package org.xkonnex.repo.dsl.profiledsl.test.namespace

import org.xkonnex.repo.dsl.profiledsl.test.AbstractModelBasedProfileTests
import org.xkonnex.repo.dsl.profiledsl.namespace.ProfileNamespaceNameFragmentProvider
import org.xkonnex.repo.dsl.profiledsl.profileDsl.TechnicalNamespace
import org.junit.Test
import org.junit.Before

class ProfileNamespaceNameFragmentProviderTest extends AbstractModelBasedProfileTests {
	
	@Before
	override setUp() throws Exception {
		super.setUp()
	}
	
	@Test
	def void testGetOrganizationNameFragment() {
		val rs = readModel("model/noOrg")
		val provider = get(ProfileNamespaceNameFragmentProvider)
		val tns = rs.allContents.toIterable.filter(TechnicalNamespace).findFirst[name == "org.example.soa"]
		
		val orgName = provider.getOrganizationNameFragment(tns)
		assertEquals("org.example", orgName)
	}
	
	@Test
	def void testGetOrganizationShortnameFragment() {
		val rs = readModel("model/noOrg")
		val provider = get(ProfileNamespaceNameFragmentProvider)
		val tns = rs.allContents.toIterable.filter(TechnicalNamespace).findFirst[name == "org.example.soa"]
		
		val orgName = provider.getOrganizationShortnameFragment(tns)
		assertEquals("ex", orgName)
	}
}