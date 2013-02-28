package org.fornax.soa.service.query.type;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.fornax.soa.basedsl.ref.DependencyDescription;
import org.fornax.soa.basedsl.util.TreeNode;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher;
import org.fornax.soa.service.query.type.BusinessObjectQueryInternal;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.BusinessObjectRef;
import org.fornax.soa.serviceDsl.Property;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.VersionedType;

@SuppressWarnings("all")
public class BusinessObjectQueries {
  @Inject
  private BusinessObjectQueryInternal boQueryInt;
  
  @Inject
  private IStateMatcher stateMatcher;
  
  protected List<BusinessObject> _getAllSuperTypes(final BusinessObject bo, final List<BusinessObject> vistitedBOs) {
    List<BusinessObject> _allSuperTypes = BusinessObjectQueryInternal.getAllSuperTypes(bo, vistitedBOs);
    return _allSuperTypes;
  }
  
  /**
   * Get the root business object of the type hierarchy of the given BO
   */
  public BusinessObject getRootBusinessObject(final BusinessObject bo) {
    BusinessObject _rootBusinessObject = this.boQueryInt.getRootBusinessObject(bo);
    return _rootBusinessObject;
  }
  
  /**
   * all own and inherited properties visible on the type
   * @param bo The BusinessObject
   * @return all own and inherited properties visible on the type
   */
  public List<Property> getAllVisibleProperties(final BusinessObject bo) {
    List<Property> _allVisibleProperties = BusinessObjectQueryInternal.getAllVisibleProperties(bo);
    return _allVisibleProperties;
  }
  
  /**
   * all inherited properties visible on the type (own properties are excluded)
   * @param bo The BusinessObject
   * @return all own and inherited properties visible on the type
   */
  public List<Property> getAllInheritedProperties(final BusinessObject bo) {
    List<Property> _allInheritedProperties = BusinessObjectQueryInternal.getAllInheritedProperties(bo);
    return _allInheritedProperties;
  }
  
  protected List<Property> _getVisibleObjectProperties(final Object bo, final LifecycleState minState) {
    ArrayList<Property> _newArrayList = CollectionLiterals.<Property>newArrayList();
    return _newArrayList;
  }
  
  protected List<Property> _getVisibleObjectProperties(final BusinessObject bo, final LifecycleState minState) {
    ArrayList<Property> _newArrayList = CollectionLiterals.<Property>newArrayList();
    List<Property> _collectVisibleObjectProperties = this.collectVisibleObjectProperties(bo, minState, _newArrayList);
    return _collectVisibleObjectProperties;
  }
  
  public List<Property> collectVisibleObjectProperties(final BusinessObject bo, final LifecycleState minState, final List<Property> props) {
    List<Property> _xblockexpression = null;
    {
      EList<Property> _properties = bo.getProperties();
      props.addAll(_properties);
      List<Property> _allInheritedProperties = this.getAllInheritedProperties(bo, minState);
      props.addAll(_allInheritedProperties);
      _xblockexpression = (props);
    }
    return _xblockexpression;
  }
  
  public List<Property> getAllInheritedProperties(final BusinessObject bo, final LifecycleState minState) {
    List<BusinessObject> _allSuperTypes = this.getAllSuperTypes(bo, minState);
    final Function1<BusinessObject,EList<Property>> _function = new Function1<BusinessObject,EList<Property>>() {
        public EList<Property> apply(final BusinessObject e) {
          EList<Property> _properties = e.getProperties();
          return _properties;
        }
      };
    List<EList<Property>> _map = ListExtensions.<BusinessObject, EList<Property>>map(_allSuperTypes, _function);
    Iterable<Property> _flatten = Iterables.<Property>concat(_map);
    List<Property> _list = IterableExtensions.<Property>toList(_flatten);
    return _list;
  }
  
  protected List<BusinessObject> _getAllSuperTypes(final BusinessObject bo, final LifecycleState minState) {
    ArrayList<BusinessObject> _newArrayList = CollectionLiterals.<BusinessObject>newArrayList();
    List<BusinessObject> _collectAllSuperTypes = this.collectAllSuperTypes(bo, _newArrayList, minState);
    return _collectAllSuperTypes;
  }
  
