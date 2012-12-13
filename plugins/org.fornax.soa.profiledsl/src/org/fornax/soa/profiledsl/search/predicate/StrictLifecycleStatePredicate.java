package org.fornax.soa.profiledsl.search.predicate;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.scoping.versions.VersionComparator;
import org.fornax.soa.basedsl.scoping.versions.VersionResolver;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateComparator;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateResolver;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

public class StrictLifecycleStatePredicate implements Predicate<IEObjectDescription> {
	
	@Inject LifecycleStateComparator stateComparator;
	@Inject LifecycleStateResolver stateResolver;

	@Inject VersionResolver versionResolver;
	
	private LifecycleState minState;
	private LifecycleState maxState;
	private String minVersion;
	private String maxVersion;
	private boolean includingMinState;
	private boolean includingMaxState;
	private boolean includingMinVersion;
	private boolean includingMaxVersion;
	
	private ResourceSet resourceSet;
	
	
	public StrictLifecycleStatePredicate(LifecycleState minState, LifecycleState maxState, String minVersion, String maxVersion, ResourceSet rs) {
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

	public StrictLifecycleStatePredicate(LifecycleState minState, boolean includingMinState, LifecycleState maxState, boolean includingMaxState, String minVersion, String maxVersion, boolean includingMinVersion, boolean includingMaxVersion, ResourceSet rs) {
		this.minState = minState;
		this.maxState = maxState;
		this.includingMinState = includingMinState;
		this.includingMaxState = includingMaxState;
		this.minVersion = minVersion;
		this.maxVersion = maxVersion;
		this.resourceSet = rs;
	}

	public boolean apply(IEObjectDescription input) {
		return stateMatches(input) && versionMatches(input);
	}

	private boolean stateMatches(IEObjectDescription input) {
		if (! stateResolver.definesState(input)) {
			return false;
		}
		if (minState == null && maxState == null)
			return true;
		LifecycleState lifecycleState = stateResolver.getLifecycleState(input, resourceSet);
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
		if (minVersion == null && maxVersion == null)
			return true;
		String lifecycleState = versionResolver.getVersion(input);
		if (minVersion != null && maxVersion != null) {
			int minVersionCmp = VersionComparator.compare(lifecycleState, minVersion);
			int maxVersionCmp = VersionComparator.compare(lifecycleState, maxVersion);
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
			int minVersionCmp = VersionComparator.compare(lifecycleState, minVersion);
			if (includingMinVersion && minVersionCmp >= 0)
				return true;
			else if (!includingMinVersion && minVersionCmp > 0)
				return true;
		} else {
			int maxVersionCmp = VersionComparator.compare(lifecycleState, maxVersion);
			if (includingMaxVersion && maxVersionCmp <= 0)
				return true;
			else if (!includingMaxVersion && maxVersionCmp < 0)
				return true;
		}
		return false;
	}

}
