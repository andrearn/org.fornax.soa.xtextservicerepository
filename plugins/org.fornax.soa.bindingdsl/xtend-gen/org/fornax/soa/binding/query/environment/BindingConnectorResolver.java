package org.fornax.soa.binding.query.environment;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.logging.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.binding.query.ServerNotConnectableException;
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver;
import org.fornax.soa.bindingDsl.BindingProtocol;
import org.fornax.soa.bindingDsl.ConnectorQualifier;
import org.fornax.soa.bindingDsl.EJB;
import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.bindingDsl.SCA;
import org.fornax.soa.bindingDsl.SOAP;
import org.fornax.soa.bindingDsl.ServiceBinding;
import org.fornax.soa.environmentDsl.AppServer;
import org.fornax.soa.environmentDsl.Broker;
import org.fornax.soa.environmentDsl.Connector;
import org.fornax.soa.environmentDsl.ESB;
import org.fornax.soa.environmentDsl.HTTP;
import org.fornax.soa.environmentDsl.IIOP;
import org.fornax.soa.environmentDsl.JMS;
import org.fornax.soa.environmentDsl.ProcessServer;
import org.fornax.soa.environmentDsl.REST;
import org.fornax.soa.environmentDsl.RMI;
import org.fornax.soa.environmentDsl.SOAPHTTP;
import org.fornax.soa.environmentDsl.Server;
import org.fornax.soa.environmentDsl.WebServer;

/**
 * Lookup and resolution of connectors for bindings
 */
@SuppressWarnings("all")
public class BindingConnectorResolver {
  @Inject
  private EnvironmentBindingResolver _environmentBindingResolver;
  
  @Inject
  private Logger log;
  
  /**
   * Find the closest matching connector for the given protocol and connector name. If the connector name
   * is not provided the first closest match based on the supported protocol is returned
   */
  protected Connector _resolveConnector(final Server s, final EObject bind, final BindingProtocol prot) {
    return null;
  }
  
