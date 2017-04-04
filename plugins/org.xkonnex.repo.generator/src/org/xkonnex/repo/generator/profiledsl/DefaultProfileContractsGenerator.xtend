package org.xkonnex.repo.generator.profiledsl

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.regex.Pattern
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile
import org.xkonnex.repo.dsl.profiledsl.profileDsl.ProfileModel
import org.xkonnex.repo.generator.profiledsl.templates.MessageHeaderXSDTemplates

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
		if (contentRoot instanceof ProfileModel) {
			val profileModel = contentRoot as ProfileModel;
			profileModel.profiles.filter (p|Pattern::matches (profileName, p.name)).forEach (e|e.compile (resource));
		}
	}
	
	def protected void compile (Profile profile, Resource res) {
		msgHeaderTpl.toMessageHeaderXSD (profile);
	}

}