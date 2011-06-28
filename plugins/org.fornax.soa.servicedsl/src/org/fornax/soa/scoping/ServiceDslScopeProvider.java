/*
 * generated by Xtext
 */
package org.fornax.soa.scoping;

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
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState;
import org.fornax.soa.basedsl.sOABaseDsl.LowerBoundRangeVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MajorVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MaxVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MinVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.basedsl.scoping.VersionedImportedNamespaceAwareScopeProvider;
import org.fornax.soa.basedsl.scoping.versions.AbstractPredicateVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.BaseDslVersionResolver;
import org.fornax.soa.basedsl.scoping.versions.EContainerVersionResolver;
import org.fornax.soa.basedsl.scoping.versions.LatestMajorVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.LatestMaxExclVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.LatestMinInclMaxExclRangeVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.LatestMinInclVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.LifecycleStateResolver;
import org.fornax.soa.basedsl.scoping.versions.RelaxedLatestMajorVersionForOwnerStateFilter;
import org.fornax.soa.basedsl.scoping.versions.ServiceDslLifecycleStateResolver;
import org.fornax.soa.basedsl.scoping.versions.VersionFilter;
import org.fornax.soa.basedsl.scoping.versions.VersionResolver;
import org.fornax.soa.serviceDsl.BusinessObjectRef;
import org.fornax.soa.serviceDsl.CapabilityRef;
import org.fornax.soa.serviceDsl.EnumTypeRef;
import org.fornax.soa.serviceDsl.EventRef;
import org.fornax.soa.serviceDsl.ExceptionRef;
import org.fornax.soa.serviceDsl.GlobalEventRef;
import org.fornax.soa.serviceDsl.MessageHeaderRef;
import org.fornax.soa.serviceDsl.OperationEventRef;
import org.fornax.soa.serviceDsl.OperationRef;
import org.fornax.soa.serviceDsl.ParameterRef;
import org.fornax.soa.serviceDsl.ServiceDslPackage;
import org.fornax.soa.serviceDsl.ServiceRef;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.serviceDsl.VersionedTypeRef;
import org.fornax.soa.util.DslElementAccessor;

