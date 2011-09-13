package org.fornax.soa.basedsl.scoping.versions;

import java.util.Collections;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

public class FixedVersionFilter<T> extends AbstractPredicateVersionFilter<T>  {

	private String version;
	private VersionResolver resolver;

	public FixedVersionFilter(VersionResolver resolver, String version) {
		this.version = version;
		this.resolver = resolver;
	}
	
	public boolean matches(IEObjectDescription description) {
		final String v = resolver.getVersion(description);
		if (v != null)
			return VersionComparator.compare(v, version) == 0;
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
					if (bestMatch == null) {
						matches.replaceValues (objName, Collections.singleton(ieObjDesc));
					}
					else {
						int c = VersionComparator.compare(ieObjDesc, bestMatch, resolver);
						if (c == 0)
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
					int c = VersionComparator.compare(ieObjDesc, bestMatch, resolver);
					if (c == 0)
						matches.replaceValues (objName, Collections.singleton(ieObjDesc));
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
				+ ((resolver == null) ? 0 : resolver.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof FixedVersionFilter))
			return false;
		FixedVersionFilter other = (FixedVersionFilter) obj;
		if (resolver == null) {
			if (other.resolver != null)
				return false;
		} else if (!resolver.equals(other.resolver))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

}
