package org.xkonnex.repo.dsl.servicedsl.test.namespace;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace;
import org.xkonnex.repo.dsl.servicedsl.service.namespace.ServiceNamespaceNameFragmentProvider;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DomainNamespace;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.InternalNamespace;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.OrganizationNamespace;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceDslFactory;
import org.xkonnex.repo.dsl.servicedsl.test.BaseServiceDslTest;
import org.xkonnex.repo.dsl.servicedsl.test.ServiceDslWithDependenciesInjector;

@RunWith(XtextRunner.class)
@InjectWith(ServiceDslWithDependenciesInjector.class)
public class ServiceNamespaceNameFragmentProviderTest extends BaseServiceDslTest {
	
	@Inject ServiceNamespaceNameFragmentProvider nameFragmentProvider;
	
	@Test
	public void testGetOrganizationNameFragment () {
		ServiceDslFactory f = ServiceDslFactory.eINSTANCE;
		OrganizationNamespace orgNs = f.createOrganizationNamespace();
		orgNs.setName("org.example");
		DomainNamespace domNs = f.createDomainNamespace();
		domNs.setName("customer.contract");
		orgNs.getSubNamespaces().add(domNs);
		
		assertEquals("org.example", nameFragmentProvider.getOrganizationNameFragment(domNs));
		
		VersionedDomainNamespace vns = new VersionedDomainNamespace();
		vns.setNamespace(domNs);
		vns.setVersion("2");

		assertEquals("org.example", nameFragmentProvider.getOrganizationNameFragment(vns));
	}
	
	@Test
	public void testGetOrganizationNameFragmentLong () {
		ServiceDslFactory f = ServiceDslFactory.eINSTANCE;
		OrganizationNamespace orgNs = f.createOrganizationNamespace();
		orgNs.setName("org.example.long");
		DomainNamespace domNs = f.createDomainNamespace();
		domNs.setName("customer.contract");
		orgNs.getSubNamespaces().add(domNs);
		
		assertEquals("org.example.long", nameFragmentProvider.getOrganizationNameFragment(domNs));
		
		VersionedDomainNamespace vns = new VersionedDomainNamespace();
		vns.setNamespace(domNs);
		vns.setVersion("2");

		assertEquals("org.example.long", nameFragmentProvider.getOrganizationNameFragment(vns));
	}
	
	@Test
	public void testGetSubNamespaceFragment () {
		ServiceDslFactory f = ServiceDslFactory.eINSTANCE;
		OrganizationNamespace orgNs = f.createOrganizationNamespace();
		orgNs.setName("org.example");
		DomainNamespace domNs = f.createDomainNamespace();
		domNs.setName("customer.contract");
		orgNs.getSubNamespaces().add(domNs);
		
		assertEquals("customer.contract", nameFragmentProvider.getSubNamespaceFragment(domNs));
		
		VersionedDomainNamespace vns = new VersionedDomainNamespace();
		vns.setNamespace(domNs);
		vns.setVersion("2");
		
		assertEquals("customer.contract", nameFragmentProvider.getSubNamespaceFragment(vns));
	}
	
	@Test
	public void testGetSubNamespaceFragmentLong () {
		ServiceDslFactory f = ServiceDslFactory.eINSTANCE;
		OrganizationNamespace orgNs = f.createOrganizationNamespace();
		orgNs.setName("org.example.long");
		DomainNamespace domNs = f.createDomainNamespace();
		domNs.setName("customer.contract");
		orgNs.getSubNamespaces().add(domNs);
		
		assertEquals("customer.contract", nameFragmentProvider.getSubNamespaceFragment(domNs));
		
		VersionedDomainNamespace vns = new VersionedDomainNamespace();
		vns.setNamespace(domNs);
		vns.setVersion("2");
		
		assertEquals("customer.contract", nameFragmentProvider.getSubNamespaceFragment(vns));
	}
	
	@Test
	public void testGetOrganizationNameFragmentNoOrg () {
		ServiceDslFactory f = ServiceDslFactory.eINSTANCE;
		DomainNamespace domNs = f.createDomainNamespace();
		domNs.setName("org.example.customer.contract");
		
		assertEquals("org.example", nameFragmentProvider.getOrganizationNameFragment(domNs));
		
		VersionedDomainNamespace vns = new VersionedDomainNamespace();
		vns.setNamespace(domNs);
		vns.setVersion("2");
		
		assertEquals("org.example", nameFragmentProvider.getOrganizationNameFragment(vns));
	}
	
