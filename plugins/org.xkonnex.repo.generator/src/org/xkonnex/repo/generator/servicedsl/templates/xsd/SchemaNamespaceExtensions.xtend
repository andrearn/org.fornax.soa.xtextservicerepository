package org.xkonnex.repo.generator.servicedsl.templates.xsd

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.xkonnex.repo.dsl.basedsl.CommonStringExtensions
import org.xkonnex.repo.dsl.basedsl.baseDsl.Namespace
import org.xkonnex.repo.dsl.basedsl.baseDsl.Version
import org.xkonnex.repo.dsl.basedsl.namespace.NamespaceURIProvider
import org.xkonnex.repo.dsl.basedsl.namespace.VersionedNamespace
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.dsl.profiledsl.profileDsl.TechnicalNamespace
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace
import org.xkonnex.repo.dsl.servicedsl.service.namespace.ServiceNamespaceNameFragmentProvider
import org.xkonnex.repo.dsl.servicedsl.service.namespace.ServiceNamespaceURIProvider
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DomainNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.InternalNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.OrganizationNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.dsl.profiledsl.namespace.ProfileNamespaceURIProvider

/**
 * Helper functions for XML Schema declarations and definitions
 */
class SchemaNamespaceExtensions {
	
	@Inject extension CommonStringExtensions
	@Inject extension NamespaceQuery
	@Inject extension ServiceNamespaceURIProvider serviceNsURIProvider
	@Inject extension ServiceNamespaceNameFragmentProvider serviceNsNameFragmentProvider
	@Inject ProfileNamespaceURIProvider profileNsURIProvider
	@Inject VersionQualifierExtensions versionQualifier	
	
	@Inject @Named ("useRegistryBasedFilePaths") 
	Boolean useRegistryBasedFilePaths
	
	@Inject @Named ("useNestedPaths") 
	Boolean useNestedPaths
	

	def boolean useRegistryBasedFilePaths () {
		useRegistryBasedFilePaths;
	}

	/**
	 * @deprecated Use {ServiceNamespaceURIProvider#getNamespaceURI(Namespace)}
	 */
	@Deprecated
	def dispatch String toUnversionedNamespace (Object o) {
		"unknown";
	}
	
	/**
	 * @deprecated Use {ServiceNamespaceURIProvider#getNamespaceURI(Namespace)}
	 */
	@Deprecated
	def dispatch String toNamespace (EObject o) {
		null;
	}
	
	/**
	 * @deprecated Use {ServiceNamespaceURIProvider#getVersionedNamespaceURI(Namespace)}
	 */
	@Deprecated
	def dispatch String toNamespace (OrganizationNamespace orgNs) {
		orgNs.versionedNamespaceURI
	}
	
	/**
	 * @deprecated Use {ServiceNamespaceURIProvider#getVersionedNamespaceURI(Namespace)}
	 */
	@Deprecated
	def dispatch String toNamespace (SubNamespace leafDomainNamespace) {
		leafDomainNamespace.versionedNamespaceURI
	}
	
	/**
	 * @deprecated Use {ServiceNamespaceURIProvider#getVersionedNamespaceURI(VersionedNamespace)}
	 */
	@Deprecated
	def dispatch String toNamespace (VersionedDomainNamespace versionedNamespace) { 
		versionedNamespace.versionedNamespaceURI
	}
	

	/**
	 * @deprecated Use {ServiceNamespaceURIProvider#getVersionPostfix(Namespace)}
	 */
	@Deprecated
	def dispatch String toVersionPostfix (Object o) { 
		throw new UnsupportedOperationException();
	}
	/**
	 * @deprecated Use {VersionQualifierExtensions#getVersionPostfix(Version)}
	 */
	@Deprecated
	def dispatch String toVersionPostfix (Version v) {
		versionQualifier.toVersionPostfix(v);
	}
	
	/**
	 * @deprecated Use {ServiceNamespaceURIProvider#getVersionPostfix(Namespace)}
	 */
	@Deprecated
	def dispatch String toVersionPostfix (OrganizationNamespace d) {
		d.versionPostfix
	}
	
