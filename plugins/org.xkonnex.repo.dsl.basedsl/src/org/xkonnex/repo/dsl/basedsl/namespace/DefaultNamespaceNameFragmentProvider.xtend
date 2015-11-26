package org.xkonnex.repo.dsl.basedsl.namespace

import org.xkonnex.repo.dsl.basedsl.namespace.NamespaceNameFragmentProvider
import org.xkonnex.repo.dsl.basedsl.baseDsl.Namespace
import org.eclipse.xtext.naming.IQualifiedNameProvider
import javax.inject.Inject
import org.xkonnex.repo.dsl.basedsl.CommonStringExtensions
import java.util.List

class DefaultNamespaceNameFragmentProvider implements NamespaceNameFragmentProvider {
	
	val NUM_OF_HOST_PARTS = 2
	
	@Inject extension IQualifiedNameProvider 
	@Inject extension CommonStringExtensions
	
	override getOrganizationNameFragment(Namespace ns) {
		val segments = ns.fullyQualifiedName.segments
		fqnSegmentsToOrgNameFragment(segments)
	}
	
	override getOrganizationNameFragment(VersionedNamespace ns) {
		ns.namespace.organizationNameFragment
	}
	
	override getSubNamespaceFragment(Namespace ns) {
		val segments = ns.fullyQualifiedName.segments
		fqnSegmentsToSubNsNameFragment(segments)
	}
	
	override getSubNamespaceFragment(VersionedNamespace ns) {
		ns.namespace.subNamespaceFragment
	}
	
	override getOrganizationNameFragment(String qualfiedNamespaceName) {
		fqnSegmentsToOrgNameFragment(qualfiedNamespaceName.split("\\."))
	}
	
	override getSubNamespaceFragment(String qualfiedNamespaceName) {
		fqnSegmentsToSubNsNameFragment(qualfiedNamespaceName.split("\\."))
	}
	
	private def String fqnSegmentsToOrgNameFragment (List<String> fqnSegments) {
		if (fqnSegments.size > NUM_OF_HOST_PARTS-1)
			return fqnSegments.subList(0, NUM_OF_HOST_PARTS).map(n|n.stripXtextEscapes).join(".")
		else
			return fqnSegments.map(n|n.stripXtextEscapes).join(".")		
	}
	
	private def String fqnSegmentsToSubNsNameFragment (List<String> fqnSegments) {
		if (fqnSegments.size > NUM_OF_HOST_PARTS-1)
			return fqnSegments.subList(NUM_OF_HOST_PARTS, fqnSegments.size).map(n|n.stripXtextEscapes).join(".")
		else
			return fqnSegments.map(n|n.stripXtextEscapes).join(".")
	}
	def dispatch String toPrefix (Namespace s) {
		if (s.prefix != null) { 
			s.prefix;
		} else {
			s.fullyQualifiedName.segments.map (e|e.substring(0,1)).join;
		}
	}
	
	def dispatch String toPrefix (VersionedNamespace s) {
		if (s.shortName != null) {
			s.shortName
		} else {
			s.namespace.fullyQualifiedName.segments.map (e|e.substring(0,1)).join;
		}
	}
	
}