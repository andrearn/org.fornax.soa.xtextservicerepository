package org.fornax.soa.service.state;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.traversal.IModelVisitor;
import org.fornax.soa.profiledsl.query.LifecycleQueries;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.state.DefaultStateInferrer;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class ServiceDslStateInferrer extends DefaultStateInferrer {

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
			return lifecycleQueries.getHighestEnvironmentalLifecycleState(states);
		}
		return null;
	}
}
