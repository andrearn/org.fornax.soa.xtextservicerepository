package org.fornax.soa.service.versioning;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.basedsl.version.VersionMatcher;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.search.StateMatcher;
import org.fornax.soa.service.query.namespace.NamespaceQuery;
import org.fornax.soa.service.versioning.IExceptionResolver;
import org.fornax.soa.serviceDsl.ExceptionRef;
import org.fornax.soa.serviceDsl.SubNamespace;

@SuppressWarnings("all")
public class LatestMinorVersionExceptionResolver implements IExceptionResolver {
  @Inject
  private StateMatcher _stateMatcher;
  
  @Inject
  private VersionMatcher _versionMatcher;
  
  @Inject
  private NamespaceQuery _namespaceQuery;
  
  /**
   * Find the latest minor version of the referenced Exceptiontype matching the
   * 	version constraint in the reference and the minimal required LifecycleState
   */
  public org.fornax.soa.serviceDsl.Exception findMatchingException(final ExceptionRef excRef, final LifecycleState minState) {
    org.fornax.soa.serviceDsl.Exception _exception = excRef.getException();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_exception);
    EList<org.fornax.soa.serviceDsl.Exception> _exceptions = _findSubdomain.getExceptions();
    final Function1<org.fornax.soa.serviceDsl.Exception,Boolean> _function = new Function1<org.fornax.soa.serviceDsl.Exception,Boolean>() {
        public Boolean apply(final org.fornax.soa.serviceDsl.Exception e) {
          boolean _and = false;
          boolean _and_1 = false;
          String _name = e.getName();
          org.fornax.soa.serviceDsl.Exception _exception = excRef.getException();
          String _name_1 = _exception.getName();
          boolean _equals = Objects.equal(_name, _name_1);
          if (!_equals) {
            _and_1 = false;
          } else {
            org.fornax.soa.serviceDsl.Exception _exception_1 = excRef.getException();
            Version _version = _exception_1.getVersion();
            VersionRef _version_1 = excRef.getVersion();
            boolean _versionMatches = LatestMinorVersionExceptionResolver.this._versionMatcher.versionMatches(_version, _version_1);
            _and_1 = (_equals && _versionMatches);
          }
          if (!_and_1) {
            _and = false;
          } else {
            org.fornax.soa.serviceDsl.Exception _exception_2 = excRef.getException();
            LifecycleState _state = _exception_2.getState();
            boolean _matchesMinStateLevel = LatestMinorVersionExceptionResolver.this._stateMatcher.matchesMinStateLevel(_state, minState);
            _and = (_and_1 && _matchesMinStateLevel);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<org.fornax.soa.serviceDsl.Exception> _filter = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>filter(_exceptions, _function);
    Iterable<org.fornax.soa.serviceDsl.Exception> _filter_1 = Iterables.<org.fornax.soa.serviceDsl.Exception>filter(_filter, org.fornax.soa.serviceDsl.Exception.class);
    final Function1<org.fornax.soa.serviceDsl.Exception,String> _function_1 = new Function1<org.fornax.soa.serviceDsl.Exception,String>() {
        public String apply(final org.fornax.soa.serviceDsl.Exception e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          return _version_1;
        }
      };
    List<org.fornax.soa.serviceDsl.Exception> _sortBy = IterableExtensions.<org.fornax.soa.serviceDsl.Exception, String>sortBy(_filter_1, _function_1);
    org.fornax.soa.serviceDsl.Exception _last = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>last(_sortBy);
    return _last;
  }
  
  /**
   * Find the latest minor version of the referenced Exceptiontype matching the
   * 	version constraint in the reference. The LifecycleState of the Exception is not considered.
   */
  public org.fornax.soa.serviceDsl.Exception findMatchingException(final ExceptionRef excRef) {
    org.fornax.soa.serviceDsl.Exception _exception = excRef.getException();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_exception);
    EList<org.fornax.soa.serviceDsl.Exception> _exceptions = _findSubdomain.getExceptions();
    final Function1<org.fornax.soa.serviceDsl.Exception,Boolean> _function = new Function1<org.fornax.soa.serviceDsl.Exception,Boolean>() {
        public Boolean apply(final org.fornax.soa.serviceDsl.Exception e) {
          boolean _and = false;
          String _name = e.getName();
          org.fornax.soa.serviceDsl.Exception _exception = excRef.getException();
          String _name_1 = _exception.getName();
          boolean _equals = Objects.equal(_name, _name_1);
          if (!_equals) {
            _and = false;
          } else {
            org.fornax.soa.serviceDsl.Exception _exception_1 = excRef.getException();
            Version _version = _exception_1.getVersion();
            VersionRef _version_1 = excRef.getVersion();
            boolean _versionMatches = LatestMinorVersionExceptionResolver.this._versionMatcher.versionMatches(_version, _version_1);
            _and = (_equals && _versionMatches);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<org.fornax.soa.serviceDsl.Exception> _filter = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>filter(_exceptions, _function);
    Iterable<org.fornax.soa.serviceDsl.Exception> _filter_1 = Iterables.<org.fornax.soa.serviceDsl.Exception>filter(_filter, org.fornax.soa.serviceDsl.Exception.class);
    final Function1<org.fornax.soa.serviceDsl.Exception,String> _function_1 = new Function1<org.fornax.soa.serviceDsl.Exception,String>() {
        public String apply(final org.fornax.soa.serviceDsl.Exception e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          return _version_1;
        }
      };
    List<org.fornax.soa.serviceDsl.Exception> _sortBy = IterableExtensions.<org.fornax.soa.serviceDsl.Exception, String>sortBy(_filter_1, _function_1);
    org.fornax.soa.serviceDsl.Exception _last = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>last(_sortBy);
    return _last;
  }
  
  /**
   * Checks, whether the Exception is the latest minor version in a given major version
   *  @param exc				The Exception to checked
   *  @param majorVersion		The major version number to which minor versions should match
   */
  public boolean isMatchingException(final org.fornax.soa.serviceDsl.Exception exc, final Integer majorVersion, final LifecycleState minState) {
    EObject _eContainer = exc.eContainer();
    EList<org.fornax.soa.serviceDsl.Exception> _exceptions = ((SubNamespace) _eContainer).getExceptions();
    final Function1<org.fornax.soa.serviceDsl.Exception,Boolean> _function = new Function1<org.fornax.soa.serviceDsl.Exception,Boolean>() {
        public Boolean apply(final org.fornax.soa.serviceDsl.Exception e) {
          String _name = e.getName();
          String _name_1 = exc.getName();
          boolean _equals = Objects.equal(_name, _name_1);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<org.fornax.soa.serviceDsl.Exception> _filter = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>filter(_exceptions, _function);
    List<org.fornax.soa.serviceDsl.Exception> _list = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>toList(_filter);
    org.fornax.soa.serviceDsl.Exception _findMatchingException = this.findMatchingException(_list, majorVersion, minState);
    boolean _equals = Objects.equal(_findMatchingException, exc);
    return _equals;
  }
  
  private org.fornax.soa.serviceDsl.Exception findMatchingException(final List<org.fornax.soa.serviceDsl.Exception> exceptions, final Integer majorVersion, final LifecycleState minState) {
    final Function1<org.fornax.soa.serviceDsl.Exception,Boolean> _function = new Function1<org.fornax.soa.serviceDsl.Exception,Boolean>() {
        public Boolean apply(final org.fornax.soa.serviceDsl.Exception e) {
          boolean _and = false;
          Version _version = e.getVersion();
          boolean _versionMatches = LatestMinorVersionExceptionResolver.this._versionMatcher.versionMatches(_version, majorVersion);
          if (!_versionMatches) {
            _and = false;
          } else {
            LifecycleState _state = e.getState();
            boolean _matchesMinStateLevel = LatestMinorVersionExceptionResolver.this._stateMatcher.matchesMinStateLevel(_state, minState);
            _and = (_versionMatches && _matchesMinStateLevel);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<org.fornax.soa.serviceDsl.Exception> _filter = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>filter(exceptions, _function);
    final Function1<org.fornax.soa.serviceDsl.Exception,String> _function_1 = new Function1<org.fornax.soa.serviceDsl.Exception,String>() {
        public String apply(final org.fornax.soa.serviceDsl.Exception e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          return _version_1;
        }
      };
    List<org.fornax.soa.serviceDsl.Exception> _sortBy = IterableExtensions.<org.fornax.soa.serviceDsl.Exception, String>sortBy(_filter, _function_1);
    org.fornax.soa.serviceDsl.Exception _last = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>last(_sortBy);
    return _last;
  }
}
