package org.fornax.soa.servicedsl.generator.templates.xsd;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
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
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.version.VersionQualifierExtensions;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader;
import org.fornax.soa.profiledsl.sOAProfileDsl.Property;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
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
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaTypeExtensions;

@SuppressWarnings("all")
public class EventXSDTemplates {
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
  private HeaderFinder _headerFinder;
  
  @Inject
  private NamespaceImportQueries _namespaceImportQueries;
  
  @Inject
  private IEObjectDocumentationProvider docProvider;
  
  @Inject
  private Logger log;
  
  public void toEventsInclSubNamespaces(final String namespace, final List<SubNamespace> namespaces, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    final Function1<SubNamespace,Boolean> _function = new Function1<SubNamespace,Boolean>() {
        public Boolean apply(final SubNamespace e) {
          String _name = e.getName();
          boolean _startsWith = _name.startsWith(namespace);
          return Boolean.valueOf(_startsWith);
        }
      };
    Iterable<SubNamespace> _filter = IterableExtensions.<SubNamespace>filter(namespaces, _function);
    for (final SubNamespace ns : _filter) {
      this.toEvents(ns, minState, profile, registryBaseUrl);
    }
  }
  
  public void toEvents(final SubNamespace ns, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    EList<Service> _services = ns.getServices();
    final Procedure1<Service> _function = new Procedure1<Service>() {
        public void apply(final Service s) {
          EventXSDTemplates.this.toEvents(s, ns, minState, profile, registryBaseUrl);
        }
      };
    IterableExtensions.<Service>forEach(_services, _function);
  }
  
  protected void _toEvents(final Service svc, final SubNamespace subDom, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
  }
  
