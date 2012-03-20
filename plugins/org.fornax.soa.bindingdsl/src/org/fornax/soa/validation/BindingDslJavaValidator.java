package org.fornax.soa.validation;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.fornax.soa.bindingDsl.Binding;
import org.fornax.soa.bindingDsl.BindingDslPackage;
import org.fornax.soa.bindingDsl.DomainBinding;
import org.fornax.soa.bindingDsl.EJB;
import org.fornax.soa.bindingDsl.HTTP;
import org.fornax.soa.bindingDsl.JMS;
import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.bindingDsl.ModuleRef;
import org.fornax.soa.bindingDsl.OperationBinding;
import org.fornax.soa.bindingDsl.REST;
import org.fornax.soa.bindingDsl.SOAP;
import org.fornax.soa.bindingDsl.ServiceBinding;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.environmentDsl.EnvironmentType;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.moduledsl.moduleDsl.ModuleDslPackage;
import org.fornax.soa.moduledsl.moduleDsl.ServiceRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateComparator;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateResolver;
import org.fornax.soa.profiledsl.scoping.versions.StateAttributeLifecycleStateResolver;
import org.fornax.soa.serviceDsl.VISIBILITY;
import org.fornax.soa.util.BindingDslHelper;

import com.google.inject.Inject;

public class BindingDslJavaValidator extends AbstractBindingDslJavaValidator {

	@Inject
	LifecycleStateComparator stateComparator;

	@Check
	public void checkOnlyPrivateServiceHasProvidedWSDL (SOAP soap) {
		if (soap.getProvidedWsdlUrl () != null) {
			if (soap.eContainer () instanceof DomainBinding) {
				error ("SOAP may not define a provided-WSDL-Url for a domain level binding",
						BindingDslPackage.Literals.SOAP__PROVIDED_WSDL_URL);
			} else if (soap.eContainer () instanceof OperationBinding) {
				error ("SOAP may not define a provided-WSDL-Url for a operation level binding",
						BindingDslPackage.Literals.SOAP__PROVIDED_WSDL_URL);
			} else if (soap.eContainer () instanceof ServiceBinding
					&& ((ServiceBinding) soap.eContainer ()).getService ()
							.getService ().getVisibility () != VISIBILITY.PRIVATE) {
				error ("SOAP may not define a provided-WSDL-Url for a service level binding to a non-private service",
						BindingDslPackage.Literals.SOAP__PROVIDED_WSDL_URL);
			}
		}
	}

	@Check
	public void checkPublisherServerInBoundEnvironment (SOAP prot) {
		if (prot.eContainer () instanceof Binding) {
			Binding b = (Binding) prot.eContainer ();
			if (!BindingDslHelper.getEnvironment (b).getServers ()
					.contains (prot.getPublisher ().getPubServer ()))
				warning (
						"The referenced publishing Server is not part of the environment declared in the binding. Hence, you are crossing environment boundaries! THIS WILL INCURR SECURITY RISKS!",
						BindingDslPackage.Literals.SOAP__PUBLISHER);
		}
	}

	@Check
	public void checkProviderServerInBoundEnvironment (SOAP prot) {
		if (prot.eContainer () instanceof Binding) {
			Binding b = (Binding) prot.eContainer ();
			if (prot.getProvider () != null
					&& !BindingDslHelper.getEnvironment (b).getServers ()
							.contains (prot.getProvider ().getProvServer ()))
				warning (
						"The referenced provider Server is not part of the environment declared in the binding. Hence, you are crossing environment boundaries! THIS WILL INCURR SECURITY RISKS!",
						BindingDslPackage.Literals.SOAP__PUBLISHER);
		}
	}

	@Check
	public void checkPublisherServerInBoundEnvironment (EJB prot) {
		if (prot.eContainer () instanceof Binding) {
			Binding b = (Binding) prot.eContainer ();
			if (!BindingDslHelper.getEnvironment (b).getServers ()
					.contains (prot.getPublisher ().getPubServer ()))
				warning (
						"The referenced publishing Server is not part of the environment declared in the binding. Hence, you are crossing environment boundaries! THIS WILL INCURR SECURITY RISKS!",
						BindingDslPackage.Literals.SOAP__PUBLISHER);
		}
	}

	@Check
	public void checkProviderServerInBoundEnvironment (EJB prot) {
		if (prot.eContainer () instanceof Binding) {
			Binding b = (Binding) prot.eContainer ();
			if (prot.getProvider () != null
					&& !BindingDslHelper.getEnvironment (b).getServers ()
							.contains (prot.getProvider ().getProvServer ()))
				warning (
						"The referenced provider Server is not part of the environment declared in the binding. Hence, you are crossing environment boundaries! THIS WILL INCURR SECURITY RISKS!",
						BindingDslPackage.Literals.SOAP__PUBLISHER);
		}
	}

