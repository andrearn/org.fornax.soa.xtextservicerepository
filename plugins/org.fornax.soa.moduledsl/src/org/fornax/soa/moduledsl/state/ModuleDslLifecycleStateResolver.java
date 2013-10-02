package org.fornax.soa.moduledsl.state;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.resource.IEObjectDescriptionBuilder;
import org.fornax.soa.profiledsl.query.LifecycleQueries;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.ILifecycleStateResolver;
import org.fornax.soa.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import org.fornax.soa.profiledsl.state.ILifecycleStateInferrer;
import org.fornax.soa.profiledsl.state.LifecycleStateCache;
import org.fornax.soa.service.state.ServiceDslStateInferrer;
import org.fornax.soa.serviceDsl.Service;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ModuleDslLifecycleStateResolver implements ILifecycleStateResolver {

	private final static String STATE_ATTR_NAME = "state";
	
	@Inject
	private LifecycleStateCache stateCache;
	
	@Inject
	private ILifecycleStateInferrer stateInferrer;
	
	@Inject
	private ServiceDslStateInferrer serviceDslStateInferrer;
	
	@Inject
	private StateAttributeLifecycleStateResolver stateAttrStateResolver;
	
	@Inject
	private IEObjectDescriptionBuilder descBuilder;
	
	@Inject
	private LifecycleQueries lifeCycleQuery;

	@Deprecated
	public LifecycleState getLifecycleState(IEObjectDescription ieDesc) {
		// TODO Auto-generated method stub
		return stateAttrStateResolver.getLifecycleState(ieDesc);
	}

	public LifecycleState getLifecycleState(IEObjectDescription ieDesc,
			ResourceSet resourceSet) {
		if (definesState(ieDesc)) {
			LifecycleState lifecycleState = stateAttrStateResolver.getLifecycleState(ieDesc, resourceSet);
			if (lifecycleState == null) {
				lifecycleState = inferState(ieDesc, resourceSet);
			}
			return lifecycleState;
		}
		return null;
	}

	public LifecycleState getLifecycleState(EObject o) {
		if (definesState(o)) {
			LifecycleState lifecycleState = stateAttrStateResolver.getLifecycleState(descBuilder.buildDescription(o), o.eResource().getResourceSet());
			if (lifecycleState == null) {
				lifecycleState = inferState(descBuilder.buildDescription(o), o.eResource().getResourceSet());
			}
			return lifecycleState;
		}
		return lifeCycleQuery.getInitialState(null, o.eResource().getResourceSet());
	}

	public LifecycleState getLifecycleState(EObject o, Resource res) {
		// TODO Auto-generated method stub
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
	
	private LifecycleState inferState (IEObjectDescription ieDesc, ResourceSet resourceSet) {
		EObject object = ieDesc.getEObjectOrProxy();
		if (object instanceof Service) {
			return serviceDslStateInferrer.inferState(ieDesc, resourceSet);
		} else {
			return stateInferrer.inferState(ieDesc, resourceSet);
		}
	}

}
