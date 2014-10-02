package org.xkonnex.repo.dsl.servicedsl.service.query.type

import java.util.List
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.TypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Type
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.BusinessObject
import java.util.ArrayList
import java.util.HashSet
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Parameter
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.AbstractVersionedTypeRef
import com.google.inject.Inject
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.LifecycleState
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObject
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.ILifecycleStateResolver
import org.xkonnex.repo.dsl.servicedsl.service.versioning.IVersionedTypeRefResolver

/*
 * Find type references of a model object
 */
class ReferencedTypesFinder {
	
	@Inject extension IVersionedTypeRefResolver
	
	
	def dispatch List<VersionedType> allReferencedVersionedTypes (Type t, LifecycleState minState) {newArrayList()}
	
	def dispatch List<VersionedType> allReferencedVersionedTypes (BusinessObject t, LifecycleState minState) { 
		t.allReferencedTypeRefs().filter (typeof (AbstractVersionedTypeRef)).map (e|e.selectMatchingTypeVersion () as VersionedType).toList;	
	}
	
	def dispatch List<VersionedType> allReferencedVersionedTypes (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception t, LifecycleState minState) { 
		t.allReferencedTypeRefs().filter (typeof (AbstractVersionedTypeRef)).map (e|e.selectMatchingTypeVersion () as VersionedType).toList;
	}
	
	def dispatch List<VersionedType> allReferencedVersionedTypes (Parameter p, LifecycleState minState) { 
		p.allReferencedTypeRefs().filter (typeof (AbstractVersionedTypeRef)).map (e|e.selectMatchingTypeVersion () as VersionedType).toList;
	}
	
	def dispatch List<VersionedType>  allReferencedVersionedTypes (Operation o, LifecycleState minState) {
		o.allReferencedTypeRefs().filter (typeof (AbstractVersionedTypeRef)).map (e|e.selectMatchingTypeVersion () as VersionedType).toList;
	}
	
	def dispatch List<VersionedType>  allReferencedVersionedTypes (Service s, LifecycleState minState) {
		s.allReferencedTypeRefs().filter (typeof (AbstractVersionedTypeRef)).map (e|e.selectMatchingTypeVersion () as VersionedType).toList;
	}
	
	
	
	def private dispatch List<TypeRef> allReferencedTypeRefs (Type t) {
		newArrayList();
	}
	
	def private dispatch List<TypeRef> allReferencedTypeRefs (DataObject t) { 
		var refs = new ArrayList<TypeRef>();
		if (t.superObject != null) {
			refs.add (t.superObject);
			refs.addAll(t.properties.map (p|p.type));
		} else {
			refs.addAll (t.properties.map (p|p.type));
		}
		return refs;
	}
		
	def private dispatch List<TypeRef> allReferencedTypeRefs (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception t) {
		t.properties.map (p|p.type);
	}
	
	def private dispatch List<TypeRef> allReferencedTypeRefs (Parameter p) {
		newArrayList(p.type);
	}
	
	def private dispatch List<TypeRef> allReferencedTypeRefs (Operation o) {
		var refs = new HashSet<TypeRef>();
		refs.addAll (o.parameters.map (p|p.allReferencedTypeRefs()).flatten.filter (typeof (TypeRef)));
		refs.addAll (o.^return.map (r|r.allReferencedTypeRefs()).flatten.filter (typeof (TypeRef)));
		refs.toList;
	}
	
	def private dispatch List<TypeRef> allReferencedTypeRefs (Service s) {
		s.operations.map(o|o.allReferencedTypeRefs()).flatten.map (e|e as TypeRef).toList;
	}
	

	
}