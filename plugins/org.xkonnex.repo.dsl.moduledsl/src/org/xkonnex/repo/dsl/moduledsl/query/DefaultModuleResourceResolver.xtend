package org.xkonnex.repo.dsl.moduledsl.query

import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ResourceRef
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleDslFactory
import org.xkonnex.repo.dsl.basedsl.baseDsl.BaseDslFactory
import javax.inject.Inject
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.IStateMatcher
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.dsl.profiledsl.query.LifecycleQueries
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup
import java.util.Set
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.AbstractResourceRef
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.impl.ImportResourceRefImpl
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ImportResourceRef
import org.xkonnex.repo.dsl.servicedsl.service.ModelExtensions

class DefaultModuleResourceResolver implements IModuleResourceResolver {
	
	@Inject extension VersionQualifierExtensions
	@Inject extension ModelExtensions

	@Inject
	private IEObjectLookup objLookup
	
	
	override getAllUsedResourceRefs(Module module) {
		var Set<AbstractResourceRef> resourceRefs = newHashSet
		resourceRefs.addAll (module.usedModules.map (usedMod | usedMod.includedResources).flatten)
		for (usedMod : module.usedModules) {
			for (resRef : usedMod.moduleRef.module.allProvidedResourceRefs) {
				if (! usedMod.excludedServices.contains(resRef)) {
					resourceRefs.add (resRef)
				}
			}
		}
		resourceRefs.addAll (module.usedResource)
		return resourceRefs
	}
	
	/** 
	 * Get explicit and implicit references to resources provided from the module.
	 * Implicit service references are service in namespaces provided by the module.
	 * Resource inclusion and exclusion rules of namespace references are respected.
	 */
	override Set<AbstractResourceRef> getAllProvidedResourceRefs (Module module) {
		var Set<AbstractResourceRef> resourceRefs = newHashSet()
		if (!module.providedNamespaces.empty) {
			val inclResources = module.providedNamespaces.map (n|n.includedResources).flatten
			val exclResources = module.providedNamespaces.map (n|n.excludedResources).flatten
			if (!inclResources.empty) {
				resourceRefs.addAll(inclResources.toSet)
			} else {
				resourceRefs.addAll(module.providedNamespaces.map (n|n.namespace.types).flatten.filter(typeof(Resource)).map(s | s.toResourceRef).toSet)
			}
			if (!exclResources.empty) {
				resourceRefs = resourceRefs.filter(r | !exclResources.toSet.contains(r)).toSet
			}
		}
		resourceRefs.addAll(module.providedResources.toSet)
		return resourceRefs
	}
	
	override Resource resolveModuleResourceRef(AbstractResourceRef resRef, LifecycleState minState) {
		resolveModuleResourceRefInternal (resRef, minState)
	}
	
	override Resource resolveModuleResourceRef(AbstractResourceRef resRef, Environment env) {
		resolveModuleResourceRefInternal (resRef, env)
	}
	
	def dispatch Resource resolveModuleResourceRefInternal (AbstractResourceRef s, LifecycleState minState) {
		
	}

	/**
	 * Get the latest version of the service referenced in the ServiceRef matching the given minimal LifecycleState 
	 */
	def dispatch  Resource resolveModuleResourceRefInternal (ResourceRef s, LifecycleState minState) {
		s.resource
	}
	
	/**
	 * Get the latest version of the service referenced in the ImportServiceRef matching the given minimal LifecycleState 
	 */
	def dispatch  Resource resolveModuleResourceRefInternal (ImportResourceRef importResourceRef, LifecycleState minState) {
		importResourceRef.resource
	}
	
	
	/**
	 * Get the latest version of the service referenced in the ServiceRef  eligible for the given environment 
	 */
	def dispatch  Resource resolveModuleResourceRefInternal (AbstractResourceRef svcRef, Environment env) {
		
	}
	
	/**
	 * Get the latest version of the service referenced in the ServiceRef  eligible for the given environment 
	 */
	def dispatch  Resource resolveModuleResourceRefInternal (ResourceRef resRef, Environment env) {
		val Module referringModule = objLookup.getOwnerByType (resRef, typeof (Module))
		val minState = referringModule.state
		resolveModuleResourceRef (resRef, minState)
	}

	/**
	 * Get the latest version of the service referenced in the ImportServiceRef eligible for the given environment 
	 */
	def dispatch  Resource resolveModuleServiceRefInternal (ImportResourceRef svcRef, Environment env) {
		val Module referringModule = objLookup.getOwnerByType (svcRef, typeof (Module))
		val minState = referringModule.state
		resolveModuleResourceRef (svcRef, minState)
	}

	def private toResourceRef (Resource svc) {
		val factory = ModuleDslFactory::eINSTANCE
		val baseDslFactory = BaseDslFactory::eINSTANCE
		var resourceRef = factory.createResourceRef
		resourceRef.setResource(svc)
		val verRef = baseDslFactory.createFixedVersionRef
		verRef.setFixedVersion(svc.version.toVersionNumber)
		resourceRef.setVersionRef(verRef)
		return resourceRef
	}
	
}