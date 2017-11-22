package org.xkonnex.repo.dsl.servicedsl.service.query.namespace

import com.google.inject.Inject
import java.util.HashSet
import java.util.Set
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.servicedsl.service.VersionedDomainNamespace
import org.xkonnex.repo.dsl.servicedsl.service.query.ServiceQueries
import org.xkonnex.repo.dsl.servicedsl.service.query.type.ReferencedTypesFinder
import org.xkonnex.repo.dsl.servicedsl.service.query.type.VersionedTypeFilter
import org.xkonnex.repo.dsl.servicedsl.service.versioning.IExceptionResolver
import org.xkonnex.repo.dsl.servicedsl.service.versioning.NamespaceSplitter
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.AbstractVersionedTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.BusinessObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Type
import org.xkonnex.repo.dsl.servicedsl.service.versioning.IVersionedTypeRefResolver
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObject

/*********************************************************************************
 *	Calculation of all VersionedDomainNamespaces imported by a given or derived 
 *	VersionedDomainNamespace. Transitive dependencies are not yet calculated
 */
class NamespaceImportQueries {
	
	@Inject extension NamespaceQuery
	@Inject extension IVersionedTypeRefResolver
	@Inject extension VersionedTypeFilter
	@Inject extension ReferencedTypesFinder

	@Inject IExceptionResolver excResolver
	@Inject ServiceQueries serviceFinder
	@Inject NamespaceSplitter namespaceSplitter
	
	/**
	 *	Calculate all dependencies of the given Service version
	 *	@deprecated ?
	 *
	 *	@param svc	The Service with it's version to calculate the imports for
	 */
	def Set<VersionedDomainNamespace> findImportedSubdomains (Service svc) { 
		var imports = svc.operations.map (o|o.parameters).flatten.map (p|p.type).filter(typeof (AbstractVersionedTypeRef))
			.map (r|r.findMatchingTypeVersion()).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace(e)).toSet;
		imports.addAll (svc.operations.map (o|o.^return).flatten.map (r|r.type).filter (typeof (AbstractVersionedTypeRef))
			.map (v|v.findMatchingTypeVersion()).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (svc.operations.map (o|o.^throws).flatten.map(t|excResolver.findMatchingException(t)).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace(e)));
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
	def Set<VersionedDomainNamespace> allImportedVersionedNS (Type t, LifecycleState minState) {
		t.allReferencedVersionedTypes(minState).map (e|namespaceSplitter.createVersionedDomainNamespace(e)).toSet();
	}
	
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of the given Type considering the minimal LifecycleState required by the 
	 *	given Type. The owning VersiondDomainNamespace of the found dependencies are returned.
	 */
	def  Set<VersionedDomainNamespace> allImportedVersionedNS (VersionedDomainNamespace s, LifecycleState minState) { 
		s.allImportedVersionedNS (minState, (new HashSet<VersionedDomainNamespace>())).toSet();
	}

	def Set<VersionedDomainNamespace> allImportedVersionedNS (
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
		s.allImportedVersionedNSStateless (new HashSet<VersionedDomainNamespace>() ).filter (typeof (VersionedDomainNamespace)).toSet;
	}
	
