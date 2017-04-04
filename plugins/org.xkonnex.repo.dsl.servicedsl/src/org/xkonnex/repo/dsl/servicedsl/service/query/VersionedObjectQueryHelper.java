package org.xkonnex.repo.dsl.servicedsl.service.query;

import org.eclipse.emf.ecore.EObject;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Version;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.BusinessObject;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Enumeration;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.GovernanceApproval;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType;

public class VersionedObjectQueryHelper {


	public static String getObjectName(GovernanceApproval g) {
		EObject o = g.eContainer();
		if (o instanceof VersionedType)
			return ((BusinessObject) o).getName();
		else if (o instanceof org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception)
			return ((org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception) o).getName();
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
		else if (o instanceof org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception)
			return ((org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception) o).getVersion();
		else if (o instanceof Service)
			return ((Service) o).getVersion();
		else
			return null;
	}
}
