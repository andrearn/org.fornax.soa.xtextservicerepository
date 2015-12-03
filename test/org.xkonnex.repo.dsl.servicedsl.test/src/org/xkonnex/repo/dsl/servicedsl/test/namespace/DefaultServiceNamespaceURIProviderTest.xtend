package org.xkonnex.repo.dsl.servicedsl.test.namespace

import org.junit.Before
import org.junit.Test
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace
import org.xkonnex.repo.dsl.servicedsl.service.namespace.DefaultServiceNamespaceUriProvider
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DomainNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.OrganizationNamespace
import org.xkonnex.repo.dsl.servicedsl.test.AbstractModelBasedServiceTests

class DefaultServiceNamespaceURIProviderTest extends AbstractModelBasedServiceTests {

	@Before	
	override setUp() throws Exception {
		super.setUp()
	}
	
	@Test
	def void testGetOrgNamespacePrefixSimple() {
		val rs = readModel("model/simple")
		val domNs = rs.allContents.toIterable.filter(DomainNamespace).findFirst[name == "samples"]
		val orgNs = domNs.eContainer as OrganizationNamespace
		val provider = get(DefaultServiceNamespaceUriProvider)		
		val orgNsURI = provider.getOrgNamespacePrefix(orgNs);
		val domNsURI = provider.getOrgNamespacePrefix(domNs);
		
		assertEquals("ox", orgNsURI);
		assertEquals("ox", domNsURI);
		
		val verNs = new VersionedDomainNamespace();
		verNs.setSubdomain(domNs);
		verNs.setVersion("1");
		assertEquals("ox", provider.getOrgNamespacePrefix(verNs));
	}
	
	@Test
	def void testGetOrgNamespacePrefixRule() {
		val rs = readModel("model/noShortNames")
		val domNs = rs.allContents.toIterable.filter(DomainNamespace).findFirst[name == "samples"]
		val orgNs = domNs.eContainer as OrganizationNamespace
		val provider = get(DefaultServiceNamespaceUriProvider)		
		val orgNsURI = provider.getOrgNamespacePrefix(orgNs);
		val domNsURI = provider.getOrgNamespacePrefix(domNs);
		
		assertEquals("xkx", orgNsURI);
		assertEquals("xkx", domNsURI);
		
		val verNs = new VersionedDomainNamespace();
		verNs.setSubdomain(domNs);
		verNs.setVersion("1");
		assertEquals("xkx", provider.getOrgNamespacePrefix(verNs));
	}

	@Test
	def void testGetOrgNamespacePrefixWithShortnameRule() {
		val rs = readModel("model/withShortNames")
		val domNs = rs.allContents.toIterable.filter(DomainNamespace).findFirst[name == "samples"]
		val orgNs = domNs.eContainer as OrganizationNamespace
		val provider = get(DefaultServiceNamespaceUriProvider)		
		val orgNsURI = provider.getOrgNamespacePrefix(orgNs);
		val domNsURI = provider.getOrgNamespacePrefix(domNs);
		
		assertEquals("ofs", orgNsURI);
		assertEquals("ofs", domNsURI);
		
		val verNs = new VersionedDomainNamespace();
		verNs.setSubdomain(domNs);
		verNs.setVersion("1");
		assertEquals("ofs", provider.getOrgNamespacePrefix(verNs));
	}
	
}