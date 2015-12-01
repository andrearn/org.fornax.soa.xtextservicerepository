package org.xkonnex.repo.dsl.servicedsl.test.query

import com.google.inject.Inject
import com.google.inject.Injector
import java.util.List
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.xkonnex.repo.core.resource.XKonneXReader
import org.xkonnex.repo.core.validation.ModelIssues
import org.xkonnex.repo.dsl.basedsl.resource.IEObjectDescriptionBuilder
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup
import org.xkonnex.repo.dsl.basedsl.util.TreeNode
import org.xkonnex.repo.dsl.servicedsl.service.query.type.DataObjectQueries
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.BusinessObject
import org.xkonnex.repo.dsl.servicedsl.test.ServiceDslWithDependenciesInjector

import static org.junit.Assert.*

@RunWith(XtextRunner) 
@InjectWith(ServiceDslWithDependenciesInjector) 
class ModelBusinessObjectQueryTest {
	@Inject 
	DataObjectQueries boQuery
	@Inject 
	IQualifiedNameProvider nameProvider
	@Inject 
	package IEObjectDescriptionBuilder descriptionBuilder
	@Inject 
	package IEObjectLookup eObjectLookup
	@Inject 
	Injector injector
	@Inject 
	private ResourceSetBasedResourceDescriptions descriptions

	@Before 
	def void setUp() throws Exception {
	}

	@Test 
	def void testGetAllSubtypes() {
		val reader = injector.getInstance(typeof(XKonneXReader))
		val modelIssues = new ModelIssues
		val List<String> pathes = newArrayList("model/withShortNames")
		val resourceSet = reader.read(pathes, modelIssues)
		descriptions.setContext(resourceSet);
		descriptions.setRegistry(IResourceServiceProvider.Registry.INSTANCE);
		val bo = resourceSet.allContents.toIterable.filter(typeof(BusinessObject)).findFirst [
			name.equals("AbstractAddress")
		]
		val List<TreeNode<IEObjectDescription>> allSubTypes = boQuery.getAllSubTypes(bo, resourceSet);
		assertEquals(2, allSubTypes.size());
		var int subTypeCount = 0;
		for (TreeNode<IEObjectDescription> node : allSubTypes) {
			if (node.getElement().getName().getLastSegment().equals("StreetAddress")) {
				subTypeCount++;
				var List<TreeNode<IEObjectDescription>> subSubTypes = node.getChildren();
				assertEquals(1, subSubTypes.size());
				assertEquals("ExtStreetAddress", subSubTypes.get(0).getElement().getName().getLastSegment());
			}
			if (node.getElement().getName().getLastSegment().equals("POBoxAddress"))
				subTypeCount++;
		}
		assertEquals(2, subTypeCount);
	}

}
