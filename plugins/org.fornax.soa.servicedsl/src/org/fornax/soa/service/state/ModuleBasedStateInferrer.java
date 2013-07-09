package org.fornax.soa.service.state;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.resource.VersionedResourceDescriptionStrategy;
import org.fornax.soa.profiledsl.query.LifecycleQueries;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.ILifecycleStateResolver;
import org.fornax.soa.profiledsl.state.ILifecycleStateInferrer;
import org.fornax.soa.service.query.ServiceQueries;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.ServiceDslPackage;
import org.fornax.soa.serviceDsl.VersionedType;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class ModuleBasedStateInferrer implements ILifecycleStateInferrer {
	
	@Inject 
	private ServiceQueries serviceQueries;
	
	@Inject
	private ServiceBasedStateInferrer serviceBasedInferrer;
	
	@Inject 
	private LifecycleQueries lifecycleQueries;
	
	@Inject
	private ILifecycleStateResolver stateResolver;

	public LifecycleState inferState (IEObjectDescription ieDesc,
			final ResourceSet resourceSet) {
		if (stateResolver.definesState (ieDesc)) {
			EObject objectOrProxy = ieDesc.getEObjectOrProxy();
			if (objectOrProxy.eIsProxy()) {
				objectOrProxy = EcoreUtil2.resolve (objectOrProxy, resourceSet);
			}
			LifecycleState state = lifecycleQueries.getAssetLifecycleState(objectOrProxy);
			if (state != null) {
				return state;
			} else {
				if (objectOrProxy.eClass().getEPackage().getNsURI().equals (ServiceDslPackage.eNS_URI)) {
					if (objectOrProxy instanceof Service) {
						Service svc = (Service) objectOrProxy;
						final List<EObject> modules = serviceQueries.findAllProvidingModules(svc);
						List<LifecycleState> modStates = Lists.transform (modules, new Function<EObject, LifecycleState>() {
							
							public LifecycleState apply (EObject input) {
								return lifecycleQueries.getAssetLifecycleState (input);
							}
								
						});
						return lifecycleQueries.getHighestEnvironmentalLifecycleState(modStates);
					} else if (objectOrProxy instanceof VersionedType) {
						state = serviceBasedInferrer.inferState (ieDesc, resourceSet);
						return state;
					}
				}
			}
		}
		return null;
	}

}
