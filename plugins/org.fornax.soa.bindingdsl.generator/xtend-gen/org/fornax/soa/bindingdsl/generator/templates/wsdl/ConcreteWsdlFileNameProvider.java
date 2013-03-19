package org.fornax.soa.bindingdsl.generator.templates.wsdl;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.binding.query.BindingLookup;
import org.fornax.soa.bindingDsl.Binding;
import org.fornax.soa.bindingDsl.BindingProtocol;
import org.fornax.soa.bindingDsl.SOAP;
import org.fornax.soa.bindingdsl.generator.templates.naming.IEndpointQualifierNameProvider;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions;

@SuppressWarnings("all")
public class ConcreteWsdlFileNameProvider {
  @Inject
  private BindingLookup _bindingLookup;
  
  @Inject
  private IEndpointQualifierNameProvider _iEndpointQualifierNameProvider;
  
  @Inject
  private SchemaNamespaceExtensions _schemaNamespaceExtensions;
  
  public String getConcreteWsdlFileNameFragment(final Service service, final Binding binding) {
    Binding specBinding = this._bindingLookup.getMostSpecificBinding(service, binding);
    EList<BindingProtocol> _protocol = specBinding.getProtocol();
    final Function1<BindingProtocol,Boolean> _function = new Function1<BindingProtocol,Boolean>() {
        public Boolean apply(final BindingProtocol p) {
          return Boolean.valueOf((p instanceof SOAP));
        }
      };
    Iterable<BindingProtocol> _filter = IterableExtensions.<BindingProtocol>filter(_protocol, _function);
    final Function1<BindingProtocol,SOAP> _function_1 = new Function1<BindingProtocol,SOAP>() {
        public SOAP apply(final BindingProtocol e) {
          return ((SOAP) e);
        }
      };
    Iterable<SOAP> _map = IterableExtensions.<BindingProtocol, SOAP>map(_filter, _function_1);
    final SOAP soapProt = IterableExtensions.<SOAP>head(_map);
    String _endpointQualifierName = this._iEndpointQualifierNameProvider.getEndpointQualifierName(specBinding, service, soapProt);
    return this.getConcreteWsdlFileNameFragment(service, _endpointQualifierName);
  }
  
  public String getConcreteWsdlFileNameFragment(final Service service, final Binding binding, final BindingProtocol protocol) {
    Binding specBinding = this._bindingLookup.getMostSpecificBinding(service, binding);
    String _endpointQualifierName = this._iEndpointQualifierNameProvider.getEndpointQualifierName(specBinding, service, protocol);
    return this.getConcreteWsdlFileNameFragment(service, _endpointQualifierName);
  }
  
  public String getConcreteWsdlFileNameFragment(final Service s, final String endPointKind) {
    EObject _eContainer = s.eContainer();
    String _fileNameFragment = this._schemaNamespaceExtensions.toFileNameFragment(_eContainer);
    String _replaceAll = _fileNameFragment.replaceAll("\\.", "-");
    String _plus = (_replaceAll + "-");
    String _name = s.getName();
    String _plus_1 = (_plus + _name);
    String _plus_2 = (_plus_1 + endPointKind);
    String _plus_3 = (_plus_2 + "Port");
    String _plus_4 = (_plus_3 + "-");
    Version _version = s.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_5 = (_plus_4 + _versionPostfix);
    return _plus_5;
  }
}
