package org.fornax.soa.servicedsl.query

/* most of templates/common.ext */
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.serviceDsl.BusinessObject
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.Enumeration
import org.eclipse.emf.ecore.EObject
import org.fornax.soa.basedsl.sOABaseDsl.Version
import org.fornax.soa.serviceDsl.VersionedType

class LifecycleQueries {
	def dispatch LifecycleState toOwnerMinDevState (Object o) {
		LifecycleState::DEVELOPMENT;
	}

	def dispatch LifecycleState toOwnerMinDevState (SubNamespace ns) {
		if (ns.linkingPolicy?.minDevState != null) {
			ns.linkingPolicy.minDevState;
		} else {
			LifecycleState::DEVELOPMENT;
		}
	}

	def dispatch LifecycleState toOwnerMinDevState (BusinessObject o) {
		if (o.linkingPolicy?.minDevState != null) {
			o.linkingPolicy.minDevState;
		} else {
			o.eContainer.toOwnerMinDevState();
		}
	}

	def dispatch LifecycleState toOwnerMinDevState (org.fornax.soa.serviceDsl.Enumeration o) {
		if (o.linkingPolicy?.minDevState != null) {
			o.linkingPolicy.minDevState;
		} else {
			o.eContainer.toOwnerMinDevState();
		}
	}
	
	def dispatch LifecycleState toOwnerMinDevState (org.fornax.soa.serviceDsl.Exception o) {
		if (o.linkingPolicy?.minDevState != null) {
			o.linkingPolicy.minDevState;
		} else {
			o.eContainer.toOwnerMinDevState();
		}
		
	}
	
	def dispatch LifecycleState toOwnerMinDevState (Service o) {
		if (o.linkingPolicy?.minDevState != null) {
			o.linkingPolicy.minDevState;
		} else {
			o.eContainer.toOwnerMinDevState();
		}
	}

	def dispatch LifecycleState toOwnerMinTestState (Object o) {
		LifecycleState::TEST;
	}
	
	def LifecycleState toOwnerMinTestState (SubNamespace ns) {
		if (ns.linkingPolicy?.minTestState != null) {
			ns.linkingPolicy.minTestState;
		} else {
			LifecycleState::TEST;
		}
	}

	def dispatch LifecycleState toOwnerMinTestState (BusinessObject o) {
		if (o.linkingPolicy?.minTestState != null) {
			o.linkingPolicy.minTestState;
		} else {
			o.eContainer.toOwnerMinTestState();
		}
	}

	def dispatch LifecycleState toOwnerMinTestState (Enumeration o) {
		if (o.linkingPolicy?.minTestState != null) {
			o.linkingPolicy.minTestState;
		} else {
			o.eContainer.toOwnerMinTestState();
		}
	}

	def dispatch LifecycleState toOwnerMinTestState (org.fornax.soa.serviceDsl.Exception o) {
		if (o.linkingPolicy?.minTestState != null) {
			o.linkingPolicy.minTestState;
		} else {
			o.eContainer.toOwnerMinTestState();
		}
	}

	def dispatch LifecycleState toOwnerMinTestState (Service o) {
		if (o.linkingPolicy?.minTestState != null) {
			o.linkingPolicy.minTestState;
		} else {
			o.eContainer.toOwnerMinTestState();
		}
	}

	def dispatch LifecycleState toOwnerMinProdState (Object o) {
 		LifecycleState::PRODUCTIVE;
	}
	
	def dispatch LifecycleState toOwnerMinProdState (SubNamespace ns) {
		if (ns.linkingPolicy?.minProdState != null) {
			ns.linkingPolicy.minProdState;
		} else {
			LifecycleState::PRODUCTIVE;
		}
	}
	
	def dispatch LifecycleState toOwnerMinProdState (BusinessObject o) {
		if (o.linkingPolicy?.minProdState != null) {
			o.linkingPolicy.minProdState;
		} else {
			o.eContainer.toOwnerMinProdState();
		}
	}

	def dispatch LifecycleState toOwnerMinProdState (Enumeration o) {
		if (o.linkingPolicy?.minProdState != null) {
			o.linkingPolicy.minProdState;
		} else {
			o.eContainer.toOwnerMinProdState();
		}
	}
	
	def dispatch LifecycleState toOwnerMinProdState (org.fornax.soa.serviceDsl.Exception o) {
		if (o.linkingPolicy?.minProdState != null) {
			o.linkingPolicy.minProdState;
		} else {
			o.eContainer.toOwnerMinProdState();
		}
	}
	
	def dispatch LifecycleState toOwnerMinProdState (Service o) {
		if (o.linkingPolicy?.minProdState != null) {
			o.linkingPolicy.minProdState;
		} else {
			o.eContainer.toOwnerMinProdState();
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