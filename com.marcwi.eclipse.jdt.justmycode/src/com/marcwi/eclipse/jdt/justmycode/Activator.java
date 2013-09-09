package com.marcwi.eclipse.jdt.justmycode;

import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.jdt.debug.core.JDIDebugModel;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.marcwi.eclipse.jdt.justmycode"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	private JustMyCodeBreakpointListener breakPointListener;
	private JustMyCodeLaunchListener launchListener;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		plugin.getLog().log(new Status(Status.WARNING, PLUGIN_ID, "Started"));
		System.out.printf("Started %s\n", this);
		DebugPlugin.getDefault().getLaunchManager().addLaunchListener(launchListener = new JustMyCodeLaunchListener());
		// XXX why do I need to install it if is specified as an extension point ?
		JDIDebugModel.addJavaBreakpointListener(breakPointListener = new JustMyCodeBreakpointListener());
	}

	public void stop(BundleContext context) throws Exception {
		JDIDebugModel.removeJavaBreakpointListener(breakPointListener);
		DebugPlugin.getDefault().getLaunchManager().removeLaunchListener(launchListener);
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
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
