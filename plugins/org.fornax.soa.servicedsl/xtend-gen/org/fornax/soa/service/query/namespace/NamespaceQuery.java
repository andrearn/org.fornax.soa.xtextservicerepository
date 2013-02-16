package org.fornax.soa.service.query.namespace;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.basedsl.CommonStringExtensions;
import org.fornax.soa.profiledsl.query.LifecycleQueries;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.BusinessObjectRef;
import org.fornax.soa.serviceDsl.DomainNamespace;
import org.fornax.soa.serviceDsl.EnumTypeRef;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.serviceDsl.ExceptionRef;
import org.fornax.soa.serviceDsl.InternalNamespace;
import org.fornax.soa.serviceDsl.OrganizationNamespace;
import org.fornax.soa.serviceDsl.QueryObject;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.ServiceRef;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.Type;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.serviceDsl.VersionedType;
import org.fornax.soa.serviceDsl.VersionedTypeRef;

/**
 * Namespace lookup functions
 */
@SuppressWarnings("all")
public class NamespaceQuery {
  @Inject
  private LifecycleQueries _lifecycleQueries;
  
  @Inject
  private CommonStringExtensions _commonStringExtensions;
  
  protected OrganizationNamespace _findOrgNamespace(final Object o) {
    return null;
  }
  
  protected OrganizationNamespace _findOrgNamespace(final Service o) {
    EObject _eContainer = o.eContainer();
    EObject _eContainer_1 = _eContainer.eContainer();
    return ((OrganizationNamespace) _eContainer_1);
  }
  
  protected OrganizationNamespace _findOrgNamespace(final DomainNamespace o) {
    OrganizationNamespace _xifexpression = null;
    EObject _eContainer = o.eContainer();
    if ((_eContainer instanceof OrganizationNamespace)) {
      EObject _eContainer_1 = o.eContainer();
      _xifexpression = ((OrganizationNamespace) _eContainer_1);
    } else {
      EObject _eContainer_2 = o.eContainer();
      OrganizationNamespace _findOrgNamespace = this==null?(OrganizationNamespace)null:this.findOrgNamespace(((DomainNamespace) _eContainer_2));
      _xifexpression = ((OrganizationNamespace) _findOrgNamespace);
    }
    return _xifexpression;
  }
  
  protected OrganizationNamespace _findOrgNamespace(final InternalNamespace o) {
    OrganizationNamespace _xifexpression = null;
    EObject _eContainer = o.eContainer();
    if ((_eContainer instanceof OrganizationNamespace)) {
      EObject _eContainer_1 = o.eContainer();
      _xifexpression = ((OrganizationNamespace) _eContainer_1);
    } else {
      EObject _eContainer_2 = o.eContainer();
      OrganizationNamespace _findOrgNamespace = this==null?(OrganizationNamespace)null:this.findOrgNamespace(((SubNamespace) _eContainer_2));
      _xifexpression = ((OrganizationNamespace) _findOrgNamespace);
    }
    return _xifexpression;
  }
  
  protected SubNamespace _findSubdomain(final Type t) {
    return null;
  }
  
