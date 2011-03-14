package org.fornax.soa.validation;

import org.eclipse.xtext.validation.Check;
import org.fornax.soa.serviceDsl.InternalNamespace;
import org.fornax.soa.serviceDsl.ServiceDslPackage;
import org.fornax.soa.serviceDsl.ServiceRef;
import org.fornax.soa.serviceDsl.VISIBILITY;
import org.fornax.soa.solutionDsl.Module;
import org.fornax.soa.solutionDsl.Solution;
 

public class SolutionDslJavaValidator extends AbstractSolutionDslJavaValidator {

//	@Check
//	public void checkTypeNameStartsWithCapital(Type type) {
//		if (!Character.isUpperCase(type.getName().charAt(0))) {
//			warning("Name should start with a capital", MyDslPackage.TYPE__NAME);
//		}
//	}
	
	@Check
	public void checkDontCallPrivateServices (ServiceRef svc) {
		if (svc.eContainer()  instanceof Module || svc.eContainer() instanceof Solution) {
			if (svc.getService() != null && svc.getService().getVisibility() == VISIBILITY.PRIVATE) {
				error ("Solutions may not call private services!", ServiceDslPackage.SERVICE_REF__SERVICE);
			}
		}
	}
	
	@Check
	public void checkDontCallInternalServices (ServiceRef svc) {
		if (svc.eContainer()  instanceof Module || svc.eContainer() instanceof Solution) {
			if (svc.getService() != null && svc.getService().eContainer() instanceof InternalNamespace) {
				error ("Solutions may not call internal services!", ServiceDslPackage.SERVICE_REF__SERVICE);
			}
		}
	}

}