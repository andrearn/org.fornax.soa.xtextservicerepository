package org.fornax.soa.service.query;

import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.serviceDsl.Operation;
import org.fornax.soa.serviceDsl.Service;

public class MessageHeaderQuery {
	
	public MessageHeader getRequestMessageHeader (Service service, SOAProfile profile) {
		if (service.getRequestMessageHeader () != null) {
			return service.getRequestMessageHeader ().getHeader ();
		} else {
			return profile.getMessaging ().getDefaultRequestHeader ().getHeader ();
		}
	}
	
	public MessageHeader getRequestMessageHeader (Operation operation, SOAProfile profile) {
		if (operation.getRequestMessageHeader () != null) {
			return operation.getRequestMessageHeader ().getHeader ();
		} else {
			return getRequestMessageHeader ((Service) operation.eContainer (), profile);
		}
	}
	
	public MessageHeader getResponseMessageHeader (Service service, SOAProfile profile) {
		if (service.getResponseMessageHeader () != null) {
			return service.getResponseMessageHeader ().getHeader ();
		} else {
			return profile.getMessaging ().getDefaultRequestHeader ().getHeader ();
		}
	}
	
	public MessageHeader getResponseMessageHeader (Operation operation, SOAProfile profile) {
		if (operation.getResponseMessageHeader () != null) {
			return operation.getResponseMessageHeader ().getHeader ();
		} else {
			return getRequestMessageHeader ((Service) operation.eContainer (), profile);
		}
	}
	
	public MessageHeader getPublishMessageHeader (Service service, SOAProfile profile) {
		if (service.getPublishMessageHeader () != null) {
			return service.getPublishMessageHeader ().getHeader ();
		} else {
			return profile.getMessaging ().getDefaultRequestHeader ().getHeader ();
		}
	}
	
	public MessageHeader getPublishMessageHeader (Operation operation, SOAProfile profile) {
		if (operation.getPublishMessageHeader () != null) {
			return operation.getPublishMessageHeader ().getHeader ();
		} else {
			return getRequestMessageHeader ((Service) operation.eContainer (), profile);
		}
	}

}
