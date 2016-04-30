package org.xkonnex.repo.dsl.bindingdsl.binding.query

import com.google.inject.Inject
import java.util.Set
import org.xkonnex.repo.dsl.bindingdsl.binding.query.services.ServiceRefBindingDescription
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointQualifierRef
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.moduledsl.query.IModuleServiceResolver
import org.xkonnex.repo.dsl.moduledsl.query.IModuleReferenceResolver
import org.xkonnex.repo.dsl.servicedsl.service.query.VersionQueries
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.IStateMatcher
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Lifecycle
import java.util.logging.Logger
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleRef
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.AbstractServiceRef
import org.xkonnex.repo.dsl.bindingdsl.binding.query.ModuleRefServiceBindingDescription
import java.util.Mapimport org.xkonnex.repo.dsl.bindingdsl.model.IEffectiveBindingBuilder

/**
 * Resolves Bindings of services/modules as explicit descriptions describing which Binding applies to which service 
 * provided or used by a module.
 */
class DefaultModuleRefServiceBindingResolver implements IModuleRefServiceBindingResolver {
	
	@Inject IModuleServiceResolver modServiceResolver
	@Inject BindingLookup bindingLookup
	@Inject EndpointQualifierQueries endpointQualifierQuery
	@Inject IModuleReferenceResolver modRefResolver
	@Inject IEffectiveBindingBuilder bindingBuilder
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
	override ModuleRefServiceBindingDescription resolveProvidedServiceBindings (Module module, Environment targetEnvironment, EndpointQualifierRef endpointQualifier) {
		val candBindings = bindingLookup.findApplicableBindingsToModuleByEnvAndQualifier (module, targetEnvironment, endpointQualifier?.endpointQualifier)
		var Set<ServiceRefBindingDescription> svcBindDescs= newHashSet
		
		val providedServices = modServiceResolver.getAllProvidedServiceRefs(module)
		for (provSvcRef : providedServices) {
			 val svc = modServiceResolver.resolveModuleServiceRef (provSvcRef, targetEnvironment)
			 for (bind : candBindings) {
//			 	val specBind = bindingLookup.getMostSpecificBinding(svc, bind, endpointQualifier)
			 	val specBind = bindingBuilder.createEffectiveBinding(svc, bind, endpointQualifier)
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
		var modRefBindingDescription = new ModuleRefServiceBindingDescription
		modRefBindingDescription.module = module
		modRefBindingDescription.endpointQualifier = endpointQualifier?.endpointQualifier
		modRefBindingDescription.serviceRefDescriptions.addAll(svcBindDescs) 
		return modRefBindingDescription
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
	override Set<ModuleRefServiceBindingDescription> resolveUsedServiceBindings (Module module, Environment targetEnvironment, EndpointQualifierRef endpointQualifierRef) {
		val usedServiceRefs = modServiceResolver.getAllUsedServiceRefs(module)
		val Set<ModuleRefServiceBindingDescription> modBindDescs = newHashSet
		val Map<Module, Set<ServiceRefBindingDescription>> svcBindDescs= newHashMap
		resolveModuleRefs (module, usedServiceRefs, targetEnvironment, endpointQualifierRef, svcBindDescs)
		resolveServicesRefs (module, usedServiceRefs, targetEnvironment, endpointQualifierRef, svcBindDescs)
		for (modKey : svcBindDescs.keySet) {
			var ModuleRefServiceBindingDescription curBindDesc = null
			if (modBindDescs.exists(b | b.module == modKey)) {
				curBindDesc = modBindDescs.findFirst (bindDesc | bindDesc.module == modKey)
			} else {
				curBindDesc = new ModuleRefServiceBindingDescription
			}
			val curSvcBind = svcBindDescs.get (modKey)
			curBindDesc.serviceRefDescriptions.addAll(curSvcBind)
			curBindDesc.module = modKey
			if (curBindDesc.endpointQualifier == null) {
				curBindDesc.endpointQualifier = curSvcBind.map (b|b.endpointQualifier).head
			}
			modBindDescs.add(curBindDesc)
		}
		return modBindDescs
	}

	def private resolveModuleRefs (Module module, Set<? extends AbstractServiceRef> usedServiceRefs, Environment targetEnvironment, EndpointQualifierRef endpointQualifierRef, Map<Module, Set<ServiceRefBindingDescription>> svcBindDescs) {
		val lifecycle = module.state.eContainer as Lifecycle
		for (usedModRef : module.usedModules) {
			val selectingEndpointQualifierRef = getSelectingEndpointQualifier (usedModRef, module, endpointQualifierRef)
			val providerModule = modRefResolver.resolveModuleRef (usedModRef, targetEnvironment, lifecycle, selectingEndpointQualifierRef, null)
			val impModSvcBindDescs = resolveProvidedServiceBindings (providerModule, targetEnvironment, selectingEndpointQualifierRef)
			
			for (curDesc : impModSvcBindDescs.serviceRefDescriptions.filter (d | usedServiceRefs.contains (d.getServiceRef))) {
				val curEndpointQualifiers = endpointQualifierQuery.getPotentialEffectiveEndpointQualifiers (curDesc.getApplicableBinding)
				if (curDesc.getEndpointQualifier == null || curEndpointQualifiers.containsEndpointQualifier (curDesc.getEndpointQualifier)) {
					if (svcBindDescs.containsKey(curDesc.providingModule)) {
						svcBindDescs.get(curDesc.providingModule).add (curDesc)
					} else {
						var Set<ServiceRefBindingDescription> svcDescSet = newHashSet
						svcDescSet.add (curDesc)
						svcBindDescs.put (curDesc.providingModule, svcDescSet)
					}
				}
			}
			
			val svcRefsForEndpointQualifier = svcBindDescs.values.flatten.toSet.filterNull.map(d|d.getServiceRef).toList
			val allImpModSvcBindDescs = resolveProvidedServiceBindings (usedModRef.moduleRef.module, targetEnvironment, selectingEndpointQualifierRef)
			
			for (curBindDesc : allImpModSvcBindDescs.serviceRefDescriptions) {
				if (!svcRefsForEndpointQualifier.contains(curBindDesc.getServiceRef) && (selectingEndpointQualifierRef == null || selectingEndpointQualifierRef.acceptOtherEndpoints)) {
					if (curBindDesc != null && !svcBindDescs.values.flatten.toSet.filterNull.map(d|d.getServiceRef).toList.contains(curBindDesc.getServiceRef)) {
						if (svcBindDescs.containsKey(curBindDesc.providingModule)) {
							svcBindDescs.get(curBindDesc.providingModule).add (curBindDesc)
						} else {
							var Set<ServiceRefBindingDescription> svcDescSet = newHashSet
							svcDescSet.add (curBindDesc)
							svcBindDescs.put (curBindDesc.providingModule, svcDescSet)
						}
					}
				}
			}
		}
	}
	
	def private resolveServicesRefs (Module module, Set<? extends AbstractServiceRef> usedServiceRefs, Environment targetEnvironment, EndpointQualifierRef endpointQualifierRef, Map<Module, Set<ServiceRefBindingDescription>> svcBindDescs) {
		val lifecycle = module.state.eContainer as Lifecycle
		for (svcRef : module.usedServices) {
			if (usedServiceRefs.contains(svcRef)) {
				val svc = modServiceResolver.resolveModuleServiceRef (svcRef, targetEnvironment)
				val canditateModules = svcRef.modules.map (m|modRefResolver.resolveModuleServiceRef(m, targetEnvironment, lifecycle))
				
				for (candMod : canditateModules) {
					val selectingEndpointQualifierRef = if (svcRef.usingEndpoint?.endpointQualifierRef != null) svcRef.usingEndpoint?.endpointQualifierRef else module.endpointQualifierRef
					val candBindings = bindingLookup.findApplicableBindingsToModuleByEnvAndQualifier (candMod, targetEnvironment, selectingEndpointQualifierRef?.endpointQualifier)
				
					for (bind : candBindings) {
					 	var specBind = bindingLookup.getMostSpecificBinding(svc, bind, selectingEndpointQualifierRef)
					 	val curSvcBindDesc = new ServiceRefBindingDescription
					 	curSvcBindDesc.applicableBinding = specBind
					 	curSvcBindDesc.resolvedService = svc
					 	curSvcBindDesc.serviceRef = svcRef
					 	curSvcBindDesc.providingModule = candMod
			 			curSvcBindDesc.endpointQualifier = svcRef.usingEndpoint?.endpointQualifierRef?.endpointQualifier
						if (svcBindDescs.containsKey(curSvcBindDesc.providingModule)) {
							svcBindDescs.get(curSvcBindDesc.providingModule).add (curSvcBindDesc)
						} else {
							var Set<ServiceRefBindingDescription> svcDescSet = newHashSet
							svcDescSet.add (curSvcBindDesc)
							svcBindDescs.put (curSvcBindDesc.providingModule, svcDescSet)
						}
					}
				}
			}
		}
	}
		
	def private EndpointQualifierRef getSelectingEndpointQualifier (ModuleRef usedModRef, Module module, EndpointQualifierRef endpointQualifierRef) {
		val moduleEndpointQualifierRef = 	if (usedModRef.usingEndpoint?.endpointQualifierRef?.endpointQualifier != null) {
													usedModRef.usingEndpoint?.endpointQualifierRef 
											} else {
													module.endpointQualifierRef
											}
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
													moduleEndpointQualifierRef 
												} else if (endpointQualifierRef != null)  {
													endpointQualifierRef 
												} else { 
													module.endpointQualifierRef
												}
		return selectingEndpointQualifierRef	
	}
	
}