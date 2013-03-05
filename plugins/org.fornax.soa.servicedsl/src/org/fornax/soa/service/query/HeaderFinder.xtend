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
	
	
	def dispatch MessageHeader findBestMatchingRequestHeader (EObject o, SOAProfile p ) { 
		p.messaging?.defaultRequestHeader?.header;
	}
		
	def dispatch MessageHeader findBestMatchingRequestHeader (Operation o, SOAProfile p ) {
		if (o.requestMessageHeader?.header != null) { 
			o.requestMessageHeader.header;
		} else {
			o.eContainer.findBestMatchingRequestHeader (p);
		}
	}
			
	def dispatch MessageHeader findBestMatchingRequestHeader (Service s, SOAProfile p ) {
		if (s.requestMessageHeader?.header != null) { 
			s.requestMessageHeader.header;
		} else {
			s.eContainer.findBestMatchingRequestHeader (p);
		}
	}
	
	def dispatch MessageHeader findBestMatchingResponseHeader (EObject o, SOAProfile p ) { 
		p.messaging?.defaultResponseHeader?.header;
	}
		
	def dispatch MessageHeader findBestMatchingResponseHeader (Operation o, SOAProfile p ) {
		if (o.responseMessageHeader?.header != null) { 
			o.responseMessageHeader.header;
		} else {
			o.eContainer.findBestMatchingResponseHeader (p);
		}
	}
			
	def dispatch MessageHeader findBestMatchingResponseHeader (Service s, SOAProfile p ) {
		if (s.responseMessageHeader?.header != null) { 
			s.responseMessageHeader.header;
		} else {
			s.eContainer.findBestMatchingResponseHeader (p);
		}
	}
	
	def dispatch MessageHeader findBestMatchingPublishHeader (EObject o, SOAProfile p ) { 
		p.messaging?.defaultPublishHeader?.header;
	}
		
	def dispatch MessageHeader findBestMatchingPublishHeader (Operation o, SOAProfile p ) {
		if (o.publishMessageHeader?.header != null) { 
			o.publishMessageHeader.header;
		} else {
			o.eContainer.findBestMatchingPublishHeader (p);
		}
	}
			
	def dispatch MessageHeader findBestMatchingPublishHeader (Service s, SOAProfile p ) {
		if (s.publishMessageHeader?.header != null) { 
			s.publishMessageHeader.header;
		} else {
			s.eContainer.findBestMatchingPublishHeader (p);
		}
	}
	
	def List<MessageHeader> getLatestMajorVersions (SOAProfile p) {
		p.messaging?.messageHeaders;
	}
	
	
}