package org.fornax.soa.binding.query

import com.google.inject.Inject
import org.fornax.soa.basedsl.scoping.versions.VersionComparator
import org.fornax.soa.basedsl.search.IEObjectLookup
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.basedsl.search.IReferenceSearch
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef
import org.eclipse.xtext.naming.QualifiedName
import org.fornax.soa.basedsl.search.IPredicateSearch
import com.google.common.base.Predicates
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.EcoreUtil2
import org.fornax.soa.profiledsl.scoping.versions.EnvironmentBasedLatestMajorVersionFilter
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher
import java.util.List
import org.fornax.soa.bindingDsl.ModuleBinding
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.fornax.soa.bindingDsl.EndpointQualifierRefs
import org.fornax.soa.moduledsl.moduleDsl.ImportBindingProtocol
import org.eclipse.emf.ecore.resource.ResourceSet
import java.util.Set
import org.fornax.soa.profiledsl.scoping.versions.IVersionFilterProvider
import org.fornax.soa.basedsl.resource.IEObjectDescriptionBuilder

class ModuleBindingLookup {
	
	@Inject
	private IQualifiedNameProvider nameProvider;
	@Inject
	private VersionComparator versionComparator;
	@Inject
	private IEObjectLookup ieObjectLookup;
	@Inject
	private IReferenceSearch refLookup; 
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
			 //TODO version filter
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
		 		&& bind.environment.equals (targetEnvironment)
		 	)
		return candBindings.toSet
	}

	
	
}