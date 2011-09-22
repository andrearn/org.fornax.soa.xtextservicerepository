package org.fornax.soa.basedsl.scoping.versions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.resource.VersionedResourceDescriptionStrategy;
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState;
import org.fornax.soa.basedsl.sOABaseDsl.SOABaseDslFactory;
import org.fornax.soa.basedsl.sOABaseDsl.SOABaseDslPackage;

public class ServiceDslLifecycleStateResolver implements LifecycleStateResolver {

	private final static String STATE_ATTR_NAME = "state";
	
	public final static ServiceDslLifecycleStateResolver INSTANCE = new ServiceDslLifecycleStateResolver();

	private ResourceSet resSet;

	public ServiceDslLifecycleStateResolver() {
	}
	
	public ServiceDslLifecycleStateResolver(ResourceSet resSet) {
		super();
		this.resSet = resSet;
	}

	public LifecycleState getLifecycleState(IEObjectDescription ieDesc) {
		EObject o = ieDesc.getEObjectOrProxy();
		ResourceSet rs = resSet;
		if (rs == null) {
			if (o.eResource() != null) {
				rs = o.eResource().getResourceSet();
				if (o.eIsProxy()) {
					o = EcoreUtil.resolve (o, resSet);
				}
			}
		}
		final EStructuralFeature stateFeature = o.eClass().getEStructuralFeature(STATE_ATTR_NAME);
		if (!o.eIsProxy()) {
			if (stateFeature != null) {
				Object stateObj = o.eGet(stateFeature, true);
				if (stateObj instanceof LifecycleState) {
					return (LifecycleState) stateObj;
				}
			}
		} else {
			String stateLiteral = ieDesc.getUserData (VersionedResourceDescriptionStrategy.STATE_KEY);
			if (stateLiteral != null)
				return LifecycleState.get(stateLiteral);
		}
		return null;
	}

	public LifecycleState getLifecycleState(EObject o) {
		final EStructuralFeature stateFeature = o.eClass()
				.getEStructuralFeature(STATE_ATTR_NAME);
		if (stateFeature != null) {
			Object stateObj = o.eGet (stateFeature, true);
			if (stateObj instanceof LifecycleState) {
				return (LifecycleState) stateObj;
			} else if (stateFeature != null) {
				return LifecycleState.PROPOSED;
			}
		}
		return null;
	}


	public String getLifecycleStateName(EObject o) {
		final EStructuralFeature stateFeature = o.eClass()
				.getEStructuralFeature(STATE_ATTR_NAME);
		if (stateFeature != null) {
			Object stateObj = o.eGet (stateFeature, true);
			if (stateObj instanceof LifecycleState) {
				return ((LifecycleState) stateObj).getLiteral();
			}
		}
		return null;
	}

}
