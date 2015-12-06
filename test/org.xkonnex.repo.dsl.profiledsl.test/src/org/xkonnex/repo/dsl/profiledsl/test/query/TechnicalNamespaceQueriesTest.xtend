package org.xkonnex.repo.dsl.profiledsl.test.query

import org.junit.Before
import org.junit.Test
import org.xkonnex.repo.dsl.profiledsl.profileDsl.TechnicalNamespace
import org.xkonnex.repo.dsl.profiledsl.query.namespace.TechnicalNamespaceQueries
import org.xkonnex.repo.dsl.profiledsl.test.AbstractModelBasedProfileTests

class TechnicalNamespaceQueriesTest extends AbstractModelBasedProfileTests {
	
	@Before
	override setUp() throws Exception {
		super.setUp()
	}
	
	@Test
	def void testFindOrgNamespace() {
		val rs = readModel("model/noOrg")
		val ns = rs.allContents.toIterable.filter(TechnicalNamespace).get(0)
		val queries = get(TechnicalNamespaceQueries)
		val orgNs = queries.findOrgNamespace(ns)
		assertNull(orgNs)

		val rs2 = readModel("model/noShortNames")
		val ns2 = rs2.allContents.toIterable.filter(TechnicalNamespace).get(0)
		val orgNs2 = queries.findOrgNamespace(ns2)
		assertNotNull(orgNs2)
		assertEquals("org.example", orgNs2.name)
	}
}