import com.google.inject.Inject;
/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class ServiceDslScopeProvider extends VersionedImportedNamespaceAwareScopeProvider {
	private static final Logger logger = Logger.getLogger(ServiceDslScopeProvider.class);

	private VersionFilter filter;

	@Inject
	private IGlobalScopeProvider globalScopeProvider;

	public void setGlobalScopeProvider(IGlobalScopeProvider globalScopeProvider) {
		this.globalScopeProvider = globalScopeProvider;
	}

	@Inject 
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;

	private IResourceDescription.Manager getManager (Resource res) {
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
		if (reference==ServiceDslPackage.Literals.VERSIONED_TYPE_REF__TYPE && ctx instanceof VersionedTypeRef) {
			final VersionRef v = ((VersionedTypeRef) ctx).getVersionRef();
			return createVersionFilter (v, DslElementAccessor.INSTANCE.getVersionedOwner(ctx));
		} else if (reference==ServiceDslPackage.Literals.BUSINESS_OBJECT_REF__TYPE && ctx instanceof BusinessObjectRef) {
			final VersionRef v = ((BusinessObjectRef) ctx).getVersionRef();
			return createVersionFilter (v, DslElementAccessor.INSTANCE.getVersionedOwner(ctx));
		//FIXME verify this ref
		} else if (reference==ServiceDslPackage.Literals.BUSINESS_OBJECT__SUPER_BUSINESS_OBJECT && ctx instanceof BusinessObjectRef) {
			final VersionRef v = ((BusinessObjectRef) ctx).getVersionRef();
			return createVersionFilter (v, DslElementAccessor.INSTANCE.getVersionedOwner(ctx));
		} else if (reference == ServiceDslPackage.Literals.ENUM_TYPE_REF__TYPE && ctx instanceof EnumTypeRef) {
			final VersionRef v = ((EnumTypeRef) ctx).getVersionRef();
			return createVersionFilter (v, DslElementAccessor.INSTANCE.getVersionedOwner(ctx));
		} else if (reference == ServiceDslPackage.Literals.SERVICE_REF__SERVICE && ctx instanceof ServiceRef) {
			final VersionRef v = ((ServiceRef) ctx).getVersionRef();
			return createVersionFilter (v, DslElementAccessor.INSTANCE.getVersionedOwner(ctx));
		} else if (reference == ServiceDslPackage.Literals.EXCEPTION_REF__EXCEPTION && ctx instanceof ExceptionRef) {
			final VersionRef v = ((ExceptionRef) ctx).getVersion();
			return createVersionFilter (v, DslElementAccessor.INSTANCE.getVersionedOwner(ctx));
		} else if (reference == ServiceDslPackage.Literals.GLOBAL_EVENT_REF__EVENT && ctx instanceof GlobalEventRef) {
			final VersionRef v = ((EventRef) ctx).getVersionRef();
			return createVersionFilter(v, DslElementAccessor.INSTANCE.getVersionedOwner(ctx));
		} else if (reference == ServiceDslPackage.Literals.OPERATION_EVENT_REF__EVENT && ctx instanceof OperationEventRef) {
			final VersionRef v = ((EventRef) ctx).getVersionRef();
			return createVersionFilter(v, DslElementAccessor.INSTANCE.getVersionedOwner(ctx));
		} else if (reference == ServiceDslPackage.Literals.OPERATION_REF__OPERATION && ctx instanceof OperationRef) {
			final VersionRef v = ((OperationRef) ctx).getVersionRef();
			return createEContainerVersionFilter(v, DslElementAccessor.INSTANCE.getVersionedOwner(ctx));
		} else if (reference == ServiceDslPackage.Literals.PARAMETER_REF__PROPERTY && ctx instanceof ParameterRef) {
			TypeRef typeRef = ((ParameterRef) ctx).getParam().getType();
			AbstractPredicateVersionFilter<IEObjectDescription> f = AbstractPredicateVersionFilter.NULL_VERSION_FILTER;
			if (typeRef instanceof BusinessObjectRef) 
				f = createEContainerVersionFilter (((BusinessObjectRef)typeRef).getVersionRef(), DslElementAccessor.INSTANCE.getVersionedOwner(ctx));
			else if (typeRef instanceof EnumTypeRef)
				f = createEContainerVersionFilter (((EnumTypeRef)typeRef).getVersionRef(), DslElementAccessor.INSTANCE.getVersionedOwner(ctx));
			return f;
		} else if (reference == ServiceDslPackage.Literals.MESSAGE_HEADER_REF__HEADER && ctx instanceof MessageHeaderRef) {
			final VersionRef v = ((MessageHeaderRef) ctx).getVersionRef();
			return createStateLessVersionFilter (v, DslElementAccessor.INSTANCE.getVersionedOwner(ctx));
		} else if (reference==ServiceDslPackage.Literals.CAPABILITY_REF__VERSION_REF && ctx instanceof CapabilityRef) {
			final VersionRef v = ((CapabilityRef) ctx).getVersionRef();
			return createVersionFilter (v, DslElementAccessor.INSTANCE.getVersionedOwner(ctx));
		}

		return AbstractPredicateVersionFilter.NULL_VERSION_FILTER;
	}

	@Override
	protected AbstractPredicateVersionFilter<IEObjectDescription> createVersionFilter(final VersionRef v, EObject owner) {
		AbstractPredicateVersionFilter<IEObjectDescription> filter = AbstractPredicateVersionFilter.NULL_VERSION_FILTER;
		VersionResolver verResolver = new BaseDslVersionResolver (v.eResource().getResourceSet());
		LifecycleStateResolver stateResolver = new ServiceDslLifecycleStateResolver (v.eResource().getResourceSet());
		LifecycleState ownerState = stateResolver.getLifecycleState(owner);
		LifecycleState minDevState = StateConstraintConfigurer.getMinDevState(owner);
		LifecycleState minTestState = StateConstraintConfigurer.getMinTestState(owner);
		LifecycleState minProdState = StateConstraintConfigurer.getMinProdState(owner);
		if (v instanceof MajorVersionRef)
			return new RelaxedLatestMajorVersionForOwnerStateFilter<IEObjectDescription> (verResolver, new Integer(((MajorVersionRef)v).getMajorVersion()).toString(), stateResolver, ownerState, minDevState, minTestState, minProdState);
		if (v instanceof MaxVersionRef)
			return new LatestMaxExclVersionFilter<IEObjectDescription>(verResolver, ((MaxVersionRef)v).getMaxVersion());
		if (v instanceof MinVersionRef)
			return new LatestMinInclVersionFilter<IEObjectDescription>(verResolver, ((MinVersionRef)v).getMinVersion());
		if (v instanceof LowerBoundRangeVersionRef)
			return new LatestMinInclMaxExclRangeVersionFilter<IEObjectDescription>(verResolver, ((LowerBoundRangeVersionRef)v).getMinVersion(), ((LowerBoundRangeVersionRef)v).getMaxVersion());
		return filter;
	}
	
	private AbstractPredicateVersionFilter<IEObjectDescription> createStateLessVersionFilter(final VersionRef v, EObject owner) {
		AbstractPredicateVersionFilter<IEObjectDescription> filter = AbstractPredicateVersionFilter.NULL_VERSION_FILTER;
		VersionResolver verResolver = new BaseDslVersionResolver (v.eResource().getResourceSet());
		if (v instanceof MajorVersionRef)
			return new LatestMajorVersionFilter<IEObjectDescription> (verResolver, new Integer(((MajorVersionRef)v).getMajorVersion()).toString());
		if (v instanceof MaxVersionRef)
			return new LatestMaxExclVersionFilter<IEObjectDescription> (verResolver, ((MaxVersionRef)v).getMaxVersion());
		if (v instanceof MinVersionRef)
			return new LatestMinInclVersionFilter<IEObjectDescription> (verResolver, ((MinVersionRef)v).getMinVersion());
		if (v instanceof LowerBoundRangeVersionRef)
			return new LatestMinInclMaxExclRangeVersionFilter<IEObjectDescription> (verResolver, ((LowerBoundRangeVersionRef)v).getMinVersion(), ((LowerBoundRangeVersionRef)v).getMaxVersion());
		return filter;
	}

	private AbstractPredicateVersionFilter<IEObjectDescription> createEContainerVersionFilter(final VersionRef v, EObject owner) {
		AbstractPredicateVersionFilter<IEObjectDescription> filter = AbstractPredicateVersionFilter.NULL_VERSION_FILTER;
		VersionResolver verResolver = new EContainerVersionResolver (v.eResource().getResourceSet());
		LifecycleStateResolver stateResolver = new ServiceDslLifecycleStateResolver (v.eResource().getResourceSet());
		LifecycleState ownerState = stateResolver.getLifecycleState(owner);
		LifecycleState minDevState = StateConstraintConfigurer.getMinDevState(owner);
		LifecycleState minTestState = StateConstraintConfigurer.getMinTestState(owner);
		LifecycleState minProdState = StateConstraintConfigurer.getMinProdState(owner);
		if (v instanceof MajorVersionRef)
			return new RelaxedLatestMajorVersionForOwnerStateFilter<IEObjectDescription> (verResolver, new Integer(((MajorVersionRef)v).getMajorVersion()).toString(), stateResolver, ownerState, minDevState, minTestState, minProdState);
		if (v instanceof MaxVersionRef)
			return new LatestMaxExclVersionFilter<IEObjectDescription> (verResolver, ((MaxVersionRef)v).getMaxVersion());
		if (v instanceof MinVersionRef)
			return new LatestMinInclVersionFilter<IEObjectDescription> (verResolver, ((MinVersionRef)v).getMinVersion());
		if (v instanceof LowerBoundRangeVersionRef)
			return new LatestMinInclMaxExclRangeVersionFilter<IEObjectDescription> (verResolver, ((LowerBoundRangeVersionRef)v).getMinVersion(), ((LowerBoundRangeVersionRef)v).getMaxVersion());
		return filter;
	}


}
