package org.fornax.soa.bindingdsl.generator

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.List
import java.util.regex.Pattern
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions
import org.fornax.soa.basedsl.search.IEObjectLookup
import org.fornax.soa.basedsl.search.IPredicateSearch
import org.fornax.soa.bindingDsl.BindingModel
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions
import org.fornax.soa.bindingdsl.generator.templates.TechnicalContractArtifactsBuilder
import org.fornax.soa.bindingdsl.generator.templates.xsd.XSDBuilder
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.serviceDsl.ServiceModel
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.serviceDsl.InternalNamespace
import org.fornax.soa.serviceDsl.DomainNamespace
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.moduledsl.moduleDsl.ModuleModel
import java.util.logging.Logger
import java.util.logging.Level
import org.fornax.soa.moduledsl.generator.VersionedModuleSelector
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver
import org.fornax.soa.moduledsl.moduleDsl.ModuleDslFactory
import org.fornax.soa.semanticsDsl.Qualifier
import org.fornax.soa.bindingdsl.generator.templates.IArtifactBuilder

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
		if (profileName == null || "".equals(profileName)) {
			logger.severe ("No profileName has been supplied to the Generator. Please provide the name an architecture profile to be applied.")
			hasValidParameters = false
		}
		var SOAProfile profile = eObjectLookup.getModelElementByName (profileName, resource, "SOAProfile");
		if (profile == null) {
			logger.severe ("No profile found mathing the name " + profileName)
			hasValidParameters = false
		}
		if (hasValidParameters) {
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
				val modModel = contentRoot as ModuleModel
				for (module : modModel.modules) {
					if (modules.exists(mod | mod.matches(module, nameProvider))) {
						val moduleSelector = modules.findFirst(modSel | modSel.matches(module, nameProvider))
						module.compile (moduleSelector, profile, resource)
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
	
	
	def protected compile (ModuleBinding bind, SOAProfile profile) {
		logger.info("Generating contracts for module binding " + bind.name)
		if (noDependencies != null && includeSubNamespaces != null)
			bindingBuilder.build (bind, profile, noDependencies, includeSubNamespaces)
		else
			bindingBuilder.build (bind, profile);
	}
		
	def protected compile (Module mod, VersionedModuleSelector moduleSelector, SOAProfile profile, Resource resource) {
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
					bindingBuilder.build(mod, env, generateProvidedServices, generateUsedServices, endpointQualifierRef, profile)
				} else {
					logger.severe("The provider endpoint-qualifier " + moduleSelector.endpointQualifier + " is not defined.")
				}
			
			} else {
				bindingBuilder.build(mod, env, generateProvidedServices, generateUsedServices, null, profile)
			}
			
		} else {
			logger.severe ("No environment found matching the name expression " + targetEnvironmentName)
		}
	}
	
	def protected compile (SubNamespace namespace, Resource resource) {
		val SOAProfile profile = eObjectLookup.getModelElementByName (profileName, resource, "SOAProfile");
		val Environment env = eObjectLookup.getModelElementByName (targetEnvironmentName, resource, "Environment");
		if (env == null)
			logger.severe ("No environment found matching the name expression " + targetEnvironmentName)
		if (profile == null)
			logger.severe ("No architecture profile found matching the name " + profileName)
		
		if (env != null && profile != null) {
			logger.info ("Generating XSDs for namespace " + nameProvider.getFullyQualifiedName(namespace).toString)
			xsdGen.toXSD (namespace, env, profile);
		}
	}
}