	/**
	 * @deprecated Use {ServiceNamespaceURIProvider#getVersionPostfix(Namespace)}
	 */
	@Deprecated
	def dispatch String toVersionPostfix (DomainNamespace s) {
		s.versionPostfix
	}
		
	/**
	 * @deprecated Use {ServiceNamespaceURIProvider#getVersionPostfix(VersionedNamespace)}
	 */
	@Deprecated
	def dispatch String toVersionPostfix (VersionedDomainNamespace s) {
		s.versionPostfix
	}

	
	/**
	 * @deprecated Use {ServiceNamespaceURIProvider#getNamespaceURI(Namespace)}
	 */
	@Deprecated
	def dispatch String toUnversionedNamespace (OrganizationNamespace namespace) {
		namespace.namespaceURI
	}
	
	/**
	 * @deprecated Use {ServiceNamespaceURIProvider#getNamespaceURI(Namespace)}
	 */
	@Deprecated
	def dispatch String toUnversionedNamespace (SubNamespace namespace) {
		namespace.namespaceURI
	}
	
	/**
	 * @deprecated Use {ServiceNamespaceURIProvider#getNamespaceURI(Namespace)}
	 */
	@Deprecated
	def dispatch String toUnversionedNamespace (VersionedDomainNamespace namespace) {
		namespace.namespaceURI
	}

	/**
	 * @deprecated Use {ServiceNamespaceURIProvider#getNamespaceURI(Namespace)}
	 */
	@Deprecated
	def dispatch String toHostPart (OrganizationNamespace d) {
		d.hostPart
	}

	@Deprecated
	def dispatch String toHostPart (SubNamespace d) {
		d.hostPart
	}
	
	/**
	 * @deprecated Use NamespaceQuery#getSubNamespacePath(SubNamespace)
	 */
	@Deprecated
	def List<SubNamespace> toSubNamespacePath (List<SubNamespace> domList) {
		domList.last.subNamespacePath
	}

	/**
	 * @deprecated Use {ServiceNamespaceURIProvider#getNamespacePrefix(Namespace)}
	 */
	@Deprecated		
	def dispatch String toShortName(SubNamespace s) {
		s.namespacePrefix
	}
	
	/**
	 * @deprecated Use {ProfileNamespaceURIProvider#getNamespacePrefix(Namespace)}
	 */
	@Deprecated
	def dispatch String toShortName(TechnicalNamespace s) {
		profileNsURIProvider.getNamespacePrefix(s)
	}

	/**
	 * XML Namespace prefixes / aliases
	 * @deprecated Use {@link ServiceNamespaceURIProvider#getNamespacePrefix(Namespace)}
	 */
	@Deprecated
	def dispatch String toShortName (OrganizationNamespace d) {
		d.namespacePrefix
	}

	/**
	 * Calulates the URL to the Schema location
	 */
	def dispatch String toSchemaAssetUrl (Service s, String registryUrl) { 
		if (registryUrl !== null && useRegistryBasedFilePaths() ) 
			registryUrl + "/" + s.toFileNameFragment() 
		else
			s.toFileNameFragment();
	}
		
	/**
	 * Calulates the URL to the Schema location
	 */
	def dispatch String toSchemaAssetUrl (OrganizationNamespace s, String registryUrl) { 
		if (registryUrl !== null && useRegistryBasedFilePaths() ) 
			registryUrl + "/" + s.toFileNameFragment() 
		else
			s.toFileNameFragment();
	}
			
	/**
	 * Calulates the URL to the Schema location
	 */
	def dispatch String toSchemaAssetUrl (DomainNamespace s, String registryUrl) { 
		if (registryUrl !== null && useRegistryBasedFilePaths() ) 
			registryUrl + "/" + s.toFileNameFragment() 
		else
			s.toFileNameFragment();
	} 
	
	/**
	 * Calulates the URL to the Schema location
	 */
	def dispatch String toSchemaAssetUrl (InternalNamespace s, String registryUrl) {
		if (registryUrl !== null && useRegistryBasedFilePaths() ) 
			registryUrl + "/" + s.toFileNameFragment() 
		else
			s.toFileNameFragment();
	}
	/**
	 * Calulates the URL to the Schema location
	 */
	def dispatch String toSchemaAssetUrl (VersionedDomainNamespace s, String registryUrl) { 
		if (registryUrl !== null && useRegistryBasedFilePaths() ) 
			registryUrl + "/" +s.toFileNameFragment() 
		else
			s.toFileNameFragment(); 
	}
	
	
	/**
	 * Calulates the URL to the Schema location
	 */
	def dispatch String toSchemaAssetUrl (EObject o, Void registryUrl) {
		null;
	}
	
