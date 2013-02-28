package org.fornax.soa.service.query.namespace

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.fornax.soa.basedsl.CommonStringExtensions
import org.fornax.soa.profiledsl.query.LifecycleQueries
import org.fornax.soa.serviceDsl.BusinessObject
import org.fornax.soa.serviceDsl.BusinessObjectRef
import org.fornax.soa.serviceDsl.DomainNamespace
import org.fornax.soa.serviceDsl.EnumTypeRef
import org.fornax.soa.serviceDsl.Enumeration
import org.fornax.soa.serviceDsl.Exception
import org.fornax.soa.serviceDsl.ExceptionRef
import org.fornax.soa.serviceDsl.InternalNamespace
import org.fornax.soa.serviceDsl.OrganizationNamespace
import org.fornax.soa.serviceDsl.QueryObject
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.ServiceRef
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.serviceDsl.Type
import org.fornax.soa.serviceDsl.TypeRef
import org.fornax.soa.serviceDsl.VersionedType
import org.fornax.soa.serviceDsl.VersionedTypeRef
import org.fornax.soa.basedsl.search.IEObjectLookup

/*
 * Namespace lookup functions
 */
class NamespaceQuery {
	
	@Inject extension IEObjectLookup

	def dispatch OrganizationNamespace findOrgNamespace (EObject o) {
		val OrganizationNamespace orgNs = o.getOwnerByType(typeof (OrganizationNamespace))
		return orgNs
	}

	def dispatch SubNamespace findSubdomain (EObject o) {
		val SubNamespace ns = o.getOwnerByType(typeof (SubNamespace))
		return ns
	}

	/**
	 *	Find the owning namespace of the owner of the type reference
	 */
	def dispatch SubNamespace findTypeRefOwnerSubdomain (TypeRef t) {
		t.getStatefulOwner()?.eContainer as SubNamespace;
	}
	
	/**
	 *	Find the owning namespace of the owner of the type reference
	 */
	def dispatch SubNamespace findTypeRefOwnerSubdomain (VersionedTypeRef c) {
		c?.getStatefulOwner()?.eContainer as SubNamespace;
	}
	
	/**
	 *	Find the owning namespace of the owner of the type reference
	 */
	def dispatch SubNamespace findTypeRefOwnerSubdomain (BusinessObjectRef c) {
		c?.getStatefulOwner()?.eContainer as SubNamespace;
	}
	
	/**
	 *	Find the owning namespace of the owner of the type reference
	 */
	def dispatch SubNamespace findTypeRefOwnerSubdomain (EnumTypeRef c) {
		c?.getStatefulOwner()?.eContainer as SubNamespace;
	}
	
	/**
	 *	Find the owning namespace of the owner of the exception reference
	 */
	def SubNamespace findExceptionRefOwnerSubdomain (ExceptionRef e) {
		e?.getStatefulOwner()?.eContainer as SubNamespace;
	}
	
	/**
	 *	Find the owning namespace of the owner of the service reference
	 */
	def SubNamespace findServiceRefOwnerSubdomain (ServiceRef s) {
		s?.getStatefulOwner()?.eContainer as SubNamespace;
	}
		
}