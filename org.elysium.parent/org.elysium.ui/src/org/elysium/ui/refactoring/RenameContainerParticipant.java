package org.elysium.ui.refactoring;

import javax.inject.Inject;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.elysium.ui.refactoring.LilyPondRefactoringDelegate.Operation;

public class RenameContainerParticipant extends RenameParticipant {

	@Inject
	LilyPondRefactoringInjects injects;
	LilyPondRefactoringDelegate delegate;

	private IContainer container;

	@Override
	protected boolean initialize(Object element) {
		container = (IContainer)element;
		return true;
	}

	@Override
	public String getName() {
		return LilyPondRefactoringDelegate.NAME;
	}

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor pm, CheckConditionsContext context) throws OperationCanceledException {
		delegate=LilyPondRefactoringDelegate.get(Operation.rename, context, injects);
		delegate.addContainerToRefactor(container, getArguments());
		return new RefactoringStatus();
	}

	@Override
	public Change createPreChange(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {
		return delegate.adaptIncludes(pm);
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		return delegate.apply(pm);
	}
}
