package org.fornax.soa.bindingdsl.generator.templates.soap;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
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
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver;
import org.fornax.soa.bindingDsl.Binding;
import org.fornax.soa.bindingDsl.BindingProtocol;
import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.bindingDsl.ModuleRef;
import org.fornax.soa.bindingDsl.SOAP;
import org.fornax.soa.bindingDsl.ServiceBinding;
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions;
import org.fornax.soa.bindingdsl.generator.templates.naming.DefaultEndpointQualifierNameProvider;
import org.fornax.soa.bindingdsl.generator.templates.soap.SoapBindingResolver;
import org.fornax.soa.bindingdsl.generator.templates.soap.SoapEndpointAddressResolver;
import org.fornax.soa.bindingdsl.generator.templates.wsdl.ConcreteWsdlFileNameProvider;
import org.fornax.soa.environmentDsl.Server;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.serviceDsl.ExceptionRef;
import org.fornax.soa.serviceDsl.Operation;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.Type;
import org.fornax.soa.servicedsl.generator.templates.webservice.ServiceTemplateExtensions;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaTypeExtensions;

/**
 * Generate concrete public endpoint WSDLs that define port, binding and service endpoint for each elegible service
 * from a DomainBinding or ModuleBinding. Whether a service is eligible is determined from it's lifecycle state checking
 * whether the state is supported in the bindings target environment.<br/><br/>
 * 
 * Each concrete WSDL imports the abstract WSDL of the respective service. Generation of the abstract WSDL is being
 * delegated to the Service DSL generator.
 */
@SuppressWarnings("all")
public class ConcreteWsdlGenerator {
  @Inject
  private BindingExtensions _bindingExtensions;
  
  @Inject
  private ConcreteWsdlFileNameProvider _concreteWsdlFileNameProvider;
  
  @Inject
  private SoapBindingResolver _soapBindingResolver;
  
  @Inject
  private SchemaNamespaceExtensions _schemaNamespaceExtensions;
  
  @Inject
  private SchemaTypeExtensions _schemaTypeExtensions;
  
  @Inject
  private ServiceTemplateExtensions _serviceTemplateExtensions;
  
  @Inject
  private SoapEndpointAddressResolver _soapEndpointAddressResolver;
  
  @Inject
  private EnvironmentBindingResolver _environmentBindingResolver;
  
  @Inject
  private DefaultEndpointQualifierNameProvider _defaultEndpointQualifierNameProvider;
  
  @Inject
  private VersionQualifierExtensions versionQualifier;
  
  @Inject
  private IEObjectDocumentationProvider docProvider;
  
  @Inject
  private IFileSystemAccess fsa;
  
  /**
   * Generate a concrete pubplic endpoint WSDL for a service bound by a ModuleBinding
   * with the given protocol definition applying the supplied profile
   */
  protected void _toWSDL(final ModuleBinding binding, final Service svc, final SOAP prot, final SOAProfile profile) {
    this.toWSDL(svc, binding, prot, profile);
  }
  
