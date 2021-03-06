package org.xkonnex.repo.dsl.servicedsl.service.query.namespace

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile
import org.xkonnex.repo.dsl.profiledsl.query.ProfileQueries
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace
import org.xkonnex.repo.dsl.servicedsl.service.query.ExceptionFinder
import org.xkonnex.repo.dsl.servicedsl.service.query.ServiceQueries
import org.xkonnex.repo.dsl.servicedsl.service.query.type.TypesByLifecycleStateFinder
import org.xkonnex.repo.dsl.servicedsl.service.versioning.NamespaceSplitter
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObjectRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.EnumTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ExceptionRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.OrganizationNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ResourceRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.TypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedTypeRef

/*
 * Namespace lookup functions
 */
class NamespaceQuery {
	
	@Inject extension IEObjectLookup
	@Inject extension TypesByLifecycleStateFinder
	@Inject extension ServiceQueries
	@Inject extension ExceptionFinder
	@Inject ProfileQueries profileQuery
	@Inject NamespaceSplitter namespaceSplitter

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
	 * 
	 * @param e versioned reference to an exception
	 * @return namespace of thrower of the exception
	 */
	def SubNamespace findExceptionRefOwnerSubdomain (ExceptionRef e) {
		e?.getStatefulOwner()?.eContainer as SubNamespace;
	}
	
	/**
	 *	Find the owning namespace of the owner of the service reference
	 * 
	 * @param s a versioned reference to a service
	 * @return namespace of the service
	 */
	def SubNamespace findServiceRefOwnerSubdomain (ServiceRef s) {
		s?.getStatefulOwner()?.eContainer as SubNamespace;
	}
	
	/**
	 *	Find the owning namespace of the owner of the resource reference
	 * 
	 * @param s a versioned reference to a resource
	 * @return namespace of the resource
	 */
	def SubNamespace findResourceRefOwnerSubdomain (ResourceRef s) {
		s?.getStatefulOwner()?.eContainer as SubNamespace;
	}
	
	def List<SubNamespace> getSubNamespacePath (SubNamespace ns) {
		val List<SubNamespace> nsList = newLinkedList(ns)
		return getSubNamespacePath(nsList)
	}
	
	private def List<SubNamespace> getSubNamespacePath (List<SubNamespace> domList) {
		if (domList.head()?.eContainer instanceof SubNamespace) {
			domList.add (0, domList.head().eContainer as SubNamespace) 
			getSubNamespacePath (domList);
			return domList;
		} else { 
			return domList.filter (typeof (SubNamespace)).toList();
		}
	}

	
	def dispatch boolean hasTypesInMinState (SubNamespace ns, LifecycleState state) {
		ns.typesWithMinState (state).size > 0;
	}
	
	def dispatch boolean hasServicesInMinState (SubNamespace ns, LifecycleState state) {
		ns.servicesWithMinState (state).size > 0;
	}
	
	def dispatch boolean hasResourcesInMinState (SubNamespace ns, LifecycleState state) {
		ns.resourcesWithMinState (state).size > 0;
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
	
	def dispatch boolean hasResourcesInMinState (VersionedDomainNamespace ns, LifecycleState state) {
		ns.resourcesWithMinState (state).size > 0;
	}
	
	def dispatch boolean hasExceptionsInMinState (VersionedDomainNamespace ns, LifecycleState state) {
		ns.exceptionsWithMinState (state).size > 0;
	}
	
	def Profile getApplicableProfile (SubNamespace ns, Profile enforcedProfile) {
		if (enforcedProfile === null) {
			if (ns.profile !== null) {
				return ns.profile
			} else {
				profileQuery.getDefaultProfile (ns.eResource.resourceSet)
			}
		} else {
			return enforcedProfile
		}
	}
	
	def Profile getApplicableProfile (OrganizationNamespace ns, Profile enforcedProfile) {
		if (enforcedProfile === null) {
			if (ns.profile !== null) {
				return ns.profile
			} else {
				profileQuery.getDefaultProfile (ns.eResource.resourceSet)
			}
		} else {
			return enforcedProfile
		}
	}
	
	def VersionedDomainNamespace getVersionedNamespace(VersionedType type) {
		val ns = EcoreUtil2::getContainerOfType(type, typeof(SubNamespace))
		namespaceSplitter.createVersionedDomainNamespace(ns, type.version)
	}
		
}