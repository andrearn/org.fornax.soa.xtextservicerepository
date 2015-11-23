package org.xkonnex.repo.dsl.profiledsl.scoping.versions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;

import com.google.inject.Singleton;

@Singleton
public class StateAttributeLifecycleStateResolver implements ILifecycleStateResolver {

	private final static String STATE_ATTR_NAME = "state";
	
	private ResourceSet resSet;

	public StateAttributeLifecycleStateResolver() {
	}
	
	@Deprecated
	public StateAttributeLifecycleStateResolver(ResourceSet resSet) {
		super();
		this.resSet = resSet;
	}

	@Deprecated
	public LifecycleState getLifecycleState(IEObjectDescription ieDesc) {
		return getLifecycleState(ieDesc, resSet);		
	}
	
	public LifecycleState getLifecycleState (IEObjectDescription ieDesc, ResourceSet rs) {
		EObject o = ieDesc.getEObjectOrProxy();
		if (rs == null) {
			if (o.eResource() != null) {
				rs = o.eResource().getResourceSet();
				if (o.eIsProxy()) {
					o = EcoreUtil2.resolve (o, resSet);
				}
			}
		} else {
			if (o.eIsProxy())
				o = EcoreUtil2.resolve(o, rs);
		}
		final EStructuralFeature stateFeature = o.eClass().getEStructuralFeature (STATE_ATTR_NAME);
		if (!o.eIsProxy()) {
			if (stateFeature != null) {
				Object stateObj = o.eGet(stateFeature, true);
				if (stateObj instanceof LifecycleState) {
					LifecycleState state = (LifecycleState) stateObj;
					if (state.eIsProxy ()) {
						state = (LifecycleState) EcoreUtil2.resolve (state, o.eResource().getResourceSet());
					}
					return state;
				}
			}
		}
		return null;
	}

	public LifecycleState getLifecycleState (EObject o) {
		final EStructuralFeature stateFeature = o.eClass()
				.getEStructuralFeature(STATE_ATTR_NAME);
		if (stateFeature != null) {
			Object stateObj = o.eGet (stateFeature, true);
			if (stateObj instanceof LifecycleState) {
				LifecycleState state = (LifecycleState) stateObj;
				if (state.eIsProxy ()) {
					state = (LifecycleState) EcoreUtil2.resolve (state, o.eResource().getResourceSet());
					
				}
				return state;
			}
		} else if (o.eContainer () != null) {
			return getLifecycleState (o.eContainer ());
		}
		return null;
	}


	public String getLifecycleStateName(EObject o) {
		LifecycleState lifecycleState = getLifecycleState (o);
		if (lifecycleState != null) {
			return lifecycleState.getName ();
		}
		return null;
	}

	public LifecycleState getLifecycleState(EObject o, Resource res) {
		final EStructuralFeature stateFeature = o.eClass().getEStructuralFeature (STATE_ATTR_NAME);
		if (stateFeature != null) {
			Object stateObj = o.eGet (stateFeature, true);
			if (stateObj instanceof LifecycleState) {
				LifecycleState state = (LifecycleState) stateObj;
				if (state.eIsProxy ()) {
					state = (LifecycleState) EcoreUtil2.resolve (state, res);
				}
				return state;
			}
		}
		return null;
	}

	public boolean definesState(EObject o) {
		final EStructuralFeature stateFeature = o.eClass().getEStructuralFeature (STATE_ATTR_NAME);
		return stateFeature != null;
	}

	public boolean definesState(IEObjectDescription ieDesc) {
		final EStructuralFeature stateFeature = ieDesc.getEClass().getEStructuralFeature (STATE_ATTR_NAME);
		return stateFeature != null;
	}

}
