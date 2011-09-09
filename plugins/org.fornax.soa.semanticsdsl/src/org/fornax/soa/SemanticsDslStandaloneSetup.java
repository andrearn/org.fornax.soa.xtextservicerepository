
package org.fornax.soa;

import java.util.ArrayList;
import java.util.List;

import org.fornax.soa.basedsl.validation.IPluggableValidatorProvider;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SemanticsDslStandaloneSetup extends SemanticsDslStandaloneSetupGenerated{

	private List<String> validatorClassName=new ArrayList<String>();

	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		Injector injector = super.createInjectorAndDoEMFRegistration();
		IPluggableValidatorProvider validatorProvider = injector.getInstance(IPluggableValidatorProvider.class);
		validatorProvider.initFromClassNames (validatorClassName);
		return injector;
	}

	public static void doSetup() {
		new SemanticsDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	public void addValidatorClassName(String validatorClassName) {
		this.validatorClassName.add (validatorClassName);
	}
	
	public List<String> getValidatorClassName() {
		return validatorClassName;
	}

}

