
package org.fornax.soa;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SemanticsDslStandaloneSetup extends SemanticsDslStandaloneSetupGenerated{

	public static void doSetup() {
		new SemanticsDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

