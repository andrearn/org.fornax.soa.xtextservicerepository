package org.xkonnex.repo.dsl.profiledsl.namespace

import java.util.List
import javax.inject.Inject
import org.xkonnex.repo.dsl.basedsl.CommonStringExtensions
import org.xkonnex.repo.dsl.basedsl.baseDsl.Namespace
import org.xkonnex.repo.dsl.basedsl.baseDsl.Version
import org.xkonnex.repo.dsl.basedsl.namespace.NamespaceURIProvider
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.dsl.profiledsl.profileDsl.OrganizationNamespace
import org.xkonnex.repo.dsl.profiledsl.profileDsl.TechnicalNamespace
import org.xkonnex.repo.dsl.profiledsl.query.namespace.TechnicalNamespaceQueries
import org.xkonnex.repo.dsl.profiledsl.versioning.VersionedTechnicalNamespace
import org.xkonnex.repo.dsl.basedsl.namespace.VersionedNamespace

class DefaultProfileNamespaceURIProvider implements ProfileNamespaceURIProvider {
	
	@Inject extension CommonStringExtensions
	@Inject extension TechnicalNamespaceQueries
	@Inject VersionQualifierExtensions versionQualifier	
	@Inject NamespaceURIProvider namespaceURIProvider
	@Inject extension ProfileNamespaceNameFragmentProvider 
	

	override String getHostPart (TechnicalNamespace ns) {
		val orgNs = ns.findOrgNamespace
		if (orgNs != null) {
			return orgNs.hostPart
		} else {
			return namespaceURIProvider.getHostPart(ns)
		}
	}

	override String getHostPart (OrganizationNamespace d) {
		"http://" + d.name.stripXtextEscapes().split("\\.").reverse().join(".");
	}
	
	override String getPathPart(TechnicalNamespace ns) {
		var List<String> pathParts = newArrayList
		val orgNs = ns.findOrgNamespace
		if (orgNs != null) {
			getAllTechnicalNamespaces(ns).map (n|n.name.stripXtextEscapes()).join(".")
			val nsParts = ns.getAllTechnicalNamespaces.map(n|n.name.stripXtextEscapes()).join(".").split("\\.")
			pathParts.addAll(nsParts)
			return pathParts.join("/")
		} else {
			return namespaceURIProvider.getPathPart(ns)
		}
	}
	
	override getNamespaceURI(OrganizationNamespace orgNs) {
		orgNs.toNamespaceURI
	}
	
	override getNamespaceURI(TechnicalNamespace ns) {
		ns.toNamespaceURI
	}
	
	override getNamespaceURI(VersionedTechnicalNamespace ns) {
		ns.namespace.toNamespaceURI
	}
	
	override getVersionedNamespaceURI(OrganizationNamespace orgNs) {
		orgNs.toVersionedNamespaceURI
	}
	
	override getVersionedNamespaceURI(TechnicalNamespace leafDomainNamespace) { 
		leafDomainNamespace.toVersionedNamespaceURI
	}
	
	override getVersionedNamespaceURI(VersionedTechnicalNamespace ns) {
		ns.toVersionedNamespaceURI
	}
	
	override requiresTrailingSlash(OrganizationNamespace ns) {
		namespaceURIProvider.requiresTrailingSlash(ns)
	}
	
	override requiresTrailingSlash(TechnicalNamespace ns) {
		if (ns.noTrailingSlash)
			return false
		else
			namespaceURIProvider.requiresTrailingSlash(ns)
	}
	
	override requiresTrailingSlash(VersionedTechnicalNamespace o) {
		requiresTrailingSlash(o.namespace)
	}
	
	def requiresTrailingSlash(Namespace ns) {
		namespaceURIProvider.requiresTrailingSlash(ns)
	}
	
	
	
	private def dispatch String toVersionPostfix (Object o) { 
		throw new UnsupportedOperationException();
	}
	
	private def dispatch String toVersionPostfix (Version v) {
		versionQualifier.toVersionPostfix(v);
	}
	
	private def dispatch String toVersionPostfix (OrganizationNamespace d) {
		versionQualifier.toDefaultVersionPostfix();
	}
	
	private def dispatch String toVersionPostfix (TechnicalNamespace s) {
			versionQualifier.toDefaultVersionPostfix();
	}
		
	private def dispatch String toVersionPostfix (VersionedTechnicalNamespace s) {
		if (s.version != null) 
			versionQualifier.toVersionPostfix(s.version) 
		else
			versionQualifier.toDefaultVersionPostfix();
	}
	
	
	
		
	private def dispatch String toVersionedNamespaceURI (Namespace o) {
		var ns = o.toNamespaceURI 
		if (!ns.endsWith("/")) 
			ns = ns +  "/" 
		ns = ns + o.toVersionPostfix;
		if (!ns.endsWith("/") && namespaceURIProvider.requiresTrailingSlash(o) ) {
			return ns + ("/"); 
		} else {
			return ns + "";
		}
	}
	
