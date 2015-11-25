package org.xkonnex.repo.dsl.profiledsl.test

import org.xkonnex.repo.dsl.profiledsl.ProfileDslInjectorProvider
import org.xkonnex.repo.dsl.basedsl.BaseDslStandaloneSetup
import org.xkonnex.repo.dsl.environmentdsl.EnvironmentDslStandaloneSetup
import org.xkonnex.repo.dsl.basedsl.baseDsl.BaseDslPackage

class ProfileDslWithDependenciesInjectorProvider extends ProfileDslInjectorProvider {
	
	override protected internalCreateInjector() {
		BaseDslStandaloneSetup.doSetup
		EnvironmentDslStandaloneSetup.doSetup
		BaseDslPackage.eINSTANCE.name
		super.internalCreateInjector()
	}
	
}