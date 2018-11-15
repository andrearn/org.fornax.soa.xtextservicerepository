package org.xkonnex.repo.dsl.profiledsl.query.namespace

import com.google.inject.Inject
import java.util.HashSet
import java.util.Set
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Class
import org.xkonnex.repo.dsl.profiledsl.profileDsl.MessageHeader
import org.xkonnex.repo.dsl.profiledsl.profileDsl.TechnicalNamespace
import org.xkonnex.repo.dsl.profiledsl.query.type.ReferencedTypesFinder
import org.xkonnex.repo.dsl.profiledsl.query.type.VersionedTypeFilter
import org.xkonnex.repo.dsl.profiledsl.versioning.TechnicalNamespaceSplitter
import org.xkonnex.repo.dsl.profiledsl.versioning.VersionedTechnicalNamespace

/*********************************************************************************
 *	Calculation of all VersionedTechnicalNamespaces imported by a given or derived 
 *	VersionedTechnicalNamespace. Transitive dependencies are not yet calculated
 */
class TechnicalNamespaceImportQueries {
	
	@Inject extension VersionedTypeFilter
	@Inject extension ReferencedTypesFinder
	@Inject extension TechnicalNamespaceSplitter
	
	
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of all owned VersiondTypes, Exceptions and Service in the given 
	 *	VersionedDomainNamespace. The owning VersiondDomainNamespace of the found dependencies are returned.
	 * 
	 * @param ns the technical namespace to investigate
	 * @return all imported technical namespaces
	 */
	def Set<VersionedTechnicalNamespace> allImportedVersionedNS (VersionedTechnicalNamespace ns) { 
		ns.allImportedVersionedNS (new HashSet<VersionedTechnicalNamespace>() ).filter (typeof (VersionedTechnicalNamespace)).toSet;
	}
	
	def dispatch Set<VersionedTechnicalNamespace> allImportedVersionedNS (
		VersionedTechnicalNamespace ns, 
		Set<VersionedTechnicalNamespace> visited
		) {
		if (! visited.contains(ns) ) { 
			visited.add(ns);
			ns.namespace.allImportedVersionedNS (ns.version).map (vns |vns.allImportedVersionedNS (visited)).flatten.filter (typeof (VersionedTechnicalNamespace)).toSet;
		} else {
			visited.filter (typeof (VersionedTechnicalNamespace)).toSet;
		}
	}
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of all owned VersiondTypes in the given 
	 *	TechnicalNamespace matching the given major version. The owning VersiondDomainNamespace 
	 *	of the found dependencies are returned.
	 */
	def dispatch Set<VersionedTechnicalNamespace> allImportedVersionedNS (TechnicalNamespace s, String nameSpaceMajorVersion) {
		s.allTypesByMajorVersion (nameSpaceMajorVersion).filter (typeof (Class))
			.map (e|e.allReferencedVersionedTypes()).flatten.map (v|v.createVersionedTechnicalNamespace()).toSet;
	}
	
	def dispatch Set<VersionedTechnicalNamespace> allImportedVersionedNS (MessageHeader t, String nameSpaceMajorVersion) {
		t.allReferencedVersionedTypes().map (e|e.createVersionedTechnicalNamespace()).toSet();
	}
	

	/*
	 *	All direct imports
	 */
	 
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of all owned VersiondTypes in the given 
	 *	TechnicalNamespace matching the given major version. The owning VersiondDomainNamespace 
	 *	of the found dependencies are returned.
	 * 
	 * @param ns the technical namespace to investigate
	 * @param nameSpaceMajorVersion the required namespace version
	 * @return all imported technical namespaces
	 */
	def Set<VersionedTechnicalNamespace> importedVersionedNS (TechnicalNamespace ns, String nameSpaceMajorVersion) {
		ns.allTypesByMajorVersion (nameSpaceMajorVersion).filter (typeof (Class))
		.map (e|e.allReferencedVersionedTypes()).flatten.map (v|v.createVersionedTechnicalNamespace()).toSet;
	}
	
}