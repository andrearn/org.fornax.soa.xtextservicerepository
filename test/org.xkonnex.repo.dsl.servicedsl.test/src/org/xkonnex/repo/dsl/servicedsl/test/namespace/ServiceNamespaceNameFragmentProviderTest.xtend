package org.xkonnex.repo.dsl.servicedsl.test.namespace

import com.google.inject.Injector
import java.util.List
import javax.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions
import org.junit.Test
import org.junit.runner.RunWith
import org.xkonnex.repo.core.resource.XKonneXReader
import org.xkonnex.repo.core.validation.ModelIssues
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace
import org.xkonnex.repo.dsl.servicedsl.service.namespace.ServiceNamespaceNameFragmentProvider
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DomainNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.InternalNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.OrganizationNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceDslFactory
import org.xkonnex.repo.dsl.servicedsl.test.ServiceDslWithDependenciesInjector

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner)) 
@InjectWith(typeof(ServiceDslWithDependenciesInjector)) 
class ServiceNamespaceNameFragmentProviderTest {
	
	@Inject 
	private ServiceNamespaceNameFragmentProvider nameFragmentProvider
	
	@Inject 
	private ResourceSetBasedResourceDescriptions descriptions
	@Inject
	private Injector injector;

	@Test 
	def void testGetOrganizationNameFragment() {
		var ServiceDslFactory f = ServiceDslFactory::eINSTANCE
		var OrganizationNamespace orgNs = f.createOrganizationNamespace()
		orgNs.setName("org.example")
		var DomainNamespace domNs = f.createDomainNamespace()
		domNs.setName("customer.contract")
		orgNs.getSubNamespaces().add(domNs)
		assertEquals("org.example", nameFragmentProvider.getOrganizationNameFragment(domNs))
		var VersionedDomainNamespace vns = new VersionedDomainNamespace()
		vns.setNamespace(domNs)
		vns.setVersion("2")
		assertEquals("org.example", nameFragmentProvider.getOrganizationNameFragment(vns))
	}

	@Test 
	def void testGetOrganizationNameFragmentLong() {
		var ServiceDslFactory f = ServiceDslFactory::eINSTANCE
		var OrganizationNamespace orgNs = f.createOrganizationNamespace()
		orgNs.setName("org.example.long")
		var DomainNamespace domNs = f.createDomainNamespace()
		domNs.setName("customer.contract")
		orgNs.getSubNamespaces().add(domNs)
		assertEquals("org.example.long", nameFragmentProvider.getOrganizationNameFragment(domNs))
		var VersionedDomainNamespace vns = new VersionedDomainNamespace()
		vns.setNamespace(domNs)
		vns.setVersion("2")
		assertEquals("org.example.long", nameFragmentProvider.getOrganizationNameFragment(vns))
	}

	@Test 
	def void testGetSubNamespaceFragment() {
		var ServiceDslFactory f = ServiceDslFactory::eINSTANCE
		var OrganizationNamespace orgNs = f.createOrganizationNamespace()
		orgNs.setName("org.example")
		var DomainNamespace domNs = f.createDomainNamespace()
		domNs.setName("customer.contract")
		orgNs.getSubNamespaces().add(domNs)
		assertEquals("customer.contract", nameFragmentProvider.getSubNamespaceFragment(domNs))
		var VersionedDomainNamespace vns = new VersionedDomainNamespace()
		vns.setNamespace(domNs)
		vns.setVersion("2")
		assertEquals("customer.contract", nameFragmentProvider.getSubNamespaceFragment(vns))
	}

	@Test 
	def void testGetSubNamespaceFragmentLong() {
		var ServiceDslFactory f = ServiceDslFactory::eINSTANCE
		var OrganizationNamespace orgNs = f.createOrganizationNamespace()
		orgNs.setName("org.example.long")
		var DomainNamespace domNs = f.createDomainNamespace()
		domNs.setName("customer.contract")
		orgNs.getSubNamespaces().add(domNs)
		assertEquals("customer.contract", nameFragmentProvider.getSubNamespaceFragment(domNs))
		var VersionedDomainNamespace vns = new VersionedDomainNamespace()
		vns.setNamespace(domNs)
		vns.setVersion("2")
		assertEquals("customer.contract", nameFragmentProvider.getSubNamespaceFragment(vns))
	}

	@Test 
	def void testGetOrganizationNameFragmentNoOrg() {
		var ServiceDslFactory f = ServiceDslFactory::eINSTANCE
		var DomainNamespace domNs = f.createDomainNamespace()
		domNs.setName("org.example.customer.contract")
		assertEquals("org.example", nameFragmentProvider.getOrganizationNameFragment(domNs))
		var VersionedDomainNamespace vns = new VersionedDomainNamespace()
		vns.setNamespace(domNs)
		vns.setVersion("2")
		assertEquals("org.example", nameFragmentProvider.getOrganizationNameFragment(vns))
	}

