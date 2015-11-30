package org.xkonnex.repo.generator.servicedsl.templates.xsd

import org.junit.Before
import org.junit.Test
import org.xkonnex.repo.dsl.profiledsl.profileDsl.TechnicalNamespace
import org.xkonnex.repo.dsl.servicedsl.test.AbstractModelBasedServiceTests

class SchemaNamespaceExtensionsTest extends AbstractModelBasedServiceTests {
	
	@Before
	override setUp() throws Exception {
		super.setUp
	}
	
	@Test
	def void testToTypeNameRef () {
		val resourceSet = readModel("model/noShortNames");
		val SchemaNamespaceExtensions schemaNsExtensions = get(SchemaNamespaceExtensions)
		val ns = resourceSet.allContents.toIterable.filter(typeof(TechnicalNamespace)).get(0)
		val nsPrefix = schemaNsExtensions.toPrefix(ns)
		assertEquals("oes", nsPrefix)
	}
}