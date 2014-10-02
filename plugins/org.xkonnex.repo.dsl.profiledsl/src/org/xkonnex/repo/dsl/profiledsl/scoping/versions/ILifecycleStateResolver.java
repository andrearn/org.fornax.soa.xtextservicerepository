package org.xkonnex.repo.dsl.profiledsl.scoping.versions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Lifecycle;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.LifecycleState;

/**
 * Provides the lifecycle of a stateful asset. If not explicitly set on asset, implementor may
 * try to derive the state by means of state inference.
 * 
 * @author aarnold
 *
 */
public interface ILifecycleStateResolver {
	
	@Deprecated
	public LifecycleState getLifecycleState (IEObjectDescription ieDesc);
	
	public LifecycleState getLifecycleState (IEObjectDescription ieDesc, ResourceSet rs);

	public LifecycleState getLifecycleState (EObject o);
	
	public LifecycleState getLifecycleState (EObject o, Resource res);
	
	public boolean definesState (EObject o);
	
	public boolean definesState (IEObjectDescription ieDesc);

}
