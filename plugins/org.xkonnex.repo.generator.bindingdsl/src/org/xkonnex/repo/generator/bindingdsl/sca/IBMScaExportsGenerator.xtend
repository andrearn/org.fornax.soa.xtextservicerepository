package org.xkonnex.repo.generator.bindingdsl.sca

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.xkonnex.repo.generator.bindingdsl.templates.TechnicalContractArtifactsBuilder
import com.google.inject.Inject
import org.xkonnex.repo.generator.bindingdsl.templates.BindingExtensions
import com.google.inject.name.Named
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions
import org.eclipse.xtext.naming.IQualifiedNameProvider
import java.util.List
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceModel
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.generator.bindingdsl.templates.vendor.ibm.SCAExportTemplates
import org.xkonnex.repo.generator.bindingdsl.templates.vendor.ibm.SCAExportExtension
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingModel
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.AbstractProfile
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.AssemblyType
import java.util.regex.Pattern
import java.util.logging.Logger
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.EnvironmentBindingResolver
import org.xkonnex.repo.dsl.profiledsl.query.ProfileQueries

class IBMScaExportsGenerator implements IGenerator {
	
	@Inject SCAExportTemplates scaExportTpl
	@Inject SCAExportExtension scaExportExt
	
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
	@Inject IEObjectLookup eObjectLookup
	@Inject ProfileQueries profileQueries
	@Inject extension EnvironmentBindingResolver		

	@Inject 
	private Logger logger
	
	override void doGenerate (Resource resource, IFileSystemAccess fsa) {
		var resourceSet = resource.resourceSet;
		resourceDescriptions.setContext (resourceSet);

		var hasValidParameters = true
		
		if (targetEnvironmentName == null || "".equals(targetEnvironmentName)) {
			logger.severe ("No targetEnvironmentName has been supplied to the Generator. Please provide the name of the environment to generate contracts for.")
			hasValidParameters = false
		}
		val AbstractProfile profile = profileQueries.getProfileByName(profileName, resourceSet);
		if (profile != null) {
			logger.info ("Enforcing generation with profile " + profile.name)
			hasValidParameters = hasValidParameters && true
		}

		val contentRoot = resource.contents.head;
		if (contentRoot instanceof BindingModel) {
			var model = resource.contents.head as BindingModel;
			for (binding : model.bindings) {
				if (binding instanceof ModuleBinding) {
					val modBind = binding as ModuleBinding;
					val module = modBind.module.module
					val assemblyType = module.assemblyType
					if ((Pattern::matches (targetEnvironmentName, modBind.resolveEnvironment.name))
							&& assemblyType == AssemblyType::SCA_EAR
					) {
						if (moduleBindingNames.exists(bindName | Pattern::matches (bindName, modBind.name) )) {
							compile (modBind, resource);
						}
					}
				}
			}
		}
	}
	
	def protected dispatch compile (ModuleBinding binding, Resource res) {
		val AbstractProfile profile = eObjectLookup.getModelElementByName (profileName, res, "AbstractProfile");
		scaExportTpl.toSCAModuleExport (binding, profile);
	}
}