package org.fornax.soa.binding.query;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.List;
import java.util.Set;
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
import org.fornax.soa.basedsl.scoping.versions.VersionFilter;
import org.fornax.soa.basedsl.search.IPredicateSearch;
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver;
import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.bindingDsl.ModuleRef;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher;
import org.fornax.soa.profiledsl.scoping.versions.IVersionFilterProvider;

@SuppressWarnings("all")
public class ModuleBindingLookup {
  @Inject
  private EnvironmentBindingResolver _environmentBindingResolver;
  
  @Inject
  private IQualifiedNameProvider nameProvider;
  
  @Inject
  private IPredicateSearch lookup;
  
  @Inject
  private IStateMatcher stateMatcher;
  
  @Inject
  private IVersionFilterProvider versionFilterProvider;
  
  @Inject
  private IEObjectDescriptionBuilder descBuilder;
  
  /**
   * Find a binding to the target environment that is applicable for the module
   */
  public List<ModuleBinding> findBindingForProvidingModuleAndEnv(final Environment targetEnvironment, final Module module) {
    LifecycleState _state = module.getState();
    String _name = targetEnvironment.getName();
    boolean _supportsEnvironment = this.stateMatcher.supportsEnvironment(_state, _name);
    if (_supportsEnvironment) {
      QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(module);
      String _string = _fullyQualifiedName.toString();
      Set<ModuleBinding> candBindings = this.findAllBindingsByModuleAndEnvironment(targetEnvironment, _string);
      final Function1<ModuleBinding,Boolean> _function = new Function1<ModuleBinding,Boolean>() {
          public Boolean apply(final ModuleBinding b) {
            ModuleRef _module = b.getModule();
            VersionRef _versionRef = _module.getVersionRef();
            VersionFilter _createVersionFilter = ModuleBindingLookup.this.versionFilterProvider.createVersionFilter(_versionRef);
            IEObjectDescription _buildDescription = ModuleBindingLookup.this.descBuilder.buildDescription(module);
            boolean _matches = _createVersionFilter.matches(_buildDescription);
            return Boolean.valueOf(_matches);
          }
        };
      Iterable<ModuleBinding> _filter = IterableExtensions.<ModuleBinding>filter(candBindings, _function);
      return IterableExtensions.<ModuleBinding>toList(_filter);
    }
    return CollectionLiterals.<ModuleBinding>newArrayList();
  }
  
  /**
   * Find all Bindings of any version of a module with the given name to the given target environment. Returns an empty set
   * if no such ModuleBinding exists
   */
  public Set<ModuleBinding> findAllBindingsByModuleAndEnvironment(final Environment targetEnvironment, final String providingModuleName) {
    Predicate<IEObjectDescription> _alwaysTrue = Predicates.<IEObjectDescription>alwaysTrue();
    Iterable<IEObjectDescription> _search = this.lookup.search("ModuleBinding ", _alwaysTrue);
    final Function1<IEObjectDescription,EObject> _function = new Function1<IEObjectDescription,EObject>() {
        public EObject apply(final IEObjectDescription desc) {
          EObject _eObjectOrProxy = desc.getEObjectOrProxy();
          Resource _eResource = targetEnvironment.eResource();
          ResourceSet _resourceSet = _eResource.getResourceSet();
          EObject _resolve = EcoreUtil2.resolve(_eObjectOrProxy, _resourceSet);
          return _resolve;
        }
      };
    Iterable<EObject> _map = IterableExtensions.<IEObjectDescription, EObject>map(_search, _function);
    Iterable<ModuleBinding> _filter = Iterables.<ModuleBinding>filter(_map, ModuleBinding.class);
    final Function1<ModuleBinding,Boolean> _function_1 = new Function1<ModuleBinding,Boolean>() {
        public Boolean apply(final ModuleBinding bind) {
          boolean _and = false;
          ModuleRef _module = bind.getModule();
          QualifiedName _fullyQualifiedName = ModuleBindingLookup.this.nameProvider.getFullyQualifiedName(_module);
          String _string = _fullyQualifiedName.toString();
          boolean _equals = providingModuleName.equals(_string);
          if (!_equals) {
            _and = false;
          } else {
            Environment _resolveEnvironment = ModuleBindingLookup.this._environmentBindingResolver.resolveEnvironment(bind);
            boolean _equals_1 = _resolveEnvironment.equals(targetEnvironment);
            _and = (_equals && _equals_1);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<ModuleBinding> candBindings = IterableExtensions.<ModuleBinding>filter(_filter, _function_1);
    return IterableExtensions.<ModuleBinding>toSet(candBindings);
  }
}
