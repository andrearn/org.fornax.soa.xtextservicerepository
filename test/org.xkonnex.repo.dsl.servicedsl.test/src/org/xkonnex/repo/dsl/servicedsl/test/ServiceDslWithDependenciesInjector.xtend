package org.xkonnex.repo.dsl.servicedsl.test

import org.xkonnex.repo.dsl.basedsl.BaseDslStandaloneSetup
import org.xkonnex.repo.dsl.environmentdsl.EnvironmentDslStandaloneSetup
import org.xkonnex.repo.dsl.profiledsl.ProfileDslStandaloneSetup
import org.xkonnex.repo.dsl.servicedsl.tests.ServiceDslInjectorProvider

class ServiceDslWithDependenciesInjector extends ServiceDslInjectorProvider {

	override internalCreateInjector() {
		BaseDslStandaloneSetup.doSetup
		EnvironmentDslStandaloneSetup.doSetup
		ProfileDslStandaloneSetup.doSetup
		ServiceDslTestSetup.doSetup
		return super.internalCreateInjector
	}

}