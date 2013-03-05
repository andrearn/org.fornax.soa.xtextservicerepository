package org.fornax.soa.binding

import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.bindingDsl.REST
import org.fornax.soa.bindingDsl.SOAP
import org.fornax.soa.moduledsl.moduleDsl.AssemblyType
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.bindingDsl.ServiceBinding


/**
 * Provide context root paths based on  
 * <ul>
 * 	<li>module name</li>
 * 	<li>server type</li> 
 * 	<li>and the assembly type (only relevant for WebSphere's SCA modules)</li>
 * <ul>
 */
class ModuleContextRootProvider implements IContextRootProvider {
	
	
	override String getContextRoot (Module mod, String serverTypeName, BindingProtocol prot ) {
		val ctxRoot = prot.getContextRootByProtocol
		if (ctxRoot != null) {
			"/" + ctxRoot
		} else {
			"/" + mod.getCtxRootByAssemblyType (serverTypeName)
		}
	}
	
	override String getContextRoot (Module mod, String serverTypeName, String serverVersion, BindingProtocol prot) {
		val ctxRoot = prot.getContextRootByProtocol
		if (ctxRoot != null) {
			"/" + ctxRoot
		} else {
			"/" + mod.getCtxRootByAssemblyType (serverTypeName, serverVersion)
		}
	}
				
	override String getContextRoot (ServiceBinding b) {
		val soapBindings = b.protocol.filter ( typeof (SOAP));
		if (!soapBindings.empty  
			&& soapBindings.head.contextRoot != null)
		{
			"/" + soapBindings.head.contextRoot + "/";
		} else {
			"/"
		}
	}
	
	override String getCtxRootByAssemblyType (Module mod, String serverType) {
		if (serverType != null && serverType.toLowerCase.trim == "webmethods") {
			""
		} else {
			switch (mod.assemblyType) {
				case AssemblyType::SCA_EAR: mod.technicalModuleName + "Web/sca/"
				default: mod.technicalModuleName + "/"
			}
		}
	}
	
	override String getCtxRootByAssemblyType (Module mod, String serverType, String serverVersion) {
		if (serverType != null && serverType.toLowerCase.trim == "webmethods") {
			""
		} else {
			switch (mod.assemblyType) {
				case AssemblyType::SCA_EAR: mod.technicalModuleName + "Web/sca/"
				default: mod.technicalModuleName + "/"
			}
		}
	}
	
	override String getContextRootByProtocol (BindingProtocol prot) {
		prot.contextRootByProtocolInternal
	}
	
	def dispatch String getContextRootByProtocolInternal (BindingProtocol prot) {
		return null;
	}
	def dispatch String getContextRootByProtocolInternal (SOAP prot) {
		return prot.contextRoot
	}
	def dispatch String getContextRootByProtocolInternal (REST prot) {
		return prot.path
	}
	
	def String getTechnicalModuleName (Module mod) {
		if (mod.deploymentModuleName != null)
			return mod.deploymentModuleName
		else 
			return mod.name
	}
}