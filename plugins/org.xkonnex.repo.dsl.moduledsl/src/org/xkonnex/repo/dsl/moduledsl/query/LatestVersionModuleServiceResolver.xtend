package org.xkonnex.repo.dsl.moduledsl.query

import com.google.inject.Inject
import java.util.Set
import org.xkonnex.repo.dsl.basedsl.baseDsl.BaseDslFactory
import org.xkonnex.repo.dsl.basedsl.version.VersionMatcher
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.AbstractServiceRef
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ImportServiceRef
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleDslFactory
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ServiceRef
import org.xkonnex.repo.dsl.profiledsl.query.LifecycleQueries
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Lifecycle
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.IStateMatcher
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup
import org.xkonnex.repo.dsl.servicedsl.service.ModelExtensions

class LatestVersionModuleServiceResolver implements IModuleServiceResolver {
	
	@Inject extension VersionMatcher
	@Inject extension NamespaceQuery
	@Inject extension VersionQualifierExtensions
	@Inject extension ModelExtensions
	
	@Inject IStateMatcher stateMatcher
	@Inject LifecycleQueries lifecycleQueries
	@Inject
	private IEObjectLookup objLookup
	
	/**
	 * Get all references to services used explicitly or implicitly by module import.
	 * Exclusion and inclusion rules for Module imports are respected
	 */
	override Set<? extends AbstractServiceRef> getAllUsedServiceRefs (Module module) {
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
	
	/** 
	 * Get explicit and implicit references to services provided from the module.
	 * Implicit service references are service in namespaces provided by the module.
	 * Service inclusion and exclusion rules of namespace references are respected.
	 */
	override Set<AbstractServiceRef> getAllProvidedServiceRefs (Module module) {
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
	
	override resolveModuleServiceRef(AbstractServiceRef svcRef) {
		resolveModuleServiceRefInternal (svcRef)
	}
	
	override Service resolveModuleServiceRef(AbstractServiceRef svcRef, LifecycleState minState) {
		resolveModuleServiceRefInternal (svcRef, minState)
	}
	
	override Service resolveModuleServiceRef(AbstractServiceRef svcRef, Environment env) {
		resolveModuleServiceRefInternal (svcRef, env)
	}
	
	def dispatch Service resolveModuleServiceRefInternal (AbstractServiceRef s) {
		
	}

	/**
	 * Get the latest version of the service referenced in the ServiceRef matching the given minimal LifecycleState 
	 */
	def dispatch  Service resolveModuleServiceRefInternal (ServiceRef s) {
		s.service.findSubdomain().services.filter (e|e.name == s.service.name && e.version.versionMatches (s.versionRef)).sortBy(e|e.version.version).last();
	}

	/**
	 * Get the latest version of the service referenced in the ImportServiceRef 
	 */
	def dispatch  Service resolveModuleServiceRefInternal (ImportServiceRef svcRef) {
		resolveModuleServiceRef (svcRef)
	}
	
	def dispatch Service resolveModuleServiceRefInternal (AbstractServiceRef s, LifecycleState minState) {
		
	}
	
	/**
	 * Get the latest version of the service referenced in the ServiceRef matching the given minimal LifecycleState 
	 */
	def dispatch  Service resolveModuleServiceRefInternal (ServiceRef s, LifecycleState minState) {
		s.service.findSubdomain().services.filter (e|e.name == s.service.name && e.version.versionMatches (s.versionRef) && stateMatcher.matches (minState, e.state)).sortBy(e|e.version.version).last();
	}
	
	/**
	 * Get the latest version of the service referenced in the ImportServiceRef matching the given minimal LifecycleState 
	 */
	def dispatch  Service resolveModuleServiceRefInternal (ImportServiceRef importServiceRef, LifecycleState minState) {
		importServiceRef.service.findSubdomain().services.filter (e|e.name == importServiceRef.service.name && e.version.versionMatches (importServiceRef.versionRef) && stateMatcher.matches (minState, e.state)).sortBy(e|e.version.version).last();
	}
	
	/**
	 * Get the latest version of the service referenced in the ServiceRef  eligible for the given environment 
	 */
	def dispatch  Service resolveModuleServiceRefInternal (AbstractServiceRef svcRef, Environment env) {
		
	}
	
	/**
	 * Get the latest version of the service referenced in the ServiceRef  eligible for the given environment 
	 */
	def dispatch  Service resolveModuleServiceRefInternal (ServiceRef svcRef, Environment env) {
		val lifecycle = if (svcRef.service.state !== null) 
							svcRef.service.state.eContainer as Lifecycle 
						else 
							lifecycleQueries.getAssetLifecycle (objLookup.getStatefulOwner(svcRef))
		val minState = lifecycleQueries.getMinLifecycleState(env, lifecycle)
		resolveModuleServiceRef (svcRef, minState)
	}

	/**
	 * Get the latest version of the service referenced in the ImportServiceRef eligible for the given environment 
	 */
	def dispatch  Service resolveModuleServiceRefInternal (ImportServiceRef svcRef, Environment env) {
		val lifecycle = if (svcRef.service.state !== null) 
							svcRef.service.state.eContainer as Lifecycle 
						else 
							lifecycleQueries.getAssetLifecycle (objLookup.getStatefulOwner(svcRef))
		val minState = lifecycleQueries.getMinLifecycleState(env, lifecycle)
		resolveModuleServiceRef (svcRef, minState)
	}
	
	
	def private toServiceRef (Service svc) {
		val factory = ModuleDslFactory::eINSTANCE
		val baseDslFactory = BaseDslFactory::eINSTANCE
		var serviceRef = factory.createServiceRef
		serviceRef.setService(svc)
		val verRef = baseDslFactory.createFixedVersionRef
		verRef.setFixedVersion(svc.version.toVersionNumber)
		serviceRef.setVersionRef(verRef)
		return serviceRef
	}
	
}