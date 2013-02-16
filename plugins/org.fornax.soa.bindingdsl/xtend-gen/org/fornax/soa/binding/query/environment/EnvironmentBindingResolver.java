package org.fornax.soa.binding.query.environment;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.binding.query.BindingLookup;
import org.fornax.soa.bindingDsl.Binding;
import org.fornax.soa.bindingDsl.BindingProtocol;
import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.bindingDsl.ModuleRef;
import org.fornax.soa.bindingDsl.OperationBinding;
import org.fornax.soa.bindingDsl.ServiceBinding;
import org.fornax.soa.environment.query.EnvironmentLookup;
import org.fornax.soa.environmentDsl.ESB;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.environmentDsl.Server;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.moduledsl.query.ModuleLookup;

@SuppressWarnings("all")
public class EnvironmentBindingResolver {
  @Inject
  private BindingLookup bindingLookup;
  
  @Inject
  private ModuleLookup moduleLookup;
  
  @Inject
  private EnvironmentLookup envLookup;
  
  /**
   * Find all ModuleBindings that directly refer to this module or a compatible module and bind it to the given
   * target environment
   */
  public Set<Environment> findUnboundEnvironmentForCompatibleModule(final Module module) {
    Resource _eResource = module.eResource();
    ResourceSet _resourceSet = _eResource==null?(ResourceSet)null:_eResource.getResourceSet();
    List<Binding> _allBindings = this.bindingLookup.getAllBindings(_resourceSet);
    final Iterable<ModuleBinding> allBindings = Iterables.<ModuleBinding>filter(_allBindings, ModuleBinding.class);
    Iterable<Module> _findCompatibleModules = this.moduleLookup.findCompatibleModules(module);
    final Set<Module> compatibleModules = IterableExtensions.<Module>toSet(_findCompatibleModules);
    final Function1<ModuleBinding,Boolean> _function = new Function1<ModuleBinding,Boolean>() {
        public Boolean apply(final ModuleBinding e) {
          ModuleRef _module = e.getModule();
          boolean _contains = compatibleModules.contains(_module);
          return Boolean.valueOf(_contains);
        }
      };
    Iterable<ModuleBinding> _filter = IterableExtensions.<ModuleBinding>filter(allBindings, _function);
    final Set<ModuleBinding> bindings = IterableExtensions.<ModuleBinding>toSet(_filter);
    final Function1<ModuleBinding,Environment> _function_1 = new Function1<ModuleBinding,Environment>() {
        public Environment apply(final ModuleBinding b) {
          Environment _resolveEnvironment = EnvironmentBindingResolver.this.resolveEnvironment(b);
          return _resolveEnvironment;
        }
      };
    Iterable<Environment> _map = IterableExtensions.<ModuleBinding, Environment>map(bindings, _function_1);
    final Set<Environment> boundEnvironments = IterableExtensions.<Environment>toSet(_map);
    Resource _eResource_1 = module.eResource();
    ResourceSet _resourceSet_1 = _eResource_1==null?(ResourceSet)null:_eResource_1.getResourceSet();
    final Set<Environment> allEnvironments = this.envLookup.findAllEnvironments(_resourceSet_1);
    final Function1<Environment,Boolean> _function_2 = new Function1<Environment,Boolean>() {
        public Boolean apply(final Environment e) {
          boolean _contains = boundEnvironments.contains(e);
          boolean _not = (!_contains);
          return Boolean.valueOf(_not);
        }
      };
    Iterable<Environment> _filter_1 = IterableExtensions.<Environment>filter(allEnvironments, _function_2);
    return IterableExtensions.<Environment>toSet(_filter_1);
  }
  
