/*
 * generated by Xtext 2.11.0
 */
package org.xkonnex.repo.dsl.bindingdsl.web

import com.google.inject.Guice
import com.google.inject.Injector
import org.eclipse.xtext.util.Modules2
import org.xkonnex.repo.dsl.bindingdsl.BindingDslRuntimeModule
import org.xkonnex.repo.dsl.bindingdsl.BindingDslStandaloneSetup
import org.xkonnex.repo.dsl.bindingdsl.ide.BindingDslIdeModule

/**
 * Initialization support for running Xtext languages in web applications.
 */
class BindingDslWebSetup extends BindingDslStandaloneSetup {
	
	override Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new BindingDslRuntimeModule, new BindingDslIdeModule, new BindingDslWebModule))
	}
	
}
