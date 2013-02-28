package org.fornax.soa.binding.query

import com.google.inject.Inject
import java.util.Set
import org.fornax.soa.binding.query.services.ServiceRefBindingDescription
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.moduledsl.moduleDsl.EndpointQualifierRef
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.moduledsl.query.IModuleServiceResolver

/**
 * Resolves Bindings of service/modules as explicit descriptions describing which Binding applies to which service 
 * provided or used by a module.
 */
class BindingResolver {
	
	@Inject IModuleServiceResolver modServiceResolver
	@Inject BindingLookup bindingLookup
	@Inject EndpointQualifierQueries endpointQualifierQuery
	
	/**
	 * Resolve Bindings of all services provided by a module in the given environment. Endpoint qualifiers in the module definition that select used endpoints of used services
	 * are used as additional filter criteria on the selected bindings. For each applicable binding and provided service
	 * a ServiceBindingDescription is returned.
	 * 
	 * @param module 				the module, for which ServiceBindingDescriptions are to be build for all used services
	 * @param targetEnvironment 	the environment a binding applicable for the used service must bind to 
	 * @param endpointQualifier 	selects an endpoint of a service by selecting the most specific binding for 
	 * 								that service having	this effective endpoint qualifier. If, null applicable bindings may
	 * 								have any or no potentially effective endpoint qualifier
	 */
	def Set<ServiceRefBindingDescription> resolveCompatibleProvidedServiceBindings (Module module, Environment targetEnvironment, EndpointQualifierRef endpointQualifier) {
		val candBindings = bindingLookup.findBindingsToCompatibleModuleEnvAndQualifier (module, targetEnvironment, endpointQualifier?.endpointQualifier)
		var Set<ServiceRefBindingDescription> svcBindDescs= newHashSet
		
		val providedServices = modServiceResolver.getAllProvidedServiceRefs(module)
		for (provSvcRef : providedServices) {
			 val svc = modServiceResolver.resolveModuleServiceRef (provSvcRef, targetEnvironment)
			 for (bind : candBindings) {
			 	val specBind = bindingLookup.getMostSpecificBinding(svc, bind, endpointQualifier)
			 	if (specBind != null) {
				 	val curSvcBindDesc = new ServiceRefBindingDescription
				 	curSvcBindDesc.applicableBinding = specBind
				 	curSvcBindDesc.resolvedService = svc
				 	curSvcBindDesc.serviceRef = provSvcRef
				 	curSvcBindDesc.providingModule = module
				 	curSvcBindDesc.endpointQualifier = endpointQualifier?.endpointQualifier
				 	svcBindDescs.add (curSvcBindDesc)
			 	}
			 }
		}
		return svcBindDescs
	}
	
	/**
	 * Resolve Bindings of services used by a module in the given environment. Endpoint qualifiers in the module definition that select used endpoints of used services
	 * are used as additional filter criteria on the selected bindings.  For each applicable binding and provided service
	 * a ServiceBindingDescription is returned.
	 * 
	 * @param module 				the module, for which ServiceBindingDescriptions are to be build for all used services
	 * @param targetEnvironment 	the environment a binding applicable for the used service must bind to 
	 * @param endpointQualifier 	selects an endpoint of a service by selecting the most specific binding for 
	 * 								that service having	this effective endpoint qualifier. If, null applicable bindings may
	 * 								have any or no potentially effective endpoint qualifier
	 */
	def Set<ServiceRefBindingDescription> resolveCompatibleUsedServiceBindings (Module module, Environment targetEnvironment) {
		val usedServiceRefs = modServiceResolver.getAllUsedServiceRefs(module)
		val Set<ServiceRefBindingDescription> svcBindDescs= newHashSet
		for (usedModRef : module.usedModules) {
			val selectingEndpointQualifierRef = if (usedModRef.endpointQualifierRef?.endpointQualifier != null) usedModRef.endpointQualifierRef else module.endpointQualifierRef
			val impModSvcBindDescs = resolveCompatibleProvidedServiceBindings (usedModRef.moduleRef.module, targetEnvironment, selectingEndpointQualifierRef)
			for (curDesc : impModSvcBindDescs.filter (d | usedServiceRefs.contains (d.serviceRef))) {
				val curEndpointQualifiers = endpointQualifierQuery.getPotentialEffectiveEndpointQualifiers (curDesc.applicableBinding)
				if (curDesc.endpointQualifier == null || curEndpointQualifiers.containsEndpointQualifier (curDesc.endpointQualifier)) {
					svcBindDescs.add (curDesc)
				}
			}
			val svcRefsForEndpointQualifier = svcBindDescs.filterNull.map(d|d.serviceRef).toList
			val allImpModSvcBindDescs = resolveCompatibleProvidedServiceBindings (usedModRef.moduleRef.module, targetEnvironment, selectingEndpointQualifierRef)
			for (curBindDesc : allImpModSvcBindDescs) {
				if (!svcRefsForEndpointQualifier.contains(curBindDesc.serviceRef) && (selectingEndpointQualifierRef == null || selectingEndpointQualifierRef.acceptOtherEndpoints)) {
					if (curBindDesc != null && !svcBindDescs.filterNull.map(d|d.serviceRef).toList.contains(curBindDesc.serviceRef)) {
						svcBindDescs.add (curBindDesc)
					}
				}
			}
		}
		for (svcRef : module.usedServices) {
			if (usedServiceRefs.contains(svcRef)) {
				val svc = modServiceResolver.resolveModuleServiceRef (svcRef, targetEnvironment)
				val canditateModules = svcRef.modules.map (m|m.module)
				for (candMod : canditateModules) {
					val selectingEndpointQualifierRef = if (svcRef.endpointQualifierRef != null) svcRef.endpointQualifierRef else module.endpointQualifierRef
					val candBindings = bindingLookup.findBindingsToCompatibleModuleEnvAndQualifier (candMod, targetEnvironment, selectingEndpointQualifierRef?.endpointQualifier)
					for (bind : candBindings) {
					 	var specBind = bindingLookup.getMostSpecificBinding(svc, bind, selectingEndpointQualifierRef)
					 	val curSvcBindDesc = new ServiceRefBindingDescription
					 	curSvcBindDesc.applicableBinding = specBind
					 	curSvcBindDesc.resolvedService = svc
					 	curSvcBindDesc.serviceRef = svcRef
					 	curSvcBindDesc.providingModule = candMod
			 			curSvcBindDesc.endpointQualifier = svcRef.endpointQualifierRef?.endpointQualifier
					 	svcBindDescs.add (curSvcBindDesc)
					}
				}
			}
		}
		return svcBindDescs
	}
	
	
}