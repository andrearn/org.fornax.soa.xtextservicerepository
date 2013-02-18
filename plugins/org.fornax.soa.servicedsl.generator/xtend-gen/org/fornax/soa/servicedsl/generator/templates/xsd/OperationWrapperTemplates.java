package org.fornax.soa.servicedsl.generator.templates.xsd;

import com.google.common.base.Objects;
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
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.version.VersionQualifierExtensions;
import org.fornax.soa.profiledsl.generator.schema.ProfileSchemaNamespaceExtensions;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader;
import org.fornax.soa.profiledsl.sOAProfileDsl.Property;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.profiledsl.versioning.VersionedTechnicalNamespace;
import org.fornax.soa.service.VersionedDomainNamespace;
import org.fornax.soa.service.query.HeaderFinder;
import org.fornax.soa.service.query.namespace.NamespaceImportQueries;
import org.fornax.soa.serviceDsl.DomainNamespace;
import org.fornax.soa.serviceDsl.InternalNamespace;
import org.fornax.soa.serviceDsl.Operation;
import org.fornax.soa.serviceDsl.Parameter;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.servicedsl.generator.templates.webservice.ServiceTemplateExtensions;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaTemplateExtensions;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaTypeExtensions;

@SuppressWarnings("all")
public class OperationWrapperTemplates {
  @Inject
  private IFileSystemAccess fsa;
  
  @Inject
  private SchemaNamespaceExtensions _schemaNamespaceExtensions;
  
  @Inject
  private SchemaTemplateExtensions _schemaTemplateExtensions;
  
  @Inject
  private SchemaTypeExtensions _schemaTypeExtensions;
  
  @Inject
  private ServiceTemplateExtensions _serviceTemplateExtensions;
  
  @Inject
  private VersionQualifierExtensions _versionQualifierExtensions;
  
  @Inject
  private HeaderFinder _headerFinder;
  
  @Inject
  private NamespaceImportQueries _namespaceImportQueries;
  
  @Inject
  private ProfileSchemaNamespaceExtensions profileSchemaNamespaceExt;
  
  @Inject
  @Named(value = "noDependencies")
  private Boolean noDependencies;
  
  @Inject
  private IEObjectDocumentationProvider docProvider;
  
  @Inject
  private Logger log;
  
  protected void _toOperationWrappersInclSubNamespaces(final String serviceName, final List<SubNamespace> namespaces, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    final Function1<SubNamespace,Boolean> _function = new Function1<SubNamespace,Boolean>() {
        public Boolean apply(final SubNamespace e) {
          String _name = e.getName();
          boolean _startsWith = _name.startsWith(serviceName);
          return Boolean.valueOf(_startsWith);
        }
      };
    Iterable<SubNamespace> _filter = IterableExtensions.<SubNamespace>filter(namespaces, _function);
    for (final SubNamespace ns : _filter) {
      this.toOperationWrappers(ns, minState, profile, registryBaseUrl);
    }
  }
  
  protected void _toOperationWrappers(final SubNamespace namespace, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    EList<Service> _services = namespace.getServices();
    final Procedure1<Service> _function = new Procedure1<Service>() {
        public void apply(final Service s) {
          OperationWrapperTemplates.this.toOperationWrappers(s, namespace, minState, profile, registryBaseUrl);
        }
      };
    IterableExtensions.<Service>forEach(_services, _function);
  }
  
  protected void _toOperationWrappers(final Service service, final SubNamespace subDom, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
  }
  
