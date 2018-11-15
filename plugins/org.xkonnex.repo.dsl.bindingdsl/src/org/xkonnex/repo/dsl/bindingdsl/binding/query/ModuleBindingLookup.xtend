package org.xkonnex.repo.dsl.bindingdsl.binding.query

import com.google.common.base.Predicates
import com.google.inject.Inject
import java.util.List
import java.util.Set
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.xkonnex.repo.dsl.basedsl.resource.IEObjectDescriptionBuilder
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.EnvironmentBindingResolver
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.IStateMatcher
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.IVersionFilterProvider

class ModuleBindingLookup {
	
	@Inject extension EnvironmentBindingResolver		
	@Inject
	private IQualifiedNameProvider nameProvider;
	@Inject
	private IPredicateSearch lookup; 
	@Inject
	private	IStateMatcher stateMatcher;
	@Inject
	private IVersionFilterProvider versionFilterProvider;
	@Inject
	private IEObjectDescriptionBuilder descBuilder;
	
	
//	def Binding getMostSpecificBinding (Service service, EndpointQualifierRef endpointQualifierRef, ImportBindingProtocol protocol, Environment targetEnvironment, Module module) {
//		val moduleBindings = findBindingForProvidingModuleAndEnv (targetEnvironment, module)
//		return null
//	}
	
	/**
	 * Find a binding to the target environment that is applicable for the module 
	 * 
	 * @param targetEnvironment The {@link Environment} to bind to
	 * @param module The  Module to be bound
	 * @return {@link ModuleBinding}s of module to the {@link Environment} targetEnvironment
	 */
	def List<ModuleBinding> findBindingForProvidingModuleAndEnv (Environment targetEnvironment, Module module) {
		 if (stateMatcher.supportsEnvironment(module.state, targetEnvironment.name)) {
			 var candBindings = findAllBindingsByModuleAndEnvironment (targetEnvironment, nameProvider.getFullyQualifiedName(module).toString)
			 return candBindings.filter (b | versionFilterProvider.createVersionFilter (b.module.versionRef)
			 									.matches (descBuilder.buildDescription(module))
			 ).toList
		 }
		 return newArrayList()
	}
	
	/**
	 * Find all Bindings of any version of a module with the given name to the given target environment. Returns an empty set 
	 * if no such ModuleBinding exists
	 *
	 * @param targetEnvironment The {@link Environment} to bind to
	 * @param providingModuleName The name of the Module to be bound
	 * @return {@link ModuleBinding}s of module to the {@link Environment} targetEnvironment
	 */
	def Set<ModuleBinding> findAllBindingsByModuleAndEnvironment (Environment targetEnvironment, String providingModuleName) {
		var candBindings= lookup.search("ModuleBinding ", Predicates::alwaysTrue)
			.map (desc | EcoreUtil2::resolve (desc.EObjectOrProxy, targetEnvironment.eResource.resourceSet))
		 	.filter (typeof (ModuleBinding))
		 	.filter (bind | providingModuleName.equals (nameProvider.getFullyQualifiedName (bind.module).toString) 
		 		&& bind.resolveEnvironment.equals (targetEnvironment)
		 	)
		return candBindings.toSet
	}

	
	
}