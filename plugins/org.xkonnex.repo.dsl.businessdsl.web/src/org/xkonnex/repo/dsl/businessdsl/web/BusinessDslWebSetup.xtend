/*
 * generated by Xtext 2.11.0
 */
package org.xkonnex.repo.dsl.businessdsl.web

import com.google.inject.Guice
import com.google.inject.Injector
import org.eclipse.xtext.util.Modules2
import org.xkonnex.repo.dsl.businessdsl.BusinessDslRuntimeModule
import org.xkonnex.repo.dsl.businessdsl.BusinessDslStandaloneSetup
import org.xkonnex.repo.dsl.businessdsl.ide.BusinessDslIdeModule

/**
 * Initialization support for running Xtext languages in web applications.
 */
class BusinessDslWebSetup extends BusinessDslStandaloneSetup {
	
	override Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new BusinessDslRuntimeModule, new BusinessDslIdeModule, new BusinessDslWebModule))
	}
	
}
