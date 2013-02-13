package org.fornax.soa.service.query

import java.util.List
import org.eclipse.emf.ecore.EObject
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.serviceDsl.Operation
import org.fornax.soa.serviceDsl.Service

/* 
 * Find the most specific message header declaration to be used by a service operation
 */
class HeaderFinder {
	
	
	def dispatch MessageHeader findBestMatchingHeader (EObject o, SOAProfile p ) { 
		p.messaging.defaultHeader.header;
	}
		
	def dispatch MessageHeader findBestMatchingHeader (Operation o, SOAProfile p ) {
		if (o.messageHeader?.header != null) { 
			o.messageHeader.header;
		} else {
			o.eContainer.findBestMatchingHeader (p);
		}
	}
			
	def dispatch MessageHeader findBestMatchingHeader (Service s, SOAProfile p ) {
		if (s.messageHeader?.header != null) { 
			s.messageHeader.header;
		} else {
			s.eContainer.findBestMatchingHeader (p);
		}
	}
	
	def List<MessageHeader> getLatestMajorVersions (SOAProfile p) {
		p.messaging.messageHeaders;
	}
	
	
}