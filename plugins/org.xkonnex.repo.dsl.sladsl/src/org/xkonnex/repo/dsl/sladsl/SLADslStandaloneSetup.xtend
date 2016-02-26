package org.xkonnex.repo.dsl.sladsl

import java.util.ArrayList
import java.util.List
import org.xkonnex.repo.dsl.basedsl.validation.IPluggableValidatorProvider
import org.xkonnex.repo.dsl.sladsl.SLADslStandaloneSetup
import org.xkonnex.repo.dsl.sladsl.SLADslStandaloneSetupGenerated
import com.google.inject.Injector

/** 
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
class SLADslStandaloneSetup extends SLADslStandaloneSetupGenerated {
	List<String> validatorClassName = new ArrayList<String>()

	override Injector createInjectorAndDoEMFRegistration() {
		var Injector injector = super.createInjectorAndDoEMFRegistration()
		var IPluggableValidatorProvider validatorProvider = injector.getInstance(IPluggableValidatorProvider)
		validatorProvider.initFromClassNames(validatorClassName)
		return injector
	}

	def static void doSetup() {
		new SLADslStandaloneSetup().createInjectorAndDoEMFRegistration()
	}

	def void addValidatorClassName(String validatorClassName) {
		this.validatorClassName.add(validatorClassName)
	}

	def List<String> getValidatorClassName() {
		return validatorClassName
	}
}
