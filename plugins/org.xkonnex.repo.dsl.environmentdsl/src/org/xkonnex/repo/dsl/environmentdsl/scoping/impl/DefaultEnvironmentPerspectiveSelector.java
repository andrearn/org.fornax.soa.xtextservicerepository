package org.xkonnex.repo.dsl.environmentdsl.scoping.impl;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment;
import org.xkonnex.repo.dsl.environmentdsl.scoping.IEnvironmentPerspectiveSelector;

public class DefaultEnvironmentPerspectiveSelector implements
		IEnvironmentPerspectiveSelector {
	
	private Environment selectedEnvironment;

	public Environment getSelectedEnvironment () {
		return selectedEnvironment;
	}

	public void selectEnvironment (Environment selectedEnvironment) {
		this.selectedEnvironment = selectedEnvironment;
	}

}
