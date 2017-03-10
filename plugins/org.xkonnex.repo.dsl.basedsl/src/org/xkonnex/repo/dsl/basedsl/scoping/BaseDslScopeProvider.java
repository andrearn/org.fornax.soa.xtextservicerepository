/*
 * generated by Xtext
 */
package org.xkonnex.repo.dsl.basedsl.scoping;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.xkonnex.repo.dsl.basedsl.baseDsl.AssetRef;
import org.xkonnex.repo.dsl.basedsl.baseDsl.BaseDslPackage;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Reference;
import org.xkonnex.repo.dsl.basedsl.baseDsl.VersionRef;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.AbstractPredicateVersionFilter;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.NullVersionFilter;
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.VersionedImportedNamespaceAwareScopeProvider;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class BaseDslScopeProvider extends ComponentAwareVersionedScopeProvider {
	
	@Override
	protected AbstractPredicateVersionFilter<IEObjectDescription> getVersionFilterFromContext (
			EObject ctx, final EReference reference) {
		if (reference == BaseDslPackage.Literals.ASSET_REF__ASSET
				&& ctx instanceof AssetRef) {
			final VersionRef v = ((AssetRef) ctx).getVersionRef();
			return createVersionFilter (v);
		}
		if (reference == BaseDslPackage.Literals.REFERENCE__REFERABLE
				&& ctx instanceof Reference) {
			final VersionRef v = ((Reference) ctx).getVersionRef();
			return createVersionFilter (v);
		}
		return new NullVersionFilter<IEObjectDescription>();
	}
	
	@Override
	protected List<ImportNormalizer> getImplicitImports(boolean ignoreCase) {
		List<ImportNormalizer> result = newArrayList();
		result.add(createImportedNamespaceResolver("org.xkonnex.repo.dsl.basedsl.ext.token.*", ignoreCase));
		result.add(createImportedNamespaceResolver("org.xkonnex.repo.dsl.basedsl.ext.crypto.*", ignoreCase));
		return result;
	}

}
