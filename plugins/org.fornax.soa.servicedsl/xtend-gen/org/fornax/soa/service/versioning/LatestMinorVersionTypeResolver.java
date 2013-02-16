package org.fornax.soa.service.versioning;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.basedsl.version.VersionMatcher;
import org.fornax.soa.profiledsl.sOAProfileDsl.DataType;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.search.StateMatcher;
import org.fornax.soa.service.query.namespace.NamespaceQuery;
import org.fornax.soa.service.versioning.ITypeResolver;
import org.fornax.soa.serviceDsl.AbstractVersionedTypeRef;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.BusinessObjectRef;
import org.fornax.soa.serviceDsl.DataTypeRef;
import org.fornax.soa.serviceDsl.EnumTypeRef;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.serviceDsl.QueryObject;
import org.fornax.soa.serviceDsl.QueryObjectRef;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.Type;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.serviceDsl.VersionedType;
import org.fornax.soa.serviceDsl.VersionedTypeRef;

@SuppressWarnings("all")
public class LatestMinorVersionTypeResolver implements ITypeResolver {
  @Inject
  private VersionMatcher _versionMatcher;
  
  @Inject
  private StateMatcher _stateMatcher;
  
  @Inject
  private NamespaceQuery _namespaceQuery;
  
  @Inject
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  protected VersionedType _selectMatchingType(final AbstractVersionedTypeRef ref) {
    return null;
  }
  
  protected VersionedType _selectMatchingType(final VersionedTypeRef ref) {
    VersionedType _type = ref.getType();
    return _type;
  }
  
  protected VersionedType _selectMatchingType(final BusinessObjectRef ref) {
    BusinessObject _type = ref.getType();
    return _type;
  }
  
  protected VersionedType _selectMatchingType(final QueryObjectRef ref) {
    QueryObject _type = ref.getType();
    return _type;
  }
  
  protected VersionedType _selectMatchingType(final EnumTypeRef ref) {
    Enumeration _type = ref.getType();
    return _type;
  }
  
  protected VersionedType _selectMatchingTypeByState(final AbstractVersionedTypeRef ref, final LifecycleState minState) {
    return null;
  }
  
