package org.fornax.soa.servicedsl.generator.templates.webservice;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.version.VersionQualifierExtensions;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader;
import org.fornax.soa.profiledsl.sOAProfileDsl.Property;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.service.VersionedDomainNamespace;
import org.fornax.soa.service.query.namespace.NamespaceImportQueries;
import org.fornax.soa.service.query.namespace.NamespaceQuery;
import org.fornax.soa.serviceDsl.DomainNamespace;
import org.fornax.soa.serviceDsl.ExceptionRef;
import org.fornax.soa.serviceDsl.InternalNamespace;
import org.fornax.soa.serviceDsl.Operation;
import org.fornax.soa.serviceDsl.Parameter;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.servicedsl.generator.templates.webservice.ServiceTemplateExtensions;
import org.fornax.soa.servicedsl.generator.templates.xsd.OperationWrapperTypesGenerator;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaTypeExtensions;
import org.fornax.soa.servicedsl.generator.templates.xsd.XSDGenerator;

@SuppressWarnings("all")
public class WrappedWsdlGenerator {
  @Inject
  private IFileSystemAccess fsa;
  
  @Inject
  private SchemaNamespaceExtensions _schemaNamespaceExtensions;
  
  @Inject
  private SchemaTypeExtensions _schemaTypeExtensions;
  
  @Inject
  private ServiceTemplateExtensions _serviceTemplateExtensions;
  
  @Inject
  private VersionQualifierExtensions _versionQualifierExtensions;
  
  @Inject
  private NamespaceQuery _namespaceQuery;
  
  @Inject
  private NamespaceImportQueries _namespaceImportQueries;
  
  @Inject
  private XSDGenerator _xSDGenerator;
  
  @Inject
  private OperationWrapperTypesGenerator _operationWrapperTypesGenerator;
  
  @Inject
  private IEObjectDocumentationProvider docProvider;
  
  @Inject
  @Named(value = "noDependencies")
  private Boolean noDependencies;
  
  /**
   * CARTRIDGE ENTRYPOINT for generation of abstract wrapped  WSDLs
   * Abstract WSDLs only define the abstract interface of a service. The binding is declared
   * in a separate WSDL that imports this abstract WSDL
   * 
   * A WSDL for each Service in the given SubNamespace matching the given minimal LifecycleState
   * will be generated. For each major version of a service WSDL is generated for the latest minor
   * version in that major version matching the minimal Lifecycle constraint is be generated
   */
  public void toWrappedWSDL(final Service svc, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(svc);
    this.toWrappedWSDL(svc, _findSubdomain, minState, profile, registryBaseUrl);
  }
  
  protected void _toWrappedWSDL(final Service svc, final SubNamespace subDom, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException();
    throw _unsupportedOperationException;
  }
  
