
package org.xkonnex.repo.dsl.basedsl;

import java.util.ArrayList;
import java.util.List;

import org.xkonnex.repo.dsl.basedsl.SOABaseDslStandaloneSetupGenerated;
import org.xkonnex.repo.dsl.basedsl.validation.IPluggableValidatorProvider;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SOABaseDslStandaloneSetup extends SOABaseDslStandaloneSetupGenerated{

	private List<String> validatorClassName=new ArrayList<String>();

	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		Injector injector = super.createInjectorAndDoEMFRegistration();
		IPluggableValidatorProvider validatorProvider = injector.getInstance(IPluggableValidatorProvider.class);
		validatorProvider.initFromClassNames (validatorClassName);
		return injector;
	}

	public static void doSetup() {
		new SOABaseDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	public void addValidatorClassName(String validatorClassName) {
		this.validatorClassName.add (validatorClassName);
	}
	
	public List<String> getValidatorClassName() {
		return validatorClassName;
	}

}

