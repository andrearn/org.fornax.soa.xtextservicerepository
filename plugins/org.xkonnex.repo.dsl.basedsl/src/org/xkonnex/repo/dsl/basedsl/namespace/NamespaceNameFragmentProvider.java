package org.xkonnex.repo.dsl.basedsl.namespace;

import org.xkonnex.repo.dsl.basedsl.baseDsl.Namespace;

import com.google.inject.ImplementedBy;

@ImplementedBy(DefaultNamespaceNameFragmentProvider.class)
public interface NamespaceNameFragmentProvider {
	
	String getOrganizationNameFragment(String qualfiedNamespaceName);
	String getOrganizationNameFragment(Namespace ns);
	String getOrganizationNameFragment(VersionedNamespace ns);
	
	String getSubNamespaceFragment(String qualfiedNamespaceName);
	String getSubNamespaceFragment(Namespace ns);
	String getSubNamespaceFragment(VersionedNamespace ns);

}
