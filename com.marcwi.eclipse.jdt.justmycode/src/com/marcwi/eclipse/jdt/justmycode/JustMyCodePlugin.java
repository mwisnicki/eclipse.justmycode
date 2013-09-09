package com.marcwi.eclipse.jdt.justmycode;

import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.debug.core.JDIDebugModel;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.marcwi.eclipse.jdt.justmycode.preferences.PreferenceConstants;

/**
 * The activator class controls the plug-in life cycle
 */
public class JustMyCodePlugin extends AbstractUIPlugin implements PreferenceConstants, IPropertyChangeListener {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.marcwi.eclipse.jdt.justmycode"; //$NON-NLS-1$

	// The shared instance
	private static JustMyCodePlugin plugin;

	private final JustMyCodeBreakpointListener breakpointListener = new JustMyCodeBreakpointListener();

	/**
	 * The constructor
	 */
	public JustMyCodePlugin() {
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		getPreferenceStore().addPropertyChangeListener(this);
		Log.log(Status.WARNING, "Started");
		updateBreakpointListener();
	}

	public void stop(BundleContext context) throws Exception {
		JDIDebugModel.removeJavaBreakpointListener(breakpointListener);
		getPreferenceStore().removePropertyChangeListener(this);
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static JustMyCodePlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in relative path
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (event.getProperty().equals(P_ENABLED))
			updateBreakpointListener();
	}

	public boolean isEnabledPref() {
		return getPreferenceStore().getBoolean(P_ENABLED);
	}

	private void updateBreakpointListener() {
		if (isEnabledPref()) {
			// XXX why do I need to install manually if it is specified as an extension point ?
			JDIDebugModel.addJavaBreakpointListener(breakpointListener);
			// TODO step filters
		} else {
			JDIDebugModel.removeJavaBreakpointListener(breakpointListener);
		}
	}
}
