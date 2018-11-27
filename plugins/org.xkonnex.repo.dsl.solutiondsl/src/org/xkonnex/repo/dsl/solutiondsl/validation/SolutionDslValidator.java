package org.xkonnex.repo.dsl.solutiondsl.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup;
import org.xkonnex.repo.dsl.basedsl.validation.NameAndVersionAreUniqueValidator;
import org.xkonnex.repo.dsl.basedsl.validation.PluggableChecks;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;
import org.xkonnex.repo.dsl.profiledsl.query.LifecycleQueries;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.ILifecycleStateResolver;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.LifecycleStateComparator;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.InternalNamespace;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Visibility;
import org.xkonnex.repo.dsl.solutiondsl.solutionDsl.InterfaceRef;
import org.xkonnex.repo.dsl.solutiondsl.solutionDsl.SolutionDslPackage;

import com.google.inject.Inject;
 
@PluggableChecks (validators = {
		NameAndVersionAreUniqueValidator.class
})
public class SolutionDslValidator extends AbstractSolutionDslValidator {
	
	@Inject LifecycleStateComparator stateComparator;
	@Inject ILifecycleStateResolver stateResolver;
	@Inject LifecycleQueries stateQueries;
	@Inject IEObjectLookup objLookup;

	@Check
	public void checkDontCallPrivateServices (InterfaceRef svc) {
		if (svc.getInterface() instanceof Service) {
			Service service = (Service)svc.getInterface();
			if (service != null && service.getVisibility() == Visibility.PRIVATE) {
				warning ("Solutions should not call private services!", SolutionDslPackage.Literals.INTERFACE_REF__INTERFACE);
			}
		} 
	}
	
	@Check
	public void checkDontCallPrivateResources (InterfaceRef svc) {
		if (svc.getInterface() instanceof Resource) {
			Resource service = (Resource)svc.getInterface();
			if (service != null && service.getVisibility() == Visibility.PRIVATE) {
				warning ("Solutions should not call private resources!", SolutionDslPackage.Literals.INTERFACE_REF__INTERFACE);
			}
		} 
	}
	
	@Check
	public void checkDontCallInternalServices (InterfaceRef svc) {
		if (svc.getInterface() instanceof Service) {
			Service service = (Service)svc.getInterface();
			if (service != null && service.eContainer() instanceof InternalNamespace) {
				warning ("Solutions should not call internal services!", SolutionDslPackage.Literals.INTERFACE_REF__INTERFACE);
			}
		}
	}
	
	@Check
	public void checkDontCallInternalResources (InterfaceRef svc) {
		if (svc.getInterface() instanceof Resource) {
			Resource service = (Resource)svc.getInterface();
			if (service != null && service.eContainer() instanceof InternalNamespace) {
				warning ("Solutions should not call internal resources!", SolutionDslPackage.Literals.INTERFACE_REF__INTERFACE);
			}
		}
	}

	@Check (CheckType.NORMAL)
	public void checkNotRefsLowerStateService(ServiceRef svcRef) {
		EObject owner = objLookup.getStatefulOwner(svcRef);
		LifecycleState ownerState = stateResolver.getLifecycleState(owner);
		if (owner != null && stateResolver.definesState (owner)) {
			if (stateComparator.compare (ownerState, svcRef.getService().getState()) > 0 && !(ownerState != null && ownerState.isIsEnd()))
				warning ("An interface with a lower lifecycle-state is being used. You should review the used service and adjust it's lifecycle-state.", SolutionDslPackage.Literals.INTERFACE_REF__INTERFACE);
		}
	}

}
