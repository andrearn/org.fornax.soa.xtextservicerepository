package org.xkonnex.repo.generator.bindingdsl.rest.wadl

import com.google.inject.Inject
import org.xkonnex.repo.dsl.basedsl.ext.infer.IComponentInferrer
import org.xkonnex.repo.dsl.bindingdsl.binding.IContextRootProvider
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.BindingConnectorResolver
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.EnvironmentBindingResolver
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ExtensibleProtocol
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.REST
import org.xkonnex.repo.dsl.bindingdsl.model.EffectiveBinding
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Server
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.generator.environmentdsl.EndpointResolver

class RESTEndpointAddressResolver {
	
	@Inject extension EnvironmentBindingResolver
	@Inject extension IComponentInferrer
	@Inject extension EndpointResolver
	@Inject BindingConnectorResolver connectorResolver
	@Inject IContextRootProvider ctxRootProvider
	@Inject extension RESTVendorEndpointResolver vendorEndpointResolver
	
	def String getEndpointBaseAddress(Service service, EffectiveBinding binding, Module module) {
//		val baseEx = "http://api.search.yahoo.com/NewsSearchService/V1/"
		val server = binding.resolveServer
		val prot = binding.protocol.filter (typeof (ExtensibleProtocol)).filter[inferComponent instanceof REST].head
		service.toEndpointAddress (server, prot, binding);
		
	}
	def dispatch String toEndpointAddress (Service service, Server server, EffectiveBinding binding, ExtensibleProtocol prot, Module mod) { 
		val connector = connectorResolver.resolveConnector(server, binding, prot);
		server.getSOAPHttpEndpointUrl(connector) 
		+ mod.toEndpointAddressPath (service, server, binding, prot);
	}
	
	def String getOperationPath(Operation operation, EffectiveBinding binding) {
		
	}

	/*
	 * Calculate the endpoint address assuming, that it is a public endpoint. 
	 * Public endpoints are usually located on an ESB
	 */
	def String toEndpointAddress (Service service, Server server, ExtensibleProtocol prot, EffectiveBinding bind) {
//		val modEndpoint  
		val connector = connectorResolver.resolveConnector(server, bind, prot);
		server.getSOAPHttpEndpointUrl(connector) 
		+ vendorEndpointResolver.toEndpointAddressPath (bind, prot, service, server);
	}
	
}