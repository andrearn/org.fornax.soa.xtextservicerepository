package org.fornax.soa.profiledsl.state;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutionException;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;

public class LifecycleStateCache {
	
	private Set<ILifecycleStateInferrer> stateInferrers = new HashSet<ILifecycleStateInferrer>();
	
	Map<IEObjectDescription, LifecycleState> cache = new WeakHashMap<IEObjectDescription, LifecycleState>();

	public LifecycleState get(IEObjectDescription key, ResourceSet resourceSet)
			throws ExecutionException {
		LifecycleState lifecycleState = cache.get(key);
		if (lifecycleState != null) {
			return lifecycleState;
		} else {
			for (ILifecycleStateInferrer inferrer : stateInferrers) {
				LifecycleState inferredState = inferrer.inferState(key, resourceSet);
				if (inferredState != null) {
					cache.put(key, inferredState);
					return inferredState;
				}
			}
			return null;
		}
	}
	
	void registerLifycycleStateInferrer(ILifecycleStateInferrer inferrer) {
		stateInferrers.add(inferrer);
	}
	
	public void invalidateEntry (IEObjectDescription key) {
		cache.remove(key);
	}
	
	public void clear () {
		cache.clear();
	}

}
