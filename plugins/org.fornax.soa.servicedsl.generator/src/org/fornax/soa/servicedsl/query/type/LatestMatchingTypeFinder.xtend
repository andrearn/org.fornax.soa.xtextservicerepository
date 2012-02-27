package org.fornax.soa.servicedsl.query.type

import com.google.inject.Inject
import java.util.List
import org.fornax.soa.basedsl.lifecycle.StateMatcher
import org.fornax.soa.basedsl.sOABaseDsl.AbstractType
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState
import org.fornax.soa.basedsl.version.VersionMatcher
import org.fornax.soa.serviceDsl.AbstractVersionedTypeRef
import org.fornax.soa.serviceDsl.BusinessObject
import org.fornax.soa.serviceDsl.BusinessObjectRef
import org.fornax.soa.serviceDsl.DataTypeRef
import org.fornax.soa.serviceDsl.EnumTypeRef
import org.fornax.soa.serviceDsl.Enumeration
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.serviceDsl.Type
import org.fornax.soa.serviceDsl.TypeRef
import org.fornax.soa.serviceDsl.VersionedType
import org.fornax.soa.serviceDsl.VersionedTypeRef
import org.fornax.soa.servicedsl.query.namespace.NamespaceQuery
import org.eclipse.emf.ecore.EObject

class LatestMatchingTypeFinder {
	
	@Inject extension VersionMatcher
	@Inject extension StateMatcher
	@Inject extension NamespaceQuery
	
	def dispatch VersionedType selectLatestMatchingType (AbstractVersionedTypeRef ref) {}
	
	def dispatch VersionedType selectLatestMatchingType (VersionedTypeRef ref) {
		ref.type;
	}
	
	def dispatch VersionedType selectLatestMatchingType (BusinessObjectRef ref) {
		ref.type;
	}
		
	def dispatch VersionedType selectLatestMatchingType (EnumTypeRef ref) {
		ref.type;
	}
	
	def dispatch VersionedType selectLatestMatchingType (AbstractVersionedTypeRef ref, LifecycleState minState) {}
	
	def dispatch VersionedType selectLatestMatchingType (VersionedTypeRef ref, LifecycleState minState) {
		ref.type.findSubdomain().types.filter (typeof (VersionedType)).filter (e| e.state.matchesMinStateLevel(minState))
		.filter (t|t.name == ref.type.name && t.version.versionMatches (ref.versionRef))
		.sortBy(e|e.version.version).last();
	}
		
	def dispatch VersionedType selectLatestMatchingType (BusinessObjectRef ref, LifecycleState minState) {
		ref.type.findSubdomain().types.filter (typeof (VersionedType)).filter (e| e.state.matchesMinStateLevel(minState))
		.filter (t|t.name == ref.type.name && t.version.versionMatches (ref.versionRef))
		.sortBy(e|e.version.version).last();
	}
	
	def dispatch VersionedType selectLatestMatchingType (EnumTypeRef ref, LifecycleState minState) {
		ref.type.findSubdomain().types.filter (typeof (VersionedType)).filter(e| e.state.matchesMinStateLevel(minState))
		.filter (t|t.name == ref.type.name && t.version.versionMatches (ref.versionRef))
		.sortBy(e|e.version.version).last();
	}
	
		
		
	/*
	 *	Checks if type declaration is the latest version matching the following constraint. The function
	 *	should never be called as Type is not versioned and considered abstract
	 */
	def dispatch boolean isLatestMatchingType (Type t, Integer majorVersion, LifecycleState minState) { 
		false;
	}
	
	/*
	 *		Checks if type declaration is the latest version matching the following constraint
	 *		- same major version
	 */
	def dispatch boolean isLatestMatchingType (VersionedType t, Integer majorVersion) { 
		(findLatestMatchingVersionedType ( 
			(t.eContainer as SubNamespace).types.filter (typeof (VersionedType)).filter (e|e.name == t.name).toList, 
			majorVersion)
		 == t);
	}		

	/*
	 *		Checks if type declaration is the latest version matching the following constraint
	 *		- same major version
	 */
	def dispatch boolean isLatestMatchingType (org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType t, Integer majorVersion) { 
		(findLatestMatchingVersionedTypeFromProfile ( 
			(t.eContainer as SubNamespace).types.filter (typeof (org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType)).filter (e|e.name == t.name).toList, 
			majorVersion)
		 == t);
	}		

	/*
	 *		Checks if type declaration is the latest version matching the following constraint
	 *		- same major version
	 *      - matches a given minimal lifecycle state
	 */
	def dispatch boolean isLatestMatchingType (VersionedType t, Integer majorVersion, LifecycleState minState) { 
		findLatestMatchingVersionedType ( 
			(t.eContainer as SubNamespace).types.filter (typeof (VersionedType)).filter (e|e.name == t.name).toList, 
			majorVersion, 
			minState) == t;
	}
		
