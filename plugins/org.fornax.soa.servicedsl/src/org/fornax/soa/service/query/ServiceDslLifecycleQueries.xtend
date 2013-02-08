package org.fornax.soa.service.query

import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.serviceDsl.Service
import org.eclipse.emf.ecore.EObject
import org.fornax.soa.serviceDsl.VersionedType
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import com.google.inject.Inject
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle

/* 
 * Finders for lifecycle state for of elements owning object and minimal applicable 
 * lifecycle state in an environment type as defined in the profile or overriden by the namespace
 */
class ServiceDslLifecycleQueries {
	
	@Inject org.fornax.soa.profiledsl.search.LifecycleQueries lifecycleQueries
	
	def dispatch LifecycleState toOwnerMinLocalState (EObject o, Lifecycle lifecycle) {
		lifecycleQueries.getMinLocalState (lifecycle);
	}
	def dispatch LifecycleState toOwnerMinLocalState (SubNamespace namespace, Lifecycle lifecycle) {
		lifecycleQueries.getMinLocalState(lifecycle);
	}
	def dispatch LifecycleState toOwnerMinLocalState (VersionedType versionedType, Lifecycle lifecycle) {
		versionedType.eContainer.toOwnerMinLocalState(lifecycle);
	}
	def dispatch LifecycleState toOwnerMinLocalState (org.fornax.soa.serviceDsl.Exception exception, Lifecycle lifecycle) {
		exception.eContainer.toOwnerMinLocalState(lifecycle);
	}
	def dispatch LifecycleState toOwnerMinLocalState (Service service, Lifecycle lifecycle) {
		service.eContainer.toOwnerMinLocalState(lifecycle);
	}
	
	def dispatch LifecycleState toOwnerMinDevState (EObject o, Lifecycle lifecycle) {
		lifecycleQueries.getMinDevState (lifecycle);
	}
	def dispatch LifecycleState toOwnerMinDevState (SubNamespace namespace, Lifecycle lifecycle) {
		lifecycleQueries.getMinDevState (lifecycle);
	}
	def dispatch LifecycleState toOwnerMinDevState (VersionedType versionedType, Lifecycle lifecycle) {
		versionedType.eContainer.toOwnerMinDevState (lifecycle);
	}
	def dispatch LifecycleState toOwnerMinDevState (org.fornax.soa.serviceDsl.Exception exception, Lifecycle lifecycle) {
		exception.eContainer.toOwnerMinDevState (lifecycle);
	}
	def dispatch LifecycleState toOwnerMinDevState (Service service, Lifecycle lifecycle) {
		service.eContainer.toOwnerMinDevState (lifecycle);
	}

	def dispatch LifecycleState toOwnerMinTestState (EObject o, Lifecycle lifecycle) {
		lifecycleQueries.getMinTestState(lifecycle);
	}
	def dispatch LifecycleState toOwnerMinTestState (SubNamespace namespace, Lifecycle lifecycle) {
		lifecycleQueries.getMinTestState(lifecycle);
	}
	def dispatch LifecycleState toOwnerMinTestState (VersionedType versionedType, Lifecycle lifecycle) {
		versionedType.eContainer.toOwnerMinTestState(lifecycle);
	}
	def dispatch LifecycleState toOwnerMinTestState (org.fornax.soa.serviceDsl.Exception exception, Lifecycle lifecycle) {
		exception.eContainer.toOwnerMinTestState(lifecycle);
	}
	def dispatch LifecycleState toOwnerMinTestState (Service service, Lifecycle lifecycle) {
		service.eContainer.toOwnerMinTestState(lifecycle);
	}

	def dispatch LifecycleState toOwnerMinStagingState (EObject o, Lifecycle lifecycle) {
		lifecycleQueries.getMinStagingState (lifecycle);
	}
	def dispatch LifecycleState toOwnerMinStagingState (SubNamespace namespace, Lifecycle lifecycle) {
		lifecycleQueries.getMinStagingState (lifecycle);
	}
	def dispatch LifecycleState toOwnerMinStagingState (VersionedType versionedType, Lifecycle lifecycle) {
		versionedType.eContainer.toOwnerMinStagingState (lifecycle);
	}
	def dispatch LifecycleState toOwnerMinStagingState (org.fornax.soa.serviceDsl.Exception exception, Lifecycle lifecycle) {
		exception.eContainer.toOwnerMinStagingState (lifecycle);
	}
	def dispatch LifecycleState toOwnerMinStagingState (Service service, Lifecycle lifecycle) {
		service.eContainer.toOwnerMinStagingState (lifecycle);
	}

	def dispatch LifecycleState toOwnerMinProdState (EObject o, Lifecycle lifecycle) {
		lifecycleQueries.getMinProdState(lifecycle);
	}
	def dispatch LifecycleState toOwnerMinProdState (SubNamespace namespace, Lifecycle lifecycle) {
		lifecycleQueries.getMinProdState(lifecycle);
	}
	def dispatch LifecycleState toOwnerMinProdState (VersionedType versionedType, Lifecycle lifecycle) {
		versionedType.eContainer.toOwnerMinProdState(lifecycle);
	}
	def dispatch LifecycleState toOwnerMinProdState (org.fornax.soa.serviceDsl.Exception exception, Lifecycle lifecycle) {
		exception.eContainer.toOwnerMinProdState(lifecycle);
	}
	def dispatch LifecycleState toOwnerMinProdState (Service service, Lifecycle lifecycle) {
		service.eContainer.toOwnerMinProdState(lifecycle);
	}


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
	
	/* 
	 * Find the closest Type that transitively is on the owning side of the composition hierarchy
	 */	
	def EObject getOwningType (EObject o) {
		o.eContainer?.getOwningType();
	}


	/* 
	 * Get the LifecycleState of the closest EObject defining a LifecycleState that transitively is on the owning side of the composition hierarchy
	 */	
	def dispatch LifecycleState getOwnerState (EObject o) {
		o.eContainer?.getOwnerState();
	}
	def dispatch LifecycleState getOwnerState (VersionedType versionedType) {
		versionedType.state;
	}
	def dispatch LifecycleState getOwnerState (org.fornax.soa.serviceDsl.Exception exception) {
		exception.state;
	}
	def dispatch LifecycleState getOwnerState (Service service) {
		service.state;
	}
}