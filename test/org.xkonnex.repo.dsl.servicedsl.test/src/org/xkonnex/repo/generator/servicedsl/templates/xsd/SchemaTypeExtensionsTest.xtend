package org.xkonnex.repo.generator.servicedsl.templates.xsd

import org.junit.Before
import org.junit.Test
import org.xkonnex.repo.dsl.profiledsl.profileDsl.MessageHeader
import org.xkonnex.repo.dsl.servicedsl.test.AbstractModelBasedServiceTests
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DomainNamespace
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.BusinessObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceDslFactory
import org.xkonnex.repo.dsl.basedsl.baseDsl.BaseDslFactory
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedTypeRef

class SchemaTypeExtensionsTest extends AbstractModelBasedServiceTests {
		
	@Before
	override setUp() throws Exception {
		super.setUp
	}
	
	@Test
	def void testToTypeNameRef () {
		val rs = readModel("model/noShortNames");
		val typeExt = get(SchemaTypeExtensions)
		val msgCtxParam = rs.allContents.toIterable.filter(typeof(MessageHeader)).map[parameters].flatten.findFirst[name == "msgCtx"]
		val ref = typeExt.toTypeNameRef(msgCtxParam.type)
		assertEquals("oes1:ServiceMessageContext", ref)

		val ns = rs.allContents.toIterable.filter(DomainNamespace).findFirst[name == "samples"]
		val person = rs.allContents.toIterable.filter(BusinessObject).findFirst[name == "Person" && version.version == "1.0"]
		val personV2 = rs.allContents.toIterable.filter(BusinessObject).findFirst[name == "Person" && version.version == "2.0"]
		val addressProp = person.properties.findFirst[name == "address"]
		val otherProp = person.properties.findFirst[name == "other"]
		val vns = new VersionedDomainNamespace
		vns.namespace = ns
		vns.version = "1"
		
		val addrRef = typeExt.toTypeNameRef(addressProp.type, vns)
		val otherRef = typeExt.toTypeNameRef(otherProp.type, vns)
		
		assertEquals("tns:AbstractAddress", addrRef)
		assertEquals("oxo1:Other", otherRef)

		val vns2 = new VersionedDomainNamespace
		vns2.namespace = ns
		vns2.version = "2"
		val addressPropV2 = personV2.properties.findFirst[name == "address"]
		val addrRefV2 = typeExt.toTypeNameRef(addressPropV2.type, vns2)

		assertEquals("oxs1:AbstractAddress", addrRefV2)
	}
		
	@Test
	def void testToFullTypeNameRef() {
		val rs = readModel("model/noShortNames")
		val typeExt = get(SchemaTypeExtensions)
		val ns = rs.allContents.toIterable.filter(DomainNamespace).findFirst[name == "samples"]
		val person = rs.allContents.toIterable.filter(BusinessObject).findFirst[name == "Person" && version.version == "1.0"]
		val addressProp = person.properties.findFirst[name == "address"]
		val otherProp = person.properties.findFirst[name == "other"]
		val vns = new VersionedDomainNamespace
		vns.namespace = ns
		vns.version = "1"
		
		val addrRef = typeExt.toNsPrefixedTypeNameRef(addressProp.type, vns)
		val otherRef = typeExt.toNsPrefixedTypeNameRef(otherProp.type, vns)
		
		assertEquals("http://xkonnex.org/samples/v1/AbstractAddress", addrRef)
		assertEquals("http://xkonnex.org/other/v1/Other", otherRef)
	}
	
	@Test
	def void testIsMany() {
		val typeExt = get(SchemaTypeExtensions)
		val verTypeRef = ServiceDslFactory.eINSTANCE.createVersionedTypeRef
		val bo1 = ServiceDslFactory.eINSTANCE.createBusinessObject
		bo1.name = "TestBO1"
		bo1.version = BaseDslFactory.eINSTANCE.createVersion
		bo1.version.version = "2.1"
		verTypeRef.many = true
		verTypeRef.type = bo1		
		assertTrue(typeExt.isMany(verTypeRef))
		val verTypeRef2 = ServiceDslFactory.eINSTANCE.createVersionedTypeRef
		val bo2 = ServiceDslFactory.eINSTANCE.createBusinessObject
		bo2.name = "TestBO2"
		bo2.version = BaseDslFactory.eINSTANCE.createVersion
		bo2.version.version = "2.1"
		verTypeRef2.many = false
		verTypeRef2.type = bo2		
		assertFalse(typeExt.isMany(verTypeRef2))
	}
	
	
}