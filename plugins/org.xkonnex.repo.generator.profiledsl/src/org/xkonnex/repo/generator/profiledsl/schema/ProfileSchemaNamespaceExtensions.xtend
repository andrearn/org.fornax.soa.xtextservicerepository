package org.xkonnex.repo.generator.profiledsl.schema

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.List
import org.xkonnex.repo.dsl.basedsl.CommonStringExtensions
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.dsl.profiledsl.profileDsl.OrganizationNamespace
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile
import org.xkonnex.repo.dsl.profiledsl.profileDsl.TechnicalNamespace
import org.xkonnex.repo.dsl.profiledsl.versioning.VersionedTechnicalNamespace
import org.xkonnex.repo.dsl.basedsl.baseDsl.Version
import org.xkonnex.repo.dsl.profiledsl.namespace.ProfileNamespaceURIProvider
import org.xkonnex.repo.dsl.profiledsl.query.namespace.TechnicalNamespaceQueries
import org.xkonnex.repo.dsl.profiledsl.namespace.ProfileNamespaceNameFragmentProvider
import org.xkonnex.repo.dsl.basedsl.namespace.NamespaceNameFragmentProvider

class ProfileSchemaNamespaceExtensions {
	
	@Inject extension ProfileNamespaceURIProvider nsURIProvider
	@Inject extension ProfileNamespaceNameFragmentProvider
	@Inject TechnicalNamespaceQueries nsQueries
	@Inject VersionQualifierExtensions versionQualifier
	@Inject NamespaceNameFragmentProvider baseDslNameFregmentProvider
	
	@Inject @Named ("useRegistryBasedFilePaths") 
	Boolean useRegistryBasedFilePaths
	
	@Inject @Named ("useNestedPaths") 
	Boolean useNestedPaths
		
	def dispatch String fqn (org.xkonnex.repo.dsl.profiledsl.profileDsl.OrganizationNamespace s) {
		baseDslNameFregmentProvider.getNamespaceFQN(s)
	}

	def dispatch List<TechnicalNamespace> toNamespacePath (Object o) {
		newArrayList();
	}

	def dispatch List<TechnicalNamespace> toNamespacePath (List<TechnicalNamespace> nsList) { 
		nsQueries.getSubNamespacePath(nsList.last)
	}
	
	
	def dispatch String fqn (TechnicalNamespace s) {
		baseDslNameFregmentProvider.getNamespaceFQN(s)
	}

	def dispatch String toPrefix(OrganizationNamespace o) {
		o.namespacePrefix
	}
	
	def dispatch String toPrefix (TechnicalNamespace s) {
		if (s.prefix != null) { 
			s.prefix;
		} else {
			s.namespacePrefix;
		}
	}
	
	def dispatch String toPrefix (VersionedTechnicalNamespace s) {
		s.namespacePrefix
	}
		
	def dispatch String toNamespace (OrganizationNamespace org) {
		org.namespaceURI
	}

	def dispatch String toNamespace (org.xkonnex.repo.dsl.profiledsl.profileDsl.TechnicalNamespace leafNamespace) {
		leafNamespace.namespaceURI
	}

	def dispatch boolean hasTrailingSlash (OrganizationNamespace ns) {
		false;
	}
	
	def dispatch boolean hasTrailingSlash (org.xkonnex.repo.dsl.profiledsl.profileDsl.TechnicalNamespace ns) {
		!ns.noTrailingSlash;
	}
		
	def dispatch String toVersionPostfix (Object o) { 
		throw new UnsupportedOperationException();
	}
	
	def dispatch String toVersionPostfix (Version v) {
		versionQualifier.toVersionPostfix(v);
	}

	def dispatch String toVersionPostfix (OrganizationNamespace d) {
		versionQualifier.toDefaultVersionPostfix();
	}
		
	def dispatch String toVersionPostfix (TechnicalNamespace s) {
		versionQualifier.toDefaultVersionPostfix();
	}
	
	def dispatch String toUnversionedNamespace (OrganizationNamespace domain) {
		"http://" + domain.name.split(".").reverse().join (".");
	}
	
	def dispatch String toUnversionedNamespace (TechnicalNamespace leafDomainNamespace) { 
		leafDomainNamespace.namespaceURI
	}
	
	def String toHostPart (org.xkonnex.repo.dsl.profiledsl.profileDsl.OrganizationNamespace d) {
		 d.name.split("\\.").reverse().join(".");
	}

		
	def org.xkonnex.repo.dsl.profiledsl.profileDsl.OrganizationNamespace findOrgNamespace (TechnicalNamespace o) { 
		nsQueries.findOrgNamespace(o)
	}
	
	def String toShortName (TechnicalNamespace s) {
		s.namespacePrefix
	}

	@Deprecated
	def String shorten (OrganizationNamespace d, Profile p) {
		d.organizationShortnameFragment
	}
	
	@Deprecated
	def dispatch String shorten (org.xkonnex.repo.dsl.profiledsl.profileDsl.OrganizationNamespace d) {
		d.organizationShortnameFragment
	}
	
	@Deprecated
	def dispatch String shorten (TechnicalNamespace d) {
		d.organizationShortnameFragment
	}

	 
	def dispatch String toRegistryAssetUrl (TechnicalNamespace s, String registryUrl) { 
		if (registryUrl != null && useRegistryBasedFilePaths ) 
			registryUrl + "/" + s.toFileNameFragment() 
		else
			s.toFileNameFragment();
	} 
	def dispatch String toRegistryAssetUrl (VersionedTechnicalNamespace s, String registryUrl) { 
		if (registryUrl != null && useRegistryBasedFilePaths ) 
			registryUrl + "/" +s.toFileNameFragment() 
		else
			s.toFileNameFragment(); 
	}
	
	def dispatch String toFileNameFragment (org.xkonnex.repo.dsl.profiledsl.profileDsl.TechnicalNamespace s) {
		s.organizationShortnameFragment.replaceAll("\\." , "-") + "-" + s.subNamespaceFragment.replaceAll("\\." , "-");
	}
	
	def dispatch String toFileNameFragment (VersionedTechnicalNamespace s) {
		s.namespace.toFileNameFragment() + "-v" + versionQualifier.toMajorVersionNumber(s.version);
	}
	
	def dispatch String toNamespace (VersionedTechnicalNamespace s) { 
		s.versionedNamespaceURI
	}
	
}