package org.fornax.soa.scoping;

import org.fornax.soa.environmentDsl.Environment;

public interface IEnvironmentPerspectiveSelector {
	
	public Environment getSelectedEnvironment ();
	
	public void selectEnvironment (Environment selectedEnvironment);

}
