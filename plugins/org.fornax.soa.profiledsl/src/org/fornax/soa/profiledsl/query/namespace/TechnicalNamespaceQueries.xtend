package org.fornax.soa.profiledsl.query.namespace

import com.google.inject.Inject
import org.fornax.soa.basedsl.search.IEObjectLookup
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace

class TechnicalNamespaceQueries {
	
	@Inject extension IEObjectLookup
		
	def TechnicalNamespace findOwnerSubdomain (org.fornax.soa.profiledsl.sOAProfileDsl.VersionedTypeRef c) {
		val TechnicalNamespace ns = c.getOwnerByType(typeof (TechnicalNamespace))
		return ns
	}
	
		
	def TechnicalNamespace findTechnicalNamespace (org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType c) {
		if (c.eContainer instanceof TechnicalNamespace)
			c.eContainer as TechnicalNamespace 
		else 
			null;
	}
	
}