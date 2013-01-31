package org.fornax.soa.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.fornax.soa.basedsl.search.IEObjectLookup;
import org.fornax.soa.basedsl.search.IReferenceSearch;
import org.fornax.soa.basedsl.validation.AbstractPluggableDeclarativeValidator;
import org.fornax.soa.binding.query.BindingLookup;
import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.environment.query.EnvironmentLookup;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.environmentDsl.EnvironmentType;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.moduledsl.moduleDsl.ModuleDslPackage;
import org.fornax.soa.moduledsl.query.ModuleLookup;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateComparator;
import org.fornax.soa.util.BindingDslHelper;

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
	BindingDslHelper bindingDslHelper;
	
	@Inject
	BindingLookup bindingLookup;
	
	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.fornax.soa.bindingDsl.BindingDslPackage.eINSTANCE);
	    result.add(org.fornax.soa.moduledsl.moduleDsl.ModuleDslPackage.eINSTANCE);
	    result.add(org.fornax.soa.serviceDsl.ServiceDslPackage.eINSTANCE);
		return result;
	}
	
	public boolean isLanguageSpecific() {
		return false;
	}

	@Check (CheckType.FAST)
	public void checkModuleHasBindingsForState (Module module) {
		if (!module.isClient() && !module.isExternal()) {
//			final Set<ModuleBinding> moduleBindings = bindingDslHelper.getBindingsForModule(module);
			final Set<ModuleBinding> moduleBindings = bindingLookup.findAllBindingsToCompatibleModule (module);
			if (moduleBindings.isEmpty()) {
				warning("The module " + module.getName() + " has no binding. You should define a binding to use it from another module", ModuleDslPackage.Literals.MODULE__NAME);
			} else {
				List<EnvironmentType> envTypes = module.getState().getQualifiesFor();
				envTypes = envLookup.filterByUsedEnvironmentTypes (envTypes, module.eResource().getResourceSet());
				for (EnvironmentType envType : envTypes) {
					boolean hasBinding = false;
					for (ModuleBinding bind : moduleBindings) {
						if (bind.getEnvironment().getType().equals(envType))
							hasBinding = true;
					}
					if (!hasBinding)
						warning("The module " + module.getName() + " has no binding to an environment of type " + envType.getName() + ". You should define such a binding to use it in a " + envType.getName() + " environment", ModuleDslPackage.Literals.MODULE__NAME);
				}
				List<Environment> envs = module.getState().getQualifiesForEnvironment();
				for (Environment env : envs) {
					boolean hasBinding = false;
					for (ModuleBinding bind : moduleBindings) {
						if (bind.getEnvironment().equals(env))
							hasBinding = true;
					}
					if (!hasBinding)
						warning("The module " + module.getName() + " has no binding to environment " + env.getName() + ". You should define such a binding to use it in the " + env.getName() + " environment", ModuleDslPackage.Literals.MODULE__NAME);
				}
			}
		}
	}
}
