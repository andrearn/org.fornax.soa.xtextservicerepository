/*
 * generated by Xtext
 */
package org.xkonnex.repo.dsl.solutiondsl.scoping;

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
import org.xkonnex.repo.dsl.basedsl.baseDsl.LowerBoundRangeVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.MajorVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.MaxVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.MinVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.VersionRef;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.AbstractPredicateVersionFilter;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.LatestMaxExclVersionFilter;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.LatestMinInclMaxExclRangeVersionFilter;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.LatestMinInclVersionFilter;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.NullVersionFilter;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.VersionedImportedNamespaceAwareScopeProvider;
import org.xkonnex.repo.dsl.basedsl.version.IScopeVersionResolver;
import org.xkonnex.repo.dsl.basedsl.version.SimpleScopeVersionResolver;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.LifecycleState;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.ILifecycleStateResolver;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.RelaxedLatestMajorVersionForOwnerStateFilter;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceDslPackage;
import org.xkonnex.repo.dsl.solutiondsl.solutionDsl.CapabilityRef;
import org.xkonnex.repo.dsl.solutiondsl.solutionDsl.EventRef;
import org.xkonnex.repo.dsl.solutiondsl.solutionDsl.ServiceRef;
import org.xkonnex.repo.dsl.solutiondsl.solutionDsl.SolutionDslPackage;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class SolutionDslScopeProvider extends VersionedImportedNamespaceAwareScopeProvider {
	private static final Logger logger = Logger.getLogger(SolutionDslScopeProvider.class);

	
	@Inject Injector injector;

	@Inject
	private IGlobalScopeProvider globalScopeProvider;
	@Inject
	private ILifecycleStateResolver stateResolver;

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
	protected AbstractPredicateVersionFilter<IEObjectDescription> getVersionFilterFromContext(
			EObject ctx, EReference reference) {
		if (reference == SolutionDslPackage.Literals.SERVICE_REF__SERVICE && ctx instanceof ServiceRef) {
			final VersionRef v = ((ServiceRef) ctx).getVersionRef();
			return createVersionFilter(v, ctx);
		}
		if (reference == SolutionDslPackage.Literals.SERVICE_REF__CALLED_OPERATIONS && ctx instanceof ServiceRef) {
			final VersionRef v = ((ServiceRef) ctx).getVersionRef();
			return createVersionFilter(v, ctx);
		}
		if (reference == ServiceDslPackage.Literals.EVENT_REF__EVENT && ctx instanceof EventRef) {
			final VersionRef v = ((EventRef) ctx).getVersionRef();
			return createVersionFilter(v, ctx);
		}
		if (reference == SolutionDslPackage.Literals.CAPABILITY_REF__CAPABILITY && ctx instanceof CapabilityRef) {
			final VersionRef v = ((CapabilityRef) ctx).getVersionRef();
			return createVersionFilter(v, ctx);
		}
		return new NullVersionFilter<IEObjectDescription>();
	}

	@Override
	protected AbstractPredicateVersionFilter<IEObjectDescription> createVersionFilter(final VersionRef v, EObject owner) {
		AbstractPredicateVersionFilter<IEObjectDescription> filter = new NullVersionFilter<IEObjectDescription>();
		if (v != null) {
			IScopeVersionResolver verResolver = new SimpleScopeVersionResolver (v.eResource().getResourceSet());
			LifecycleState ownerState = stateResolver.getLifecycleState(owner);
			if (v instanceof MajorVersionRef) {
				RelaxedLatestMajorVersionForOwnerStateFilter<IEObjectDescription> stateFilter = new RelaxedLatestMajorVersionForOwnerStateFilter<IEObjectDescription> (verResolver, 
						new Integer(((MajorVersionRef)v).getMajorVersion()).toString(), 
						stateResolver, ownerState, v.eResource().getResourceSet());
				injector.injectMembers (stateFilter);
				return stateFilter;
			}
			if (v instanceof MaxVersionRef)
				return new LatestMaxExclVersionFilter<IEObjectDescription>(verResolver, ((MaxVersionRef)v).getMaxVersion());
			if (v instanceof MinVersionRef)
				return new LatestMinInclVersionFilter<IEObjectDescription>(verResolver, ((MinVersionRef)v).getMinVersion());
			if (v instanceof LowerBoundRangeVersionRef)
				return new LatestMinInclMaxExclRangeVersionFilter<IEObjectDescription>(verResolver, ((LowerBoundRangeVersionRef)v).getMinVersion(), ((LowerBoundRangeVersionRef)v).getMaxVersion());
		}
		return filter;
	}

}
