package org.xkonnex.repo.dsl.basedsl.namespace

import javax.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.xkonnex.repo.dsl.basedsl.baseDsl.Namespace
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import java.util.regex.Pattern

class DefaultNamespaceURIProvider implements NamespaceURIProvider {
	
	val SEGMENT_SHORTNAME_LENGTH 	= 1
	val URI_PROTOCOL_QUALIFIER 		= "http://"
	val PROTOCOL_SEPARATOR 			= "://"
	val PATH_SEPARATOR 				= "/"

	@Inject extension NamespaceNameFragmentProvider 
	@Inject extension IQualifiedNameProvider
	@Inject extension VersionQualifierExtensions versionQualifier
	@Inject extension NamespaceQueries
	@Inject VersionQualifierExtensions verExt

	override getHostPart(Namespace ns) {
		if (ns.uri != null) {
			var hostPart = ns.uri
			var protocolPart = ns.uri
			val protocolSeparatorIndex = hostPart.indexOf(PROTOCOL_SEPARATOR) {
			if (protocolSeparatorIndex > -1 && hostPart.length >= protocolSeparatorIndex + PATH_SEPARATOR.length)
				hostPart = hostPart.substring(protocolSeparatorIndex + PROTOCOL_SEPARATOR.length)
				protocolPart = protocolPart.substring(0, protocolSeparatorIndex + PROTOCOL_SEPARATOR.length)
			}
			val slashIndex = hostPart.indexOf(PATH_SEPARATOR)
			if (slashIndex > -1) {
				hostPart = hostPart.substring(0, slashIndex)
			}
			return protocolPart + hostPart
		}
		return URI_PROTOCOL_QUALIFIER + ns.organizationNameFragment.split("\\.").reverse.join(".");
	}

	override getPathPart(Namespace ns) {
		if (ns.uri != null) {
			var pathPart = ns.uri
			val protocolSeparatorIndex = pathPart.indexOf(PROTOCOL_SEPARATOR) {
			if (protocolSeparatorIndex > -1 && pathPart.length >= protocolSeparatorIndex + PROTOCOL_SEPARATOR.length)
				pathPart = pathPart.substring(protocolSeparatorIndex + PROTOCOL_SEPARATOR.length)
			}
			val slashIndex = pathPart.indexOf(PATH_SEPARATOR)
			if (slashIndex > -1) {
				pathPart = pathPart.substring(slashIndex)
			}
			while (pathPart.startsWith("/")) {
				pathPart = pathPart.substring(1, pathPart.length)
			}
			while (pathPart.endsWith("/")) {
				pathPart = pathPart.substring(0, pathPart.length - 1)
			}
			return pathPart
		}
		return ns.subNamespaceFragment.split("\\.").join("/")
	}
	
	override getHostPart(String ns) {
		return URI_PROTOCOL_QUALIFIER + ns.organizationNameFragment.split("\\.").reverse.join(".");
	}

	override getPathPart(String ns) {
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
	override getUnversionedNamespaceURI(String ns) {
		var nsURI = ns.hostPart + "/" + ns.pathPart
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
		verExt.toDefaultVersionPostfix
	}
	
	override getVersionPostfix(VersionedNamespace ns) {
		verExt.toVersionPostfix(ns.version)
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
			true
	}
	
	private def segmentToShortName (String segment) {
		segment.substring(0, SEGMENT_SHORTNAME_LENGTH)
	}

	
	private def addTrailingSlashIfRequired(String nsURI, Namespace ns) {
		if (!nsURI.endsWith("/") && ns.requiresTrailingSlash() )  {
			return nsURI + ("/"); 
		} else {
			return nsURI;
		}
	}
	
	private def addTrailingSlashIfRequired(String nsURI, String ns) {
		if (nsURI.requiresTrailingSlash)  {
			return nsURI + ("/"); 
		} else {
			return nsURI;
		}
	}	
	
	private def requiresTrailingSlash(String nsUri) {
		if (!nsUri.endsWith("/")) true else false
	}

}