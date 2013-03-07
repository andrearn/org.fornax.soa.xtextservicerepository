package org.fornax.soa.moduledsl.query;

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
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.basedsl.search.IPredicateSearch;
import org.fornax.soa.moduledsl.moduleDsl.EndpointQualifierRef;
import org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.moduledsl.moduleDsl.ModuleRef;
import org.fornax.soa.moduledsl.moduleDsl.NamespaceRef;
import org.fornax.soa.moduledsl.moduleDsl.QualifierRefs;
import org.fornax.soa.moduledsl.moduleDsl.ServiceRef;
import org.fornax.soa.moduledsl.query.IModuleVersionMatcher;
import org.fornax.soa.semanticsDsl.Qualifier;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.SubNamespace;

@SuppressWarnings("all")
public class ModuleLookup {
  @Inject
  private IPredicateSearch search;
  
  @Inject
  private IModuleVersionMatcher _iModuleVersionMatcher;
  
  public Set<Module> findAllModules(final ResourceSet resourceSet) {
    Predicate<IEObjectDescription> _alwaysTrue = Predicates.<IEObjectDescription>alwaysTrue();
    Iterable<IEObjectDescription> moduleDescs = this.search.search("Module ", _alwaysTrue);
    List<Module> allModules = CollectionLiterals.<Module>newArrayList();
    for (final IEObjectDescription moduleDesc : moduleDescs) {
      {
        final EObject obj = moduleDesc.getEObjectOrProxy();
        if ((obj instanceof Module)) {
          final Module module = ((Module) obj);
          boolean _eIsProxy = module.eIsProxy();
          if (_eIsProxy) {
            EObject _resolve = EcoreUtil2.resolve(module, resourceSet);
            final Module resolvedModule = ((Module) _resolve);
            boolean _eIsProxy_1 = resolvedModule.eIsProxy();
            boolean _not = (!_eIsProxy_1);
            if (_not) {
              allModules.add(resolvedModule);
            }
          } else {
            allModules.add(module);
          }
        }
      }
    }
    Iterable<Module> _filter = Iterables.<Module>filter(allModules, Module.class);
    return IterableExtensions.<Module>toSet(_filter);
  }
  
  public Set<Module> findAllModuleVersionsByName(final String moduleName, final ResourceSet resourceSet) {
    Predicate<IEObjectDescription> _alwaysTrue = Predicates.<IEObjectDescription>alwaysTrue();
    Iterable<IEObjectDescription> moduleDescs = this.search.search(moduleName, "Module ", _alwaysTrue);
    List<Module> allModules = CollectionLiterals.<Module>newArrayList();
    for (final IEObjectDescription moduleDesc : moduleDescs) {
      {
        final EObject obj = moduleDesc.getEObjectOrProxy();
        if ((obj instanceof Module)) {
          final Module module = ((Module) obj);
          boolean _eIsProxy = module.eIsProxy();
          if (_eIsProxy) {
            EObject _resolve = EcoreUtil2.resolve(module, resourceSet);
            final Module resolvedModule = ((Module) _resolve);
            boolean _eIsProxy_1 = resolvedModule.eIsProxy();
            boolean _not = (!_eIsProxy_1);
            if (_not) {
              allModules.add(resolvedModule);
            }
          } else {
            allModules.add(module);
          }
        }
      }
    }
    Iterable<Module> _filter = Iterables.<Module>filter(allModules, Module.class);
    return IterableExtensions.<Module>toSet(_filter);
  }
  
  public Iterable<Module> findCompatibleModules(final Module module) {
    Iterable<Module> _xblockexpression = null;
    {
      Resource _eResource = module.eResource();
      ResourceSet _resourceSet = _eResource.getResourceSet();
      final Set<Module> allModules = this.findAllModules(_resourceSet);
      final Function1<Module,Boolean> _function = new Function1<Module,Boolean>() {
          public Boolean apply(final Module m) {
            boolean _isCompatibleTo = ModuleLookup.this._iModuleVersionMatcher.isCompatibleTo(m, module);
            return Boolean.valueOf(_isCompatibleTo);
          }
        };
      Iterable<Module> _filter = IterableExtensions.<Module>filter(allModules, _function);
      _xblockexpression = (_filter);
    }
    return _xblockexpression;
  }
  
