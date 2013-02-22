package org.fornax.soa.basedsl.version;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class VersionClassifierComparator {

	private static final Pattern pattern = Pattern.compile("(^[\\d+][\\.\\d+]*)(?:(?:\\.|\\-)(\\w.*))?$");
	private static final Pattern qualPattern = Pattern.compile("(\\D*)(\\d*)(\\.|\\-)?(SNAPSHOT)?");	
	
	public static int compare (String v1, String v2) {
		VersionClassifier v1Classier = getVersionClassier (v1);
		VersionClassifier v2Classier = getVersionClassier (v2);
		Integer simpleQualNum1 = null;
		Integer simpleQualNum2 = null;
		int clsCmp = v1Classier.compareTo (v2Classier);
		if (clsCmp == 0 && !VersionClassifier.FINAL.equals(v1Classier)) {
			Matcher v1Matcher = pattern.matcher(v1);
			v1Matcher.find();
			String v1Qualifier = v1Matcher.group(2);
			Matcher v2Matcher = pattern.matcher(v2);
			v2Matcher.find();
			String v2Qualifier = v2Matcher.group(2);
			if (v1Qualifier != null) {
				v1Qualifier = v1Qualifier.toUpperCase();
				Matcher q1Matcher = qualPattern.matcher(v1Qualifier);
				q1Matcher.find();
				try {
					simpleQualNum1 = Integer.valueOf(q1Matcher.group(2));
				} catch (Exception ex) {
					
				}
			}
			if (v2Qualifier != null) {
				v2Qualifier = v2Qualifier.toUpperCase();
				Matcher q2Matcher = qualPattern.matcher(v2Qualifier);
				q2Matcher.find();
				try {
					simpleQualNum2 = Integer.valueOf(q2Matcher.group(2));
				} catch (Exception ex) {
					
				}
			}
			if (simpleQualNum1 != null)
				return simpleQualNum1.compareTo(simpleQualNum2);
			else if (simpleQualNum1 == null && simpleQualNum2 == null)
				return 0;
			else 
				return 1;
		} else {
			return clsCmp;
		}
	}
	
	public static VersionClassifier getVersionClassier (String version) {
		Matcher verMatcher = pattern.matcher(version);
		verMatcher.find();
		String verDigits = verMatcher.group(1);
		String verQualifier = verMatcher.group(2);
		if (verQualifier == null || "".equals(verQualifier))
			return VersionClassifier.FINAL;
		verQualifier = verQualifier.toUpperCase();
		if (verQualifier.startsWith ("M")) {
			if (verQualifier.endsWith("SNAPSHOT"))
				return VersionClassifier.MILESTONE_SNAPSHOT;
			else
				return VersionClassifier.MILESTONE;
		} else if (verQualifier.startsWith ("A")) {
			if (verQualifier.endsWith("SNAPSHOT"))
				return VersionClassifier.APLHA_SNAPSHOT;
			else
				return VersionClassifier.APLHA;
		} else if (verQualifier.startsWith ("B")) {
			if (verQualifier.endsWith("SNAPSHOT"))
				return VersionClassifier.BETA_SNAPSHOT;
			else
				return VersionClassifier.BETA;
		} else if (verQualifier.startsWith ("RC") || verQualifier.startsWith ("CR")) {
			if (verQualifier.endsWith("SNAPSHOT"))
				return VersionClassifier.RELEASE_CANDITATE_SNAPSHOT;
			else
				return VersionClassifier.RELEASE_CANDITATE;
		} else {
			if (verQualifier.endsWith("SNAPSHOT"))
				return VersionClassifier.FINAL_SNAPSHOT;
			else
				return VersionClassifier.FINAL;
		}
	}

}
