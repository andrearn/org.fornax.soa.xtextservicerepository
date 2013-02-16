package org.fornax.soa.service.query.type;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.service.versioning.ITypeResolver;
import org.fornax.soa.serviceDsl.AbstractVersionedTypeRef;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.BusinessObjectRef;
import org.fornax.soa.serviceDsl.Operation;
import org.fornax.soa.serviceDsl.Parameter;
import org.fornax.soa.serviceDsl.Property;
import org.fornax.soa.serviceDsl.QueryObject;
import org.fornax.soa.serviceDsl.QueryObjectRef;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.SimpleAttribute;
import org.fornax.soa.serviceDsl.Type;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.serviceDsl.VersionedType;

/**
 * Find types references by a model object
 */
@SuppressWarnings("all")
public class ReferencedTypesFinder {
  @Inject
  private ITypeResolver _iTypeResolver;
  
  protected List<TypeRef> _allReferencedTypeRefs(final Type t) {
    ArrayList<TypeRef> _newArrayList = CollectionLiterals.<TypeRef>newArrayList();
    return _newArrayList;
  }
  
  protected List<TypeRef> _allReferencedTypeRefs(final BusinessObject t) {
    ArrayList<TypeRef> _arrayList = new ArrayList<TypeRef>();
    ArrayList<TypeRef> refs = _arrayList;
    BusinessObjectRef _superBusinessObject = t.getSuperBusinessObject();
    boolean _notEquals = (!Objects.equal(_superBusinessObject, null));
    if (_notEquals) {
      BusinessObjectRef _superBusinessObject_1 = t.getSuperBusinessObject();
      refs.add(_superBusinessObject_1);
      EList<Property> _properties = t.getProperties();
      final Function1<Property,TypeRef> _function = new Function1<Property,TypeRef>() {
          public TypeRef apply(final Property p) {
            TypeRef _type = p.getType();
            return _type;
          }
        };
      List<TypeRef> _map = ListExtensions.<Property, TypeRef>map(_properties, _function);
      refs.addAll(_map);
    } else {
      EList<Property> _properties_1 = t.getProperties();
      final Function1<Property,TypeRef> _function_1 = new Function1<Property,TypeRef>() {
          public TypeRef apply(final Property p) {
            TypeRef _type = p.getType();
            return _type;
          }
        };
      List<TypeRef> _map_1 = ListExtensions.<Property, TypeRef>map(_properties_1, _function_1);
      refs.addAll(_map_1);
    }
    return refs;
  }
  
  protected List<TypeRef> _allReferencedTypeRefs(final QueryObject t) {
    ArrayList<TypeRef> _arrayList = new ArrayList<TypeRef>();
    ArrayList<TypeRef> refs = _arrayList;
    QueryObjectRef _superQueryObject = t.getSuperQueryObject();
    boolean _notEquals = (!Objects.equal(_superQueryObject, null));
    if (_notEquals) {
      QueryObjectRef _superQueryObject_1 = t.getSuperQueryObject();
      refs.add(_superQueryObject_1);
      EList<Property> _properties = t.getProperties();
      final Function1<Property,TypeRef> _function = new Function1<Property,TypeRef>() {
          public TypeRef apply(final Property p) {
            TypeRef _type = p.getType();
            return _type;
          }
        };
      List<TypeRef> _map = ListExtensions.<Property, TypeRef>map(_properties, _function);
      refs.addAll(_map);
    } else {
      EList<Property> _properties_1 = t.getProperties();
      final Function1<Property,TypeRef> _function_1 = new Function1<Property,TypeRef>() {
          public TypeRef apply(final Property p) {
            TypeRef _type = p.getType();
            return _type;
          }
        };
      List<TypeRef> _map_1 = ListExtensions.<Property, TypeRef>map(_properties_1, _function_1);
      refs.addAll(_map_1);
    }
    return refs;
  }
  
  protected List<TypeRef> _allReferencedTypeRefs(final org.fornax.soa.serviceDsl.Exception t) {
    EList<SimpleAttribute> _properties = t.getProperties();
    final Function1<SimpleAttribute,TypeRef> _function = new Function1<SimpleAttribute,TypeRef>() {
        public TypeRef apply(final SimpleAttribute p) {
          TypeRef _type = p.getType();
          return _type;
        }
      };
    List<TypeRef> _map = ListExtensions.<SimpleAttribute, TypeRef>map(_properties, _function);
    return _map;
  }
  
  protected List<TypeRef> _allReferencedTypeRefs(final Parameter p) {
    TypeRef _type = p.getType();
    ArrayList<TypeRef> _newArrayList = CollectionLiterals.<TypeRef>newArrayList(_type);
    return _newArrayList;
  }
  
