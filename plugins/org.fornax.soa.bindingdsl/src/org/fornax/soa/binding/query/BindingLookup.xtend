package org.fornax.soa.binding.query

import org.fornax.soa.serviceDsl.Service
import org.eclipse.emf.ecore.resource.ResourceSet
import java.util.Set
import org.eclipse.xtext.resource.IEObjectDescription
import com.google.common.base.Predicates
import java.util.List
import org.fornax.soa.bindingDsl.Binding
import org.eclipse.xtext.EcoreUtil2
import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.fornax.soa.basedsl.scoping.versions.VersionComparator
import org.fornax.soa.basedsl.search.IEObjectLookup
import org.fornax.soa.basedsl.search.IReferenceSearch
import org.fornax.soa.basedsl.search.IPredicateSearch
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.basedsl.resource.IEObjectDescriptionBuilder
import org.fornax.soa.profiledsl.scoping.versions.IVersionFilterProvider
import org.fornax.soa.bindingDsl.ServiceBinding
import org.fornax.soa.moduledsl.query.ModuleLookup
import org.fornax.soa.bindingDsl.DomainBinding
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver
import org.fornax.soa.moduledsl.query.ModuleServiceResolver
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.moduledsl.moduleDsl.ImportBindingProtocol
import org.fornax.soa.moduledsl.moduleDsl.AbstractServiceRef
import org.fornax.soa.moduledsl.query.IModuleVersionMatcher
import org.fornax.soa.semanticsDsl.Qualifier
import org.fornax.soa.basedsl.version.VersionMatcher
import org.fornax.soa.moduledsl.query.ServiceRefMatcher

class BindingLookup {
	
	@Inject
	private IQualifiedNameProvider nameProvider
	@Inject
	private VersionComparator versionComparator
	@Inject
	private IEObjectLookup ieObjectLookup
	@Inject
	private IReferenceSearch refLookup
	@Inject
	private IPredicateSearch lookup
	@Inject
	private	IStateMatcher stateMatcher
	@Inject
	private IEObjectDescriptionBuilder descBuilder
	@Inject	
	private IVersionFilterProvider versionFilterProvider
	@Inject
	private ModuleLookup moduleLookup	
	@Inject extension EnvironmentBindingResolver
	
	@Inject IPredicateSearch search
	@Inject ModuleServiceResolver moduleResolver
	@Inject ProtocolMatcher protocolMatcher
	@Inject VersionMatcher versionMatcher
	@Inject private BindingServiceRefMatcher serviceRefMatcher
	
	def getAllBindings (ResourceSet rs) {
		var Set<IEObjectDescription> allBindingDescs = lookup.search("ModuleBinding ", Predicates::alwaysTrue).toSet
		allBindingDescs.addAll (lookup.search("DomainBinding ", Predicates::alwaysTrue))
		allBindingDescs.addAll (lookup.search("ServiceBinding ", Predicates::alwaysTrue))
		allBindingDescs.addAll (lookup.search("OperationBinding ", Predicates::alwaysTrue))
		var List<Binding> allBindings = newArrayList()
		for (bindingDesc : allBindingDescs) {
			val obj = bindingDesc.EObjectOrProxy
			if (obj instanceof Binding) {
				val binding = obj as Binding	
				if (binding.eIsProxy) {
					val resolvedBinding = EcoreUtil2::resolve (binding, rs) as Binding
					if (!resolvedBinding.eIsProxy) {
						allBindings.add (resolvedBinding)
					}
				} else {
					allBindings.add (binding)
				}
			}
		}
		return allBindings
	}
	
	
	def ModuleBinding getImportModuleBinding (List<ModuleBinding> canditates, Module importMod, String envName) {
		canditates.findFirst (e|e.module.module == importMod && e.environment.name == envName );
	}
	
	/*
	 * Find all ModuleBindings that directly refer to this module and bind it to the given 
	 * target environment
	 */
	def Set<ModuleBinding> findBindingsToModule (Module module, String envName) {
		val allBindings = getAllBindings(module.eResource?.resourceSet).filter (typeof (ModuleBinding))
		allBindings.filter (e|e.module.module == module && e.environment.name == envName ).toSet;
	}
	
	/*
	 * Find all ModuleBindings of the candidates that directly refer to this module and bind it to the given 
	 * target environment
	 */
	def Set<ModuleBinding> findBindingsToModule (List<ModuleBinding> canditates, Module importMod, String envName) {
		canditates.filter (e|e.module.module == importMod && e.environment.name == envName ).toSet;
	}

	/*
	 * Find all ModuleBindings that directly refer to this module or a compatible module and bind it to the given 
	 * target environment
	 */
	def Set<ModuleBinding> findBindingsToCompatibleModule (Module module, Environment targetEnvironment) {
		val allBindings = getAllBindings(module.eResource?.resourceSet).filter (typeof (ModuleBinding))
		val compatibleModules = moduleLookup.findCompatibleModules(module).toSet
		return allBindings.filter (e|compatibleModules.contains (e.module.module) && e.environment == targetEnvironment ).toSet;
	}
	
