package org.fornax.soa.service.versioning

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.fornax.soa.basedsl.version.VersionMatcher
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.profiledsl.search.StateMatcher
import org.fornax.soa.service.query.namespace.NamespaceQuery
import org.fornax.soa.serviceDsl.AbstractVersionedTypeRef
import org.fornax.soa.serviceDsl.BusinessObject
import org.fornax.soa.serviceDsl.EnumTypeRef
import org.fornax.soa.serviceDsl.Enumeration
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.serviceDsl.Type
import org.fornax.soa.serviceDsl.TypeRef
import org.fornax.soa.serviceDsl.VersionedType
import org.fornax.soa.serviceDsl.VersionedTypeRef
import org.fornax.soa.serviceDsl.DataObjectRef
import org.fornax.soa.serviceDsl.DataObject

class LatestMinorVersionTypeResolver implements ITypeResolver {
	
	@Inject extension VersionMatcher
	@Inject extension StateMatcher
	@Inject extension NamespaceQuery
	@Inject extension IQualifiedNameProvider
	
	override selectMatchingType(AbstractVersionedTypeRef ref) {
		selectMatchingType(ref)
	}
	
	def dispatch VersionedType selectMatchingTypeImpl (AbstractVersionedTypeRef ref) {}
	
	def dispatch VersionedType selectMatchingTypeImpl (VersionedTypeRef ref) {
		ref.type;
	}
	
	def dispatch VersionedType selectMatchingTypeImpl (DataObjectRef ref) {
		ref.type;
	}
	
	def dispatch VersionedType selectMatchingTypeImpl (EnumTypeRef ref) {
		ref.type;
	}
	
	override selectMatchingTypeByState(AbstractVersionedTypeRef ref, LifecycleState minState) {
		selectMatchingTypeByState(ref, minState)
	}
	
	def dispatch VersionedType selectMatchingTypeByStateImpl (AbstractVersionedTypeRef ref, LifecycleState minState) {}
	
	def dispatch VersionedType selectMatchingTypeByStateImpl (VersionedTypeRef ref, LifecycleState minState) {
		ref.type.findSubdomain().types.filter (typeof (VersionedType)).filter (e| e.state.matchesMinStateLevel(minState))
		.filter (t|t.name == ref.type.name && t.version.versionMatches (ref.versionRef))
		.sortBy(e|e.version.version).last();
	}
		
	def dispatch VersionedType selectMatchingTypeByStateImpl (DataObjectRef ref, LifecycleState minState) {
		ref.type.findSubdomain().types.filter (typeof (VersionedType)).filter (e| e.state.matchesMinStateLevel(minState))
		.filter (t|t.name == ref.type.name && t.version.versionMatches (ref.versionRef))
		.sortBy(e|e.version.version).last();
	}
		
	def dispatch VersionedType selectMatchingTypeByStateImpl (EnumTypeRef ref, LifecycleState minState) {
		ref.type.findSubdomain().types.filter (typeof (VersionedType)).filter(e| e.state.matchesMinStateLevel(minState))
		.filter (t|t.name == ref.type.name && t.version.versionMatches (ref.versionRef))
		.sortBy(e|e.version.version).last();
	}
	
		
		
	/*
	 *	Checks if type declaration is the latest version matching the following constraint. The function
	 *	should never be called as Type is not versioned and considered abstract
	 */
	def dispatch boolean isMatchingType (Type t, Integer majorVersion, LifecycleState minState) { 
		false;
	}
	
	/*
	 *		Checks if type declaration is the latest version matching the following constraint
	 *		- same major version
	 */
	override boolean isMatchingType (VersionedType t, Integer majorVersion) { 
		(findMatchingVersionedType ( 
			(t.eContainer as SubNamespace).types.filter (typeof (VersionedType)).filter (e|e.name == t.name).toList, 
			majorVersion)
		 == t);
	}		 

	/*
	 *		Checks if type declaration is the latest version matching the following constraint
	 *		- same major version
	 */
	override boolean isMatchingType (org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType t, Integer majorVersion) { 
		(findMatchingVersionedTypeFromProfile ( 
			(t.eContainer as SubNamespace).types.filter (typeof (org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType)).filter (e|e.name == t.name).toList, 
			majorVersion)
		 == t);
	}		

