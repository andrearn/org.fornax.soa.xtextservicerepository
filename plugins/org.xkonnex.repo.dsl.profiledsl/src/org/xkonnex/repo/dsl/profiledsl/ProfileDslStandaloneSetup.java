
package org.xkonnex.repo.dsl.profiledsl;

import java.util.ArrayList;
import java.util.List;

import org.xkonnex.repo.dsl.basedsl.baseDsl.impl.BaseDslFactoryImpl;
import org.xkonnex.repo.dsl.basedsl.validation.IPluggableValidatorProvider;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.impl.EnvironmentDslFactoryImpl;
import org.xkonnex.repo.dsl.profiledsl.ProfileDslStandaloneSetupGenerated;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.impl.ProfileDslPackageImpl;

import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ProfileDslStandaloneSetup extends ProfileDslStandaloneSetupGenerated{

	private List<String> validatorClassName=new ArrayList<String>();

	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		Injector injector = super.createInjectorAndDoEMFRegistration();
		IPluggableValidatorProvider validatorProvider = injector.getInstance(IPluggableValidatorProvider.class);
		validatorProvider.initFromClassNames (validatorClassName);
		return injector;
	}

	public static void doSetup() {
		BaseDslFactoryImpl.init();
		EnvironmentDslFactoryImpl.init();
		new ProfileDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
	public void addValidatorClassName(String validatorClassName) {
		this.validatorClassName.add (validatorClassName);
	}
	
	public List<String> getValidatorClassName() {
		return validatorClassName;
	}

}

