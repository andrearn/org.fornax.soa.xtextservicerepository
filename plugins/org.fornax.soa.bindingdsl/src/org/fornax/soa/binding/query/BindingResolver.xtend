package org.fornax.soa.binding.query

import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.bindingDsl.SOAP
import org.fornax.soa.bindingDsl.EJB
import org.fornax.soa.bindingDsl.JMS
import org.fornax.soa.bindingDsl.REST
import org.fornax.soa.bindingDsl.SCA
import org.fornax.soa.moduledsl.moduleDsl.AbstractServiceRef
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.moduledsl.moduleDsl.ServiceRef
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.moduledsl.query.ModuleLookup
import com.google.inject.Inject
import org.fornax.soa.bindingDsl.ModuleBinding
import java.util.Set
import org.fornax.soa.moduledsl.query.ModuleServiceLookup
import org.fornax.soa.moduledsl.query.ModuleServiceResolver
import org.fornax.soa.binding.query.services.BindingServiceResolver
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver

/**
 * Resolves Bindings to explicit descriptions describing which Binding applies to which service an module
 */
class BindingResolver {
	
	@Inject ModuleLookup modLookup
	@Inject ModuleServiceResolver modServiceResolver
	@Inject BindingLookup bindingLookup
	@Inject extension BindingServiceResolver
	
	@Inject extension EnvironmentBindingResolver
	
	/**
	 * Resolve Bindings of services provided by a module
	 */
	def Set<ServiceRefBindingDescription> resolveCompatibleProvidedServiceBindings (Module module, Environment targetEnvironment) {
		val candBindings = bindingLookup.findBindingsToCompatibleModule (module, targetEnvironment)
		var Set<ServiceRefBindingDescription> svcBindDescs= newHashSet
		
		val providedServices = modServiceResolver.getAllProvidedServiceRefs(module)
		for (provSvcRef : providedServices) {
			 val svc = provSvcRef.latestServiceInEnvironment (targetEnvironment)
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
	 * Resolve Bindings of services used by a module
	 */
	def Set<ServiceRefBindingDescription> resolveCompatibleUsedServiceBindings (Module module, Environment targetEnvironment) {
		val usedServiceRefs = modServiceResolver.getAllUsedServiceRefs(module)
		var Set<ServiceRefBindingDescription> svcBindDescs= newHashSet
		for (usedModRef : module.usedModules) {
			val impModSvcBindDescs = resolveCompatibleProvidedServiceBindings (usedModRef.moduleRef.module, targetEnvironment)
			for (curDesc : impModSvcBindDescs.filter (d | usedServiceRefs.contains (d.serviceRef))) {
				val curEntpointQualifiers = curDesc.applicableBinding?.endpointQualifierRefs?.endpointQualifiers
				if (curDesc.endpointQualifier == null || curEntpointQualifiers.contains(curDesc.endpointQualifier)) {
					svcBindDescs.add (curDesc)
				}
			}
		}
		for (svcRef : module.usedServices) {
			if (usedServiceRefs.contains(svcRef)) {
				val svc = svcRef.latestServiceInEnvironment (targetEnvironment)
				val canditateModules = svcRef.modules.map (m|m.module)
				for (candMod : canditateModules) {
					val candBindings = bindingLookup.findBindingsToCompatibleModule (candMod, targetEnvironment)
					for (bind : candBindings) {
					 	val specBind = bindingLookup.getMostSpecificBinding(svc, bind)
					 	val curSvcBindDesc = new ServiceRefBindingDescription
					 	curSvcBindDesc.applicableBinding = specBind
					 	curSvcBindDesc.resolvedService = svc
					 	curSvcBindDesc.serviceRef = svcRef
					 	curSvcBindDesc.providingModule = candMod
					 	svcBindDescs.add (curSvcBindDesc)
					}
				}
			}
		}
		return svcBindDescs
	}
	
	
//	def getPublisher (BindingProtocol prot) {
//		switch (prot) {
//			SOAP:		(prot as SOAP).publisher
//			EJB:		(prot as EJB).publisher
//			JMS:		(prot as JMS).publisher
//			REST:		(prot as REST).publisher
//			SCA:		(prot as SCA).publisher
//			default:	null
//		}
//		
//	}
//	def getProvider (BindingProtocol prot) {
//		switch (prot) {
//			SOAP:		(prot as SOAP).provider
//			EJB:		(prot as EJB).provider
//			JMS:		(prot as JMS).provider
//			REST:		(prot as REST).provider
//			SCA:		(prot as SCA).provider
//			default:	null
//		}
//		
//	}
}