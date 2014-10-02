package org.xkonnex.repo.dsl.profiledsl.state;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.LifecycleState;

import com.google.inject.ImplementedBy;

@ImplementedBy (DefaultStateInferrer.class)
public interface ILifecycleStateInferrer {
	
	/**
	 * Calculates the inferred {@link LifecycleState} of the asset represented by the 
	 * {@code assetObjectDescription}
	 * 
	 * @param assetObjectDescription 
	 * @param resourceSet required to materialize the EObject from the assetObjectDescription
	 * @return
	 */
	public LifecycleState inferState (IEObjectDescription assetObjectDescription, ResourceSet resourceSet);

}
