package org.fornax.soa.servicedsl.generator.query.namespace

import com.google.inject.Inject
import java.util.HashSet
import java.util.Set
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.basedsl.generator.version.VersionMatcher
import org.fornax.soa.basedsl.generator.version.VersionQualifierExtensions
import org.fornax.soa.profiledsl.generator.namespace.VersionedTechnicalNamespace
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace
import org.fornax.soa.serviceDsl.BusinessObject
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.serviceDsl.Type
import org.fornax.soa.serviceDsl.VersionedTypeRef
import org.fornax.soa.service.VersionedDomainNamespace
import org.fornax.soa.servicedsl.generator.domain.NamespaceSplitter
import org.fornax.soa.servicedsl.generator.query.ExceptionFinder
import org.fornax.soa.servicedsl.generator.query.ServiceFinder
import org.fornax.soa.servicedsl.generator.query.type.BusinessObjectQueries
import org.fornax.soa.servicedsl.generator.query.type.LatestMatchingTypeFinder
import org.fornax.soa.servicedsl.generator.query.type.ReferencedTypesFinder
import org.fornax.soa.servicedsl.generator.query.type.VersionedTypeFilter
import org.fornax.soa.profiledsl.generator.namespace.TechnicalNamespaceSplitter

/*********************************************************************************
 *	Calculation of all VersionedDomainNamespaces imported by a given or derived 
 *	VersionedDomainNamespace. Transitive dependencies are not yet calculated
 */
class NamespaceImportQueries {
	
	@Inject extension VersionMatcher
	@Inject extension VersionQualifierExtensions
	@Inject extension NamespaceQuery
	@Inject extension LatestMatchingTypeFinder
	@Inject extension VersionedTypeFilter
	@Inject extension BusinessObjectQueries
	@Inject extension ReferencedTypesFinder

	@Inject ExceptionFinder excFinder
	@Inject ServiceFinder serviceFinder
	@Inject NamespaceSplitter namespaceSplitter
	@Inject TechnicalNamespaceSplitter technicalNSSpliter
	
	/**
	 *	Calculate all dependencies of the given Service version
	 *	@deprecated ?
	 *
	 *	@param svc	The Service with it's version to calculate the imports for
	 */
	def Set<VersionedDomainNamespace> findImportedSubdomains (Service svc) { 
		var imports = svc.operations.map (o|o.parameters).flatten.map (p|p.type).filter(typeof (VersionedTypeRef))
			.map (r|r.findLatestMatchingType()).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace(e)).toSet;
		imports.addAll (svc.operations.map (o|o.^return).flatten.map (r|r.type).filter (typeof (VersionedTypeRef))
			.map (v|v.findLatestMatchingType()).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (svc.operations.map (o|o.^throws).flatten.map(t|excFinder.findLatestMatchingException(t)).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace(e)));
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
		t.allReferencedVersionedTypes(minState).map (e|namespaceSplitter.createVersionedDomainNamespace(e)).toSet();
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
			s.subdomain.allImportedVersionedNS (s.version, minState).map (vns |vns.allImportedVersionedNS (minState, visited)).flatten.toSet;
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
			.map (b|b.allReferencedVersionedTypes (minState)).flatten.map (r|namespaceSplitter.createVersionedDomainNamespace(r)).toSet;

