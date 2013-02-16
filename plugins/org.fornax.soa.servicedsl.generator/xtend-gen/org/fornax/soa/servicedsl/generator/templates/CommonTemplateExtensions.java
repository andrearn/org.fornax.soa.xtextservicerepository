package org.fornax.soa.servicedsl.generator.templates;

import com.google.inject.Inject;
import java.util.Arrays;
import org.fornax.soa.basedsl.sOABaseDsl.LowerBoundRangeVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MaxVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MinVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.basedsl.version.VersionQualifierExtensions;

@SuppressWarnings("all")
public class CommonTemplateExtensions {
  @Inject
  private VersionQualifierExtensions _versionQualifierExtensions;
  
  protected String _versionRangeText(final VersionRef v) {
    return "";
  }
  
  protected String _versionRangeText(final MinVersionRef v) {
    String _minVersion = v.getMinVersion();
    String _versionNumber = this._versionQualifierExtensions.toVersionNumber(_minVersion);
    String _plus = (">= " + _versionNumber);
    return _plus;
  }
  
  protected String _versionRangeText(final LowerBoundRangeVersionRef v) {
    String _minVersion = v.getMinVersion();
    String _versionNumber = this._versionQualifierExtensions.toVersionNumber(_minVersion);
    String _plus = (_versionNumber + " to <");
    String _maxVersion = v.getMaxVersion();
    String _versionNumber_1 = this._versionQualifierExtensions.toVersionNumber(_maxVersion);
    String _plus_1 = (_plus + _versionNumber_1);
    return _plus_1;
  }
  
  protected String _versionRangeText(final MaxVersionRef v) {
    String _maxVersion = v.getMaxVersion();
    String _versionNumber = this._versionQualifierExtensions.toVersionNumber(_maxVersion);
    String _plus = ("<= " + _versionNumber);
    return _plus;
  }
  
  public String versionRangeText(final VersionRef v) {
    if (v instanceof LowerBoundRangeVersionRef) {
      return _versionRangeText((LowerBoundRangeVersionRef)v);
    } else if (v instanceof MaxVersionRef) {
      return _versionRangeText((MaxVersionRef)v);
    } else if (v instanceof MinVersionRef) {
      return _versionRangeText((MinVersionRef)v);
    } else if (v != null) {
      return _versionRangeText(v);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v).toString());
    }
  }
}
