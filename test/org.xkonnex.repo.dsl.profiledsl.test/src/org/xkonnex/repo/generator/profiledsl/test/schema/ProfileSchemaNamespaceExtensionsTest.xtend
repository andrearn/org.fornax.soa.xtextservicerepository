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
	
	@Test
	def void testFindOrgNamespace() {
		val rs = readModel("model/noOrg")
		val ns = rs.allContents.toIterable.filter(TechnicalNamespace).get(0)
		val schemaNsExt = get(ProfileSchemaNamespaceExtensions)
		val orgNs = schemaNsExt.findOrgNamespace(ns)
		assertNull(orgNs)

		val rs2 = readModel("model/noShortNames")
		val ns2 = rs2.allContents.toIterable.filter(TechnicalNamespace).get(0)
		val orgNs2 = schemaNsExt.findOrgNamespace(ns2)
		assertNotNull(orgNs2)
		assertEquals("org.example", orgNs2.name)
	}
	
	@Test
	def void testShorten() {
		val rs = readModel("model/noOrg")
		val schemaNsExt = get(ProfileSchemaNamespaceExtensions)

		val ns = rs.allContents.toIterable.filter(TechnicalNamespace).get(0)
		val shortName = schemaNsExt.shorten(ns)
		assertNotNull(shortName)
		assertEquals("ex", shortName)
	}
	
	@Test
	def void testToFilenameFragment() {
		val rs = readModel("model/noOrg")
		val ns = rs.allContents.toIterable.filter(TechnicalNamespace).get(0)
		val schemaNsExt = get(ProfileSchemaNamespaceExtensions)
		val vns = new VersionedTechnicalNamespace
		vns.namespace = ns
		vns.version = "1"
		val filename = schemaNsExt.toFileNameFragment(vns)
		assertNotNull(filename)
		assertEquals("ex-soa-v1", filename)

		val rs2 = readModel("model/noShortNames")
		val ns2 = rs2.allContents.toIterable.filter(TechnicalNamespace).get(0)
		val vns2 =new VersionedTechnicalNamespace
		vns2.namespace = ns2
		vns2.version = "1"
		val filename2 = schemaNsExt.toFileNameFragment(vns2)
		assertNotNull(filename2)
		assertEquals("ex-soa-v1", filename2)
	}
	
}