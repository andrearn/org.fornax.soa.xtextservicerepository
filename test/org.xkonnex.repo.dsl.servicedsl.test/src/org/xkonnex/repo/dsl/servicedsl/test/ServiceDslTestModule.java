package org.xkonnex.repo.dsl.servicedsl.test;

import org.xkonnex.repo.dsl.servicedsl.ServiceDslRuntimeModule;
import org.xkonnex.repo.generator.servicedsl.ServiceDslGeneratorModule;

import com.google.inject.Binder;
import com.google.inject.name.Names;

public class ServiceDslTestModule extends ServiceDslGeneratorModule {

	public void configureUseNestedPaths (Binder bind) {
		bind.bind(Boolean.class).annotatedWith(Names.named("useNestedPaths")).toInstance(false);		
	}
	
	public void configureUseRegistryBasedFilePaths (Binder bind) {
		bind.bind (Boolean.class).annotatedWith(Names.named("useRegistryBasedFilePaths")).toInstance(false);
	}

}