  protected List<TypeRef> _allReferencedTypeRefs(final Operation o) {
    List<TypeRef> _xblockexpression = null;
    {
      HashSet<TypeRef> _hashSet = new HashSet<TypeRef>();
      HashSet<TypeRef> refs = _hashSet;
      EList<Parameter> _parameters = o.getParameters();
      final Function1<Parameter,List<TypeRef>> _function = new Function1<Parameter,List<TypeRef>>() {
          public List<TypeRef> apply(final Parameter p) {
            List<TypeRef> _allReferencedTypeRefs = ReferencedTypesFinder.this.allReferencedTypeRefs(p);
            return _allReferencedTypeRefs;
          }
        };
      List<List<TypeRef>> _map = ListExtensions.<Parameter, List<TypeRef>>map(_parameters, _function);
      Iterable<TypeRef> _flatten = Iterables.<TypeRef>concat(_map);
      Iterable<TypeRef> _filter = Iterables.<TypeRef>filter(_flatten, TypeRef.class);
      Iterables.<TypeRef>addAll(refs, _filter);
      EList<Parameter> _return = o.getReturn();
      final Function1<Parameter,List<TypeRef>> _function_1 = new Function1<Parameter,List<TypeRef>>() {
          public List<TypeRef> apply(final Parameter r) {
            List<TypeRef> _allReferencedTypeRefs = ReferencedTypesFinder.this.allReferencedTypeRefs(r);
            return _allReferencedTypeRefs;
          }
        };
      List<List<TypeRef>> _map_1 = ListExtensions.<Parameter, List<TypeRef>>map(_return, _function_1);
      Iterable<TypeRef> _flatten_1 = Iterables.<TypeRef>concat(_map_1);
      Iterable<TypeRef> _filter_1 = Iterables.<TypeRef>filter(_flatten_1, TypeRef.class);
      Iterables.<TypeRef>addAll(refs, _filter_1);
      List<TypeRef> _list = IterableExtensions.<TypeRef>toList(refs);
      _xblockexpression = (_list);
    }
    return _xblockexpression;
  }
  
  protected List<TypeRef> _allReferencedTypeRefs(final Service s) {
    EList<Operation> _operations = s.getOperations();
    final Function1<Operation,List<TypeRef>> _function = new Function1<Operation,List<TypeRef>>() {
        public List<TypeRef> apply(final Operation o) {
          List<TypeRef> _allReferencedTypeRefs = ReferencedTypesFinder.this.allReferencedTypeRefs(o);
          return _allReferencedTypeRefs;
        }
      };
    List<List<TypeRef>> _map = ListExtensions.<Operation, List<TypeRef>>map(_operations, _function);
    Iterable<TypeRef> _flatten = Iterables.<TypeRef>concat(_map);
    final Function1<TypeRef,TypeRef> _function_1 = new Function1<TypeRef,TypeRef>() {
        public TypeRef apply(final TypeRef e) {
          return ((TypeRef) e);
        }
      };
    Iterable<TypeRef> _map_1 = IterableExtensions.<TypeRef, TypeRef>map(_flatten, _function_1);
    List<TypeRef> _list = IterableExtensions.<TypeRef>toList(_map_1);
    return _list;
  }
  
  protected List<VersionedType> _allReferencedVersionedTypes(final Type t, final LifecycleState minState) {
    ArrayList<VersionedType> _newArrayList = CollectionLiterals.<VersionedType>newArrayList();
    return _newArrayList;
  }
  
  protected List<VersionedType> _allReferencedVersionedTypes(final BusinessObject t, final LifecycleState minState) {
    List<TypeRef> _allReferencedTypeRefs = this.allReferencedTypeRefs(t);
    Iterable<AbstractVersionedTypeRef> _filter = Iterables.<AbstractVersionedTypeRef>filter(_allReferencedTypeRefs, AbstractVersionedTypeRef.class);
    final Function1<AbstractVersionedTypeRef,VersionedType> _function = new Function1<AbstractVersionedTypeRef,VersionedType>() {
        public VersionedType apply(final AbstractVersionedTypeRef e) {
          VersionedType _selectMatchingType = ReferencedTypesFinder.this._iTypeResolver.selectMatchingType(e);
          return ((VersionedType) _selectMatchingType);
        }
      };
    Iterable<VersionedType> _map = IterableExtensions.<AbstractVersionedTypeRef, VersionedType>map(_filter, _function);
    List<VersionedType> _list = IterableExtensions.<VersionedType>toList(_map);
    return _list;
  }
  
  protected List<VersionedType> _allReferencedVersionedTypes(final org.fornax.soa.serviceDsl.Exception t, final LifecycleState minState) {
    List<TypeRef> _allReferencedTypeRefs = this.allReferencedTypeRefs(t);
    Iterable<AbstractVersionedTypeRef> _filter = Iterables.<AbstractVersionedTypeRef>filter(_allReferencedTypeRefs, AbstractVersionedTypeRef.class);
    final Function1<AbstractVersionedTypeRef,VersionedType> _function = new Function1<AbstractVersionedTypeRef,VersionedType>() {
        public VersionedType apply(final AbstractVersionedTypeRef e) {
          VersionedType _selectMatchingType = ReferencedTypesFinder.this._iTypeResolver.selectMatchingType(e);
          return ((VersionedType) _selectMatchingType);
        }
      };
    Iterable<VersionedType> _map = IterableExtensions.<AbstractVersionedTypeRef, VersionedType>map(_filter, _function);
    List<VersionedType> _list = IterableExtensions.<VersionedType>toList(_map);
    return _list;
  }
  
