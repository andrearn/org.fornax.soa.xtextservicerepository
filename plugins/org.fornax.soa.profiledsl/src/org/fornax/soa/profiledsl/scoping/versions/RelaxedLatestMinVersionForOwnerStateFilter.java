package org.fornax.soa.profiledsl.scoping.versions;

import java.util.Collections;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.scoping.versions.LatestMinInclVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.VersionComparator;
import org.fornax.soa.basedsl.scoping.versions.VersionResolver;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.scoping.IEnvironmentPerspectiveSelector;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

public class RelaxedLatestMinVersionForOwnerStateFilter<T> extends LatestMinInclVersionFilter<T> {
	
	private LifecycleState ownerLifecycleState;
	private LifecycleStateResolver stateResolver;
	
	@Inject
	private	IStateMatcher stateMatcher;
	
	@Inject
	private IEnvironmentPerspectiveSelector envSelector;
	
	@Inject
	private LifecycleStateComparator stateComparator;
	
	public RelaxedLatestMinVersionForOwnerStateFilter (VersionResolver resolver, String minVersion, LifecycleStateResolver stateResolver, LifecycleState ownerLifecycleState) {
		super (resolver, minVersion);
		this.ownerLifecycleState = ownerLifecycleState;
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

	
	public boolean stateMatches (IEObjectDescription description) {
		final LifecycleState state = stateResolver.getLifecycleState(description);
		LifecycleState sourceState = ownerLifecycleState;
		Environment selectedEnvironment = getEnvSelector().getSelectedEnvironment();
		if (selectedEnvironment != null && ownerLifecycleState.eContainer() instanceof Lifecycle) {
			LifecycleState lowestStateByEnvironment = stateMatcher.getLowestStateByEnvironment ((Lifecycle)ownerLifecycleState.eContainer(), selectedEnvironment);
			if (getStateComparator().compare (ownerLifecycleState, lowestStateByEnvironment) > 0)
				sourceState = lowestStateByEnvironment;
		}
		if (state == null && sourceState != null) {
			return true;
		} else if (sourceState != null && (sourceState.isIsEnd() || sourceState.isIsInitial())) {
			return true;
		}
		return getStateMatcher().matches (sourceState, state);
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
				+ ((minVersion == null) ? 0 : minVersion.hashCode());
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
		if (!(obj instanceof RelaxedLatestMinVersionForOwnerStateFilter))
			return false;
		RelaxedLatestMinVersionForOwnerStateFilter<T> other = (RelaxedLatestMinVersionForOwnerStateFilter<T>) obj;
		if (minVersion == null) {
			if (other.minVersion != null)
				return false;
		} else if (!minVersion.equals(other.minVersion))
			return false;
		if (ownerLifecycleState != other.ownerLifecycleState)
			return false;
		return true;
	}

	public void setStateMatcher(IStateMatcher stateMatcher) {
		this.stateMatcher = stateMatcher;
	}

	public IStateMatcher getStateMatcher() {
		return stateMatcher;
	}

	public void setEnvSelector(IEnvironmentPerspectiveSelector envSelector) {
		this.envSelector = envSelector;
	}

	public IEnvironmentPerspectiveSelector getEnvSelector() {
		return envSelector;
	}

	public void setStateComparator(LifecycleStateComparator stateComparator) {
		this.stateComparator = stateComparator;
	}

	public LifecycleStateComparator getStateComparator() {
		return stateComparator;
	}
	

}