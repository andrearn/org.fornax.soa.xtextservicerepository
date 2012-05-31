package org.fornax.soa.bindingdsl.generator.queries.modules

import org.fornax.soa.bindingDsl.ModuleBinding
import java.util.List
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.serviceDsl.Service
import com.google.inject.Inject
import org.fornax.soa.basedsl.search.IPredicateSearch
import com.google.common.base.Predicates
import org.eclipse.emf.ecore.resource.ResourceSet
import org.fornax.soa.bindingDsl.ServiceBinding
import java.util.Set
import org.fornax.soa.moduledsl.generator.query.ModuleServiceResolver
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.bindingDsl.DomainBinding
import org.eclipse.xtext.EcoreUtil2
import org.fornax.soa.moduledsl.moduleDsl.ImportBindingProtocol
import org.fornax.soa.bindingdsl.generator.queries.ProtocolMatcher
import org.fornax.soa.bindingDsl.OperationBinding
import org.eclipse.xtext.resource.IEObjectDescription
import org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef
import org.fornax.soa.bindingDsl.ModuleRef
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.bindingdsl.generator.queries.environment.EnvironmentBindingResolver

class ModuleBindingResolver {
	
	@Inject extension EnvironmentBindingResolver
	
	@Inject IPredicateSearch search
	@Inject ModuleServiceResolver moduleResolver
	@Inject ProtocolMatcher protocolMatcher

	def getAllBindings (ResourceSet rs) {
		var Set<IEObjectDescription> allBindingProxies = search.search("ModuleBinding ", Predicates::alwaysTrue).toSet
		allBindingProxies.addAll (search.search("DomainBinding ", Predicates::alwaysTrue))
		allBindingProxies.addAll (search.search("ServiceBinding ", Predicates::alwaysTrue))
		allBindingProxies.addAll (search.search("OperationBinding ", Predicates::alwaysTrue))
		var List<Binding> allBindings = newArrayList()
		for (bindingDesc : allBindingProxies) {
			val obj = bindingDesc.EObjectOrProxy
			if (obj instanceof Binding) {
				val binding = obj as Binding	
				if (binding.eIsProxy) {
					val resolvedBinding = EcoreUtil2::resolve (binding, rs) as Binding
					if (!resolvedBinding.eIsProxy) {
						allBindings.add (binding)
					}
				} else {
					allBindings.add (binding)
				}
			}
		}
		return allBindings
	}
	
	def ModuleBinding getImportModuleBinding (List<ModuleBinding> canditates, Module importMod, String envName) {
		canditates.findFirst (e|e.module == importMod && e.environment.name == envName );
	}
	
	/*
	 * Find all bindings for the given Service to any environment
	 */
	def Iterable<Binding> findMostSpecificBindings (Service service, Environment env) {
		val allBindings = getAllBindings(service.eResource?.resourceSet)
		var Set<Binding> bindings = newHashSet()
		val serviceBindings = allBindings.filter (typeof (ServiceBinding)).filter (b|b.resolveEnvironment == env && b.service.service == service)
		if (serviceBindings.empty) {
			val providingModules = moduleResolver.findProvidingModules(service)
			if (!providingModules.empty) {
				val moduleBindings = allBindings.filter (typeof (ModuleBinding)).filter (b|b.resolveEnvironment == env && providingModules.exists(m|m == b.module.module))
				bindings.addAll(moduleBindings)
			}
			val serviceNamespace = service.eContainer as SubNamespace
			val domainBindings = allBindings.filter (typeof (DomainBinding)).filter (b|b.resolveEnvironment == env && b.subNamespace == serviceNamespace)
			bindings.addAll(domainBindings)
		} else {
			bindings.addAll(serviceBindings)
		}
		return bindings
	}
	
	def Iterable<Binding> findMostSpecificBindings (Service service, Environment env, ImportBindingProtocol protocol) {
		return service.findMostSpecificBindings (env).filter (p|protocolMatcher.supportsImportBindingProtocol (p, protocol))
	}
	
