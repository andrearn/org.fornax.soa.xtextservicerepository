package org.fornax.soa.bindingdsl.generator

import org.eclipse.xtext.generator.IGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.fornax.soa.bindingdsl.templates.BindingTemplates
import com.google.inject.Inject
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.bindingDsl.ModuleBinding
import org.eclipse.emf.ecore.EObject
import java.util.ArrayList
import com.google.inject.name.Named
import java.util.List

class DefaultBindingDslContractGenerators implements IGenerator {
	
	@Inject BindingTemplates bindingTpl
	
	
	@Named ("profileName") 			String profileName
	@Named ("moduleBindingNames") 	List<String> moduleBindingNames
	@Named ("namespacesNames") 		List<String> namespacesNames
	@Named ("noDependencies") 		Boolean noDependencies
	@Named ("includeSubNamespaces") Boolean includeSubNamespaces
	
	override void doGenerate (Resource input, IFileSystemAccess fsa) {
		var contentIt = input.allContents;
		var bindings = new ArrayList<ModuleBinding>();
		var SOAProfile profile = null;
		while (contentIt.hasNext) {
			val obj = contentIt.next as EObject;
			if (obj instanceof ModuleBinding) {
				bindings.add (obj as ModuleBinding);
			} else if (obj instanceof SOAProfile && (obj as SOAProfile).name == profileName) {
				profile = obj as SOAProfile;
			}
		}
		for (binding : bindings) {
			binding.compile (profile);
		}
	}
	
	def protected compile (ModuleBinding bind, SOAProfile profile) {
		if (noDependencies != null && includeSubNamespaces != null)
			bindingTpl.toBinding (bind, profile, noDependencies, includeSubNamespaces)
		else
			bindingTpl.toBinding (bind, profile);
	}

	
}