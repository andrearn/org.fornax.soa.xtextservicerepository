package org.xkonnex.repo.dsl.profiledsl.query

import org.eclipse.emf.ecore.EObject
import org.xkonnex.repo.dsl.profiledsl.profileDsl.VersionedType
import org.xkonnex.repo.dsl.basedsl.baseDsl.Version

class ProfileVersionQueries {
		
	def dispatch EObject getOwningType (VersionedType o) {
		o;
	}

	def dispatch Version getOwnerVersion (org.xkonnex.repo.dsl.profiledsl.profileDsl.VersionedType o) {
		o.version;
	}

	def dispatch Version getOwnerVersion (org.xkonnex.repo.dsl.profiledsl.profileDsl.VersionedTypeRef o) {
		o.type.ownerVersion;
	}
	
	
}