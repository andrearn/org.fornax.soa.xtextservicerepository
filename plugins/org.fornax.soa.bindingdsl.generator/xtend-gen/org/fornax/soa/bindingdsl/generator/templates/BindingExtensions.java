package org.fornax.soa.bindingdsl.generator.templates;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.fornax.soa.basedsl.CommonStringExtensions;
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver;
import org.fornax.soa.bindingDsl.BindingProtocol;
import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.bindingDsl.OperationBinding;
import org.fornax.soa.bindingDsl.ServiceBinding;
import org.fornax.soa.environmentDsl.Connector;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.environmentDsl.HTTP;
import org.fornax.soa.environmentDsl.Host;
import org.fornax.soa.environmentDsl.Registry;

@SuppressWarnings("all")
public class BindingExtensions {
  @Inject
  private CommonStringExtensions _commonStringExtensions;
  
  @Inject
  private EnvironmentBindingResolver _environmentBindingResolver;
  
  protected String _getRegistryBaseUrl(final EObject o) {
    return null;
  }
  
  protected String _getRegistryBaseUrl(final ServiceBinding b) {
    EObject _eContainer = b.eContainer();
    String _registryBaseUrl = this.getRegistryBaseUrl(_eContainer);
    return _registryBaseUrl;
  }
  
  protected String _getRegistryBaseUrl(final OperationBinding b) {
    EObject _eContainer = b.eContainer();
    String _registryBaseUrl = this.getRegistryBaseUrl(_eContainer);
    return _registryBaseUrl;
  }
  
  protected String _getRegistryBaseUrl(final ModuleBinding b) {
    Environment _resolveEnvironment = this._environmentBindingResolver.resolveEnvironment(b);
    String _registryBaseUrl = _resolveEnvironment==null?(String)null:this.getRegistryBaseUrl(_resolveEnvironment);
    return _registryBaseUrl;
  }
  
  protected String _getRegistryBaseUrl(final Environment env) {
    String _xifexpression = null;
    Registry _defaultRegistry = env.getDefaultRegistry();
    boolean _notEquals = (!Objects.equal(_defaultRegistry, null));
    if (_notEquals) {
      String _xblockexpression = null;
      {
        Registry _defaultRegistry_1 = env.getDefaultRegistry();
        EList<Connector> _connectors = _defaultRegistry_1.getConnectors();
        Iterable<HTTP> _filter = Iterables.<HTTP>filter(_connectors, HTTP.class);
        final Function1<HTTP,Boolean> _function = new Function1<HTTP,Boolean>() {
            public Boolean apply(final HTTP c) {
              boolean _isIsDefault = c.isIsDefault();
              return Boolean.valueOf(_isIsDefault);
            }
          };
        Iterable<HTTP> _filter_1 = IterableExtensions.<HTTP>filter(_filter, _function);
        HTTP regConnector = IterableExtensions.<HTTP>head(_filter_1);
        String _xifexpression_1 = null;
        boolean _notEquals_1 = (!Objects.equal(regConnector, null));
        if (_notEquals_1) {
          String _xblockexpression_1 = null;
          {
            String _contextRoot = regConnector==null?(String)null:regConnector.getContextRoot();
            String _plus = ("/" + _contextRoot);
            String path = ObjectExtensions.<String>operator_elvis(_plus, "");
            path.replaceAll("//", "/");
            Registry _defaultRegistry_2 = env.getDefaultRegistry();
            Host _host = _defaultRegistry_2.getHost();
            String _fqn = _host==null?(String)null:_host.getFqn();
            String _plus_1 = ("http://" + _fqn);
            String _plus_2 = ("" + ":");
            int _port = regConnector.getPort();
            String _plus_3 = (_plus_2 + Integer.valueOf(_port));
            String _elvis = ObjectExtensions.<String>operator_elvis(_plus_1, _plus_3);
            String _plus_4 = ("" + path);
            String _elvis_1 = ObjectExtensions.<String>operator_elvis(_elvis, _plus_4);
            String baseUrl = ObjectExtensions.<String>operator_elvis(_elvis_1, "");
            String _stripTrailingSlash = this._commonStringExtensions.stripTrailingSlash(baseUrl);
            _xblockexpression_1 = (_stripTrailingSlash);
          }
          _xifexpression_1 = _xblockexpression_1;
        }
        _xblockexpression = (_xifexpression_1);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  protected List<BindingProtocol> _getEndpointProtocols(final ServiceBinding b) {
    EList<BindingProtocol> _protocol = b.getProtocol();
    return _protocol;
  }
  
  protected List<BindingProtocol> _getEndpointProtocols(final OperationBinding b) {
    EList<BindingProtocol> _protocol = b.getProtocol();
    return _protocol;
  }
  
  public String getRegistryBaseUrl(final EObject b) {
    if (b instanceof ModuleBinding) {
      return _getRegistryBaseUrl((ModuleBinding)b);
    } else if (b instanceof ServiceBinding) {
      return _getRegistryBaseUrl((ServiceBinding)b);
    } else if (b instanceof OperationBinding) {
      return _getRegistryBaseUrl((OperationBinding)b);
    } else if (b instanceof Environment) {
      return _getRegistryBaseUrl((Environment)b);
    } else if (b != null) {
      return _getRegistryBaseUrl(b);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(b).toString());
    }
  }
  
  public List<BindingProtocol> getEndpointProtocols(final EObject b) {
    if (b instanceof ServiceBinding) {
      return _getEndpointProtocols((ServiceBinding)b);
    } else if (b instanceof OperationBinding) {
      return _getEndpointProtocols((OperationBinding)b);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(b).toString());
    }
  }
}