  /**
   * Find all modules that provide the given service
   */
  public Iterable<Module> findProvidingModules(final Service service) {
    Resource _eResource = service.eResource();
    ResourceSet _resourceSet = _eResource==null?(ResourceSet)null:_eResource.getResourceSet();
    Set<Module> allModules = this.findAllModules(_resourceSet);
    final Function1<Module,Boolean> _function = new Function1<Module,Boolean>() {
        public Boolean apply(final Module m) {
          EList<ServiceRef> _providedServices = m.getProvidedServices();
          final Function1<ServiceRef,Service> _function = new Function1<ServiceRef,Service>() {
              public Service apply(final ServiceRef e) {
                Service _service = e.getService();
                return _service;
              }
            };
          List<Service> _map = ListExtensions.<ServiceRef, Service>map(_providedServices, _function);
          final Function1<Service,Boolean> _function_1 = new Function1<Service,Boolean>() {
              public Boolean apply(final Service s) {
                boolean _equals = Objects.equal(s, service);
                return Boolean.valueOf(_equals);
              }
            };
          boolean _exists = IterableExtensions.<Service>exists(_map, _function_1);
          return Boolean.valueOf(_exists);
        }
      };
    Iterable<Module> providingModules = IterableExtensions.<Module>filter(allModules, _function);
    final Function1<Module,Boolean> _function_1 = new Function1<Module,Boolean>() {
        public Boolean apply(final Module m) {
          EList<NamespaceRef> _providedNamespaces = m.getProvidedNamespaces();
          final Function1<NamespaceRef,EList<Service>> _function = new Function1<NamespaceRef,EList<Service>>() {
              public EList<Service> apply(final NamespaceRef e) {
                SubNamespace _namespace = e.getNamespace();
                EList<Service> _services = _namespace.getServices();
                return _services;
              }
            };
          List<EList<Service>> _map = ListExtensions.<NamespaceRef, EList<Service>>map(_providedNamespaces, _function);
          final Function1<EList<Service>,Boolean> _function_1 = new Function1<EList<Service>,Boolean>() {
              public Boolean apply(final EList<Service> s) {
                boolean _equals = Objects.equal(s, service);
                return Boolean.valueOf(_equals);
              }
            };
          boolean _exists = IterableExtensions.<EList<Service>>exists(_map, _function_1);
          return Boolean.valueOf(_exists);
        }
      };
    final Iterable<Module> nsProvidingModules = IterableExtensions.<Module>filter(allModules, _function_1);
    Set<Module> _set = IterableExtensions.<Module>toSet(providingModules);
    Iterables.<Module>addAll(_set, nsProvidingModules);
    return providingModules;
  }
  
  public Iterable<Module> findProvidingModules(final Service service, final VersionRef versionRef) {
    Resource _eResource = service.eResource();
    ResourceSet _resourceSet = _eResource==null?(ResourceSet)null:_eResource.getResourceSet();
    Set<Module> allModules = this.findAllModules(_resourceSet);
    final Function1<Module,Boolean> _function = new Function1<Module,Boolean>() {
        public Boolean apply(final Module m) {
          EList<ServiceRef> _providedServices = m.getProvidedServices();
          final Function1<ServiceRef,Service> _function = new Function1<ServiceRef,Service>() {
              public Service apply(final ServiceRef e) {
                Service _service = e.getService();
                return _service;
              }
            };
          List<Service> _map = ListExtensions.<ServiceRef, Service>map(_providedServices, _function);
          final Function1<Service,Boolean> _function_1 = new Function1<Service,Boolean>() {
              public Boolean apply(final Service s) {
                boolean _equals = Objects.equal(s, service);
                return Boolean.valueOf(_equals);
              }
            };
          boolean _exists = IterableExtensions.<Service>exists(_map, _function_1);
          return Boolean.valueOf(_exists);
        }
      };
    Iterable<Module> providingModules = IterableExtensions.<Module>filter(allModules, _function);
    final Function1<Module,Boolean> _function_1 = new Function1<Module,Boolean>() {
        public Boolean apply(final Module m) {
          EList<NamespaceRef> _providedNamespaces = m.getProvidedNamespaces();
          final Function1<NamespaceRef,EList<Service>> _function = new Function1<NamespaceRef,EList<Service>>() {
              public EList<Service> apply(final NamespaceRef e) {
                SubNamespace _namespace = e.getNamespace();
                EList<Service> _services = _namespace.getServices();
                return _services;
              }
            };
          List<EList<Service>> _map = ListExtensions.<NamespaceRef, EList<Service>>map(_providedNamespaces, _function);
          final Function1<EList<Service>,Boolean> _function_1 = new Function1<EList<Service>,Boolean>() {
              public Boolean apply(final EList<Service> s) {
                boolean _equals = Objects.equal(s, service);
                return Boolean.valueOf(_equals);
              }
            };
          boolean _exists = IterableExtensions.<EList<Service>>exists(_map, _function_1);
          return Boolean.valueOf(_exists);
        }
      };
    final Iterable<Module> nsProvidingModules = IterableExtensions.<Module>filter(allModules, _function_1);
    Set<Module> _set = IterableExtensions.<Module>toSet(providingModules);
    Iterables.<Module>addAll(_set, nsProvidingModules);
    return providingModules;
  }
  