	@Test
	public void testGetSubNamespaceFragmentNoOrg () {
		ServiceDslFactory f = ServiceDslFactory.eINSTANCE;
		DomainNamespace domNs = f.createDomainNamespace();
		domNs.setName("org.example.customer.contract");
		
		assertEquals("customer.contract", nameFragmentProvider.getSubNamespaceFragment(domNs));

		VersionedDomainNamespace vns = new VersionedDomainNamespace();
		vns.setNamespace(domNs);
		vns.setVersion("2");
		
		assertEquals("customer.contract", nameFragmentProvider.getSubNamespaceFragment(vns));
	}
	
	@Test
	public void testGetOrganizationNameFragmentNested () {
		ServiceDslFactory f = ServiceDslFactory.eINSTANCE;
		OrganizationNamespace orgNs = f.createOrganizationNamespace();
		orgNs.setName("org.example");
		DomainNamespace domNs = f.createDomainNamespace();
		domNs.setName("customer.contract");
		InternalNamespace internalNs = f.createInternalNamespace();
		internalNs.setName("internal.legacy");
		domNs.getInteralNamespaces().add(internalNs);
		orgNs.getSubNamespaces().add(domNs);
		
		assertEquals("org.example", nameFragmentProvider.getOrganizationNameFragment(domNs));
		
		VersionedDomainNamespace vns = new VersionedDomainNamespace();
		vns.setNamespace(domNs);
		vns.setVersion("2");

		assertEquals("org.example", nameFragmentProvider.getOrganizationNameFragment(vns));
	}
	
	@Test
	public void testGetSubNamespaceFragmentNested () {
		ServiceDslFactory f = ServiceDslFactory.eINSTANCE;
		OrganizationNamespace orgNs = f.createOrganizationNamespace();
		orgNs.setName("org.example");
		DomainNamespace domNs = f.createDomainNamespace();
		domNs.setName("customer.contract");
		InternalNamespace internalNs = f.createInternalNamespace();
		internalNs.setName("internal.legacy");
		InternalNamespace deepNs = f.createInternalNamespace();
		deepNs.setName("deep.and.long");
		internalNs.getInteralNamespaces().add(deepNs);
		domNs.getInteralNamespaces().add(internalNs);
		orgNs.getSubNamespaces().add(domNs);
		
		assertEquals("customer.contract", nameFragmentProvider.getSubNamespaceFragment(domNs));
		assertEquals("customer.contract.internal.legacy.deep.and.long", nameFragmentProvider.getSubNamespaceFragment(deepNs));
		
		VersionedDomainNamespace vns = new VersionedDomainNamespace();
		vns.setNamespace(domNs);
		vns.setVersion("2");
		
		assertEquals("customer.contract", nameFragmentProvider.getSubNamespaceFragment(vns));
	}
	
	@Test
	public void testGetOrganizationNameFragmentNoOrgNested () {
		ServiceDslFactory f = ServiceDslFactory.eINSTANCE;
		DomainNamespace domNs = f.createDomainNamespace();
		domNs.setName("org.example.customer.contract");
		InternalNamespace internalNs = f.createInternalNamespace();
		internalNs.setName("internal.legacy");
		domNs.getInteralNamespaces().add(internalNs);
		
		assertEquals("org.example", nameFragmentProvider.getOrganizationNameFragment(domNs));
		
		VersionedDomainNamespace vns = new VersionedDomainNamespace();
		vns.setNamespace(domNs);
		vns.setVersion("2");
		
		assertEquals("org.example", nameFragmentProvider.getOrganizationNameFragment(vns));
	}
	
	@Test
	public void testGetSubNamespaceFragmentNoOrgNested () {
		ServiceDslFactory f = ServiceDslFactory.eINSTANCE;
		DomainNamespace domNs = f.createDomainNamespace();
		domNs.setName("org.example.customer.contract");
		InternalNamespace internalNs = f.createInternalNamespace();
		internalNs.setName("internal.legacy");
		domNs.getInteralNamespaces().add(internalNs);
		
		assertEquals("customer.contract", nameFragmentProvider.getSubNamespaceFragment(domNs));
		assertEquals("customer.contract.internal.legacy", nameFragmentProvider.getSubNamespaceFragment(internalNs));

		VersionedDomainNamespace vns = new VersionedDomainNamespace();
		vns.setNamespace(domNs);
		vns.setVersion("2");
		
		assertEquals("customer.contract", nameFragmentProvider.getSubNamespaceFragment(vns));
	}

}
