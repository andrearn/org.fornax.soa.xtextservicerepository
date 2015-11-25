package org.xkonnex.repo.dsl.servicedsl.test.namespace;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace;
import org.xkonnex.repo.dsl.servicedsl.service.namespace.DefaultServiceNamespaceUriProvider;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DomainNamespace;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.InternalNamespace;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.OrganizationNamespace;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceDslFactory;
import org.xkonnex.repo.dsl.servicedsl.test.BaseServiceDslTest;
import org.xkonnex.repo.dsl.servicedsl.test.ServiceDslWithDependenciesInjector;

@RunWith(XtextRunner.class)
@InjectWith(ServiceDslWithDependenciesInjector.class)
public class ServiceNamespaceUriProviderTest extends BaseServiceDslTest {
	
	@Inject
	private DefaultServiceNamespaceUriProvider provider;
	

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}
	
	@Test
	public void testGetUnversionedNamespaceURI() {
		ServiceDslFactory f = ServiceDslFactory.eINSTANCE;
		OrganizationNamespace orgNs = f.createOrganizationNamespace();
		orgNs.setName("org.example");
		DomainNamespace domNs = f.createDomainNamespace();
		domNs.setName("customer.contract");
		orgNs.getSubNamespaces().add(domNs);
		String orgNsURI = provider.getUnversionedNamespaceURI(orgNs);
		String domNsURI = provider.getUnversionedNamespaceURI(domNs);
		assertEquals("http://example.org/", orgNsURI);
		assertEquals("http://example.org/customer/contract/", domNsURI);
		VersionedDomainNamespace verNs = new VersionedDomainNamespace();
		verNs.setSubdomain(domNs);
		verNs.setVersion("1");
		assertEquals("http://example.org/customer/contract/", provider.getUnversionedNamespaceURI(verNs));
	}
	
	@Test
	public void testGetVersionedNamespaceURI() {
		ServiceDslFactory f = ServiceDslFactory.eINSTANCE;
		OrganizationNamespace orgNs = f.createOrganizationNamespace();
		orgNs.setName("org.example");
		DomainNamespace domNs = f.createDomainNamespace();
		domNs.setName("customer.contract");
		orgNs.getSubNamespaces().add(domNs);
		String orgNsURI = provider.getVersionedNamespaceURI(orgNs);
		String domNsURI = provider.getVersionedNamespaceURI(domNs);
		assertEquals("http://example.org/v1/", orgNsURI);
		assertEquals("http://example.org/customer/contract/v1/", domNsURI);
		VersionedDomainNamespace verNs = new VersionedDomainNamespace();
		verNs.setSubdomain(domNs);
		verNs.setVersion("2");
		assertEquals("http://example.org/customer/contract/v2/", provider.getVersionedNamespaceURI(verNs));
	}
	
	@Test
	public void testGetUnversionedNamespaceURIWithURI() {
		ServiceDslFactory f = ServiceDslFactory.eINSTANCE;
		OrganizationNamespace orgNs = f.createOrganizationNamespace();
		orgNs.setName("org.example");
		DomainNamespace domNs = f.createDomainNamespace();
		domNs.setName("customer.contract");
		domNs.setUri("https://ex.com/cust/contr/");
		orgNs.getSubNamespaces().add(domNs);
		
		String orgNsURI = provider.getUnversionedNamespaceURI(orgNs);
		String domNsURI = provider.getUnversionedNamespaceURI(domNs);
		assertEquals("https://ex.com/cust/contr/", domNsURI);
		VersionedDomainNamespace verNs = new VersionedDomainNamespace();
		verNs.setSubdomain(domNs);
		verNs.setVersion("2");
		assertEquals("https://ex.com/cust/contr/", provider.getUnversionedNamespaceURI(verNs));
	}
	
	@Test
	public void testGetVersionedNamespaceURIWithURI() {
		ServiceDslFactory f = ServiceDslFactory.eINSTANCE;
		OrganizationNamespace orgNs = f.createOrganizationNamespace();
		orgNs.setName("org.example");
		DomainNamespace domNs = f.createDomainNamespace();
		domNs.setName("customer.contract");
		domNs.setUri("https://ex.com/cust/contr/");
		orgNs.getSubNamespaces().add(domNs);
		
		String orgNsURI = provider.getVersionedNamespaceURI(orgNs);
		String domNsURI = provider.getVersionedNamespaceURI(domNs);
		assertEquals("https://ex.com/cust/contr/v1/", domNsURI);
		VersionedDomainNamespace verNs = new VersionedDomainNamespace();
		verNs.setSubdomain(domNs);
		verNs.setVersion("2");
		assertEquals("https://ex.com/cust/contr/v2/", provider.getVersionedNamespaceURI(verNs));
	}
	
	@Test
	public void testGetUnversionedNamespaceNoOrg() {
		ServiceDslFactory f = ServiceDslFactory.eINSTANCE;
		DomainNamespace domNs = f.createDomainNamespace();
		domNs.setName("org.example.customer.contract");
		String domNsURI = provider.getUnversionedNamespaceURI(domNs);
		assertEquals("http://example.org/customer/contract/", domNsURI);
		VersionedDomainNamespace verNs = new VersionedDomainNamespace();
		verNs.setSubdomain(domNs);
		verNs.setVersion("1");
		assertEquals("http://example.org/customer/contract/", provider.getUnversionedNamespaceURI(verNs));
	}
	
	@Test
	public void testGetVersionedNamespaceNoOrg() {
		ServiceDslFactory f = ServiceDslFactory.eINSTANCE;
		DomainNamespace domNs = f.createDomainNamespace();
		domNs.setName("org.example.customer.contract");
		String domNsURI = provider.getVersionedNamespaceURI(domNs);
		assertEquals("http://example.org/customer/contract/v1/", domNsURI);
		VersionedDomainNamespace verNs = new VersionedDomainNamespace();
		verNs.setSubdomain(domNs);
		verNs.setVersion("2");
		assertEquals("http://example.org/customer/contract/v2/", provider.getVersionedNamespaceURI(verNs));
	}
	@Test
	public void testGetUnversionedNamespaceNestedNoOrg() {
		ServiceDslFactory f = ServiceDslFactory.eINSTANCE;
		DomainNamespace domNs = f.createDomainNamespace();
		domNs.setName("org.example.customer.contract");
		InternalNamespace internalNs = f.createInternalNamespace();
		internalNs.setName("internal.legacy");
		domNs.getInteralNamespaces().add(internalNs);

		String intNsURI = provider.getUnversionedNamespaceURI(internalNs);
		assertEquals("http://example.org/customer/contract/internal/legacy/", intNsURI);
		VersionedDomainNamespace verNs = new VersionedDomainNamespace();
		verNs.setSubdomain(internalNs);
		verNs.setVersion("2");
		assertEquals("http://example.org/customer/contract/internal/legacy/", provider.getUnversionedNamespaceURI(verNs));
	}
	
	@Test
	public void testGetVersionedNamespaceNestedNoOrg() {
		ServiceDslFactory f = ServiceDslFactory.eINSTANCE;
		DomainNamespace domNs = f.createDomainNamespace();
		domNs.setName("org.example.customer.contract");
		InternalNamespace internalNs = f.createInternalNamespace();
		internalNs.setName("internal.legacy");
		domNs.getInteralNamespaces().add(internalNs);
		
		String intNsURI = provider.getVersionedNamespaceURI(internalNs);
		assertEquals("http://example.org/customer/contract/internal/legacy/v1/", intNsURI);
		VersionedDomainNamespace verNs = new VersionedDomainNamespace();
		verNs.setSubdomain(internalNs);
		verNs.setVersion("2");
		assertEquals("http://example.org/customer/contract/internal/legacy/v2/", provider.getVersionedNamespaceURI(verNs));
	}
	
	@Test
	public void testGetPathPart() {
		ServiceDslFactory f = ServiceDslFactory.eINSTANCE;
		DomainNamespace domNs = f.createDomainNamespace();
		domNs.setName("org.example.customer.contract");
		String domNsPathPart = provider.getPathPart(domNs);
		InternalNamespace internalNs = f.createInternalNamespace();
		internalNs.setName("internal.legacy");
		domNs.getInteralNamespaces().add(internalNs);
		String intNsPathPart = provider.getPathPart(internalNs);
		
		assertEquals("customer/contract", domNsPathPart);
		assertEquals("customer/contract/internal/legacy", intNsPathPart);
	}
	
	@Test
	public void testGetHostPartNoOrg() {
		ServiceDslFactory f = ServiceDslFactory.eINSTANCE;
		DomainNamespace domNs = f.createDomainNamespace();
		domNs.setName("org.example.customer.contract");
		String domNsHostPart = provider.getHostPart(domNs);
		InternalNamespace internalNs = f.createInternalNamespace();
		internalNs.setName("internal.legacy");
		domNs.getInteralNamespaces().add(internalNs);
		String intNsHostPart = provider.getHostPart(internalNs);
		
		assertEquals("http://example.org", domNsHostPart);
		assertEquals("http://example.org", intNsHostPart);
	}
	
	@Test
	public void testGetHostPartOrg() {
		ServiceDslFactory f = ServiceDslFactory.eINSTANCE;
		OrganizationNamespace orgNs = f.createOrganizationNamespace();
		orgNs.setName("org.example");
		DomainNamespace domNs = f.createDomainNamespace();
		domNs.setName("customer.contract");
		InternalNamespace internalNs = f.createInternalNamespace();
		internalNs.setName("internal.legacy");
		domNs.getInteralNamespaces().add(internalNs);
		orgNs.getSubNamespaces().add(domNs);

		
		String domNsHostPart = provider.getHostPart(domNs);
		String intNsHostPart = provider.getHostPart(internalNs);
		
		assertEquals("http://example.org", domNsHostPart);
		assertEquals("http://example.org", intNsHostPart);
	}

}
