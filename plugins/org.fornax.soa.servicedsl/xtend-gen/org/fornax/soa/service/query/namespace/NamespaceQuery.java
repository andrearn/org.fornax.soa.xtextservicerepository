package org.fornax.soa.service.query.namespace;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.basedsl.search.IEObjectLookup;
import org.fornax.soa.serviceDsl.BusinessObjectRef;
import org.fornax.soa.serviceDsl.EnumTypeRef;
import org.fornax.soa.serviceDsl.ExceptionRef;
import org.fornax.soa.serviceDsl.OrganizationNamespace;
import org.fornax.soa.serviceDsl.ServiceRef;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.serviceDsl.VersionedTypeRef;

/**
 * Namespace lookup functions
 */
@SuppressWarnings("all")
public class NamespaceQuery {
  @Inject
  private IEObjectLookup _iEObjectLookup;
  
  protected OrganizationNamespace _findOrgNamespace(final EObject o) {
    final OrganizationNamespace orgNs = this._iEObjectLookup.<OrganizationNamespace>getOwnerByType(o, OrganizationNamespace.class);
    return orgNs;
  }
  
  protected SubNamespace _findSubdomain(final EObject o) {
    final SubNamespace ns = this._iEObjectLookup.<SubNamespace>getOwnerByType(o, SubNamespace.class);
    return ns;
  }
  
  /**
   * Find the owning namespace of the owner of the type reference
   */
  protected SubNamespace _findTypeRefOwnerSubdomain(final TypeRef t) {
    EObject _statefulOwner = this._iEObjectLookup.getStatefulOwner(t);
    EObject _eContainer = _statefulOwner==null?(EObject)null:_statefulOwner.eContainer();
    return ((SubNamespace) _eContainer);
  }
  
  /**
   * Find the owning namespace of the owner of the type reference
   */
  protected SubNamespace _findTypeRefOwnerSubdomain(final VersionedTypeRef c) {
    EObject _statefulOwner = c==null?(EObject)null:this._iEObjectLookup.getStatefulOwner(c);
    EObject _eContainer = _statefulOwner==null?(EObject)null:_statefulOwner.eContainer();
    return ((SubNamespace) _eContainer);
  }
  
  /**
   * Find the owning namespace of the owner of the type reference
   */
  protected SubNamespace _findTypeRefOwnerSubdomain(final BusinessObjectRef c) {
    EObject _statefulOwner = c==null?(EObject)null:this._iEObjectLookup.getStatefulOwner(c);
    EObject _eContainer = _statefulOwner==null?(EObject)null:_statefulOwner.eContainer();
    return ((SubNamespace) _eContainer);
  }
  
  /**
   * Find the owning namespace of the owner of the type reference
   */
  protected SubNamespace _findTypeRefOwnerSubdomain(final EnumTypeRef c) {
    EObject _statefulOwner = c==null?(EObject)null:this._iEObjectLookup.getStatefulOwner(c);
    EObject _eContainer = _statefulOwner==null?(EObject)null:_statefulOwner.eContainer();
    return ((SubNamespace) _eContainer);
  }
  
  /**
   * Find the owning namespace of the owner of the exception reference
   */
  public SubNamespace findExceptionRefOwnerSubdomain(final ExceptionRef e) {
    EObject _statefulOwner = e==null?(EObject)null:this._iEObjectLookup.getStatefulOwner(e);
    EObject _eContainer = _statefulOwner==null?(EObject)null:_statefulOwner.eContainer();
    return ((SubNamespace) _eContainer);
  }
  
  /**
   * Find the owning namespace of the owner of the service reference
   */
  public SubNamespace findServiceRefOwnerSubdomain(final ServiceRef s) {
    EObject _statefulOwner = s==null?(EObject)null:this._iEObjectLookup.getStatefulOwner(s);
    EObject _eContainer = _statefulOwner==null?(EObject)null:_statefulOwner.eContainer();
    return ((SubNamespace) _eContainer);
  }
  
  public OrganizationNamespace findOrgNamespace(final EObject o) {
    {
      return _findOrgNamespace(o);
    }
  }
  
  public SubNamespace findSubdomain(final EObject o) {
    {
      return _findSubdomain(o);
    }
  }
  
  public SubNamespace findTypeRefOwnerSubdomain(final TypeRef c) {
    if (c instanceof BusinessObjectRef) {
      return _findTypeRefOwnerSubdomain((BusinessObjectRef)c);
    } else if (c instanceof EnumTypeRef) {
      return _findTypeRefOwnerSubdomain((EnumTypeRef)c);
    } else if (c instanceof VersionedTypeRef) {
      return _findTypeRefOwnerSubdomain((VersionedTypeRef)c);
    } else if (c != null) {
      return _findTypeRefOwnerSubdomain(c);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(c).toString());
    }
  }
}
