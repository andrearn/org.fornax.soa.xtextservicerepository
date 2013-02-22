package org.fornax.soa.service.query;

import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.serviceDsl.GovernanceApproval;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.VersionedType;

public class VersionedObjectQueryHelper {


	public static String getObjectName(GovernanceApproval g) {
		EObject o = g.eContainer();
		if (o instanceof VersionedType)
			return ((BusinessObject) o).getName();
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
}
