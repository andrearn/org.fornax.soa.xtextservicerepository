package org.fornax.soa.bindingdsl.generator.templates.naming;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.fornax.soa.binding.query.EndpointQualifierQueries;
import org.fornax.soa.bindingDsl.Binding;
import org.fornax.soa.bindingDsl.BindingProtocol;
import org.fornax.soa.bindingdsl.generator.templates.naming.IEndpointQualifierNameProvider;
import org.fornax.soa.semanticsDsl.Qualifier;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.Visibility;

@SuppressWarnings("all")
public class DefaultEndpointQualifierNameProvider implements IEndpointQualifierNameProvider {
  @Inject
  private EndpointQualifierQueries _endpointQualifierQueries;
  
  @Inject
  @Named(value = "ignoreEndpointQualifierNames")
  private boolean ignoreEndpointQualifierNames;
  
  public String getEndpointQualifierName(final Binding bind, final Service svc, final BindingProtocol prot) {
    String detailedQualifierName = "";
    Qualifier _effectiveEndpointQualifier = this._endpointQualifierQueries.getEffectiveEndpointQualifier(prot);
    boolean _notEquals = (!Objects.equal(_effectiveEndpointQualifier, null));
    if (_notEquals) {
      Qualifier _effectiveEndpointQualifier_1 = this._endpointQualifierQueries.getEffectiveEndpointQualifier(prot);
      String _name = _effectiveEndpointQualifier_1.getName();
      String _replaceAll = _name.replaceAll("\\.", "_");
      detailedQualifierName = _replaceAll;
    }
    boolean _isPublicEndpoint = this._endpointQualifierQueries.isPublicEndpoint(svc, bind, prot);
    if (_isPublicEndpoint) {
      if (this.ignoreEndpointQualifierNames) {
        return "Public";
      } else {
        return (detailedQualifierName + "Public");
      }
    } else {
      if (this.ignoreEndpointQualifierNames) {
        return "Private";
      } else {
        return (detailedQualifierName + "Private");
      }
    }
  }
  
  public String getServiceVisibilityName(final Service s) {
    String _switchResult = null;
    Visibility _visibility = s.getVisibility();
    final Visibility _switchValue = _visibility;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,Visibility.PUBLIC)) {
        _matched=true;
        _switchResult = "Public";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,Visibility.DOMAIN)) {
        _matched=true;
        _switchResult = "Domain";
      }
    }
    if (!_matched) {
      _switchResult = "Private";
    }
    return _switchResult;
  }
}
