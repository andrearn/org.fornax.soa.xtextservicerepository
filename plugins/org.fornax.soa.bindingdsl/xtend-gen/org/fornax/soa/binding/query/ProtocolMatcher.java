package org.fornax.soa.binding.query;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.bindingDsl.AMQP;
import org.fornax.soa.bindingDsl.Binding;
import org.fornax.soa.bindingDsl.BindingProtocol;
import org.fornax.soa.bindingDsl.EJB;
import org.fornax.soa.bindingDsl.FILE;
import org.fornax.soa.bindingDsl.FTP;
import org.fornax.soa.bindingDsl.HTTP;
import org.fornax.soa.bindingDsl.IIOP;
import org.fornax.soa.bindingDsl.JMS;
import org.fornax.soa.bindingDsl.REST;
import org.fornax.soa.bindingDsl.SAP;
import org.fornax.soa.bindingDsl.SCA;
import org.fornax.soa.bindingDsl.SOAP;
import org.fornax.soa.moduledsl.moduleDsl.ImportBindingProtocol;

/**
 * Matches BindingProtocols of the Binding DSL to the respective Connector protocol
 */
@SuppressWarnings("all")
public class ProtocolMatcher {
  public boolean matchesImportBindingProtocol(final BindingProtocol bindingProtocol, final ImportBindingProtocol prot) {
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(prot,ImportBindingProtocol.SCA)) {
        _matched=true;
        if ((bindingProtocol instanceof SCA)) {
          return true;
        } else {
          return false;
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(prot,ImportBindingProtocol.SOAP)) {
        _matched=true;
        if ((bindingProtocol instanceof SOAP)) {
          return true;
        } else {
          return false;
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(prot,ImportBindingProtocol.EJB)) {
        _matched=true;
        if ((bindingProtocol instanceof EJB)) {
          return true;
        } else {
          return false;
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(prot,ImportBindingProtocol.HTTP)) {
        _matched=true;
        if ((bindingProtocol instanceof HTTP)) {
          return true;
        } else {
          return false;
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(prot,ImportBindingProtocol.REST)) {
        _matched=true;
        if ((bindingProtocol instanceof REST)) {
          return true;
        } else {
          return false;
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(prot,ImportBindingProtocol.SAP)) {
        _matched=true;
        if ((bindingProtocol instanceof SAP)) {
          return true;
        } else {
          return false;
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(prot,ImportBindingProtocol.JMS)) {
        _matched=true;
        if ((bindingProtocol instanceof JMS)) {
          return true;
        } else {
          return false;
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(prot,ImportBindingProtocol.FILE)) {
        _matched=true;
        if ((bindingProtocol instanceof FILE)) {
          return true;
        } else {
          return false;
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(prot,ImportBindingProtocol.FTP)) {
        _matched=true;
        if ((bindingProtocol instanceof FTP)) {
          return true;
        } else {
          return false;
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(prot,ImportBindingProtocol.IIOP)) {
        _matched=true;
        if ((bindingProtocol instanceof IIOP)) {
          return true;
        } else {
          return false;
        }
      }
    }
    if (!_matched) {
      if (Objects.equal(prot,ImportBindingProtocol.AMQP)) {
        _matched=true;
        if ((bindingProtocol instanceof AMQP)) {
          return true;
        } else {
          return false;
        }
      }
    }
    return false;
  }
  
  public boolean supportsImportBindingProtocol(final Binding binding, final ImportBindingProtocol prot) {
    EList<BindingProtocol> _protocol = binding.getProtocol();
    final Function1<BindingProtocol,Boolean> _function = new Function1<BindingProtocol,Boolean>() {
        public Boolean apply(final BindingProtocol p) {
          boolean _matchesImportBindingProtocol = ProtocolMatcher.this.matchesImportBindingProtocol(p, prot);
          return Boolean.valueOf(_matchesImportBindingProtocol);
        }
      };
    return IterableExtensions.<BindingProtocol>exists(_protocol, _function);
  }
}
