package org.xkonnex.repo.generator.bindingdsl.rest

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
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.generator.environmentdsl.EndpointResolver
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.AbstractOperation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ResourceOperation

class RESTEndpointAddressResolver {
	
	@Inject extension EnvironmentBindingResolver
	@Inject extension IComponentInferrer
	@Inject extension EndpointResolver
	@Inject BindingConnectorResolver connectorResolver
	@Inject IContextRootProvider ctxRootProvider
	@Inject extension RESTVendorEndpointResolver vendorEndpointResolver
	
	def String getEndpointBaseAddress(Service service, EffectiveBinding binding, Module module) {
		val server = binding.resolveServer
		val prot = binding.protocol.filter (typeof (ExtensibleProtocol)).filter[inferComponent instanceof REST].head
		service.toEndpointAddress (server, prot, binding)
		
	}
	def String toEndpointAddress (Service service, Server server, EffectiveBinding binding, ExtensibleProtocol prot, Module mod) { 
		val connector = connectorResolver.resolveConnector(server, binding, prot);
		connector.getEndpointUrl() 
		+ mod.toEndpointAddressPath (service, server, binding, prot)
	}
	
	def dispatch String getOperationPath(AbstractOperation operation, EffectiveBinding binding) {
		val prot = binding.protocol.filter (typeof (ExtensibleProtocol)).filter[type.identifier == typeof(REST).canonicalName].head
		val REST restProt = prot.inferComponent
		if (!restProt.path.nullOrEmpty) restProt.path else operation.name
	}
	def dispatch String getOperationPath(ResourceOperation operation, EffectiveBinding binding) {
		val prot = binding.protocol.filter (typeof (ExtensibleProtocol)).filter[type.identifier == typeof(REST).canonicalName].head
		val REST restProt = prot.inferComponent
		if (!restProt.path.nullOrEmpty) restProt.path else operation.path
	}

	/**
	 * Calculate the endpoint address assuming, that it is a public endpoint. 
	 * Public endpoints are usually located on an ESB or API gateway
	 * 
	 * @param service a Service
	 * @param server the server where Service is deployed
	 * @param prot the protocol specification
	 * @param bind the efective binding
	 * @return the endpoint address
	 */
	def String toEndpointAddress (Service service, Server server, ExtensibleProtocol prot, EffectiveBinding bind) {
		val connector = connectorResolver.resolveConnector(server, bind, prot);
		connector.getEndpointUrl()
		+ vendorEndpointResolver.toEndpointAddressPath (bind, prot, service, server);
	}

	/**
	 * Calculate the endpoint address assuming, that it is a public endpoint. 
	 * Public endpoints are usually located on an ESB or API gateway
	 * 
	 * @param resource a Resource
	 * @param server the server where Resource is deployed
	 * @param prot the protocol specification
	 * @param bind the efective binding
	 * @return the endpoint address
	 */
	def String toEndpointAddress (Resource resource, Server server, ExtensibleProtocol prot, EffectiveBinding bind) {
		val connector = connectorResolver.resolveConnector(server, bind, prot);
		connector.getEndpointUrl()
		+ vendorEndpointResolver.toEndpointAddressPath (bind, prot, resource, server);
	}
	
}