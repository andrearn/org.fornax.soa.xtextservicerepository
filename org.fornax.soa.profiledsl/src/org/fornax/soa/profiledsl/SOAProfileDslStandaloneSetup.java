
package org.fornax.soa.profiledsl;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SOAProfileDslStandaloneSetup extends SOAProfileDslStandaloneSetupGenerated{

	public static void doSetup() {
		new SOAProfileDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

