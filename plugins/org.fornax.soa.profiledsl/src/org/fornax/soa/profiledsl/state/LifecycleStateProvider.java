package org.fornax.soa.profiledsl.state;

import java.util.concurrent.ExecutionException;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
@Deprecated
public class LifecycleStateProvider implements ILifecycleStateProvider {
	
	@Inject
	private LifecycleStateCache stateCache;
	
	public LifecycleStateProvider() {
		stateCache = new LifecycleStateCache();
	}
	
	/* (non-Javadoc)
	 * @see org.fornax.soa.profiledsl.state.ILifecycleStateProvider#getAssetState(org.eclipse.xtext.resource.IEObjectDescription, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public LifecycleState getAssetState (IEObjectDescription ieDesc, ResourceSet resourceSet) {
		try {
			return stateCache.get(ieDesc, resourceSet);
		} catch (ExecutionException e) {
		}
		return null;
	}

}
