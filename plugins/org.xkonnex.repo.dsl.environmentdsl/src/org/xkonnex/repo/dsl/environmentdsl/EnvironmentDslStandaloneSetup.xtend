package org.xkonnex.repo.dsl.environmentdsl

import java.util.ArrayList
import java.util.List
import org.xkonnex.repo.dsl.basedsl.baseDsl.impl.BaseDslFactoryImpl
import org.xkonnex.repo.dsl.basedsl.validation.IPluggableValidatorProvider
import org.xkonnex.repo.dsl.environmentdsl.EnvironmentDslStandaloneSetupGenerated
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.impl.EnvironmentDslFactoryImpl
import com.google.inject.Injector

/** 
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
class EnvironmentDslStandaloneSetup extends EnvironmentDslStandaloneSetupGenerated {
	List<String> validatorClassName = new ArrayList<String>()

	override Injector createInjectorAndDoEMFRegistration() {
		var Injector injector = super.createInjectorAndDoEMFRegistration()
		var IPluggableValidatorProvider validatorProvider = injector.getInstance(IPluggableValidatorProvider)
		validatorProvider.initFromClassNames(validatorClassName)
		return injector
	}

	def static void doSetup() {
		new EnvironmentDslStandaloneSetup().createInjectorAndDoEMFRegistration()
	}

	def void addValidatorClassName(String validatorClassName) {
		this.validatorClassName.add(validatorClassName)
	}

	def List<String> getValidatorClassName() {
		return validatorClassName
	}
}
