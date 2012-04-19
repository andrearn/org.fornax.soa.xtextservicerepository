package org.fornax.soa.bindingdsl.generator.templates.soap

import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
import com.google.inject.Inject
import org.fornax.soa.basedsl.generator.version.VersionQualifierExtensions
import org.fornax.soa.servicedsl.generator.query.namespace.NamespaceQuery
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions
import org.fornax.soa.environmentdsl.generator.EndpointResolver
import org.fornax.soa.environmentDsl.Server
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.bindingDsl.DomainBinding
import org.fornax.soa.bindingDsl.ServiceBinding
import org.eclipse.emf.ecore.EObject
import org.fornax.soa.bindingDsl.SOAP

/*
 * Resolves SOAP endpoint addresses according to the naming conventions 
 */
class SoapEndpointAddressResolver {

	@Inject extension VersionQualifierExtensions
	@Inject extension NamespaceQuery
	@Inject extension SchemaNamespaceExtensions
	@Inject extension BindingExtensions
	@Inject extension SoapVendorBindingsResolver
	@Inject extension EndpointResolver
	@Inject extension SoapBindingResolver

	def dispatch String toEndpointAddress (Service s, Server server, BindingProtocol prot, Module mod) { 
		server.getSOAPHttpEndpointUrl() 
		+ mod.toEndpointAddressPath (s.findOrgNamespace(), s.findSubdomain(), s, server);
	}
	
	def dispatch String toEndpointAddress (Service s, Server server, BindingProtocol prot, DomainBinding bind) {
		server.getSOAPHttpEndpointUrl() 
		+ bind.toEndpointAddressPath (prot, s.findOrgNamespace(), s.findSubdomain(), s, server);
	}
	def dispatch String toEndpointAddress (Service s, Server server, BindingProtocol prot, ServiceBinding bind) { 
		server.getSOAPHttpEndpointUrl() 
		+ bind.toEndpointAddressPath (prot, s.findOrgNamespace(), s.findSubdomain(), s, server);
	}

	
	def dispatch String toEndpointAddress (Service s, EObject b) {
		""
	}
	
	def dispatch String toEndpointAddress (Service s, DomainBinding b) {
		if (b.serviceBinding.map (svcBind|svcBind.service).contains(s)) { 
			toEndpointAddress(s, s.getServiceBinding(b))
		} else {
			s.toEndpointAddress (b.getPublishingServer(), b.publisherProtocols.filter (typeof (SOAP)).head, b)
		}
	}	
	
	def dispatch String toEndpointAddress(Service s, ServiceBinding b) {
		s.toEndpointAddress (b.getPublishingServer(), b.publisherProtocols.filter (typeof (SOAP)).head, b);
	}
	



	def dispatch String toProviderEndpointAddress(Service s, EObject b) {
	}
	
	def dispatch String toProviderEndpointAddress(Service s, DomainBinding b) {
		if (b.serviceBinding.map (svcBind | svcBind.service).contains (s)) {
			toProviderEndpointAddress(s, s.getServiceBinding(b))
		} else {
			s.toProviderEndpointAddress (b.getProvidingServer(), b.providerProtocols.filter (typeof (SOAP)).head, b)
		}
	}
		
	def dispatch String toProviderEndpointAddress (Service s, ServiceBinding b) {
		s.toProviderEndpointAddress (b.getProvidingServer(), b.providerProtocols.filter (typeof (SOAP)).head, b);
	}
	
	def dispatch String toProviderEndpointAddress(Service s, Server server, BindingProtocol prot, DomainBinding bind) {
		server.getSOAPHttpEndpointUrl()
		+ bind.toProviderEndpointAddressPath (prot, s.findOrgNamespace(), s.findSubdomain(), s, server);
	}

	def dispatch String toProviderEndpointAddress(Service s, Server server, BindingProtocol prot, ServiceBinding bind) { 
		server.getSOAPHttpEndpointUrl()
		+ bind.toProviderEndpointAddressPath (prot, s.findOrgNamespace(), s.findSubdomain(), s, server);
	}
	
}