  /**
   * Find all modules that provide the given service. from any of the candidate modules
   */
  public Iterable<Module> findProvidingModules(final Service service, final Iterable<Module> candidateModules) {
    final Function1<Module,Boolean> _function = new Function1<Module,Boolean>() {
        public Boolean apply(final Module cand) {
          Iterable<Module> _findProvidingModules = ModuleLookup.this.findProvidingModules(service);
          final Function1<Module,Boolean> _function = new Function1<Module,Boolean>() {
              public Boolean apply(final Module m) {
                boolean _equals = Objects.equal(m, cand);
                return Boolean.valueOf(_equals);
              }
            };
          boolean _exists = IterableExtensions.<Module>exists(_findProvidingModules, _function);
          return Boolean.valueOf(_exists);
        }
      };
    Iterable<Module> _filter = IterableExtensions.<Module>filter(candidateModules, _function);
    return _filter;
  }
  
  /**
   * Find all modules that provide the given service, from any of the candidate modules, that
   * declare the given qualifier
   */
  public Iterable<Module> findProvidingModules(final Service service, final Iterable<Module> candidateModules, final String qualifierName) {
    Iterable<Module> _findProvidingModules = this.findProvidingModules(service, candidateModules);
    final Function1<Module,Boolean> _function = new Function1<Module,Boolean>() {
        public Boolean apply(final Module m) {
          QualifierRefs _qualifiers = m.getQualifiers();
          EList<Qualifier> _qualifiers_1 = _qualifiers.getQualifiers();
          final Function1<Qualifier,Boolean> _function = new Function1<Qualifier,Boolean>() {
              public Boolean apply(final Qualifier q) {
                String _name = q.getName();
                boolean _equals = Objects.equal(_name, qualifierName);
                return Boolean.valueOf(_equals);
              }
            };
          boolean _exists = IterableExtensions.<Qualifier>exists(_qualifiers_1, _function);
          return Boolean.valueOf(_exists);
        }
      };
    Iterable<Module> _filter = IterableExtensions.<Module>filter(_findProvidingModules, _function);
    return _filter;
  }
  
  /**
   * Get the endpoint qualifier
   */
  protected String _getQualifier(final Module module) {
    EndpointQualifierRef _endpointQualifierRef = module.getEndpointQualifierRef();
    Qualifier _endpointQualifier = _endpointQualifierRef==null?(Qualifier)null:_endpointQualifierRef.getEndpointQualifier();
    String _name = _endpointQualifier.getName();
    return _name;
  }
  
  /**
   * Get the endpoint qualifier
   */
  protected String _getQualifier(final ModuleRef moduleRef) {
    EndpointQualifierRef _endpointQualifierRef = moduleRef.getEndpointQualifierRef();
    Qualifier _endpointQualifier = _endpointQualifierRef==null?(Qualifier)null:_endpointQualifierRef.getEndpointQualifier();
    boolean _notEquals = (!Objects.equal(_endpointQualifier, null));
    if (_notEquals) {
      EndpointQualifierRef _endpointQualifierRef_1 = moduleRef.getEndpointQualifierRef();
      Qualifier _endpointQualifier_1 = _endpointQualifierRef_1.getEndpointQualifier();
      return _endpointQualifier_1.getName();
    } else {
      EObject _eContainer = moduleRef.eContainer();
      return this.getQualifier(((Module) _eContainer));
    }
  }
  
  /**
   * Get the endpoint qualifier
   */
  protected String _getQualifier(final ImportServiceRef impServiceRef) {
    EndpointQualifierRef _endpointQualifierRef = impServiceRef.getEndpointQualifierRef();
    Qualifier _endpointQualifier = _endpointQualifierRef==null?(Qualifier)null:_endpointQualifierRef.getEndpointQualifier();
    boolean _notEquals = (!Objects.equal(_endpointQualifier, null));
    if (_notEquals) {
      EndpointQualifierRef _endpointQualifierRef_1 = impServiceRef.getEndpointQualifierRef();
      Qualifier _endpointQualifier_1 = _endpointQualifierRef_1.getEndpointQualifier();
      return _endpointQualifier_1.getName();
    } else {
      EObject _eContainer = impServiceRef.eContainer();
      return this.getQualifier(((Module) _eContainer));
    }
  }
  
