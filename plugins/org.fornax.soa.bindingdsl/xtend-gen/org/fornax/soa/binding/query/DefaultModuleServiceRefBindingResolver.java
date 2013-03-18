package org.fornax.soa.binding.query;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.fornax.soa.binding.EndpointQualifierDescriptor;
import org.fornax.soa.binding.query.BindingLookup;
import org.fornax.soa.binding.query.EndpointQualifierQueries;
import org.fornax.soa.binding.query.IModuleServiceRefBindingResolver;
import org.fornax.soa.binding.query.services.ModuleServiceRefBindingDescription;
import org.fornax.soa.bindingDsl.Binding;
import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.moduledsl.moduleDsl.AbstractServiceRef;
import org.fornax.soa.moduledsl.moduleDsl.EndpointQualifierRef;
import org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.moduledsl.moduleDsl.ModuleRef;
import org.fornax.soa.moduledsl.moduleDsl.ServiceModuleRef;
import org.fornax.soa.moduledsl.query.IModuleReferenceResolver;
import org.fornax.soa.moduledsl.query.IModuleServiceResolver;
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.semanticsDsl.Qualifier;
import org.fornax.soa.serviceDsl.Service;

/**
 * Resolves Bindings of service/modules as explicit descriptions describing which Binding applies to which service
 * provided or used by a module.
 */
@SuppressWarnings("all")
public class DefaultModuleServiceRefBindingResolver implements IModuleServiceRefBindingResolver {
  @Inject
  private IModuleServiceResolver modServiceResolver;
  
  @Inject
  private BindingLookup bindingLookup;
  
  @Inject
  private EndpointQualifierQueries endpointQualifierQuery;
  
  @Inject
  private IModuleReferenceResolver modRefResolver;
  
  @Inject
  private Logger log;
  
  /**
   * Resolve Bindings of all services provided by a module in the given environment. Endpoint qualifiers in the module definition that select used endpoints of used services
   * are used as additional filter criteria on the selected bindings. For each applicable binding and provided service
   * a ServiceBindingDescription is returned.
   * 
   * @param module 				the module, for which ServiceBindingDescriptions are to be build for all used services
   * @param targetEnvironment 	the environment a binding applicable for the used service must bind to
   * @param endpointQualifier 	selects an endpoint of a service by selecting the most specific binding for
   * 								that service having	this effective endpoint qualifier. If, null applicable bindings may
   * 								have any or no potentially effective endpoint qualifier
   */
  public Set<ModuleServiceRefBindingDescription> resolveCompatibleProvidedServiceBindings(final Module module, final Environment targetEnvironment, final EndpointQualifierRef endpointQualifier) {
    Qualifier _endpointQualifier = endpointQualifier==null?(Qualifier)null:endpointQualifier.getEndpointQualifier();
    final Set<ModuleBinding> candBindings = this.bindingLookup.findBindingsToCompatibleModuleEnvAndQualifier(module, targetEnvironment, _endpointQualifier);
    Set<ModuleServiceRefBindingDescription> svcBindDescs = CollectionLiterals.<ModuleServiceRefBindingDescription>newHashSet();
    final Set<AbstractServiceRef> providedServices = this.modServiceResolver.getAllProvidedServiceRefs(module);
    for (final AbstractServiceRef provSvcRef : providedServices) {
      {
        final Service svc = this.modServiceResolver.resolveModuleServiceRef(provSvcRef, targetEnvironment);
        for (final ModuleBinding bind : candBindings) {
          {
            final Binding specBind = this.bindingLookup.getMostSpecificBinding(svc, bind, endpointQualifier);
            boolean _notEquals = (!Objects.equal(specBind, null));
            if (_notEquals) {
              ModuleServiceRefBindingDescription _moduleServiceRefBindingDescription = new ModuleServiceRefBindingDescription();
              final ModuleServiceRefBindingDescription curSvcBindDesc = _moduleServiceRefBindingDescription;
              curSvcBindDesc.setApplicableBinding(specBind);
              curSvcBindDesc.setResolvedService(svc);
              curSvcBindDesc.setServiceRef(provSvcRef);
              curSvcBindDesc.setProvidingModule(module);
              Qualifier _endpointQualifier_1 = endpointQualifier==null?(Qualifier)null:endpointQualifier.getEndpointQualifier();
              curSvcBindDesc.setEndpointQualifier(_endpointQualifier_1);
              svcBindDescs.add(curSvcBindDesc);
            }
          }
        }
      }
    }
    return svcBindDescs;
  }
  
