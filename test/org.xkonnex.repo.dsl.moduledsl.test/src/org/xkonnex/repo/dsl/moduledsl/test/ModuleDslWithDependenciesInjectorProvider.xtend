package org.xkonnex.repo.dsl.moduledsl.test

import org.xkonnex.repo.dsl.basedsl.BaseDslStandaloneSetup
import org.xkonnex.repo.dsl.environmentdsl.EnvironmentDslStandaloneSetup
import org.xkonnex.repo.dsl.moduledsl.ModuleDslInjectorProvider
import org.xkonnex.repo.dsl.profiledsl.ProfileDslStandaloneSetup
import org.xkonnex.repo.dsl.servicedsl.ServiceDslStandaloneSetup
import org.xkonnex.repo.dsl.businessdsl.BusinessDslStandaloneSetup
import org.xkonnex.repo.dsl.semanticsdsl.SemanticsDslStandaloneSetup

class ModuleDslWithDependenciesInjectorProvider extends ModuleDslInjectorProvider {
	
	override protected internalCreateInjector() {
		BaseDslStandaloneSetup.doSetup
		EnvironmentDslStandaloneSetup.doSetup
		ProfileDslStandaloneSetup.doSetup
		BusinessDslStandaloneSetup.doSetup
		SemanticsDslStandaloneSetup.doSetup
		ServiceDslStandaloneSetup.doSetup
		super.internalCreateInjector()
	}
	
}