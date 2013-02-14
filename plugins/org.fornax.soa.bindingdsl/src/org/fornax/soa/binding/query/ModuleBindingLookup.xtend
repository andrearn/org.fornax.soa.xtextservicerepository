package org.fornax.soa.binding.query

import com.google.common.base.Predicates
import com.google.inject.Inject
import java.util.List
import java.util.Set
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.fornax.soa.basedsl.resource.IEObjectDescriptionBuilder
import org.fornax.soa.basedsl.search.IPredicateSearch
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.bindingDsl.EndpointQualifierRefs
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.moduledsl.moduleDsl.ImportBindingProtocol
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher
import org.fornax.soa.profiledsl.scoping.versions.IVersionFilterProvider
import org.fornax.soa.serviceDsl.Service

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
	
	
	def Binding getMostSpecificBinding (Service service, EndpointQualifierRefs endpointQualifierRefs, ImportBindingProtocol protocol, Environment targetEnvironment, Module module) {
		val moduleBindings = findBindingForProvidingModuleAndEnv (targetEnvironment, module)
		return null
	}
	
	/*
	 * Find a binding to the target environment that is applicable for the module 
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
	
	/*
	 * Find all Bindings of any version of a module with the given name to the given target environment. Returns an empty set 
	 * if no such ModuleBinding exists
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