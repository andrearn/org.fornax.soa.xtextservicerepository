package org.fornax.soa.servicedsl.generator.templates.java;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe2.language.scoping.QualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.profiledsl.sOAProfileDsl.ClassRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.DataType;
import org.fornax.soa.serviceDsl.DataTypeRef;
import org.fornax.soa.serviceDsl.ExceptionRef;
import org.fornax.soa.serviceDsl.Property;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.Type;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.serviceDsl.VersionedType;
import org.fornax.soa.serviceDsl.VersionedTypeRef;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions;

/**
 * Derive Java class names from types and type references
 */
@SuppressWarnings("all")
public class JavaTypeExtensions {
  @Inject
  private QualifiedNameProvider nameProvider;
  
  @Inject
  private SchemaNamespaceExtensions _schemaNamespaceExtensions;
  
  /**
   * Returns the fully qualified java class name for a Type.
   */
  protected String _toQualifiedJavaTypeName(final Type type) {
    return null;
  }
  
  protected String _toQualifiedJavaTypeName(final Type type, final boolean optionalField) {
    return null;
  }
  
  /**
   * Returns the fully qualified java class name for a Type.
   */
  protected String _toQualifiedJavaTypeName(final DataType type, final boolean optionalField) {
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
        if (optionalField) {
          return "Byte[]";
        } else {
          return "byte[]";
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"base64Binary")) {
        _matched=true;
        if (optionalField) {
          return "Byte[]";
        } else {
          return "byte[]";
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
      if (optionalField) {
        return "Void";
      } else {
        return "void";
      }
    }
    return _switchResult;
  }
  
  /**
   * Returns the fully qualified java class name for a Type.
   */
  protected String _toQualifiedJavaTypeName(final VersionedType type) {
    EObject _eContainer = type.eContainer();
    QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(_eContainer);
    String _string = _fullyQualifiedName.toString();
    String _plus = (_string + ".");
    Version _version = type.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_1 = (_plus + _versionPostfix);
    String _plus_2 = (_plus_1 + ".");
    String _name = type.getName();
    String _plus_3 = (_plus_2 + _name);
    return _plus_3;
  }
  
  /**
   * Returns the fully qualified java class name for a Type.
   */
  protected String _toQualifiedJavaTypeName(final Service service) {
    EObject _eContainer = service.eContainer();
    QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(_eContainer);
    String _string = _fullyQualifiedName.toString();
    String _plus = (_string + ".");
    Version _version = service.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_1 = (_plus + _versionPostfix);
    String _plus_2 = (_plus_1 + ".");
    String _name = service.getName();
    String _plus_3 = (_plus_2 + _name);
    return _plus_3;
  }
  
  /**
   * Returns the fully qualified java class name for a Type.
   */
  protected String _toQualifiedJavaTypeName(final org.fornax.soa.serviceDsl.Exception exception) {
    EObject _eContainer = exception.eContainer();
    QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(_eContainer);
    String _string = _fullyQualifiedName.toString();
    String _plus = (_string + ".");
    Version _version = exception.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_1 = (_plus + _versionPostfix);
    String _plus_2 = (_plus_1 + ".");
    String _name = exception.getName();
    String _plus_3 = (_plus_2 + _name);
    return _plus_3;
  }
  
  /**
   * Get the full qualified of the Java type derived from the Service DSL type reference
   */
  protected String _toQualifiedJavaTypeName(final TypeRef typeRef, final boolean optionalField) {
    return null;
  }
  
