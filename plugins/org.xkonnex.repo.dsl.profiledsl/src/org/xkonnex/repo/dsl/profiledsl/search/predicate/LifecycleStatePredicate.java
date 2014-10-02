package org.xkonnex.repo.dsl.profiledsl.search.predicate;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.LifecycleState;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.ILifecycleStateResolver;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.LifecycleStateComparator;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

public class LifecycleStatePredicate implements Predicate<IEObjectDescription> {
	
	@Inject LifecycleStateComparator stateComparator;
	@Inject ILifecycleStateResolver stateResolver;
	@Inject IEObjectLookup objLookup;
	
	private LifecycleState minState;
	private LifecycleState maxState;
	
	private boolean includingMinState;
	private boolean includingMaxState;
	
	private ResourceSet resourceSet;
	
	
	public LifecycleStatePredicate(LifecycleState minState, LifecycleState maxState, ResourceSet rs) {
		this.minState = minState;
		this.maxState = maxState;
		this.includingMinState = true;
		this.includingMaxState = true;
		this.resourceSet = rs;
	}

	public LifecycleStatePredicate(LifecycleState minState, boolean includingMinState, LifecycleState maxState, boolean includingMaxState, ResourceSet rs) {
		this.minState = minState;
		this.maxState = maxState;
		this.includingMinState = includingMinState;
		this.includingMaxState = includingMaxState;
		this.resourceSet = rs;
	}

	public boolean apply(IEObjectDescription input) {
		return stateMatches(input);
	}


	private boolean stateMatches(IEObjectDescription input) {
		EObject o = input.getEObjectOrProxy();
		if (o.eIsProxy()) {
			o = EcoreUtil2.resolve(o, resourceSet);
		}
		EObject statefulObj = objLookup.getStatefulOwner(o);
		if (! stateResolver.definesState(statefulObj)) {
			return true;
		}
		if (minState == null && maxState == null)
			return true;
		LifecycleState lifecycleState = stateResolver.getLifecycleState(statefulObj);
		if (minState != null && maxState != null) {
			int minStateCmp = stateComparator.compare(lifecycleState, minState);
			int maxStateCmp = stateComparator.compare(lifecycleState, maxState);
			if (includingMaxState && includingMinState) {
				if (minStateCmp >= 0 && maxStateCmp <=0)
					return true;
			} else if (includingMinState && !includingMaxState) {
				if (minStateCmp >=0 && maxStateCmp < 0)
					return true;
			} else if (!includingMinState && includingMaxState) {
				if (minStateCmp > 0 && maxStateCmp <= 0)
					return true;
			} else {
				if (minStateCmp > 0 && maxStateCmp < 0)
					return true;
			}
		} else if (minState != null && maxState == null) {
			int minStateCmp = stateComparator.compare(lifecycleState, minState);
			if (includingMinState && minStateCmp >= 0)
				return true;
			else if (!includingMinState && minStateCmp > 0)
				return true;
		} else {
			int maxStateCmp = stateComparator.compare(lifecycleState, maxState);
			if (includingMaxState && maxStateCmp <= 0)
				return true;
			else if (!includingMaxState && maxStateCmp < 0)
				return true;
		}
		return false;
	}

}
