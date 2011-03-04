package org.fornax.soa.basedsl.scoping.versions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState;

public interface LifecycleStateResolver {

	public LifecycleState getLifecycleState (IEObjectDescription ieDesc);

	public LifecycleState getLifecycleState (EObject o);

}
