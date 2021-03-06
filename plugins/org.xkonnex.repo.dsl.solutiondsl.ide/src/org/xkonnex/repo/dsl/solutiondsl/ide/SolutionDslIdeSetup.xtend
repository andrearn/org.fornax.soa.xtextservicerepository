/*
 * generated by Xtext 2.11.0
 */
package org.xkonnex.repo.dsl.solutiondsl.ide

import com.google.inject.Guice
import org.eclipse.xtext.util.Modules2
import org.xkonnex.repo.dsl.solutiondsl.SolutionDslRuntimeModule
import org.xkonnex.repo.dsl.solutiondsl.SolutionDslStandaloneSetup

/**
 * Initialization support for running Xtext languages as language servers.
 */
class SolutionDslIdeSetup extends SolutionDslStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new SolutionDslRuntimeModule, new SolutionDslIdeModule))
	}
	
}
