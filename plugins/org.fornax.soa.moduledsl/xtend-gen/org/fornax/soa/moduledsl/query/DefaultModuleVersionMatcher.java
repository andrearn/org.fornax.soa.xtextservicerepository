package org.fornax.soa.moduledsl.query;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.scoping.versions.VersionComparator;
import org.fornax.soa.basedsl.version.VersionQualifierExtensions;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.moduledsl.query.IModuleVersionMatcher;

/**
 * Checks, whether to two module versions are compatible.<br/>
 * 
 * A Module is considered compatible, if it has
 * <ol>
 * 	<li>the same major version number</li>
 *  <li>the same or a higher minor version number</li>
 * </ol>
 */
@SuppressWarnings("all")
public class DefaultModuleVersionMatcher implements IModuleVersionMatcher {
  @Inject
  private VersionQualifierExtensions _versionQualifierExtensions;
  
  @Inject
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  /**
   * Check, whether the Module module is compatible to Module originalModule based on thein versions
   * 
   * returns true, if module is compatible to originalModule
   */
  public boolean isCompatibleTo(final Module otherModule, final Module originalModule) {
    final Version originalVersion = otherModule.getVersion();
    final Version otherVersion = otherModule.getVersion();
    boolean _and = false;
    boolean _and_1 = false;
    QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(otherModule);
    QualifiedName _fullyQualifiedName_1 = this._iQualifiedNameProvider.getFullyQualifiedName(originalModule);
    boolean _equals = Objects.equal(_fullyQualifiedName, _fullyQualifiedName_1);
    if (!_equals) {
      _and_1 = false;
    } else {
      String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(originalVersion);
      String _majorVersionNumber_1 = this._versionQualifierExtensions.toMajorVersionNumber(otherVersion);
      boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
      _and_1 = (_equals && _equals_1);
    }
    if (!_and_1) {
      _and = false;
    } else {
      String _versionNumber = this._versionQualifierExtensions.toVersionNumber(originalVersion);
      String _versionNumber_1 = this._versionQualifierExtensions.toVersionNumber(otherVersion);
      int _compare = VersionComparator.compare(_versionNumber, _versionNumber_1);
      boolean _greaterEqualsThan = (_compare >= 0);
      _and = (_and_1 && _greaterEqualsThan);
    }
    if (_and) {
      return true;
    }
    return false;
  }
}
