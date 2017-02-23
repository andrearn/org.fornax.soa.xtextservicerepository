package org.xkonnex.repo.dsl.servicedsl.test.query

import static org.junit.Assert.*

import org.junit.runner.RunWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.InjectWith
import org.xkonnex.repo.dsl.servicedsl.test.ServiceDslWithDependenciesInjector
import javax.inject.Inject
import org.xkonnex.repo.dsl.servicedsl.service.query.resource.ResourceQueries
import org.junit.Test

@RunWith(XtextRunner) 
@InjectWith(ServiceDslWithDependenciesInjector) 
class ResourceQueriesTest {
	
	@Inject ResourceQueries queries 
	
	@Test
	def testExtractParametersFromURI() {
		val paramNames = queries.extractParametersFromURI("/api/v2/customer/${customerId}/address/${addressId_1}/appartment/${appartment_Num}")
		assertEquals(3, paramNames.size)
		assertTrue(paramNames.contains("customerId"))
		assertTrue(paramNames.contains("addressId_1"))
		assertTrue(paramNames.contains("appartment_Num"))
	}
	
}