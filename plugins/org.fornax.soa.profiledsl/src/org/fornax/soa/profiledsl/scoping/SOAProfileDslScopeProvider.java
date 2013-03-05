/*
 * generated by Xtext
 */
package org.fornax.soa.profiledsl.scoping;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.fornax.soa.basedsl.sOABaseDsl.FixedVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.LowerBoundRangeVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MajorVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MaxVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MinVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.basedsl.scoping.versions.filter.AbstractPredicateVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.filter.FixedVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.filter.LatestMaxExclVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.filter.LatestMinInclMaxExclRangeVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.filter.LatestMinInclVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.filter.VersionedImportedNamespaceAwareScopeProvider;
import org.fornax.soa.basedsl.version.IScopeVersionResolver;
import org.fornax.soa.basedsl.version.SimpleScopeVersionResolver;
import org.fornax.soa.profiledsl.sOAProfileDsl.ClassRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.EnumRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfileDslPackage;
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedTypeRef;
import org.fornax.soa.profiledsl.scoping.versions.ILifecycleStateResolver;
import org.fornax.soa.profiledsl.scoping.versions.RelaxedLatestMajorVersionForOwnerStateFilter;
import org.fornax.soa.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import org.fornax.soa.profiledsl.util.ProfileDslElementAccessor;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class SOAProfileDslScopeProvider extends VersionedImportedNamespaceAwareScopeProvider {
	private static final Logger logger = Logger.getLogger(SOAProfileDslScopeProvider.class);


	@Inject
	private IGlobalScopeProvider globalScopeProvider;

	@Inject Injector injector;

	public void setGlobalScopeProvider(IGlobalScopeProvider globalScopeProvider) {
		this.globalScopeProvider = globalScopeProvider;
	}

	@Inject 
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;

	private IResourceDescription.Manager getManager(Resource res) {
		IResourceServiceProvider resourceServiceProvider = resourceServiceProviderRegistry
				.getResourceServiceProvider(res.getURI());
		return resourceServiceProvider.getResourceDescriptionManager();
	}

	@Inject
	private IResourceScopeCache cache = IResourceScopeCache.NullImpl.INSTANCE;

	public void setCache(IResourceScopeCache cache) {
		this.cache = cache;
	}

	@Inject
	private IQualifiedNameProvider nameProvider;

	public void setNameProvider(IQualifiedNameProvider nameProvider) {
		this.nameProvider = nameProvider;
	}

	public IQualifiedNameProvider getNameProvider() {
		return nameProvider;
	}

	@Override
	protected AbstractPredicateVersionFilter<IEObjectDescription> getVersionFilterFromContext (
			EObject ctx, final EReference reference) {
		if (reference==SOAProfileDslPackage.Literals.VERSIONED_TYPE_REF__TYPE && ctx instanceof VersionedTypeRef) {
			final VersionRef v = ((VersionedTypeRef)ctx).getVersionRef();
			return createVersionFilter (v, ProfileDslElementAccessor.INSTANCE.getVersionedOwner(ctx));
		
		} else if (reference==SOAProfileDslPackage.Literals.CLASS_REF__TYPE && ctx instanceof ClassRef) {
			final VersionRef v = ((ClassRef)ctx).getVersionRef();
			return createVersionFilter (v, ProfileDslElementAccessor.INSTANCE.getVersionedOwner(ctx));
		
		} else if (reference==SOAProfileDslPackage.Literals.CLASS__SUPER_CLASS && ctx instanceof ClassRef) {
			final VersionRef v = ((ClassRef)ctx).getVersionRef();
			return createVersionFilter (v, ProfileDslElementAccessor.INSTANCE.getVersionedOwner(ctx));
			
		} else if (reference == SOAProfileDslPackage.Literals.ENUM_REF__TYPE && ctx instanceof EnumRef) {
			final VersionRef v = ((EnumRef)ctx).getVersionRef();
			return createVersionFilter (v, ProfileDslElementAccessor.INSTANCE.getVersionedOwner(ctx));
		}
		return AbstractPredicateVersionFilter.NULL_VERSION_FILTER;
	}
	
	@Override
	protected AbstractPredicateVersionFilter<IEObjectDescription> createVersionFilter(final VersionRef v, EObject owner) {
		AbstractPredicateVersionFilter<IEObjectDescription> filter = AbstractPredicateVersionFilter.NULL_VERSION_FILTER;
		if (v != null) {
			IScopeVersionResolver verResolver = new SimpleScopeVersionResolver (v.eResource().getResourceSet());
			ILifecycleStateResolver stateResolver = new StateAttributeLifecycleStateResolver (v.eResource().getResourceSet());
			LifecycleState ownerState = stateResolver.getLifecycleState(owner);
			if (v instanceof MajorVersionRef) {
				RelaxedLatestMajorVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedLatestMajorVersionForOwnerStateFilter<IEObjectDescription> (verResolver, new Integer(((MajorVersionRef)v).getMajorVersion()).toString(), stateResolver, ownerState);
				injector.injectMembers (stateFilter);
				return stateFilter;
			}
			if (v instanceof MaxVersionRef)
				return new LatestMaxExclVersionFilter<IEObjectDescription> (verResolver, ((MaxVersionRef)v).getMaxVersion());
			if (v instanceof MinVersionRef)
				return new LatestMinInclVersionFilter<IEObjectDescription> (verResolver, ((MinVersionRef)v).getMinVersion());
			if (v instanceof LowerBoundRangeVersionRef)
				return new LatestMinInclMaxExclRangeVersionFilter<IEObjectDescription> (verResolver, ((LowerBoundRangeVersionRef)v).getMinVersion(), ((LowerBoundRangeVersionRef)v).getMaxVersion());
			if (v instanceof FixedVersionRef)
				return new FixedVersionFilter<IEObjectDescription> (verResolver, ((FixedVersionRef)v).getFixedVersion());
		}
		return filter;
	}


}
