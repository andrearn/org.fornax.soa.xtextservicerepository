package org.fornax.soa.basedsl.scoping.versions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtext.resource.IEObjectDescription;

public class VersionComparator {
	
	private static final Pattern pattern = Pattern.compile("(^[\\d+][\\.\\d+]*)(?:(?:\\.|\\-)(\\w.*))?$");
//	private static final Pattern qualPattern = Pattern.compile("(\\D*)(\\d*)(\\.|\\-)?(SNAPSHOT)?");	
	
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
		if ((v1+"SNAPSHOT").equals(v2))
			return -1;
		if ((v2+"SNAPSHOT").equals(v1))
			return 1;
		Matcher v1Matcher = pattern.matcher(v1);
		v1Matcher.find();
		String v1Digits = v1Matcher.group(1);
		String v1Qualifier = v1Matcher.group(2);
		Matcher v2Matcher = pattern.matcher(v2);
		v2Matcher.find();
		String v2Digits = v2Matcher.group(1);
		String v2Qualifier = v2Matcher.group(2);
		String[] v1DigitParts = v1Digits.split("\\.");
		String[] v2DigitParts = v2Digits.split("\\.");
		int dist = v1DigitParts.length - v2DigitParts.length;
		if (dist < 0) {
			dist = -dist;
			for (int i = 0; i < dist; i++) {
				v1Digits = v1Digits + ".0";
			}
		} else if (dist > 0){
			for (int i = 0; i < dist; i++) {
				v2Digits = v2Digits + ".0";
			}
		}
		v1DigitParts = v1Digits.split("\\.");
		v2DigitParts = v2Digits.split("\\.");
		for (int i = 0; i < v1DigitParts.length; i++) {
			if (i < v2DigitParts.length) {
				int cmp = v1DigitParts[i].compareTo(v2DigitParts[i]);
				if (cmp != 0)
					return cmp;
			}
		}
		int classifierCmp = VersionClassifierComparator.compare (v1, v2);
//		if (v1Digits.equals(v2Digits)) {
//			return VersionClassifierComparator.compare(v1, v2);
//		}
//		if (classifierCmp != 0) {
			return classifierCmp;
//		} else {
//			String simpleQualNum1 = null;
//			String simpleQualNum2 = null;
//			if (v1Qualifier != null) {
//				v1Qualifier = v1Qualifier.toUpperCase();
//				Matcher q1Matcher = qualPattern.matcher(v1Qualifier);
//				q1Matcher.find();
//				try {
//					simpleQualNum1 = q1Matcher.group(2);
//				} catch (Exception ex) {
//					
//				}
//			}
//			if (v2Qualifier != null) {
//				v2Qualifier = v2Qualifier.toUpperCase();
//				Matcher q2Matcher = qualPattern.matcher(v2Qualifier);
//				q2Matcher.find();
//				try {
//					simpleQualNum2 = q2Matcher.group(2);
//				} catch (Exception ex) {
//					
//				}
//			}
//			if (simpleQualNum1 != null)
//				return simpleQualNum1.compareTo(simpleQualNum2);
//			else if (simpleQualNum1 == null && simpleQualNum2 == null)
//				return 0;
//			else 
//				return 1;
//		}
	}
	
	public static int compare (IEObjectDescription eObjDesc1, IEObjectDescription eObjDesc2, VersionResolver resolver) {
		if (eObjDesc1 == null && eObjDesc2 != null)
			return -1;
		if (eObjDesc1 != null && eObjDesc2 == null)
			return 1;
		return compare (resolver.getVersion(eObjDesc1), resolver.getVersion(eObjDesc2));
	}

	public static int compare (final Integer v1, final Integer v2) {
		return compare(v1.toString(), v2.toString());
	}
	public static int compare (final String v1, final Integer v2) {
		return compare(v1.toString(), v2.toString());
	}
	public static int compare (final Integer v1, final String v2) {
		return compare(v1.toString(), v2.toString());
	}

}
