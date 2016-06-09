package org.xkonnex.repo.dsl.bindingdsl.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CancelableDiagnostician;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.INamesAreUniqueValidationHelper;
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup;
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch;
import org.xkonnex.repo.dsl.basedsl.search.IReferenceSearch;
import org.xkonnex.repo.dsl.basedsl.validation.AbstractPluggableDeclarativeValidator;
import org.xkonnex.repo.dsl.basedsl.validation.NameAndVersionAreUniqueValidator;
import org.xkonnex.repo.dsl.basedsl.validation.PluggableChecks;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingDslPackage;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleRef;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.OperationBinding;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAP;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ServiceBinding;
import org.xkonnex.repo.dsl.bindingdsl.util.BindingDslHelper;
import org.xkonnex.repo.dsl.bindingdsl.validation.AbstractBindingDslValidator;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.EnvironmentType;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.LifecycleStateComparator;
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.EnvironmentBindingResolver;
import org.xkonnex.repo.dsl.moduledsl.query.ModuleLookup;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Visibility;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Injector;

@PluggableChecks (validators = {
		UsedModuleValidator.class,
		ModuleProvidedServicesValidator.class,
		NameAndVersionAreUniqueValidator.class
})
public class BindingDslValidator extends AbstractBindingDslValidator {

	@Inject
	private LifecycleStateComparator stateComparator;
	
	@Inject
	private ModuleLookup moduleLookup;
	
	@Inject
	private IReferenceSearch referenceSearch;
	
	@Inject
	private IEObjectLookup objLookup;
	
	@Inject
	private IQualifiedNameProvider nameProvider;
	
	@Inject
	private IPredicateSearch search;
	
	@Inject
	private INamesAreUniqueValidationHelper namesUniqueValidationHelper;

	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry = IResourceServiceProvider.Registry.INSTANCE;
	
	@Inject
	private Injector injector;
	@Inject 
	private EnvironmentBindingResolver envBindResolver;

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingDslPackage.eINSTANCE);
	    result.add(org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleDslPackage.eINSTANCE);
	    result.add(org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceDslPackage.eINSTANCE);
		return result;
	}

	@Check (CheckType.FAST)
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

	@Check (CheckType.FAST)
	public void checkUniqueBindingNamesInResourceOf(ModuleBinding eObject) {
		QualifiedName bindingName = nameProvider.getFullyQualifiedName(eObject);
		final EClass eObjectClass = eObject.eClass();
		if (bindingName != null) {
			Predicate<IEObjectDescription> pred = new Predicate<IEObjectDescription>() {

				public boolean apply(IEObjectDescription input) {
					return eObjectClass.isInstance(input.getEObjectOrProxy());
				}
			};
			Iterable<IEObjectDescription> descriptions = search.search(bindingName.toString() + " ", eObject.eClass().getName() + " ", pred);
			if (Lists.newArrayList(descriptions).size() > 1) {
				error ("Duplicate " + eObjectClass.getName() + " '"+ bindingName.toString() + "'", BindingDslPackage.Literals.MODULE_BINDING__NAME);
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
