package org.fornax.soa.service.query;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.version.VersionQualifierExtensions;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.search.StateMatcher;
import org.fornax.soa.service.VersionedDomainNamespace;
import org.fornax.soa.service.query.ServiceQueriesInternal;
import org.fornax.soa.service.query.namespace.NamespaceQuery;
import org.fornax.soa.serviceDsl.ExceptionRef;
import org.fornax.soa.serviceDsl.Operation;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.SubNamespace;

@SuppressWarnings("all")
public class ServiceQueries {
  @Inject
  private StateMatcher _stateMatcher;
  
  @Inject
  private VersionQualifierExtensions _versionQualifierExtensions;
  
  @Inject
  private NamespaceQuery _namespaceQuery;
  
  @Inject
  private ServiceQueriesInternal svcQueriesInt;
  
  protected List _servicesWithMinState(final Object ns, final LifecycleState state) {
    return null;
  }
  
  protected List _servicesWithMinState(final SubNamespace ns, final LifecycleState state) {
    EList<Service> _services = ns.getServices();
    final Function1<Service,Boolean> _function = new Function1<Service,Boolean>() {
        public Boolean apply(final Service e) {
          LifecycleState _state = e.getState();
          boolean _matchesMinStateLevel = ServiceQueries.this._stateMatcher.matchesMinStateLevel(_state, state);
          return Boolean.valueOf(_matchesMinStateLevel);
        }
      };
    Iterable<Service> _filter = IterableExtensions.<Service>filter(_services, _function);
    List<Service> _list = IterableExtensions.<Service>toList(_filter);
    return _list;
  }
  
  protected List _servicesWithMinState(final VersionedDomainNamespace ns, final LifecycleState state) {
    EObject _subdomain = ns.getSubdomain();
    List _servicesWithMinState = this.servicesWithMinState(_subdomain, state);
    return _servicesWithMinState;
  }
  
  public List<org.fornax.soa.serviceDsl.Exception> allExceptionsByMajorVersion(final SubNamespace s, final String majorVersion) {
    EList<org.fornax.soa.serviceDsl.Exception> _exceptions = s.getExceptions();
    final Function1<org.fornax.soa.serviceDsl.Exception,Boolean> _function = new Function1<org.fornax.soa.serviceDsl.Exception,Boolean>() {
        public Boolean apply(final org.fornax.soa.serviceDsl.Exception e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          String[] _split = _version_1.split("\\.");
          String _head = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(_split)));
          boolean _equals = Objects.equal(_head, majorVersion);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<org.fornax.soa.serviceDsl.Exception> _filter = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>filter(_exceptions, _function);
    List<org.fornax.soa.serviceDsl.Exception> _list = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>toList(_filter);
    return _list;
  }
  
  public List<org.fornax.soa.serviceDsl.Exception> allExceptionsByMajorVersion(final Service s, final String majorVersion) {
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(s);
    EList<org.fornax.soa.serviceDsl.Exception> _exceptions = _findSubdomain.getExceptions();
    final Function1<org.fornax.soa.serviceDsl.Exception,Boolean> _function = new Function1<org.fornax.soa.serviceDsl.Exception,Boolean>() {
        public Boolean apply(final org.fornax.soa.serviceDsl.Exception e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          String[] _split = _version_1.split("\\.");
          String _head = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(_split)));
          boolean _equals = Objects.equal(_head, majorVersion);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<org.fornax.soa.serviceDsl.Exception> _filter = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>filter(_exceptions, _function);
    List<org.fornax.soa.serviceDsl.Exception> _list = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>toList(_filter);
    return _list;
  }
  
  public List<org.fornax.soa.serviceDsl.Exception> allReferencedExceptions(final Service s) {
    EList<Operation> _operations = s.getOperations();
    final Function1<Operation,EList<ExceptionRef>> _function = new Function1<Operation,EList<ExceptionRef>>() {
        public EList<ExceptionRef> apply(final Operation o) {
          EList<ExceptionRef> _throws = o.getThrows();
          return _throws;
        }
      };
    List<EList<ExceptionRef>> _map = ListExtensions.<Operation, EList<ExceptionRef>>map(_operations, _function);
    Iterable<ExceptionRef> _flatten = Iterables.<ExceptionRef>concat(_map);
    final Function1<ExceptionRef,org.fornax.soa.serviceDsl.Exception> _function_1 = new Function1<ExceptionRef,org.fornax.soa.serviceDsl.Exception>() {
        public org.fornax.soa.serviceDsl.Exception apply(final ExceptionRef e) {
          org.fornax.soa.serviceDsl.Exception _exception = e.getException();
          return _exception;
        }
      };
    Iterable<org.fornax.soa.serviceDsl.Exception> _map_1 = IterableExtensions.<ExceptionRef, org.fornax.soa.serviceDsl.Exception>map(_flatten, _function_1);
    List<org.fornax.soa.serviceDsl.Exception> _list = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>toList(_map_1);
    return _list;
  }
  
  public List<EObject> findAllServiceConsumers(final Service service) {
    List<EObject> _findAllServiceConsumers = this.svcQueriesInt.findAllServiceConsumers(service);
    return _findAllServiceConsumers;
  }
  
  private Service findMatchingServiceByMajorVersionAndState(final String majorVersion, final List<Service> s, final LifecycleState minState) {
    final Function1<Service,Boolean> _function = new Function1<Service,Boolean>() {
        public Boolean apply(final Service e) {
          boolean _and = false;
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          String[] _split = _version_1.split("\\.");
          String _head = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(_split)));
          boolean _equals = Objects.equal(_head, majorVersion);
          if (!_equals) {
            _and = false;
          } else {
            LifecycleState _state = e.getState();
            boolean _matchesMinStateLevel = ServiceQueries.this._stateMatcher.matchesMinStateLevel(_state, minState);
            _and = (_equals && _matchesMinStateLevel);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<Service> _filter = IterableExtensions.<Service>filter(s, _function);
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
  
  public List servicesWithMinState(final Object ns, final LifecycleState state) {
    if (ns instanceof SubNamespace) {
      return _servicesWithMinState((SubNamespace)ns, state);
    } else if (ns instanceof VersionedDomainNamespace) {
      return _servicesWithMinState((VersionedDomainNamespace)ns, state);
    } else if (ns != null) {
      return _servicesWithMinState(ns, state);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ns, state).toString());
    }
  }
}
