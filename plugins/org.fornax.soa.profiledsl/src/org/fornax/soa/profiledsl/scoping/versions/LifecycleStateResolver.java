package org.fornax.soa.profiledsl.scoping.versions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;

public interface LifecycleStateResolver {

	public LifecycleState getLifecycleState (IEObjectDescription ieDesc);
	
	public LifecycleState getLifecycleState (IEObjectDescription ieDesc, ResourceSet rs);

	public LifecycleState getLifecycleState (EObject o);
	
	public LifecycleState getLifecycleState (EObject o, Resource res);

}
