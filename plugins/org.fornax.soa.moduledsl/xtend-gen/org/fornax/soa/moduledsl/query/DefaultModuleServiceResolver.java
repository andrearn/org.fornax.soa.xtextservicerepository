package org.fornax.soa.moduledsl.query;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.fornax.soa.basedsl.sOABaseDsl.FixedVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.SOABaseDslFactory;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.basedsl.version.VersionMatcher;
import org.fornax.soa.basedsl.version.VersionQualifierExtensions;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.moduledsl.moduleDsl.AbstractServiceRef;
import org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.moduledsl.moduleDsl.ModuleDslFactory;
import org.fornax.soa.moduledsl.moduleDsl.ModuleRef;
import org.fornax.soa.moduledsl.moduleDsl.NamespaceRef;
import org.fornax.soa.moduledsl.moduleDsl.ServiceModuleRef;
import org.fornax.soa.moduledsl.moduleDsl.ServiceRef;
import org.fornax.soa.moduledsl.query.IModuleServiceResolver;
import org.fornax.soa.profiledsl.query.LifecycleQueries;
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher;
import org.fornax.soa.service.query.namespace.NamespaceQuery;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.SubNamespace;

@SuppressWarnings("all")
public class DefaultModuleServiceResolver implements IModuleServiceResolver {
  @Inject
  private VersionMatcher _versionMatcher;
  
  @Inject
  private NamespaceQuery _namespaceQuery;
  
  @Inject
  private VersionQualifierExtensions _versionQualifierExtensions;
  
  @Inject
  private IStateMatcher stateMatcher;
  
  @Inject
  private LifecycleQueries lifecycleQueries;
  
  /**
   * Get all references to services used explicitly or implicitly by module import.
   * Exclusion and inclusion rules for Module imports are respected
   */
  public Set<? extends AbstractServiceRef> getAllUsedServiceRefs(final Module module) {
    Set<AbstractServiceRef> serviceRefs = CollectionLiterals.<AbstractServiceRef>newHashSet();
    EList<ModuleRef> _usedModules = module.getUsedModules();
    final Function1<ModuleRef,EList<ServiceRef>> _function = new Function1<ModuleRef,EList<ServiceRef>>() {
        public EList<ServiceRef> apply(final ModuleRef usedMod) {
          EList<ServiceRef> _includedServices = usedMod.getIncludedServices();
          return _includedServices;
        }
      };
    List<EList<ServiceRef>> _map = ListExtensions.<ModuleRef, EList<ServiceRef>>map(_usedModules, _function);
    Iterable<ServiceRef> _flatten = Iterables.<ServiceRef>concat(_map);
    Iterables.<AbstractServiceRef>addAll(serviceRefs, _flatten);
    EList<ModuleRef> _usedModules_1 = module.getUsedModules();
    for (final ModuleRef usedMod : _usedModules_1) {
      ServiceModuleRef _moduleRef = usedMod.getModuleRef();
      Module _module = _moduleRef.getModule();
      Set<AbstractServiceRef> _allProvidedServiceRefs = this.getAllProvidedServiceRefs(_module);
      for (final AbstractServiceRef svcRef : _allProvidedServiceRefs) {
        EList<ServiceRef> _excludedServices = usedMod.getExcludedServices();
        boolean _contains = _excludedServices.contains(svcRef);
        boolean _not = (!_contains);
        if (_not) {
          serviceRefs.add(svcRef);
        }
      }
    }
    EList<ImportServiceRef> _usedServices = module.getUsedServices();
    serviceRefs.addAll(_usedServices);
    return serviceRefs;
  }
  
