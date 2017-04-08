package org.xkonnex.repo.dsl.bindingdsl.binding.query.operation

import java.util.HashMap
import java.util.List
import java.util.Map
import javax.inject.Inject
import org.xkonnex.repo.dsl.basedsl.ext.infer.IComponentInferrer
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ExtensibleProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.REST
import org.xkonnex.repo.dsl.bindingdsl.model.IEffectiveBindingBuilder
import org.xkonnex.repo.dsl.moduledsl.model.IEffectiveProvidingEndpointBuilder
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Verb
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ResourceOperation

class OperationBindingQueries {
	
	@Inject extension IComponentInferrer
	@Inject IEffectiveBindingBuilder bindingBuilder
	@Inject IEffectiveProvidingEndpointBuilder endpointBuilder
	
	def Map<Verb, List<Operation>> getRESTOperationsByVerb(Service service, ModuleBinding binding) {
		var HashMap<Verb, List<Operation>> ops = new HashMap<Verb, List<Operation>>()
		for (op : service.operations) {
			val effBind = bindingBuilder.createEffectiveBinding(op, binding)
			val prot = effBind.protocol.filter(typeof(ExtensibleProtocol)).filter[type.identifier == typeof(REST).canonicalName].head
			val REST restProt = prot.inferComponent
			val endpoint = endpointBuilder.createEffectiveProvidingEndpointForClazz(op, binding.module.module, typeof(org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST))
			val org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST restEndpoint = endpoint?.endpointProtocol?.inferComponent
			val verb = if (restProt.verb !== null) restProt.verb else if (restEndpoint?.verb !== null) restEndpoint.verb else Verb.POST
			var registerdOps = ops.get(verb)
			if (registerdOps === null) {
				registerdOps = newArrayList(op)
			} else {
				registerdOps += op
			}
			ops.put(verb, registerdOps)
		}
		ops
	}
	
	
	def Map<Verb, List<ResourceOperation>> getRESTOperationsByVerb(Resource resource, ModuleBinding binding) {
		var HashMap<Verb, List<ResourceOperation>> ops = new HashMap<Verb, List<ResourceOperation>>()
		for (op : resource.operations) {
			val effBind = bindingBuilder.createEffectiveBinding(op, binding)
			val prot = effBind.protocol.filter(typeof(ExtensibleProtocol)).filter[type.identifier == typeof(REST).canonicalName].head
			val REST restProt = prot.inferComponent
			val endpoint = endpointBuilder.createEffectiveProvidingEndpointForClazz(op, binding.module.module, typeof(org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST))
			val org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST restEndpoint = endpoint.endpointProtocol.inferComponent
			val verb = if (restProt.verb !== null) restProt.verb else if (restEndpoint.verb !== null) restEndpoint.verb else Verb.POST
			var registerdOps = ops.get(verb)
			if (registerdOps === null) {
				registerdOps = newArrayList(op)
			} else {
				registerdOps += op
			}
			ops.put(verb, registerdOps)
		}
		ops
	}
}