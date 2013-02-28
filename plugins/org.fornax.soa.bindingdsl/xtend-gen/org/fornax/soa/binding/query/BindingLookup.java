package org.fornax.soa.binding.query;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.basedsl.resource.IEObjectDescriptionBuilder;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.basedsl.scoping.versions.filter.VersionFilter;
import org.fornax.soa.basedsl.search.IPredicateSearch;
import org.fornax.soa.binding.EndpointQualifierDescriptor;
import org.fornax.soa.binding.query.EndpointQualifierQueries;
import org.fornax.soa.binding.query.ProtocolMatcher;
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver;
import org.fornax.soa.binding.query.services.BindingServiceRefMatcher;
import org.fornax.soa.bindingDsl.Binding;
import org.fornax.soa.bindingDsl.BindingProtocol;
import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.bindingDsl.ModuleRef;
import org.fornax.soa.bindingDsl.ServiceBinding;
import org.fornax.soa.bindingDsl.ServiceRef;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.moduledsl.moduleDsl.EndpointQualifierRef;
import org.fornax.soa.moduledsl.moduleDsl.ImportBindingProtocol;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.moduledsl.query.ModuleLookup;
import org.fornax.soa.profiledsl.scoping.versions.IVersionFilterProvider;
import org.fornax.soa.semanticsDsl.Qualifier;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.SubNamespace;

@SuppressWarnings("all")
public class BindingLookup {
  @Inject
  private EnvironmentBindingResolver _environmentBindingResolver;
  
  @Inject
  private IQualifiedNameProvider nameProvider;
  
  @Inject
  private IPredicateSearch lookup;
  
  @Inject
  private IEObjectDescriptionBuilder descBuilder;
  
  @Inject
  private IVersionFilterProvider versionFilterProvider;
  
  @Inject
  private ModuleLookup moduleLookup;
  
  @Inject
  private EndpointQualifierQueries _endpointQualifierQueries;
  
  @Inject
  private ProtocolMatcher protocolMatcher;
  
  @Inject
  private BindingServiceRefMatcher serviceRefMatcher;
  
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
  public Set<ModuleBinding> findBindingsToCompatibleModuleEnvAndQualifier(final Module module, final Environment targetEnvironment, final Qualifier endpointQualifier) {
    Resource _eResource = module.eResource();
    ResourceSet _resourceSet = _eResource==null?(ResourceSet)null:_eResource.getResourceSet();
    List<Binding> _allBindings = this.getAllBindings(_resourceSet);
    final Iterable<ModuleBinding> allBindings = Iterables.<ModuleBinding>filter(_allBindings, ModuleBinding.class);
    Iterable<Module> _findCompatibleModules = this.moduleLookup.findCompatibleModules(module);
    final Set<Module> compatibleModules = IterableExtensions.<Module>toSet(_findCompatibleModules);
    boolean _notEquals = (!Objects.equal(endpointQualifier, null));
    if (_notEquals) {
      final Set<ModuleBinding> modBindings = CollectionLiterals.<ModuleBinding>newHashSet();
      for (final ModuleBinding b : allBindings) {
        {
          ModuleBinding bind = b;
          boolean _eIsProxy = b.eIsProxy();
          if (_eIsProxy) {
            Resource _eResource_1 = module.eResource();
            ResourceSet _resourceSet_1 = _eResource_1==null?(ResourceSet)null:_eResource_1.getResourceSet();
            EObject _resolve = EcoreUtil2.resolve(b, _resourceSet_1);
            bind = ((ModuleBinding) _resolve);
          }
          boolean _and = false;
          boolean _and_1 = false;
          ModuleRef _module = bind.getModule();
          Module _module_1 = _module.getModule();
          boolean _contains = compatibleModules.contains(_module_1);
          if (!_contains) {
            _and_1 = false;
          } else {
            Environment _resolveEnvironment = this._environmentBindingResolver.resolveEnvironment(bind);
            boolean _equals = Objects.equal(_resolveEnvironment, targetEnvironment);
            _and_1 = (_contains && _equals);
          }
          if (!_and_1) {
            _and = false;
          } else {
            boolean _or = false;
            boolean _equals_1 = Objects.equal(endpointQualifier, null);
            if (_equals_1) {
              _or = true;
            } else {
              EndpointQualifierDescriptor _potentialEffectiveEndpointQualifiers = this._endpointQualifierQueries.getPotentialEffectiveEndpointQualifiers(bind);
              boolean _containsEndpointQualifier = _potentialEffectiveEndpointQualifiers.containsEndpointQualifier(endpointQualifier);
              _or = (_equals_1 || _containsEndpointQualifier);
            }
            _and = (_and_1 && _or);
          }
          if (_and) {
            modBindings.add(bind);
          }
        }
      }
      return modBindings;
    } else {
      final Function1<ModuleBinding,Boolean> _function = new Function1<ModuleBinding,Boolean>() {
          public Boolean apply(final ModuleBinding e) {
            boolean _and = false;
            ModuleRef _module = e.getModule();
            Module _module_1 = _module.getModule();
            boolean _contains = compatibleModules.contains(_module_1);
            if (!_contains) {
              _and = false;
            } else {
              Environment _resolveEnvironment = BindingLookup.this._environmentBindingResolver.resolveEnvironment(e);
              boolean _equals = Objects.equal(_resolveEnvironment, targetEnvironment);
              _and = (_contains && _equals);
            }
            return Boolean.valueOf(_and);
          }
        };
      Iterable<ModuleBinding> _filter = IterableExtensions.<ModuleBinding>filter(allBindings, _function);
      return IterableExtensions.<ModuleBinding>toSet(_filter);
    }
  }
  
