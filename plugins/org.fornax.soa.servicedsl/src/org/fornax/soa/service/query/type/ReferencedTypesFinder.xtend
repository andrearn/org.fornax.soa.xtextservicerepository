package org.fornax.soa.service.query.type

import java.util.List
import org.fornax.soa.serviceDsl.TypeRef
import org.fornax.soa.serviceDsl.Type
import org.fornax.soa.serviceDsl.BusinessObject
import java.util.ArrayList
import java.util.HashSet
import org.fornax.soa.serviceDsl.Parameter
import org.fornax.soa.serviceDsl.Operation
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.VersionedType
import org.fornax.soa.serviceDsl.AbstractVersionedTypeRef
import com.google.inject.Inject
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.serviceDsl.DataObject
import org.fornax.soa.profiledsl.scoping.versions.ILifecycleStateResolver
import org.fornax.soa.service.versioning.IVersionedTypeRefResolver

/*
 * Find type references of a model object
 */
class ReferencedTypesFinder {
	
	@Inject extension IVersionedTypeRefResolver
	
	
	def dispatch List<VersionedType> allReferencedVersionedTypes (Type t, LifecycleState minState) {newArrayList()}
	
	def dispatch List<VersionedType> allReferencedVersionedTypes (BusinessObject t, LifecycleState minState) { 
		t.allReferencedTypeRefs().filter (typeof (AbstractVersionedTypeRef)).map (e|e.selectMatchingTypeVersion () as VersionedType).toList;	
	}
	
	def dispatch List<VersionedType> allReferencedVersionedTypes (org.fornax.soa.serviceDsl.Exception t, LifecycleState minState) { 
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
		
	def private dispatch List<TypeRef> allReferencedTypeRefs (org.fornax.soa.serviceDsl.Exception t) {
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