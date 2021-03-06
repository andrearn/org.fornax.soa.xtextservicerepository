package org.xkonnex.repo.dsl.moduledsl.test.model

import com.google.inject.Inject
import com.google.inject.Injector
import java.util.List
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.xkonnex.repo.core.resource.XKonneXReader
import org.xkonnex.repo.core.validation.ModelIssues
import org.xkonnex.repo.dsl.basedsl.ext.infer.ComponentInferrer
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST
import org.xkonnex.repo.dsl.moduledsl.model.EffectiveProvidingEndpointProtocol
import org.xkonnex.repo.dsl.moduledsl.model.IEffectiveProvidingEndpointBuilder
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.OperationRef
import org.xkonnex.repo.dsl.moduledsl.test.ModuleDslWithDependenciesInjectorProvider
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Verb

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner)) 
@InjectWith(typeof(ModuleDslWithDependenciesInjectorProvider)) 
class EffectiveProvidingEndpointBuilderTest {
	
	@Inject 
	private IEffectiveProvidingEndpointBuilder endpointBuilder
	@Inject 
	private Injector injector
	@Inject 
	private ResourceSetBasedResourceDescriptions descriptions
	@Inject
	private ComponentInferrer componentInferrer
	
	@Test
	def testCreateEffectiveProvidingEndpoint() {
		val reader = injector.getInstance(typeof(XKonneXReader))
		val modelIssues = new ModelIssues
		val List<String> pathes = newArrayList("model/endpoint")
		val rs = reader.read(pathes, modelIssues)
		descriptions.setContext(rs);
		descriptions.setRegistry(IResourceServiceProvider.Registry.INSTANCE);
		val op = rs.allContents.toIterable.filter(typeof(Operation)).findFirst[name == "getCustomerDetails"]
		val mod = rs.allContents.toIterable.filter(typeof(Module)).findFirst[name == "org.example.sales.esb"]
		val opRef = rs.allContents.toIterable.filter(typeof(OperationRef)).head
		val effEndpoint = endpointBuilder.createEffectiveProvidingEndpoint(op, opRef.providingEndpoints.head)
		assertTrue(effEndpoint.endpointProtocol instanceof EffectiveProvidingEndpointProtocol)
		
		val p = opRef.providingEndpoints.head.endpointProtocol
		val pt = componentInferrer.inferComponent(p)
		
		val effProt = effEndpoint.endpointProtocol as EffectiveProvidingEndpointProtocol
		assertTrue(effProt.endpointProtocol instanceof REST)
		
		val protBean = effProt.endpointProtocol as REST
		assertEquals("customer/details", protBean.path)
		assertEquals(Verb.GET, protBean.verb)
		assertEquals("application/json", protBean.requestContentType.head)
		assertEquals("application/json", protBean.response.head.contentType.head)
		
	}
}