	def Iterable<Binding> findMostSpecificBindings (Service service, Environment env, ImportBindingProtocol protocol, String qualifierName) {
		var Set<Binding> bindings = newHashSet()
		val serviceBindings = service.findMostSpecificBindings(env).filter (typeof (ServiceBinding))
		val moduleBindings = service.findMostSpecificBindings(env).filter (typeof (ModuleBinding))
		val domainBindings = service.findMostSpecificBindings(env).filter (typeof (DomainBinding))
		val serviceBindingsWithBindingQualifier = serviceBindings.filter (b | 
			b.eContainer instanceof ModuleBinding && 
			protocolMatcher.supportsImportBindingProtocol (b, protocol) &&
			(qualifierName == null || (b.eContainer as ModuleBinding).protocol.exists(p|p.qualifier.qualifierName.exists(bindQualifier|bindQualifier == qualifierName)))
		)
		bindings.addAll (serviceBindingsWithBindingQualifier)
		if (bindings.empty) {
			val moduleBindingsWithBindingQualifier = moduleBindings.filter (b | 
				protocolMatcher.supportsImportBindingProtocol (b, protocol) &&
				(qualifierName == null || b.protocol.exists(p|p.qualifier != null && p.qualifier.qualifierName.exists(bindQualifier|bindQualifier == qualifierName)))
			)
			bindings.addAll (moduleBindingsWithBindingQualifier)
		}
		if (bindings.empty) {
			val domainBindingsWithBindingQualifier = domainBindings.filter (b | 
				protocolMatcher.supportsImportBindingProtocol (b, protocol) &&
				(qualifierName == null || b.protocol.exists(p|p.qualifier != null && p.qualifier.qualifierName.exists(bindQualifier|bindQualifier == qualifierName)))
			)
			bindings.addAll (domainBindingsWithBindingQualifier)
		}
		return bindings.filter (p|protocolMatcher.supportsImportBindingProtocol (p, protocol))
	}
	
	/*
	 * Find all bindings for the given Service to any environment
	 */
	def Iterable<Binding> findMostSpecificBindings (Service service, Environment env, Iterable<Module> canditateModules) {
		val allBindings = getAllBindings(service.eResource?.resourceSet)
		var Set<Binding> bindings = newHashSet()
		val serviceBindings = allBindings.filter (typeof (ServiceBinding)).filter (b|b.resolveEnvironment == env && b.service.service == service)
		if (serviceBindings.empty) {
			val providingModules = moduleResolver.findProvidingModules(service, canditateModules)
			if (!providingModules.empty) {
				val moduleBindings = allBindings.filter (typeof (ModuleBinding)).filter (b|b.resolveEnvironment == env && providingModules.exists(m|m == b.module.module))
				bindings.addAll(moduleBindings)
			}
			val serviceNamespace = service.eContainer as SubNamespace
			val domainBindings = allBindings.filter (typeof (DomainBinding)).filter (b|b.resolveEnvironment == env && b.subNamespace == serviceNamespace)
			bindings.addAll(domainBindings)
		} else {
			bindings.addAll(serviceBindings)
		}
		return bindings
	}
	
	def Iterable<Binding> findMostSpecificBindings (Service service, Environment env, ImportBindingProtocol protocol, Iterable<Module> canditateModules) {
		return service.findMostSpecificBindings(env, canditateModules).filter (p|protocolMatcher.supportsImportBindingProtocol (p, protocol))
	}
	
	
	def Iterable<Binding> findMostSpecificBindings (Service service, Environment env, ImportBindingProtocol protocol, String qualifierName, Iterable<Module> scopedProviderModules) {
		var Set<Binding> bindings = newHashSet()
		val serviceBindings = service.findMostSpecificBindings(env).filter (typeof (ServiceBinding))
		val moduleBindings = service.findMostSpecificBindings(env).filter (typeof (ModuleBinding))
		val serviceBindingsWithBindingQualifier = serviceBindings.filter (b | 
				b.eContainer instanceof ModuleBinding && 
				protocolMatcher.supportsImportBindingProtocol (b, protocol) && 
				(qualifierName == null || b.protocol.exists (p|p.qualifier != null && p.qualifier.qualifierName.exists (bindQualifier|bindQualifier == qualifierName))) &&
				(scopedProviderModules.nullOrEmpty || scopedProviderModules.exists (m|m == (b.eContainer as ModuleBinding).module.module))
		)
		if (!serviceBindingsWithBindingQualifier.nullOrEmpty) {
			bindings.addAll (serviceBindingsWithBindingQualifier)
		}
		if (bindings.empty) {
			val moduleBindingsWithBindingQualifier = moduleBindings.filter (b | 
				protocolMatcher.supportsImportBindingProtocol (b, protocol) && 
				(scopedProviderModules.nullOrEmpty || scopedProviderModules.exists (m| m == b.module.module)) && 
				(qualifierName == null || b.protocol.exists(p|p.qualifier != null && p.qualifier.qualifierName.exists (bindQualifier|bindQualifier == qualifierName))))
			if (!moduleBindingsWithBindingQualifier.nullOrEmpty) {
				bindings.addAll (moduleBindingsWithBindingQualifier)
			}
		}
		return bindings.filter (p|protocolMatcher.supportsImportBindingProtocol (p, protocol))
	}
}