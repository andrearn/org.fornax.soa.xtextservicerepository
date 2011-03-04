package org.fornax.soa.basedsl.scoping.versions;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.xtext.resource.IEObjectDescription;

public class LatestMaxExclVersionFilter implements VersionFilter {

	private String maxVersion;
	private VersionResolver resolver;

	public LatestMaxExclVersionFilter(VersionResolver resolver, String maxVersion) {
		this.maxVersion = maxVersion;
		this.resolver = resolver;
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

	public boolean matches(IEObjectDescription description) {
		final String v = resolver.getVersion(description);
		if (v != null)
			return VersionComparator.compare(resolver.getVersion(description), maxVersion) <= 0;
		else
			return true;
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
				+ ((maxVersion == null) ? 0 : maxVersion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof LatestMaxExclVersionFilter))
			return false;
		LatestMaxExclVersionFilter other = (LatestMaxExclVersionFilter) obj;
		if (maxVersion == null) {
			if (other.maxVersion != null)
				return false;
		} else if (!maxVersion.equals(other.maxVersion))
			return false;
		return true;
	}

	
}
