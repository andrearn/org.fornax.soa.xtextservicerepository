package org.fornax.soa.binding.query

import com.google.common.base.Predicates
import com.google.inject.Inject
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.resource.IEObjectDescription
import org.fornax.soa.basedsl.resource.IEObjectDescriptionBuilder
import org.fornax.soa.basedsl.search.IPredicateSearch
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver
import org.fornax.soa.binding.query.services.BindingServiceRefMatcher
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingDsl.ServiceBinding
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.moduledsl.moduleDsl.ImportBindingProtocol
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.moduledsl.query.ModuleLookup
import org.fornax.soa.profiledsl.scoping.versions.IVersionFilterProvider
import org.fornax.soa.semanticsDsl.Qualifier
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.binding.query.EndpointQualifierQueries
import org.fornax.soa.moduledsl.moduleDsl.EndpointQualifierRef

class BindingLookup {
	
	@Inject extension EnvironmentBindingResolver

	@Inject
	private IQualifiedNameProvider nameProvider
	@Inject
	private IPredicateSearch lookup
	@Inject
	private IEObjectDescriptionBuilder descBuilder
	@Inject	
	private IVersionFilterProvider versionFilterProvider
	@Inject
	private ModuleLookup moduleLookup
	@Inject
	private extension EndpointQualifierQueries	
	
	@Inject 
	private ProtocolMatcher protocolMatcher
	@Inject 
	private BindingServiceRefMatcher serviceRefMatcher
	
	/**
	 * Find all ModuleBindings that directly refer to this module or a compatible module and bind it to the given 
	 * target environment that satisfy the given endpoint qualifier or any endpoint qualifier in the binding if endpointQualifier
	 * is null
	 * 
	 * @param module 			The module to find a ModuleBinding for. Bindings to compatible module version are also considered
	 * @param targetEnvironment	The environment the bindings must bind to.
	 * @param endpointQualifier	Endpoint qualifier that must be effective in the binding. When null, endpoint qualifiers are ignored,
	 * 							i.e. all bindings that match the other criteria will be returned	 
	 */
	def Set<ModuleBinding> findBindingsToCompatibleModuleEnvAndQualifier (Module module, Environment targetEnvironment, Qualifier endpointQualifier) {
		val allBindings = getAllBindings(module.eResource?.resourceSet).filter (typeof (ModuleBinding))
		val compatibleModules = moduleLookup.findCompatibleModules(module).toSet
		if (endpointQualifier != null) {
			val Set<ModuleBinding> modBindings = newHashSet()
			for (b : allBindings) {
				var ModuleBinding bind = b
				if (b.eIsProxy) {
					bind = EcoreUtil2::resolve(b, module.eResource?.resourceSet) as ModuleBinding
				}
				if (compatibleModules.contains (bind.module.module) && bind.resolveEnvironment == targetEnvironment && (endpointQualifier == null || bind.potentialEffectiveEndpointQualifiers.containsEndpointQualifier(endpointQualifier))) {
					modBindings.add(bind)
				}
			}
			return modBindings
		} else  
			return allBindings.filter (e|compatibleModules.contains (e.module.module) && e.resolveEnvironment == targetEnvironment ).toSet;
	}
	
	/**
	 * Find all ModuleBindings that directly refer to this module or a compatible module and bind it to the given 
	 * target environment. Endpoint qualifiers are ignored.
	 * 
	 * @param module 			The module to find a ModuleBinding for. Bindings to compatible module version are also considered
	 * @param targetEnvironment	The environment the bindings must bind to.
	 */
	def Set<ModuleBinding> findBindingsToCompatibleModuleByEnv (Module module, Environment targetEnvironment) {
		val allBindings = getAllBindings(module.eResource?.resourceSet).filter (typeof (ModuleBinding))
		val compatibleModules = moduleLookup.findCompatibleModules(module).toSet
		return allBindings.filter (e|compatibleModules.contains (e.module.module) && e.resolveEnvironment == targetEnvironment ).toSet;
	}
	
	/**
	 * Find all ModuleBindings that directly refer to this module or a compatible module and bind it to any 
	 * target environment.
	 */
	def Set<ModuleBinding> findAllBindingsToCompatibleModule (Module module) {
		val allBindings = getAllBindings(module.eResource?.resourceSet).filter (typeof (ModuleBinding))
		val compatibleModules = moduleLookup.findCompatibleModules(module).toSet
		return allBindings.filter (e|compatibleModules.contains (e.module.module)).toSet
	}
	
