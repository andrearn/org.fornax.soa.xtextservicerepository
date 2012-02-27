package org.fornax.soa.bindingdsl.generator

import com.google.common.base.Predicates
import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.fornax.soa.basedsl.search.IPredicateSearch
import org.fornax.soa.basedsl.search.SearchPattern
import org.fornax.soa.bindingDsl.BindingModel
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingdsl.templates.BindingTemplates
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfileDslPackage
import org.eclipse.xtext.EcoreUtil2
import org.fornax.soa.bindingDsl.DomainBinding
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions
import org.eclipse.xtext.resource.SynchronizedXtextResourceSet
import org.eclipse.xtext.resource.IResourceDescription
import org.fornax.soa.serviceDsl.ServiceModel
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.fornax.soa.servicedsl.templates.xsd.XSDTemplates
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.environmentDsl.EnvironmentDslPackage
import org.fornax.soa.bindingdsl.templates.BindingExtensions
import org.fornax.soa.serviceDsl.SubNamespace

class DefaultBindingDslContractGenerators implements IGenerator {
	
	
	@Inject BindingTemplates bindingTpl
	@Inject BindingExtensions bindingExt
	
	@Inject @Named ("profileName") 			
	String profileName
	
	@Inject @Named ("moduleBindingNames") 	
	List<String> moduleBindingNames
	
	@Inject @Named ("domainBindingNames") 	
	List<String> domainBindingNames
	
	@Inject @Named ("namespaces") 			
	List<String> namespaces
	
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
	
	override void doGenerate (Resource resource, IFileSystemAccess fsa) {
		var contentRoot = resource.contents.head;
		var resourceSet = resource.resourceSet;
		resourceDescriptions.setContext (resourceSet);
		
		if (contentRoot instanceof BindingModel) {
			var model = resource.contents.head as BindingModel;
			var profileDescriptions = searchEngine.search (profileName, SearchPattern::RULE_EXACT_MATCH, 
				SOAProfileDslPackage::eINSTANCE.SOAProfile.name, Predicates::alwaysTrue
			);
			var profile = EcoreUtil2::resolve (profileDescriptions.head.EObjectOrProxy, resource.resourceSet) as SOAProfile;
			for (binding : model.bindings) {
				if (binding instanceof ModuleBinding) {
					compile (binding as ModuleBinding, profile);
				} else if (binding instanceof DomainBinding) {
					compile (binding as DomainBinding, profile);
				}
			}
		}
		
		if  (contentRoot instanceof ServiceModel) {
			val svcModel = contentRoot as ServiceModel;
			for (ns : svcModel.orgNamespaces.map (ons | ons.subNamespaces).flatten) {
				if (namespaces.contains (nameProvider.getFullyQualifiedName (ns).toString)) {
					compile (ns as SubNamespace, resource); 
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
	
	def protected compile (SubNamespace namespace, Resource resource) {
		val profileDescriptions = searchEngine.search (profileName, SearchPattern::RULE_EXACT_MATCH, 
			SOAProfileDslPackage::eINSTANCE.SOAProfile.name, Predicates::alwaysTrue
		);
		val profile = EcoreUtil2::resolve (profileDescriptions.head.EObjectOrProxy, resource.resourceSet) as SOAProfile;
		val envDescriptions = searchEngine.search (targetEnvironmentName, SearchPattern::RULE_EXACT_MATCH, 
			EnvironmentDslPackage::eINSTANCE.environment.name, Predicates::alwaysTrue
		);
		var env = EcoreUtil2::resolve (profileDescriptions.head.EObjectOrProxy, resource.resourceSet) as Environment;
		
		if (env != null && profile != null) {
			bindingTpl.toXSD (namespace, env, profile);
		}
	}
}