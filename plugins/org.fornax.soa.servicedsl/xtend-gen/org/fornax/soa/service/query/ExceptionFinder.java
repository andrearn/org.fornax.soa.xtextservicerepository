package org.fornax.soa.service.query;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.search.StateMatcher;
import org.fornax.soa.service.VersionedDomainNamespace;
import org.fornax.soa.serviceDsl.SubNamespace;

/**
 * Search for Exception type definitions
 */
@SuppressWarnings("all")
public class ExceptionFinder {
  @Inject
  private StateMatcher _stateMatcher;
  
  protected List _exceptionsWithMinState(final Object ns, final LifecycleState state) {
    ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
    return _newArrayList;
  }
  
  protected List _exceptionsWithMinState(final SubNamespace ns, final LifecycleState state) {
    EList<org.fornax.soa.serviceDsl.Exception> _exceptions = ns.getExceptions();
    final Function1<org.fornax.soa.serviceDsl.Exception,Boolean> _function = new Function1<org.fornax.soa.serviceDsl.Exception,Boolean>() {
        public Boolean apply(final org.fornax.soa.serviceDsl.Exception e) {
          LifecycleState _state = e.getState();
          boolean _matchesMinStateLevel = ExceptionFinder.this._stateMatcher.matchesMinStateLevel(_state, state);
          return Boolean.valueOf(_matchesMinStateLevel);
        }
      };
    Iterable<org.fornax.soa.serviceDsl.Exception> _filter = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>filter(_exceptions, _function);
    List<org.fornax.soa.serviceDsl.Exception> _list = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>toList(_filter);
    return _list;
  }
  
  protected List _exceptionsWithMinState(final VersionedDomainNamespace ns, final LifecycleState state) {
    EObject _subdomain = ns.getSubdomain();
    List _exceptionsWithMinState = this.exceptionsWithMinState(_subdomain, state);
    return _exceptionsWithMinState;
  }
  
  public List exceptionsWithMinState(final Object ns, final LifecycleState state) {
    if (ns instanceof SubNamespace) {
      return _exceptionsWithMinState((SubNamespace)ns, state);
    } else if (ns instanceof VersionedDomainNamespace) {
      return _exceptionsWithMinState((VersionedDomainNamespace)ns, state);
    } else if (ns != null) {
      return _exceptionsWithMinState(ns, state);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ns, state).toString());
    }
  }
}
