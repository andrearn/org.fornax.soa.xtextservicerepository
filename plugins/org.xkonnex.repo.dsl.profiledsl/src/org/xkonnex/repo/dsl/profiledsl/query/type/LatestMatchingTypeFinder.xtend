package org.xkonnex.repo.dsl.profiledsl.query.type

import com.google.inject.Inject
import java.util.List
import org.xkonnex.repo.dsl.basedsl.baseDsl.AbstractType
import org.xkonnex.repo.dsl.basedsl.version.VersionMatcher
import org.xkonnex.repo.dsl.profiledsl.profileDsl.AttributeDataTypeRef
import org.xkonnex.repo.dsl.profiledsl.profileDsl.DataTypeRef
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.profileDsl.TechnicalNamespace
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Type
import org.xkonnex.repo.dsl.profiledsl.profileDsl.VersionedType
import org.xkonnex.repo.dsl.profiledsl.profileDsl.VersionedTypeRef

class LatestMatchingTypeFinder {
		
	@Inject extension VersionMatcher
		
	
	
	def VersionedType selectLatestMatchingType (VersionedTypeRef ref) {
		ref.type;
	}

	/*
	 *		Checks if type declaration is the latest version matching the following constraint
	 *		- same major version
	 */
	def boolean isLatestMatchingType (VersionedType t, Integer majorVersion) { 
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
	def private Type findLatestMatchingVersionedTypeFromProfile (List<VersionedType> types, Integer majorVersion) { 
		types.filter (
			e|e.version.versionMatches (majorVersion) 
		).sortBy(e|e.version.version).last();
	}

	
	/**
	 * 		Type reference resolution
	 *		find the lastest type declaration matching
	 *  	- the version constraint defined in the reference
	 */
	def dispatch Type findLatestMatchingType (DataTypeRef t) {
		t.type ;
	}
	
	def dispatch Type findLatestMatchingType (AttributeDataTypeRef t) {
		t.type ;
	}
	
	
		
	def Type findLatestMatchingType (DataTypeRef t, LifecycleState minState) { 
		t.type ;
	}

	def String toTypeName (AbstractType t) {
		t.name;
	}	
	
}