		val exByMajor = serviceFinder.allExceptionsByMajorVersion (s, nameSpaceMajorVersion);
		imports.addAll (exByMajor.map (e|e.allReferencedVersionedTypes (minState)).flatten.map (e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (exByMajor.map (ex|ex.superException).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace (excFinder.findLatestMatchingException(e))));
		return imports;
	}
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of the given Service (versioned). The owning 
	 *	VersiondDomainNamespace of the found dependencies are returned.
	 */
	def dispatch Set<VersionedDomainNamespace> allImportedVersionedNS (Service s, String nameSpaceMajorVersion, LifecycleState minState) {
		var imports = s.allTypesByMajorVersion (nameSpaceMajorVersion).filter (typeof (BusinessObject))
			.map (b|b.allReferencedVersionedTypes (minState)).flatten.map (r|namespaceSplitter.createVersionedDomainNamespace(r)).toSet;
		imports.addAll (s.allReferencedVersionedTypes (minState).map (e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (serviceFinder.allReferencedExceptions (s).map (e|namespaceSplitter.createVersionedDomainNamespace(e)));

		val exByMajor = serviceFinder.allExceptionsByMajorVersion (s, nameSpaceMajorVersion);
		imports.addAll (exByMajor.map (e|e.allReferencedVersionedTypes (minState)).flatten.map (e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (exByMajor.map (ex|ex.superException).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace (excFinder.findLatestMatchingException(e))));
		imports.add (namespaceSplitter.createVersionedDomainNamespace(s));
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
		t.allReferencedVersionedTypes (minState).map (e|namespaceSplitter.createVersionedDomainNamespace(e)).toSet();
	}
	
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of the given Type considering the minimal LifecycleState required by the 
	 *	given Type. The owning VersiondDomainNamespace of the found dependencies are returned.
	 */
	def dispatch Set<VersionedDomainNamespace> importedVersionedNS (VersionedDomainNamespace s, LifecycleState minState) { 
		s.importedVersionedNS (minState, new HashSet<VersionedDomainNamespace>()).toSet();
	}
	
			/*called this????*/
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
	def dispatch Set<VersionedDomainNamespace> importedVersionedNS (VersionedDomainNamespace s) {
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
		var imports = s.allTypesByMajorVersion (nameSpaceMajorVersion, minState).filter (typeof (BusinessObject))
			.map (b|b.allReferencedVersionedTypes (minState)).flatten.map (e|namespaceSplitter.createVersionedDomainNamespace(e)).toSet;
		val exByMajor = serviceFinder.allExceptionsByMajorVersion (s, nameSpaceMajorVersion);
		imports.addAll (exByMajor.map (ex|ex.allReferencedVersionedTypes (minState)).flatten.map(e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (exByMajor.map (ex|ex.superException).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace (excFinder.findLatestMatchingException (e))));
		imports;
	}
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of the given Service (versioned). The owning 
	 *	VersiondDomainNamespace of the found dependencies are returned.
	 */
	def dispatch Set<VersionedDomainNamespace> importedVersionedNS (Service s, LifecycleState minState) {
		var imports = new HashSet<VersionedDomainNamespace>();
		var serviceBos = s.allReferencedVersionedTypes (minState).map (e|namespaceSplitter.createVersionedDomainNamespace(e));
		imports.addAll (serviceBos);
		val allEx = serviceFinder.allReferencedExceptions(s);
		imports.addAll (allEx.map (e|namespaceSplitter.createVersionedDomainNamespace(e)));
		
		val exRefTypes = allEx.map (e|e.allReferencedVersionedTypes (minState)).flatten;
		imports.addAll (exRefTypes.map(e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (allEx.map (e|e.superException).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace (excFinder.findLatestMatchingException(e))));
		return imports;
	}
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of the given Service (versioned). The owning 
	 *	VersiondDomainNamespace of the found dependencies are returned.
	 */
	def dispatch Set<VersionedDomainNamespace> importedVersionedNS (Service s, String nameSpaceMajorVersion, LifecycleState minState) {
		var imports = new HashSet<VersionedDomainNamespace>();
		var serviceBos = s.allReferencedVersionedTypes (minState).map (e|namespaceSplitter.createVersionedDomainNamespace(e));
		imports.addAll (serviceBos);
		imports.addAll (serviceFinder.allReferencedExceptions(s).map (e|namespaceSplitter.createVersionedDomainNamespace(e)));

		val exByMajor = serviceFinder.allExceptionsByMajorVersion (s, nameSpaceMajorVersion);
		val exRefTypes = exByMajor.map (e|e.allReferencedVersionedTypes (minState)).flatten;
		imports.addAll (exRefTypes.map(e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (exByMajor.map (e|e.superException).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace (excFinder.findLatestMatchingException(e))));
		return imports;
	}

}
