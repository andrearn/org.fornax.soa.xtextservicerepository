package org.xkonnex.repo.dsl.moduledsl.query

import com.google.common.base.Predicates
import com.google.inject.Inject
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.EcoreUtil2
import org.xkonnex.repo.dsl.basedsl.baseDsl.VersionRef
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ImportServiceRef
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.IStateMatcher
import org.xkonnex.repo.dsl.basedsl.version.VersionComparator
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IEObjectDescription
import org.xkonnex.repo.dsl.servicedsl.service.ModelExtensions
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource

/**
 * This class provides operations to find Modules 
 */
class ModuleLookup {
	
	@Inject IPredicateSearch search
	@Inject extension IModuleVersionMatcher
	@Inject extension IStateMatcher
	@Inject extension ModelExtensions
	
	/**
	 * Find all available Modules (defined by the model represented by the given {@link ResourceSet})
	 * 
	 * @param resourceSet the {@link ResourceSet} containing the model
	 * @return all modules in the model
	 */
	def findAllModules (ResourceSet resourceSet) {
		var Iterable<IEObjectDescription> moduleDescs = null
		if (resourceSet !== null)
			moduleDescs = search.search ("Module ", Predicates::alwaysTrue, resourceSet)
		else
			moduleDescs = search.search ("Module ", Predicates::alwaysTrue)
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
		return allModules.filter (typeof (Module)).toSet
	}
	
	/**
	 * Find all Modules of any version having the given Module name.
	 * 
	 * @param moduleName the name of the module to look for
	 * @param resourceSet the {@link ResourceSet} containing the model
	 * @return all versions of the module with the name moduleName 
	 */
	def findAllModuleVersionsByName (String moduleName, ResourceSet resourceSet) {
		var Iterable<IEObjectDescription> moduleDescs = null
		if (resourceSet !== null)
			moduleDescs = search.search (moduleName, "Module ", Predicates::alwaysTrue, resourceSet)
		else
			moduleDescs = search.search (moduleName, "Module ", Predicates::alwaysTrue)
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
		return allModules.filter (typeof (Module)).toSet
	}
	
	def findCompatibleModules (Module module) {
		val allModules = findAllModules (module.eResource.resourceSet)
		allModules.filter (m | m.isCompatibleTo (module))
	}
	
	/**
	 * Find all Module versions of Modules with given qualified Module name that match the given version constraint
	 * @param moduleName The name of the Module
	 * @param versionConstraint The version of the Module must match this constraint
	 * @param resourceSet The ResourceSet of model files containing the Modules 
	 * @return all effectively referenced modules
	 */
	def findAllEffectivelyReferencedModules (QualifiedName moduleName, VersionRef versionConstraint, ResourceSet resourceSet) {
		val allModules = findAllModules (resourceSet)
		allModules.filter (m | m.isEffectivelyReferencedVersion(moduleName, versionConstraint))
	}
	
	/** 
	 * Find all Modules that provide the given service
	 * 
	 * @param service The {@link Service} that must be provided by the Module
	 * @return all modules that provide the {@link Service} service
	 */
	def findProvidingModules (Service service) {
		var Set<Module> allModules = findAllModules (service.eResource?.resourceSet)
		var providingModules = allModules.filter (m|m.providedServices.map (e|e.service).exists (s|s == service))
		val nsProvidingModules = allModules.filter (m|m.providedNamespaces.map (e|e.namespace.services).exists (s|s == service))
		providingModules.toSet.addAll (nsProvidingModules)
		return providingModules
	}
	
	/** 
	 * Find all Modules that provide the given Resource
	 * 
	 * @param resource The {@link Resource} that must be provided by the Module
	 * @return all modules that provide the {@link Resource} resource
	 */
	def findProvidingModules (Resource resource) {
		var Set<Module> allModules = findAllModules (resource.eResource?.resourceSet)
		var providingModules = allModules.filter (m|m.providedResources.map (e|e.resource).exists (s|s == resource))
		val nsProvidingModules = allModules.filter (m|m.providedNamespaces.map (e|e.namespace.resources).exists (s|s == resource))
		providingModules.toSet.addAll (nsProvidingModules)
		return providingModules
	}
		
	/** 
	 * Find all modules that provide the given service. from any of the candidate modules
	 * 
	 * @param service The {@link Service} that must be provided by the Module
	 * @param candidateModules candidate modules to choose from
	 * @return all modules from the candidate list, that provide the {@link Service} service
	 */
	def findProvidingModules (Service service, Iterable<Module> candidateModules) {
		candidateModules.filter (cand| service.findProvidingModules.exists(m|m == cand))
	}
	
