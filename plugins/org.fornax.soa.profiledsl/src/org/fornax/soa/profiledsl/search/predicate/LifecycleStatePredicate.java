package org.fornax.soa.profiledsl.search.predicate;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateComparator;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateResolver;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

public class LifecycleStatePredicate implements Predicate<IEObjectDescription> {
	
	@Inject LifecycleStateComparator stateComparator;
	@Inject LifecycleStateResolver stateResolver;
	
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
		if (minState == null && maxState == null)
			return true;
		EObject eObjectOrProxy = input.getEObjectOrProxy();
		if (eObjectOrProxy.eIsProxy()) {
			eObjectOrProxy = EcoreUtil2.resolve (eObjectOrProxy, resourceSet);
		}
		LifecycleState lifecycleState = stateResolver.getLifecycleState(eObjectOrProxy);
		if (minState != null && maxState != null) {
			int minStateCmp = stateComparator.compare(lifecycleState, minState);
			int maxStateCmp = stateComparator.compare(lifecycleState, minState);
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
			int maxStateCmp = stateComparator.compare(lifecycleState, minState);
			if (includingMaxState && maxStateCmp >= 0)
				return true;
			else if (!includingMaxState && maxStateCmp > 0)
				return true;
		}
		return false;
	}

}