  /**
   * Get explicit and implicit references to services provided from the module.
   * Implicit service references are service in namespaces provided by the module.
   * Service inclusion and exclusion rules of namespace references are respected.
   */
  public Set<AbstractServiceRef> getAllProvidedServiceRefs(final Module module) {
    Set<AbstractServiceRef> serviceRefs = CollectionLiterals.<AbstractServiceRef>newHashSet();
    EList<NamespaceRef> _providedNamespaces = module.getProvidedNamespaces();
    boolean _isEmpty = _providedNamespaces.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      EList<NamespaceRef> _providedNamespaces_1 = module.getProvidedNamespaces();
      final Function1<NamespaceRef,EList<ServiceRef>> _function = new Function1<NamespaceRef,EList<ServiceRef>>() {
          public EList<ServiceRef> apply(final NamespaceRef n) {
            EList<ServiceRef> _includedServices = n.getIncludedServices();
            return _includedServices;
          }
        };
      List<EList<ServiceRef>> _map = ListExtensions.<NamespaceRef, EList<ServiceRef>>map(_providedNamespaces_1, _function);
      final Iterable<ServiceRef> inclSvcs = Iterables.<ServiceRef>concat(_map);
      EList<NamespaceRef> _providedNamespaces_2 = module.getProvidedNamespaces();
      final Function1<NamespaceRef,EList<ServiceRef>> _function_1 = new Function1<NamespaceRef,EList<ServiceRef>>() {
          public EList<ServiceRef> apply(final NamespaceRef n) {
            EList<ServiceRef> _excludedServices = n.getExcludedServices();
            return _excludedServices;
          }
        };
      List<EList<ServiceRef>> _map_1 = ListExtensions.<NamespaceRef, EList<ServiceRef>>map(_providedNamespaces_2, _function_1);
      final Iterable<ServiceRef> exclSvcs = Iterables.<ServiceRef>concat(_map_1);
      boolean _isEmpty_1 = IterableExtensions.isEmpty(inclSvcs);
      boolean _not_1 = (!_isEmpty_1);
      if (_not_1) {
        Set<ServiceRef> _set = IterableExtensions.<ServiceRef>toSet(inclSvcs);
        serviceRefs.addAll(_set);
      } else {
        EList<NamespaceRef> _providedNamespaces_3 = module.getProvidedNamespaces();
        final Function1<NamespaceRef,EList<Service>> _function_2 = new Function1<NamespaceRef,EList<Service>>() {
            public EList<Service> apply(final NamespaceRef n) {
              SubNamespace _namespace = n.getNamespace();
              EList<Service> _services = _namespace.getServices();
              return _services;
            }
          };
        List<EList<Service>> _map_2 = ListExtensions.<NamespaceRef, EList<Service>>map(_providedNamespaces_3, _function_2);
        Iterable<Service> _flatten = Iterables.<Service>concat(_map_2);
        final Function1<Service,ServiceRef> _function_3 = new Function1<Service,ServiceRef>() {
            public ServiceRef apply(final Service s) {
              ServiceRef _serviceRef = DefaultModuleServiceResolver.this.toServiceRef(s);
              return _serviceRef;
            }
          };
        Iterable<ServiceRef> _map_3 = IterableExtensions.<Service, ServiceRef>map(_flatten, _function_3);
        Set<ServiceRef> _set_1 = IterableExtensions.<ServiceRef>toSet(_map_3);
        serviceRefs.addAll(_set_1);
      }
      boolean _isEmpty_2 = IterableExtensions.isEmpty(exclSvcs);
      boolean _not_2 = (!_isEmpty_2);
      if (_not_2) {
        final Function1<AbstractServiceRef,Boolean> _function_4 = new Function1<AbstractServiceRef,Boolean>() {
            public Boolean apply(final AbstractServiceRef r) {
              Set<ServiceRef> _set = IterableExtensions.<ServiceRef>toSet(exclSvcs);
              boolean _contains = _set.contains(r);
              boolean _not = (!_contains);
              return Boolean.valueOf(_not);
            }
          };
        Iterable<AbstractServiceRef> _filter = IterableExtensions.<AbstractServiceRef>filter(serviceRefs, _function_4);
        Set<AbstractServiceRef> _set_2 = IterableExtensions.<AbstractServiceRef>toSet(_filter);
        serviceRefs = _set_2;
      }
    }
    EList<ServiceRef> _providedServices = module.getProvidedServices();
    Set<ServiceRef> _set_3 = IterableExtensions.<ServiceRef>toSet(_providedServices);
    serviceRefs.addAll(_set_3);
    return serviceRefs;
  }
  
  public Service resolveModuleServiceRef(final AbstractServiceRef svcRef, final LifecycleState minState) {
    Service _resolveModuleServiceRefInternal = this.resolveModuleServiceRefInternal(svcRef, minState);
    return _resolveModuleServiceRefInternal;
  }
  
  public Service resolveModuleServiceRef(final AbstractServiceRef svcRef, final Environment env) {
    Service _resolveModuleServiceRefInternal = this.resolveModuleServiceRefInternal(svcRef, env);
    return _resolveModuleServiceRefInternal;
  }
  
  protected Service _resolveModuleServiceRefInternal(final AbstractServiceRef s, final LifecycleState minState) {
    return null;
  }
  
  /**
   * Get the latest version of the service referenced in the ServiceRef matching the given minimal LifecycleState
   */
  protected Service _resolveModuleServiceRefInternal(final ServiceRef s, final LifecycleState minState) {
    Service _service = s.getService();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_service);
    EList<Service> _services = _findSubdomain.getServices();
    final Function1<Service,Boolean> _function = new Function1<Service,Boolean>() {
        public Boolean apply(final Service e) {
          boolean _and = false;
          boolean _and_1 = false;
          String _name = e.getName();
          Service _service = s.getService();
          String _name_1 = _service.getName();
          boolean _equals = Objects.equal(_name, _name_1);
          if (!_equals) {
            _and_1 = false;
          } else {
            Version _version = e.getVersion();
            VersionRef _versionRef = s.getVersionRef();
            boolean _versionMatches = DefaultModuleServiceResolver.this._versionMatcher.versionMatches(_version, _versionRef);
            _and_1 = (_equals && _versionMatches);
          }
          if (!_and_1) {
            _and = false;
          } else {
            LifecycleState _state = e.getState();
            boolean _matches = DefaultModuleServiceResolver.this.stateMatcher.matches(minState, _state);
            _and = (_and_1 && _matches);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<Service> _filter = IterableExtensions.<Service>filter(_services, _function);
    final Function1<Service,String> _function_1 = new Function1<Service,String>() {
        public String apply(final Service e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          return _version_1;
        }
      };
    List<Service> _sortBy = IterableExtensions.<Service, String>sortBy(_filter, _function_1);
    Service _last = IterableExtensions.<Service>last(_sortBy);
    return _last;
  }
  
  /**
   * Get the latest version of the service referenced in the ImportServiceRef matching the given minimal LifecycleState
   */
  protected Service _resolveModuleServiceRefInternal(final ImportServiceRef importServiceRef, final LifecycleState minState) {
    Service _service = importServiceRef.getService();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_service);
    EList<Service> _services = _findSubdomain.getServices();
    final Function1<Service,Boolean> _function = new Function1<Service,Boolean>() {
        public Boolean apply(final Service e) {
          boolean _and = false;
          boolean _and_1 = false;
          String _name = e.getName();
          Service _service = importServiceRef.getService();
          String _name_1 = _service.getName();
          boolean _equals = Objects.equal(_name, _name_1);
          if (!_equals) {
            _and_1 = false;
          } else {
            Version _version = e.getVersion();
            VersionRef _versionRef = importServiceRef.getVersionRef();
            boolean _versionMatches = DefaultModuleServiceResolver.this._versionMatcher.versionMatches(_version, _versionRef);
            _and_1 = (_equals && _versionMatches);
          }
          if (!_and_1) {
            _and = false;
          } else {
            LifecycleState _state = e.getState();
            boolean _matches = DefaultModuleServiceResolver.this.stateMatcher.matches(minState, _state);
            _and = (_and_1 && _matches);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<Service> _filter = IterableExtensions.<Service>filter(_services, _function);
    final Function1<Service,String> _function_1 = new Function1<Service,String>() {
        public String apply(final Service e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          return _version_1;
        }
      };
    List<Service> _sortBy = IterableExtensions.<Service, String>sortBy(_filter, _function_1);
    Service _last = IterableExtensions.<Service>last(_sortBy);
    return _last;
  }
  
  /**
   * Get the latest version of the service referenced in the ServiceRef  eligible for the given environment
   */
  protected Service _resolveModuleServiceRefInternal(final AbstractServiceRef svcRef, final Environment env) {
    return null;
  }
  
  /**
   * Get the latest version of the service referenced in the ServiceRef  eligible for the given environment
   */
  protected Service _resolveModuleServiceRefInternal(final ServiceRef svcRef, final Environment env) {
    Service _xblockexpression = null;
    {
      Service _service = svcRef.getService();
      LifecycleState _state = _service.getState();
      EObject _eContainer = _state.eContainer();
      final LifecycleState minState = this.lifecycleQueries.getMinLifecycleState(env, ((Lifecycle) _eContainer));
      Service _resolveModuleServiceRef = this.resolveModuleServiceRef(svcRef, minState);
      _xblockexpression = (_resolveModuleServiceRef);
    }
    return _xblockexpression;
  }
  
  /**
   * Get the latest version of the service referenced in the ImportServiceRef eligible for the given environment
   */
  protected Service _resolveModuleServiceRefInternal(final ImportServiceRef svcRef, final Environment env) {
    Service _xblockexpression = null;
    {
      Service _service = svcRef.getService();
      LifecycleState _state = _service.getState();
      EObject _eContainer = _state.eContainer();
      final LifecycleState minState = this.lifecycleQueries.getMinLifecycleState(env, ((Lifecycle) _eContainer));
      Service _resolveModuleServiceRef = this.resolveModuleServiceRef(svcRef, minState);
      _xblockexpression = (_resolveModuleServiceRef);
    }
    return _xblockexpression;
  }
  
  private ServiceRef toServiceRef(final Service svc) {
    final ModuleDslFactory factory = ModuleDslFactory.eINSTANCE;
    final SOABaseDslFactory baseDslFactory = SOABaseDslFactory.eINSTANCE;
    ServiceRef serviceRef = factory.createServiceRef();
    serviceRef.setService(svc);
    final FixedVersionRef verRef = baseDslFactory.createFixedVersionRef();
    Version _version = svc.getVersion();
    String _versionNumber = this._versionQualifierExtensions.toVersionNumber(_version);
    verRef.setFixedVersion(_versionNumber);
    serviceRef.setVersionRef(verRef);
    return serviceRef;
  }
  
  public Service resolveModuleServiceRefInternal(final AbstractServiceRef svcRef, final EObject env) {
    if (svcRef instanceof ImportServiceRef
         && env instanceof Environment) {
      return _resolveModuleServiceRefInternal((ImportServiceRef)svcRef, (Environment)env);
    } else if (svcRef instanceof ImportServiceRef
         && env instanceof LifecycleState) {
      return _resolveModuleServiceRefInternal((ImportServiceRef)svcRef, (LifecycleState)env);
    } else if (svcRef instanceof ServiceRef
         && env instanceof Environment) {
      return _resolveModuleServiceRefInternal((ServiceRef)svcRef, (Environment)env);
    } else if (svcRef instanceof ServiceRef
         && env instanceof LifecycleState) {
      return _resolveModuleServiceRefInternal((ServiceRef)svcRef, (LifecycleState)env);
    } else if (svcRef != null
         && env instanceof Environment) {
      return _resolveModuleServiceRefInternal(svcRef, (Environment)env);
    } else if (svcRef != null
         && env instanceof LifecycleState) {
      return _resolveModuleServiceRefInternal(svcRef, (LifecycleState)env);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(svcRef, env).toString());
    }
  }
}
