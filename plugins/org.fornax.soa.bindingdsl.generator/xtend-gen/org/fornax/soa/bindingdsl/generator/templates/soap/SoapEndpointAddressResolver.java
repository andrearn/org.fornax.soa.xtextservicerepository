package org.fornax.soa.bindingdsl.generator.templates.soap;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.binding.query.environment.BindingConnectorResolver;
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver;
import org.fornax.soa.bindingDsl.Binding;
import org.fornax.soa.bindingDsl.BindingProtocol;
import org.fornax.soa.bindingDsl.SOAP;
import org.fornax.soa.bindingDsl.ServiceBinding;
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions;
import org.fornax.soa.bindingdsl.generator.templates.soap.SoapVendorEndpointAddressResolver;
import org.fornax.soa.environmentDsl.Connector;
import org.fornax.soa.environmentDsl.Server;
import org.fornax.soa.environmentdsl.generator.EndpointResolver;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.service.query.namespace.NamespaceQuery;
import org.fornax.soa.serviceDsl.OrganizationNamespace;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.SubNamespace;

/**
 * Resolves SOAP endpoint addresses according to the naming conventions
 */
@SuppressWarnings("all")
public class SoapEndpointAddressResolver {
  @Inject
  private NamespaceQuery _namespaceQuery;
  
  @Inject
  private BindingExtensions _bindingExtensions;
  
  @Inject
  private SoapVendorEndpointAddressResolver _soapVendorEndpointAddressResolver;
  
  @Inject
  private EndpointResolver _endpointResolver;
  
  @Inject
  private EnvironmentBindingResolver _environmentBindingResolver;
  
  @Inject
  private BindingConnectorResolver connectorResolver;
  
  protected String _toEndpointAddress(final Service service, final Server server, final BindingProtocol prot, final Module mod) {
    String _xblockexpression = null;
    {
      EObject _eContainer = prot.eContainer();
      final Binding bind = ((Binding) _eContainer);
      final Connector connector = this.connectorResolver.resolveConnector(server, bind, prot);
      String _sOAPHttpEndpointUrl = this._endpointResolver.getSOAPHttpEndpointUrl(server, connector);
      OrganizationNamespace _findOrgNamespace = this._namespaceQuery.findOrgNamespace(service);
      SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(service);
      String _endpointAddressPath = this._soapVendorEndpointAddressResolver.toEndpointAddressPath(mod, _findOrgNamespace, _findSubdomain, service, server, bind, prot);
      String _plus = (_sOAPHttpEndpointUrl + _endpointAddressPath);
      _xblockexpression = (_plus);
    }
    return _xblockexpression;
  }
  
  /**
   * Calculate the endpoint address assuming, that it is a public endpoint.
   * Public endpoints are usually located on an ESB
   */
  protected String _toEndpointAddress(final Service service, final Server server, final BindingProtocol prot, final ServiceBinding bind) {
    String _xblockexpression = null;
    {
      final Connector connector = this.connectorResolver.resolveConnector(server, bind, prot);
      String _sOAPHttpEndpointUrl = this._endpointResolver.getSOAPHttpEndpointUrl(server, connector);
      OrganizationNamespace _findOrgNamespace = this._namespaceQuery.findOrgNamespace(service);
      SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(service);
      String _endpointAddressPath = this._soapVendorEndpointAddressResolver.toEndpointAddressPath(bind, prot, _findOrgNamespace, _findSubdomain, service, server);
      String _plus = (_sOAPHttpEndpointUrl + _endpointAddressPath);
      _xblockexpression = (_plus);
    }
    return _xblockexpression;
  }
  
  protected String _toEndpointAddress(final Service service, final EObject binding) {
    return "";
  }
  
  protected String _toEndpointAddress(final Service service, final ServiceBinding binding) {
    String _xblockexpression = null;
    {
      final Server server = this._environmentBindingResolver.resolveServer(binding);
      List<BindingProtocol> _endpointProtocols = this._bindingExtensions.getEndpointProtocols(binding);
      Iterable<SOAP> _filter = Iterables.<SOAP>filter(_endpointProtocols, SOAP.class);
      final SOAP prot = IterableExtensions.<SOAP>head(_filter);
      String _endpointAddress = this.toEndpointAddress(service, server, prot, binding);
      _xblockexpression = (_endpointAddress);
    }
    return _xblockexpression;
  }
  
  public String toEndpointAddress(final Service service, final Server server, final BindingProtocol prot, final EObject bind) {
    if (bind instanceof ServiceBinding) {
      return _toEndpointAddress(service, server, prot, (ServiceBinding)bind);
    } else if (bind instanceof Module) {
      return _toEndpointAddress(service, server, prot, (Module)bind);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(service, server, prot, bind).toString());
    }
  }
  
  public String toEndpointAddress(final Service service, final EObject binding) {
    if (binding instanceof ServiceBinding) {
      return _toEndpointAddress(service, (ServiceBinding)binding);
    } else if (binding != null) {
      return _toEndpointAddress(service, binding);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(service, binding).toString());
    }
  }
}
