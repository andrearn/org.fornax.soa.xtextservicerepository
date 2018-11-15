package org.xkonnex.repo.dsl.bindingdsl.binding.query

import com.google.common.base.Predicates
import com.google.inject.Inject
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.resource.IEObjectDescription
import org.xkonnex.repo.dsl.basedsl.resource.IEObjectDescriptionBuilder
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.EnvironmentBindingResolver
import org.xkonnex.repo.dsl.bindingdsl.binding.query.services.BindingServiceRefMatcher
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ChannelBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.OperationBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ServiceBinding
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointQualifierRef
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.moduledsl.query.IModuleServiceResolver
import org.xkonnex.repo.dsl.moduledsl.query.IModuleVersionMatcher
import org.xkonnex.repo.dsl.moduledsl.query.ModuleLookup
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.IVersionFilterProvider
import org.xkonnex.repo.dsl.semanticsdsl.semanticsDsl.Qualifier
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.bindingdsl.binding.query.EndpointQualifierQueries
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource
import org.xkonnex.repo.dsl.bindingdsl.binding.query.resource.BindingResourceRefMatcher
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ResourceBinding
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.AbstractOperation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ResourceOperation

/**
 * Lookup of Bindings for different criteria, e.g. find a binding for a module to an environment
 */
class BindingLookup {
	
	@Inject extension EnvironmentBindingResolver
	@Inject extension IModuleVersionMatcher

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
	private IModuleServiceResolver modServiceResolver
	@Inject
	private extension EndpointQualifierQueries	
	
	@Inject 
	private ProtocolMatcher protocolMatcher
	@Inject 
	private BindingServiceRefMatcher serviceRefMatcher
	@Inject
	private BindingResourceRefMatcher resourceRefMatcher
	
	/**
	 * Find all ModuleBindings that refer to this module by name and version constraint and bind it to the given 
	 * target environment that satisfy the given endpoint qualifier or any endpoint qualifier in the binding if endpointQualifier
	 * is null
	 * 
	 * @param module 			The module to find a ModuleBinding for. Bindings referring to this module version 
	 * 							are concerning the version constraint from the binding are considered
	 * @param targetEnvironment	The environment the bindings must bind to.
	 * @param endpointQualifier	Endpoint qualifier that must be effective in the binding. When null, endpoint qualifiers are ignored,
	 * 							i.e. all bindings that match the other criteria will be returned	 
	 * @return applicable bindings
	 */
	def Set<ModuleBinding> findApplicableBindingsToModuleByEnvAndQualifier (Module module, Environment targetEnvironment, Qualifier endpointQualifier) {
		val allBindings = getAllBindings(module.eResource?.resourceSet).filter (typeof (ModuleBinding))
		val Set<ModuleBinding> modBindings = newHashSet()
		for (b : allBindings) {
			var ModuleBinding bind = b
			if (b.eIsProxy) {
				bind = EcoreUtil2::resolve(b, module.eResource?.resourceSet) as ModuleBinding
			}
			val referredModuleName = nameProvider.getFullyQualifiedName(bind.module.module)
			if (module.isEffectivelyReferencedVersion (referredModuleName, bind.module.versionRef) && bind.resolveEnvironment == targetEnvironment && (endpointQualifier === null || bind.potentialEffectiveEndpointQualifiers.containsEndpointQualifier(endpointQualifier))) {
				modBindings.add(bind)
			}
		}
		return modBindings
	}
	
	/**
	 * Find all ModuleBindings that refer to this module by name and version constraint and bind it to the given 
	 * target environment. Endpoint qualifiers are ignored.
	 * 
	 * @param module 			The module to find a ModuleBinding for. Bindings referring to this module version 
	 * 							are concerning the version constraint from the binding are considered
	 * @param targetEnvironment	The environment the bindings must bind to.
	 * @return applicable bindings
	 */
	def Set<ModuleBinding> findApplicableBindingsToModuleByEnv (Module module, Environment targetEnvironment) {
		val allBindings = getAllBindings(module.eResource?.resourceSet).filter (typeof (ModuleBinding))
		val Set<ModuleBinding> modBindings = newHashSet()
		for (b : allBindings) {
			var ModuleBinding bind = b
			if (b.eIsProxy) {
				bind = EcoreUtil2::resolve(b, module.eResource?.resourceSet) as ModuleBinding
			}
			val referredModuleName = nameProvider.getFullyQualifiedName(bind.module.module)
			if (module.isEffectivelyReferencedVersion (referredModuleName, bind.module.versionRef) && bind.resolveEnvironment == targetEnvironment) {
				modBindings.add(bind)
			}
		}
		return modBindings
	}
	
