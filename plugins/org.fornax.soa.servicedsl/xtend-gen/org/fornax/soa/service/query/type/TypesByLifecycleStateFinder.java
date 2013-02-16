package org.fornax.soa.service.query.type;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace;
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType;
import org.fornax.soa.profiledsl.search.StateMatcher;
import org.fornax.soa.service.VersionedDomainNamespace;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.Type;

@SuppressWarnings("all")
public class TypesByLifecycleStateFinder {
  @Inject
  private StateMatcher _stateMatcher;
  
  public List<Type> typesWithMinState(final SubNamespace ns, final LifecycleState state) {
    List<Type> _xblockexpression = null;
    {
      HashSet<Type> _hashSet = new HashSet<Type>();
      Set<Type> types = _hashSet;
      EList<Type> _types = ns.getTypes();
      Iterable<BusinessObject> _filter = Iterables.<BusinessObject>filter(_types, BusinessObject.class);
      final Function1<BusinessObject,Boolean> _function = new Function1<BusinessObject,Boolean>() {
          public Boolean apply(final BusinessObject e) {
            LifecycleState _state = e.getState();
            boolean _matchesMinStateLevel = TypesByLifecycleStateFinder.this._stateMatcher.matchesMinStateLevel(_state, state);
            return Boolean.valueOf(_matchesMinStateLevel);
          }
        };
      Iterable<BusinessObject> _filter_1 = IterableExtensions.<BusinessObject>filter(_filter, _function);
      Iterables.<Type>addAll(types, _filter_1);
      EList<Type> _types_1 = ns.getTypes();
      Iterable<Enumeration> _filter_2 = Iterables.<Enumeration>filter(_types_1, Enumeration.class);
      final Function1<Enumeration,Boolean> _function_1 = new Function1<Enumeration,Boolean>() {
          public Boolean apply(final Enumeration e) {
            LifecycleState _state = e.getState();
            boolean _matchesMinStateLevel = TypesByLifecycleStateFinder.this._stateMatcher.matchesMinStateLevel(_state, state);
            return Boolean.valueOf(_matchesMinStateLevel);
          }
        };
      Iterable<Enumeration> _filter_3 = IterableExtensions.<Enumeration>filter(_filter_2, _function_1);
      Iterables.<Type>addAll(types, _filter_3);
      List<Type> _list = IterableExtensions.<Type>toList(types);
      _xblockexpression = (_list);
    }
    return _xblockexpression;
  }
  
  public List<org.fornax.soa.profiledsl.sOAProfileDsl.Type> typesWithMinState(final TechnicalNamespace ns, final LifecycleState state) {
    EList<org.fornax.soa.profiledsl.sOAProfileDsl.Type> _types = ns.getTypes();
    Iterable<VersionedType> _filter = Iterables.<VersionedType>filter(_types, VersionedType.class);
    final Function1<VersionedType,org.fornax.soa.profiledsl.sOAProfileDsl.Type> _function = new Function1<VersionedType,org.fornax.soa.profiledsl.sOAProfileDsl.Type>() {
        public org.fornax.soa.profiledsl.sOAProfileDsl.Type apply(final VersionedType t) {
          return ((org.fornax.soa.profiledsl.sOAProfileDsl.Type) t);
        }
      };
    Iterable<org.fornax.soa.profiledsl.sOAProfileDsl.Type> _map = IterableExtensions.<VersionedType, org.fornax.soa.profiledsl.sOAProfileDsl.Type>map(_filter, _function);
    List<org.fornax.soa.profiledsl.sOAProfileDsl.Type> _list = IterableExtensions.<org.fornax.soa.profiledsl.sOAProfileDsl.Type>toList(_map);
    return _list;
  }
  
  public List<Type> typesWithMinState(final Object ns, final LifecycleState state) {
    return null;
  }
  
  public List<Type> typesWithMinState(final VersionedDomainNamespace ns, final LifecycleState state) {
    EObject _subdomain = ns.getSubdomain();
    List<Type> _typesWithMinState = this.typesWithMinState(_subdomain, state);
    return _typesWithMinState;
  }
}