  /**
   * Get the full qualified of the Java type derived from the Service DSL type reference
   */
  protected String _toQualifiedJavaTypeName(final DataTypeRef typeRef, final boolean optionalField) {
    String _xifexpression = null;
    boolean _isMany = typeRef.isMany();
    if (_isMany) {
      boolean _isSet = typeRef.isSet();
      if (_isSet) {
        DataType _type = typeRef.getType();
        String _qualifiedJavaTypeName = this.toQualifiedJavaTypeName(_type, true);
        String _plus = ("Set<" + _qualifiedJavaTypeName);
        return (_plus + ">");
      } else {
        DataType _type_1 = typeRef.getType();
        String _qualifiedJavaTypeName_1 = this.toQualifiedJavaTypeName(_type_1, true);
        String _plus_1 = ("List<" + _qualifiedJavaTypeName_1);
        return (_plus_1 + ">");
      }
    } else {
      DataType _type_2 = typeRef.getType();
      String _qualifiedJavaTypeName_2 = this.toQualifiedJavaTypeName(_type_2, optionalField);
      _xifexpression = _qualifiedJavaTypeName_2;
    }
    return _xifexpression;
  }
  
  /**
   * Get the full qualified of the Java type derived from the Service DSL type reference
   */
  protected String _toQualifiedJavaTypeName(final VersionedTypeRef typeRef, final boolean optionalField) {
    String _xifexpression = null;
    boolean _isMany = typeRef.isMany();
    if (_isMany) {
      boolean _isSet = typeRef.isSet();
      if (_isSet) {
        VersionedType _type = typeRef.getType();
        String _qualifiedJavaTypeName = this.toQualifiedJavaTypeName(_type, true);
        String _plus = ("Set<" + _qualifiedJavaTypeName);
        return (_plus + ">");
      } else {
        VersionedType _type_1 = typeRef.getType();
        String _qualifiedJavaTypeName_1 = this.toQualifiedJavaTypeName(_type_1, true);
        String _plus_1 = ("List<" + _qualifiedJavaTypeName_1);
        return (_plus_1 + ">");
      }
    } else {
      VersionedType _type_2 = typeRef.getType();
      String _qualifiedJavaTypeName_2 = this.toQualifiedJavaTypeName(_type_2, optionalField);
      _xifexpression = _qualifiedJavaTypeName_2;
    }
    return _xifexpression;
  }
  
  /**
   * Get the full qualified of the Java type derived from the Service DSL type reference
   */
  protected String _toQualifiedJavaTypeName(final ExceptionRef exRef, final boolean optionalField) {
    org.fornax.soa.serviceDsl.Exception _exception = exRef.getException();
    String _qualifiedJavaTypeName = this.toQualifiedJavaTypeName(_exception, optionalField);
    return _qualifiedJavaTypeName;
  }
  
  /**
   * returns the Java type name of the property's type
   */
  protected String _toQualifiedJavaTypeName(final Property property) {
    TypeRef _type = property.getType();
    boolean _isOptional = property.isOptional();
    String _qualifiedJavaTypeName = this.toQualifiedJavaTypeName(_type, _isOptional);
    return _qualifiedJavaTypeName;
  }
  
  /**
   * Returns the Java class name for a Type.
   */
  protected String _toJavaTypeName(final Type type, final boolean optionalField) {
    return null;
  }
  
  /**
   * Returns the Java class name for a Type.
   */
  protected String _toJavaTypeName(final DataType type, final boolean optionalField) {
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
        if (optionalField) {
          return "Byte[]";
        } else {
          return "byte[]";
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"base64Binary")) {
        _matched=true;
        if (optionalField) {
          return "Byte[]";
        } else {
          return "byte[]";
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
      if (optionalField) {
        return "Void";
      } else {
        return "void";
      }
    }
    return _switchResult;
  }
  
  /**
   * Returns the Java class name for a Type.
   */
  protected String _toJavaTypeName(final VersionedType type, final boolean optionalField) {
    String _name = type.getName();
    return _name;
  }
  
  /**
   * Returns the Java class name for a Type.
   */
  protected String _toJavaTypeName(final TypeRef typeRef, final boolean optionalField) {
    return null;
  }
  
  /**
   * Returns the Java class name for a Type.
   */
  protected String _toJavaTypeName(final DataTypeRef typeRef, final boolean optionalField) {
    boolean _isMany = typeRef.isMany();
    if (_isMany) {
      boolean _isSet = typeRef.isSet();
      if (_isSet) {
        DataType _type = typeRef.getType();
        String _javaTypeName = this.toJavaTypeName(_type, true);
        String _plus = ("Set<" + _javaTypeName);
        return (_plus + ">");
      } else {
        DataType _type_1 = typeRef.getType();
        String _javaTypeName_1 = this.toJavaTypeName(_type_1, true);
        String _plus_1 = ("List<" + _javaTypeName_1);
        return (_plus_1 + ">");
      }
    } else {
      DataType _type_2 = typeRef.getType();
      return this.toJavaTypeName(_type_2, optionalField);
    }
  }
  
