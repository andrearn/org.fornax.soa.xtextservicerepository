package org.fornax.soa.bindingdsl.generator.templates.soap

import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.moduledsl.moduleDsl.AssemblyType

class ContextRootProvider {
	
	def String getContextRoot (Module mod, String serverTypeName ) {
		"/" + mod.getCtxRootByAssemblyType (serverTypeName)
	}
		
	def String getCtxRootByAssemblyType (Module mod, String serverType) {
		switch (mod.assemblyType) {
			case AssemblyType::SCA_EAR: mod.technicalModuleName + "Web/sca/"
			case AssemblyType::WEB_METHODS: ""
			default: mod.technicalModuleName + "/"
		}
	}
	
	def String getTechnicalModuleName (Module mod) {
		if (mod.deploymentModuleName != null)
			return mod.deploymentModuleName
		else 
			return mod.name
	}
}