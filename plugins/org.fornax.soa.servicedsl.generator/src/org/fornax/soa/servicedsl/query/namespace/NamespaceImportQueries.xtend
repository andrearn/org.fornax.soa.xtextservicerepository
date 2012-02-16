package org.fornax.soa.servicedsl.query.namespace

import com.google.inject.Inject
import java.util.HashSet
import java.util.Set
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState
import org.fornax.soa.basedsl.version.VersionMatcher
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.profiledsl.VersionedTechnicalNamespace
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace
import org.fornax.soa.serviceDsl.BusinessObject
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.serviceDsl.Type
import org.fornax.soa.serviceDsl.VersionedTypeRef
import org.fornax.soa.servicedsl.VersionedDomainNamespace
import org.fornax.soa.servicedsl.domain.NamespaceSplitter
import org.fornax.soa.servicedsl.query.ExceptionFinder
import org.fornax.soa.servicedsl.query.ServiceFinder
import org.fornax.soa.servicedsl.query.type.BusinessObjectQueries
import org.fornax.soa.servicedsl.query.type.LatestMatchingTypeFinder
import org.fornax.soa.servicedsl.query.type.ReferencedTypesFinder
import org.fornax.soa.servicedsl.query.type.VersionedTypeFilter
import org.fornax.soa.profiledsl.TechnicalNamespaceSplitter

/*********************************************************************************
 *	Calculation of all VersionedDomainNamespaces imported by a given or derived 
 *	VersionedDomainNamespace. Transitive dependencies are not yet calculated
 */
class NamespaceImportQueries {
	
	@Inject extension VersionMatcher
	@Inject extension VersionQualifierExtensions
	@Inject extension NamespaceQuery
	@Inject extension NamespaceSplitter
	@Inject extension LatestMatchingTypeFinder
	@Inject extension VersionedTypeFilter
	@Inject extension ExceptionFinder
	@Inject extension ServiceFinder
	@Inject extension BusinessObjectQueries
	@Inject extension ReferencedTypesFinder
	@Inject extension TechnicalNamespaceSplitter
	
	/**
	 *	Calculate all dependencies of the given Service version
	 *	@deprecated ?
	 *
	 *	@param svc	The Service with it's version to calculate the imports for
	 */
	def Set<VersionedDomainNamespace> findImportedSubdomains (Service svc) { 
		var imports = svc.operations.map (o|o.parameters).flatten.map (p|p.type).filter(typeof (VersionedTypeRef))
			.map (r|r.findLatestMatchingType()).filterNull().map (e|e.createVersionedDomainNamespace()).toSet;
		imports.addAll (svc.operations.map (o|o.^return).flatten.map (r|r.type).filter (typeof (VersionedTypeRef))
			.map (v|v.findLatestMatchingType()).filterNull().map (e|e.createVersionedDomainNamespace()));
		imports.addAll (svc.operations.map (o|o.throws).flatten.map(t|t.findLatestMatchingException()).filterNull().map (e|e.createVersionedDomainNamespace()));
		return imports;
	}
	
	/**
	 *	Calculate all dependencies of the given Service version and LifecycleState. Dependencies must match
	 *	the given minimal LifecycleState
	 *	@deprecated ?
	 *
	 *	@param svc	The Service with it's version to calculate the imports for
	 */
	def Set<SubNamespace> allImportedSubNamespaces (Type t, LifecycleState minState) { 
		t.allReferencedVersionedTypes (minState).map (e|e.findSubdomain()).toSet();
	}
	
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of the given Type considering the minimal LifecycleState required by the 
	 *	given Type. The owning VersiondDomainNamespace of the found dependencies are returned.
	 */
	def dispatch Set<VersionedDomainNamespace> allImportedVersionedNS (Type t, LifecycleState minState) {
		t.allReferencedVersionedTypes(minState).map (e|e.createVersionedDomainNamespace()).toSet();
	}
	
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of the given Type considering the minimal LifecycleState required by the 
	 *	given Type. The owning VersiondDomainNamespace of the found dependencies are returned.
	 */
	def dispatch Set<VersionedDomainNamespace> allImportedVersionedNS (VersionedDomainNamespace s, LifecycleState minState) { 
		s.allImportedVersionedNS (minState, (new HashSet<VersionedDomainNamespace>())).toSet();
	}
	
