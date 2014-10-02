package org.xkonnex.repo.generator.profiledsl

import org.eclipse.xtext.generator.IGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.SOAProfile
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.SOAProfileModel
import com.google.inject.name.Named
import com.google.inject.Inject
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions
import org.xkonnex.repo.generator.profiledsl.templates.MessageHeaderXSDTemplates
import java.util.regex.Pattern

class DefaultProfileContractsGenerator implements IGenerator {
	
	@Inject @Named ("profileName")
	String profileName

	@Inject
	ResourceSetBasedResourceDescriptions resourceDescriptions
	
	@Inject MessageHeaderXSDTemplates msgHeaderTpl
	
	override void doGenerate (Resource resource, IFileSystemAccess fsa) {
		var resourceSet = resource.resourceSet;
		resourceDescriptions.setContext (resourceSet);
		
		val contentRoot = resource.contents.head;
		if (contentRoot instanceof SOAProfileModel) {
			val profileModel = contentRoot as SOAProfileModel;
			profileModel.profiles.filter (p|Pattern::matches (profileName, p.name)).forEach (e|e.compile (resource));
		}
	}
	
	def protected void compile (SOAProfile profile, Resource res) {
		msgHeaderTpl.toMessageHeaderXSD (profile);
	}

}