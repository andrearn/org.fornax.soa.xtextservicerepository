package org.fornax.soa.profiledsl.scoping.versions;

import java.util.List;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.sOABaseDsl.FixedVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.LowerBoundRangeVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MajorVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MaxVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MinVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.basedsl.scoping.versions.filter.AbstractPredicateVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.filter.FixedVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.filter.LatestMajorVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.filter.LatestMaxExclVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.filter.LatestMinInclMaxExclRangeVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.filter.LatestMinInclVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.filter.NullVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.filter.VersionFilter;
import org.fornax.soa.basedsl.version.IScopeVersionResolver;
import org.fornax.soa.basedsl.version.SimpleScopeVersionResolver;
import org.fornax.soa.basedsl.version.VersionedOwnerScopeVersionResolver;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;

import com.google.common.base.Predicate;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class DefaultVersionFilterProvider implements IVersionFilterProvider<IEObjectDescription> {
	
	@Inject Injector injector;
	@Inject ILifecycleStateResolver stateResolver;

	public VersionFilter<IEObjectDescription> createVersionFilter(VersionRef v,
			LifecycleState minState) {
		AbstractPredicateVersionFilter<IEObjectDescription> filter = new NullVersionFilter<IEObjectDescription>();
		if (v != null) {
			IScopeVersionResolver verResolver = new VersionedOwnerScopeVersionResolver (v.eResource().getResourceSet());
			if (v instanceof MajorVersionRef) {
				RelaxedLatestMajorVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedLatestMajorVersionForOwnerStateFilter<IEObjectDescription> (verResolver, new Integer(((MajorVersionRef)v).getMajorVersion()).toString(), stateResolver, minState, v.eResource().getResourceSet());
				injector.injectMembers (stateFilter);
				return stateFilter;
			}
			if (v instanceof MaxVersionRef) {
				RelaxedMaxVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedMaxVersionForOwnerStateFilter<IEObjectDescription> (verResolver, ((MaxVersionRef)v).getMaxVersion(), stateResolver, minState, v.eResource().getResourceSet());
				injector.injectMembers (stateFilter);
				return stateFilter;
			}
			if (v instanceof MinVersionRef) {
				RelaxedLatestMinVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedLatestMinVersionForOwnerStateFilter<IEObjectDescription> (verResolver, ((MinVersionRef)v).getMinVersion(), stateResolver, minState, v.eResource().getResourceSet());
				injector.injectMembers (stateFilter);
				return stateFilter;
			}
			if (v instanceof LowerBoundRangeVersionRef) {
				RelaxedLatestMinMaxVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedLatestMinMaxVersionForOwnerStateFilter<IEObjectDescription> (verResolver, ((LowerBoundRangeVersionRef)v).getMinVersion(), ((LowerBoundRangeVersionRef)v).getMaxVersion(), stateResolver, minState, v.eResource().getResourceSet());
				injector.injectMembers (stateFilter);
				return stateFilter;
			}
			if (v instanceof FixedVersionRef)
				return new FixedVersionFilter<IEObjectDescription>(verResolver, ((FixedVersionRef) v).getFixedVersion());
		}
		return filter;
	}

	public VersionFilter<IEObjectDescription> createVersionFilter(VersionRef v) {
		AbstractPredicateVersionFilter<IEObjectDescription> filter = new NullVersionFilter<IEObjectDescription>();
		if (v != null) {
			IScopeVersionResolver verResolver = new SimpleScopeVersionResolver (v.eResource().getResourceSet());
			if (v instanceof MajorVersionRef)
				return new LatestMajorVersionFilter<IEObjectDescription> (verResolver, new Integer(((MajorVersionRef)v).getMajorVersion()).toString());
			if (v instanceof MaxVersionRef)
				return new LatestMaxExclVersionFilter<IEObjectDescription> (verResolver, ((MaxVersionRef)v).getMaxVersion());
			if (v instanceof MinVersionRef)
				return new LatestMinInclVersionFilter<IEObjectDescription> (verResolver, ((MinVersionRef)v).getMinVersion());
			if (v instanceof LowerBoundRangeVersionRef)
				return new LatestMinInclMaxExclRangeVersionFilter<IEObjectDescription> (verResolver, ((LowerBoundRangeVersionRef)v).getMinVersion(), ((LowerBoundRangeVersionRef)v).getMaxVersion());
			if (v instanceof FixedVersionRef)
				return new FixedVersionFilter<IEObjectDescription>(verResolver, ((FixedVersionRef) v).getFixedVersion());
		}
		return filter;
	}

	public VersionFilter<IEObjectDescription> createVersionFilter(VersionRef v,
			LifecycleState minState,
			Predicate<IEObjectDescription> preFilterPredicate) {
		AbstractPredicateVersionFilter<IEObjectDescription> versionFilter = (AbstractPredicateVersionFilter<IEObjectDescription>)createVersionFilter (v, minState);
		versionFilter.setPreFilterPredicate(preFilterPredicate);
		return versionFilter;
	}

	public VersionFilter<IEObjectDescription> createVersionFilter(VersionRef v,
			Predicate<IEObjectDescription> preFilterPredicate) {
		AbstractPredicateVersionFilter<IEObjectDescription> versionFilter = (AbstractPredicateVersionFilter<IEObjectDescription>)createVersionFilter (v);
		versionFilter.setPreFilterPredicate(preFilterPredicate);
		return versionFilter;
	}

}
