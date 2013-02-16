package org.fornax.soa.moduledsl.query;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.basedsl.version.VersionMatcher;
import org.fornax.soa.moduledsl.moduleDsl.AbstractServiceRef;
import org.fornax.soa.serviceDsl.Service;

@SuppressWarnings("all")
public class ServiceRefMatcher {
  @Inject
  private VersionMatcher _versionMatcher;
  
  @Inject
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  public boolean matches(final Service svc, final AbstractServiceRef ref) {
    final QualifiedName svcName = this._iQualifiedNameProvider.getFullyQualifiedName(svc);
    Service _service = ref.getService();
    final QualifiedName refSvcName = this._iQualifiedNameProvider.getFullyQualifiedName(_service);
    boolean _and = false;
    boolean _equals = Objects.equal(svcName, refSvcName);
    if (!_equals) {
      _and = false;
    } else {
      Version _version = svc.getVersion();
      VersionRef _versionRef = ref.getVersionRef();
      boolean _versionMatches = this._versionMatcher.versionMatches(_version, _versionRef);
      _and = (_equals && _versionMatches);
    }
    if (_and) {
      return true;
    } else {
      return false;
    }
  }
}
