/*
 * generated by Xtext 2.11.0
 */
package org.xkonnex.repo.dsl.basedsl.web

import com.google.inject.Guice
import com.google.inject.Injector
import org.eclipse.xtext.util.Modules2
import org.xkonnex.repo.dsl.basedsl.BaseDslRuntimeModule
import org.xkonnex.repo.dsl.basedsl.BaseDslStandaloneSetup
import org.xkonnex.repo.dsl.basedsl.ide.BaseDslIdeModule

/**
 * Initialization support for running Xtext languages in web applications.
 */
class BaseDslWebSetup extends BaseDslStandaloneSetup {
	
	override Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new BaseDslRuntimeModule, new BaseDslIdeModule, new BaseDslWebModule))
	}
	
}
