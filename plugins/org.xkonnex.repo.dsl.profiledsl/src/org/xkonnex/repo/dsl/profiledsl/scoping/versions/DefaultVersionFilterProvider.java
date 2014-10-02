package org.xkonnex.repo.dsl.profiledsl.scoping.versions;

import java.util.List;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.AbstractPredicateVersionFilter;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.FixedVersionFilter;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.LatestMajorVersionFilter;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.LatestMaxExclVersionFilter;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.LatestMinInclMaxExclRangeVersionFilter;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.LatestMinInclVersionFilter;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.NullVersionFilter;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.VersionFilter;
import org.xkonnex.repo.dsl.basedsl.version.IScopeVersionResolver;
import org.xkonnex.repo.dsl.basedsl.version.SimpleScopeVersionResolver;
import org.xkonnex.repo.dsl.basedsl.version.VersionedOwnerScopeVersionResolver;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.LifecycleState;
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.FixedVersionRef;
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.LowerBoundRangeVersionRef;
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.MajorVersionRef;
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.MaxVersionRef;
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.MinVersionRef;
import org.xkonnex.repo.dsl.basedsl.sOABaseDsl.VersionRef;

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
