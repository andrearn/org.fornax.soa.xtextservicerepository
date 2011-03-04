
package org.fornax.soa;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SLADslStandaloneSetup extends SLADslStandaloneSetupGenerated{

	public static void doSetup() {
		new SLADslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

