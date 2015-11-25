
package org.xkonnex.repo.dsl.environmentdsl;

import java.util.ArrayList;
import java.util.List;

import org.xkonnex.repo.dsl.basedsl.baseDsl.impl.BaseDslFactoryImpl;
import org.xkonnex.repo.dsl.basedsl.validation.IPluggableValidatorProvider;
import org.xkonnex.repo.dsl.environmentdsl.EnvironmentDslStandaloneSetupGenerated;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.impl.EnvironmentDslFactoryImpl;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class EnvironmentDslStandaloneSetup extends EnvironmentDslStandaloneSetupGenerated{

	private List<String> validatorClassName=new ArrayList<String>();

	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		Injector injector = super.createInjectorAndDoEMFRegistration();
		IPluggableValidatorProvider validatorProvider = injector.getInstance(IPluggableValidatorProvider.class);
		validatorProvider.initFromClassNames (validatorClassName);
		return injector;
	}

	public static void doSetup() {
		new EnvironmentDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	public void addValidatorClassName(String validatorClassName) {
		this.validatorClassName.add (validatorClassName);
	}
	
	public List<String> getValidatorClassName() {
		return validatorClassName;
	}

}

