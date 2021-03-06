package org.xkonnex.repo.dsl.servicedsl.service.query.type

import com.google.inject.Inject
import java.util.ArrayList
import java.util.HashSet
import java.util.LinkedList
import java.util.List
import java.util.Set
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.resource.IEObjectDescription
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.servicedsl.service.versioning.IVersionedTypeRefResolver
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.AbstractVersionedTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.BusinessObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Parameter
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Type
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.TypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.AbstractOperation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ResourceOperation

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
	
	def dispatch List<VersionedType> allReferencedVersionedTypes (Exception t, LifecycleState minState) { 
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
	
	def dispatch List<VersionedType>  allReferencedVersionedTypes (Resource s, LifecycleState minState) {
		s.allReferencedTypeRefs().filter (typeof (AbstractVersionedTypeRef)).map (e|e.selectMatchingTypeVersion () as VersionedType).toList;
	}
	

	def dispatch List<VersionedType> allReferencedVersionedTypes (Type t) {newArrayList()}
	
	def dispatch List<VersionedType> allReferencedVersionedTypes (BusinessObject t) { 
		t.allReferencedTypeRefs().filter (typeof (AbstractVersionedTypeRef)).map (e|e.selectMatchingTypeVersion () as VersionedType).toList;	
	}
	
	def dispatch List<VersionedType> allReferencedVersionedTypes (Exception t) { 
		t.allReferencedTypeRefs().filter (typeof (AbstractVersionedTypeRef)).map (e|e.selectMatchingTypeVersion () as VersionedType).toList;
	}
	
	def dispatch List<VersionedType> allReferencedVersionedTypes (Parameter p) { 
		p.allReferencedTypeRefs().filter (typeof (AbstractVersionedTypeRef)).map (e|e.selectMatchingTypeVersion () as VersionedType).toList;
	}
	
	def dispatch List<VersionedType>  allReferencedVersionedTypes (Operation o) {
		o.allReferencedTypeRefs().filter (typeof (AbstractVersionedTypeRef)).map (e|e.selectMatchingTypeVersion () as VersionedType).toList;
	}
	
	def dispatch List<VersionedType>  allReferencedVersionedTypes (Service s) {
		s.allReferencedTypeRefs().filter (typeof (AbstractVersionedTypeRef)).map (e|e.selectMatchingTypeVersion () as VersionedType).toList;
	}
	
	def dispatch List<VersionedType>  allReferencedVersionedTypes (Resource s) {
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
		
	def private dispatch List<TypeRef> allReferencedTypeRefs (Exception t) {
		t.properties.map (p|p.type);
	}
	
	def private dispatch List<TypeRef> allReferencedTypeRefs (Parameter p) {
		newArrayList(p.type);
	}
	
	def private dispatch List<TypeRef> allReferencedTypeRefs (AbstractOperation o) {
		return new ArrayList<TypeRef>();
	}
	
	def private dispatch List<TypeRef> allReferencedTypeRefs (Operation o) {
		var refs = new HashSet<TypeRef>();
		refs.addAll (o.parameters.map (p|p.allReferencedTypeRefs()).flatten.filter (typeof (TypeRef)));
		refs.addAll (o.^return.map (r|r.allReferencedTypeRefs()).flatten.filter (typeof (TypeRef)));
		refs.toList;
	}
	
	def private dispatch List<TypeRef> allReferencedTypeRefs (ResourceOperation o) {
		var refs = new HashSet<TypeRef>();
		refs.addAll (o.parameters.map (p|p.allReferencedTypeRefs()).flatten.filter (typeof (TypeRef)));
		refs.addAll (o.response.map[it.^return].flatten.map (r|r.allReferencedTypeRefs()).flatten.filter (typeof (TypeRef)));
		refs.toList;
	}
	
	def private dispatch List<TypeRef> allReferencedTypeRefs (Service s) {
		s.operations.map(o|o.allReferencedTypeRefs()).flatten.map (e|e as TypeRef).toList;
	}
	
	def private dispatch List<TypeRef> allReferencedTypeRefs (Resource s) {
		s.operations.map(o|o.allReferencedTypeRefs()).flatten.map (e|e as TypeRef).toList;
	}
	
	
	def Set<Type> allTransitiveReferencedVersionedTypes(DataObject object, boolean includeInheritedProperties, boolean includeSuperTypes) {
		val resSet = object.eResource.resourceSet
		val Set<Type> allReferencedTypes = newHashSet()
		val deps = object.properties.map(p| p.getTransitiveDependencies(includeInheritedProperties, false, new LinkedList<IEObjectDescription>(), null)).filterNull
		val types = deps.flatten.map(d | {
			var eObj = d.target.EObjectOrProxy
			if (eObj.eIsProxy) {
				eObj = EcoreUtil2.resolve(eObj, resSet)
			}
			eObj
		}).filterNull.filter(typeof (Type))
		allReferencedTypes.addAll(types)
		if (includeSuperTypes) {
			for (aType : types) {
				if (aType instanceof DataObject) {
					val dataObj = aType as DataObject
					if (dataObj.state !== null) {
						allReferencedTypes.addAll(dataObj.getAllSuperTypes(dataObj.state))
					} else {
						allReferencedTypes.addAll(dataObj.getAllSuperTypes())
					}
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
		val respTypeRefs = service.operations.map(op|op.^return).flatten.filterNull.map(p|p.type)
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
		val respTypeRefs = resource.operations.map(op|op.response).flatten.map(r|r.^return).flatten.map(p|p.type)
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



// FIXME	allTransitiveReferencedVersionedTypes
//	def Set<VersionedType> allTransitiveReferencedVersionedTypes(DataObject object, boolean includeInheritedProperties, boolean includeSuperTypes) {
//		val resSet = object.eResource.resourceSet
//		val Set<VersionedType> allReferencedTypes = newHashSet()
//		val Set<VersionedType> types = newHashSet()
//		for (p : object.properties) { 
//			val transDeps =  p.getTransitiveDependencies(includeInheritedProperties, false, null, null)
//			if (transDeps !== null) {
//				types.addAll(transDeps.flatten.map [
//					var eObj = target.EObjectOrProxy
//					if (eObj.eIsProxy) {
//						eObj = EcoreUtil2.resolve(eObj, resSet)
//					}
//					eObj
//				].filter(typeof (VersionedType)))
//			}
//		}
//		allReferencedTypes.addAll(types)
//		if (includeSuperTypes) {
//			for (aType : types) {
//				if (aType instanceof DataObject) {
//					val dataObj = aType as DataObject
//					allReferencedTypes.addAll(dataObj.getAllSuperTypes().filterNull)
//				}
//			}
//		}
//		allReferencedTypes
//	}

	def getAllReferencedVersionedTypes(Service service) {
		val typeRefs = service.operations.map(op|op.parameters).flatten.map(p|p.type).toList
		val respTypeRefs = service.operations.map(op|op.^return).flatten.map(p|p.type)
		typeRefs.addAll(respTypeRefs)
		val verTypes = typeRefs.filter(typeof(AbstractVersionedTypeRef)).map[toVersionedType]
		val allRefTypes = verTypes.filter(typeof(DataObject)).map[t | allTransitiveReferencedVersionedTypes(t, true, true)].filterNull.flatten.filter(typeof(VersionedType))
		val Set<VersionedType> allVerTypes = newHashSet()
		allVerTypes.addAll(verTypes)
		for (aType : verTypes) {
			if (aType instanceof DataObject) {
				val dataObj = aType as DataObject
				allVerTypes.addAll(dataObj.getAllSuperTypes())
			}
		}
		if (allRefTypes !== null)
			allVerTypes.addAll(allRefTypes)
		allVerTypes
	}

	def getAllReferencedVersionedTypes(Resource resource) {
		val typeRefs = resource.operations.map(op|op.parameters).flatten.map(p|p.type).toList
		val respTypeRefs = resource.operations.map(op|op.response).flatten.map(r|r.^return).flatten.map(p|p.type)
		typeRefs.addAll(respTypeRefs)
		val verTypes = typeRefs.filter(typeof(AbstractVersionedTypeRef)).map[toVersionedType]
		val allRefTypes = verTypes.filter(typeof(DataObject)).map(t | allTransitiveReferencedVersionedTypes(t, true, true)).filterNull.flatten.filter(typeof(VersionedType))
		val Set<VersionedType> allVerTypes = newHashSet()
		allVerTypes.addAll(verTypes)
		for (aType : verTypes) {
			if (aType instanceof DataObject) {
				val dataObj = aType as DataObject
				allVerTypes.addAll(dataObj.getAllSuperTypes())
			}
		}
		if (allRefTypes !== null)
			allVerTypes.addAll(allRefTypes)
		allVerTypes
	}
	
	def getAllReferencedVersionedTypes(Operation op) {
		val typeRefs = op.parameters.map(p|p.type).toList
		val respTypeRefs = op.^return.map(p|p.type)
		typeRefs.addAll(respTypeRefs)
		val verTypes = typeRefs.filter(typeof(AbstractVersionedTypeRef)).map[toVersionedType]
		val allRefTypes = verTypes.filter(typeof(DataObject)).map(t | allTransitiveReferencedVersionedTypes(t, true, true)).flatten.filter(typeof(VersionedType))
		val Set<VersionedType> allVerTypes = newHashSet()
		allVerTypes.addAll(verTypes)
		for (aType : verTypes) {
			if (aType instanceof DataObject) {
				val dataObj = aType as DataObject
				allVerTypes.addAll(dataObj.getAllSuperTypes())
			}
		}
		allVerTypes.addAll(allRefTypes)
		allVerTypes
	}
	
}