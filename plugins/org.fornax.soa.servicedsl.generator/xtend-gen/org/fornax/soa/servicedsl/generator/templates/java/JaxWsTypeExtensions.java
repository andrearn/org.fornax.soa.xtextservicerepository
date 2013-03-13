package org.fornax.soa.servicedsl.generator.templates.java;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.mwe2.language.scoping.QualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.search.IEObjectLookup;
import org.fornax.soa.serviceDsl.ExceptionRef;
import org.fornax.soa.serviceDsl.Operation;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.Type;
import org.fornax.soa.serviceDsl.VersionedType;
import org.fornax.soa.servicedsl.generator.templates.java.JavaTypeExtensions;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions;

@SuppressWarnings("all")
public class JaxWsTypeExtensions {
  @Inject
  private SchemaNamespaceExtensions _schemaNamespaceExtensions;
  
  @Inject
  private JavaTypeExtensions _javaTypeExtensions;
  
  @Inject
  private QualifiedNameProvider nameProvider;
  
  @Inject
  private JavaTypeExtensions javaTypeExt;
  
  @Inject
  private IEObjectLookup objLookup;
  
  /**
   * Returns the fully qualified JAX-WS-style java class name for a Service.
   */
  public String toJaxWsQualifiedTypeName(final Service service) {
    String _jaxWsServicePackageName = this.toJaxWsServicePackageName(service);
    String _plus = (_jaxWsServicePackageName + ".");
    String _name = service.getName();
    String _plus_1 = (_plus + _name);
    return _plus_1;
  }
  
  /**
   * Returns the fully qualified JAX-WS-style java class name for an Exception.
   */
  public String toJaxWsQualifiedTypeName(final org.fornax.soa.serviceDsl.Exception exception, final Operation throwingOperation) {
    String _xblockexpression = null;
    {
      EObject _eContainer = throwingOperation.eContainer();
      final Service service = ((Service) _eContainer);
      String _jaxWsServicePackageName = this.toJaxWsServicePackageName(service);
      String _plus = (_jaxWsServicePackageName + ".");
      String _name = exception.getName();
      String _plus_1 = (_plus + _name);
      _xblockexpression = (_plus_1);
    }
    return _xblockexpression;
  }
  
  /**
   * Returns the simple JAX-WS-style java class name for a Service.
   */
  public String toJaxWsTypeName(final Service service, final boolean optionalField) {
    String _name = service.getName();
    return _name;
  }
  
  /**
   * Returns the simple JAX-WS-style java class name for an Exception.
   */
  public String toJaxWsTypeName(final org.fornax.soa.serviceDsl.Exception exception) {
    String _name = exception.getName();
    return _name;
  }
  
  /**
   * Returns the simple JAX-WS-style java class name for the Exception referenced by an ExceptionRef .
   */
  public String toJaxWsTypeName(final ExceptionRef exRef) {
    org.fornax.soa.serviceDsl.Exception _exception = exRef.getException();
    String _jaxWsTypeName = this.toJaxWsTypeName(_exception);
    return _jaxWsTypeName;
  }
  
  /**
   * Get the simple class name JAX-WS-style operation request parameter wrapper type
   */
  public String toJaxWsOperationRequestTypeName(final Operation operation) {
    String _name = operation.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    return _firstUpper;
  }
  
  /**
   * Get the simple class name JAX-WS-style operation response parameter wrapper type
   */
  public String toJaxWsOperationResponseTypeName(final Operation operation) {
    String _name = operation.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    String _plus = (_firstUpper + "Response");
    return _plus;
  }
  
