package org.fornax.soa.profiledsl.search;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.search.IPredicateSearch;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.search.predicate.LifecycleStatePredicate;
import org.fornax.soa.profiledsl.search.predicate.StrictLifecycleStatePredicate;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class FindAssetsWithStateQuery {
	
	@Inject Injector injector;
	
	@Inject IPredicateSearch search;

	public Iterable<IEObjectDescription>  search(String pattern, String assetType,
			LifecycleState minState, LifecycleState maxState, ResourceSet rs) {
		StrictLifecycleStatePredicate predicate = new StrictLifecycleStatePredicate(minState, maxState, rs);
		injector.injectMembers(predicate);
		if (assetType == null)
			assetType = "";
		Iterable<IEObjectDescription> result = search.search (pattern, assetType, predicate);
		return result;
	}

}