	private def Set<VersionedDomainNamespace> allImportedVersionedNSStateless (
		VersionedDomainNamespace s, 
		Set<VersionedDomainNamespace> visited
		) {
		if (! visited.contains(s) ) { 
			visited.add(s);
			val subNamespaceImports = allImportedVersionedNS (s.subdomain, s.version)
			subNamespaceImports.map(vns | allImportedVersionedNSStateless (vns, visited)).filter (typeof (VersionedDomainNamespace)).toSet;
		} else {
			visited.filter (typeof (VersionedDomainNamespace)).toSet;
		}
	}

	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of all owned VersiondTypes, Exceptions and Service in the given 
	 *	SubNamespace matching the given major version. The owning VersiondDomainNamespace of the found dependencies are returned.
	 */
	def Set<VersionedDomainNamespace> allImportedVersionedNS (SubNamespace s, String nameSpaceMajorVersion) {
		var imports = s.allTypesByMajorVersion (nameSpaceMajorVersion).filter (typeof (BusinessObject))
			.map (b|b.allReferencedVersionedTypes ()).flatten.map (r|namespaceSplitter.createVersionedDomainNamespace(r)).toSet;

		val exByMajor = serviceFinder.allExceptionsByMajorVersion (s, nameSpaceMajorVersion);
		imports.addAll (exByMajor.map (e|e.allReferencedVersionedTypes ()).flatten.map (e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (exByMajor.map (ex|ex.superException).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace (excResolver.findMatchingException(e))));
		return imports;
	}

	/**
	 *	Calculate all dependencies of the given Service version and LifecycleState. Dependencies must match
	 *	the given minimal LifecycleState
	 *	@deprecated ?
	 *
	 *	@param svc	The Service with it's version to calculate the imports for
	 */
	def Set<SubNamespace> allImportedSubNamespaces (Type t) { 
		t.allReferencedVersionedTypes ().map (e|e.findSubdomain()).toSet();
	}	
	
//	def dispatch Set<VersionedDomainNamespace> allImportedVersionedNS (Object s, String nameSpaceMajorVersion, LifecycleState minState) {}
//	def dispatch Set<VersionedDomainNamespace> allImportedVersionedNS (Object s, String nameSpaceMajorVersion) {}
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of all owned VersiondTypes, Exceptions and Service in the given 
	 *	SubNamespace matching the given major version. The owning VersiondDomainNamespace of the found dependencies are returned.
	 */
	def Set<VersionedDomainNamespace> allImportedVersionedNS (SubNamespace s, String nameSpaceMajorVersion, LifecycleState minState) {
		var imports = s.allTypesByMajorVersion (nameSpaceMajorVersion).filter (typeof (BusinessObject))
			.map (b|b.allReferencedVersionedTypes (minState)).flatten.map (r|namespaceSplitter.createVersionedDomainNamespace(r)).toSet;

		val exByMajor = serviceFinder.allExceptionsByMajorVersion (s, nameSpaceMajorVersion);
		imports.addAll (exByMajor.map (e|e.allReferencedVersionedTypes (minState)).flatten.map (e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (exByMajor.map (ex|ex.superException).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace (excResolver.findMatchingException(e))));
		return imports;
	}
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of the given Service (versioned). The owning 
	 *	VersiondDomainNamespace of the found dependencies are returned.
	 */
	def Set<VersionedDomainNamespace> allImportedVersionedNS (Service s, String nameSpaceMajorVersion, LifecycleState minState) {
		var imports = s.allTypesByMajorVersion (nameSpaceMajorVersion).filter (typeof (DataObject))
			.map (b|b.allReferencedVersionedTypes (minState)).flatten.map (r|namespaceSplitter.createVersionedDomainNamespace(r)).toSet;
		imports.addAll (s.allReferencedVersionedTypes (minState).map (e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (serviceFinder.allReferencedExceptions (s).map (e|namespaceSplitter.createVersionedDomainNamespace(e)));

		val exByMajor = serviceFinder.allExceptionsByMajorVersion (s, nameSpaceMajorVersion);
		imports.addAll (exByMajor.map (e|e.allReferencedVersionedTypes (minState)).flatten.map (e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (exByMajor.map (ex|ex.superException).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace (excResolver.findMatchingException(e))));
		imports.add (namespaceSplitter.createVersionedDomainNamespace(s));
		return imports;
	}
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of the given Service (versioned). The owning 
	 *	VersiondDomainNamespace of the found dependencies are returned.
	 */
	def Set<VersionedDomainNamespace> allImportedVersionedNS (Resource s, String nameSpaceMajorVersion, LifecycleState minState) {
		var imports = s.allTypesByMajorVersion (nameSpaceMajorVersion).filter (typeof (DataObject))
			.map (b|b.allReferencedVersionedTypes (minState)).flatten.map (r|namespaceSplitter.createVersionedDomainNamespace(r)).toSet;
		imports.addAll (s.allReferencedVersionedTypes (minState).map (e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (serviceFinder.allReferencedExceptions (s).map (e|namespaceSplitter.createVersionedDomainNamespace(e)));

		val exByMajor = serviceFinder.allExceptionsByMajorVersion (s, nameSpaceMajorVersion);
		imports.addAll (exByMajor.map (e|e.allReferencedVersionedTypes (minState)).flatten.map (e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (exByMajor.map (ex|ex.superException).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace (excResolver.findMatchingException(e))));
		imports.add (namespaceSplitter.createVersionedDomainNamespace(s));
		return imports;
	}
		
//
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of all owned VersiondTypes, Exceptions and Service in the given 
	 *	SubNamespace matching the given major version. The owning VersiondDomainNamespace of the found dependencies are returned.
	 */
	def Set<VersionedDomainNamespace> allImportedVersionedNSStateless (SubNamespace s, String nameSpaceMajorVersion) {
		var imports = s.allTypesByMajorVersion (nameSpaceMajorVersion).filter (typeof (BusinessObject))
			.map (b|b.allReferencedVersionedTypes ()).flatten.map (r|namespaceSplitter.createVersionedDomainNamespace(r)).toSet;

		val exByMajor = serviceFinder.allExceptionsByMajorVersion (s, nameSpaceMajorVersion);
		imports.addAll (exByMajor.map (e|e.allReferencedVersionedTypes ()).flatten.map (e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (exByMajor.map (ex|ex.superException).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace (excResolver.findMatchingException(e))));
		return imports;
	}
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of the given Service (versioned). The owning 
	 *	VersiondDomainNamespace of the found dependencies are returned.
	 */
	def Set<VersionedDomainNamespace> allImportedVersionedNSStateless (Service s, String nameSpaceMajorVersion) {
		var imports = s.allTypesByMajorVersion (nameSpaceMajorVersion).filter (typeof (DataObject))
			.map (b|b.allReferencedVersionedTypes ()).flatten.map (r|namespaceSplitter.createVersionedDomainNamespace(r)).toSet;
		imports.addAll (s.allReferencedVersionedTypes ().map (e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (serviceFinder.allReferencedExceptions (s).map (e|namespaceSplitter.createVersionedDomainNamespace(e)));

		val exByMajor = serviceFinder.allExceptionsByMajorVersion (s, nameSpaceMajorVersion);
		imports.addAll (exByMajor.map (e|e.allReferencedVersionedTypes ()).flatten.map (e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (exByMajor.map (ex|ex.superException).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace (excResolver.findMatchingException(e))));
		imports.add (namespaceSplitter.createVersionedDomainNamespace(s));
		return imports;
	}
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of the given Service (versioned). The owning 
	 *	VersiondDomainNamespace of the found dependencies are returned.
	 */
	def Set<VersionedDomainNamespace> allImportedVersionedNSStateless (Resource s, String nameSpaceMajorVersion) {
		var imports = s.allTypesByMajorVersion (nameSpaceMajorVersion).filter (typeof (DataObject))
			.map (b|b.allReferencedVersionedTypes ()).flatten.map (r|namespaceSplitter.createVersionedDomainNamespace(r)).toSet;
		imports.addAll (s.allReferencedVersionedTypes ().map (e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (serviceFinder.allReferencedExceptions (s).map (e|namespaceSplitter.createVersionedDomainNamespace(e)));

		val exByMajor = serviceFinder.allExceptionsByMajorVersion (s, nameSpaceMajorVersion);
		imports.addAll (exByMajor.map (e|e.allReferencedVersionedTypes ()).flatten.map (e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (exByMajor.map (ex|ex.superException).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace (excResolver.findMatchingException(e))));
		imports.add (namespaceSplitter.createVersionedDomainNamespace(s));
		return imports;
	}
//

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
	def Set<VersionedDomainNamespace> importedVersionedNS (Type t, LifecycleState minState) {
		t.allReferencedVersionedTypes (minState).map (e|namespaceSplitter.createVersionedDomainNamespace(e)).toSet();
	}
	
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of the given Type considering the minimal LifecycleState required by the 
	 *	given Type. The owning VersiondDomainNamespace of the found dependencies are returned.
	 */
	def Set<VersionedDomainNamespace> importedVersionedNS (VersionedDomainNamespace s, LifecycleState minState) { 
		s.importedVersionedNS (minState, new HashSet<VersionedDomainNamespace>()).toSet();
	}
	
			/*called this????*/
	def Set<VersionedDomainNamespace> importedVersionedNS (
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
		s.importedVersionedNSStateless (new HashSet<VersionedDomainNamespace>()).toSet();
	}
	
	def Set<VersionedDomainNamespace> importedVersionedNSStateless (
		VersionedDomainNamespace s, 
		Set<VersionedDomainNamespace> visited
		) {
		(s.subdomain as SubNamespace).importedVersionedNS (s.version);
	}
	
	
//	def dispatch Set<VersionedDomainNamespace> importedVersionedNS (Object s, String nameSpaceMajorVersion, LifecycleState minState) {}
//	def dispatch Set<VersionedDomainNamespace> importedVersionedNS (Object s, String nameSpaceMajorVersion) {}
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of all owned VersiondTypes, Exceptions and Service in the given 
	 *	SubNamespace matching the given major version. The owning VersiondDomainNamespace of the found dependencies are returned.
	 */
	def Set<VersionedDomainNamespace> importedVersionedNS (SubNamespace s, String nameSpaceMajorVersion, LifecycleState minState) {
		var imports = s.allTypesByMajorVersion (nameSpaceMajorVersion, minState).filter (typeof (BusinessObject))
			.map (b|b.allReferencedVersionedTypes (minState)).flatten.map (e|namespaceSplitter.createVersionedDomainNamespace(e)).toSet;
		val exByMajor = serviceFinder.allExceptionsByMajorVersion (s, nameSpaceMajorVersion);
		imports.addAll (exByMajor.map (ex|ex.allReferencedVersionedTypes (minState)).flatten.map(e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (exByMajor.map (ex|ex.superException).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace (excResolver.findMatchingException (e))));
		imports;
	}
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of the given Service (versioned). The owning 
	 *	VersiondDomainNamespace of the found dependencies are returned.
	 */
	def Set<VersionedDomainNamespace> importedVersionedNS (Service s, LifecycleState minState) {
		var imports = new HashSet<VersionedDomainNamespace>();
		var serviceBos = s.allReferencedVersionedTypes (minState).map (e|namespaceSplitter.createVersionedDomainNamespace(e));
		imports.addAll (serviceBos);
		val allEx = serviceFinder.allReferencedExceptions(s);
		imports.addAll (allEx.map (e|namespaceSplitter.createVersionedDomainNamespace(e)));
		
		val exRefTypes = allEx.map (e|e.allReferencedVersionedTypes (minState)).flatten;
		imports.addAll (exRefTypes.map(e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (allEx.map (e|e.superException).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace (excResolver.findMatchingException(e))));
		return imports;
	}
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of the given Service (versioned). The owning 
	 *	VersiondDomainNamespace of the found dependencies are returned.
	 */
	def Set<VersionedDomainNamespace> importedVersionedNS (Resource s, LifecycleState minState) {
		var imports = new HashSet<VersionedDomainNamespace>();
		var serviceBos = s.allReferencedVersionedTypes (minState).map (e|namespaceSplitter.createVersionedDomainNamespace(e));
		imports.addAll (serviceBos);
		val allEx = serviceFinder.allReferencedExceptions(s);
		imports.addAll (allEx.map (e|namespaceSplitter.createVersionedDomainNamespace(e)));
		
		val exRefTypes = allEx.map (e|e.allReferencedVersionedTypes (minState)).flatten;
		imports.addAll (exRefTypes.map(e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (allEx.map (e|e.superException).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace (excResolver.findMatchingException(e))));
		return imports;
	}
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of the given Service (versioned). The owning 
	 *	VersiondDomainNamespace of the found dependencies are returned.
	 */
	def Set<VersionedDomainNamespace> importedVersionedNS (Service s, String nameSpaceMajorVersion, LifecycleState minState) {
		var imports = new HashSet<VersionedDomainNamespace>();
		var serviceBos = s.allReferencedVersionedTypes (minState).map (e|namespaceSplitter.createVersionedDomainNamespace(e));
		imports.addAll (serviceBos);
		imports.addAll (serviceFinder.allReferencedExceptions(s).map (e|namespaceSplitter.createVersionedDomainNamespace(e)));

		val exByMajor = serviceFinder.allExceptionsByMajorVersion (s, nameSpaceMajorVersion);
		val exRefTypes = exByMajor.map (e|e.allReferencedVersionedTypes (minState)).flatten;
		imports.addAll (exRefTypes.map(e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (exByMajor.map (e|e.superException).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace (excResolver.findMatchingException(e))));
		return imports;
	}
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of the given Service (versioned). The owning 
	 *	VersiondDomainNamespace of the found dependencies are returned.
	 */
	def Set<VersionedDomainNamespace> importedVersionedNS (Resource s, String nameSpaceMajorVersion, LifecycleState minState) {
		var imports = new HashSet<VersionedDomainNamespace>();
		var serviceBos = s.allReferencedVersionedTypes (minState).map (e|namespaceSplitter.createVersionedDomainNamespace(e));
		imports.addAll (serviceBos);
		imports.addAll (serviceFinder.allReferencedExceptions(s).map (e|namespaceSplitter.createVersionedDomainNamespace(e)));

		val exByMajor = serviceFinder.allExceptionsByMajorVersion (s, nameSpaceMajorVersion);
		val exRefTypes = exByMajor.map (e|e.allReferencedVersionedTypes (minState)).flatten;
		imports.addAll (exRefTypes.map(e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (exByMajor.map (e|e.superException).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace (excResolver.findMatchingException(e))));
		return imports;
	}





	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of all owned VersiondTypes, Exceptions and Service in the given 
	 *	SubNamespace matching the given major version. The owning VersiondDomainNamespace of the found dependencies are returned.
	 */
	def Set<VersionedDomainNamespace> importedVersionedNS (SubNamespace s, String nameSpaceMajorVersion) {
		var imports = s.allTypesByMajorVersion (nameSpaceMajorVersion).filter (typeof (BusinessObject))
			.map (b|b.allReferencedVersionedTypes ()).flatten.map (e|namespaceSplitter.createVersionedDomainNamespace(e)).toSet;
		val exByMajor = serviceFinder.allExceptionsByMajorVersion (s, nameSpaceMajorVersion);
		imports.addAll (exByMajor.map (ex|ex.allReferencedVersionedTypes ()).flatten.map(e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (exByMajor.map (ex|ex.superException).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace (excResolver.findMatchingException (e))));
		imports;
	}
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of the given Service (versioned). The owning 
	 *	VersiondDomainNamespace of the found dependencies are returned.
	 */
	def Set<VersionedDomainNamespace> importedVersionedNS (Service s) {
		var imports = new HashSet<VersionedDomainNamespace>();
		var serviceBos = s.allReferencedVersionedTypes ().map (e|namespaceSplitter.createVersionedDomainNamespace(e));
		imports.addAll (serviceBos);
		val allEx = serviceFinder.allReferencedExceptions(s);
		imports.addAll (allEx.map (e|namespaceSplitter.createVersionedDomainNamespace(e)));
		
		val exRefTypes = allEx.map (e|e.allReferencedVersionedTypes ()).flatten;
		imports.addAll (exRefTypes.map(e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (allEx.map (e|e.superException).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace (excResolver.findMatchingException(e))));
		return imports;
	}
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of the given Service (versioned). The owning 
	 *	VersiondDomainNamespace of the found dependencies are returned.
	 */
	def Set<VersionedDomainNamespace> importedVersionedNS (Resource s) {
		var imports = new HashSet<VersionedDomainNamespace>();
		var serviceBos = s.allReferencedVersionedTypes ().map (e|namespaceSplitter.createVersionedDomainNamespace(e));
		imports.addAll (serviceBos);
		val allEx = serviceFinder.allReferencedExceptions(s);
		imports.addAll (allEx.map (e|namespaceSplitter.createVersionedDomainNamespace(e)));
		
		val exRefTypes = allEx.map (e|e.allReferencedVersionedTypes ()).flatten;
		imports.addAll (exRefTypes.map(e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (allEx.map (e|e.superException).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace (excResolver.findMatchingException(e))));
		return imports;
	}
	
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of the given Service (versioned). The owning 
	 *	VersiondDomainNamespace of the found dependencies are returned.
	 */
	def Set<VersionedDomainNamespace> importedVersionedNS (Service s, String nameSpaceMajorVersion) {
		var imports = new HashSet<VersionedDomainNamespace>();
		var serviceBos = s.allReferencedVersionedTypes ().map (e|namespaceSplitter.createVersionedDomainNamespace(e));
		imports.addAll (serviceBos);
		imports.addAll (serviceFinder.allReferencedExceptions(s).map (e|namespaceSplitter.createVersionedDomainNamespace(e)));

		val exByMajor = serviceFinder.allExceptionsByMajorVersion (s, nameSpaceMajorVersion);
		val exRefTypes = exByMajor.map (e|e.allReferencedVersionedTypes ()).flatten;
		imports.addAll (exRefTypes.map(e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (exByMajor.map (e|e.superException).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace (excResolver.findMatchingException(e))));
		return imports;
	}
	/**
	 *	Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
	 *	are derived from the versioned dependencies of the given Service (versioned). The owning 
	 *	VersiondDomainNamespace of the found dependencies are returned.
	 */
	def Set<VersionedDomainNamespace> importedVersionedNS (Resource s, String nameSpaceMajorVersion) {
		var imports = new HashSet<VersionedDomainNamespace>();
		var serviceBos = s.allReferencedVersionedTypes ().map (e|namespaceSplitter.createVersionedDomainNamespace(e));
		imports.addAll (serviceBos);
		imports.addAll (serviceFinder.allReferencedExceptions(s).map (e|namespaceSplitter.createVersionedDomainNamespace(e)));

		val exByMajor = serviceFinder.allExceptionsByMajorVersion (s, nameSpaceMajorVersion);
		val exRefTypes = exByMajor.map (e|e.allReferencedVersionedTypes ()).flatten;
		imports.addAll (exRefTypes.map(e|namespaceSplitter.createVersionedDomainNamespace(e)));
		imports.addAll (exByMajor.map (e|e.superException).filterNull().map (e|namespaceSplitter.createVersionedDomainNamespace (excResolver.findMatchingException(e))));
		return imports;
	}

}