	/** 
	 * Find all modules that provide the given resource. from any of the candidate modules
	 * 
	 * @param resource The {@link Resource} that must be provided by the Module
	 * @param candidateModules candidate modules to choose from
	 * @return all modules from the candidate list, that provide the {@link Resource} resource
	 */
	def findProvidingModules (Resource resource, Iterable<Module> candidateModules) {
		candidateModules.filter (cand| resource.findProvidingModules.exists(m|m == cand))
	}
	
	/** 
	 * Find all modules that provide the given service, from any of the candidate modules, that 
	 * declare the given qualifier
	 * 
	 * @param service The {@link Service} that must be provided by the Module
	 * @param candidateModules candidate modules to choose from
	 * @param qualifierName name of the endpoint qualifier
	 * @return all modules from the candidate list, that provide the {@link Service} service
	 */
	def findProvidingModules (Service service, Iterable<Module> candidateModules, String qualifierName) {
		service.findProvidingModules (candidateModules).filter (m|m.qualifiers.qualifiers.exists(q|q.name == qualifierName))
	}
	
	/** 
	 * Find all modules that provide the given resource, from any of the candidate modules, that 
	 * declare the given qualifier
	 * 
	 * @param resource The {@link Resource} that must be provided by the Module
	 * @param candidateModules candidate modules to choose from
	 * @param qualifierName name of the endpoint qualifier
	 * @return all modules from the candidate list, that provide the {@link Resource} resource
	 */
	def findProvidingModules (Resource resource, Iterable<Module> candidateModules, String qualifierName) {
		resource.findProvidingModules (candidateModules).filter (m|m.qualifiers.qualifiers.exists(q|q.name == qualifierName))
	}
	
	def findLatestModuleByNameAndMinState (Module module, LifecycleState minState) {
		val modules = findAllModuleVersionsByName(module.name, module.eResource.resourceSet)
		var Module matchingModule = null
		for (mod : modules) {
			if (minState.matches(mod.state)) {
				if (matchingModule === null 
					|| VersionComparator::compare(mod.version.version, matchingModule.version.version) > 0
				) {
					matchingModule = mod
				}
			}
		}
		return matchingModule
	}
		
	/**
	 * Get the endpoint qualifier
	 * 
	 * @param module the module
	 * @return the name of the endpoint qualifier
	 */	
	def dispatch String getQualifier (Module module) {
		module.endpointQualifierRef?.endpointQualifier.name
	}
	
	/**
	 * Get the endpoint qualifier
	 * 
	 * @param moduleRef the reference to a module
	 * @return the name of the endpoint qualifier
	 */	
	def dispatch String getQualifier (ModuleRef moduleRef) {
		if (moduleRef.usingEndpoint?.endpointQualifierRef?.endpointQualifier !== null)
			return moduleRef.usingEndpoint?.endpointQualifierRef.endpointQualifier.name
		else
			return (moduleRef.eContainer as Module).qualifier
	}
	
	/**
	 * Get the endpoint qualifier
	 * 
	 * @param impServiceRef reference to a service imported by a module
	 * @return the name of the endpoint qualifier
	 */	
	def dispatch String getQualifier (ImportServiceRef impServiceRef) {
		if (impServiceRef.usingEndpoint?.endpointQualifierRef?.endpointQualifier !== null)
			return impServiceRef.usingEndpoint?.endpointQualifierRef.endpointQualifier.name
		else
			return (impServiceRef.eContainer as Module).qualifier
	}
		
	def dispatch String getBindingQualifier (Module module) {
		module.endpointQualifierRef?.endpointQualifier.name
	}
	
	def dispatch String getBindingQualifier (ModuleRef moduleRef) {
		if (moduleRef.usingEndpoint?.endpointQualifierRef?.endpointQualifier !== null)
			return moduleRef.usingEndpoint?.endpointQualifierRef.endpointQualifier.name
		else
			return (moduleRef.eContainer as Module).endpointQualifierRef?.endpointQualifier.name
	}
	
	def dispatch String getBindingQualifier (ImportServiceRef impServiceRef) {
		if (impServiceRef.usingEndpoint?.endpointQualifierRef?.endpointQualifier !== null)
			return impServiceRef.usingEndpoint?.endpointQualifierRef.endpointQualifier.name
		else
			return (impServiceRef.eContainer as Module).endpointQualifierRef?.endpointQualifier.name
	}
	
	/**
	 * Get the module that contains the model element.
	 * 
	 * @param modelElement a model element
	 * @return the module that contains the model element
	 */
	def dispatch getOwningModule (EObject modelElement) {
		if (modelElement?.eContainer !== null)
			return modelElement.eContainer
		else 
			return null
	}
	
	/**
	 * Get the module that contains the model element. I.n this case the Module itself
	 * @param modelElement a (nested) module
	 * @return the module that contains the model element
	 */
	def dispatch getOwningModule (Module modelElement) {
		return modelElement
	}
}