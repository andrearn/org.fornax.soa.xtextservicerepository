package org.fornax.soa.profiledsl.versioning;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.fornax.soa.basedsl.CommonEObjectExtensions;
import org.fornax.soa.basedsl.CommonStringExtensions;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.version.VersionQualifierExtensions;
import org.fornax.soa.profiledsl.sOAProfileDsl.OrganizationNamespace;
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace;
import org.fornax.soa.profiledsl.sOAProfileDsl.Type;
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType;
import org.fornax.soa.profiledsl.versioning.VersionedTechnicalNamespace;

@SuppressWarnings("all")
public class TechnicalNamespaceSplitter {
  @Inject
  private VersionQualifierExtensions _versionQualifierExtensions;
  
  @Inject
  private CommonStringExtensions _commonStringExtensions;
  
  @Inject
  private CommonEObjectExtensions _commonEObjectExtensions;
  
  /**
   * Split into VersionedDomainNamespace per accounted major version of contained versioned elements
   */
  public Set<VersionedTechnicalNamespace> toVersionedTechnicalNamespaces(final TechnicalNamespace s) {
    Set<VersionedTechnicalNamespace> _xifexpression = null;
    EList<Type> _types = s.getTypes();
    int _size = _types.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      EList<Type> _types_1 = s.getTypes();
      final Function1<Type,VersionedTechnicalNamespace> _function = new Function1<Type,VersionedTechnicalNamespace>() {
          public VersionedTechnicalNamespace apply(final Type t) {
            VersionedTechnicalNamespace _createVersionedTechnicalNamespace = TechnicalNamespaceSplitter.this.createVersionedTechnicalNamespace(t);
            return _createVersionedTechnicalNamespace;
          }
        };
      List<VersionedTechnicalNamespace> _map = ListExtensions.<Type, VersionedTechnicalNamespace>map(_types_1, _function);
      Set<VersionedTechnicalNamespace> _set = IterableExtensions.<VersionedTechnicalNamespace>toSet(_map);
      _xifexpression = _set;
    } else {
      HashSet<VersionedTechnicalNamespace> _newHashSet = CollectionLiterals.<VersionedTechnicalNamespace>newHashSet();
      _xifexpression = _newHashSet;
    }
    return _xifexpression;
  }
  
  public Set<VersionedTechnicalNamespace> getAllLatestSubNamespacesByMajorVersion(final Set<VersionedTechnicalNamespace> canditates) {
    final Function1<VersionedTechnicalNamespace,Boolean> _function = new Function1<VersionedTechnicalNamespace,Boolean>() {
        public Boolean apply(final VersionedTechnicalNamespace e) {
          final Function1<VersionedTechnicalNamespace,Boolean> _function = new Function1<VersionedTechnicalNamespace,Boolean>() {
              public Boolean apply(final VersionedTechnicalNamespace c) {
                boolean _and = false;
                String _version = c.getVersion();
                String _majorVersionNumber = TechnicalNamespaceSplitter.this._versionQualifierExtensions.toMajorVersionNumber(_version);
                String _version_1 = e.getVersion();
                String _majorVersionNumber_1 = TechnicalNamespaceSplitter.this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
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
          boolean _exists = IterableExtensions.<VersionedTechnicalNamespace>exists(canditates, _function);
          boolean _not = (!_exists);
          return Boolean.valueOf(_not);
        }
      };
    Iterable<VersionedTechnicalNamespace> _filter = IterableExtensions.<VersionedTechnicalNamespace>filter(canditates, _function);
    Set<VersionedTechnicalNamespace> _set = IterableExtensions.<VersionedTechnicalNamespace>toSet(_filter);
    return _set;
  }
  
  public VersionedTechnicalNamespace getLatestSubNamespaceByMajorVersion(final Set<VersionedTechnicalNamespace> canditates, final int majorVer) {
    final Function1<VersionedTechnicalNamespace,Boolean> _function = new Function1<VersionedTechnicalNamespace,Boolean>() {
        public Boolean apply(final VersionedTechnicalNamespace e) {
          String _version = e.getVersion();
          String _majorVersionNumber = TechnicalNamespaceSplitter.this._versionQualifierExtensions.toMajorVersionNumber(_version);
          boolean _equals = Objects.equal(_majorVersionNumber, Integer.valueOf(majorVer));
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<VersionedTechnicalNamespace> _filter = IterableExtensions.<VersionedTechnicalNamespace>filter(canditates, _function);
    final Function1<VersionedTechnicalNamespace,String> _function_1 = new Function1<VersionedTechnicalNamespace,String>() {
        public String apply(final VersionedTechnicalNamespace e) {
          String _version = e.getVersion();
          return _version;
        }
      };
    List<VersionedTechnicalNamespace> _sortBy = IterableExtensions.<VersionedTechnicalNamespace, String>sortBy(_filter, _function_1);
    List<VersionedTechnicalNamespace> _reverse = ListExtensions.<VersionedTechnicalNamespace>reverse(_sortBy);
    List<VersionedTechnicalNamespace> _list = IterableExtensions.<VersionedTechnicalNamespace>toList(_reverse);
    VersionedTechnicalNamespace _head = IterableExtensions.<VersionedTechnicalNamespace>head(_list);
    return _head;
  }
  
  protected VersionedTechnicalNamespace _createVersionedTechnicalNamespace(final EObject c) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(c);
    final VersionedTechnicalNamespace _result;
    synchronized (_createCache_createVersionedTechnicalNamespace) {
      if (_createCache_createVersionedTechnicalNamespace.containsKey(_cacheKey)) {
        return _createCache_createVersionedTechnicalNamespace.get(_cacheKey);
      }
      VersionedTechnicalNamespace _versionedTechnicalNamespace = new VersionedTechnicalNamespace();
      _result = _versionedTechnicalNamespace;
      _createCache_createVersionedTechnicalNamespace.put(_cacheKey, _result);
    }
    _init_createVersionedTechnicalNamespace(_result, c);
    return _result;
  }
  
  private final HashMap<ArrayList<? extends Object>,VersionedTechnicalNamespace> _createCache_createVersionedTechnicalNamespace = CollectionLiterals.newHashMap();
  
  private void _init_createVersionedTechnicalNamespace(final VersionedTechnicalNamespace it, final EObject c) {
  }
  
  protected VersionedTechnicalNamespace _createVersionedTechnicalNamespace(final VersionedType c) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(c);
    final VersionedTechnicalNamespace _result;
    synchronized (_createCache_createVersionedTechnicalNamespace_1) {
      if (_createCache_createVersionedTechnicalNamespace_1.containsKey(_cacheKey)) {
        return _createCache_createVersionedTechnicalNamespace_1.get(_cacheKey);
      }
      VersionedTechnicalNamespace _versionedTechnicalNamespace = new VersionedTechnicalNamespace();
      _result = _versionedTechnicalNamespace;
      _createCache_createVersionedTechnicalNamespace_1.put(_cacheKey, _result);
    }
    _init_createVersionedTechnicalNamespace_1(_result, c);
    return _result;
  }
  
  private final HashMap<ArrayList<? extends Object>,VersionedTechnicalNamespace> _createCache_createVersionedTechnicalNamespace_1 = CollectionLiterals.newHashMap();
  
  private void _init_createVersionedTechnicalNamespace_1(final VersionedTechnicalNamespace it, final VersionedType c) {
    EObject _eContainer = c.eContainer();
    if ((_eContainer instanceof TechnicalNamespace)) {
      EObject _eContainer_1 = c.eContainer();
      String _name = ((TechnicalNamespace) _eContainer_1).getName();
      String _stripXtextEscapes = this._commonStringExtensions.stripXtextEscapes(_name);
      it.setName(_stripXtextEscapes);
      EObject _eContainer_2 = c.eContainer();
      String _prefix = ((TechnicalNamespace) _eContainer_2).getPrefix();
      String _stripXtextEscapes_1 = _prefix==null?(String)null:this._commonStringExtensions.stripXtextEscapes(_prefix);
      it.setShortName(_stripXtextEscapes_1);
    } else {
      EObject _eContainer_3 = c.eContainer();
      String _name_1 = ((OrganizationNamespace) _eContainer_3).getName();
      String _stripXtextEscapes_2 = this._commonStringExtensions.stripXtextEscapes(_name_1);
      it.setName(_stripXtextEscapes_2);
      EObject _eContainer_4 = c.eContainer();
      String _prefix_1 = ((OrganizationNamespace) _eContainer_4).getPrefix();
      String _stripXtextEscapes_3 = this._commonStringExtensions.stripXtextEscapes(_prefix_1);
      it.setShortName(_stripXtextEscapes_3);
    }
    EObject _eContainer_5 = c.eContainer();
    it.setNamespace(((TechnicalNamespace) _eContainer_5));
    EObject _eContainer_6 = c.eContainer();
    String _fqn = this._commonEObjectExtensions.fqn(_eContainer_6);
    it.setFqn(_fqn);
    Version _version = c.getVersion();
    String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_version);
    it.setVersion(_majorVersionNumber);
  }
  
  protected VersionedTechnicalNamespace _createVersionedTechnicalNamespace(final Type c) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(c);
    final VersionedTechnicalNamespace _result;
    synchronized (_createCache_createVersionedTechnicalNamespace_2) {
      if (_createCache_createVersionedTechnicalNamespace_2.containsKey(_cacheKey)) {
        return _createCache_createVersionedTechnicalNamespace_2.get(_cacheKey);
      }
      VersionedTechnicalNamespace _versionedTechnicalNamespace = new VersionedTechnicalNamespace();
      _result = _versionedTechnicalNamespace;
      _createCache_createVersionedTechnicalNamespace_2.put(_cacheKey, _result);
    }
    _init_createVersionedTechnicalNamespace_2(_result, c);
    return _result;
  }
  
  private final HashMap<ArrayList<? extends Object>,VersionedTechnicalNamespace> _createCache_createVersionedTechnicalNamespace_2 = CollectionLiterals.newHashMap();
  
  private void _init_createVersionedTechnicalNamespace_2(final VersionedTechnicalNamespace it, final Type c) {
    EObject _eContainer = c.eContainer();
    if ((_eContainer instanceof TechnicalNamespace)) {
      EObject _eContainer_1 = c.eContainer();
      String _name = ((TechnicalNamespace) _eContainer_1).getName();
      String _stripXtextEscapes = this._commonStringExtensions.stripXtextEscapes(_name);
      it.setName(_stripXtextEscapes);
      EObject _eContainer_2 = c.eContainer();
      String _prefix = ((TechnicalNamespace) _eContainer_2).getPrefix();
      String _stripXtextEscapes_1 = _prefix==null?(String)null:this._commonStringExtensions.stripXtextEscapes(_prefix);
      it.setShortName(_stripXtextEscapes_1);
    } else {
      EObject _eContainer_3 = c.eContainer();
      String _name_1 = ((OrganizationNamespace) _eContainer_3).getName();
      String _stripXtextEscapes_2 = this._commonStringExtensions.stripXtextEscapes(_name_1);
      it.setName(_stripXtextEscapes_2);
      EObject _eContainer_4 = c.eContainer();
      String _prefix_1 = ((OrganizationNamespace) _eContainer_4).getPrefix();
      String _stripXtextEscapes_3 = this._commonStringExtensions.stripXtextEscapes(_prefix_1);
      it.setShortName(_stripXtextEscapes_3);
    }
    EObject _eContainer_5 = c.eContainer();
    it.setNamespace(((TechnicalNamespace) _eContainer_5));
    EObject _eContainer_6 = c.eContainer();
    String _fqn = this._commonEObjectExtensions.fqn(_eContainer_6);
    it.setFqn(_fqn);
  }
  
  public VersionedTechnicalNamespace createVersionedTechnicalNamespace(final EObject c) {
    if (c instanceof VersionedType) {
      return _createVersionedTechnicalNamespace((VersionedType)c);
    } else if (c instanceof Type) {
      return _createVersionedTechnicalNamespace((Type)c);
    } else if (c != null) {
      return _createVersionedTechnicalNamespace(c);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(c).toString());
    }
  }
}
