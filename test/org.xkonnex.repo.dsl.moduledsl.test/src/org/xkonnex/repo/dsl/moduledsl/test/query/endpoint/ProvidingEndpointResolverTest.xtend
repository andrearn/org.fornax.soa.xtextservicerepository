package org.xkonnex.repo.dsl.moduledsl.test.query.endpoint

import static org.junit.Assert.*

import com.google.inject.Inject
import com.google.inject.Injector
import java.util.List
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions
import org.junit.Test
import org.junit.runner.RunWith
import org.xkonnex.repo.core.resource.XKonneXReader
import org.xkonnex.repo.core.validation.ModelIssues
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.moduledsl.query.endpoint.IModuleEndpointProtocolLookup
import org.xkonnex.repo.dsl.moduledsl.query.endpoint.IProvidingEndpointResolver
import org.xkonnex.repo.dsl.moduledsl.test.ModuleDslWithDependenciesInjectorProvider
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.OperationRef
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ServiceRef
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.ProvidingEndpoint

@RunWith(typeof(XtextRunner)) 
@InjectWith(typeof(ModuleDslWithDependenciesInjectorProvider)) 
class ProvidingEndpointResolverTest {
	
	@Inject 
	private IModuleEndpointProtocolLookup lookup
	@Inject 
	private IProvidingEndpointResolver resolver
	@Inject 
	private Injector injector
	@Inject 
	private ResourceSetBasedResourceDescriptions descriptions


	@Test
	def testCollectProvidingEndpointHierarchyByTypeOperation() {
		val reader = injector.getInstance(typeof(XKonneXReader))
		val modelIssues = new ModelIssues
		val List<String> pathes = newArrayList("model/endpoint")
		val rs = reader.read(pathes, modelIssues)
		descriptions.setContext(rs);
		descriptions.setRegistry(IResourceServiceProvider.Registry.INSTANCE);
		
		val op = rs.allContents.toIterable.filter(typeof(Operation)).findFirst[name == "getCustomerDetails"]
		val mod = rs.allContents.toIterable.filter(typeof(Module)).findFirst[name == "org.example.sales.esb"]
		val protocolPrototype =  new REST
		val endpointSpecs = resolver.collectProvidingEndpointHierarchyByType(op, mod, protocolPrototype)
		assertEquals(2, endpointSpecs.size)
	}
	
	@Test
	def testGetMostSpecificProvidingEndpointConfig() {
		val reader = injector.getInstance(typeof(XKonneXReader))
		val modelIssues = new ModelIssues
		val List<String> pathes = newArrayList("model/endpoint")
		val rs = reader.read(pathes, modelIssues)
		descriptions.setContext(rs);
		descriptions.setRegistry(IResourceServiceProvider.Registry.INSTANCE);

		val op = rs.allContents.toIterable.filter(typeof(Operation)).findFirst[name == "getCustomerDetails"]
		val mod = rs.allContents.toIterable.filter(typeof(Module)).findFirst[name == "org.example.sales.esb"]
		val epConfig = resolver.getMostSpecificProvidingEndpointConfig(op, mod)
		assertTrue(epConfig instanceof OperationRef)

		val opFindByNameAndCity = rs.allContents.toIterable.filter(typeof(Operation)).findFirst[name == "findByNameAndCity"]
		val epConfigFindByNameAndCity = resolver.getMostSpecificProvidingEndpointConfig(opFindByNameAndCity, mod)
		assertTrue(epConfigFindByNameAndCity instanceof ServiceRef)
	}
	
	@Test
	def testGetMostSpecificProvidingEndpointByType() {
		val reader = injector.getInstance(typeof(XKonneXReader))
		val modelIssues = new ModelIssues
		val List<String> pathes = newArrayList("model/endpoint")
		val rs = reader.read(pathes, modelIssues)
		descriptions.setContext(rs);
		descriptions.setRegistry(IResourceServiceProvider.Registry.INSTANCE);

		val op = rs.allContents.toIterable.filter(typeof(Operation)).findFirst[name == "getCustomerDetails"]
		val mod = rs.allContents.toIterable.filter(typeof(Module)).findFirst[name == "org.example.sales.esb"]
		val protocolPrototype =  new REST
		val endpoint = resolver.getMostSpecificProvidingEndpointByType(op, mod, protocolPrototype)
		assertTrue(endpoint instanceof ProvidingEndpoint)
		assertTrue(endpoint.eContainer instanceof OperationRef)

		val opFindByNameAndCity = rs.allContents.toIterable.filter(typeof(Operation)).findFirst[name == "findByNameAndCity"]
		val endpointFindByNameAndCity = resolver.getMostSpecificProvidingEndpointByType(opFindByNameAndCity, mod, protocolPrototype)
		assertTrue(endpointFindByNameAndCity instanceof ProvidingEndpoint)
		assertTrue(endpointFindByNameAndCity.eContainer instanceof ServiceRef)
	}
	
}