	/**
	 * Find all ModuleBindings that directly refer to this module or a compatible module and bind it to any 
	 * target environment with the given endpoint qualifier or any endpoint qualifier in the binding if endpointQualifier
	 * is null.
	 */
	def Set<ModuleBinding> findAllBindingsToCompatibleModule (Module module, Qualifier endpointQualifier) {
		val allBindings = getAllBindings(module.eResource?.resourceSet).filter (typeof (ModuleBinding))
		val compatibleModules = moduleLookup.findCompatibleModules(module).toSet
		if (endpointQualifier != null) {
			val Set<ModuleBinding> modBindings = newHashSet()
			for (b : allBindings) {
				var ModuleBinding bind = b
				if (b.eIsProxy) {
					bind = EcoreUtil2::resolve(b, module.eResource?.resourceSet) as ModuleBinding
				}
				if (compatibleModules.contains (bind.module.module) && (endpointQualifier == null || bind.potentialEffectiveEndpointQualifiers.containsEndpointQualifier(endpointQualifier))) {
					modBindings.add(bind)
				}
			}
			return modBindings
		}
		else 
			return allBindings.filter (e|compatibleModules.contains (e.module.module)).toSet
	}
	
	/**
	 * Find all bindings for the given Service to an environment. The most specific bindings are returned. By default
	 * this is a ModuleBinding. However, if the ModuleBinding is overridden for a service with a ServiceBinding, the 
	 * respective ServiceBinding will be returned.
	 */
	def Iterable<Binding> findMostSpecificBindings (Service service, Environment env) {
		val allBindings = getAllBindings(service.eResource?.resourceSet)
		var Set<Binding> bindings = newHashSet()
		val serviceBindings = allBindings.filter (typeof (ServiceBinding)).filter (b|b.resolveEnvironment == env && b.service.service == service)
		if (serviceBindings.empty) {
			val providingModules = moduleLookup.findProvidingModules(service)
			if (!providingModules.empty) {
				val moduleBindings = allBindings.filter (typeof (ModuleBinding)).filter (b|b.resolveEnvironment == env && providingModules.exists(m|m == b.module.module))
				bindings.addAll(moduleBindings)
			}
		} else {
			bindings.addAll(serviceBindings)
		}
		return bindings
	}
	
	/*
	 * Find all bindings for the given Service to an environment that provide an endpoint with the given protocol. 
	 * The most specific bindings are returned. By default this is a ModuleBinding. However, if the ModuleBinding 
	 * is overridden for a service with a ServiceBinding, the respective ServiceBinding will be returned.
	 */
	def Iterable<Binding> findMostSpecificBindings (Service service, Environment env, ImportBindingProtocol protocol) {
		return service.findMostSpecificBindings (env).filter (p|protocolMatcher.supportsImportBindingProtocol (p, protocol))
	}
	
	/*
	 * Find the most specific Bindings of a Service to an Environment that support a protocol that matches the used 
	 * ImportBindingProtocol and the given endpoint qualifier. An endpoint qualifier is matched, if the Binding declares 
	 * it as one of it's endpoint qualifiers.
	 */
	def Iterable<Binding> findMostSpecificBindings (Service service, Environment env, ImportBindingProtocol protocol, EndpointQualifierRef endpointQualifier) {
		var Set<Binding> bindings = newHashSet()
		val serviceBindings = service.findMostSpecificBindings(env).filter (typeof (ServiceBinding))
		val moduleBindings = service.findMostSpecificBindings(env).filter (typeof (ModuleBinding))
		val serviceBindingsWithBindingQualifier = serviceBindings.filter (b | 
			b.eContainer instanceof ModuleBinding && 
			protocolMatcher.supportsImportBindingProtocol (b, protocol) &&
			(endpointQualifier == null || (b.eContainer as ModuleBinding).protocol.exists(p|p.effectiveEndpointQualifier == endpointQualifier?.endpointQualifier))
		)
		bindings.addAll (serviceBindingsWithBindingQualifier)
		if (bindings.empty) {
			val moduleBindingsWithBindingQualifier = moduleBindings.filter (b | 
				protocolMatcher.supportsImportBindingProtocol (b, protocol) &&
				(endpointQualifier == null || b.protocol.exists(p|p.endpointQualifierRef != null && p.effectiveEndpointQualifier == endpointQualifier?.endpointQualifier))
			)
			bindings.addAll (moduleBindingsWithBindingQualifier)
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
			val providingModules = moduleLookup.findProvidingModules(service, canditateModules)
			if (!providingModules.empty) {
				val moduleBindings = allBindings.filter (typeof (ModuleBinding)).filter (b|b.resolveEnvironment == env && providingModules.exists(m|m == b.module.module))
				bindings.addAll(moduleBindings)
			}
			val serviceNamespace = service.eContainer as SubNamespace
		} else {
			bindings.addAll(serviceBindings)
		}
		return bindings
	}
	