  /**
   * Returns the Java class name for a Type.
   */
  protected String _toJavaTypeName(final VersionedTypeRef typeRef, final boolean optionalField) {
    boolean _isMany = typeRef.isMany();
    if (_isMany) {
      boolean _isSet = typeRef.isSet();
      if (_isSet) {
        VersionedType _type = typeRef.getType();
        String _javaTypeName = this.toJavaTypeName(_type, true);
        String _plus = ("Set<" + _javaTypeName);
        return (_plus + ">");
      } else {
        VersionedType _type_1 = typeRef.getType();
        String _javaTypeName_1 = this.toJavaTypeName(_type_1, true);
        String _plus_1 = ("List<" + _javaTypeName_1);
        return (_plus_1 + ">");
      }
    } else {
      VersionedType _type_2 = typeRef.getType();
      return this.toJavaTypeName(_type_2, optionalField);
    }
  }
  
  /**
   * Returns the Java class name for a Type.
   */
  protected String _toJavaTypeName(final Service service, final boolean optionalField) {
    String _name = service.getName();
    return _name;
  }
  
  /**
   * Returns the Java class name for a Type.
   */
  protected String _toJavaTypeName(final org.fornax.soa.serviceDsl.Exception exception, final boolean optionalField) {
    String _name = exception.getName();
    return _name;
  }
  
  /**
   * Returns the Java class name of an implementation class of the collection class of a many TypeRef.
   */
  protected String _toImplJavaTypeName(final TypeRef typeRef, final boolean optionalField) {
    return null;
  }
  
  /**
   * Returns the Java class name of an implementation class of the collection class of a many TypeRef.
   */
  protected String _toImplJavaTypeName(final DataTypeRef typeRef, final boolean optionalField) {
    boolean _isMany = typeRef.isMany();
    if (_isMany) {
      boolean _isSet = typeRef.isSet();
      if (_isSet) {
        DataType _type = typeRef.getType();
        String _javaTypeName = this.toJavaTypeName(_type, true);
        String _plus = ("HashSet<" + _javaTypeName);
        return (_plus + ">");
      } else {
        DataType _type_1 = typeRef.getType();
        String _javaTypeName_1 = this.toJavaTypeName(_type_1, true);
        String _plus_1 = ("ArrayList<" + _javaTypeName_1);
        return (_plus_1 + ">");
      }
    } else {
      DataType _type_2 = typeRef.getType();
      return this.toJavaTypeName(_type_2, optionalField);
    }
  }
  
  /**
   * Returns the Java class name of an implementation class of the collection class of a many TypeRef.
   */
  protected String _toImplJavaTypeName(final VersionedTypeRef typeRef, final boolean optionalField) {
    boolean _isMany = typeRef.isMany();
    if (_isMany) {
      boolean _isSet = typeRef.isSet();
      if (_isSet) {
        VersionedType _type = typeRef.getType();
        String _javaTypeName = this.toJavaTypeName(_type, true);
        String _plus = ("HashSet<" + _javaTypeName);
        return (_plus + ">");
      } else {
        VersionedType _type_1 = typeRef.getType();
        String _javaTypeName_1 = this.toJavaTypeName(_type_1, true);
        String _plus_1 = ("ArrayList<" + _javaTypeName_1);
        return (_plus_1 + ">");
      }
    } else {
      VersionedType _type_2 = typeRef.getType();
      return this.toJavaTypeName(_type_2, optionalField);
    }
  }
  
  /**
   * returns the Java type name of the property's type
   */
  public String toJavaTypeName(final Property property) {
    TypeRef _type = property.getType();
    boolean _isOptional = property.isOptional();
    String _javaTypeName = this.toJavaTypeName(_type, _isOptional);
    return _javaTypeName;
  }
  
