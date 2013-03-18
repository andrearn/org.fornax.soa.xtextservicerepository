package org.fornax.soa.moduledsl.query

import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.fornax.soa.basedsl.search.IEObjectDescriptionIsInstancePredicate
import org.fornax.soa.basedsl.search.IPredicateSearch
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.moduledsl.moduleDsl.ModuleRef
import org.fornax.soa.moduledsl.moduleDsl.ServiceModuleRef
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.profiledsl.scoping.versions.IVersionFilterProvider
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher
import org.eclipse.xtext.EcoreUtil2
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle
import org.eclipse.xtext.resource.IEObjectDescription
import org.fornax.soa.moduledsl.moduleDsl.EndpointQualifierRef
import org.fornax.soa.moduledsl.moduleDsl.ImportBindingProtocol
import org.fornax.soa.basedsl.search.IReferenceSearch

class DefaultModuleReferenceResolver implements IModuleReferenceResolver {
	
	@Inject
	private IQualifiedNameProvider nameProvider
	@Inject 
	private IVersionFilterProvider versionFilterProvider
	@Inject
	private IPredicateSearch search
	@Inject 
	private IStateMatcher stateMatcher 
	@Inject
	private IReferenceSearch referenceSearch

	override resolveModuleRef(ModuleRef moduleRef, LifecycleState minState) {
		resolveModuleServiceRef (moduleRef.moduleRef, minState)
	}
	
	override resolveModuleServiceRef(ServiceModuleRef moduleRef, LifecycleState minState) {
		val moduleName = nameProvider.getFullyQualifiedName (moduleRef.module)
		val moduleDescs = search.search (moduleName.toString, "Module ", new IEObjectDescriptionIsInstancePredicate(typeof (Module)))
		val versionFilter = versionFilterProvider.createVersionFilter(moduleRef.version, minState)
		val moduleMap = versionFilter.getBestMatchByNames(moduleDescs, false)
		val resolvedModuleDesc = moduleMap.get(moduleName)?.head as IEObjectDescription
		var resolvedMod = resolvedModuleDesc.EObjectOrProxy as Module
		if (resolvedMod != null && resolvedMod.eIsProxy) {
			resolvedMod = EcoreUtil2::resolve(resolvedMod, moduleRef.eResource?.resourceSet) as Module
		}
		return resolvedMod
	}
	

	override resolveModuleRef(ModuleRef moduleRef, Environment targetEnvironment, Lifecycle lifecycle) {
		val minState = stateMatcher.getLowestStateByEnvironment(lifecycle, targetEnvironment)
		resolveModuleRef (moduleRef, minState)
	}
	
	override resolveModuleServiceRef(ServiceModuleRef moduleRef, Environment targetEnvironment, Lifecycle lifecycle) {
		val minState = stateMatcher.getLowestStateByEnvironment(lifecycle, targetEnvironment)
		resolveModuleServiceRef (moduleRef, minState)
	}
	

	override resolveModuleRef(ModuleRef moduleRef, Environment targetEnvironment, Lifecycle lifecycle, EndpointQualifierRef endpointQualifierRef, ImportBindingProtocol usedProtocol) {
		val svcModuleRef = moduleRef.moduleRef
		val minState = stateMatcher.getLowestStateByEnvironment (lifecycle, targetEnvironment)
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
		val minState = stateMatcher.getLowestStateByEnvironment (lifecycle, targetEnvironment)
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