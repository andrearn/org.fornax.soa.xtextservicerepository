package org.fornax.soa.service.namespace;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.fornax.soa.basedsl.CommonStringExtensions;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.version.VersionMatcher;
import org.fornax.soa.basedsl.version.VersionQualifierExtensions;
import org.fornax.soa.service.VersionedDomainNamespace;
import org.fornax.soa.service.query.type.VersionedTypeFilter;
import org.fornax.soa.serviceDsl.OrganizationNamespace;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.Type;
import org.fornax.soa.serviceDsl.VersionedType;

/**
 * Split SubNamespaces by major major versions of it's owned services, BOs, enums and exceptions
 */
@SuppressWarnings("all")
public class NamespaceSplitter {
  @Inject
  private VersionMatcher _versionMatcher;
  
  @Inject
  private VersionQualifierExtensions _versionQualifierExtensions;
  
  @Inject
  private CommonStringExtensions _commonStringExtensions;
  
  @Inject
  private VersionedTypeFilter _versionedTypeFilter;
  
  @Inject
  private IQualifiedNameProvider nameProvider;
  
  /**
   * Split into VersionedDomainNamespace per accounted major version of contained versioned elements
   */
  protected Set<VersionedDomainNamespace> _splitNamespaceByMajorVersion(final Object s) {
    HashSet<VersionedDomainNamespace> _newHashSet = CollectionLiterals.<VersionedDomainNamespace>newHashSet();
    return _newHashSet;
  }
  
