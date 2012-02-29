package org.fornax.soa.bindingdsl.generator.sca

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.fornax.soa.bindingdsl.templates.BindingTemplates
import com.google.inject.Inject
import org.fornax.soa.bindingdsl.templates.BindingExtensions
import com.google.inject.name.Named
import org.fornax.soa.basedsl.search.IPredicateSearch
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions
import org.eclipse.xtext.naming.IQualifiedNameProvider
import java.util.List
import org.fornax.soa.serviceDsl.ServiceModel
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.bindingdsl.templates.vendor.ibm.SCAExportTemplates
import org.fornax.soa.bindingdsl.templates.vendor.ibm.SCAExportExtension
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingDsl.BindingModel
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.basedsl.search.IEObjectLookup
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.moduledsl.moduleDsl.AssemblyType

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
	
	override void doGenerate (Resource resource, IFileSystemAccess fsa) {
		var resourceSet = resource.resourceSet;
		resourceDescriptions.setContext (resourceSet);

		val contentRoot = resource.contents.head;
		if (contentRoot instanceof BindingModel) {
			var model = resource.contents.head as BindingModel;
			for (binding : model.bindings) {
				if (binding instanceof ModuleBinding) {
					val modBind = binding as ModuleBinding;
					val module = modBind.module.module
					val assemblyType = module.assemblyType
					if (moduleBindingNames.contains (modBind.name) && assemblyType == AssemblyType::SCA_EAR) {
						compile (modBind, resource);
					
					}
				}
			}
		}
	}
	
	def protected dispatch compile (ModuleBinding binding, Resource res) {
		val SOAProfile profile = eObjectLookup.getModelElementByName (profileName, res, "SOAProfile");
		scaExportTpl.toSCAModuleExport (binding, profile);
	}
}