  protected String _toPackageName(final Type type) {
    return null;
  }
  
  protected String _toPackageName(final VersionedType type) {
    EObject _eContainer = type.eContainer();
    QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(_eContainer);
    String _string = _fullyQualifiedName.toString();
    String _plus = (_string + ".");
    Version _version = type.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_1 = (_plus + _versionPostfix);
    return _plus_1;
  }
  
  protected String _toPackageName(final org.fornax.soa.serviceDsl.Exception exception) {
    EObject _eContainer = exception.eContainer();
    QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(_eContainer);
    String _string = _fullyQualifiedName.toString();
    String _plus = (_string + ".");
    Version _version = exception.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_1 = (_plus + _versionPostfix);
    return _plus_1;
  }
  
  protected String _toPackageName(final org.fornax.soa.profiledsl.sOAProfileDsl.Class type) {
    EObject _eContainer = type.eContainer();
    QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(_eContainer);
    String _string = _fullyQualifiedName.toString();
    String _plus = (_string + ".");
    Version _version = type.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_1 = (_plus + _versionPostfix);
    return _plus_1;
  }
  
  protected String _toPackageName(final TypeRef typeRef) {
    return null;
  }
  
  protected String _toPackageName(final VersionedTypeRef typeRef) {
    VersionedType _type = typeRef.getType();
    String _packageName = this.toPackageName(_type);
    return _packageName;
  }
  
  protected String _toPackageName(final ClassRef typeRef) {
    org.fornax.soa.profiledsl.sOAProfileDsl.Class _type = typeRef.getType();
    String _packageName = this.toPackageName(_type);
    return _packageName;
  }
  
  protected String _toPackageName(final Service svc) {
    EObject _eContainer = svc.eContainer();
    QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(_eContainer);
    String _string = _fullyQualifiedName.toString();
    String _plus = (_string + ".");
    Version _version = svc.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_1 = (_plus + _versionPostfix);
    return _plus_1;
  }
  
  /**
   * Convert a fully qualified class name to the Java file name
   */
  public String toJavaFileName(final String qualifiedClassName) {
    String _replaceAll = qualifiedClassName.replaceAll("\\.", "/");
    String _plus = (_replaceAll + ".java");
    return _plus;
  }
  
  /**
   * Get the java file name of a class representing a Type
   */
  public String toJavaFileName(final Type type) {
    String _qualifiedJavaTypeName = this.toQualifiedJavaTypeName(type, false);
    String _javaFileName = this.toJavaFileName(_qualifiedJavaTypeName);
    return _javaFileName;
  }
  
  /**
   * Get the java file name of a class representing a Service
   */
  public String toJavaFileName(final Service type) {
    String _qualifiedJavaTypeName = this.toQualifiedJavaTypeName(type, false);
    String _javaFileName = this.toJavaFileName(_qualifiedJavaTypeName);
    return _javaFileName;
  }
  
  /**
   * Get the java file name of a class representing the referenced Type
   */
  public String toJavaFileName(final TypeRef typeRef, final boolean isOptional) {
    String _qualifiedJavaTypeName = this.toQualifiedJavaTypeName(typeRef, isOptional);
    String _javaFileName = this.toJavaFileName(_qualifiedJavaTypeName);
    return _javaFileName;
  }
  
  /**
   * Get the java file name of the exception wrapper class representing the referenced Exception
   */
  public String toJavaFileName(final ExceptionRef typeRef) {
    String _qualifiedJavaTypeName = this.toQualifiedJavaTypeName(typeRef, false);
    String _javaFileName = this.toJavaFileName(_qualifiedJavaTypeName);
    return _javaFileName;
  }
  
