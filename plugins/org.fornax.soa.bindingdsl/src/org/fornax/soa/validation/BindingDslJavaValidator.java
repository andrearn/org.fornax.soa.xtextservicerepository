package org.fornax.soa.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.Check;
import org.fornax.soa.basedsl.search.IEObjectLookup;
import org.fornax.soa.basedsl.search.IReferenceSearch;
import org.fornax.soa.basedsl.validation.AbstractPluggableDeclarativeValidator;
import org.fornax.soa.basedsl.validation.PluggableChecks;
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver;
import org.fornax.soa.bindingDsl.Binding;
import org.fornax.soa.bindingDsl.BindingDslPackage;
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
import org.fornax.soa.moduledsl.query.ModuleLookup;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateComparator;
import org.fornax.soa.serviceDsl.Visibility;
import org.fornax.soa.util.BindingDslHelper;

import com.google.inject.Inject;
import com.google.inject.Injector;

@PluggableChecks (validators = {
		UsedModuleValidator.class,
		ModuleProvidedServicesValidator.class
})
public class BindingDslJavaValidator extends AbstractBindingDslJavaValidator {

	@Inject
	LifecycleStateComparator stateComparator;
	
	@Inject
	ModuleLookup moduleLookup;
	
	@Inject
	IReferenceSearch referenceSearch;
	
	@Inject
	IEObjectLookup objLookup;
	
	@Inject
	Injector injector;
	@Inject 
	EnvironmentBindingResolver envBindResolver;		

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.fornax.soa.bindingDsl.BindingDslPackage.eINSTANCE);
	    result.add(org.fornax.soa.moduledsl.moduleDsl.ModuleDslPackage.eINSTANCE);
	    result.add(org.fornax.soa.serviceDsl.ServiceDslPackage.eINSTANCE);
		return result;
	}

	@Check
	public void checkOnlyPrivateServiceHasProvidedWSDL (SOAP soap) {
		if (soap.getProvidedWsdlUrl () != null) {
			if (soap.eContainer () instanceof ModuleBinding) {
				error ("SOAP may not define a provided-WSDL-Url for a module binding",
						BindingDslPackage.Literals.SOAP__PROVIDED_WSDL_URL);
			} else if (soap.eContainer () instanceof OperationBinding) {
				error ("SOAP may not define a provided-WSDL-Url for an operation binding",
						BindingDslPackage.Literals.SOAP__PROVIDED_WSDL_URL);
			} else if (soap.eContainer () instanceof ServiceBinding
					&& ((ServiceBinding) soap.eContainer ()).getService ()
							.getService ().getVisibility () != Visibility.PRIVATE) {
				error ("SOAP may not define a provided-WSDL-Url for a service level binding to a non-private service",
						BindingDslPackage.Literals.SOAP__PROVIDED_WSDL_URL);
			}
		}
	}

	@Check
	public void checkNotRefsLowerStateService (ModuleRef moduleRef) {
		EObject owner = moduleRef.eContainer ();
		if (owner instanceof ModuleBinding) {
			ModuleBinding bind = (ModuleBinding) owner;
			Module module = moduleRef.getModule ();
			LifecycleState state = module.getState();
			EnvironmentType targetEnvType = envBindResolver.resolveEnvironment(bind).getType ();
			List<EnvironmentType> stateEnvironmentTypes = state.getQualifiesFor();
			EList<Environment> stateEnvironments = state.getQualifiesForEnvironment();
			List<EnvironmentType> allStateEnvironmentTypes = stateComparator.getStateEnvironmentTypes(state);
			if (!(stateEnvironmentTypes.contains (targetEnvType)) || stateEnvironments.contains(envBindResolver.resolveEnvironment(bind))) {
				error ("The module "
						+ module.getName ()
						+ " "
						+ module.getVersion ().getVersion ()
						+ " is in state "
						+ module.getState ().getName ()
						+ " which does not qualify for the targeted environment "
						+ envBindResolver.resolveEnvironment(bind).getName() 
						+ ". Review the module's state and seek governance approval to a state that supports the targeted environment!",
								BindingDslPackage.Literals.MODULE_REF__MODULE);
			}
		}
	}
	
	
	protected Set<AbstractPluggableDeclarativeValidator> getRegisteredValidators () {
		Set<AbstractPluggableDeclarativeValidator> regValidators = new HashSet<AbstractPluggableDeclarativeValidator>();
		regValidators.add(this);
		regValidators.add(injector.getInstance(UsedModuleValidator.class));
		return regValidators;
	}

	
}
