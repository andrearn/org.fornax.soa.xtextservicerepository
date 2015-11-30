package org.xkonnex.repo.dsl.profiledsl.test;

import org.xkonnex.repo.generator.profiledsl.ProfileDslGeneratorModule;

import com.google.inject.Binder;
import com.google.inject.name.Names;

public class ProfileDslTestModule extends ProfileDslGeneratorModule {

	public void configureUseNestedPaths (Binder bind) {
		bind.bind(Boolean.class).annotatedWith(Names.named("useNestedPaths")).toInstance(false);		
	}
	
	public void configureUseRegistryBasedFilePaths (Binder bind) {
		bind.bind (Boolean.class).annotatedWith(Names.named("useRegistryBasedFilePaths")).toInstance(false);
	}

}