  protected String _getBindingQualifier(final Module module) {
    EndpointQualifierRef _endpointQualifierRef = module.getEndpointQualifierRef();
    Qualifier _endpointQualifier = _endpointQualifierRef==null?(Qualifier)null:_endpointQualifierRef.getEndpointQualifier();
    String _name = _endpointQualifier.getName();
    return _name;
  }
  
  protected String _getBindingQualifier(final ModuleRef moduleRef) {
    EndpointQualifierRef _endpointQualifierRef = moduleRef.getEndpointQualifierRef();
    Qualifier _endpointQualifier = _endpointQualifierRef==null?(Qualifier)null:_endpointQualifierRef.getEndpointQualifier();
    boolean _notEquals = (!Objects.equal(_endpointQualifier, null));
    if (_notEquals) {
      EndpointQualifierRef _endpointQualifierRef_1 = moduleRef.getEndpointQualifierRef();
      Qualifier _endpointQualifier_1 = _endpointQualifierRef_1.getEndpointQualifier();
      return _endpointQualifier_1.getName();
    } else {
      EObject _eContainer = moduleRef.eContainer();
      EndpointQualifierRef _endpointQualifierRef_2 = ((Module) _eContainer).getEndpointQualifierRef();
      Qualifier _endpointQualifier_2 = _endpointQualifierRef_2==null?(Qualifier)null:_endpointQualifierRef_2.getEndpointQualifier();
      return _endpointQualifier_2.getName();
    }
  }
  
  protected String _getBindingQualifier(final ImportServiceRef impServiceRef) {
    EndpointQualifierRef _endpointQualifierRef = impServiceRef.getEndpointQualifierRef();
    Qualifier _endpointQualifier = _endpointQualifierRef==null?(Qualifier)null:_endpointQualifierRef.getEndpointQualifier();
    boolean _notEquals = (!Objects.equal(_endpointQualifier, null));
    if (_notEquals) {
      EndpointQualifierRef _endpointQualifierRef_1 = impServiceRef.getEndpointQualifierRef();
      Qualifier _endpointQualifier_1 = _endpointQualifierRef_1.getEndpointQualifier();
      return _endpointQualifier_1.getName();
    } else {
      EObject _eContainer = impServiceRef.eContainer();
      EndpointQualifierRef _endpointQualifierRef_2 = ((Module) _eContainer).getEndpointQualifierRef();
      Qualifier _endpointQualifier_2 = _endpointQualifierRef_2==null?(Qualifier)null:_endpointQualifierRef_2.getEndpointQualifier();
      return _endpointQualifier_2.getName();
    }
  }
  
  /**
   * Get the module that contains the model element.
   */
  protected EObject _getOwningModule(final EObject modelElement) {
    EObject _eContainer = modelElement==null?(EObject)null:modelElement.eContainer();
    boolean _notEquals = (!Objects.equal(_eContainer, null));
    if (_notEquals) {
      return modelElement.eContainer();
    } else {
      return null;
    }
  }
  
  /**
   * Get the module that contains the model element. I.n this case the Module itself
   */
  protected EObject _getOwningModule(final Module modelElement) {
    return modelElement;
  }
  
  public String getQualifier(final EObject impServiceRef) {
    if (impServiceRef instanceof ImportServiceRef) {
      return _getQualifier((ImportServiceRef)impServiceRef);
    } else if (impServiceRef instanceof Module) {
      return _getQualifier((Module)impServiceRef);
    } else if (impServiceRef instanceof ModuleRef) {
      return _getQualifier((ModuleRef)impServiceRef);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(impServiceRef).toString());
    }
  }
  
  public String getBindingQualifier(final EObject impServiceRef) {
    if (impServiceRef instanceof ImportServiceRef) {
      return _getBindingQualifier((ImportServiceRef)impServiceRef);
    } else if (impServiceRef instanceof Module) {
      return _getBindingQualifier((Module)impServiceRef);
    } else if (impServiceRef instanceof ModuleRef) {
      return _getBindingQualifier((ModuleRef)impServiceRef);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(impServiceRef).toString());
    }
  }
  
  public EObject getOwningModule(final EObject modelElement) {
    if (modelElement instanceof Module) {
      return _getOwningModule((Module)modelElement);
    } else if (modelElement != null) {
      return _getOwningModule(modelElement);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(modelElement).toString());
    }
  }
}