  protected Connector _resolveConnector(final Server s, final ModuleBinding bind, final BindingProtocol prot) {
    Connector _xblockexpression = null;
    {
      EList<Connector> _xifexpression = null;
      Server _resolveServer = this._environmentBindingResolver.resolveServer(bind, prot);
      EList<Connector> _connectors = _resolveServer==null?(EList<Connector>)null:this.getConnectors(_resolveServer);
      boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(_connectors);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        Server _resolveServer_1 = this._environmentBindingResolver.resolveServer(bind, prot);
        EList<Connector> _connectors_1 = _resolveServer_1==null?(EList<Connector>)null:this.getConnectors(_resolveServer_1);
        _xifexpression = _connectors_1;
      } else {
        EList<Connector> _connectors_2 = this.getConnectors(s);
        _xifexpression = _connectors_2;
      }
      final EList<Connector> serverConnectors = _xifexpression;
      ConnectorQualifier _endpointConnector = prot==null?(ConnectorQualifier)null:prot.getEndpointConnector();
      final EList<Connector> chosenConnectors = _endpointConnector==null?(EList<Connector>)null:_endpointConnector.getConnectors();
      Connector _xifexpression_1 = null;
      boolean _and = false;
      boolean _isNullOrEmpty_1 = IterableExtensions.isNullOrEmpty(chosenConnectors);
      boolean _not_1 = (!_isNullOrEmpty_1);
      if (!_not_1) {
        _and = false;
      } else {
        boolean _isNullOrEmpty_2 = IterableExtensions.isNullOrEmpty(serverConnectors);
        boolean _not_2 = (!_isNullOrEmpty_2);
        _and = (_not_1 && _not_2);
      }
      if (_and) {
        Connector _selectBestMatchingConnector = this.selectBestMatchingConnector(prot, chosenConnectors, serverConnectors);
        _xifexpression_1 = _selectBestMatchingConnector;
      } else {
        Connector _findConnectorsByProtocol = this.findConnectorsByProtocol(s, prot, serverConnectors);
        _xifexpression_1 = _findConnectorsByProtocol;
      }
      _xblockexpression = (_xifexpression_1);
    }
    return _xblockexpression;
  }
  
  protected Connector _resolveConnector(final Server s, final ServiceBinding bind, final BindingProtocol prot) {
    Connector _xblockexpression = null;
    {
      EList<Connector> _xifexpression = null;
      Server _resolveServer = this._environmentBindingResolver.resolveServer(bind, prot);
      EList<Connector> _connectors = _resolveServer==null?(EList<Connector>)null:this.getConnectors(_resolveServer);
      boolean _isNullOrEmpty = IterableExtensions.isNullOrEmpty(_connectors);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        Server _resolveServer_1 = this._environmentBindingResolver.resolveServer(bind, prot);
        EList<Connector> _connectors_1 = _resolveServer_1==null?(EList<Connector>)null:this.getConnectors(_resolveServer_1);
        _xifexpression = _connectors_1;
      } else {
        EList<Connector> _connectors_2 = this.getConnectors(s);
        _xifexpression = _connectors_2;
      }
      final EList<Connector> serverConnectors = _xifexpression;
      ConnectorQualifier _endpointConnector = prot==null?(ConnectorQualifier)null:prot.getEndpointConnector();
      final EList<Connector> chosenConnectors = _endpointConnector==null?(EList<Connector>)null:_endpointConnector.getConnectors();
      Connector _xifexpression_1 = null;
      boolean _and = false;
      boolean _isNullOrEmpty_1 = IterableExtensions.isNullOrEmpty(chosenConnectors);
      boolean _not_1 = (!_isNullOrEmpty_1);
      if (!_not_1) {
        _and = false;
      } else {
        boolean _isNullOrEmpty_2 = IterableExtensions.isNullOrEmpty(serverConnectors);
        boolean _not_2 = (!_isNullOrEmpty_2);
        _and = (_not_1 && _not_2);
      }
      if (_and) {
        Connector _selectBestMatchingConnector = this.selectBestMatchingConnector(prot, chosenConnectors, serverConnectors);
        _xifexpression_1 = _selectBestMatchingConnector;
      } else {
        Connector _findConnectorsByProtocol = this.findConnectorsByProtocol(s, prot, serverConnectors);
        _xifexpression_1 = _findConnectorsByProtocol;
      }
      _xblockexpression = (_xifexpression_1);
    }
    return _xblockexpression;
  }
  
  protected Connector _findConnectorsByProtocol(final Server s, final BindingProtocol prot, final Iterable<Connector> canditateConnectors) {
    return null;
  }
  
  protected Connector _findConnectorsByProtocol(final AppServer s, final BindingProtocol prot, final Iterable<Connector> canditateConnectors) {
    EList<Connector> _connectors = s.getConnectors();
    Connector _selectBestMatchingConnector = this.selectBestMatchingConnector(prot, _connectors, canditateConnectors);
    return _selectBestMatchingConnector;
  }
  
  protected Connector _findConnectorsByProtocol(final ESB s, final BindingProtocol prot, final Iterable<Connector> canditateConnectors) {
    EList<Connector> _connectors = s.getConnectors();
    Connector _selectBestMatchingConnector = this.selectBestMatchingConnector(prot, _connectors, canditateConnectors);
    return _selectBestMatchingConnector;
  }
  
  protected Connector _findConnectorsByProtocol(final Broker s, final BindingProtocol prot, final Iterable<Connector> canditateConnectors) {
    EList<Connector> _connectors = s.getConnectors();
    Connector _selectBestMatchingConnector = this.selectBestMatchingConnector(prot, _connectors, canditateConnectors);
    return _selectBestMatchingConnector;
  }
  
  protected Connector _findConnectorsByProtocol(final WebServer s, final BindingProtocol prot, final Iterable<Connector> canditateConnectors) {
    EList<Connector> _connectors = s.getConnectors();
    Connector _selectBestMatchingConnector = this.selectBestMatchingConnector(prot, _connectors, canditateConnectors);
    return _selectBestMatchingConnector;
  }
  
  public Connector selectBestMatchingConnector(final Iterable<Connector> con, final String connectorName) {
    Connector _xifexpression = null;
    boolean _notEquals = (!Objects.equal(connectorName, null));
    if (_notEquals) {
      final Function1<Connector,Boolean> _function = new Function1<Connector,Boolean>() {
          public Boolean apply(final Connector c) {
            String _name = c.getName();
            boolean _equals = Objects.equal(_name, connectorName);
            return Boolean.valueOf(_equals);
          }
        };
      Connector _findFirst = IterableExtensions.<Connector>findFirst(con, _function);
      _xifexpression = _findFirst;
    } else {
      Connector _head = IterableExtensions.<Connector>head(con);
      _xifexpression = _head;
    }
    return _xifexpression;
  }
  
  public Connector selectBestMatchingConnector(final BindingProtocol prot, final Iterable<Connector> serverConnectors, final Iterable<Connector> chosenConnectors) {
    Connector _xblockexpression = null;
    {
      final Function1<Connector,Boolean> _function = new Function1<Connector,Boolean>() {
          public Boolean apply(final Connector e) {
            boolean _supportsProtocol = BindingConnectorResolver.this.supportsProtocol(e, prot);
            return Boolean.valueOf(_supportsProtocol);
          }
        };
      final Iterable<Connector> canditateCon = IterableExtensions.<Connector>filter(serverConnectors, _function);
      final Function1<Connector,Boolean> _function_1 = new Function1<Connector,Boolean>() {
          public Boolean apply(final Connector con) {
            final Function1<Connector,Boolean> _function = new Function1<Connector,Boolean>() {
                public Boolean apply(final Connector c) {
                  boolean _equals = Objects.equal(c, con);
                  return Boolean.valueOf(_equals);
                }
              };
            boolean _exists = IterableExtensions.<Connector>exists(chosenConnectors, _function);
            return Boolean.valueOf(_exists);
          }
        };
      Connector _findFirst = IterableExtensions.<Connector>findFirst(canditateCon, _function_1);
      _xblockexpression = (_findFirst);
    }
    return _xblockexpression;
  }
  
  /**
   * Test whether a connector supports the given protocol
   * 
   * TODO: complete this for all protocols and possible matches!!!
   */
  public boolean supportsProtocol(final Connector con, final BindingProtocol prot) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (!_matched) {
      if (prot instanceof SOAP) {
        final SOAP _sOAP = (SOAP)prot;
        _matched=true;
        _switchResult = (con instanceof SOAPHTTP);
      }
    }
    if (!_matched) {
      if (prot instanceof EJB) {
        final EJB _eJB = (EJB)prot;
        _matched=true;
        boolean _or = false;
        if ((con instanceof RMI)) {
          _or = true;
        } else {
          _or = ((con instanceof RMI) || (con instanceof IIOP));
        }
        _switchResult = _or;
      }
    }
    if (!_matched) {
      if (prot instanceof SCA) {
        final SCA _sCA = (SCA)prot;
        _matched=true;
        boolean _or = false;
        if ((con instanceof RMI)) {
          _or = true;
        } else {
          _or = ((con instanceof RMI) || (con instanceof IIOP));
        }
        _switchResult = _or;
      }
    }
    if (!_matched) {
      if (prot instanceof JMS) {
        final JMS _jMS = (JMS)prot;
        _matched=true;
        _switchResult = (con instanceof JMS);
      }
    }
    if (!_matched) {
      if (prot instanceof REST) {
        final REST _rEST = (REST)prot;
        _matched=true;
        _switchResult = (con instanceof REST);
      }
    }
    if (!_matched) {
      if (prot instanceof HTTP) {
        final HTTP _hTTP = (HTTP)prot;
        _matched=true;
        _switchResult = (con instanceof HTTP);
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
  
  public EList<Connector> getConnectors(final Server server) {
    EList<Connector> _xblockexpression = null;
    {
      boolean _equals = Objects.equal(server, null);
      if (_equals) {
        IllegalArgumentException _illegalArgumentException = new IllegalArgumentException("Server may not be null");
        throw _illegalArgumentException;
      }
      EList<Connector> _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (server instanceof AppServer) {
          final AppServer _appServer = (AppServer)server;
          _matched=true;
          EList<Connector> _connectors = ((AppServer) _appServer).getConnectors();
          _switchResult = _connectors;
        }
      }
      if (!_matched) {
        if (server instanceof Broker) {
          final Broker _broker = (Broker)server;
          _matched=true;
          EList<Connector> _connectors = ((Broker) _broker).getConnectors();
          _switchResult = _connectors;
        }
      }
      if (!_matched) {
        if (server instanceof ESB) {
          final ESB _eSB = (ESB)server;
          _matched=true;
          EList<Connector> _connectors = ((ESB) _eSB).getConnectors();
          _switchResult = _connectors;
        }
      }
      if (!_matched) {
        if (server instanceof ProcessServer) {
          final ProcessServer _processServer = (ProcessServer)server;
          _matched=true;
          EList<Connector> _connectors = ((ProcessServer) _processServer).getConnectors();
          _switchResult = _connectors;
        }
      }
      if (!_matched) {
        if (server instanceof WebServer) {
          final WebServer _webServer = (WebServer)server;
          _matched=true;
          EList<Connector> _connectors = ((WebServer) _webServer).getConnectors();
          _switchResult = _connectors;
        }
      }
      if (!_matched) {
        {
          String _name = server.getName();
          String _plus = ("Server " + _name);
          String _plus_1 = (_plus + " of type ");
          EClass _eClass = server.eClass();
          String _name_1 = _eClass.getName();
          String _plus_2 = (_plus_1 + _name_1);
          String _plus_3 = (_plus_2 + " dos not support connectors.");
          this.log.severe(_plus_3);
          ServerNotConnectableException _serverNotConnectableException = new ServerNotConnectableException();
          throw _serverNotConnectableException;
        }
      }
      _xblockexpression = (_switchResult);
    }
    return _xblockexpression;
  }
  
  public Connector resolveConnector(final Server s, final EObject bind, final BindingProtocol prot) {
    if (bind instanceof ModuleBinding) {
      return _resolveConnector(s, (ModuleBinding)bind, prot);
    } else if (bind instanceof ServiceBinding) {
      return _resolveConnector(s, (ServiceBinding)bind, prot);
    } else if (bind != null) {
      return _resolveConnector(s, bind, prot);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s, bind, prot).toString());
    }
  }
  
  public Connector findConnectorsByProtocol(final Server s, final BindingProtocol prot, final Iterable<Connector> canditateConnectors) {
    if (s instanceof AppServer) {
      return _findConnectorsByProtocol((AppServer)s, prot, canditateConnectors);
    } else if (s instanceof Broker) {
      return _findConnectorsByProtocol((Broker)s, prot, canditateConnectors);
    } else if (s instanceof ESB) {
      return _findConnectorsByProtocol((ESB)s, prot, canditateConnectors);
    } else if (s instanceof WebServer) {
      return _findConnectorsByProtocol((WebServer)s, prot, canditateConnectors);
    } else if (s != null) {
      return _findConnectorsByProtocol(s, prot, canditateConnectors);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s, prot, canditateConnectors).toString());
    }
  }
}
