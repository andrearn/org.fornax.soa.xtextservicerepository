package org.xkonnex.repo.dsl.bindingdsl.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup;
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch;
import org.xkonnex.repo.dsl.basedsl.search.IReferenceSearch;
import org.xkonnex.repo.dsl.basedsl.validation.AbstractPluggableDeclarativeValidator;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding;
import org.xkonnex.repo.dsl.bindingdsl.util.BindingDslHelper;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.EnvironmentType;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleDslPackage;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.LifecycleStateComparator;
import org.xkonnex.repo.dsl.bindingdsl.binding.query.BindingLookup;
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.EnvironmentBindingResolver;
import org.xkonnex.repo.dsl.environmentdsl.environment.query.EnvironmentLookup;
import org.xkonnex.repo.dsl.moduledsl.query.ModuleLookup;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class ModuleProvidedServicesValidator extends AbstractPluggableDeclarativeValidator {

	@Inject
	LifecycleStateComparator stateComparator;
	
	@Inject
	ModuleLookup moduleLookup;
	@Inject
	EnvironmentLookup envLookup;
	
	@Inject
	IReferenceSearch referenceSearch;
	
	@Inject
	IEObjectLookup objLookup;
	
	@Inject
	IPredicateSearch search;
	
	@Inject
	BindingDslHelper bindingDslHelper;
	
	@Inject
	BindingLookup bindingLookup;
	@Inject EnvironmentBindingResolver envBindResolver;		
	
	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingDslPackage.eINSTANCE);
	    result.add(org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleDslPackage.eINSTANCE);
	    result.add(org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceDslPackage.eINSTANCE);
		return result;
	}
	
	public boolean isLanguageSpecific() {
		return false;
	}

	@Check (CheckType.FAST)
	public void checkModuleHasBindingsForState (Module module) {
		Predicate<IEObjectDescription> assetPredicate = Predicates.alwaysTrue();
		if (!module.isClient() && !module.isExternal() && search.search("*", assetPredicate).iterator().hasNext()) {
			final Set<ModuleBinding> moduleBindings = bindingLookup.findAllApplicableBindingsToModule (module);
			if (moduleBindings.isEmpty()) {
				warning("The module " + module.getName() + " has no binding. You should define a binding to use it from another module", ModuleDslPackage.Literals.MODULE__NAME);
			} else {
				List<EnvironmentType> envTypes = module.getState().getQualifiesFor();
				envTypes = envLookup.filterByUsedEnvironmentTypes (envTypes, module.eResource().getResourceSet());
				for (EnvironmentType envType : envTypes) {
					boolean hasBinding = false;
					for (ModuleBinding bind : moduleBindings) {
						if (envBindResolver.resolveEnvironment(bind).getType().equals(envType))
							hasBinding = true;
					}
					if (!hasBinding)
						warning("The module " + module.getName() + " has no binding to an environment of type " + envType.getName() + ". You should define such a binding to use it in a " + envType.getName() + " environment", ModuleDslPackage.Literals.MODULE__NAME);
				}
				List<Environment> envs = module.getState().getQualifiesForEnvironment();
				for (Environment env : envs) {
					boolean hasBinding = false;
					for (ModuleBinding bind : moduleBindings) {
						if (envBindResolver.resolveEnvironment(bind).equals(env))
							hasBinding = true;
					}
					if (!hasBinding)
						warning("The module " + module.getName() + " has no binding to environment " + env.getName() + ". You should define such a binding to use it in the " + env.getName() + " environment", ModuleDslPackage.Literals.MODULE__NAME);
				}
			}
		}
	}
}
