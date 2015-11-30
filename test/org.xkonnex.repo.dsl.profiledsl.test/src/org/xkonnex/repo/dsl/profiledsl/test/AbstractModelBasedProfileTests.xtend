package org.xkonnex.repo.dsl.profiledsl.test

import java.util.List
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.junit4.AbstractXtextTests
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions
import org.junit.Before
import org.xkonnex.repo.core.resource.XKonneXReader
import org.xkonnex.repo.core.validation.ModelIssues
import org.xkonnex.repo.dsl.basedsl.BaseDslStandaloneSetup
import org.xkonnex.repo.dsl.environmentdsl.EnvironmentDslStandaloneSetup
import org.xkonnex.repo.dsl.profiledsl.ProfileDslStandaloneSetup
import org.xkonnex.repo.dsl.profiledsl.test.ProfileDslTestSetup

class AbstractModelBasedProfileTests extends AbstractXtextTests {
	
	@Before
	override setUp() throws Exception {
		super.setUp
		with(BaseDslStandaloneSetup)
		with(EnvironmentDslStandaloneSetup)
		with(ProfileDslStandaloneSetup)
		with(ProfileDslTestSetup)
	}
	
	protected def ResourceSet readModel(String modelPath) {
		val reader = get(typeof(XKonneXReader))
		val modelIssues = new ModelIssues
		val List<String> pathes = newArrayList(modelPath)
		val resourceSet = reader.read(pathes, modelIssues)
		val ResourceSetBasedResourceDescriptions descriptions = get(ResourceSetBasedResourceDescriptions)
		descriptions.setContext(resourceSet);
		descriptions.setRegistry(IResourceServiceProvider.Registry.INSTANCE)
		resourceSet
	}
	
}