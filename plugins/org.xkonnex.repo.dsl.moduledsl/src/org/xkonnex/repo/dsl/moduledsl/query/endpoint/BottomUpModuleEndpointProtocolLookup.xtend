package org.xkonnex.repo.dsl.moduledsl.query.endpoint

import org.xkonnex.repo.dsl.moduledsl.query.endpoint.IModuleEndpointProtocolLookup
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.IModuleEndpointProtocol
import org.xkonnex.repo.dsl.moduledsl.query.endpoint.IProvidingEndpointResolver
import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.xkonnex.repo.dsl.moduledsl.query.IModuleServiceResolver
import org.xkonnex.repo.dsl.moduledsl.query.IModuleOperationResolver
import org.xkonnex.repo.dsl.basedsl.ext.infer.IComponentInferrer
import org.eclipse.xtext.EcoreUtil2
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Channel
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.AbstractOperation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ResourceOperation

class BottomUpModuleEndpointProtocolLookup implements IModuleEndpointProtocolLookup {
	
	@Inject private IProvidingEndpointResolver endpointResolver
	@Inject IModuleServiceResolver serviceResolver
	@Inject IModuleOperationResolver operationResolver
	@Inject IComponentInferrer componentInferrer

	override collectEndpointProtocolHierarchyByType(Service service, Module module, IModuleEndpointProtocol protocol) {
		val specEndpoint = endpointResolver.getMostSpecificProvidingEndpointByType(service, module, protocol)
		var List<IModuleEndpointProtocol> hierarchy = newArrayList()
		val IModuleEndpointProtocol prot = componentInferrer.inferComponent(specEndpoint.endpointProtocol)
		if (prot !== null && protocol.class.isAssignableFrom(prot.class)) {
			hierarchy+=prot
		}
		return hierarchy
	}
	
	override collectEndpointProtocolHierarchyByType(AbstractOperation operation, Module module, IModuleEndpointProtocol protocol) {
		collectEndpointProtocolHierarchyByTypeInternal(operation, module, protocol)
	}
	private def dispatch collectEndpointProtocolHierarchyByTypeInternal(AbstractOperation operation, Module module, IModuleEndpointProtocol protocol) {
	}
	private def dispatch collectEndpointProtocolHierarchyByTypeInternal(Operation operation, Module module, IModuleEndpointProtocol protocol) {
		val specEndpoint = endpointResolver.getMostSpecificProvidingEndpointByType(operation, module, protocol)
		var List<IModuleEndpointProtocol> hierarchy = newArrayList()
		val IModuleEndpointProtocol prot = componentInferrer.inferComponent(specEndpoint.endpointProtocol)
		if (prot !== null && protocol.class.isAssignableFrom(prot.class)) {
			hierarchy+=prot
		}
		val svc = EcoreUtil2.getContainerOfType(operation, typeof(Service))
		hierarchy += collectEndpointProtocolHierarchyByType(svc, module, protocol)
		return hierarchy
	}
	private def dispatch collectEndpointProtocolHierarchyByTypeInternal(ResourceOperation operation, Module module, IModuleEndpointProtocol protocol) {
		val specEndpoint = endpointResolver.getMostSpecificProvidingEndpointByType(operation, module, protocol)
		var List<IModuleEndpointProtocol> hierarchy = newArrayList()
		val IModuleEndpointProtocol prot = componentInferrer.inferComponent(specEndpoint.endpointProtocol)
		if (prot !== null && protocol.class.isAssignableFrom(prot.class)) {
			hierarchy+=prot
		}
		val res = EcoreUtil2.getContainerOfType(operation, typeof(Resource))
		hierarchy += collectEndpointProtocolHierarchyByType(res, module, protocol)
		return hierarchy
	}
	
	override collectEndpointProtocolHierarchyByType(Channel channel, Module module, IModuleEndpointProtocol protocol) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override collectEndpointProtocolHierarchyByType(Resource resource, Module module, IModuleEndpointProtocol protocol) {
		val specEndpoint = endpointResolver.getMostSpecificProvidingEndpointByType(resource, module, protocol)
		var List<IModuleEndpointProtocol> hierarchy = newArrayList()
		val IModuleEndpointProtocol prot = componentInferrer.inferComponent(specEndpoint.endpointProtocol)
		if (prot !== null && protocol.class.isAssignableFrom(prot.class)) {
			hierarchy+=prot
		}
		return hierarchy
	}
	
}