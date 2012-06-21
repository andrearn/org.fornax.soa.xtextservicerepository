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
import org.fornax.soa.bindingDsl.DomainBinding
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions
import org.fornax.soa.bindingdsl.generator.templates.BindingBuilder
import org.fornax.soa.bindingdsl.generator.templates.xsd.XSDTemplates
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
	
	
	@Inject org.fornax.soa.bindingdsl.generator.templates.BindingBuilder bindingTpl
	@Inject org.fornax.soa.bindingdsl.generator.templates.xsd.XSDTemplates xsdGen

	@Inject BindingExtensions bindingExt
	
	@Inject @Named ("profileName") 			
	String profileName
	
	@Inject @Named ("moduleBindingNames") 	
	List<String> moduleBindingNames

	@Inject @Named ("moduleNames") 	
	List<String> moduleNames
	
	@Inject @Named ("domainBindingNames") 	
	List<String> domainBindingNames
	
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
			logger.severe ("No profileName has been supplied to the Generator. Please proved the name an architecture profile to be applied.")
			hasValidParameters = false
		}
		val SOAProfile profile = eObjectLookup.getModelElementByName (profileName, resource, "SOAProfile");
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
							&& Pattern::matches (targetEnvironmentName, modBind.environment.name)
						) {
							compile (modBind, profile);
						}
					} else if (binding instanceof DomainBinding) {
						val domBind = binding as DomainBinding;
						if (domainBindingNames.exists (domBindName | Pattern::matches(domBindName, domBind.name))
							&& Pattern::matches (targetEnvironmentName, domBind.environment.name)
						) {
							compile (domBind, profile);
						}
					}
				}
			}
			
			if (contentRoot instanceof ModuleModel) {
				val modModel = contentRoot as ModuleModel
				for (module : modModel.modules) {
					if (moduleNames.exists(modName | Pattern::matches (modName, nameProvider.getFullyQualifiedName (module).toString))) {
						module.compile (profile, resource)
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
		if (noDependencies != null && includeSubNamespaces != null)
			bindingTpl.toBinding (bind, profile, noDependencies, includeSubNamespaces)
		else
			bindingTpl.toBinding (bind, profile);
	}
	
	def protected compile (DomainBinding bind, SOAProfile profile) {
		bindingTpl.toBinding (bind, profile);
	}
	
	def protected compile (Module mod, SOAProfile profile, Resource resource) {
		val Environment env = eObjectLookup.getModelElementByName (targetEnvironmentName, resource, "Environment");
		if (env != null)
			bindingTpl.toBinding(mod, env, profile)
		else
			logger.severe ("No environment found matching the name expression " + targetEnvironmentName)
	}
	
	def protected compile (SubNamespace namespace, Resource resource) {
		val SOAProfile profile = eObjectLookup.getModelElementByName (profileName, resource, "SOAProfile");
		val Environment env = eObjectLookup.getModelElementByName (targetEnvironmentName, resource, "Environment");
		if (env == null)
			logger.severe ("No environment found mathcing the name expression " + targetEnvironmentName)
		if (profile == null)
			logger.severe ("No architecture profile found matching the name " + profileName)
		
		if (env != null && profile != null) {
			xsdGen.toXSD (namespace, env, profile);
		}
	}
}