package org.xkonnex.repo.generator.moduledsl;

import org.xkonnex.repo.dsl.moduledsl.ModuleDslRuntimeModule;
import org.xkonnex.repo.dsl.moduledsl.query.IModuleServiceResolver;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.DefaultStateMatcher;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.IStateMatcher;
import org.xkonnex.repo.dsl.moduledsl.query.DefaultModuleServiceResolver;

public class ModuleDslGeneratorModule extends ModuleDslRuntimeModule {
	
	public Class<? extends IModuleServiceResolver> bindModuleServiceResolver () {
		return DefaultModuleServiceResolver.class;
	}
	
	public Class<? extends IStateMatcher> bindIStateMatcher () {
		return DefaultStateMatcher.class;
	}
}
