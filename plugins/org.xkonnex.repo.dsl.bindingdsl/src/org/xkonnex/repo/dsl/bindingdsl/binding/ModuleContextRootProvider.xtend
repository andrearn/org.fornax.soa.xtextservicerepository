package org.xkonnex.repo.dsl.bindingdsl.binding

import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.REST
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAP
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.AssemblyType
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ServiceBinding


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