  protected List<VersionedType> _allReferencedVersionedTypes(final Parameter p, final LifecycleState minState) {
    List<TypeRef> _allReferencedTypeRefs = this.allReferencedTypeRefs(p);
    Iterable<AbstractVersionedTypeRef> _filter = Iterables.<AbstractVersionedTypeRef>filter(_allReferencedTypeRefs, AbstractVersionedTypeRef.class);
    final Function1<AbstractVersionedTypeRef,VersionedType> _function = new Function1<AbstractVersionedTypeRef,VersionedType>() {
        public VersionedType apply(final AbstractVersionedTypeRef e) {
          VersionedType _selectMatchingType = ReferencedTypesFinder.this._iTypeResolver.selectMatchingType(e);
          return ((VersionedType) _selectMatchingType);
        }
      };
    Iterable<VersionedType> _map = IterableExtensions.<AbstractVersionedTypeRef, VersionedType>map(_filter, _function);
    List<VersionedType> _list = IterableExtensions.<VersionedType>toList(_map);
    return _list;
  }
  
  protected List<VersionedType> _allReferencedVersionedTypes(final Operation o, final LifecycleState minState) {
    List<TypeRef> _allReferencedTypeRefs = this.allReferencedTypeRefs(o);
    Iterable<AbstractVersionedTypeRef> _filter = Iterables.<AbstractVersionedTypeRef>filter(_allReferencedTypeRefs, AbstractVersionedTypeRef.class);
    final Function1<AbstractVersionedTypeRef,VersionedType> _function = new Function1<AbstractVersionedTypeRef,VersionedType>() {
        public VersionedType apply(final AbstractVersionedTypeRef e) {
          VersionedType _selectMatchingType = ReferencedTypesFinder.this._iTypeResolver.selectMatchingType(e);
          return ((VersionedType) _selectMatchingType);
        }
      };
    Iterable<VersionedType> _map = IterableExtensions.<AbstractVersionedTypeRef, VersionedType>map(_filter, _function);
    List<VersionedType> _list = IterableExtensions.<VersionedType>toList(_map);
    return _list;
  }
  
  protected List<VersionedType> _allReferencedVersionedTypes(final Service s, final LifecycleState minState) {
    List<TypeRef> _allReferencedTypeRefs = this.allReferencedTypeRefs(s);
    Iterable<AbstractVersionedTypeRef> _filter = Iterables.<AbstractVersionedTypeRef>filter(_allReferencedTypeRefs, AbstractVersionedTypeRef.class);
    final Function1<AbstractVersionedTypeRef,VersionedType> _function = new Function1<AbstractVersionedTypeRef,VersionedType>() {
        public VersionedType apply(final AbstractVersionedTypeRef e) {
          VersionedType _selectMatchingType = ReferencedTypesFinder.this._iTypeResolver.selectMatchingType(e);
          return ((VersionedType) _selectMatchingType);
        }
      };
    Iterable<VersionedType> _map = IterableExtensions.<AbstractVersionedTypeRef, VersionedType>map(_filter, _function);
    List<VersionedType> _list = IterableExtensions.<VersionedType>toList(_map);
    return _list;
  }
  
  public List<TypeRef> allReferencedTypeRefs(final EObject t) {
    if (t instanceof BusinessObject) {
      return _allReferencedTypeRefs((BusinessObject)t);
    } else if (t instanceof QueryObject) {
      return _allReferencedTypeRefs((QueryObject)t);
    } else if (t instanceof org.fornax.soa.serviceDsl.Exception) {
      return _allReferencedTypeRefs((org.fornax.soa.serviceDsl.Exception)t);
    } else if (t instanceof Operation) {
      return _allReferencedTypeRefs((Operation)t);
    } else if (t instanceof Parameter) {
      return _allReferencedTypeRefs((Parameter)t);
    } else if (t instanceof Service) {
      return _allReferencedTypeRefs((Service)t);
    } else if (t instanceof Type) {
      return _allReferencedTypeRefs((Type)t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t).toString());
    }
  }
  
  public List<VersionedType> allReferencedVersionedTypes(final EObject t, final LifecycleState minState) {
    if (t instanceof BusinessObject) {
      return _allReferencedVersionedTypes((BusinessObject)t, minState);
    } else if (t instanceof org.fornax.soa.serviceDsl.Exception) {
      return _allReferencedVersionedTypes((org.fornax.soa.serviceDsl.Exception)t, minState);
    } else if (t instanceof Operation) {
      return _allReferencedVersionedTypes((Operation)t, minState);
    } else if (t instanceof Parameter) {
      return _allReferencedVersionedTypes((Parameter)t, minState);
    } else if (t instanceof Service) {
      return _allReferencedVersionedTypes((Service)t, minState);
    } else if (t instanceof Type) {
      return _allReferencedVersionedTypes((Type)t, minState);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t, minState).toString());
    }
  }
}
