package org.xkonnex.repo.dsl.solutiondsl.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup;
import org.xkonnex.repo.dsl.basedsl.validation.NameAndVersionAreUniqueValidator;
import org.xkonnex.repo.dsl.basedsl.validation.PluggableChecks;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.ILifecycleStateResolver;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.LifecycleStateComparator;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;
import org.xkonnex.repo.dsl.profiledsl.query.LifecycleQueries;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.InternalNamespace;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Visibility;
import org.xkonnex.repo.dsl.solutiondsl.solutionDsl.Module;
import org.xkonnex.repo.dsl.solutiondsl.solutionDsl.ServiceRef;
import org.xkonnex.repo.dsl.solutiondsl.solutionDsl.Solution;
import org.xkonnex.repo.dsl.solutiondsl.solutionDsl.SolutionDslPackage;
import org.xkonnex.repo.dsl.solutiondsl.validation.AbstractSolutionDslJavaValidator;

import com.google.inject.Inject;
 
@PluggableChecks (validators = {
		NameAndVersionAreUniqueValidator.class
})
public class SolutionDslJavaValidator extends AbstractSolutionDslJavaValidator {
	
	@Inject LifecycleStateComparator stateComparator;
	@Inject ILifecycleStateResolver stateResolver;
	@Inject LifecycleQueries stateQueries;
	@Inject IEObjectLookup objLookup;

	@Check
	public void checkDontCallPrivateServices (ServiceRef svc) {
		if (svc.getService() != null && svc.getService().getVisibility() == Visibility.PRIVATE) {
			warning ("Solutions should not call private services!", SolutionDslPackage.Literals.SERVICE_REF__SERVICE);
		}
	}
	
	@Check
	public void checkDontCallInternalServices (ServiceRef svc) {
		if (svc.getService() != null && svc.getService().eContainer() instanceof InternalNamespace) {
			warning ("Solutions should not call internal services!", SolutionDslPackage.Literals.SERVICE_REF__SERVICE);
		}
	}

	@Check (CheckType.NORMAL)
	public void checkNotRefsLowerStateService(ServiceRef svcRef) {
		EObject owner = objLookup.getStatefulOwner(svcRef);
		LifecycleState ownerState = stateResolver.getLifecycleState(owner);
		if (owner != null && stateResolver.definesState (owner)) {
			if (stateComparator.compare (ownerState, svcRef.getService().getState()) > 0 && !(ownerState != null && ownerState.isIsEnd()))
				warning ("A service with a lower lifecycle-state is being used. You should review the used service and adjust it's lifecycle-state.", SolutionDslPackage.Literals.SERVICE_REF__SERVICE);
		}
	}

}
