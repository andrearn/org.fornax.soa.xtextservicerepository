package org.fornax.soa.moduledsl.query

import com.google.common.base.Predicates
import com.google.inject.Inject
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.EcoreUtil2
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef
import org.fornax.soa.basedsl.search.IPredicateSearch
import org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.moduledsl.moduleDsl.ModuleRef
import org.fornax.soa.serviceDsl.Service

class ModuleLookup {
	
	@Inject IPredicateSearch search
	@Inject extension IModuleVersionMatcher
	
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
		return allModules.filter (typeof (Module)).toSet
	}
	
	def findCompatibleModules (Module module) {
		val allModules = findAllModules (module.eResource.resourceSet)
		allModules.filter (m | m.isCompatibleTo (module))
	}
	
	/* 
	 * Find all modules that provide the given service
	 */
	def findProvidingModules (Service service) {
		var Set<Module> allModules = findAllModules (service.eResource?.resourceSet)
		var providingModules = allModules.filter (m|m.providedServices.map (e|e.service).exists (s|s == service))
		val nsProvidingModules = allModules.filter (m|m.providedNamespaces.map (e|e.namespace.services).exists (s|s == service))
		providingModules.toSet.addAll (nsProvidingModules)
		return providingModules
	}
	
	def findProvidingModules (Service service, VersionRef versionRef) {
		var Set<Module> allModules = findAllModules (service.eResource?.resourceSet)
		var providingModules = allModules.filter (m|m.providedServices.map (e|e.service).exists(s|s == service))
		val nsProvidingModules = allModules.filter (m|m.providedNamespaces.map (e|e.namespace.services).exists(s|s == service))
		providingModules.toSet.addAll (nsProvidingModules)
		return providingModules
	}
	
	/* 
	 * Find all modules that provide the given service. from any of the candidate modules
	 */
	def findProvidingModules (Service service, Iterable<Module> candidateModules) {
		candidateModules.filter (cand| service.findProvidingModules.exists(m|m == cand))
	}
	
	/* 
	 * Find all modules that provide the given service, from any of the candidate modules, that 
	 * declare the given qualifier
	 */
	def findProvidingModules (Service service, Iterable<Module> candidateModules, String qualifierName) {
		service.findProvidingModules (candidateModules).filter (m|m.qualifiers.qualifiers.exists(q|q.name == qualifierName))
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
		
	def dispatch String getBindingQualifier (Module module) {
		module.endpointQualifier.name
	}
	
	def dispatch String getBindingQualifier (ModuleRef moduleRef) {
		if (moduleRef.endpointQualifier != null)
			return moduleRef.endpointQualifier.name
		else
			return (moduleRef.eContainer as Module).endpointQualifier.name
	}
	
	def dispatch String getBindingQualifier (ImportServiceRef impServiceRef) {
		if (impServiceRef.endpointQualifier != null)
			return impServiceRef.endpointQualifier.name
		else
			return (impServiceRef.eContainer as Module).endpointQualifier.name
	}
	
	/*
	 * Get the module that contains the model element.
	 */
	def dispatch getOwningModule (EObject modelElement) {
		if (modelElement?.eContainer != null)
			return modelElement.eContainer
		else 
			return null
	}
	
	/*
	 * Get the module that contains the model element. I.n this case the Module itself
	 */
	def dispatch getOwningModule (Module modelElement) {
		return modelElement
	}
}