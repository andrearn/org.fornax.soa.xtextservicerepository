package org.fornax.soa.basedsl.scoping.versions;

import java.util.Collections;
import java.util.Map;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

/**
 * A filter of potential references in scope matching the version constraint and
 * the LifecycleState constraints. If an object with a name matches to the
 * version constraint only and no object with the same name has a full match it
 * will not be filtered though.
 * 
 * @author aarnold
 * 
 */
public class RelaxedLatestMajorVersionForOwnerStateFilter<T> extends AbstractPredicateVersionFilter<T> {
	
	private String majorVersion;
	private VersionResolver resolver;
	private LifecycleState ownerLifecycleState;
	private LifecycleState minDevLifecycleState;
	private LifecycleState minTestLifecycleState;
	private LifecycleState minProdLifecycleState;
	private LifecycleStateResolver stateResolver;
	
	public RelaxedLatestMajorVersionForOwnerStateFilter (VersionResolver resolver, String majorVersion, LifecycleStateResolver stateResolver, LifecycleState ownerLifecycleState, LifecycleState minDevLifecycleState, LifecycleState minTestLifecycleState, LifecycleState minProdLifecycleState) {
		this.majorVersion = majorVersion;
		this.resolver = resolver;
		this.ownerLifecycleState = ownerLifecycleState;
		this.minDevLifecycleState = minDevLifecycleState;
		this.minTestLifecycleState = minTestLifecycleState;
		this.minProdLifecycleState = minProdLifecycleState;
		this.stateResolver = stateResolver;
	}

	public Multimap<QualifiedName, IEObjectDescription> getBestMatchByNames (
			Iterable<IEObjectDescription> canditates, boolean ignoreCase) {
		Multimap<QualifiedName, IEObjectDescription> matches = LinkedHashMultimap.create(5,2);
		if (canditates != null) {
			Multimap<QualifiedName, IEObjectDescription> versionMatches = LinkedHashMultimap.create(5,2);
			for (IEObjectDescription ieObjDesc : canditates) {
				if (ieObjDesc != null && matches(ieObjDesc)) {
					QualifiedName objName = ieObjDesc.getName();
					IEObjectDescription bestMatch = getCurrentBestMatch (matches, objName);
					if (bestMatch == null) {
						if (stateMatches(ieObjDesc))
							matches.replaceValues (objName, Collections.singleton(ieObjDesc));
						else
							versionMatches.replaceValues(objName, Collections.singleton (ieObjDesc));
					}
					else {
						int c = VersionComparator.compare(ieObjDesc, bestMatch, resolver);
						if (c >= 0) {
							if (stateMatches(ieObjDesc))
								matches.replaceValues(objName, Collections.singleton (ieObjDesc));
							else {
								versionMatches.replaceValues(objName, Collections.singleton (ieObjDesc));
							}
						}
					}
				}
			}
			for (QualifiedName relaxedCandName : versionMatches.keySet()) {
				if (!matches.containsKey(relaxedCandName))
					matches.replaceValues (relaxedCandName, Collections.singleton (getCurrentBestMatch (versionMatches, relaxedCandName)));
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
	
	public boolean stateMatches (IEObjectDescription description) {
		final LifecycleState state = stateResolver.getLifecycleState(description);
		if (state == null && ownerLifecycleState != null) {
			return true;
		} else if (ownerLifecycleState == LifecycleState.RETIRED) {
			return true;
		} else if (ownerLifecycleState == LifecycleState.DEFINED && state != LifecycleState.RETIRED) {
			return LifecycleStateComparator.compare(ownerLifecycleState, state) >= 0 || LifecycleStateComparator.compare(minDevLifecycleState, state) >= 0;
		} else if (ownerLifecycleState == LifecycleState.DEVELOPMENT && state != LifecycleState.RETIRED) {
			return LifecycleStateComparator.compare(ownerLifecycleState, state) >= 0 || LifecycleStateComparator.compare(minDevLifecycleState, state) >= 0;
		} else if (ownerLifecycleState == LifecycleState.TEST && state != LifecycleState.RETIRED) {
			return LifecycleStateComparator.compare(ownerLifecycleState, state) >= 0 || LifecycleStateComparator.compare(minTestLifecycleState, state) >= 0;
		} else if (ownerLifecycleState == LifecycleState.PRODUCTIVE && state != LifecycleState.RETIRED) {
			return LifecycleStateComparator.compare(ownerLifecycleState, state) >= 0 || LifecycleStateComparator.compare(minProdLifecycleState, state) >= 0;
		} else if (ownerLifecycleState == LifecycleState.DEPRECATED && state != LifecycleState.RETIRED) {
			return LifecycleStateComparator.compare(ownerLifecycleState, state) >= 0 || LifecycleStateComparator.compare(minProdLifecycleState, state) >= 0;
		} else if (ownerLifecycleState == LifecycleState.PROPOSED && state != LifecycleState.RETIRED) {
			return LifecycleStateComparator.compare(ownerLifecycleState, state) >= 0 || LifecycleStateComparator.compare(minDevLifecycleState, state) >= 0;
		} else {
			return false;
		}
		
	}
	

	
	public static String toMajorVersion (String v) {
		String[] parts = v.split("\\.");
		return parts[0];
	}

	public Multimap<QualifiedName, IEObjectDescription> getBestMatchByQualifedNames(
			Iterable<IEObjectDescription> canditates, boolean ignoreCase) {
		Multimap<QualifiedName, IEObjectDescription> matches = LinkedHashMultimap.create(5,2);
		if (canditates != null) {
			for (IEObjectDescription ieObjDesc : canditates) {
				if (matches(ieObjDesc)) {
					QualifiedName objName = ieObjDesc.getQualifiedName();
					IEObjectDescription bestMatch = getCurrentBestMatch (matches, objName);
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
				+ ((minDevLifecycleState == null) ? 0 : minDevLifecycleState
						.hashCode());
		result = prime
				* result
				+ ((minProdLifecycleState == null) ? 0 : minProdLifecycleState
						.hashCode());
		result = prime
				* result
				+ ((minTestLifecycleState == null) ? 0 : minTestLifecycleState
						.hashCode());
		result = prime
				* result
				+ ((ownerLifecycleState == null) ? 0 : ownerLifecycleState
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RelaxedLatestMajorVersionForOwnerStateFilter))
			return false;
		RelaxedLatestMajorVersionForOwnerStateFilter other = (RelaxedLatestMajorVersionForOwnerStateFilter) obj;
		if (majorVersion == null) {
			if (other.majorVersion != null)
				return false;
		} else if (!majorVersion.equals(other.majorVersion))
			return false;
		if (minDevLifecycleState != other.minDevLifecycleState)
			return false;
		if (minProdLifecycleState != other.minProdLifecycleState)
			return false;
		if (minTestLifecycleState != other.minTestLifecycleState)
			return false;
		if (ownerLifecycleState != other.ownerLifecycleState)
			return false;
		return true;
	}
	

}
