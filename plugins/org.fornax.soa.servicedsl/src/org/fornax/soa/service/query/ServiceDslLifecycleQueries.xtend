package org.fornax.soa.service.query

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.fornax.soa.serviceDsl.Exception
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.VersionedType

/* 
 * Finders for lifecycle state for of elements owning object and minimal applicable 
 * lifecycle state in an environment type as defined in the profile or overriden by the namespace
 */
class ServiceDslLifecycleQueries {
	

	/*
	 * Find the first owning EObject with a LifecycleState that is a transitive compositor of this object
	 */
	def dispatch EObject getStatefulOwner (EObject o) {
		o.eContainer?.getStatefulOwner();
	}
	def dispatch EObject getStatefulOwner (VersionedType versionedType) {
		versionedType;
	}
	def dispatch EObject getStatefulOwner (org.fornax.soa.serviceDsl.Exception exception) {
		exception;
	}
	def dispatch EObject getStatefulOwner (Service service) {
		service;
	}
	

}