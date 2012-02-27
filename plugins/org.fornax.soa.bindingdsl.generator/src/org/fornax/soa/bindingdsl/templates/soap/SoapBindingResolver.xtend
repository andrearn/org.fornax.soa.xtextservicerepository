package org.fornax.soa.bindingdsl.templates.soap

import com.google.inject.Inject
import java.util.List
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.bindingDsl.DomainBinding
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingDsl.SOAP
import org.fornax.soa.bindingDsl.SOAPStyle
import org.fornax.soa.bindingDsl.ServiceBinding
import org.fornax.soa.bindingDsl.ServiceRef
import org.fornax.soa.bindingdsl.templates.BindingExtensions
import org.fornax.soa.environmentDsl.AppServer
import org.fornax.soa.environmentDsl.ESB
import org.fornax.soa.environmentDsl.Server
import org.fornax.soa.environmentdsl.generator.EndpointResolver
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.servicedsl.query.namespace.NamespaceQuery
import org.fornax.soa.servicedsl.templates.xsd.SchemaNamespaceExtensions
import org.eclipse.emf.ecore.EObject

class SoapBindingResolver {
	
	@Inject extension VersionQualifierExtensions
	@Inject extension NamespaceQuery
	@Inject extension org.fornax.soa.servicedsl.templates.xsd.SchemaNamespaceExtensions
	@Inject extension BindingExtensions
	@Inject extension SoapVendorBindingsResolver
	@Inject extension EndpointResolver
		
	def dispatch String getWsdlBindingStyle(SOAP bind) { 
		switch (bind.style) {
		case SOAPStyle::RPCLIT: "RPC"
		case SOAPStyle::RPCENC: "RPC"
		default : "document"	
		}
	}
		
	def dispatch String getSoapEncoding(SOAP bind) {
		switch (bind.style) {
		case SOAPStyle::RPCENC: "encoded"
		default : "literal"	
		}
	}
		
		
	def dispatch String getPublisherEndpointAddress (Service s, EObject b) {
		
	}
	
	def dispatch String getPublisherEndpointAddress (Service s, DomainBinding b) {
		if (b.serviceBinding.map (svcBind|svcBind.service).contains(s)) { 
			getPublisherEndpointAddress(s, s.getServiceBinding(b))
		} else {
			b.getPublishingServer().getBaseUrl()
			+ getEndpoint (b.getContextRoot(s), b.subNamespace.findOrgNamespace(), b.subNamespace, s, b.getPublishingServer());
	/*		+ b.subNamespace.getOrgNamespace().name.replaceAll("\\.","/") + "/" 
			+ b.subNamespace.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	*/
	
		}
	
	}	
	
	def dispatch String getPublisherEndpointAddress(Service s, ServiceBinding b) {
		b.getPublishingServer().getBaseUrl()
			+ getEndpoint (b.getContextRoot(), b.service.service.findOrgNamespace(), (b.service.service.eContainer as SubNamespace), s, b.getPublishingServer());
		/*
		+ b.getContextRoot() 
		+ b.service.service.getOrgNamespace().name.replaceAll("\\.","/") + "/" 
		+ ((SubNamespace)b.service.service.eContainer).name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	*/
	}
	
	def dispatch String getProviderEndpointAddress(Service s, EObject b) {
	}
	
	def dispatch String getProviderEndpointAddress(Service s, DomainBinding b) {
		if (b.serviceBinding.map (svcBind | svcBind.service).contains (s)) {
			getProviderEndpointAddress(s, s.getServiceBinding(b))
		} else {
			b.getProvidingServer().getBaseUrl()
			+ b.getProviderContextRoot(s) 
			+ b.subNamespace.findOrgNamespace().name.replaceAll("\\.","/") + "/" 
			+ b.subNamespace.name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
		}
	}
		
	def dispatch String getProviderEndpointAddress (Service s, ServiceBinding b) {
		b.getProvidingServer().getBaseUrl() 
		+ b.getProviderContextRoot() 
		+ b.service.service.findOrgNamespace().name.replaceAll("\\.","/") + "/" 
		+ (b.service.service.eContainer as SubNamespace).name.replaceAll("\\.","/") +"/" + s.name + "/" + s.version.toVersionPostfix();
	}
	
	def dispatch ServiceBinding getServiceBinding (Service s, DomainBinding b) {
		b.serviceBinding.findFirst(e|e.service.service == s);
	}
	 
	def dispatch String getBaseUrl (Server s) {
		"http://" + s.host;
	}
	def dispatch String getBaseUrl (ESB s) {
		if (s.soapUrl != null) {
			s.soapUrl;
		} else {
			s.baseUrl;
		}
	}
	def dispatch String getBaseUrl (AppServer s) {
		s.baseUrl;
	}
	
	def dispatch List<BindingProtocol> getBindingProtocols (DomainBinding domBind, ServiceRef s) {
		if (domBind.serviceBinding.filter (e|e.service.service.name == s.service.name).size > 0) {
			domBind.serviceBinding.filter (e|e.service.service.name == s.service.name).map (b|b.protocol).flatten.toList; 
		} else {
			domBind.protocol.toList;
		}
	}
	
	def dispatch List<BindingProtocol> getBindingProtocols (DomainBinding domBind, Service s) { 
		if (domBind.serviceBinding.filter (e|e.service.service.name == s.name).size > 0) { 
			domBind.serviceBinding.filter (e|e.service.service.name == s.name).map (b|b.protocol).flatten.toList;
		} else {
			domBind.protocol;
		}
	}
	
