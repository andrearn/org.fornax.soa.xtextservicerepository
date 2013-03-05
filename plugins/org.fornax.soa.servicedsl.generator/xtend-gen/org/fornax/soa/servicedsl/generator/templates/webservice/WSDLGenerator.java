package org.fornax.soa.servicedsl.generator.templates.webservice;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
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
import org.fornax.soa.profiledsl.generator.schema.ProfileSchemaNamespaceExtensions;
import org.fornax.soa.profiledsl.query.namespace.TechnicalNamespaceImportQueries;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader;
import org.fornax.soa.profiledsl.sOAProfileDsl.Property;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.profiledsl.versioning.VersionedTechnicalNamespace;
import org.fornax.soa.service.VersionedDomainNamespace;
import org.fornax.soa.service.query.HeaderFinder;
import org.fornax.soa.service.query.namespace.NamespaceImportQueries;
import org.fornax.soa.serviceDsl.DomainNamespace;
import org.fornax.soa.serviceDsl.ExceptionRef;
import org.fornax.soa.serviceDsl.InternalNamespace;
import org.fornax.soa.serviceDsl.Operation;
import org.fornax.soa.serviceDsl.Parameter;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.servicedsl.generator.templates.webservice.ServiceTemplateExtensions;
import org.fornax.soa.servicedsl.generator.templates.webservice.WsdlParameterExtensions;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaTypeExtensions;
import org.fornax.soa.servicedsl.generator.templates.xsd.XSDGenerator;

/**
 * Template class for generation of abstract WSDLs
 */
@SuppressWarnings("all")
public class WSDLGenerator {
  @Inject
  private IFileSystemAccess fsa;
  
  @Inject
  private SchemaNamespaceExtensions _schemaNamespaceExtensions;
  
  @Inject
  private SchemaTypeExtensions _schemaTypeExtensions;
  
  @Inject
  private ServiceTemplateExtensions _serviceTemplateExtensions;
  
  @Inject
  private HeaderFinder _headerFinder;
  
  @Inject
  private NamespaceImportQueries _namespaceImportQueries;
  
  @Inject
  private XSDGenerator _xSDGenerator;
  
  @Inject
  private WsdlParameterExtensions _wsdlParameterExtensions;
  
  @Inject
  private TechnicalNamespaceImportQueries techNsImportQueries;
  
  @Inject
  private VersionQualifierExtensions versionQualifier;
  
  @Inject
  private ProfileSchemaNamespaceExtensions profileSchemaNamespaceExt;
  
  @Inject
  private IEObjectDocumentationProvider docProvider;
  
  @Inject
  @Named(value = "noDependencies")
  private Boolean noDependencies;
  
  @Inject
  private Logger log;
  
