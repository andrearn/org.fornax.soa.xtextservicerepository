package org.xkonnex.repo.dsl.servicedsl.service.namespace;

import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.OrganizationNamespace;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace;

import com.google.inject.ImplementedBy;

@ImplementedBy(DefaultServiceNamespaceUriProvider.class)
public interface ServiceNamespaceURIProvider {
	
	String getUnversionedNamespaceURI(OrganizationNamespace orgNs);
	String getUnversionedNamespaceURI(SubNamespace ns);
	String getUnversionedNamespaceURI(VersionedDomainNamespace ns);
	
	String getVersionedNamespaceURI(OrganizationNamespace orgNs);
	String getVersionedNamespaceURI(SubNamespace ns);
	String getVersionedNamespaceURI(VersionedDomainNamespace ns) ;

	String getHostPart (SubNamespace d);
	String getHostPart (OrganizationNamespace d);
	
	String getPathPart(SubNamespace ns);
	
	boolean requiresTrailingSlash (OrganizationNamespace o);
	boolean requiresTrailingSlash (SubNamespace o);
	boolean requiresTrailingSlash (VersionedDomainNamespace o);

}
