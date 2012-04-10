package org.fornax.soa.basedsl.scoping.versions;

public class VersionClassifierComparator {
	
	public static int compare (String v1, String v2) {
		VersionClassifier v1Classier = getVersionClassier (v1);
		VersionClassifier v2Classier = getVersionClassier (v2);
		return v1Classier.compareTo (v2Classier);
	}
	
	public static VersionClassifier getVersionClassier (String version) {
		String[] parts = version.split("\\.");
		String lastSegment = parts[parts.length-1];
		if (lastSegment.startsWith ("M") || lastSegment.startsWith ("m")) {
			return VersionClassifier.MILESTONE;
		} else if (lastSegment.startsWith ("A") || lastSegment.startsWith ("a")) {
			return VersionClassifier.APLHA;
		} else if (lastSegment.startsWith ("B") || lastSegment.startsWith ("b")) {
			return VersionClassifier.BETA;
		} else if (lastSegment.startsWith ("RC") || lastSegment.startsWith ("rc")) {
			return VersionClassifier.RELEASE_CANDITATE;
		} else if (lastSegment.startsWith ("CR") || lastSegment.startsWith ("cr")) {
			return VersionClassifier.RELEASE_CANDITATE;
		} else {
			return VersionClassifier.FINAL;
		}
	}

}