  protected VersionedType _selectMatchingTypeByState(final VersionedTypeRef ref, final LifecycleState minState) {
    VersionedType _type = ref.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    EList<Type> _types = _findSubdomain.getTypes();
    Iterable<VersionedType> _filter = Iterables.<VersionedType>filter(_types, VersionedType.class);
    final Function1<VersionedType,Boolean> _function = new Function1<VersionedType,Boolean>() {
        public Boolean apply(final VersionedType e) {
          LifecycleState _state = e.getState();
          boolean _matchesMinStateLevel = LatestMinorVersionTypeResolver.this._stateMatcher.matchesMinStateLevel(_state, minState);
          return Boolean.valueOf(_matchesMinStateLevel);
        }
      };
    Iterable<VersionedType> _filter_1 = IterableExtensions.<VersionedType>filter(_filter, _function);
    final Function1<VersionedType,Boolean> _function_1 = new Function1<VersionedType,Boolean>() {
        public Boolean apply(final VersionedType t) {
          boolean _and = false;
          String _name = t.getName();
          VersionedType _type = ref.getType();
          String _name_1 = _type.getName();
          boolean _equals = Objects.equal(_name, _name_1);
          if (!_equals) {
            _and = false;
          } else {
            Version _version = t.getVersion();
            VersionRef _versionRef = ref.getVersionRef();
            boolean _versionMatches = LatestMinorVersionTypeResolver.this._versionMatcher.versionMatches(_version, _versionRef);
            _and = (_equals && _versionMatches);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<VersionedType> _filter_2 = IterableExtensions.<VersionedType>filter(_filter_1, _function_1);
    final Function1<VersionedType,String> _function_2 = new Function1<VersionedType,String>() {
        public String apply(final VersionedType e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          return _version_1;
        }
      };
    List<VersionedType> _sortBy = IterableExtensions.<VersionedType, String>sortBy(_filter_2, _function_2);
    VersionedType _last = IterableExtensions.<VersionedType>last(_sortBy);
    return _last;
  }
  
  protected VersionedType _selectMatchingTypeByState(final BusinessObjectRef ref, final LifecycleState minState) {
    BusinessObject _type = ref.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    EList<Type> _types = _findSubdomain.getTypes();
    Iterable<VersionedType> _filter = Iterables.<VersionedType>filter(_types, VersionedType.class);
    final Function1<VersionedType,Boolean> _function = new Function1<VersionedType,Boolean>() {
        public Boolean apply(final VersionedType e) {
          LifecycleState _state = e.getState();
          boolean _matchesMinStateLevel = LatestMinorVersionTypeResolver.this._stateMatcher.matchesMinStateLevel(_state, minState);
          return Boolean.valueOf(_matchesMinStateLevel);
        }
      };
    Iterable<VersionedType> _filter_1 = IterableExtensions.<VersionedType>filter(_filter, _function);
    final Function1<VersionedType,Boolean> _function_1 = new Function1<VersionedType,Boolean>() {
        public Boolean apply(final VersionedType t) {
          boolean _and = false;
          String _name = t.getName();
          BusinessObject _type = ref.getType();
          String _name_1 = _type.getName();
          boolean _equals = Objects.equal(_name, _name_1);
          if (!_equals) {
            _and = false;
          } else {
            Version _version = t.getVersion();
            VersionRef _versionRef = ref.getVersionRef();
            boolean _versionMatches = LatestMinorVersionTypeResolver.this._versionMatcher.versionMatches(_version, _versionRef);
            _and = (_equals && _versionMatches);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<VersionedType> _filter_2 = IterableExtensions.<VersionedType>filter(_filter_1, _function_1);
    final Function1<VersionedType,String> _function_2 = new Function1<VersionedType,String>() {
        public String apply(final VersionedType e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          return _version_1;
        }
      };
    List<VersionedType> _sortBy = IterableExtensions.<VersionedType, String>sortBy(_filter_2, _function_2);
    VersionedType _last = IterableExtensions.<VersionedType>last(_sortBy);
    return _last;
  }
  
  protected VersionedType _selectMatchingTypeByState(final QueryObjectRef ref, final LifecycleState minState) {
    QueryObject _type = ref.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    EList<Type> _types = _findSubdomain.getTypes();
    Iterable<VersionedType> _filter = Iterables.<VersionedType>filter(_types, VersionedType.class);
    final Function1<VersionedType,Boolean> _function = new Function1<VersionedType,Boolean>() {
        public Boolean apply(final VersionedType e) {
          LifecycleState _state = e.getState();
          boolean _matchesMinStateLevel = LatestMinorVersionTypeResolver.this._stateMatcher.matchesMinStateLevel(_state, minState);
          return Boolean.valueOf(_matchesMinStateLevel);
        }
      };
    Iterable<VersionedType> _filter_1 = IterableExtensions.<VersionedType>filter(_filter, _function);
    final Function1<VersionedType,Boolean> _function_1 = new Function1<VersionedType,Boolean>() {
        public Boolean apply(final VersionedType t) {
          boolean _and = false;
          String _name = t.getName();
          QueryObject _type = ref.getType();
          String _name_1 = _type.getName();
          boolean _equals = Objects.equal(_name, _name_1);
          if (!_equals) {
            _and = false;
          } else {
            Version _version = t.getVersion();
            VersionRef _versionRef = ref.getVersionRef();
            boolean _versionMatches = LatestMinorVersionTypeResolver.this._versionMatcher.versionMatches(_version, _versionRef);
            _and = (_equals && _versionMatches);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<VersionedType> _filter_2 = IterableExtensions.<VersionedType>filter(_filter_1, _function_1);
    final Function1<VersionedType,String> _function_2 = new Function1<VersionedType,String>() {
        public String apply(final VersionedType e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          return _version_1;
        }
      };
    List<VersionedType> _sortBy = IterableExtensions.<VersionedType, String>sortBy(_filter_2, _function_2);
    VersionedType _last = IterableExtensions.<VersionedType>last(_sortBy);
    return _last;
  }
  
  protected VersionedType _selectMatchingTypeByState(final EnumTypeRef ref, final LifecycleState minState) {
    Enumeration _type = ref.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    EList<Type> _types = _findSubdomain.getTypes();
    Iterable<VersionedType> _filter = Iterables.<VersionedType>filter(_types, VersionedType.class);
    final Function1<VersionedType,Boolean> _function = new Function1<VersionedType,Boolean>() {
        public Boolean apply(final VersionedType e) {
          LifecycleState _state = e.getState();
          boolean _matchesMinStateLevel = LatestMinorVersionTypeResolver.this._stateMatcher.matchesMinStateLevel(_state, minState);
          return Boolean.valueOf(_matchesMinStateLevel);
        }
      };
    Iterable<VersionedType> _filter_1 = IterableExtensions.<VersionedType>filter(_filter, _function);
    final Function1<VersionedType,Boolean> _function_1 = new Function1<VersionedType,Boolean>() {
        public Boolean apply(final VersionedType t) {
          boolean _and = false;
          String _name = t.getName();
          Enumeration _type = ref.getType();
          String _name_1 = _type.getName();
          boolean _equals = Objects.equal(_name, _name_1);
          if (!_equals) {
            _and = false;
          } else {
            Version _version = t.getVersion();
            VersionRef _versionRef = ref.getVersionRef();
            boolean _versionMatches = LatestMinorVersionTypeResolver.this._versionMatcher.versionMatches(_version, _versionRef);
            _and = (_equals && _versionMatches);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<VersionedType> _filter_2 = IterableExtensions.<VersionedType>filter(_filter_1, _function_1);
    final Function1<VersionedType,String> _function_2 = new Function1<VersionedType,String>() {
        public String apply(final VersionedType e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          return _version_1;
        }
      };
    List<VersionedType> _sortBy = IterableExtensions.<VersionedType, String>sortBy(_filter_2, _function_2);
    VersionedType _last = IterableExtensions.<VersionedType>last(_sortBy);
    return _last;
  }
  
  /**
   * Checks if type declaration is the latest version matching the following constraint. The function
   * 	should never be called as Type is not versioned and considered abstract
   */
  protected boolean _isMatchingType(final Type t, final Integer majorVersion, final LifecycleState minState) {
    return false;
  }
  
  /**
   * Checks if type declaration is the latest version matching the following constraint
   * 		- same major version
   */
  public boolean isMatchingType(final VersionedType t, final Integer majorVersion) {
    EObject _eContainer = t.eContainer();
    EList<Type> _types = ((SubNamespace) _eContainer).getTypes();
    Iterable<VersionedType> _filter = Iterables.<VersionedType>filter(_types, VersionedType.class);
    final Function1<VersionedType,Boolean> _function = new Function1<VersionedType,Boolean>() {
        public Boolean apply(final VersionedType e) {
          String _name = e.getName();
          String _name_1 = t.getName();
          boolean _equals = Objects.equal(_name, _name_1);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<VersionedType> _filter_1 = IterableExtensions.<VersionedType>filter(_filter, _function);
    List<VersionedType> _list = IterableExtensions.<VersionedType>toList(_filter_1);
    Type _findMatchingVersionedType = this.findMatchingVersionedType(_list, majorVersion);
    boolean _equals = Objects.equal(_findMatchingVersionedType, t);
    return _equals;
  }
  
  /**
   * Checks if type declaration is the latest version matching the following constraint
   * 		- same major version
   */
  public boolean isMatchingType(final org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType t, final Integer majorVersion) {
    EObject _eContainer = t.eContainer();
    EList<Type> _types = ((SubNamespace) _eContainer).getTypes();
    Iterable<org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType> _filter = Iterables.<org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType>filter(_types, org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType.class);
    final Function1<org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType,Boolean> _function = new Function1<org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType,Boolean>() {
        public Boolean apply(final org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType e) {
          String _name = e.getName();
          String _name_1 = t.getName();
          boolean _equals = Objects.equal(_name, _name_1);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType> _filter_1 = IterableExtensions.<org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType>filter(_filter, _function);
    List<org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType> _list = IterableExtensions.<org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType>toList(_filter_1);
    org.fornax.soa.profiledsl.sOAProfileDsl.Type _findMatchingVersionedTypeFromProfile = this.findMatchingVersionedTypeFromProfile(_list, majorVersion);
    boolean _equals = Objects.equal(_findMatchingVersionedTypeFromProfile, t);
    return _equals;
  }
  
  /**
   * Checks if type declaration is the latest version matching the following constraint
   * 		- same major version
   *      - matches a given minimal lifecycle state
   */
  protected boolean _isMatchingType(final VersionedType t, final Integer majorVersion, final LifecycleState minState) {
    EObject _eContainer = t.eContainer();
    EList<Type> _types = ((SubNamespace) _eContainer).getTypes();
    Iterable<VersionedType> _filter = Iterables.<VersionedType>filter(_types, VersionedType.class);
    final Function1<VersionedType,Boolean> _function = new Function1<VersionedType,Boolean>() {
        public Boolean apply(final VersionedType e) {
          String _name = e.getName();
          String _name_1 = t.getName();
          boolean _equals = Objects.equal(_name, _name_1);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<VersionedType> _filter_1 = IterableExtensions.<VersionedType>filter(_filter, _function);
    List<VersionedType> _list = IterableExtensions.<VersionedType>toList(_filter_1);
    Type _findMatchingVersionedType = this.findMatchingVersionedType(_list, majorVersion, minState);
    boolean _equals = Objects.equal(_findMatchingVersionedType, t);
    return _equals;
  }
  
  /**
   * Type reference resolution
   * 		find the latest type declaration matching
   *  	- the version constraint defined in the reference
   */
  protected Type _findMatchingType(final EObject t) {
    return null;
  }
  
  protected Type _findMatchingType(final TypeRef t) {
    return null;
  }
  
  protected Type _findMatchingType(final VersionedTypeRef t) {
    VersionedType _type = t.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    EList<Type> _types = _findSubdomain.getTypes();
    final Function1<Type,Boolean> _function = new Function1<Type,Boolean>() {
        public Boolean apply(final Type e) {
          boolean _and = false;
          QualifiedName _fullyQualifiedName = LatestMinorVersionTypeResolver.this._iQualifiedNameProvider.getFullyQualifiedName(e);
          VersionedType _type = t.getType();
          QualifiedName _fullyQualifiedName_1 = LatestMinorVersionTypeResolver.this._iQualifiedNameProvider.getFullyQualifiedName(_type);
          boolean _equals = Objects.equal(_fullyQualifiedName, _fullyQualifiedName_1);
          if (!_equals) {
            _and = false;
          } else {
            VersionedType _type_1 = t.getType();
            Version _version = _type_1.getVersion();
            VersionRef _versionRef = t.getVersionRef();
            boolean _versionMatches = LatestMinorVersionTypeResolver.this._versionMatcher.versionMatches(_version, _versionRef);
            _and = (_equals && _versionMatches);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<Type> _filter = IterableExtensions.<Type>filter(_types, _function);
    Iterable<VersionedType> _filter_1 = Iterables.<VersionedType>filter(_filter, VersionedType.class);
    final Function1<VersionedType,String> _function_1 = new Function1<VersionedType,String>() {
        public String apply(final VersionedType e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          return _version_1;
        }
      };
    List<VersionedType> _sortBy = IterableExtensions.<VersionedType, String>sortBy(_filter_1, _function_1);
    VersionedType _last = IterableExtensions.<VersionedType>last(_sortBy);
    return _last;
  }
  
  protected Type _findMatchingType(final BusinessObjectRef t) {
    BusinessObject _type = t.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    EList<Type> _types = _findSubdomain.getTypes();
    final Function1<Type,Boolean> _function = new Function1<Type,Boolean>() {
        public Boolean apply(final Type e) {
          boolean _and = false;
          QualifiedName _fullyQualifiedName = LatestMinorVersionTypeResolver.this._iQualifiedNameProvider.getFullyQualifiedName(e);
          BusinessObject _type = t.getType();
          QualifiedName _fullyQualifiedName_1 = LatestMinorVersionTypeResolver.this._iQualifiedNameProvider.getFullyQualifiedName(_type);
          boolean _equals = Objects.equal(_fullyQualifiedName, _fullyQualifiedName_1);
          if (!_equals) {
            _and = false;
          } else {
            BusinessObject _type_1 = t.getType();
            Version _version = _type_1.getVersion();
            VersionRef _versionRef = t.getVersionRef();
            boolean _versionMatches = LatestMinorVersionTypeResolver.this._versionMatcher.versionMatches(_version, _versionRef);
            _and = (_equals && _versionMatches);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<Type> _filter = IterableExtensions.<Type>filter(_types, _function);
    Iterable<BusinessObject> _filter_1 = Iterables.<BusinessObject>filter(_filter, BusinessObject.class);
    final Function1<BusinessObject,String> _function_1 = new Function1<BusinessObject,String>() {
        public String apply(final BusinessObject e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          return _version_1;
        }
      };
    List<BusinessObject> _sortBy = IterableExtensions.<BusinessObject, String>sortBy(_filter_1, _function_1);
    BusinessObject _last = IterableExtensions.<BusinessObject>last(_sortBy);
    return _last;
  }
  
  protected Type _findMatchingType(final QueryObjectRef t) {
    QueryObject _type = t.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    EList<Type> _types = _findSubdomain.getTypes();
    final Function1<Type,Boolean> _function = new Function1<Type,Boolean>() {
        public Boolean apply(final Type e) {
          boolean _and = false;
          QualifiedName _fullyQualifiedName = LatestMinorVersionTypeResolver.this._iQualifiedNameProvider.getFullyQualifiedName(e);
          QueryObject _type = t.getType();
          QualifiedName _fullyQualifiedName_1 = LatestMinorVersionTypeResolver.this._iQualifiedNameProvider.getFullyQualifiedName(_type);
          boolean _equals = Objects.equal(_fullyQualifiedName, _fullyQualifiedName_1);
          if (!_equals) {
            _and = false;
          } else {
            QueryObject _type_1 = t.getType();
            Version _version = _type_1.getVersion();
            VersionRef _versionRef = t.getVersionRef();
            boolean _versionMatches = LatestMinorVersionTypeResolver.this._versionMatcher.versionMatches(_version, _versionRef);
            _and = (_equals && _versionMatches);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<Type> _filter = IterableExtensions.<Type>filter(_types, _function);
    Iterable<VersionedType> _filter_1 = Iterables.<VersionedType>filter(_filter, VersionedType.class);
    final Function1<VersionedType,String> _function_1 = new Function1<VersionedType,String>() {
        public String apply(final VersionedType e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          return _version_1;
        }
      };
    List<VersionedType> _sortBy = IterableExtensions.<VersionedType, String>sortBy(_filter_1, _function_1);
    VersionedType _last = IterableExtensions.<VersionedType>last(_sortBy);
    return _last;
  }
  
  protected Type _findMatchingType(final EnumTypeRef t) {
    Enumeration _type = t.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    EList<Type> _types = _findSubdomain.getTypes();
    final Function1<Type,Boolean> _function = new Function1<Type,Boolean>() {
        public Boolean apply(final Type e) {
          boolean _and = false;
          QualifiedName _fullyQualifiedName = LatestMinorVersionTypeResolver.this._iQualifiedNameProvider.getFullyQualifiedName(e);
          Enumeration _type = t.getType();
          QualifiedName _fullyQualifiedName_1 = LatestMinorVersionTypeResolver.this._iQualifiedNameProvider.getFullyQualifiedName(_type);
          boolean _equals = Objects.equal(_fullyQualifiedName, _fullyQualifiedName_1);
          if (!_equals) {
            _and = false;
          } else {
            Enumeration _type_1 = t.getType();
            Version _version = _type_1.getVersion();
            VersionRef _versionRef = t.getVersionRef();
            boolean _versionMatches = LatestMinorVersionTypeResolver.this._versionMatcher.versionMatches(_version, _versionRef);
            _and = (_equals && _versionMatches);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<Type> _filter = IterableExtensions.<Type>filter(_types, _function);
    Iterable<Enumeration> _filter_1 = Iterables.<Enumeration>filter(_filter, Enumeration.class);
    final Function1<Enumeration,String> _function_1 = new Function1<Enumeration,String>() {
        public String apply(final Enumeration e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          return _version_1;
        }
      };
    List<Enumeration> _sortBy = IterableExtensions.<Enumeration, String>sortBy(_filter_1, _function_1);
    Enumeration _last = IterableExtensions.<Enumeration>last(_sortBy);
    return _last;
  }
  
  public org.fornax.soa.profiledsl.sOAProfileDsl.Type findMatchingType(final DataTypeRef t) {
    DataType _type = t.getType();
    return _type;
  }
  
  /**
   * Reference resolution
   * 		find the lastest type declaration matching
   *  	- the version constraint defined in the reference
   * 		- the given minimal required LifecycleState
   */
  protected Type _findMatchingTypeByState(final TypeRef t, final LifecycleState minState) {
    return null;
  }
  
  protected Type _findMatchingTypeByState(final VersionedTypeRef t, final LifecycleState minState) {
    VersionedType _type = t.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    EList<Type> _types = _findSubdomain.getTypes();
    final Function1<Type,Boolean> _function = new Function1<Type,Boolean>() {
        public Boolean apply(final Type e) {
          boolean _and = false;
          boolean _and_1 = false;
          QualifiedName _fullyQualifiedName = LatestMinorVersionTypeResolver.this._iQualifiedNameProvider.getFullyQualifiedName(e);
          VersionedType _type = t.getType();
          QualifiedName _fullyQualifiedName_1 = LatestMinorVersionTypeResolver.this._iQualifiedNameProvider.getFullyQualifiedName(_type);
          boolean _equals = Objects.equal(_fullyQualifiedName, _fullyQualifiedName_1);
          if (!_equals) {
            _and_1 = false;
          } else {
            VersionedType _type_1 = t.getType();
            Version _version = _type_1.getVersion();
            VersionRef _versionRef = t.getVersionRef();
            boolean _versionMatches = LatestMinorVersionTypeResolver.this._versionMatcher.versionMatches(_version, _versionRef);
            _and_1 = (_equals && _versionMatches);
          }
          if (!_and_1) {
            _and = false;
          } else {
            VersionedType _type_2 = t.getType();
            LifecycleState _state = _type_2.getState();
            boolean _matchesMinStateLevel = LatestMinorVersionTypeResolver.this._stateMatcher.matchesMinStateLevel(_state, minState);
            _and = (_and_1 && _matchesMinStateLevel);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<Type> _filter = IterableExtensions.<Type>filter(_types, _function);
    Iterable<VersionedType> _filter_1 = Iterables.<VersionedType>filter(_filter, VersionedType.class);
    final Function1<VersionedType,String> _function_1 = new Function1<VersionedType,String>() {
        public String apply(final VersionedType e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          return _version_1;
        }
      };
    List<VersionedType> _sortBy = IterableExtensions.<VersionedType, String>sortBy(_filter_1, _function_1);
    VersionedType _last = IterableExtensions.<VersionedType>last(_sortBy);
    return _last;
  }
  
  protected Type _findMatchingTypeByState(final BusinessObjectRef t, final LifecycleState minState) {
    BusinessObject _type = t.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    EList<Type> _types = _findSubdomain.getTypes();
    final Function1<Type,Boolean> _function = new Function1<Type,Boolean>() {
        public Boolean apply(final Type e) {
          boolean _and = false;
          boolean _and_1 = false;
          QualifiedName _fullyQualifiedName = LatestMinorVersionTypeResolver.this._iQualifiedNameProvider.getFullyQualifiedName(e);
          BusinessObject _type = t.getType();
          QualifiedName _fullyQualifiedName_1 = LatestMinorVersionTypeResolver.this._iQualifiedNameProvider.getFullyQualifiedName(_type);
          boolean _equals = Objects.equal(_fullyQualifiedName, _fullyQualifiedName_1);
          if (!_equals) {
            _and_1 = false;
          } else {
            BusinessObject _type_1 = t.getType();
            Version _version = _type_1.getVersion();
            VersionRef _versionRef = t.getVersionRef();
            boolean _versionMatches = LatestMinorVersionTypeResolver.this._versionMatcher.versionMatches(_version, _versionRef);
            _and_1 = (_equals && _versionMatches);
          }
          if (!_and_1) {
            _and = false;
          } else {
            BusinessObject _type_2 = t.getType();
            LifecycleState _state = _type_2.getState();
            boolean _matchesMinStateLevel = LatestMinorVersionTypeResolver.this._stateMatcher.matchesMinStateLevel(_state, minState);
            _and = (_and_1 && _matchesMinStateLevel);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<Type> _filter = IterableExtensions.<Type>filter(_types, _function);
    Iterable<BusinessObject> _filter_1 = Iterables.<BusinessObject>filter(_filter, BusinessObject.class);
    final Function1<BusinessObject,String> _function_1 = new Function1<BusinessObject,String>() {
        public String apply(final BusinessObject e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          return _version_1;
        }
      };
    List<BusinessObject> _sortBy = IterableExtensions.<BusinessObject, String>sortBy(_filter_1, _function_1);
    BusinessObject _last = IterableExtensions.<BusinessObject>last(_sortBy);
    return _last;
  }
  
  protected Type _findMatchingTypeByState(final QueryObjectRef t, final LifecycleState minState) {
    QueryObject _type = t.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    EList<Type> _types = _findSubdomain.getTypes();
    final Function1<Type,Boolean> _function = new Function1<Type,Boolean>() {
        public Boolean apply(final Type e) {
          boolean _and = false;
          boolean _and_1 = false;
          QualifiedName _fullyQualifiedName = LatestMinorVersionTypeResolver.this._iQualifiedNameProvider.getFullyQualifiedName(e);
          QueryObject _type = t.getType();
          QualifiedName _fullyQualifiedName_1 = LatestMinorVersionTypeResolver.this._iQualifiedNameProvider.getFullyQualifiedName(_type);
          boolean _equals = Objects.equal(_fullyQualifiedName, _fullyQualifiedName_1);
          if (!_equals) {
            _and_1 = false;
          } else {
            QueryObject _type_1 = t.getType();
            Version _version = _type_1.getVersion();
            VersionRef _versionRef = t.getVersionRef();
            boolean _versionMatches = LatestMinorVersionTypeResolver.this._versionMatcher.versionMatches(_version, _versionRef);
            _and_1 = (_equals && _versionMatches);
          }
          if (!_and_1) {
            _and = false;
          } else {
            QueryObject _type_2 = t.getType();
            LifecycleState _state = _type_2.getState();
            boolean _matchesMinStateLevel = LatestMinorVersionTypeResolver.this._stateMatcher.matchesMinStateLevel(_state, minState);
            _and = (_and_1 && _matchesMinStateLevel);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<Type> _filter = IterableExtensions.<Type>filter(_types, _function);
    Iterable<BusinessObject> _filter_1 = Iterables.<BusinessObject>filter(_filter, BusinessObject.class);
    final Function1<BusinessObject,String> _function_1 = new Function1<BusinessObject,String>() {
        public String apply(final BusinessObject e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          return _version_1;
        }
      };
    List<BusinessObject> _sortBy = IterableExtensions.<BusinessObject, String>sortBy(_filter_1, _function_1);
    BusinessObject _last = IterableExtensions.<BusinessObject>last(_sortBy);
    return _last;
  }
  
  protected Type _findMatchingTypeByState(final EnumTypeRef t, final LifecycleState minState) {
    Enumeration _type = t.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    EList<Type> _types = _findSubdomain.getTypes();
    final Function1<Type,Boolean> _function = new Function1<Type,Boolean>() {
        public Boolean apply(final Type e) {
          boolean _and = false;
          boolean _and_1 = false;
          QualifiedName _fullyQualifiedName = LatestMinorVersionTypeResolver.this._iQualifiedNameProvider.getFullyQualifiedName(e);
          Enumeration _type = t.getType();
          QualifiedName _fullyQualifiedName_1 = LatestMinorVersionTypeResolver.this._iQualifiedNameProvider.getFullyQualifiedName(_type);
          boolean _equals = Objects.equal(_fullyQualifiedName, _fullyQualifiedName_1);
          if (!_equals) {
            _and_1 = false;
          } else {
            Enumeration _type_1 = t.getType();
            Version _version = _type_1.getVersion();
            VersionRef _versionRef = t.getVersionRef();
            boolean _versionMatches = LatestMinorVersionTypeResolver.this._versionMatcher.versionMatches(_version, _versionRef);
            _and_1 = (_equals && _versionMatches);
          }
          if (!_and_1) {
            _and = false;
          } else {
            Enumeration _type_2 = t.getType();
            LifecycleState _state = _type_2.getState();
            boolean _matchesMinStateLevel = LatestMinorVersionTypeResolver.this._stateMatcher.matchesMinStateLevel(_state, minState);
            _and = (_and_1 && _matchesMinStateLevel);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<Type> _filter = IterableExtensions.<Type>filter(_types, _function);
    Iterable<Enumeration> _filter_1 = Iterables.<Enumeration>filter(_filter, Enumeration.class);
    final Function1<Enumeration,String> _function_1 = new Function1<Enumeration,String>() {
        public String apply(final Enumeration e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          return _version_1;
        }
      };
    List<Enumeration> _sortBy = IterableExtensions.<Enumeration, String>sortBy(_filter_1, _function_1);
    Enumeration _last = IterableExtensions.<Enumeration>last(_sortBy);
    return _last;
  }
  
  private Type _findMatchingVersionedType(final List<VersionedType> types, final Integer majorVersion) {
    final Function1<VersionedType,Boolean> _function = new Function1<VersionedType,Boolean>() {
        public Boolean apply(final VersionedType e) {
          Version _version = e.getVersion();
          boolean _versionMatches = LatestMinorVersionTypeResolver.this._versionMatcher.versionMatches(_version, majorVersion);
          return Boolean.valueOf(_versionMatches);
        }
      };
    Iterable<VersionedType> _filter = IterableExtensions.<VersionedType>filter(types, _function);
    final Function1<VersionedType,String> _function_1 = new Function1<VersionedType,String>() {
        public String apply(final VersionedType e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          return _version_1;
        }
      };
    List<VersionedType> _sortBy = IterableExtensions.<VersionedType, String>sortBy(_filter, _function_1);
    VersionedType _last = IterableExtensions.<VersionedType>last(_sortBy);
    return _last;
  }
  
  private org.fornax.soa.profiledsl.sOAProfileDsl.Type _findMatchingVersionedTypeFromProfile(final List<org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType> types, final Integer majorVersion) {
    final Function1<org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType,Boolean> _function = new Function1<org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType,Boolean>() {
        public Boolean apply(final org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType e) {
          Version _version = e.getVersion();
          boolean _versionMatches = LatestMinorVersionTypeResolver.this._versionMatcher.versionMatches(_version, majorVersion);
          return Boolean.valueOf(_versionMatches);
        }
      };
    Iterable<org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType> _filter = IterableExtensions.<org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType>filter(types, _function);
    final Function1<org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType,String> _function_1 = new Function1<org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType,String>() {
        public String apply(final org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          return _version_1;
        }
      };
    List<org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType> _sortBy = IterableExtensions.<org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType, String>sortBy(_filter, _function_1);
    org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType _last = IterableExtensions.<org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType>last(_sortBy);
    return _last;
  }
  
  private Type findMatchingVersionedType(final List<VersionedType> types, final Integer majorVersion, final LifecycleState minState) {
    final Function1<VersionedType,Boolean> _function = new Function1<VersionedType,Boolean>() {
        public Boolean apply(final VersionedType e) {
          boolean _and = false;
          Version _version = e.getVersion();
          boolean _versionMatches = LatestMinorVersionTypeResolver.this._versionMatcher.versionMatches(_version, majorVersion);
          if (!_versionMatches) {
            _and = false;
          } else {
            LifecycleState _state = e.getState();
            boolean _matchesMinStateLevel = LatestMinorVersionTypeResolver.this._stateMatcher.matchesMinStateLevel(_state, minState);
            _and = (_versionMatches && _matchesMinStateLevel);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<VersionedType> _filter = IterableExtensions.<VersionedType>filter(types, _function);
    final Function1<VersionedType,String> _function_1 = new Function1<VersionedType,String>() {
        public String apply(final VersionedType e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          return _version_1;
        }
      };
    List<VersionedType> _sortBy = IterableExtensions.<VersionedType, String>sortBy(_filter, _function_1);
    VersionedType _last = IterableExtensions.<VersionedType>last(_sortBy);
    return _last;
  }
  
  public VersionedType selectMatchingType(final AbstractVersionedTypeRef ref) {
    if (ref instanceof BusinessObjectRef) {
      return _selectMatchingType((BusinessObjectRef)ref);
    } else if (ref instanceof EnumTypeRef) {
      return _selectMatchingType((EnumTypeRef)ref);
    } else if (ref instanceof QueryObjectRef) {
      return _selectMatchingType((QueryObjectRef)ref);
    } else if (ref instanceof VersionedTypeRef) {
      return _selectMatchingType((VersionedTypeRef)ref);
    } else if (ref != null) {
      return _selectMatchingType(ref);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ref).toString());
    }
  }
  
  public VersionedType selectMatchingTypeByState(final AbstractVersionedTypeRef ref, final LifecycleState minState) {
    if (ref instanceof BusinessObjectRef) {
      return _selectMatchingTypeByState((BusinessObjectRef)ref, minState);
    } else if (ref instanceof EnumTypeRef) {
      return _selectMatchingTypeByState((EnumTypeRef)ref, minState);
    } else if (ref instanceof QueryObjectRef) {
      return _selectMatchingTypeByState((QueryObjectRef)ref, minState);
    } else if (ref instanceof VersionedTypeRef) {
      return _selectMatchingTypeByState((VersionedTypeRef)ref, minState);
    } else if (ref != null) {
      return _selectMatchingTypeByState(ref, minState);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ref, minState).toString());
    }
  }
  
  public boolean isMatchingType(final Type t, final Integer majorVersion, final LifecycleState minState) {
    if (t instanceof VersionedType) {
      return _isMatchingType((VersionedType)t, majorVersion, minState);
    } else if (t != null) {
      return _isMatchingType(t, majorVersion, minState);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t, majorVersion, minState).toString());
    }
  }
  
  public Type findMatchingType(final EObject t) {
    if (t instanceof BusinessObjectRef) {
      return _findMatchingType((BusinessObjectRef)t);
    } else if (t instanceof EnumTypeRef) {
      return _findMatchingType((EnumTypeRef)t);
    } else if (t instanceof QueryObjectRef) {
      return _findMatchingType((QueryObjectRef)t);
    } else if (t instanceof VersionedTypeRef) {
      return _findMatchingType((VersionedTypeRef)t);
    } else if (t instanceof TypeRef) {
      return _findMatchingType((TypeRef)t);
    } else if (t != null) {
      return _findMatchingType(t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t).toString());
    }
  }
  
  public Type findMatchingTypeByState(final TypeRef t, final LifecycleState minState) {
    if (t instanceof BusinessObjectRef) {
      return _findMatchingTypeByState((BusinessObjectRef)t, minState);
    } else if (t instanceof EnumTypeRef) {
      return _findMatchingTypeByState((EnumTypeRef)t, minState);
    } else if (t instanceof QueryObjectRef) {
      return _findMatchingTypeByState((QueryObjectRef)t, minState);
    } else if (t instanceof VersionedTypeRef) {
      return _findMatchingTypeByState((VersionedTypeRef)t, minState);
    } else if (t != null) {
      return _findMatchingTypeByState(t, minState);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t, minState).toString());
    }
  }
  
  private Type findMatchingVersionedType(final List<VersionedType> types, final Integer majorVersion) {
    {
      return _findMatchingVersionedType(types, majorVersion);
    }
  }
  
  private org.fornax.soa.profiledsl.sOAProfileDsl.Type findMatchingVersionedTypeFromProfile(final List<org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType> types, final Integer majorVersion) {
    {
      return _findMatchingVersionedTypeFromProfile(types, majorVersion);
    }
  }
}
