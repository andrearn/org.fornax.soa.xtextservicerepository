package org.xkonnex.repo.dsl.servicedsl.service.query

import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.Version
import org.eclipse.emf.ecore.EObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service

class VersionQueries {
	

	def dispatch Version getOwnerVersion (EObject o) {
		o.eContainer?.getOwnerVersion();
	}
	
	def dispatch Version getOwnerVersion (VersionedType versionedType) {
		versionedType.version;
	}
	
	def dispatch Version getOwnerVersion (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.VersionedType technicalVersionedType) {
		technicalVersionedType.version;
	}

	def dispatch Version getOwnerVersion (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception exception) {
		exception.version;
	}
	
	def dispatch Version getOwnerVersion (Service service) {
		service.version;
	}
	
}