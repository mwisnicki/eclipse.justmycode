package com.marcwi.eclipse.jdt.justmycode;

import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchListener;

public class JustMyCodeLaunchListener implements ILaunchListener {

	@Override
	public void launchAdded(ILaunch launch) {
		Log.log(Status.INFO, "launchAdded %s", launch);
	}

	@Override
	public void launchChanged(ILaunch launch) {
		Log.log(Status.INFO, "launchChanged %s", launch);
	}

	@Override
	public void launchRemoved(ILaunch launch) {
		Log.log(Status.INFO, "launchRemoved %s", launch);
	}

}
