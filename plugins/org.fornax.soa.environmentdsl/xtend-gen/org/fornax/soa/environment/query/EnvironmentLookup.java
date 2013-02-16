package org.fornax.soa.environment.query;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.inject.Inject;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.basedsl.search.IPredicateSearch;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.environmentDsl.EnvironmentType;

/**
 * Search for Environment and related entities
 */
@SuppressWarnings("all")
public class EnvironmentLookup {
  @Inject
  private IPredicateSearch lookup;
  
  /**
   * find all defined Environments and initialize EMF proxies
   */
  public Set<Environment> findAllEnvironments(final ResourceSet resourceSet) {
    Predicate<IEObjectDescription> _alwaysTrue = Predicates.<IEObjectDescription>alwaysTrue();
    Iterable<IEObjectDescription> envDescs = this.lookup.search("Environment ", _alwaysTrue);
    List<Environment> allEnvironments = CollectionLiterals.<Environment>newArrayList();
    for (final IEObjectDescription moduleDesc : envDescs) {
      {
        final EObject obj = moduleDesc.getEObjectOrProxy();
        if ((obj instanceof Environment)) {
          final Environment env = ((Environment) obj);
          boolean _eIsProxy = env.eIsProxy();
          if (_eIsProxy) {
            EObject _resolve = EcoreUtil2.resolve(env, resourceSet);
            final Environment resolvedEnv = ((Environment) _resolve);
            boolean _eIsProxy_1 = resolvedEnv.eIsProxy();
            boolean _not = (!_eIsProxy_1);
            if (_not) {
              allEnvironments.add(resolvedEnv);
            }
          } else {
            allEnvironments.add(env);
          }
        }
      }
    }
    return IterableExtensions.<Environment>toSet(allEnvironments);
  }
  
  /**
   * Collect all used EnvironmentTypes from all Environments define in the model
   */
  public Set<EnvironmentType> getAllUsedEnvironmentTypes(final ResourceSet resourceSet) {
    final Set<Environment> allEnvs = this.findAllEnvironments(resourceSet);
    final Function1<Environment,EnvironmentType> _function = new Function1<Environment,EnvironmentType>() {
        public EnvironmentType apply(final Environment e) {
          EnvironmentType _type = e.getType();
          return _type;
        }
      };
    Iterable<EnvironmentType> _map = IterableExtensions.<Environment, EnvironmentType>map(allEnvs, _function);
    return IterableExtensions.<EnvironmentType>toSet(_map);
  }
  
  /**
   * Filters a collection of EnvironmentTypes in such a way, that it only
   * contains the overall used EnvironmentTypes from Environments defined in
   * themodel
   */
  public List<EnvironmentType> filterByUsedEnvironmentTypes(final List<EnvironmentType> environmentTypes, final ResourceSet resourceSet) {
    final Set<EnvironmentType> allDefEnvs = this.getAllUsedEnvironmentTypes(resourceSet);
    final Function1<EnvironmentType,Boolean> _function = new Function1<EnvironmentType,Boolean>() {
        public Boolean apply(final EnvironmentType e) {
          boolean _contains = allDefEnvs.contains(e);
          return Boolean.valueOf(_contains);
        }
      };
    Iterable<EnvironmentType> _filter = IterableExtensions.<EnvironmentType>filter(environmentTypes, _function);
    return IterableExtensions.<EnvironmentType>toList(_filter);
  }
}
