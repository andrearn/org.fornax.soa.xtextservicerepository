package org.xkonnex.repo.dsl.profiledsl.query.namespace

import com.google.inject.Inject
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.TechnicalNamespace

class TechnicalNamespaceQueries {
	
	@Inject extension IEObjectLookup
		
	def TechnicalNamespace findOwnerSubdomain (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.VersionedTypeRef c) {
		val TechnicalNamespace ns = c.getOwnerByType(typeof (TechnicalNamespace))
		return ns
	}
	
		
	def TechnicalNamespace findTechnicalNamespace (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.VersionedType c) {
		if (c.eContainer instanceof TechnicalNamespace)
			c.eContainer as TechnicalNamespace 
		else 
			null;
	}
	
}