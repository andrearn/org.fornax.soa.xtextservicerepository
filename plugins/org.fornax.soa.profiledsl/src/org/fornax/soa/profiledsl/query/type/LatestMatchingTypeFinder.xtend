package org.fornax.soa.profiledsl.query.type

import com.google.inject.Inject
import java.util.List
import org.fornax.soa.basedsl.version.VersionMatcher
import org.fornax.soa.basedsl.sOABaseDsl.AbstractType
import org.fornax.soa.profiledsl.query.namespace.TechnicalNamespaceQueries
import org.fornax.soa.profiledsl.sOAProfileDsl.AttributeDataTypeRef
import org.fornax.soa.profiledsl.sOAProfileDsl.DataTypeRef
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace
import org.fornax.soa.profiledsl.sOAProfileDsl.Type
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedTypeRef
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher

class LatestMatchingTypeFinder {
		
	@Inject extension VersionMatcher
	@Inject extension IStateMatcher
	@Inject extension TechnicalNamespaceQueries
		
	
	
	def dispatch org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType selectLatestMatchingType (VersionedTypeRef ref) {
		ref.type;
	}

	/*
	 *		Checks if type declaration is the latest version matching the following constraint
	 *		- same major version
	 */
	def dispatch boolean isLatestMatchingType (VersionedType t, Integer majorVersion) { 
		(findLatestMatchingVersionedTypeFromProfile ( 
			(t.eContainer as TechnicalNamespace).types.filter (typeof (VersionedType)).filter (e|e.name == t.name).toList, 
			majorVersion)
		 == t);
	}		

	/*
	 *		Checks if type declaration is the latest version matching the following constraint
	 *		- same major version
	 *      - matches a given minimal lifecycle state
	 */
	def private dispatch Type findLatestMatchingVersionedTypeFromProfile (List<VersionedType> types, Integer majorVersion) { 
		types.filter (
			e|e.version.versionMatches (majorVersion) 
		).sortBy(e|e.version.version).last();
	}

	
	/**
	 * 		Type reference resolution
	 *		find the lastest type declaration matching
	 *  	- the version constraint defined in the reference
	 */
	def dispatch org.fornax.soa.profiledsl.sOAProfileDsl.Type findLatestMatchingType (org.fornax.soa.profiledsl.sOAProfileDsl.DataTypeRef t) {
		t.type ;
	}
	
	def dispatch org.fornax.soa.profiledsl.sOAProfileDsl.Type findLatestMatchingType (org.fornax.soa.profiledsl.sOAProfileDsl.AttributeDataTypeRef t) {
		t.type ;
	}
	
	
		
	def dispatch org.fornax.soa.profiledsl.sOAProfileDsl.Type findLatestMatchingType (org.fornax.soa.profiledsl.sOAProfileDsl.DataTypeRef t, LifecycleState minState) { 
		t.type ;
	}

	def dispatch String toTypeName (AbstractType t) {
		t.name;
	}	
	
}