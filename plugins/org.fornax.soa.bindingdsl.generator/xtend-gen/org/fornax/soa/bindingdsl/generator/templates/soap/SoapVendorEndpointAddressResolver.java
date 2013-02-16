package org.fornax.soa.bindingdsl.generator.templates.soap;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.bindingDsl.Binding;
import org.fornax.soa.bindingDsl.BindingProtocol;
import org.fornax.soa.bindingDsl.SOAP;
import org.fornax.soa.bindingDsl.ServiceBinding;
import org.fornax.soa.bindingdsl.generator.templates.naming.IEndpointQualifierNameProvider;
import org.fornax.soa.bindingdsl.generator.templates.soap.ContextRootProvider;
import org.fornax.soa.bindingdsl.generator.templates.soap.SoapBindingResolver;
import org.fornax.soa.environmentDsl.AppServer;
import org.fornax.soa.environmentDsl.Broker;
import org.fornax.soa.environmentDsl.Database;
import org.fornax.soa.environmentDsl.ESB;
import org.fornax.soa.environmentDsl.ProcessServer;
import org.fornax.soa.environmentDsl.Registry;
import org.fornax.soa.environmentDsl.SAP;
import org.fornax.soa.environmentDsl.Server;
import org.fornax.soa.environmentDsl.WebServer;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.serviceDsl.OrganizationNamespace;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions;

@SuppressWarnings("all")
public class SoapVendorEndpointAddressResolver {
  @Inject
  private IEndpointQualifierNameProvider _iEndpointQualifierNameProvider;
  
  @Inject
  private SchemaNamespaceExtensions _schemaNamespaceExtensions;
  
  @Inject
  private ContextRootProvider ctxRootProvider;
  
  @Inject
  private SoapBindingResolver soapBindRes;
  
  protected String _toEndpointAddressPath(final Module mod, final OrganizationNamespace orgNs, final SubNamespace subNs, final Service s, final Server server, final Binding bind, final BindingProtocol prot) {
    String _xblockexpression = null;
    {
      final String serverType = this.toServerTypeName(server);
      final String serverVersion = this.toServerTypeVersion(server);
      final String ctxRoot = this.ctxRootProvider.getContextRoot(mod, serverType, serverVersion, prot);
      String _endpointAddressPath = this.toEndpointAddressPath(ctxRoot, orgNs, subNs, s, server, bind, prot);
      _xblockexpression = (_endpointAddressPath);
    }
    return _xblockexpression;
  }
  
  protected String _toEndpointAddressPath(final ServiceBinding bind, final BindingProtocol prot, final OrganizationNamespace orgNs, final SubNamespace subNs, final Service s, final Server server) {
    String _xblockexpression = null;
    {
      final String serverType = this.toServerTypeName(server);
      final String serverVersion = this.toServerTypeVersion(server);
      final String ctxRoot = this.ctxRootProvider.getContextRoot(bind);
      String _endpointAddressPath = this.toEndpointAddressPath(ctxRoot, orgNs, subNs, s, server, bind, prot);
      _xblockexpression = (_endpointAddressPath);
    }
    return _xblockexpression;
  }
  
