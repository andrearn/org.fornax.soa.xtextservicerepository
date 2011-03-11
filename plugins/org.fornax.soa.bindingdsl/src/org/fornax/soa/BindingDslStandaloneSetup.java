
package org.fornax.soa;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class BindingDslStandaloneSetup extends BindingDslStandaloneSetupGenerated{

	public static void doSetup() {
		new BindingDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

