package org.xkonnex.repo.dsl.basedsl

import java.util.ArrayList
import java.util.List
import org.xkonnex.repo.dsl.basedsl.BaseDslStandaloneSetupGenerated
import org.xkonnex.repo.dsl.basedsl.baseDsl.impl.BaseDslFactoryImpl
import org.xkonnex.repo.dsl.basedsl.validation.IPluggableValidatorProvider
import com.google.inject.Injector

/** 
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
class BaseDslStandaloneSetup extends BaseDslStandaloneSetupGenerated {
	List<String> validatorClassName = new ArrayList<String>()

	override Injector createInjectorAndDoEMFRegistration() {
		var Injector injector = super.createInjectorAndDoEMFRegistration()
		var IPluggableValidatorProvider validatorProvider = injector.getInstance(IPluggableValidatorProvider)
		validatorProvider.initFromClassNames(validatorClassName)
		return injector
	}

	def static void doSetup() {
		new BaseDslStandaloneSetup().createInjectorAndDoEMFRegistration()
	}

	def void addValidatorClassName(String validatorClassName) {
		this.validatorClassName.add(validatorClassName)
	}

	def List<String> getValidatorClassName() {
		return validatorClassName
	}
}