  protected void _toWSDL(final Service svc, final ServiceBinding svcBind, final SOAP prot, final SOAProfile profile) {
    String _concreteWsdlFileNameFragment = this._concreteWsdlFileNameProvider.getConcreteWsdlFileNameFragment(svc, svcBind, prot);
    final String wsdlFile = (_concreteWsdlFileNameFragment + ".wsdl");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    _builder.newLine();
    _builder.append("<wsdl:definitions xmlns:soap=\"http://schemas.xmlsoap.org/wsdl/soap/\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:tns=\"");
    String _targetNamespace = this._serviceTemplateExtensions.toTargetNamespace(svc);
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
    _builder.append("name=\"");
    String _name = svc.getName();
    _builder.append(_name, "	");
    _builder.append("\" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("targetNamespace=\"");
    String _targetNamespace_1 = this._serviceTemplateExtensions.toTargetNamespace(svc);
    _builder.append(_targetNamespace_1, "	");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<wsdl:documentation>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Version ");
    Version _version = svc.getVersion();
    String _versionNumber = this.versionQualifier.toVersionNumber(_version);
    _builder.append(_versionNumber, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("Lifecycle state: ");
    LifecycleState _state = svc.getState();
    String _string = _state.toString();
    _builder.append(_string, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    String _documentation = this.docProvider.getDocumentation(svc);
    _builder.append(_documentation, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</wsdl:documentation>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<wsdl:import namespace=\"");
    String _targetNamespace_2 = this._serviceTemplateExtensions.toTargetNamespace(svc);
    _builder.append(_targetNamespace_2, "    ");
    _builder.append("\" location=\"");
    String _registryBaseUrl = this._bindingExtensions.getRegistryBaseUrl(svcBind);
    String _registryAssetUrl = this._schemaNamespaceExtensions.toRegistryAssetUrl(svc, _registryBaseUrl);
    _builder.append(_registryAssetUrl, "    ");
    _builder.append(".wsdl\"></wsdl:import>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    EList<BindingProtocol> _protocol = svcBind.getProtocol();
    Iterable<SOAP> _filter = Iterables.<SOAP>filter(_protocol, SOAP.class);
    final Function1<SOAP,Object> _function = new Function1<SOAP,Object>() {
        public Object apply(final SOAP p) {
          Object _sOAPBinding = ConcreteWsdlGenerator.this.toSOAPBinding(p, svc);
          return _sOAPBinding;
        }
      };
    Iterable<Object> _map = IterableExtensions.<SOAP, Object>map(_filter, _function);
    String _join = IterableExtensions.join(_map);
    _builder.append(_join, "	");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    EList<BindingProtocol> _protocol_1 = svcBind.getProtocol();
    Iterable<SOAP> _filter_1 = Iterables.<SOAP>filter(_protocol_1, SOAP.class);
    final Function1<SOAP,Object> _function_1 = new Function1<SOAP,Object>() {
        public Object apply(final SOAP p) {
          Server _resolveServer = ConcreteWsdlGenerator.this._environmentBindingResolver.resolveServer(svcBind);
          Object _wsdlService = ConcreteWsdlGenerator.this.toWsdlService(p, svc, _resolveServer, svcBind);
          return _wsdlService;
        }
      };
    Iterable<Object> _map_1 = IterableExtensions.<SOAP, Object>map(_filter_1, _function_1);
    String _join_1 = IterableExtensions.join(_map_1);
    _builder.append(_join_1, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("</wsdl:definitions>");
    _builder.newLine();
    final CharSequence content = _builder;
    this.fsa.generateFile(wsdlFile, content);
  }
  
  protected void _toWSDL(final Service svc, final ModuleBinding modBind, final BindingProtocol prot, final SOAProfile profile) {
    String _concreteWsdlFileNameFragment = this._concreteWsdlFileNameProvider.getConcreteWsdlFileNameFragment(svc, modBind, prot);
    final String wsdlFile = (_concreteWsdlFileNameFragment + ".wsdl");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    _builder.newLine();
    _builder.append("<wsdl:definitions xmlns:soap=\"http://schemas.xmlsoap.org/wsdl/soap/\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:tns=\"");
    String _targetNamespace = this._serviceTemplateExtensions.toTargetNamespace(svc);
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
    _builder.append("name=\"");
    String _name = svc.getName();
    _builder.append(_name, "	");
    _builder.append("\" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("targetNamespace=\"");
    String _targetNamespace_1 = this._serviceTemplateExtensions.toTargetNamespace(svc);
    _builder.append(_targetNamespace_1, "	");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<wsdl:documentation>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Version ");
    Version _version = svc.getVersion();
    String _versionNumber = this.versionQualifier.toVersionNumber(_version);
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
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</wsdl:documentation>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<wsdl:import namespace=\"");
    String _targetNamespace_2 = this._serviceTemplateExtensions.toTargetNamespace(svc);
    _builder.append(_targetNamespace_2, "    ");
    _builder.append("\" location=\"");
    String _registryBaseUrl = this._bindingExtensions.getRegistryBaseUrl(modBind);
    String _registryAssetUrl = this._schemaNamespaceExtensions.toRegistryAssetUrl(svc, _registryBaseUrl);
    _builder.append(_registryAssetUrl, "    ");
    _builder.append(".wsdl\"></wsdl:import>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    String _endpointQualifierName = this._defaultEndpointQualifierNameProvider.getEndpointQualifierName(modBind, svc, prot);
    Object _sOAPBinding = this.toSOAPBinding(prot, svc, _endpointQualifierName);
    _builder.append(_sOAPBinding, "	");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    Server _resolveServer = this._environmentBindingResolver.resolveServer(modBind);
    Object _wsdlService = this.toWsdlService(prot, svc, _resolveServer, modBind);
    _builder.append(_wsdlService, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("</wsdl:definitions>");
    _builder.newLine();
    final CharSequence content = _builder;
    this.fsa.generateFile(wsdlFile, content);
  }
  
  protected void _toSOAPBinding(final BindingProtocol protocol, final Service svc) {
  }
  
  protected void _toSOAPBinding(final BindingProtocol protocol, final Service svc, final String qualifierName) {
  }
  
  protected Object _toSOAPBinding(final SOAP protocol, final Service svc) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<wsdl:binding name=\"");
    String _bindingName = this._soapBindingResolver.toBindingName(svc, protocol);
    _builder.append(_bindingName, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("type=\"tns:");
    String _name = svc.getName();
    _builder.append(_name, "	");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<soap:binding style=\"");
    String _wsdlBindingStyle = this._soapBindingResolver.getWsdlBindingStyle(protocol);
    _builder.append(_wsdlBindingStyle, "	");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("transport=\"http://schemas.xmlsoap.org/soap/http\" />");
    _builder.newLine();
    _builder.append("\t");
    EList<Operation> _operations = svc.getOperations();
    final Function1<Operation,CharSequence> _function = new Function1<Operation,CharSequence>() {
        public CharSequence apply(final Operation o) {
          CharSequence _sOAPBindingOperation = ConcreteWsdlGenerator.this.toSOAPBindingOperation(o, protocol);
          return _sOAPBindingOperation;
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
  
  protected Object _toSOAPBinding(final SOAP protocol, final Service svc, final String qualifierName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<wsdl:binding name=\"");
    String _bindingName = this._soapBindingResolver.toBindingName(svc, protocol, qualifierName);
    _builder.append(_bindingName, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("type=\"tns:");
    String _name = svc.getName();
    _builder.append(_name, "	");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<soap:binding style=\"");
    String _wsdlBindingStyle = this._soapBindingResolver.getWsdlBindingStyle(protocol);
    _builder.append(_wsdlBindingStyle, "	");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("transport=\"http://schemas.xmlsoap.org/soap/http\" />");
    _builder.newLine();
    _builder.append("\t");
    EList<Operation> _operations = svc.getOperations();
    final Function1<Operation,CharSequence> _function = new Function1<Operation,CharSequence>() {
        public CharSequence apply(final Operation o) {
          CharSequence _sOAPBindingOperation = ConcreteWsdlGenerator.this.toSOAPBindingOperation(o, protocol);
          return _sOAPBindingOperation;
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
  
  public CharSequence toSOAPBindingOperation(final Operation op, final SOAP protocol) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
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
    String _targetNamespace = this._serviceTemplateExtensions.toTargetNamespace(_eContainer);
    _builder.append(_targetNamespace, "		");
    String _name_1 = op.getName();
    _builder.append(_name_1, "		");
    _builder.append("\" />");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<wsdl:input>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<soap:body use=\"");
    String _soapEncoding = this._soapBindingResolver.getSoapEncoding(protocol);
    _builder.append(_soapEncoding, "		");
    _builder.append("\" />");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</wsdl:input>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<wsdl:output>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<soap:body use=\"");
    String _soapEncoding_1 = this._soapBindingResolver.getSoapEncoding(protocol);
    _builder.append(_soapEncoding_1, "		");
    _builder.append("\" />");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</wsdl:output>");
    _builder.newLine();
    {
      EList<ExceptionRef> _throws = op.getThrows();
      for(final ExceptionRef fault : _throws) {
        _builder.append("\t");
        _builder.append("<wsdl:fault name=\"");
        org.fornax.soa.serviceDsl.Exception _exception = fault.getException();
        String _name_2 = _exception.getName();
        String _firstLower = StringExtensions.toFirstLower(_name_2);
        _builder.append(_firstLower, "	");
        _builder.append("\">");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("<soap:fault name=\"");
        org.fornax.soa.serviceDsl.Exception _exception_1 = fault.getException();
        String _name_3 = _exception_1.getName();
        String _firstLower_1 = StringExtensions.toFirstLower(_name_3);
        _builder.append(_firstLower_1, "		");
        _builder.append("\" use=\"");
        String _soapEncoding_2 = this._soapBindingResolver.getSoapEncoding(protocol);
        _builder.append(_soapEncoding_2, "		");
        _builder.append("\"/>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("</wsdl:fault>");
        _builder.newLine();
      }
    }
    _builder.append("</wsdl:operation>");
    _builder.newLine();
    return _builder;
  }
  
  protected Object _toWsdlService(final BindingProtocol protocol, final Service svc) {
    return null;
  }
  
  protected CharSequence _toWsdlService(final BindingProtocol protocol, final Service svc, final String qualifierName) {
    return null;
  }
  
  protected CharSequence _toWsdlService(final SOAP protocol, final Service svc, final Binding bind) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<wsdl:service name=\"");
    String _name = svc.getName();
    _builder.append(_name, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<wsdl:port binding=\"tns:");
    String _bindingName = this._soapBindingResolver.toBindingName(svc, protocol);
    _builder.append(_bindingName, "	");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("name=\"");
    String _scopedPortName = this._soapBindingResolver.toScopedPortName(svc, bind, protocol);
    _builder.append(_scopedPortName, "		");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<soap:address location=\"");
    EObject _eContainer = protocol.eContainer();
    String _endpointAddress = this._soapEndpointAddressResolver.toEndpointAddress(svc, _eContainer);
    _builder.append(_endpointAddress, "		");
    _builder.append("\" />");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</wsdl:port>");
    _builder.newLine();
    _builder.append("</wsdl:service>");
    _builder.newLine();
    return _builder;
  }
  
  protected Object _toWsdlService(final SOAP protocol, final Service svc, final String qualifierName, final Binding bind) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<wsdl:service name=\"");
    String _name = svc.getName();
    _builder.append(_name, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<wsdl:port binding=\"tns:");
    String _bindingName = this._soapBindingResolver.toBindingName(svc, protocol, qualifierName);
    _builder.append(_bindingName, "	");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("name=\"");
    String _scopedPortName = this._soapBindingResolver.toScopedPortName(svc, bind, protocol, qualifierName);
    _builder.append(_scopedPortName, "		");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<soap:address location=\"");
    EObject _eContainer = protocol.eContainer();
    String _endpointAddress = this._soapEndpointAddressResolver.toEndpointAddress(svc, _eContainer);
    _builder.append(_endpointAddress, "		");
    _builder.append("\" />");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</wsdl:port>");
    _builder.newLine();
    _builder.append("</wsdl:service>");
    _builder.newLine();
    return _builder;
  }
  
