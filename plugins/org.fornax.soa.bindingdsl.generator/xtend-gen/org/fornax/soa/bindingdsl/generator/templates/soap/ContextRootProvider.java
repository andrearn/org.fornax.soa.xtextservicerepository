package org.fornax.soa.bindingdsl.generator.templates.soap;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.bindingDsl.BindingProtocol;
import org.fornax.soa.bindingDsl.REST;
import org.fornax.soa.bindingDsl.SOAP;
import org.fornax.soa.bindingDsl.ServiceBinding;
import org.fornax.soa.moduledsl.moduleDsl.AssemblyType;
import org.fornax.soa.moduledsl.moduleDsl.Module;

@SuppressWarnings("all")
public class ContextRootProvider {
  public String getContextRoot(final Module mod, final String serverTypeName, final BindingProtocol prot) {
    String _xblockexpression = null;
    {
      final String ctxRoot = this.getContextRootByProtocol(prot);
      String _xifexpression = null;
      boolean _notEquals = (!Objects.equal(ctxRoot, null));
      if (_notEquals) {
        String _plus = ("/" + ctxRoot);
        _xifexpression = _plus;
      } else {
        String _ctxRootByAssemblyType = this.getCtxRootByAssemblyType(mod, serverTypeName);
        String _plus_1 = ("/" + _ctxRootByAssemblyType);
        _xifexpression = _plus_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public String getContextRoot(final Module mod, final String serverTypeName, final String serverVersion, final BindingProtocol prot) {
    String _xblockexpression = null;
    {
      final String ctxRoot = this.getContextRootByProtocol(prot);
      String _xifexpression = null;
      boolean _notEquals = (!Objects.equal(ctxRoot, null));
      if (_notEquals) {
        String _plus = ("/" + ctxRoot);
        _xifexpression = _plus;
      } else {
        String _ctxRootByAssemblyType = this.getCtxRootByAssemblyType(mod, serverTypeName, serverVersion);
        String _plus_1 = ("/" + _ctxRootByAssemblyType);
        _xifexpression = _plus_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected String _getContextRoot(final ServiceBinding b) {
    String _xblockexpression = null;
    {
      EList<BindingProtocol> _protocol = b.getProtocol();
      final Iterable<SOAP> soapBindings = Iterables.<SOAP>filter(_protocol, SOAP.class);
      String _xifexpression = null;
      boolean _and = false;
      boolean _isEmpty = IterableExtensions.isEmpty(soapBindings);
      boolean _not = (!_isEmpty);
      if (!_not) {
        _and = false;
      } else {
        SOAP _head = IterableExtensions.<SOAP>head(soapBindings);
        String _contextRoot = _head.getContextRoot();
        boolean _notEquals = (!Objects.equal(_contextRoot, null));
        _and = (_not && _notEquals);
      }
      if (_and) {
        SOAP _head_1 = IterableExtensions.<SOAP>head(soapBindings);
        String _contextRoot_1 = _head_1.getContextRoot();
        String _plus = ("/" + _contextRoot_1);
        String _plus_1 = (_plus + "/");
        _xifexpression = _plus_1;
      } else {
        _xifexpression = "/";
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public String getCtxRootByAssemblyType(final Module mod, final String serverType) {
    String _xifexpression = null;
    String _lowerCase = serverType.toLowerCase();
    String _trim = _lowerCase.trim();
    boolean _equals = Objects.equal(_trim, "webmethods");
    if (_equals) {
      _xifexpression = "";
    } else {
      String _switchResult = null;
      AssemblyType _assemblyType = mod.getAssemblyType();
      final AssemblyType _switchValue = _assemblyType;
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(_switchValue,AssemblyType.SCA_EAR)) {
          _matched=true;
          String _technicalModuleName = this.getTechnicalModuleName(mod);
          String _plus = (_technicalModuleName + "Web/sca/");
          _switchResult = _plus;
        }
      }
      if (!_matched) {
        String _technicalModuleName_1 = this.getTechnicalModuleName(mod);
        String _plus_1 = (_technicalModuleName_1 + "/");
        _switchResult = _plus_1;
      }
      _xifexpression = _switchResult;
    }
    return _xifexpression;
  }
  
  public String getCtxRootByAssemblyType(final Module mod, final String serverType, final String serverVersion) {
    String _xifexpression = null;
    String _lowerCase = serverType.toLowerCase();
    String _trim = _lowerCase.trim();
    boolean _equals = Objects.equal(_trim, "webmethods");
    if (_equals) {
      _xifexpression = "";
    } else {
      String _switchResult = null;
      AssemblyType _assemblyType = mod.getAssemblyType();
      final AssemblyType _switchValue = _assemblyType;
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(_switchValue,AssemblyType.SCA_EAR)) {
          _matched=true;
          String _technicalModuleName = this.getTechnicalModuleName(mod);
          String _plus = (_technicalModuleName + "Web/sca/");
          _switchResult = _plus;
        }
      }
      if (!_matched) {
        String _technicalModuleName_1 = this.getTechnicalModuleName(mod);
        String _plus_1 = (_technicalModuleName_1 + "/");
        _switchResult = _plus_1;
      }
      _xifexpression = _switchResult;
    }
    return _xifexpression;
  }
  
  protected String _getContextRootByProtocol(final BindingProtocol prot) {
    return null;
  }
  
  protected String _getContextRootByProtocol(final SOAP prot) {
    return prot.getContextRoot();
  }
  
  protected String _getContextRootByProtocol(final REST prot) {
    return prot.getPath();
  }
  
  public String getTechnicalModuleName(final Module mod) {
    String _deploymentModuleName = mod.getDeploymentModuleName();
    boolean _notEquals = (!Objects.equal(_deploymentModuleName, null));
    if (_notEquals) {
      return mod.getDeploymentModuleName();
    } else {
      return mod.getName();
    }
  }
  
  public String getContextRoot(final ServiceBinding b) {
    {
      return _getContextRoot(b);
    }
  }
  
  public String getContextRootByProtocol(final BindingProtocol prot) {
    if (prot instanceof REST) {
      return _getContextRootByProtocol((REST)prot);
    } else if (prot instanceof SOAP) {
      return _getContextRootByProtocol((SOAP)prot);
    } else if (prot != null) {
      return _getContextRootByProtocol(prot);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(prot).toString());
    }
  }
}
