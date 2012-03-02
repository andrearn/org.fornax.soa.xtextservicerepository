package org.fornax.soa.moduledsl.generator;

import org.fornax.soa.moduledsl.ModuleDslRuntimeModule;
import org.fornax.soa.moduledsl.generator.query.ModuleNamespaceQuery;
import org.fornax.soa.moduledsl.generator.query.ModuleServiceResolver;

public class ModuleDslGeneratorModule extends ModuleDslRuntimeModule {

	public Class<? extends ModuleNamespaceQuery> bindModuleNamespaceQuery () {
		return ModuleNamespaceQuery.class;
	}
	
	public Class<? extends ModuleServiceResolver> bindModuleServiceResolver () {
		return ModuleServiceResolver.class;
	}
}
