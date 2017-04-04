package org.xkonnex.repo.dsl.profiledsl.query.type

import com.google.inject.Inject
import java.util.ArrayList
import java.util.HashSet
import java.util.List
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Class
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.profileDsl.MessageHeader
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Property
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Type
import org.xkonnex.repo.dsl.profiledsl.profileDsl.TypeRef
import org.xkonnex.repo.dsl.profiledsl.profileDsl.VersionedType
import org.xkonnex.repo.dsl.profiledsl.profileDsl.VersionedTypeRef

class ReferencedTypesFinder {
	
	@Inject extension LatestMatchingTypeFinder
	
	def List<VersionedType> allReferencedVersionedTypes (Type t, LifecycleState minState) {newArrayList()}
	
	def dispatch List<VersionedType>  allReferencedVersionedTypes (Class t) { 
		t.allReferencedTypeRefs().filter (typeof (VersionedTypeRef)).map (e|e.selectLatestMatchingType () as VersionedType).toList;
	}	

	def dispatch List<TypeRef> allReferencedTypeRefs (Class t) {
		var refs = new HashSet<TypeRef>(); 	
		if (t.superClass !== null) {
			refs.addAll (t.properties.filter (typeof (Property)).map (e|e.type));
			refs.add (t.superClass as TypeRef);
		} else {
			refs.addAll (t.properties.filter (typeof (Property)).map (e|e.type));
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