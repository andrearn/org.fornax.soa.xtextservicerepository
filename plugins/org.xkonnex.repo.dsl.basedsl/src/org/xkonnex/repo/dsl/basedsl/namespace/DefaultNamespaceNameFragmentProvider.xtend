package org.xkonnex.repo.dsl.basedsl.namespace

import org.xkonnex.repo.dsl.basedsl.namespace.NamespaceNameFragmentProvider
import org.xkonnex.repo.dsl.basedsl.baseDsl.Namespace
import org.eclipse.xtext.naming.IQualifiedNameProvider
import javax.inject.Inject
import org.xkonnex.repo.dsl.basedsl.CommonStringExtensions
import java.util.List

class DefaultNamespaceNameFragmentProvider implements NamespaceNameFragmentProvider {
	
	val NUM_OF_HOST_PARTS = 2
	val SEGMENT_SHORTNAME_LENGTH 	= 1
	
	@Inject extension CommonStringExtensions
	@Inject extension NamespaceQueries
	
	
	override getNamespaceFQN (Namespace ns) {
		ns.namespacePath.map[name].join(".")
	}
	
	override getOrganizationNameFragment(Namespace ns) {
		val segments = ns.namespaceFQN.segments
		fqnSegmentsToOrgNameFragment(segments)
	}
	
	override getOrganizationNameFragment(VersionedNamespace ns) {
		ns.namespace.organizationNameFragment
	}
	
	
	override getSubNamespaceFragment(Namespace ns) {
		val segments = ns.namespaceFQN.segments
		fqnSegmentsToSubNsNameFragment(segments)
	}
	
	override getSubNamespaceFragment(VersionedNamespace ns) {
		ns.namespace.subNamespaceFragment
	}
	
	override getOrganizationNameFragment(String qualfiedNamespaceName) {
		fqnSegmentsToOrgNameFragment(qualfiedNamespaceName.segments)
	}
	
	override getSubNamespaceFragment(String qualfiedNamespaceName) {
		fqnSegmentsToSubNsNameFragment(qualfiedNamespaceName.segments)
	}
	
	
	override getShortname(String qualifiedNamespaceName) {
		qualifiedNamespaceName.segments.map (e|e.segmentToShortName).join;
	}
	
	override getShortname(Namespace ns) {
		if (ns.prefix != null) { 
			ns.prefix;
		} else {
			ns.namespaceFQN.segments.map (e|e.segmentToShortName).join
		}
	}
	
	override getShortname(VersionedNamespace ns) {
		ns.namespace.shortname
	}


	override def segmentToShortName (String segment) {
		segment.substring(0, SEGMENT_SHORTNAME_LENGTH)
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
			s.namespaceFQN.segments.map (e|e.substring(0,1)).join;
		}
	}
	
	def dispatch String toPrefix (VersionedNamespace s) {
		if (s.shortName != null) {
			s.shortName
		} else {
			s.namespace.namespaceFQN.segments.map (e|e.substring(0,1)).join;
		}
	}
	
}