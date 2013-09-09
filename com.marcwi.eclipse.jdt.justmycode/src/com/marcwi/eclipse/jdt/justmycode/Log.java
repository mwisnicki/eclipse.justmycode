package com.marcwi.eclipse.jdt.justmycode;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Status;

class Log {
	private static final ILog log = Activator.getDefault().getLog();

	public static void log(int severity, String format, Object... args) {
		log.log(new Status(severity, Activator.PLUGIN_ID, String.format(format, args)));
	}
	
	public static void log(int severity, Throwable exception, String format, Object... args) {
		log.log(new Status(severity, Activator.PLUGIN_ID, String.format(format, args), exception));
	}
}
