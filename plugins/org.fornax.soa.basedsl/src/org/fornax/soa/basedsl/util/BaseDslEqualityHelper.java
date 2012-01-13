package org.fornax.soa.basedsl.util;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.resource.VersionedResourceDescriptionStrategy;

public class BaseDslEqualityHelper {
	
	public static boolean isEqual (IEObjectDescription ieObjDesc1, IEObjectDescription ieObjDesc2) {
		if (ieObjDesc1 == null) {
			if (ieObjDesc2 == null) {
				return true;
			} else {
				return false;
			}
		}
		if (!ieObjDesc1.getName().equals(ieObjDesc2.getName()))
			return false;
		String ieObjDesc1Version 	= ieObjDesc1.getUserData (VersionedResourceDescriptionStrategy.VERSION_KEY);
		String ieObjDesc2Version 	= ieObjDesc2.getUserData (VersionedResourceDescriptionStrategy.VERSION_KEY);
		if (ieObjDesc1Version == null && ieObjDesc2Version == null)
			return true;
		return ieObjDesc1Version.equals (ieObjDesc2Version);
	}

}
