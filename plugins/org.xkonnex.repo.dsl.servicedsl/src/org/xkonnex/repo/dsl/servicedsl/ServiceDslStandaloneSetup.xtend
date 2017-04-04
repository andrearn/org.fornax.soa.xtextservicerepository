package org.xkonnex.repo.dsl.servicedsl

import com.google.inject.Injector
import java.util.ArrayList
import java.util.List
import org.xkonnex.repo.dsl.basedsl.validation.IPluggableValidatorProvider

/** 
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
class ServiceDslStandaloneSetup extends ServiceDslStandaloneSetupGenerated {
	List<String> validatorClassName = new ArrayList<String>()

	override Injector createInjectorAndDoEMFRegistration() {
		var Injector injector = super.createInjectorAndDoEMFRegistration()
		var IPluggableValidatorProvider validatorProvider = injector.getInstance(IPluggableValidatorProvider)
		validatorProvider.initFromClassNames(validatorClassName)
		return injector
	}

	def static void doSetup() {
		new ServiceDslStandaloneSetup().createInjectorAndDoEMFRegistration()
	}

	def void addValidatorClassName(String validatorClassName) {
		this.validatorClassName.add(validatorClassName)
	}

	def List<String> getValidatorClassName() {
		return validatorClassName
	}
}
