package org.xkonnex.repo.dsl.profiledsl.namespace;

import org.xkonnex.repo.dsl.basedsl.baseDsl.Namespace;
import org.xkonnex.repo.dsl.basedsl.namespace.VersionedNamespace;

import com.google.inject.ImplementedBy;

@ImplementedBy(DefaultProfileNamespaceNameFragmentProvider.class)
public interface ProfileNamespaceNameFragmentProvider {
	
	String getOrganizationNameFragment(Namespace ns);
	String getOrganizationNameFragment(VersionedNamespace ns);
	
	String getSubNamespaceFragment(Namespace ns);
	String getSubNamespaceFragment(VersionedNamespace ns);

	String getOrganizationShortnameFragment(Namespace ns);
	String getOrganizationShortnameFragment(VersionedNamespace ns);

}
