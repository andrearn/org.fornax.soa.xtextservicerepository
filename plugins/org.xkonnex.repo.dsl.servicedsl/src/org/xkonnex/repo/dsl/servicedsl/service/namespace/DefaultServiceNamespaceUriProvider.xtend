package org.xkonnex.repo.dsl.servicedsl.service.namespace

import javax.inject.Inject
import org.xkonnex.repo.dsl.basedsl.CommonStringExtensions
import org.xkonnex.repo.dsl.basedsl.baseDsl.Namespace
import org.xkonnex.repo.dsl.basedsl.baseDsl.Version
import org.xkonnex.repo.dsl.basedsl.namespace.NamespaceURIProvider
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.OrganizationNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.dsl.basedsl.namespace.VersionedNamespace

class DefaultServiceNamespaceUriProvider implements ServiceNamespaceURIProvider {
	
	@Inject extension CommonStringExtensions
	@Inject extension NamespaceQuery
	@Inject extension ServiceNamespaceNameFragmentProvider
	@Inject VersionQualifierExtensions versionQualifier	
	@Inject NamespaceURIProvider namespaceURIProvider

	
	override getUnversionedNamespaceURI(Namespace ns) {
		ns.toUnversionedNamespaceURI
	}
	override getUnversionedNamespaceURI(VersionedNamespace ns) {
		var nsURI = ns.namespace.toUnversionedNamespaceURI;
		nsURI.addTrailingSlashIfReqired(ns)
	}
	
	override getVersionedNamespaceURI(Namespace ns) {
		ns.toNamespaceURI
	}
	override getVersionedNamespaceURI(VersionedNamespace ns) {
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
		"http://" + d.organizationNameFragment.split("\\.").reverse().join(".");
	}
	
	override String getPathPart(SubNamespace ns) {
		val orgNs = ns.findOrgNamespace
		if (orgNs != null) {
			return ns.subNamespaceFragment.split("\\.").join("/")
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
	override boolean requiresTrailingSlash (VersionedNamespace ns) {
		requiresTrailingSlash(ns.namespace as SubNamespace)
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
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getVersionPostfix(Namespace ns) {
		ns.toVersionPostfix
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
		
	private def dispatch String toVersionPostfix (VersionedNamespace s) {
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
	private def addTrailingSlashIfReqired(String ns, VersionedNamespace s) {
		ns.addTrailingSlashIfReqired(s.namespace as SubNamespace)
	}
	
	
	private def dispatch String toUnversionedNamespaceURI (Namespace namespace) {
		namespaceURIProvider.toUnversionedNamespaceURI
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
	
	
	private def dispatch String toOrgNamespacePrefix (Namespace namespace) {
		namespaceURIProvider.toUnversionedNamespaceURI
	}
	
	private def dispatch String toOrgNamespacePrefix (OrganizationNamespace namespace) {
		if (namespace.prefix != null) {
			return namespace.prefix
		} else {
			return namespace.namespacePrefix
		}
	}
	
	private def dispatch String toOrgNamespacePrefix (VersionedDomainNamespace s) {
		var ns = s.subdomain.toUnversionedNamespaceURI;
		ns.addTrailingSlashIfReqired(s)
	}
	
		
}