package org.fornax.soa.basedsl.version;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.basedsl.sOABaseDsl.SOABaseDslFactory;
import org.fornax.soa.basedsl.sOABaseDsl.Version;

@SuppressWarnings("all")
public class VersionQualifierExtensions {
  @Inject
  private SOABaseDslFactory dslFactory;
  
  protected String _toVersionNumber(final Integer v) {
    String _string = v.toString();
    return _string;
  }
  
  protected String _toVersionNumber(final String v) {
    String _replaceFirst = v.replaceFirst("\\[", "");
    String _replaceFirst_1 = _replaceFirst.replaceFirst("\\]", "");
    return _replaceFirst_1;
  }
  
  protected String _toVersionNumber(final Version v) {
    String _version = v.getVersion();
    return _version;
  }
  
  protected String _toMajorVersionNumber(final Integer v) {
    String _string = v.toString();
    return _string;
  }
  
  protected String _toMajorVersionNumber(final String v) {
    String _xifexpression = null;
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(v, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _notEquals_1 = (!Objects.equal(v, ""));
      _and = (_notEquals && _notEquals_1);
    }
    if (_and) {
      String _versionNumber = this.toVersionNumber(v);
      String[] _split = _versionNumber.split("\\.");
      String _head = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(_split)));
      _xifexpression = _head;
    } else {
      _xifexpression = "1";
    }
    return _xifexpression;
  }
  
  protected String _toMajorVersionNumber(final Version v) {
    String _xifexpression = null;
    boolean _notEquals = (!Objects.equal(v, null));
    if (_notEquals) {
      String _versionNumber = this.toVersionNumber(v);
      String[] _split = _versionNumber.split("\\.");
      String _head = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(_split)));
      _xifexpression = _head;
    } else {
      _xifexpression = "1";
    }
    return _xifexpression;
  }
  
  protected String _toVersionPostfix(final String v) {
    String _majorVersionNumber = this.toMajorVersionNumber(v);
    String _plus = ("v" + _majorVersionNumber);
    return _plus;
  }
  
  protected String _toVersionPostfix(final Integer v) {
    String _majorVersionNumber = this.toMajorVersionNumber(v);
    String _plus = ("v" + _majorVersionNumber);
    return _plus;
  }
  
  protected String _toVersionPostfix(final Version v) {
    String _majorVersionNumber = this.toMajorVersionNumber(v);
    String _plus = ("v" + _majorVersionNumber);
    return _plus;
  }
  
  public String toDefaultVersionPostfix() {
    String _defaultMajorVersion = this.toDefaultMajorVersion();
    String _plus = ("v" + _defaultMajorVersion);
    return _plus;
  }
  
  public String toDefaultMajorVersion() {
    return "1";
  }
  
  /**
   * returns the default version string 1.0
   */
  public String toDefaultVersion() {
    return "1.0";
  }
  
  public Version toVersion(final String v) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(v);
    final Version _result;
    synchronized (_createCache_toVersion) {
      if (_createCache_toVersion.containsKey(_cacheKey)) {
        return _createCache_toVersion.get(_cacheKey);
      }
      Version _createVersion = this.dslFactory.createVersion();
      _result = _createVersion;
      _createCache_toVersion.put(_cacheKey, _result);
    }
    _init_toVersion(_result, v);
    return _result;
  }
  
  private final HashMap<ArrayList<? extends Object>,Version> _createCache_toVersion = CollectionLiterals.newHashMap();
  
  private void _init_toVersion(final Version it, final String v) {
    it.setVersion(v);
  }
  
  public String toVersionNumber(final Object v) {
    if (v instanceof Integer) {
      return _toVersionNumber((Integer)v);
    } else if (v instanceof Version) {
      return _toVersionNumber((Version)v);
    } else if (v instanceof String) {
      return _toVersionNumber((String)v);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v).toString());
    }
  }
  
  public String toMajorVersionNumber(final Object v) {
    if (v instanceof Integer) {
      return _toMajorVersionNumber((Integer)v);
    } else if (v instanceof Version) {
      return _toMajorVersionNumber((Version)v);
    } else if (v instanceof String) {
      return _toMajorVersionNumber((String)v);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v).toString());
    }
  }
  
  public String toVersionPostfix(final Object v) {
    if (v instanceof Integer) {
      return _toVersionPostfix((Integer)v);
    } else if (v instanceof Version) {
      return _toVersionPostfix((Version)v);
    } else if (v instanceof String) {
      return _toVersionPostfix((String)v);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v).toString());
    }
  }
}
