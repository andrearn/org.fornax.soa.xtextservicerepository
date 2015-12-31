package org.xkonnex.repo.dsl.bindingdsl.binding.query

import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AMQP
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.EJB
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.FILE
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.FTP
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.HTTP
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.IIOP
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.JMS
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.REST
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SAP
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SCA
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAP
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ImportBindingProtocol
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ImportBindingProtocolEnum
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ExtensibleImportBindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ExtensibleProtocol

/*
 * Matches BindingProtocols of the Binding DSL to the respective Connector protocol
 */
class ProtocolMatcher {
	
	def boolean matchesImportBindingProtocol (BindingProtocol bindingProtocol, ImportBindingProtocol prot) {
		if (prot.protocolEnum != null) {
		switch (prot.protocolEnum) {
			case ImportBindingProtocolEnum::SCA:	if (bindingProtocol instanceof SCA) return true else return false
			case ImportBindingProtocolEnum::SOAP:	if (bindingProtocol instanceof SOAP) return true else return false
			case ImportBindingProtocolEnum::EJB:	if (bindingProtocol instanceof EJB) return true else return false
			case ImportBindingProtocolEnum::HTTP:	if (bindingProtocol instanceof HTTP) return true else return false
			case ImportBindingProtocolEnum::REST:	if (bindingProtocol instanceof REST) return true else return false
			case ImportBindingProtocolEnum::SAP:	if (bindingProtocol instanceof SAP) return true else return false
			case ImportBindingProtocolEnum::JMS:	if (bindingProtocol instanceof JMS) return true else return false
			case ImportBindingProtocolEnum::FILE:	if (bindingProtocol instanceof FILE) return true else return false
			case ImportBindingProtocolEnum::FTP:	if (bindingProtocol instanceof FTP) return true else return false
			case ImportBindingProtocolEnum::IIOP:	if (bindingProtocol instanceof IIOP) return true else return false
			case ImportBindingProtocolEnum::AMQP:	if (bindingProtocol instanceof AMQP) return true else return false
		}
		} else if (prot instanceof ExtensibleImportBindingProtocol && bindingProtocol instanceof ExtensibleProtocol) {
			val extProt = prot as ExtensibleProtocol
			val extModProt = prot as ExtensibleImportBindingProtocol
			
		}
		return false
	}
	
	def supportsImportBindingProtocol (Binding binding, ImportBindingProtocol prot) {
		return binding.protocol.exists(p | p.matchesImportBindingProtocol(prot))
	}
	
	def boolean matchesImportBindingProtocol (BindingProtocol bindingProtocol, ImportBindingProtocolEnum prot) {
		switch (prot) {
			case ImportBindingProtocolEnum::SCA:	if (bindingProtocol instanceof SCA) return true else return false
			case ImportBindingProtocolEnum::SOAP:	if (bindingProtocol instanceof SOAP) return true else return false
			case ImportBindingProtocolEnum::EJB:	if (bindingProtocol instanceof EJB) return true else return false
			case ImportBindingProtocolEnum::HTTP:	if (bindingProtocol instanceof HTTP) return true else return false
			case ImportBindingProtocolEnum::REST:	if (bindingProtocol instanceof REST) return true else return false
			case ImportBindingProtocolEnum::SAP:	if (bindingProtocol instanceof SAP) return true else return false
			case ImportBindingProtocolEnum::JMS:	if (bindingProtocol instanceof JMS) return true else return false
			case ImportBindingProtocolEnum::FILE:	if (bindingProtocol instanceof FILE) return true else return false
			case ImportBindingProtocolEnum::FTP:	if (bindingProtocol instanceof FTP) return true else return false
			case ImportBindingProtocolEnum::IIOP:	if (bindingProtocol instanceof IIOP) return true else return false
			case ImportBindingProtocolEnum::AMQP:	if (bindingProtocol instanceof AMQP) return true else return false
		}
		return false
	}
	
	def supportsImportBindingProtocol (Binding binding, ImportBindingProtocolEnum prot) {
		return binding.protocol.exists(p | p.matchesImportBindingProtocol(prot))
	}
}