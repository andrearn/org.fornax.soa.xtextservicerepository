package org.fornax.soa.basedsl.scoping.versions;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.xtext.resource.IEObjectDescription;

public class LatestMinInclVersionFilter implements VersionFilter {

	private String minVersion;
	private VersionResolver resolver;

	public LatestMinInclVersionFilter(VersionResolver resolver, String minVersion) {
		this.minVersion = minVersion;
		this.resolver = resolver;
	}
	
	public boolean matches(IEObjectDescription description) {
		final String v = resolver.getVersion(description);
		if (v != null)
			return VersionComparator.compare(v, minVersion) >= 0;
		else
			return true;
	}

	public Map<String, IEObjectDescription> getBestMatchByNames(
			Iterable<IEObjectDescription> canditates) {
		Map<String, IEObjectDescription> matches = new HashMap<String, IEObjectDescription>();
		for (IEObjectDescription ieObjDesc : canditates) {
			if (matches(ieObjDesc)) {
				String objName = ieObjDesc.getName();
				IEObjectDescription bestMatch = matches.get(objName);
				if (bestMatch == null)
					matches.put(objName, ieObjDesc);
				else {
					int c = VersionComparator.compare(ieObjDesc, bestMatch, resolver);
					if (c >= 0)
						matches.put(objName, ieObjDesc);
				}
			}
		}
		return matches;
	}

	public Map<String, IEObjectDescription> getBestMatchByQualifedNames(
			Iterable<IEObjectDescription> canditates) {
		Map<String, IEObjectDescription> matches = new HashMap<String, IEObjectDescription>();
		for (IEObjectDescription ieObjDesc : canditates) {
			if (ieObjDesc != null && matches(ieObjDesc)) {
				String objName = ieObjDesc.getQualifiedName();
				IEObjectDescription bestMatch = matches.get(objName);
				if (bestMatch == null)
					matches.put(objName, ieObjDesc);
				else {
					int c = VersionComparator.compare(ieObjDesc, bestMatch, resolver);
					if (c >= 0)
						matches.put(objName, ieObjDesc);
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
				+ ((minVersion == null) ? 0 : minVersion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof LatestMinInclVersionFilter))
			return false;
		LatestMinInclVersionFilter other = (LatestMinInclVersionFilter) obj;
		if (minVersion == null) {
			if (other.minVersion != null)
				return false;
		} else if (!minVersion.equals(other.minVersion))
			return false;
		return true;
	}
	

}
