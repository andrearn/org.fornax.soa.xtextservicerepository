package org.fornax.soa.moduledsl.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.moduledsl.moduleDsl.ModuleDslPackage;
import org.fornax.soa.moduledsl.moduleDsl.ServiceRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateComparator;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateResolver;
import org.fornax.soa.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import com.google.inject.Inject;
 

public class ModuleDslJavaValidator extends AbstractModuleDslJavaValidator {

	@Inject LifecycleStateComparator stateComparator;
	
	
	@Check (CheckType.NORMAL)
	public void checkNotRefsLowerStateService(ServiceRef svcRef) {
		EObject owner = svcRef.eContainer ();
		LifecycleStateResolver stateRes = new StateAttributeLifecycleStateResolver (owner.eResource().getResourceSet());
		LifecycleState ownerState = stateRes.getLifecycleState (owner);
		if (owner != null && owner instanceof Module) {
			if (stateComparator.compare (ownerState, svcRef.getService().getState()) > 0)
				warning ("A service with a lower lifecycle-state is being referenced. You should review the referenced service and adjust it's lifecycle-state.", ModuleDslPackage.Literals.SERVICE_REF__SERVICE);
		}
	}
}
