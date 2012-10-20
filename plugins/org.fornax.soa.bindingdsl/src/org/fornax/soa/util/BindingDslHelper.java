package org.fornax.soa.util;

import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.bindingDsl.Binding;
import org.fornax.soa.bindingDsl.BindingProtocol;
import org.fornax.soa.bindingDsl.DomainBinding;
import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.bindingDsl.OperationBinding;
import org.fornax.soa.bindingDsl.ServiceBinding;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.serviceDsl.SubNamespace;

public class BindingDslHelper {

	public static Environment getEnvironment (BindingProtocol prot) {
		EObject o = prot.eContainer();
		if (o instanceof Binding)
			return getEnvironment((Binding)o);
		return null;
	}

	public static Environment getEnvironment (Binding bind) {
		if (bind instanceof DomainBinding)
			return ((DomainBinding)bind).getEnvironment();
		if (bind instanceof ServiceBinding)
			if (((ServiceBinding)bind).eContainer() instanceof DomainBinding)
				return ((DomainBinding)((ServiceBinding)bind).eContainer()).getEnvironment();
			else if (((ServiceBinding)bind).eContainer() instanceof ModuleBinding)
				return ((ModuleBinding)((ServiceBinding)bind).eContainer()).getEnvironment();
		if (bind instanceof ModuleBinding)
			return ((ModuleBinding)bind).getEnvironment();
		if (bind instanceof OperationBinding)
			if (((ServiceBinding)bind).eContainer() instanceof DomainBinding)
				return ((DomainBinding)((ServiceBinding)bind).eContainer().eContainer()).getEnvironment();
			else if (((ServiceBinding)bind).eContainer() instanceof ModuleBinding)
				return ((ModuleBinding)((ServiceBinding)bind).eContainer().eContainer()).getEnvironment();
		return null;
	}
	
	public static Binding getTopLevelBinding (EObject o) {
		if (o instanceof DomainBinding || o instanceof ModuleBinding) {
			return (Binding)o;
		} else if (o.eContainer() != null) {
			return getTopLevelBinding(o.eContainer());
		} else {
			return null;
		}
	}
	
	public static Environment getTargetEnvironment (EObject o) {
		Binding bind = getTopLevelBinding(o);
		if (bind instanceof ModuleBinding)
			return ((ModuleBinding) bind).getEnvironment();
		else if (bind instanceof DomainBinding)
			return ((DomainBinding) bind).getEnvironment();
		else
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
