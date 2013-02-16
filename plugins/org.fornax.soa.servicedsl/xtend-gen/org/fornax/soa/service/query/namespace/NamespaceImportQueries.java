package org.fornax.soa.service.query.namespace;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.service.VersionedDomainNamespace;
import org.fornax.soa.service.namespace.NamespaceSplitter;
import org.fornax.soa.service.query.ExceptionFinder;
import org.fornax.soa.service.query.ServiceQueries;
import org.fornax.soa.service.query.namespace.NamespaceQuery;
import org.fornax.soa.service.query.type.ReferencedTypesFinder;
import org.fornax.soa.service.query.type.VersionedTypeFilter;
import org.fornax.soa.service.versioning.IExceptionResolver;
import org.fornax.soa.service.versioning.ITypeResolver;
import org.fornax.soa.serviceDsl.AbstractVersionedTypeRef;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.ExceptionRef;
import org.fornax.soa.serviceDsl.Operation;
import org.fornax.soa.serviceDsl.Parameter;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.Type;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.serviceDsl.VersionedType;

/**
 * Calculation of all VersionedDomainNamespaces imported by a given or derived
 * 	VersionedDomainNamespace. Transitive dependencies are not yet calculated
 */
@SuppressWarnings("all")
public class NamespaceImportQueries {
  @Inject
  private NamespaceQuery _namespaceQuery;
  
  @Inject
  private ITypeResolver _iTypeResolver;
  
  @Inject
  private VersionedTypeFilter _versionedTypeFilter;
  
  @Inject
  private ReferencedTypesFinder _referencedTypesFinder;
  
  @Inject
  private ExceptionFinder excFinder;
  
  @Inject
  private IExceptionResolver excResolver;
  
  @Inject
  private ServiceQueries serviceFinder;
  
  @Inject
  private NamespaceSplitter namespaceSplitter;
  
