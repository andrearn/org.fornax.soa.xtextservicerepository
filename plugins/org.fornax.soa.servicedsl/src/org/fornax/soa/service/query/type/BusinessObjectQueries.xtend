package org.fornax.soa.service.query.type

import java.util.List
import org.fornax.soa.serviceDsl.Property
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.serviceDsl.BusinessObject
import java.util.ArrayList
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.emf.ecore.resource.ResourceSet
import org.fornax.soa.basedsl.ref.DependencyDescription
import com.google.inject.Inject
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.serviceDsl.VersionedType
import org.eclipse.xtext.naming.QualifiedName
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.fornax.soa.basedsl.util.TreeNode

class BusinessObjectQueries {
	
	@Inject
	private BusinessObjectQueryInternal boQueryInt
	
	def List<BusinessObject> getAllSuperTypes (BusinessObject bo, List<BusinessObject> vistitedBOs) {
		BusinessObjectQueryInternal::getAllSuperTypes(bo, vistitedBOs)
	}
	def BusinessObject getRootBusinessObject (BusinessObject bo) {
		boQueryInt.getRootBusinessObject (bo)
	}
	def List<Property> getAllVisibleProperties (BusinessObject bo) {
		BusinessObjectQueryInternal::getAllVisibleProperties(bo)
	}
	def List<Property> getAllInheritedProperties (BusinessObject bo) {
		BusinessObjectQueryInternal::getAllInheritedProperties(bo)
	}
	
	def dispatch List<Property> findAllVisibleProperties (Object bo, LifecycleState minState) {newArrayList()}

	def dispatch List<Property> findAllVisibleProperties (BusinessObject bo, LifecycleState minState) {
		bo.collectAllVisibleProperties (minState, newArrayList());
	}
		
	def dispatch List<Property> collectAllVisibleProperties (BusinessObject bo, LifecycleState minState, List<Property> props) {
		props.addAll (bo.properties);
		props.addAll(bo.findAllInheritedProperties(minState));
		props;
	}
		
	def dispatch List<Property> findAllInheritedProperties (BusinessObject bo, LifecycleState minState) {
		bo.findAllSuperTypes (minState).map (e|e.properties).flatten.toList;
	}
		
	def dispatch List<BusinessObject> findAllSuperTypes (BusinessObject bo, LifecycleState minState) {
		bo.collectAllSuperTypes (newArrayList(), minState);
	}
	
	def private List<BusinessObject> collectAllSuperTypes (BusinessObject bo, List<BusinessObject> superTypes, LifecycleState minState) {
		if (bo.superBusinessObject != null) {
			superTypes.add ( bo.superBusinessObject.type as BusinessObject);
			superTypes;
		} else {
			superTypes;
		}
	}
	
	def Iterable<IEObjectDescription> findUnapprovedBusinessObjects (ResourceSet res) {
		
	}
	
	/**
	 * Find all transitive dependencies of the Property. The dependency graph is build from all properties transitively 
	 * referenced via the properties' type references if these have properties themselves, i.e. they are BusinessOobjects 
	 * @param prop Property from which to start the traversal of the dependency graph
	 * @param includeInheritedProperties
	 * @param includeCycleTypes include the BO in the result even if it already was visited. 
	 * 		However traversal of this path stops here
	 * @return {@link DependencyDescription} keyed with the {@link IEObjectDesription} of the referring property 
	 */
	def DependencyDescription getTransitiveDependencies (Property prop, boolean includeInheritedProperties, boolean includeCycleTypes, List<IEObjectDescription> visitedDependendies, DependencyDescription referrer) {
		boQueryInt.getTransitiveDependencies (prop, includeInheritedProperties, includeCycleTypes, visitedDependendies, referrer)
	}
	
	def List<QualifiedName> getOtherTypeNsRefsToNs (VersionedType type, SubNamespace ns) {
		boQueryInt.getOtherTypeNsRefsToNs(type, ns)
	}
	
	def	Map<EObject, VersionedType> getReferencedVersionedTypes (BusinessObject bo, boolean includeInheritedProperties) {
		boQueryInt.getReferencedVersionedTypes (bo, includeInheritedProperties)
	}

	def VersionedType toVersionedType (IEObjectDescription desc, Resource res) {
		boQueryInt.toVersionedType(desc, res)
	}
	
	def List<TreeNode<IEObjectDescription>> getAllSubTypes (BusinessObject bo, ResourceSet resourceSet) {
		boQueryInt.getAllSubTypes (bo, resourceSet)
	}
	
	def TreeNode<IEObjectDescription> getAllSubTypesWithParent (TreeNode<IEObjectDescription> parent, ResourceSet resourceSet) {
		boQueryInt.getAllSubTypesWithParent(parent, resourceSet)
	}
	
}