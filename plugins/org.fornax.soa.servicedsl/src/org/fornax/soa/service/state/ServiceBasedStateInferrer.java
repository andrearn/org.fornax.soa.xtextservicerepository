package org.fornax.soa.service.state;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.resource.VersionedResourceDescriptionStrategy;
import org.fornax.soa.basedsl.search.IPredicateSearch;
import org.fornax.soa.profiledsl.query.LifecycleQueries;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.ILifecycleStateResolver;
import org.fornax.soa.profiledsl.state.ILifecycleStateInferrer;
import org.fornax.soa.profiledsl.state.ILifecycleStateProvider;
import org.fornax.soa.service.query.ServiceQueries;
import org.fornax.soa.service.query.type.DataObjectQueries;
import org.fornax.soa.service.query.type.ReferencedTypesFinder;
import org.fornax.soa.service.query.type.TypeQueries;
import org.fornax.soa.serviceDsl.DataObject;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.ServiceDslPackage;
import org.fornax.soa.serviceDsl.VersionedType;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

public class ServiceBasedStateInferrer implements ILifecycleStateInferrer {
	
	
	@Inject 
	private TypeQueries typeQueries;
	
	@Inject
	private ILifecycleStateProvider stateProvider;
	@Inject 
	private LifecycleQueries lifecycleQueries;
	
	@Inject
	private ILifecycleStateResolver stateResolver;

	public LifecycleState inferState (IEObjectDescription ieDesc,
			ResourceSet resourceSet) {
		if (stateResolver.definesState(ieDesc)) {
			EObject objectOrProxy = ieDesc.getEObjectOrProxy();
			if (objectOrProxy.eIsProxy()) {
				objectOrProxy = EcoreUtil2.resolve (objectOrProxy, resourceSet);
			}
			if (objectOrProxy.eClass().getEPackage().getNsURI().equals(ServiceDslPackage.eNS_URI)) {
				if (objectOrProxy instanceof Service) {
					return stateProvider.getAssetState(ieDesc, resourceSet);
				} else if (objectOrProxy instanceof VersionedType) {
					VersionedType type = (VersionedType) objectOrProxy;
					List<Service> services = new ArrayList<Service>(typeQueries.findUsingServices(type));
					List<LifecycleState> svcStates = Lists.transform(services, new Function<EObject, LifecycleState>() {

						public LifecycleState apply(EObject input) {
							return lifecycleQueries.getAssetLifecycleState(input);
						}
						
					});
					return lifecycleQueries.getHighestEnvironmentalLifecycleState(svcStates);
				}
			}
		}
		return null;
	}

}