	/*
	 * Find all ModuleBindings of the candidates that refer to this module or a compatible module and bind it to the given 
	 * target environment
	 */
	def Set<ModuleBinding> findAllBindingsToCompatibleModule (List<ModuleBinding> canditates, Module module, Environment targetEnvironment) {
		val compatibleModules = moduleLookup.findCompatibleModules(module).toSet
		return canditates.filter (e|compatibleModules.contains (e.module.module) && e.environment == targetEnvironment ).toSet;
	}
	/*
	 * Find all ModuleBindings that directly refer to this module or a compatible module and bind it to the given 
	 * target environment
	 */
	def Set<ModuleBinding> findAllBindingsToCompatibleModule (Module module) {
		val allBindings = getAllBindings(module.eResource?.resourceSet).filter (typeof (ModuleBinding))
		val compatibleModules = moduleLookup.findCompatibleModules(module).toSet
		return allBindings.filter (e|compatibleModules.contains (e.module.module)).toSet;
	}
	
	/**
	 * Find all bindings for the given Service to an environment
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
	
	/*
	 * get the specific defined Binding of a Service to an Environment that support a protocol that matches the used 
	 * ImportBindingProtocol
	 */
	def Iterable<Binding> findMostSpecificBindings (Service service, Environment env, ImportBindingProtocol protocol) {
		return service.findMostSpecificBindings (env).filter (p|protocolMatcher.supportsImportBindingProtocol (p, protocol))
	}
	
	/*
	 * Find the most specific Bindings of a Service to an Environment that support a protocol that matches the used 
	 * ImportBindingProtocol and the given endpoint qualifier. An endpoint qualifier is matched, if the Binding declares 
	 * it as one of it's endpoint qualifiers.
	 */
	def Iterable<Binding> findMostSpecificBindings (Service service, Environment env, ImportBindingProtocol protocol, Qualifier endpointQualifier) {
		var Set<Binding> bindings = newHashSet()
		val serviceBindings = service.findMostSpecificBindings(env).filter (typeof (ServiceBinding))
		val moduleBindings = service.findMostSpecificBindings(env).filter (typeof (ModuleBinding))
		val domainBindings = service.findMostSpecificBindings(env).filter (typeof (DomainBinding))
		val serviceBindingsWithBindingQualifier = serviceBindings.filter (b | 
			b.eContainer instanceof ModuleBinding && 
			protocolMatcher.supportsImportBindingProtocol (b, protocol) &&
			(endpointQualifier == null || (b.eContainer as ModuleBinding).protocol.exists(p|p.endpointQualifierRefs.endpointQualifiers.exists(bindQualifier|bindQualifier == endpointQualifier)))
		)
		bindings.addAll (serviceBindingsWithBindingQualifier)
		if (bindings.empty) {
			val moduleBindingsWithBindingQualifier = moduleBindings.filter (b | 
				protocolMatcher.supportsImportBindingProtocol (b, protocol) &&
				(endpointQualifier == null || b.protocol.exists(p|p.endpointQualifierRefs != null && p.endpointQualifierRefs.endpointQualifiers.exists(bindQualifier|bindQualifier == endpointQualifier)))
			)
			bindings.addAll (moduleBindingsWithBindingQualifier)
		}
		if (bindings.empty) {
			val domainBindingsWithBindingQualifier = domainBindings.filter (b | 
				protocolMatcher.supportsImportBindingProtocol (b, protocol) &&
				(endpointQualifier == null || b.protocol.exists(p|p.endpointQualifierRefs != null && p.endpointQualifierRefs.endpointQualifiers.exists(bindQualifier|bindQualifier == endpointQualifier)))
			)
			bindings.addAll (domainBindingsWithBindingQualifier)
		}
		return bindings.filter (p|protocolMatcher.supportsImportBindingProtocol (p, protocol))
	}
	
