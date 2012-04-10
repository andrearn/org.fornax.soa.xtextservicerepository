package org.fornax.soa.basedsl.scoping.versions;

import org.eclipse.xtext.resource.IEObjectDescription;

public class VersionComparator {
	
	
	public static int compare (final String v1, final String v2) {
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
		String ver1 = v1;
		String ver2 = v2;
		if (v1Parts.length == v2Parts.length + 1) {
			ver2 = v2 + ".0"; 
		}
		if (v2Parts.length == v1Parts.length + 1) {
			ver1 = v1 + ".0";
		}
		String[] ver1Parts = ver1.split("\\.");
		String[] ver2Parts = ver2.split("\\.");
		for (int i = 0; i < ver1Parts.length; i++) {
			if (i < ver2Parts.length) {
				int classifierCmp = VersionClassifierComparator.compare (ver1Parts[i], ver2Parts[i]);
				if (classifierCmp != 0)
					return classifierCmp;
				
				int cmp = ver1Parts[i].compareTo(ver2Parts[i]);
				if (cmp != 0 && Character.isDigit (ver1Parts[i].charAt (0)) && Character.isDigit (ver2Parts[i].charAt (0))) {
					return cmp;
				}
				if (cmp != 0 && Character.isDigit (ver1Parts[i].charAt (0)) && !Character.isDigit (ver2Parts[i].charAt (0))) {
					if (ver1Parts[i].compareTo ("0") > 0)
						return 1;
					else
						return 0;
				}
				if (cmp != 0 && !Character.isDigit (ver1Parts[i].charAt (0)) && Character.isDigit (ver2Parts[i].charAt (0))) {
					if (ver2Parts[i].compareTo ("0") > 0)
						return 1;
					else
						return 0;
				}
				if (cmp != 0 && !Character.isDigit (ver1Parts[i].charAt (0)) && !Character.isDigit (ver2Parts[i].charAt (0))) {
					return VersionClassifierComparator.compare (ver1Parts[i], ver2Parts[i]);
				}
			}
		}
		
		if (v1Parts.length == v2Parts.length + 1 || v2Parts.length == v1Parts.length + 1)
			return 0;
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
