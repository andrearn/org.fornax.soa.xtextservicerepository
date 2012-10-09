package org.fornax.soa.util;

import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.basedsl.metamodel.MetamodelAccess;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.serviceDsl.GlobalEvent;
import org.fornax.soa.serviceDsl.Operation;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.VersionedType;

public class DslElementAccessor extends MetamodelAccess {
	
	public final static DslElementAccessor INSTANCE = new DslElementAccessor();
	
	public EObject getVersionedOwner (EObject canditate) {
		if (canditate.eContainer() == null)
			return canditate;
		if (canditate instanceof BusinessObject) {
			return canditate;
		} else if (canditate instanceof Enumeration) {
			return canditate;
		} else if (canditate instanceof VersionedType) {
			return canditate;
		} else if (canditate instanceof org.fornax.soa.serviceDsl.Exception) {
			return canditate;
		} else if (canditate instanceof Service) {
			return canditate;
		} else if (canditate instanceof GlobalEvent) {
			return canditate;
		}
		return getVersionedOwner(canditate.eContainer());
	}
	
	public Operation getOwningOperation (EObject canditate) {
		if (canditate instanceof Operation) {
			return (Operation)canditate;
		} else if (canditate.eContainer() != null){
			return getOwningOperation (canditate.eContainer());
		} else {
			return null;
		}
	}
}