  private List<BusinessObject> collectAllSuperTypes(final BusinessObject bo, final List<BusinessObject> superTypes, final LifecycleState minState) {
    List<BusinessObject> _xifexpression = null;
    BusinessObjectRef _superBusinessObject = bo.getSuperBusinessObject();
    boolean _notEquals = (!Objects.equal(_superBusinessObject, null));
    if (_notEquals) {
      List<BusinessObject> _xblockexpression = null;
      {
        BusinessObjectRef _superBusinessObject_1 = bo.getSuperBusinessObject();
        BusinessObject _type = _superBusinessObject_1.getType();
        LifecycleState _state = _type.getState();
        boolean _matches = this.stateMatcher.matches(minState, _state);
        if (_matches) {
          BusinessObjectRef _superBusinessObject_2 = bo.getSuperBusinessObject();
          BusinessObject _type_1 = _superBusinessObject_2.getType();
          superTypes.add(((BusinessObject) _type_1));
        }
        _xblockexpression = (superTypes);
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = superTypes;
    }
    return _xifexpression;
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
  public DependencyDescription getTransitiveDependencies(final Property prop, final boolean includeInheritedProperties, final boolean includeCycleTypes, final List<IEObjectDescription> visitedDependendies, final DependencyDescription referrer) {
    DependencyDescription _transitiveDependencies = this.boQueryInt.getTransitiveDependencies(prop, includeInheritedProperties, includeCycleTypes, visitedDependendies, referrer);
    return _transitiveDependencies;
  }
  
  public List<QualifiedName> getOtherTypeNsRefsToNs(final VersionedType type, final SubNamespace ns) {
    List<QualifiedName> _otherTypeNsRefsToNs = this.boQueryInt.getOtherTypeNsRefsToNs(type, ns);
    return _otherTypeNsRefsToNs;
  }
  
  public Map<EObject,VersionedType> getReferencedVersionedTypes(final BusinessObject bo, final boolean includeInheritedProperties) {
    Map<EObject,VersionedType> _referencedVersionedTypes = this.boQueryInt.getReferencedVersionedTypes(bo, includeInheritedProperties);
    return _referencedVersionedTypes;
  }
  
  public VersionedType toVersionedType(final IEObjectDescription desc, final Resource res) {
    VersionedType _versionedType = this.boQueryInt.toVersionedType(desc, res);
    return _versionedType;
  }
  
  public List<TreeNode<IEObjectDescription>> getAllSubTypes(final BusinessObject bo, final ResourceSet resourceSet) {
    List<TreeNode<IEObjectDescription>> _allSubTypes = this.boQueryInt.getAllSubTypes(bo, resourceSet);
    return _allSubTypes;
  }
  
  public TreeNode<IEObjectDescription> getAllSubTypesWithParent(final TreeNode<IEObjectDescription> parent, final ResourceSet resourceSet) {
    TreeNode<IEObjectDescription> _allSubTypesWithParent = this.boQueryInt.getAllSubTypesWithParent(parent, resourceSet);
    return _allSubTypesWithParent;
  }
  
  public List<BusinessObject> getAllSuperTypes(final BusinessObject bo, final Object vistitedBOs) {
    if (vistitedBOs instanceof List) {
      return _getAllSuperTypes(bo, (List<BusinessObject>)vistitedBOs);
    } else if (vistitedBOs instanceof LifecycleState) {
      return _getAllSuperTypes(bo, (LifecycleState)vistitedBOs);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(bo, vistitedBOs).toString());
    }
  }
  
  public List<Property> getVisibleObjectProperties(final Object bo, final LifecycleState minState) {
    if (bo instanceof BusinessObject) {
      return _getVisibleObjectProperties((BusinessObject)bo, minState);
    } else if (bo != null) {
      return _getVisibleObjectProperties(bo, minState);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(bo, minState).toString());
    }
  }
}
