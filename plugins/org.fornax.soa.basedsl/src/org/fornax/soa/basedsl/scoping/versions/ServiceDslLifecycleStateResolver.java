package org.fornax.soa.basedsl.scoping.versions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState;

public class ServiceDslLifecycleStateResolver implements LifecycleStateResolver {

	private final static String STATE_ATTR_NAME = "state";

	private ResourceSet resSet;

	public ServiceDslLifecycleStateResolver(ResourceSet resSet) {
		super();
		this.resSet = resSet;
	}

	public LifecycleState getLifecycleState(IEObjectDescription ieDesc) {
		EObject o = ieDesc.getEObjectOrProxy();
		if (o.eIsProxy()) {
			o = EcoreUtil.resolve(o, resSet);
		}
		final EStructuralFeature stateFeature = o.eClass()
				.getEStructuralFeature(STATE_ATTR_NAME);
		if (stateFeature != null) {
			Object stateObj = o.eGet(stateFeature, true);
			if (stateObj instanceof LifecycleState) {
				return (LifecycleState) stateObj;
			}
		}

		return null;
	}

	public LifecycleState getLifecycleState(EObject o) {
		final EStructuralFeature stateFeature = o.eClass()
				.getEStructuralFeature(STATE_ATTR_NAME);
		if (stateFeature != null && o.eIsSet(stateFeature)) {
			Object stateObj = o.eGet(stateFeature);
			if (stateObj instanceof LifecycleState) {
				return (LifecycleState) stateObj;
			}
		}
		return null;
	}

}
