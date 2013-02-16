package org.fornax.soa.profiledsl.query.type;

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
import org.fornax.soa.profiledsl.query.type.LatestMatchingTypeFinder;
import org.fornax.soa.profiledsl.sOAProfileDsl.AbstractProperty;
import org.fornax.soa.profiledsl.sOAProfileDsl.ClassRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader;
import org.fornax.soa.profiledsl.sOAProfileDsl.Property;
import org.fornax.soa.profiledsl.sOAProfileDsl.Type;
import org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType;
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedTypeRef;

@SuppressWarnings("all")
public class ReferencedTypesFinder {
  @Inject
  private LatestMatchingTypeFinder _latestMatchingTypeFinder;
  
  protected List<VersionedType> _allReferencedVersionedTypes(final Type t, final LifecycleState minState) {
    ArrayList<VersionedType> _newArrayList = CollectionLiterals.<VersionedType>newArrayList();
    return _newArrayList;
  }
  
  protected List<VersionedType> _allReferencedVersionedTypes(final org.fornax.soa.profiledsl.sOAProfileDsl.Class t) {
    List<TypeRef> _allReferencedTypeRefs = this.allReferencedTypeRefs(t);
    Iterable<VersionedTypeRef> _filter = Iterables.<VersionedTypeRef>filter(_allReferencedTypeRefs, VersionedTypeRef.class);
    final Function1<VersionedTypeRef,VersionedType> _function = new Function1<VersionedTypeRef,VersionedType>() {
        public VersionedType apply(final VersionedTypeRef e) {
          VersionedType _selectLatestMatchingType = ReferencedTypesFinder.this._latestMatchingTypeFinder.selectLatestMatchingType(e);
          return ((VersionedType) _selectLatestMatchingType);
        }
      };
    Iterable<VersionedType> _map = IterableExtensions.<VersionedTypeRef, VersionedType>map(_filter, _function);
    List<VersionedType> _list = IterableExtensions.<VersionedType>toList(_map);
    return _list;
  }
  
  protected List<TypeRef> _allReferencedTypeRefs(final org.fornax.soa.profiledsl.sOAProfileDsl.Class t) {
    List<TypeRef> _xblockexpression = null;
    {
      HashSet<TypeRef> _hashSet = new HashSet<TypeRef>();
      HashSet<TypeRef> refs = _hashSet;
      ClassRef _superClass = t.getSuperClass();
      boolean _notEquals = (!Objects.equal(_superClass, null));
      if (_notEquals) {
        EList<AbstractProperty> _properties = t.getProperties();
        Iterable<Property> _filter = Iterables.<Property>filter(_properties, Property.class);
        final Function1<Property,TypeRef> _function = new Function1<Property,TypeRef>() {
            public TypeRef apply(final Property e) {
              TypeRef _type = e.getType();
              return _type;
            }
          };
        Iterable<TypeRef> _map = IterableExtensions.<Property, TypeRef>map(_filter, _function);
        Iterables.<TypeRef>addAll(refs, _map);
        ClassRef _superClass_1 = t.getSuperClass();
        refs.add(((TypeRef) _superClass_1));
      } else {
        EList<AbstractProperty> _properties_1 = t.getProperties();
        Iterable<Property> _filter_1 = Iterables.<Property>filter(_properties_1, Property.class);
        final Function1<Property,TypeRef> _function_1 = new Function1<Property,TypeRef>() {
            public TypeRef apply(final Property e) {
              TypeRef _type = e.getType();
              return _type;
            }
          };
        Iterable<TypeRef> _map_1 = IterableExtensions.<Property, TypeRef>map(_filter_1, _function_1);
        Iterables.<TypeRef>addAll(refs, _map_1);
      }
      List<TypeRef> _list = IterableExtensions.<TypeRef>toList(refs);
      _xblockexpression = (_list);
    }
    return _xblockexpression;
  }
  
