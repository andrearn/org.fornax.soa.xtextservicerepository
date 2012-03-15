package org.fornax.soa.scoping.impl;

import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.scoping.IEnvironmentPerspectiveSelector;

public class DefaultEnvironmentPerspectiveSelector implements
		IEnvironmentPerspectiveSelector {
	
	private Environment selectedEnvironment;

	@Override
	public Environment getSelectedEnvironment () {
		return selectedEnvironment;
	}

	@Override
	public void selectEnvironment (Environment selectedEnvironment) {
		this.selectedEnvironment = selectedEnvironment;
	}

}
