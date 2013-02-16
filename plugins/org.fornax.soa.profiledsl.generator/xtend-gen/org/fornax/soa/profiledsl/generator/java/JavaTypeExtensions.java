package org.fornax.soa.profiledsl.generator.java;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe2.language.scoping.QualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.profiledsl.generator.schema.ProfileSchemaNamespaceExtensions;
import org.fornax.soa.profiledsl.sOAProfileDsl.DataType;
import org.fornax.soa.profiledsl.sOAProfileDsl.DataTypeRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.Property;
import org.fornax.soa.profiledsl.sOAProfileDsl.Type;
import org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType;
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedTypeRef;

@SuppressWarnings("all")
public class JavaTypeExtensions {
  @Inject
  private QualifiedNameProvider nameProvider;
  
  @Inject
  private ProfileSchemaNamespaceExtensions _profileSchemaNamespaceExtensions;
  
  /**
   * Returns the fully qualified java class name for a Type.
   */
  protected Object _toQualifiedJavaTypeName(final Type type, final boolean optionalField) {
    return null;
  }
  
  protected Object _toQualifiedJavaTypeName(final DataType type, final boolean optionalField) {
    String _switchResult = null;
    String _name = type.getName();
    final String _switchValue = _name;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,"date")) {
        _matched=true;
        _switchResult = "java.util.Date";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"datetime")) {
        _matched=true;
        _switchResult = "java.util.Date";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"byte")) {
        _matched=true;
        if (optionalField) {
          return "Byte";
        } else {
          return "byte";
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"int")) {
        _matched=true;
        if (optionalField) {
          return "Integer";
        } else {
          return "int";
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"long")) {
        _matched=true;
        if (optionalField) {
          return "Long";
        } else {
          return "long";
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"float")) {
        _matched=true;
        if (optionalField) {
          return "Float";
        } else {
          return "float";
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"double")) {
        _matched=true;
        if (optionalField) {
          return "Double";
        } else {
          return "double";
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"decimal")) {
        _matched=true;
        _switchResult = "java.math.BigDecimal";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"binary")) {
        _matched=true;
        _switchResult = "byte[]";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"base64Binary")) {
        _matched=true;
        _switchResult = "byte[]";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"decimal")) {
        _matched=true;
        _switchResult = "BigDecimal";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"boolean")) {
        _matched=true;
        if (optionalField) {
          return "Boolean";
        } else {
          return "boolean";
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"char")) {
        _matched=true;
        if (optionalField) {
          return "Character";
        } else {
          return "char";
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"string")) {
        _matched=true;
        return "String";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"anyType")) {
        _matched=true;
        return "Object";
      }
    }
    if (!_matched) {
      return "void";
    }
    return _switchResult;
  }
  
  protected Object _toQualifiedJavaTypeName(final VersionedType type, final boolean optionalField) {
    EObject _eContainer = type.eContainer();
    QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(_eContainer);
    String _string = _fullyQualifiedName.toString();
    String _plus = (_string + ".");
    Version _version = type.getVersion();
    String _versionPostfix = this._profileSchemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_1 = (_plus + _versionPostfix);
    String _plus_2 = (_plus_1 + ".");
    String _name = type.getName();
    String _plus_3 = (_plus_2 + _name);
    return _plus_3;
  }
  
  protected Object _toQualifiedJavaTypeName(final TypeRef typeRef, final boolean optionalField) {
    return null;
  }
  
  protected Object _toQualifiedJavaTypeName(final DataTypeRef typeRef, final boolean optionalField) {
    DataType _type = typeRef.getType();
    Object _qualifiedJavaTypeName = this.toQualifiedJavaTypeName(_type, optionalField);
    return _qualifiedJavaTypeName;
  }
  
  protected Object _toQualifiedJavaTypeName(final VersionedTypeRef typeRef, final boolean optionalField) {
    VersionedType _type = typeRef.getType();
    Object _qualifiedJavaTypeName = this.toQualifiedJavaTypeName(_type, optionalField);
    return _qualifiedJavaTypeName;
  }
  
  /**
   * returns the Java type name of the property's type
   */
  public Object toQualifiedJavaTypeName(final Property property) {
    TypeRef _type = property.getType();
    boolean _isOptional = property.isOptional();
    Object _qualifiedJavaTypeName = this.toQualifiedJavaTypeName(_type, _isOptional);
    return _qualifiedJavaTypeName;
  }
  
  /**
   * Returns the Java class name for a Type.
   */
  protected Object _toJavaTypeName(final Type type, final boolean optionalField) {
    return null;
  }
  
  protected Object _toJavaTypeName(final DataType type, final boolean optionalField) {
    String _switchResult = null;
    String _name = type.getName();
    final String _switchValue = _name;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,"date")) {
        _matched=true;
        _switchResult = "Date";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"datetime")) {
        _matched=true;
        _switchResult = "Date";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"byte")) {
        _matched=true;
        if (optionalField) {
          return "Byte";
        } else {
          return "byte";
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"int")) {
        _matched=true;
        if (optionalField) {
          return "Integer";
        } else {
          return "int";
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"long")) {
        _matched=true;
        if (optionalField) {
          return "Long";
        } else {
          return "long";
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"float")) {
        _matched=true;
        if (optionalField) {
          return "Float";
        } else {
          return "float";
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"double")) {
        _matched=true;
        if (optionalField) {
          return "Double";
        } else {
          return "double";
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"decimal")) {
        _matched=true;
        _switchResult = "BigDecimal";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"binary")) {
        _matched=true;
        _switchResult = "byte[]";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"base64Binary")) {
        _matched=true;
        _switchResult = "byte[]";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"decimal")) {
        _matched=true;
        _switchResult = "BigDecimal";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"boolean")) {
        _matched=true;
        if (optionalField) {
          return "Boolean";
        } else {
          return "boolean";
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"char")) {
        _matched=true;
        if (optionalField) {
          return "Character";
        } else {
          return "char";
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"string")) {
        _matched=true;
        return "String";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"anyType")) {
        _matched=true;
        return "Object";
      }
    }
    if (!_matched) {
      return "void";
    }
    return _switchResult;
  }
  
  protected Object _toJavaTypeName(final VersionedType type, final boolean optionalField) {
    String _name = type.getName();
    return _name;
  }
  
  protected Object _toJavaTypeName(final TypeRef typeRef, final boolean optionalField) {
    return null;
  }
  
  protected Object _toJavaTypeName(final DataTypeRef typeRef, final boolean optionalField) {
    DataType _type = typeRef.getType();
    Object _qualifiedJavaTypeName = this.toQualifiedJavaTypeName(_type, optionalField);
    return _qualifiedJavaTypeName;
  }
  
  protected Object _toJavaTypeName(final VersionedTypeRef typeRef, final boolean optionalField) {
    VersionedType _type = typeRef.getType();
    Object _qualifiedJavaTypeName = this.toQualifiedJavaTypeName(_type, optionalField);
    return _qualifiedJavaTypeName;
  }
  
  /**
   * returns the Java type name of the property's type
   */
  public Object toJavaTypeName(final Property property) {
    TypeRef _type = property.getType();
    boolean _isOptional = property.isOptional();
    Object _javaTypeName = this.toJavaTypeName(_type, _isOptional);
    return _javaTypeName;
  }
  
  public Object toQualifiedJavaTypeName(final EObject type, final boolean optionalField) {
    if (type instanceof DataType) {
      return _toQualifiedJavaTypeName((DataType)type, optionalField);
    } else if (type instanceof DataTypeRef) {
      return _toQualifiedJavaTypeName((DataTypeRef)type, optionalField);
    } else if (type instanceof VersionedType) {
      return _toQualifiedJavaTypeName((VersionedType)type, optionalField);
    } else if (type instanceof VersionedTypeRef) {
      return _toQualifiedJavaTypeName((VersionedTypeRef)type, optionalField);
    } else if (type instanceof Type) {
      return _toQualifiedJavaTypeName((Type)type, optionalField);
    } else if (type instanceof TypeRef) {
      return _toQualifiedJavaTypeName((TypeRef)type, optionalField);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(type, optionalField).toString());
    }
  }
  
  public Object toJavaTypeName(final EObject type, final boolean optionalField) {
    if (type instanceof DataType) {
      return _toJavaTypeName((DataType)type, optionalField);
    } else if (type instanceof DataTypeRef) {
      return _toJavaTypeName((DataTypeRef)type, optionalField);
    } else if (type instanceof VersionedType) {
      return _toJavaTypeName((VersionedType)type, optionalField);
    } else if (type instanceof VersionedTypeRef) {
      return _toJavaTypeName((VersionedTypeRef)type, optionalField);
    } else if (type instanceof Type) {
      return _toJavaTypeName((Type)type, optionalField);
    } else if (type instanceof TypeRef) {
      return _toJavaTypeName((TypeRef)type, optionalField);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(type, optionalField).toString());
    }
  }
}
