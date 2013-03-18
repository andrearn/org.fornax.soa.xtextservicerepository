package org.fornax.soa.binding.query

import com.google.inject.Inject
import java.util.Set
import org.fornax.soa.binding.query.services.ModuleServiceRefBindingDescription
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.moduledsl.moduleDsl.EndpointQualifierRef
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.moduledsl.query.IModuleServiceResolver
import org.fornax.soa.moduledsl.query.IModuleReferenceResolver
import org.fornax.soa.service.query.VersionQueries
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle
import java.util.logging.Logger
import org.fornax.soa.moduledsl.moduleDsl.ModuleRef
import org.fornax.soa.moduledsl.moduleDsl.AbstractServiceRef

/**
 * Resolves Bindings of service/modules as explicit descriptions describing which Binding applies to which service 
 * provided or used by a module.
 */
class DefaultModuleServiceRefBindingResolver implements IModuleServiceRefBindingResolver {
	
	@Inject IModuleServiceResolver modServiceResolver
	@Inject BindingLookup bindingLookup
	@Inject EndpointQualifierQueries endpointQualifierQuery
	@Inject IModuleReferenceResolver modRefResolver
	@Inject Logger log
	
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
	override Set<ModuleServiceRefBindingDescription> resolveCompatibleProvidedServiceBindings (Module module, Environment targetEnvironment, EndpointQualifierRef endpointQualifier) {
		val candBindings = bindingLookup.findBindingsToCompatibleModuleEnvAndQualifier (module, targetEnvironment, endpointQualifier?.endpointQualifier)
		var Set<ModuleServiceRefBindingDescription> svcBindDescs= newHashSet
		
		val providedServices = modServiceResolver.getAllProvidedServiceRefs(module)
		for (provSvcRef : providedServices) {
			 val svc = modServiceResolver.resolveModuleServiceRef (provSvcRef, targetEnvironment)
			 for (bind : candBindings) {
			 	val specBind = bindingLookup.getMostSpecificBinding(svc, bind, endpointQualifier)
			 	if (specBind != null) {
				 	val curSvcBindDesc = new ModuleServiceRefBindingDescription
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
	override Set<ModuleServiceRefBindingDescription> resolveCompatibleUsedServiceBindings (Module module, Environment targetEnvironment, EndpointQualifierRef endpointQualifierRef) {
		val usedServiceRefs = modServiceResolver.getAllUsedServiceRefs(module)
		val Set<ModuleServiceRefBindingDescription> svcBindDescs= newHashSet
		resolveModuleRefs (module, usedServiceRefs, targetEnvironment, endpointQualifierRef, svcBindDescs)
		resolveServicesRefs (module, usedServiceRefs, targetEnvironment, endpointQualifierRef, svcBindDescs)
		return svcBindDescs
	}

	def private resolveModuleRefs (Module module, Set<? extends AbstractServiceRef> usedServiceRefs, Environment targetEnvironment, EndpointQualifierRef endpointQualifierRef, Set<ModuleServiceRefBindingDescription> svcBindDescs) {
		val lifecycle = module.state.eContainer as Lifecycle
		for (usedModRef : module.usedModules) {
			val selectingEndpointQualifierRef = getSelectingEndpointQualifier (usedModRef, module, endpointQualifierRef)
			val providerModule = modRefResolver.resolveModuleRef (usedModRef, targetEnvironment, lifecycle, selectingEndpointQualifierRef, null)
			val impModSvcBindDescs = resolveCompatibleProvidedServiceBindings (providerModule, targetEnvironment, selectingEndpointQualifierRef)
			
			for (curDesc : impModSvcBindDescs.filter (d | usedServiceRefs.contains (d.getServiceRef))) {
				val curEndpointQualifiers = endpointQualifierQuery.getPotentialEffectiveEndpointQualifiers (curDesc.getApplicableBinding)
				if (curDesc.getEndpointQualifier == null || curEndpointQualifiers.containsEndpointQualifier (curDesc.getEndpointQualifier)) {
					svcBindDescs.add (curDesc)
				}
			}
			
			val svcRefsForEndpointQualifier = svcBindDescs.filterNull.map(d|d.getServiceRef).toList
			val allImpModSvcBindDescs = resolveCompatibleProvidedServiceBindings (usedModRef.moduleRef.module, targetEnvironment, selectingEndpointQualifierRef)
			
			for (curBindDesc : allImpModSvcBindDescs) {
				if (!svcRefsForEndpointQualifier.contains(curBindDesc.getServiceRef) && (selectingEndpointQualifierRef == null || selectingEndpointQualifierRef.acceptOtherEndpoints)) {
					if (curBindDesc != null && !svcBindDescs.filterNull.map(d|d.getServiceRef).toList.contains(curBindDesc.getServiceRef)) {
						svcBindDescs.add (curBindDesc)
					}
				}
			}
		}
	}
	
	def private resolveServicesRefs (Module module, Set<? extends AbstractServiceRef> usedServiceRefs, Environment targetEnvironment, EndpointQualifierRef endpointQualifierRef, Set<ModuleServiceRefBindingDescription> svcBindDescs) {
		val lifecycle = module.state.eContainer as Lifecycle
		for (svcRef : module.usedServices) {
			if (usedServiceRefs.contains(svcRef)) {
				val svc = modServiceResolver.resolveModuleServiceRef (svcRef, targetEnvironment)
				val canditateModules = svcRef.modules.map (m|modRefResolver.resolveModuleServiceRef(m, targetEnvironment, lifecycle))
				
				for (candMod : canditateModules) {
					val selectingEndpointQualifierRef = if (svcRef.endpointQualifierRef != null) svcRef.endpointQualifierRef else module.endpointQualifierRef
					val candBindings = bindingLookup.findBindingsToCompatibleModuleEnvAndQualifier (candMod, targetEnvironment, selectingEndpointQualifierRef?.endpointQualifier)
				
					for (bind : candBindings) {
					 	var specBind = bindingLookup.getMostSpecificBinding(svc, bind, selectingEndpointQualifierRef)
					 	val curSvcBindDesc = new ModuleServiceRefBindingDescription
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
	}
		
	def private EndpointQualifierRef getSelectingEndpointQualifier (ModuleRef usedModRef, Module module, EndpointQualifierRef endpointQualifierRef) {
		val moduleEndpointQualifierRef = 	if (usedModRef.endpointQualifierRef?.endpointQualifier != null) 
													usedModRef.endpointQualifierRef 
												else 
													module.endpointQualifierRef
		val selectingEndpointQualifierRef = if (endpointQualifierRef != null 
														&& moduleEndpointQualifierRef?.endpointQualifier?.name != null
												) {
													if (!endpointQualifierRef.endpointQualifier.name.equals(moduleEndpointQualifierRef?.endpointQualifier?.name)) {
														log.warning ("The modules endpoint qualifier " + 
															moduleEndpointQualifierRef?.endpointQualifier?.name + 
															" has been overridden with the endpoint qualifier " + 
															endpointQualifierRef.endpointQualifier.name
														)
													}
													usedModRef.endpointQualifierRef 
												} else if (endpointQualifierRef != null)  {
													endpointQualifierRef 
												} else { 
													module.endpointQualifierRef
												}
		return selectingEndpointQualifierRef	
	}
	
}