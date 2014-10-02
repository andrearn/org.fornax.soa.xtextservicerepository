
package org.xkonnex.repo.dsl.moduledsl;

import java.util.ArrayList;
import java.util.List;

import org.xkonnex.repo.dsl.basedsl.validation.IPluggableValidatorProvider;
import org.xkonnex.repo.dsl.moduledsl.ModuleDslStandaloneSetupGenerated;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ModuleDslStandaloneSetup extends ModuleDslStandaloneSetupGenerated{

	private List<String> validatorClassName=new ArrayList<String>();

	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		Injector injector = super.createInjectorAndDoEMFRegistration();
		IPluggableValidatorProvider validatorProvider = injector.getInstance(IPluggableValidatorProvider.class);
		validatorProvider.initFromClassNames (validatorClassName);
		return injector;
	}

	public static void doSetup() {
		new ModuleDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	public void addValidatorClassName(String validatorClassName) {
		this.validatorClassName.add (validatorClassName);
	}
	
	public List<String> getValidatorClassName() {
		return validatorClassName;
	}

}

