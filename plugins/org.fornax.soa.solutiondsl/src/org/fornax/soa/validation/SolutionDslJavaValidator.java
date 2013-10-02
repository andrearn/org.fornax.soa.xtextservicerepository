package org.fornax.soa.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.fornax.soa.basedsl.search.IEObjectLookup;
import org.fornax.soa.basedsl.validation.NameAndVersionAreUniqueValidator;
import org.fornax.soa.basedsl.validation.PluggableChecks;
import org.fornax.soa.profiledsl.query.LifecycleQueries;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateComparator;
import org.fornax.soa.profiledsl.scoping.versions.ILifecycleStateResolver;
import org.fornax.soa.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import org.fornax.soa.serviceDsl.InternalNamespace;
import org.fornax.soa.serviceDsl.Visibility;
import org.fornax.soa.solutionDsl.Module;
import org.fornax.soa.solutionDsl.ServiceRef;
import org.fornax.soa.solutionDsl.Solution;
import org.fornax.soa.solutionDsl.SolutionDslPackage;

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
