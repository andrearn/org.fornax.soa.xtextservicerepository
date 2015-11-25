package org.xkonnex.repo.dsl.profiledsl.namespace;

import org.xkonnex.repo.dsl.profiledsl.profileDsl.OrganizationNamespace;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.TechnicalNamespace;
import org.xkonnex.repo.dsl.profiledsl.versioning.VersionedTechnicalNamespace;

import com.google.inject.ImplementedBy;

@ImplementedBy(DefaultProfileNamespaceURIProvider.class)
public interface ProfileNamespaceURIProvider {
	
	String getUnversionedNamespaceURI(OrganizationNamespace orgNs);
	String getUnversionedNamespaceURI(TechnicalNamespace ns);
	String getUnversionedNamespaceURI(VersionedTechnicalNamespace ns);
	
	String getVersionedNamespaceURI(OrganizationNamespace orgNs);
	String getVersionedNamespaceURI(TechnicalNamespace ns);
	String getVersionedNamespaceURI(VersionedTechnicalNamespace ns) ;

	String getHostPart (TechnicalNamespace d);
	String getHostPart (OrganizationNamespace d);
	
	String getPathPart(TechnicalNamespace ns);
	
	boolean requiresTrailingSlash (OrganizationNamespace o);
	boolean requiresTrailingSlash (TechnicalNamespace o);
	boolean requiresTrailingSlash (VersionedTechnicalNamespace o);

}