  /**
   * Find all ModuleBindings that directly refer to this module or a compatible module and bind it to the given
   * target environment. Endpoint qualifiers are ignored.
   * 
   * @param module 			The module to find a ModuleBinding for. Bindings to compatible module version are also considered
   * @param targetEnvironment	The environment the bindings must bind to.
   */
  public Set<ModuleBinding> findBindingsToCompatibleModuleByEnv(final Module module, final Environment targetEnvironment) {
    Resource _eResource = module.eResource();
    ResourceSet _resourceSet = _eResource==null?(ResourceSet)null:_eResource.getResourceSet();
    List<Binding> _allBindings = this.getAllBindings(_resourceSet);
    final Iterable<ModuleBinding> allBindings = Iterables.<ModuleBinding>filter(_allBindings, ModuleBinding.class);
    Iterable<Module> _findCompatibleModules = this.moduleLookup.findCompatibleModules(module);
    final Set<Module> compatibleModules = IterableExtensions.<Module>toSet(_findCompatibleModules);
    final Function1<ModuleBinding,Boolean> _function = new Function1<ModuleBinding,Boolean>() {
        public Boolean apply(final ModuleBinding e) {
          boolean _and = false;
          ModuleRef _module = e.getModule();
          Module _module_1 = _module.getModule();
          boolean _contains = compatibleModules.contains(_module_1);
          if (!_contains) {
            _and = false;
          } else {
            Environment _resolveEnvironment = BindingLookup.this._environmentBindingResolver.resolveEnvironment(e);
            boolean _equals = Objects.equal(_resolveEnvironment, targetEnvironment);
            _and = (_contains && _equals);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<ModuleBinding> _filter = IterableExtensions.<ModuleBinding>filter(allBindings, _function);
    return IterableExtensions.<ModuleBinding>toSet(_filter);
  }
  
  /**
   * Find all ModuleBindings that directly refer to this module or a compatible module and bind it to any
   * target environment.
   */
  public Set<ModuleBinding> findAllBindingsToCompatibleModule(final Module module) {
    Resource _eResource = module.eResource();
    ResourceSet _resourceSet = _eResource==null?(ResourceSet)null:_eResource.getResourceSet();
    List<Binding> _allBindings = this.getAllBindings(_resourceSet);
    final Iterable<ModuleBinding> allBindings = Iterables.<ModuleBinding>filter(_allBindings, ModuleBinding.class);
    Iterable<Module> _findCompatibleModules = this.moduleLookup.findCompatibleModules(module);
    final Set<Module> compatibleModules = IterableExtensions.<Module>toSet(_findCompatibleModules);
    final Function1<ModuleBinding,Boolean> _function = new Function1<ModuleBinding,Boolean>() {
        public Boolean apply(final ModuleBinding e) {
          ModuleRef _module = e.getModule();
          Module _module_1 = _module.getModule();
          boolean _contains = compatibleModules.contains(_module_1);
          return Boolean.valueOf(_contains);
        }
      };
    Iterable<ModuleBinding> _filter = IterableExtensions.<ModuleBinding>filter(allBindings, _function);
    return IterableExtensions.<ModuleBinding>toSet(_filter);
  }
  
  /**
   * Find all ModuleBindings that directly refer to this module or a compatible module and bind it to any
   * target environment with the given endpoint qualifier or any endpoint qualifier in the binding if endpointQualifier
   * is null.
   */
  public Set<ModuleBinding> findAllBindingsToCompatibleModule(final Module module, final Qualifier endpointQualifier) {
    Resource _eResource = module.eResource();
    ResourceSet _resourceSet = _eResource==null?(ResourceSet)null:_eResource.getResourceSet();
    List<Binding> _allBindings = this.getAllBindings(_resourceSet);
    final Iterable<ModuleBinding> allBindings = Iterables.<ModuleBinding>filter(_allBindings, ModuleBinding.class);
    Iterable<Module> _findCompatibleModules = this.moduleLookup.findCompatibleModules(module);
    final Set<Module> compatibleModules = IterableExtensions.<Module>toSet(_findCompatibleModules);
    boolean _notEquals = (!Objects.equal(endpointQualifier, null));
    if (_notEquals) {
      final Set<ModuleBinding> modBindings = CollectionLiterals.<ModuleBinding>newHashSet();
      for (final ModuleBinding b : allBindings) {
        {
          ModuleBinding bind = b;
          boolean _eIsProxy = b.eIsProxy();
          if (_eIsProxy) {
            Resource _eResource_1 = module.eResource();
            ResourceSet _resourceSet_1 = _eResource_1==null?(ResourceSet)null:_eResource_1.getResourceSet();
            EObject _resolve = EcoreUtil2.resolve(b, _resourceSet_1);
            bind = ((ModuleBinding) _resolve);
          }
          boolean _and = false;
          ModuleRef _module = bind.getModule();
          Module _module_1 = _module.getModule();
          boolean _contains = compatibleModules.contains(_module_1);
          if (!_contains) {
            _and = false;
          } else {
            boolean _or = false;
            boolean _equals = Objects.equal(endpointQualifier, null);
            if (_equals) {
              _or = true;
            } else {
              EndpointQualifierDescriptor _potentialEffectiveEndpointQualifiers = this._endpointQualifierQueries.getPotentialEffectiveEndpointQualifiers(bind);
              boolean _containsEndpointQualifier = _potentialEffectiveEndpointQualifiers.containsEndpointQualifier(endpointQualifier);
              _or = (_equals || _containsEndpointQualifier);
            }
            _and = (_contains && _or);
          }
          if (_and) {
            modBindings.add(bind);
          }
        }
      }
      return modBindings;
    } else {
      final Function1<ModuleBinding,Boolean> _function = new Function1<ModuleBinding,Boolean>() {
          public Boolean apply(final ModuleBinding e) {
            ModuleRef _module = e.getModule();
            Module _module_1 = _module.getModule();
            boolean _contains = compatibleModules.contains(_module_1);
            return Boolean.valueOf(_contains);
          }
        };
      Iterable<ModuleBinding> _filter = IterableExtensions.<ModuleBinding>filter(allBindings, _function);
      return IterableExtensions.<ModuleBinding>toSet(_filter);
    }
  }
  
  /**
   * Find all bindings for the given Service to an environment. The most specific bindings are returned. By default
   * this is a ModuleBinding. However, if the ModuleBinding is overridden for a service with a ServiceBinding, the
   * respective ServiceBinding will be returned.
   */
  public Iterable<Binding> findMostSpecificBindings(final Service service, final Environment env) {
    Resource _eResource = service.eResource();
    ResourceSet _resourceSet = _eResource==null?(ResourceSet)null:_eResource.getResourceSet();
    final List<Binding> allBindings = this.getAllBindings(_resourceSet);
    Set<Binding> bindings = CollectionLiterals.<Binding>newHashSet();
    Iterable<ServiceBinding> _filter = Iterables.<ServiceBinding>filter(allBindings, ServiceBinding.class);
    final Function1<ServiceBinding,Boolean> _function = new Function1<ServiceBinding,Boolean>() {
        public Boolean apply(final ServiceBinding b) {
          boolean _and = false;
          Environment _resolveEnvironment = BindingLookup.this._environmentBindingResolver.resolveEnvironment(b);
          boolean _equals = Objects.equal(_resolveEnvironment, env);
          if (!_equals) {
            _and = false;
          } else {
            ServiceRef _service = b.getService();
            Service _service_1 = _service.getService();
            boolean _equals_1 = Objects.equal(_service_1, service);
            _and = (_equals && _equals_1);
          }
          return Boolean.valueOf(_and);
        }
      };
    final Iterable<ServiceBinding> serviceBindings = IterableExtensions.<ServiceBinding>filter(_filter, _function);
    boolean _isEmpty = IterableExtensions.isEmpty(serviceBindings);
    if (_isEmpty) {
      final Iterable<Module> providingModules = this.moduleLookup.findProvidingModules(service);
      boolean _isEmpty_1 = IterableExtensions.isEmpty(providingModules);
      boolean _not = (!_isEmpty_1);
      if (_not) {
        Iterable<ModuleBinding> _filter_1 = Iterables.<ModuleBinding>filter(allBindings, ModuleBinding.class);
        final Function1<ModuleBinding,Boolean> _function_1 = new Function1<ModuleBinding,Boolean>() {
            public Boolean apply(final ModuleBinding b) {
              boolean _and = false;
              Environment _resolveEnvironment = BindingLookup.this._environmentBindingResolver.resolveEnvironment(b);
              boolean _equals = Objects.equal(_resolveEnvironment, env);
              if (!_equals) {
                _and = false;
              } else {
                final Function1<Module,Boolean> _function = new Function1<Module,Boolean>() {
                    public Boolean apply(final Module m) {
                      ModuleRef _module = b.getModule();
                      Module _module_1 = _module.getModule();
                      boolean _equals = Objects.equal(m, _module_1);
                      return Boolean.valueOf(_equals);
                    }
                  };
                boolean _exists = IterableExtensions.<Module>exists(providingModules, _function);
                _and = (_equals && _exists);
              }
              return Boolean.valueOf(_and);
            }
          };
        final Iterable<ModuleBinding> moduleBindings = IterableExtensions.<ModuleBinding>filter(_filter_1, _function_1);
        Iterables.<Binding>addAll(bindings, moduleBindings);
      }
    } else {
      Iterables.<Binding>addAll(bindings, serviceBindings);
    }
    return bindings;
  }
  
  /**
   * Find all bindings for the given Service to an environment that provide an endpoint with the given protocol.
   * The most specific bindings are returned. By default this is a ModuleBinding. However, if the ModuleBinding
   * is overridden for a service with a ServiceBinding, the respective ServiceBinding will be returned.
   */
  public Iterable<Binding> findMostSpecificBindings(final Service service, final Environment env, final ImportBindingProtocol protocol) {
    Iterable<Binding> _findMostSpecificBindings = this.findMostSpecificBindings(service, env);
    final Function1<Binding,Boolean> _function = new Function1<Binding,Boolean>() {
        public Boolean apply(final Binding p) {
          boolean _supportsImportBindingProtocol = BindingLookup.this.protocolMatcher.supportsImportBindingProtocol(p, protocol);
          return Boolean.valueOf(_supportsImportBindingProtocol);
        }
      };
    return IterableExtensions.<Binding>filter(_findMostSpecificBindings, _function);
  }
  
  /**
   * Find the most specific Bindings of a Service to an Environment that support a protocol that matches the used
   * ImportBindingProtocol and the given endpoint qualifier. An endpoint qualifier is matched, if the Binding declares
   * it as one of it's endpoint qualifiers.
   */
  public Iterable<Binding> findMostSpecificBindings(final Service service, final Environment env, final ImportBindingProtocol protocol, final EndpointQualifierRef endpointQualifier) {
    Set<Binding> bindings = CollectionLiterals.<Binding>newHashSet();
    Iterable<Binding> _findMostSpecificBindings = this.findMostSpecificBindings(service, env);
    final Iterable<ServiceBinding> serviceBindings = Iterables.<ServiceBinding>filter(_findMostSpecificBindings, ServiceBinding.class);
    Iterable<Binding> _findMostSpecificBindings_1 = this.findMostSpecificBindings(service, env);
    final Iterable<ModuleBinding> moduleBindings = Iterables.<ModuleBinding>filter(_findMostSpecificBindings_1, ModuleBinding.class);
    final Function1<ServiceBinding,Boolean> _function = new Function1<ServiceBinding,Boolean>() {
        public Boolean apply(final ServiceBinding b) {
          boolean _and = false;
          boolean _and_1 = false;
          EObject _eContainer = b.eContainer();
          if (!(_eContainer instanceof ModuleBinding)) {
            _and_1 = false;
          } else {
            boolean _supportsImportBindingProtocol = BindingLookup.this.protocolMatcher.supportsImportBindingProtocol(b, protocol);
            _and_1 = ((_eContainer instanceof ModuleBinding) && _supportsImportBindingProtocol);
          }
          if (!_and_1) {
            _and = false;
          } else {
            boolean _or = false;
            boolean _equals = Objects.equal(endpointQualifier, null);
            if (_equals) {
              _or = true;
            } else {
              EObject _eContainer_1 = b.eContainer();
              EList<BindingProtocol> _protocol = ((ModuleBinding) _eContainer_1).getProtocol();
              final Function1<BindingProtocol,Boolean> _function = new Function1<BindingProtocol,Boolean>() {
                  public Boolean apply(final BindingProtocol p) {
                    Qualifier _effectiveEndpointQualifier = BindingLookup.this._endpointQualifierQueries.getEffectiveEndpointQualifier(p);
                    Qualifier _endpointQualifier = endpointQualifier==null?(Qualifier)null:endpointQualifier.getEndpointQualifier();
                    boolean _equals = Objects.equal(_effectiveEndpointQualifier, _endpointQualifier);
                    return Boolean.valueOf(_equals);
                  }
                };
              boolean _exists = IterableExtensions.<BindingProtocol>exists(_protocol, _function);
              _or = (_equals || _exists);
            }
            _and = (_and_1 && _or);
          }
          return Boolean.valueOf(_and);
        }
      };
    final Iterable<ServiceBinding> serviceBindingsWithBindingQualifier = IterableExtensions.<ServiceBinding>filter(serviceBindings, _function);
    Iterables.<Binding>addAll(bindings, serviceBindingsWithBindingQualifier);
    boolean _isEmpty = bindings.isEmpty();
    if (_isEmpty) {
      final Function1<ModuleBinding,Boolean> _function_1 = new Function1<ModuleBinding,Boolean>() {
          public Boolean apply(final ModuleBinding b) {
            boolean _and = false;
            boolean _supportsImportBindingProtocol = BindingLookup.this.protocolMatcher.supportsImportBindingProtocol(b, protocol);
            if (!_supportsImportBindingProtocol) {
              _and = false;
            } else {
              boolean _or = false;
              boolean _equals = Objects.equal(endpointQualifier, null);
              if (_equals) {
                _or = true;
              } else {
                EList<BindingProtocol> _protocol = b.getProtocol();
                final Function1<BindingProtocol,Boolean> _function = new Function1<BindingProtocol,Boolean>() {
                    public Boolean apply(final BindingProtocol p) {
                      boolean _and = false;
                      org.fornax.soa.bindingDsl.EndpointQualifierRef _endpointQualifierRef = p.getEndpointQualifierRef();
                      boolean _notEquals = (!Objects.equal(_endpointQualifierRef, null));
                      if (!_notEquals) {
                        _and = false;
                      } else {
                        Qualifier _effectiveEndpointQualifier = BindingLookup.this._endpointQualifierQueries.getEffectiveEndpointQualifier(p);
                        Qualifier _endpointQualifier = endpointQualifier==null?(Qualifier)null:endpointQualifier.getEndpointQualifier();
                        boolean _equals = Objects.equal(_effectiveEndpointQualifier, _endpointQualifier);
                        _and = (_notEquals && _equals);
                      }
                      return Boolean.valueOf(_and);
                    }
                  };
                boolean _exists = IterableExtensions.<BindingProtocol>exists(_protocol, _function);
                _or = (_equals || _exists);
              }
              _and = (_supportsImportBindingProtocol && _or);
            }
            return Boolean.valueOf(_and);
          }
        };
      final Iterable<ModuleBinding> moduleBindingsWithBindingQualifier = IterableExtensions.<ModuleBinding>filter(moduleBindings, _function_1);
      Iterables.<Binding>addAll(bindings, moduleBindingsWithBindingQualifier);
    }
    final Function1<Binding,Boolean> _function_2 = new Function1<Binding,Boolean>() {
        public Boolean apply(final Binding p) {
          boolean _supportsImportBindingProtocol = BindingLookup.this.protocolMatcher.supportsImportBindingProtocol(p, protocol);
          return Boolean.valueOf(_supportsImportBindingProtocol);
        }
      };
    return IterableExtensions.<Binding>filter(bindings, _function_2);
  }
  
  /**
   * Find all bindings for the given Service to any environment, where the service is provided by one of
   * the candidate modules
   */
  public Iterable<Binding> findMostSpecificBindings(final Service service, final Environment env, final Iterable<Module> canditateModules) {
    Resource _eResource = service.eResource();
    ResourceSet _resourceSet = _eResource==null?(ResourceSet)null:_eResource.getResourceSet();
    final List<Binding> allBindings = this.getAllBindings(_resourceSet);
    Set<Binding> bindings = CollectionLiterals.<Binding>newHashSet();
    Iterable<ServiceBinding> _filter = Iterables.<ServiceBinding>filter(allBindings, ServiceBinding.class);
    final Function1<ServiceBinding,Boolean> _function = new Function1<ServiceBinding,Boolean>() {
        public Boolean apply(final ServiceBinding b) {
          boolean _and = false;
          Environment _resolveEnvironment = BindingLookup.this._environmentBindingResolver.resolveEnvironment(b);
          boolean _equals = Objects.equal(_resolveEnvironment, env);
          if (!_equals) {
            _and = false;
          } else {
            ServiceRef _service = b.getService();
            Service _service_1 = _service.getService();
            boolean _equals_1 = Objects.equal(_service_1, service);
            _and = (_equals && _equals_1);
          }
          return Boolean.valueOf(_and);
        }
      };
    final Iterable<ServiceBinding> serviceBindings = IterableExtensions.<ServiceBinding>filter(_filter, _function);
    boolean _isEmpty = IterableExtensions.isEmpty(serviceBindings);
    if (_isEmpty) {
      final Iterable<Module> providingModules = this.moduleLookup.findProvidingModules(service, canditateModules);
      boolean _isEmpty_1 = IterableExtensions.isEmpty(providingModules);
      boolean _not = (!_isEmpty_1);
      if (_not) {
        Iterable<ModuleBinding> _filter_1 = Iterables.<ModuleBinding>filter(allBindings, ModuleBinding.class);
        final Function1<ModuleBinding,Boolean> _function_1 = new Function1<ModuleBinding,Boolean>() {
            public Boolean apply(final ModuleBinding b) {
              boolean _and = false;
              Environment _resolveEnvironment = BindingLookup.this._environmentBindingResolver.resolveEnvironment(b);
              boolean _equals = Objects.equal(_resolveEnvironment, env);
              if (!_equals) {
                _and = false;
              } else {
                final Function1<Module,Boolean> _function = new Function1<Module,Boolean>() {
                    public Boolean apply(final Module m) {
                      ModuleRef _module = b.getModule();
                      Module _module_1 = _module.getModule();
                      boolean _equals = Objects.equal(m, _module_1);
                      return Boolean.valueOf(_equals);
                    }
                  };
                boolean _exists = IterableExtensions.<Module>exists(providingModules, _function);
                _and = (_equals && _exists);
              }
              return Boolean.valueOf(_and);
            }
          };
        final Iterable<ModuleBinding> moduleBindings = IterableExtensions.<ModuleBinding>filter(_filter_1, _function_1);
        Iterables.<Binding>addAll(bindings, moduleBindings);
      }
      EObject _eContainer = service.eContainer();
      final SubNamespace serviceNamespace = ((SubNamespace) _eContainer);
    } else {
      Iterables.<Binding>addAll(bindings, serviceBindings);
    }
    return bindings;
  }
  
  public Iterable<Binding> findMostSpecificBindings(final Service service, final Environment env, final ImportBindingProtocol protocol, final Iterable<Module> canditateModules) {
    Iterable<Binding> _findMostSpecificBindings = this.findMostSpecificBindings(service, env, canditateModules);
    final Function1<Binding,Boolean> _function = new Function1<Binding,Boolean>() {
        public Boolean apply(final Binding p) {
          boolean _supportsImportBindingProtocol = BindingLookup.this.protocolMatcher.supportsImportBindingProtocol(p, protocol);
          return Boolean.valueOf(_supportsImportBindingProtocol);
        }
      };
    return IterableExtensions.<Binding>filter(_findMostSpecificBindings, _function);
  }
  
  public Iterable<Binding> findMostSpecificBindings(final Service service, final Environment env, final ImportBindingProtocol protocol, final EndpointQualifierRef endpointQualifierRef, final Iterable<Module> scopedProviderModules) {
    Set<Binding> bindings = CollectionLiterals.<Binding>newHashSet();
    Iterable<Binding> _findMostSpecificBindings = this.findMostSpecificBindings(service, env);
    final Iterable<ServiceBinding> serviceBindings = Iterables.<ServiceBinding>filter(_findMostSpecificBindings, ServiceBinding.class);
    Iterable<Binding> _findMostSpecificBindings_1 = this.findMostSpecificBindings(service, env);
    final Iterable<ModuleBinding> moduleBindings = Iterables.<ModuleBinding>filter(_findMostSpecificBindings_1, ModuleBinding.class);
    final Function1<ServiceBinding,Boolean> _function = new Function1<ServiceBinding,Boolean>() {
        public Boolean apply(final ServiceBinding b) {
          boolean _and = false;
          boolean _and_1 = false;
          boolean _and_2 = false;
          EObject _eContainer = b.eContainer();
          if (!(_eContainer instanceof ModuleBinding)) {
            _and_2 = false;
          } else {
            boolean _supportsImportBindingProtocol = BindingLookup.this.protocolMatcher.supportsImportBindingProtocol(b, protocol);
            _and_2 = ((_eContainer instanceof ModuleBinding) && _supportsImportBindingProtocol);
          }
          if (!_and_2) {
            _and_1 = false;
          } else {
            boolean _or = false;
            boolean _equals = Objects.equal(endpointQualifierRef, null);
            if (_equals) {
              _or = true;
            } else {
              EList<BindingProtocol> _protocol = b.getProtocol();
              final Function1<BindingProtocol,Boolean> _function = new Function1<BindingProtocol,Boolean>() {
                  public Boolean apply(final BindingProtocol p) {
                    boolean _and = false;
                    org.fornax.soa.bindingDsl.EndpointQualifierRef _endpointQualifierRef = p.getEndpointQualifierRef();
                    boolean _notEquals = (!Objects.equal(_endpointQualifierRef, null));
                    if (!_notEquals) {
                      _and = false;
                    } else {
                      Qualifier _effectiveEndpointQualifier = BindingLookup.this._endpointQualifierQueries.getEffectiveEndpointQualifier(p);
                      Qualifier _endpointQualifier = endpointQualifierRef.getEndpointQualifier();
                      boolean _equals = Objects.equal(_effectiveEndpointQualifier, _endpointQualifier);
                      _and = (_notEquals && _equals);
                    }
                    return Boolean.valueOf(_and);
                  }
                };
              boolean _exists = IterableExtensions.<BindingProtocol>exists(_protocol, _function);
              _or = (_equals || _exists);
            }
            _and_1 = (_and_2 && _or);
          }
          if (!_and_1) {
            _and = false;
          } else {
            boolean _or_1 = false;
            boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(scopedProviderModules);
            if (_isNullOrEmpty) {
              _or_1 = true;
            } else {
              final Function1<Module,Boolean> _function_1 = new Function1<Module,Boolean>() {
                  public Boolean apply(final Module m) {
                    EObject _eContainer = b.eContainer();
                    ModuleRef _module = ((ModuleBinding) _eContainer).getModule();
                    Module _module_1 = _module.getModule();
                    boolean _equals = Objects.equal(m, _module_1);
                    return Boolean.valueOf(_equals);
                  }
                };
              boolean _exists_1 = IterableExtensions.<Module>exists(scopedProviderModules, _function_1);
              _or_1 = (_isNullOrEmpty || _exists_1);
            }
            _and = (_and_1 && _or_1);
          }
          return Boolean.valueOf(_and);
        }
      };
    final Iterable<ServiceBinding> serviceBindingsWithBindingQualifier = IterableExtensions.<ServiceBinding>filter(serviceBindings, _function);
    boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(serviceBindingsWithBindingQualifier);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      Iterables.<Binding>addAll(bindings, serviceBindingsWithBindingQualifier);
    }
    boolean _isEmpty = bindings.isEmpty();
    if (_isEmpty) {
      final Function1<ModuleBinding,Boolean> _function_1 = new Function1<ModuleBinding,Boolean>() {
          public Boolean apply(final ModuleBinding b) {
            boolean _and = false;
            boolean _and_1 = false;
            boolean _supportsImportBindingProtocol = BindingLookup.this.protocolMatcher.supportsImportBindingProtocol(b, protocol);
            if (!_supportsImportBindingProtocol) {
              _and_1 = false;
            } else {
              boolean _or = false;
              boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(scopedProviderModules);
              if (_isNullOrEmpty) {
                _or = true;
              } else {
                final Function1<Module,Boolean> _function = new Function1<Module,Boolean>() {
                    public Boolean apply(final Module m) {
                      ModuleRef _module = b.getModule();
                      Module _module_1 = _module.getModule();
                      boolean _equals = Objects.equal(m, _module_1);
                      return Boolean.valueOf(_equals);
                    }
                  };
                boolean _exists = IterableExtensions.<Module>exists(scopedProviderModules, _function);
                _or = (_isNullOrEmpty || _exists);
              }
              _and_1 = (_supportsImportBindingProtocol && _or);
            }
            if (!_and_1) {
              _and = false;
            } else {
              boolean _or_1 = false;
              boolean _equals = Objects.equal(endpointQualifierRef, null);
              if (_equals) {
                _or_1 = true;
              } else {
                EList<BindingProtocol> _protocol = b.getProtocol();
                final Function1<BindingProtocol,Boolean> _function_1 = new Function1<BindingProtocol,Boolean>() {
                    public Boolean apply(final BindingProtocol p) {
                      boolean _and = false;
                      org.fornax.soa.bindingDsl.EndpointQualifierRef _endpointQualifierRef = p.getEndpointQualifierRef();
                      boolean _notEquals = (!Objects.equal(_endpointQualifierRef, null));
                      if (!_notEquals) {
                        _and = false;
                      } else {
                        Qualifier _effectiveEndpointQualifier = BindingLookup.this._endpointQualifierQueries.getEffectiveEndpointQualifier(p);
                        Qualifier _endpointQualifier = endpointQualifierRef.getEndpointQualifier();
                        boolean _equals = Objects.equal(_effectiveEndpointQualifier, _endpointQualifier);
                        _and = (_notEquals && _equals);
                      }
                      return Boolean.valueOf(_and);
                    }
                  };
                boolean _exists_1 = IterableExtensions.<BindingProtocol>exists(_protocol, _function_1);
                _or_1 = (_equals || _exists_1);
              }
              _and = (_and_1 && _or_1);
            }
            return Boolean.valueOf(_and);
          }
        };
      final Iterable<ModuleBinding> moduleBindingsWithBindingQualifier = IterableExtensions.<ModuleBinding>filter(moduleBindings, _function_1);
      boolean _isNullOrEmpty_1 = IterableExtensions.isNullOrEmpty(moduleBindingsWithBindingQualifier);
      boolean _not_1 = (!_isNullOrEmpty_1);
      if (_not_1) {
        Iterables.<Binding>addAll(bindings, moduleBindingsWithBindingQualifier);
      }
    }
    final Function1<Binding,Boolean> _function_2 = new Function1<Binding,Boolean>() {
        public Boolean apply(final Binding p) {
          boolean _supportsImportBindingProtocol = BindingLookup.this.protocolMatcher.supportsImportBindingProtocol(p, protocol);
          return Boolean.valueOf(_supportsImportBindingProtocol);
        }
      };
    return IterableExtensions.<Binding>filter(bindings, _function_2);
  }
  
  /**
   * Get the most specific binding for service matching the given endpoint qualifier. The most specific binding is by default
   * the top level binding. This might be overridden in a nested binding declaration. If such an override is defined, it will be
   * returned instead.
   */
  protected Binding _getMostSpecificBinding(final Service service, final Binding binding, final EndpointQualifierRef endpointQualifier) {
    final Binding candBind = this.getMostSpecificBinding(service, binding);
    final EndpointQualifierDescriptor bindEndpointQualifiers = this._endpointQualifierQueries.getPotentialEffectiveEndpointQualifiers(candBind);
    boolean _and = false;
    boolean _and_1 = false;
    boolean _notEquals = (!Objects.equal(endpointQualifier, null));
    if (!_notEquals) {
      _and_1 = false;
    } else {
      boolean _notEquals_1 = (!Objects.equal(candBind, null));
      _and_1 = (_notEquals && _notEquals_1);
    }
    if (!_and_1) {
      _and = false;
    } else {
      Qualifier _endpointQualifier = endpointQualifier.getEndpointQualifier();
      boolean _containsEndpointQualifier = bindEndpointQualifiers.containsEndpointQualifier(_endpointQualifier);
      _and = (_and_1 && _containsEndpointQualifier);
    }
    if (_and) {
      return candBind;
    } else {
      boolean _equals = Objects.equal(endpointQualifier, null);
      if (_equals) {
        return candBind;
      } else {
        return null;
      }
    }
  }
  
  protected Binding _getMostSpecificBinding(final Service service, final ModuleBinding binding) {
    EList<ServiceBinding> _serviceBindings = binding.getServiceBindings();
    boolean _isEmpty = _serviceBindings.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      EList<ServiceBinding> _serviceBindings_1 = binding.getServiceBindings();
      for (final ServiceBinding svcBind : _serviceBindings_1) {
        ServiceRef _service = svcBind.getService();
        boolean _matches = this.serviceRefMatcher.matches(service, _service);
        if (_matches) {
          return svcBind;
        }
      }
    }
    return binding;
  }
  
  protected Binding _getMostSpecificBinding(final Service service, final ServiceBinding binding) {
    ServiceRef _service = binding.getService();
    Service _service_1 = _service.getService();
    boolean _equals = Objects.equal(_service_1, service);
    if (_equals) {
      return binding;
    } else {
      return null;
    }
  }
  
  /**
   * Get all Bindings defined in the model. This includes ModuleBindings, ServiceBindings and OperationBindings
   */
  public List<Binding> getAllBindings(final ResourceSet rs) {
    Predicate<IEObjectDescription> _alwaysTrue = Predicates.<IEObjectDescription>alwaysTrue();
    Iterable<IEObjectDescription> _search = this.lookup.search("ModuleBinding ", _alwaysTrue);
    Set<IEObjectDescription> allBindingDescs = IterableExtensions.<IEObjectDescription>toSet(_search);
    Predicate<IEObjectDescription> _alwaysTrue_1 = Predicates.<IEObjectDescription>alwaysTrue();
    Iterable<IEObjectDescription> _search_1 = this.lookup.search("ServiceBinding ", _alwaysTrue_1);
    Iterables.<IEObjectDescription>addAll(allBindingDescs, _search_1);
    Predicate<IEObjectDescription> _alwaysTrue_2 = Predicates.<IEObjectDescription>alwaysTrue();
    Iterable<IEObjectDescription> _search_2 = this.lookup.search("OperationBinding ", _alwaysTrue_2);
    Iterables.<IEObjectDescription>addAll(allBindingDescs, _search_2);
    List<Binding> allBindings = CollectionLiterals.<Binding>newArrayList();
    for (final IEObjectDescription bindingDesc : allBindingDescs) {
      {
        final EObject obj = bindingDesc.getEObjectOrProxy();
        if ((obj instanceof Binding)) {
          final Binding binding = ((Binding) obj);
          boolean _eIsProxy = binding.eIsProxy();
          if (_eIsProxy) {
            EObject _resolve = EcoreUtil2.resolve(binding, rs);
            final Binding resolvedBinding = ((Binding) _resolve);
            boolean _eIsProxy_1 = resolvedBinding.eIsProxy();
            boolean _not = (!_eIsProxy_1);
            if (_not) {
              allBindings.add(resolvedBinding);
            }
          } else {
            allBindings.add(binding);
          }
        }
      }
    }
    return allBindings;
  }
  
  /**
   * Check, whether the given Binding applies to the given Service
   */
  protected boolean _isBindingApplicable(final Binding bind, final Service svc) {
    return false;
  }
  
  /**
   * Check, whether the given Binding applies to the given Module
   */
  protected boolean _isBindingApplicable(final ModuleBinding bind, final Module mod) {
    ModuleRef _module = bind.getModule();
    VersionRef _versionRef = _module.getVersionRef();
    VersionFilter versionFilter = this.versionFilterProvider.createVersionFilter(_versionRef);
    boolean _or = false;
    ModuleRef _module_1 = bind.getModule();
    Module _module_2 = _module_1.getModule();
    boolean _equals = Objects.equal(_module_2, mod);
    if (_equals) {
      _or = true;
    } else {
      boolean _and = false;
      ModuleRef _module_3 = bind.getModule();
      Module _module_4 = _module_3.getModule();
      QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(_module_4);
      QualifiedName _fullyQualifiedName_1 = this.nameProvider.getFullyQualifiedName(mod);
      boolean _equals_1 = Objects.equal(_fullyQualifiedName, _fullyQualifiedName_1);
      if (!_equals_1) {
        _and = false;
      } else {
        IEObjectDescription _buildDescription = this.descBuilder.buildDescription(mod);
        boolean _matches = versionFilter.matches(_buildDescription);
        _and = (_equals_1 && _matches);
      }
      _or = (_equals || _and);
    }
    if (_or) {
      return true;
    } else {
      return false;
    }
  }
  
  /**
   * Check, whether the given Binding applies to the given Module and Service
   */
  public boolean isBindingApplicable(final ModuleBinding bind, final Module mod, final Service svc) {
    ModuleRef _module = bind.getModule();
    VersionRef _versionRef = _module.getVersionRef();
    VersionFilter versionFilter = this.versionFilterProvider.createVersionFilter(_versionRef);
    boolean _or = false;
    ModuleRef _module_1 = bind.getModule();
    Module _module_2 = _module_1.getModule();
    boolean _equals = Objects.equal(_module_2, mod);
    if (_equals) {
      _or = true;
    } else {
      boolean _and = false;
      ModuleRef _module_3 = bind.getModule();
      Module _module_4 = _module_3.getModule();
      QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(_module_4);
      QualifiedName _fullyQualifiedName_1 = this.nameProvider.getFullyQualifiedName(mod);
      boolean _equals_1 = Objects.equal(_fullyQualifiedName, _fullyQualifiedName_1);
      if (!_equals_1) {
        _and = false;
      } else {
        IEObjectDescription _buildDescription = this.descBuilder.buildDescription(mod);
        boolean _matches = versionFilter.matches(_buildDescription);
        _and = (_equals_1 && _matches);
      }
      _or = (_equals || _and);
    }
    if (_or) {
      return true;
    } else {
      return false;
    }
  }
  
  /**
   * Check, whether the given Binding applies to the given Service
   */
  protected boolean _isBindingApplicable(final ModuleBinding bind, final Service svc) {
    Iterable<Module> candModules = this.moduleLookup.findProvidingModules(svc);
    ModuleRef _module = bind.getModule();
    VersionRef _versionRef = _module.getVersionRef();
    VersionFilter versionFilter = this.versionFilterProvider.createVersionFilter(_versionRef);
    for (final Module mod : candModules) {
      boolean _or = false;
      ModuleRef _module_1 = bind.getModule();
      Module _module_2 = _module_1.getModule();
      boolean _equals = Objects.equal(_module_2, mod);
      if (_equals) {
        _or = true;
      } else {
        boolean _and = false;
        ModuleRef _module_3 = bind.getModule();
        Module _module_4 = _module_3.getModule();
        QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(_module_4);
        QualifiedName _fullyQualifiedName_1 = this.nameProvider.getFullyQualifiedName(mod);
        boolean _equals_1 = Objects.equal(_fullyQualifiedName, _fullyQualifiedName_1);
        if (!_equals_1) {
          _and = false;
        } else {
          IEObjectDescription _buildDescription = this.descBuilder.buildDescription(mod);
          boolean _matches = versionFilter.matches(_buildDescription);
          _and = (_equals_1 && _matches);
        }
        _or = (_equals || _and);
      }
      if (_or) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * Check, whether the given Binding applies to the given Service
   */
  protected boolean _isBindingApplicable(final ServiceBinding bind, final Service svc) {
    ServiceRef _service = bind.getService();
    VersionRef _versionRef = _service.getVersionRef();
    VersionFilter versionFilter = this.versionFilterProvider.createVersionFilter(_versionRef);
    boolean _or = false;
    ServiceRef _service_1 = bind.getService();
    Service _service_2 = _service_1.getService();
    boolean _equals = Objects.equal(_service_2, svc);
    if (_equals) {
      _or = true;
    } else {
      boolean _and = false;
      ServiceRef _service_3 = bind.getService();
      Service _service_4 = _service_3.getService();
      QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(_service_4);
      QualifiedName _fullyQualifiedName_1 = this.nameProvider.getFullyQualifiedName(svc);
      boolean _equals_1 = Objects.equal(_fullyQualifiedName, _fullyQualifiedName_1);
      if (!_equals_1) {
        _and = false;
      } else {
        IEObjectDescription _buildDescription = this.descBuilder.buildDescription(svc);
        boolean _matches = versionFilter.matches(_buildDescription);
        _and = (_equals_1 && _matches);
      }
      _or = (_equals || _and);
    }
    if (_or) {
      return true;
    } else {
      return false;
    }
  }
  
  public Binding getMostSpecificBinding(final Service service, final Binding binding, final EndpointQualifierRef endpointQualifier) {
    {
      return _getMostSpecificBinding(service, binding, endpointQualifier);
    }
  }
  
  public Binding getMostSpecificBinding(final Service service, final Binding binding) {
    if (binding instanceof ModuleBinding) {
      return _getMostSpecificBinding(service, (ModuleBinding)binding);
    } else if (binding instanceof ServiceBinding) {
      return _getMostSpecificBinding(service, (ServiceBinding)binding);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(service, binding).toString());
    }
  }
  
  public boolean isBindingApplicable(final Binding bind, final EObject mod) {
    if (bind instanceof ModuleBinding
         && mod instanceof Module) {
      return _isBindingApplicable((ModuleBinding)bind, (Module)mod);
    } else if (bind instanceof ModuleBinding
         && mod instanceof Service) {
      return _isBindingApplicable((ModuleBinding)bind, (Service)mod);
    } else if (bind instanceof ServiceBinding
         && mod instanceof Service) {
      return _isBindingApplicable((ServiceBinding)bind, (Service)mod);
    } else if (bind != null
         && mod instanceof Service) {
      return _isBindingApplicable(bind, (Service)mod);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(bind, mod).toString());
    }
  }
}
