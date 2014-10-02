package org.xkonnex.repo.dsl.profiledsl.query.namespace

import com.google.inject.Inject
import java.util.HashSet
import java.util.Set
import org.xkonnex.repo.dsl.profiledsl.query.type.ReferencedTypesFinder
import org.xkonnex.repo.dsl.profiledsl.query.type.VersionedTypeFilter
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Class
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.MessageHeader
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.TechnicalNamespace
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
	 */
	def Set<VersionedTechnicalNamespace> allImportedVersionedNS (VersionedTechnicalNamespace s) { 
		s.allImportedVersionedNS (new HashSet<VersionedTechnicalNamespace>() ).filter (typeof (VersionedTechnicalNamespace)).toSet;
	}
	
	def dispatch Set<VersionedTechnicalNamespace> allImportedVersionedNS (
		VersionedTechnicalNamespace s, 
		Set<VersionedTechnicalNamespace> visited
		) {
		if (! visited.contains(s) ) { 
			visited.add(s);
			s.namespace.allImportedVersionedNS (s.version).map (vns |vns.allImportedVersionedNS (visited)).flatten.filter (typeof (VersionedTechnicalNamespace)).toSet;
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
		s.allTypesByMajorVersion (nameSpaceMajorVersion).filter (typeof (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Class))
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
	 */
	def dispatch Set<VersionedTechnicalNamespace> importedVersionedNS (TechnicalNamespace s, String nameSpaceMajorVersion) {
		s.allTypesByMajorVersion (nameSpaceMajorVersion).filter (typeof (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Class))
		.map (e|e.allReferencedVersionedTypes()).flatten.map (v|v.createVersionedTechnicalNamespace()).toSet;
	}
	
}