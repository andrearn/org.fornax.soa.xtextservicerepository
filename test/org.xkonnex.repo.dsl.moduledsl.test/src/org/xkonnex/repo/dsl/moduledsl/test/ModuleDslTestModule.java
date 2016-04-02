package org.xkonnex.repo.dsl.moduledsl.test;

import org.xkonnex.repo.generator.moduledsl.ModuleDslGeneratorModule;

import com.google.inject.Binder;
import com.google.inject.name.Names;

public class ModuleDslTestModule extends ModuleDslGeneratorModule {

	public void configureUseNestedPaths (Binder bind) {
		bind.bind(Boolean.class).annotatedWith(Names.named("useNestedPaths")).toInstance(false);		
	}
	
	public void configureUseRegistryBasedFilePaths (Binder bind) {
		bind.bind (Boolean.class).annotatedWith(Names.named("useRegistryBasedFilePaths")).toInstance(false);
	}

}
