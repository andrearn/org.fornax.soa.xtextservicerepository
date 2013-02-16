package org.fornax.soa.service.query.type;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.version.VersionMatcher;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.search.StateMatcher;
import org.fornax.soa.service.query.namespace.NamespaceQuery;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.Type;
import org.fornax.soa.serviceDsl.VersionedType;

@SuppressWarnings("all")
public class VersionedTypeFilter {
  @Inject
  private VersionMatcher _versionMatcher;
  
  @Inject
  private NamespaceQuery _namespaceQuery;
  
  @Inject
  private StateMatcher _stateMatcher;
  
  /**
   * all types from the namespace with the given major version
   */
  protected List<VersionedType> _allTypesByMajorVersion(final SubNamespace s, final String majorVersion) {
    EList<Type> _types = s.getTypes();
    Iterable<VersionedType> _filter = Iterables.<VersionedType>filter(_types, VersionedType.class);
    final Function1<VersionedType,Boolean> _function = new Function1<VersionedType,Boolean>() {
        public Boolean apply(final VersionedType t) {
          Version _version = t.getVersion();
          boolean _matchesMajorVersion = VersionedTypeFilter.this._versionMatcher.matchesMajorVersion(_version, majorVersion);
          return Boolean.valueOf(_matchesMajorVersion);
        }
      };
    Iterable<VersionedType> _filter_1 = IterableExtensions.<VersionedType>filter(_filter, _function);
    List<VersionedType> _list = IterableExtensions.<VersionedType>toList(_filter_1);
    return _list;
  }
  
  /**
   * all types from the namespace of the service with the given major version
   */
  protected List<VersionedType> _allTypesByMajorVersion(final Service s, final String majorVersion) {
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(s);
    EList<Type> _types = ((SubNamespace) _findSubdomain).getTypes();
    Iterable<VersionedType> _filter = Iterables.<VersionedType>filter(_types, VersionedType.class);
    final Function1<VersionedType,Boolean> _function = new Function1<VersionedType,Boolean>() {
        public Boolean apply(final VersionedType t) {
          Version _version = t.getVersion();
          boolean _matchesMajorVersion = VersionedTypeFilter.this._versionMatcher.matchesMajorVersion(_version, majorVersion);
          return Boolean.valueOf(_matchesMajorVersion);
        }
      };
    Iterable<VersionedType> _filter_1 = IterableExtensions.<VersionedType>filter(_filter, _function);
    List<VersionedType> _list = IterableExtensions.<VersionedType>toList(_filter_1);
    return _list;
  }
  
  /**
   * all types from the namespace with the given major version
   */
  protected List<VersionedType> _allTypesByMajorVersion(final SubNamespace s, final String majorVersion, final LifecycleState minState) {
    EList<Type> _types = s.getTypes();
    Iterable<VersionedType> _filter = Iterables.<VersionedType>filter(_types, VersionedType.class);
    final Function1<VersionedType,Boolean> _function = new Function1<VersionedType,Boolean>() {
        public Boolean apply(final VersionedType e) {
          LifecycleState _state = e.getState();
          boolean _matchesMinStateLevel = VersionedTypeFilter.this._stateMatcher.matchesMinStateLevel(_state, minState);
          return Boolean.valueOf(_matchesMinStateLevel);
        }
      };
    Iterable<VersionedType> _filter_1 = IterableExtensions.<VersionedType>filter(_filter, _function);
    final Function1<VersionedType,Boolean> _function_1 = new Function1<VersionedType,Boolean>() {
        public Boolean apply(final VersionedType t) {
          Version _version = t.getVersion();
          boolean _matchesMajorVersion = VersionedTypeFilter.this._versionMatcher.matchesMajorVersion(_version, majorVersion);
          return Boolean.valueOf(_matchesMajorVersion);
        }
      };
    Iterable<VersionedType> _filter_2 = IterableExtensions.<VersionedType>filter(_filter_1, _function_1);
    List<VersionedType> _list = IterableExtensions.<VersionedType>toList(_filter_2);
    return _list;
  }
  
  /**
   * all types from the namespace of the service with the given major version
   */
  protected List<VersionedType> _allTypesByMajorVersion(final Service s, final String majorVersion, final LifecycleState minState) {
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(s);
    EList<Type> _types = ((SubNamespace) _findSubdomain).getTypes();
    Iterable<VersionedType> _filter = Iterables.<VersionedType>filter(_types, VersionedType.class);
    final Function1<VersionedType,Boolean> _function = new Function1<VersionedType,Boolean>() {
        public Boolean apply(final VersionedType e) {
          LifecycleState _state = e.getState();
          boolean _matchesMinStateLevel = VersionedTypeFilter.this._stateMatcher.matchesMinStateLevel(_state, minState);
          return Boolean.valueOf(_matchesMinStateLevel);
        }
      };
    Iterable<VersionedType> _filter_1 = IterableExtensions.<VersionedType>filter(_filter, _function);
    final Function1<VersionedType,Boolean> _function_1 = new Function1<VersionedType,Boolean>() {
        public Boolean apply(final VersionedType t) {
          Version _version = t.getVersion();
          boolean _matchesMajorVersion = VersionedTypeFilter.this._versionMatcher.matchesMajorVersion(_version, majorVersion);
          return Boolean.valueOf(_matchesMajorVersion);
        }
      };
    Iterable<VersionedType> _filter_2 = IterableExtensions.<VersionedType>filter(_filter_1, _function_1);
    List<VersionedType> _list = IterableExtensions.<VersionedType>toList(_filter_2);
    return _list;
  }
  
  public List<VersionedType> allTypesByMajorVersion(final EObject s, final String majorVersion) {
    if (s instanceof Service) {
      return _allTypesByMajorVersion((Service)s, majorVersion);
    } else if (s instanceof SubNamespace) {
      return _allTypesByMajorVersion((SubNamespace)s, majorVersion);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s, majorVersion).toString());
    }
  }
  
  public List<VersionedType> allTypesByMajorVersion(final EObject s, final String majorVersion, final LifecycleState minState) {
    if (s instanceof Service) {
      return _allTypesByMajorVersion((Service)s, majorVersion, minState);
    } else if (s instanceof SubNamespace) {
      return _allTypesByMajorVersion((SubNamespace)s, majorVersion, minState);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s, majorVersion, minState).toString());
    }
  }
}
