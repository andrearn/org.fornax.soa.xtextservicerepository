
package org.fornax.soa.base;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SOABaseDslStandaloneSetup extends SOABaseDslStandaloneSetupGenerated{

	public static void doSetup() {
		new SOABaseDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

