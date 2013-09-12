package org.fornax.soa.profiledsl.state;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.fornax.soa.basedsl.traversal.IModelVisitor;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * A visitor that collects all {@link LifecycleState}s from assets in the object graph
 * 
 * @author André Arnold
 *
 */
public class StateCollectorModelVisitor implements IModelVisitor<IEObjectDescription> {
	
	protected List<LifecycleState> states = Lists.newArrayList();
	protected ResourceSet resourceSet;
	protected StateAttributeLifecycleStateResolver stateAttrResolver;
	
	public StateCollectorModelVisitor(ResourceSet resourceSet, StateAttributeLifecycleStateResolver stateAttrResolver) {
		this.resourceSet = resourceSet;
		this.stateAttrResolver = stateAttrResolver;
	}

	public boolean visit(IEObjectDescription modelElement, IEObjectDescription referrerElement) {
		if (stateAttrResolver.definesState(modelElement) &&
				isEligibleElement (modelElement, referrerElement)) {
			LifecycleState lifecycleState = stateAttrResolver.getLifecycleState(modelElement, resourceSet);
			if (lifecycleState != null) {
				states.add(lifecycleState);
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	protected boolean isEligibleElement(IEObjectDescription modelElement, IEObjectDescription predecessorElement) {
		return true;
	}

	public List<LifecycleState> getStates() {
		return states;
	}

	public void setStates(List<LifecycleState> states) {
		this.states = states;
	}
	
	

}
