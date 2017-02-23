package org.xkonnex.repo.dsl.moduledsl.test.query.endpoint

import static org.junit.Assert.*
import com.google.inject.Inject
import org.junit.Test
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.moduledsl.query.endpoint.IModuleEndpointProtocolLookup
import org.xkonnex.repo.dsl.moduledsl.test.AbstractModelBasedModuleTests
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.eclipse.xtext.testing.InjectWith
import org.junit.runner.RunWith
import org.eclipse.xtext.testing.XtextRunner
import org.xkonnex.repo.dsl.moduledsl.test.ModuleDslWithDependenciesInjectorProvider
import com.google.inject.Injector
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions
import org.xkonnex.repo.core.resource.XKonneXReader
import org.xkonnex.repo.core.validation.ModelIssues
import java.util.List
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service

@RunWith(typeof(XtextRunner)) 
@InjectWith(typeof(ModuleDslWithDependenciesInjectorProvider)) 
class ModuleEndpointProtocolLookupTest {
	
	@Inject 
	private IModuleEndpointProtocolLookup lookup
	@Inject 
	private Injector injector
	@Inject 
	private ResourceSetBasedResourceDescriptions descriptions
	
	@Test
	def testCollectEndpointProtocolHierarchyByTypeOperation() {
		val reader = injector.getInstance(typeof(XKonneXReader))
		val modelIssues = new ModelIssues
		val List<String> pathes = newArrayList("model/endpoint")
		val rs = reader.read(pathes, modelIssues)
		descriptions.setContext(rs);
		descriptions.setRegistry(IResourceServiceProvider.Registry.INSTANCE);
		val op = rs.allContents.toIterable.filter(typeof(Operation)).findFirst[name == "getCustomerDetails"]
		val mod = rs.allContents.toIterable.filter(typeof(Module)).head//findFirst[name == "org.example.sales.esb"]
		val protocolPrototype =  new REST
		val protocolSpecs = lookup.collectEndpointProtocolHierarchyByType(op, mod, protocolPrototype)
		assertEquals(2, protocolSpecs.size)
		assertTrue(protocolSpecs.get(0) instanceof REST)
		assertEquals("customer/details", (protocolSpecs.get(0) as REST).path)
		assertTrue(protocolSpecs.get(1) instanceof REST)
		assertEquals("customer", (protocolSpecs.get(1) as REST).path)
	}
	
	@Test
	def testCollectEndpointProtocolHierarchyByTypeService() {
		val reader = injector.getInstance(typeof(XKonneXReader))
		val modelIssues = new ModelIssues
		val List<String> pathes = newArrayList("model/endpoint")
		val rs = reader.read(pathes, modelIssues)
		descriptions.setContext(rs);
		descriptions.setRegistry(IResourceServiceProvider.Registry.INSTANCE);
		val svc = rs.allContents.toIterable.filter(typeof(Service)).findFirst[name == "CustomerLookupBES"]
		val mod = rs.allContents.toIterable.filter(typeof(Module)).head//findFirst[name == "org.example.sales.esb"]
		val protocolPrototype =  new REST
		val protocolSpecs = lookup.collectEndpointProtocolHierarchyByType(svc, mod, protocolPrototype)
		assertEquals(1, protocolSpecs.size)
		assertTrue(protocolSpecs.get(0) instanceof REST)
		assertEquals("customer", (protocolSpecs.get(0) as REST).path)
	}
	
}