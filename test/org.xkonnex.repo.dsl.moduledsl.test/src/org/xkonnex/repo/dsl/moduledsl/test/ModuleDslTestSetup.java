package org.xkonnex.repo.dsl.moduledsl.test;

import java.util.ArrayList;
import java.util.List;

import org.xkonnex.repo.dsl.moduledsl.ModuleDslStandaloneSetup;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ModuleDslTestSetup extends ModuleDslStandaloneSetup {
	
	private List<String> validatorClassName=new ArrayList<String>();

	@Override
	public Injector createInjector() {
		return Guice.createInjector(new ModuleDslTestModule());
	}
	
	public static void doSetup() {
		new ModuleDslTestSetup().createInjectorAndDoEMFRegistration();
	}

}
