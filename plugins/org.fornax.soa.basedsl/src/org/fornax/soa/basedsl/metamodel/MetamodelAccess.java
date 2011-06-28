package org.fornax.soa.basedsl.metamodel;

import org.eclipse.emf.ecore.EObject;

public class MetamodelAccess {

	@SuppressWarnings("unchecked")
	public <T> T getOwnerByType (EObject o, Class<T> c) {
		if (c.isInstance(o))
			return (T) o;
		while (o.eContainer() != null) {
			o = o.eContainer();
			if (c.isInstance(o))
				return (T) o;
		}
		return null;
	}

}