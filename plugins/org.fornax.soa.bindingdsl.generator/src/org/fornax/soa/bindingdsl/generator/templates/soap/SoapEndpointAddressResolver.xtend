package org.fornax.soa.bindingdsl.generator.templates.soap

import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
import com.google.inject.Inject
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.service.query.namespace.NamespaceQuery
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions
import org.fornax.soa.environmentdsl.generator.EndpointResolver
import org.fornax.soa.environmentDsl.Server
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.bindingDsl.ServiceBinding
import org.eclipse.emf.ecore.EObject
import org.fornax.soa.bindingDsl.SOAP
import org.fornax.soa.bindingdsl.generator.templates.BindingConnectorResolver
import org.fornax.soa.bindingDsl.Binding

/*
 * Resolves SOAP endpoint addresses according to the naming conventions 
 */
class SoapEndpointAddressResolver {

	@Inject extension NamespaceQuery
	@Inject extension BindingExtensions
	@Inject extension SoapVendorBindingsResolver
	@Inject extension EndpointResolver
	@Inject extension SoapBindingResolver
	@Inject BindingConnectorResolver connectorResolver

	def dispatch String toEndpointAddress (Service service, Server server, BindingProtocol prot, Module mod) { 
		val bind = prot.eContainer as Binding
		val connector = connectorResolver.resolveConnector(server, bind, prot);
		server.getSOAPHttpEndpointUrl() 
		+ mod.toEndpointAddressPath (service.findOrgNamespace(), service.findSubdomain(), service, server, bind, prot);
	}
	
	/*
	 * Calculate the endpoint address assuming, that it is a public endpoint. 
	 * Public endpoints are usually located on an ESB
	 */
	def dispatch String toEndpointAddress (Service service, Server server, BindingProtocol prot, ServiceBinding bind) { 
		val connector = connectorResolver.resolveConnector(server, bind, prot);
		server.getSOAPHttpEndpointUrl(connector) 
		+ bind.toEndpointAddressPath (prot, service.findOrgNamespace(), service.findSubdomain(), service, server);
	}

	
	def dispatch String toEndpointAddress (Service service, EObject binding) {
		""
	}
		
	def dispatch String toEndpointAddress(Service service, ServiceBinding binding) {
		val server = binding.getPublishingServer()
		val prot = binding.publisherProtocols.filter (typeof (SOAP)).head
		service.toEndpointAddress (server, prot, binding);
	}
		
}