	/*
	 * Find all bindings for the given Service to any environment, where the service is provided by one of
	 * the candidate modules
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
	
	
	def Iterable<Binding> findMostSpecificBindings (Service service, Environment env, ImportBindingProtocol protocol, Qualifier qualifier, Iterable<Module> scopedProviderModules) {
		var Set<Binding> bindings = newHashSet()
		val serviceBindings = service.findMostSpecificBindings(env).filter (typeof (ServiceBinding))
		val moduleBindings = service.findMostSpecificBindings(env).filter (typeof (ModuleBinding))
		val serviceBindingsWithBindingQualifier = serviceBindings.filter (b | 
				b.eContainer instanceof ModuleBinding && 
				protocolMatcher.supportsImportBindingProtocol (b, protocol) && 
				(qualifier == null || b.protocol.exists (p|p.endpointQualifierRefs != null && p.endpointQualifierRefs.endpointQualifiers.exists (q|q == qualifier))) &&
				(scopedProviderModules.nullOrEmpty || scopedProviderModules.exists (m|m == (b.eContainer as ModuleBinding).module.module))
		)
		if (!serviceBindingsWithBindingQualifier.nullOrEmpty) {
			bindings.addAll (serviceBindingsWithBindingQualifier)
		}
		if (bindings.empty) {
			val moduleBindingsWithBindingQualifier = moduleBindings.filter (b | 
				protocolMatcher.supportsImportBindingProtocol (b, protocol) && 
				(scopedProviderModules.nullOrEmpty || scopedProviderModules.exists (m| m == b.module.module)) && 
				(qualifier == null || b.protocol.exists(p|p.endpointQualifierRefs != null && p.endpointQualifierRefs.endpointQualifiers.exists (q|q == qualifier))))
			if (!moduleBindingsWithBindingQualifier.nullOrEmpty) {
				bindings.addAll (moduleBindingsWithBindingQualifier)
			}
		}
		return bindings.filter (p|protocolMatcher.supportsImportBindingProtocol (p, protocol))
	}
	
	def dispatch Binding getMostSpecificBinding (Service service, Binding binding, Qualifier endpointQualifier) {
		val candBind = service.getMostSpecificBinding (binding)
		if (endpointQualifier != null && candBind != null && candBind.endpointQualifierRefs.endpointQualifiers.contains (endpointQualifier)) {
			return binding
		}
	}

	def dispatch Binding getMostSpecificBinding (Service service, ModuleBinding binding) {
		if (!binding.serviceBindings.empty) {
			for (svcBind : binding.serviceBindings) {
				if (serviceRefMatcher.matches(service, svcBind.service)) {
					return svcBind
				}
			}
		}
		return binding
	}
	def dispatch Binding getMostSpecificBinding (Service service, ServiceBinding binding) {
		if (binding.service.service == service)
			return binding
		else
			return null
	}
	def dispatch getMostSpecificBinding (Service service, DomainBinding binding) {
		if (!binding.serviceBinding.empty) {
			for (svcBind : binding.serviceBinding) {
				if (serviceRefMatcher.matches(service, svcBind.service)) {
					return svcBind
				}
			}
		}
	}
	
	/*
	 * Check, whether the given Binding applies to the given Service
	 */
	def dispatch isBindingApplicable (Binding bind, Service svc) {
		return false
	}
	
	/*
	 * Check, whether the given Binding applies to the given Module
	 */
	def dispatch isBindingApplicable (ModuleBinding bind, Module mod) {
		var versionFilter = versionFilterProvider.createVersionFilter (bind.module.versionRef)
		if (bind.module.module == mod || 
			(nameProvider.getFullyQualifiedName(bind.module.module) == nameProvider.getFullyQualifiedName(mod)
				&& versionFilter.matches (descBuilder.buildDescription (mod))
			)
		) {
			return true
		} else {
			return false
		}
	}
	
	/*
	 * Check, whether the given Binding applies to the given Module and Service
	 */
	def isBindingApplicable (ModuleBinding bind, Module mod, Service svc) {
		var versionFilter = versionFilterProvider.createVersionFilter (bind.module.versionRef)
		if (bind.module.module == mod || 
			(nameProvider.getFullyQualifiedName(bind.module.module) == nameProvider.getFullyQualifiedName(mod)
				&& versionFilter.matches (descBuilder.buildDescription (mod))
			)
		) {
			return true
		} else {
			return false
		}
	}
	
	/*
	 * Check, whether the given Binding applies to the given Service
	 */
	def dispatch isBindingApplicable (ModuleBinding bind, Service svc) {
		var candModules = moduleLookup.findProvidingModules (svc)
		var versionFilter = versionFilterProvider.createVersionFilter (bind.module.versionRef)
		for (mod : candModules)
			if (bind.module.module == mod || 
				(nameProvider.getFullyQualifiedName (bind.module.module) == nameProvider.getFullyQualifiedName(mod)
					&& versionFilter.matches (descBuilder.buildDescription (mod))
				)
			) {
				return true
			}
		return false
	}
	
	/*
	 * Check, whether the given Binding applies to the given Service
	 */
	def dispatch isBindingApplicable (ServiceBinding bind, Service svc) {
		var versionFilter = versionFilterProvider.createVersionFilter (bind.service.versionRef)
		if (bind.service.service == svc || 
			(nameProvider.getFullyQualifiedName (bind.service.service) == nameProvider.getFullyQualifiedName (svc)
				&& versionFilter.matches (descBuilder.buildDescription (svc))
			)
		) {
			return true
		} else {
			return false
		}
	}

	/*
	 * Check, whether the given Binding applies to the given Service
	 */
	def dispatch isBindingApplicable (DomainBinding bind, Service svc) {
		if (bind.subNamespace == svc.eContainer) {
			return true
		} else {
			return false
		}
	}

}