package org.fornax.soa.profiledsl.query;

import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType;
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedTypeRef;

@SuppressWarnings("all")
public class ProfileVersionQueries {
  protected EObject _getOwningType(final VersionedType o) {
    return o;
  }
  
  protected Version _getOwnerVersion(final VersionedType o) {
    Version _version = o.getVersion();
    return _version;
  }
  
  protected Version _getOwnerVersion(final VersionedTypeRef o) {
    VersionedType _type = o.getType();
    Version _ownerVersion = this.getOwnerVersion(_type);
    return _ownerVersion;
  }
  
  public EObject getOwningType(final VersionedType o) {
    {
      return _getOwningType(o);
    }
  }
  
  public Version getOwnerVersion(final EObject o) {
    if (o instanceof VersionedType) {
      return _getOwnerVersion((VersionedType)o);
    } else if (o instanceof VersionedTypeRef) {
      return _getOwnerVersion((VersionedTypeRef)o);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(o).toString());
    }
  }
}
