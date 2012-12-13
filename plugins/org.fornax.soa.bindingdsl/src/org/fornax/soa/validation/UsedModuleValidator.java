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
import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.environmentDsl.EnvironmentType;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.moduledsl.moduleDsl.ModuleDslPackage;
import org.fornax.soa.moduledsl.moduleDsl.ServiceModuleRef;
import org.fornax.soa.moduledsl.query.ModuleLookup;
import org.fornax.soa.profiledsl.scoping.versions.LifecycleStateComparator;
import org.fornax.soa.util.BindingDslHelper;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

public class UsedModuleValidator extends AbstractPluggableDeclarativeValidator {

	@Inject
	LifecycleStateComparator stateComparator;
	
	@Inject
	ModuleLookup moduleLookup;
	
	@Inject
	IReferenceSearch referenceSearch;
	
	@Inject
	IEObjectLookup objLookup;
	
	@Inject
	BindingDslHelper bindingDslHelper;
	
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

	@Check (CheckType.NORMAL)
	public void checkUsedModuleHasBinding(org.fornax.soa.moduledsl.moduleDsl.ServiceModuleRef modRef) {
		if (modRef.eResource() != null && !moduleLookup.findAllModules(modRef.eResource().getResourceSet()).isEmpty()) {
			Module usedModule = modRef.getModule();
			if (usedModule != null && usedModule.eResource() != null) {
				
				final Set<ModuleBinding> usedModuleBindings = bindingDslHelper.getBindingsForModule(usedModule);
				if (usedModuleBindings.isEmpty()) {
					warning("The used module " + usedModule.getName() + " has no binding. You should define a binding to use it from another module", ModuleDslPackage.Literals.SERVICE_MODULE_REF__MODULE);
				} else {
					EList<EnvironmentType> envTypes = usedModule.getState().getQualifiesFor();
					for (EnvironmentType envType : envTypes) {
						boolean hasBinding = false;
						for (ModuleBinding bind : usedModuleBindings) {
							if (bind.getEnvironment().getType().equals(envType))
								hasBinding = true;
						}
						if (!hasBinding)
							warning("The used module " + usedModule.getName() + " has no binding to an environment of type " + envType.getName() + ". You should define such a binding to use it in a " + envType.getName() + " environment", ModuleDslPackage.Literals.SERVICE_MODULE_REF__MODULE);
					}
					EList<Environment> envs = usedModule.getState().getQualifiesForEnvironment();
					for (Environment env : envs) {
						boolean hasBinding = false;
						for (ModuleBinding bind : usedModuleBindings) {
							if (bind.getEnvironment().equals(env))
								hasBinding = true;
						}
						if (!hasBinding)
							warning("The used module " + usedModule.getName() + " has no binding to environment " + env.getName() + ". You should define such a binding to use it in the " + env.getName() + " environment", ModuleDslPackage.Literals.SERVICE_MODULE_REF__MODULE);
					}
				}
			}
		}
		
	}
	
	@Check (CheckType.NORMAL)
	public void checkUsedServiceHasBinding(org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef svcRef) {
		if (svcRef.eResource() != null && !moduleLookup.findAllModules(svcRef.eResource().getResourceSet()).isEmpty()) {
			Iterable<Module> providingModules = Sets.newHashSet();
			if (!svcRef.getModules().isEmpty()) {
				List<Module> candModules = Lists.transform(svcRef.getModules(), new Function<ServiceModuleRef, Module>() {

					public Module apply(ServiceModuleRef input) {
						return input.getModule();
					}
					
				});
				if (svcRef.getBindingQualifier() != null) {
					providingModules = moduleLookup.findProvidingModules(svcRef.getService(), candModules, svcRef.getBindingQualifier().getName());
					if (!providingModules.iterator().hasNext())
						warning("The service "+ svcRef.getService().getName() + " is not provided by any of the candidate Modules with the binding qualifier " + svcRef.getBindingQualifier() + ".", ModuleDslPackage.Literals.IMPORT_SERVICE_REF__SERVICE);
				}
				else
					providingModules = moduleLookup.findProvidingModules(svcRef.getService(), candModules);
					if (!providingModules.iterator().hasNext())
						warning("The service "+ svcRef.getService().getName() + " is not provided by any of the candidate Modules.", ModuleDslPackage.Literals.IMPORT_SERVICE_REF__SERVICE);
			} else {
				providingModules = moduleLookup.findProvidingModules(svcRef.getService());
				if (!providingModules.iterator().hasNext())
					warning("The service "+ svcRef.getService().getName() + " is not provided by any Module.", ModuleDslPackage.Literals.IMPORT_SERVICE_REF__SERVICE);
			}
			boolean hasProvidingModuleWithBinding = false;
			for (Module usedModule : providingModules) {
				if (usedModule != null && usedModule.eResource() != null) {
					final Set<ModuleBinding> usedModuleBindings = bindingDslHelper.getBindingsForModule(usedModule);
					if (!usedModuleBindings.isEmpty())
						hasProvidingModuleWithBinding = true;
				}
			}
			if (!hasProvidingModuleWithBinding)
				warning("The service "+ svcRef.getService().getName() + " has no providing Module with a binding. You should define a binding for a providing module to use it from another module", ModuleDslPackage.Literals.IMPORT_SERVICE_REF__SERVICE);
		}
		
	}

}
