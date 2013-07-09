package org.fornax.soa.profiledsl.state;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;

import com.google.inject.ImplementedBy;

@ImplementedBy (LifecycleStateProvider.class)
public interface ILifecycleStateProvider {

	public abstract LifecycleState getAssetState(IEObjectDescription ieDesc,
			ResourceSet resourceSet);

	public abstract void registerStateInferrer(ILifecycleStateInferrer inferrer);

}