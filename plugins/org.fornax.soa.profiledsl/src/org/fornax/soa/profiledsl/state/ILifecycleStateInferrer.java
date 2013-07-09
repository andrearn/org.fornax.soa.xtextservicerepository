package org.fornax.soa.profiledsl.state;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;

public interface ILifecycleStateInferrer {
	
	public LifecycleState inferState (IEObjectDescription ieDesc, ResourceSet resourceSet);

}