  protected void _toWsdlService(final BindingProtocol protocol, final Service svc, final Server server, final ModuleBinding bind) {
  }
  
  protected Object _toWsdlService(final SOAP protocol, final Service svc, final Server server, final ModuleBinding bind) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<wsdl:service name=\"");
    String _name = svc.getName();
    _builder.append(_name, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<wsdl:port binding=\"tns:");
    String _endpointQualifierName = this._defaultEndpointQualifierNameProvider.getEndpointQualifierName(bind, svc, protocol);
    String _bindingName = this._soapBindingResolver.toBindingName(svc, protocol, _endpointQualifierName);
    _builder.append(_bindingName, "	");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("name=\"");
    String _endpointQualifierName_1 = this._defaultEndpointQualifierNameProvider.getEndpointQualifierName(bind, svc, protocol);
    String _scopedPortName = this._soapBindingResolver.toScopedPortName(svc, bind, protocol, _endpointQualifierName_1);
    _builder.append(_scopedPortName, "		");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("<soap:address location=\"");
    ModuleRef _module = bind.getModule();
    Module _module_1 = _module.getModule();
    String _endpointAddress = this._soapEndpointAddressResolver.toEndpointAddress(svc, server, protocol, _module_1);
    _builder.append(_endpointAddress, "		");
    _builder.append("\" />");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</wsdl:port>");
    _builder.newLine();
    _builder.append("</wsdl:service>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence toSecPolicies(final Type type) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<wsp:Policy wsu:Id=\"UP_policy\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">");
    _builder.newLine();
    _builder.newLine();
    _builder.append("</wsp:Policy>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence toTransportPolicy(final Type type) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<sp:TransportBinding");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<wsp:Policy>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<sp:TransportToken>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<wsp:Policy>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<sp:HttpsToken />");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</wsp:Policy>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</sp:TransportToken>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<sp:Layout>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<wsp:Policy>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<sp:Strict />");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</wsp:Policy>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</sp:Layout>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<sp:AlgorithmSuite>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<wsp:Policy>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<sp:Basic128 />");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</wsp:Policy>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</sp:AlgorithmSuite>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</wsp:Policy>");
    _builder.newLine();
    _builder.append("</sp:TransportBinding>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence toAuthPolicy(final Type type) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<sp:SupportingTokens");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<wsp:Policy>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<sp:UsernameToken");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("xmlns:sp=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy\"");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("sp:IncludeToken=\"http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/Always\">");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<wsp:Policy>");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("<sp:WssUsernameToken11 />");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("</wsp:Policy>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</sp:UsernameToken>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</wsp:Policy>");
    _builder.newLine();
    _builder.append("</sp:SupportingTokens>");
    _builder.newLine();
    return _builder;
  }
  
  public void toWSDL(final EObject binding, final EObject svc, final BindingProtocol prot, final SOAProfile profile) {
    if (binding instanceof ModuleBinding
         && svc instanceof Service
         && prot instanceof SOAP) {
      _toWSDL((ModuleBinding)binding, (Service)svc, (SOAP)prot, profile);
      return;
    } else if (binding instanceof Service
         && svc instanceof ServiceBinding
         && prot instanceof SOAP) {
      _toWSDL((Service)binding, (ServiceBinding)svc, (SOAP)prot, profile);
      return;
    } else if (binding instanceof Service
         && svc instanceof ModuleBinding
         && prot != null) {
      _toWSDL((Service)binding, (ModuleBinding)svc, prot, profile);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(binding, svc, prot, profile).toString());
    }
  }
  
  public Object toSOAPBinding(final BindingProtocol protocol, final Service svc) {
    if (protocol instanceof SOAP) {
      return _toSOAPBinding((SOAP)protocol, svc);
    } else if (protocol != null) {
      _toSOAPBinding(protocol, svc);
      return null;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(protocol, svc).toString());
    }
  }
  
  public Object toSOAPBinding(final BindingProtocol protocol, final Service svc, final String qualifierName) {
    if (protocol instanceof SOAP) {
      return _toSOAPBinding((SOAP)protocol, svc, qualifierName);
    } else if (protocol != null) {
      _toSOAPBinding(protocol, svc, qualifierName);
      return null;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(protocol, svc, qualifierName).toString());
    }
  }
  
  public Object toWsdlService(final BindingProtocol protocol, final Service svc) {
    {
      return _toWsdlService(protocol, svc);
    }
  }
  
  public CharSequence toWsdlService(final BindingProtocol protocol, final Service svc, final Object bind) {
    if (protocol instanceof SOAP
         && bind instanceof Binding) {
      return _toWsdlService((SOAP)protocol, svc, (Binding)bind);
    } else if (protocol != null
         && bind instanceof String) {
      return _toWsdlService(protocol, svc, (String)bind);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(protocol, svc, bind).toString());
    }
  }
  
  public Object toWsdlService(final BindingProtocol protocol, final Service svc, final Object server, final Binding bind) {
    if (protocol instanceof SOAP
         && server instanceof Server
         && bind instanceof ModuleBinding) {
      return _toWsdlService((SOAP)protocol, svc, (Server)server, (ModuleBinding)bind);
    } else if (protocol instanceof SOAP
         && server instanceof String
         && bind != null) {
      return _toWsdlService((SOAP)protocol, svc, (String)server, bind);
    } else if (protocol != null
         && server instanceof Server
         && bind instanceof ModuleBinding) {
      _toWsdlService(protocol, svc, (Server)server, (ModuleBinding)bind);
      return null;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(protocol, svc, server, bind).toString());
    }
  }
}
