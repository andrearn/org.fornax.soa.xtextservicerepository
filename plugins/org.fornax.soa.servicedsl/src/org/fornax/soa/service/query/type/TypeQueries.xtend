package org.fornax.soa.service.query.type

import com.google.inject.Inject
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.resource.IEObjectDescription
import org.fornax.soa.basedsl.search.IEObjectLookup
import org.fornax.soa.profiledsl.sOAProfileDsl.DataType
import org.fornax.soa.serviceDsl.DataObject
import org.fornax.soa.serviceDsl.Enumeration
import org.fornax.soa.serviceDsl.Operation
import org.fornax.soa.serviceDsl.Parameter
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.VersionedType
import org.fornax.soa.basedsl.ref.DependencyDescription
import java.util.List

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
	
	def List getStatesOfClosestReferrers (VersionedType type) {
		
	}
	
	def List<DependencyDescription> getReferrersAsGraph (VersionedType type) {
	}
}