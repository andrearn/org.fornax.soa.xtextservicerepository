package org.xkonnex.repo.generator.bindingdsl.templates.soap

import com.google.inject.Inject
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAP
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAPStyle
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.generator.bindingdsl.templates.naming.IEndpointQualifierNameProvider

class SoapBindingResolver {
	
	@Inject extension IEndpointQualifierNameProvider
		
	def String getWsdlBindingStyle(SOAP bind) { 
		switch (bind.style) {
		case SOAPStyle::RPCLIT: "RPC"
		case SOAPStyle::RPCENC: "RPC"
		default : "document"	
		}
	}
		
	def String getSoapEncoding(SOAP bind) {
		switch (bind.style) {
		case SOAPStyle::RPCENC: "encoded"
		default : "literal"	
		}
	}
		
					
	def String toBindingName (Service s, SOAP p) {
		s.name + p.getPortNamePostfix();
	}
		
	def String toBindingName (Service s, SOAP p, String qualifierName) {
		s.name + qualifierName + p.getPortNamePostfix();
	}
	
	def String toPortName (Service s, SOAP p) {
		s.name + p.getPortNamePostfix();
	}
	
	def String toPortName (Service s, SOAP p, String qualifierName) {
		if (qualifierName != "Public" && qualifierName != "Private")
			s.name + qualifierName + p.getPortNamePostfix()
		else 
			s.toPortName(p)
	}
	
	
	def String toScopedPortName (Service s, Binding binding, SOAP p) {
		binding.getEndpointQualifierName (s, p)
		s.toPortName(p) + binding.getEndpointQualifierName (s, p);
	}
	
	def String toScopedPortName (Service s, Binding binding, SOAP p, String qualifierName) {
		if (qualifierName != "Public" && qualifierName != "Private")
			s.toPortName(p) + qualifierName
		else
			s.toScopedPortName(binding, p)
	}
	
	def private String getPortNamePostfix(SOAP p) { 
		switch (p.style) {
		case SOAPStyle::RPCLIT: "SOAPRPClit"
		case SOAPStyle::RPCENC: "SOAPRPCEnc"
		default : "SOAP"	
		}
	}
}