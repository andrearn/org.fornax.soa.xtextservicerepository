package org.xkonnex.repo.dsl.profiledsl.state;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.basedsl.traversal.IModelVisitor;
import org.xkonnex.repo.dsl.basedsl.traversal.ReferrerGraphTraversor;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;
import org.xkonnex.repo.dsl.profiledsl.query.LifecycleQueries;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Default implementation of n {@link ILifecycleStateInferrer}. The inferrer looks for the closest 
 * stateful assets in each path of the tree of referrers to the given stateful model element.
 * The inferrer is based on a depth first search algorithm that traverses each path in the graph of referrers until
 * an asset is encountered, that declares it's state. The states of these assets are being collected by a 
 * {@link StateCollectorModelVisitor}. When graph traversal has terminated, the highest state wrt. supported environments
 * of the collected asset states is returned. 
 * 
 * @author André Arnold
 */
public class DefaultStateInferrer implements ILifecycleStateInferrer {
	
	@Inject
	protected LifecycleQueries lifecycleQueries;
	
	@Inject
	protected Injector injector;
	
	@Inject
	protected StateAttributeLifecycleStateResolver stateAttrStateResolver;


	public LifecycleState inferState(IEObjectDescription ieDesc,
			ResourceSet resourceSet) {
		if (stateAttrStateResolver.definesState(ieDesc)) {
			ReferrerGraphTraversor traversor = injector.getInstance(ReferrerGraphTraversor.class);
			StateCollectorModelVisitor stateCollector = new StateCollectorModelVisitor(resourceSet, stateAttrStateResolver);
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
