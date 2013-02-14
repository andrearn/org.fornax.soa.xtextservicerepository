package org.fornax.soa.service.query.type

import java.util.List
import org.fornax.soa.serviceDsl.QueryObject
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.emf.ecore.resource.ResourceSet
import org.fornax.soa.basedsl.ref.DependencyDescription
import org.eclipse.xtext.naming.QualifiedName
import org.fornax.soa.serviceDsl.VersionedType
import org.fornax.soa.serviceDsl.SubNamespace
import java.util.Map
import org.eclipse.emf.ecore.EObject
import com.google.inject.Inject
import org.fornax.soa.service.query.type.QueryObjectQueryInternal
import org.fornax.soa.basedsl.util.TreeNode

class QueryObjectQueries {
	
	@Inject
	private QueryObjectQueryInternal qoQueryInt
	
	def List<QueryObject> getAllSuperTypes (QueryObject qo, List<QueryObject> vistitedQOs) {
		QueryObjectQueryInternal::getAllSuperTypes (qo, vistitedQOs)
	}
	
	def QueryObject getRootBusinessObject (QueryObject qo) {
		qoQueryInt.getRootBusinessObject (qo)
	}
	
	def List<org.fornax.soa.serviceDsl.Property> getAllVisibleProperties (QueryObject qo) {
		QueryObjectQueryInternal::getAllVisibleProperties(qo)
	}
	
	def List<org.fornax.soa.serviceDsl.Property> getAllInheritedProperties (QueryObject qo) {
		QueryObjectQueryInternal::getAllInheritedProperties (qo)
	}
	
	def Iterable<IEObjectDescription> findUnapprovedQueryObjects (ResourceSet res) {
		qoQueryInt.findUnapprovedQueryObjects(res)
	}
	
	def DependencyDescription getTransitiveDependencies (org.fornax.soa.serviceDsl.Property prop, boolean includeInheritedProperties, boolean includeCycleTypes, List<IEObjectDescription> visitedDependendies, DependencyDescription referrer) {
		qoQueryInt.getTransitiveDependencies(prop, includeInheritedProperties, includeCycleTypes, visitedDependendies, referrer)
	}
	
	def List<QualifiedName> getOtherTypeNsRefsToNs (VersionedType type, SubNamespace ns) {
		qoQueryInt.getOtherTypeNsRefsToNs(type, ns)
	}

	def Map<EObject, VersionedType> getReferencedVersionedTypes (QueryObject qo, boolean includeInheritedProperties) {
		qoQueryInt.getReferencedVersionedTypes(qo, includeInheritedProperties)
	}
	
	def List<TreeNode<IEObjectDescription>> getAllSubTypes (QueryObject qo, ResourceSet resourceSet) {
		qoQueryInt.getAllSubTypes(qo, resourceSet)
	}
	
	def TreeNode<IEObjectDescription> getAllSubTypesWithParent (TreeNode<IEObjectDescription> parent, ResourceSet resourceSet) {
		qoQueryInt.getAllSubTypesWithParent(parent, resourceSet)
	}
		
	
	
}