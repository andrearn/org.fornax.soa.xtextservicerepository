package org.xkonnex.repo.dsl.environmentdsl.scoping;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment;

public interface IEnvironmentPerspectiveSelector {
	
	public Environment getSelectedEnvironment ();
	
	public void selectEnvironment (Environment selectedEnvironment);

}
