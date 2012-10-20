package org.fornax.soa.basedsl.metamodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

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
	
	public EObject getStatefulOwner (EObject o) {
		EStructuralFeature feature = o.eClass().getEStructuralFeature("state");
		if (feature != null) 
			return o;
		else if (o.eContainer() != null)
			return getStatefulOwner(o.eContainer());
		else
			return null;
	}
	
	public EObject getVersionedOwner (EObject o) {
		EStructuralFeature feature = o.eClass().getEStructuralFeature("version");
		if (feature != null) 
			return o;
		else if (o.eContainer() != null)
			return getStatefulOwner(o.eContainer());
		else
			return null;
	}

}