  protected Server _resolveServer(final Binding bind, final BindingProtocol prot) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException();
    throw _unsupportedOperationException;
  }
  
  /**
   * Return the server to bind to. If not stated explicitly in the ModuleBinding
   * the environments default ESB is being used
   */
  protected Server _resolveServer(final ModuleBinding bind, final BindingProtocol prot) {
    final Server server = bind.getProvServer();
    Server _xifexpression = null;
    boolean _notEquals = (!Objects.equal(server, null));
    if (_notEquals) {
      _xifexpression = server;
    } else {
      Environment _resolveEnvironment = this.resolveEnvironment(bind);
      ESB _defaultESB = _resolveEnvironment.getDefaultESB();
      _xifexpression = _defaultESB;
    }
    return _xifexpression;
  }
  
  protected Server _resolveServer(final ServiceBinding bind, final BindingProtocol prot) {
    EObject _eContainer = bind.eContainer();
    Server _resolveServer = this.resolveServer(((Binding) _eContainer), prot);
    return _resolveServer;
  }
  
  protected Server _resolveServer(final OperationBinding bind, final BindingProtocol prot) {
    EObject _eContainer = bind.eContainer();
    Server _resolveServer = this.resolveServer(((Binding) _eContainer), prot);
    return _resolveServer;
  }
  
  protected Server _resolveServer(final EObject bind, final BindingProtocol prot) {
    EObject _eContainer = bind.eContainer();
    Server _resolveServer = _eContainer==null?(Server)null:this.resolveServer(_eContainer, prot);
    return _resolveServer;
  }
  
  protected Server _resolveServer(final ModuleBinding bind) {
    final Server server = bind.getProvServer();
    Server _xifexpression = null;
    boolean _notEquals = (!Objects.equal(server, null));
    if (_notEquals) {
      _xifexpression = server;
    } else {
      Environment _resolveEnvironment = this.resolveEnvironment(bind);
      ESB _defaultESB = _resolveEnvironment.getDefaultESB();
      _xifexpression = _defaultESB;
    }
    return _xifexpression;
  }
  
  protected Server _resolveServer(final ServiceBinding bind) {
    EObject _eContainer = bind.eContainer();
    Server _resolveServer = this.resolveServer(((Binding) _eContainer));
    return _resolveServer;
  }
  
  protected Server _resolveServer(final OperationBinding bind) {
    EObject _eContainer = bind.eContainer();
    Server _resolveServer = this.resolveServer(((Binding) _eContainer));
    return _resolveServer;
  }
  
  protected Server _resolveServer(final EObject bind) {
    EObject _eContainer = bind.eContainer();
    Server _resolveServer = _eContainer==null?(Server)null:this.resolveServer(_eContainer);
    return _resolveServer;
  }
  
  protected Environment _resolveEnvironment(final Server server) {
    EObject _eContainer = server.eContainer();
    return ((Environment) _eContainer);
  }
  
  protected Environment _resolveEnvironment(final EObject o) {
    EObject _eContainer = o.eContainer();
    Environment _resolveEnvironment = _eContainer==null?(Environment)null:this.resolveEnvironment(_eContainer);
    return _resolveEnvironment;
  }
  
  protected Environment _resolveEnvironment(final Binding bind) {
    Environment _resolveEnvironment = this.resolveEnvironment(bind);
    return _resolveEnvironment;
  }
  
  protected Environment _resolveEnvironment(final ModuleBinding bind) {
    Environment _xifexpression = null;
    Server _provServer = bind.getProvServer();
    boolean _notEquals = (!Objects.equal(_provServer, null));
    if (_notEquals) {
      Server _provServer_1 = bind.getProvServer();
      Environment _resolveEnvironment = this.resolveEnvironment(_provServer_1);
      _xifexpression = _resolveEnvironment;
    } else {
      Environment _environment = bind.getEnvironment();
      _xifexpression = _environment;
    }
    return _xifexpression;
  }
  
  protected Environment _getEnvironment(final ServiceBinding bind) {
    EObject _eContainer = bind.eContainer();
    Environment _resolveEnvironment = this.resolveEnvironment(((Binding) _eContainer));
    return _resolveEnvironment;
  }
  
  protected Environment _getEnvironment(final OperationBinding bind) {
    EObject _eContainer = bind.eContainer();
    Environment _resolveEnvironment = this.resolveEnvironment(((Binding) _eContainer));
    return _resolveEnvironment;
  }
  
  public Server resolveServer(final EObject bind, final BindingProtocol prot) {
    if (bind instanceof ModuleBinding) {
      return _resolveServer((ModuleBinding)bind, prot);
    } else if (bind instanceof ServiceBinding) {
      return _resolveServer((ServiceBinding)bind, prot);
    } else if (bind instanceof Binding) {
      return _resolveServer((Binding)bind, prot);
    } else if (bind instanceof OperationBinding) {
      return _resolveServer((OperationBinding)bind, prot);
    } else if (bind != null) {
      return _resolveServer(bind, prot);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(bind, prot).toString());
    }
  }
  
  public Server resolveServer(final EObject bind) {
    if (bind instanceof ModuleBinding) {
      return _resolveServer((ModuleBinding)bind);
    } else if (bind instanceof ServiceBinding) {
      return _resolveServer((ServiceBinding)bind);
    } else if (bind instanceof OperationBinding) {
      return _resolveServer((OperationBinding)bind);
    } else if (bind != null) {
      return _resolveServer(bind);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(bind).toString());
    }
  }
  
  public Environment resolveEnvironment(final EObject bind) {
    if (bind instanceof ModuleBinding) {
      return _resolveEnvironment((ModuleBinding)bind);
    } else if (bind instanceof Binding) {
      return _resolveEnvironment((Binding)bind);
    } else if (bind instanceof Server) {
      return _resolveEnvironment((Server)bind);
    } else if (bind != null) {
      return _resolveEnvironment(bind);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(bind).toString());
    }
  }
  
  public Environment getEnvironment(final EObject bind) {
    if (bind instanceof ServiceBinding) {
      return _getEnvironment((ServiceBinding)bind);
    } else if (bind instanceof OperationBinding) {
      return _getEnvironment((OperationBinding)bind);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(bind).toString());
    }
  }
}