	private def dispatch String toVersionedNamespaceURI (OrganizationNamespace domain) {
		var ns = domain.toNamespaceURI 
		if (!ns.endsWith("/")) 
			ns = ns +  "/" 
		ns = ns + domain.toVersionPostfix;
		if (!ns.endsWith("/") && domain.requiresTrailingSlash() ) {
			return ns + ("/"); 
		} else {
			return ns + "";
		}
	}
	
	private def dispatch String toVersionedNamespaceURI (TechnicalNamespace leafDomainNamespace) { 
		var ns = leafDomainNamespace.toNamespaceURI
		if (!ns.endsWith("/")) 
			ns = ns +  "/" 
		ns = ns + leafDomainNamespace.toVersionPostfix();
		if (!ns.endsWith("/") && leafDomainNamespace.requiresTrailingSlash() ) {
			return ns + ("/"); 
		} else {
			return ns + "";
		}
	}
	
	private def dispatch String toVersionedNamespaceURI (VersionedTechnicalNamespace s) { 
		var ns = s.namespace.toNamespaceURI.stripXtextEscapes()
		if (!ns.endsWith("/")) 
			ns = ns +  "/" 
		ns = ns + s.toVersionPostfix();
		addTrailingSlashIfReqired(ns, s)
	}
	
	private def addTrailingSlashIfReqired(String ns, OrganizationNamespace s) {
		if (!ns.endsWith("/") && s.requiresTrailingSlash() )  {
			return ns + ("/"); 
		} else {
			return ns + "";
		}
	}
	private def addTrailingSlashIfReqired(String ns, TechnicalNamespace s) {
		if (!ns.endsWith("/") && s.requiresTrailingSlash() )  {
			return ns + ("/"); 
		} else {
			return ns + "";
		}
	}
	private def addTrailingSlashIfReqired(String ns, VersionedTechnicalNamespace s) {
		ns.addTrailingSlashIfReqired(s.namespace as TechnicalNamespace)
	}
	
	
	private def dispatch String toNamespaceURI (Namespace leafDomainNamespace) {
		
	}
	
	private def dispatch String toNamespaceURI (OrganizationNamespace namespace) {
		var ns = namespace.hostPart
		ns.addTrailingSlashIfReqired(namespace);
	}
	
	private def dispatch String toNamespaceURI (VersionedTechnicalNamespace s) {
		var ns = s.namespace.toNamespaceURI;
		ns.addTrailingSlashIfReqired(s)
	}
	
	private def dispatch String toNamespaceURI (TechnicalNamespace leafDomainNamespace) {
		var ns = ""
		if (leafDomainNamespace.uri != null)
			ns = leafDomainNamespace.uri
		else
			ns = leafDomainNamespace.hostPart + "/" + leafDomainNamespace.pathPart
		ns.addTrailingSlashIfReqired(leafDomainNamespace)
	}
	
	private def List<TechnicalNamespace> getAllTechnicalNamespaces (TechnicalNamespace ns) {
		val List<TechnicalNamespace> nsList = newArrayList(ns)
		return getAllTechnicalNamespaces(nsList)
	}
	
	private def List<TechnicalNamespace> getAllTechnicalNamespaces (List<TechnicalNamespace> domList) {
		if (domList.last()?.eContainer instanceof TechnicalNamespace) {
			domList.add (domList.last().eContainer as TechnicalNamespace) 
			getAllTechnicalNamespaces (domList);
			return domList;
		} else { 
			return domList.filter (typeof (TechnicalNamespace)).toList().reverse();
		}
	}
	
	override getNamespacePrefix(Namespace ns) {
		namespaceURIProvider.getNamespacePrefix(ns)
	}
	
	override getNamespacePrefix(VersionedNamespace ns) {
		namespaceURIProvider.getNamespacePrefix(ns)
	}
	
	override getNamespacePrefix(String qualifiedNameFragment) {
		namespaceURIProvider.getNamespacePrefix(qualifiedNameFragment)
	}
	
	override getVersionedNamespacePrefix(VersionedNamespace ns) {
		ns.namespacePrefix + ns.version
	}
	
	override getVersionedNamespacePrefix(Namespace ns) {
		ns.namespacePrefix + "1"
	}
	
	override getVersionedNamespacePrefix(String qualifiedNameFragment) {
		namespaceURIProvider.getVersionedNamespacePrefix(qualifiedNameFragment)
	}
	
	override getOrgNamespacePrefix(String qualifiedNameFragment) {
		qualifiedNameFragment.orgNamespacePrefix
	}
	
	override getOrgNamespacePrefix(Namespace ns) {
		ns.organizationShortnameFragment
	}
	
	override getOrgNamespacePrefix(VersionedNamespace ns) {
		ns.organizationShortnameFragment
	}
		
}