  protected SubNamespace _findSubdomain(final VersionedType c) {
    SubNamespace _xifexpression = null;
    EObject _eContainer = c.eContainer();
    if ((_eContainer instanceof SubNamespace)) {
      EObject _eContainer_1 = c.eContainer();
      _xifexpression = ((SubNamespace) _eContainer_1);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  protected SubNamespace _findSubdomain(final BusinessObject c) {
    SubNamespace _xifexpression = null;
    EObject _eContainer = c.eContainer();
    if ((_eContainer instanceof SubNamespace)) {
      EObject _eContainer_1 = c.eContainer();
      _xifexpression = ((SubNamespace) _eContainer_1);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  protected SubNamespace _findSubdomain(final QueryObject c) {
    SubNamespace _xifexpression = null;
    EObject _eContainer = c.eContainer();
    if ((_eContainer instanceof SubNamespace)) {
      EObject _eContainer_1 = c.eContainer();
      _xifexpression = ((SubNamespace) _eContainer_1);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  protected SubNamespace _findSubdomain(final Enumeration c) {
    SubNamespace _xifexpression = null;
    EObject _eContainer = c.eContainer();
    if ((_eContainer instanceof SubNamespace)) {
      EObject _eContainer_1 = c.eContainer();
      _xifexpression = ((SubNamespace) _eContainer_1);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  protected SubNamespace _findSubdomain(final org.fornax.soa.serviceDsl.Exception c) {
    SubNamespace _xifexpression = null;
    EObject _eContainer = c.eContainer();
    if ((_eContainer instanceof SubNamespace)) {
      EObject _eContainer_1 = c.eContainer();
      _xifexpression = ((SubNamespace) _eContainer_1);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  protected SubNamespace _findSubdomain(final Service c) {
    SubNamespace _xifexpression = null;
    EObject _eContainer = c.eContainer();
    if ((_eContainer instanceof SubNamespace)) {
      EObject _eContainer_1 = c.eContainer();
      _xifexpression = ((SubNamespace) _eContainer_1);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  /**
   * Find the owning namespace of the owner of the type reference
   */
  protected SubNamespace _findRefOwnerSubdomain(final TypeRef t) {
    EObject _statefulOwner = this._lifecycleQueries.getStatefulOwner(t);
    EObject _eContainer = _statefulOwner==null?(EObject)null:_statefulOwner.eContainer();
    return ((SubNamespace) _eContainer);
  }
  
  /**
   * Find the owning namespace of the owner of the type reference
   */
  protected SubNamespace _findRefOwnerSubdomain(final VersionedTypeRef c) {
    EObject _statefulOwner = c==null?(EObject)null:this._lifecycleQueries.getStatefulOwner(c);
    EObject _eContainer = _statefulOwner==null?(EObject)null:_statefulOwner.eContainer();
    return ((SubNamespace) _eContainer);
  }
  
  /**
   * Find the owning namespace of the owner of the type reference
   */
  protected SubNamespace _findRefOwnerSubdomain(final BusinessObjectRef c) {
    EObject _statefulOwner = c==null?(EObject)null:this._lifecycleQueries.getStatefulOwner(c);
    EObject _eContainer = _statefulOwner==null?(EObject)null:_statefulOwner.eContainer();
    return ((SubNamespace) _eContainer);
  }
  
  /**
   * Find the owning namespace of the owner of the type reference
   */
  protected SubNamespace _findRefOwnerSubdomain(final EnumTypeRef c) {
    EObject _statefulOwner = c==null?(EObject)null:this._lifecycleQueries.getStatefulOwner(c);
    EObject _eContainer = _statefulOwner==null?(EObject)null:_statefulOwner.eContainer();
    return ((SubNamespace) _eContainer);
  }
  
  /**
   * Find the owning namespace of the owner of the exception reference
   */
  protected SubNamespace _findRefOwnerSubdomain(final ExceptionRef e) {
    EObject _statefulOwner = e==null?(EObject)null:this._lifecycleQueries.getStatefulOwner(e);
    EObject _eContainer = _statefulOwner==null?(EObject)null:_statefulOwner.eContainer();
    return ((SubNamespace) _eContainer);
  }
  
  /**
   * Find the owning namespace of the owner of the service reference
   */
  protected SubNamespace _findRefOwnerSubdomain(final ServiceRef s) {
    EObject _statefulOwner = s==null?(EObject)null:this._lifecycleQueries.getStatefulOwner(s);
    EObject _eContainer = _statefulOwner==null?(EObject)null:_statefulOwner.eContainer();
    return ((SubNamespace) _eContainer);
  }
  
  public OrganizationNamespace findOrgNamespace(final Object o) {
    if (o instanceof DomainNamespace) {
      return _findOrgNamespace((DomainNamespace)o);
    } else if (o instanceof InternalNamespace) {
      return _findOrgNamespace((InternalNamespace)o);
    } else if (o instanceof Service) {
      return _findOrgNamespace((Service)o);
    } else if (o != null) {
      return _findOrgNamespace(o);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(o).toString());
    }
  }
  
  public SubNamespace findSubdomain(final EObject c) {
    if (c instanceof BusinessObject) {
      return _findSubdomain((BusinessObject)c);
    } else if (c instanceof Enumeration) {
      return _findSubdomain((Enumeration)c);
    } else if (c instanceof QueryObject) {
      return _findSubdomain((QueryObject)c);
    } else if (c instanceof VersionedType) {
      return _findSubdomain((VersionedType)c);
    } else if (c instanceof org.fornax.soa.serviceDsl.Exception) {
      return _findSubdomain((org.fornax.soa.serviceDsl.Exception)c);
    } else if (c instanceof Service) {
      return _findSubdomain((Service)c);
    } else if (c instanceof Type) {
      return _findSubdomain((Type)c);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(c).toString());
    }
  }
  
  public SubNamespace findRefOwnerSubdomain(final EObject c) {
    if (c instanceof BusinessObjectRef) {
      return _findRefOwnerSubdomain((BusinessObjectRef)c);
    } else if (c instanceof EnumTypeRef) {
      return _findRefOwnerSubdomain((EnumTypeRef)c);
    } else if (c instanceof VersionedTypeRef) {
      return _findRefOwnerSubdomain((VersionedTypeRef)c);
    } else if (c instanceof ExceptionRef) {
      return _findRefOwnerSubdomain((ExceptionRef)c);
    } else if (c instanceof ServiceRef) {
      return _findRefOwnerSubdomain((ServiceRef)c);
    } else if (c instanceof TypeRef) {
      return _findRefOwnerSubdomain((TypeRef)c);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(c).toString());
    }
  }
}
