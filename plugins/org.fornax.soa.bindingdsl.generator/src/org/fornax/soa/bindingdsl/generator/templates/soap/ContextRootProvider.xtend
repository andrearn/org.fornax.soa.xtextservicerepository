package org.fornax.soa.bindingdsl.generator.templates.soap

import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.moduledsl.moduleDsl.AssemblyType

class ContextRootProvider {
	
	def String getContextRoot (Module mod, String serverTypeName ) {
		"/" + mod.getCtxRootByAssemblyType (serverTypeName)
	}
	
	def String getContextRoot (Module mod, String serverTypeName, String serverVersion) {
		"/" + mod.getCtxRootByAssemblyType (serverTypeName, serverVersion)
	}
		
	def String getCtxRootByAssemblyType (Module mod, String serverType) {
		if (serverType.toLowerCase.trim == "webmethods") {
			""
		} else {
			switch (mod.assemblyType) {
				case AssemblyType::SCA_EAR: mod.technicalModuleName + "Web/sca/"
				default: mod.technicalModuleName + "/"
			}
		}
	}
	
	def String getCtxRootByAssemblyType (Module mod, String serverType, String serverVersion) {
		if (serverType.toLowerCase.trim == "webmethods") {
			""
		} else {
			switch (mod.assemblyType) {
				case AssemblyType::SCA_EAR: mod.technicalModuleName + "Web/sca/"
				default: mod.technicalModuleName + "/"
			}
		}
	}
	
	def String getTechnicalModuleName (Module mod) {
		if (mod.deploymentModuleName != null)
			return mod.deploymentModuleName
		else 
			return mod.name
	}
}