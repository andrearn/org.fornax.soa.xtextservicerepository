package org.xkonnex.repo.generator.profiledsl.test.schema

import org.xkonnex.repo.dsl.profiledsl.test.AbstractModelBasedProfileTests
import org.junit.Before
import org.xkonnex.repo.generator.profiledsl.schema.ProfileSchemaNamespaceExtensions
import org.xkonnex.repo.dsl.profiledsl.profileDsl.TechnicalNamespace
import org.junit.Test
import org.xkonnex.repo.dsl.profiledsl.versioning.VersionedTechnicalNamespace

class ProfileSchemaNamespaceExtensionsTest extends AbstractModelBasedProfileTests {
	
	@Before
	override setUp() throws Exception {
		super.setUp()
	}
	
	@Test
	def void testToPrefix() {
		val rs = readModel("model/noShortNames")
		val ns = rs.allContents.toIterable.filter(TechnicalNamespace).get(0)
		val schemaNsExt = get(ProfileSchemaNamespaceExtensions)
		val nsPrefix = schemaNsExt.toPrefix(ns)
		assertEquals("oes", nsPrefix)
		val vns = new VersionedTechnicalNamespace
		vns.namespace = ns
		vns.version = "2"
		val vnsPrefix = schemaNsExt.toPrefix(ns)
		assertEquals("oes", vnsPrefix)
	}
	
}