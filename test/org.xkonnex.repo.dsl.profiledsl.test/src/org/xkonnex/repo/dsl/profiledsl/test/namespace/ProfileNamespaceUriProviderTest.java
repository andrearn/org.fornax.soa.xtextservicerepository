package org.xkonnex.repo.dsl.profiledsl.test.namespace;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xkonnex.repo.dsl.profiledsl.namespace.ProfileNamespaceURIProvider;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.OrganizationNamespace;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.ProfileDslFactory;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.TechnicalNamespace;
import org.xkonnex.repo.dsl.profiledsl.test.ProfileDslWithDependenciesInjectorProvider;
import org.xkonnex.repo.dsl.profiledsl.versioning.VersionedTechnicalNamespace;

@RunWith(XtextRunner.class)
@InjectWith(ProfileDslWithDependenciesInjectorProvider.class)
public class ProfileNamespaceUriProviderTest {
	
	@Inject
	private ProfileNamespaceURIProvider provider;
	
	@Test
	public void testGetUnversionedNamespaceURI() {
		ProfileDslFactory f = ProfileDslFactory.eINSTANCE;
		Profile profile = f.createProfile();
		profile.setName("TestProfile");
		OrganizationNamespace orgNs = f.createOrganizationNamespace();
		orgNs.setName("org.example");
		TechnicalNamespace domNs = f.createTechnicalNamespace();
		domNs.setName("customer.contract");
		orgNs.getSubNamespaces().add(domNs);
		profile.getNamespaces().add(orgNs);

		String orgNsURI = provider.getNamespaceURI(orgNs);
		String domNsURI = provider.getNamespaceURI(domNs);
		assertEquals("http://example.org/", orgNsURI);
		assertEquals("http://example.org/customer/contract/", domNsURI);
		VersionedTechnicalNamespace verNs = new VersionedTechnicalNamespace();
		verNs.setNamespace(domNs);
		verNs.setVersion("1");
		assertEquals("http://example.org/customer/contract/", provider.getNamespaceURI(verNs));
	}
	
	@Test
	public void testGetVersionedNamespaceURI() {
		ProfileDslFactory f = ProfileDslFactory.eINSTANCE;
		Profile profile = f.createProfile();
		profile.setName("TestProfile");
		OrganizationNamespace orgNs = f.createOrganizationNamespace();
		orgNs.setName("org.example");
		TechnicalNamespace domNs = f.createTechnicalNamespace();
		domNs.setName("customer.contract");
		orgNs.getSubNamespaces().add(domNs);
		profile.getNamespaces().add(orgNs);
		
		String orgNsURI = provider.getVersionedNamespaceURI(orgNs);
		String domNsURI = provider.getVersionedNamespaceURI(domNs);
		assertEquals("http://example.org/v1/", orgNsURI);
		assertEquals("http://example.org/customer/contract/v1/", domNsURI);
		VersionedTechnicalNamespace verNs = new VersionedTechnicalNamespace();
		verNs.setNamespace(domNs);
		verNs.setVersion("2");
		assertEquals("http://example.org/customer/contract/v2/", provider.getVersionedNamespaceURI(verNs));
	}
	
	@Test
	public void testGetUnversionedNamespaceURIWithURI() {
		ProfileDslFactory f = ProfileDslFactory.eINSTANCE;
		Profile profile = f.createProfile();
		profile.setName("TestProfile");
		OrganizationNamespace orgNs = f.createOrganizationNamespace();
		orgNs.setName("org.example");
		TechnicalNamespace domNs = f.createTechnicalNamespace();
		domNs.setName("customer.contract");
		domNs.setUri("https://ex.com/cust/contr/");
		orgNs.getSubNamespaces().add(domNs);
		profile.getNamespaces().add(orgNs);
		
		String orgNsURI = provider.getNamespaceURI(orgNs);
		String domNsURI = provider.getNamespaceURI(domNs);
		assertEquals("https://ex.com/cust/contr/", domNsURI);
		VersionedTechnicalNamespace verNs = new VersionedTechnicalNamespace();
		verNs.setNamespace(domNs);
		verNs.setVersion("2");
		assertEquals("https://ex.com/cust/contr/", provider.getNamespaceURI(verNs));
	}
	
	@Test
	public void testGetVersionedNamespaceURIWithURI() {
		ProfileDslFactory f = ProfileDslFactory.eINSTANCE;
		Profile profile = f.createProfile();
		profile.setName("TestProfile");
		OrganizationNamespace orgNs = f.createOrganizationNamespace();
		orgNs.setName("org.example");
		TechnicalNamespace domNs = f.createTechnicalNamespace();
		domNs.setName("customer.contract");
		domNs.setUri("https://ex.com/cust/contr/");
		orgNs.getSubNamespaces().add(domNs);
		profile.getNamespaces().add(orgNs);
		
		String orgNsURI = provider.getVersionedNamespaceURI(orgNs);
		String domNsURI = provider.getVersionedNamespaceURI(domNs);
		assertEquals("https://ex.com/cust/contr/v1/", domNsURI);
		VersionedTechnicalNamespace verNs = new VersionedTechnicalNamespace();
		verNs.setNamespace(domNs);
		verNs.setVersion("2");
		assertEquals("https://ex.com/cust/contr/v2/", provider.getVersionedNamespaceURI(verNs));
	}
	
