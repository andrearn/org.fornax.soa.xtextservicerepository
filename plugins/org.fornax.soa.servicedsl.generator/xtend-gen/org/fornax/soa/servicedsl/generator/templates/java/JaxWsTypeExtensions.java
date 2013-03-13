package org.fornax.soa.servicedsl.generator.templates.java;

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
  public String toJaxWsRequestTypeName(final Operation operation) {
    String _name = operation.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    return _firstUpper;
  }
  
  /**
   * Get the simple class name JAX-WS-style operation response parameter wrapper type
   */
  public String toJaxWsResponseTypeName(final Operation operation) {
    String _name = operation.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    String _plus = (_firstUpper + "Response");
    return _plus;
  }
  
  /**
   * Get the fully qualified class name JAX-WS-style operation request parameter wrapper type
   */
  public String toJaxWsQualifiedRequestTypeName(final Operation operation) {
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
  public String toJaxWsQualifiedResponseTypeName(final Operation operation) {
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
  
  /**
   * Get the Java package name of a Service
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
  
  public String toJaxWsRequestJavaFileName(final Operation operation) {
    String _jaxWsQualifiedRequestTypeName = this.toJaxWsQualifiedRequestTypeName(operation);
    String _javaFileName = this._javaTypeExtensions.toJavaFileName(_jaxWsQualifiedRequestTypeName);
    return _javaFileName;
  }
  
  public String toJaxWsResponseJavaFileName(final Operation operation) {
    String _jaxWsQualifiedResponseTypeName = this.toJaxWsQualifiedResponseTypeName(operation);
    String _javaFileName = this._javaTypeExtensions.toJavaFileName(_jaxWsQualifiedResponseTypeName);
    return _javaFileName;
  }
  
  public String toJaxWsJavaFileName(final org.fornax.soa.serviceDsl.Exception exception, final Operation throwingOperation) {
    String _jaxWsQualifiedTypeName = this.toJaxWsQualifiedTypeName(exception, throwingOperation);
    String _javaFileName = this._javaTypeExtensions.toJavaFileName(_jaxWsQualifiedTypeName);
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
}
