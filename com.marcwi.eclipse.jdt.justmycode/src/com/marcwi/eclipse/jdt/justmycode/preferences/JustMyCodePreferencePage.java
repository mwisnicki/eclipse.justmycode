package com.marcwi.eclipse.jdt.justmycode.preferences;

import org.eclipse.jface.preference.*;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbench;
import com.marcwi.eclipse.jdt.justmycode.JustMyCodePlugin;

public class JustMyCodePreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage,
		PreferenceConstants {

	public JustMyCodePreferencePage() {
		super(GRID);
		setPreferenceStore(JustMyCodePlugin.getDefault().getPreferenceStore());
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common GUI blocks needed to manipulate various
	 * types of preferences. Each field editor knows how to save and restore itself.
	 */
	public void createFieldEditors() {
		addField(new BooleanFieldEditor(P_ENABLED, "&Enabled", getFieldEditorParent()));
	}

	public void init(IWorkbench workbench) {
	}

}