  /**
   * Resolve Bindings of services used by a module in the given environment. Endpoint qualifiers in the module definition that select used endpoints of used services
   * are used as additional filter criteria on the selected bindings.  For each applicable binding and provided service
   * a ServiceBindingDescription is returned.
   * 
   * @param module 				the module, for which ServiceBindingDescriptions are to be build for all used services
   * @param targetEnvironment 	the environment a binding applicable for the used service must bind to
   * @param endpointQualifier 	selects an endpoint of a service by selecting the most specific binding for
   * 								that service having	this effective endpoint qualifier. If, null applicable bindings may
   * 								have any or no potentially effective endpoint qualifier
   */
  public Set<ModuleServiceRefBindingDescription> resolveCompatibleUsedServiceBindings(final Module module, final Environment targetEnvironment, final EndpointQualifierRef endpointQualifierRef) {
    final Set<? extends AbstractServiceRef> usedServiceRefs = this.modServiceResolver.getAllUsedServiceRefs(module);
    final Set<ModuleServiceRefBindingDescription> svcBindDescs = CollectionLiterals.<ModuleServiceRefBindingDescription>newHashSet();
    this.resolveModuleRefs(module, usedServiceRefs, targetEnvironment, endpointQualifierRef, svcBindDescs);
    this.resolveServicesRefs(module, usedServiceRefs, targetEnvironment, endpointQualifierRef, svcBindDescs);
    return svcBindDescs;
  }
  
  private void resolveModuleRefs(final Module module, final Set<? extends AbstractServiceRef> usedServiceRefs, final Environment targetEnvironment, final EndpointQualifierRef endpointQualifierRef, final Set<ModuleServiceRefBindingDescription> svcBindDescs) {
    LifecycleState _state = module.getState();
    EObject _eContainer = _state.eContainer();
    final Lifecycle lifecycle = ((Lifecycle) _eContainer);
    EList<ModuleRef> _usedModules = module.getUsedModules();
    for (final ModuleRef usedModRef : _usedModules) {
      {
        final EndpointQualifierRef selectingEndpointQualifierRef = this.getSelectingEndpointQualifier(usedModRef, module, endpointQualifierRef);
        final Module providerModule = this.modRefResolver.resolveModuleRef(usedModRef, targetEnvironment, lifecycle, selectingEndpointQualifierRef, null);
        final Set<ModuleServiceRefBindingDescription> impModSvcBindDescs = this.resolveCompatibleProvidedServiceBindings(providerModule, targetEnvironment, selectingEndpointQualifierRef);
        final Function1<ModuleServiceRefBindingDescription,Boolean> _function = new Function1<ModuleServiceRefBindingDescription,Boolean>() {
            public Boolean apply(final ModuleServiceRefBindingDescription d) {
              AbstractServiceRef _serviceRef = d.getServiceRef();
              boolean _contains = usedServiceRefs.contains(_serviceRef);
              return Boolean.valueOf(_contains);
            }
          };
        Iterable<ModuleServiceRefBindingDescription> _filter = IterableExtensions.<ModuleServiceRefBindingDescription>filter(impModSvcBindDescs, _function);
        for (final ModuleServiceRefBindingDescription curDesc : _filter) {
          {
            Binding _applicableBinding = curDesc.getApplicableBinding();
            final EndpointQualifierDescriptor curEndpointQualifiers = this.endpointQualifierQuery.getPotentialEffectiveEndpointQualifiers(_applicableBinding);
            boolean _or = false;
            Qualifier _endpointQualifier = curDesc.getEndpointQualifier();
            boolean _equals = Objects.equal(_endpointQualifier, null);
            if (_equals) {
              _or = true;
            } else {
              Qualifier _endpointQualifier_1 = curDesc.getEndpointQualifier();
              boolean _containsEndpointQualifier = curEndpointQualifiers.containsEndpointQualifier(_endpointQualifier_1);
              _or = (_equals || _containsEndpointQualifier);
            }
            if (_or) {
              svcBindDescs.add(curDesc);
            }
          }
        }
        Iterable<ModuleServiceRefBindingDescription> _filterNull = IterableExtensions.<ModuleServiceRefBindingDescription>filterNull(svcBindDescs);
        final Function1<ModuleServiceRefBindingDescription,AbstractServiceRef> _function_1 = new Function1<ModuleServiceRefBindingDescription,AbstractServiceRef>() {
            public AbstractServiceRef apply(final ModuleServiceRefBindingDescription d) {
              AbstractServiceRef _serviceRef = d.getServiceRef();
              return _serviceRef;
            }
          };
        Iterable<AbstractServiceRef> _map = IterableExtensions.<ModuleServiceRefBindingDescription, AbstractServiceRef>map(_filterNull, _function_1);
        final List svcRefsForEndpointQualifier = IterableExtensions.<AbstractServiceRef>toList(_map);
        ServiceModuleRef _moduleRef = usedModRef.getModuleRef();
        Module _module = _moduleRef.getModule();
        final Set<ModuleServiceRefBindingDescription> allImpModSvcBindDescs = this.resolveCompatibleProvidedServiceBindings(_module, targetEnvironment, selectingEndpointQualifierRef);
        for (final ModuleServiceRefBindingDescription curBindDesc : allImpModSvcBindDescs) {
          boolean _and = false;
          AbstractServiceRef _serviceRef = curBindDesc.getServiceRef();
          boolean _contains = svcRefsForEndpointQualifier.contains(_serviceRef);
          boolean _not = (!_contains);
          if (!_not) {
            _and = false;
          } else {
            boolean _or = false;
            boolean _equals = Objects.equal(selectingEndpointQualifierRef, null);
            if (_equals) {
              _or = true;
            } else {
              boolean _isAcceptOtherEndpoints = selectingEndpointQualifierRef.isAcceptOtherEndpoints();
              _or = (_equals || _isAcceptOtherEndpoints);
            }
            _and = (_not && _or);
          }
          if (_and) {
            boolean _and_1 = false;
            boolean _notEquals = (!Objects.equal(curBindDesc, null));
            if (!_notEquals) {
              _and_1 = false;
            } else {
              Iterable<ModuleServiceRefBindingDescription> _filterNull_1 = IterableExtensions.<ModuleServiceRefBindingDescription>filterNull(svcBindDescs);
              final Function1<ModuleServiceRefBindingDescription,AbstractServiceRef> _function_2 = new Function1<ModuleServiceRefBindingDescription,AbstractServiceRef>() {
                  public AbstractServiceRef apply(final ModuleServiceRefBindingDescription d) {
                    AbstractServiceRef _serviceRef = d.getServiceRef();
                    return _serviceRef;
                  }
                };
              Iterable<AbstractServiceRef> _map_1 = IterableExtensions.<ModuleServiceRefBindingDescription, AbstractServiceRef>map(_filterNull_1, _function_2);
              List _list = IterableExtensions.<AbstractServiceRef>toList(_map_1);
              AbstractServiceRef _serviceRef_1 = curBindDesc.getServiceRef();
              boolean _contains_1 = _list.contains(_serviceRef_1);
              boolean _not_1 = (!_contains_1);
              _and_1 = (_notEquals && _not_1);
            }
            if (_and_1) {
              svcBindDescs.add(curBindDesc);
            }
          }
        }
      }
    }
  }
  
