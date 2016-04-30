package org.xkonnex.repo.dsl.bindingdsl.binding

import com.google.inject.Inject
import org.xkonnex.repo.dsl.basedsl.ext.infer.IComponentInferrer
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.REST
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAP
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ServiceBinding
import org.xkonnex.repo.dsl.bindingdsl.model.EffectiveBinding
import org.xkonnex.repo.dsl.moduledsl.ext.assembly.IAssemblyType
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.AssemblyType
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.AssemblyTypeEnum
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ExtensibleAssemblyType
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module

/**
 * Provide context root paths based on  
 * <ul>
 * 	<li>module name</li>
 * 	<li>server type</li> 
 * 	<li>and the assembly type (only relevant for WebSphere's SCA modules)</li>
 * <ul>
 */
class ModuleContextRootProvider implements IContextRootProvider {
	
	@Inject IComponentInferrer componentInferrer
	
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
		getCtxRootByAssemblyTypeInternal(serverType, mod)
	}
	
	override String getCtxRootByAssemblyType (Module mod, String serverType, String serverVersion) {
		getCtxRootByAssemblyTypeInternal(serverType, mod)
	}
	
	def getCtxRootByAssemblyTypeInternal(String serverType, Module mod) {
		if (serverType != null && serverType.toLowerCase.trim == "webmethods") {
			""
		} else if (mod.assemblyType instanceof ExtensibleAssemblyType) {
			val IAssemblyType assemblyType = componentInferrer.inferComponent(mod.assemblyType as ExtensibleAssemblyType)
			mod.technicalModuleName + "/"
		} else if (mod.assemblyType instanceof AssemblyType) {
			switch (mod.assemblyType.typeEnum) {
				case AssemblyTypeEnum::SCA_EAR: mod.technicalModuleName + "Web/sca/"
				default: mod.technicalModuleName + "/"
			}
		} else {
			mod.technicalModuleName + "/"
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
	
	override getContextRoot(EffectiveBinding b) {
		val soapBindings = b.protocol.filter ( typeof (SOAP));
		if (!soapBindings.empty  
			&& soapBindings.head.contextRoot != null)
		{
			"/" + soapBindings.head.contextRoot + "/";
		} else {
			"/"
		}
	}
	
}