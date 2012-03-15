package org.fornax.soa.moduledsl.generator;

import org.fornax.soa.moduledsl.ModuleDslRuntimeModule;
import org.fornax.soa.moduledsl.generator.query.ModuleNamespaceQuery;
import org.fornax.soa.moduledsl.generator.query.ModuleServiceResolver;
import org.fornax.soa.profiledsl.scoping.versions.DefaultStateMatcher;
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher;

public class ModuleDslGeneratorModule extends ModuleDslRuntimeModule {

	public Class<? extends ModuleNamespaceQuery> bindModuleNamespaceQuery () {
		return ModuleNamespaceQuery.class;
	}
	
	public Class<? extends ModuleServiceResolver> bindModuleServiceResolver () {
		return ModuleServiceResolver.class;
	}
	
	public Class<? extends IStateMatcher> bindIStateMatcher () {
		return DefaultStateMatcher.class;
	}
}
