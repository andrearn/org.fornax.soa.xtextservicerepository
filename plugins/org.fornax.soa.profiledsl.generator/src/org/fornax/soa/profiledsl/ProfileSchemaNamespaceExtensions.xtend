package org.fornax.soa.profiledsl

import com.google.inject.Inject
import org.fornax.soa.basedsl.CommonStringExtensions
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace
import java.util.List
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.profiledsl.sOAProfileDsl.OrganizationNamespace
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile

class ProfileSchemaNamespaceExtensions {
	
	@Inject extension CommonStringExtensions
	@Inject extension VersionQualifierExtensions
		
	def dispatch String fqn (org.fornax.soa.profiledsl.sOAProfileDsl.OrganizationNamespace s) {
		s.name.stripXtextEscapes();
	}

	def dispatch List<TechnicalNamespace> toNamespacePath (Object o) {
		newArrayList();
	}
	
	def dispatch String fqn (TechnicalNamespace s) {
		(s.findOrgNamespace() as OrganizationNamespace).name.stripXtextEscapes() + "." + toNamespacePath (newArrayList(s)).map(n|n.name.stripXtextEscapes()).join(".");
	}

	/*
	 * TODO IMPLEMENT!
	 */
	def dispatch String toPrefix(TechnicalNamespace o) {
		"tns";
	}
		
	def dispatch String toNamespace (org.fornax.soa.profiledsl.sOAProfileDsl.OrganizationNamespace org) { 
		var ns = org.toUnversionedNamespace() + "/" + org.toVersionPostfix();
		if (org.hasTrailingSlash() ){
			return ns + ("/"); 
		} else {
			return ns + "";
		}
	}

	def dispatch String toNamespace (org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace leafNamespace) {
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
	
	def dispatch boolean hasTrailingSlash (org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace ns) {
		!ns.noTrailingSlash;
	}
		
	def dispatch String toVersionPostfix (org.fornax.soa.profiledsl.sOAProfileDsl.OrganizationNamespace d) {
		toDefaultVersionPostfix();
	}
		
	def dispatch String toVersionPostfix (org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace s) {
		toDefaultVersionPostfix();
	}
	
	def dispatch String toUnversionedNamespace (org.fornax.soa.profiledsl.sOAProfileDsl.OrganizationNamespace domain) {
		"http://" + domain.name.split(".").reverse().join (".");
	}
	
	def dispatch String toUnversionedNamespace (org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace leafDomainNamespace) { 
		"http://" + 
		leafDomainNamespace.findOrgNamespace().toHostPart() + "/" + 
		(newArrayList (leafDomainNamespace).toNamespacePath().map (n|n.name.stripXtextEscapes().replaceAll("\\.","/")).join("/"));
	}
	
	def dispatch String toHostPart (org.fornax.soa.profiledsl.sOAProfileDsl.OrganizationNamespace d) {
		 d.name.split("\\.").reverse().join(".");
	}

		
	def dispatch org.fornax.soa.profiledsl.sOAProfileDsl.OrganizationNamespace findOrgNamespace (TechnicalNamespace o) { 
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

	
	def dispatch String toFileNameFragment (org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace s) {
		s.findOrgNamespace().shorten().replaceAll("\\." , "-") + "-" + newArrayList(s).toNamespacePath().map(n|n.name.stripXtextEscapes().replaceAll("\\." , "-")).join("-");
	}
	
	def dispatch String shorten (org.fornax.soa.profiledsl.sOAProfileDsl.OrganizationNamespace d) {
		d.prefix;
	}
	
}