package org.xkonnex.repo.dsl.profiledsl.scoping.versions;

import java.util.Collections;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.AbstractPredicateVersionFilter;
import org.xkonnex.repo.dsl.basedsl.version.IScopeVersionResolver;
import org.xkonnex.repo.dsl.basedsl.version.VersionComparator;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

public class LatestMajorVersionForOwnerStateFilter<T> extends AbstractPredicateVersionFilter<T> {
	
	private String majorVersion;
	private IScopeVersionResolver resolver;
	private LifecycleState ownerLifecycleState;
	private ILifecycleStateResolver stateResolver;
	private ResourceSet resourceSet;
	
	@Inject
	IStateMatcher stateMatcher;
	
	public LatestMajorVersionForOwnerStateFilter(IScopeVersionResolver resolver, String majorVersion, ILifecycleStateResolver stateResolver, LifecycleState ownerLifecycleState, ResourceSet resourceSet) {
		this.majorVersion = majorVersion;
		this.resolver = resolver;
		this.ownerLifecycleState = ownerLifecycleState;
		this.stateResolver = stateResolver;
		this.resourceSet = resourceSet;
	}

	public Multimap<QualifiedName, IEObjectDescription> getBestMatchByNames(
			Iterable<IEObjectDescription> canditates, boolean ignoreCase) {
		Multimap<QualifiedName, IEObjectDescription> matches = LinkedHashMultimap.create(5,2);
		if (canditates != null) {
			for (IEObjectDescription ieObjDesc : canditates) {
				if (ieObjDesc != null && matches (ieObjDesc)) {
					QualifiedName objName = ieObjDesc.getName();
					IEObjectDescription bestMatch = getCurrentBestMatch(matches, objName);
					if (bestMatch == null) {
						matches.replaceValues (objName, Collections.singleton(ieObjDesc));
					}
					else {
						int c = VersionComparator.compare (ieObjDesc, bestMatch, resolver);
						if (c >= 0) {
							matches.replaceValues (objName, Collections.singleton(ieObjDesc));
						}
					}
				}
			}
		}
		return matches;
	}

	public boolean matches(IEObjectDescription description) {
		final String v = resolver.getVersionAsString(description);
		final LifecycleState state = stateResolver.getLifecycleState(description, resourceSet);
		if (v != null)
			if (state != null)
				return toMajorVersion (v).equals(majorVersion) && stateMatches (state);
			else
				return toMajorVersion (v).equals(majorVersion);
		else
			return true;
	}
	
	public boolean stateMatches (LifecycleState state) {
		return stateMatcher.matches (ownerLifecycleState, state);
	}
	

	
	public static String toMajorVersion (String v) {
		String[] parts = v.split("\\.");
		return parts[0];
	}

	public Multimap<QualifiedName, IEObjectDescription> getBestMatchByQualifiedNames(
			Iterable<IEObjectDescription> canditates, boolean ignoreCase) {
		Multimap<QualifiedName, IEObjectDescription> matches = LinkedHashMultimap.create(5,2);
		if (canditates != null) {
			for (IEObjectDescription ieObjDesc : canditates) {
				if (matches(ieObjDesc)) {
					QualifiedName objName = ieObjDesc.getQualifiedName();
					IEObjectDescription bestMatch = getCurrentBestMatch(matches, objName);
					if (bestMatch == null) {
						matches.replaceValues (objName, Collections.singleton(ieObjDesc));
					}
					else {
						int c = VersionComparator.compare(ieObjDesc, bestMatch, resolver);
						if (c >= 0) {
							matches.replaceValues (objName, Collections.singleton(ieObjDesc));
						}
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
		result = prime
				* result
				+ ((ownerLifecycleState == null) ? 0 : ownerLifecycleState
						.hashCode());
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof LatestMajorVersionForOwnerStateFilter))
			return false;
		LatestMajorVersionForOwnerStateFilter<T> other = (LatestMajorVersionForOwnerStateFilter<T>) obj;
		if (majorVersion == null) {
			if (other.majorVersion != null)
				return false;
		} else if (!majorVersion.equals(other.majorVersion))
			return false;
		if (ownerLifecycleState != other.ownerLifecycleState)
			return false;
		return true;
	}
	
	

}
