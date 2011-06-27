
package org.fornax.soa.moduledsl;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ModuleDslStandaloneSetup extends ModuleDslStandaloneSetupGenerated{

	public static void doSetup() {
		new ModuleDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

