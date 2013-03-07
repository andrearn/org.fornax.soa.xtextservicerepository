package org.fornax.soa.basedsl.scoping.versions.filter;

import java.util.Collections;
import java.util.HashMap;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.version.IScopeVersionResolver;
import org.fornax.soa.basedsl.version.VersionComparator;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

public class LatestMaxExclVersionFilter<T> extends AbstractPredicateVersionFilter<T> {

	protected String maxVersion;
	protected IScopeVersionResolver resolver;

	public LatestMaxExclVersionFilter(IScopeVersionResolver resolver, String maxVersion) {
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
					IEObjectDescription bestMatch = getCurrentBestMatch(matches, objName);
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
		final String v = resolver.getVersionAsString(description);
		if (v != null)
			return VersionComparator.compare(resolver.getVersionAsString(description), maxVersion) <= 0;
		else
			return true;
	}

	public Multimap<QualifiedName, IEObjectDescription> getBestMatchByQualifiedNames(
			Iterable<IEObjectDescription> canditates, boolean ignoreCase) {
		Multimap<QualifiedName, IEObjectDescription> matches = LinkedHashMultimap.create(5,2);
		if (canditates != null) {
			for (IEObjectDescription ieObjDesc : canditates) {
				if (ieObjDesc != null && matches(ieObjDesc)) {
					QualifiedName objName = ieObjDesc.getQualifiedName();
					IEObjectDescription bestMatch = getCurrentBestMatch(matches, objName);
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
