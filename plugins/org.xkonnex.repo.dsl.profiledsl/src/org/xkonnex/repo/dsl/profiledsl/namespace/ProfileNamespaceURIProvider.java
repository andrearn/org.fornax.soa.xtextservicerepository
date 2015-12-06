package org.xkonnex.repo.dsl.profiledsl.namespace;

import org.xkonnex.repo.dsl.basedsl.baseDsl.Namespace;
import org.xkonnex.repo.dsl.basedsl.namespace.VersionedNamespace;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.OrganizationNamespace;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.TechnicalNamespace;
import org.xkonnex.repo.dsl.profiledsl.versioning.VersionedTechnicalNamespace;

import com.google.inject.ImplementedBy;

@ImplementedBy(DefaultProfileNamespaceURIProvider.class)
public interface ProfileNamespaceURIProvider {
	
	String getNamespaceURI(OrganizationNamespace orgNs);
	String getNamespaceURI(TechnicalNamespace ns);
	String getNamespaceURI(VersionedTechnicalNamespace ns);
	
	String getVersionedNamespaceURI(OrganizationNamespace orgNs);
	String getVersionedNamespaceURI(TechnicalNamespace ns);
	String getVersionedNamespaceURI(VersionedTechnicalNamespace ns) ;
	
	String getNamespacePrefix(String qualifiedNameFragment);
	String getNamespacePrefix(Namespace ns);
	String getNamespacePrefix(VersionedNamespace ns);
	String getOrgNamespacePrefix(String qualifiedNameFragment);
	String getOrgNamespacePrefix(Namespace ns);
	String getOrgNamespacePrefix(VersionedNamespace ns);
	
	String getVersionedNamespacePrefix(String qualifiedNameFragment);
	String getVersionedNamespacePrefix(Namespace ns);
	String getVersionedNamespacePrefix(VersionedNamespace ns);

	String getHostPart (TechnicalNamespace d);
	String getHostPart (OrganizationNamespace d);
	
	String getPathPart(TechnicalNamespace ns);
	
	boolean requiresTrailingSlash (OrganizationNamespace o);
	boolean requiresTrailingSlash (TechnicalNamespace o);
	boolean requiresTrailingSlash (VersionedTechnicalNamespace o);

}
