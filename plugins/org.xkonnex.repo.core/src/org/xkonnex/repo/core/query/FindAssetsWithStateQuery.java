package org.xkonnex.repo.core.query;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.core.query.predicates.CanonicalOrNotPredicate;
import org.xkonnex.repo.core.query.predicates.HasTagPredicate;
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;
import org.xkonnex.repo.dsl.profiledsl.search.predicate.VersionAndLifecycleStatePredicate;

import com.google.common.base.Predicates;
import com.google.inject.Inject;
import com.google.inject.Injector;

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