  protected void _toOperationWrappers(final Service service, final DomainNamespace subDom, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    final Set<VersionedTechnicalNamespace> headerImports = this._serviceTemplateExtensions.collectTechnicalVersionedNamespaceImports(service, profile);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    _builder.newLine();
    _builder.append("<xsd:schema targetNamespace=\"");
    String _wrapperTargetNamespace = this._serviceTemplateExtensions.toWrapperTargetNamespace(service);
    _builder.append(_wrapperTargetNamespace, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:jxb=\"http://java.sun.com/xml/ns/jaxb\"");
    _builder.newLine();
    {
      Version _version = service.getVersion();
      String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_version);
      Set<VersionedDomainNamespace> _allImportedVersionedNS = this._namespaceImportQueries.allImportedVersionedNS(service, _majorVersionNumber, minState);
      for(final VersionedDomainNamespace imp : _allImportedVersionedNS) {
        _builder.append("\t");
        _builder.append("xmlns:");
        String _prefix = this._schemaNamespaceExtensions.toPrefix(imp);
        String _version_1 = imp.getVersion();
        String _majorVersionNumber_1 = this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
        String _plus = (_prefix + _majorVersionNumber_1);
        _builder.append(_plus, "	");
        _builder.append("=\"");
        String _namespace = this._schemaTypeExtensions.toNamespace(imp);
        _builder.append(_namespace, "	");
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
            _builder.append("\t");
            _builder.append("xmlns:");
            String _prefix_1 = this.profileSchemaNamespaceExt.toPrefix(headerImp);
            String _version_2 = headerImp.getVersion();
            String _majorVersionNumber_2 = this._versionQualifierExtensions.toMajorVersionNumber(_version_2);
            String _plus_1 = (_prefix_1 + _majorVersionNumber_2);
            _builder.append(_plus_1, "	");
            _builder.append("=\"");
            String _namespace_1 = this.profileSchemaNamespaceExt.toNamespace(headerImp);
            _builder.append(_namespace_1, "	");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("elementFormDefault=\"qualified\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("attributeFormDefault=\"unqualified\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(">");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      Version _version_3 = service.getVersion();
      String _majorVersionNumber_3 = this._versionQualifierExtensions.toMajorVersionNumber(_version_3);
      Set<VersionedDomainNamespace> _allImportedVersionedNS_1 = this._namespaceImportQueries.allImportedVersionedNS(service, _majorVersionNumber_3, minState);
      for(final VersionedDomainNamespace imp_1 : _allImportedVersionedNS_1) {
        _builder.append("\t");
        _builder.append("<xsd:import schemaLocation=\"");
        String _registryAssetUrl = this._schemaNamespaceExtensions.toRegistryAssetUrl(imp_1, registryBaseUrl);
        _builder.append(_registryAssetUrl, "	");
        _builder.append(".xsd\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("namespace=\"");
        String _namespace_2 = this._schemaTypeExtensions.toNamespace(imp_1);
        _builder.append(_namespace_2, "		");
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
            _builder.append("\t");
            _builder.append("<xsd:import schemaLocation=\"");
            String _registryAssetUrl_1 = this.profileSchemaNamespaceExt.toRegistryAssetUrl(headerImp_1, registryBaseUrl);
            _builder.append(_registryAssetUrl_1, "	");
            _builder.append(".xsd\"");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("namespace=\"");
            String _namespace_3 = this.profileSchemaNamespaceExt.toNamespace(headerImp_1);
            _builder.append(_namespace_3, "		");
            _builder.append("\"/>");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<xsd:annotation>");
    _builder.newLine();
    _builder.append("   \t\t");
    _builder.append("<xsd:documentation>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<![CDATA[Version ");
    Version _version_4 = service.getVersion();
    String _versionNumber = this._versionQualifierExtensions.toVersionNumber(_version_4);
    _builder.append(_versionNumber, "			");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("Lifecycle state: ");
    LifecycleState _state = service.getState();
    String _name = _state.getName();
    _builder.append(_name, "			");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    String _documentation = this.docProvider.getDocumentation(service);
    _builder.append(_documentation, "			");
    _builder.append("]]>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t   \t");
    _builder.append("</xsd:documentation>");
    _builder.newLine();
    _builder.append("   \t");
    _builder.append("</xsd:annotation>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    String _operationWrapperMessages = this.toOperationWrapperMessages(service, minState, profile);
    _builder.append(_operationWrapperMessages, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("</xsd:schema>");
    _builder.newLine();
    CharSequence content = _builder;
    final String xsdFileName = this._schemaTemplateExtensions.toOpWrapperXSDFileName(service);
    this.fsa.generateFile(xsdFileName, content);
  }
  
  protected void _toOperationWrappers(final Service service, final InternalNamespace subDom, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    final Set<VersionedTechnicalNamespace> headerImports = this._serviceTemplateExtensions.collectTechnicalVersionedNamespaceImports(service, profile);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    _builder.newLine();
    _builder.append("<xsd:schema targetNamespace=\"");
    String _wrapperTargetNamespace = this._serviceTemplateExtensions.toWrapperTargetNamespace(service);
    _builder.append(_wrapperTargetNamespace, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"");
    _builder.newLine();
    {
      Version _version = service.getVersion();
      String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_version);
      Set<VersionedDomainNamespace> _allImportedVersionedNS = this._namespaceImportQueries.allImportedVersionedNS(service, _majorVersionNumber, minState);
      for(final VersionedDomainNamespace imp : _allImportedVersionedNS) {
        _builder.append("\t");
        _builder.append("xmlns:");
        String _prefix = this._schemaNamespaceExtensions.toPrefix(imp);
        String _version_1 = imp.getVersion();
        String _majorVersionNumber_1 = this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
        String _plus = (_prefix + _majorVersionNumber_1);
        _builder.append(_plus, "	");
        _builder.append("=\"");
        String _namespace = this._schemaTypeExtensions.toNamespace(imp);
        _builder.append(_namespace, "	");
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
            _builder.append("\t");
            _builder.append("xmlns:");
            String _prefix_1 = this.profileSchemaNamespaceExt.toPrefix(headerImp);
            String _version_2 = headerImp.getVersion();
            String _majorVersionNumber_2 = this._versionQualifierExtensions.toMajorVersionNumber(_version_2);
            String _plus_1 = (_prefix_1 + _majorVersionNumber_2);
            _builder.append(_plus_1, "	");
            _builder.append("=\"");
            String _namespace_1 = this.profileSchemaNamespaceExt.toNamespace(headerImp);
            _builder.append(_namespace_1, "	");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.append("elementFormDefault=\"qualified\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("attributeFormDefault=\"unqualified\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(">");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      Version _version_3 = service.getVersion();
      String _majorVersionNumber_3 = this._versionQualifierExtensions.toMajorVersionNumber(_version_3);
      Set<VersionedDomainNamespace> _allImportedVersionedNS_1 = this._namespaceImportQueries.allImportedVersionedNS(service, _majorVersionNumber_3, minState);
      for(final VersionedDomainNamespace imp_1 : _allImportedVersionedNS_1) {
        _builder.append("\t");
        _builder.append("<xsd:import schemaLocation=\"");
        String _registryAssetUrl = this._schemaNamespaceExtensions.toRegistryAssetUrl(imp_1, registryBaseUrl);
        _builder.append(_registryAssetUrl, "	");
        _builder.append(".xsd\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("namespace=\"");
        String _namespace_2 = this._schemaTypeExtensions.toNamespace(imp_1);
        _builder.append(_namespace_2, "		");
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
            _builder.append("\t");
            _builder.append("<xsd:import schemaLocation=\"");
            String _registryAssetUrl_1 = this.profileSchemaNamespaceExt.toRegistryAssetUrl(headerImp_1, registryBaseUrl);
            _builder.append(_registryAssetUrl_1, "	");
            _builder.append(".xsd\"");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("\t");
            _builder.append("namespace=\"");
            String _namespace_3 = this.profileSchemaNamespaceExt.toNamespace(headerImp_1);
            _builder.append(_namespace_3, "		");
            _builder.append("\"/>");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<xsd:annotation>");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("<xsd:documentation>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<![CDATA[Version ");
    Version _version_4 = service.getVersion();
    String _versionNumber = this._versionQualifierExtensions.toVersionNumber(_version_4);
    _builder.append(_versionNumber, "			");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("Lifecycle state: ");
    LifecycleState _state = service.getState();
    String _name = _state.getName();
    _builder.append(_name, "			");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    String _documentation = this.docProvider.getDocumentation(service);
    _builder.append(_documentation, "			");
    _builder.append("]]>");
    _builder.newLineIfNotEmpty();
    _builder.append("    \t");
    _builder.append("</xsd:documentation>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("</xsd:annotation>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    String _operationWrapperMessages = this.toOperationWrapperMessages(service, minState, profile);
    _builder.append(_operationWrapperMessages, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("</xsd:schema>");
    _builder.newLine();
    CharSequence content = _builder;
    final String xsdFileName = this._schemaTemplateExtensions.toOpWrapperXSDFileName(service);
    this.fsa.generateFile(xsdFileName, content);
  }
  
  protected String _toOperationWrapperMessages(final Service service, final LifecycleState minState, final SOAProfile profile) {
    EList<Operation> _operations = service.getOperations();
    final Function1<Operation,CharSequence> _function = new Function1<Operation,CharSequence>() {
        public CharSequence apply(final Operation e) {
          CharSequence _concreteOperationWrapperTypes = OperationWrapperTemplates.this.toConcreteOperationWrapperTypes(e, profile);
          return _concreteOperationWrapperTypes;
        }
      };
    List<CharSequence> _map = ListExtensions.<Operation, CharSequence>map(_operations, _function);
    String _join = IterableExtensions.join(_map);
    return _join;
  }
  
  protected CharSequence _toConcreteOperationWrapperTypes(final Operation op, final SOAProfile profile) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<xsd:complexType name=\"");
    String _operationWrapperRequestType = this._serviceTemplateExtensions.toOperationWrapperRequestType(op);
    _builder.append(_operationWrapperRequestType, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<xsd:sequence>");
    _builder.newLine();
    {
      MessageHeader _findBestMatchingRequestHeader = this._headerFinder.findBestMatchingRequestHeader(op, profile);
      boolean _notEquals = (!Objects.equal(_findBestMatchingRequestHeader, null));
      if (_notEquals) {
        _builder.append("\t\t");
        MessageHeader _findBestMatchingRequestHeader_1 = this._headerFinder.findBestMatchingRequestHeader(op, profile);
        CharSequence _parameter = _findBestMatchingRequestHeader_1==null?(CharSequence)null:this.toParameter(_findBestMatchingRequestHeader_1);
        _builder.append(_parameter, "		");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    EList<Parameter> _parameters = op.getParameters();
    final Function1<Parameter,CharSequence> _function = new Function1<Parameter,CharSequence>() {
        public CharSequence apply(final Parameter p) {
          CharSequence _parameter = OperationWrapperTemplates.this.toParameter(p);
          return _parameter;
        }
      };
    List<CharSequence> _map = ListExtensions.<Parameter, CharSequence>map(_parameters, _function);
    String _join = IterableExtensions.join(_map);
    _builder.append(_join, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</xsd:sequence>");
    _builder.newLine();
    _builder.append("</xsd:complexType>");
    _builder.newLine();
    _builder.append("<xsd:complexType name=\"");
    String _operationWrapperResponseType = this._serviceTemplateExtensions.toOperationWrapperResponseType(op);
    _builder.append(_operationWrapperResponseType, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<xsd:sequence>");
    _builder.newLine();
    {
      MessageHeader _findBestMatchingResponseHeader = this._headerFinder.findBestMatchingResponseHeader(op, profile);
      boolean _notEquals_1 = (!Objects.equal(_findBestMatchingResponseHeader, null));
      if (_notEquals_1) {
        _builder.append("\t\t");
        MessageHeader _findBestMatchingResponseHeader_1 = this._headerFinder.findBestMatchingResponseHeader(op, profile);
        CharSequence _parameter_1 = _findBestMatchingResponseHeader_1==null?(CharSequence)null:this.toParameter(_findBestMatchingResponseHeader_1);
        _builder.append(_parameter_1, "		");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    EList<Parameter> _return = op.getReturn();
    final Function1<Parameter,CharSequence> _function_1 = new Function1<Parameter,CharSequence>() {
        public CharSequence apply(final Parameter r) {
          CharSequence _parameter = OperationWrapperTemplates.this.toParameter(r);
          return _parameter;
        }
      };
    List<CharSequence> _map_1 = ListExtensions.<Parameter, CharSequence>map(_return, _function_1);
    String _join_1 = IterableExtensions.join(_map_1);
    _builder.append(_join_1, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</xsd:sequence>");
    _builder.newLine();
    _builder.append("</xsd:complexType>");
    _builder.newLine();
    return _builder;
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
          CharSequence _parameter = OperationWrapperTemplates.this.toParameter(p);
          return _parameter;
        }
      };
    List<CharSequence> _map = ListExtensions.<Property, CharSequence>map(_parameters, _function);
    String _join = IterableExtensions.join(_map);
    _builder.append(_join, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public void toOperationWrappersInclSubNamespaces(final String serviceName, final List<SubNamespace> namespaces, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    {
      _toOperationWrappersInclSubNamespaces(serviceName, namespaces, minState, profile, registryBaseUrl);
      return;
    }
  }
  
  public void toOperationWrappers(final SubNamespace namespace, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    {
      _toOperationWrappers(namespace, minState, profile, registryBaseUrl);
      return;
    }
  }
  
  public void toOperationWrappers(final Service service, final SubNamespace subDom, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    if (subDom instanceof DomainNamespace) {
      _toOperationWrappers(service, (DomainNamespace)subDom, minState, profile, registryBaseUrl);
      return;
    } else if (subDom instanceof InternalNamespace) {
      _toOperationWrappers(service, (InternalNamespace)subDom, minState, profile, registryBaseUrl);
      return;
    } else if (subDom != null) {
      _toOperationWrappers(service, subDom, minState, profile, registryBaseUrl);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(service, subDom, minState, profile, registryBaseUrl).toString());
    }
  }
  
  public String toOperationWrapperMessages(final Service service, final LifecycleState minState, final SOAProfile profile) {
    {
      return _toOperationWrapperMessages(service, minState, profile);
    }
  }
  
  public CharSequence toConcreteOperationWrapperTypes(final Operation op, final SOAProfile profile) {
    {
      return _toConcreteOperationWrapperTypes(op, profile);
    }
  }
  
  public CharSequence toParameter(final EObject prop) {
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
