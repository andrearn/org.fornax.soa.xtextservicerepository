package org.fornax.soa.basedsl.scoping.versions;

import org.eclipse.xtext.resource.IEObjectDescription;

public class VersionComparator {
	
	
	public static int compare (String v1, String v2) {
		if (v1!=null && v2 == null)
			return 1;
		if (v1==null && v2 != null)
			return -1;
		if (v1==null && v2==null)
			return 0;
		if (v1.equals(v2)) {
			return 0;
		}
		
		String[] v1Parts = v1.split("\\.");
		String[] v2Parts = v2.split("\\.");
		for (int i = 0; i < v1Parts.length; i++) {
			if (i < v2Parts.length) {
				int cmp = v1Parts[i].compareTo(v2Parts[i]);
				if (cmp != 0) {
					return cmp;
				}
			}
		}
		
		if (v1Parts.length > v2Parts.length) {
			return 1;
		}
		return -1;
	}
	
	public static int compare (IEObjectDescription eObjDesc1, IEObjectDescription eObjDesc2, VersionResolver resolver) {
		if (eObjDesc1 == null && eObjDesc2 != null)
			return -1;
		if (eObjDesc1 != null && eObjDesc2 == null)
			return 1;
		return compare (resolver.getVersion(eObjDesc1), resolver.getVersion(eObjDesc2));
	}

}
