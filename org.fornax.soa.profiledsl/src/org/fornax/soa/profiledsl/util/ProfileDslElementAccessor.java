package org.fornax.soa.profiledsl.util;

import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.profiledsl.sOAProfileDsl.Enumeration;
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader;
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType;

public class ProfileDslElementAccessor {

	public final static ProfileDslElementAccessor INSTANCE = new ProfileDslElementAccessor();

	public EObject getVersionedOwner(EObject candiate) {
		if (candiate.eContainer() == null)
			return candiate;
		if (candiate instanceof MessageHeader) {
				return candiate;
		} else if (candiate instanceof org.fornax.soa.profiledsl.sOAProfileDsl.Class) {
			return candiate;
		} else if (candiate instanceof Enumeration) {
			return candiate;
		} else if (candiate instanceof VersionedType) {
			return candiate;
		}
		return getVersionedOwner(candiate.eContainer());
	}

	@SuppressWarnings("unchecked")
	public <T> T getOwnerByType(EObject o, Class<T> c) {
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
