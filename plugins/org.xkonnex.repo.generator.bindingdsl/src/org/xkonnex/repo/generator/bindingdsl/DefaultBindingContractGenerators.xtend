package org.xkonnex.repo.generator.bindingdsl

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.List
import java.util.regex.Pattern
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingModel
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.xkonnex.repo.generator.bindingdsl.templates.BindingExtensions
import org.xkonnex.repo.generator.bindingdsl.templates.TechnicalContractArtifactsBuilder
import org.xkonnex.repo.generator.bindingdsl.templates.xsd.XSDBuilder
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.AbstractProfile
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceModel
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.InternalNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DomainNamespace
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleModel
import java.util.logging.Logger
import java.util.logging.Level
import org.xkonnex.repo.generator.moduledsl.VersionedModuleSelector
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.EnvironmentBindingResolver
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ModuleDslFactory
import org.xkonnex.repo.dsl.semanticsdsl.semanticsDsl.Qualifier
import org.xkonnex.repo.generator.bindingdsl.templates.IArtifactBuilder
import org.xkonnex.repo.dsl.moduledsl.query.ModuleLookup
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.IStateMatcher
import org.xkonnex.repo.dsl.profiledsl.query.LifecycleQueriesimport org.xkonnex.repo.dsl.profiledsl.query.ProfileQueries
import org.eclipse.xtext.EcoreUtil2
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Lifecycle
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery

/*
 * Generate technical service and datamodel contract artifacts like WSDLs, XSDs or IDLs for ModuleBindings
 * or DomainBinding filtered by name and selected target environment. For each protocol statet in the Binding,
 * the respective contract artifacts used by services supporting that protocol type are generated. The generation 
 * is delegeted to a builder chain, while each protocol is handled by a certain <code>IProtocolContractBuilder</code><br/><br/>
 * 
 * E.g. SOAP contract artifacts are generated by the SOAPProtocolContractBuilder. Generated artifacts include a
 * concrete WSDL defining the SOAP binding and the service endpoint, an abstract WSDL to define the interface structure
 * and XSDs for the parameter types.
 */
class DefaultBindingContractGenerators implements IGenerator {
	
	
	@Inject extension NamespaceQuery
	@Inject IArtifactBuilder bindingBuilder
	@Inject XSDBuilder xsdGen

	
	@Inject @Named ("profileName")
	String profileName
	
	@Inject @Named ("moduleBindingNames") 	
	List<String> moduleBindingNames
	
	@Inject @Named ("modules")
	List<VersionedModuleSelector> modules
	
	@Inject @Named ("moduleBindings")
	List<ModuleBindingSelector> moduleBindingSelectors
	
	@Inject @Named ("namespaces") 			
	List<String> namespaces
	
	@Inject @Named ("domainNamespaces") 			
	List<String> domainNamespaces
	
	@Inject @Named ("internalNamespaces") 			
	List<String> internalNamespaces
	
	@Inject @Named ("noDependencies") 		
	Boolean noDependencies
	
	@Inject @Named ("includeSubNamespaces") 
	Boolean includeSubNamespaces
	
	@Inject @Named ("targetEnvironmentName")
	String targetEnvironmentName
	
	@Inject 
	IPredicateSearch searchEngine
	@Inject
	ModuleLookup modLookup
	@Inject
	IStateMatcher stateMatcher
	@Inject
	LifecycleQueries lifecycleQueries
	@Inject
	ProfileQueries profileQueries
	
	@Inject
	ResourceSetBasedResourceDescriptions resourceDescriptions
	
	@Inject IQualifiedNameProvider nameProvider
	@Inject IEObjectLookup eObjectLookup
	
	@Inject Logger logger
	@Inject extension EnvironmentBindingResolver		
	
