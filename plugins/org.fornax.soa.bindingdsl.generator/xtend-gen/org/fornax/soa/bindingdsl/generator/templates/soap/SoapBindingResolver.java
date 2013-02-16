package org.fornax.soa.bindingdsl.generator.templates.soap;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.fornax.soa.bindingDsl.Binding;
import org.fornax.soa.bindingDsl.SOAP;
import org.fornax.soa.bindingDsl.SOAPStyle;
import org.fornax.soa.bindingdsl.generator.templates.naming.IEndpointQualifierNameProvider;
import org.fornax.soa.serviceDsl.Service;

@SuppressWarnings("all")
public class SoapBindingResolver {
  @Inject
  private IEndpointQualifierNameProvider _iEndpointQualifierNameProvider;
  
  public String getWsdlBindingStyle(final SOAP bind) {
    String _switchResult = null;
    SOAPStyle _style = bind.getStyle();
    final SOAPStyle _switchValue = _style;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,SOAPStyle.RPCLIT)) {
        _matched=true;
        _switchResult = "RPC";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,SOAPStyle.RPCENC)) {
        _matched=true;
        _switchResult = "RPC";
      }
    }
    if (!_matched) {
      _switchResult = "document";
    }
    return _switchResult;
  }
  
  public String getSoapEncoding(final SOAP bind) {
    String _switchResult = null;
    SOAPStyle _style = bind.getStyle();
    final SOAPStyle _switchValue = _style;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,SOAPStyle.RPCENC)) {
        _matched=true;
        _switchResult = "encoded";
      }
    }
    if (!_matched) {
      _switchResult = "literal";
    }
    return _switchResult;
  }
  
  public String toBindingName(final Service s, final SOAP p) {
    String _name = s.getName();
    String _portNamePostfix = this.getPortNamePostfix(p);
    String _plus = (_name + _portNamePostfix);
    return _plus;
  }
  
  public String toBindingName(final Service s, final SOAP p, final String qualifierName) {
    String _name = s.getName();
    String _plus = (_name + qualifierName);
    String _portNamePostfix = this.getPortNamePostfix(p);
    String _plus_1 = (_plus + _portNamePostfix);
    return _plus_1;
  }
  
  public String toPortName(final Service s, final SOAP p) {
    String _name = s.getName();
    String _portNamePostfix = this.getPortNamePostfix(p);
    String _plus = (_name + _portNamePostfix);
    return _plus;
  }
  
  public String toPortName(final Service s, final SOAP p, final String qualifierName) {
    String _xifexpression = null;
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(qualifierName, "Public"));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _notEquals_1 = (!Objects.equal(qualifierName, "Private"));
      _and = (_notEquals && _notEquals_1);
    }
    if (_and) {
      String _name = s.getName();
      String _plus = (_name + qualifierName);
      String _portNamePostfix = this.getPortNamePostfix(p);
      String _plus_1 = (_plus + _portNamePostfix);
      _xifexpression = _plus_1;
    } else {
      String _portName = this.toPortName(s, p);
      _xifexpression = _portName;
    }
    return _xifexpression;
  }
  
  public String toScopedPortName(final Service s, final Binding binding, final SOAP p) {
    String _xblockexpression = null;
    {
      this._iEndpointQualifierNameProvider.getEndpointQualifierName(binding, s, p);
      String _portName = this.toPortName(s, p);
      String _endpointQualifierName = this._iEndpointQualifierNameProvider.getEndpointQualifierName(binding, s, p);
      String _plus = (_portName + _endpointQualifierName);
      _xblockexpression = (_plus);
    }
    return _xblockexpression;
  }
  
  public String toScopedPortName(final Service s, final Binding binding, final SOAP p, final String qualifierName) {
    String _xifexpression = null;
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(qualifierName, "Public"));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _notEquals_1 = (!Objects.equal(qualifierName, "Private"));
      _and = (_notEquals && _notEquals_1);
    }
    if (_and) {
      String _portName = this.toPortName(s, p);
      String _plus = (_portName + qualifierName);
      _xifexpression = _plus;
    } else {
      String _scopedPortName = this.toScopedPortName(s, binding, p);
      _xifexpression = _scopedPortName;
    }
    return _xifexpression;
  }
  
  private String getPortNamePostfix(final SOAP p) {
    String _switchResult = null;
    SOAPStyle _style = p.getStyle();
    final SOAPStyle _switchValue = _style;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,SOAPStyle.RPCLIT)) {
        _matched=true;
        _switchResult = "SOAPRPClit";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,SOAPStyle.RPCENC)) {
        _matched=true;
        _switchResult = "SOAPRPCEnc";
      }
    }
    if (!_matched) {
      _switchResult = "SOAP";
    }
    return _switchResult;
  }
}
