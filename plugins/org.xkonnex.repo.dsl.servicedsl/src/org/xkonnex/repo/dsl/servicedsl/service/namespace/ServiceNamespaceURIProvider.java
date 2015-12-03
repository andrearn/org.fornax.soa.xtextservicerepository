package org.xkonnex.repo.dsl.servicedsl.service.namespace;

import org.xkonnex.repo.dsl.basedsl.baseDsl.Namespace;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Version;
import org.xkonnex.repo.dsl.basedsl.namespace.NamespaceURIProvider;
import org.xkonnex.repo.dsl.basedsl.namespace.VersionedNamespace;
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.OrganizationNamespace;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace;

import com.google.inject.ImplementedBy;

@ImplementedBy(DefaultServiceNamespaceUriProvider.class)
public interface ServiceNamespaceURIProvider {
	
	String getNamespaceURI(Namespace orgNs);
	String getNamespaceURI(VersionedNamespace ns);
	
	String getVersionedNamespaceURI(Namespace ns);
	String getVersionedNamespaceURI(VersionedNamespace ns) ;

	String getHostPart (SubNamespace d);
	String getHostPart (OrganizationNamespace d);
	
	String getPathPart(SubNamespace ns);
	
	boolean requiresTrailingSlash (OrganizationNamespace o);
	boolean requiresTrailingSlash (SubNamespace o);
	boolean requiresTrailingSlash (VersionedNamespace o);
	
	String getNamespacePrefix(String qualifiedNameFragment);
	String getNamespacePrefix(Namespace ns);
	String getNamespacePrefix(VersionedNamespace ns);
	String getOrgNamespacePrefix(String qualifiedNameFragment);
	String getOrgNamespacePrefix(Namespace ns);
	String getOrgNamespacePrefix(VersionedNamespace ns);
	
	String getVersionedNamespacePrefix(String qualifiedNameFragment);
	String getVersionedNamespacePrefix(Namespace ns);
	String getVersionedNamespacePrefix(VersionedNamespace ns);
	
	String getVersionPostfix(Namespace ns);

}
