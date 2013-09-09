package com.marcwi.eclipse.jdt.justmycode.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.marcwi.eclipse.jdt.justmycode.JustMyCodePlugin;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer implements PreferenceConstants {

	public void initializeDefaultPreferences() {
		IPreferenceStore store = JustMyCodePlugin.getDefault().getPreferenceStore();
		store.setDefault(P_ENABLED, false);
	}

}
