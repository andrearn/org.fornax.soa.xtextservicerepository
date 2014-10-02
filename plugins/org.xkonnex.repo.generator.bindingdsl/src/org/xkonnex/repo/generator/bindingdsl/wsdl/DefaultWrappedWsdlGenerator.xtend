package org.xkonnex.repo.generator.bindingdsl.wsdl

import org.eclipse.xtext.generator.IGenerator
import com.google.inject.Inject
import org.xkonnex.repo.generator.bindingdsl.templates.wsdl.WrappedWSDLBuilder
import org.xkonnex.repo.generator.bindingdsl.templates.BindingExtensions
import com.google.inject.name.Named
import java.util.List
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceModel
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.SOAProfile
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.SOAProfileDslFactory
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment
import java.util.regex.Pattern
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DomainNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.InternalNamespace
import java.util.logging.Logger
import org.xkonnex.repo.dsl.profiledsl.query.ProfileQueries

class DefaultWrappedWsdlGenerator implements IGenerator {

	@Inject WrappedWSDLBuilder wsdlTpl
	
	@Inject BindingExtensions bindingExt
	
	@Inject @Named ("profileName") 			
	String profileName
	
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
	@Inject	ProfileQueries profileQueries
	
	@Inject 
	private Logger logger
	
	override void doGenerate (Resource resource, IFileSystemAccess fsa) {
		var resourceSet = resource.resourceSet;
		resourceDescriptions.setContext (resourceSet);

		var hasValidParameters = true
		if (targetEnvironmentName == null || "".equals(targetEnvironmentName)) {
			logger.severe("No targetEnvironmentName has been supplied to the Generator. Please provide the name of the environment to generate contracts for.")
			hasValidParameters = false
		}
		val SOAProfile profile = profileQueries.getProfileByName(profileName, resourceSet);
		if (profile != null) {
			logger.info ("Enforcing generation with profile " + profile.name)
			hasValidParameters = hasValidParameters && true
		}

		if (hasValidParameters) {
			val contentRoot = resource.contents.head;
			if (contentRoot instanceof ServiceModel) {
				val svcModel = contentRoot as ServiceModel;
				val Iterable<? extends SubNamespace> subNamespaces = svcModel.orgNamespaces.map (ons | ons.subNamespaces).flatten;
				for (ns : subNamespaces) {
					for (nsName : namespaces) {
						if (Pattern::matches (nsName, nameProvider.getFullyQualifiedName (ns).toString)) {
							compile (ns as SubNamespace, resource); 
						}
					}
				}
				for (ns : subNamespaces.filter (typeof (DomainNamespace))) {
					for (nsName : domainNamespaces) {
						if (Pattern::matches (nsName, nameProvider.getFullyQualifiedName (ns).toString)) {
							compile (ns as SubNamespace, resource); 
						}
					}
				}
				for (ns : subNamespaces.filter (typeof (InternalNamespace))) {
					for (nsName : internalNamespaces) {
						if (Pattern::matches (nsName, nameProvider.getFullyQualifiedName (ns).toString)) {
							compile (ns as SubNamespace, resource); 
						}
					}
				}
			}
		}
	}
	
	def protected dispatch compile (SubNamespace namespace, Resource res) {
		val SOAProfile profile = eObjectLookup.getModelElementByName (profileName, res, "SOAProfile");
		val Environment env = eObjectLookup.getModelElementByName (targetEnvironmentName, res, "Environment");
		wsdlTpl.toWrappedWSDL(namespace, profile, env);
	}
}