  protected void _toWSDL(final Service s, final DomainNamespace subDom, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    EList<Operation> _operations = s.getOperations();
    final Function1<Operation,EList<ExceptionRef>> _function = new Function1<Operation,EList<ExceptionRef>>() {
        public EList<ExceptionRef> apply(final Operation o) {
          EList<ExceptionRef> _throws = o.getThrows();
          return _throws;
        }
      };
    List<EList<ExceptionRef>> _map = ListExtensions.<Operation, EList<ExceptionRef>>map(_operations, _function);
    final Iterable<ExceptionRef> allServiceExceptionRefs = Iterables.<ExceptionRef>concat(_map);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    _builder.newLine();
    _builder.append("<wsdl:definitions xmlns:soap=\"http://schemas.xmlsoap.org/wsdl/soap/\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:tns=\"");
    String _targetNamespace = this._serviceTemplateExtensions.toTargetNamespace(s);
    _builder.append(_targetNamespace, "	");
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
    String _name = s.getName();
    _builder.append(_name, "	");
    _builder.append("\" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("targetNamespace=\"");
    String _targetNamespace_1 = this._serviceTemplateExtensions.toTargetNamespace(s);
    _builder.append(_targetNamespace_1, "	");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<wsdl:documentation>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Version ");
    Version _version = s.getVersion();
    String _versionNumber = this.versionQualifier.toVersionNumber(_version);
    _builder.append(_versionNumber, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("Lifecycle state: ");
    LifecycleState _state = s.getState();
    String _name_1 = _state.getName();
    _builder.append(_name_1, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    String _documentation = this.docProvider.getDocumentation(s);
    _builder.append(_documentation, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</wsdl:documentation>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _types = this.toTypes(s, minState, profile, registryBaseUrl);
    _builder.append(_types, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    EList<Operation> _operations_1 = s.getOperations();
    final Function1<Operation,CharSequence> _function_1 = new Function1<Operation,CharSequence>() {
        public CharSequence apply(final Operation e) {
          CharSequence _messages = WSDLGenerator.this.toMessages(e);
          return _messages;
        }
      };
    List<CharSequence> _map_1 = ListExtensions.<Operation, CharSequence>map(_operations_1, _function_1);
    String _join = IterableExtensions.join(_map_1);
    _builder.append(_join, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    final Function1<ExceptionRef,String> _function_2 = new Function1<ExceptionRef,String>() {
        public String apply(final ExceptionRef t) {
          org.fornax.soa.serviceDsl.Exception _exception = t.getException();
          String _name = _exception.getName();
          return _name;
        }
      };
    Iterable<String> _map_2 = IterableExtensions.<ExceptionRef, String>map(allServiceExceptionRefs, _function_2);
    Set<String> _set = IterableExtensions.<String>toSet(_map_2);
    final Function1<String,CharSequence> _function_3 = new Function1<String,CharSequence>() {
        public CharSequence apply(final String e) {
          List<ExceptionRef> _list = IterableExtensions.<ExceptionRef>toList(allServiceExceptionRefs);
          CharSequence _faultMessages = WSDLGenerator.this.toFaultMessages(e, _list);
          return _faultMessages;
        }
      };
    Iterable<CharSequence> _map_3 = IterableExtensions.<String, CharSequence>map(_set, _function_3);
    String _join_1 = IterableExtensions.join(_map_3);
    _builder.append(_join_1, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _portType = this.toPortType(s);
    _builder.append(_portType, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("</wsdl:definitions>");
    final CharSequence content = _builder;
    String _fileNameFragment = this._schemaNamespaceExtensions.toFileNameFragment(s);
    final String wsdlFileName = (_fileNameFragment + ".wsdl");
    this.fsa.generateFile(wsdlFileName, content);
  }
  
  protected void _toWSDL(final Service s, final InternalNamespace subDom, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    EList<Operation> _operations = s.getOperations();
    final Function1<Operation,EList<ExceptionRef>> _function = new Function1<Operation,EList<ExceptionRef>>() {
        public EList<ExceptionRef> apply(final Operation o) {
          EList<ExceptionRef> _throws = o.getThrows();
          return _throws;
        }
      };
    List<EList<ExceptionRef>> _map = ListExtensions.<Operation, EList<ExceptionRef>>map(_operations, _function);
    final Iterable<ExceptionRef> allServiceExceptionRefs = Iterables.<ExceptionRef>concat(_map);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    _builder.newLine();
    _builder.append("<wsdl:definitions xmlns:soap=\"http://schemas.xmlsoap.org/wsdl/soap/\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:tns=\"");
    String _targetNamespace = this._serviceTemplateExtensions.toTargetNamespace(s);
    _builder.append(_targetNamespace, "	");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("xmlns:wsdl=\"http://schemas.xmlsoap.org/wsdl/\" ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:ref=\"http://ws-i.org/profiles/basic/1.1/xsd");
    _builder.newLine();
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("name=\"");
    String _name = s.getName();
    _builder.append(_name, "	");
    _builder.append("\" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("targetNamespace=\"");
    String _targetNamespace_1 = this._serviceTemplateExtensions.toTargetNamespace(s);
    _builder.append(_targetNamespace_1, "	");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<wsdl:documentation>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<![CDATA[Version ");
    Version _version = s.getVersion();
    String _versionNumber = this.versionQualifier.toVersionNumber(_version);
    _builder.append(_versionNumber, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("Lifecycle state: ");
    LifecycleState _state = s.getState();
    String _name_1 = _state.getName();
    _builder.append(_name_1, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    String _documentation = this.docProvider.getDocumentation(s);
    _builder.append(_documentation, "		");
    _builder.append("]]>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</wsdl:documentation>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _types = this.toTypes(s, minState, profile, registryBaseUrl);
    _builder.append(_types, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    EList<Operation> _operations_1 = s.getOperations();
    final Function1<Operation,CharSequence> _function_1 = new Function1<Operation,CharSequence>() {
        public CharSequence apply(final Operation e) {
          CharSequence _messages = WSDLGenerator.this.toMessages(e);
          return _messages;
        }
      };
    List<CharSequence> _map_1 = ListExtensions.<Operation, CharSequence>map(_operations_1, _function_1);
    String _join = IterableExtensions.join(_map_1);
    _builder.append(_join, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    final Function1<ExceptionRef,String> _function_2 = new Function1<ExceptionRef,String>() {
        public String apply(final ExceptionRef t) {
          org.fornax.soa.serviceDsl.Exception _exception = t.getException();
          String _name = _exception.getName();
          return _name;
        }
      };
    Iterable<String> _map_2 = IterableExtensions.<ExceptionRef, String>map(allServiceExceptionRefs, _function_2);
    Set<String> _set = IterableExtensions.<String>toSet(_map_2);
    final Function1<String,CharSequence> _function_3 = new Function1<String,CharSequence>() {
        public CharSequence apply(final String e) {
          List<ExceptionRef> _list = IterableExtensions.<ExceptionRef>toList(allServiceExceptionRefs);
          CharSequence _faultMessages = WSDLGenerator.this.toFaultMessages(e, _list);
          return _faultMessages;
        }
      };
    Iterable<CharSequence> _map_3 = IterableExtensions.<String, CharSequence>map(_set, _function_3);
    String _join_1 = IterableExtensions.join(_map_3);
    _builder.append(_join_1, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _portType = this.toPortType(s);
    _builder.append(_portType, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("</wsdl:definitions>");
    final CharSequence content = _builder;
    String _fileNameFragment = this._schemaNamespaceExtensions.toFileNameFragment(subDom);
    String _plus = (_fileNameFragment + "-");
    String _name_2 = s.getName();
    String _plus_1 = (_plus + _name_2);
    String _plus_2 = (_plus_1 + "-");
    Version _version_1 = s.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version_1);
    String _plus_3 = (_plus_2 + _versionPostfix);
    final String wsdlFileName = (_plus_3 + ".wsdl");
    this.fsa.generateFile(wsdlFileName, content);
  }
  
  public CharSequence toTypes(final Service s, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    CharSequence _xblockexpression = null;
    {
      final Set<VersionedTechnicalNamespace> headerImports = this._serviceTemplateExtensions.collectTechnicalVersionedNamespaceImports(s, profile);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<wsdl:types>");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("<xsd:schema targetNamespace=\"");
      String _targetNamespace = this._serviceTemplateExtensions.toTargetNamespace(s);
      _builder.append(_targetNamespace, "	");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      _builder.append("xmlns:ref=\"http://ws-i.org/profiles/basic/1.1/xsd\"");
      _builder.newLine();
      {
        Version _version = s.getVersion();
        String _majorVersionNumber = this.versionQualifier.toMajorVersionNumber(_version);
        Set<VersionedDomainNamespace> _importedVersionedNS = this._namespaceImportQueries.importedVersionedNS(s, _majorVersionNumber, minState);
        for(final VersionedDomainNamespace imp : _importedVersionedNS) {
          _builder.append("\t\t");
          _builder.append("xmlns:");
          String _prefix = this._schemaNamespaceExtensions.toPrefix(imp);
          String _version_1 = imp.getVersion();
          String _majorVersionNumber_1 = this.versionQualifier.toMajorVersionNumber(_version_1);
          String _plus = (_prefix + _majorVersionNumber_1);
          _builder.append(_plus, "		");
          _builder.append("=\"");
          String _namespace = this._schemaTypeExtensions.toNamespace(imp);
          _builder.append(_namespace, "		");
          _builder.append("\"");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        boolean _isEmpty = headerImports.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          {
            for(final VersionedTechnicalNamespace headerImp : headerImports) {
              _builder.append("\t\t");
              _builder.append("xmlns:");
              String _prefix_1 = this.profileSchemaNamespaceExt.toPrefix(headerImp);
              String _version_2 = headerImp.getVersion();
              String _majorVersionNumber_2 = this.versionQualifier.toMajorVersionNumber(_version_2);
              String _plus_1 = (_prefix_1 + _majorVersionNumber_2);
              _builder.append(_plus_1, "		");
              _builder.append("=\"");
              String _namespace_1 = this.profileSchemaNamespaceExt.toNamespace(headerImp);
              _builder.append(_namespace_1, "		");
              _builder.append("\"");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("\t\t");
      _builder.append("elementFormDefault=\"qualified\"");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("attributeFormDefault=\"unqualified\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append(">");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("<xsd:import namespace=\"http://ws-i.org/profiles/basic/1.1/xsd\" />");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      {
        Version _version_3 = s.getVersion();
        String _majorVersionNumber_3 = this.versionQualifier.toMajorVersionNumber(_version_3);
        Set<VersionedDomainNamespace> _importedVersionedNS_1 = this._namespaceImportQueries.importedVersionedNS(s, _majorVersionNumber_3, minState);
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
          String _namespace_2 = this._schemaTypeExtensions.toNamespace(imp_1);
          _builder.append(_namespace_2, "			");
          _builder.append("\"/>");
          _builder.newLineIfNotEmpty();
        }
      }
      {
        boolean _isEmpty_1 = headerImports.isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        if (_not_1) {
          {
            for(final VersionedTechnicalNamespace headerImp_1 : headerImports) {
              _builder.append("\t\t");
              _builder.append("<xsd:import schemaLocation=\"");
              String _registryAssetUrl_1 = this.profileSchemaNamespaceExt.toRegistryAssetUrl(headerImp_1, registryBaseUrl);
              _builder.append(_registryAssetUrl_1, "		");
              _builder.append(".xsd\"");
              _builder.newLineIfNotEmpty();
              _builder.append("\t\t");
              _builder.append("\t");
              _builder.append("namespace=\"");
              String _namespace_3 = this.profileSchemaNamespaceExt.toNamespace(headerImp_1);
              _builder.append(_namespace_3, "			");
              _builder.append("\"/>");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
      _builder.append("\t\t");
      EList<Operation> _operations = s.getOperations();
      final Function1<Operation,CharSequence> _function = new Function1<Operation,CharSequence>() {
          public CharSequence apply(final Operation e) {
            CharSequence _operationWrapperTypes = WSDLGenerator.this.toOperationWrapperTypes(e, profile);
            return _operationWrapperTypes;
          }
        };
      List<CharSequence> _map = ListExtensions.<Operation, CharSequence>map(_operations, _function);
      String _join = IterableExtensions.join(_map);
      _builder.append(_join, "		");
      _builder.newLineIfNotEmpty();
      _builder.append("\t\t");
      EList<Operation> _operations_1 = s.getOperations();
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
          public CharSequence apply(final String e) {
            EList<Operation> _operations = s.getOperations();
            final Function1<Operation,EList<ExceptionRef>> _function = new Function1<Operation,EList<ExceptionRef>>() {
                public EList<ExceptionRef> apply(final Operation o) {
                  EList<ExceptionRef> _throws = o.getThrows();
                  return _throws;
                }
              };
            List<EList<ExceptionRef>> _map = ListExtensions.<Operation, EList<ExceptionRef>>map(_operations, _function);
            Iterable<ExceptionRef> _flatten = Iterables.<ExceptionRef>concat(_map);
            List<ExceptionRef> _list = IterableExtensions.<ExceptionRef>toList(_flatten);
            CharSequence _operationFaultWrapperTypes = WSDLGenerator.this.toOperationFaultWrapperTypes(e, _list);
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
      _xblockexpression = (_builder);
    }
    return _xblockexpression;
  }
  
  public CharSequence toOperationWrapperTypes(final Operation o, final SOAProfile profile) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<xsd:element name=\"");
    String _name = o.getName();
    _builder.append(_name, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<xsd:complexType>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<xsd:sequence>");
    _builder.newLine();
    {
      MessageHeader _findBestMatchingRequestHeader = this._headerFinder.findBestMatchingRequestHeader(o, profile);
      boolean _notEquals = (!Objects.equal(_findBestMatchingRequestHeader, null));
      if (_notEquals) {
        _builder.append("\t\t\t");
        MessageHeader _findBestMatchingRequestHeader_1 = this._headerFinder.findBestMatchingRequestHeader(o, profile);
        CharSequence _parameter = this.toParameter(_findBestMatchingRequestHeader_1);
        _builder.append(_parameter, "			");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    EList<Parameter> _parameters = o.getParameters();
    final Function1<Parameter,CharSequence> _function = new Function1<Parameter,CharSequence>() {
        public CharSequence apply(final Parameter p) {
          CharSequence _parameter = WSDLGenerator.this.toParameter(p);
          return _parameter;
        }
      };
    List<CharSequence> _map = ListExtensions.<Parameter, CharSequence>map(_parameters, _function);
    String _join = IterableExtensions.join(_map);
    _builder.append(_join, "			");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.newLine();
    {
      boolean _operationsUseExtendableParameters = this._serviceTemplateExtensions.operationsUseExtendableParameters(profile);
      if (_operationsUseExtendableParameters) {
        _builder.append("\t\t\t");
        _builder.append("<xsd:any maxOccurs=\"unbounded\" minOccurs=\"0\" namespace=\"##other\"");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("processContents=\"skip\"/>");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("</xsd:sequence>");
    _builder.newLine();
    {
      boolean _operationsUseExtendableXMLAttributes = this._serviceTemplateExtensions.operationsUseExtendableXMLAttributes(profile);
      if (_operationsUseExtendableXMLAttributes) {
        _builder.append("\t\t");
        _builder.append("<xsd:anyAttribute namespace=\"##any\"/>");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("</xsd:complexType>");
    _builder.newLine();
    _builder.append("</xsd:element>");
    _builder.newLine();
    _builder.append("<xsd:element name=\"");
    String _name_1 = o.getName();
    _builder.append(_name_1, "");
    _builder.append("Response\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<xsd:complexType>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<xsd:sequence>");
    _builder.newLine();
    {
      MessageHeader _findBestMatchingResponseHeader = this._headerFinder.findBestMatchingResponseHeader(o, profile);
      boolean _notEquals_1 = (!Objects.equal(_findBestMatchingResponseHeader, null));
      if (_notEquals_1) {
        _builder.append("\t\t\t");
        MessageHeader _findBestMatchingResponseHeader_1 = this._headerFinder.findBestMatchingResponseHeader(o, profile);
        CharSequence _parameter_1 = this.toParameter(_findBestMatchingResponseHeader_1);
        _builder.append(_parameter_1, "			");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    EList<Parameter> _return = o.getReturn();
    final Function1<Parameter,CharSequence> _function_1 = new Function1<Parameter,CharSequence>() {
        public CharSequence apply(final Parameter r) {
          CharSequence _parameter = WSDLGenerator.this.toParameter(r);
          return _parameter;
        }
      };
    List<CharSequence> _map_1 = ListExtensions.<Parameter, CharSequence>map(_return, _function_1);
    String _join_1 = IterableExtensions.join(_map_1);
    _builder.append(_join_1, "			");
    _builder.newLineIfNotEmpty();
    {
      boolean _operationsUseExtendableParameters_1 = this._serviceTemplateExtensions.operationsUseExtendableParameters(profile);
      if (_operationsUseExtendableParameters_1) {
        _builder.append("\t\t\t");
        _builder.append("<xsd:any maxOccurs=\"unbounded\" minOccurs=\"0\" namespace=\"##other\"");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("processContents=\"skip\"/>");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.append("</xsd:sequence>");
    _builder.newLine();
    {
      boolean _operationsUseExtendableXMLAttributes_1 = this._serviceTemplateExtensions.operationsUseExtendableXMLAttributes(profile);
      if (_operationsUseExtendableXMLAttributes_1) {
        _builder.append("\t\t");
        _builder.append("<xsd:anyAttribute namespace=\"##any\"/>");
        _builder.newLine();
      }
    }
    _builder.append("\t");
    _builder.append("</xsd:complexType>");
    _builder.newLine();
    _builder.append("</xsd:element>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence toOperationFaultWrapperTypes(final String name, final List<ExceptionRef> exceptions) {
    CharSequence _xblockexpression = null;
    {
      final Function1<ExceptionRef,Boolean> _function = new Function1<ExceptionRef,Boolean>() {
          public Boolean apply(final ExceptionRef e) {
            org.fornax.soa.serviceDsl.Exception _exception = e.getException();
            String _name = _exception.getName();
            boolean _equals = Objects.equal(_name, name);
            return Boolean.valueOf(_equals);
          }
        };
      final ExceptionRef exRef = IterableExtensions.<ExceptionRef>findFirst(exceptions, _function);
      CharSequence _xifexpression = null;
      boolean _notEquals = (!Objects.equal(exRef, null));
      if (_notEquals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("<xsd:element name=\"");
        org.fornax.soa.serviceDsl.Exception _exception = exRef.getException();
        String _name = _exception.getName();
        _builder.append(_name, "");
        _builder.append("\" type=\"");
        String _exceptionNameRef = this._schemaTypeExtensions.toExceptionNameRef(exRef);
        _builder.append(_exceptionNameRef, "");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
        _xifexpression = _builder;
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _xifexpression = _builder_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected CharSequence _toParameter(final Parameter p) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<xsd:element name=\"");
    String _name = p.getName();
    _builder.append(_name, "");
    _builder.append("\" type=\"");
    String _elementType = this._wsdlParameterExtensions.toElementType(p);
    _builder.append(_elementType, "");
    _builder.append("\" ");
    {
      TypeRef _type = p.getType();
      boolean _isMimeContentMultiPartAttachment = this._schemaTypeExtensions.isMimeContentMultiPartAttachment(_type);
      if (_isMimeContentMultiPartAttachment) {
        TypeRef _type_1 = p.getType();
        CharSequence _mimeFragment = this._xSDGenerator.toMimeFragment(_type_1);
        _builder.append(_mimeFragment, "");
      } else {
        CharSequence _elementCardinality = this.toElementCardinality(p);
        _builder.append(_elementCardinality, "");
      }
    }
    _builder.append("></xsd:element>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence toElementCardinality(final Parameter param) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isOptional = param.isOptional();
      if (_isOptional) {
        _builder.append("minOccurs=\"0\"");
      }
    }
    _builder.append("\t");
    {
      TypeRef _type = param.getType();
      boolean _isMany = this._schemaTypeExtensions.isMany(_type);
      if (_isMany) {
        _builder.append("maxOccurs=\"unbounded\"");
      }
    }
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
  
  public CharSequence toParameter(final MessageHeader header) {
    StringConcatenation _builder = new StringConcatenation();
    EList<Property> _parameters = header.getParameters();
    final Function1<Property,CharSequence> _function = new Function1<Property,CharSequence>() {
        public CharSequence apply(final Property p) {
          CharSequence _parameter = WSDLGenerator.this.toParameter(p);
          return _parameter;
        }
      };
    List<CharSequence> _map = ListExtensions.<Property, CharSequence>map(_parameters, _function);
    String _join = IterableExtensions.join(_map);
    _builder.append(_join, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence toMessages(final Operation o) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<wsdl:message name=\"");
    String _name = o.getName();
    _builder.append(_name, "");
    _builder.append("Request\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<wsdl:part element=\"tns:");
    String _name_1 = o.getName();
    _builder.append(_name_1, "	");
    _builder.append("\" name=\"parameters\" />");
    _builder.newLineIfNotEmpty();
    _builder.append("</wsdl:message>");
    _builder.newLine();
    _builder.append("<wsdl:message name=\"");
    String _name_2 = o.getName();
    _builder.append(_name_2, "");
    _builder.append("Response\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<wsdl:part element=\"tns:");
    String _name_3 = o.getName();
    _builder.append(_name_3, "	");
    _builder.append("Response\" name=\"parameters\" />");
    _builder.newLineIfNotEmpty();
    _builder.append("</wsdl:message>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence toPortType(final Service s) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<wsdl:portType name=\"");
    String _name = s.getName();
    _builder.append(_name, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<wsdl:documentation>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<![CDATA[");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Version:\t");
    Version _version = s.getVersion();
    String _versionNumber = this.versionQualifier.toVersionNumber(_version);
    _builder.append(_versionNumber, "				");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("Lifecycle state: ");
    LifecycleState _state = s.getState();
    String _name_1 = _state.getName();
    _builder.append(_name_1, "				");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t\t\t\t");
    String _documentation = this.docProvider.getDocumentation(s);
    _builder.append(_documentation, "				");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("]]>   \t\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</wsdl:documentation>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    EList<Operation> _operations = s.getOperations();
    final Function1<Operation,CharSequence> _function = new Function1<Operation,CharSequence>() {
        public CharSequence apply(final Operation e) {
          CharSequence _operation = WSDLGenerator.this.toOperation(e);
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
  
  public CharSequence toOperation(final Operation o) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<wsdl:operation name=\"");
    String _name = o.getName();
    _builder.append(_name, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<wsdl:documentation>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<![CDATA[");
    String _documentation = this.docProvider.getDocumentation(o);
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
    String _name_1 = o.getName();
    _builder.append(_name_1, "	");
    _builder.append("Request\" />");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<wsdl:output message=\"tns:");
    String _name_2 = o.getName();
    _builder.append(_name_2, "	");
    _builder.append("Response\" />");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _fault = this.toFault(o);
    _builder.append(_fault, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("</wsdl:operation>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence toFaultMessages(final String name, final List<ExceptionRef> exceptions) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<wsdl:message name=\"");
    final Function1<ExceptionRef,Boolean> _function = new Function1<ExceptionRef,Boolean>() {
        public Boolean apply(final ExceptionRef e) {
          org.fornax.soa.serviceDsl.Exception _exception = e.getException();
          String _name = _exception.getName();
          boolean _equals = Objects.equal(_name, name);
          return Boolean.valueOf(_equals);
        }
      };
    ExceptionRef _findFirst = IterableExtensions.<ExceptionRef>findFirst(exceptions, _function);
    org.fornax.soa.serviceDsl.Exception _exception = _findFirst==null?(org.fornax.soa.serviceDsl.Exception)null:_findFirst.getException();
    String _name = _exception.getName();
    _builder.append(_name, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<wsdl:part name=\"parameters\" element=\"tns:");
    final Function1<ExceptionRef,Boolean> _function_1 = new Function1<ExceptionRef,Boolean>() {
        public Boolean apply(final ExceptionRef e) {
          org.fornax.soa.serviceDsl.Exception _exception = e.getException();
          String _name = _exception.getName();
          boolean _equals = Objects.equal(_name, name);
          return Boolean.valueOf(_equals);
        }
      };
    ExceptionRef _findFirst_1 = IterableExtensions.<ExceptionRef>findFirst(exceptions, _function_1);
    org.fornax.soa.serviceDsl.Exception _exception_1 = _findFirst_1.getException();
    String _name_1 = _exception_1.getName();
    _builder.append(_name_1, "	");
    _builder.append("\"></wsdl:part>");
    _builder.newLineIfNotEmpty();
    _builder.append("</wsdl:message>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence toFault(final Operation o) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<ExceptionRef> _throws = o.getThrows();
      for(final ExceptionRef fault : _throws) {
        _builder.append("<wsdl:fault name=\"");
        org.fornax.soa.serviceDsl.Exception _exception = fault.getException();
        String _name = _exception.getName();
        String _firstLower = StringExtensions.toFirstLower(_name);
        _builder.append(_firstLower, "");
        _builder.append("\" message=\"tns:");
        org.fornax.soa.serviceDsl.Exception _exception_1 = fault.getException();
        String _name_1 = _exception_1.getName();
        _builder.append(_name_1, "");
        _builder.append("\"></wsdl:fault>");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence toBinding(final Service s) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<wsdl:binding name=\"");
    String _name = s.getName();
    _builder.append(_name, "");
    _builder.append("SOAP\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("type=\"tns:");
    String _name_1 = s.getName();
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
    EList<Operation> _operations = s.getOperations();
    final Function1<Operation,CharSequence> _function = new Function1<Operation,CharSequence>() {
        public CharSequence apply(final Operation o) {
          CharSequence _bindingOperation = WSDLGenerator.this.toBindingOperation(o);
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
  
  public CharSequence toBindingOperation(final Operation o) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<wsdl:operation name=\"");
    String _name = o.getName();
    _builder.append(_name, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<soap:operation");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("soapAction=\"");
    EObject _eContainer = o.eContainer();
    String _namespace = this._schemaTypeExtensions.toNamespace(_eContainer);
    String _name_1 = o.getName();
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
  
  public void toWSDL(final Service s, final SubNamespace subDom, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    if (subDom instanceof DomainNamespace) {
      _toWSDL(s, (DomainNamespace)subDom, minState, profile, registryBaseUrl);
      return;
    } else if (subDom instanceof InternalNamespace) {
      _toWSDL(s, (InternalNamespace)subDom, minState, profile, registryBaseUrl);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s, subDom, minState, profile, registryBaseUrl).toString());
    }
  }
  
  public CharSequence toParameter(final EObject prop) {
    if (prop instanceof Property) {
      return _toParameter((Property)prop);
    } else if (prop instanceof Parameter) {
      return _toParameter((Parameter)prop);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(prop).toString());
    }
  }
}
