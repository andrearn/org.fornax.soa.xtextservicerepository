package org.xkonnex.repo.dsl.moduledsl.query

import com.google.inject.Inject
import java.util.List
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ServiceRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation

class DefaultModuleOperationResolver implements IModuleOperationResolver {
	
	@Inject IModuleServiceResolver serviceResolver
	
	override getAllProvidedOperationRefs(Module module) {
		val serviceRefs = serviceResolver.getAllProvidedServiceRefs(module)
		val opRefs = serviceRefs.filter(typeof(ServiceRef)).map[it.operations].flatten.toList
		return opRefs
	}
	
	override getAllProvidedOperations(Module module) {
		val serviceRefs = serviceResolver.getAllProvidedServiceRefs(module)
		var List<Operation> ops = newArrayList()
		for (serviceRef : serviceRefs) {
			val svc = serviceRef.service
			for (op : svc.operations) {
				ops+=op
			}
		}
		return ops
	}
	
}