	def dispatch String getContextRoot (DomainBinding b, Service s) {
		val soapBindings = b.getBindingProtocols(s).filter (typeof (SOAP));
		if (soapBindings.size > 0
			&& soapBindings.head.contextRoot != null)
		{
			"/" + soapBindings.head.contextRoot + "/";
		} else {
			"/";
		}
	}
	
	def dispatch String getProviderContextRoot (DomainBinding b, Service s) {
		val soapBindings = b.getBindingProtocols(s).filter (typeof (SOAP));
		if (!soapBindings.empty  
			&& soapBindings.head.providerContextRoot != null) 
		{
			"/" + soapBindings.head.providerContextRoot + "/";
		} else {
			"/";
		}
	}
			
	def dispatch String getContextRoot (ServiceBinding b) {
		val soapBindings = b.protocol.filter ( typeof (SOAP));
		if (!soapBindings.empty  
			&& soapBindings.head.contextRoot != null)
		{
			"/" + soapBindings.head.contextRoot + "/";
		} else {
			"/";
		}
	}
	
	def dispatch String getProviderContextRoot (ServiceBinding b) {
		val soapBindings = b.protocol.filter ( typeof (SOAP));
		if (!soapBindings.empty  
			&& soapBindings.head.providerContextRoot != null)
		{
				"/" + soapBindings.head.providerContextRoot + "/";
		} else {
			"/";
		}
	}
			
	def dispatch Server getPublishingServer (Binding b) {
		val soapBindings = b.protocol.filter ( typeof (SOAP));
		if (soapBindings.head?.publisher?.pubServer != null) {
			soapBindings.head.publisher.pubServer;
		} else if (b.eContainer instanceof DomainBinding) {
			(b.eContainer as DomainBinding).environment.defaultESB;
		} else if (b.eContainer instanceof ModuleBinding) {
			(b.eContainer as ModuleBinding).environment.defaultESB;
		}
	}
	def dispatch Server getPublishingServer (DomainBinding b) {
		val soapBindings = b.protocol.filter ( typeof (SOAP));
		if (soapBindings.head?.publisher?.pubServer != null) {
			soapBindings.head.publisher.pubServer;
		} else {
			b.environment.defaultESB;
		}
	}
	def dispatch Server getPublishingServer (ModuleBinding b) {
		val soapBindings = b.protocol.filter ( typeof (SOAP));
		if (soapBindings.head?.publisher?.pubServer != null) {
			soapBindings.head.publisher.pubServer;
		} else {
			b.environment.defaultESB;
		}
	}
		
	def dispatch Server getProvidingServer (Binding b) {
		val soapBindings = b.protocol.filter ( typeof (SOAP));
		if (soapBindings.head?.publisher?.pubServer != null) {
			soapBindings.head?.publisher?.pubServer;
		} else if (b.eContainer instanceof DomainBinding) {
			(b.eContainer as DomainBinding).environment.defaultAppServer;
		} else if (b.eContainer instanceof ModuleBinding) {
			(b.eContainer as ModuleBinding).environment.defaultAppServer;
		}
	}
	def dispatch Server getProvidingServer (DomainBinding b) {
		val soapBindings = b.protocol.filter ( typeof (SOAP));
		if (soapBindings.head?.publisher?.pubServer != null) {
			soapBindings.head?.publisher?.pubServer;
		} else {
			b.environment.defaultAppServer;
		}
	}
	def dispatch Server getProvidingServer (ModuleBinding b) {
		val soapBindings = b.protocol.filter ( typeof (SOAP));
		if (soapBindings.head?.publisher?.pubServer != null) {
			soapBindings.head?.publisher?.pubServer;
		} else {
			b.environment.defaultAppServer;
		}
	}
		
	def dispatch String getDefaultESBEndpointAddress (Service s, DomainBinding b) {
		(b.environment.defaultESB as ESB).baseUrl + "/" 
		+ b.subNamespace.findOrgNamespace().shorten() + "/" 
		+ b.subNamespace.name.replaceAll("\\.","/") +"/" + s.name;
	}
		 
	def dispatch String getDefaultAppServerEndpointAddress (Service s, DomainBinding b) {
		(b.environment.defaultAppServer).baseUrl + "/" 
		+ b.subNamespace.findOrgNamespace().shorten() + "/" 
		+ b.subNamespace.name.replaceAll("\\.","/") +"/" + s.name;
	} 
		
	def dispatch String toBindingName (Service s, SOAP p) {
		s.name + p.getPortNamePostfix();
	}
	
	def dispatch String toPortName (Service s, SOAP p) {
		s.name + p.getPortNamePostfix();
	}
	
	def dispatch String toScopedPortName (Service s, SOAP p) {
		s.toPortName(p) + s.getServiceVisibilityName ();
	}
	
	def private String getPortNamePostfix(SOAP p) { 
		switch (p.style) {
		case SOAPStyle::RPCLIT: "SOAPRPClit"
		case SOAPStyle::RPCENC: "SOAPRPCEnc"
		default : "SOAP"	
		}
	}
		
	def dispatch String getServerEndpoint(Service s, Server server, BindingProtocol prot, Module mod) { 
		server.getSOAPHttpEndpointUrl() + "/"
		+ mod.getEndpoint (s.findOrgNamespace(), s.findSubdomain(), s, server);
	}
}