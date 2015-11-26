package org.xkonnex.repo.dsl.servicedsl.service.namespace;

import org.xkonnex.repo.dsl.basedsl.baseDsl.Namespace;
import org.xkonnex.repo.dsl.basedsl.namespace.VersionedNamespace;

import com.google.inject.ImplementedBy;

@ImplementedBy(DefaultServiceNamespaceNameFragmentProvider.class)
public interface ServiceNamespaceNameFragmentProvider {
	
	String getOrganizationNameFragment(Namespace ns);
	String getOrganizationNameFragment(VersionedNamespace ns);
	
	String getSubNamespaceFragment(Namespace ns);
	String getSubNamespaceFragment(VersionedNamespace ns);

}
