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
import org.fornax.soa.serviceDsl.SubNamespace;
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
  
  @Inject
  private IEObjectLookup objLookup;
  
  /**
   * Returns the fully qualified java class name for a Type.
   */
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
  
  public String toJaxWsTypeName(final Service service, final boolean optionalField) {
    String _name = service.getName();
    return _name;
  }
  
  public String toJaxWsTypeName(final org.fornax.soa.serviceDsl.Exception exception, final boolean optionalField) {
    String _name = exception.getName();
    return _name;
  }
  
  public String toJaxWsTypeName(final ExceptionRef exRef, final boolean optionalField) {
    org.fornax.soa.serviceDsl.Exception _exception = exRef.getException();
    String _jaxWsTypeName = this.toJaxWsTypeName(_exception, optionalField);
    return _jaxWsTypeName;
  }
  
  /**
   * Get the qualified class name
   */
  public String toJaxWsRequestTypeName(final Operation operation, final boolean optionalField) {
    String _name = operation.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    return _firstUpper;
  }
  
  public String toJaxWsResponseTypeName(final Operation operation, final boolean optionalField) {
    String _name = operation.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    String _plus = (_firstUpper + "Response");
    return _plus;
  }
  
  /**
   * Get the qualified class name
   */
  public String toQualifiedJaxWsRequestTypeName(final Operation operation, final boolean optionalField) {
    String _xblockexpression = null;
    {
      final Service service = this.objLookup.<Service>getOwnerByType(operation, Service.class);
      QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(service);
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
      String _name_1 = operation.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name_1);
      String _plus_5 = (_plus_4 + _firstUpper);
      _xblockexpression = (_plus_5);
    }
    return _xblockexpression;
  }
  
  public String toQualifiedJaxWsResponseTypeName(final Operation operation, final boolean optionalField) {
    String _xblockexpression = null;
    {
      final Service service = this.objLookup.<Service>getOwnerByType(operation, Service.class);
      final SubNamespace namespace = this.objLookup.<SubNamespace>getOwnerByType(operation, SubNamespace.class);
      QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(namespace);
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
      String _name_1 = operation.getName();
      String _firstUpper = StringExtensions.toFirstUpper(_name_1);
      String _plus_5 = (_plus_4 + _firstUpper);
      String _plus_6 = (_plus_5 + "Response");
      _xblockexpression = (_plus_6);
    }
    return _xblockexpression;
  }
}