	override void doGenerate (Resource resource, IFileSystemAccess fsa) {
		var contentRoot = resource.contents.head;
		var resourceSet = resource.resourceSet;
		resourceDescriptions.setContext (resourceSet);
		
		var hasValidParameters = true
		
		if (targetEnvironmentName == null || "".equals(targetEnvironmentName)) {
			logger.severe ("No targetEnvironmentName has been supplied to the Generator. Please provide the name of the environment to generate contracts for.")
			hasValidParameters = false
		}
		val AbstractProfile profile = profileQueries.getProfileByName(profileName, resourceSet)
		if (profile != null) {
			logger.info ("Enforcing generation with profile " + profile.name)
			hasValidParameters = hasValidParameters && true
		}
		if (hasValidParameters) {
			val Environment env = eObjectLookup.getModelElementByName (targetEnvironmentName, resource, "Environment");
			if (contentRoot instanceof BindingModel) {
				var model = resource.contents.head as BindingModel;
				for (binding : model.bindings) {
					if (binding instanceof ModuleBinding) {
						val modBind = binding as ModuleBinding;
						if (moduleBindingNames.exists (modBindName | Pattern::matches (modBindName, modBind.name)) 
							&& Pattern::matches (targetEnvironmentName, modBind.resolveEnvironment.name)
						) {
							compile (modBind, profile);
						}
						for (modBindingSelector : moduleBindingSelectors) {
							if (modBindingSelector.matches(modBind, nameProvider)) {
								compile (modBind, profile);
							}
						}
					}
				}
			}
			
			if (contentRoot instanceof ModuleModel) {
				var modModel = contentRoot as ModuleModel
				if (modModel.eIsProxy) {
					modModel = EcoreUtil2::resolve(modModel, resourceSet) as ModuleModel
				}
				if (!modModel.modules.empty) {
					val moduleLifecycle = modModel.modules.head.state.eContainer as Lifecycle
					val minState = lifecycleQueries.getMinLifecycleState(env, moduleLifecycle)
					for (module : modModel.modules) {
						if (modules.exists(mod | mod.matches(module, minState, modLookup, stateMatcher, nameProvider))) {
							val moduleSelector = modules.findFirst(modSel | modSel.matches(module, minState, modLookup, stateMatcher, nameProvider))
							module.compile (moduleSelector, profile, resource)
						}
					}
				}
			}
			
			if  (contentRoot instanceof ServiceModel) {
				val svcModel = contentRoot as ServiceModel;
				val Iterable<? extends SubNamespace> subNamespaces = svcModel.orgNamespaces.map (ons | ons.subNamespaces).flatten;
				for (ns : subNamespaces) {
					if (namespaces.exists (nsName | Pattern::matches (nsName, nameProvider.getFullyQualifiedName (ns).toString))) {
						compile (ns as SubNamespace, resource); 
					}
					if (ns instanceof DomainNamespace && domainNamespaces.exists (nsName | Pattern::matches (nsName, nameProvider.getFullyQualifiedName (ns).toString))) {
						compile (ns as SubNamespace, resource); 
					}
					if (ns instanceof InternalNamespace && internalNamespaces.exists (nsName | Pattern::matches (nsName, nameProvider.getFullyQualifiedName (ns).toString))) {
						compile (ns as SubNamespace, resource); 
					}
				}
			}
		}
	}
	
	
	def protected compile (ModuleBinding bind, AbstractProfile profile) {
		logger.info("Generating contracts for module binding " + bind.name)
		if (noDependencies != null && includeSubNamespaces != null)
			bindingBuilder.build (bind, profile, noDependencies, includeSubNamespaces)
		else
			bindingBuilder.build (bind, profile);
	}
		
	def protected compile (Module mod, VersionedModuleSelector moduleSelector, AbstractProfile enforcedProfile, Resource resource) {
		logger.info("Generating contracts for module " + mod.name + " version " + mod.version.version)
		val Environment env = eObjectLookup.getModelElementByName (targetEnvironmentName, resource, "Environment");
		var generateProvidedServices = moduleSelector.generateProvidedServices
		var generateUsedServices = moduleSelector.generateUsedServices
		if (!generateProvidedServices && !generateUsedServices)
			generateUsedServices = true
		if (env != null) {
			if (moduleSelector.endpointQualifier != null) {
				val endpointQualifierRef =  ModuleDslFactory::eINSTANCE.createEndpointQualifierRef
				val Qualifier endpointQualifier = eObjectLookup.getModelElementByName(moduleSelector.endpointQualifier, resource, "Qualifier")
				if (endpointQualifierRef != null) {
					endpointQualifierRef.setEndpointQualifier(endpointQualifier)
					bindingBuilder.build(mod, env, moduleSelector.selectTypeVersionsByEnvironment, generateProvidedServices, generateUsedServices, endpointQualifierRef, enforcedProfile)
				} else {
					logger.severe("The provider endpoint-qualifier " + moduleSelector.endpointQualifier + " is not defined.")
				}
			
			} else {
				bindingBuilder.build(mod, env, moduleSelector.selectTypeVersionsByEnvironment, generateProvidedServices, generateUsedServices, null, enforcedProfile)
			}
			
		} else {
			logger.severe ("No environment found matching the name expression " + targetEnvironmentName)
		}
	}
	
	def protected compile (SubNamespace namespace, Resource resource) {
		val AbstractProfile profile = namespace.getApplicableProfile(profileQueries.getProfileByName(profileName, resource.resourceSet))
		val Environment env = eObjectLookup.getModelElementByName (targetEnvironmentName, resource, "Environment");
		if (env == null)
			logger.severe ("No environment found matching the name expression " + targetEnvironmentName)
		if (profile == null)
			logger.severe ("No applicable architecture profile found")
		
		if (env != null && profile != null) {
			logger.info ("Generating XSDs for namespace " + nameProvider.getFullyQualifiedName(namespace).toString)
			xsdGen.toXSD (namespace, env, profile);
		}
	}
}