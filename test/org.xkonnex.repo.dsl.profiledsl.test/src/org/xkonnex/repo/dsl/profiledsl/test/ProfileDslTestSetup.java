package org.xkonnex.repo.dsl.profiledsl.test;

import java.util.ArrayList;
import java.util.List;

import org.xkonnex.repo.dsl.profiledsl.ProfileDslStandaloneSetup;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ProfileDslTestSetup extends ProfileDslStandaloneSetup {
	
	private List<String> validatorClassName=new ArrayList<String>();

	@Override
	public Injector createInjector() {
		return Guice.createInjector(new ProfileDslTestModule());
	}
	
	public static void doSetup() {
		new ProfileDslTestSetup().createInjectorAndDoEMFRegistration();
	}

}
