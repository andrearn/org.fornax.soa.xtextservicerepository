package org.xkonnex.repo.dsl.servicedsl.service.query.type

import com.google.inject.Inject
import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IEObjectDescription
import org.xkonnex.repo.dsl.basedsl.ref.DependencyDescription
import org.xkonnex.repo.dsl.basedsl.util.TreeNode
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Property
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType

class DataObjectQueries {
	@Inject
	private DataObjectQueryInternal doQueryInt
	
	
	def dispatch List<DataObject> getAllSuperTypes (DataObject bo, List<DataObject> vistitedBOs) {
		DataObjectQueryInternal::getAllSuperTypes(bo, vistitedBOs)
	}
	
	def List<TreeNode<IEObjectDescription>> getAllSubTypes (DataObject bo, ResourceSet resourceSet) {
		doQueryInt.getAllSubTypes (bo, resourceSet)
	}
	
	/**
	 * Get the root business object of the type hierarchy of the given BO
	 */
	def DataObject getRootDataObject (DataObject bo) {
		doQueryInt.getRootDataObject(bo) as DataObject
	}

	/**
	 * all own and inherited properties visible on the type
	 * @param bo The DataObject
	 * @return all own and inherited properties visible on the type
	 */
	def List<Property> getAllVisibleProperties (DataObject bo) {
		DataObjectQueryInternal::getAllVisibleProperties(bo)
	}
	
	/**
	 * all inherited properties visible on the type (own properties are excluded)
	 * @param bo The DataObject
	 * @return all own and inherited properties visible on the type
	 */
	def List<Property> getAllInheritedProperties (DataObject bo) {
		DataObjectQueryInternal::getAllInheritedProperties(bo)
	}
	
	def dispatch List<Property> getVisibleObjectProperties (Object bo, LifecycleState minState) {newArrayList()}

	def dispatch List<Property> getVisibleObjectProperties (DataObject bo, LifecycleState minState) {
		bo.collectVisibleObjectProperties (minState, newArrayList());
	}
		
	def List<Property> collectVisibleObjectProperties (DataObject bo, LifecycleState minState, List<Property> props) {
		props.addAll (bo.properties);
		props.addAll(bo.getAllInheritedProperties(minState));
		props;
	}
		
	def List<Property> getAllInheritedProperties (DataObject bo, LifecycleState minState) {
		bo.getAllSuperTypes (minState).map (e|e.properties).flatten.toList;
	}
		
	def dispatch List<DataObject> getAllSuperTypes (DataObject bo, LifecycleState minState) {
		bo.collectAllSuperTypes (newArrayList(), minState);
	}
	
	def private List<DataObject> collectAllSuperTypes (DataObject bo, List<DataObject> superTypes, LifecycleState minState) {
		return doQueryInt.collectAllSuperTypes(bo, superTypes, minState);
	}
	
	
	/**
	 * Find all transitive dependencies of the Property. The dependency graph is build from all properties transitively 
	 * referenced via the properties' type references if these have properties themselves, i.e. they are BusinessOobjects
	 *  
	 * @param prop Property from which to start the traversal of the dependency graph
	 * @param includeInheritedProperties traverse dependencies via inherited properties as well
	 * @param includeCycleTypes include the BO in the result even if it already was visited. 
	 * 		However traversal of this path stops here
	 * @param referrer The DependencyDescription that refers to the DependencyDescriptions to be created
	 * @return {@link DependencyDescription} keyed with the {@link IEObjectDescription} of the referring property 
	 */
	def DependencyDescription getTransitiveDependencies (Property prop, boolean includeInheritedProperties, boolean includeCycleTypes, List<IEObjectDescription> visitedDependendies, DependencyDescription referrer) {
		doQueryInt.getTransitiveDependencies (prop, includeInheritedProperties, includeCycleTypes, visitedDependendies, referrer)
	}
	
	/**
	 * Get all {@link EObject}s that have a transitive reference to the given {@code type}. Traversal of the reference graph stops, when the referrer
	 * is not a {@link DataObject}. References are being determined recursively. 
	 * 
	 * @param type The type to find transitive references to
	 * @param includeSuperTypes Look for references to super types as well?
	 * @param visited	Contains all trasititively found references so far.
	 * @param resourceSet	The {@link ResourceSet} used to materialize found references from.
	 * @return
	 */
	def List<IEObjectDescription> getAllTransitiveReferrers (EObject type, boolean includeSuperTypes, List<IEObjectDescription> visited, ResourceSet resourceSet) {
		doQueryInt.getAllTransitiveReferrers(type, includeSuperTypes, visited, resourceSet)
	}
	
	
	/**
	 * Get the {@link QualifiedName}s of all Properties of all types  declared in the same {@link SubNamespace} as
	 * the given {@code type}, that refer transitively to types in the given {@link SubNamespace} {@code ns}.
	 * 
	 * @param type The type who's namespace and all properties declared therein are to be examined
	 * @param ns The target namespace potentially being referenced
	 * @return The {@link QualifiedName}s of all properties that have such transitive references
	 */
	def List<QualifiedName> getOtherTypeNsRefsToNs (VersionedType type, SubNamespace ns) {
		doQueryInt.getOtherTypeNsRefsToNs(type, ns)
	}
	
	def	Map<EObject, VersionedType> getReferencedVersionedTypes (DataObject bo, boolean includeInheritedProperties) {
		doQueryInt.getReferencedVersionedTypes (bo, includeInheritedProperties)
	}

	def VersionedType toVersionedType (IEObjectDescription desc, Resource res) {
		doQueryInt.toVersionedType(desc, res)
	}
	
	def TreeNode<IEObjectDescription> getAllSubTypesWithParent (TreeNode<IEObjectDescription> parent, ResourceSet resourceSet) {
		doQueryInt.getAllSubTypesWithParent(parent, resourceSet)
	}
	
	def Iterable<IEObjectDescription> findUnapprovedDataObjects (ResourceSet res) {
		doQueryInt.findUnapprovedDataObjects(res)
	}
	
}