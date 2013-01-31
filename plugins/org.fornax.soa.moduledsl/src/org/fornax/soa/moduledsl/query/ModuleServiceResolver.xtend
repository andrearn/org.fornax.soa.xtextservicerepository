package org.fornax.soa.moduledsl.query

import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.moduledsl.moduleDsl.ServiceRef
import org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef
import com.google.inject.Inject
import org.fornax.soa.service.query.namespace.NamespaceQuery
import org.fornax.soa.basedsl.version.VersionMatcher
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher
import org.fornax.soa.basedsl.search.IPredicateSearch
import org.fornax.soa.moduledsl.moduleDsl.Module
import com.google.common.base.Predicates
import org.eclipse.xtext.EcoreUtil2
import java.util.List
import org.eclipse.emf.ecore.resource.ResourceSet
import org.fornax.soa.moduledsl.moduleDsl.ModuleRef
import java.util.Set
import org.fornax.soa.moduledsl.moduleDsl.AbstractServiceRef
import org.fornax.soa.moduledsl.moduleDsl.ModuleDslFactory
import org.fornax.soa.basedsl.sOABaseDsl.SOABaseDslFactory
import org.fornax.soa.service.query.VersionQueries
import org.fornax.soa.basedsl.version.VersionQualifierExtensions

class ModuleServiceResolver {
	
	@Inject extension VersionMatcher
	@Inject IStateMatcher stateMatcher
	@Inject extension NamespaceQuery
	@Inject IPredicateSearch search
	@Inject ModuleLookup modLookup
	@Inject extension VersionQualifierExtensions
	
	/*
	 * Get all references to service used explicitly or implicitly by module import.
	 * Exclusion and inclusion rules for Module imports are respected
	 */
	def Set<? extends AbstractServiceRef> getAllUsedServiceRefs (Module module) {
		val usedModuleRefs = module.usedModules
		
		var Set<AbstractServiceRef> serviceRefs = newHashSet
		serviceRefs.addAll (module.usedModules.map (usedMod | usedMod.includedServices).flatten)
		for (usedMod : module.usedModules) {
			for (svcRef : usedMod.moduleRef.module.getAllProvidedServiceRefs) {
				if (! usedMod.excludedServices.contains(svcRef)) {
					serviceRefs.add (svcRef)
				}
			}
		}
		serviceRefs.addAll (module.usedServices)
		return serviceRefs
	}
	
	/* 
	 * Get explicit and implicit references to services provided from the module.
	 * Implicit service references are service in namespaces provided by the module.
	 * Service inclusion and exclusion rules of namespace references are respected.
	 */
	def Set<AbstractServiceRef> getAllProvidedServiceRefs (Module module) {
		var Set<AbstractServiceRef> serviceRefs = newHashSet()
		if (!module.providedNamespaces.empty) {
			val inclSvcs = module.providedNamespaces.map (n|n.includedServices).flatten
			val exclSvcs = module.providedNamespaces.map (n|n.excludedServices).flatten
			if (!inclSvcs.empty) {
				serviceRefs.addAll(inclSvcs.toSet)
			} else {
				serviceRefs.addAll(module.providedNamespaces.map (n|n.namespace.services).flatten.map(s | s.toServiceRef).toSet)
			}
			if (!exclSvcs.empty) {
				serviceRefs = serviceRefs.filter(r | !exclSvcs.toSet.contains(r)).toSet
			}
		}
		serviceRefs.addAll(module.providedServices.toSet)
		return serviceRefs
	}
	
	def private toServiceRef (Service svc) {
		val factory = ModuleDslFactory::eINSTANCE
		val baseDslFactory = SOABaseDslFactory::eINSTANCE
		var serviceRef = factory.createServiceRef
		serviceRef.setService(svc)
		val verRef = baseDslFactory.createFixedVersionRef
		verRef.setFixedVersion(svc.version.toVersionNumber)
		serviceRef.setVersionRef(verRef)
		return serviceRef
	}
	
	/*
	 * Get the latest version of the service referenced in the ServiceRef matching the given minimal LifecycleState 
	 */
	def dispatch Service findLatestMatchingServiceMod (ServiceRef s, LifecycleState minState) {
		s.service.findSubdomain().services.filter (e|e.name == s.service.name && e.version.versionMatches (s.versionRef) && stateMatcher.matches (minState, e.state)).sortBy(e|e.version.version).last();
	}
	
	/*
	 * Get the latest version of the service referenced in the ImportServiceRef matching the given minimal LifecycleState 
	 */
	def dispatch Service findLatestMatchingServiceMod (ImportServiceRef importServiceRef, LifecycleState minState) {
		importServiceRef.service.findSubdomain().services.filter (e|e.name == importServiceRef.service.name && e.version.versionMatches (importServiceRef.versionRef) && stateMatcher.matches (minState, e.state)).sortBy(e|e.version.version).last();
	}
	
	/*
	 * Get all Modules defined in the model
	 */
	def findAllModules (ResourceSet resourceSet) {
		var moduleDescs = search.search("Module ", Predicates::alwaysTrue)
		var List<Module> allModules = newArrayList()
		for (moduleDesc : moduleDescs) {
			val obj = moduleDesc.EObjectOrProxy
			if (obj instanceof Module) {
				val module = obj as Module
				if (module.eIsProxy) {
					val resolvedModule = EcoreUtil2::resolve (module, resourceSet) as Module
					if (!resolvedModule.eIsProxy) {
						allModules.add (resolvedModule)
					}
				} else {
					allModules.add (module)
				}
			}
		}
		return allModules
	}
	
	/* 
	 * Find all modules that provide the given service
	 */
	def findProvidingModules (Service service) {
		var List<Module> allModules = findAllModules (service.eResource?.resourceSet)
		var providingModules = allModules.filter (m|m.providedServices.map (e|e.service).exists(s|s == service))
		val nsProvidingModules = allModules.filter (m|m.providedNamespaces.map (e|e.namespace.services).exists(s|s == service))
		providingModules.toSet.addAll (nsProvidingModules)
		return providingModules
	}
	
	/* 
	 * Find all modules that provide the given service. from any of the canditate modules
	 */
	def findProvidingModules (Service service, Iterable<Module> canditateModules) {
		canditateModules.filter (cand| service.findProvidingModules.exists(m|m == cand))
	}
	
	/* 
	 * Find all modules that provide the given service, from any of the canditate modules, that 
	 * declare the given qualifier
	 */
	def findProvidingModules (Service service, Iterable<Module> canditateModules, String qualifierName) {
		service.findProvidingModules (canditateModules).filter (m|m.qualifiers.qualifiers.exists(q|q.name == qualifierName))
	}
	
	/*
	 * Get the endpoint qualifier
	 */	
	def dispatch String getQualifier (Module module) {
		module.endpointQualifier.name
	}
	
	/*
	 * Get the endpoint qualifier
	 */	
	def dispatch String getQualifier (ModuleRef moduleRef) {
		if (moduleRef.endpointQualifier != null)
			return moduleRef.endpointQualifier.name
		else
			return (moduleRef.eContainer as Module).qualifier
	}
	
	/*
	 * Get the endpoint qualifier
	 */	
	def dispatch String getQualifier (ImportServiceRef impServiceRef) {
		if (impServiceRef.endpointQualifier != null)
			return impServiceRef.endpointQualifier.name
		else
			return (impServiceRef.eContainer as Module).qualifier
	}
		
}