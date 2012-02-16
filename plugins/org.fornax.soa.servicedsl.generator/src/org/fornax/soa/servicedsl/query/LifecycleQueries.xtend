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
	def dispatch LifecycleState getOwnerMinDevState (Object o) {
		LifecycleState::DEVELOPMENT;
	}

	def dispatch LifecycleState getOwnerMinDevState (SubNamespace ns) {
		if (ns.linkingPolicy.minDevState != null) {
			ns.linkingPolicy.minDevState;
		} else {
			LifecycleState::DEVELOPMENT;
		}
	}

	def dispatch LifecycleState getOwnerMinDevState (BusinessObject o) {
		if (o.linkingPolicy.minDevState != null) {
			o.linkingPolicy.minDevState;
		} else {
			o.eContainer.getOwnerMinDevState();
		}
	}

	def dispatch LifecycleState getOwnerMinDevState (org.fornax.soa.serviceDsl.Enumeration o) {
		if (o.linkingPolicy.minDevState != null) {
			o.linkingPolicy.minDevState;
		} else {
			o.eContainer.getOwnerMinDevState();
		}
	}
	
	def dispatch LifecycleState getOwnerMinDevState (org.fornax.soa.serviceDsl.Exception o) {
		if (o.linkingPolicy.minDevState != null) {
			o.linkingPolicy.minDevState;
		} else {
			o.eContainer.getOwnerMinDevState();
		}
		
	}
	
	def dispatch LifecycleState getOwnerMinDevState (Service o) {
		if (o.linkingPolicy.minDevState != null) {
			o.linkingPolicy.minDevState;
		} else {
			o.eContainer.getOwnerMinDevState();
		}
	}

	def dispatch LifecycleState getOwnerMinTestState (Object o) {
		LifecycleState::TEST;
	}
	
	def LifecycleState getOwnerMinTestState (SubNamespace ns) {
		if (ns.linkingPolicy.minTestState != null) {
			ns.linkingPolicy.minTestState;
		} else {
			LifecycleState::TEST;
		}
	}

	def dispatch LifecycleState getOwnerMinTestState (BusinessObject o) {
		if (o.linkingPolicy.minTestState != null) {
			o.linkingPolicy.minTestState;
		} else {
			o.eContainer.getOwnerMinTestState();
		}
	}

	def dispatch LifecycleState getOwnerMinTestState (Enumeration o) {
		if (o.linkingPolicy.minTestState != null) {
			o.linkingPolicy.minTestState;
		} else {
			o.eContainer.getOwnerMinTestState();
		}
	}

	def dispatch LifecycleState getOwnerMinTestState (org.fornax.soa.serviceDsl.Exception o) {
		if (o.linkingPolicy.minTestState != null) {
			o.linkingPolicy.minTestState;
		} else {
			o.eContainer.getOwnerMinTestState();
		}
	}

	def dispatch LifecycleState getOwnerMinTestState (Service o) {
		if (o.linkingPolicy.minTestState != null) {
			o.linkingPolicy.minTestState;
		} else {
			o.eContainer.getOwnerMinTestState();
		}
	}

	def dispatch LifecycleState getOwnerMinProdState (Object o) {
 		LifecycleState::PRODUCTIVE;
	}
	
	def dispatch LifecycleState getOwnerMinProdState (SubNamespace ns) {
		if (ns.linkingPolicy.minProdState != null) {
			ns.linkingPolicy.minProdState;
		} else {
			LifecycleState::PRODUCTIVE;
		}
	}
	
	def dispatch LifecycleState getOwnerMinProdState (BusinessObject o) {
		if (o.linkingPolicy.minProdState != null) {
			o.linkingPolicy.minProdState;
		} else {
			o.eContainer.getOwnerMinProdState();
		}
	}

	def dispatch LifecycleState getOwnerMinProdState (Enumeration o) {
		if (o.linkingPolicy.minProdState != null) {
			o.linkingPolicy.minProdState;
		} else {
			o.eContainer.getOwnerMinProdState();
		}
	}
	
	def dispatch LifecycleState getOwnerMinProdState (org.fornax.soa.serviceDsl.Exception o) {
		if (o.linkingPolicy.minProdState != null) {
			o.linkingPolicy.minProdState;
		} else {
			o.eContainer.getOwnerMinProdState();
		}
	}
	
	def dispatch LifecycleState getOwnerMinProdState (Service o) {
		if (o.linkingPolicy.minProdState != null) {
			o.linkingPolicy.minProdState;
		} else {
			o.eContainer.getOwnerMinProdState();
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


	def dispatch Version getOwnerVersion (EObject o) {
		o.eContainer?.getOwnerVersion();
	}
	
	def dispatch Version getOwnerVersion (VersionedType o) {
		o.version;
	}

	def dispatch Version getOwnerVersion (org.fornax.soa.serviceDsl.Exception o) {
		o.version;
	}
	
	def dispatch Version getOwnerVersion (Service o) {
		o.version;
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