package org.fornax.soa.bindingdsl.generator.queries

import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.bindingDsl.SOAP
import org.fornax.soa.moduledsl.moduleDsl.ImportBindingProtocol
import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.bindingDsl.REST
import org.fornax.soa.bindingDsl.HTTP
import org.fornax.soa.bindingDsl.AMQP
import org.fornax.soa.bindingDsl.IIOP
import org.fornax.soa.bindingDsl.FTP
import org.fornax.soa.bindingDsl.FILE
import org.fornax.soa.bindingDsl.JMS
import org.fornax.soa.bindingDsl.SAP
import org.fornax.soa.bindingDsl.EJB
import org.fornax.soa.bindingDsl.SCA

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
			default: false
		}
		return false
	}
	
	def supportsImportBindingProtocol (Binding binding, ImportBindingProtocol prot) {
		return binding.protocol.exists(p | p.matchesImportBindingProtocol(prot))
	}
}