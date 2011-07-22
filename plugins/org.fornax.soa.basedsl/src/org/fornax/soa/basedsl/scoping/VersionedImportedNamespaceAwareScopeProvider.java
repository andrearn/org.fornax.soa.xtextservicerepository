package org.fornax.soa.basedsl.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.fornax.soa.basedsl.sOABaseDsl.FixedVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.LowerBoundRangeVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MajorVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MaxVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MinVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.basedsl.scoping.versions.AbstractPredicateVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.BaseDslVersionResolver;
import org.fornax.soa.basedsl.scoping.versions.FixedVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.LatestMajorVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.LatestMaxExclVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.LatestMinInclMaxExclRangeVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.LatestMinInclVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.NullVersionFilter;
import org.fornax.soa.basedsl.scoping.versions.VersionFilteringScope;
import org.fornax.soa.basedsl.scoping.versions.VersionResolver;
import org.fornax.soa.basedsl.scoping.versions.VersioningContainerBasedScope;

public abstract class VersionedImportedNamespaceAwareScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {
	
	protected IScope getLocalElementsScope(IScope parent, final EObject context,
			final EReference reference) {
		IScope result = super.getLocalElementsScope(parent, context, reference);
		AbstractPredicateVersionFilter<IEObjectDescription> versionFilter = getVersionFilterFromContext (context, reference);
		return new VersionFilteringScope (result, versionFilter, isIgnoreCase());
	}
	
	protected IScope getResourceScope(final IScope parent, final EObject context, final EReference reference) {
		// TODO: SZ - context may not be a proxy, may it?
		if (context.eResource() == null)
			return parent;
		ISelectable allDescriptions = getAllDescriptions (context.eResource());
		return VersioningContainerBasedScope.createScope (parent, allDescriptions, getVersionFilterFromContext (context, reference), reference.getEReferenceType(), isIgnoreCase(reference));
	}
	
	protected abstract AbstractPredicateVersionFilter<IEObjectDescription> getVersionFilterFromContext (final EObject context, final EReference reference);
	
	protected boolean isIgnoreCase () {
		return false;
	}

	protected AbstractPredicateVersionFilter<IEObjectDescription> createVersionFilter(final VersionRef v, EObject owner) {
		AbstractPredicateVersionFilter<IEObjectDescription> filter = AbstractPredicateVersionFilter.NULL_VERSION_FILTER;
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
				return new FixedVersionFilter<IEObjectDescription> (verResolver, ((FixedVersionRef)v).getFixedVersion());
		}
		return filter;
	}
	
}
