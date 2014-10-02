package org.xkonnex.repo.dsl.profiledsl.scoping.versions;

import java.util.Collections;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.LatestMaxExclVersionFilter;
import org.xkonnex.repo.dsl.basedsl.version.IScopeVersionResolver;
import org.xkonnex.repo.dsl.basedsl.version.VersionComparator;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.EnvironmentType;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.LifecycleState;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

public class EnvironmentBasedLatestMaxVersionFilter<T> extends
		LatestMaxExclVersionFilter<T> {
	@Inject
	private ILifecycleStateResolver stateResolver;
	private String environmentName;
	private EnvironmentType environmentType;
	private ResourceSet resSet;
	
	@Inject
	private	IStateMatcher stateMatcher;
	
	public EnvironmentBasedLatestMaxVersionFilter (IScopeVersionResolver resolver, String maxVersion, String environmentName, EnvironmentType envType) {
		super (resolver, maxVersion);
		this.environmentName = environmentName;
		this.environmentType = envType;
	}
	public EnvironmentBasedLatestMaxVersionFilter (IScopeVersionResolver resolver, String maxVersion, String environmentName, EnvironmentType envType, ResourceSet rs) {
		super (resolver, maxVersion);
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

	public Multimap<QualifiedName, IEObjectDescription> getBestMatchByQualifiedNames(
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
				+ ((maxVersion == null) ? 0 : maxVersion.hashCode());
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EnvironmentBasedLatestMaxVersionFilter))
			return false;
		EnvironmentBasedLatestMaxVersionFilter<T> other = (EnvironmentBasedLatestMaxVersionFilter<T>) obj;
		if (maxVersion == null) {
			if (other.maxVersion != null)
				return false;
		} else if (!maxVersion.equals(other.maxVersion))
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
