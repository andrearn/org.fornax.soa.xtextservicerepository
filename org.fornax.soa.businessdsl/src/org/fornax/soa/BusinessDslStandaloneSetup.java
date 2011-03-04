
package org.fornax.soa;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class BusinessDslStandaloneSetup extends BusinessDslStandaloneSetupGenerated{

	public static void doSetup() {
		new BusinessDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