  /**
   * Get the fully qualified class name JAX-WS-style operation request parameter wrapper type
   */
  public String toJaxWsQualifiedOperationRequestTypeName(final Operation operation) {
    String _xblockexpression = null;
    {
      final Service service = this.objLookup.<Service>getOwnerByType(operation, Service.class);
      String _jaxWsServicePackageName = this.toJaxWsServicePackageName(service);
      String _plus = (_jaxWsServicePackageName + ".");
      String _name = operation.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name);
      String _plus_1 = (_plus + _firstUpper);
      _xblockexpression = (_plus_1);
    }
    return _xblockexpression;
  }
  
  /**
   * Get the fully qualified class name JAX-WS-style operation response parameter wrapper type
   */
  public String toJaxWsQualifiedOperationResponseTypeName(final Operation operation) {
    String _xblockexpression = null;
    {
      final Service service = this.objLookup.<Service>getOwnerByType(operation, Service.class);
      String _jaxWsServicePackageName = this.toJaxWsServicePackageName(service);
      String _plus = (_jaxWsServicePackageName + ".");
      String _name = operation.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name);
      String _plus_1 = (_plus + _firstUpper);
      String _plus_2 = (_plus_1 + "Response");
      _xblockexpression = (_plus_2);
    }
    return _xblockexpression;
  }
  
  public String toJaxWsQualifiedExceptionTypeName(final ExceptionRef exRef) {
    String _jaxWsServiceExceptionPackageName = this.toJaxWsServiceExceptionPackageName(exRef);
    String _plus = (_jaxWsServiceExceptionPackageName + ".");
    org.fornax.soa.serviceDsl.Exception _exception = exRef.getException();
    String _jaxWsTypeName = this.toJaxWsTypeName(_exception);
    String _plus_1 = (_plus + _jaxWsTypeName);
    return _plus_1;
  }
  
  /**
   * Get the JAX-WS-style Java package name of a Service
   */
  public String toJaxWsServicePackageName(final Service service) {
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
    return _plus_3;
  }
  
  /**
   * Get the JAX-WS-style Java package name of a Service Operation
   */
  public String toJaxWsServiceOperationPackageName(final Operation operation) {
    final Service service = this.objLookup.<Service>getOwnerByType(operation, Service.class);
    boolean _notEquals = (!Objects.equal(service, null));
    if (_notEquals) {
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
      return (_plus_2 + _versionPostfix);
    } else {
      return null;
    }
  }
  
  /**
   * Get the JAX-WS-style Java package name of a Service Exception
   */
  public String toJaxWsServiceExceptionPackageName(final ExceptionRef exceptionRef) {
    final Service service = this.objLookup.<Service>getOwnerByType(exceptionRef, Service.class);
    boolean _notEquals = (!Objects.equal(service, null));
    if (_notEquals) {
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
      return (_plus_2 + _versionPostfix);
    } else {
      return null;
    }
  }
  
  public String toJaxWsOperationRequestJavaFileName(final Operation operation) {
    String _jaxWsQualifiedOperationRequestTypeName = this.toJaxWsQualifiedOperationRequestTypeName(operation);
    String _javaFileName = this._javaTypeExtensions.toJavaFileName(_jaxWsQualifiedOperationRequestTypeName);
    return _javaFileName;
  }
  
  public String toJaxWsOperationResponseJavaFileName(final Operation operation) {
    String _jaxWsQualifiedOperationResponseTypeName = this.toJaxWsQualifiedOperationResponseTypeName(operation);
    String _javaFileName = this._javaTypeExtensions.toJavaFileName(_jaxWsQualifiedOperationResponseTypeName);
    return _javaFileName;
  }
  
  public String toJaxWsJavaFileName(final Service service) {
    String _jaxWsQualifiedTypeName = this.toJaxWsQualifiedTypeName(service);
    String _javaFileName = this._javaTypeExtensions.toJavaFileName(_jaxWsQualifiedTypeName);
    return _javaFileName;
  }
  
  public String toJaxWsJavaFileName(final Type type) {
    return null;
  }
  
  public String toJaxWsJavaFileName(final VersionedType type) {
    String _qualifiedJavaTypeName = this._javaTypeExtensions.toQualifiedJavaTypeName(type);
    String _javaFileName = this._javaTypeExtensions.toJavaFileName(_qualifiedJavaTypeName);
    return _javaFileName;
  }
  
  public String toJaxWsServiceExceptionJavaFileName(final ExceptionRef exceptionRef) {
    String _xblockexpression = null;
    {
      final Operation throwingOperation = this.objLookup.<Operation>getOwnerByType(exceptionRef, Operation.class);
      org.fornax.soa.serviceDsl.Exception _exception = exceptionRef.getException();
      String _jaxWsServiceExceptionJavaFileName = this.toJaxWsServiceExceptionJavaFileName(_exception, throwingOperation);
      _xblockexpression = (_jaxWsServiceExceptionJavaFileName);
    }
    return _xblockexpression;
  }
  
  private String toJaxWsServiceExceptionJavaFileName(final org.fornax.soa.serviceDsl.Exception exception, final Operation throwingOperation) {
    String _jaxWsQualifiedTypeName = this.toJaxWsQualifiedTypeName(exception, throwingOperation);
    String _javaFileName = this._javaTypeExtensions.toJavaFileName(_jaxWsQualifiedTypeName);
    return _javaFileName;
  }
}
