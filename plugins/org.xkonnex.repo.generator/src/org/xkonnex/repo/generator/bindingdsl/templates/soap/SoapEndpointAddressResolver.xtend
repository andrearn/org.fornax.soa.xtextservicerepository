package org.xkonnex.repo.generator.bindingdsl.templates.soap

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.BindingConnectorResolver
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.EnvironmentBindingResolver
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAP
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ServiceBinding
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Server
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.generator.bindingdsl.templates.BindingExtensions
import org.xkonnex.repo.generator.environmentdsl.EndpointResolver

/*
 * Resolves SOAP endpoint addresses according to the naming conventions 
 */
class SoapEndpointAddressResolver {

	@Inject extension BindingExtensions
	@Inject extension SoapVendorEndpointAddressResolver
	@Inject extension EndpointResolver
	@Inject extension EnvironmentBindingResolver
	@Inject BindingConnectorResolver connectorResolver

	def dispatch String toEndpointAddress (Service service, Server server, BindingProtocol prot, Module mod) { 
		val bind = prot.eContainer as Binding
		val connector = connectorResolver.resolveConnector(server, bind, prot);
		connector.getEndpointUrl() 
		+ mod.toEndpointAddressPath (service, server, bind, prot);
	}
	
	/*
	 * Calculate the endpoint address assuming, that it is a public endpoint. 
	 * Public endpoints are usually located on an ESB
	 */
	def dispatch String toEndpointAddress (Service service, Server server, BindingProtocol prot, ServiceBinding bind) { 
		val connector = connectorResolver.resolveConnector(server, bind, prot);
		connector.getEndpointUrl() 
		+ bind.toEndpointAddressPath (prot, service, server);
	}

	
	def dispatch String toEndpointAddress (Service service, EObject binding) {
		""
	}
		
	def dispatch String toEndpointAddress(Service service, ServiceBinding binding) {
		val server = binding.resolveServer
		val prot = binding.getEndpointProtocols.filter (typeof (SOAP)).head
		service.toEndpointAddress (server, prot, binding);
	}
		
}