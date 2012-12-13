package org.fornax.soa.bindingdsl.generator.templates.soap

import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.bindingDsl.REST
import org.fornax.soa.bindingDsl.SOAP
import org.fornax.soa.moduledsl.moduleDsl.AssemblyType
import org.fornax.soa.moduledsl.moduleDsl.Module

class ContextRootProvider {
	
	
	def String getContextRoot (Module mod, String serverTypeName, BindingProtocol prot ) {
		val ctxRoot = prot.getContextRootByProtocol
		if (ctxRoot != null) {
			"/" + ctxRoot
		} else {
			"/" + mod.getCtxRootByAssemblyType (serverTypeName)
		}
	}
	
	def String getContextRoot (Module mod, String serverTypeName, String serverVersion, BindingProtocol prot) {
		val ctxRoot = prot.getContextRootByProtocol
		if (ctxRoot != null) {
			"/" + ctxRoot
		} else {
			"/" + mod.getCtxRootByAssemblyType (serverTypeName, serverVersion)
		}
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
	
	def dispatch String getContextRootByProtocol (BindingProtocol prot) {
		return null;
	}
	def dispatch String getContextRootByProtocol (SOAP prot) {
		return prot.contextRoot
	}
	def dispatch String getContextRootByProtocol (REST prot) {
		return prot.path
	}
	
	def String getTechnicalModuleName (Module mod) {
		if (mod.deploymentModuleName != null)
			return mod.deploymentModuleName
		else 
			return mod.name
	}
}