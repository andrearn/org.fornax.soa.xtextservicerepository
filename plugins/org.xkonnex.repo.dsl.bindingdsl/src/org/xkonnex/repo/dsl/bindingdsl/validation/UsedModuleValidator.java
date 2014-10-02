package org.xkonnex.repo.dsl.bindingdsl.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup;
import org.xkonnex.repo.dsl.basedsl.search.IReferenceSearch;
import org.xkonnex.repo.dsl.basedsl.validation.AbstractPluggableDeclarativeValidator;
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding;
import org.xkonnex.repo.dsl.bindingdsl.util.BindingDslHelper;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.EnvironmentType;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleDslPackage;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ServiceModuleRef;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.LifecycleStateComparator;
import org.xkonnex.repo.dsl.bindingdsl.binding.query.BindingLookup;
import org.xkonnex.repo.dsl.bindingdsl.binding.query.EndpointQualifierQueries;
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.EnvironmentBindingResolver;
import org.xkonnex.repo.dsl.environmentdsl.environment.query.EnvironmentLookup;
import org.xkonnex.repo.dsl.moduledsl.query.ModuleLookup;
import org.xkonnex.repo.dsl.semanticsdsl.semanticsDsl.Qualifier;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

public class UsedModuleValidator extends AbstractPluggableDeclarativeValidator {

	@Inject
	private LifecycleStateComparator stateComparator;
	@Inject
	private ModuleLookup moduleLookup;
	@Inject
	private EnvironmentLookup envLookup;
	@Inject
	private IReferenceSearch referenceSearch;
	@Inject
	private IEObjectLookup objLookup;
	@Inject
	private BindingDslHelper bindingDslHelper;
	@Inject
	private EnvironmentBindingResolver envBindResolver;
	@Inject
	private BindingLookup bindLookup;
	@Inject
	private EndpointQualifierQueries endpointQualifierQueries;
	
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
	public void checkUsedModuleHasBinding(org.xkonnex.repo.dsl.moduledsl.moduleDsl.ServiceModuleRef modRef) {
		if (modRef.eResource() != null && !moduleLookup.findAllModules(modRef.eResource().getResourceSet()).isEmpty()) {
			Module usedModule = modRef.getModule();
			if (usedModule != null && usedModule.eResource() != null) {
				Qualifier effectiveEndpointQualifier = endpointQualifierQueries.getEffectiveEndpointQualifier(modRef);
				final Set<ModuleBinding> usedModuleBindings = bindLookup.findAllApplicableBindingsToModuleByQualifier (usedModule, effectiveEndpointQualifier);
				if (usedModuleBindings.isEmpty()) {
					warning("The used module " + usedModule.getName() + " has no binding. You should define a binding to use it from another module", ModuleDslPackage.Literals.SERVICE_MODULE_REF__MODULE);
				} else {
					List<EnvironmentType> envTypes = usedModule.getState().getQualifiesFor();
					envTypes = envLookup.filterByUsedEnvironmentTypes (envTypes, usedModule.eResource().getResourceSet());
					for (EnvironmentType envType : envTypes) {
						boolean hasBinding = false;
						for (ModuleBinding bind : usedModuleBindings) {
							if (envBindResolver.resolveEnvironment(bind).getType().equals(envType))
								hasBinding = true;
						}
						if (!hasBinding)
							warning("The used module " + usedModule.getName() + " has no binding to an environment of type " + envType.getName() + ". You should define such a binding to use it in a " + envType.getName() + " environment", ModuleDslPackage.Literals.SERVICE_MODULE_REF__MODULE);
					}
					EList<Environment> envs = usedModule.getState().getQualifiesForEnvironment();
					for (Environment env : envs) {
						boolean hasBinding = false;
						for (ModuleBinding bind : usedModuleBindings) {
							if (envBindResolver.resolveEnvironment(bind).equals(env))
								hasBinding = true;
						}
						if (!hasBinding)
							warning("The used module " + usedModule.getName() + " has no binding to environment " + env.getName() + ". You should define such a binding to use it in the " + env.getName() + " environment", ModuleDslPackage.Literals.SERVICE_MODULE_REF__MODULE);
					}
				}
			}
		}
		
	}
	
	@Check (CheckType.FAST)
	public void checkUsedServiceHasBinding(org.xkonnex.repo.dsl.moduledsl.moduleDsl.ImportServiceRef svcRef) {
		if (svcRef.eResource() != null && !moduleLookup.findAllModules(svcRef.eResource().getResourceSet()).isEmpty()) {
			Iterable<Module> providingModules = Sets.newHashSet();
			if (!svcRef.getModules().isEmpty()) {
				List<Module> candModules = Lists.transform(svcRef.getModules(), new Function<ServiceModuleRef, Module>() {

					public Module apply(ServiceModuleRef input) {
						return input.getModule();
					}
					
				});
				if (svcRef.getEndpointQualifierRef() != null) {
					providingModules = moduleLookup.findProvidingModules(svcRef.getService(), candModules, svcRef.getEndpointQualifierRef().getEndpointQualifier().getName());
					if (!providingModules.iterator().hasNext())
						warning("The service "+ svcRef.getService().getName() + " is not provided by any of the candidate Modules with the endpoint qualifier " + svcRef.getEndpointQualifierRef().getEndpointQualifier().getName() + ".", ModuleDslPackage.Literals.ABSTRACT_SERVICE_REF__SERVICE);
				}
				else
					providingModules = moduleLookup.findProvidingModules(svcRef.getService(), candModules);
					if (!providingModules.iterator().hasNext())
						warning("The service "+ svcRef.getService().getName() + " is not provided by any of the candidate Modules.", ModuleDslPackage.Literals.ABSTRACT_SERVICE_REF__SERVICE);
			} else {
				providingModules = moduleLookup.findProvidingModules(svcRef.getService());
				if (!providingModules.iterator().hasNext())
					warning("The service "+ svcRef.getService().getName() + " is not provided by any Module.", ModuleDslPackage.Literals.ABSTRACT_SERVICE_REF__SERVICE);
			}
			boolean hasProvidingModuleWithBinding = false;
			for (Module usedModule : providingModules) {
				if (usedModule != null && usedModule.eResource() != null) {
					final Set<ModuleBinding> usedModuleBindings = bindLookup.findAllApplicableBindingsToModule (usedModule);
					if (!usedModuleBindings.isEmpty())
						hasProvidingModuleWithBinding = true;
				}
			}
			if (!hasProvidingModuleWithBinding)
				warning("The service "+ svcRef.getService().getName() + " has no providing Module with a binding. You should define a binding for a providing module to use it from another module", ModuleDslPackage.Literals.ABSTRACT_SERVICE_REF__SERVICE);
		}
		
	}

}
