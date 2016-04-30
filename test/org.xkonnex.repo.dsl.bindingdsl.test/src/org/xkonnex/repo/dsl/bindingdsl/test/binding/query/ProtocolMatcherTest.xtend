package org.xkonnex.repo.dsl.bindingdsl.test.binding.query

import static org.junit.Assert.*
import javax.inject.Inject
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.runner.RunWith
import org.xkonnex.repo.dsl.bindingdsl.binding.query.ProtocolMatcher
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingDslFactory
import org.xkonnex.repo.dsl.bindingdsl.test.BindingDslWithDependenciesInjectorProvider
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.REST
import org.junit.Test
import org.xkonnex.repo.dsl.moduledsl.ext.protocol.SOAP

@RunWith(typeof(XtextRunner)) 
@InjectWith(typeof(BindingDslWithDependenciesInjectorProvider)) 
class ProtocolMatcherTest {
	
	@Inject ProtocolMatcher protocolMatcher
	
	@Test
	def testSupportsModuleEndpointProtocolSOAP() {
		val factory = BindingDslFactory::eINSTANCE
		val modBind = factory.createModuleBinding
		val prot = factory.createSOAP
		modBind.protocol += prot
		
		val supported = protocolMatcher.supportsModuleEndpointProtocol(modBind, typeof (SOAP))
		assertTrue(supported)
	}
	
	@Test
	def testMatchesModuleEndpointProtocolSOAP() {
		val factory = BindingDslFactory::eINSTANCE
		val modBind = factory.createModuleBinding
		val prot = factory.createSOAP
		
		val supported = protocolMatcher.matchesModuleEndpointProtocol(prot, typeof(SOAP))
		assertTrue(supported)
	}
	
	@Test
	def testSupportsModuleEndpointProtocolExtensible() {
		val factory = BindingDslFactory::eINSTANCE
		val modBind = factory.createModuleBinding
		val prot = factory.createExtensibleProtocol
		val type = TypesFactory.eINSTANCE.createJvmGenericType
		type.abstract = false
		val declaredType = TypesFactory::eINSTANCE.createJvmGenericType
	    declaredType.setSimpleName("REST")
	    declaredType.setPackageName("org.xkonnex.repo.dsl.bindingdsl.ext.protocol")
	    prot.type = declaredType
		modBind.protocol += prot
		
		val supported = protocolMatcher.supportsModuleEndpointProtocol(modBind, typeof (REST))
		assertTrue(supported)
	}
	
	@Test
	def testMatchesModuleEndpointProtocolExtensible() {
		val factory = BindingDslFactory::eINSTANCE
		val modBind = factory.createModuleBinding
		val prot = factory.createExtensibleProtocol
		val type = TypesFactory.eINSTANCE.createJvmGenericType
		type.abstract = false
		val declaredType = TypesFactory::eINSTANCE.createJvmGenericType
	    declaredType.setSimpleName("REST")
	    declaredType.setPackageName("org.xkonnex.repo.dsl.bindingdsl.ext.protocol")
	    prot.type = declaredType
		modBind.protocol += prot
		
		val supported = protocolMatcher.matchesModuleEndpointProtocol(prot, typeof(REST))
		assertTrue(supported)
	}
	
}