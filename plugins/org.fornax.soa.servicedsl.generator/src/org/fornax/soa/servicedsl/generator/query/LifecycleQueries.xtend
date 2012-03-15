package org.fornax.soa.servicedsl.generator.query


import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.serviceDsl.BusinessObject
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.Enumeration
import org.eclipse.emf.ecore.EObject
import org.fornax.soa.basedsl.sOABaseDsl.Version
import org.fornax.soa.serviceDsl.VersionedType
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import com.google.inject.Inject
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle

/* 
 * Finders for lifecycle state for of elements owning object and minimal applicable 
 * lifecycle state in an environment type as defined in the profile or overriden by the namespace
 */
class LifecycleQueries {
	
	@Inject org.fornax.soa.profiledsl.generator.query.LifecycleQueries lifecycleQueries
	
	def dispatch LifecycleState toOwnerMinDevState (Object o, Lifecycle l) {
		lifecycleQueries.getMinDevState (l);
	}

	def dispatch LifecycleState toOwnerMinDevState (SubNamespace ns, Lifecycle l) {
		if (ns.linkingPolicy?.minDevState != null) {
			ns.linkingPolicy.minDevState;
		} else {
			lifecycleQueries.getMinDevState(l);
		}
	}

	def dispatch LifecycleState toOwnerMinDevState (BusinessObject o, Lifecycle l) {
		if (o.linkingPolicy?.minDevState != null) {
			o.linkingPolicy.minDevState;
		} else {
			o.eContainer.toOwnerMinDevState(l);
		}
	}

	def dispatch LifecycleState toOwnerMinDevState (org.fornax.soa.serviceDsl.Enumeration o, Lifecycle l) {
		if (o.linkingPolicy?.minDevState != null) {
			o.linkingPolicy.minDevState;
		} else {
			o.eContainer.toOwnerMinDevState(l);
		}
	}
	
	def dispatch LifecycleState toOwnerMinDevState (org.fornax.soa.serviceDsl.Exception o, Lifecycle l) {
		if (o.linkingPolicy?.minDevState != null) {
			o.linkingPolicy.minDevState;
		} else {
			o.eContainer.toOwnerMinDevState(l);
		}
		
	}
	
	def dispatch LifecycleState toOwnerMinDevState (Service o, Lifecycle l) {
		if (o.linkingPolicy?.minDevState != null) {
			o.linkingPolicy.minDevState;
		} else {
			o.eContainer.toOwnerMinDevState(l);
		}
	}

	def dispatch LifecycleState toOwnerMinTestState (Object o, Lifecycle l) {
		lifecycleQueries.getMinTestState(l);
	}
	
	def LifecycleState toOwnerMinTestState (SubNamespace ns, Lifecycle l) {
		if (ns.linkingPolicy?.minTestState != null) {
			ns.linkingPolicy.minTestState;
		} else {
			lifecycleQueries.getMinTestState(l);
		}
	}

	def dispatch LifecycleState toOwnerMinTestState (BusinessObject o, Lifecycle l) {
		if (o.linkingPolicy?.minTestState != null) {
			o.linkingPolicy.minTestState;
		} else {
			o.eContainer.toOwnerMinTestState(l);
		}
	}

	def dispatch LifecycleState toOwnerMinTestState (Enumeration o, Lifecycle l) {
		if (o.linkingPolicy?.minTestState != null) {
			o.linkingPolicy.minTestState;
		} else {
			o.eContainer.toOwnerMinTestState(l);
		}
	}

	def dispatch LifecycleState toOwnerMinTestState (org.fornax.soa.serviceDsl.Exception o, Lifecycle l) {
		if (o.linkingPolicy?.minTestState != null) {
			o.linkingPolicy.minTestState;
		} else {
			o.eContainer.toOwnerMinTestState(l);
		}
	}

	def dispatch LifecycleState toOwnerMinTestState (Service o, Lifecycle l) {
		if (o.linkingPolicy?.minTestState != null) {
			o.linkingPolicy.minTestState;
		} else {
			o.eContainer.toOwnerMinTestState(l);
		}
	}

	def dispatch LifecycleState toOwnerMinProdState (Object o, Lifecycle l) {
		lifecycleQueries.getMinProdState(l);
	}
	
	def dispatch LifecycleState toOwnerMinProdState (SubNamespace ns, Lifecycle l) {
		if (ns.linkingPolicy?.minProdState != null) {
			ns.linkingPolicy.minProdState;
		} else {
			lifecycleQueries.getMinProdState(l);
		}
	}
	
	def dispatch LifecycleState toOwnerMinProdState (BusinessObject o, Lifecycle l) {
		if (o.linkingPolicy?.minProdState != null) {
			o.linkingPolicy.minProdState;
		} else {
			o.eContainer.toOwnerMinProdState(l);
		}
	}

	def dispatch LifecycleState toOwnerMinProdState (Enumeration o, Lifecycle l) {
		if (o.linkingPolicy?.minProdState != null) {
			o.linkingPolicy.minProdState;
		} else {
			o.eContainer.toOwnerMinProdState(l);
		}
	}
	
	def dispatch LifecycleState toOwnerMinProdState (org.fornax.soa.serviceDsl.Exception o, Lifecycle l) {
		if (o.linkingPolicy?.minProdState != null) {
			o.linkingPolicy.minProdState;
		} else {
			o.eContainer.toOwnerMinProdState(l);
		}
	}
	
	def dispatch LifecycleState toOwnerMinProdState (Service o, Lifecycle l) {
		if (o.linkingPolicy?.minProdState != null) {
			o.linkingPolicy.minProdState;
		} else {
			o.eContainer.toOwnerMinProdState(l);
		}
	}


	def dispatch EObject getStatefulOwner (EObject o) {
		o.eContainer?.getStatefulOwner();
	}
	
	def dispatch EObject getStatefulOwner (BusinessObject o) {
		o;
	}
	
	def dispatch EObject getStatefulOwner (Enumeration o) {
		o;
	}
	
	def dispatch EObject getStatefulOwner (org.fornax.soa.serviceDsl.Exception o) {
		o;
	}
	
	def dispatch EObject getStatefulOwner (Service o) {
		o;
	}
	
	
	def dispatch EObject getOwningType (EObject o) {
		o.eContainer?.getOwningType();
	}


	def dispatch LifecycleState getOwnerState (EObject o) {
		o.eContainer?.getOwnerState();
	}
	
	def dispatch LifecycleState getOwnerState (VersionedType o) {
		o.state;
	}
	
	def dispatch LifecycleState getOwnerState (org.fornax.soa.serviceDsl.Exception o) {
		o.state;
	}

	def dispatch LifecycleState getOwnerState (Service o) {
		o.state;
	}
}