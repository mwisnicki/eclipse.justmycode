package com.marcwi.eclipse.jdt.justmycode;

import org.eclipse.debug.core.model.Breakpoint;

public class Breakpoint1 extends Breakpoint {

	public Breakpoint1() {
	}

	@Override
	public String getModelIdentifier() {
		return Activator.PLUGIN_ID;
	}

}
