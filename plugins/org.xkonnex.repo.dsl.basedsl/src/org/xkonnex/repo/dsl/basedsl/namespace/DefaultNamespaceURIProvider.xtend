package org.xkonnex.repo.dsl.basedsl.namespace

import java.util.List
import javax.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.xkonnex.repo.dsl.basedsl.CommonStringExtensions
import org.xkonnex.repo.dsl.basedsl.baseDsl.Namespace

class DefaultNamespaceURIProvider implements NamespaceURIProvider {

	val NUM_OF_HOST_PARTS = 2

	@Inject extension CommonStringExtensions
	@Inject IQualifiedNameProvider nameProvider

	override getHostPart(Namespace ns) {
		var List<String> hostParts = newArrayList()
		var nsParts = nameProvider.getFullyQualifiedName(ns).segments.map(n|n.stripXtextEscapes)
		hostParts.add(nsParts.get(0))
		if (nsParts.size > 1) {
			for (var int i = 1; i < NUM_OF_HOST_PARTS; i++) {
				hostParts.add(nsParts.get(i))
			}
		}
		return "http://" + hostParts.reverse.join(".");
	}

	override getPathPart(Namespace ns) {
		var List<String> pathParts = newArrayList
		pathParts.addAll(nameProvider.getFullyQualifiedName(ns).segments)
		if (pathParts.size >= NUM_OF_HOST_PARTS) {
			for (var int i = 0; i < NUM_OF_HOST_PARTS; i++) {
				pathParts.remove(0)
			}
		}
		return pathParts.join("/")
	}

	override getUnversionedNamespaceURI(Namespace ns) {
		var nsURI = ""
		if (ns.uri != null)
			nsURI = ns.uri
		else
			nsURI = ns.hostPart + "/" + ns.pathPart
		nsURI.addTrailingSlashIfRequired(ns)
	}

	override requiresTrailingSlash(Namespace ns) {
		if (ns.uri != null)
			ns.uri.endsWith("/")
		else
			true;
	}

	
	private def addTrailingSlashIfRequired(String nsURI, Namespace s) {
		if (!nsURI.endsWith("/") && s.requiresTrailingSlash() )  {
			return nsURI + ("/"); 
		} else {
			return nsURI + "";
		}
	}
	

}