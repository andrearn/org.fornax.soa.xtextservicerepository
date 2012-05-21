package org.fornax.soa.query;

import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.serviceDsl.Operation;
import org.fornax.soa.serviceDsl.Service;

public class MessageHeaderQuery {
	
	public MessageHeader getMessageHeader (Service service, SOAProfile profile) {
		if (service.getMessageHeader () != null) {
			return service.getMessageHeader ().getHeader ();
		} else {
			return profile.getMessaging ().getDefaultHeader ().getHeader ();
		}
	}
	
	public MessageHeader getMessageHeader (Operation operation, SOAProfile profile) {
		if (operation.getMessageHeader () != null) {
			return operation.getMessageHeader ().getHeader ();
		} else {
			return getMessageHeader ((Service) operation.eContainer (), profile);
		}
	}

}
