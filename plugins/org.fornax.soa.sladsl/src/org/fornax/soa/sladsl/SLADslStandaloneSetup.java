
package org.fornax.soa.sladsl;

import java.util.ArrayList;
import java.util.List;

import org.fornax.soa.sladsl.SLADslStandaloneSetup;
import org.fornax.soa.sladsl.SLADslStandaloneSetupGenerated;
import org.fornax.soa.basedsl.validation.IPluggableValidatorProvider;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SLADslStandaloneSetup extends SLADslStandaloneSetupGenerated{

	private List<String> validatorClassName=new ArrayList<String>();

	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		Injector injector = super.createInjectorAndDoEMFRegistration();
		IPluggableValidatorProvider validatorProvider = injector.getInstance(IPluggableValidatorProvider.class);
		validatorProvider.initFromClassNames (validatorClassName);
		return injector;
	}

	public static void doSetup() {
		new SLADslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	public void addValidatorClassName(String validatorClassName) {
		this.validatorClassName.add (validatorClassName);
	}
	
	public List<String> getValidatorClassName() {
		return validatorClassName;
	}

}
