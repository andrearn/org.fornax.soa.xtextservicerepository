
package org.fornax.soa;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class EnvironmentDslStandaloneSetup extends EnvironmentDslStandaloneSetupGenerated{

	public static void doSetup() {
		new EnvironmentDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

