package org.fornax.soa.servicedsl.generator.templates.java;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe2.language.scoping.QualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.profiledsl.sOAProfileDsl.DataType;
import org.fornax.soa.serviceDsl.DataTypeRef;
import org.fornax.soa.serviceDsl.ExceptionRef;
import org.fornax.soa.serviceDsl.Operation;
import org.fornax.soa.serviceDsl.Property;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.Type;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.serviceDsl.VersionedType;
import org.fornax.soa.serviceDsl.VersionedTypeRef;
import org.fornax.soa.servicedsl.generator.templates.java.JavaTypeExtensions;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions;

@SuppressWarnings("all")
public class JaxWsTypeExtensions {
  @Inject
  private QualifiedNameProvider nameProvider;
  
  @Inject
  private SchemaNamespaceExtensions _schemaNamespaceExtensions;
  
  @Inject
  private JavaTypeExtensions javaTypeExt;
  
  /**
   * Returns the fully qualified java class name for a Type.
   */
  protected Object _toQualifiedJaxWsTypeName(final Type type, final boolean optionalField) {
    return null;
  }
  
  protected Object _toQualifiedJaxWsTypeName(final DataType type, final boolean optionalField) {
    String _qualifiedJavaTypeName = this.javaTypeExt.toQualifiedJavaTypeName(type, optionalField);
    return _qualifiedJavaTypeName;
  }
  
