package org.fornax.soa.businessdsl.metamodel;

import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.basedsl.metamodel.MetamodelAccess;
import org.fornax.soa.businessDsl.Capability;

public class BusinessDslMetamodelAccess extends MetamodelAccess {
	
	public static final BusinessDslMetamodelAccess INSTANCE = new BusinessDslMetamodelAccess();
	
	public EObject getVersionedOwner (EObject canditate) {
		if (canditate.eContainer() == null)
			return canditate;
		if (canditate instanceof Capability)
			return canditate;
		else
			return getVersionedOwner(canditate.eContainer());
	}

}
