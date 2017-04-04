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
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObject
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.ILifecycleStateResolver
import org.xkonnex.repo.dsl.servicedsl.service.versioning.IVersionedTypeRefResolver
import java.util.LinkedList
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.EcoreUtil2
import java.util.Set
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource

/*
 * Find type references of a model object
 */
class ReferencedTypesFinder {
	
	@Inject extension IVersionedTypeRefResolver
	@Inject extension DataObjectQueries
	@Inject extension TypeQueries
	
	
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
		if (t.superObject !== null) {
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
	
	
	def Set<Type> allTransitiveReferencedVersionedTypes(DataObject object, boolean includeInheritedProperties, boolean includeSuperTypes) {
		val resSet = object.eResource.resourceSet
		val Set<Type> allReferencedTypes = newHashSet()
		val deps = object.properties.map(p| p.getTransitiveDependencies(includeInheritedProperties, false, new LinkedList<IEObjectDescription>(), null))
		val types = deps.flatten.map(d | {
			var eObj = d.target.EObjectOrProxy
			if (eObj.eIsProxy) {
				eObj = EcoreUtil2.resolve(eObj, resSet)
			}
			eObj
		}).filter(typeof (Type))
		allReferencedTypes.addAll(types)
		if (includeSuperTypes) {
			for (aType : types) {
				if (aType instanceof DataObject) {
					val dataObj = aType as DataObject
					allReferencedTypes.addAll(dataObj.getAllSuperTypes(dataObj.state))
				}
			}
		}
		allReferencedTypes
	}
	
	def Set<VersionedType> allTransitiveReferencedVersionedTypes(DataObject object, boolean includeInheritedProperties, boolean includeSuperTypes, LifecycleState minState) {
		val resSet = object.eResource.resourceSet
		val Set<VersionedType> allReferencedTypes = newHashSet()
		val Set<VersionedType> types = newHashSet()
		for (p : object.properties) { 
			val transDeps =  p.getTransitiveDependencies(includeInheritedProperties, false, null, null)
			if (transDeps !== null) {
				types.addAll(transDeps.flatten.map [
					var eObj = target.EObjectOrProxy
					if (eObj.eIsProxy) {
						eObj = EcoreUtil2.resolve(eObj, resSet)
					}
					eObj
				].filter(typeof (VersionedType)))
			}
		}
		allReferencedTypes.addAll(types)
		if (includeSuperTypes) {
			for (aType : types) {
				if (aType instanceof DataObject) {
					val dataObj = aType as DataObject
					allReferencedTypes.addAll(dataObj.getAllSuperTypes(minState).filterNull)
				}
			}
		}
		allReferencedTypes
	}

	def getAllReferencedVersionedTypes(Service service, LifecycleState state) {
		val typeRefs = service.operations.map(op|op.parameters).flatten.map(p|p.type).toList
		val respTypeRefs = service.operations.map(op|op.^return).flatten.map(p|p.type)
		typeRefs.addAll(respTypeRefs)
		val verTypes = typeRefs.filter(typeof(AbstractVersionedTypeRef)).map[toVersionedType]
		val allRefTypes = verTypes.filter(typeof(DataObject)).map[t | allTransitiveReferencedVersionedTypes(t, true, true, state)].filterNull.flatten.filter(typeof(VersionedType))
		val Set<VersionedType> allVerTypes = newHashSet()
		allVerTypes.addAll(verTypes)
		for (aType : verTypes) {
			if (aType instanceof DataObject) {
				val dataObj = aType as DataObject
				allVerTypes.addAll(dataObj.getAllSuperTypes(state))
			}
		}
		if (allRefTypes !== null)
			allVerTypes.addAll(allRefTypes)
		allVerTypes
	}

	def getAllReferencedVersionedTypes(Resource resource, LifecycleState state) {
		val typeRefs = resource.operations.map(op|op.parameters).flatten.map(p|p.type).toList
		val respTypeRefs = resource.operations.map(op|op.^return).flatten.map(p|p.type)
		typeRefs.addAll(respTypeRefs)
		val verTypes = typeRefs.filter(typeof(AbstractVersionedTypeRef)).map[toVersionedType]
		val allRefTypes = verTypes.filter(typeof(DataObject)).map(t | allTransitiveReferencedVersionedTypes(t, true, true, state)).filterNull.flatten.filter(typeof(VersionedType))
		val Set<VersionedType> allVerTypes = newHashSet()
		allVerTypes.addAll(verTypes)
		for (aType : verTypes) {
			if (aType instanceof DataObject) {
				val dataObj = aType as DataObject
				allVerTypes.addAll(dataObj.getAllSuperTypes(state))
			}
		}
		if (allRefTypes !== null)
			allVerTypes.addAll(allRefTypes)
		allVerTypes
	}
	
	def getAllReferencedVersionedTypes(Operation op, LifecycleState state) {
		val typeRefs = op.parameters.map(p|p.type).toList
		val respTypeRefs = op.^return.map(p|p.type)
		typeRefs.addAll(respTypeRefs)
		val verTypes = typeRefs.filter(typeof(AbstractVersionedTypeRef)).map[toVersionedType]
		val allRefTypes = verTypes.filter(typeof(DataObject)).map(t | allTransitiveReferencedVersionedTypes(t, true, true, state)).flatten.filter(typeof(VersionedType))
		val Set<VersionedType> allVerTypes = newHashSet()
		allVerTypes.addAll(verTypes)
		for (aType : verTypes) {
			if (aType instanceof DataObject) {
				val dataObj = aType as DataObject
				allVerTypes.addAll(dataObj.getAllSuperTypes(state))
			}
		}
		allVerTypes.addAll(allRefTypes)
		allVerTypes
	}

	
}