	/**
	 * Calulates the URL to the Schema location
	 */
	def dispatch String toSchemaAssetUrl (Service s, Void registryUrl) { 
		s.toFileNameFragment();
	}
		
	/**
	 * Calulates the URL to the Schema location
	 */
	def dispatch String toSchemaAssetUrl (OrganizationNamespace s, Void registryUrl) { 
		s.toFileNameFragment(); 
	}
	
	/**
	 * Calulates the URL to the Schema location
	 */
	def dispatch String toSchemaAssetUrl (DomainNamespace s, Void registryUrl) {
		s.toFileNameFragment();
	}
	
	def dispatch String toSchemaAssetUrl (InternalNamespace s, Void registryUrl) { 
		s.toFileNameFragment(); 
	}
	
	def dispatch String toSchemaAssetUrl (VersionedDomainNamespace s, Void registryUrl) { 
		s.toFileNameFragment();
	}
	
	/**
	 * Calculates a part of Schema filename
	 */
	def dispatch String toFileNameFragment (EObject s) {
		null;
	}
	
	/**
	 * Calculates a part of Schema filename
	 */
	def dispatch String toFileNameFragment (Service s) { 
		s.eContainer.toFileNameFragment().replaceAll("\\." , "-") + "-" + s.name.stripXtextEscapes() + "-" + s.version.toVersionPostfix();
	}
	
	/**
	 * Calculates a part of Schema filename
	 */
	def dispatch String toFileNameFragment (OrganizationNamespace ns) {
		ns.organizationShortnameFragment.replaceAll("\\." , "-");
	}
	
	/**
	 * Calculates a part of Schema filename
	 */
	def dispatch String toFileNameFragment (SubNamespace ns) {
		ns.organizationShortnameFragment.replaceAll("\\." , "-") + "-" + ns.subNamespaceFragment.replaceAll("\\." , "-")
	}
	
	/**
	 * Calculates a part of Schema filename
	 */
	def dispatch String toFileNameFragment (VersionedNamespace ns) {
		ns.namespace.toFileNameFragment() + "-v" + versionQualifier.toMajorVersionNumber(ns.version);
	}
		
	
		
	
	/**
	 * XML Namespace prefixes / aliases
	 * @deprecated Use {@link ServiceNamespaceURIProvider#getNamespacePrefix(Namespace)}
	 */
	@Deprecated
	def dispatch String toPrefix(EObject o) {
		"tns";
	}
	/**
	 * XML Namespace prefixes / aliases
	 * @deprecated Use {@link ServiceNamespaceURIProvider#getNamespacePrefix(Namespace)}
	 */
	@Deprecated
	def dispatch String toPrefix(Namespace s) {
		serviceNsURIProvider.getNamespacePrefix(s)
	}
	/**
	 * XML Namespace prefixes / aliases
	 * @deprecated Use {@link ProfileNamespaceURIProvider#getNamespacePrefix(Namespace)}
	 */
	@Deprecated
	def dispatch String toPrefix(TechnicalNamespace s) {
		profileNsURIProvider.getNamespacePrefix(s)
	}
	
	/**
	 * XML Namespace prefixes / aliases
	 * @deprecated Use {@link ProfileNamespaceURIProvider#getNamespacePrefix(Namespace)}
	 */
	@Deprecated
	def dispatch String toPrefix(org.xkonnex.repo.dsl.profiledsl.profileDsl.OrganizationNamespace s) {
		profileNsURIProvider.getNamespacePrefix(s)
	}
		
	/**
	 * XML Namespace prefixes / aliases
	 * @deprecated Use {@link ServiceNamespaceURIProvider#getNamespacePrefix(VersionedNamespace)}
	 */
	@Deprecated
	def dispatch String toPrefix (VersionedNamespace s) {
		serviceNsURIProvider.getNamespacePrefix(s)
	}
	
}