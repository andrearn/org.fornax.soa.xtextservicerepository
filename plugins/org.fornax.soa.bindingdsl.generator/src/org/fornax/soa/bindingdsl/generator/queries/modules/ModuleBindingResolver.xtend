package org.fornax.soa.bindingdsl.generator.queries.modules

import org.fornax.soa.bindingDsl.ModuleBinding
import java.util.List
import org.fornax.soa.moduledsl.moduleDsl.Module

class ModuleBindingResolver {
	
	def ModuleBinding getImportModuleBinding (List<ModuleBinding> canditates, Module importMod, String envName) {
		canditates.findFirst (e|e.module == importMod && e.environment.name == envName );
	}
}