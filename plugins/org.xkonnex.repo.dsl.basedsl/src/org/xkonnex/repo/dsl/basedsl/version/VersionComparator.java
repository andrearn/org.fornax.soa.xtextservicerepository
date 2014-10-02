package org.xkonnex.repo.dsl.basedsl.version;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.Version;

/**
 * Comparator for version numbers
 * @author aarnold
 *
 */
public class VersionComparator {
	
	private static final Pattern pattern = Pattern.compile("(^[\\d+][\\.\\d+]*)(?:(?:\\.|\\-)(\\w.*))?$");
	
	/**
	 * Compares two version numbers
	 * @param v1 a version number
	 * @param v2 another version number
	 * @return	<ul>
	 * 		<li>0, if the version numbers v1 and v2 are equal</li>
	 * 		<li>1, if the version v1 is higher than version v2</li>
	 * 		<li>-1, if the version v1 is lower than version v2</li>
	 * </ul>
	 */
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
		return classifierCmp;
	}
	
	/**
	 * Compares two version numbers
	 * @param eObjDesc1 IEObjectDescription of a versioned object 
	 * @param eObjDesc2 another IEObjectDescription of a versioned object
	 * @return	<ul>
	 * 		<li>0, if the version numbers of eObjDesc1 and eObjDesc2 are equal</li>
	 * 		<li>1, if the version of eObjDesc1 is higher than version of eObjDesc2</li>
	 * 		<li>-1, if the version of eObjDesc1 is lower than version of eObjDesc2</li>
	 * </ul>
	 */
	public static int compare (IEObjectDescription eObjDesc1, IEObjectDescription eObjDesc2, IScopeVersionResolver resolver) {
		if (eObjDesc1 == null && eObjDesc2 != null)
			return -1;
		if (eObjDesc1 != null && eObjDesc2 == null)
			return 1;
		return compare (resolver.getVersionAsString(eObjDesc1), resolver.getVersionAsString(eObjDesc2));
	}

	/**
	 * Compares two version numbers
	 * @param v1 a version number
	 * @param v2 another version number
	 * @return	<ul>
	 * 		<li>0, if the version numbers v1 and v2 are equal</li>
	 * 		<li>1, if the version v1 is higher than version v2</li>
	 * 		<li>-1, if the version v1 is lower than version v2</li>
	 * </ul>
	 */
	public static int compare (final Integer v1, final Integer v2) {
		return compare(v1.toString(), v2.toString());
	}
	/**
	 * Compares two version numbers
	 * @param v1 a version number
	 * @param v2 another version number
	 * @return	<ul>
	 * 		<li>0, if the version numbers v1 and v2 are equal</li>
	 * 		<li>1, if the version v1 is higher than version v2</li>
	 * 		<li>-1, if the version v1 is lower than version v2</li>
	 * </ul>
	 */
	public static int compare (final String v1, final Integer v2) {
		return compare(v1.toString(), v2.toString());
	}
	/**
	 * Compares two version numbers
	 * @param v1 a version number
	 * @param v2 another version number
	 * @return	<ul>
	 * 		<li>0, if the version numbers v1 and v2 are equal</li>
	 * 		<li>1, if the version v1 is higher than version v2</li>
	 * 		<li>-1, if the version v1 is lower than version v2</li>
	 * </ul>
	 */
	public static int compare (final Integer v1, final String v2) {
		return compare(v1.toString(), v2.toString());
	}
	/**
	 * Compares two version numbers
	 * @param v1 a version number
	 * @param v2 another version number
	 * @return	<ul>
	 * 		<li>0, if the version numbers v1 and v2 are equal</li>
	 * 		<li>1, if the version v1 is higher than version v2</li>
	 * 		<li>-1, if the version v1 is lower than version v2</li>
	 * </ul>
	 */
	public static int compare (final Version v1, final Version v2) {
		return compare(v1.getVersion(), v2.getVersion());
	}

}
