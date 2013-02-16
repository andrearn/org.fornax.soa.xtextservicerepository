package org.fornax.soa.service.query;

import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader;
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeaderRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.Messaging;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.serviceDsl.Operation;
import org.fornax.soa.serviceDsl.Service;

/**
 * Find the most specific message header declaration to be used by a service operation
 */
@SuppressWarnings("all")
public class HeaderFinder {
  protected MessageHeader _findBestMatchingHeader(final EObject o, final SOAProfile p) {
    Messaging _messaging = p.getMessaging();
    MessageHeaderRef _defaultHeader = _messaging.getDefaultHeader();
    MessageHeader _header = _defaultHeader.getHeader();
    return _header;
  }
  
  protected MessageHeader _findBestMatchingHeader(final Operation o, final SOAProfile p) {
    MessageHeader _xifexpression = null;
    org.fornax.soa.serviceDsl.MessageHeaderRef _messageHeader = o.getMessageHeader();
    MessageHeader _header = _messageHeader==null?(MessageHeader)null:_messageHeader.getHeader();
    boolean _notEquals = (!Objects.equal(_header, null));
    if (_notEquals) {
      org.fornax.soa.serviceDsl.MessageHeaderRef _messageHeader_1 = o.getMessageHeader();
      MessageHeader _header_1 = _messageHeader_1.getHeader();
      _xifexpression = _header_1;
    } else {
      EObject _eContainer = o.eContainer();
      MessageHeader _findBestMatchingHeader = this.findBestMatchingHeader(_eContainer, p);
      _xifexpression = _findBestMatchingHeader;
    }
    return _xifexpression;
  }
  
  protected MessageHeader _findBestMatchingHeader(final Service s, final SOAProfile p) {
    MessageHeader _xifexpression = null;
    org.fornax.soa.serviceDsl.MessageHeaderRef _messageHeader = s.getMessageHeader();
    MessageHeader _header = _messageHeader==null?(MessageHeader)null:_messageHeader.getHeader();
    boolean _notEquals = (!Objects.equal(_header, null));
    if (_notEquals) {
      org.fornax.soa.serviceDsl.MessageHeaderRef _messageHeader_1 = s.getMessageHeader();
      MessageHeader _header_1 = _messageHeader_1.getHeader();
      _xifexpression = _header_1;
    } else {
      EObject _eContainer = s.eContainer();
      MessageHeader _findBestMatchingHeader = this.findBestMatchingHeader(_eContainer, p);
      _xifexpression = _findBestMatchingHeader;
    }
    return _xifexpression;
  }
  
  public List<MessageHeader> getLatestMajorVersions(final SOAProfile p) {
    Messaging _messaging = p.getMessaging();
    EList<MessageHeader> _messageHeaders = _messaging.getMessageHeaders();
    return _messageHeaders;
  }
  
  public MessageHeader findBestMatchingHeader(final EObject o, final SOAProfile p) {
    if (o instanceof Operation) {
      return _findBestMatchingHeader((Operation)o, p);
    } else if (o instanceof Service) {
      return _findBestMatchingHeader((Service)o, p);
    } else if (o != null) {
      return _findBestMatchingHeader(o, p);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(o, p).toString());
    }
  }
}
