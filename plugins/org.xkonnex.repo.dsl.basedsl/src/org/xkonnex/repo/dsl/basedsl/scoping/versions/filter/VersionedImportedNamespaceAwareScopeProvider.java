package org.xkonnex.repo.dsl.basedsl.scoping.versions.filter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.xkonnex.repo.dsl.basedsl.baseDsl.FixedVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.LowerBoundRangeVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.MajorVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.MaxVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.MinVersionRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.VersionRef;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.VersionFilteringScope;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.VersioningContainerBasedScope;
import org.xkonnex.repo.dsl.basedsl.version.IScopeVersionResolver;
import org.xkonnex.repo.dsl.basedsl.version.SimpleScopeVersionResolver;

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

	protected AbstractPredicateVersionFilter<IEObjectDescription> createVersionFilter(final VersionRef v) {
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
				return new FixedVersionFilter<IEObjectDescription> (verResolver, ((FixedVersionRef)v).getFixedVersion());
		}
		return filter;
	}
	
	protected AbstractPredicateVersionFilter<IEObjectDescription> createVersionFilter(final VersionRef v, EObject owner) {
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
				return new FixedVersionFilter<IEObjectDescription> (verResolver, ((FixedVersionRef)v).getFixedVersion());
		}
		return filter;
	}
	
}