	@Test
	public void testGetUnversionedNamespaceNoOrg() {
		ProfileDslFactory f = ProfileDslFactory.eINSTANCE;
		Profile profile = f.createProfile();
		profile.setName("TestProfile");
		TechnicalNamespace domNs = f.createTechnicalNamespace();
		domNs.setName("org.example.customer.contract");
		profile.getNamespaces().add(domNs);

		String domNsURI = provider.getNamespaceURI(domNs);
		assertEquals("http://example.org/customer/contract/", domNsURI);
		VersionedTechnicalNamespace verNs = new VersionedTechnicalNamespace();
		verNs.setNamespace(domNs);
		verNs.setVersion("1");
		assertEquals("http://example.org/customer/contract/", provider.getNamespaceURI(verNs));
	}
	
	@Test
	public void testGetVersionedNamespaceNoOrg() {
		ProfileDslFactory f = ProfileDslFactory.eINSTANCE;
		Profile profile = f.createProfile();
		profile.setName("TestProfile");
		TechnicalNamespace domNs = f.createTechnicalNamespace();
		domNs.setName("org.example.customer.contract");
		profile.getNamespaces().add(domNs);

		String domNsURI = provider.getVersionedNamespaceURI(domNs);
		assertEquals("http://example.org/customer/contract/v1/", domNsURI);
		VersionedTechnicalNamespace verNs = new VersionedTechnicalNamespace();
		verNs.setNamespace(domNs);
		verNs.setVersion("2");
		assertEquals("http://example.org/customer/contract/v2/", provider.getVersionedNamespaceURI(verNs));
	}
	@Test
	public void testGetUnversionedNamespaceNestedNoOrg() {
		ProfileDslFactory f = ProfileDslFactory.eINSTANCE;
		Profile profile = f.createProfile();
		profile.setName("TestProfile");
		TechnicalNamespace domNs = f.createTechnicalNamespace();
		domNs.setName("org.example.customer.contract");
		profile.getNamespaces().add(domNs);

		VersionedTechnicalNamespace verNs = new VersionedTechnicalNamespace();
		verNs.setNamespace(domNs);
		verNs.setVersion("2");
		assertEquals("http://example.org/customer/contract/", provider.getNamespaceURI(verNs));
	}
	
	@Test
	public void testGetVersionedNamespaceNestedNoOrg() {
		ProfileDslFactory f = ProfileDslFactory.eINSTANCE;
		TechnicalNamespace domNs = f.createTechnicalNamespace();
		domNs.setName("org.example.customer.contract");
		
		VersionedTechnicalNamespace verNs = new VersionedTechnicalNamespace();
		verNs.setNamespace(domNs);
		verNs.setVersion("2");
		assertEquals("http://example.org/customer/contract/v2/", provider.getVersionedNamespaceURI(verNs));
	}
	
	@Test
	public void testGetPathPart() {
		ProfileDslFactory f = ProfileDslFactory.eINSTANCE;
		Profile profile = f.createProfile();
		profile.setName("TestProfile");
		TechnicalNamespace domNs = f.createTechnicalNamespace();
		domNs.setName("org.example.customer.contract");
		profile.getNamespaces().add(domNs);

		String domNsPathPart = provider.getPathPart(domNs);
		
		assertEquals("customer/contract", domNsPathPart);
	}
	
	@Test
	public void testGetHostPartNoOrg() {
		ProfileDslFactory f = ProfileDslFactory.eINSTANCE;
		Profile profile = f.createProfile();
		profile.setName("TestProfile");
		TechnicalNamespace domNs = f.createTechnicalNamespace();
		domNs.setName("org.example.customer.contract");
		profile.getNamespaces().add(domNs);

		String domNsHostPart = provider.getHostPart(domNs);
		
		assertEquals("http://example.org", domNsHostPart);
	}
	
	@Test
	public void testGetHostPartOrg() {
		ProfileDslFactory f = ProfileDslFactory.eINSTANCE;
		Profile profile = f.createProfile();
		profile.setName("TestProfile");
		OrganizationNamespace orgNs = f.createOrganizationNamespace();
		orgNs.setName("org.example");
		TechnicalNamespace domNs = f.createTechnicalNamespace();
		domNs.setName("customer.contract");
		orgNs.getSubNamespaces().add(domNs);
		profile.getNamespaces().add(orgNs);
		
		String domNsHostPart = provider.getHostPart(domNs);
		
		assertEquals("http://example.org", domNsHostPart);
	}

}