	/**
	 * Find all ModuleBindings that refer to this module by name and version constraint and bind it to any 
	 * target environment.
	 * 
	 * @param module 			The module to find a ModuleBinding for. Bindings referring to this module version 
	 * 							are concerning the version constraint from the binding are considered
	 * @return applicable bindings
	 */
	def Set<ModuleBinding> findAllApplicableBindingsToModule (Module module) {
		val allBindings = getAllBindings(module.eResource?.resourceSet).filter (typeof (ModuleBinding))
		val Set<ModuleBinding> modBindings = newHashSet()
		for (b : allBindings) {
			var ModuleBinding bind = b
			if (b.eIsProxy) {
				bind = EcoreUtil2::resolve(b, module.eResource?.resourceSet) as ModuleBinding
			}
			val referredModuleName = nameProvider.getFullyQualifiedName(bind.module.module)
			if (module.isEffectivelyReferencedVersion (referredModuleName, bind.module.versionRef)) {
				modBindings.add(bind)
			}
		}
		return modBindings
	}
	
	/**
	 * Find all ModuleBindings that that refer to this module by name and version constraint and bind it to any 
	 * target environment with the given endpoint qualifier or any endpoint qualifier in the binding if endpointQualifier
	 * is null.
	 * 
	 * @param module 			The module to find bindings for
	 * @param endpointQualifier The endpointQualifier with which the Bindings must be tagged
	 * @return applicable bindings
	 */
	def Set<ModuleBinding> findAllApplicableBindingsToModuleByQualifier (Module module, Qualifier endpointQualifier) {
		val allBindings = getAllBindings(module.eResource?.resourceSet).filter (typeof (ModuleBinding))
		val Set<ModuleBinding> modBindings = newHashSet()
		for (b : allBindings) {
			var ModuleBinding bind = b
			if (b.eIsProxy) {
				bind = EcoreUtil2::resolve(b, module.eResource?.resourceSet) as ModuleBinding
			}
			val referredModuleName = nameProvider.getFullyQualifiedName(bind.module.module)
			if (module.isEffectivelyReferencedVersion (referredModuleName, bind.module.versionRef) && (endpointQualifier === null || bind.potentialEffectiveEndpointQualifiers.containsEndpointQualifier(endpointQualifier))) {
				modBindings.add(bind)
			}
		}
		return modBindings
	}
	
