package org.xkonnex.repo.dsl.bindingdsl.binding.query

import javax.inject.Inject
import org.xkonnex.repo.dsl.basedsl.ext.infer.IComponentInferrer
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ExtensibleProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAP
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.IModuleEndpointProtocol
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointProtocol
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.IProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding

/*
 * Matches BindingProtocols of the Binding DSL to the respective Connector protocol
 */
class ProtocolMatcher {
	
	@Inject IComponentInferrer componentInferrer
	
	def boolean matchesModuleEndpointProtocol (BindingProtocol bindingProtocol, EndpointProtocol prot) {
		if (prot != null) {
			switch (prot) {
				case org.xkonnex.repo.dsl.moduledsl.ext.protocol.SOAP:	if (bindingProtocol instanceof SOAP) return true else return false
			}
		} else if (prot instanceof EndpointProtocol && bindingProtocol instanceof ExtensibleProtocol) {
			val protType = (bindingProtocol as ExtensibleProtocol).type
			val IProtocol extProt = componentInferrer.inferComponent(protType)
			return extProt.supportsModuleEndpointProtocol(prot)
		}
		return false
	}
	
	def boolean matchesModuleEndpointProtocol (BindingProtocol bindingProtocol, Class<? extends IModuleEndpointProtocol> prot) {
		if (prot != null) {
			if (bindingProtocol instanceof ExtensibleProtocol) {
				val protType = (bindingProtocol as ExtensibleProtocol).type
				val IProtocol extProt = componentInferrer.inferComponent(protType)
				return extProt.supportsModuleEndpointProtocol(prot)
			} else { 
				switch (prot) {
					case prot.isAssignableFrom(org.xkonnex.repo.dsl.moduledsl.ext.protocol.SOAP) && bindingProtocol instanceof SOAP: return true
				}
				
			}
		}
		return false
	}
	
	def supportsModuleEndpointProtocol (AnyBinding binding, EndpointProtocol prot) {
		return binding.protocol.exists(p | p.matchesModuleEndpointProtocol(prot))
	}
	
	def supportsModuleEndpointProtocol (AnyBinding binding, Class<? extends IModuleEndpointProtocol> prot) {
		return binding.protocol.exists(p | p.matchesModuleEndpointProtocol(prot))
	}
}