package org.fornax.soa.profiledsl.scoping.versions;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.sOABaseDsl.FixedVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.LowerBoundRangeVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MajorVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MaxVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MinVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.basedsl.scoping.versions.AbstractPredicateVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.BaseDslVersionResolver;
import org.fornax.soa.basedsl.scoping.versions.EContainerVersionResolver;
import org.fornax.soa.basedsl.scoping.versions.FixedVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.LatestMajorVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.LatestMaxExclVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.LatestMinInclMaxExclRangeVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.LatestMinInclVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.NullVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.VersionFilter;
import org.fornax.soa.basedsl.scoping.versions.VersionResolver;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class DefaultVersionFilterProvider implements IVersionFilterProvider<IEObjectDescription> {
	
	@Inject Injector injector;

	public VersionFilter<IEObjectDescription> createVersionFilter(VersionRef v,
			LifecycleState minState) {
		AbstractPredicateVersionFilter<IEObjectDescription> filter = new NullVersionFilter<IEObjectDescription>();
		if (v != null) {
			VersionResolver verResolver = new EContainerVersionResolver (v.eResource().getResourceSet());
			LifecycleStateResolver stateResolver = new StateAttributeLifecycleStateResolver (v.eResource().getResourceSet());
			if (v instanceof MajorVersionRef) {
				RelaxedLatestMajorVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedLatestMajorVersionForOwnerStateFilter<IEObjectDescription> (verResolver, new Integer(((MajorVersionRef)v).getMajorVersion()).toString(), stateResolver, minState);
				injector.injectMembers (stateFilter);
				return stateFilter;
			}
			if (v instanceof MaxVersionRef) {
				RelaxedMaxVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedMaxVersionForOwnerStateFilter<IEObjectDescription> (verResolver, ((MaxVersionRef)v).getMaxVersion(), stateResolver, minState);
				injector.injectMembers (stateFilter);
				return stateFilter;
			}
			if (v instanceof MinVersionRef) {
				RelaxedLatestMinVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedLatestMinVersionForOwnerStateFilter<IEObjectDescription> (verResolver, ((MinVersionRef)v).getMinVersion(), stateResolver, minState);
				injector.injectMembers (stateFilter);
				return stateFilter;
			}
			if (v instanceof LowerBoundRangeVersionRef) {
				RelaxedLatestMinMaxVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedLatestMinMaxVersionForOwnerStateFilter<IEObjectDescription> (verResolver, ((LowerBoundRangeVersionRef)v).getMinVersion(), ((LowerBoundRangeVersionRef)v).getMaxVersion(), stateResolver, minState);
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
			VersionResolver verResolver = new BaseDslVersionResolver (v.eResource().getResourceSet());
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

}