  protected void _toEvents(final Service svc, final DomainNamespace subDom, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<xsd:schema targetNamespace=\"");
    String _targetNamespace = this._serviceTemplateExtensions.toTargetNamespace(svc);
    _builder.append(_targetNamespace, "		");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("xmlns:jxb=\"http://java.sun.com/xml/ns/jaxb\"");
    _builder.newLine();
    {
      Version _version = svc.getVersion();
      String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_version);
      Set<VersionedDomainNamespace> _allImportedVersionedNS = this._namespaceImportQueries.allImportedVersionedNS(svc, _majorVersionNumber, minState);
      for(final VersionedDomainNamespace imp : _allImportedVersionedNS) {
        _builder.append("\t\t\t");
        _builder.append("xmlns:");
        String _prefix = this._schemaNamespaceExtensions.toPrefix(imp);
        String _version_1 = imp.getVersion();
        String _majorVersionNumber_1 = this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
        String _plus = (_prefix + _majorVersionNumber_1);
        _builder.append(_plus, "			");
        _builder.append("=\"");
        String _namespace = this._schemaTypeExtensions.toNamespace(imp);
        _builder.append(_namespace, "			");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      MessageHeader _findBestMatchingHeader = this._headerFinder.findBestMatchingHeader(svc, profile);
      boolean _notEquals = (!Objects.equal(_findBestMatchingHeader, null));
      if (_notEquals) {
        {
          MessageHeader _findBestMatchingHeader_1 = this._headerFinder.findBestMatchingHeader(svc, profile);
          Version _version_2 = svc.getVersion();
          String _majorVersionNumber_2 = this._versionQualifierExtensions.toMajorVersionNumber(_version_2);
          Set<VersionedDomainNamespace> _allImportedVersionedNS_1 = this._namespaceImportQueries.allImportedVersionedNS(_findBestMatchingHeader_1, _majorVersionNumber_2);
          for(final VersionedDomainNamespace headerImp : _allImportedVersionedNS_1) {
            _builder.append("\t\t\t");
            _builder.append("xmlns:");
            String _prefix_1 = this._schemaNamespaceExtensions.toPrefix(headerImp);
            String _version_3 = headerImp.getVersion();
            String _majorVersionNumber_3 = this._versionQualifierExtensions.toMajorVersionNumber(_version_3);
            String _plus_1 = (_prefix_1 + _majorVersionNumber_3);
            _builder.append(_plus_1, "			");
            _builder.append("=\"");
            String _namespace_1 = this._schemaTypeExtensions.toNamespace(headerImp);
            _builder.append(_namespace_1, "			");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t\t\t");
    _builder.append("elementFormDefault=\"qualified\"");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("attributeFormDefault=\"unqualified\"");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append(">");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    {
      Version _version_4 = svc.getVersion();
      String _majorVersionNumber_4 = this._versionQualifierExtensions.toMajorVersionNumber(_version_4);
      Set<VersionedDomainNamespace> _allImportedVersionedNS_2 = this._namespaceImportQueries.allImportedVersionedNS(svc, _majorVersionNumber_4, minState);
      for(final VersionedDomainNamespace imp_1 : _allImportedVersionedNS_2) {
        _builder.append("\t\t\t");
        _builder.append("<xsd:import schemaLocation=\"");
        String _registryAssetUrl = this._schemaNamespaceExtensions.toRegistryAssetUrl(imp_1, registryBaseUrl);
        _builder.append(_registryAssetUrl, "			");
        _builder.append(".xsd\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("namespace=\"");
        String _namespace_2 = this._schemaTypeExtensions.toNamespace(imp_1);
        _builder.append(_namespace_2, "				");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      MessageHeader _findBestMatchingHeader_2 = this._headerFinder.findBestMatchingHeader(svc, profile);
      boolean _notEquals_1 = (!Objects.equal(_findBestMatchingHeader_2, null));
      if (_notEquals_1) {
        {
          MessageHeader _findBestMatchingHeader_3 = this._headerFinder.findBestMatchingHeader(svc, profile);
          Version _version_5 = svc.getVersion();
          String _majorVersionNumber_5 = this._versionQualifierExtensions.toMajorVersionNumber(_version_5);
          Set<VersionedDomainNamespace> _allImportedVersionedNS_3 = this._namespaceImportQueries.allImportedVersionedNS(_findBestMatchingHeader_3, _majorVersionNumber_5);
          for(final VersionedDomainNamespace headerImp_1 : _allImportedVersionedNS_3) {
            _builder.append("\t\t\t");
            _builder.append("<xsd:import schemaLocation=\"");
            String _registryAssetUrl_1 = this._schemaNamespaceExtensions.toRegistryAssetUrl(headerImp_1, registryBaseUrl);
            _builder.append(_registryAssetUrl_1, "			");
            _builder.append(".xsd\"");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("namespace=\"");
            String _namespace_3 = this._schemaTypeExtensions.toNamespace(headerImp_1);
            _builder.append(_namespace_3, "				");
            _builder.append("\"/>");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<xsd:annotation>");
    _builder.newLine();
    _builder.append("\t\t   \t\t");
    _builder.append("<xsd:documentation>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<![CDATA[Version ");
    Version _version_6 = svc.getVersion();
    String _versionNumber = this._versionQualifierExtensions.toVersionNumber(_version_6);
    _builder.append(_versionNumber, "					");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("Lifecycle state: ");
    LifecycleState _state = svc.getState();
    String _name = _state.getName();
    _builder.append(_name, "					");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    String _documentation = this.docProvider.getDocumentation(svc);
    _builder.append(_documentation, "					");
    _builder.append("]]>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t   \t");
    _builder.append("</xsd:documentation>");
    _builder.newLine();
    _builder.append("\t\t   \t");
    _builder.append("</xsd:annotation>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    CharSequence _eventMessages = this.toEventMessages(svc, minState, profile);
    _builder.append(_eventMessages, "			");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("</xsd:schema>");
    _builder.newLine();
    final CharSequence content = _builder;
    String _fileNameFragment = this._schemaNamespaceExtensions.toFileNameFragment(svc);
    final String xsdFileName = (_fileNameFragment + "Events.xsd");
    this.fsa.generateFile(xsdFileName, content);
  }
  
  protected void _toEvents(final Service svc, final InternalNamespace subDom, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<xsd:schema targetNamespace=\"");
    String _targetNamespace = this._serviceTemplateExtensions.toTargetNamespace(svc);
    _builder.append(_targetNamespace, "		");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"");
    _builder.newLine();
    {
      Version _version = svc.getVersion();
      String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_version);
      Set<VersionedDomainNamespace> _allImportedVersionedNS = this._namespaceImportQueries.allImportedVersionedNS(svc, _majorVersionNumber, minState);
      for(final VersionedDomainNamespace imp : _allImportedVersionedNS) {
        _builder.append("\t\t\t");
        _builder.append("xmlns:");
        String _prefix = this._schemaNamespaceExtensions.toPrefix(imp);
        String _version_1 = imp.getVersion();
        String _majorVersionNumber_1 = this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
        String _plus = (_prefix + _majorVersionNumber_1);
        _builder.append(_plus, "			");
        _builder.append("=\"");
        String _namespace = this._schemaTypeExtensions.toNamespace(imp);
        _builder.append(_namespace, "			");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      MessageHeader _findBestMatchingHeader = this._headerFinder.findBestMatchingHeader(svc, profile);
      boolean _notEquals = (!Objects.equal(_findBestMatchingHeader, null));
      if (_notEquals) {
        {
          MessageHeader _findBestMatchingHeader_1 = this._headerFinder.findBestMatchingHeader(svc, profile);
          Version _version_2 = svc.getVersion();
          String _majorVersionNumber_2 = this._versionQualifierExtensions.toMajorVersionNumber(_version_2);
          Set<VersionedDomainNamespace> _allImportedVersionedNS_1 = this._namespaceImportQueries.allImportedVersionedNS(_findBestMatchingHeader_1, _majorVersionNumber_2);
          for(final VersionedDomainNamespace headerImp : _allImportedVersionedNS_1) {
            _builder.append("\t\t\t");
            _builder.append("xmlns:");
            String _prefix_1 = this._schemaNamespaceExtensions.toPrefix(headerImp);
            String _version_3 = headerImp.getVersion();
            String _majorVersionNumber_3 = this._versionQualifierExtensions.toMajorVersionNumber(_version_3);
            String _plus_1 = (_prefix_1 + _majorVersionNumber_3);
            _builder.append(_plus_1, "			");
            _builder.append("=\"");
            String _namespace_1 = this._schemaTypeExtensions.toNamespace(headerImp);
            _builder.append(_namespace_1, "			");
            _builder.append("\"");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t\t\t");
    _builder.append("elementFormDefault=\"qualified\"");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("attributeFormDefault=\"unqualified\"");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append(">");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    {
      Version _version_4 = svc.getVersion();
      String _majorVersionNumber_4 = this._versionQualifierExtensions.toMajorVersionNumber(_version_4);
      Set<VersionedDomainNamespace> _allImportedVersionedNS_2 = this._namespaceImportQueries.allImportedVersionedNS(svc, _majorVersionNumber_4, minState);
      for(final VersionedDomainNamespace imp_1 : _allImportedVersionedNS_2) {
        _builder.append("\t\t\t");
        _builder.append("<xsd:import schemaLocation=\"");
        String _registryAssetUrl = this._schemaNamespaceExtensions.toRegistryAssetUrl(imp_1, registryBaseUrl);
        _builder.append(_registryAssetUrl, "			");
        _builder.append(".xsd\"");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("namespace=\"");
        String _namespace_2 = this._schemaTypeExtensions.toNamespace(imp_1);
        _builder.append(_namespace_2, "				");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      MessageHeader _findBestMatchingHeader_2 = this._headerFinder.findBestMatchingHeader(svc, profile);
      boolean _notEquals_1 = (!Objects.equal(_findBestMatchingHeader_2, null));
      if (_notEquals_1) {
        {
          MessageHeader _findBestMatchingHeader_3 = this._headerFinder.findBestMatchingHeader(svc, profile);
          Version _version_5 = svc.getVersion();
          String _majorVersionNumber_5 = this._versionQualifierExtensions.toMajorVersionNumber(_version_5);
          Set<VersionedDomainNamespace> _allImportedVersionedNS_3 = this._namespaceImportQueries.allImportedVersionedNS(_findBestMatchingHeader_3, _majorVersionNumber_5);
          for(final VersionedDomainNamespace headerImp_1 : _allImportedVersionedNS_3) {
            _builder.append("\t\t\t");
            _builder.append("<xsd:import schemaLocation=\"");
            String _registryAssetUrl_1 = this._schemaNamespaceExtensions.toRegistryAssetUrl(headerImp_1, registryBaseUrl);
            _builder.append(_registryAssetUrl_1, "			");
            _builder.append(".xsd\"");
            _builder.newLineIfNotEmpty();
            _builder.append("\t\t\t");
            _builder.append("\t");
            _builder.append("namespace=\"");
            String _namespace_3 = this._schemaTypeExtensions.toNamespace(headerImp_1);
            _builder.append(_namespace_3, "				");
            _builder.append("\"/>");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<xsd:annotation>");
    _builder.newLine();
    _builder.append("\t\t    \t");
    _builder.append("<xsd:documentation>");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("<![CDATA[Version ");
    Version _version_6 = svc.getVersion();
    String _versionNumber = this._versionQualifierExtensions.toVersionNumber(_version_6);
    _builder.append(_versionNumber, "					");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.append("Lifecycle state: ");
    LifecycleState _state = svc.getState();
    String _name = _state.getName();
    _builder.append(_name, "					");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    String _documentation = this.docProvider.getDocumentation(svc);
    _builder.append(_documentation, "					");
    _builder.append("]]>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t    \t");
    _builder.append("</xsd:documentation>");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("</xsd:annotation>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    CharSequence _eventMessages = this.toEventMessages(svc, minState, profile);
    _builder.append(_eventMessages, "			");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("</xsd:schema>");
    _builder.newLine();
    final CharSequence content = _builder;
    String _fileNameFragment = this._schemaNamespaceExtensions.toFileNameFragment(subDom);
    String _plus_2 = (_fileNameFragment + "-");
    String _name_1 = svc.getName();
    String _plus_3 = (_plus_2 + _name_1);
    String _plus_4 = (_plus_3 + "-");
    Version _version_7 = svc.getVersion();
    String _versionPostfix = this._versionQualifierExtensions.toVersionPostfix(_version_7);
    String _plus_5 = (_plus_4 + _versionPostfix);
    final String xsdFileName = (_plus_5 + "Events.xsd");
    this.fsa.generateFile(xsdFileName, content);
  }
  
  public CharSequence toEventMessages(final Service svc, final LifecycleState minState, final SOAProfile profile) {
    StringConcatenation _builder = new StringConcatenation();
    EList<Operation> _operations = svc.getOperations();
    final Function1<Operation,CharSequence> _function = new Function1<Operation,CharSequence>() {
        public CharSequence apply(final Operation o) {
          CharSequence _operationWrapperTypes = EventXSDTemplates.this.toOperationWrapperTypes(o, profile);
          return _operationWrapperTypes;
        }
      };
    List<CharSequence> _map = ListExtensions.<Operation, CharSequence>map(_operations, _function);
    String _join = IterableExtensions.join(_map);
    _builder.append(_join, "");
    _builder.newLineIfNotEmpty();
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
        public CharSequence apply(final String o) {
          EList<Operation> _operations = svc.getOperations();
          final Function1<Operation,EList<ExceptionRef>> _function = new Function1<Operation,EList<ExceptionRef>>() {
              public EList<ExceptionRef> apply(final Operation op) {
                EList<ExceptionRef> _throws = op.getThrows();
                return _throws;
              }
            };
          List<EList<ExceptionRef>> _map = ListExtensions.<Operation, EList<ExceptionRef>>map(_operations, _function);
          Iterable<ExceptionRef> _flatten = Iterables.<ExceptionRef>concat(_map);
          List<ExceptionRef> _list = IterableExtensions.<ExceptionRef>toList(_flatten);
          CharSequence _operationFaultWrapperTypes = EventXSDTemplates.this.toOperationFaultWrapperTypes(o, _list);
          return _operationFaultWrapperTypes;
        }
      };
    Iterable<CharSequence> _map_3 = IterableExtensions.<String, CharSequence>map(_set, _function_3);
    String _join_1 = IterableExtensions.join(_map_3);
    _builder.append(_join_1, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence toOperationWrapperTypes(final Operation op, final SOAProfile profile) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<xsd:element name=\"");
    String _name = op.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<xsd:complexType>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<xsd:sequence>");
    _builder.newLine();
    {
      MessageHeader _findBestMatchingHeader = this._headerFinder.findBestMatchingHeader(op, profile);
      boolean _notEquals = (!Objects.equal(_findBestMatchingHeader, null));
      if (_notEquals) {
        _builder.append("\t\t\t");
        MessageHeader _findBestMatchingHeader_1 = this._headerFinder.findBestMatchingHeader(op, profile);
        CharSequence _parameter = this.toParameter(_findBestMatchingHeader_1);
        _builder.append(_parameter, "			");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    EList<Parameter> _parameters = op.getParameters();
    final Function1<Parameter,CharSequence> _function = new Function1<Parameter,CharSequence>() {
        public CharSequence apply(final Parameter p) {
          CharSequence _parameter = EventXSDTemplates.this.toParameter(p);
          return _parameter;
        }
      };
    List<CharSequence> _map = ListExtensions.<Parameter, CharSequence>map(_parameters, _function);
    String _join = IterableExtensions.join(_map);
    _builder.append(_join, "			");
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
    String _firstUpper_1 = StringExtensions.toFirstUpper(_name_1);
    _builder.append(_firstUpper_1, "");
    _builder.append("Response\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<xsd:complexType>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<xsd:sequence>");
    _builder.newLine();
    {
      MessageHeader _findBestMatchingHeader_2 = this._headerFinder.findBestMatchingHeader(op, profile);
      boolean _notEquals_1 = (!Objects.equal(_findBestMatchingHeader_2, null));
      if (_notEquals_1) {
        _builder.append("\t\t\t");
        MessageHeader _findBestMatchingHeader_3 = this._headerFinder.findBestMatchingHeader(op, profile);
        CharSequence _parameter_1 = this.toParameter(_findBestMatchingHeader_3);
        _builder.append(_parameter_1, "			");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t");
    EList<Parameter> _return = op.getReturn();
    final Function1<Parameter,CharSequence> _function_1 = new Function1<Parameter,CharSequence>() {
        public CharSequence apply(final Parameter r) {
          CharSequence _parameter = EventXSDTemplates.this.toParameter(r);
          return _parameter;
        }
      };
    List<CharSequence> _map_1 = _return==null?(List<CharSequence>)null:ListExtensions.<Parameter, CharSequence>map(_return, _function_1);
    String _join_1 = IterableExtensions.join(_map_1);
    _builder.append(_join_1, "			");
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
  
  public CharSequence toOperationFaultWrapperTypes(final String faultName, final List<ExceptionRef> exceptions) {
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
    _builder.append("<xsd:element param.name=\"");
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
          CharSequence _parameter = EventXSDTemplates.this.toParameter(p);
          return _parameter;
        }
      };
    List<CharSequence> _map = ListExtensions.<Property, CharSequence>map(_parameters, _function);
    String _join = IterableExtensions.join(_map);
    _builder.append(_join, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public void toEvents(final Service svc, final SubNamespace subDom, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    if (subDom instanceof DomainNamespace) {
      _toEvents(svc, (DomainNamespace)subDom, minState, profile, registryBaseUrl);
      return;
    } else if (subDom instanceof InternalNamespace) {
      _toEvents(svc, (InternalNamespace)subDom, minState, profile, registryBaseUrl);
      return;
    } else if (subDom != null) {
      _toEvents(svc, subDom, minState, profile, registryBaseUrl);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(svc, subDom, minState, profile, registryBaseUrl).toString());
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
