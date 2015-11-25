package org.xkonnex.repo.dsl.servicedsl.service.namespace

import java.util.List
import javax.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.xkonnex.repo.dsl.basedsl.CommonStringExtensions
import org.xkonnex.repo.dsl.basedsl.baseDsl.Version
import org.xkonnex.repo.dsl.basedsl.namespace.NamespaceURIProvider;
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.OrganizationNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.dsl.basedsl.baseDsl.Namespace

class DefaultServiceNamespaceUriProvider implements ServiceNamespaceURIProvider {
	
	@Inject extension CommonStringExtensions
	@Inject extension NamespaceQuery
	@Inject VersionQualifierExtensions versionQualifier	
	@Inject IQualifiedNameProvider nameProvider
	@Inject NamespaceURIProvider namespaceURIProvider

	
	override getUnversionedNamespaceURI(OrganizationNamespace orgNs) {
		orgNs.toUnversionedNamespaceURI
	}
	override getUnversionedNamespaceURI(SubNamespace ns) {
		ns.toUnversionedNamespaceURI
	}
	override getUnversionedNamespaceURI(VersionedDomainNamespace ns) {
		ns.toUnversionedNamespaceURI
	}
	
	override getVersionedNamespaceURI(OrganizationNamespace orgNs) {
		orgNs.toNamespaceURI
	}
	override getVersionedNamespaceURI(SubNamespace ns) {
		ns.toNamespaceURI
	}
	override getVersionedNamespaceURI(VersionedDomainNamespace ns) {
		ns.toNamespaceURI
	}

	override String getHostPart (SubNamespace ns) {
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
	
	override String getPathPart(SubNamespace ns) {
		var List<String> pathParts = newArrayList
		val orgNs = ns.findOrgNamespace
		if (orgNs != null) {
			getAllSubNamespaces(ns).map (n|n.name.stripXtextEscapes()).join(".")
			val nsParts = ns.allSubNamespaces.map(n|n.name.stripXtextEscapes()).join(".").split("\\.")
			pathParts.addAll(nsParts)
			return pathParts.join("/")
		} else {
			return namespaceURIProvider.getPathPart(ns)
		}
	}

	override boolean requiresTrailingSlash (OrganizationNamespace ns) {
		true;
	}
	override boolean requiresTrailingSlash (SubNamespace ns) {
		namespaceURIProvider.requiresTrailingSlash(ns)
	}
	override boolean requiresTrailingSlash (VersionedDomainNamespace ns) {
		requiresTrailingSlash(ns.subdomain as SubNamespace)
	}
	
	

	private def dispatch String toVersionPostfix (Object o) { 
		throw new UnsupportedOperationException();
	}
	
	private def dispatch String toVersionPostfix (Version v) {
		versionQualifier.toVersionPostfix(v);
	}
	
	private def dispatch String toVersionPostfix (Namespace d) {
		versionQualifier.toDefaultVersionPostfix();
	}
	
	private def dispatch String toVersionPostfix (OrganizationNamespace d) {
		versionQualifier.toDefaultVersionPostfix();
	}
	
	private def dispatch String toVersionPostfix (SubNamespace s) {
		if (s.version != null && s.version.version != null ) 
			versionQualifier.toVersionPostfix(s.version) 
		else
			versionQualifier.toDefaultVersionPostfix();
	}
		
	private def dispatch String toVersionPostfix (VersionedDomainNamespace s) {
		if (s.version != null) 
			versionQualifier.toVersionPostfix(s.version) 
		else
			versionQualifier.toDefaultVersionPostfix();
	}
	
	
	
		
	private def dispatch String toNamespaceURI (Namespace ns) {
		namespaceURIProvider.getUnversionedNamespaceURI(ns);
		ns.toVersionPostfix
	}
	
	private def dispatch String toNamespaceURI (OrganizationNamespace domain) {
		var ns = domain.toUnversionedNamespaceURI 
		if (!ns.endsWith("/")) 
			ns = ns +  "/" 
		ns = ns + domain.toVersionPostfix;
		if (!ns.endsWith("/") && domain.requiresTrailingSlash() ) {
			return ns + ("/"); 
		} else {
			return ns + "";
		}
	}
	
	private def dispatch String toNamespaceURI (SubNamespace leafDomainNamespace) { 
		var ns = leafDomainNamespace.toUnversionedNamespaceURI
		if (!ns.endsWith("/")) 
			ns = ns +  "/" 
		ns = ns + leafDomainNamespace.toVersionPostfix();
		if (!ns.endsWith("/") && leafDomainNamespace.requiresTrailingSlash() ) {
			return ns + ("/"); 
		} else {
			return ns + "";
		}
	}
	
	private def dispatch String toNamespaceURI (VersionedDomainNamespace s) { 
		var ns = s.subdomain.toUnversionedNamespaceURI.stripXtextEscapes()
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
	private def addTrailingSlashIfReqired(String ns, SubNamespace s) {
		if (!ns.endsWith("/") && s.requiresTrailingSlash() )  {
			return ns + ("/"); 
		} else {
			return ns + "";
		}
	}
	private def addTrailingSlashIfReqired(String ns, VersionedDomainNamespace s) {
		ns.addTrailingSlashIfReqired(s.subdomain as SubNamespace)
	}
	
	
	private def dispatch String toUnversionedNamespaceURI (OrganizationNamespace namespace) {
		var ns = namespace.hostPart
		ns.addTrailingSlashIfReqired(namespace);
	}
	
	private def dispatch String toUnversionedNamespaceURI (VersionedDomainNamespace s) {
		var ns = s.subdomain.toUnversionedNamespaceURI;
		ns.addTrailingSlashIfReqired(s)
	}
	
	private def dispatch String toUnversionedNamespaceURI (SubNamespace leafDomainNamespace) {
		var ns = ""
		if (leafDomainNamespace.uri != null)
			ns = leafDomainNamespace.uri
		else
			ns = leafDomainNamespace.hostPart + "/" + leafDomainNamespace.pathPart
		ns.addTrailingSlashIfReqired(leafDomainNamespace)
	}
	
	private def List<SubNamespace> getAllSubNamespaces (SubNamespace ns) {
		val List<SubNamespace> nsList = newArrayList(ns)
		return getAllSubNamespaces(nsList)
	}
	
	private def List<SubNamespace> getAllSubNamespaces (List<SubNamespace> domList) {
		if (domList.last()?.eContainer instanceof SubNamespace) {
			domList.add (domList.last().eContainer as SubNamespace) 
			getAllSubNamespaces (domList);
			return domList;
		} else { 
			return domList.filter (typeof (SubNamespace)).toList().reverse();
		}
	}
		
}