	def dispatch Set<VersionedDomainNamespace> allImportedVersionedNS (
		VersionedDomainNamespace s, 
		LifecycleState minState, 
		Set<VersionedDomainNamespace> visited
		) {
		if (! visited.contains(s) ) {
			visited.add(s);
			s.subdomain.allImportedVersionedNS (s.version, minState).allImportedVersionedNS (minState, visited)
		} else {
			visited;
		}
	}
	
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of all owned VersiondTypes, Exceptions and Service in the given 
	 *	VersionedDomainNamespace. The owning VersiondDomainNamespace of the found dependencies are returned.
	 */
	def Set<VersionedDomainNamespace> allImportedVersionedNS (VersionedDomainNamespace s) { 
		s.allImportedVersionedNS (new HashSet<VersionedDomainNamespace>() ).filter (typeof (VersionedDomainNamespace)).toSet;
	}
	
	def dispatch Set<VersionedDomainNamespace> allImportedVersionedNS (
		VersionedDomainNamespace s, 
		Set<VersionedDomainNamespace> visited
		) {
		if (! visited.contains(s) ) { 
			visited.add(s);
			s.subdomain.allImportedVersionedNS (s.version).allImportedVersionedNS (visited).filter (typeof (VersionedDomainNamespace)).toSet;
		} else {
			visited.filter (typeof (VersionedDomainNamespace)).toSet;
		}
	}
	
	
	def dispatch Set<VersionedDomainNamespace> allImportedVersionedNS (Object s, String nameSpaceMajorVersion, LifecycleState minState) {}
	def dispatch Set<VersionedDomainNamespace> allImportedVersionedNS (Object s, String nameSpaceMajorVersion) {}
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of all owned VersiondTypes, Exceptions and Service in the given 
	 *	SubNamespace matching the given major version. The owning VersiondDomainNamespace of the found dependencies are returned.
	 */
	def dispatch Set<VersionedDomainNamespace> allImportedVersionedNS (SubNamespace s, String nameSpaceMajorVersion, LifecycleState minState) {
		var imports = s.allTypesByMajorVersion (nameSpaceMajorVersion).filter (typeof (BusinessObject))
			.map (b|b.allReferencedVersionedTypes (minState)).flatten.map (r|r.createVersionedDomainNamespace()).toSet;
		imports.addAll (s.allExceptionsByMajorVersion (nameSpaceMajorVersion).map (e|e.allReferencedVersionedTypes (minState)).flatten.map (e|e.createVersionedDomainNamespace()));
		imports.addAll (s.allExceptionsByMajorVersion (nameSpaceMajorVersion).map (ex|ex.superException).filterNull().map (e|e.findLatestMatchingException().createVersionedDomainNamespace()));
		return imports;
	}
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of the given Service (versioned). The owning 
	 *	VersiondDomainNamespace of the found dependencies are returned.
	 */
	def dispatch Set<VersionedDomainNamespace> allImportedVersionedNS (Service s, String nameSpaceMajorVersion, LifecycleState minState) {
		var imports = s.allTypesByMajorVersion (nameSpaceMajorVersion).filter (typeof (BusinessObject))
			.map (b|b.allReferencedVersionedTypes (minState)).flatten.map (r|r.createVersionedDomainNamespace()).toSet;
		imports.addAll (s.allReferencedVersionedTypes (minState).map (e|e.createVersionedDomainNamespace()));
		imports.addAll (s.allReferencedExceptions().map (e|e.createVersionedDomainNamespace()));
		imports.addAll (s.allExceptionsByMajorVersion (nameSpaceMajorVersion).map (e|e.allReferencedVersionedTypes (minState)).flatten.map (e|e.createVersionedDomainNamespace()));
		imports.addAll (s.allExceptionsByMajorVersion (nameSpaceMajorVersion).map (ex|ex.superException).filterNull().map (e|e.findLatestMatchingException().createVersionedDomainNamespace()));
		imports.add (s.createVersionedDomainNamespace());
		return imports;
	}
		


	/*
	 *	All direct imports
	 */
	 
