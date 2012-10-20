package org.fornax.soa.profiledsl.scoping.versions;

import java.util.Collections;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.scoping.versions.LatestMinInclVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.VersionComparator;
import org.fornax.soa.basedsl.scoping.versions.VersionResolver;
import org.fornax.soa.environmentDsl.EnvironmentType;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

public class EnvironmentBasedLatestMinVersionFilter<T> extends
		LatestMinInclVersionFilter<T> {

	@Inject
	private LifecycleStateResolver stateResolver;
	private String environmentName;
	private EnvironmentType environmentType;
	private ResourceSet resSet;
	
	@Inject
	private	IStateMatcher stateMatcher;
	
	public EnvironmentBasedLatestMinVersionFilter (VersionResolver resolver, String minVersion, String environmentName, EnvironmentType envType) {
		super (resolver, minVersion);
		this.environmentName = environmentName;
		this.environmentType = envType;
	}
	public EnvironmentBasedLatestMinVersionFilter (VersionResolver resolver, String minVersion, String environmentName, EnvironmentType envType, ResourceSet rs) {
		super (resolver, minVersion);
		this.environmentName = environmentName;
		this.environmentType = envType;
		this.resSet = rs;
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
		final LifecycleState state = stateResolver.getLifecycleState(description, resSet);
		return stateMatcher.supportsEnvironment (state, environmentName) || stateMatcher.supportsEnvironmentType (state, environmentType);
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
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EnvironmentBasedLatestMinVersionFilter))
			return false;
		EnvironmentBasedLatestMinVersionFilter<T> other = (EnvironmentBasedLatestMinVersionFilter<T>) obj;
		if (minVersion == null) {
			if (other.minVersion != null)
				return false;
		} else if (!minVersion.equals(other.minVersion))
			return false;
		return true;
	}

	public void setStateMatcher(IStateMatcher stateMatcher) {
		this.stateMatcher = stateMatcher;
	}

	public IStateMatcher getStateMatcher() {
		return stateMatcher;
	}
	
}