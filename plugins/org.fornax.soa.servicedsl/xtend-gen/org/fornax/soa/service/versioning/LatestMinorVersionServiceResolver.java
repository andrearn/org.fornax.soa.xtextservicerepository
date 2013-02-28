package org.fornax.soa.service.versioning;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.basedsl.version.VersionMatcher;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.search.StateMatcher;
import org.fornax.soa.service.query.namespace.NamespaceQuery;
import org.fornax.soa.service.versioning.IServiceResolver;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.ServiceRef;
import org.fornax.soa.serviceDsl.SubNamespace;

@SuppressWarnings("all")
public class LatestMinorVersionServiceResolver implements IServiceResolver {
  @Inject
  private StateMatcher _stateMatcher;
  
  @Inject
  private VersionMatcher _versionMatcher;
  
  @Inject
  private NamespaceQuery _namespaceQuery;
  
  public Service findMatchingServiceByMajorVersionAndState(final String majorVersion, final List<Service> s, final LifecycleState minState) {
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
            boolean _matchesMinStateLevel = LatestMinorVersionServiceResolver.this._stateMatcher.matchesMinStateLevel(_state, minState);
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
  
  public Service findMatchingService(final ServiceRef s) {
    Service _service = s.getService();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_service);
    EList<Service> _services = _findSubdomain.getServices();
    final Function1<Service,Boolean> _function = new Function1<Service,Boolean>() {
        public Boolean apply(final Service e) {
          boolean _and = false;
          String _name = e.getName();
          Service _service = s.getService();
          String _name_1 = _service.getName();
          boolean _equals = Objects.equal(_name, _name_1);
          if (!_equals) {
            _and = false;
          } else {
            Service _service_1 = s.getService();
            Version _version = _service_1.getVersion();
            VersionRef _versionRef = s.getVersionRef();
            boolean _versionMatches = LatestMinorVersionServiceResolver.this._versionMatcher.versionMatches(_version, _versionRef);
            _and = (_equals && _versionMatches);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<Service> _filter = IterableExtensions.<Service>filter(_services, _function);
    Iterable<Service> _filter_1 = Iterables.<Service>filter(_filter, Service.class);
    final Function1<Service,String> _function_1 = new Function1<Service,String>() {
        public String apply(final Service e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          return _version_1;
        }
      };
    List<Service> _sortBy = IterableExtensions.<Service, String>sortBy(_filter_1, _function_1);
    Service _last = IterableExtensions.<Service>last(_sortBy);
    return _last;
  }
  
  public Service findMatchingServiceByState(final ServiceRef s, final LifecycleState minState) {
    SubNamespace _findServiceRefOwnerSubdomain = this._namespaceQuery.findServiceRefOwnerSubdomain(s);
    EList<Service> _services = _findServiceRefOwnerSubdomain.getServices();
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
            boolean _versionMatches = LatestMinorVersionServiceResolver.this._versionMatcher.versionMatches(_version, _versionRef);
            _and_1 = (_equals && _versionMatches);
          }
          if (!_and_1) {
            _and = false;
          } else {
            LifecycleState _state = e.getState();
            boolean _matchesMinStateLevel = LatestMinorVersionServiceResolver.this._stateMatcher.matchesMinStateLevel(_state, minState);
            _and = (_and_1 && _matchesMinStateLevel);
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
  
  public boolean isMatchingService(final Service s, final int majorVersion, final LifecycleState minState) {
    EObject _eContainer = s.eContainer();
    EList<Service> _services = ((SubNamespace) _eContainer).getServices();
    final Function1<Service,Boolean> _function = new Function1<Service,Boolean>() {
        public Boolean apply(final Service e) {
          String _name = e.getName();
          String _name_1 = s.getName();
          boolean _equals = Objects.equal(_name, _name_1);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<Service> _filter = IterableExtensions.<Service>filter(_services, _function);
    List<Service> _list = IterableExtensions.<Service>toList(_filter);
    Service _findLatestMatchingService = this.findLatestMatchingService(_list, majorVersion, minState);
    boolean _equals = Objects.equal(_findLatestMatchingService, s);
    return _equals;
  }
  
  private Service findLatestMatchingService(final List<Service> canditates, final int majorVersion, final LifecycleState minState) {
    final Function1<Service,Boolean> _function = new Function1<Service,Boolean>() {
        public Boolean apply(final Service e) {
          boolean _and = false;
          Version _version = e.getVersion();
          boolean _versionMatches = LatestMinorVersionServiceResolver.this._versionMatcher.versionMatches(_version, Integer.valueOf(majorVersion));
          if (!_versionMatches) {
            _and = false;
          } else {
            LifecycleState _state = e.getState();
            boolean _matchesMinStateLevel = LatestMinorVersionServiceResolver.this._stateMatcher.matchesMinStateLevel(_state, minState);
            _and = (_versionMatches && _matchesMinStateLevel);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<Service> _filter = IterableExtensions.<Service>filter(canditates, _function);
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
}
