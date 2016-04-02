package org.xkonnex.repo.dsl.bindingdsl.test;

import org.xkonnex.repo.generator.bindingdsl.BindingDslGeneratorModule;

import com.google.inject.Binder;
import com.google.inject.name.Names;

public class BindingDslTestModule extends BindingDslGeneratorModule {

	public void configureUseNestedPaths (Binder bind) {
		bind.bind(Boolean.class).annotatedWith(Names.named("useNestedPaths")).toInstance(false);		
	}
	
	public void configureUseRegistryBasedFilePaths (Binder bind) {
		bind.bind (Boolean.class).annotatedWith(Names.named("useRegistryBasedFilePaths")).toInstance(false);
	}

}