	/**
	 *	Calculate all dependencies of the given Service version and LifecycleState. Dependencies must match
	 *	the given minimal LifecycleState
	 *	@deprecated ?
	 *
	 *	@param svc	The Service with it's version to calculate the imports for
	 */
	def Set<SubNamespace> importedSubNamespaces (Type t, LifecycleState minState) {
		t.allReferencedVersionedTypes (minState).map (e|e.findSubdomain()).toSet();
	}
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of the given Type considering the minimal LifecycleState required by the 
	 *	given Type. The owning VersiondDomainNamespace of the found dependencies are returned.
	 */
	def dispatch Set<VersionedDomainNamespace> importedVersionedNS (Type t, LifecycleState minState) {
		t.allReferencedVersionedTypes(minState).map (e|e.createVersionedDomainNamespace()).toSet();
	}
	
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of the given Type considering the minimal LifecycleState required by the 
	 *	given Type. The owning VersiondDomainNamespace of the found dependencies are returned.
	 */
	def dispatch Set<VersionedDomainNamespace> importedVersionedNS (VersionedDomainNamespace s, LifecycleState minState) { 
		s.importedVersionedNS (minState, new HashSet<VersionedDomainNamespace>()).toSet();
	}
	
	def dispatch Set<VersionedDomainNamespace> importedVersionedNS (
		VersionedDomainNamespace s, 
		LifecycleState minState, 
		Set<VersionedDomainNamespace> visited
		) { 
		(s.subdomain as SubNamespace).importedVersionedNS (s.version, minState);
	}
	
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of all owned VersiondTypes, Exceptions and Service in the given 
	 *	VersionedDomainNamespace. The owning VersiondDomainNamespace of the found dependencies are returned.
	 */
	def Set<VersionedDomainNamespace> importedVersionedNS (VersionedDomainNamespace s) {
		s.importedVersionedNS (new HashSet<VersionedDomainNamespace>()).toSet();
	}
	
	def dispatch Set<VersionedDomainNamespace> importedVersionedNS (
		VersionedDomainNamespace s, 
		Set<VersionedDomainNamespace> visited
		) {
		(s.subdomain as SubNamespace).importedVersionedNS (s.version);
	}
	
	
	def dispatch Set<VersionedDomainNamespace> importedVersionedNS (Object s, String nameSpaceMajorVersion, LifecycleState minState) {}
	def dispatch Set<VersionedDomainNamespace> importedVersionedNS (Object s, String nameSpaceMajorVersion) {}
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of all owned VersiondTypes, Exceptions and Service in the given 
	 *	SubNamespace matching the given major version. The owning VersiondDomainNamespace of the found dependencies are returned.
	 */
	def dispatch Set<VersionedDomainNamespace> importedVersionedNS (SubNamespace s, String nameSpaceMajorVersion, LifecycleState minState) {
		var imports = s.allTypesByMajorVersion (nameSpaceMajorVersion).filter (typeof (BusinessObject))
			.map (b|b.allReferencedVersionedTypes (minState)).flatten.map (e|e.createVersionedDomainNamespace()).toSet;
		imports.addAll (s.allExceptionsByMajorVersion (nameSpaceMajorVersion).map (ex|ex.allReferencedVersionedTypes (minState)).flatten.map(e|e.createVersionedDomainNamespace()));
		imports.addAll (s.allExceptionsByMajorVersion (nameSpaceMajorVersion).map (ex|ex.superException).filterNull().map (e|e.findLatestMatchingException().createVersionedDomainNamespace()));
		imports;
	}
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of the given Service (versioned). The owning 
	 *	VersiondDomainNamespace of the found dependencies are returned.
	 */
	def dispatch Set<VersionedDomainNamespace> importedVersionedNS (Service s, String nameSpaceMajorVersion, LifecycleState minState) {
		var imports = s.allTypesByMajorVersion (nameSpaceMajorVersion).filter (typeof (BusinessObject))
			.map (b|b.allReferencedVersionedTypes (minState)).flatten.map (e|e.createVersionedDomainNamespace()).toSet;
		imports.addAll (s.allReferencedVersionedTypes (minState).map (e|e.createVersionedDomainNamespace()));
		imports.addAll (s.allReferencedExceptions().map (e|e.createVersionedDomainNamespace()));
		imports.addAll (s.allExceptionsByMajorVersion (nameSpaceMajorVersion).map (e|e.allReferencedVersionedTypes (minState)).flatten.map(e|e.createVersionedDomainNamespace()));
		imports.addAll (s.allExceptionsByMajorVersion (nameSpaceMajorVersion).map (e|e.superException).filterNull().map (e|e.findLatestMatchingException().createVersionedDomainNamespace()));
		imports.addAll ({s.createVersionedDomainNamespace()});
		return imports;
	}

}