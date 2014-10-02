
package org.xkonnex.repo.dsl.bindingdsl;

import java.util.ArrayList;
import java.util.List;

import org.xkonnex.repo.dsl.basedsl.validation.IPluggableValidatorProvider;
import org.xkonnex.repo.dsl.bindingdsl.BindingDslStandaloneSetupGenerated;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class BindingDslStandaloneSetup extends BindingDslStandaloneSetupGenerated{

	private List<String> validatorClassName=new ArrayList<String>();

	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		Injector injector = super.createInjectorAndDoEMFRegistration();
		IPluggableValidatorProvider validatorProvider = injector.getInstance(IPluggableValidatorProvider.class);
		validatorProvider.initFromClassNames (validatorClassName);
		return injector;
	}

	public static void doSetup() {
		new BindingDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	public void addValidatorClassName(String validatorClassName) {
		this.validatorClassName.add (validatorClassName);
	}
	
	public List<String> getValidatorClassName() {
		return validatorClassName;
	}

}

