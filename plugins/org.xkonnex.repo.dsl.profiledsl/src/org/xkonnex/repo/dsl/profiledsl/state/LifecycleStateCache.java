package org.xkonnex.repo.dsl.profiledsl.state;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutionException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class LifecycleStateCache implements Adapter {
	
	@Inject
	private ILifecycleStateInferrer stateInferrer;
	
	private Notifier notifier;
	
	Map<IEObjectDescription, LifecycleState> cache = new WeakHashMap<IEObjectDescription, LifecycleState>();

	public LifecycleState get(IEObjectDescription key, ResourceSet resourceSet)
			throws ExecutionException {
		LifecycleState lifecycleState = cache.get(key);
		if (lifecycleState != null) {
			return lifecycleState;
		} else {
			LifecycleState inferredState = stateInferrer.inferState(key, resourceSet);
			if (inferredState != null) {
				cache.put(key, inferredState);
				return inferredState;
			}
			return null;
		}
	}
	
	
	public void invalidateEntry (IEObjectDescription key) {
		cache.remove(key);
	}
	
	public void clear () {
		cache.clear();
	}


	public void notifyChanged(Notification notification) {
		clear();
	}


	public Notifier getTarget() {
		// TODO Auto-generated method stub
		return notifier;
	}


	public void setTarget(Notifier newTarget) {
		this.notifier = notifier;
	}


	public boolean isAdapterForType(Object type) {
		return true;
	}

}
