package org.elysium.ui;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IURIEditorInput;
import org.eclipse.xtext.ui.editor.XtextEditor;

import com.google.common.collect.ObjectArrays;

public class LilyPondXtextEditor extends XtextEditor{

	@Override
	protected String[] collectContextMenuPreferencePages() {
		return getPreferencePages(super.collectContextMenuPreferencePages());
	}

	@Override
	protected String[] collectRulerMenuPreferencePages() {
		return getPreferencePages(super.collectRulerMenuPreferencePages());
	}

	@Override
	protected String[] collectOverviewRulerMenuPreferencePages() {
		return getPreferencePages(super.collectOverviewRulerMenuPreferencePages());
	}

	private String[] getPreferencePages(String[] superPages){
		String prefix="org.elysium.ui.preferencePages.";
		String[] xturtlePages = new String[] {
				prefix + "LilyPond",
				prefix + "Compiler",
				prefix + "SyntaxUpdater",
				prefix + "Validation",
				prefix + "Editor",
				prefix + "NewProjectWizard",
				prefix + "SyntaxColoring",
				prefix + "Templates",
				"org.elysium.LilyPond.refactoring"
				};
		return ObjectArrays.concat(superPages, xturtlePages, String.class);
	}

	@Override
	public String getTitleToolTip() {
		String tooltip=super.getTitleToolTip();
		IResource resource = getResource();
		if(resource != null) {
			return tooltip+ "\n"+ resource.getRawLocation().toString();
		} else {
			try {
				IURIEditorInput input = ((IURIEditorInput) getEditorInput());
				return input.getName()+"\n"+URI.createURI(input.getURI().toString()).toFileString().replace('\\', '/');
			} catch (Exception e) {
				//ignore
			}
		}
		return tooltip;
	}

}