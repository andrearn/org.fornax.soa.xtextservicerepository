package org.xkonnex.repo.dsl.profiledsl.query.namespace

import com.google.inject.Inject
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup
import org.xkonnex.repo.dsl.profiledsl.profileDsl.OrganizationNamespace
import org.xkonnex.repo.dsl.profiledsl.profileDsl.TechnicalNamespace
import org.xkonnex.repo.dsl.profiledsl.profileDsl.VersionedType
import org.xkonnex.repo.dsl.profiledsl.profileDsl.VersionedTypeRef

class TechnicalNamespaceQueries {
	
	@Inject extension IEObjectLookup
		
	def TechnicalNamespace findOwnerSubdomain (VersionedTypeRef c) {
		val TechnicalNamespace ns = c.getOwnerByType(typeof (TechnicalNamespace))
		return ns
	}
	
		
	def TechnicalNamespace findTechnicalNamespace (VersionedType c) {
		if (c.eContainer instanceof TechnicalNamespace)
			c.eContainer as TechnicalNamespace 
		else 
			null;
	}
	
	def OrganizationNamespace findOrgNamespace (TechnicalNamespace o) { 
		if (o.eContainer instanceof OrganizationNamespace) {
			o.eContainer as OrganizationNamespace;
		} else if (o.eContainer instanceof TechnicalNamespace) {
			this?.findOrgNamespace (o.eContainer as TechnicalNamespace) as OrganizationNamespace;
		} else {
			return null
		}
	}
	
}