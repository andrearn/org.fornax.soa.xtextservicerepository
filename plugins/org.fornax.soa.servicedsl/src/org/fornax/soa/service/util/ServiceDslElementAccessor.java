package org.fornax.soa.service.util;

import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.serviceDsl.Operation;

public class ServiceDslElementAccessor {
	
	public final static ServiceDslElementAccessor INSTANCE = new ServiceDslElementAccessor();
	
	
	public Operation getOwningOperation (EObject canditate) {
		if (canditate instanceof Operation) {
			return (Operation)canditate;
		} else if (canditate.eContainer() != null){
			return getOwningOperation (canditate.eContainer());
		} else {
			return null;
		}
	}
}
