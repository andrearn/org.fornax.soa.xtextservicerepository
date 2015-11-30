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

/*
 * domains.ext
 */
class SchemaNamespaceExtensions {
	
	@Inject extension CommonStringExtensions
	@Inject extension NamespaceQuery
	@Inject extension ServiceNamespaceURIProvider serviceNsURIProvider
	@Inject extension ServiceNamespaceNameFragmentProvider serviceNsNameFragmentProvider
	@Inject ProfileNamespaceURIProvider profileNsURIProvider
	@Inject NamespaceURIProvider nsURIProvider
	@Inject VersionQualifierExtensions versionQualifier	
	
	@Inject @Named ("useRegistryBasedFilePaths") 
	Boolean useRegistryBasedFilePaths
	
	@Inject @Named ("useNestedPaths") 
	Boolean useNestedPaths
	
	@Inject IQualifiedNameProvider nameProvider
	

	def boolean useRegistryBasedFilePaths () {
		useRegistryBasedFilePaths;
	}

	def dispatch String toUnversionedNamespace (Object o) {
		"unknown";
	}
	
	def dispatch String toNamespace (EObject o) {
		null;
	}
	
	def dispatch String toNamespace (OrganizationNamespace orgNs) {
		serviceNsURIProvider.getVersionedNamespaceURI(orgNs)
	}
	
	def dispatch String toNamespace (SubNamespace leafDomainNamespace) { 
		serviceNsURIProvider.getVersionedNamespaceURI(leafDomainNamespace)
	}
	
	def dispatch String toNamespace (VersionedDomainNamespace versionedNamespace) { 
		serviceNsURIProvider.getVersionedNamespaceURI(versionedNamespace)
	}
	