	def private dispatch Type findLatestMatchingVersionedType (List<VersionedType> types, Integer majorVersion) { 
		types.filter (
			e|e.version.versionMatches (majorVersion) 
		).sortBy(e|e.version.version).last();
	}
	
	def private dispatch org.fornax.soa.profiledsl.sOAProfileDsl.Type findLatestMatchingVersionedTypeFromProfile (List<org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType> types, Integer majorVersion) { 
		types.filter (
			e|e.version.versionMatches (majorVersion) 
		).sortBy(e|e.version.version).last();
	}
	
	def private Type findLatestMatchingVersionedType (List<VersionedType> types, Integer majorVersion, LifecycleState minState) { 
		types.filter (
			e|e.version.versionMatches (majorVersion) && 
			e.state.matchesMinStateLevel (minState)
		).sortBy (e|e.version.version).last();
	}

	
	/**
	 * 		Type reference resolution
	 *		find the lastest type declaration matching
	 *  	- the version constraint defined in the reference
	 */
	def dispatch Type findLatestMatchingType (EObject t) {
	}
	def dispatch Type findLatestMatchingType (TypeRef t) {
	}
	
	def dispatch Type findLatestMatchingType (VersionedTypeRef t) {
		t.type.findSubdomain ().types.
			filter (e|e.toTypeName() == t.type.toTypeName() && t.type.version.versionMatches (t.versionRef))
			.filter (typeof (VersionedType))
			.sortBy (e|e.version.version).last( );
	}
	
	def dispatch Type findLatestMatchingType (BusinessObjectRef t) { 
		t.type.findSubdomain ().types.
			filter (e|e.toTypeName() == t.type.toTypeName() && t.type.version.versionMatches (t.versionRef))
			.filter (typeof (BusinessObject))
			.sortBy (e|e.version.version).last( );
	}
	
	def dispatch Type findLatestMatchingType (EnumTypeRef t) { 
		t.type.findSubdomain ().types.
			filter (
				e|e.toTypeName() == t.type.toTypeName() && 
				t.type.version.versionMatches (t.versionRef)
			)
			.filter (typeof (Enumeration))
			.sortBy (e|e.version.version).last( );
	}
	
	def dispatch org.fornax.soa.profiledsl.sOAProfileDsl.Type findLatestMatchingType (DataTypeRef t) {
		t.type;
	}
		
	
	
	/**
	 * 		Reference resolution
	 *		find the lastest type declaration matching
	 *  	- the version constraint defined in the reference
	 *		- the given minimal required LifecycleState
	 */
	def dispatch Type findLatestMatchingType (TypeRef t, LifecycleState minState) {
		null;
	}
	
	def dispatch Type findLatestMatchingType (VersionedTypeRef t, LifecycleState minState) { 
		t.type.findSubdomain ().types.
			filter (
				e|e.toTypeName() == t.type.toTypeName() && 
				t.type.version.versionMatches (t.versionRef) && 
				t.type.state.matchesMinStateLevel(minState)
			)
			.filter (typeof (VersionedType))
			.sortBy (e|e.version.version).last( );
	}
	
	def dispatch Type findLatestMatchingType (BusinessObjectRef t, LifecycleState minState) { 
		t.type.findSubdomain ().types.
			filter (
				e|e.toTypeName() == t.type.toTypeName() && 
				t.type.version.versionMatches (t.versionRef) && 
				t.type.state.matchesMinStateLevel(minState)
			)
			.filter (typeof (BusinessObject))
			.sortBy (e|e.version.version).last( );
	}
	
	def dispatch Type findLatestMatchingType (EnumTypeRef t, LifecycleState minState) { 
		t.type.findSubdomain ().types.
			filter (
				e|e.toTypeName() == t.type.toTypeName() && 
				t.type.version.versionMatches (t.versionRef) && 
				t.type.state.matchesMinStateLevel(minState)
			)
			.filter (typeof (Enumeration))
			.sortBy (e|e.version.version).last( );
	}



	def dispatch String toTypeName (Type t) {
		"";
	}
	def dispatch String toTypeName (VersionedType t) {
		t.name;
	}
	def dispatch String toTypeName (AbstractType t) {
		t.name;
	}	
	
	def dispatch String toTypeName (org.fornax.soa.serviceDsl.Exception e) {
		if (e.name.endsWith("Exception")) {
			e.name.replaceAll("Exception", "Fault")
		} else if (e.name.endsWith("Fault")) {
				e.name
		} else {
				e.name + "Fault"
		}
	}
}