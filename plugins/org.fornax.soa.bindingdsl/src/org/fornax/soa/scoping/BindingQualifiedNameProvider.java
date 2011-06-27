package org.fornax.soa.scoping;

import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.fornax.soa.bindingDsl.DomainBinding;
import org.fornax.soa.bindingDsl.OperationBinding;
import org.fornax.soa.bindingDsl.ServiceBinding;
import org.fornax.soa.environmentDsl.Environment;

public class BindingQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
	
//	public QualifiedName qualifiedName (DomainBinding b) {
//		QualifiedName nsName = getFullyQualifiedName (b.getSubNamespace());
//		System.err.println("nsName " + nsName);
//		String domBindName = nsName + "_" + getFullyQualifiedName(b.getEnvironment());
//		System.err.println("domBindName " + domBindName);
//		return domBindName;
//	}
//	
//	public QualifiedName qualifiedName (ServiceBinding b) {
//		QualifiedName svcName = getFullyQualifiedName (b.getService().getService());
//		Environment env = null;
//		if (b.getEnvironment() != null) {
//			env = b.getEnvironment();
//		} else if (b.eContainer() instanceof DomainBinding) {
//			DomainBinding domBind = (DomainBinding) b.eContainer();
//			env = domBind.getEnvironment();
//		}
//		return svcName + "_" + getFullyQualifiedName(env);
//	}
//	
//	public QualifiedName qualifiedName (OperationBinding b) {
//		QualifiedName svcName = getFullyQualifiedName (b.getOperation());
//		Environment env = null;
//		if (b.eContainer() instanceof ServiceBinding ) {
//			ServiceBinding svcBind = (ServiceBinding) b.eContainer();
//			if (svcBind.getEnvironment() != null) {
//				env = svcBind.getEnvironment();
//			} else if (b.eContainer().eContainer() instanceof DomainBinding) {
//				DomainBinding domBind = (DomainBinding) b.eContainer().eContainer();
//				env = domBind.getEnvironment();
//			}
//			
//		}
//		return svcName + "_" + getFullyQualifiedName(env);
//	}
	
}