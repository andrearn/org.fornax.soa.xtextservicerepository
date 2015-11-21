package org.xkonnex.repo.dsl.profiledsl.search.predicate;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Version;
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup;
import org.xkonnex.repo.dsl.basedsl.version.IScopeVersionResolver;
import org.xkonnex.repo.dsl.basedsl.version.VersionComparator;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.LifecycleState;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.ILifecycleStateResolver;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.LifecycleStateComparator;
import org.xkonnex.repo.dsl.profiledsl.query.LifecycleQueries;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

public class VersionAndLifecycleStatePredicate implements Predicate<IEObjectDescription> {
	
	@Inject LifecycleStateComparator stateComparator;
	@Inject ILifecycleStateResolver stateResolver;
	@Inject IEObjectLookup objLookup;

	@Inject IScopeVersionResolver versionResolver;
	
	private LifecycleState minState;
	private LifecycleState maxState;
	private String minVersion;
	private String maxVersion;
	private boolean includingMinState;
	private boolean includingMaxState;
	private boolean includingMinVersion;
	private boolean includingMaxVersion;
	
	private ResourceSet resourceSet;
	
	
	public VersionAndLifecycleStatePredicate(LifecycleState minState, LifecycleState maxState, String minVersion, String maxVersion, ResourceSet rs) {
		this.minState = minState;
		this.maxState = maxState;
		this.includingMinState = true;
		this.includingMaxState = true;
		this.minVersion = minVersion;
		this.maxVersion = maxVersion;
		this.includingMinVersion = true;
		this.includingMaxVersion = true;
		this.resourceSet = rs;
	}

	public VersionAndLifecycleStatePredicate(LifecycleState minState, boolean includingMinState, LifecycleState maxState, boolean includingMaxState, String minVersion, String maxVersion, boolean includingMinVersion, boolean includingMaxVersion, ResourceSet rs) {
		this.minState = minState;
		this.maxState = maxState;
		this.includingMinState = includingMinState;
		this.includingMaxState = includingMaxState;
		this.minVersion = minVersion;
		this.maxVersion = maxVersion;
		this.includingMinVersion = includingMinVersion;
		this.includingMaxVersion = includingMaxVersion;
		this.resourceSet = rs;
	}

	public boolean apply(IEObjectDescription input) {
		return stateMatches(input) && versionMatches(input);
	}

	private boolean stateMatches(IEObjectDescription input) {
		EObject o = input.getEObjectOrProxy();
		if (o.eIsProxy()) {
			o = EcoreUtil2.resolve(o, resourceSet);
		}
		EObject statefulObj = objLookup.getStatefulOwner(o);
		if (statefulObj == null) {
			return minState == null && maxState == null;
		}
		if (! stateResolver.definesState(statefulObj)) {
			return true;
		}
		if (minState == null && maxState == null)
			return true;
		LifecycleState lifecycleState = stateResolver.getLifecycleState(statefulObj);
		if (minState != null && maxState != null) {
			int minStateCmp = stateComparator.compare(lifecycleState, minState);
			int maxStateCmp = stateComparator.compare(lifecycleState, maxState);
			if (includingMaxState && includingMinState) {
				if (minStateCmp >= 0 && maxStateCmp <=0)
					return true;
			} else if (includingMinState && !includingMaxState) {
				if (minStateCmp >=0 && maxStateCmp < 0)
					return true;
			} else if (!includingMinState && includingMaxState) {
				if (minStateCmp > 0 && maxStateCmp <= 0)
					return true;
			} else {
				if (minStateCmp > 0 && maxStateCmp < 0)
					return true;
			}
		} else if (minState != null && maxState == null) {
			int minStateCmp = stateComparator.compare(lifecycleState, minState);
			if (includingMinState && minStateCmp >= 0)
				return true;
			else if (!includingMinState && minStateCmp > 0)
				return true;
		} else {
			int maxStateCmp = stateComparator.compare(lifecycleState, maxState);
			if (includingMaxState && maxStateCmp <= 0)
				return true;
			else if (!includingMaxState && maxStateCmp < 0)
				return true;
		}
		return false;
	}
	
	private boolean versionMatches(IEObjectDescription input) {
		EObject o = input.getEObjectOrProxy();
		if (o.eIsProxy()) {
			o = EcoreUtil2.resolve(o, resourceSet);
		}
		EObject versionedObj = objLookup.getVersionedOwner(o);
		if (versionedObj == null) {
			return minVersion == null && maxVersion == null;
		}
		if (minVersion == null && maxVersion == null)
			return true;
		String assetVersion = versionResolver.getVersionAsString(versionedObj);
		if (minVersion != null && maxVersion != null) {
			int minVersionCmp = VersionComparator.compare(assetVersion, minVersion);
			int maxVersionCmp = VersionComparator.compare(assetVersion, maxVersion);
			if (includingMaxState && includingMinState) {
				if (minVersionCmp >= 0 && maxVersionCmp <=0)
					return true;
			} else if (includingMinVersion && !includingMaxVersion) {
				if (minVersionCmp >=0 && maxVersionCmp < 0)
					return true;
			} else if (!includingMinVersion && includingMaxVersion) {
				if (minVersionCmp > 0 && maxVersionCmp <= 0)
					return true;
			} else {
				if (minVersionCmp > 0 && maxVersionCmp < 0)
					return true;
			}
		} else if (minVersion != null && maxVersion == null) {
			int minVersionCmp = VersionComparator.compare(assetVersion, minVersion);
			if (includingMinVersion && minVersionCmp >= 0)
				return true;
			else if (!includingMinVersion && minVersionCmp > 0)
				return true;
		} else {
			int maxVersionCmp = VersionComparator.compare(assetVersion, maxVersion);
			if (includingMaxVersion && maxVersionCmp <= 0)
				return true;
			else if (!includingMaxVersion && maxVersionCmp < 0)
				return true;
		}
		return false;
	}

}
