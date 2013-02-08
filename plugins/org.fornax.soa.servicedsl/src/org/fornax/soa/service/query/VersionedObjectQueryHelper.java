package org.fornax.soa.service.query;

import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.serviceDsl.GovernanceApproval;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.SubNamespace;

public class VersionedObjectQueryHelper {

	public static LifecycleState getLifecycleState(GovernanceApproval g) {
		EObject o = g.eContainer();
		if (o instanceof BusinessObject)
			return ((BusinessObject) o).getState();
		else if (o instanceof Enumeration)
			return ((Enumeration) o).getState();
		else if (o instanceof org.fornax.soa.serviceDsl.Exception)
			return ((org.fornax.soa.serviceDsl.Exception) o).getState();
		else if (o instanceof Service)
			return ((Service) o).getState();
		else
			return null;
	}

	public static String getObjectName(GovernanceApproval g) {
		EObject o = g.eContainer();
		if (o instanceof BusinessObject)
			return ((BusinessObject) o).getName();
		else if (o instanceof Enumeration)
			return ((Enumeration) o).getName();
		else if (o instanceof org.fornax.soa.serviceDsl.Exception)
			return ((org.fornax.soa.serviceDsl.Exception) o).getName();
		else if (o instanceof Service)
			return ((Service) o).getName();
		else
			return null;
	}

	public static Version getObjectVersion(GovernanceApproval g) {
		EObject o = g.eContainer();
		if (o instanceof BusinessObject)
			return ((BusinessObject) o).getVersion();
		else if (o instanceof Enumeration)
			return ((Enumeration) o).getVersion();
		else if (o instanceof org.fornax.soa.serviceDsl.Exception)
			return ((org.fornax.soa.serviceDsl.Exception) o).getVersion();
		else if (o instanceof Service)
			return ((Service) o).getVersion();
		else
			return null;
	}
	
	public static boolean isStatefulServiceDslObject (EObject o) {
		if (o instanceof SubNamespace || 
				o instanceof BusinessObject ||
				o instanceof Service ||
				o instanceof Enumeration ||
				o instanceof org.fornax.soa.serviceDsl.Exception) {
			return true;
		} else {
			return false;
		}
	}
}
