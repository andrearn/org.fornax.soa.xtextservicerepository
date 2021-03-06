package org.xkonnex.repo.dsl.servicedsl.test;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.util.Modules2;
import org.xkonnex.repo.dsl.basedsl.baseDsl.impl.BaseDslFactoryImpl;
import org.xkonnex.repo.dsl.basedsl.validation.IPluggableValidatorProvider;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.impl.EnvironmentDslFactoryImpl;
import org.xkonnex.repo.dsl.profiledsl.ProfileDslStandaloneSetup;
import org.xkonnex.repo.dsl.servicedsl.ServiceDslStandaloneSetup;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.util.Modules;

public class ServiceDslTestSetup extends ServiceDslStandaloneSetup {
	
	private List<String> validatorClassName=new ArrayList<String>();

	@Override
	public Injector createInjector() {
		return Guice.createInjector(new ServiceDslTestModule());
	}
	
	public static void doSetup() {
		new ServiceDslTestSetup().createInjectorAndDoEMFRegistration();
	}

}