  protected String _toEndpointAddressPath(final String ctxRoot, final OrganizationNamespace orgNs, final SubNamespace subNs, final Service s, final Server server, final Binding bind, final BindingProtocol prot) {
    String _xblockexpression = null;
    {
      final String serverType = this.toServerTypeName(server);
      final String serverVersion = this.toServerTypeVersion(server);
      String _xifexpression = null;
      boolean _notEquals = (!Objects.equal(serverType, null));
      if (_notEquals) {
        String _switchResult = null;
        String _lowerCase = serverType.toLowerCase();
        final String _switchValue = _lowerCase;
        boolean _matched = false;
        if (!_matched) {
          if (Objects.equal(_switchValue,"tomcat")) {
            _matched=true;
            String _mcatEndpointPath = this.tomcatEndpointPath(ctxRoot, orgNs, subNs, s, server, bind, prot);
            _switchResult = _mcatEndpointPath;
          }
        }
        if (!_matched) {
          if (Objects.equal(_switchValue,"websphere")) {
            _matched=true;
            String _websphereSCAEndpointPath = this.websphereSCAEndpointPath(ctxRoot, orgNs, subNs, s, server, bind, prot);
            _switchResult = _websphereSCAEndpointPath;
          }
        }
        if (!_matched) {
          if (Objects.equal(_switchValue,"webmethods")) {
            _matched=true;
            String _webmethodsEndpointPath = this.webmethodsEndpointPath(ctxRoot, orgNs, subNs, s, server, bind, prot);
            _switchResult = _webmethodsEndpointPath;
          }
        }
        if (!_matched) {
          if (Objects.equal(_switchValue,"oraclesb")) {
            _matched=true;
            String _oraclesbEndpointPath = this.oraclesbEndpointPath(ctxRoot, orgNs, subNs, s, server, bind, prot);
            _switchResult = _oraclesbEndpointPath;
          }
        }
        if (!_matched) {
          if (Objects.equal(_switchValue,"weblogic")) {
            _matched=true;
            String _weblogicEndpointPath = this.weblogicEndpointPath(ctxRoot, orgNs, subNs, s, server, bind, prot);
            _switchResult = _weblogicEndpointPath;
          }
        }
        if (!_matched) {
          if (Objects.equal(_switchValue,"aqualogic")) {
            _matched=true;
            String _aqualogicEndpointPath = this.aqualogicEndpointPath(ctxRoot, orgNs, subNs, s, server, bind, prot);
            _switchResult = _aqualogicEndpointPath;
          }
        }
        if (!_matched) {
          if (Objects.equal(_switchValue,"sappi")) {
            _matched=true;
            String _sappiEndpointPath = this.sappiEndpointPath(ctxRoot, orgNs, subNs, s, server, bind, prot);
            _switchResult = _sappiEndpointPath;
          }
        }
        if (!_matched) {
          if (Objects.equal(_switchValue,"sapce")) {
            _matched=true;
            String _sapceEndpointPath = this.sapceEndpointPath(ctxRoot, orgNs, subNs, s, server, bind, prot);
            _switchResult = _sapceEndpointPath;
          }
        }
        if (!_matched) {
          if (Objects.equal(_switchValue,"sapnetweaver")) {
            _matched=true;
            String _sapNetweaverEndpointPath = this.sapNetweaverEndpointPath(ctxRoot, orgNs, subNs, s, server, bind, prot);
            _switchResult = _sapNetweaverEndpointPath;
          }
        }
        if (!_matched) {
          if (Objects.equal(_switchValue,"jboss")) {
            _matched=true;
            String _jbossEndpointPath = this.jbossEndpointPath(ctxRoot, orgNs, subNs, s, server, bind, prot);
            _switchResult = _jbossEndpointPath;
          }
        }
        if (!_matched) {
          if (Objects.equal(_switchValue,"jbossesb")) {
            _matched=true;
            String _jbossesbEndpointPath = this.jbossesbEndpointPath(ctxRoot, orgNs, subNs, s, server, bind, prot);
            _switchResult = _jbossesbEndpointPath;
          }
        }
        if (!_matched) {
          if (Objects.equal(_switchValue,"mule")) {
            _matched=true;
            String _muleEndpointPath = this.muleEndpointPath(ctxRoot, orgNs, subNs, s, server, bind, prot);
            _switchResult = _muleEndpointPath;
          }
        }
        if (!_matched) {
          if (Objects.equal(_switchValue,"fuseesb")) {
            _matched=true;
            String _fuseesbEndpointPath = this.fuseesbEndpointPath(ctxRoot, orgNs, subNs, s, server, bind, prot);
            _switchResult = _fuseesbEndpointPath;
          }
        }
        if (!_matched) {
          String _defaultPatternEndpointPath = this.defaultPatternEndpointPath(ctxRoot, orgNs, subNs, s, server, bind, prot);
          _switchResult = _defaultPatternEndpointPath;
        }
        _xifexpression = _switchResult;
      } else {
        String _defaultPatternEndpointPath_1 = this.defaultPatternEndpointPath(ctxRoot, orgNs, subNs, s, server, bind, prot);
        _xifexpression = _defaultPatternEndpointPath_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public String toServerTypeName(final Server s) {
    String serverTypeName = "undefined";
    boolean _matched = false;
    if (!_matched) {
      if (s instanceof AppServer) {
        final AppServer _appServer = (AppServer)s;
        _matched=true;
        String _serverType = ((AppServer) _appServer).getServerType();
        serverTypeName = _serverType;
      }
    }
    if (!_matched) {
      if (s instanceof ESB) {
        final ESB _eSB = (ESB)s;
        _matched=true;
        String _serverType = ((ESB) _eSB).getServerType();
        serverTypeName = _serverType;
      }
    }
    if (!_matched) {
      if (s instanceof ProcessServer) {
        final ProcessServer _processServer = (ProcessServer)s;
        _matched=true;
        String _serverType = ((ProcessServer) _processServer).getServerType();
        serverTypeName = _serverType;
      }
    }
    if (!_matched) {
      if (s instanceof Broker) {
        final Broker _broker = (Broker)s;
        _matched=true;
        String _serverType = ((Broker) _broker).getServerType();
        serverTypeName = _serverType;
      }
    }
    if (!_matched) {
      if (s instanceof WebServer) {
        final WebServer _webServer = (WebServer)s;
        _matched=true;
        String _serverType = ((WebServer) _webServer).getServerType();
        serverTypeName = _serverType;
      }
    }
    if (!_matched) {
      if (s instanceof SAP) {
        final SAP _sAP = (SAP)s;
        _matched=true;
        serverTypeName = "saperp";
      }
    }
    if (!_matched) {
      if (s instanceof Database) {
        final Database _database = (Database)s;
        _matched=true;
        String _serverType = ((Database) _database).getServerType();
        serverTypeName = _serverType;
      }
    }
    if (!_matched) {
      if (s instanceof Registry) {
        final Registry _registry = (Registry)s;
        _matched=true;
        String _serverType = ((Registry) _registry).getServerType();
        serverTypeName = _serverType;
      }
    }
    if (!_matched) {
      return "undefined";
    }
    boolean _notEquals = (!Objects.equal(serverTypeName, null));
    if (_notEquals) {
      return serverTypeName;
    } else {
      return "undefined";
    }
  }
  
  public String toServerTypeVersion(final Server s) {
    String serverTypeVersion = "undefined";
    boolean _matched = false;
    if (!_matched) {
      if (s instanceof AppServer) {
        final AppServer _appServer = (AppServer)s;
        _matched=true;
        String _serverVersion = ((AppServer) _appServer).getServerVersion();
        serverTypeVersion = _serverVersion;
      }
    }
    if (!_matched) {
      if (s instanceof ESB) {
        final ESB _eSB = (ESB)s;
        _matched=true;
        String _serverVersion = ((ESB) _eSB).getServerVersion();
        serverTypeVersion = _serverVersion;
      }
    }
    if (!_matched) {
      if (s instanceof ProcessServer) {
        final ProcessServer _processServer = (ProcessServer)s;
        _matched=true;
        String _serverVersion = ((ProcessServer) _processServer).getServerVersion();
        serverTypeVersion = _serverVersion;
      }
    }
    if (!_matched) {
      if (s instanceof Broker) {
        final Broker _broker = (Broker)s;
        _matched=true;
        String _serverVersion = ((Broker) _broker).getServerVersion();
        serverTypeVersion = _serverVersion;
      }
    }
    if (!_matched) {
      if (s instanceof WebServer) {
        final WebServer _webServer = (WebServer)s;
        _matched=true;
        String _serverVersion = ((WebServer) _webServer).getServerVersion();
        serverTypeVersion = _serverVersion;
      }
    }
    if (!_matched) {
      if (s instanceof SAP) {
        final SAP _sAP = (SAP)s;
        _matched=true;
        return "undefined";
      }
    }
    if (!_matched) {
      if (s instanceof Database) {
        final Database _database = (Database)s;
        _matched=true;
        String _serverVersion = ((Database) _database).getServerVersion();
        serverTypeVersion = _serverVersion;
      }
    }
    if (!_matched) {
      if (s instanceof Registry) {
        final Registry _registry = (Registry)s;
        _matched=true;
        String _serverVersion = ((Registry) _registry).getServerVersion();
        serverTypeVersion = _serverVersion;
      }
    }
    if (!_matched) {
      return "undefined";
    }
    boolean _notEquals = (!Objects.equal(serverTypeVersion, null));
    if (_notEquals) {
      return serverTypeVersion;
    } else {
      return "undefined";
    }
  }
  
  public String defaultPatternEndpointPath(final String ctxRoot, final OrganizationNamespace orgNs, final SubNamespace subNs, final Service s, final Server server, final Binding bind, final BindingProtocol prot) {
    String _name = orgNs.getName();
    String _replaceAll = _name.replaceAll("\\.", "/");
    String _plus = (ctxRoot + _replaceAll);
    String _plus_1 = (_plus + "/");
    String _name_1 = subNs.getName();
    String _replaceAll_1 = _name_1.replaceAll("\\.", "/");
    String _plus_2 = (_plus_1 + _replaceAll_1);
    String _plus_3 = (_plus_2 + "/");
    String _name_2 = s.getName();
    String _plus_4 = (_plus_3 + _name_2);
    String _plus_5 = (_plus_4 + "/");
    Version _version = s.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_6 = (_plus_5 + _versionPostfix);
    return _plus_6;
  }
  
  public String tomcatEndpointPath(final String ctxRoot, final OrganizationNamespace orgNs, final SubNamespace subNs, final Service s, final Server server, final Binding bind, final BindingProtocol prot) {
    String _name = orgNs.getName();
    String _replaceAll = _name.replaceAll("\\.", "/");
    String _plus = (ctxRoot + _replaceAll);
    String _plus_1 = (_plus + "/");
    String _name_1 = subNs.getName();
    String _replaceAll_1 = _name_1.replaceAll("\\.", "/");
    String _plus_2 = (_plus_1 + _replaceAll_1);
    String _plus_3 = (_plus_2 + "/");
    String _name_2 = s.getName();
    String _plus_4 = (_plus_3 + _name_2);
    String _plus_5 = (_plus_4 + "/");
    Version _version = s.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_6 = (_plus_5 + _versionPostfix);
    return _plus_6;
  }
  
  public String websphereEndpointPath(final String ctxRoot, final OrganizationNamespace orgNs, final SubNamespace subNs, final Service s, final Server server, final Binding bind, final BindingProtocol prot) {
    String _name = orgNs.getName();
    String _replaceAll = _name.replaceAll("\\.", "/");
    String _plus = (ctxRoot + _replaceAll);
    String _plus_1 = (_plus + "/");
    String _name_1 = subNs.getName();
    String _replaceAll_1 = _name_1.replaceAll("\\.", "/");
    String _plus_2 = (_plus_1 + _replaceAll_1);
    String _plus_3 = (_plus_2 + "/");
    String _name_2 = s.getName();
    String _plus_4 = (_plus_3 + _name_2);
    String _plus_5 = (_plus_4 + "/");
    Version _version = s.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_6 = (_plus_5 + _versionPostfix);
    return _plus_6;
  }
  
  public String websphereSCAEndpointPath(final String ctxRoot, final OrganizationNamespace orgNs, final SubNamespace subNs, final Service s, final Server server, final Binding bind, final BindingProtocol prot) {
    String _prefix = this._schemaNamespaceExtensions.toPrefix(orgNs);
    String _plus = (ctxRoot + _prefix);
    String _plus_1 = (_plus + "_");
    String _name = subNs.getName();
    String _replaceAll = _name.replaceAll("\\.", "_");
    String _plus_2 = (_plus_1 + _replaceAll);
    String _plus_3 = (_plus_2 + "_");
    String _name_1 = s.getName();
    String _plus_4 = (_plus_3 + _name_1);
    String _plus_5 = (_plus_4 + "SOAP");
    String _endpointQualifierName = this._iEndpointQualifierNameProvider.getEndpointQualifierName(bind, s, prot);
    String _plus_6 = (_plus_5 + _endpointQualifierName);
    String _plus_7 = (_plus_6 + "_");
    Version _version = s.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_8 = (_plus_7 + _versionPostfix);
    return _plus_8;
  }
  
  public String webmethodsEndpointPath(final String ctxRoot, final OrganizationNamespace orgNs, final SubNamespace subNs, final Service s, final Server server, final Binding bind, final BindingProtocol prot) {
    String _name = orgNs.getName();
    String _plus = (ctxRoot + _name);
    String _plus_1 = (_plus + ".");
    String _name_1 = subNs.getName();
    String _plus_2 = (_plus_1 + _name_1);
    String _plus_3 = (_plus_2 + ".");
    String _name_2 = s.getName();
    String _plus_4 = (_plus_3 + _name_2);
    String _plus_5 = (_plus_4 + ".");
    Version _version = s.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_6 = (_plus_5 + _versionPostfix);
    String _plus_7 = (_plus_6 + ":");
    String _name_3 = s.getName();
    final String servicePath = (_plus_7 + _name_3);
    String scopedPortName = "";
    if ((prot instanceof SOAP)) {
      String _endpointQualifierName = this._iEndpointQualifierNameProvider.getEndpointQualifierName(bind, s, prot);
      String _scopedPortName = this.soapBindRes.toScopedPortName(s, bind, ((SOAP) prot), _endpointQualifierName);
      scopedPortName = _scopedPortName;
    }
    if ((server instanceof ESB)) {
      final ESB esb = ((ESB) server);
      final String esbVersion = esb.getServerVersion();
      boolean _notEquals = (!Objects.equal(esbVersion, null));
      if (_notEquals) {
        final String[] esbVersionDigits = esbVersion.split("\\.");
        boolean _and = false;
        String _get = ((List<String>)Conversions.doWrapArray(esbVersionDigits)).get(0);
        boolean _greaterEqualsThan = (_get.compareTo("8") >= 0);
        if (!_greaterEqualsThan) {
          _and = false;
        } else {
          boolean _notEquals_1 = (!Objects.equal(scopedPortName, ""));
          _and = (_greaterEqualsThan && _notEquals_1);
        }
        if (_and) {
          String _plus_8 = (servicePath + "/");
          return (_plus_8 + scopedPortName);
        }
      }
    }
    return servicePath;
  }
  
  public String oraclesbEndpointPath(final String ctxRoot, final OrganizationNamespace orgNs, final SubNamespace subNs, final Service s, final Server server, final Binding bind, final BindingProtocol prot) {
    String _name = orgNs.getName();
    String _replaceAll = _name.replaceAll("\\.", "/");
    String _plus = (ctxRoot + _replaceAll);
    String _plus_1 = (_plus + "/");
    String _name_1 = subNs.getName();
    String _replaceAll_1 = _name_1.replaceAll("\\.", "/");
    String _plus_2 = (_plus_1 + _replaceAll_1);
    String _plus_3 = (_plus_2 + "/");
    String _name_2 = s.getName();
    String _plus_4 = (_plus_3 + _name_2);
    String _plus_5 = (_plus_4 + "/");
    Version _version = s.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_6 = (_plus_5 + _versionPostfix);
    return _plus_6;
  }
  
  public String weblogicEndpointPath(final String ctxRoot, final OrganizationNamespace orgNs, final SubNamespace subNs, final Service s, final Server server, final Binding bind, final BindingProtocol prot) {
    String _name = orgNs.getName();
    String _replaceAll = _name.replaceAll("\\.", "/");
    String _plus = (ctxRoot + _replaceAll);
    String _plus_1 = (_plus + "/");
    String _name_1 = subNs.getName();
    String _replaceAll_1 = _name_1.replaceAll("\\.", "/");
    String _plus_2 = (_plus_1 + _replaceAll_1);
    String _plus_3 = (_plus_2 + "/");
    String _name_2 = s.getName();
    String _plus_4 = (_plus_3 + _name_2);
    String _plus_5 = (_plus_4 + "/");
    Version _version = s.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_6 = (_plus_5 + _versionPostfix);
    return _plus_6;
  }
  
  public String aqualogicEndpointPath(final String ctxRoot, final OrganizationNamespace orgNs, final SubNamespace subNs, final Service s, final Server server, final Binding bind, final BindingProtocol prot) {
    String _name = orgNs.getName();
    String _replaceAll = _name.replaceAll("\\.", "/");
    String _plus = (ctxRoot + _replaceAll);
    String _plus_1 = (_plus + "/");
    String _name_1 = subNs.getName();
    String _replaceAll_1 = _name_1.replaceAll("\\.", "/");
    String _plus_2 = (_plus_1 + _replaceAll_1);
    String _plus_3 = (_plus_2 + "/");
    String _name_2 = s.getName();
    String _plus_4 = (_plus_3 + _name_2);
    String _plus_5 = (_plus_4 + "/");
    Version _version = s.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_6 = (_plus_5 + _versionPostfix);
    return _plus_6;
  }
  
  public String sappiEndpointPath(final String ctxRoot, final OrganizationNamespace orgNs, final SubNamespace subNs, final Service s, final Server server, final Binding bind, final BindingProtocol prot) {
    String _name = orgNs.getName();
    String _replaceAll = _name.replaceAll("\\.", "/");
    String _plus = (ctxRoot + _replaceAll);
    String _plus_1 = (_plus + "/");
    String _name_1 = subNs.getName();
    String _replaceAll_1 = _name_1.replaceAll("\\.", "/");
    String _plus_2 = (_plus_1 + _replaceAll_1);
    String _plus_3 = (_plus_2 + "/");
    String _name_2 = s.getName();
    String _plus_4 = (_plus_3 + _name_2);
    String _plus_5 = (_plus_4 + "/");
    Version _version = s.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_6 = (_plus_5 + _versionPostfix);
    return _plus_6;
  }
  
  public String sapceEndpointPath(final String ctxRoot, final OrganizationNamespace orgNs, final SubNamespace subNs, final Service s, final Server server, final Binding bind, final BindingProtocol prot) {
    String _name = orgNs.getName();
    String _replaceAll = _name.replaceAll("\\.", "/");
    String _plus = (ctxRoot + _replaceAll);
    String _plus_1 = (_plus + "/");
    String _name_1 = subNs.getName();
    String _replaceAll_1 = _name_1.replaceAll("\\.", "/");
    String _plus_2 = (_plus_1 + _replaceAll_1);
    String _plus_3 = (_plus_2 + "/");
    String _name_2 = s.getName();
    String _plus_4 = (_plus_3 + _name_2);
    String _plus_5 = (_plus_4 + "/");
    Version _version = s.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_6 = (_plus_5 + _versionPostfix);
    return _plus_6;
  }
  
  public String sapNetweaverEndpointPath(final String ctxRoot, final OrganizationNamespace orgNs, final SubNamespace subNs, final Service s, final Server server, final Binding bind, final BindingProtocol prot) {
    String _name = orgNs.getName();
    String _replaceAll = _name.replaceAll("\\.", "/");
    String _plus = (ctxRoot + _replaceAll);
    String _plus_1 = (_plus + "/");
    String _name_1 = subNs.getName();
    String _replaceAll_1 = _name_1.replaceAll("\\.", "/");
    String _plus_2 = (_plus_1 + _replaceAll_1);
    String _plus_3 = (_plus_2 + "/");
    String _name_2 = s.getName();
    String _plus_4 = (_plus_3 + _name_2);
    String _plus_5 = (_plus_4 + "/");
    Version _version = s.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_6 = (_plus_5 + _versionPostfix);
    return _plus_6;
  }
  
  public String jbossEndpointPath(final String ctxRoot, final OrganizationNamespace orgNs, final SubNamespace subNs, final Service s, final Server server, final Binding bind, final BindingProtocol prot) {
    String _name = orgNs.getName();
    String _replaceAll = _name.replaceAll("\\.", "/");
    String _plus = (ctxRoot + _replaceAll);
    String _plus_1 = (_plus + "/");
    String _name_1 = subNs.getName();
    String _replaceAll_1 = _name_1.replaceAll("\\.", "/");
    String _plus_2 = (_plus_1 + _replaceAll_1);
    String _plus_3 = (_plus_2 + "/");
    String _name_2 = s.getName();
    String _plus_4 = (_plus_3 + _name_2);
    String _plus_5 = (_plus_4 + "/");
    Version _version = s.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_6 = (_plus_5 + _versionPostfix);
    return _plus_6;
  }
  
  public String jbossesbEndpointPath(final String ctxRoot, final OrganizationNamespace orgNs, final SubNamespace subNs, final Service s, final Server server, final Binding bind, final BindingProtocol prot) {
    String _name = orgNs.getName();
    String _replaceAll = _name.replaceAll("\\.", "/");
    String _plus = (ctxRoot + _replaceAll);
    String _plus_1 = (_plus + "/");
    String _name_1 = subNs.getName();
    String _replaceAll_1 = _name_1.replaceAll("\\.", "/");
    String _plus_2 = (_plus_1 + _replaceAll_1);
    String _plus_3 = (_plus_2 + "/");
    String _name_2 = s.getName();
    String _plus_4 = (_plus_3 + _name_2);
    String _plus_5 = (_plus_4 + "/");
    Version _version = s.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_6 = (_plus_5 + _versionPostfix);
    return _plus_6;
  }
  
  public String muleEndpointPath(final String ctxRoot, final OrganizationNamespace orgNs, final SubNamespace subNs, final Service s, final Server server, final Binding bind, final BindingProtocol prot) {
    String _name = orgNs.getName();
    String _replaceAll = _name.replaceAll("\\.", "/");
    String _plus = (ctxRoot + _replaceAll);
    String _plus_1 = (_plus + "/");
    String _name_1 = subNs.getName();
    String _replaceAll_1 = _name_1.replaceAll("\\.", "/");
    String _plus_2 = (_plus_1 + _replaceAll_1);
    String _plus_3 = (_plus_2 + "/");
    String _name_2 = s.getName();
    String _plus_4 = (_plus_3 + _name_2);
    String _plus_5 = (_plus_4 + "/");
    Version _version = s.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_6 = (_plus_5 + _versionPostfix);
    return _plus_6;
  }
  
  public String fuseesbEndpointPath(final String ctxRoot, final OrganizationNamespace orgNs, final SubNamespace subNs, final Service s, final Server server, final Binding bind, final BindingProtocol prot) {
    String _name = orgNs.getName();
    String _replaceAll = _name.replaceAll("\\.", "/");
    String _plus = (ctxRoot + _replaceAll);
    String _plus_1 = (_plus + "/");
    String _name_1 = subNs.getName();
    String _replaceAll_1 = _name_1.replaceAll("\\.", "/");
    String _plus_2 = (_plus_1 + _replaceAll_1);
    String _plus_3 = (_plus_2 + "/");
    String _name_2 = s.getName();
    String _plus_4 = (_plus_3 + _name_2);
    String _plus_5 = (_plus_4 + "/");
    Version _version = s.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_6 = (_plus_5 + _versionPostfix);
    return _plus_6;
  }
  
  public String toEndpointAddressPath(final Object mod, final OrganizationNamespace orgNs, final SubNamespace subNs, final Service s, final Server server, final Binding bind, final BindingProtocol prot) {
    if (mod instanceof Module) {
      return _toEndpointAddressPath((Module)mod, orgNs, subNs, s, server, bind, prot);
    } else if (mod instanceof String) {
      return _toEndpointAddressPath((String)mod, orgNs, subNs, s, server, bind, prot);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(mod, orgNs, subNs, s, server, bind, prot).toString());
    }
  }
  
  public String toEndpointAddressPath(final ServiceBinding bind, final BindingProtocol prot, final OrganizationNamespace orgNs, final SubNamespace subNs, final Service s, final Server server) {
    {
      return _toEndpointAddressPath(bind, prot, orgNs, subNs, s, server);
    }
  }
}
