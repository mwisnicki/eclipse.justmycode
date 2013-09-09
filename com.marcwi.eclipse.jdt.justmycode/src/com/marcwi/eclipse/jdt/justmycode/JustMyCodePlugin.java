package com.marcwi.eclipse.jdt.justmycode;

import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.debug.core.JDIDebugModel;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class JustMyCodePlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.marcwi.eclipse.jdt.justmycode"; //$NON-NLS-1$

	// The shared instance
	private static JustMyCodePlugin plugin;

	private JustMyCodeBreakpointListener breakPointListener;
	
	/**
	 * The constructor
	 */
	public JustMyCodePlugin() {
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		Log.log(Status.WARNING, "Started");
		// XXX why do I need to install manually if it is specified as an extension point ?
		JDIDebugModel.addJavaBreakpointListener(breakPointListener = new JustMyCodeBreakpointListener());
		// TODO step filters
	}

	public void stop(BundleContext context) throws Exception {
		JDIDebugModel.removeJavaBreakpointListener(breakPointListener);
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
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