	@Test 
	def void testGetSubNamespaceFragmentNoOrg() {
		var ServiceDslFactory f = ServiceDslFactory::eINSTANCE
		var DomainNamespace domNs = f.createDomainNamespace()
		domNs.setName("org.example.customer.contract")
		assertEquals("customer.contract", nameFragmentProvider.getSubNamespaceFragment(domNs))
		var VersionedDomainNamespace vns = new VersionedDomainNamespace()
		vns.setNamespace(domNs)
		vns.setVersion("2")
		assertEquals("customer.contract", nameFragmentProvider.getSubNamespaceFragment(vns))
	}

	@Test 
	def void testGetOrganizationNameFragmentNested() {
		var ServiceDslFactory f = ServiceDslFactory::eINSTANCE
		var OrganizationNamespace orgNs = f.createOrganizationNamespace()
		orgNs.setName("org.example")
		var DomainNamespace domNs = f.createDomainNamespace()
		domNs.setName("customer.contract")
		var InternalNamespace internalNs = f.createInternalNamespace()
		internalNs.setName("internal.legacy")
		domNs.getInteralNamespaces().add(internalNs)
		orgNs.getSubNamespaces().add(domNs)
		assertEquals("org.example", nameFragmentProvider.getOrganizationNameFragment(domNs))
		var VersionedDomainNamespace vns = new VersionedDomainNamespace()
		vns.setNamespace(domNs)
		vns.setVersion("2")
		assertEquals("org.example", nameFragmentProvider.getOrganizationNameFragment(vns))
	}

	@Test 
	def void testGetSubNamespaceFragmentNested() {
		var ServiceDslFactory f = ServiceDslFactory::eINSTANCE
		var OrganizationNamespace orgNs = f.createOrganizationNamespace()
		orgNs.setName("org.example")
		var DomainNamespace domNs = f.createDomainNamespace()
		domNs.setName("customer.contract")
		var InternalNamespace internalNs = f.createInternalNamespace()
		internalNs.setName("internal.legacy")
		var InternalNamespace deepNs = f.createInternalNamespace()
		deepNs.setName("deep.and.long")
		internalNs.getInteralNamespaces().add(deepNs)
		domNs.getInteralNamespaces().add(internalNs)
		orgNs.getSubNamespaces().add(domNs)
		assertEquals("customer.contract", nameFragmentProvider.getSubNamespaceFragment(domNs))
		assertEquals("customer.contract.internal.legacy.deep.and.long",
			nameFragmentProvider.getSubNamespaceFragment(deepNs))
		var VersionedDomainNamespace vns = new VersionedDomainNamespace()
		vns.setNamespace(domNs)
		vns.setVersion("2")
		assertEquals("customer.contract", nameFragmentProvider.getSubNamespaceFragment(vns))
	}

	@Test 
	def void testGetOrganizationNameFragmentNoOrgNested() {
		var ServiceDslFactory f = ServiceDslFactory::eINSTANCE
		var DomainNamespace domNs = f.createDomainNamespace()
		domNs.setName("org.example.customer.contract")
		var InternalNamespace internalNs = f.createInternalNamespace()
		internalNs.setName("internal.legacy")
		domNs.getInteralNamespaces().add(internalNs)
		assertEquals("org.example", nameFragmentProvider.getOrganizationNameFragment(domNs))
		var VersionedDomainNamespace vns = new VersionedDomainNamespace()
		vns.setNamespace(domNs)
		vns.setVersion("2")
		assertEquals("org.example", nameFragmentProvider.getOrganizationNameFragment(vns))
	}

	@Test 
	def void testGetSubNamespaceFragmentNoOrgNested() {
		var ServiceDslFactory f = ServiceDslFactory::eINSTANCE
		var DomainNamespace domNs = f.createDomainNamespace()
		domNs.setName("org.example.customer.contract")
		var InternalNamespace internalNs = f.createInternalNamespace()
		internalNs.setName("internal.legacy")
		domNs.getInteralNamespaces().add(internalNs)
		assertEquals("customer.contract", nameFragmentProvider.getSubNamespaceFragment(domNs))
		assertEquals("customer.contract.internal.legacy", nameFragmentProvider.getSubNamespaceFragment(internalNs))
		var VersionedDomainNamespace vns = new VersionedDomainNamespace()
		vns.setNamespace(domNs)
		vns.setVersion("2")
		assertEquals("customer.contract", nameFragmentProvider.getSubNamespaceFragment(vns))
	}
	
	@Test
	def void testGetOrgNamespaceShortname() {
		val reader = injector.getInstance(typeof(XKonneXReader))
		val modelIssues = new ModelIssues
		val List<String> pathes = newArrayList("model/withShortNames")
		val resourceSet = reader.read(pathes, modelIssues)
		descriptions.setContext(resourceSet);
		descriptions.setRegistry(IResourceServiceProvider.Registry.INSTANCE);
		var DomainNamespace samplesNS = resourceSet.allContents.toIterable.filter(typeof (DomainNamespace)).findFirst[name.contains("samples")]
		var DomainNamespace otherNS = resourceSet.allContents.toIterable.filter(typeof (DomainNamespace)).findFirst[name.contains("other")]
		val samplesShortname = nameFragmentProvider.getOrganizationShortnameFragment(samplesNS)
		val otherShortname = nameFragmentProvider.getOrganizationShortnameFragment(otherNS)
		assertEquals("ofs", samplesShortname)
		assertEquals("xkx", otherShortname)
	}
}