	/*
	 *		Checks if type declaration is the latest version matching the following constraint
	 *		- same major version
	 *      - matches a given minimal lifecycle state
	 */
	def dispatch boolean isMatchingType (VersionedType t, Integer majorVersion, LifecycleState minState) { 
		findMatchingVersionedType ( 
			(t.eContainer as SubNamespace).types.filter (typeof (VersionedType)).filter (e|e.name == t.name).toList, 
			majorVersion, 
			minState) == t;
	}

	
	/**
	 * 		Type reference resolution
	 *		find the latest type declaration matching
	 *  	- the version constraint defined in the reference
	 */
	def dispatch Type findMatchingType (EObject t) {
	}
	def dispatch Type findMatchingType (TypeRef t) {
	}
	
	def dispatch Type findMatchingType (VersionedTypeRef t) {
		t.type.findSubdomain ().types.
			filter (e|e.fullyQualifiedName == t.type.fullyQualifiedName && t.type.version.versionMatches (t.versionRef))
			.filter (typeof (VersionedType))
			.sortBy (e|e.version.version).last( );
	}
	
	def dispatch Type findMatchingType (DataObjectRef t) { 
		t.type.findSubdomain ().types.
			filter (e|e.fullyQualifiedName == t.type.fullyQualifiedName && t.type.version.versionMatches (t.versionRef))
			.filter (typeof (DataObject))
			.sortBy (e|e.version.version).last( );
	} 
	
	def dispatch Type findMatchingType (EnumTypeRef t) { 
		t.type.findSubdomain ().types.
			filter (
				e|e.fullyQualifiedName == t.type.fullyQualifiedName && 
				t.type.version.versionMatches (t.versionRef)
			)
			.filter (typeof (Enumeration))
			.sortBy (e|e.version.version).last( );
	}
	
//	override org.fornax.soa.profiledsl.sOAProfileDsl.Type findMatchingType (DataTypeRef t) {
//		t.type;
//	}
		
	
	
	/**
	 * 		Reference resolution
	 *		find the lastest type declaration matching
	 *  	- the version constraint defined in the reference
	 *		- the given minimal required LifecycleState
	 */
	def dispatch Type findMatchingTypeByState (VersionedTypeRef t, LifecycleState minState) { 
		t.type.findSubdomain ().types.
			filter (
				e|e.fullyQualifiedName == t.type.fullyQualifiedName && 
				t.type.version.versionMatches (t.versionRef) && 
				t.type.state.matchesMinStateLevel(minState)
			)
			.filter (typeof (VersionedType))
			.sortBy (e|e.version.version).last( );
	}
	
	def dispatch Type findMatchingTypeByState (DataObjectRef t, LifecycleState minState) { 
		t.type.findSubdomain ().types.
			filter (
				e|e.fullyQualifiedName == t.type.fullyQualifiedName && 
				t.type.version.versionMatches (t.versionRef) && 
				t.type.state.matchesMinStateLevel(minState)
			)
			.filter (typeof (DataObject))
			.sortBy (e|e.version.version).last( );
	}

	
	def dispatch Type findMatchingTypeByState (EnumTypeRef t, LifecycleState minState) { 
		t.type.findSubdomain ().types.
			filter (
				e|e.fullyQualifiedName == t.type.fullyQualifiedName && 
				t.type.version.versionMatches (t.versionRef) && 
				t.type.state.matchesMinStateLevel(minState)
			)
			.filter (typeof (Enumeration))
			.sortBy (e|e.version.version).last( );
	}
	
		
	def private Type findMatchingVersionedType (List<VersionedType> types, Integer majorVersion) { 
		types.filter (
			e|e.version.versionMatches (majorVersion) 
		).sortBy(e|e.version.version).last();
	}
	
	def private org.fornax.soa.profiledsl.sOAProfileDsl.Type findMatchingVersionedTypeFromProfile (List<org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType> types, Integer majorVersion) { 
		types.filter (
			e|e.version.versionMatches (majorVersion) 
		).sortBy(e|e.version.version).last();
	}
	
	def private Type findMatchingVersionedType (List<VersionedType> types, Integer majorVersion, LifecycleState minState) { 
		types.filter (
			e|e.version.versionMatches (majorVersion) && 
			e.state.matchesMinStateLevel (minState)
		).sortBy (e|e.version.version).last();
	}
	
}