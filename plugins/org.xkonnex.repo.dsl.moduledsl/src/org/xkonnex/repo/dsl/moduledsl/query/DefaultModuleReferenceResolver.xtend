package org.xkonnex.repo.dsl.moduledsl.query

import com.google.inject.Inject
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.resource.IEObjectDescription
import org.xkonnex.repo.dsl.basedsl.search.IEObjectDescriptionIsInstancePredicate
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch
import org.xkonnex.repo.dsl.basedsl.search.IReferenceSearch
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointQualifierRef
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ImportBindingProtocol
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleRef
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ServiceModuleRef
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Lifecycle
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.IVersionFilterProvider

class DefaultModuleReferenceResolver implements IModuleReferenceResolver {
	
	@Inject
	private IQualifiedNameProvider nameProvider
	@Inject 
	private IVersionFilterProvider versionFilterProvider
	@Inject
	private IPredicateSearch search
	@Inject
	private IReferenceSearch referenceSearch
	@Inject
	private IEObjectLookup objLookup

	override resolveModuleRef(ModuleRef moduleRef, LifecycleState minState) {
		resolveModuleServiceRef (moduleRef.moduleRef, minState)
	}
	
	override resolveModuleServiceRef(ServiceModuleRef moduleRef, LifecycleState minState) {
		val moduleName = nameProvider.getFullyQualifiedName (moduleRef.module)
		val moduleDescs = search.search (moduleName.toString, "Module ", new IEObjectDescriptionIsInstancePredicate(typeof (Module)))
		val Module referringModule = objLookup.getOwnerByType (moduleRef, typeof (Module))
		val minimalState = referringModule.state
		val versionFilter = versionFilterProvider.createVersionFilter(moduleRef.version, minimalState)
		val moduleMap = versionFilter.getBestMatchByNames(moduleDescs, false)
		val resolvedModuleDesc = moduleMap.get(moduleName)?.head as IEObjectDescription
		var resolvedMod = resolvedModuleDesc.EObjectOrProxy as Module
		if (resolvedMod != null && resolvedMod.eIsProxy) {
			resolvedMod = EcoreUtil2::resolve(resolvedMod, moduleRef.eResource?.resourceSet) as Module
		}
		return resolvedMod
	}
	

	override resolveModuleRef(ModuleRef moduleRef, Environment targetEnvironment, Lifecycle lifecycle) {
		val Module referringModule = objLookup.getOwnerByType (moduleRef, typeof (Module))
		val minState = referringModule.state
		resolveModuleRef (moduleRef, minState)
	}
	
	override resolveModuleServiceRef(ServiceModuleRef moduleRef, Environment targetEnvironment, Lifecycle lifecycle) {
		val Module referringModule = objLookup.getOwnerByType (moduleRef, typeof (Module))
		val minState = referringModule.state
		resolveModuleServiceRef (moduleRef, minState)
	}
	

	override resolveModuleRef(ModuleRef moduleRef, Environment targetEnvironment, Lifecycle lifecycle, EndpointQualifierRef endpointQualifierRef, ImportBindingProtocol usedProtocol) {
		val svcModuleRef = moduleRef.moduleRef
		val Module referringModule = objLookup.getOwnerByType (moduleRef, typeof (Module))
		val minState = referringModule.state
		val moduleName = nameProvider.getFullyQualifiedName (svcModuleRef.module)
		val moduleDescs = search.search (moduleName.toString, "Module ", new IEObjectDescriptionIsInstancePredicate(typeof (Module)))
		val deployedModulePredicate = new DeployedModuleInEnvironmentPredicate(targetEnvironment, endpointQualifierRef, referenceSearch)
		var versionFilter = versionFilterProvider.createVersionFilter (svcModuleRef.version, minState, deployedModulePredicate)
		val moduleMap = versionFilter.getBestMatchByNames (moduleDescs, false)
		val resolvedModuleDesc = moduleMap.get (moduleName)?.head as IEObjectDescription
		var resolvedMod = resolvedModuleDesc.EObjectOrProxy as Module
		if (resolvedMod != null && resolvedMod.eIsProxy) {
			resolvedMod = EcoreUtil2::resolve (resolvedMod, svcModuleRef.eResource?.resourceSet) as Module
		}
		return resolvedMod
	}
	
	override resolveModuleServiceRef(ServiceModuleRef moduleRef, Environment targetEnvironment, Lifecycle lifecycle, EndpointQualifierRef endpointQualifierRef, ImportBindingProtocol usedProtocol) {
		val Module referringModule = objLookup.getOwnerByType (moduleRef, typeof (Module))
		val minState = referringModule.state
		val moduleName = nameProvider.getFullyQualifiedName (moduleRef.module)
		val moduleDescs = search.search (moduleName.toString, "Module ", new IEObjectDescriptionIsInstancePredicate(typeof (Module)))
		val deployedModulePredicate = new DeployedModuleInEnvironmentPredicate(targetEnvironment, endpointQualifierRef, referenceSearch)
		var versionFilter = versionFilterProvider.createVersionFilter (moduleRef.version, minState, deployedModulePredicate)
		val moduleMap = versionFilter.getBestMatchByNames (moduleDescs, false)
		val resolvedModuleDesc = moduleMap.get (moduleName)?.head as IEObjectDescription
		var resolvedMod = resolvedModuleDesc.EObjectOrProxy as Module
		if (resolvedMod != null && resolvedMod.eIsProxy) {
			resolvedMod = EcoreUtil2::resolve (resolvedMod, moduleRef.eResource?.resourceSet) as Module
		}
		return resolvedMod
	}
	
}