	def Iterable<Binding> findMostSpecificBindings (Service service, Environment env, ImportBindingProtocol protocol, Iterable<Module> canditateModules) {
		return service.findMostSpecificBindings(env, canditateModules).filter (p|protocolMatcher.supportsImportBindingProtocol (p, protocol))
	}
	
	
	//TODO REVIEW resolution when unqualified
	def Iterable<Binding> findMostSpecificBindings (Service service, Environment env, ImportBindingProtocol protocol, EndpointQualifierRef endpointQualifierRef, Iterable<Module> scopedProviderModules) {
		var Set<Binding> bindings = newHashSet()
		val serviceBindings = service.findMostSpecificBindings(env).filter (typeof (ServiceBinding))
		val moduleBindings = service.findMostSpecificBindings(env).filter (typeof (ModuleBinding))
		val serviceBindingsWithBindingQualifier = serviceBindings.filter (b | 
				b.eContainer instanceof ModuleBinding && 
				protocolMatcher.supportsImportBindingProtocol (b, protocol) && 
				(endpointQualifierRef == null || b.protocol.exists (p|p.endpointQualifierRef != null && p.effectiveEndpointQualifier == endpointQualifierRef.endpointQualifier)) &&
				(scopedProviderModules.nullOrEmpty || scopedProviderModules.exists (m|m == (b.eContainer as ModuleBinding).module.module))
		)
		if (!serviceBindingsWithBindingQualifier.nullOrEmpty) {
			bindings.addAll (serviceBindingsWithBindingQualifier)
		}
		if (bindings.empty) {
			val moduleBindingsWithBindingQualifier = moduleBindings.filter (b | 
				protocolMatcher.supportsImportBindingProtocol (b, protocol) && 
				(scopedProviderModules.nullOrEmpty || scopedProviderModules.exists (m| m == b.module.module)) && 
				(endpointQualifierRef == null || b.protocol.exists(p|p.endpointQualifierRef != null && p.effectiveEndpointQualifier == endpointQualifierRef.endpointQualifier)))
			if (!moduleBindingsWithBindingQualifier.nullOrEmpty) {
				bindings.addAll (moduleBindingsWithBindingQualifier)
			}
		}
		return bindings.filter (p|protocolMatcher.supportsImportBindingProtocol (p, protocol))
	}
	
	/**
	 * Get the most specific binding for service matching the given endpoint qualifier. The most specific binding is by default
	 * the top level binding. This might be overridden in a nested binding declaration. If such an override is defined, it will be
	 * returned instead.
	 */
	def dispatch Binding getMostSpecificBinding (Service service, Binding binding, EndpointQualifierRef endpointQualifier) {
		val candBind = service.getMostSpecificBinding (binding)
		val bindEndpointQualifiers = candBind.getPotentialEffectiveEndpointQualifiers
		if (endpointQualifier != null && candBind != null && bindEndpointQualifiers.containsEndpointQualifier(endpointQualifier.endpointQualifier)) {
			return candBind
		} else if (endpointQualifier == null) {
			return candBind
		} else {
			return null
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
	
	/**
	 * Get all Bindings defined in the model. This includes ModuleBindings, ServiceBindings and OperationBindings
	 */
	def getAllBindings (ResourceSet rs) {
		var Set<IEObjectDescription> allBindingDescs = lookup.search("ModuleBinding ", Predicates::alwaysTrue).toSet
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


}