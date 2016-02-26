package org.xkonnex.repo.dsl.profiledsl

import java.util.ArrayList
import java.util.List
import org.xkonnex.repo.dsl.basedsl.baseDsl.impl.BaseDslFactoryImpl
import org.xkonnex.repo.dsl.basedsl.validation.IPluggableValidatorProvider
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.impl.EnvironmentDslFactoryImpl
import org.xkonnex.repo.dsl.profiledsl.ProfileDslStandaloneSetupGenerated
import org.xkonnex.repo.dsl.profiledsl.profileDsl.impl.ProfileDslPackageImpl
import com.google.inject.Injector

/** 
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
class ProfileDslStandaloneSetup extends ProfileDslStandaloneSetupGenerated {
	List<String> validatorClassName = new ArrayList<String>()

	override Injector createInjectorAndDoEMFRegistration() {
		var Injector injector = super.createInjectorAndDoEMFRegistration()
		var IPluggableValidatorProvider validatorProvider = injector.getInstance(IPluggableValidatorProvider)
		validatorProvider.initFromClassNames(validatorClassName)
		return injector
	}

	def static void doSetup() {
		BaseDslFactoryImpl.init()
		EnvironmentDslFactoryImpl.init()
		new ProfileDslStandaloneSetup().createInjectorAndDoEMFRegistration()
	}

	def void addValidatorClassName(String validatorClassName) {
		this.validatorClassName.add(validatorClassName)
	}

	def List<String> getValidatorClassName() {
		return validatorClassName
	}
}
