package org.fornax.soa.util;

import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.bindingDsl.BindingProtocol;
import org.fornax.soa.bindingDsl.DomainBinding;
import org.fornax.soa.bindingDsl.OperationBinding;
import org.fornax.soa.bindingDsl.ServiceBinding;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.serviceDsl.SubNamespace;

public class BindingDslHelper {

	public static Environment getEnvironment (BindingProtocol prot) {
		EObject o = prot.eContainer();
		if (o instanceof DomainBinding)
			return ((DomainBinding)o).getEnvironment();
		if (o instanceof ServiceBinding)
			return ((ServiceBinding)o).getEnvironment();
		if (o instanceof OperationBinding)
			return ((ServiceBinding)o.eContainer()).getEnvironment();
		return null;
	}
	
	public static SubNamespace getSubNamespace (BindingProtocol prot) {
		EObject o = prot.eContainer();
		if (o instanceof DomainBinding)
			return ((DomainBinding)o).getSubNamespace();
		if (o instanceof ServiceBinding)
			return (SubNamespace) ((ServiceBinding)o).getService().getService().eContainer();
		if (o instanceof OperationBinding)
			return (SubNamespace) ((ServiceBinding)o.eContainer()).getService().getService().eContainer();
		return null;
	}

}
