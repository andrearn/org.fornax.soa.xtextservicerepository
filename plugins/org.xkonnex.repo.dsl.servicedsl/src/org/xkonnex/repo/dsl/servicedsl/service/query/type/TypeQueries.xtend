package org.xkonnex.repo.dsl.servicedsl.service.query.type

import com.google.inject.Inject
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.resource.IEObjectDescription
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup
import org.xkonnex.repo.dsl.profiledsl.profileDsl.DataType
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Enumeration
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Parameter
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType
import org.xkonnex.repo.dsl.basedsl.ref.DependencyDescription
import java.util.List
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.AbstractVersionedTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObjectRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.EnumTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataTypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.TypeRef

class TypeQueries {
	
	@Inject DataObjectQueries dataObjQueries
	@Inject extension IEObjectLookup objLookup
	@Inject TypeQueriesInternal tqInt
	
	def dispatch Set<Operation> findUsingServiceOperations (DataType type) {
		val List<EObject> typeRefs = tqInt.findReferrers(type)
		val paramTypeRefs = typeRefs.filter (typeof (Parameter)).toSet
		val verTypeRefs = typeRefs.filter (typeof(DataObject))
		var Set<Operation> ops =newHashSet()
		ops = verTypeRefs.map (o|o.findUsingServiceOperations).flatten.toSet
		ops.addAll (paramTypeRefs.map (p|p.getOwnerByType(typeof(Operation))).toSet)
		return ops
	}
	
	def dispatch Set<Operation> findUsingServiceOperations (DataObject obj) {
		var List<IEObjectDescription> visited = newArrayList()
		val List<IEObjectDescription> referrers = dataObjQueries.getAllTransitiveReferrers(obj, true, visited, obj.eResource.resourceSet)
		referrers.filter (typeof (Parameter)) .map (p|p.getOwnerByType(typeof(Operation))).toSet
	}
	
	def dispatch Set<Operation> findUsingServiceOperations (Enumeration enumeration) {
		val List<EObject> typeRefs = tqInt.findReferrers(enumeration)
		val paramTypeRefs = typeRefs.filter (typeof (Parameter)).toSet
		val verTypeRefs = typeRefs.filter (typeof(DataObject))
		var Set<Operation> ops =newHashSet()
		ops = verTypeRefs.map (o|o.findUsingServiceOperations).flatten.toSet
		ops.addAll (paramTypeRefs.map (p|p.getOwnerByType(typeof(Operation))).toSet)
		return ops
	}
	
	def dispatch Set<Service> findUsingServices (DataType type) {
		findUsingServiceOperations(type).map (o|o.getOwnerByType(typeof(Service))).toSet
	}
	
	def dispatch Set<Service> findUsingServices (DataObject obj) {
		findUsingServiceOperations(obj).map (o|o.getOwnerByType(typeof(Service))).toSet
	}
	
	def dispatch Set<Service> findUsingServices (Enumeration enumeration) {
		findUsingServiceOperations(enumeration).map (o|o.getOwnerByType(typeof(Service))).toSet
	}
	
	def dispatch Set<Resource> findUsingResources (DataType type) {
		findUsingServiceOperations(type).map (o|o.getOwnerByType(typeof(Resource))).toSet
	}
	
	def dispatch Set<Resource> findUsingResources (DataObject obj) {
		findUsingServiceOperations(obj).map (o|o.getOwnerByType(typeof(Resource))).toSet
	}
	
	def dispatch Set<Resource> findUsingResources (Enumeration enumeration) {
		findUsingServiceOperations(enumeration).map (o|o.getOwnerByType(typeof(Resource))).toSet
	}
	
	def List getStatesOfClosestReferrers (VersionedType type) {
		
	}
	
	def List<DependencyDescription> getReferrersAsGraph (VersionedType type) {
	}
	
	def dispatch toVersionedType(AbstractVersionedTypeRef typeRef) {
	}
	def dispatch toVersionedType(VersionedTypeRef typeRef) {
		typeRef.type
	}
	def dispatch toVersionedType(EnumTypeRef typeRef) {
		typeRef.type
	}
}