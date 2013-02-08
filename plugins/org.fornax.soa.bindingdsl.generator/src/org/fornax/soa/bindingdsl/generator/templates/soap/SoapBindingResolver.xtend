package org.fornax.soa.bindingdsl.generator.templates.soap

import com.google.inject.Inject
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingDsl.SOAP
import org.fornax.soa.bindingDsl.SOAPStyle
import org.fornax.soa.bindingDsl.ServiceBinding
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions
import org.fornax.soa.environmentDsl.Server
import org.fornax.soa.environmentdsl.generator.EndpointResolver
import org.fornax.soa.service.query.namespace.NamespaceQuery
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
import org.fornax.soa.bindingdsl.generator.templates.naming.EndpointQualifierNameProvider

class SoapBindingResolver {
	
	@Inject extension EndpointQualifierNameProvider
		
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
	
	def dispatch String toPrivatePortName (Service s, SOAP p) {
		s.name + p.getPortNamePostfix();
	}
	
	def dispatch String toPrivatePortName (Service s, SOAP p, String qualifierName) {
		if (qualifierName != "Public" && qualifierName != "Private")
			s.name + qualifierName + p.getPortNamePostfix() + "Private"
		else 
			s.toPrivatePortName(p) + "Private"
	}
	
	def String toScopedPortName (Service s, SOAP p) {
		s.toPortName(p) + s.getServiceVisibilityName ();
	}
	
	def String toScopedPortName (Service s, SOAP p, String qualifierName) {
		if (qualifierName != "Public" && qualifierName != "Private")
			s.toPortName(p) + qualifierName + s.getServiceVisibilityName ()
		else
			s.toScopedPortName(p)
	}
	
	def private String getPortNamePostfix(SOAP p) { 
		switch (p.style) {
		case SOAPStyle::RPCLIT: "SOAPRPClit"
		case SOAPStyle::RPCENC: "SOAPRPCEnc"
		default : "SOAP"	
		}
	}
}