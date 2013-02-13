package org.fornax.soa.profiledsl.query.type

import com.google.inject.Inject
import java.util.HashSet
import java.util.List
import org.fornax.soa.profiledsl.sOAProfileDsl.Class
import org.fornax.soa.profiledsl.sOAProfileDsl.Property
import org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef
import org.fornax.soa.profiledsl.sOAProfileDsl.Type
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType
import java.util.ArrayList
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedTypeRef

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
		
	def dispatch List<VersionedType> allReferencedVersionedTypes (MessageHeader t)  { 
		val types = t.parameters.map (p|p.type).filter (typeof (VersionedTypeRef)).map (v|v.type as Type);
		val transitiveTypeRefs = types.map (e|e.allReferencedTypeRefs ()).flatten.filter (typeof (VersionedTypeRef))
		transitiveTypeRefs.map (r|r.selectLatestMatchingType ()).filter (typeof (VersionedType)).toList;
	}	
	
	
	def dispatch List<TypeRef> allReferencedTypeRefs (Type t) {
		new ArrayList<TypeRef>();
	}
	def dispatch List<TypeRef> allReferencedTypeRefs (TypeRef t) {
		new ArrayList<TypeRef>();
	}
	
	def dispatch List<TypeRef> allReferencedTypeRefs (VersionedType t) {
		new ArrayList<TypeRef>();
	}
			
	def dispatch List<TypeRef> allReferencedTypeRefs (MessageHeader t) {
		t.parameters.map (p|p.type).toList;
	}
	
}