  /**
   * Calculate all dependencies of the given Service version
   * 	@deprecated ?
   * 
   * 	@param svc	The Service with it's version to calculate the imports for
   */
  public Set<VersionedDomainNamespace> findImportedSubdomains(final Service svc) {
    EList<Operation> _operations = svc.getOperations();
    final Function1<Operation,EList<Parameter>> _function = new Function1<Operation,EList<Parameter>>() {
        public EList<Parameter> apply(final Operation o) {
          EList<Parameter> _parameters = o.getParameters();
          return _parameters;
        }
      };
    List<EList<Parameter>> _map = ListExtensions.<Operation, EList<Parameter>>map(_operations, _function);
    Iterable<Parameter> _flatten = Iterables.<Parameter>concat(_map);
    final Function1<Parameter,TypeRef> _function_1 = new Function1<Parameter,TypeRef>() {
        public TypeRef apply(final Parameter p) {
          TypeRef _type = p.getType();
          return _type;
        }
      };
    Iterable<TypeRef> _map_1 = IterableExtensions.<Parameter, TypeRef>map(_flatten, _function_1);
    Iterable<AbstractVersionedTypeRef> _filter = Iterables.<AbstractVersionedTypeRef>filter(_map_1, AbstractVersionedTypeRef.class);
    final Function1<AbstractVersionedTypeRef,Type> _function_2 = new Function1<AbstractVersionedTypeRef,Type>() {
        public Type apply(final AbstractVersionedTypeRef r) {
          Type _findMatchingType = NamespaceImportQueries.this._iTypeResolver.findMatchingType(r);
          return _findMatchingType;
        }
      };
    Iterable<Type> _map_2 = IterableExtensions.<AbstractVersionedTypeRef, Type>map(_filter, _function_2);
    Iterable<Type> _filterNull = IterableExtensions.<Type>filterNull(_map_2);
    final Function1<Type,VersionedDomainNamespace> _function_3 = new Function1<Type,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final Type e) {
          VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceImportQueries.this.namespaceSplitter.createVersionedDomainNamespace(e);
          return _createVersionedDomainNamespace;
        }
      };
    Iterable<VersionedDomainNamespace> _map_3 = IterableExtensions.<Type, VersionedDomainNamespace>map(_filterNull, _function_3);
    Set<VersionedDomainNamespace> imports = IterableExtensions.<VersionedDomainNamespace>toSet(_map_3);
    EList<Operation> _operations_1 = svc.getOperations();
    final Function1<Operation,EList<Parameter>> _function_4 = new Function1<Operation,EList<Parameter>>() {
        public EList<Parameter> apply(final Operation o) {
          EList<Parameter> _return = o.getReturn();
          return _return;
        }
      };
    List<EList<Parameter>> _map_4 = ListExtensions.<Operation, EList<Parameter>>map(_operations_1, _function_4);
    Iterable<Parameter> _flatten_1 = Iterables.<Parameter>concat(_map_4);
    final Function1<Parameter,TypeRef> _function_5 = new Function1<Parameter,TypeRef>() {
        public TypeRef apply(final Parameter r) {
          TypeRef _type = r.getType();
          return _type;
        }
      };
    Iterable<TypeRef> _map_5 = IterableExtensions.<Parameter, TypeRef>map(_flatten_1, _function_5);
    Iterable<AbstractVersionedTypeRef> _filter_1 = Iterables.<AbstractVersionedTypeRef>filter(_map_5, AbstractVersionedTypeRef.class);
    final Function1<AbstractVersionedTypeRef,Type> _function_6 = new Function1<AbstractVersionedTypeRef,Type>() {
        public Type apply(final AbstractVersionedTypeRef v) {
          Type _findMatchingType = NamespaceImportQueries.this._iTypeResolver.findMatchingType(v);
          return _findMatchingType;
        }
      };
    Iterable<Type> _map_6 = IterableExtensions.<AbstractVersionedTypeRef, Type>map(_filter_1, _function_6);
    Iterable<Type> _filterNull_1 = IterableExtensions.<Type>filterNull(_map_6);
    final Function1<Type,VersionedDomainNamespace> _function_7 = new Function1<Type,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final Type e) {
          VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceImportQueries.this.namespaceSplitter.createVersionedDomainNamespace(e);
          return _createVersionedDomainNamespace;
        }
      };
    Iterable<VersionedDomainNamespace> _map_7 = IterableExtensions.<Type, VersionedDomainNamespace>map(_filterNull_1, _function_7);
    Iterables.<VersionedDomainNamespace>addAll(imports, _map_7);
    EList<Operation> _operations_2 = svc.getOperations();
    final Function1<Operation,EList<ExceptionRef>> _function_8 = new Function1<Operation,EList<ExceptionRef>>() {
        public EList<ExceptionRef> apply(final Operation o) {
          EList<ExceptionRef> _throws = o.getThrows();
          return _throws;
        }
      };
    List<EList<ExceptionRef>> _map_8 = ListExtensions.<Operation, EList<ExceptionRef>>map(_operations_2, _function_8);
    Iterable<ExceptionRef> _flatten_2 = Iterables.<ExceptionRef>concat(_map_8);
    final Function1<ExceptionRef,org.fornax.soa.serviceDsl.Exception> _function_9 = new Function1<ExceptionRef,org.fornax.soa.serviceDsl.Exception>() {
        public org.fornax.soa.serviceDsl.Exception apply(final ExceptionRef t) {
          org.fornax.soa.serviceDsl.Exception _findMatchingException = NamespaceImportQueries.this.excResolver.findMatchingException(t);
          return _findMatchingException;
        }
      };
    Iterable<org.fornax.soa.serviceDsl.Exception> _map_9 = IterableExtensions.<ExceptionRef, org.fornax.soa.serviceDsl.Exception>map(_flatten_2, _function_9);
    Iterable<org.fornax.soa.serviceDsl.Exception> _filterNull_2 = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>filterNull(_map_9);
    final Function1<org.fornax.soa.serviceDsl.Exception,VersionedDomainNamespace> _function_10 = new Function1<org.fornax.soa.serviceDsl.Exception,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final org.fornax.soa.serviceDsl.Exception e) {
          VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceImportQueries.this.namespaceSplitter.createVersionedDomainNamespace(e);
          return _createVersionedDomainNamespace;
        }
      };
    Iterable<VersionedDomainNamespace> _map_10 = IterableExtensions.<org.fornax.soa.serviceDsl.Exception, VersionedDomainNamespace>map(_filterNull_2, _function_10);
    Iterables.<VersionedDomainNamespace>addAll(imports, _map_10);
    return imports;
  }
  
  /**
   * Calculate all dependencies of the given Service version and LifecycleState. Dependencies must match
   * 	the given minimal LifecycleState
   * 	@deprecated ?
   * 
   * 	@param svc	The Service with it's version to calculate the imports for
   */
  public Set<SubNamespace> allImportedSubNamespaces(final Type t, final LifecycleState minState) {
    List<VersionedType> _allReferencedVersionedTypes = this._referencedTypesFinder.allReferencedVersionedTypes(t, minState);
    final Function1<VersionedType,SubNamespace> _function = new Function1<VersionedType,SubNamespace>() {
        public SubNamespace apply(final VersionedType e) {
          SubNamespace _findSubdomain = NamespaceImportQueries.this._namespaceQuery.findSubdomain(e);
          return _findSubdomain;
        }
      };
    List<SubNamespace> _map = ListExtensions.<VersionedType, SubNamespace>map(_allReferencedVersionedTypes, _function);
    Set<SubNamespace> _set = IterableExtensions.<SubNamespace>toSet(_map);
    return _set;
  }
  
  /**
   * Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
   * 	are derived from the versioned dependencies of the given Type considering the minimal LifecycleState required by the
   * 	given Type. The owning VersiondDomainNamespace of the found dependencies are returned.
   */
  protected Set<VersionedDomainNamespace> _allImportedVersionedNS(final Type t, final LifecycleState minState) {
    List<VersionedType> _allReferencedVersionedTypes = this._referencedTypesFinder.allReferencedVersionedTypes(t, minState);
    final Function1<VersionedType,VersionedDomainNamespace> _function = new Function1<VersionedType,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final VersionedType e) {
          VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceImportQueries.this.namespaceSplitter.createVersionedDomainNamespace(e);
          return _createVersionedDomainNamespace;
        }
      };
    List<VersionedDomainNamespace> _map = ListExtensions.<VersionedType, VersionedDomainNamespace>map(_allReferencedVersionedTypes, _function);
    Set<VersionedDomainNamespace> _set = IterableExtensions.<VersionedDomainNamespace>toSet(_map);
    return _set;
  }
  
  /**
   * Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
   * 	are derived from the versioned dependencies of the given Type considering the minimal LifecycleState required by the
   * 	given Type. The owning VersiondDomainNamespace of the found dependencies are returned.
   */
  protected Set<VersionedDomainNamespace> _allImportedVersionedNS(final VersionedDomainNamespace s, final LifecycleState minState) {
    HashSet<VersionedDomainNamespace> _hashSet = new HashSet<VersionedDomainNamespace>();
    Set<VersionedDomainNamespace> _allImportedVersionedNS = this.allImportedVersionedNS(s, minState, _hashSet);
    Set<VersionedDomainNamespace> _set = IterableExtensions.<VersionedDomainNamespace>toSet(_allImportedVersionedNS);
    return _set;
  }
  
  protected Set<VersionedDomainNamespace> _allImportedVersionedNS(final VersionedDomainNamespace s, final LifecycleState minState, final Set<VersionedDomainNamespace> visited) {
    Set<VersionedDomainNamespace> _xifexpression = null;
    boolean _contains = visited.contains(s);
    boolean _not = (!_contains);
    if (_not) {
      Set<VersionedDomainNamespace> _xblockexpression = null;
      {
        visited.add(s);
        EObject _subdomain = s.getSubdomain();
        String _version = s.getVersion();
        Set<VersionedDomainNamespace> _allImportedVersionedNS = this.allImportedVersionedNS(_subdomain, _version, minState);
        final Function1<VersionedDomainNamespace,Set<VersionedDomainNamespace>> _function = new Function1<VersionedDomainNamespace,Set<VersionedDomainNamespace>>() {
            public Set<VersionedDomainNamespace> apply(final VersionedDomainNamespace vns) {
              Set<VersionedDomainNamespace> _allImportedVersionedNS = NamespaceImportQueries.this.allImportedVersionedNS(vns, minState, visited);
              return _allImportedVersionedNS;
            }
          };
        Iterable<Set<VersionedDomainNamespace>> _map = IterableExtensions.<VersionedDomainNamespace, Set<VersionedDomainNamespace>>map(_allImportedVersionedNS, _function);
        Iterable<VersionedDomainNamespace> _flatten = Iterables.<VersionedDomainNamespace>concat(_map);
        Set<VersionedDomainNamespace> _set = IterableExtensions.<VersionedDomainNamespace>toSet(_flatten);
        _xblockexpression = (_set);
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = visited;
    }
    return _xifexpression;
  }
  
  /**
   * Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
   * 	are derived from the versioned dependencies of all owned VersiondTypes, Exceptions and Service in the given
   * 	VersionedDomainNamespace. The owning VersiondDomainNamespace of the found dependencies are returned.
   */
  public Set<VersionedDomainNamespace> allImportedVersionedNS(final VersionedDomainNamespace s) {
    HashSet<VersionedDomainNamespace> _hashSet = new HashSet<VersionedDomainNamespace>();
    Set<VersionedDomainNamespace> _allImportedVersionedNS = this.allImportedVersionedNS(s, _hashSet);
    Iterable<VersionedDomainNamespace> _filter = Iterables.<VersionedDomainNamespace>filter(_allImportedVersionedNS, VersionedDomainNamespace.class);
    Set<VersionedDomainNamespace> _set = IterableExtensions.<VersionedDomainNamespace>toSet(_filter);
    return _set;
  }
  
  protected Set<VersionedDomainNamespace> _allImportedVersionedNS(final VersionedDomainNamespace s, final Set<VersionedDomainNamespace> visited) {
    Set<VersionedDomainNamespace> _xifexpression = null;
    boolean _contains = visited.contains(s);
    boolean _not = (!_contains);
    if (_not) {
      Set<VersionedDomainNamespace> _xblockexpression = null;
      {
        visited.add(s);
        EObject _subdomain = s.getSubdomain();
        String _version = s.getVersion();
        Set<VersionedDomainNamespace> _allImportedVersionedNS = this.allImportedVersionedNS(_subdomain, _version);
        Set<VersionedDomainNamespace> _allImportedVersionedNS_1 = this.allImportedVersionedNS(_allImportedVersionedNS, visited);
        Iterable<VersionedDomainNamespace> _filter = Iterables.<VersionedDomainNamespace>filter(_allImportedVersionedNS_1, VersionedDomainNamespace.class);
        Set<VersionedDomainNamespace> _set = IterableExtensions.<VersionedDomainNamespace>toSet(_filter);
        _xblockexpression = (_set);
      }
      _xifexpression = _xblockexpression;
    } else {
      Iterable<VersionedDomainNamespace> _filter = Iterables.<VersionedDomainNamespace>filter(visited, VersionedDomainNamespace.class);
      Set<VersionedDomainNamespace> _set = IterableExtensions.<VersionedDomainNamespace>toSet(_filter);
      _xifexpression = _set;
    }
    return _xifexpression;
  }
  
  protected Set<VersionedDomainNamespace> _allImportedVersionedNS(final Object s, final String nameSpaceMajorVersion, final LifecycleState minState) {
    return null;
  }
  
  protected Set<VersionedDomainNamespace> _allImportedVersionedNS(final Object s, final String nameSpaceMajorVersion) {
    return null;
  }
  
  /**
   * Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
   * 	are derived from the versioned dependencies of all owned VersiondTypes, Exceptions and Service in the given
   * 	SubNamespace matching the given major version. The owning VersiondDomainNamespace of the found dependencies are returned.
   */
  protected Set<VersionedDomainNamespace> _allImportedVersionedNS(final SubNamespace s, final String nameSpaceMajorVersion, final LifecycleState minState) {
    List<VersionedType> _allTypesByMajorVersion = this._versionedTypeFilter.allTypesByMajorVersion(s, nameSpaceMajorVersion);
    Iterable<BusinessObject> _filter = Iterables.<BusinessObject>filter(_allTypesByMajorVersion, BusinessObject.class);
    final Function1<BusinessObject,List<VersionedType>> _function = new Function1<BusinessObject,List<VersionedType>>() {
        public List<VersionedType> apply(final BusinessObject b) {
          List<VersionedType> _allReferencedVersionedTypes = NamespaceImportQueries.this._referencedTypesFinder.allReferencedVersionedTypes(b, minState);
          return _allReferencedVersionedTypes;
        }
      };
    Iterable<List<VersionedType>> _map = IterableExtensions.<BusinessObject, List<VersionedType>>map(_filter, _function);
    Iterable<VersionedType> _flatten = Iterables.<VersionedType>concat(_map);
    final Function1<VersionedType,VersionedDomainNamespace> _function_1 = new Function1<VersionedType,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final VersionedType r) {
          VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceImportQueries.this.namespaceSplitter.createVersionedDomainNamespace(r);
          return _createVersionedDomainNamespace;
        }
      };
    Iterable<VersionedDomainNamespace> _map_1 = IterableExtensions.<VersionedType, VersionedDomainNamespace>map(_flatten, _function_1);
    Set<VersionedDomainNamespace> imports = IterableExtensions.<VersionedDomainNamespace>toSet(_map_1);
    final List<org.fornax.soa.serviceDsl.Exception> exByMajor = this.serviceFinder.allExceptionsByMajorVersion(s, nameSpaceMajorVersion);
    final Function1<org.fornax.soa.serviceDsl.Exception,List<VersionedType>> _function_2 = new Function1<org.fornax.soa.serviceDsl.Exception,List<VersionedType>>() {
        public List<VersionedType> apply(final org.fornax.soa.serviceDsl.Exception e) {
          List<VersionedType> _allReferencedVersionedTypes = NamespaceImportQueries.this._referencedTypesFinder.allReferencedVersionedTypes(e, minState);
          return _allReferencedVersionedTypes;
        }
      };
    List<List<VersionedType>> _map_2 = ListExtensions.<org.fornax.soa.serviceDsl.Exception, List<VersionedType>>map(exByMajor, _function_2);
    Iterable<VersionedType> _flatten_1 = Iterables.<VersionedType>concat(_map_2);
    final Function1<VersionedType,VersionedDomainNamespace> _function_3 = new Function1<VersionedType,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final VersionedType e) {
          VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceImportQueries.this.namespaceSplitter.createVersionedDomainNamespace(e);
          return _createVersionedDomainNamespace;
        }
      };
    Iterable<VersionedDomainNamespace> _map_3 = IterableExtensions.<VersionedType, VersionedDomainNamespace>map(_flatten_1, _function_3);
    Iterables.<VersionedDomainNamespace>addAll(imports, _map_3);
    final Function1<org.fornax.soa.serviceDsl.Exception,ExceptionRef> _function_4 = new Function1<org.fornax.soa.serviceDsl.Exception,ExceptionRef>() {
        public ExceptionRef apply(final org.fornax.soa.serviceDsl.Exception ex) {
          ExceptionRef _superException = ex.getSuperException();
          return _superException;
        }
      };
    List<ExceptionRef> _map_4 = ListExtensions.<org.fornax.soa.serviceDsl.Exception, ExceptionRef>map(exByMajor, _function_4);
    Iterable<ExceptionRef> _filterNull = IterableExtensions.<ExceptionRef>filterNull(_map_4);
    final Function1<ExceptionRef,VersionedDomainNamespace> _function_5 = new Function1<ExceptionRef,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final ExceptionRef e) {
          org.fornax.soa.serviceDsl.Exception _findMatchingException = NamespaceImportQueries.this.excResolver.findMatchingException(e);
          VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceImportQueries.this.namespaceSplitter.createVersionedDomainNamespace(_findMatchingException);
          return _createVersionedDomainNamespace;
        }
      };
    Iterable<VersionedDomainNamespace> _map_5 = IterableExtensions.<ExceptionRef, VersionedDomainNamespace>map(_filterNull, _function_5);
    Iterables.<VersionedDomainNamespace>addAll(imports, _map_5);
    return imports;
  }
  
  /**
   * Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
   * 	are derived from the versioned dependencies of the given Service (versioned). The owning
   * 	VersiondDomainNamespace of the found dependencies are returned.
   */
  protected Set<VersionedDomainNamespace> _allImportedVersionedNS(final Service s, final String nameSpaceMajorVersion, final LifecycleState minState) {
    List<VersionedType> _allTypesByMajorVersion = this._versionedTypeFilter.allTypesByMajorVersion(s, nameSpaceMajorVersion);
    Iterable<BusinessObject> _filter = Iterables.<BusinessObject>filter(_allTypesByMajorVersion, BusinessObject.class);
    final Function1<BusinessObject,List<VersionedType>> _function = new Function1<BusinessObject,List<VersionedType>>() {
        public List<VersionedType> apply(final BusinessObject b) {
          List<VersionedType> _allReferencedVersionedTypes = NamespaceImportQueries.this._referencedTypesFinder.allReferencedVersionedTypes(b, minState);
          return _allReferencedVersionedTypes;
        }
      };
    Iterable<List<VersionedType>> _map = IterableExtensions.<BusinessObject, List<VersionedType>>map(_filter, _function);
    Iterable<VersionedType> _flatten = Iterables.<VersionedType>concat(_map);
    final Function1<VersionedType,VersionedDomainNamespace> _function_1 = new Function1<VersionedType,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final VersionedType r) {
          VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceImportQueries.this.namespaceSplitter.createVersionedDomainNamespace(r);
          return _createVersionedDomainNamespace;
        }
      };
    Iterable<VersionedDomainNamespace> _map_1 = IterableExtensions.<VersionedType, VersionedDomainNamespace>map(_flatten, _function_1);
    Set<VersionedDomainNamespace> imports = IterableExtensions.<VersionedDomainNamespace>toSet(_map_1);
    List<VersionedType> _allReferencedVersionedTypes = this._referencedTypesFinder.allReferencedVersionedTypes(s, minState);
    final Function1<VersionedType,VersionedDomainNamespace> _function_2 = new Function1<VersionedType,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final VersionedType e) {
          VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceImportQueries.this.namespaceSplitter.createVersionedDomainNamespace(e);
          return _createVersionedDomainNamespace;
        }
      };
    List<VersionedDomainNamespace> _map_2 = ListExtensions.<VersionedType, VersionedDomainNamespace>map(_allReferencedVersionedTypes, _function_2);
    Iterables.<VersionedDomainNamespace>addAll(imports, _map_2);
    List<org.fornax.soa.serviceDsl.Exception> _allReferencedExceptions = this.serviceFinder.allReferencedExceptions(s);
    final Function1<org.fornax.soa.serviceDsl.Exception,VersionedDomainNamespace> _function_3 = new Function1<org.fornax.soa.serviceDsl.Exception,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final org.fornax.soa.serviceDsl.Exception e) {
          VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceImportQueries.this.namespaceSplitter.createVersionedDomainNamespace(e);
          return _createVersionedDomainNamespace;
        }
      };
    List<VersionedDomainNamespace> _map_3 = ListExtensions.<org.fornax.soa.serviceDsl.Exception, VersionedDomainNamespace>map(_allReferencedExceptions, _function_3);
    Iterables.<VersionedDomainNamespace>addAll(imports, _map_3);
    final List<org.fornax.soa.serviceDsl.Exception> exByMajor = this.serviceFinder.allExceptionsByMajorVersion(s, nameSpaceMajorVersion);
    final Function1<org.fornax.soa.serviceDsl.Exception,List<VersionedType>> _function_4 = new Function1<org.fornax.soa.serviceDsl.Exception,List<VersionedType>>() {
        public List<VersionedType> apply(final org.fornax.soa.serviceDsl.Exception e) {
          List<VersionedType> _allReferencedVersionedTypes = NamespaceImportQueries.this._referencedTypesFinder.allReferencedVersionedTypes(e, minState);
          return _allReferencedVersionedTypes;
        }
      };
    List<List<VersionedType>> _map_4 = ListExtensions.<org.fornax.soa.serviceDsl.Exception, List<VersionedType>>map(exByMajor, _function_4);
    Iterable<VersionedType> _flatten_1 = Iterables.<VersionedType>concat(_map_4);
    final Function1<VersionedType,VersionedDomainNamespace> _function_5 = new Function1<VersionedType,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final VersionedType e) {
          VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceImportQueries.this.namespaceSplitter.createVersionedDomainNamespace(e);
          return _createVersionedDomainNamespace;
        }
      };
    Iterable<VersionedDomainNamespace> _map_5 = IterableExtensions.<VersionedType, VersionedDomainNamespace>map(_flatten_1, _function_5);
    Iterables.<VersionedDomainNamespace>addAll(imports, _map_5);
    final Function1<org.fornax.soa.serviceDsl.Exception,ExceptionRef> _function_6 = new Function1<org.fornax.soa.serviceDsl.Exception,ExceptionRef>() {
        public ExceptionRef apply(final org.fornax.soa.serviceDsl.Exception ex) {
          ExceptionRef _superException = ex.getSuperException();
          return _superException;
        }
      };
    List<ExceptionRef> _map_6 = ListExtensions.<org.fornax.soa.serviceDsl.Exception, ExceptionRef>map(exByMajor, _function_6);
    Iterable<ExceptionRef> _filterNull = IterableExtensions.<ExceptionRef>filterNull(_map_6);
    final Function1<ExceptionRef,VersionedDomainNamespace> _function_7 = new Function1<ExceptionRef,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final ExceptionRef e) {
          org.fornax.soa.serviceDsl.Exception _findMatchingException = NamespaceImportQueries.this.excResolver.findMatchingException(e);
          VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceImportQueries.this.namespaceSplitter.createVersionedDomainNamespace(_findMatchingException);
          return _createVersionedDomainNamespace;
        }
      };
    Iterable<VersionedDomainNamespace> _map_7 = IterableExtensions.<ExceptionRef, VersionedDomainNamespace>map(_filterNull, _function_7);
    Iterables.<VersionedDomainNamespace>addAll(imports, _map_7);
    VersionedDomainNamespace _createVersionedDomainNamespace = this.namespaceSplitter.createVersionedDomainNamespace(s);
    imports.add(_createVersionedDomainNamespace);
    return imports;
  }
  
  /**
   * Calculate all dependencies of the given Service version and LifecycleState. Dependencies must match
   * 	the given minimal LifecycleState
   * 	@deprecated ?
   * 
   * 	@param svc	The Service with it's version to calculate the imports for
   */
  public Set<SubNamespace> importedSubNamespaces(final Type t, final LifecycleState minState) {
    List<VersionedType> _allReferencedVersionedTypes = this._referencedTypesFinder.allReferencedVersionedTypes(t, minState);
    final Function1<VersionedType,SubNamespace> _function = new Function1<VersionedType,SubNamespace>() {
        public SubNamespace apply(final VersionedType e) {
          SubNamespace _findSubdomain = NamespaceImportQueries.this._namespaceQuery.findSubdomain(e);
          return _findSubdomain;
        }
      };
    List<SubNamespace> _map = ListExtensions.<VersionedType, SubNamespace>map(_allReferencedVersionedTypes, _function);
    Set<SubNamespace> _set = IterableExtensions.<SubNamespace>toSet(_map);
    return _set;
  }
  
  /**
   * Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
   * 	are derived from the versioned dependencies of the given Type considering the minimal LifecycleState required by the
   * 	given Type. The owning VersiondDomainNamespace of the found dependencies are returned.
   */
  protected Set<VersionedDomainNamespace> _importedVersionedNS(final Type t, final LifecycleState minState) {
    List<VersionedType> _allReferencedVersionedTypes = this._referencedTypesFinder.allReferencedVersionedTypes(t, minState);
    final Function1<VersionedType,VersionedDomainNamespace> _function = new Function1<VersionedType,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final VersionedType e) {
          VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceImportQueries.this.namespaceSplitter.createVersionedDomainNamespace(e);
          return _createVersionedDomainNamespace;
        }
      };
    List<VersionedDomainNamespace> _map = ListExtensions.<VersionedType, VersionedDomainNamespace>map(_allReferencedVersionedTypes, _function);
    Set<VersionedDomainNamespace> _set = IterableExtensions.<VersionedDomainNamespace>toSet(_map);
    return _set;
  }
  
  /**
   * Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
   * 	are derived from the versioned dependencies of the given Type considering the minimal LifecycleState required by the
   * 	given Type. The owning VersiondDomainNamespace of the found dependencies are returned.
   */
  protected Set<VersionedDomainNamespace> _importedVersionedNS(final VersionedDomainNamespace s, final LifecycleState minState) {
    HashSet<VersionedDomainNamespace> _hashSet = new HashSet<VersionedDomainNamespace>();
    Set<VersionedDomainNamespace> _importedVersionedNS = this.importedVersionedNS(s, minState, _hashSet);
    Set<VersionedDomainNamespace> _set = IterableExtensions.<VersionedDomainNamespace>toSet(_importedVersionedNS);
    return _set;
  }
  
  /**
   * called this????
   */
  protected Set<VersionedDomainNamespace> _importedVersionedNS(final VersionedDomainNamespace s, final LifecycleState minState, final Set<VersionedDomainNamespace> visited) {
    EObject _subdomain = s.getSubdomain();
    String _version = s.getVersion();
    Set<VersionedDomainNamespace> _importedVersionedNS = this.importedVersionedNS(((SubNamespace) _subdomain), _version, minState);
    return _importedVersionedNS;
  }
  
  /**
   * Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
   * 	are derived from the versioned dependencies of all owned VersiondTypes, Exceptions and Service in the given
   * 	VersionedDomainNamespace. The owning VersiondDomainNamespace of the found dependencies are returned.
   */
  public Set<VersionedDomainNamespace> importedVersionedNS(final VersionedDomainNamespace s) {
    HashSet<VersionedDomainNamespace> _hashSet = new HashSet<VersionedDomainNamespace>();
    Set<VersionedDomainNamespace> _importedVersionedNS = this.importedVersionedNS(s, _hashSet);
    Set<VersionedDomainNamespace> _set = IterableExtensions.<VersionedDomainNamespace>toSet(_importedVersionedNS);
    return _set;
  }
  
  protected Set<VersionedDomainNamespace> _importedVersionedNS(final VersionedDomainNamespace s, final Set<VersionedDomainNamespace> visited) {
    EObject _subdomain = s.getSubdomain();
    String _version = s.getVersion();
    Set<VersionedDomainNamespace> _importedVersionedNS = this.importedVersionedNS(((SubNamespace) _subdomain), _version);
    return _importedVersionedNS;
  }
  
  protected Set<VersionedDomainNamespace> _importedVersionedNS(final Object s, final String nameSpaceMajorVersion, final LifecycleState minState) {
    return null;
  }
  
  protected Set<VersionedDomainNamespace> _importedVersionedNS(final Object s, final String nameSpaceMajorVersion) {
    return null;
  }
  
  /**
   * Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
   * 	are derived from the versioned dependencies of all owned VersiondTypes, Exceptions and Service in the given
   * 	SubNamespace matching the given major version. The owning VersiondDomainNamespace of the found dependencies are returned.
   */
  protected Set<VersionedDomainNamespace> _importedVersionedNS(final SubNamespace s, final String nameSpaceMajorVersion, final LifecycleState minState) {
    Set<VersionedDomainNamespace> _xblockexpression = null;
    {
      List<VersionedType> _allTypesByMajorVersion = this._versionedTypeFilter.allTypesByMajorVersion(s, nameSpaceMajorVersion, minState);
      Iterable<BusinessObject> _filter = Iterables.<BusinessObject>filter(_allTypesByMajorVersion, BusinessObject.class);
      final Function1<BusinessObject,List<VersionedType>> _function = new Function1<BusinessObject,List<VersionedType>>() {
          public List<VersionedType> apply(final BusinessObject b) {
            List<VersionedType> _allReferencedVersionedTypes = NamespaceImportQueries.this._referencedTypesFinder.allReferencedVersionedTypes(b, minState);
            return _allReferencedVersionedTypes;
          }
        };
      Iterable<List<VersionedType>> _map = IterableExtensions.<BusinessObject, List<VersionedType>>map(_filter, _function);
      Iterable<VersionedType> _flatten = Iterables.<VersionedType>concat(_map);
      final Function1<VersionedType,VersionedDomainNamespace> _function_1 = new Function1<VersionedType,VersionedDomainNamespace>() {
          public VersionedDomainNamespace apply(final VersionedType e) {
            VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceImportQueries.this.namespaceSplitter.createVersionedDomainNamespace(e);
            return _createVersionedDomainNamespace;
          }
        };
      Iterable<VersionedDomainNamespace> _map_1 = IterableExtensions.<VersionedType, VersionedDomainNamespace>map(_flatten, _function_1);
      Set<VersionedDomainNamespace> imports = IterableExtensions.<VersionedDomainNamespace>toSet(_map_1);
      final List<org.fornax.soa.serviceDsl.Exception> exByMajor = this.serviceFinder.allExceptionsByMajorVersion(s, nameSpaceMajorVersion);
      final Function1<org.fornax.soa.serviceDsl.Exception,List<VersionedType>> _function_2 = new Function1<org.fornax.soa.serviceDsl.Exception,List<VersionedType>>() {
          public List<VersionedType> apply(final org.fornax.soa.serviceDsl.Exception ex) {
            List<VersionedType> _allReferencedVersionedTypes = NamespaceImportQueries.this._referencedTypesFinder.allReferencedVersionedTypes(ex, minState);
            return _allReferencedVersionedTypes;
          }
        };
      List<List<VersionedType>> _map_2 = ListExtensions.<org.fornax.soa.serviceDsl.Exception, List<VersionedType>>map(exByMajor, _function_2);
      Iterable<VersionedType> _flatten_1 = Iterables.<VersionedType>concat(_map_2);
      final Function1<VersionedType,VersionedDomainNamespace> _function_3 = new Function1<VersionedType,VersionedDomainNamespace>() {
          public VersionedDomainNamespace apply(final VersionedType e) {
            VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceImportQueries.this.namespaceSplitter.createVersionedDomainNamespace(e);
            return _createVersionedDomainNamespace;
          }
        };
      Iterable<VersionedDomainNamespace> _map_3 = IterableExtensions.<VersionedType, VersionedDomainNamespace>map(_flatten_1, _function_3);
      Iterables.<VersionedDomainNamespace>addAll(imports, _map_3);
      final Function1<org.fornax.soa.serviceDsl.Exception,ExceptionRef> _function_4 = new Function1<org.fornax.soa.serviceDsl.Exception,ExceptionRef>() {
          public ExceptionRef apply(final org.fornax.soa.serviceDsl.Exception ex) {
            ExceptionRef _superException = ex.getSuperException();
            return _superException;
          }
        };
      List<ExceptionRef> _map_4 = ListExtensions.<org.fornax.soa.serviceDsl.Exception, ExceptionRef>map(exByMajor, _function_4);
      Iterable<ExceptionRef> _filterNull = IterableExtensions.<ExceptionRef>filterNull(_map_4);
      final Function1<ExceptionRef,VersionedDomainNamespace> _function_5 = new Function1<ExceptionRef,VersionedDomainNamespace>() {
          public VersionedDomainNamespace apply(final ExceptionRef e) {
            org.fornax.soa.serviceDsl.Exception _findMatchingException = NamespaceImportQueries.this.excResolver.findMatchingException(e);
            VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceImportQueries.this.namespaceSplitter.createVersionedDomainNamespace(_findMatchingException);
            return _createVersionedDomainNamespace;
          }
        };
      Iterable<VersionedDomainNamespace> _map_5 = IterableExtensions.<ExceptionRef, VersionedDomainNamespace>map(_filterNull, _function_5);
      Iterables.<VersionedDomainNamespace>addAll(imports, _map_5);
      _xblockexpression = (imports);
    }
    return _xblockexpression;
  }
  
  /**
   * Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
   * 	are derived from the versioned dependencies of the given Service (versioned). The owning
   * 	VersiondDomainNamespace of the found dependencies are returned.
   */
  protected Set<VersionedDomainNamespace> _importedVersionedNS(final Service s, final LifecycleState minState) {
    HashSet<VersionedDomainNamespace> _hashSet = new HashSet<VersionedDomainNamespace>();
    HashSet<VersionedDomainNamespace> imports = _hashSet;
    List<VersionedType> _allReferencedVersionedTypes = this._referencedTypesFinder.allReferencedVersionedTypes(s, minState);
    final Function1<VersionedType,VersionedDomainNamespace> _function = new Function1<VersionedType,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final VersionedType e) {
          VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceImportQueries.this.namespaceSplitter.createVersionedDomainNamespace(e);
          return _createVersionedDomainNamespace;
        }
      };
    List<VersionedDomainNamespace> serviceBos = ListExtensions.<VersionedType, VersionedDomainNamespace>map(_allReferencedVersionedTypes, _function);
    Iterables.<VersionedDomainNamespace>addAll(imports, serviceBos);
    final List<org.fornax.soa.serviceDsl.Exception> allEx = this.serviceFinder.allReferencedExceptions(s);
    final Function1<org.fornax.soa.serviceDsl.Exception,VersionedDomainNamespace> _function_1 = new Function1<org.fornax.soa.serviceDsl.Exception,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final org.fornax.soa.serviceDsl.Exception e) {
          VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceImportQueries.this.namespaceSplitter.createVersionedDomainNamespace(e);
          return _createVersionedDomainNamespace;
        }
      };
    List<VersionedDomainNamespace> _map = ListExtensions.<org.fornax.soa.serviceDsl.Exception, VersionedDomainNamespace>map(allEx, _function_1);
    Iterables.<VersionedDomainNamespace>addAll(imports, _map);
    final Function1<org.fornax.soa.serviceDsl.Exception,List<VersionedType>> _function_2 = new Function1<org.fornax.soa.serviceDsl.Exception,List<VersionedType>>() {
        public List<VersionedType> apply(final org.fornax.soa.serviceDsl.Exception e) {
          List<VersionedType> _allReferencedVersionedTypes = NamespaceImportQueries.this._referencedTypesFinder.allReferencedVersionedTypes(e, minState);
          return _allReferencedVersionedTypes;
        }
      };
    List<List<VersionedType>> _map_1 = ListExtensions.<org.fornax.soa.serviceDsl.Exception, List<VersionedType>>map(allEx, _function_2);
    final Iterable<VersionedType> exRefTypes = Iterables.<VersionedType>concat(_map_1);
    final Function1<VersionedType,VersionedDomainNamespace> _function_3 = new Function1<VersionedType,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final VersionedType e) {
          VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceImportQueries.this.namespaceSplitter.createVersionedDomainNamespace(e);
          return _createVersionedDomainNamespace;
        }
      };
    Iterable<VersionedDomainNamespace> _map_2 = IterableExtensions.<VersionedType, VersionedDomainNamespace>map(exRefTypes, _function_3);
    Iterables.<VersionedDomainNamespace>addAll(imports, _map_2);
    final Function1<org.fornax.soa.serviceDsl.Exception,ExceptionRef> _function_4 = new Function1<org.fornax.soa.serviceDsl.Exception,ExceptionRef>() {
        public ExceptionRef apply(final org.fornax.soa.serviceDsl.Exception e) {
          ExceptionRef _superException = e.getSuperException();
          return _superException;
        }
      };
    List<ExceptionRef> _map_3 = ListExtensions.<org.fornax.soa.serviceDsl.Exception, ExceptionRef>map(allEx, _function_4);
    Iterable<ExceptionRef> _filterNull = IterableExtensions.<ExceptionRef>filterNull(_map_3);
    final Function1<ExceptionRef,VersionedDomainNamespace> _function_5 = new Function1<ExceptionRef,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final ExceptionRef e) {
          org.fornax.soa.serviceDsl.Exception _findMatchingException = NamespaceImportQueries.this.excResolver.findMatchingException(e);
          VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceImportQueries.this.namespaceSplitter.createVersionedDomainNamespace(_findMatchingException);
          return _createVersionedDomainNamespace;
        }
      };
    Iterable<VersionedDomainNamespace> _map_4 = IterableExtensions.<ExceptionRef, VersionedDomainNamespace>map(_filterNull, _function_5);
    Iterables.<VersionedDomainNamespace>addAll(imports, _map_4);
    return imports;
  }
  
  /**
   * Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
   * 	are derived from the versioned dependencies of the given Service (versioned). The owning
   * 	VersiondDomainNamespace of the found dependencies are returned.
   */
  protected Set<VersionedDomainNamespace> _importedVersionedNS(final Service s, final String nameSpaceMajorVersion, final LifecycleState minState) {
    HashSet<VersionedDomainNamespace> _hashSet = new HashSet<VersionedDomainNamespace>();
    HashSet<VersionedDomainNamespace> imports = _hashSet;
    List<VersionedType> _allReferencedVersionedTypes = this._referencedTypesFinder.allReferencedVersionedTypes(s, minState);
    final Function1<VersionedType,VersionedDomainNamespace> _function = new Function1<VersionedType,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final VersionedType e) {
          VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceImportQueries.this.namespaceSplitter.createVersionedDomainNamespace(e);
          return _createVersionedDomainNamespace;
        }
      };
    List<VersionedDomainNamespace> serviceBos = ListExtensions.<VersionedType, VersionedDomainNamespace>map(_allReferencedVersionedTypes, _function);
    Iterables.<VersionedDomainNamespace>addAll(imports, serviceBos);
    List<org.fornax.soa.serviceDsl.Exception> _allReferencedExceptions = this.serviceFinder.allReferencedExceptions(s);
    final Function1<org.fornax.soa.serviceDsl.Exception,VersionedDomainNamespace> _function_1 = new Function1<org.fornax.soa.serviceDsl.Exception,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final org.fornax.soa.serviceDsl.Exception e) {
          VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceImportQueries.this.namespaceSplitter.createVersionedDomainNamespace(e);
          return _createVersionedDomainNamespace;
        }
      };
    List<VersionedDomainNamespace> _map = ListExtensions.<org.fornax.soa.serviceDsl.Exception, VersionedDomainNamespace>map(_allReferencedExceptions, _function_1);
    Iterables.<VersionedDomainNamespace>addAll(imports, _map);
    final List<org.fornax.soa.serviceDsl.Exception> exByMajor = this.serviceFinder.allExceptionsByMajorVersion(s, nameSpaceMajorVersion);
    final Function1<org.fornax.soa.serviceDsl.Exception,List<VersionedType>> _function_2 = new Function1<org.fornax.soa.serviceDsl.Exception,List<VersionedType>>() {
        public List<VersionedType> apply(final org.fornax.soa.serviceDsl.Exception e) {
          List<VersionedType> _allReferencedVersionedTypes = NamespaceImportQueries.this._referencedTypesFinder.allReferencedVersionedTypes(e, minState);
          return _allReferencedVersionedTypes;
        }
      };
    List<List<VersionedType>> _map_1 = ListExtensions.<org.fornax.soa.serviceDsl.Exception, List<VersionedType>>map(exByMajor, _function_2);
    final Iterable<VersionedType> exRefTypes = Iterables.<VersionedType>concat(_map_1);
    final Function1<VersionedType,VersionedDomainNamespace> _function_3 = new Function1<VersionedType,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final VersionedType e) {
          VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceImportQueries.this.namespaceSplitter.createVersionedDomainNamespace(e);
          return _createVersionedDomainNamespace;
        }
      };
    Iterable<VersionedDomainNamespace> _map_2 = IterableExtensions.<VersionedType, VersionedDomainNamespace>map(exRefTypes, _function_3);
    Iterables.<VersionedDomainNamespace>addAll(imports, _map_2);
    final Function1<org.fornax.soa.serviceDsl.Exception,ExceptionRef> _function_4 = new Function1<org.fornax.soa.serviceDsl.Exception,ExceptionRef>() {
        public ExceptionRef apply(final org.fornax.soa.serviceDsl.Exception e) {
          ExceptionRef _superException = e.getSuperException();
          return _superException;
        }
      };
    List<ExceptionRef> _map_3 = ListExtensions.<org.fornax.soa.serviceDsl.Exception, ExceptionRef>map(exByMajor, _function_4);
    Iterable<ExceptionRef> _filterNull = IterableExtensions.<ExceptionRef>filterNull(_map_3);
    final Function1<ExceptionRef,VersionedDomainNamespace> _function_5 = new Function1<ExceptionRef,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final ExceptionRef e) {
          org.fornax.soa.serviceDsl.Exception _findMatchingException = NamespaceImportQueries.this.excResolver.findMatchingException(e);
          VersionedDomainNamespace _createVersionedDomainNamespace = NamespaceImportQueries.this.namespaceSplitter.createVersionedDomainNamespace(_findMatchingException);
          return _createVersionedDomainNamespace;
        }
      };
    Iterable<VersionedDomainNamespace> _map_4 = IterableExtensions.<ExceptionRef, VersionedDomainNamespace>map(_filterNull, _function_5);
    Iterables.<VersionedDomainNamespace>addAll(imports, _map_4);
    return imports;
  }
  
  public Set<VersionedDomainNamespace> allImportedVersionedNS(final Object t, final Object minState) {
    if (t instanceof Type
         && minState instanceof LifecycleState) {
      return _allImportedVersionedNS((Type)t, (LifecycleState)minState);
    } else if (t instanceof VersionedDomainNamespace
         && minState instanceof Set) {
      return _allImportedVersionedNS((VersionedDomainNamespace)t, (Set<VersionedDomainNamespace>)minState);
    } else if (t instanceof VersionedDomainNamespace
         && minState instanceof LifecycleState) {
      return _allImportedVersionedNS((VersionedDomainNamespace)t, (LifecycleState)minState);
    } else if (t != null
         && minState instanceof String) {
      return _allImportedVersionedNS(t, (String)minState);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t, minState).toString());
    }
  }
  
  public Set<VersionedDomainNamespace> allImportedVersionedNS(final Object s, final Object nameSpaceMajorVersion, final Object minState) {
    if (s instanceof Service
         && nameSpaceMajorVersion instanceof String
         && minState instanceof LifecycleState) {
      return _allImportedVersionedNS((Service)s, (String)nameSpaceMajorVersion, (LifecycleState)minState);
    } else if (s instanceof SubNamespace
         && nameSpaceMajorVersion instanceof String
         && minState instanceof LifecycleState) {
      return _allImportedVersionedNS((SubNamespace)s, (String)nameSpaceMajorVersion, (LifecycleState)minState);
    } else if (s instanceof VersionedDomainNamespace
         && nameSpaceMajorVersion instanceof LifecycleState
         && minState instanceof Set) {
      return _allImportedVersionedNS((VersionedDomainNamespace)s, (LifecycleState)nameSpaceMajorVersion, (Set<VersionedDomainNamespace>)minState);
    } else if (s != null
         && nameSpaceMajorVersion instanceof String
         && minState instanceof LifecycleState) {
      return _allImportedVersionedNS(s, (String)nameSpaceMajorVersion, (LifecycleState)minState);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s, nameSpaceMajorVersion, minState).toString());
    }
  }
  
  public Set<VersionedDomainNamespace> importedVersionedNS(final Object s, final Object minState) {
    if (s instanceof Service
         && minState instanceof LifecycleState) {
      return _importedVersionedNS((Service)s, (LifecycleState)minState);
    } else if (s instanceof Type
         && minState instanceof LifecycleState) {
      return _importedVersionedNS((Type)s, (LifecycleState)minState);
    } else if (s instanceof VersionedDomainNamespace
         && minState instanceof Set) {
      return _importedVersionedNS((VersionedDomainNamespace)s, (Set<VersionedDomainNamespace>)minState);
    } else if (s instanceof VersionedDomainNamespace
         && minState instanceof LifecycleState) {
      return _importedVersionedNS((VersionedDomainNamespace)s, (LifecycleState)minState);
    } else if (s != null
         && minState instanceof String) {
      return _importedVersionedNS(s, (String)minState);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s, minState).toString());
    }
  }
  
  public Set<VersionedDomainNamespace> importedVersionedNS(final Object s, final Object nameSpaceMajorVersion, final Object minState) {
    if (s instanceof Service
         && nameSpaceMajorVersion instanceof String
         && minState instanceof LifecycleState) {
      return _importedVersionedNS((Service)s, (String)nameSpaceMajorVersion, (LifecycleState)minState);
    } else if (s instanceof SubNamespace
         && nameSpaceMajorVersion instanceof String
         && minState instanceof LifecycleState) {
      return _importedVersionedNS((SubNamespace)s, (String)nameSpaceMajorVersion, (LifecycleState)minState);
    } else if (s instanceof VersionedDomainNamespace
         && nameSpaceMajorVersion instanceof LifecycleState
         && minState instanceof Set) {
      return _importedVersionedNS((VersionedDomainNamespace)s, (LifecycleState)nameSpaceMajorVersion, (Set<VersionedDomainNamespace>)minState);
    } else if (s != null
         && nameSpaceMajorVersion instanceof String
         && minState instanceof LifecycleState) {
      return _importedVersionedNS(s, (String)nameSpaceMajorVersion, (LifecycleState)minState);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s, nameSpaceMajorVersion, minState).toString());
    }
  }
}
