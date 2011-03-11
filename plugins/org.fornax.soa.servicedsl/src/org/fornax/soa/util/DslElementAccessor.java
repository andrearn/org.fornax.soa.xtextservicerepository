package org.fornax.soa.util;

import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.serviceDsl.GlobalEvent;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.VersionedType;

public class DslElementAccessor {
	
	public final static DslElementAccessor INSTANCE = new DslElementAccessor();
	
	public EObject getVersionedOwner (EObject candiate) {
		if (candiate.eContainer() == null)
			return candiate;
		if (candiate instanceof BusinessObject) {
				return candiate;
		} else if (candiate instanceof Enumeration) {
			return candiate;
		} else if (candiate instanceof VersionedType) {
			return candiate;
		} else if (candiate instanceof org.fornax.soa.serviceDsl.Exception) {
			return candiate;
		} else if (candiate instanceof Service) {
			return candiate;
		} else if (candiate instanceof GlobalEvent) {
			return candiate;
		}
		return getVersionedOwner(candiate.eContainer());
	}

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
