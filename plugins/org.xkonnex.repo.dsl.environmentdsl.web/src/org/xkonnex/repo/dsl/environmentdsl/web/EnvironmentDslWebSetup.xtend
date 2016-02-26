/*
 * generated by Xtext 2.9.1
 */
package org.xkonnex.repo.dsl.environmentdsl.web

import com.google.inject.Guice
import com.google.inject.Injector
import com.google.inject.Provider
import com.google.inject.util.Modules
import java.util.concurrent.ExecutorService
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.xkonnex.repo.dsl.environmentdsl.EnvironmentDslRuntimeModule
import org.xkonnex.repo.dsl.environmentdsl.EnvironmentDslStandaloneSetup

/**
 * Initialization support for running Xtext languages in web applications.
 */
@FinalFieldsConstructor
class EnvironmentDslWebSetup extends EnvironmentDslStandaloneSetup {
	
	val Provider<ExecutorService> executorServiceProvider;
	
	override Injector createInjector() {
		val runtimeModule = new EnvironmentDslRuntimeModule()
		val webModule = new EnvironmentDslWebModule(executorServiceProvider)
		return Guice.createInjector(Modules.override(runtimeModule).with(webModule))
	}
	
}