  protected Object _toQualifiedJaxWsTypeName(final VersionedType type, final boolean optionalField) {
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
  
  public String toQualifiedJaxWsTypeName(final Service service, final boolean optionalField) {
    EObject _eContainer = service.eContainer();
    QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(_eContainer);
    String _string = _fullyQualifiedName.toString();
    String _plus = (_string + ".");
    String _name = service.getName();
    String _lowerCase = _name.toLowerCase();
    String _plus_1 = (_plus + _lowerCase);
    String _plus_2 = (_plus_1 + ".");
    Version _version = service.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_3 = (_plus_2 + _versionPostfix);
    String _plus_4 = (_plus_3 + ".");
    String _name_1 = service.getName();
    String _plus_5 = (_plus_4 + _name_1);
    return _plus_5;
  }
  
  public String toQualifiedJaxWsTypeName(final org.fornax.soa.serviceDsl.Exception exception, final Operation throwingOperation, final boolean optionalField) {
    String _xblockexpression = null;
    {
      EObject _eContainer = throwingOperation.eContainer();
      final Service service = ((Service) _eContainer);
      EObject _eContainer_1 = exception.eContainer();
      QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(_eContainer_1);
      String _string = _fullyQualifiedName.toString();
      String _plus = (_string + ".");
      String _name = service.getName();
      String _lowerCase = _name.toLowerCase();
      String _plus_1 = (_plus + _lowerCase);
      String _plus_2 = (_plus_1 + ".");
      Version _version = exception.getVersion();
      String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
      String _plus_3 = (_plus_2 + _versionPostfix);
      String _plus_4 = (_plus_3 + ".");
      String _name_1 = exception.getName();
      String _plus_5 = (_plus_4 + _name_1);
      _xblockexpression = (_plus_5);
    }
    return _xblockexpression;
  }
  
  protected Object _toQualifiedJavaTypeName(final TypeRef typeRef, final boolean optionalField) {
    return null;
  }
  
  protected Object _toQualifiedJaxWsTypeName(final DataTypeRef typeRef, final boolean optionalField) {
    DataType _type = typeRef.getType();
    Object _qualifiedJaxWsTypeName = this.toQualifiedJaxWsTypeName(_type, optionalField);
    return _qualifiedJaxWsTypeName;
  }
  
  protected Object _toQualifiedJaxWsTypeName(final VersionedTypeRef typeRef, final boolean optionalField) {
    VersionedType _type = typeRef.getType();
    Object _qualifiedJaxWsTypeName = this.toQualifiedJaxWsTypeName(_type, optionalField);
    return _qualifiedJaxWsTypeName;
  }
  
  public String toQualifiedJaxWsTypeName(final ExceptionRef exRef, final boolean optionalField) {
    org.fornax.soa.serviceDsl.Exception _exception = exRef.getException();
    EObject _eContainer = exRef.eContainer();
    String _qualifiedJaxWsTypeName = this.toQualifiedJaxWsTypeName(_exception, ((Operation) _eContainer), optionalField);
    return _qualifiedJaxWsTypeName;
  }
  
  /**
   * returns the Java type name of the property's type
   */
  public Object toQualifiedJaxWsTypeName(final Property property) {
    TypeRef _type = property.getType();
    boolean _isOptional = property.isOptional();
    Object _qualifiedJavaTypeName = this.toQualifiedJavaTypeName(_type, _isOptional);
    return _qualifiedJavaTypeName;
  }
  
  /**
   * Returns the Java class name for a Type.
   */
  protected Object _toJaxWsTypeName(final Type type, final boolean optionalField) {
    return null;
  }
  
  protected Object _toJaxWsTypeName(final DataType type, final boolean optionalField) {
    String _javaTypeName = this.javaTypeExt.toJavaTypeName(type, optionalField);
    return _javaTypeName;
  }
  
  protected Object _toJaxWsTypeName(final VersionedType type, final boolean optionalField) {
    String _name = type.getName();
    return _name;
  }
  
  public String toJaxWsTypeName(final Service service, final boolean optionalField) {
    String _name = service.getName();
    return _name;
  }
  
  public String toJaxWsTypeName(final org.fornax.soa.serviceDsl.Exception exception, final boolean optionalField) {
    String _name = exception.getName();
    return _name;
  }
  
  protected Object _toJaxWsTypeName(final TypeRef typeRef, final boolean optionalField) {
    return null;
  }
  
  protected Object _toJaxWsTypeName(final DataTypeRef typeRef, final boolean optionalField) {
    DataType _type = typeRef.getType();
    Object _jaxWsTypeName = this.toJaxWsTypeName(_type, optionalField);
    return _jaxWsTypeName;
  }
  
  protected Object _toJaxWsTypeName(final VersionedTypeRef typeRef, final boolean optionalField) {
    VersionedType _type = typeRef.getType();
    Object _jaxWsTypeName = this.toJaxWsTypeName(_type, optionalField);
    return _jaxWsTypeName;
  }
  
  public String toJaxWsTypeName(final ExceptionRef exRef, final boolean optionalField) {
    org.fornax.soa.serviceDsl.Exception _exception = exRef.getException();
    String _jaxWsTypeName = this.toJaxWsTypeName(_exception, optionalField);
    return _jaxWsTypeName;
  }
  
  /**
   * returns the Java type name of the property's type
   */
  public Object toJavaTypeName(final Property property) {
    TypeRef _type = property.getType();
    boolean _isOptional = property.isOptional();
    Object _jaxWsTypeName = this.toJaxWsTypeName(_type, _isOptional);
    return _jaxWsTypeName;
  }
  
  public Object toQualifiedJaxWsTypeName(final EObject typeRef, final boolean optionalField) {
    if (typeRef instanceof VersionedTypeRef) {
      return _toQualifiedJaxWsTypeName((VersionedTypeRef)typeRef, optionalField);
    } else if (typeRef instanceof DataType) {
      return _toQualifiedJaxWsTypeName((DataType)typeRef, optionalField);
    } else if (typeRef instanceof DataTypeRef) {
      return _toQualifiedJaxWsTypeName((DataTypeRef)typeRef, optionalField);
    } else if (typeRef instanceof VersionedType) {
      return _toQualifiedJaxWsTypeName((VersionedType)typeRef, optionalField);
    } else if (typeRef instanceof Type) {
      return _toQualifiedJaxWsTypeName((Type)typeRef, optionalField);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(typeRef, optionalField).toString());
    }
  }
  
  public Object toQualifiedJavaTypeName(final TypeRef typeRef, final boolean optionalField) {
    {
      return _toQualifiedJavaTypeName(typeRef, optionalField);
    }
  }
  
  public Object toJaxWsTypeName(final EObject typeRef, final boolean optionalField) {
    if (typeRef instanceof VersionedTypeRef) {
      return _toJaxWsTypeName((VersionedTypeRef)typeRef, optionalField);
    } else if (typeRef instanceof DataType) {
      return _toJaxWsTypeName((DataType)typeRef, optionalField);
    } else if (typeRef instanceof DataTypeRef) {
      return _toJaxWsTypeName((DataTypeRef)typeRef, optionalField);
    } else if (typeRef instanceof VersionedType) {
      return _toJaxWsTypeName((VersionedType)typeRef, optionalField);
    } else if (typeRef instanceof Type) {
      return _toJaxWsTypeName((Type)typeRef, optionalField);
    } else if (typeRef instanceof TypeRef) {
      return _toJaxWsTypeName((TypeRef)typeRef, optionalField);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(typeRef, optionalField).toString());
    }
  }
}
