package org.fornax.soa.bindingdsl.generator.templates.vendor.ibm;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.fornax.soa.binding.query.BindingLookup;
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver;
import org.fornax.soa.bindingDsl.Binding;
import org.fornax.soa.bindingDsl.BindingProtocol;
import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.bindingDsl.ModuleRef;
import org.fornax.soa.bindingDsl.SCA;
import org.fornax.soa.bindingDsl.SOAP;
import org.fornax.soa.bindingdsl.generator.templates.soap.SoapBindingResolver;
import org.fornax.soa.bindingdsl.generator.templates.vendor.ibm.SCAExportExtension;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.moduledsl.moduleDsl.AssemblyType;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.moduledsl.moduleDsl.ServiceRef;
import org.fornax.soa.moduledsl.query.IModuleServiceResolver;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.servicedsl.generator.templates.webservice.ServiceTemplateExtensions;

/**
 * Generator for IBM SCA export components for the IBM WebSphere ESB. For each service provided from the module referenced in the binding
 * that supports an SCA protocol and is eligible for the bindings target environment as of their lifecycle state
 * an SCA export component is being generated.
 */
@SuppressWarnings("all")
public class SCAExportTemplates {
  @Inject
  private BindingLookup _bindingLookup;
  
  @Inject
  private IModuleServiceResolver _iModuleServiceResolver;
  
  @Inject
  private ServiceTemplateExtensions _serviceTemplateExtensions;
  
  @Inject
  private SCAExportExtension _sCAExportExtension;
  
  @Inject
  private SoapBindingResolver _soapBindingResolver;
  
  @Inject
  private EnvironmentBindingResolver _environmentBindingResolver;
  
  @Inject
  private IFileSystemAccess fsa;
  
  protected void _toSCAModuleExport(final BindingProtocol protocol, final SOAProfile profile) {
  }
  
  protected void _toSCAModuleExport(final ModuleBinding binding, final SOAProfile profile) {
    ModuleRef _module = binding.getModule();
    Module _module_1 = _module.getModule();
    AssemblyType _assemblyType = _module_1.getAssemblyType();
    boolean _equals = Objects.equal(_assemblyType, AssemblyType.SCA_EAR);
    if (_equals) {
      ModuleRef _module_2 = binding.getModule();
      Module _module_3 = _module_2.getModule();
      EList<ServiceRef> _providedServices = _module_3.getProvidedServices();
      for (final ServiceRef provSvc : _providedServices) {
        {
          Environment _resolveEnvironment = this._environmentBindingResolver.resolveEnvironment(binding);
          final Service svc = this._iModuleServiceResolver.resolveModuleServiceRef(provSvc, _resolveEnvironment);
          boolean _notEquals = (!Objects.equal(svc, null));
          if (_notEquals) {
            Binding _mostSpecificBinding = this._bindingLookup.getMostSpecificBinding(svc, binding);
            EList<BindingProtocol> _protocol = _mostSpecificBinding.getProtocol();
            final Procedure1<BindingProtocol> _function = new Procedure1<BindingProtocol>() {
                public void apply(final BindingProtocol p) {
                  SCAExportTemplates.this.toServiceExport(p, binding, svc, profile);
                }
              };
            IterableExtensions.<BindingProtocol>forEach(_protocol, _function);
          }
        }
      }
    }
  }
  
  protected void _toServiceExport(final BindingProtocol protocol, final ModuleBinding modBind, final Service svc, final SOAProfile profile) {
  }
  