  /**
   * Split into VersionedDomainNamespace per accounted major version of contained versioned elements
   */
  protected Set<VersionedDomainNamespace> _splitNamespaceByMajorVersion(final SubNamespace s) {
    Set<VersionedDomainNamespace> verNS = CollectionLiterals.<VersionedDomainNamespace>newHashSet();
    boolean _or = false;
    boolean _or_1 = false;
    EList<Type> _types = s.getTypes();
    int _size = _types.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      _or_1 = true;
    } else {
      EList<Service> _services = s.getServices();
      int _size_1 = _services.size();
      boolean _greaterThan_1 = (_size_1 > 0);
      _or_1 = (_greaterThan || _greaterThan_1);
    }
    if (_or_1) {
      _or = true;
    } else {
      EList<org.fornax.soa.serviceDsl.Exception> _exceptions = s.getExceptions();
      int _size_2 = _exceptions.size();
      boolean _greaterThan_2 = (_size_2 > 0);
      _or = (_or_1 || _greaterThan_2);
    }
    if (_or) {
      EList<Type> _types_1 = s.getTypes();
      final Function1<Type,VersionedDomainNamespace> _function = new Function1<Type,VersionedDomainNamespace>() {
          public VersionedDomainNamespace apply(final Type t) {
            VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceSplitter.this.createVersionedDomainNamespace(t);
            return _createVersionedDomainNamespace;
          }
        };
      List<VersionedDomainNamespace> _map = ListExtensions.<Type, VersionedDomainNamespace>map(_types_1, _function);
      verNS.addAll(_map);
      EList<Service> _services_1 = s.getServices();
      final Function1<Service,VersionedDomainNamespace> _function_1 = new Function1<Service,VersionedDomainNamespace>() {
          public VersionedDomainNamespace apply(final Service svc) {
            VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceSplitter.this.createVersionedDomainNamespace(svc);
            return _createVersionedDomainNamespace;
          }
        };
      List<VersionedDomainNamespace> _map_1 = ListExtensions.<Service, VersionedDomainNamespace>map(_services_1, _function_1);
      verNS.addAll(_map_1);
      EList<org.fornax.soa.serviceDsl.Exception> _exceptions_1 = s.getExceptions();
      final Function1<org.fornax.soa.serviceDsl.Exception,VersionedDomainNamespace> _function_2 = new Function1<org.fornax.soa.serviceDsl.Exception,VersionedDomainNamespace>() {
          public VersionedDomainNamespace apply(final org.fornax.soa.serviceDsl.Exception e) {
            VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceSplitter.this.createVersionedDomainNamespace(e);
            return _createVersionedDomainNamespace;
          }
        };
      List<VersionedDomainNamespace> _map_2 = ListExtensions.<org.fornax.soa.serviceDsl.Exception, VersionedDomainNamespace>map(_exceptions_1, _function_2);
      verNS.addAll(_map_2);
      return verNS;
    } else {
      return verNS;
    }
  }
  
  public Set<VersionedDomainNamespace> getAllLatestSubNamespacesByMajorVersion(final Set<VersionedDomainNamespace> canditates) {
    final Function1<VersionedDomainNamespace,Boolean> _function = new Function1<VersionedDomainNamespace,Boolean>() {
        public Boolean apply(final VersionedDomainNamespace e) {
          final Function1<VersionedDomainNamespace,Boolean> _function = new Function1<VersionedDomainNamespace,Boolean>() {
              public Boolean apply(final VersionedDomainNamespace c) {
                boolean _and = false;
                String _version = c.getVersion();
                String _majorVersionNumber = NamespaceSplitter.this._versionQualifierExtensions.toMajorVersionNumber(_version);
                String _version_1 = e.getVersion();
                String _majorVersionNumber_1 = NamespaceSplitter.this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
                boolean _equals = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
                if (!_equals) {
                  _and = false;
                } else {
                  String _version_2 = c.getVersion();
                  String _version_3 = e.getVersion();
                  boolean _greaterThan = (_version_2.compareTo(_version_3) > 0);
                  _and = (_equals && _greaterThan);
                }
                return Boolean.valueOf(_and);
              }
            };
          boolean _exists = IterableExtensions.<VersionedDomainNamespace>exists(canditates, _function);
          boolean _not = (!_exists);
          return Boolean.valueOf(_not);
        }
      };
    Iterable<VersionedDomainNamespace> _filter = IterableExtensions.<VersionedDomainNamespace>filter(canditates, _function);
    Set<VersionedDomainNamespace> _set = IterableExtensions.<VersionedDomainNamespace>toSet(_filter);
    return _set;
  }
  
  public VersionedDomainNamespace getLatestSubNamespaceByMajorVersion(final Set<VersionedDomainNamespace> canditates, final int majorVer) {
    final Function1<VersionedDomainNamespace,Boolean> _function = new Function1<VersionedDomainNamespace,Boolean>() {
        public Boolean apply(final VersionedDomainNamespace e) {
          String _version = e.getVersion();
          String _majorVersionNumber = NamespaceSplitter.this._versionQualifierExtensions.toMajorVersionNumber(_version);
          boolean _equals = Objects.equal(_majorVersionNumber, Integer.valueOf(majorVer));
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<VersionedDomainNamespace> _filter = IterableExtensions.<VersionedDomainNamespace>filter(canditates, _function);
    final Function1<VersionedDomainNamespace,String> _function_1 = new Function1<VersionedDomainNamespace,String>() {
        public String apply(final VersionedDomainNamespace e) {
          String _version = e.getVersion();
          return _version;
        }
      };
    List<VersionedDomainNamespace> _sortBy = IterableExtensions.<VersionedDomainNamespace, String>sortBy(_filter, _function_1);
    List<VersionedDomainNamespace> _reverse = ListExtensions.<VersionedDomainNamespace>reverse(_sortBy);
    List<VersionedDomainNamespace> _list = IterableExtensions.<VersionedDomainNamespace>toList(_reverse);
    VersionedDomainNamespace _head = IterableExtensions.<VersionedDomainNamespace>head(_list);
    return _head;
  }
  
  /**
   * Create a VersionedDomainNamespace for a Type
   */
  protected VersionedDomainNamespace _createVersionedDomainNamespace(final Type type) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(type);
    final VersionedDomainNamespace _result;
    synchronized (_createCache_createVersionedDomainNamespace) {
      if (_createCache_createVersionedDomainNamespace.containsKey(_cacheKey)) {
        return _createCache_createVersionedDomainNamespace.get(_cacheKey);
      }
      VersionedDomainNamespace _versionedDomainNamespace = new VersionedDomainNamespace();
      _result = _versionedDomainNamespace;
      _createCache_createVersionedDomainNamespace.put(_cacheKey, _result);
    }
    _init_createVersionedDomainNamespace(_result, type);
    return _result;
  }
  
  private final HashMap<ArrayList<? extends Object>,VersionedDomainNamespace> _createCache_createVersionedDomainNamespace = CollectionLiterals.newHashMap();
  
  private void _init_createVersionedDomainNamespace(final VersionedDomainNamespace it, final Type type) {
  }
  
  /**
   * Create a VersionedDomainNamespace for a Service
   */
  public VersionedDomainNamespace createVersionedDomainNamespace(final SubNamespace ns, final Version v) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(ns, v);
    final VersionedDomainNamespace _result;
    synchronized (_createCache_createVersionedDomainNamespace_1) {
      if (_createCache_createVersionedDomainNamespace_1.containsKey(_cacheKey)) {
        return _createCache_createVersionedDomainNamespace_1.get(_cacheKey);
      }
      VersionedDomainNamespace _versionedDomainNamespace = new VersionedDomainNamespace();
      _result = _versionedDomainNamespace;
      _createCache_createVersionedDomainNamespace_1.put(_cacheKey, _result);
    }
    _init_createVersionedDomainNamespace(_result, ns, v);
    return _result;
  }
  
  private final HashMap<ArrayList<? extends Object>,VersionedDomainNamespace> _createCache_createVersionedDomainNamespace_1 = CollectionLiterals.newHashMap();
  
  private void _init_createVersionedDomainNamespace(final VersionedDomainNamespace it, final SubNamespace ns, final Version v) {
    EObject _eContainer = ns.eContainer();
    if ((_eContainer instanceof SubNamespace)) {
      EObject _eContainer_1 = ns.eContainer();
      String _name = ((SubNamespace) _eContainer_1).getName();
      String _stripXtextEscapes = this._commonStringExtensions.stripXtextEscapes(_name);
      it.setName(_stripXtextEscapes);
      EObject _eContainer_2 = ns.eContainer();
      String _prefix = ((SubNamespace) _eContainer_2)==null?(String)null:((SubNamespace) _eContainer_2).getPrefix();
      String _stripXtextEscapes_1 = this._commonStringExtensions.stripXtextEscapes(_prefix);
      it.setShortName(_stripXtextEscapes_1);
    } else {
      EObject _eContainer_3 = ns.eContainer();
      String _name_1 = ((OrganizationNamespace) _eContainer_3).getName();
      String _stripXtextEscapes_2 = this._commonStringExtensions.stripXtextEscapes(_name_1);
      it.setName(_stripXtextEscapes_2);
      EObject _eContainer_4 = ns.eContainer();
      String _prefix_1 = ((OrganizationNamespace) _eContainer_4)==null?(String)null:((OrganizationNamespace) _eContainer_4).getPrefix();
      String _stripXtextEscapes_3 = this._commonStringExtensions.stripXtextEscapes(_prefix_1);
      it.setShortName(_stripXtextEscapes_3);
    }
    it.setSubdomain(ns);
    QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(ns);
    String _string = _fullyQualifiedName.toString();
    it.setFqn(_string);
    String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(v);
    it.setVersion(_majorVersionNumber);
    String _version = v.getVersion();
    String _majorVersionNumber_1 = this._versionQualifierExtensions.toMajorVersionNumber(_version);
    List<VersionedType> _allTypesByMajorVersion = this._versionedTypeFilter.allTypesByMajorVersion(ns, _majorVersionNumber_1);
    final Function1<VersionedType,Type> _function = new Function1<VersionedType,Type>() {
        public Type apply(final VersionedType t) {
          return ((Type) t);
        }
      };
    List<Type> _map = ListExtensions.<VersionedType, Type>map(_allTypesByMajorVersion, _function);
    List<Type> _list = IterableExtensions.<Type>toList(_map);
    it.setTypes(_list);
    EList<Service> _services = ns.getServices();
    final Function1<Service,Boolean> _function_1 = new Function1<Service,Boolean>() {
        public Boolean apply(final Service t) {
          Version _version = t.getVersion();
          String _version_1 = v.getVersion();
          String _majorVersionNumber = NamespaceSplitter.this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
          boolean _matchesMajorVersion = NamespaceSplitter.this._versionMatcher.matchesMajorVersion(_version, _majorVersionNumber);
          return Boolean.valueOf(_matchesMajorVersion);
        }
      };
    Iterable<Service> _filter = IterableExtensions.<Service>filter(_services, _function_1);
    List<Service> _list_1 = IterableExtensions.<Service>toList(_filter);
    it.setServices(_list_1);
    EList<org.fornax.soa.serviceDsl.Exception> _exceptions = ns.getExceptions();
    final Function1<org.fornax.soa.serviceDsl.Exception,Boolean> _function_2 = new Function1<org.fornax.soa.serviceDsl.Exception,Boolean>() {
        public Boolean apply(final org.fornax.soa.serviceDsl.Exception t) {
          Version _version = t.getVersion();
          String _version_1 = v.getVersion();
          String _majorVersionNumber = NamespaceSplitter.this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
          boolean _matchesMajorVersion = NamespaceSplitter.this._versionMatcher.matchesMajorVersion(_version, _majorVersionNumber);
          return Boolean.valueOf(_matchesMajorVersion);
        }
      };
    Iterable<org.fornax.soa.serviceDsl.Exception> _filter_1 = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>filter(_exceptions, _function_2);
    List<org.fornax.soa.serviceDsl.Exception> _list_2 = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>toList(_filter_1);
    it.setExceptions(_list_2);
  }
  
  protected VersionedDomainNamespace _createVersionedDomainNamespace(final VersionedType c) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(c);
    final VersionedDomainNamespace _result;
    synchronized (_createCache_createVersionedDomainNamespace_2) {
      if (_createCache_createVersionedDomainNamespace_2.containsKey(_cacheKey)) {
        return _createCache_createVersionedDomainNamespace_2.get(_cacheKey);
      }
      VersionedDomainNamespace _versionedDomainNamespace = new VersionedDomainNamespace();
      _result = _versionedDomainNamespace;
      _createCache_createVersionedDomainNamespace_2.put(_cacheKey, _result);
    }
    _init_createVersionedDomainNamespace_1(_result, c);
    return _result;
  }
  
  private final HashMap<ArrayList<? extends Object>,VersionedDomainNamespace> _createCache_createVersionedDomainNamespace_2 = CollectionLiterals.newHashMap();
  
  private void _init_createVersionedDomainNamespace_1(final VersionedDomainNamespace it, final VersionedType c) {
    EObject _eContainer = c.eContainer();
    if ((_eContainer instanceof SubNamespace)) {
      EObject _eContainer_1 = c.eContainer();
      String _name = ((SubNamespace) _eContainer_1).getName();
      String _stripXtextEscapes = this._commonStringExtensions.stripXtextEscapes(_name);
      it.setName(_stripXtextEscapes);
      EObject _eContainer_2 = c.eContainer();
      String _prefix = ((SubNamespace) _eContainer_2).getPrefix();
      String _stripXtextEscapes_1 = _prefix==null?(String)null:this._commonStringExtensions.stripXtextEscapes(_prefix);
      it.setShortName(_stripXtextEscapes_1);
    } else {
      EObject _eContainer_3 = c.eContainer();
      String _name_1 = ((OrganizationNamespace) _eContainer_3).getName();
      String _stripXtextEscapes_2 = this._commonStringExtensions.stripXtextEscapes(_name_1);
      it.setName(_stripXtextEscapes_2);
      EObject _eContainer_4 = c.eContainer();
      String _prefix_1 = ((OrganizationNamespace) _eContainer_4).getPrefix();
      String _stripXtextEscapes_3 = _prefix_1==null?(String)null:this._commonStringExtensions.stripXtextEscapes(_prefix_1);
      it.setShortName(_stripXtextEscapes_3);
    }
    EObject _eContainer_5 = c.eContainer();
    it.setSubdomain(_eContainer_5);
    EObject _eContainer_6 = c.eContainer();
    QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(_eContainer_6);
    String _string = _fullyQualifiedName.toString();
    it.setFqn(_string);
    Version _version = c.getVersion();
    String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_version);
    it.setVersion(_majorVersionNumber);
    EObject _eContainer_7 = c.eContainer();
    Version _version_1 = c.getVersion();
    String _majorVersionNumber_1 = this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
    List<VersionedType> _allTypesByMajorVersion = this._versionedTypeFilter.allTypesByMajorVersion(((SubNamespace) _eContainer_7), _majorVersionNumber_1);
    final Function1<VersionedType,Type> _function = new Function1<VersionedType,Type>() {
        public Type apply(final VersionedType t) {
          return ((Type) t);
        }
      };
    List<Type> _map = ListExtensions.<VersionedType, Type>map(_allTypesByMajorVersion, _function);
    List<Type> _list = IterableExtensions.<Type>toList(_map);
    it.setTypes(_list);
    EObject _eContainer_8 = c.eContainer();
    EList<Service> _services = ((SubNamespace) _eContainer_8).getServices();
    final Function1<Service,Boolean> _function_1 = new Function1<Service,Boolean>() {
        public Boolean apply(final Service t) {
          Version _version = t.getVersion();
          Version _version_1 = c.getVersion();
          String _majorVersionNumber = NamespaceSplitter.this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
          boolean _matchesMajorVersion = NamespaceSplitter.this._versionMatcher.matchesMajorVersion(_version, _majorVersionNumber);
          return Boolean.valueOf(_matchesMajorVersion);
        }
      };
    Iterable<Service> _filter = IterableExtensions.<Service>filter(_services, _function_1);
    List<Service> _list_1 = IterableExtensions.<Service>toList(_filter);
    it.setServices(_list_1);
    EObject _eContainer_9 = c.eContainer();
    EList<org.fornax.soa.serviceDsl.Exception> _exceptions = ((SubNamespace) _eContainer_9).getExceptions();
    final Function1<org.fornax.soa.serviceDsl.Exception,Boolean> _function_2 = new Function1<org.fornax.soa.serviceDsl.Exception,Boolean>() {
        public Boolean apply(final org.fornax.soa.serviceDsl.Exception t) {
          Version _version = t.getVersion();
          Version _version_1 = c.getVersion();
          String _majorVersionNumber = NamespaceSplitter.this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
          boolean _matchesMajorVersion = NamespaceSplitter.this._versionMatcher.matchesMajorVersion(_version, _majorVersionNumber);
          return Boolean.valueOf(_matchesMajorVersion);
        }
      };
    Iterable<org.fornax.soa.serviceDsl.Exception> _filter_1 = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>filter(_exceptions, _function_2);
    List<org.fornax.soa.serviceDsl.Exception> _list_2 = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>toList(_filter_1);
    it.setExceptions(_list_2);
  }
  
  /**
   * Create a VersionedDomainNamespace for an Exception
   */
  protected VersionedDomainNamespace _createVersionedDomainNamespace(final org.fornax.soa.serviceDsl.Exception c) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(c);
    final VersionedDomainNamespace _result;
    synchronized (_createCache_createVersionedDomainNamespace_3) {
      if (_createCache_createVersionedDomainNamespace_3.containsKey(_cacheKey)) {
        return _createCache_createVersionedDomainNamespace_3.get(_cacheKey);
      }
      VersionedDomainNamespace _versionedDomainNamespace = new VersionedDomainNamespace();
      _result = _versionedDomainNamespace;
      _createCache_createVersionedDomainNamespace_3.put(_cacheKey, _result);
    }
    _init_createVersionedDomainNamespace_2(_result, c);
    return _result;
  }
  
  private final HashMap<ArrayList<? extends Object>,VersionedDomainNamespace> _createCache_createVersionedDomainNamespace_3 = CollectionLiterals.newHashMap();
  
  private void _init_createVersionedDomainNamespace_2(final VersionedDomainNamespace it, final org.fornax.soa.serviceDsl.Exception c) {
    EObject _eContainer = c.eContainer();
    if ((_eContainer instanceof SubNamespace)) {
      EObject _eContainer_1 = c.eContainer();
      String _name = ((SubNamespace) _eContainer_1).getName();
      String _stripXtextEscapes = this._commonStringExtensions.stripXtextEscapes(_name);
      it.setName(_stripXtextEscapes);
      EObject _eContainer_2 = c.eContainer();
      String _prefix = ((SubNamespace) _eContainer_2).getPrefix();
      String _stripXtextEscapes_1 = _prefix==null?(String)null:this._commonStringExtensions.stripXtextEscapes(_prefix);
      it.setShortName(_stripXtextEscapes_1);
    } else {
      EObject _eContainer_3 = c.eContainer();
      String _name_1 = ((OrganizationNamespace) _eContainer_3).getName();
      String _stripXtextEscapes_2 = this._commonStringExtensions.stripXtextEscapes(_name_1);
      it.setName(_stripXtextEscapes_2);
      EObject _eContainer_4 = c.eContainer();
      String _prefix_1 = ((OrganizationNamespace) _eContainer_4).getPrefix();
      String _stripXtextEscapes_3 = _prefix_1==null?(String)null:this._commonStringExtensions.stripXtextEscapes(_prefix_1);
      it.setShortName(_stripXtextEscapes_3);
    }
    EObject _eContainer_5 = c.eContainer();
    it.setSubdomain(_eContainer_5);
    EObject _eContainer_6 = c.eContainer();
    QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(_eContainer_6);
    String _string = _fullyQualifiedName.toString();
    it.setFqn(_string);
    Version _version = c.getVersion();
    String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_version);
    it.setVersion(_majorVersionNumber);
    EObject _eContainer_7 = c.eContainer();
    EList<Type> _types = ((SubNamespace) _eContainer_7).getTypes();
    Iterable<VersionedType> _filter = Iterables.<VersionedType>filter(_types, VersionedType.class);
    final Function1<VersionedType,Boolean> _function = new Function1<VersionedType,Boolean>() {
        public Boolean apply(final VersionedType t) {
          Version _version = t.getVersion();
          Version _version_1 = c.getVersion();
          String _majorVersionNumber = NamespaceSplitter.this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
          boolean _matchesMajorVersion = NamespaceSplitter.this._versionMatcher.matchesMajorVersion(_version, _majorVersionNumber);
          return Boolean.valueOf(_matchesMajorVersion);
        }
      };
    Iterable<VersionedType> _filter_1 = IterableExtensions.<VersionedType>filter(_filter, _function);
    final Function1<VersionedType,Type> _function_1 = new Function1<VersionedType,Type>() {
        public Type apply(final VersionedType t) {
          return ((Type) t);
        }
      };
    Iterable<Type> _map = IterableExtensions.<VersionedType, Type>map(_filter_1, _function_1);
    List<Type> _list = IterableExtensions.<Type>toList(_map);
    it.setTypes(_list);
    EObject _eContainer_8 = c.eContainer();
    EList<Service> _services = ((SubNamespace) _eContainer_8).getServices();
    final Function1<Service,Boolean> _function_2 = new Function1<Service,Boolean>() {
        public Boolean apply(final Service t) {
          Version _version = t.getVersion();
          Version _version_1 = c.getVersion();
          String _majorVersionNumber = NamespaceSplitter.this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
          boolean _matchesMajorVersion = NamespaceSplitter.this._versionMatcher.matchesMajorVersion(_version, _majorVersionNumber);
          return Boolean.valueOf(_matchesMajorVersion);
        }
      };
    Iterable<Service> _filter_2 = IterableExtensions.<Service>filter(_services, _function_2);
    List<Service> _list_1 = IterableExtensions.<Service>toList(_filter_2);
    it.setServices(_list_1);
    EObject _eContainer_9 = c.eContainer();
    EList<org.fornax.soa.serviceDsl.Exception> _exceptions = ((SubNamespace) _eContainer_9).getExceptions();
    final Function1<org.fornax.soa.serviceDsl.Exception,Boolean> _function_3 = new Function1<org.fornax.soa.serviceDsl.Exception,Boolean>() {
        public Boolean apply(final org.fornax.soa.serviceDsl.Exception t) {
          Version _version = t.getVersion();
          Version _version_1 = c.getVersion();
          String _majorVersionNumber = NamespaceSplitter.this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
          boolean _matchesMajorVersion = NamespaceSplitter.this._versionMatcher.matchesMajorVersion(_version, _majorVersionNumber);
          return Boolean.valueOf(_matchesMajorVersion);
        }
      };
    Iterable<org.fornax.soa.serviceDsl.Exception> _filter_3 = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>filter(_exceptions, _function_3);
    List<org.fornax.soa.serviceDsl.Exception> _list_2 = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>toList(_filter_3);
    it.setExceptions(_list_2);
  }
  
  protected VersionedDomainNamespace _createVersionedDomainNamespace(final Service c) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(c);
    final VersionedDomainNamespace _result;
    synchronized (_createCache_createVersionedDomainNamespace_4) {
      if (_createCache_createVersionedDomainNamespace_4.containsKey(_cacheKey)) {
        return _createCache_createVersionedDomainNamespace_4.get(_cacheKey);
      }
      VersionedDomainNamespace _versionedDomainNamespace = new VersionedDomainNamespace();
      _result = _versionedDomainNamespace;
      _createCache_createVersionedDomainNamespace_4.put(_cacheKey, _result);
    }
    _init_createVersionedDomainNamespace_3(_result, c);
    return _result;
  }
  
  private final HashMap<ArrayList<? extends Object>,VersionedDomainNamespace> _createCache_createVersionedDomainNamespace_4 = CollectionLiterals.newHashMap();
  
  private void _init_createVersionedDomainNamespace_3(final VersionedDomainNamespace it, final Service c) {
    EObject _eContainer = c.eContainer();
    if ((_eContainer instanceof SubNamespace)) {
      EObject _eContainer_1 = c.eContainer();
      String _name = ((SubNamespace) _eContainer_1).getName();
      String _stripXtextEscapes = this._commonStringExtensions.stripXtextEscapes(_name);
      it.setName(_stripXtextEscapes);
      EObject _eContainer_2 = c.eContainer();
      String _prefix = ((SubNamespace) _eContainer_2).getPrefix();
      String _stripXtextEscapes_1 = _prefix==null?(String)null:this._commonStringExtensions.stripXtextEscapes(_prefix);
      it.setShortName(_stripXtextEscapes_1);
    } else {
      EObject _eContainer_3 = c.eContainer();
      String _name_1 = ((OrganizationNamespace) _eContainer_3).getName();
      String _stripXtextEscapes_2 = this._commonStringExtensions.stripXtextEscapes(_name_1);
      it.setName(_stripXtextEscapes_2);
      EObject _eContainer_4 = c.eContainer();
      String _prefix_1 = ((OrganizationNamespace) _eContainer_4).getPrefix();
      String _stripXtextEscapes_3 = _prefix_1==null?(String)null:this._commonStringExtensions.stripXtextEscapes(_prefix_1);
      it.setShortName(_stripXtextEscapes_3);
    }
    EObject _eContainer_5 = c.eContainer();
    it.setSubdomain(_eContainer_5);
    EObject _eContainer_6 = c.eContainer();
    QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(_eContainer_6);
    String _string = _fullyQualifiedName.toString();
    it.setFqn(_string);
    Version _version = c.getVersion();
    String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_version);
    it.setVersion(_majorVersionNumber);
    EObject _eContainer_7 = c.eContainer();
    EList<Type> _types = ((SubNamespace) _eContainer_7).getTypes();
    Iterable<VersionedType> _filter = Iterables.<VersionedType>filter(_types, VersionedType.class);
    final Function1<VersionedType,Boolean> _function = new Function1<VersionedType,Boolean>() {
        public Boolean apply(final VersionedType t) {
          Version _version = t.getVersion();
          Version _version_1 = c.getVersion();
          String _majorVersionNumber = NamespaceSplitter.this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
          boolean _matchesMajorVersion = NamespaceSplitter.this._versionMatcher.matchesMajorVersion(_version, _majorVersionNumber);
          return Boolean.valueOf(_matchesMajorVersion);
        }
      };
    Iterable<VersionedType> _filter_1 = IterableExtensions.<VersionedType>filter(_filter, _function);
    final Function1<VersionedType,Type> _function_1 = new Function1<VersionedType,Type>() {
        public Type apply(final VersionedType t) {
          return ((Type) t);
        }
      };
    Iterable<Type> _map = IterableExtensions.<VersionedType, Type>map(_filter_1, _function_1);
    List<Type> _list = IterableExtensions.<Type>toList(_map);
    it.setTypes(_list);
    EObject _eContainer_8 = c.eContainer();
    EList<Service> _services = ((SubNamespace) _eContainer_8).getServices();
    final Function1<Service,Boolean> _function_2 = new Function1<Service,Boolean>() {
        public Boolean apply(final Service t) {
          Version _version = t.getVersion();
          Version _version_1 = c.getVersion();
          String _majorVersionNumber = NamespaceSplitter.this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
          boolean _matchesMajorVersion = NamespaceSplitter.this._versionMatcher.matchesMajorVersion(_version, _majorVersionNumber);
          return Boolean.valueOf(_matchesMajorVersion);
        }
      };
    Iterable<Service> _filter_2 = IterableExtensions.<Service>filter(_services, _function_2);
    List<Service> _list_1 = IterableExtensions.<Service>toList(_filter_2);
    it.setServices(_list_1);
    EObject _eContainer_9 = c.eContainer();
    EList<org.fornax.soa.serviceDsl.Exception> _exceptions = ((SubNamespace) _eContainer_9).getExceptions();
    final Function1<org.fornax.soa.serviceDsl.Exception,Boolean> _function_3 = new Function1<org.fornax.soa.serviceDsl.Exception,Boolean>() {
        public Boolean apply(final org.fornax.soa.serviceDsl.Exception t) {
          Version _version = t.getVersion();
          Version _version_1 = c.getVersion();
          String _majorVersionNumber = NamespaceSplitter.this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
          boolean _matchesMajorVersion = NamespaceSplitter.this._versionMatcher.matchesMajorVersion(_version, _majorVersionNumber);
          return Boolean.valueOf(_matchesMajorVersion);
        }
      };
    Iterable<org.fornax.soa.serviceDsl.Exception> _filter_3 = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>filter(_exceptions, _function_3);
    List<org.fornax.soa.serviceDsl.Exception> _list_2 = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>toList(_filter_3);
    it.setExceptions(_list_2);
  }
  
  public Set<VersionedDomainNamespace> splitNamespaceByMajorVersion(final Object s) {
    if (s instanceof SubNamespace) {
      return _splitNamespaceByMajorVersion((SubNamespace)s);
    } else if (s != null) {
      return _splitNamespaceByMajorVersion(s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s).toString());
    }
  }
  
  public VersionedDomainNamespace createVersionedDomainNamespace(final EObject c) {
    if (c instanceof VersionedType) {
      return _createVersionedDomainNamespace((VersionedType)c);
    } else if (c instanceof org.fornax.soa.serviceDsl.Exception) {
      return _createVersionedDomainNamespace((org.fornax.soa.serviceDsl.Exception)c);
    } else if (c instanceof Service) {
      return _createVersionedDomainNamespace((Service)c);
    } else if (c instanceof Type) {
      return _createVersionedDomainNamespace((Type)c);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(c).toString());
    }
  }
}
