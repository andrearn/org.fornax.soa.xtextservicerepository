package org.xkonnex.repo.generator.profiledsl.test.schema

import org.xkonnex.repo.dsl.profiledsl.test.AbstractModelBasedProfileTests
import org.junit.Before
import org.junit.Test
import org.xkonnex.repo.dsl.profiledsl.profileDsl.MessageHeader
import org.xkonnex.repo.generator.profiledsl.schema.ProfileSchemaTypeExtensions
import org.xkonnex.repo.dsl.profiledsl.profileDsl.TechnicalNamespace
import org.xkonnex.repo.dsl.profiledsl.versioning.VersionedTechnicalNamespace
import org.xkonnex.repo.dsl.profiledsl.profileDsl.ProfileDslFactory
import org.xkonnex.repo.dsl.basedsl.baseDsl.BaseDslFactory

class ProfileSchemaTypeExtensionsTest extends AbstractModelBasedProfileTests {
	
	@Before
	override setUp() throws Exception {
		super.setUp()
	}
	
	@Test
	def void testToTypeNameRef() {
		val rs = readModel("model/noShortNames")
		val header = rs.allContents.toIterable.filter(MessageHeader).get(0)
		val typeExt = get(ProfileSchemaTypeExtensions)
		val ns = rs.allContents.toIterable.filter(TechnicalNamespace).get(0)
		val vns = new VersionedTechnicalNamespace
		vns.namespace = ns
		vns.version = "1"
		val ref = typeExt.toTypeNameRef(header.parameters.findFirst[name=="msgCtx"].type, vns)
		assertEquals("tns:ServiceMessageContext", ref)
	}
	
	@Test
	def void testToFullTypeNameRef() {
		val rs = readModel("model/noShortNames")
		val header = rs.allContents.toIterable.filter(MessageHeader).get(0)
		val typeExt = get(ProfileSchemaTypeExtensions)
		val typeRef = header.parameters.findFirst[name=="msgCtx"].type
		val ref = typeExt.toFullTypeNameRef(typeRef)
		assertEquals("http://example.org/soa/v1/ServiceMessageContext", ref)
	}
	
	@Test
	def void testIsMany() {
		val typeExt = get(ProfileSchemaTypeExtensions)
		val verTypeRef = ProfileDslFactory.eINSTANCE.createVersionedTypeRef
		val class = ProfileDslFactory.eINSTANCE.createClass
		class.name = "TestClass"
		class.version = BaseDslFactory.eINSTANCE.createVersion
		class.version.version = "2.1"
		verTypeRef.many = true
		verTypeRef.type = class		
		assertTrue(typeExt.isMany(verTypeRef))
		
		val verTypeRef2 = ProfileDslFactory.eINSTANCE.createVersionedTypeRef
		val class2 = ProfileDslFactory.eINSTANCE.createClass
		class2.name = "TestClass"
		class2.version = BaseDslFactory.eINSTANCE.createVersion
		class2.version.version = "2.1"
		verTypeRef2.many = false
		verTypeRef2.type = class2		
		assertFalse(typeExt.isMany(verTypeRef2))
	}
		
}