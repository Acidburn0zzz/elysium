package org.elysium.ui.refactoring;

import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.NullChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.DeleteRefactoring;
import org.eclipse.ltk.core.refactoring.participants.MoveArguments;
import org.eclipse.ltk.core.refactoring.participants.RefactoringArguments;
import org.eclipse.ltk.core.refactoring.participants.RenameArguments;
import org.eclipse.ltk.core.refactoring.resource.MoveResourceChange;
import org.eclipse.ltk.core.refactoring.resource.RenameResourceChange;
import org.eclipse.ltk.internal.core.refactoring.resource.DeleteResourcesProcessor;
import org.elysium.LilyPondConstants;
import org.elysium.ui.Activator;
import org.elysium.ui.refactoring.LilyPondRefactoringDelegate.Operation;

import com.google.common.io.Files;

class LilyPondRefactoring {

	LilyPondRefactoringInjects support;

	private Map<URI, IFile> platformURItoFileOfRefactorTargets=new HashMap<URI, IFile>();
	private Map<IResource, RefactoringArguments> argumentsMap=new HashMap<IResource, RefactoringArguments>();
	private List<IContainer> refactoredContainers=new ArrayList<IContainer>();
	private final Operation operation;
	private List<IFile> compiledFilesRefactorTargets=new ArrayList<IFile>();

	public LilyPondRefactoring(Operation operation, LilyPondRefactoringInjects support) {
		this.operation=operation;
		this.support=support;
	}

	public void addFileToRefactor(IFile file, RefactoringArguments arguments){
		if(support.isSource(file)){
			checkArgumentType(arguments);
			URI uri=URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			platformURItoFileOfRefactorTargets.put(uri, file);
			argumentsMap.put(file, arguments);
		}else if(support.isCompiled(file)){
			compiledFilesRefactorTargets.add(file);
		}
	}

	private void checkArgumentType(RefactoringArguments arguments){
		if(arguments!=null){
			switch (operation) {
			case rename:
				if(!(arguments instanceof RenameArguments)){
					throw new IllegalArgumentException("no rename arguments given: "+arguments);
				}
				break;
			case move: 
				if(!(arguments instanceof MoveArguments)){
					throw new IllegalArgumentException("no move arguments given: "+arguments);
				}
				break;
			default:
				break;
			}
		}
	}

	public void addContainerToRefactor(IContainer container, RefactoringArguments arguments){
		checkArgumentType(arguments);
		try {
			refactoredContainers.add(container);
			argumentsMap.put(container, arguments);
			container.accept(new IResourceVisitor() {
				@Override
				public boolean visit(IResource resource) throws CoreException {
					if (resource instanceof IFile) {
						IFile iFile = (IFile)resource;
						addFileToRefactor(iFile, null);
					}
					return true;
				}
			});
		} catch (CoreException e) {
			Activator.logError("error while preparing DeleteFolderParticipant", e);
		}
	}

	public Operation getOperation() {
		return operation;
	}

	public Set<URI> getRefactoredFiles(){
		return platformURItoFileOfRefactorTargets.keySet();
	}

	public List<IPath> getFilePaths(Set<URI> uris){
		List<IPath> result=new ArrayList<IPath>();
		for (URI uri : uris) {
			IFile file = platformURItoFileOfRefactorTargets.get(uri);
			if(file!=null){
				result.add(file.getFullPath());
			}else{
				throw new IllegalStateException(uri + "was not part of the refactoring!");
			}
		}
		return result;
	}

	public Change apply(IProgressMonitor monitor) throws CoreException{
		CompositeChange result = new CompositeChange(operation.toString()+ " compiled Files");
		for (IFile file : platformURItoFileOfRefactorTargets.values()) {
			if(!monitor.isCanceled()){
				apply(file, result);
			}
		}
		if(result.getChildren().length==0){
			return null;
		}else{
			return result; 
		}
	}

	private void apply(IFile source, CompositeChange containerChange) throws CoreException{
		RefactoringArguments arguments = argumentsMap.get(source);
		if(arguments!=null){
			List<IFile> compiledFiles = getCompiled(source);
			for (IFile compiled : compiledFiles) {
				Change change = getCompiledChange(compiled, arguments);
				if(change!=null){
					containerChange.add(change);
				}
			}
		}
	}

	private Change getCompiledChange(IFile compiled, RefactoringArguments arguments) throws OperationCanceledException, CoreException{
		switch (operation) {
		case rename:
			String newName=Files.getNameWithoutExtension(((RenameArguments)arguments).getNewName())+"."+compiled.getFileExtension();
			return compiledChangeWithClosingScoreView(compiled,new RenameResourceChange(compiled.getFullPath(), newName));
		case move:
			return compiledChangeWithClosingScoreView(compiled, new MoveResourceChange(compiled, (IContainer)((MoveArguments)arguments).getDestination()));
		default:
			break;
		}
		return null;
	}

