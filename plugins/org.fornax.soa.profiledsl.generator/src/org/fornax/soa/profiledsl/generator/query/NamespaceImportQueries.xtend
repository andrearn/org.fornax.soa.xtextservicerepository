package org.fornax.soa.profiledsl.generator.query

import com.google.inject.Inject
import java.util.Set
import org.fornax.soa.basedsl.generator.version.VersionMatcher
import org.fornax.soa.basedsl.generator.version.VersionQualifierExtensions
import org.fornax.soa.profiledsl.generator.namespace.TechnicalNamespaceSplitter
import org.fornax.soa.profiledsl.generator.namespace.VersionedTechnicalNamespace
import org.fornax.soa.profiledsl.sOAProfileDsl.Class
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace
import java.util.HashSet
import org.fornax.soa.profiledsl.generator.query.type.LatestMatchingTypeFinder
import org.fornax.soa.profiledsl.generator.query.type.VersionedTypeFilter
import org.fornax.soa.profiledsl.generator.query.type.ReferencedTypesFinder

/*********************************************************************************
 *	Calculation of all VersionedTechnicalNamespaces imported by a given or derived 
 *	VersionedTechnicalNamespace. Transitive dependencies are not yet calculated
 */
class NamespaceImportQueries {
	
	@Inject extension VersionMatcher
	@Inject extension VersionQualifierExtensions
	@Inject extension NamespaceQueries
	@Inject extension LatestMatchingTypeFinder
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
		s.allTypesByMajorVersion (nameSpaceMajorVersion).filter (typeof (org.fornax.soa.profiledsl.sOAProfileDsl.Class))
			.map (e|e.allReferencedVersionedTypes()).flatten.map (v|v.createVersionedTechnicalNamespace()).toSet;
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
		s.allTypesByMajorVersion (nameSpaceMajorVersion).filter (typeof (org.fornax.soa.profiledsl.sOAProfileDsl.Class))
		.map (e|e.allReferencedVersionedTypes()).flatten.map (v|v.createVersionedTechnicalNamespace()).toSet;
	}
	
}