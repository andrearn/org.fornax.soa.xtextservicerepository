package org.xkonnex.repo.dsl.bindingdsl.test

import org.xkonnex.repo.dsl.basedsl.BaseDslStandaloneSetup
import org.xkonnex.repo.dsl.bindingdsl.BindingDslRuntimeModule
import org.xkonnex.repo.dsl.bindingdsl.tests.BindingDslInjectorProvider
import org.xkonnex.repo.dsl.businessdsl.BusinessDslStandaloneSetup
import org.xkonnex.repo.dsl.environmentdsl.EnvironmentDslStandaloneSetup
import org.xkonnex.repo.dsl.moduledsl.ModuleDslStandaloneSetup
import org.xkonnex.repo.dsl.profiledsl.ProfileDslStandaloneSetup
import org.xkonnex.repo.dsl.semanticsdsl.SemanticsDslStandaloneSetup
import org.xkonnex.repo.dsl.servicedsl.ServiceDslStandaloneSetup

class BindingDslWithDependenciesInjectorProvider extends BindingDslInjectorProvider {
	
	override protected internalCreateInjector() {
		var injector = super.internalCreateInjector()
		BaseDslStandaloneSetup.doSetup
		EnvironmentDslStandaloneSetup.doSetup
		ProfileDslStandaloneSetup.doSetup
		BusinessDslStandaloneSetup.doSetup
		SemanticsDslStandaloneSetup.doSetup
		ServiceDslStandaloneSetup.doSetup
		ModuleDslStandaloneSetup.doSetup
		return injector
	}
	
	override protected BindingDslRuntimeModule createRuntimeModule() {
		// make it work also with Maven/Tycho and OSGI
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=493672
		return new BindingDslRuntimeModule() {
			override ClassLoader bindClassLoaderToInstance() {
				return typeof(BindingDslWithDependenciesInjectorProvider)
						.getClassLoader();
			}
		};
	}
	
}