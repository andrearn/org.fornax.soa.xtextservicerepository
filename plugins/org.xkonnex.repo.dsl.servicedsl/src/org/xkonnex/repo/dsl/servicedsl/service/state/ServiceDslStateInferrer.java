package org.xkonnex.repo.dsl.servicedsl.service.state;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup;
import org.xkonnex.repo.dsl.basedsl.traversal.IModelVisitor;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.LifecycleState;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.SOAProfile;
import org.xkonnex.repo.dsl.profiledsl.state.DefaultStateInferrer;
import org.xkonnex.repo.dsl.profiledsl.query.LifecycleQueries;
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class ServiceDslStateInferrer extends DefaultStateInferrer {
	
	@Inject
	private IEObjectLookup objLookup;
	
	@Inject
	private NamespaceQuery namespaceQuery;
	
	public LifecycleState inferState(IEObjectDescription ieDesc,
			ResourceSet resourceSet) {
		if (stateAttrStateResolver.definesState(ieDesc)) {
			ServiceDslStateInferenceGraphTraversor traversor = injector.getInstance(ServiceDslStateInferenceGraphTraversor.class);
			ServiceDslStateCollectorVisitor stateCollector = new ServiceDslStateCollectorVisitor(resourceSet, stateAttrStateResolver);
			injector.injectMembers(stateCollector);
			List<IModelVisitor<IEObjectDescription>> visitors = new ArrayList<IModelVisitor<IEObjectDescription>>();
			visitors.add(stateCollector);
			traversor.traverse(ieDesc, null, visitors, resourceSet);
			List<LifecycleState> states = stateCollector.getStates();
			if (!states.isEmpty())
				return lifecycleQueries.getHighestEnvironmentalLifecycleState(states);
			else {
				EObject obj = ieDesc.getEObjectOrProxy();
				if (obj.eIsProxy()) {
					obj = EcoreUtil2.resolve(obj, resourceSet);
				}
				SubNamespace subNamespace = objLookup.getOwnerByType(obj, SubNamespace.class);
				SOAProfile applicableProfile = namespaceQuery.getApplicableProfile(subNamespace, null);
				return lifecycleQueries.getInitialState(applicableProfile, resourceSet);
			}
		}
		return null;
	}
}
