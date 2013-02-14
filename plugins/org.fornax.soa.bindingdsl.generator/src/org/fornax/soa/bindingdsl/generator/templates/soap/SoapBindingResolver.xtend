package org.fornax.soa.bindingdsl.generator.templates.soap

import com.google.inject.Inject
import org.fornax.soa.bindingDsl.SOAP
import org.fornax.soa.bindingDsl.SOAPStyle
import org.fornax.soa.bindingDsl.ServiceBinding
import org.fornax.soa.bindingdsl.generator.templates.naming.DefaultEndpointQualifierNameProvider
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.bindingdsl.generator.templates.naming.IEndpointQualifierNameProvider
import org.fornax.soa.bindingDsl.Binding

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
		
				
	def dispatch String getContextRoot (ServiceBinding b) {
		val soapBindings = b.protocol.filter ( typeof (SOAP));
		if (!soapBindings.empty  
			&& soapBindings.head.contextRoot != null)
		{
			"/" + soapBindings.head.contextRoot + "/";
		} else {
			"/"
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