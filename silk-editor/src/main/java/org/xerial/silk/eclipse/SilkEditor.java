package org.xerial.silk.eclipse;

import org.eclipse.ui.editors.text.TextEditor;

public class SilkEditor extends TextEditor {

	private ColorManager colorManager;

	public SilkEditor() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new XMLConfiguration(colorManager));
		setDocumentProvider(new XMLDocumentProvider());
	}
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

}