	/**
	 * Find all ModuleBindings that <b>explicitly</b> refer to this module and bind it to any 
	 * target environment.
	 * 
	 * @param module The module to find bindings for
	 * @return applicable bindings
	 */
	def Set<ModuleBinding> findAllExplicitBindingsToModule (Module module) {
		val allBindings = getAllBindings(module.eResource?.resourceSet).filter (typeof (ModuleBinding))
		val Set<ModuleBinding> modBindings = newHashSet()
		for (b : allBindings) {
			var ModuleBinding bind = b
			if (b.eIsProxy) {
				bind = EcoreUtil2::resolve(b, module.eResource?.resourceSet) as ModuleBinding
			}
			val referredModuleName = nameProvider.getFullyQualifiedName(bind.module.module)
			if (module.isEffectivelyReferencedVersion (referredModuleName, bind.module.versionRef)) {
				modBindings.add(bind)
			}
		}
		return modBindings
	}
	/**
	 * Find all ModuleBindings that <b>explicitly</b> refer to this module and bind it to any 
	 * target environment with the given endpoint qualifier or any endpoint qualifier in the binding if endpointQualifier
	 * is null.
	 * 
	 * @param module The module to find bindings for
	 * @param endpointQualifier The endpointQualifier with which the Bindings must be tagged
	 * @return explicitly matching bindings
	 */
	def Set<ModuleBinding> findAllExplicitBindingsToModuleByQualifier (Module module, Qualifier endpointQualifier) {
		val allBindings = getAllBindings(module.eResource?.resourceSet).filter (typeof (ModuleBinding))
		val Set<ModuleBinding> modBindings = newHashSet()
		for (b : allBindings) {
			var ModuleBinding bind = b
			if (b.eIsProxy) {
				bind = EcoreUtil2::resolve(b, module.eResource?.resourceSet) as ModuleBinding
			}
			if (module == bind.module.module && (endpointQualifier === null || bind.potentialEffectiveEndpointQualifiers.containsEndpointQualifier(endpointQualifier))) {
				modBindings.add(bind)
			}
		}
		return modBindings
	}
	
	
	/**
	 * Get the most specific binding for the service matching that is tagged with the given endpoint qualifier. 
	 * The most specific binding is by default the top level binding. This might be overridden in a nested binding 
	 * declaration. If such an override is defined, it will be returned instead.
	 * 
	 * @param service The {@link Service} to find a binding for
	 * @param binding A {@link Binding} on a higher/more generic level
	 * @param endpointQualifier A narrowing qualifier that selects an endpoint/type of binding
	 * @return the most specific {@link Binding} for this {@link Service} 
	 */
	def Binding getMostSpecificBinding (Service service, Binding binding, EndpointQualifierRef endpointQualifier) {
		val candBind = service.getMostSpecificBinding (binding)
		val bindEndpointQualifiers = candBind.getPotentialEffectiveEndpointQualifiers
		if (endpointQualifier !== null && candBind !== null && bindEndpointQualifiers.containsEndpointQualifier(endpointQualifier.endpointQualifier)) {
			return candBind
		} else if (endpointQualifier === null) {
			return candBind
		} else {
			return null
		}
	}
	/**
	 * Get the most specific binding for the service matching that is tagged with the given endpoint qualifier. 
	 * The most specific binding is by default the top level binding. This might be overridden in a nested binding 
	 * declaration. If such an override is defined, it will be returned instead.

	 * @param resource The {@link Resource} to find a binding for
	 * @param binding A {@link Binding} on a higher/more generic level
	 * @param endpointQualifier A narrowing qualifier that selects an endpoint/type of binding
	 * @return the most specific {@link Binding} for this {@link Service} 
	 */
	def Binding getMostSpecificBinding (Resource resource, Binding binding, EndpointQualifierRef endpointQualifier) {
		val candBind = resource.getMostSpecificBinding (binding)
		val bindEndpointQualifiers = candBind.getPotentialEffectiveEndpointQualifiers
		if (endpointQualifier !== null && candBind !== null && bindEndpointQualifiers.containsEndpointQualifier(endpointQualifier.endpointQualifier)) {
			return candBind
		} else if (endpointQualifier === null) {
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
	def dispatch Binding getMostSpecificBinding (Resource resource, ModuleBinding binding) {
		
		if (!binding.resourceBindings.empty) {
			for (resBind : binding.resourceBindings) {
				if (resourceRefMatcher.matches(resource, resBind.resource)) {
					return resBind
				}
			}
		}
		return binding
	}
	def dispatch Binding getMostSpecificBinding (Resource resource, ResourceBinding binding) {
		if (binding.resource.resource == resource)
			return binding
		else
			return null
	}
	
	def dispatch AnyBinding getMostSpecificOperationBinding (AbstractOperation operation, AnyBinding binding) {
		return null
	}
	def dispatch AnyBinding getMostSpecificOperationBinding (AbstractOperation operation, OperationBinding binding) {
		if (binding.operation == operation)
			return binding
		else
			return null
	}
	
	def dispatch AnyBinding getMostSpecificOperationBinding (AbstractOperation operation, ServiceBinding binding) {
		if (binding.operation == operation)
			return binding
		else
			return null
	}
	
	def dispatch AnyBinding getMostSpecificOperationBinding (AbstractOperation operation, ResourceBinding binding) {
		if (binding.operation == operation)
			return binding
		else
			return null
	}
	
	def dispatch AnyBinding getMostSpecificOperationBinding (AbstractOperation operation, ModuleBinding binding) {
		
	}
	def dispatch AnyBinding getMostSpecificOperationBinding (Operation operation, ModuleBinding binding) {
		val service = EcoreUtil2.getContainerOfType(operation, typeof (Service))
		if (!binding.serviceBindings.empty) {
			for (svcBind : binding.serviceBindings) {
				if (serviceRefMatcher.matches(service, svcBind.service)) {
					for (opBind : svcBind.operation) {
						if (opBind.operation == operation) {
							return opBind
						}
					}
					return svcBind
				}
			}
		}
		return binding
	}
	def dispatch AnyBinding getMostSpecificOperationBinding (ResourceOperation operation, ModuleBinding binding) {
		val resource = EcoreUtil2.getContainerOfType(operation, typeof (Resource))
		if (!binding.resourceBindings.empty) {
			for (resBind : binding.resourceBindings) {
				if (resourceRefMatcher.matches(resource, resBind.resource)) {
					for (opBind : resBind.operation) {
						if (opBind.operation == operation) {
							return opBind
						}
					}
					return resBind
				}
			}
		}
		return binding
	}
	
	def dispatch AnyBinding getMostSpecificOperationBinding (AbstractOperation operation, AnyBinding binding, EndpointQualifierRef endpointQualifier) {
		return null
	}
	def dispatch AnyBinding getMostSpecificOperationBinding (AbstractOperation operation, OperationBinding binding, EndpointQualifierRef endpointQualifier) {
		if (binding.operation == operation)
			return binding
		else
			return null
	}
	
	def dispatch AnyBinding getMostSpecificOperationBinding (AbstractOperation operation, ServiceBinding binding, EndpointQualifierRef endpointQualifier) {
		if (binding.operation == operation)
			return binding
		else
			return null
	}
	
	def dispatch AnyBinding getMostSpecificOperationBinding (AbstractOperation operation, ModuleBinding binding, EndpointQualifierRef endpointQualifier) {
		val service = EcoreUtil2.getContainerOfType(operation, typeof (Service))
		if (!binding.serviceBindings.empty) {
			for (svcBind : binding.serviceBindings) {
				if (serviceRefMatcher.matches(service, svcBind.service)) {
					for (opBind : svcBind.operation) {
						if (opBind.operation == operation) {
							val bindEndpointQualifiers = opBind.getPotentialEffectiveEndpointQualifiers
							if (endpointQualifier !== null && opBind !== null && bindEndpointQualifiers.containsEndpointQualifier(endpointQualifier.endpointQualifier)) {
								return opBind
							} else if (endpointQualifier === null) {
								return opBind
							} else {
								return null
							}
						}
					}
					val bindEndpointQualifiers = svcBind.getPotentialEffectiveEndpointQualifiers
					if (endpointQualifier !== null && svcBind !== null && bindEndpointQualifiers.containsEndpointQualifier(endpointQualifier.endpointQualifier)) {
						return svcBind
					} else if (endpointQualifier === null) {
						return svcBind
					} else {
						return null
					}
				}
			}
		}
		return binding
	}
	def dispatch AnyBinding getMostSpecificOperationBinding (ResourceOperation operation, ModuleBinding binding, EndpointQualifierRef endpointQualifier) {
		val resource = EcoreUtil2.getContainerOfType(operation, typeof (Resource))
		if (!binding.resourceBindings.empty) {
			for (resBind : binding.resourceBindings) {
				if (resourceRefMatcher.matches(resource, resBind.resource)) {
					for (opBind : resBind.operation) {
						if (opBind.operation == operation) {
							val bindEndpointQualifiers = opBind.getPotentialEffectiveEndpointQualifiers
							if (endpointQualifier !== null && opBind !== null && bindEndpointQualifiers.containsEndpointQualifier(endpointQualifier.endpointQualifier)) {
								return opBind
							} else if (endpointQualifier === null) {
								return opBind
							} else {
								return null
							}
						}
					}
					val bindEndpointQualifiers = resBind.getPotentialEffectiveEndpointQualifiers
					if (endpointQualifier !== null && resBind !== null && bindEndpointQualifiers.containsEndpointQualifier(endpointQualifier.endpointQualifier)) {
						return resBind
					} else if (endpointQualifier === null) {
						return resBind
					} else {
						return null
					}
				}
			}
		}
		return binding
	}
	
	def List<AnyBinding> getBottomUpBindingHierarchy(Service service, ModuleBinding binding) {
		val specBind = getMostSpecificBinding(service, binding);
		var hierarchy = getBottomUpHierarchyForSpecificBinding(specBind)
		hierarchy
	}
	def List<AnyBinding> getBottomUpBindingHierarchy(Resource resource, ModuleBinding binding) {
		val specBind = getMostSpecificBinding(resource, binding);
		var hierarchy = getBottomUpHierarchyForSpecificBinding(specBind)
		hierarchy
	}
	def List<AnyBinding> getBottomUpBindingHierarchy(AbstractOperation operation, ModuleBinding binding) {
		val specBind = getMostSpecificOperationBinding(operation, binding);
		var hierarchy = getBottomUpHierarchyForSpecificBinding(specBind)
		hierarchy
	}
	
	def List<AnyBinding> getBottomUpHierarchyForSpecificBinding(AnyBinding specBind) {
		var List<AnyBinding> hierarchy = newArrayList()
		val opBind = EcoreUtil2.getContainerOfType(specBind, typeof(OperationBinding))
		val channelBind = EcoreUtil2.getContainerOfType(specBind, typeof(ChannelBinding))
		val svcBind = EcoreUtil2.getContainerOfType(specBind, typeof(ServiceBinding))
		val resBind = EcoreUtil2.getContainerOfType(specBind, typeof(ResourceBinding))
		val modBind = EcoreUtil2.getContainerOfType(specBind, typeof(ModuleBinding))
		if (opBind !== null)
			hierarchy+=opBind
		if (channelBind !== null)
			hierarchy+=channelBind
		if (svcBind !== null)
			hierarchy+=svcBind
		if (resBind !== null)
			hierarchy+=resBind
		if (modBind !== null)
			hierarchy+=modBind
		hierarchy
	}
	
	/**
	 * Get all Bindings defined in the model. This includes ModuleBindings, ServiceBindings and OperationBindings
	 * 
	 * @param rs The {@link ResourceSet} that loads the model
	 * @return all {@link Binding}s defined in the model loaded by the {@link ResourceSet}
	 */
	def getAllBindings (ResourceSet rs) {
		var Set<IEObjectDescription> allBindingDescs = lookup.search("ModuleBinding ", Predicates::alwaysTrue, rs).toSet
		allBindingDescs.addAll (lookup.search("ServiceBinding ", Predicates::alwaysTrue))
		allBindingDescs.addAll (lookup.search("ResourceBinding ", Predicates::alwaysTrue))
		allBindingDescs.addAll (lookup.search("ResourceBinding ", Predicates::alwaysTrue))
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
	
	/**
	 * Check, whether the given Binding applies to the given Service
	 */
	def dispatch isBindingApplicable (Binding bind, Service svc) {
		return false
	}
	
	/**
	 * Check, whether the given Binding applies to the given Module. The Binding is applicable,
	 * if it references the given module or a later compatible version
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
	
	/**
	 * Check, whether the given Binding applies to the given Module and Service The Binding is applicable,
	 * if it references the given module or a later compatible version and the module provides the service.
	 * 
	 * @param bind a {@link ModuleBinding} to check
	 * @param mod the suspect Module that should be bound
	 * @param svc a {@link Service} in the Module mod
	 * 
	 * @return true, if the  ModuloeBinding bind binds the Service inside the Module mod
	 */
	def isBindingApplicable (ModuleBinding bind, Module mod, Service svc) {
		var versionFilter = versionFilterProvider.createVersionFilter (bind.module.versionRef)
		if ((bind.module.module == mod || 
			(nameProvider.getFullyQualifiedName(bind.module.module) == nameProvider.getFullyQualifiedName(mod)
				&& versionFilter.matches (descBuilder.buildDescription (mod))
			) && modServiceResolver.getAllProvidedServiceRefs(bind.module.module).map(r|r.service).toList.contains(svc))
		) {
			return true
		} else {
			return false
		}
	}
	
	/**
	 * Check, whether the given Binding applies to the given Service
	 */
	def dispatch isBindingApplicable (ModuleBinding bind, Service svc) {
		var candModules = moduleLookup.findProvidingModules (svc)
		var versionFilter = versionFilterProvider.createVersionFilter (bind.module.versionRef)
		for (mod : candModules) {
			if (bind.module.module == mod || 
				(nameProvider.getFullyQualifiedName (bind.module.module) == nameProvider.getFullyQualifiedName(mod)
					&& versionFilter.matches (descBuilder.buildDescription (mod))
				)
			) {
				return true
			}
		}
		return false
	}
	/**
	 * Check, whether the given Binding applies to the given Resource
	 */
	def dispatch isBindingApplicable (ModuleBinding bind, Resource res) {
		var candModules = moduleLookup.findProvidingModules (res)
		var versionFilter = versionFilterProvider.createVersionFilter (bind.module.versionRef)
		for (mod : candModules) {
			if (bind.module.module == mod || 
				(nameProvider.getFullyQualifiedName (bind.module.module) == nameProvider.getFullyQualifiedName(mod)
					&& versionFilter.matches (descBuilder.buildDescription (mod))
				)
			) {
				return true
			}
		}
		return false
	}
	
	/**
	 * Check, whether the given Binding applies to the given Service
	 */
	def dispatch isBindingApplicable (ServiceBinding bind, Service service) {
		var versionFilter = versionFilterProvider.createVersionFilter (bind.service.versionRef)
		if (bind.service.service == service || 
			(nameProvider.getFullyQualifiedName (bind.service.service) == nameProvider.getFullyQualifiedName (service)
				&& versionFilter.matches (descBuilder.buildDescription (service))
			)
		) {
			return true
		} else {
			return false
		}
	}
	/**
	 * Check, whether the given Binding applies to the given Resource
	 */
	def dispatch isBindingApplicable (ResourceBinding bind, Resource resource) {
		var versionFilter = versionFilterProvider.createVersionFilter (bind.resource.versionRef)
		if (bind.resource.resource == resource || 
			(nameProvider.getFullyQualifiedName (bind.resource.resource) == nameProvider.getFullyQualifiedName (resource)
				&& versionFilter.matches (descBuilder.buildDescription (resource))
			)
		) {
			return true
		} else {
			return false
		}
	}


}