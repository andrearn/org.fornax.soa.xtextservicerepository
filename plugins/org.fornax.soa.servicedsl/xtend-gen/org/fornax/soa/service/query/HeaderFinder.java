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
  protected MessageHeader _findBestMatchingRequestHeader(final EObject o, final SOAProfile p) {
    Messaging _messaging = p.getMessaging();
    MessageHeaderRef _defaultRequestHeader = _messaging.getDefaultRequestHeader();
    MessageHeader _header = _defaultRequestHeader.getHeader();
    return _header;
  }
  
  protected MessageHeader _findBestMatchingRequestHeader(final Operation o, final SOAProfile p) {
    MessageHeader _xifexpression = null;
    org.fornax.soa.serviceDsl.MessageHeaderRef _requestMessageHeader = o.getRequestMessageHeader();
    MessageHeader _header = _requestMessageHeader==null?(MessageHeader)null:_requestMessageHeader.getHeader();
    boolean _notEquals = (!Objects.equal(_header, null));
    if (_notEquals) {
      org.fornax.soa.serviceDsl.MessageHeaderRef _requestMessageHeader_1 = o.getRequestMessageHeader();
      MessageHeader _header_1 = _requestMessageHeader_1.getHeader();
      _xifexpression = _header_1;
    } else {
      EObject _eContainer = o.eContainer();
      MessageHeader _findBestMatchingRequestHeader = this.findBestMatchingRequestHeader(_eContainer, p);
      _xifexpression = _findBestMatchingRequestHeader;
    }
    return _xifexpression;
  }
  
  protected MessageHeader _findBestMatchingRequestHeader(final Service s, final SOAProfile p) {
    MessageHeader _xifexpression = null;
    org.fornax.soa.serviceDsl.MessageHeaderRef _requestMessageHeader = s.getRequestMessageHeader();
    MessageHeader _header = _requestMessageHeader==null?(MessageHeader)null:_requestMessageHeader.getHeader();
    boolean _notEquals = (!Objects.equal(_header, null));
    if (_notEquals) {
      org.fornax.soa.serviceDsl.MessageHeaderRef _requestMessageHeader_1 = s.getRequestMessageHeader();
      MessageHeader _header_1 = _requestMessageHeader_1.getHeader();
      _xifexpression = _header_1;
    } else {
      EObject _eContainer = s.eContainer();
      MessageHeader _findBestMatchingRequestHeader = this.findBestMatchingRequestHeader(_eContainer, p);
      _xifexpression = _findBestMatchingRequestHeader;
    }
    return _xifexpression;
  }
  
  protected MessageHeader _findBestMatchingResponseHeader(final EObject o, final SOAProfile p) {
    Messaging _messaging = p.getMessaging();
    MessageHeaderRef _defaultResponseHeader = _messaging.getDefaultResponseHeader();
    MessageHeader _header = _defaultResponseHeader.getHeader();
    return _header;
  }
  
  protected MessageHeader _findBestMatchingResponseHeader(final Operation o, final SOAProfile p) {
    MessageHeader _xifexpression = null;
    org.fornax.soa.serviceDsl.MessageHeaderRef _responseMessageHeader = o.getResponseMessageHeader();
    MessageHeader _header = _responseMessageHeader==null?(MessageHeader)null:_responseMessageHeader.getHeader();
    boolean _notEquals = (!Objects.equal(_header, null));
    if (_notEquals) {
      org.fornax.soa.serviceDsl.MessageHeaderRef _responseMessageHeader_1 = o.getResponseMessageHeader();
      MessageHeader _header_1 = _responseMessageHeader_1.getHeader();
      _xifexpression = _header_1;
    } else {
      EObject _eContainer = o.eContainer();
      MessageHeader _findBestMatchingResponseHeader = this.findBestMatchingResponseHeader(_eContainer, p);
      _xifexpression = _findBestMatchingResponseHeader;
    }
    return _xifexpression;
  }
  
  protected MessageHeader _findBestMatchingResponseHeader(final Service s, final SOAProfile p) {
    MessageHeader _xifexpression = null;
    org.fornax.soa.serviceDsl.MessageHeaderRef _responseMessageHeader = s.getResponseMessageHeader();
    MessageHeader _header = _responseMessageHeader==null?(MessageHeader)null:_responseMessageHeader.getHeader();
    boolean _notEquals = (!Objects.equal(_header, null));
    if (_notEquals) {
      org.fornax.soa.serviceDsl.MessageHeaderRef _responseMessageHeader_1 = s.getResponseMessageHeader();
      MessageHeader _header_1 = _responseMessageHeader_1.getHeader();
      _xifexpression = _header_1;
    } else {
      EObject _eContainer = s.eContainer();
      MessageHeader _findBestMatchingResponseHeader = this.findBestMatchingResponseHeader(_eContainer, p);
      _xifexpression = _findBestMatchingResponseHeader;
    }
    return _xifexpression;
  }
  
  protected MessageHeader _findBestMatchingPublishHeader(final EObject o, final SOAProfile p) {
    Messaging _messaging = p.getMessaging();
    MessageHeaderRef _defaultPublishHeader = _messaging.getDefaultPublishHeader();
    MessageHeader _header = _defaultPublishHeader.getHeader();
    return _header;
  }
  
  protected MessageHeader _findBestMatchingPublishHeader(final Operation o, final SOAProfile p) {
    MessageHeader _xifexpression = null;
    org.fornax.soa.serviceDsl.MessageHeaderRef _publishMessageHeader = o.getPublishMessageHeader();
    MessageHeader _header = _publishMessageHeader==null?(MessageHeader)null:_publishMessageHeader.getHeader();
    boolean _notEquals = (!Objects.equal(_header, null));
    if (_notEquals) {
      org.fornax.soa.serviceDsl.MessageHeaderRef _publishMessageHeader_1 = o.getPublishMessageHeader();
      MessageHeader _header_1 = _publishMessageHeader_1.getHeader();
      _xifexpression = _header_1;
    } else {
      EObject _eContainer = o.eContainer();
      MessageHeader _findBestMatchingPublishHeader = this.findBestMatchingPublishHeader(_eContainer, p);
      _xifexpression = _findBestMatchingPublishHeader;
    }
    return _xifexpression;
  }
  
  protected MessageHeader _findBestMatchingPublishHeader(final Service s, final SOAProfile p) {
    MessageHeader _xifexpression = null;
    org.fornax.soa.serviceDsl.MessageHeaderRef _publishMessageHeader = s.getPublishMessageHeader();
    MessageHeader _header = _publishMessageHeader==null?(MessageHeader)null:_publishMessageHeader.getHeader();
    boolean _notEquals = (!Objects.equal(_header, null));
    if (_notEquals) {
      org.fornax.soa.serviceDsl.MessageHeaderRef _publishMessageHeader_1 = s.getPublishMessageHeader();
      MessageHeader _header_1 = _publishMessageHeader_1.getHeader();
      _xifexpression = _header_1;
    } else {
      EObject _eContainer = s.eContainer();
      MessageHeader _findBestMatchingPublishHeader = this.findBestMatchingPublishHeader(_eContainer, p);
      _xifexpression = _findBestMatchingPublishHeader;
    }
    return _xifexpression;
  }
  
  public List<MessageHeader> getLatestMajorVersions(final SOAProfile p) {
    Messaging _messaging = p.getMessaging();
    EList<MessageHeader> _messageHeaders = _messaging.getMessageHeaders();
    return _messageHeaders;
  }
  
  public MessageHeader findBestMatchingRequestHeader(final EObject o, final SOAProfile p) {
    if (o instanceof Operation) {
      return _findBestMatchingRequestHeader((Operation)o, p);
    } else if (o instanceof Service) {
      return _findBestMatchingRequestHeader((Service)o, p);
    } else if (o != null) {
      return _findBestMatchingRequestHeader(o, p);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(o, p).toString());
    }
  }
  
  public MessageHeader findBestMatchingResponseHeader(final EObject o, final SOAProfile p) {
    if (o instanceof Operation) {
      return _findBestMatchingResponseHeader((Operation)o, p);
    } else if (o instanceof Service) {
      return _findBestMatchingResponseHeader((Service)o, p);
    } else if (o != null) {
      return _findBestMatchingResponseHeader(o, p);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(o, p).toString());
    }
  }
  
  public MessageHeader findBestMatchingPublishHeader(final EObject o, final SOAProfile p) {
    if (o instanceof Operation) {
      return _findBestMatchingPublishHeader((Operation)o, p);
    } else if (o instanceof Service) {
      return _findBestMatchingPublishHeader((Service)o, p);
    } else if (o != null) {
      return _findBestMatchingPublishHeader(o, p);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(o, p).toString());
    }
  }
}
