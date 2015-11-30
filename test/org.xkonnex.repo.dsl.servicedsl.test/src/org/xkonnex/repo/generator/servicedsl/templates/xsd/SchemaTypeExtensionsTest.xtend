package org.xkonnex.repo.generator.servicedsl.templates.xsd

import org.junit.Before
import org.junit.Test
import org.xkonnex.repo.dsl.profiledsl.profileDsl.MessageHeader
import org.xkonnex.repo.dsl.servicedsl.test.AbstractModelBasedServiceTests

class SchemaTypeExtensionsTest extends AbstractModelBasedServiceTests {
		
	@Before
	override setUp() throws Exception {
		super.setUp
	}
	
	@Test
	def void testToTypeNameRef () {
		val resourceSet = readModel("model/noShortNames");
		val SchemaTypeExtensions schemaTypeExtensions = get(SchemaTypeExtensions)
		val msgCtxParam = resourceSet.allContents.toIterable.filter(typeof(MessageHeader)).map[parameters].flatten.findFirst[name == "msgCtx"]
		val ref = schemaTypeExtensions.toTypeNameRef(msgCtxParam.type)
		assertEquals("oes1:ServiceMessageContext", ref)
	}
	
	
}