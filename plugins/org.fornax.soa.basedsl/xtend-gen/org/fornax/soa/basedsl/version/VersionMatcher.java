package org.fornax.soa.basedsl.version;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.basedsl.sOABaseDsl.FixedVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.LowerBoundRangeVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MajorVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MaxVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.MinVersionRef;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.basedsl.version.VersionQualifierExtensions;

@SuppressWarnings("all")
public class VersionMatcher {
  @Inject
  private VersionQualifierExtensions _versionQualifierExtensions;
  
  protected boolean _versionMatches(final Version v, final VersionRef r) {
    return false;
  }
  
  protected boolean _versionMatches(final Version v, final Integer majorVer) {
    boolean _or = false;
    String _version = v.getVersion();
    String _versionNumber = this._versionQualifierExtensions.toVersionNumber(_version);
    String[] _split = _versionNumber.split("\\.");
    String _get = ((List<String>)Conversions.doWrapArray(_split)).get(0);
    String _string = majorVer.toString();
    boolean _equals = Objects.equal(_get, _string);
    if (_equals) {
      _or = true;
    } else {
      String _versionNumber_1 = this._versionQualifierExtensions.toVersionNumber(v);
      String[] _split_1 = _versionNumber_1.split("\\.");
      String _get_1 = ((List<String>)Conversions.doWrapArray(_split_1)).get(0);
      String _string_1 = majorVer.toString();
      boolean _equals_1 = Objects.equal(_get_1, _string_1);
      _or = (_equals || _equals_1);
    }
    return _or;
  }
  
  protected boolean _versionMatches(final Version v, final MinVersionRef r) {
    boolean _or = false;
    String _versionNumber = this._versionQualifierExtensions.toVersionNumber(v);
    String _minVersion = r.getMinVersion();
    String _versionNumber_1 = this._versionQualifierExtensions.toVersionNumber(_minVersion);
    boolean _equals = Objects.equal(_versionNumber, _versionNumber_1);
    if (_equals) {
      _or = true;
    } else {
      String _versionNumber_2 = this._versionQualifierExtensions.toVersionNumber(v);
      String _minVersion_1 = r.getMinVersion();
      String _versionNumber_3 = this._versionQualifierExtensions.toVersionNumber(_minVersion_1);
      boolean _greaterThan = (_versionNumber_2.compareTo(_versionNumber_3) > 0);
      _or = (_equals || _greaterThan);
    }
    return _or;
  }
  
  protected boolean _versionMatches(final Version v, final MaxVersionRef r) {
    boolean _or = false;
    String _versionNumber = this._versionQualifierExtensions.toVersionNumber(v);
    String _maxVersion = r.getMaxVersion();
    String _versionNumber_1 = this._versionQualifierExtensions.toVersionNumber(_maxVersion);
    boolean _equals = Objects.equal(_versionNumber, _versionNumber_1);
    if (_equals) {
      _or = true;
    } else {
      String _versionNumber_2 = this._versionQualifierExtensions.toVersionNumber(v);
      String _maxVersion_1 = r.getMaxVersion();
      String _versionNumber_3 = this._versionQualifierExtensions.toVersionNumber(_maxVersion_1);
      boolean _lessThan = (_versionNumber_2.compareTo(_versionNumber_3) < 0);
      _or = (_equals || _lessThan);
    }
    return _or;
  }
  
  protected boolean _versionMatches(final Version v, final LowerBoundRangeVersionRef r) {
    boolean _or = false;
    String _version = v.getVersion();
    String _versionNumber = this._versionQualifierExtensions.toVersionNumber(_version);
    String _minVersion = r.getMinVersion();
    String _versionNumber_1 = this._versionQualifierExtensions.toVersionNumber(_minVersion);
    boolean _equals = Objects.equal(_versionNumber, _versionNumber_1);
    if (_equals) {
      _or = true;
    } else {
      boolean _and = false;
      String _versionNumber_2 = this._versionQualifierExtensions.toVersionNumber(v);
      String _minVersion_1 = r.getMinVersion();
      String _versionNumber_3 = this._versionQualifierExtensions.toVersionNumber(_minVersion_1);
      boolean _greaterThan = (_versionNumber_2.compareTo(_versionNumber_3) > 0);
      if (!_greaterThan) {
        _and = false;
      } else {
        String _versionNumber_4 = this._versionQualifierExtensions.toVersionNumber(v);
        String _maxVersion = r.getMaxVersion();
        String _versionNumber_5 = this._versionQualifierExtensions.toVersionNumber(_maxVersion);
        boolean _lessThan = (_versionNumber_4.compareTo(_versionNumber_5) < 0);
        _and = (_greaterThan && _lessThan);
      }
      _or = (_equals || _and);
    }
    return _or;
  }
  
  protected boolean _versionMatches(final Version v, final MajorVersionRef r) {
    boolean _or = false;
    String _version = v.getVersion();
    String _versionNumber = this._versionQualifierExtensions.toVersionNumber(_version);
    String[] _split = _versionNumber.split("\\.");
    String _get = ((List<String>)Conversions.doWrapArray(_split)).get(0);
    int _majorVersion = r.getMajorVersion();
    String _string = Integer.valueOf(_majorVersion).toString();
    boolean _equals = Objects.equal(_get, _string);
    if (_equals) {
      _or = true;
    } else {
      String _versionNumber_1 = this._versionQualifierExtensions.toVersionNumber(v);
      String[] _split_1 = _versionNumber_1.split("\\.");
      String _get_1 = ((List<String>)Conversions.doWrapArray(_split_1)).get(0);
      int _majorVersion_1 = r.getMajorVersion();
      String _string_1 = Integer.valueOf(_majorVersion_1).toString();
      boolean _equals_1 = Objects.equal(_get_1, _string_1);
      _or = (_equals || _equals_1);
    }
    return _or;
  }
  
  protected boolean _versionMatches(final Version v, final FixedVersionRef r) {
    String _versionNumber = this._versionQualifierExtensions.toVersionNumber(v);
    String _fixedVersion = r.getFixedVersion();
    String _versionNumber_1 = this._versionQualifierExtensions.toVersionNumber(_fixedVersion);
    boolean _equals = Objects.equal(_versionNumber, _versionNumber_1);
    return _equals;
  }
  
  protected boolean _matchesMajorVersion(final Version v, final String majorVer) {
    String _version = v.getVersion();
    String _versionNumber = this._versionQualifierExtensions.toVersionNumber(_version);
    String[] _split = _versionNumber.split("\\.");
    String _head = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(_split)));
    boolean _equals = Objects.equal(_head, majorVer);
    return _equals;
  }
  
  public boolean versionMatches(final Version v, final Object r) {
    if (r instanceof FixedVersionRef) {
      return _versionMatches(v, (FixedVersionRef)r);
    } else if (r instanceof LowerBoundRangeVersionRef) {
      return _versionMatches(v, (LowerBoundRangeVersionRef)r);
    } else if (r instanceof MajorVersionRef) {
      return _versionMatches(v, (MajorVersionRef)r);
    } else if (r instanceof MaxVersionRef) {
      return _versionMatches(v, (MaxVersionRef)r);
    } else if (r instanceof MinVersionRef) {
      return _versionMatches(v, (MinVersionRef)r);
    } else if (r instanceof Integer) {
      return _versionMatches(v, (Integer)r);
    } else if (r instanceof VersionRef) {
      return _versionMatches(v, (VersionRef)r);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v, r).toString());
    }
  }
  
  public boolean matchesMajorVersion(final Version v, final String majorVer) {
    {
      return _matchesMajorVersion(v, majorVer);
    }
  }
}