  protected void _toWrappedWSDL(final Service svc, final DomainNamespace subDom, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    EList<Operation> _operations = svc.getOperations();
    final Function1<Operation,EList<ExceptionRef>> _function = new Function1<Operation,EList<ExceptionRef>>() {
        public EList<ExceptionRef> apply(final Operation o) {
          EList<ExceptionRef> _throws = o.getThrows();
          return _throws;
        }
      };
    List<EList<ExceptionRef>> _map = ListExtensions.<Operation, EList<ExceptionRef>>map(_operations, _function);
    final Iterable<ExceptionRef> allServiceExceptionRefs = Iterables.<ExceptionRef>concat(_map);
    this._operationWrapperTypesGenerator.toOperationWrappers(svc, subDom, minState, profile, registryBaseUrl);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    _builder.newLine();
    _builder.append("<wsdl:definitions xmlns:soap=\"http://schemas.xmlsoap.org/wsdl/soap/\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:tns=\"");
    String _wrapperServiceTargetNamespace = this._serviceTemplateExtensions.toWrapperServiceTargetNamespace(svc);
    _builder.append(_wrapperServiceTargetNamespace, "	");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("xmlns:wsdl=\"http://schemas.xmlsoap.org/wsdl/\" ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:jaxws=\"http://java.sun.com/xml/ns/jaxws\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("name=\"");
    String _name = svc.getName();
    _builder.append(_name, "	");
    _builder.append("\" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("targetNamespace=\"");
    String _wrapperServiceTargetNamespace_1 = this._serviceTemplateExtensions.toWrapperServiceTargetNamespace(svc);
    _builder.append(_wrapperServiceTargetNamespace_1, "	");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<wsdl:documentation>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<![CDATA[Version ");
    Version _version = svc.getVersion();
    String _versionNumber = this._versionQualifierExtensions.toVersionNumber(_version);
    _builder.append(_versionNumber, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("Lifecycle state: ");
    LifecycleState _state = svc.getState();
    String _name_1 = _state.getName();
    _builder.append(_name_1, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    String _documentation = this.docProvider.getDocumentation(svc);
    _builder.append(_documentation, "		");
    _builder.append("]]>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</wsdl:documentation>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _types = this.toTypes(svc, minState, profile, registryBaseUrl);
    _builder.append(_types, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    EList<Operation> _operations_1 = svc.getOperations();
    final Function1<Operation,CharSequence> _function_1 = new Function1<Operation,CharSequence>() {
        public CharSequence apply(final Operation o) {
          CharSequence _messages = WrappedWsdlGenerator.this.toMessages(o);
          return _messages;
        }
      };
    List<CharSequence> _map_1 = ListExtensions.<Operation, CharSequence>map(_operations_1, _function_1);
    String _join = IterableExtensions.join(_map_1);
    _builder.append(_join, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    final Function1<ExceptionRef,String> _function_2 = new Function1<ExceptionRef,String>() {
        public String apply(final ExceptionRef r) {
          org.fornax.soa.serviceDsl.Exception _exception = r.getException();
          String _name = _exception.getName();
          return _name;
        }
      };
    Iterable<String> _map_2 = IterableExtensions.<ExceptionRef, String>map(allServiceExceptionRefs, _function_2);
    Set<String> _set = IterableExtensions.<String>toSet(_map_2);
    final Function1<String,CharSequence> _function_3 = new Function1<String,CharSequence>() {
        public CharSequence apply(final String n) {
          List<ExceptionRef> _list = IterableExtensions.<ExceptionRef>toList(allServiceExceptionRefs);
          CharSequence _faultMessages = WrappedWsdlGenerator.this.toFaultMessages(n, _list);
          return _faultMessages;
        }
      };
    Iterable<CharSequence> _map_3 = IterableExtensions.<String, CharSequence>map(_set, _function_3);
    String _join_1 = IterableExtensions.join(_map_3);
    _builder.append(_join_1, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _portType = this.toPortType(svc);
    _builder.append(_portType, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("</wsdl:definitions>");
    _builder.newLine();
    final CharSequence content = _builder;
    final String xsdFileName = this._serviceTemplateExtensions.getWrappedWSDLFileName(svc);
    this.fsa.generateFile(xsdFileName, content);
  }
  
  protected void _toWrappedWSDL(final Service svc, final InternalNamespace subDom, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    EList<Operation> _operations = svc.getOperations();
    final Function1<Operation,EList<ExceptionRef>> _function = new Function1<Operation,EList<ExceptionRef>>() {
        public EList<ExceptionRef> apply(final Operation o) {
          EList<ExceptionRef> _throws = o.getThrows();
          return _throws;
        }
      };
    List<EList<ExceptionRef>> _map = ListExtensions.<Operation, EList<ExceptionRef>>map(_operations, _function);
    final Iterable<ExceptionRef> allServiceExceptionRefs = Iterables.<ExceptionRef>concat(_map);
    this._operationWrapperTypesGenerator.toOperationWrappers(svc, subDom, minState, profile, registryBaseUrl);
    String _fileNameFragment = this._schemaNamespaceExtensions.toFileNameFragment(subDom);
    String _plus = (_fileNameFragment + "-");
    String _name = svc.getName();
    String _plus_1 = (_plus + _name);
    String _plus_2 = (_plus_1 + "-");
    Version _version = svc.getVersion();
    String _versionPostfix = this._versionQualifierExtensions.toVersionPostfix(_version);
    String _plus_3 = (_plus_2 + _versionPostfix);
    final String xsdFileName = (_plus_3 + "Wrapped.wsdl");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    _builder.newLine();
    _builder.append("<wsdl:definitions xmlns:soap=\"http://schemas.xmlsoap.org/wsdl/soap/\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:tns=\"");
    String _wrapperServiceTargetNamespace = this._serviceTemplateExtensions.toWrapperServiceTargetNamespace(svc);
    _builder.append(_wrapperServiceTargetNamespace, "	");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("xmlns:wsdl=\"http://schemas.xmlsoap.org/wsdl/\" ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("name=\"");
    String _name_1 = svc.getName();
    _builder.append(_name_1, "	");
    _builder.append("\" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("targetNamespace=\"");
    String _wrapperServiceTargetNamespace_1 = this._serviceTemplateExtensions.toWrapperServiceTargetNamespace(svc);
    _builder.append(_wrapperServiceTargetNamespace_1, "	");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<wsdl:documentation>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<![CDATA[Version ");
    Version _version_1 = svc.getVersion();
    String _versionNumber = this._versionQualifierExtensions.toVersionNumber(_version_1);
    _builder.append(_versionNumber, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("Lifecycle state: ");
    LifecycleState _state = svc.getState();
    String _name_2 = _state.getName();
    _builder.append(_name_2, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    String _documentation = this.docProvider.getDocumentation(svc);
    _builder.append(_documentation, "		");
    _builder.append("]]>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</wsdl:documentation>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _types = this.toTypes(svc, minState, profile, registryBaseUrl);
    _builder.append(_types, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    EList<Operation> _operations_1 = svc.getOperations();
    final Function1<Operation,CharSequence> _function_1 = new Function1<Operation,CharSequence>() {
        public CharSequence apply(final Operation o) {
          CharSequence _messages = WrappedWsdlGenerator.this.toMessages(o);
          return _messages;
        }
      };
    List<CharSequence> _map_1 = ListExtensions.<Operation, CharSequence>map(_operations_1, _function_1);
    String _join = IterableExtensions.join(_map_1);
    _builder.append(_join, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    final Function1<ExceptionRef,String> _function_2 = new Function1<ExceptionRef,String>() {
        public String apply(final ExceptionRef r) {
          org.fornax.soa.serviceDsl.Exception _exception = r.getException();
          String _name = _exception.getName();
          return _name;
        }
      };
    Iterable<String> _map_2 = IterableExtensions.<ExceptionRef, String>map(allServiceExceptionRefs, _function_2);
    Set<String> _set = IterableExtensions.<String>toSet(_map_2);
    final Function1<String,CharSequence> _function_3 = new Function1<String,CharSequence>() {
        public CharSequence apply(final String n) {
          List<ExceptionRef> _list = IterableExtensions.<ExceptionRef>toList(allServiceExceptionRefs);
          CharSequence _faultMessages = WrappedWsdlGenerator.this.toFaultMessages(n, _list);
          return _faultMessages;
        }
      };
    Iterable<CharSequence> _map_3 = IterableExtensions.<String, CharSequence>map(_set, _function_3);
    String _join_1 = IterableExtensions.join(_map_3);
    _builder.append(_join_1, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _portType = this.toPortType(svc);
    _builder.append(_portType, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("</wsdl:definitions>");
    _builder.newLine();
    final CharSequence content = _builder;
    this.fsa.generateFile(xsdFileName, content);
  }
  
  protected CharSequence toTypes(final Service svc, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<wsdl:types>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<xsd:schema targetNamespace=\"");
    String _wrapperServiceTargetNamespace = this._serviceTemplateExtensions.toWrapperServiceTargetNamespace(svc);
    _builder.append(_wrapperServiceTargetNamespace, "	");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    {
      Version _version = svc.getVersion();
      String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_version);
      Set<VersionedDomainNamespace> _importedVersionedNS = this._namespaceImportQueries.importedVersionedNS(svc, _majorVersionNumber, minState);
      for(final VersionedDomainNamespace imp : _importedVersionedNS) {
        _builder.append("\t\t");
        _builder.append("xmlns:");
        String _prefix = this._schemaNamespaceExtensions.toPrefix(imp);
        String _version_1 = imp.getVersion();
        String _majorVersionNumber_1 = this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
        String _plus = (_prefix + _majorVersionNumber_1);
        _builder.append(_plus, "		");
        _builder.append("=\"");
        String _namespace = this._schemaTypeExtensions.toNamespace(imp);
        _builder.append(_namespace, "		");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("xmlns:svc=\"");
    String _wrapperTargetNamespace = this._serviceTemplateExtensions.toWrapperTargetNamespace(svc);
    _builder.append(_wrapperTargetNamespace, "		");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("elementFormDefault=\"qualified\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("attributeFormDefault=\"unqualified\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(">");
    _builder.newLine();
    {
      Version _version_2 = svc.getVersion();
      String _majorVersionNumber_2 = this._versionQualifierExtensions.toMajorVersionNumber(_version_2);
      Set<VersionedDomainNamespace> _importedVersionedNS_1 = this._namespaceImportQueries.importedVersionedNS(svc, _majorVersionNumber_2, minState);
      for(final VersionedDomainNamespace imp_1 : _importedVersionedNS_1) {
        _builder.append("\t\t");
        _builder.append("<xsd:import schemaLocation=\"");
        String _registryAssetUrl = this._schemaNamespaceExtensions.toRegistryAssetUrl(imp_1, registryBaseUrl);
        _builder.append(_registryAssetUrl, "		");
        _builder.append(".xsd\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("namespace=\"");
        String _namespace_1 = this._schemaTypeExtensions.toNamespace(imp_1);
        _builder.append(_namespace_1, "			");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("<xsd:import schemaLocation=\"");
    String _registeredOperationWrapperUrl = this._serviceTemplateExtensions.getRegisteredOperationWrapperUrl(svc, registryBaseUrl);
    _builder.append(_registeredOperationWrapperUrl, "		");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("namespace=\"");
    String _wrapperTargetNamespace_1 = this._serviceTemplateExtensions.toWrapperTargetNamespace(svc);
    _builder.append(_wrapperTargetNamespace_1, "			");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    EList<Operation> _operations = svc.getOperations();
    final Function1<Operation,CharSequence> _function = new Function1<Operation,CharSequence>() {
        public CharSequence apply(final Operation o) {
          CharSequence _operationWrapperTypes = WrappedWsdlGenerator.this.toOperationWrapperTypes(o, profile);
          return _operationWrapperTypes;
        }
      };
    List<CharSequence> _map = ListExtensions.<Operation, CharSequence>map(_operations, _function);
    String _join = IterableExtensions.join(_map);
    _builder.append(_join, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    EList<Operation> _operations_1 = svc.getOperations();
    final Function1<Operation,EList<ExceptionRef>> _function_1 = new Function1<Operation,EList<ExceptionRef>>() {
        public EList<ExceptionRef> apply(final Operation o) {
          EList<ExceptionRef> _throws = o.getThrows();
          return _throws;
        }
      };
    List<EList<ExceptionRef>> _map_1 = ListExtensions.<Operation, EList<ExceptionRef>>map(_operations_1, _function_1);
    Iterable<ExceptionRef> _flatten = Iterables.<ExceptionRef>concat(_map_1);
    final Function1<ExceptionRef,String> _function_2 = new Function1<ExceptionRef,String>() {
        public String apply(final ExceptionRef t) {
          org.fornax.soa.serviceDsl.Exception _exception = t.getException();
          String _name = _exception.getName();
          return _name;
        }
      };
    Iterable<String> _map_2 = IterableExtensions.<ExceptionRef, String>map(_flatten, _function_2);
    Set<String> _set = IterableExtensions.<String>toSet(_map_2);
    final Function1<String,CharSequence> _function_3 = new Function1<String,CharSequence>() {
        public CharSequence apply(final String n) {
          EList<Operation> _operations = svc.getOperations();
          final Function1<Operation,EList<ExceptionRef>> _function = new Function1<Operation,EList<ExceptionRef>>() {
              public EList<ExceptionRef> apply(final Operation o) {
                EList<ExceptionRef> _throws = o.getThrows();
                return _throws;
              }
            };
          List<EList<ExceptionRef>> _map = ListExtensions.<Operation, EList<ExceptionRef>>map(_operations, _function);
          Iterable<ExceptionRef> _flatten = Iterables.<ExceptionRef>concat(_map);
          List<ExceptionRef> _list = IterableExtensions.<ExceptionRef>toList(_flatten);
          CharSequence _operationFaultWrapperTypes = WrappedWsdlGenerator.this.toOperationFaultWrapperTypes(n, _list);
          return _operationFaultWrapperTypes;
        }
      };
    Iterable<CharSequence> _map_3 = IterableExtensions.<String, CharSequence>map(_set, _function_3);
    String _join_1 = IterableExtensions.join(_map_3);
    _builder.append(_join_1, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</xsd:schema>");
    _builder.newLine();
    _builder.append("</wsdl:types>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence toOperationWrapperTypes(final Operation op, final SOAProfile profile) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<xsd:element name=\"");
    String _name = op.getName();
    _builder.append(_name, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<xsd:complexType>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<xsd:sequence>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<xsd:element name=\"request\" type=\"svc:");
    String _operationWrapperRequestType = this._serviceTemplateExtensions.toOperationWrapperRequestType(op);
    _builder.append(_operationWrapperRequestType, "			");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("</xsd:sequence>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</xsd:complexType>");
    _builder.newLine();
    _builder.append("</xsd:element>");
    _builder.newLine();
    _builder.append("<xsd:element name=\"");
    String _name_1 = op.getName();
    _builder.append(_name_1, "");
    _builder.append("Response\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<xsd:complexType>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<xsd:sequence>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<xsd:element name=\"response\" type=\"svc:");
    String _operationWrapperResponseType = this._serviceTemplateExtensions.toOperationWrapperResponseType(op);
    _builder.append(_operationWrapperResponseType, "			");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("</xsd:sequence>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</xsd:complexType>");
    _builder.newLine();
    _builder.append("</xsd:element>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence toOperationFaultWrapperTypes(final String faultName, final List<ExceptionRef> exceptions) {
    CharSequence _xblockexpression = null;
    {
      final Function1<ExceptionRef,Boolean> _function = new Function1<ExceptionRef,Boolean>() {
          public Boolean apply(final ExceptionRef e) {
            org.fornax.soa.serviceDsl.Exception _exception = e.getException();
            String _name = _exception.getName();
            boolean _equals = Objects.equal(_name, faultName);
            return Boolean.valueOf(_equals);
          }
        };
      final ExceptionRef exceptionRef = IterableExtensions.<ExceptionRef>findFirst(exceptions, _function);
      CharSequence _xifexpression = null;
      boolean _notEquals = (!Objects.equal(exceptionRef, null));
      if (_notEquals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("<xsd:element name=\"");
        org.fornax.soa.serviceDsl.Exception _exception = exceptionRef==null?(org.fornax.soa.serviceDsl.Exception)null:exceptionRef.getException();
        String _name = _exception.getName();
        _builder.append(_name, "");
        _builder.append("\" type=\"");
        String _exceptionNameRef = exceptionRef==null?(String)null:this._schemaTypeExtensions.toExceptionNameRef(exceptionRef);
        _builder.append(_exceptionNameRef, "");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
        _xifexpression = _builder;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected CharSequence _toParameter(final Parameter param) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<xsd:element name=\"");
    String _name = param.getName();
    _builder.append(_name, "");
    _builder.append("\" type=\"");
    TypeRef _type = param.getType();
    String _typeNameRef = this._schemaTypeExtensions.toTypeNameRef(_type);
    _builder.append(_typeNameRef, "");
    _builder.append("\" ");
    {
      boolean _isOptional = param.isOptional();
      if (_isOptional) {
        _builder.append("minOccurs=\"0\" ");
      }
    }
    {
      TypeRef _type_1 = param.getType();
      boolean _isMany = this._schemaTypeExtensions.isMany(_type_1);
      if (_isMany) {
        _builder.append("maxOccurs=\"unbounded\"");
      }
    }
    _builder.append(" ");
    {
      TypeRef _type_2 = param.getType();
      boolean _isMimeContentMultiPartAttachment = this._schemaTypeExtensions.isMimeContentMultiPartAttachment(_type_2);
      if (_isMimeContentMultiPartAttachment) {
        TypeRef _type_3 = param.getType();
        CharSequence _mimeFragment = this._xSDGenerator.toMimeFragment(_type_3);
        _builder.append(_mimeFragment, "");
      }
    }
    _builder.append("></xsd:element>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _toParameter(final Property prop) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<xsd:element name=\"");
    String _name = prop.getName();
    _builder.append(_name, "");
    _builder.append("\" type=\"");
    org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef _type = prop.getType();
    String _typeNameRef = this._schemaTypeExtensions.toTypeNameRef(_type);
    _builder.append(_typeNameRef, "");
    _builder.append("\" ");
    {
      boolean _isOptional = prop.isOptional();
      if (_isOptional) {
        _builder.append("minOccurs=\"0\" ");
      }
    }
    {
      org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef _type_1 = prop.getType();
      boolean _isMany = _type_1.isMany();
      if (_isMany) {
        _builder.append("maxOccurs=\"unbounded\"");
      }
    }
    _builder.append("></xsd:element>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _toParameter(final MessageHeader header) {
    StringConcatenation _builder = new StringConcatenation();
    EList<Property> _parameters = header.getParameters();
    final Function1<Property,CharSequence> _function = new Function1<Property,CharSequence>() {
        public CharSequence apply(final Property p) {
          CharSequence _parameter = WrappedWsdlGenerator.this.toParameter(p);
          return _parameter;
        }
      };
    List<CharSequence> _map = ListExtensions.<Property, CharSequence>map(_parameters, _function);
    String _join = IterableExtensions.join(_map);
    _builder.append(_join, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence toMessages(final Operation op) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<wsdl:message name=\"");
    String _name = op.getName();
    _builder.append(_name, "");
    _builder.append("Request\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<wsdl:part element=\"tns:");
    String _name_1 = op.getName();
    _builder.append(_name_1, "	");
    _builder.append("\" name=\"parameters\" />");
    _builder.newLineIfNotEmpty();
    _builder.append("</wsdl:message>");
    _builder.newLine();
    _builder.append("<wsdl:message name=\"");
    String _name_2 = op.getName();
    _builder.append(_name_2, "");
    _builder.append("Response\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<wsdl:part element=\"tns:");
    String _name_3 = op.getName();
    _builder.append(_name_3, "	");
    _builder.append("Response\" name=\"parameters\" />");
    _builder.newLineIfNotEmpty();
    _builder.append("</wsdl:message>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence toPortType(final Service svc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<wsdl:portType name=\"");
    String _name = svc.getName();
    _builder.append(_name, "");
    _builder.append("Wrapped\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<wsdl:documentation>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<![CDATA[Version:\t");
    Version _version = svc.getVersion();
    String _versionNumber = this._versionQualifierExtensions.toVersionNumber(_version);
    _builder.append(_versionNumber, "			");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("Lifecycle state: ");
    LifecycleState _state = svc.getState();
    String _name_1 = _state.getName();
    _builder.append(_name_1, "			");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    String _documentation = this.docProvider.getDocumentation(svc);
    _builder.append(_documentation, "			");
    _builder.append("]]>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</wsdl:documentation>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    EList<Operation> _operations = svc.getOperations();
    final Function1<Operation,CharSequence> _function = new Function1<Operation,CharSequence>() {
        public CharSequence apply(final Operation o) {
          CharSequence _operation = WrappedWsdlGenerator.this.toOperation(o);
          return _operation;
        }
      };
    List<CharSequence> _map = ListExtensions.<Operation, CharSequence>map(_operations, _function);
    String _join = IterableExtensions.join(_map);
    _builder.append(_join, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("</wsdl:portType>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence toOperation(final Operation op) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<wsdl:operation name=\"");
    String _name = op.getName();
    _builder.append(_name, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<wsdl:documentation>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<![CDATA[");
    String _documentation = this.docProvider.getDocumentation(op);
    _builder.append(_documentation, "		");
    _builder.append("]]>   \t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</wsdl:documentation>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<wsdl:input message=\"tns:");
    String _name_1 = op.getName();
    _builder.append(_name_1, "	");
    _builder.append("Request\" />");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<wsdl:output message=\"tns:");
    String _name_2 = op.getName();
    _builder.append(_name_2, "	");
    _builder.append("Response\" />");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _fault = this.toFault(op);
    _builder.append(_fault, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("</wsdl:operation>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence toFaultMessages(final String faultName, final List<ExceptionRef> exceptions) {
    CharSequence _xblockexpression = null;
    {
      final Function1<ExceptionRef,Boolean> _function = new Function1<ExceptionRef,Boolean>() {
          public Boolean apply(final ExceptionRef e) {
            org.fornax.soa.serviceDsl.Exception _exception = e.getException();
            String _name = _exception.getName();
            boolean _equals = Objects.equal(_name, faultName);
            return Boolean.valueOf(_equals);
          }
        };
      final ExceptionRef exceptionRef = IterableExtensions.<ExceptionRef>findFirst(exceptions, _function);
      CharSequence _xifexpression = null;
      boolean _notEquals = (!Objects.equal(exceptionRef, null));
      if (_notEquals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("<wsdl:message name=\"");
        final Function1<ExceptionRef,Boolean> _function_1 = new Function1<ExceptionRef,Boolean>() {
            public Boolean apply(final ExceptionRef e) {
              org.fornax.soa.serviceDsl.Exception _exception = e.getException();
              String _name = _exception.getName();
              boolean _equals = Objects.equal(_name, faultName);
              return Boolean.valueOf(_equals);
            }
          };
        ExceptionRef _findFirst = IterableExtensions.<ExceptionRef>findFirst(exceptions, _function_1);
        org.fornax.soa.serviceDsl.Exception _exception = _findFirst.getException();
        String _name = _exception.getName();
        _builder.append(_name, "");
        _builder.append("\">");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("<wsdl:part name=\"parameters\" element=\"tns:");
        org.fornax.soa.serviceDsl.Exception _exception_1 = exceptionRef==null?(org.fornax.soa.serviceDsl.Exception)null:exceptionRef.getException();
        String _name_1 = _exception_1.getName();
        _builder.append(_name_1, "	");
        _builder.append("\"></wsdl:part>");
        _builder.newLineIfNotEmpty();
        _builder.append("</wsdl:message>");
        _builder.newLine();
        _xifexpression = _builder;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected CharSequence toFault(final Operation op) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<ExceptionRef> _throws = op.getThrows();
      for(final ExceptionRef fault : _throws) {
        _builder.append("<wsdl:fault name=\"");
        org.fornax.soa.serviceDsl.Exception _exception = fault==null?(org.fornax.soa.serviceDsl.Exception)null:fault.getException();
        String _name = _exception.getName();
        String _firstLower = StringExtensions.toFirstLower(_name);
        _builder.append(_firstLower, "");
        _builder.append("\" message=\"tns:");
        org.fornax.soa.serviceDsl.Exception _exception_1 = fault==null?(org.fornax.soa.serviceDsl.Exception)null:fault.getException();
        String _name_1 = _exception_1.getName();
        _builder.append(_name_1, "");
        _builder.append("\"></wsdl:fault>");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  protected CharSequence toBinding(final Service svc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<wsdl:binding name=\"");
    String _name = svc.getName();
    _builder.append(_name, "");
    _builder.append("SOAP\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("type=\"tns:");
    String _name_1 = svc.getName();
    _builder.append(_name_1, "	");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<soap:binding style=\"document\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("transport=\"http://schemas.xmlsoap.org/soap/http\" />");
    _builder.newLine();
    _builder.append("\t");
    EList<Operation> _operations = svc.getOperations();
    final Function1<Operation,CharSequence> _function = new Function1<Operation,CharSequence>() {
        public CharSequence apply(final Operation o) {
          CharSequence _bindingOperation = WrappedWsdlGenerator.this.toBindingOperation(o);
          return _bindingOperation;
        }
      };
    List<CharSequence> _map = ListExtensions.<Operation, CharSequence>map(_operations, _function);
    String _join = IterableExtensions.join(_map);
    _builder.append(_join, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("</wsdl:binding>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence toBindingOperation(final Operation op) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<wsdl:operation name=\"");
    String _name = op.getName();
    _builder.append(_name, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<soap:operation");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("soapAction=\"");
    EObject _eContainer = op.eContainer();
    String _namespace = this._schemaTypeExtensions.toNamespace(_eContainer);
    String _name_1 = op.getName();
    String _plus = (_namespace + _name_1);
    _builder.append(_plus, "		");
    _builder.append("\" />");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<wsdl:input>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<soap:body use=\"literal\" />");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</wsdl:input>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<wsdl:output>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<soap:body use=\"literal\" />");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</wsdl:output>");
    _builder.newLine();
    _builder.append("</wsdl:operation>");
    _builder.newLine();
    return _builder;
  }
  
  public void toWrappedWSDL(final Service svc, final SubNamespace subDom, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    if (subDom instanceof DomainNamespace) {
      _toWrappedWSDL(svc, (DomainNamespace)subDom, minState, profile, registryBaseUrl);
      return;
    } else if (subDom instanceof InternalNamespace) {
      _toWrappedWSDL(svc, (InternalNamespace)subDom, minState, profile, registryBaseUrl);
      return;
    } else if (subDom != null) {
      _toWrappedWSDL(svc, subDom, minState, profile, registryBaseUrl);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(svc, subDom, minState, profile, registryBaseUrl).toString());
    }
  }
  
  protected CharSequence toParameter(final EObject prop) {
    if (prop instanceof Property) {
      return _toParameter((Property)prop);
    } else if (prop instanceof MessageHeader) {
      return _toParameter((MessageHeader)prop);
    } else if (prop instanceof Parameter) {
      return _toParameter((Parameter)prop);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(prop).toString());
    }
  }
}
