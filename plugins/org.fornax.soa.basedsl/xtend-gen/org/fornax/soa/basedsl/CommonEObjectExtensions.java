package org.fornax.soa.basedsl;

import com.google.common.base.Objects;
import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.basedsl.sOABaseDsl.Version;

@SuppressWarnings("all")
public class CommonEObjectExtensions {
  public EObject eRootContainer(final EObject o) {
    EObject _xifexpression = null;
    EObject _eContainer = o.eContainer();
    boolean _notEquals = (!Objects.equal(_eContainer, null));
    if (_notEquals) {
      EObject _eRootContainer = this.eRootContainer(o);
      _xifexpression = _eRootContainer;
    } else {
      return o;
    }
    return _xifexpression;
  }
  
  protected String _fqn(final EObject o) {
    return null;
  }
  
  protected EObject _getOwningType(final EObject o) {
    EObject _eContainer = o.eContainer();
    EObject _owningType = _eContainer==null?(EObject)null:this.getOwningType(_eContainer);
    return _owningType;
  }
  
  protected Version _getOwnerVersion(final EObject o) {
    EObject _eContainer = o.eContainer();
    Version _ownerVersion = _eContainer==null?(Version)null:this.getOwnerVersion(_eContainer);
    return _ownerVersion;
  }
  
  public String fqn(final EObject o) {
    {
      return _fqn(o);
    }
  }
  
  public EObject getOwningType(final EObject o) {
    {
      return _getOwningType(o);
    }
  }
  
  public Version getOwnerVersion(final EObject o) {
    {
      return _getOwnerVersion(o);
    }
  }
}