  public String toQualifiedJavaTypeName(final EObject type) {
    if (type instanceof VersionedType) {
      return _toQualifiedJavaTypeName((VersionedType)type);
    } else if (type instanceof org.fornax.soa.serviceDsl.Exception) {
      return _toQualifiedJavaTypeName((org.fornax.soa.serviceDsl.Exception)type);
    } else if (type instanceof Property) {
      return _toQualifiedJavaTypeName((Property)type);
    } else if (type instanceof Service) {
      return _toQualifiedJavaTypeName((Service)type);
    } else if (type instanceof Type) {
      return _toQualifiedJavaTypeName((Type)type);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(type).toString());
    }
  }
  
  public String toQualifiedJavaTypeName(final EObject typeRef, final boolean optionalField) {
    if (typeRef instanceof VersionedTypeRef) {
      return _toQualifiedJavaTypeName((VersionedTypeRef)typeRef, optionalField);
    } else if (typeRef instanceof DataType) {
      return _toQualifiedJavaTypeName((DataType)typeRef, optionalField);
    } else if (typeRef instanceof DataTypeRef) {
      return _toQualifiedJavaTypeName((DataTypeRef)typeRef, optionalField);
    } else if (typeRef instanceof ExceptionRef) {
      return _toQualifiedJavaTypeName((ExceptionRef)typeRef, optionalField);
    } else if (typeRef instanceof Type) {
      return _toQualifiedJavaTypeName((Type)typeRef, optionalField);
    } else if (typeRef instanceof TypeRef) {
      return _toQualifiedJavaTypeName((TypeRef)typeRef, optionalField);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(typeRef, optionalField).toString());
    }
  }
  
  public String toJavaTypeName(final EObject typeRef, final boolean optionalField) {
    if (typeRef instanceof VersionedTypeRef) {
      return _toJavaTypeName((VersionedTypeRef)typeRef, optionalField);
    } else if (typeRef instanceof DataType) {
      return _toJavaTypeName((DataType)typeRef, optionalField);
    } else if (typeRef instanceof DataTypeRef) {
      return _toJavaTypeName((DataTypeRef)typeRef, optionalField);
    } else if (typeRef instanceof VersionedType) {
      return _toJavaTypeName((VersionedType)typeRef, optionalField);
    } else if (typeRef instanceof org.fornax.soa.serviceDsl.Exception) {
      return _toJavaTypeName((org.fornax.soa.serviceDsl.Exception)typeRef, optionalField);
    } else if (typeRef instanceof Service) {
      return _toJavaTypeName((Service)typeRef, optionalField);
    } else if (typeRef instanceof Type) {
      return _toJavaTypeName((Type)typeRef, optionalField);
    } else if (typeRef instanceof TypeRef) {
      return _toJavaTypeName((TypeRef)typeRef, optionalField);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(typeRef, optionalField).toString());
    }
  }
  
  public String toImplJavaTypeName(final TypeRef typeRef, final boolean optionalField) {
    if (typeRef instanceof VersionedTypeRef) {
      return _toImplJavaTypeName((VersionedTypeRef)typeRef, optionalField);
    } else if (typeRef instanceof DataTypeRef) {
      return _toImplJavaTypeName((DataTypeRef)typeRef, optionalField);
    } else if (typeRef != null) {
      return _toImplJavaTypeName(typeRef, optionalField);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(typeRef, optionalField).toString());
    }
  }
  
  public String toPackageName(final EObject type) {
    if (type instanceof org.fornax.soa.profiledsl.sOAProfileDsl.Class) {
      return _toPackageName((org.fornax.soa.profiledsl.sOAProfileDsl.Class)type);
    } else if (type instanceof VersionedTypeRef) {
      return _toPackageName((VersionedTypeRef)type);
    } else if (type instanceof VersionedType) {
      return _toPackageName((VersionedType)type);
    } else if (type instanceof ClassRef) {
      return _toPackageName((ClassRef)type);
    } else if (type instanceof org.fornax.soa.serviceDsl.Exception) {
      return _toPackageName((org.fornax.soa.serviceDsl.Exception)type);
    } else if (type instanceof Service) {
      return _toPackageName((Service)type);
    } else if (type instanceof Type) {
      return _toPackageName((Type)type);
    } else if (type instanceof TypeRef) {
      return _toPackageName((TypeRef)type);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(type).toString());
    }
  }
}
