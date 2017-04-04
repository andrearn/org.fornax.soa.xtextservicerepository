/*
 * generated by Xtext 2.11.0
 */
package org.xkonnex.repo.dsl.environmentdsl.ide

import com.google.inject.Guice
import org.eclipse.xtext.util.Modules2
import org.xkonnex.repo.dsl.environmentdsl.EnvironmentDslRuntimeModule
import org.xkonnex.repo.dsl.environmentdsl.EnvironmentDslStandaloneSetup

/**
 * Initialization support for running Xtext languages as language servers.
 */
class EnvironmentDslIdeSetup extends EnvironmentDslStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new EnvironmentDslRuntimeModule, new EnvironmentDslIdeModule))
	}
	
}