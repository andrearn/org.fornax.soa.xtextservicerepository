package org.xkonnex.repo.dsl.profiledsl.query.namespace

import com.google.inject.Inject
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup
import org.xkonnex.repo.dsl.profiledsl.profileDsl.OrganizationNamespace
import org.xkonnex.repo.dsl.profiledsl.profileDsl.TechnicalNamespace
import org.xkonnex.repo.dsl.profiledsl.profileDsl.VersionedType
import org.xkonnex.repo.dsl.profiledsl.profileDsl.VersionedTypeRef
import java.util.List

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
	
	def List<TechnicalNamespace> getSubNamespacePath (TechnicalNamespace ns) {
		val List<TechnicalNamespace> nsList = newLinkedList(ns)
		return getSubNamespacePath(nsList)
	}
	
	private def List<TechnicalNamespace> getSubNamespacePath (List<TechnicalNamespace> domList) {
		if (domList.head()?.eContainer instanceof TechnicalNamespace) {
			domList.add (0, domList.head().eContainer as TechnicalNamespace) 
			getSubNamespacePath (domList);
			return domList;
		} else { 
			return domList.filter (typeof (TechnicalNamespace)).toList();
		}
	}
	
}