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

/*
 * Matches BindingProtocols of the Binding DSL to the respective Connector protocol
 */
class ProtocolMatcher {
	
	def boolean matchesImportBindingProtocol (BindingProtocol bindingProtocol, ImportBindingProtocol prot) {
		switch (prot) {
			case ImportBindingProtocol::SCA:	if (bindingProtocol instanceof SCA) return true else return false
			case ImportBindingProtocol::SOAP:	if (bindingProtocol instanceof SOAP) return true else return false
			case ImportBindingProtocol::EJB:	if (bindingProtocol instanceof EJB) return true else return false
			case ImportBindingProtocol::HTTP:	if (bindingProtocol instanceof HTTP) return true else return false
			case ImportBindingProtocol::REST:	if (bindingProtocol instanceof REST) return true else return false
			case ImportBindingProtocol::SAP:	if (bindingProtocol instanceof SAP) return true else return false
			case ImportBindingProtocol::JMS:	if (bindingProtocol instanceof JMS) return true else return false
			case ImportBindingProtocol::FILE:	if (bindingProtocol instanceof FILE) return true else return false
			case ImportBindingProtocol::FTP:	if (bindingProtocol instanceof FTP) return true else return false
			case ImportBindingProtocol::IIOP:	if (bindingProtocol instanceof IIOP) return true else return false
			case ImportBindingProtocol::AMQP:	if (bindingProtocol instanceof AMQP) return true else return false
		}
		return false
	}
	
	def supportsImportBindingProtocol (Binding binding, ImportBindingProtocol prot) {
		return binding.protocol.exists(p | p.matchesImportBindingProtocol(prot))
	}
}