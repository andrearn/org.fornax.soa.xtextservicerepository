package org.xkonnex.repo.generator.servicedsl.templates.xsd

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.ArrayList
import java.util.List
import java.util.Set
import org.eclipse.emf.common.util.TreeIterator
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.xkonnex.repo.dsl.basedsl.CommonEObjectExtensions
import org.xkonnex.repo.dsl.basedsl.CommonStringExtensions
import org.xkonnex.repo.dsl.basedsl.baseDsl.Version
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.profileDsl.TechnicalNamespace
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace
import org.xkonnex.repo.dsl.servicedsl.service.query.ExceptionFinder
import org.xkonnex.repo.dsl.servicedsl.service.query.ServiceQueries
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.dsl.servicedsl.service.query.type.TypesByLifecycleStateFinder
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DomainNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.EnumTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.InternalNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.OrganizationNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceModel
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import com.google.common.collect.Lists

/*
 * domains.ext
 */
class SchemaNamespaceExtensions {
	
	@Inject extension CommonStringExtensions
	@Inject extension NamespaceQuery

	@Inject VersionQualifierExtensions versionQualifier
	
	@Inject @Named ("useRegistryBasedFilePaths") 
	Boolean useRegistryBasedFilePaths
	
	@Inject @Named ("useNestedPaths") 
	Boolean useNestedPaths
	
	@Inject IQualifiedNameProvider nameProvider
	
	val NUM_OF_HOST_PARTS = 2



	def boolean useRegistryBasedFilePaths () {
		useRegistryBasedFilePaths;
	}

	def dispatch String toUnversionedNamespace (Object o) {
		"unknown";
	}

	def dispatch String fqn (SubNamespace s) {
		(s.findOrgNamespace() as OrganizationNamespace).name.stripXtextEscapes() + "."
			 + toSubNamespacePath(newArrayList(s)).map(n|n.name.stripXtextEscapes()).join(".");
	}
	
	def dispatch String toNamespace (EObject o) {
		null;
	}
	
	def dispatch String toNamespace (OrganizationNamespace domain) {
		var ns = domain.toUnversionedNamespace() + "/" + domain.toVersionPostfix();
		if (domain.hasTrailingSlash() ) {
			return ns + ("/"); 
		} else {
			return ns + "";
		}
	}
	
	def dispatch String toNamespace (SubNamespace leafDomainNamespace) { 
		var ns = leafDomainNamespace.toUnversionedNamespace() +  "/" + leafDomainNamespace.toVersionPostfix();
		if (leafDomainNamespace.hasTrailingSlash() ) {
			return ns + ("/"); 
		} else {
			return ns + "";
		}
	}
	
	def dispatch String toNamespace (VersionedDomainNamespace s) { 
		var ns = s.subdomain.toUnversionedNamespace().stripXtextEscapes() + "/" + s.toVersionPostfix(); 
		if (s.subdomain.hasTrailingSlash() )  {
			return ns + ("/"); 
		} else {
			return ns + "";
		}
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
		"http://" + namespace.name.split(".").reverse().join (".");
	}
	
	def dispatch String toUnversionedNamespace (SubNamespace leafDomainNamespace) {
		val orgNs = leafDomainNamespace.findOrgNamespace()
		var String hostPart = null
		"http://" + 
		orgNs.toHostPart() + "/" + 
		newArrayList (leafDomainNamespace).toSubNamespacePath().map (n|n.name.stripXtextEscapes().replaceAll("\\.","/")).join("/");
	}
	
	def dispatch String toUnversionedNamespace (VersionedDomainNamespace s) {
		s.subdomain.toUnversionedNamespace();
	}

	def dispatch String toHostPart (OrganizationNamespace d) {
		d.name.split("\\.").reverse().join(".");
	}

	def dispatch String toHostPart (SubNamespace d) {
		var nsParts = d.name.split("\\.")
		var List<String> hostParts = Lists.newArrayList(nsParts.get(0))
		if (nsParts.size > 1) {
			for (var int i=1; i<NUM_OF_HOST_PARTS; i++) {
				hostParts.add(nsParts.get(i))
			}
		}
		hostParts.join(".");
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
		if (s.prefix == null ) s.toPrefix() else s.prefix;
	}
	
	def dispatch String toShortName(TechnicalNamespace s) {
		if (s.prefix == null ) s.toPrefix() else s.prefix;
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
	
	def dispatch String toFileNameFragment (OrganizationNamespace s) {
		s.findOrgNamespace().toPrefix().replaceAll("\\." , "-");
	}
	
	def dispatch String toFileNameFragment (DomainNamespace s) {
		val namespaces = new ArrayList<SubNamespace>();
		namespaces.add (s);
		s.findOrgNamespace().toPrefix().replaceAll("\\." , "-") + "-" + toSubNamespacePath (namespaces).map(n|n.name.stripXtextEscapes().replaceAll("\\." , "-")).join("-");
	}
	
	def dispatch String toFileNameFragment (InternalNamespace s) {
		val namespaces = new ArrayList<SubNamespace>();
		namespaces.add (s);
		s.findOrgNamespace().toPrefix().replaceAll("\\." , "-") + "-" + toSubNamespacePath (namespaces).map(n|n.name.stripXtextEscapes().replaceAll("\\." , "-")).join("-");
	}
	
	def dispatch String toFileNameFragment (VersionedDomainNamespace s) {
		s.subdomain.toFileNameFragment() + "-v" + versionQualifier.toMajorVersionNumber(s.version);
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
	def dispatch String toPrefix(OrganizationNamespace o) {
		if (o.prefix != null) {
			o.prefix;
		} else { 
			nameProvider.getFullyQualifiedName(o).segments.map (e|e.substring(0,1)).join;
		}
	}
	
	def dispatch String toPrefix (SubNamespace s) {
		if (s.prefix != null) { 
			s.prefix;
		} else {
			nameProvider.getFullyQualifiedName(s).segments.map (e|e.substring(0,1)).join;
		}
	}
	
	def dispatch String toPrefix (VersionedDomainNamespace s) {
		if (s.shortName != null) {
			s.shortName
		} else {
			nameProvider.getFullyQualifiedName(s.subdomain as EObject).segments.map (e|e.substring(0,1)).join;
		}
	}
	
}