  private void resolveServicesRefs(final Module module, final Set<? extends AbstractServiceRef> usedServiceRefs, final Environment targetEnvironment, final EndpointQualifierRef endpointQualifierRef, final Set<ModuleServiceRefBindingDescription> svcBindDescs) {
    LifecycleState _state = module.getState();
    EObject _eContainer = _state.eContainer();
    final Lifecycle lifecycle = ((Lifecycle) _eContainer);
    EList<ImportServiceRef> _usedServices = module.getUsedServices();
    for (final ImportServiceRef svcRef : _usedServices) {
      boolean _contains = usedServiceRefs.contains(svcRef);
      if (_contains) {
        final Service svc = this.modServiceResolver.resolveModuleServiceRef(svcRef, targetEnvironment);
        EList<ServiceModuleRef> _modules = svcRef.getModules();
        final Function1<ServiceModuleRef,Module> _function = new Function1<ServiceModuleRef,Module>() {
            public Module apply(final ServiceModuleRef m) {
              Module _resolveModuleServiceRef = DefaultModuleServiceRefBindingResolver.this.modRefResolver.resolveModuleServiceRef(m, targetEnvironment, lifecycle);
              return _resolveModuleServiceRef;
            }
          };
        final List<Module> canditateModules = ListExtensions.<ServiceModuleRef, Module>map(_modules, _function);
        for (final Module candMod : canditateModules) {
          {
            EndpointQualifierRef _xifexpression = null;
            EndpointQualifierRef _endpointQualifierRef = svcRef.getEndpointQualifierRef();
            boolean _notEquals = (!Objects.equal(_endpointQualifierRef, null));
            if (_notEquals) {
              EndpointQualifierRef _endpointQualifierRef_1 = svcRef.getEndpointQualifierRef();
              _xifexpression = _endpointQualifierRef_1;
            } else {
              EndpointQualifierRef _endpointQualifierRef_2 = module.getEndpointQualifierRef();
              _xifexpression = _endpointQualifierRef_2;
            }
            final EndpointQualifierRef selectingEndpointQualifierRef = _xifexpression;
            Qualifier _endpointQualifier = selectingEndpointQualifierRef==null?(Qualifier)null:selectingEndpointQualifierRef.getEndpointQualifier();
            final Set<ModuleBinding> candBindings = this.bindingLookup.findBindingsToCompatibleModuleEnvAndQualifier(candMod, targetEnvironment, _endpointQualifier);
            for (final ModuleBinding bind : candBindings) {
              {
                Binding specBind = this.bindingLookup.getMostSpecificBinding(svc, bind, selectingEndpointQualifierRef);
                ModuleServiceRefBindingDescription _moduleServiceRefBindingDescription = new ModuleServiceRefBindingDescription();
                final ModuleServiceRefBindingDescription curSvcBindDesc = _moduleServiceRefBindingDescription;
                curSvcBindDesc.setApplicableBinding(specBind);
                curSvcBindDesc.setResolvedService(svc);
                curSvcBindDesc.setServiceRef(svcRef);
                curSvcBindDesc.setProvidingModule(candMod);
                EndpointQualifierRef _endpointQualifierRef_3 = svcRef.getEndpointQualifierRef();
                Qualifier _endpointQualifier_1 = _endpointQualifierRef_3==null?(Qualifier)null:_endpointQualifierRef_3.getEndpointQualifier();
                curSvcBindDesc.setEndpointQualifier(_endpointQualifier_1);
                svcBindDescs.add(curSvcBindDesc);
              }
            }
          }
        }
      }
    }
  }
  
