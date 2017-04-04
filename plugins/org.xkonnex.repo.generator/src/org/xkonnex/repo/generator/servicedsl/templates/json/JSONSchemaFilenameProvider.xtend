package org.xkonnex.repo.generator.servicedsl.templates.json

import javax.inject.Inject
import javax.inject.Named
import org.eclipse.emf.ecore.EObject
import org.xkonnex.repo.dsl.basedsl.CommonStringExtensions
import org.xkonnex.repo.dsl.basedsl.namespace.VersionedNamespace
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace
import org.xkonnex.repo.dsl.servicedsl.service.namespace.ServiceNamespaceNameFragmentProvider
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DomainNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.InternalNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.OrganizationNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery

class JSONSchemaFilenameProvider {
		
	@Inject extension ServiceNamespaceNameFragmentProvider serviceNsNameFragmentProvider
	@Inject extension NamespaceQuery
	@Inject VersionQualifierExtensions versionQualifier	
	
	@Inject @Named ("useRegistryBasedFilePaths") 
	Boolean useRegistryBasedFilePaths
	
	@Inject @Named ("useNestedPaths") 
	Boolean useNestedPaths
	

	def boolean useRegistryBasedFilePaths () {
		useRegistryBasedFilePaths;
	}


	/**
	 * Calulates the URL to the Schema location
	 */
	def dispatch String toSchemaAssetUrl (Service s, String registryUrl) { 
		if (registryUrl != null && useRegistryBasedFilePaths() ) 
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
	
//	/**
//	 * Calculates a part of Schema filename
//	 */
//	def dispatch String toFileNameFragment (Service s) { 
//		s.eContainer.toFileNameFragment().replaceAll("\\." , "-") + "-" + s.name.stripXtextEscapes() + "-" + s.version.toVersionPostfix();
//	}
	
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
		ns.namespace.toFileNameFragment() + "-" + versionQualifier.toVersionPostfix(ns.version);
	}

	def dispatch String toFileNameFragment (VersionedType type) {
		val ns = type.findSubdomain
		ns.toFileNameFragment + "-" + type.name + "-" + versionQualifier.toVersionPostfix(type.version);
	}
		
		
}