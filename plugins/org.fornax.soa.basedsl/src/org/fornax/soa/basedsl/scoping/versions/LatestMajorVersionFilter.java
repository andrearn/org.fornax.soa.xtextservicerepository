package org.fornax.soa.basedsl.scoping.versions;

import java.util.Map;

import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.collect.Maps;

public class LatestMajorVersionFilter implements VersionFilter {
	
	private String majorVersion;
	private VersionResolver resolver;
	
	public LatestMajorVersionFilter(VersionResolver resolver, String majorVersion) {
		this.majorVersion = majorVersion;
		this.resolver = resolver;
	}

	public Map<String, IEObjectDescription> getBestMatchByNames(
			Iterable<IEObjectDescription> canditates) {
		Map<String, IEObjectDescription> matches = Maps.newLinkedHashMap();
		for (IEObjectDescription ieObjDesc : canditates) {
			if (ieObjDesc != null && matches(ieObjDesc)) {
				String objName = ieObjDesc.getName();
				IEObjectDescription bestMatch = matches.get(objName);
				if (bestMatch == null) {
					matches.put(objName, ieObjDesc);
				}
				else {
					int c = VersionComparator.compare(ieObjDesc, bestMatch, resolver);
					if (c >= 0) {
						matches.put(objName, ieObjDesc);
					}
				}
			}
		}
		return matches;
	}

	public boolean matches(IEObjectDescription description) {
		final String v = resolver.getVersion(description);
		if (v != null)
			return toMajorVersion (v).equals(majorVersion);
		else
			return true;
	}

	
	public static String toMajorVersion (String v) {
		String[] parts = v.split("\\.");
		return parts[0];
	}

	public Map<String, IEObjectDescription> getBestMatchByQualifedNames(
			Iterable<IEObjectDescription> canditates) {
		Map<String, IEObjectDescription> matches = Maps.newLinkedHashMap();
		for (IEObjectDescription ieObjDesc : canditates) {
			if (matches(ieObjDesc)) {
				String objName = ieObjDesc.getQualifiedName();
				IEObjectDescription bestMatch = matches.get(objName);
				if (bestMatch == null) {
					matches.put(objName, ieObjDesc);
				}
				else {
					int c = VersionComparator.compare(ieObjDesc, bestMatch, resolver);
					if (c >= 0) {
						matches.put(objName, ieObjDesc);
					}
				}
			}
		}
		return matches;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((majorVersion == null) ? 0 : majorVersion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof LatestMajorVersionFilter))
			return false;
		LatestMajorVersionFilter other = (LatestMajorVersionFilter) obj;
		if (majorVersion == null) {
			if (other.majorVersion != null)
				return false;
		} else if (!majorVersion.equals(other.majorVersion))
			return false;
		return true;
	}

	
}
