package org.fornax.soa.profiledsl.query

import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace
import com.google.inject.Inject
import org.fornax.soa.basedsl.CommonEObjectExtensions

class NamespaceQueries {
	
	@Inject extension CommonEObjectExtensions
	@Inject extension ProfileVersionQueries
		
	def dispatch TechnicalNamespace findOwnerSubdomain (org.fornax.soa.profiledsl.sOAProfileDsl.VersionedTypeRef c) {
		c?.getOwningType()?.eContainer as TechnicalNamespace;
	}
	
		
	def TechnicalNamespace findTechnicalNamespace (org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType c) {
		if (c.eContainer instanceof TechnicalNamespace)
			c.eContainer as TechnicalNamespace 
		else 
			null;
	}
	
}