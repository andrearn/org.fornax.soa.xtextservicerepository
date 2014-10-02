package org.xkonnex.repo.dsl.servicedsl.service.versioning

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.xkonnex.repo.dsl.basedsl.version.VersionMatcher
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.search.StateMatcher
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.AbstractVersionedTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObjectRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.EnumTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Type
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.TypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedTypeRef

class DefaultTypeResolver implements IVersionedTypeRefResolver {
	
	@Inject extension VersionMatcher
	@Inject extension StateMatcher
	@Inject extension NamespaceQuery
	@Inject extension IQualifiedNameProvider
	
	override selectMatchingTypeVersion(AbstractVersionedTypeRef ref) {
		selectMatchingTypeImpl(ref)
	}
	
	override selectMatchingTypeVersionByState(AbstractVersionedTypeRef ref, LifecycleState minState) {
		selectMatchingTypeByStateImpl(ref, minState)
	} 
	
	
	def dispatch VersionedType selectMatchingTypeImpl (EObject ref) { }
	
	def dispatch VersionedType selectMatchingTypeImpl (VersionedTypeRef ref) {
		ref.type as VersionedType;
	}
	
	def dispatch VersionedType selectMatchingTypeImpl (DataObjectRef ref) {
		ref.type;
	}
	
	def dispatch VersionedType selectMatchingTypeImpl (EnumTypeRef ref) {
		ref.type;
	}
	
	def dispatch VersionedType selectMatchingTypeByStateImpl (AbstractVersionedTypeRef ref, LifecycleState minState) {}
	
	def dispatch VersionedType selectMatchingTypeByStateImpl (VersionedTypeRef ref, LifecycleState minState) {
		ref.type
	}
		
	def dispatch VersionedType selectMatchingTypeByStateImpl (DataObjectRef ref, LifecycleState minState) {
		ref.type
	}
		
	def dispatch VersionedType selectMatchingTypeByStateImpl (EnumTypeRef ref, LifecycleState minState) {
		ref.type
	}
	
		
		
	/*
	 *	Checks if type declaration is the latest version matching the following constraint. The function
	 *	should never be called as Type is not versioned and considered abstract
	 */
	def dispatch boolean typeMatchesMajorVersion (Type t, Integer majorVersion, LifecycleState minState) { 
		false;
	}

	/*
	 *		Checks if type declaration is the latest version matching the following constraint
	 *		- same major version
	 *      - matches a given minimal lifecycle state
	 * 		- is the latest matching version in the types namespace
	 */
	def dispatch boolean typeMatchesMajorVersion (VersionedType t, Integer majorVersion, LifecycleState minState) { 
		findMatchingVersionedType ( 
			(t.eContainer as SubNamespace).types.filter (typeof (VersionedType)).filter (e|e.name == t.name).toList, 
			majorVersion, 
			minState) == t;
	}
	
	/*
	 *		Checks if type declaration is the latest version matching the following constraint
	 *		- same major version
	 * 		- is the latest matching version in the types namespace
	 */
	override boolean typeMatchesMajorVersion (VersionedType t, Integer majorVersion) { 
		(findMatchingVersionedType ( 
			(t.eContainer as SubNamespace).types.filter (typeof (VersionedType)).filter (e|e.name == t.name).toList, 
			majorVersion)
		 == t);
	}		

	/*
	 *		Checks if type declaration is the latest version matching the following constraint
	 *		- same major version
	 * 		- is the latest matching version in the types namespace
	 */
	override boolean typeMatchesMajorVersion (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.VersionedType t, Integer majorVersion) { 
		(findMatchingVersionedTypeFromProfile ( 
			(t.eContainer as SubNamespace).types.filter (typeof (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.VersionedType)).filter (e|e.name == t.name).toList, 
			majorVersion)
		 == t);
	}		

	
	/**
	 * 		Type reference resolution
	 *		find the latest type declaration matching
	 *  	- the version constraint defined in the reference
	 */
	def dispatch Type findMatchingTypeVersion (EObject t) {
	}
	def dispatch Type findMatchingTypeVersion (TypeRef t) {
	}
	
	def dispatch Type findMatchingTypeVersion (VersionedTypeRef t) {
		t.type
	}
	
	def dispatch Type findMatchingTypeVersion (DataObjectRef t) { 
		t.type
	}
	
	def dispatch Type findMatchingTypeVersion (EnumTypeRef t) { 
		t.type
	}
	
//	override org.xkonnex.repo.dsl.semanticsdsl.profiledsl.sOAProfileDsl.Type findMatchingType (DataTypeRef t) {
//		t.type;
//	}
		
	
	
	/**
	 * 		Reference resolution
	 *		find the lastest type declaration matching
	 *  	- the version constraint defined in the reference
	 *		- the given minimal required LifecycleState
	 */
	def private Type findMatchingVersionedType (List<VersionedType> types, Integer majorVersion) { 
		types.filter (
			e|e.version.versionMatches (majorVersion) 
		).sortBy(e|e.version.version).last();
	}
	
	def private org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Type findMatchingVersionedTypeFromProfile (List<org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.VersionedType> types, Integer majorVersion) { 
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