package org.fornax.soa.servicerepo.query;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.search.IPredicateSearch;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.search.predicate.VersionAndLifecycleStatePredicate;
import org.fornax.soa.servicerepo.query.predicates.CanonicalOrNotPredicate;
import org.fornax.soa.servicerepo.query.predicates.HasTagPredicate;

import com.google.common.base.Predicates;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.ibm.icu.text.CanonicalIterator;

public class FindAssetsWithStateQuery {
	
	@Inject Injector injector;
	
	@Inject IPredicateSearch search;

	@SuppressWarnings("unchecked")
	public Iterable<IEObjectDescription>  search(String pattern, String assetType,
			LifecycleState minState, LifecycleState maxState, 
			String minVersion, String maxVersion, 
			boolean inclCanonicalModel, boolean inclNonCanonicalModel, 
			List<String> tagNames,
			boolean allTags,
			boolean withTagsFromParent,
			ResourceSet rs) {
		VersionAndLifecycleStatePredicate statePredicate = new VersionAndLifecycleStatePredicate(minState, maxState, minVersion, maxVersion, rs);
		injector.injectMembers(statePredicate);
		CanonicalOrNotPredicate canonicalPredicate = new CanonicalOrNotPredicate(inclCanonicalModel, inclNonCanonicalModel, rs);
		injector.injectMembers(canonicalPredicate);
		HasTagPredicate tagsPredicate = new HasTagPredicate(tagNames, allTags, withTagsFromParent, rs);
		injector.injectMembers(tagsPredicate);
		
		if (assetType == null)
			assetType = "";
		Iterable<IEObjectDescription> result = search.search (pattern, assetType, Predicates.and(
				statePredicate, canonicalPredicate, tagsPredicate));
		return result;
	}

}
