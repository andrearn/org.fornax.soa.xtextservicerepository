package org.fornax.soa.service.query;

import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.VersionedType;

@SuppressWarnings("all")
public class VersionQueries {
  protected Version _getOwnerVersion(final EObject o) {
    EObject _eContainer = o.eContainer();
    Version _ownerVersion = _eContainer==null?(Version)null:this.getOwnerVersion(_eContainer);
    return _ownerVersion;
  }
  
  protected Version _getOwnerVersion(final VersionedType versionedType) {
    Version _version = versionedType.getVersion();
    return _version;
  }
  
  protected Version _getOwnerVersion(final org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType technicalVersionedType) {
    Version _version = technicalVersionedType.getVersion();
    return _version;
  }
  
  protected Version _getOwnerVersion(final org.fornax.soa.serviceDsl.Exception exception) {
    Version _version = exception.getVersion();
    return _version;
  }
  
  protected Version _getOwnerVersion(final Service service) {
    Version _version = service.getVersion();
    return _version;
  }
  
  public Version getOwnerVersion(final EObject technicalVersionedType) {
    if (technicalVersionedType instanceof org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType) {
      return _getOwnerVersion((org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType)technicalVersionedType);
    } else if (technicalVersionedType instanceof VersionedType) {
      return _getOwnerVersion((VersionedType)technicalVersionedType);
    } else if (technicalVersionedType instanceof org.fornax.soa.serviceDsl.Exception) {
      return _getOwnerVersion((org.fornax.soa.serviceDsl.Exception)technicalVersionedType);
    } else if (technicalVersionedType instanceof Service) {
      return _getOwnerVersion((Service)technicalVersionedType);
    } else if (technicalVersionedType != null) {
      return _getOwnerVersion(technicalVersionedType);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(technicalVersionedType).toString());
    }
  }
}
