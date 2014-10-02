package org.xkonnex.repo.dsl.profiledsl.query.type

import com.google.inject.Inject
import java.util.HashSet
import java.util.List
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Class
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Property
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.TypeRef
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Type
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.VersionedType
import java.util.ArrayList
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.MessageHeader
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.VersionedTypeRef

class ReferencedTypesFinder {
	
	@Inject extension LatestMatchingTypeFinder
	
	def dispatch List<VersionedType> allReferencedVersionedTypes (Type t, LifecycleState minState) {newArrayList()}
	
	def dispatch List<org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.VersionedType>  allReferencedVersionedTypes (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Class t) { 
		t.allReferencedTypeRefs().filter (typeof (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.VersionedTypeRef)).map (e|e.selectLatestMatchingType () as org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.VersionedType).toList;
	}	

	def dispatch List<TypeRef> allReferencedTypeRefs (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Class t) {
		var refs = new HashSet<org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.TypeRef>(); 	
		if (t.superClass != null) {
			refs.addAll (t.properties.filter (typeof (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Property)).map (e|e.type));
			refs.add (t.superClass as org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.TypeRef);
		} else {
			refs.addAll (t.properties.filter (typeof (org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.Property)).map (e|e.type));
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