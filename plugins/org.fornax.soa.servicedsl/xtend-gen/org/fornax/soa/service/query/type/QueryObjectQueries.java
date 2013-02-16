package org.fornax.soa.service.query.type;

import com.google.inject.Inject;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.ref.DependencyDescription;
import org.fornax.soa.basedsl.util.TreeNode;
import org.fornax.soa.service.query.type.QueryObjectQueryInternal;
import org.fornax.soa.serviceDsl.Property;
import org.fornax.soa.serviceDsl.QueryObject;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.VersionedType;

@SuppressWarnings("all")
public class QueryObjectQueries {
  @Inject
  private QueryObjectQueryInternal qoQueryInt;
  
  public List<QueryObject> getAllSuperTypes(final QueryObject qo, final List<QueryObject> vistitedQOs) {
    List<QueryObject> _allSuperTypes = QueryObjectQueryInternal.getAllSuperTypes(qo, vistitedQOs);
    return _allSuperTypes;
  }
  
  public QueryObject getRootBusinessObject(final QueryObject qo) {
    QueryObject _rootBusinessObject = this.qoQueryInt.getRootBusinessObject(qo);
    return _rootBusinessObject;
  }
  
  public List<Property> getAllVisibleProperties(final QueryObject qo) {
    List<Property> _allVisibleProperties = QueryObjectQueryInternal.getAllVisibleProperties(qo);
    return _allVisibleProperties;
  }
  
  public List<Property> getAllInheritedProperties(final QueryObject qo) {
    List<Property> _allInheritedProperties = QueryObjectQueryInternal.getAllInheritedProperties(qo);
    return _allInheritedProperties;
  }
  
  public Iterable<IEObjectDescription> findUnapprovedQueryObjects(final ResourceSet res) {
    Iterable<IEObjectDescription> _findUnapprovedQueryObjects = this.qoQueryInt.findUnapprovedQueryObjects(res);
    return _findUnapprovedQueryObjects;
  }
  
  public DependencyDescription getTransitiveDependencies(final Property prop, final boolean includeInheritedProperties, final boolean includeCycleTypes, final List<IEObjectDescription> visitedDependendies, final DependencyDescription referrer) {
    DependencyDescription _transitiveDependencies = this.qoQueryInt.getTransitiveDependencies(prop, includeInheritedProperties, includeCycleTypes, visitedDependendies, referrer);
    return _transitiveDependencies;
  }
  
  public List<QualifiedName> getOtherTypeNsRefsToNs(final VersionedType type, final SubNamespace ns) {
    List<QualifiedName> _otherTypeNsRefsToNs = this.qoQueryInt.getOtherTypeNsRefsToNs(type, ns);
    return _otherTypeNsRefsToNs;
  }
  
  public Map<EObject,VersionedType> getReferencedVersionedTypes(final QueryObject qo, final boolean includeInheritedProperties) {
    Map<EObject,VersionedType> _referencedVersionedTypes = this.qoQueryInt.getReferencedVersionedTypes(qo, includeInheritedProperties);
    return _referencedVersionedTypes;
  }
  
  public List<TreeNode<IEObjectDescription>> getAllSubTypes(final QueryObject qo, final ResourceSet resourceSet) {
    List<TreeNode<IEObjectDescription>> _allSubTypes = this.qoQueryInt.getAllSubTypes(qo, resourceSet);
    return _allSubTypes;
  }
  
  public TreeNode<IEObjectDescription> getAllSubTypesWithParent(final TreeNode<IEObjectDescription> parent, final ResourceSet resourceSet) {
    TreeNode<IEObjectDescription> _allSubTypesWithParent = this.qoQueryInt.getAllSubTypesWithParent(parent, resourceSet);
    return _allSubTypesWithParent;
  }
}
