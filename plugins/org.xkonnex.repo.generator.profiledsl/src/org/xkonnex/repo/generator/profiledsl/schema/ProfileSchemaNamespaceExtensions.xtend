package org.xkonnex.repo.generator.profiledsl.schema

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.List
import org.xkonnex.repo.dsl.basedsl.CommonStringExtensions
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.OrganizationNamespace
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.SOAProfile
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.TechnicalNamespace
import org.xkonnex.repo.dsl.profiledsl.versioning.VersionedTechnicalNamespace

class ProfileSchemaNamespaceExtensions {
	
	@Inject extension CommonStringExtensions
	@Inject VersionQualifierExtensions versionQualifier
	
	@Inject @Named ("useRegistryBasedFilePaths") 
	Boolean useRegistryBasedFilePaths
	
	@Inject @Named ("useNestedPaths") 
	Boolean useNestedPaths
		
	def dispatch String fqn (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.OrganizationNamespace s) {
		s.name.stripXtextEscapes();
	}

	def dispatch List<TechnicalNamespace> toNamespacePath (Object o) {
		newArrayList();
	}

	def dispatch List<TechnicalNamespace> toNamespacePath (List<TechnicalNamespace> nsList) { 
		if (nsList.last().eContainer instanceof TechnicalNamespace) {
			nsList.add ((nsList.toList().last().eContainer  as TechnicalNamespace));
			toNamespacePath (nsList);
		} else {
			nsList.filter (typeof (TechnicalNamespace)).toList.reverse();
		}
			
	}
	
	
	def dispatch String fqn (TechnicalNamespace s) {
		(s.findOrgNamespace() as OrganizationNamespace).name.stripXtextEscapes() + "." + toNamespacePath (newArrayList(s)).map(n|n.name.stripXtextEscapes()).join(".");
	}

	def dispatch String toPrefix(OrganizationNamespace o) {
		if (o.prefix != null) {
			o.prefix;
		} else { 
			o.name.split("\\.").map (e|e.substring(0, 1)).join;
		}
	}
	
	def dispatch String toPrefix (TechnicalNamespace s) {
		if (s.prefix != null) { 
			s.prefix;
		} else {
			toNamespacePath( newArrayList(s)).map (n|n.name.split("\\.").map (e|e.substring(0,1)).join).join;
		}
	}
	
	def dispatch String toPrefix (VersionedTechnicalNamespace s) {
		if (s.shortName != null) {
			s.shortName
		} else {
			toNamespacePath (newArrayList (s.namespace)).map (n|n.name.split("\\.").map (e|e.substring(0,1)).join).join;
		}
	}
		
	def dispatch String toNamespace (OrganizationNamespace org) { 
		var ns = org.toUnversionedNamespace() + "/" + org.toVersionPostfix();
		if (org.hasTrailingSlash() ){
			return ns + ("/"); 
		} else {
			return ns + "";
		}
	}

	def dispatch String toNamespace (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.TechnicalNamespace leafNamespace) {
		var ns = leafNamespace.toUnversionedNamespace() +  "/" + leafNamespace.toVersionPostfix(); 
		if (leafNamespace.hasTrailingSlash() ) {
			return ns + ("/"); 
		} else {
			return ns + "";
		}
	}

	def dispatch boolean hasTrailingSlash (OrganizationNamespace ns) {
		false;
	}
	
	def dispatch boolean hasTrailingSlash (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.TechnicalNamespace ns) {
		!ns.noTrailingSlash;
	}
		
	def dispatch String toVersionPostfix (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.OrganizationNamespace d) {
		versionQualifier.toDefaultVersionPostfix();
	}
		
	def dispatch String toVersionPostfix (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.TechnicalNamespace s) {
		versionQualifier.toDefaultVersionPostfix();
	}
	
	def dispatch String toUnversionedNamespace (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.OrganizationNamespace domain) {
		"http://" + domain.name.split(".").reverse().join (".");
	}
	
	def dispatch String toUnversionedNamespace (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.TechnicalNamespace leafDomainNamespace) { 
		"http://" + 
		leafDomainNamespace.findOrgNamespace().toHostPart() + "/" + 
		(newArrayList (leafDomainNamespace).toNamespacePath().map (n|n.name.stripXtextEscapes().replaceAll("\\.","/")).join("/"));
	}
	
	def dispatch String toHostPart (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.OrganizationNamespace d) {
		 d.name.split("\\.").reverse().join(".");
	}

		
	def dispatch org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.OrganizationNamespace findOrgNamespace (TechnicalNamespace o) { 
		if (o.eContainer instanceof OrganizationNamespace) {
			o.eContainer as OrganizationNamespace;
		} else {
			this?.findOrgNamespace (o.eContainer as TechnicalNamespace) as OrganizationNamespace;
		}
	}
	
	def dispatch String toShortName (TechnicalNamespace s) {
		if (s.prefix == null ) {
			s.toPrefix()
		} else {
			s.prefix;
		}
	}

	
	def String shorten (OrganizationNamespace d, SOAProfile p) {
		if (!p.namespaceRules.aliases.filter (e|e.baseNamespaceFragment == d.name).isEmpty) {
			p.namespaceRules.aliases.filter (e|e.baseNamespaceFragment == d.name).map (n|n.shortenedBaseNamespaceFragment).join();
		} else {
			d.name;
		}
	}
	
	def dispatch String shorten (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.OrganizationNamespace d) {
		d.prefix;
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
	
	def dispatch String toFileNameFragment (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.TechnicalNamespace s) {
		s.findOrgNamespace().shorten().replaceAll("\\." , "-") + "-" + newArrayList(s).toNamespacePath().map(n|n.name.stripXtextEscapes().replaceAll("\\." , "-")).join("-");
	}
	
	def dispatch String toFileNameFragment (VersionedTechnicalNamespace s) {
		s.namespace.toFileNameFragment() + "-v" + versionQualifier.toMajorVersionNumber(s.version);
	}
	
	def dispatch String toNamespace (VersionedTechnicalNamespace s) { 
		var ns = s.namespace.toUnversionedNamespace().stripXtextEscapes() + "/" + versionQualifier.toVersionPostfix(s.version); 
		if (s.namespace.hasTrailingSlash() )  {
			return ns + ("/"); 
		} else {
			return ns + "";
		}
	}
	
}