	private Change compiledChangeWithClosingScoreView(final IFile compiled, Change compileChange){
		if(compiled.getFileExtension().equals(LilyPondConstants.SCORE_EXTENSION)){
			CompositeChange change=new CompositeChange(compiled.getProjectRelativePath().toString());
			Change closeView=new NullChange("close score view (if open)"){
				@Override
				@SuppressWarnings("restriction")
				public Change perform(IProgressMonitor pm) throws CoreException {
					if(compiled.getFileExtension().equals(LilyPondConstants.SCORE_EXTENSION)){
						new DeleteRefactoring(new DeleteResourcesProcessor(new IResource[]{compiled}, true)).checkAllConditions(pm);
					}
					return super.perform(pm);
				}
			};
			change.add(closeView);
			change.add(compileChange);
			return change;
		}else{
			return compileChange;
		}
	}

	private List<IFile> getCompiled(IFile source) throws CoreException{
		List<IFile> result=new ArrayList<IFile>();
		IResource[] siblings = source.getParent().members();
		for (IResource sibling : siblings) {
			if(sibling instanceof IFile){
				IFile siblingFile=(IFile)sibling;
				if(!compiledFilesRefactorTargets.contains(siblingFile) && support.isCompiled(siblingFile)){
					boolean siblingCompiledFromSource=source.getFullPath().removeFileExtension().equals(siblingFile.getFullPath().removeFileExtension());
					if(siblingCompiledFromSource){
						result.add((IFile) sibling);
					}
				}
			}
		}
		return result;
	}

	private List<String> getChangedSearchFolders() {
		List<String> result=new ArrayList<String>();
		if(!refactoredContainers.isEmpty()){
			List<String> containerURIS=new ArrayList<String>();
			for (IContainer container : refactoredContainers) {
				containerURIS.add(container.getLocationURI().toString());
			}
			for (String searchPath : support.getSearchPaths()) {
				String searchPathUri = new File(searchPath).toURI().toString();
				for (String containerURI : containerURIS) {
					if(searchPathUri.startsWith(containerURI)){
						result.add(searchPath);
					}
				}
			}
		}
		return result;
	}

	public void addSearchPathAffectedIssues(RefactoringStatus status) {
		if(support.warnSearchPathAffected()){
			for (String searchFolder : getChangedSearchFolders()) {
				status.addWarning(MessageFormat.format("search path {0} is affected by the refactoring!", searchFolder));
			}
		}
	}

	public LilyPondRefactoredImportUriCalculator getNewImportUriCalculator(URI sourceUri, URI resolvedUriToRefactor) {
		IFile source=asFile(sourceUri);
		IFile refactorTarget = platformURItoFileOfRefactorTargets.get(resolvedUriToRefactor);
		if(refactorTarget==null){
			return new LilyPondRefactoredImportUriCalculator(source, getDestination(source));
		}else{
			return new LilyPondRefactoredImportUriCalculator(source, getDestination(source), refactorTarget, getDestination(refactorTarget));
		}
	}

	public IFile asFile(URI platformUri){
		IFile file=platformURItoFileOfRefactorTargets.get(platformUri);
		if(file!=null){
			return file;
		}else{
			return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformUri.toPlatformString(true)));
		}
	}

	private IFile getDestination(IFile original){
		if(original==null){
			return null;
		}
		RefactoringArguments argument = argumentsMap.get(original);
		if(argument!=null){
			switch (operation) {
			case rename:return original.getParent().getFile(new Path(((RenameArguments)argument).getNewName()));
			case move: return ((IContainer)((MoveArguments)argument).getDestination()).getFile(new Path(original.getName()));
			default:
				throw new IllegalStateException("should not be called for operation "+operation);
			}
		}else{
			IContainer parent=original.getParent();
			do{
				if(refactoredContainers.contains(parent)){
					IPath relativePath = original.getFullPath().makeRelativeTo(parent.getFullPath());
					IContainer destinationRoot = getDestination((IContainer)parent);
					IFile result=destinationRoot.getFile(relativePath);
					return result;
				}
				parent=parent.getParent();
			}while(parent!=null);
		}
		return original;
	}

	private IContainer getDestination(IContainer container){
		RefactoringArguments argument = argumentsMap.get(container);
		switch (operation) {
		case rename: {
			String newName= ((RenameArguments)argument).getNewName();
			IContainer parent = container.getParent();
			if(parent.getType()==IResource.ROOT){
				return ((IWorkspaceRoot)parent).getProject(newName);
			}else{
				return parent.getFolder(new Path(newName));
			}
		}
		case move: return ((IContainer)((MoveArguments)argument).getDestination()).getFolder(new Path(container.getName()));
		default:
			throw new IllegalStateException("should not be called for operation "+operation);
		}
	}
}