	@Check
	public void checkPublisherServerInBoundEnvironment (JMS prot) {
		if (prot.eContainer () instanceof Binding) {
			Binding b = (Binding) prot.eContainer ();
			if (!BindingDslHelper.getEnvironment (b).getServers ()
					.contains (prot.getPublisher ().getPubServer ()))
				warning (
						"The referenced publishing Server is not part of the environment declared in the binding. Hence, you are crossing environment boundaries! THIS WILL INCURR SECURITY RISKS!",
						BindingDslPackage.Literals.SOAP__PUBLISHER);
		}
	}

	@Check
	public void checkProviderServerInBoundEnvironment (JMS prot) {
		if (prot.eContainer () instanceof Binding) {
			Binding b = (Binding) prot.eContainer ();
			if (prot.getProvider () != null
					&& !BindingDslHelper.getEnvironment (b).getServers ()
							.contains (prot.getProvider ().getProvServer ()))
				warning (
						"The referenced provider Server is not part of the environment declared in the binding. Hence, you are crossing environment boundaries! THIS WILL INCURR SECURITY RISKS!",
						BindingDslPackage.Literals.SOAP__PUBLISHER);
		}
	}

	@Check
	public void checkPublisherServerInBoundEnvironment (HTTP prot) {
		if (prot.eContainer () instanceof Binding) {
			Binding b = (Binding) prot.eContainer ();
			if (!BindingDslHelper.getEnvironment (b).getServers ()
					.contains (prot.getPublisher ().getPubServer ()))
				warning (
						"The referenced publishing Server is not part of the environment declared in the binding. Hence, you are crossing environment boundaries! THIS WILL INCURR SECURITY RISKS!",
						BindingDslPackage.Literals.SOAP__PUBLISHER);
		}
	}

	@Check
	public void checkProviderServerInBoundEnvironment (HTTP prot) {
		if (prot.eContainer () instanceof Binding) {
			Binding b = (Binding) prot.eContainer ();
			if (prot.getProvider () != null
					&& !BindingDslHelper.getEnvironment (b).getServers ()
							.contains (prot.getProvider ().getProvServer ()))
				warning (
						"The referenced provider Server is not part of the environment declared in the binding. Hence, you are crossing environment boundaries! THIS WILL INCURR SECURITY RISKS!",
						BindingDslPackage.Literals.SOAP__PUBLISHER);
		}
	}

	@Check
	public void checkPublisherServerInBoundEnvironment (REST prot) {
		if (prot.eContainer () instanceof Binding) {
			Binding b = (Binding) prot.eContainer ();
			if (!BindingDslHelper.getEnvironment (b).getServers ()
					.contains (prot.getPublisher ().getPubServer ()))
				warning (
						"The referenced publishing Server is not part of the environment declared in the binding. Hence, you are crossing environment boundaries! THIS WILL INCURR SECURITY RISKS!",
						BindingDslPackage.Literals.SOAP__PUBLISHER);
		}
	}

	@Check
	public void checkProviderServerInBoundEnvironment (REST prot) {
		if (prot.eContainer () instanceof Binding) {
			Binding b = (Binding) prot.eContainer ();
			if (prot.getProvider () != null
					&& !BindingDslHelper.getEnvironment (b).getServers ()
							.contains (prot.getProvider ().getProvServer ()))
				warning (
						"The referenced provider Server is not part of the environment declared in the binding. Hence, you are crossing environment boundaries! THIS WILL INCURR SECURITY RISKS!",
						BindingDslPackage.Literals.SOAP__PUBLISHER);
		}
	}

	@Check
	public void checkNotRefsLowerStateService (ModuleRef moduleRef) {
		EObject owner = moduleRef.eContainer ();
		if (owner instanceof ModuleBinding) {
			ModuleBinding bind = (ModuleBinding) owner;
			Module module = moduleRef.getModule ();
			LifecycleState state = module.getState();
			EnvironmentType targetEnvType = bind.getEnvironment ().getType ();
			List<EnvironmentType> stateEnvironmentTypes = state.getQualifiesFor();
			EList<Environment> stateEnvironments = state.getQualifiesForEnvironment();
			List<EnvironmentType> allStateEnvironmentTypes = stateComparator.getStateEnvironmentTypes(state);
			if (!(stateEnvironmentTypes.contains (targetEnvType)) || stateEnvironments.contains(bind.getEnvironment())) {
				error ("The module "
						+ module.getName ()
						+ " "
						+ module.getVersion ().getVersion ()
						+ " is in state "
						+ module.getState ().getName ()
						+ " which does not qualify for the targeted environment "
						+ bind.getEnvironment ().getName() 
						+ ". Review the module's state and seek governance approval to a state that supports the targeted environment!",
								BindingDslPackage.Literals.MODULE_REF__MODULE);
			}
		}
	}

}
