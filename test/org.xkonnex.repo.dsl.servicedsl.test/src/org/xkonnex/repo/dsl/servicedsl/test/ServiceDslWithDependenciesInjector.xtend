package org.xkonnex.repo.dsl.servicedsl.test

import org.xkonnex.repo.dsl.servicedsl.ServiceDslInjectorProvider
import org.xkonnex.repo.dsl.basedsl.BaseDslStandaloneSetup
import org.xkonnex.repo.dsl.environmentdsl.EnvironmentDslStandaloneSetup
import org.xkonnex.repo.dsl.profiledsl.ProfileDslStandaloneSetup
import org.xkonnex.repo.dsl.basedsl.baseDsl.BaseDslFactory
import org.xkonnex.repo.dsl.basedsl.baseDsl.BaseDslPackage

class ServiceDslWithDependenciesInjector extends ServiceDslInjectorProvider {

	override internalCreateInjector() {
		BaseDslStandaloneSetup.doSetup
		EnvironmentDslStandaloneSetup.doSetup
		ProfileDslStandaloneSetup.doSetup
		return super.internalCreateInjector
	}

}