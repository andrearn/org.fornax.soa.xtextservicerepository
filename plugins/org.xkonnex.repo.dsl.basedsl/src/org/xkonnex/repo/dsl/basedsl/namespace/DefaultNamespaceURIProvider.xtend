package org.xkonnex.repo.dsl.basedsl.namespace

import javax.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.xkonnex.repo.dsl.basedsl.baseDsl.Namespace
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions

class DefaultNamespaceURIProvider implements NamespaceURIProvider {
	
	val SEGMENT_SHORTNAME_LENGTH = 1
	val URI_PROTOCOL_QUALIFIER = "http://"

	@Inject extension NamespaceNameFragmentProvider 
	@Inject extension IQualifiedNameProvider
	@Inject extension VersionQualifierExtensions versionQualifier
	@Inject extension NamespaceQueries

	override getHostPart(Namespace ns) {
		return URI_PROTOCOL_QUALIFIER + ns.organizationNameFragment.split("\\.").reverse.join(".");
	}

	override getPathPart(Namespace ns) {
		return ns.subNamespaceFragment.split("\\.").join("/")
	}

	override getUnversionedNamespaceURI(Namespace ns) {
		var nsURI = ""
		if (ns.uri != null)
			nsURI = ns.uri
		else
			nsURI = ns.hostPart + "/" + ns.pathPart
		nsURI.addTrailingSlashIfRequired(ns)
	}
	
	override getNamespacePrefix(String qualifiedNameFragment) {
		qualifiedNameFragment.split("\\.").map (e|e.segmentToShortName).join
	}
	
	override getNamespacePrefix(Namespace ns) {
		if (ns.prefix != null) { 
			ns.prefix;
		} else {
			val path = ns.namespacePath.map[name].join(".")
			path.split("\\.").map (e|e.segmentToShortName).join;
		}
	}
	
	override getNamespacePrefix(VersionedNamespace ns) {
		if (ns.shortName != null) {
			ns.shortName
		} else {
			ns.namespace.namespacePrefix;
		}
	}
	
	override getVersionPostfix(Namespace ns) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getVersionedNamespacePrefix(String qualifiedNameFragment) {
		qualifiedNameFragment.namespacePrefix + versionQualifier.toDefaultMajorVersion
	}
	
	override getVersionedNamespacePrefix(Namespace ns) {
		ns.namespacePrefix + versionQualifier.toDefaultMajorVersion
	}
	
	override getVersionedNamespacePrefix(VersionedNamespace ns) {
		getNamespacePrefix(ns) + ns.version.toMajorVersionNumber
	}

	override requiresTrailingSlash(Namespace ns) {
		if (ns.uri != null)
			ns.uri.endsWith("/")
		else
			true;
	}
	
	private def segmentToShortName (String segment) {
		segment.substring(0, SEGMENT_SHORTNAME_LENGTH)
	}

	
	private def addTrailingSlashIfRequired(String nsURI, Namespace s) {
		if (!nsURI.endsWith("/") && s.requiresTrailingSlash() )  {
			return nsURI + ("/"); 
		} else {
			return nsURI + "";
		}
	}	

}