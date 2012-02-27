package org.fornax.soa.profiledsl.query

import org.eclipse.emf.ecore.EObject
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType
import org.fornax.soa.basedsl.sOABaseDsl.Version

class ProfileVersionQueries {
		
	def dispatch EObject getOwningType (VersionedType o) {
		o;
	}

	def dispatch Version getOwnerVersion (org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType o) {
		o.version;
	}

	def dispatch Version getOwnerVersion (org.fornax.soa.profiledsl.sOAProfileDsl.VersionedTypeRef o) {
		o.type.ownerVersion;
	}
	
	
}