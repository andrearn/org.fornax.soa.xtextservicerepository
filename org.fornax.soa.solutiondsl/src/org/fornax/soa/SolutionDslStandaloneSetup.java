
package org.fornax.soa;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SolutionDslStandaloneSetup extends SolutionDslStandaloneSetupGenerated{

	public static void doSetup() {
		new SolutionDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

