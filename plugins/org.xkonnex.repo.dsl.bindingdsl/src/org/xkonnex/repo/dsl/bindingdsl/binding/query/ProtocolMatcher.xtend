package org.xkonnex.repo.dsl.bindingdsl.binding.query

import javax.inject.Inject
import org.xkonnex.repo.dsl.basedsl.ext.infer.IComponentInferrer
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AMQP
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.EJB
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ExtensibleProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.FILE
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.FTP
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.HTTP
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.IIOP
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.JMS
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.REST
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SAP
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SCA
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
				case org.xkonnex.repo.dsl.moduledsl.ext.protocol.SCA:	if (bindingProtocol instanceof SCA) return true else return false
				case org.xkonnex.repo.dsl.moduledsl.ext.protocol.SOAP:	if (bindingProtocol instanceof SOAP) return true else return false
				case org.xkonnex.repo.dsl.moduledsl.ext.protocol.EJB:	if (bindingProtocol instanceof EJB) return true else return false
				case org.xkonnex.repo.dsl.moduledsl.ext.protocol.HTTP:	if (bindingProtocol instanceof HTTP) return true else return false
				case org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST:	if (bindingProtocol instanceof REST) return true else return false
				case org.xkonnex.repo.dsl.moduledsl.ext.protocol.SAP:	if (bindingProtocol instanceof SAP) return true else return false
				case org.xkonnex.repo.dsl.moduledsl.ext.protocol.JMS:	if (bindingProtocol instanceof JMS) return true else return false
				case org.xkonnex.repo.dsl.moduledsl.ext.protocol.FILE:	if (bindingProtocol instanceof FILE) return true else return false
				case org.xkonnex.repo.dsl.moduledsl.ext.protocol.FTP:	if (bindingProtocol instanceof FTP) return true else return false
				case org.xkonnex.repo.dsl.moduledsl.ext.protocol.IIOP:	if (bindingProtocol instanceof IIOP) return true else return false
				case org.xkonnex.repo.dsl.moduledsl.ext.protocol.AMQP:	if (bindingProtocol instanceof AMQP) return true else return false
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
					case prot.isAssignableFrom(org.xkonnex.repo.dsl.moduledsl.ext.protocol.SCA) && bindingProtocol instanceof SCA: return true
					case prot.isAssignableFrom(org.xkonnex.repo.dsl.moduledsl.ext.protocol.SOAP) && bindingProtocol instanceof SOAP: return true
					case prot.isAssignableFrom(org.xkonnex.repo.dsl.moduledsl.ext.protocol.EJB) && bindingProtocol instanceof EJB: return true
					case prot.isAssignableFrom(org.xkonnex.repo.dsl.moduledsl.ext.protocol.HTTP) && bindingProtocol instanceof HTTP: return true
					case prot.isAssignableFrom(org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST) && bindingProtocol instanceof REST: return true
					case prot.isAssignableFrom(org.xkonnex.repo.dsl.moduledsl.ext.protocol.SAP) && bindingProtocol instanceof SAP: return true
					case prot.isAssignableFrom(org.xkonnex.repo.dsl.moduledsl.ext.protocol.JMS) && bindingProtocol instanceof JMS: return true
					case prot.isAssignableFrom(org.xkonnex.repo.dsl.moduledsl.ext.protocol.FILE) && bindingProtocol instanceof FILE: return true
					case prot.isAssignableFrom(org.xkonnex.repo.dsl.moduledsl.ext.protocol.FTP) && bindingProtocol instanceof FTP: return true
					case prot.isAssignableFrom(org.xkonnex.repo.dsl.moduledsl.ext.protocol.IIOP) && bindingProtocol instanceof IIOP: return true
					case prot.isAssignableFrom(org.xkonnex.repo.dsl.moduledsl.ext.protocol.AMQP) && bindingProtocol instanceof AMQP: return true
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