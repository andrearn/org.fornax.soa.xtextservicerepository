package org.fornax.soa.validation;

import org.eclipse.xtext.validation.Check;
import org.fornax.soa.bindingDsl.Binding;
import org.fornax.soa.bindingDsl.BindingDslPackage;
import org.fornax.soa.bindingDsl.DomainBinding;
import org.fornax.soa.bindingDsl.EJB;
import org.fornax.soa.bindingDsl.HTTP;
import org.fornax.soa.bindingDsl.JMS;
import org.fornax.soa.bindingDsl.OperationBinding;
import org.fornax.soa.bindingDsl.REST;
import org.fornax.soa.bindingDsl.SAP;
import org.fornax.soa.bindingDsl.SOAP;
import org.fornax.soa.bindingDsl.ServiceBinding;
import org.fornax.soa.serviceDsl.VISIBILITY;
 

public class BindingDslJavaValidator extends AbstractBindingDslJavaValidator {

//	@Check
//	public void checkGreetingStartsWithCapital(Greeting greeting) {
//		if (!Character.isUpperCase(greeting.getName().charAt(0))) {
//			warning("Name should start with a capital", MyDslPackage.GREETING__NAME);
//		}
//	}
	@Check
	public void checkOnlyPrivateServiceHasProvidedWSDL (SOAP soap) {
		if (soap.getProvidedWsdlUrl() != null) {
			if (soap.eContainer() instanceof DomainBinding) {
				error ("SOAP may not define a provided-WSDL-Url for a domain level binding", BindingDslPackage.SOAP__PROVIDED_WSDL_URL);
			} else if (soap.eContainer() instanceof OperationBinding) {
				error ("SOAP may not define a provided-WSDL-Url for a operation level binding", BindingDslPackage.SOAP__PROVIDED_WSDL_URL);
			} else if (soap.eContainer() instanceof ServiceBinding && ((ServiceBinding) soap.eContainer()).getService().getService().getVisibility() != VISIBILITY.PRIVATE) {
				error ("SOAP may not define a provided-WSDL-Url for a service level binding to a non-private service", BindingDslPackage.SOAP__PROVIDED_WSDL_URL);
			}
		}
	}
	
	@Check
	public void checkPublisherServerInBoundEnvironment (SOAP prot) {
		if (prot.eContainer() instanceof Binding) {
			Binding b = (Binding) prot.eContainer();
			if (! b.getEnvironment().getServers().contains(prot.getPublisher().getPubServer()))
					warning ("The referenced publishing Server is not part of the environment declared in the binding. Hence, you are crossing environment boundaries! THIS WILL INCURR SECURITY RISKS!", BindingDslPackage.SOAP__PUBLISHER);
		} 
	}
	@Check
	public void checkProviderServerInBoundEnvironment (SOAP prot) {
		if (prot.eContainer() instanceof Binding) {
			Binding b = (Binding) prot.eContainer();
			if (prot.getProvider() != null && ! b.getEnvironment().getServers().contains(prot.getProvider().getProvServer()))
					warning ("The referenced provider Server is not part of the environment declared in the binding. Hence, you are crossing environment boundaries! THIS WILL INCURR SECURITY RISKS!", BindingDslPackage.SOAP__PUBLISHER);
		} 
	}
	@Check
	public void checkPublisherServerInBoundEnvironment (EJB prot) {
		if (prot.eContainer() instanceof Binding) {
			Binding b = (Binding) prot.eContainer();
			if (! b.getEnvironment().getServers().contains(prot.getPublisher().getPubServer()))
					warning ("The referenced publishing Server is not part of the environment declared in the binding. Hence, you are crossing environment boundaries! THIS WILL INCURR SECURITY RISKS!", BindingDslPackage.SOAP__PUBLISHER);
		} 
	}
	@Check
	public void checkProviderServerInBoundEnvironment (EJB prot) {
		if (prot.eContainer() instanceof Binding) {
			Binding b = (Binding) prot.eContainer();
			if (prot.getProvider() != null && ! b.getEnvironment().getServers().contains(prot.getProvider().getProvServer()))
					warning ("The referenced provider Server is not part of the environment declared in the binding. Hence, you are crossing environment boundaries! THIS WILL INCURR SECURITY RISKS!", BindingDslPackage.SOAP__PUBLISHER);
		} 
	}
	@Check
	public void checkPublisherServerInBoundEnvironment (JMS prot) {
		if (prot.eContainer() instanceof Binding) {
			Binding b = (Binding) prot.eContainer();
			if (! b.getEnvironment().getServers().contains(prot.getPublisher().getPubServer()))
					warning ("The referenced publishing Server is not part of the environment declared in the binding. Hence, you are crossing environment boundaries! THIS WILL INCURR SECURITY RISKS!", BindingDslPackage.SOAP__PUBLISHER);
		} 
	}
	@Check
	public void checkProviderServerInBoundEnvironment (JMS prot) {
		if (prot.eContainer() instanceof Binding) {
			Binding b = (Binding) prot.eContainer();
			if (prot.getProvider() != null && ! b.getEnvironment().getServers().contains(prot.getProvider().getProvServer()))
					warning ("The referenced provider Server is not part of the environment declared in the binding. Hence, you are crossing environment boundaries! THIS WILL INCURR SECURITY RISKS!", BindingDslPackage.SOAP__PUBLISHER);
		} 
	}
	@Check
	public void checkPublisherServerInBoundEnvironment (HTTP prot) {
		if (prot.eContainer() instanceof Binding) {
			Binding b = (Binding) prot.eContainer();
			if (! b.getEnvironment().getServers().contains(prot.getPublisher().getPubServer()))
					warning ("The referenced publishing Server is not part of the environment declared in the binding. Hence, you are crossing environment boundaries! THIS WILL INCURR SECURITY RISKS!", BindingDslPackage.SOAP__PUBLISHER);
		} 
	}
	@Check
	public void checkProviderServerInBoundEnvironment (HTTP prot) {
		if (prot.eContainer() instanceof Binding) {
			Binding b = (Binding) prot.eContainer();
			if (prot.getProvider() != null && ! b.getEnvironment().getServers().contains(prot.getProvider().getProvServer()))
					warning ("The referenced provider Server is not part of the environment declared in the binding. Hence, you are crossing environment boundaries! THIS WILL INCURR SECURITY RISKS!", BindingDslPackage.SOAP__PUBLISHER);
		} 
	}
	@Check
	public void checkPublisherServerInBoundEnvironment (REST prot) {
		if (prot.eContainer() instanceof Binding) {
			Binding b = (Binding) prot.eContainer();
			if (! b.getEnvironment().getServers().contains(prot.getPublisher().getPubServer()))
					warning ("The referenced publishing Server is not part of the environment declared in the binding. Hence, you are crossing environment boundaries! THIS WILL INCURR SECURITY RISKS!", BindingDslPackage.SOAP__PUBLISHER);
		} 
	}
	@Check
	public void checkProviderServerInBoundEnvironment (REST prot) {
		if (prot.eContainer() instanceof Binding) {
			Binding b = (Binding) prot.eContainer();
			if (prot.getProvider() != null && ! b.getEnvironment().getServers().contains(prot.getProvider().getProvServer()))
					warning ("The referenced provider Server is not part of the environment declared in the binding. Hence, you are crossing environment boundaries! THIS WILL INCURR SECURITY RISKS!", BindingDslPackage.SOAP__PUBLISHER);
		} 
	}

}
