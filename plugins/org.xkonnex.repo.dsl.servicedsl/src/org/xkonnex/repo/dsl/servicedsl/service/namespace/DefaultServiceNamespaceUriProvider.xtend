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
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup

class DefaultServiceNamespaceUriProvider implements ServiceNamespaceURIProvider {
	
	@Inject extension CommonStringExtensions
	@Inject extension NamespaceQuery
	@Inject extension ServiceNamespaceNameFragmentProvider
	@Inject extension IEObjectLookup
	@Inject VersionQualifierExtensions versionQualifier	
	@Inject NamespaceURIProvider namespaceURIProvider

	
	override getNamespaceURI(Namespace ns) {
		ns.toNamespaceURI
	}
	override getNamespaceURI(VersionedNamespace ns) {
		var nsURI = ns.namespace.toNamespaceURI;
		nsURI.addTrailingSlashIfReqired(ns)
	}
	
	override getServiceNamespaceURI(Service service) {
		val ns = service.getOwnerByType(SubNamespace)
		var tns = ns.namespaceURI 
		if (!tns.endsWith("/")) 
			tns = tns + "/" 
		tns = tns + service.name
		tns.addTrailingSlashIfReqired(ns)
	}
	
	override getVersionedNamespaceURI(Namespace ns) {
		ns.toVersionedNamespaceURI
	}
	override getVersionedNamespaceURI(VersionedNamespace ns) {
		ns.toVersionedNamespaceURI
	}
	
	override getVersionedServiceNamespaceURI(Service service) {
		val ns = service.getOwnerByType(SubNamespace)
		var tns = ns.namespaceURI 
		if (!tns.endsWith("/")) 
			tns = tns + "/" 
		tns = tns + service.name + "/" + service.version.toVersionPostfix()
		tns.addTrailingSlashIfReqired(ns)
	}

	override String getHostPart (SubNamespace ns) {
		val orgNs = ns.findOrgNamespace
		if (orgNs !== null) {
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
		if (orgNs !== null) {
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
	
	override getVersionPostfix(VersionedNamespace ns) {
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
		if (s.version !== null && s.version.version !== null ) 
			versionQualifier.toVersionPostfix(s.version) 
		else
			versionQualifier.toDefaultVersionPostfix();
	}
		
	private def dispatch String toVersionPostfix (VersionedNamespace s) {
		if (s.version !== null) 
			versionQualifier.toVersionPostfix(s.version) 
		else
			versionQualifier.toDefaultVersionPostfix();
	}
	
	
	
		
	private def dispatch String toVersionedNamespaceURI (Namespace ns) {
		namespaceURIProvider.getNamespaceURI(ns);
		ns.toVersionPostfix
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
	
	private def dispatch String toVersionedNamespaceURI (SubNamespace leafDomainNamespace) { 
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
	
	private def dispatch String toVersionedNamespaceURI (VersionedDomainNamespace s) { 
		var ns = s.subdomain.toNamespaceURI.stripXtextEscapes()
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
	
	
	private def dispatch String toNamespaceURI (Namespace namespace) {
		namespaceURIProvider.toNamespaceURI
	}
	
	private def dispatch String toNamespaceURI (OrganizationNamespace namespace) {
		var ns = namespace.hostPart
		ns.addTrailingSlashIfReqired(namespace);
	}
	
	private def dispatch String toNamespaceURI (VersionedDomainNamespace s) {
		var ns = s.subdomain.toNamespaceURI;
		ns.addTrailingSlashIfReqired(s)
	}
	
	private def dispatch String toNamespaceURI (SubNamespace leafDomainNamespace) {
		var ns = ""
		if (leafDomainNamespace.uri !== null)
			ns = leafDomainNamespace.uri
		else
			ns = leafDomainNamespace.hostPart + "/" + leafDomainNamespace.pathPart
		ns.addTrailingSlashIfReqired(leafDomainNamespace)
	}
	
}