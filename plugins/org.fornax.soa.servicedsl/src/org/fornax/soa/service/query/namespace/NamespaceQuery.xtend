package org.fornax.soa.service.query.namespace

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.fornax.soa.basedsl.search.IEObjectLookup
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.service.VersionedDomainNamespace
import org.fornax.soa.service.query.ExceptionFinder
import org.fornax.soa.service.query.ServiceQueries
import org.fornax.soa.service.query.type.TypesByLifecycleStateFinder
import org.fornax.soa.serviceDsl.DataObjectRef
import org.fornax.soa.serviceDsl.EnumTypeRef
import org.fornax.soa.serviceDsl.ExceptionRef
import org.fornax.soa.serviceDsl.OrganizationNamespace
import org.fornax.soa.serviceDsl.ServiceRef
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.serviceDsl.TypeRef
import org.fornax.soa.serviceDsl.VersionedTypeRef

/*
 * Namespace lookup functions
 */
class NamespaceQuery {
	
	@Inject extension IEObjectLookup
	@Inject extension TypesByLifecycleStateFinder
	@Inject extension ServiceQueries
	@Inject extension ExceptionFinder

	def OrganizationNamespace findOrgNamespace (EObject o) {
		val OrganizationNamespace orgNs = o.getOwnerByType(typeof (OrganizationNamespace))
		return orgNs
	}

	def SubNamespace findSubdomain (EObject o) {
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
	def dispatch SubNamespace findTypeRefOwnerSubdomain (DataObjectRef c) {
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

	
	def dispatch boolean hasTypesInMinState (SubNamespace ns, LifecycleState state) {
		ns.typesWithMinState (state).size > 0;
	}
	
	def dispatch boolean hasServicesInMinState (SubNamespace ns, LifecycleState state) {
		ns.servicesWithMinState (state).size > 0;
	}
	
	def dispatch boolean hasExceptionsInMinState (SubNamespace ns, LifecycleState state) {
		ns.exceptionsWithMinState (state).size > 0;
	}
	
	def dispatch boolean hasTypesInMinState (VersionedDomainNamespace ns, LifecycleState state) {
		ns.typesWithMinState (state).size > 0;
	}
	
	def dispatch boolean hasServicesInMinState (VersionedDomainNamespace ns, LifecycleState state) {
		ns.servicesWithMinState (state).size > 0;
	}
	
	def dispatch boolean hasExceptionsInMinState (VersionedDomainNamespace ns, LifecycleState state) {
		ns.exceptionsWithMinState (state).size > 0;
	}
		
}