  protected List<VersionedType> _allReferencedVersionedTypes(final MessageHeader t) {
    List<VersionedType> _xblockexpression = null;
    {
      EList<Property> _parameters = t.getParameters();
      final Function1<Property,TypeRef> _function = new Function1<Property,TypeRef>() {
          public TypeRef apply(final Property p) {
            TypeRef _type = p.getType();
            return _type;
          }
        };
      List<TypeRef> _map = ListExtensions.<Property, TypeRef>map(_parameters, _function);
      Iterable<VersionedTypeRef> _filter = Iterables.<VersionedTypeRef>filter(_map, VersionedTypeRef.class);
      final Function1<VersionedTypeRef,Type> _function_1 = new Function1<VersionedTypeRef,Type>() {
          public Type apply(final VersionedTypeRef v) {
            VersionedType _type = v.getType();
            return ((Type) _type);
          }
        };
      final Iterable<Type> types = IterableExtensions.<VersionedTypeRef, Type>map(_filter, _function_1);
      final Function1<Type,List<TypeRef>> _function_2 = new Function1<Type,List<TypeRef>>() {
          public List<TypeRef> apply(final Type e) {
            List<TypeRef> _allReferencedTypeRefs = ReferencedTypesFinder.this.allReferencedTypeRefs(e);
            return _allReferencedTypeRefs;
          }
        };
      Iterable<List<TypeRef>> _map_1 = IterableExtensions.<Type, List<TypeRef>>map(types, _function_2);
      Iterable<TypeRef> _flatten = Iterables.<TypeRef>concat(_map_1);
      final Iterable<VersionedTypeRef> transitiveTypeRefs = Iterables.<VersionedTypeRef>filter(_flatten, VersionedTypeRef.class);
      final Function1<VersionedTypeRef,VersionedType> _function_3 = new Function1<VersionedTypeRef,VersionedType>() {
          public VersionedType apply(final VersionedTypeRef r) {
            VersionedType _selectLatestMatchingType = ReferencedTypesFinder.this._latestMatchingTypeFinder.selectLatestMatchingType(r);
            return _selectLatestMatchingType;
          }
        };
      Iterable<VersionedType> _map_2 = IterableExtensions.<VersionedTypeRef, VersionedType>map(transitiveTypeRefs, _function_3);
      Iterable<VersionedType> _filter_1 = Iterables.<VersionedType>filter(_map_2, VersionedType.class);
      List<VersionedType> _list = IterableExtensions.<VersionedType>toList(_filter_1);
      _xblockexpression = (_list);
    }
    return _xblockexpression;
  }
  
  protected List<TypeRef> _allReferencedTypeRefs(final Type t) {
    ArrayList<TypeRef> _arrayList = new ArrayList<TypeRef>();
    return _arrayList;
  }
  
  protected List<TypeRef> _allReferencedTypeRefs(final TypeRef t) {
    ArrayList<TypeRef> _arrayList = new ArrayList<TypeRef>();
    return _arrayList;
  }
  
  protected List<TypeRef> _allReferencedTypeRefs(final VersionedType t) {
    ArrayList<TypeRef> _arrayList = new ArrayList<TypeRef>();
    return _arrayList;
  }
  
  protected List<TypeRef> _allReferencedTypeRefs(final MessageHeader t) {
    EList<Property> _parameters = t.getParameters();
    final Function1<Property,TypeRef> _function = new Function1<Property,TypeRef>() {
        public TypeRef apply(final Property p) {
          TypeRef _type = p.getType();
          return _type;
        }
      };
    List<TypeRef> _map = ListExtensions.<Property, TypeRef>map(_parameters, _function);
    List<TypeRef> _list = IterableExtensions.<TypeRef>toList(_map);
    return _list;
  }
  
  public List<VersionedType> allReferencedVersionedTypes(final Type t, final LifecycleState minState) {
    {
      return _allReferencedVersionedTypes(t, minState);
    }
  }
  
  public List<VersionedType> allReferencedVersionedTypes(final EObject t) {
    if (t instanceof org.fornax.soa.profiledsl.sOAProfileDsl.Class) {
      return _allReferencedVersionedTypes((org.fornax.soa.profiledsl.sOAProfileDsl.Class)t);
    } else if (t instanceof MessageHeader) {
      return _allReferencedVersionedTypes((MessageHeader)t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t).toString());
    }
  }
  
  public List<TypeRef> allReferencedTypeRefs(final EObject t) {
    if (t instanceof org.fornax.soa.profiledsl.sOAProfileDsl.Class) {
      return _allReferencedTypeRefs((org.fornax.soa.profiledsl.sOAProfileDsl.Class)t);
    } else if (t instanceof VersionedType) {
      return _allReferencedTypeRefs((VersionedType)t);
    } else if (t instanceof MessageHeader) {
      return _allReferencedTypeRefs((MessageHeader)t);
    } else if (t instanceof Type) {
      return _allReferencedTypeRefs((Type)t);
    } else if (t instanceof TypeRef) {
      return _allReferencedTypeRefs((TypeRef)t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t).toString());
    }
  }
}
