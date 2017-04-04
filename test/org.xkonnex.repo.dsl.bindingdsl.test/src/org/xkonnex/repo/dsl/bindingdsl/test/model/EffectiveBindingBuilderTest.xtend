package org.xkonnex.repo.dsl.bindingdsl.test.model

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
import org.xkonnex.repo.dsl.bindingdsl.model.IEffectiveBindingBuilder
import org.xkonnex.repo.dsl.bindingdsl.test.BindingDslWithDependenciesInjectorProvider
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.xkonnex.repo.dsl.bindingdsl.binding.query.BindingLookup
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.REST
import org.xkonnex.repo.dsl.bindingdsl.ext.protocol.IProtocol
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.HttpVerb
import org.xkonnex.repo.dsl.bindingdsl.model.protocol.EffectiveBindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAP
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ExtensibleProtocol
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.ESB
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Verb

@RunWith(typeof(XtextRunner)) 
@InjectWith(typeof(BindingDslWithDependenciesInjectorProvider)) 
class EffectiveBindingBuilderTest {

	@Inject 
	private Injector injector
	@Inject 
	private ResourceSetBasedResourceDescriptions descriptions
	@Inject
	private IEffectiveBindingBuilder bindingBuilder
	@Inject
	private BindingLookup bindingLookup
	
	@Test
	def testCreateEffectiveBindingOperation() {
		val reader = injector.getInstance(typeof(XKonneXReader))
		val modelIssues = new ModelIssues
		val List<String> pathes = newArrayList("model/bindings")
		val rs = reader.read(pathes, modelIssues)
		descriptions.setContext(rs);
		descriptions.setRegistry(IResourceServiceProvider.Registry.INSTANCE);
		
		val op = rs.allContents.toIterable.filter(typeof(Operation)).findFirst[name == "getCustomerDetails"]
		val bind = rs.allContents.toIterable.filter(typeof(ModuleBinding)).findFirst[name == "org.example.sales.esb.dev"]
		val effBind = bindingBuilder.createEffectiveBinding(op, bind)
		
		assertNotNull(effBind.provServer)
		assertTrue(effBind.provServer instanceof ESB)
		assertFalse((effBind.provServer as ESB).connectors.nullOrEmpty)
		
		val effProtocols = effBind.protocol.map[it as EffectiveBindingProtocol]
		assertEquals(2, effProtocols.size)

		val extProts = effProtocols.filter[it.extensibleProtocol !== null].map[it.extensibleProtocol as IProtocol]
		assertEquals(1, extProts.size)
		
		val rest = extProts.head as REST
		assertEquals("customer/details", rest.path)
		assertEquals(Verb::GET, rest.verb)
		assertEquals("application/json", rest.requestContentType.head)
		assertEquals("application/json", rest.response.head.contentType.head)

		val soapProts = effProtocols.filter(SOAP)
		assertEquals(1, soapProts.size)
	}
	
	@Test
	def testCreateEffectiveBindingProtocol() {
		val reader = injector.getInstance(typeof(XKonneXReader))
		val modelIssues = new ModelIssues
		val List<String> pathes = newArrayList("model/bindings")
		val rs = reader.read(pathes, modelIssues)
		descriptions.setContext(rs);
		descriptions.setRegistry(IResourceServiceProvider.Registry.INSTANCE);
		
		val op = rs.allContents.toIterable.filter(typeof(Operation)).findFirst[name == "getCustomerDetails"]
		val bind = rs.allContents.toIterable.filter(typeof(ModuleBinding)).findFirst[name == "org.example.sales.esb.dev"]
		val specBinding = bindingLookup.getMostSpecificOperationBinding(op, bind)
		val bindingHierarchy = bindingLookup.getBottomUpHierarchyForSpecificBinding(specBinding);
		
		val protocols = bindingBuilder.createEffectiveBindingProtocol(bindingHierarchy)
		
		assertEquals(2, protocols.size)

		val extProts = protocols.filter[it.extensibleProtocol != null].map[it.extensibleProtocol as IProtocol]
		assertEquals(1, extProts.size)
		
		val rest = extProts.head as REST
		assertEquals("customer/details", rest.path)
		assertEquals(Verb::GET, rest.verb)
		assertEquals("application/json", rest.requestContentType.head)
		assertEquals("application/json", rest.response.head.contentType.head)
		
		val extensibleProt = protocols.filter(typeof(ExtensibleProtocol)).head
		assertNotNull(extensibleProt.type)
	}
}