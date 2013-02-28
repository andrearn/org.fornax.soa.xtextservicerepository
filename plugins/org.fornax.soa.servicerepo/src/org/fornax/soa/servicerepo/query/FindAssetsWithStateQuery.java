package org.fornax.soa.servicerepo.query;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.search.IPredicateSearch;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.search.predicate.StrictLifecycleStatePredicate;
import org.fornax.soa.servicerepo.query.predicates.CanonicalOrNotPredicate;

import com.google.common.base.Predicates;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.ibm.icu.text.CanonicalIterator;

public class FindAssetsWithStateQuery {
	
	@Inject Injector injector;
	
	@Inject IPredicateSearch search;

	public Iterable<IEObjectDescription>  search(String pattern, String assetType,
			LifecycleState minState, LifecycleState maxState, String minVersion, String maxVersion, boolean inclCanonicalModel, boolean inclNonCanonicalModel, ResourceSet rs) {
		StrictLifecycleStatePredicate statePredicate = new StrictLifecycleStatePredicate(minState, maxState, minVersion, maxVersion, rs);
		injector.injectMembers(statePredicate);
		CanonicalOrNotPredicate canonicalPredicate = new CanonicalOrNotPredicate(inclCanonicalModel, inclNonCanonicalModel, rs);
		injector.injectMembers(canonicalPredicate);
		if (assetType == null)
			assetType = "";
		Iterable<IEObjectDescription> result = search.search (pattern, assetType, Predicates.and(statePredicate, Predicates.and (statePredicate, canonicalPredicate)));
		return result;
	}

}
