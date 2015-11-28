package org.xkonnex.repo.dsl.servicedsl.test;

import java.util.List;

import org.xkonnex.repo.core.XKonneXRepoDSL;

import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;

public class ServiceTestModule extends AbstractModule {
	
	private List<Injector> injectors;
	
	public ServiceTestModule(List<Injector> injectors) {
		this.injectors = injectors;
	}

	@Override
	protected void configure() {
		bind(new TypeLiteral<List<Injector>>(){}).annotatedWith(XKonneXRepoDSL.class).toInstance(injectors);
		
	}

}