  private EndpointQualifierRef getSelectingEndpointQualifier(final ModuleRef usedModRef, final Module module, final EndpointQualifierRef endpointQualifierRef) {
    EndpointQualifierRef _xifexpression = null;
    EndpointQualifierRef _endpointQualifierRef = usedModRef.getEndpointQualifierRef();
    Qualifier _endpointQualifier = _endpointQualifierRef==null?(Qualifier)null:_endpointQualifierRef.getEndpointQualifier();
    boolean _notEquals = (!Objects.equal(_endpointQualifier, null));
    if (_notEquals) {
      EndpointQualifierRef _endpointQualifierRef_1 = usedModRef.getEndpointQualifierRef();
      _xifexpression = _endpointQualifierRef_1;
    } else {
      EndpointQualifierRef _endpointQualifierRef_2 = module.getEndpointQualifierRef();
      _xifexpression = _endpointQualifierRef_2;
    }
    final EndpointQualifierRef moduleEndpointQualifierRef = _xifexpression;
    EndpointQualifierRef _xifexpression_1 = null;
    boolean _and = false;
    boolean _notEquals_1 = (!Objects.equal(endpointQualifierRef, null));
    if (!_notEquals_1) {
      _and = false;
    } else {
      Qualifier _endpointQualifier_1 = moduleEndpointQualifierRef==null?(Qualifier)null:moduleEndpointQualifierRef.getEndpointQualifier();
      String _name = _endpointQualifier_1==null?(String)null:_endpointQualifier_1.getName();
      boolean _notEquals_2 = (!Objects.equal(_name, null));
      _and = (_notEquals_1 && _notEquals_2);
    }
    if (_and) {
      EndpointQualifierRef _xblockexpression = null;
      {
        Qualifier _endpointQualifier_2 = endpointQualifierRef.getEndpointQualifier();
        String _name_1 = _endpointQualifier_2.getName();
        Qualifier _endpointQualifier_3 = moduleEndpointQualifierRef==null?(Qualifier)null:moduleEndpointQualifierRef.getEndpointQualifier();
        String _name_2 = _endpointQualifier_3==null?(String)null:_endpointQualifier_3.getName();
        boolean _equals = _name_1.equals(_name_2);
        boolean _not = (!_equals);
        if (_not) {
          Qualifier _endpointQualifier_4 = moduleEndpointQualifierRef==null?(Qualifier)null:moduleEndpointQualifierRef.getEndpointQualifier();
          String _name_3 = _endpointQualifier_4==null?(String)null:_endpointQualifier_4.getName();
          String _plus = ("The modules endpoint qualifier " + _name_3);
          String _plus_1 = (_plus + 
            " has been overridden with the endpoint qualifier ");
          Qualifier _endpointQualifier_5 = endpointQualifierRef.getEndpointQualifier();
          String _name_4 = _endpointQualifier_5.getName();
          String _plus_2 = (_plus_1 + _name_4);
          this.log.warning(_plus_2);
        }
        EndpointQualifierRef _endpointQualifierRef_3 = usedModRef.getEndpointQualifierRef();
        _xblockexpression = (_endpointQualifierRef_3);
      }
      _xifexpression_1 = _xblockexpression;
    } else {
      EndpointQualifierRef _xifexpression_2 = null;
      boolean _notEquals_3 = (!Objects.equal(endpointQualifierRef, null));
      if (_notEquals_3) {
        _xifexpression_2 = endpointQualifierRef;
      } else {
        EndpointQualifierRef _endpointQualifierRef_3 = module.getEndpointQualifierRef();
        _xifexpression_2 = _endpointQualifierRef_3;
      }
      _xifexpression_1 = _xifexpression_2;
    }
    final EndpointQualifierRef selectingEndpointQualifierRef = _xifexpression_1;
    return selectingEndpointQualifierRef;
  }
}