  protected void _toServiceExport(final SOAP protocol, final ModuleBinding modBind, final Service svc, final SOAProfile profile) {
    final String exportFile = this._sCAExportExtension.getExportFileName(svc, protocol);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<scdl:export ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("xmlns:jaxws=\"http://www.ibm.com/xmlns/prod/websphere/scdl/jaxws/6.0.0\" ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("xmlns:ns1=\"");
    String _targetNamespace = this._serviceTemplateExtensions.toTargetNamespace(svc);
    _builder.append(_targetNamespace, "		");
    _builder.append("\" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("xmlns:scdl=\"http://www.ibm.com/xmlns/prod/websphere/scdl/6.0.0\" ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("xmlns:wsdl=\"http://www.ibm.com/xmlns/prod/websphere/scdl/wsdl/6.0.0\" ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("displayName=\"");
    String _exportDisplayName = this._sCAExportExtension.getExportDisplayName(svc, protocol);
    _builder.append(_exportDisplayName, "		");
    _builder.append("\" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("name=\"");
    String _exportName = this._sCAExportExtension.getExportName(svc, protocol);
    _builder.append(_exportName, "		");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("> ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<interfaces>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<interface xsi:type=\"wsdl:WSDLPortType\" preferredInteractionStyle=\"sync\" portType=\"ns1:");
    String _name = svc.getName();
    _builder.append(_name, "		");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</interfaces>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<esbBinding xsi:type=\"jaxws:JaxWsExportBinding\" port=\"ns1:");
    String _scopedPortName = this._soapBindingResolver.toScopedPortName(svc, modBind, protocol);
    _builder.append(_scopedPortName, "	");
    _builder.append("\" service=\"ns1:");
    String _name_1 = svc.getName();
    _builder.append(_name_1, "	");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("</scdl:export>");
    _builder.newLine();
    final CharSequence content = _builder;
    this.fsa.generateFile(exportFile, content);
  }
  
  protected void _toServiceExport(final SCA protocol, final ModuleBinding modBind, final Service svc, final SOAProfile profile) {
    final String exportFile = this._sCAExportExtension.getExportFileName(svc, protocol);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<scdl:export ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("xmlns:jaxws=\"http://www.ibm.com/xmlns/prod/websphere/scdl/jaxws/6.0.0\" ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("xmlns:ns1=\"");
    String _targetNamespace = this._serviceTemplateExtensions.toTargetNamespace(svc);
    _builder.append(_targetNamespace, "		");
    _builder.append("\" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("xmlns:scdl=\"http://www.ibm.com/xmlns/prod/websphere/scdl/6.0.0\" ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("xmlns:wsdl=\"http://www.ibm.com/xmlns/prod/websphere/scdl/wsdl/6.0.0\" ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("displayName=\"");
    String _exportDisplayName = this._sCAExportExtension.getExportDisplayName(svc, protocol);
    _builder.append(_exportDisplayName, "		");
    _builder.append("\" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("name=\"");
    String _exportName = this._sCAExportExtension.getExportName(svc, protocol);
    _builder.append(_exportName, "		");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("> ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<interfaces>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<interface xsi:type=\"wsdl:WSDLPortType\" preferredInteractionStyle=\"sync\" portType=\"ns1:");
    String _name = svc.getName();
    _builder.append(_name, "		");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</interfaces>");
    _builder.newLine();
    _builder.append("</scdl:export>");
    _builder.newLine();
    final CharSequence content = _builder;
    this.fsa.generateFile(exportFile, content);
  }
  
  protected void _toSCAModuleExport(final SCA protocol) {
  }
  
  public void toSCAModuleExport(final EObject binding, final SOAProfile profile) {
    if (binding instanceof ModuleBinding) {
      _toSCAModuleExport((ModuleBinding)binding, profile);
      return;
    } else if (binding instanceof BindingProtocol) {
      _toSCAModuleExport((BindingProtocol)binding, profile);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(binding, profile).toString());
    }
  }
  
  public void toServiceExport(final BindingProtocol protocol, final ModuleBinding modBind, final Service svc, final SOAProfile profile) {
    if (protocol instanceof SCA) {
      _toServiceExport((SCA)protocol, modBind, svc, profile);
      return;
    } else if (protocol instanceof SOAP) {
      _toServiceExport((SOAP)protocol, modBind, svc, profile);
      return;
    } else if (protocol != null) {
      _toServiceExport(protocol, modBind, svc, profile);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(protocol, modBind, svc, profile).toString());
    }
  }
  
  public void toSCAModuleExport(final SCA protocol) {
    {
      _toSCAModuleExport(protocol);
      return;
    }
  }
}
