package org.fornax.soa.binding.query

import com.google.inject.Inject
import java.util.Set
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.moduledsl.query.DefaultModuleServiceResolver
import org.fornax.soa.binding.query.services.ServiceRefBindingDescription
import org.fornax.soa.moduledsl.query.IModuleServiceResolver
import org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef
import org.fornax.soa.semanticsDsl.Qualifier

/**
 * Resolves Bindings to explicit descriptions describing which Binding applies to which service an module
 */
class BindingResolver {
	
	@Inject IModuleServiceResolver modServiceResolver
	@Inject BindingLookup bindingLookup
	@Inject EndpointQualifierQueries endpointQualifierQuery
	/**
	 * Resolve Bindings of services provided by a module or a compatible module version
	 */
	def Set<ServiceRefBindingDescription> resolveCompatibleProvidedServiceBindings (Module module, Environment targetEnvironment) {
		val candBindings = bindingLookup.findBindingsToCompatibleModule (module, targetEnvironment)
		var Set<ServiceRefBindingDescription> svcBindDescs= newHashSet
		
		val providedServices = modServiceResolver.getAllProvidedServiceRefs(module)
		for (provSvcRef : providedServices) {
			 val svc = modServiceResolver.resolveModuleServiceRef (provSvcRef, targetEnvironment)
			 for (bind : candBindings) {
			 	val specBind = bindingLookup.getMostSpecificBinding(svc, bind)
			 	val curSvcBindDesc = new ServiceRefBindingDescription
			 	curSvcBindDesc.applicableBinding = specBind
			 	curSvcBindDesc.resolvedService = svc
			 	curSvcBindDesc.serviceRef = provSvcRef
			 	curSvcBindDesc.providingModule = module
			 	svcBindDescs.add (curSvcBindDesc)
			 }
		}
		return svcBindDescs
	}
	/**
	 * Resolve Bindings of services provided by a module or a compatible module version
	 */
	def Set<ServiceRefBindingDescription> resolveCompatibleProvidedServiceBindings (Module module, Environment targetEnvironment, Qualifier endpointQualifier) {
		val candBindings = bindingLookup.findBindingsToCompatibleModule (module, targetEnvironment)
		var Set<ServiceRefBindingDescription> svcBindDescs= newHashSet
		
		val providedServices = modServiceResolver.getAllProvidedServiceRefs(module)
		for (provSvcRef : providedServices) {
			 val svc = modServiceResolver.resolveModuleServiceRef (provSvcRef, targetEnvironment)
			 for (bind : candBindings) {
			 	val specBind = bindingLookup.getMostSpecificBinding(svc, bind, endpointQualifier)
			 	val curSvcBindDesc = new ServiceRefBindingDescription
			 	curSvcBindDesc.applicableBinding = specBind
			 	curSvcBindDesc.resolvedService = svc
			 	curSvcBindDesc.serviceRef = provSvcRef
			 	curSvcBindDesc.providingModule = module
			 	curSvcBindDesc.endpointQualifier = endpointQualifier
			 	svcBindDescs.add (curSvcBindDesc)
			 }
		}
		return svcBindDescs
	}
	
	/**
	 * Resolve Bindings of services used by a module
	 */
	def Set<ServiceRefBindingDescription> resolveCompatibleUsedServiceBindings (Module module, Environment targetEnvironment) {
		val usedServiceRefs = modServiceResolver.getAllUsedServiceRefs(module)
		var Set<ServiceRefBindingDescription> svcBindDescs= newHashSet
		for (usedModRef : module.usedModules) {
			val impModSvcBindDescs = resolveCompatibleProvidedServiceBindings (usedModRef.moduleRef.module, targetEnvironment, if (usedModRef.endpointQualifier != null) usedModRef.endpointQualifier else module.endpointQualifier)
			for (curDesc : impModSvcBindDescs.filter (d | usedServiceRefs.contains (d.serviceRef))) {
				val curEndpointQualifiers = endpointQualifierQuery.getEffectiveEndpointQualifier(curDesc.applicableBinding)
				if (curDesc.endpointQualifier == null || curEndpointQualifiers == curDesc.endpointQualifier) {
					svcBindDescs.add (curDesc)
				}
			}
		}
		for (svcRef : module.usedServices) {
			if (usedServiceRefs.contains(svcRef)) {
				val svc = modServiceResolver.resolveModuleServiceRef (svcRef, targetEnvironment)
				val canditateModules = svcRef.modules.map (m|m.module)
				for (candMod : canditateModules) {
					val candBindings = bindingLookup.findBindingsToCompatibleModule (candMod, targetEnvironment)
					for (bind : candBindings) {
					 	val specBind = bindingLookup.getMostSpecificBinding(svc, bind, if (svcRef.endpointQualifier != null) svcRef.endpointQualifier else module.endpointQualifier)
					 	val curSvcBindDesc = new ServiceRefBindingDescription
					 	curSvcBindDesc.applicableBinding = specBind
					 	curSvcBindDesc.resolvedService = svc
					 	curSvcBindDesc.serviceRef = svcRef
					 	curSvcBindDesc.providingModule = candMod
			 			curSvcBindDesc.endpointQualifier = svcRef.endpointQualifier
					 	svcBindDescs.add (curSvcBindDesc)
					}
				}
			}
		}
		return svcBindDescs
	}
	
	
}