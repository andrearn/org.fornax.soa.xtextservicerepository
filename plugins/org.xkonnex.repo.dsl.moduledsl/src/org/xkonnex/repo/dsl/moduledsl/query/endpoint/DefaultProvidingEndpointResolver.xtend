package org.xkonnex.repo.dsl.moduledsl.query.endpoint

import com.google.inject.Inject
import org.eclipse.xtext.EcoreUtil2
import org.xkonnex.repo.dsl.basedsl.ext.infer.IComponentInferrer
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.IModuleEndpointProtocol
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ServiceRef
import org.xkonnex.repo.dsl.moduledsl.query.IModuleOperationResolver
import org.xkonnex.repo.dsl.moduledsl.query.IModuleServiceResolver
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Channel
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ProvidingEndpointConfig
import java.util.List
import org.eclipse.emf.ecore.EObject

class DefaultProvidingEndpointResolver implements IProvidingEndpointResolver {
	
	@Inject IModuleServiceResolver serviceResolver
	@Inject IModuleOperationResolver operationResolver
	@Inject IComponentInferrer componentInferrer
	@Inject private IProvidingEndpointResolver endpointResolver
	
	
	override getMostSpecificProvidingEndpointByType(Service service, Module module, IModuleEndpointProtocol protocol) {
		for (ep : getServiceProvidingEndpoints(service, module)) {
			val IModuleEndpointProtocol prot = componentInferrer.inferComponent(ep.endpointProtocol.type)
			if (protocol.class.isAssignableFrom(prot.class)) {
				return ep
			}
		}
		return null
	}
	
	override getMostSpecificProvidingEndpointByType(Operation operation, Module module, IModuleEndpointProtocol protocol) {
		for (ep : getOperationProvidingEndpoints(operation, module)) {
			val IModuleEndpointProtocol prot = componentInferrer.inferComponent(ep.endpointProtocol.type)
			if (protocol.class.isAssignableFrom(prot.class)) {
				return ep
			}
		}
		return null
	}
	
	override getMostSpecificProvidingEndpointByType(Channel channel, Module module, IModuleEndpointProtocol protocol) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getOperationProvidingEndpoints(Operation operation, Module module) {
		val opRefs = operationResolver.getAllProvidedOperationRefs(module)
		val selectedOpRefs = opRefs?.filter[it.operation == operation]
		val opProvEndpoints = selectedOpRefs?.head?.providingEndpoints
		if (!opProvEndpoints.nullOrEmpty) {
			return opProvEndpoints
		} else {
			val svc = EcoreUtil2.getContainerOfType(operation, typeof(Service))
			return svc.getServiceProvidingEndpoints(module)
		}
	}
	
	override getServiceProvidingEndpoints(Service service, Module module) {
		val svcRefs = serviceResolver.getAllProvidedServiceRefs(module)
		val selectedSvcRefs = svcRefs?.filter[it.service == service]?.filter(typeof(ServiceRef))
		return selectedSvcRefs?.head?.providingEndpoints
	}
	
	override getMostSpecificProvidingEndpointConfig(Service service, Module module) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getMostSpecificProvidingEndpointConfig(Operation operation, Module module) {
		val opRefs = operationResolver.getAllProvidedOperationRefs(module)
		val selectedOpRefs = opRefs?.filter[it.operation == operation]
		val opProvEndpointConfig = selectedOpRefs?.head
		if (opProvEndpointConfig != null) {
			return opProvEndpointConfig
		}else {
			val svc = EcoreUtil2.getContainerOfType(operation, typeof(Service))
			val svcRefs = serviceResolver.getAllProvidedServiceRefs(module)
			val svcProvRef = svcRefs?.filter[it.service == svc]
			svcProvRef?.head as ProvidingEndpointConfig
		}		
	}
	
	override getMostSpecificProvidingEndpointConfig(Channel channel, Module module) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override collectProvidingEndpointHierarchyByType(Service service, Module module, IModuleEndpointProtocol protocol) {
		val specEndpoint = endpointResolver.getMostSpecificProvidingEndpointByType(service, module, protocol)
		var List<EObject> hierarchy = newArrayList()
		val IModuleEndpointProtocol prot = componentInferrer.inferComponent(specEndpoint.endpointProtocol)
		if (prot != null && protocol.class.isAssignableFrom(prot.class)) {
			hierarchy+=specEndpoint as EObject
		}
		return hierarchy
	}
	
	override collectProvidingEndpointHierarchyByType(Operation operation, Module module, IModuleEndpointProtocol protocol) {
		val specEndpoint = endpointResolver.getMostSpecificProvidingEndpointByType(operation, module, protocol)
		var List<EObject> hierarchy = newArrayList()
		val IModuleEndpointProtocol prot = componentInferrer.inferComponent(specEndpoint.endpointProtocol)
		if (prot != null && protocol.class.isAssignableFrom(prot.class)) {
			hierarchy+=specEndpoint as EObject
		}
		val svc = EcoreUtil2.getContainerOfType(operation, typeof(Service))
		hierarchy += collectProvidingEndpointHierarchyByType(svc, module, protocol)
		return hierarchy
	}
	
	override collectProvidingEndpointHierarchyByType(Channel channel, Module module, IModuleEndpointProtocol protocol) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	
}