package org.fornax.soa.basedsl.scoping.versions;

import java.util.Collections;
import java.util.HashMap;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

public class LatestMinInclMaxExclRangeVersionFilter<T> extends AbstractPredicateVersionFilter<T>  {

	private String maxVersion;
	private String minVersion;
	private VersionResolver resolver;

	public LatestMinInclMaxExclRangeVersionFilter(VersionResolver resolver, String minVersion, String maxVersion) {
		this.minVersion = minVersion;
		this.maxVersion = maxVersion;
		this.resolver = resolver;
	}
	
	public Multimap<QualifiedName, IEObjectDescription> getBestMatchByNames(
			Iterable<IEObjectDescription> canditates, boolean ignoreCase) {
		Multimap<QualifiedName, IEObjectDescription> matches = LinkedHashMultimap.create(5,2);
		if (canditates != null) {
			for (IEObjectDescription ieObjDesc : canditates) {
				if (matches(ieObjDesc)) {
					QualifiedName objName = ieObjDesc.getName();
					IEObjectDescription bestMatch = getCurrentBestMatch (matches, objName);
					if (bestMatch == null)
						matches.replaceValues (objName, Collections.singleton(ieObjDesc));
					else {
						int c = VersionComparator.compare(ieObjDesc, bestMatch, resolver);
						if (c >= 0)
							matches.replaceValues (objName, Collections.singleton(ieObjDesc));
					}
				}
			}
		}
		return matches;
	}

	public boolean matches(IEObjectDescription description) {
		// TODO Auto-generated method stub
		final String version = resolver.getVersion(description);
		if (version != null)
			return (VersionComparator.compare(version, maxVersion) < 0) && (VersionComparator.compare(version, minVersion) >= 0);
		else
			return true;
	}

	public Multimap<QualifiedName, IEObjectDescription> getBestMatchByQualifedNames(
			Iterable<IEObjectDescription> canditates, boolean ignoreCase) {
		Multimap<QualifiedName, IEObjectDescription> matches = LinkedHashMultimap.create(5,2);
		if (canditates != null) {
			for (IEObjectDescription ieObjDesc : canditates) {
				if (ieObjDesc != null && matches(ieObjDesc)) {
					QualifiedName objName = ieObjDesc.getQualifiedName();
					IEObjectDescription bestMatch = getCurrentBestMatch (matches, objName);
					if (bestMatch == null)
						matches.replaceValues (objName, Collections.singleton(ieObjDesc));
					else {
						int c = VersionComparator.compare(ieObjDesc, bestMatch, resolver);
						if (c >= 0)
							matches.replaceValues (objName, Collections.singleton(ieObjDesc));
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
				+ ((maxVersion == null) ? 0 : maxVersion.hashCode());
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
		if (!(obj instanceof LatestMinInclMaxExclRangeVersionFilter))
			return false;
		LatestMinInclMaxExclRangeVersionFilter other = (LatestMinInclMaxExclRangeVersionFilter) obj;
		if (maxVersion == null) {
			if (other.maxVersion != null)
				return false;
		} else if (!maxVersion.equals(other.maxVersion))
			return false;
		if (minVersion == null) {
			if (other.minVersion != null)
				return false;
		} else if (!minVersion.equals(other.minVersion))
			return false;
		return true;
	}
	
	

}
