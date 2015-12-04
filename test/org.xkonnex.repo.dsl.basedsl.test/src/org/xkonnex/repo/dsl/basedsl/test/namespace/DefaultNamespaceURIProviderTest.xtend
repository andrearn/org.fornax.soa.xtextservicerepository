package org.xkonnex.repo.dsl.basedsl.test.namespace

import static org.junit.Assert.*
import javax.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.runner.RunWith
import org.xkonnex.repo.dsl.basedsl.BaseDslInjectorProvider
import org.xkonnex.repo.dsl.basedsl.namespace.DefaultNamespaceURIProvider
import org.junit.Test
import org.xkonnex.repo.dsl.basedsl.baseDsl.BaseDslFactory
import org.xkonnex.repo.dsl.basedsl.namespace.VersionedNamespace

@RunWith(XtextRunner)
@InjectWith(BaseDslInjectorProvider)
class DefaultNamespaceURIProviderTest {
	
	@Inject 
	private DefaultNamespaceURIProvider nsUriProvider
	
	@Test
	def void testGetUnversionedNamespaceURI () {
		val ns = BaseDslFactory.eINSTANCE.createNamespace
		ns.name = "org.example.customer.contract"

		assertEquals("http://example.org/customer/contract/", nsUriProvider.getNamespaceURI(ns))
		assertEquals("http://example.org/customer/contract/", nsUriProvider.getNamespaceURI("org.example.customer.contract"))

		val nsWithUri = BaseDslFactory.eINSTANCE.createNamespace
		nsWithUri.name = "org.example.customer.contract"
		nsWithUri.uri = "http://ex.org/cust/contr/"

		assertEquals("http://ex.org/cust/contr/", nsUriProvider.getNamespaceURI(nsWithUri))
	}
	
	@Test
	def void testGetNamespacePrefix() {
		val ns = BaseDslFactory.eINSTANCE.createNamespace
		ns.name = "org.example.customer.contract"
		
		assertEquals("oecc", nsUriProvider.getNamespacePrefix("org.example.customer.contract"))
		assertEquals("oecc", nsUriProvider.getNamespacePrefix(ns))
		
		val vns = new VersionedNamespace
		vns.namespace = ns
		vns.version = "2.1"
		
		assertEquals("oecc", nsUriProvider.getNamespacePrefix(vns))
	}
	
	@Test
	def void testGetVersionedNamespacePrefix() {
		val ns = BaseDslFactory.eINSTANCE.createNamespace
		ns.name = "org.example.customer.contract"
		
		assertEquals("oecc1", nsUriProvider.getVersionedNamespacePrefix("org.example.customer.contract"))
		assertEquals("oecc1", nsUriProvider.getVersionedNamespacePrefix(ns))
		
		val vns = new VersionedNamespace
		vns.namespace = ns
		vns.version = "2.1"
		
		assertEquals("oecc2", nsUriProvider.getVersionedNamespacePrefix(vns))
	}
	
	@Test
	def void testGetVersionPostfix() {
		val ns = BaseDslFactory.eINSTANCE.createNamespace
		ns.name = "org.example.customer.contract"
		
		assertEquals ("v1", nsUriProvider.getVersionPostfix(ns))

		val vns = new VersionedNamespace
		vns.namespace = ns
		vns.version ="2.1"
		assertEquals ("v1", nsUriProvider.getVersionPostfix(ns))
	}
	
	@Test
	def void testGetHostPart() {
		val ns = BaseDslFactory.eINSTANCE.createNamespace
		ns.name = "org.example.customer.contract"
		
		assertEquals("http://example.org", nsUriProvider.getHostPart(ns))
		assertEquals("http://example.org", nsUriProvider.getHostPart("org.example.customer.contract"))
		
		val nsWithUri = BaseDslFactory.eINSTANCE.createNamespace
		nsWithUri.name = "org.example.customer.contract"
		nsWithUri.uri = "http://ex.org/cust/contr/"
		
		assertEquals("http://ex.org", nsUriProvider.getHostPart(nsWithUri))
	}
	
	@Test
	def void testGetPathPart() {
		val ns = BaseDslFactory.eINSTANCE.createNamespace
		ns.name = "org.example.customer.contract"
		
		assertEquals("customer/contract", nsUriProvider.getPathPart(ns))
		assertEquals("customer/contract", nsUriProvider.getPathPart("org.example.customer.contract"))
		
		val nsWithUri = BaseDslFactory.eINSTANCE.createNamespace
		nsWithUri.name = "org.example.customer.contract"
		nsWithUri.uri = "http://ex.org/cust/contr/"
		
		assertEquals ("cust/contr", nsUriProvider.getPathPart(nsWithUri))
	}
	
	@Test
	def void testRequiresTrailingSlash() {
		val nsWithSlash = BaseDslFactory.eINSTANCE.createNamespace
		nsWithSlash.name = "org.example.customer.contract"
		nsWithSlash.uri = "http://example.org/cust/contr/"
		
		assertTrue (nsUriProvider.requiresTrailingSlash(nsWithSlash))
		
		val nsNoSlash = BaseDslFactory.eINSTANCE.createNamespace
		nsNoSlash.name = "org.example.customer.contract"
		nsNoSlash.uri = "http://example.org/cust/contr"
		
		assertFalse (nsUriProvider.requiresTrailingSlash(nsNoSlash))
	}
}