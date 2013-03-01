package org.fornax.soa.profiledsl.search.predicate;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.search.IEObjectLookup;
import org.fornax.soa.basedsl.version.IScopeVersionResolver;
import org.fornax.soa.basedsl.version.VersionComparator;
import org.fornax.soa.profiledsl.query.LifecycleQueries;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateComparator;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateResolver;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

public class VersionPredicate implements Predicate<IEObjectDescription> {
	
	@Inject LifecycleStateComparator stateComparator;
	@Inject LifecycleStateResolver stateResolver;
	@Inject IEObjectLookup objLookup;

	@Inject IScopeVersionResolver versionResolver;
	
	private String minVersion;
	private String maxVersion;
	private boolean includingMinVersion;
	private boolean includingMaxVersion;
	
	private ResourceSet resourceSet;
	
	
	public VersionPredicate(String minVersion, String maxVersion, ResourceSet rs) {
		this.minVersion = minVersion;
		this.maxVersion = maxVersion;
		this.includingMinVersion = true;
		this.includingMaxVersion = true;
		this.resourceSet = rs;
	}

	public VersionPredicate(String minVersion, String maxVersion, boolean includingMinVersion, boolean includingMaxVersion, ResourceSet rs) {
		this.minVersion = minVersion;
		this.maxVersion = maxVersion;
		this.resourceSet = rs;
	}

	public boolean apply(IEObjectDescription input) {
		return versionMatches(input);
	}
	
	private boolean versionMatches(IEObjectDescription input) {
		EObject o = input.getEObjectOrProxy();
		if (o.eIsProxy()) {
			o = EcoreUtil2.resolve(o, resourceSet);
		}
		EObject versionedObj = objLookup.getVersionedOwner(o);
		if (minVersion == null && maxVersion == null)
			return true;
		String lifecycleState = versionResolver.getVersionAsString(versionedObj);
		if (minVersion != null && maxVersion != null) {
			int minVersionCmp = VersionComparator.compare(lifecycleState, minVersion);
			int maxVersionCmp = VersionComparator.compare(lifecycleState, maxVersion);
			if (includingMinVersion && !includingMaxVersion) {
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
