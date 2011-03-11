package org.fornax.soa.scoping;

import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.fornax.soa.bindingDsl.DomainBinding;
import org.fornax.soa.bindingDsl.OperationBinding;
import org.fornax.soa.bindingDsl.ServiceBinding;
import org.fornax.soa.environmentDsl.Environment;

public class BindingQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
	
	public String qualifiedName (DomainBinding b) {
		String nsName = getQualifiedName(b.getSubNamespace());
		System.err.println("nsName " + nsName);
		String domBindName = nsName + "_" + getQualifiedName(b.getEnvironment());
		System.err.println("domBindName " + domBindName);
		return domBindName;
	}
	
	public String qualifiedName (ServiceBinding b) {
		String svcName = getQualifiedName(b.getService().getService());
		Environment env = null;
		if (b.getEnvironment() != null) {
			env = b.getEnvironment();
		} else if (b.eContainer() instanceof DomainBinding) {
			DomainBinding domBind = (DomainBinding) b.eContainer();
			env = domBind.getEnvironment();
		}
		return svcName + "_" + getQualifiedName(env);
	}
	
	public String qualifiedName (OperationBinding b) {
		String svcName = getQualifiedName(b.getOperation());
		Environment env = null;
		if (b.eContainer() instanceof ServiceBinding ) {
			ServiceBinding svcBind = (ServiceBinding) b.eContainer();
			if (svcBind.getEnvironment() != null) {
				env = svcBind.getEnvironment();
			} else if (b.eContainer().eContainer() instanceof DomainBinding) {
				DomainBinding domBind = (DomainBinding) b.eContainer().eContainer();
				env = domBind.getEnvironment();
			}
			
		}
		return svcName + "_" + getQualifiedName(env);
	}
	
}