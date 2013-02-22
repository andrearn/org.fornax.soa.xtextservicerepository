package org.fornax.soa.basedsl.scoping.versions.filter;

import java.util.Collections;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.version.IScopeVersionResolver;
import org.fornax.soa.basedsl.version.VersionComparator;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

public class LatestMinInclVersionFilter<T> extends AbstractPredicateVersionFilter<T>  {

	protected String minVersion;
	protected IScopeVersionResolver resolver;

	public LatestMinInclVersionFilter(IScopeVersionResolver resolver, String minVersion) {
		this.minVersion = minVersion;
		this.resolver = resolver;
	}
	
	public boolean matches(IEObjectDescription description) {
		final String v = resolver.getVersionAsString(description);
		if (v != null)
			return VersionComparator.compare(v, minVersion) >= 0;
		else
			return true;
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
		LatestMinInclVersionFilter<T> other = (LatestMinInclVersionFilter<T>) obj;
		if (minVersion == null) {
			if (other.minVersion != null)
				return false;
		} else if (!minVersion.equals(other.minVersion))
			return false;
		return true;
	}
	

}
