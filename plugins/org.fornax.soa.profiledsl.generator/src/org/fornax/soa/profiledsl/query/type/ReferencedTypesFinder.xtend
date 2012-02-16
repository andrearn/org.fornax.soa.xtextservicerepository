package org.fornax.soa.profiledsl.query.type

import com.google.inject.Inject
import java.util.HashSet
import java.util.List
import org.fornax.soa.profiledsl.sOAProfileDsl.Class
import org.fornax.soa.profiledsl.sOAProfileDsl.Property
import org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef
import org.fornax.soa.profiledsl.sOAProfileDsl.Type
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType
import java.util.ArrayList

class ReferencedTypesFinder {
	
	@Inject extension LatestMatchingTypeFinder
	
	def dispatch List<VersionedType> allReferencedVersionedTypes (Type t, LifecycleState minState) {newArrayList()}
	
	def dispatch List<org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType>  allReferencedVersionedTypes (org.fornax.soa.profiledsl.sOAProfileDsl.Class t) { 
		t.allReferencedTypeRefs().filter (typeof (org.fornax.soa.profiledsl.sOAProfileDsl.VersionedTypeRef)).map (e|e.selectLatestMatchingType () as org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType).toList;
	}	

	def dispatch List<TypeRef> allReferencedTypeRefs (org.fornax.soa.profiledsl.sOAProfileDsl.Class t) {
		var refs = new HashSet<org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef>(); 	
		if (t.superClass != null) {
			refs.addAll (t.properties.filter (typeof (org.fornax.soa.profiledsl.sOAProfileDsl.Property)).map (e|e.type));
			refs.add (t.superClass as org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef);
		} else {
			refs.addAll (t.properties.filter (typeof (org.fornax.soa.profiledsl.sOAProfileDsl.Property)).map (e|e.type));
		}
		refs.toList;
	}
	
}