	def dispatch boolean hasTrailingSlash (Object o) {
		true;
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
	
	def dispatch String toVersionPostfix (DomainNamespace s) {
		if (s.version != null && s.version.version != null ) 
			versionQualifier.toVersionPostfix(s.version) 
		else
			versionQualifier.toDefaultVersionPostfix();
	}
		
	def dispatch String toVersionPostfix (VersionedDomainNamespace s) {
		if (s.version != null) 
			versionQualifier.toVersionPostfix(s.version) 
		else
			versionQualifier.toDefaultVersionPostfix();
	}

	
	def dispatch String toUnversionedNamespace (OrganizationNamespace namespace) {
		serviceNsURIProvider.getUnversionedNamespaceURI(namespace)
	}
	
	def dispatch String toUnversionedNamespace (SubNamespace namespace) {
		serviceNsURIProvider.getUnversionedNamespaceURI(namespace)
	}
	
	def dispatch String toUnversionedNamespace (VersionedDomainNamespace namespace) {
		serviceNsURIProvider.getUnversionedNamespaceURI(namespace)
	}

	def dispatch String toHostPart (OrganizationNamespace d) {
		serviceNsURIProvider.getHostPart(d)
	}

	def dispatch String toHostPart (SubNamespace d) {
		serviceNsURIProvider.getHostPart(d)
	}
	
	def List<SubNamespace> toSubNamespacePath (List<SubNamespace> domList) {
		if (domList.last()?.eContainer instanceof SubNamespace) {
			domList.add (domList.last().eContainer as SubNamespace) 
			toSubNamespacePath (domList);
			return domList;
		} else { 
			return domList.filter (typeof (SubNamespace)).toList().reverse();
		}
	}

		
	def dispatch String toShortName(SubNamespace s) {
				serviceNsURIProvider.getNamespacePrefix(s)
		s.namespacePrefix
	}
	
	def dispatch String toShortName(TechnicalNamespace s) {
		profileNsURIProvider.getNamespacePrefix(s)
	}


	def dispatch String toSchemaAssetUrl (Service s, String registryUrl) { 
		if (registryUrl != null && useRegistryBasedFilePaths() ) 
			registryUrl + "/" + s.toFileNameFragment() 
		else
			s.toFileNameFragment();
	}
		
	def dispatch String toSchemaAssetUrl (OrganizationNamespace s, String registryUrl) { 
		if (registryUrl != null && useRegistryBasedFilePaths() ) 
			registryUrl + "/" + s.toFileNameFragment() 
		else
			s.toFileNameFragment();
	}
			
	def dispatch String toSchemaAssetUrl (DomainNamespace s, String registryUrl) { 
		if (registryUrl != null && useRegistryBasedFilePaths() ) 
			registryUrl + "/" + s.toFileNameFragment() 
		else
			s.toFileNameFragment();
	} 
	
	def dispatch String toSchemaAssetUrl (InternalNamespace s, String registryUrl) {
		if (registryUrl != null && useRegistryBasedFilePaths() ) 
			registryUrl + "/" + s.toFileNameFragment() 
		else
			s.toFileNameFragment();
	}
	def dispatch String toSchemaAssetUrl (VersionedDomainNamespace s, String registryUrl) { 
		if (registryUrl != null && useRegistryBasedFilePaths() ) 
			registryUrl + "/" +s.toFileNameFragment() 
		else
			s.toFileNameFragment(); 
	}
	
	
	def dispatch String toSchemaAssetUrl (EObject o, Void registryUrl) {
		null;
	}
	
	def dispatch String toSchemaAssetUrl (Service s, Void registryUrl) { 
		s.toFileNameFragment();
	}
		
	def dispatch String toSchemaAssetUrl (OrganizationNamespace s, Void registryUrl) { 
		s.toFileNameFragment(); 
	}
	
	def dispatch String toSchemaAssetUrl (DomainNamespace s, Void registryUrl) {
		s.toFileNameFragment();
	}
	
	def dispatch String toSchemaAssetUrl (InternalNamespace s, Void registryUrl) { 
		s.toFileNameFragment(); 
	}
	
	def dispatch String toSchemaAssetUrl (VersionedDomainNamespace s, Void registryUrl) { 
		s.toFileNameFragment();
	}
	
	
	def dispatch String toFileNameFragment (EObject s) {
		null;
	}
	
	def dispatch String toFileNameFragment (Service s) { 
		s.eContainer.toFileNameFragment().replaceAll("\\." , "-") + "-" + s.name.stripXtextEscapes() + "-" + s.version.toVersionPostfix();
	}
	
	def dispatch String toFileNameFragment (OrganizationNamespace ns) {
		ns.organizationShortnameFragment.replaceAll("\\." , "-");
	}
	
	def dispatch String toFileNameFragment (SubNamespace ns) {
		ns.organizationShortnameFragment.replaceAll("\\." , "-") + "-" + ns.subNamespaceFragment.replaceAll("\\." , "-")
	}
	
	def dispatch String toFileNameFragment (VersionedNamespace ns) {
		ns.namespace.toFileNameFragment() + "-v" + versionQualifier.toMajorVersionNumber(ns.version);
	}
		
	
	def dispatch String toShortName (OrganizationNamespace d) {
		if (d.prefix != null) {
			d.prefix;
		} else { 
			d.name;
		}
	}
		
	
	/*
	 * 	XML Namespace prefixes / aliases
	 */
	def dispatch String toPrefix(EObject o) {
		"tns";
	}
	def dispatch String toPrefix(Namespace s) {
		serviceNsURIProvider.getNamespacePrefix(s)
	}
	def dispatch String toPrefix(TechnicalNamespace s) {
		profileNsURIProvider.getNamespacePrefix(s)
	}
	def dispatch String toPrefix(org.xkonnex.repo.dsl.profiledsl.profileDsl.OrganizationNamespace s) {
		profileNsURIProvider.getNamespacePrefix(s)
	}
		
	def dispatch String toPrefix (VersionedNamespace s) {
		serviceNsURIProvider.getNamespacePrefix(s)
	}
	
}