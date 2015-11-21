package org.xkonnex.repo.dsl.servicedsl.service.query

import java.util.List
import org.eclipse.emf.ecore.EObject
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.MessageHeader
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.AbstractProfile
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service

/* 
 * Find the most specific message header declaration to be used by a service operation
 */
class HeaderFinder {
	
	
	def dispatch MessageHeader findBestMatchingRequestHeader (EObject o, AbstractProfile p ) { 
		p.messaging?.defaultRequestHeader?.header;
	}
		
	def dispatch MessageHeader findBestMatchingRequestHeader (Operation o, AbstractProfile p ) {
		if (o.requestMessageHeader?.header != null) { 
			o.requestMessageHeader.header;
		} else {
			o.eContainer.findBestMatchingRequestHeader (p);
		}
	}
			
	def dispatch MessageHeader findBestMatchingRequestHeader (Service s, AbstractProfile p ) {
		if (s.requestMessageHeader?.header != null) { 
			s.requestMessageHeader.header;
		} else {
			s.eContainer.findBestMatchingRequestHeader (p);
		}
	}
	
	def dispatch MessageHeader findBestMatchingResponseHeader (EObject o, AbstractProfile p ) { 
		p.messaging?.defaultResponseHeader?.header;
	}
		
	def dispatch MessageHeader findBestMatchingResponseHeader (Operation o, AbstractProfile p ) {
		if (o.responseMessageHeader?.header != null) { 
			o.responseMessageHeader.header;
		} else {
			o.eContainer.findBestMatchingResponseHeader (p);
		}
	}
			
	def dispatch MessageHeader findBestMatchingResponseHeader (Service s, AbstractProfile p ) {
		if (s.responseMessageHeader?.header != null) { 
			s.responseMessageHeader.header;
		} else {
			s.eContainer.findBestMatchingResponseHeader (p);
		}
	}
	
	def dispatch MessageHeader findBestMatchingPublishHeader (EObject o, AbstractProfile p ) { 
		p.messaging?.defaultPublishHeader?.header;
	}
		
	def dispatch MessageHeader findBestMatchingPublishHeader (Operation o, AbstractProfile p ) {
		if (o.publishMessageHeader?.header != null) { 
			o.publishMessageHeader.header;
		} else {
			o.eContainer.findBestMatchingPublishHeader (p);
		}
	}
			
	def dispatch MessageHeader findBestMatchingPublishHeader (Service s, AbstractProfile p ) {
		if (s.publishMessageHeader?.header != null) { 
			s.publishMessageHeader.header;
		} else {
			s.eContainer.findBestMatchingPublishHeader (p);
		}
	}
	
	def List<MessageHeader> getLatestMajorVersions (AbstractProfile p) {
		p.messaging?.messageHeaders;
	}
	
	
}