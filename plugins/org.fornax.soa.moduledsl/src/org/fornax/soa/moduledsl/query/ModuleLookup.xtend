package org.fornax.soa.moduledsl.query

import com.google.inject.Inject
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher
import org.fornax.soa.basedsl.search.IPredicateSearch
import org.eclipse.emf.ecore.resource.ResourceSet
import java.util.List
import org.fornax.soa.moduledsl.moduleDsl.Module
import com.google.common.base.Predicates
import org.eclipse.xtext.EcoreUtil2
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.moduledsl.moduleDsl.ModuleRef
import org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef

class ModuleLookup {
	
	@Inject IStateMatcher stateMatcher
	@Inject IPredicateSearch search
	
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
		service.findProvidingModules (canditateModules).filter (m|m.qualifiers.qualifierName.contains(qualifierName))
	}	
		
	def dispatch String getBindingQualifier (Module module) {
		module.bindingQualifier
	}
	
	def dispatch String getBindingQualifier (ModuleRef moduleRef) {
		if (moduleRef.bindingQualifier != null)
			return moduleRef.bindingQualifier
		else
			return (moduleRef.eContainer as Module).bindingQualifier
	}
	
	def dispatch String getBindingQualifier (ImportServiceRef impServiceRef) {
		if (impServiceRef.bindingQualifier != null)
			return impServiceRef.bindingQualifier
		else
			return (impServiceRef.eContainer as Module).bindingQualifier
	}
}