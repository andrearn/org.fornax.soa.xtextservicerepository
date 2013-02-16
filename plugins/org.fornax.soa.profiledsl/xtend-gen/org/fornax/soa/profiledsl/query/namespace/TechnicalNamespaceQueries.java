package org.fornax.soa.profiledsl.query.namespace;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.basedsl.CommonEObjectExtensions;
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace;
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType;
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedTypeRef;

@SuppressWarnings("all")
public class TechnicalNamespaceQueries {
  @Inject
  private CommonEObjectExtensions _commonEObjectExtensions;
  
  public TechnicalNamespace findOwnerSubdomain(final VersionedTypeRef c) {
    EObject _owningType = c==null?(EObject)null:this._commonEObjectExtensions.getOwningType(c);
    EObject _eContainer = _owningType==null?(EObject)null:_owningType.eContainer();
    return ((TechnicalNamespace) _eContainer);
  }
  
  public TechnicalNamespace findTechnicalNamespace(final VersionedType c) {
    TechnicalNamespace _xifexpression = null;
    EObject _eContainer = c.eContainer();
    if ((_eContainer instanceof TechnicalNamespace)) {
      EObject _eContainer_1 = c.eContainer();
      _xifexpression = ((TechnicalNamespace) _eContainer_1);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
}
