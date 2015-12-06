package org.xkonnex.repo.dsl.servicedsl.service.namespace;

import org.xkonnex.repo.dsl.basedsl.baseDsl.Namespace;
import org.xkonnex.repo.dsl.basedsl.namespace.VersionedNamespace;

import com.google.inject.ImplementedBy;

@ImplementedBy(DefaultServiceNamespaceNameFragmentProvider.class)
public interface ServiceNamespaceNameFragmentProvider {
	
	/**
	 * Calculates the logical fully qualified name of the namespace
	 * @param ns The namespace
	 * @return The namspace's logical FQN
	 */
	String getNamespaceFQN (Namespace ns);
	
	String getOrganizationNameFragment(Namespace ns);
	String getOrganizationNameFragment(VersionedNamespace ns);
	
	String getSubNamespaceFragment(Namespace ns);
	String getSubNamespaceFragment(VersionedNamespace ns);

	String getOrganizationShortnameFragment(Namespace ns);
	String getOrganizationShortnameFragment(VersionedNamespace ns);

}
