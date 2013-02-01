package org.fornax.soa.service.query

import org.fornax.soa.basedsl.sOABaseDsl.Version
import org.eclipse.emf.ecore.EObject
import org.fornax.soa.serviceDsl.VersionedType
import org.fornax.soa.serviceDsl.Service

class VersionQueries {
	

	def dispatch Version getOwnerVersion (EObject o) {
		o.eContainer?.getOwnerVersion();
	}
	
	def dispatch Version getOwnerVersion (VersionedType versionedType) {
		versionedType.version;
	}
	
	def dispatch Version getOwnerVersion (org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType technicalVersionedType) {
		technicalVersionedType.version;
	}

	def dispatch Version getOwnerVersion (org.fornax.soa.serviceDsl.Exception exception) {
		exception.version;
	}
	
	def dispatch Version getOwnerVersion (Service service) {
		service.version;
	}
	
}