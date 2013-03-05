package org.fornax.soa.service.query.namespace;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.basedsl.search.IEObjectLookup;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.service.VersionedDomainNamespace;
import org.fornax.soa.service.query.ExceptionFinder;
import org.fornax.soa.service.query.ServiceQueries;
import org.fornax.soa.service.query.type.TypesByLifecycleStateFinder;
import org.fornax.soa.serviceDsl.BusinessObjectRef;
import org.fornax.soa.serviceDsl.EnumTypeRef;
import org.fornax.soa.serviceDsl.ExceptionRef;
import org.fornax.soa.serviceDsl.OrganizationNamespace;
import org.fornax.soa.serviceDsl.ServiceRef;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.Type;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.serviceDsl.VersionedTypeRef;

/**
 * Namespace lookup functions
 */
@SuppressWarnings("all")
public class NamespaceQuery {
  @Inject
  private IEObjectLookup _iEObjectLookup;
  
  @Inject
  private TypesByLifecycleStateFinder _typesByLifecycleStateFinder;
  
  @Inject
  private ServiceQueries _serviceQueries;
  
  @Inject
  private ExceptionFinder _exceptionFinder;
  
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
  
  protected boolean _hasTypesInMinState(final SubNamespace ns, final LifecycleState state) {
    List<Type> _typesWithMinState = this._typesByLifecycleStateFinder.typesWithMinState(ns, state);
    int _size = _typesWithMinState.size();
    boolean _greaterThan = (_size > 0);
    return _greaterThan;
  }
  
  protected boolean _hasServicesInMinState(final SubNamespace ns, final LifecycleState state) {
    List _servicesWithMinState = this._serviceQueries.servicesWithMinState(ns, state);
    int _size = _servicesWithMinState.size();
    boolean _greaterThan = (_size > 0);
    return _greaterThan;
  }
  
  protected boolean _hasExceptionsInMinState(final SubNamespace ns, final LifecycleState state) {
    List _exceptionsWithMinState = this._exceptionFinder.exceptionsWithMinState(ns, state);
    int _size = _exceptionsWithMinState.size();
    boolean _greaterThan = (_size > 0);
    return _greaterThan;
  }
  
  protected boolean _hasTypesInMinState(final VersionedDomainNamespace ns, final LifecycleState state) {
    List<Type> _typesWithMinState = this._typesByLifecycleStateFinder.typesWithMinState(ns, state);
    int _size = _typesWithMinState.size();
    boolean _greaterThan = (_size > 0);
    return _greaterThan;
  }
  
  protected boolean _hasServicesInMinState(final VersionedDomainNamespace ns, final LifecycleState state) {
    List _servicesWithMinState = this._serviceQueries.servicesWithMinState(ns, state);
    int _size = _servicesWithMinState.size();
    boolean _greaterThan = (_size > 0);
    return _greaterThan;
  }
  
  protected boolean _hasExceptionsInMinState(final VersionedDomainNamespace ns, final LifecycleState state) {
    List _exceptionsWithMinState = this._exceptionFinder.exceptionsWithMinState(ns, state);
    int _size = _exceptionsWithMinState.size();
    boolean _greaterThan = (_size > 0);
    return _greaterThan;
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
  
  public boolean hasTypesInMinState(final Object ns, final LifecycleState state) {
    if (ns instanceof SubNamespace) {
      return _hasTypesInMinState((SubNamespace)ns, state);
    } else if (ns instanceof VersionedDomainNamespace) {
      return _hasTypesInMinState((VersionedDomainNamespace)ns, state);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ns, state).toString());
    }
  }
  
  public boolean hasServicesInMinState(final Object ns, final LifecycleState state) {
    if (ns instanceof SubNamespace) {
      return _hasServicesInMinState((SubNamespace)ns, state);
    } else if (ns instanceof VersionedDomainNamespace) {
      return _hasServicesInMinState((VersionedDomainNamespace)ns, state);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ns, state).toString());
    }
  }
  
  public boolean hasExceptionsInMinState(final Object ns, final LifecycleState state) {
    if (ns instanceof SubNamespace) {
      return _hasExceptionsInMinState((SubNamespace)ns, state);
    } else if (ns instanceof VersionedDomainNamespace) {
      return _hasExceptionsInMinState((VersionedDomainNamespace)ns, state);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ns, state).toString());
    }
  }
}
