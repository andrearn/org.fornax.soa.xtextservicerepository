package org.fornax.soa.profiledsl.query.type;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.basedsl.sOABaseDsl.AbstractType;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.version.VersionMatcher;
import org.fornax.soa.profiledsl.query.namespace.TechnicalNamespaceQueries;
import org.fornax.soa.profiledsl.sOAProfileDsl.AttributeDataTypeRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.DataType;
import org.fornax.soa.profiledsl.sOAProfileDsl.DataTypeRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace;
import org.fornax.soa.profiledsl.sOAProfileDsl.Type;
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType;
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedTypeRef;
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher;

@SuppressWarnings("all")
public class LatestMatchingTypeFinder {
  @Inject
  private VersionMatcher _versionMatcher;
  
  @Inject
  private IStateMatcher _iStateMatcher;
  
  @Inject
  private TechnicalNamespaceQueries _technicalNamespaceQueries;
  
  protected VersionedType _selectLatestMatchingType(final VersionedTypeRef ref) {
    VersionedType _type = ref.getType();
    return _type;
  }
  
  /**
   * Checks if type declaration is the latest version matching the following constraint
   * 		- same major version
   */
  protected boolean _isLatestMatchingType(final VersionedType t, final Integer majorVersion) {
    EObject _eContainer = t.eContainer();
    EList<Type> _types = ((TechnicalNamespace) _eContainer).getTypes();
    Iterable<VersionedType> _filter = Iterables.<VersionedType>filter(_types, VersionedType.class);
    final Function1<VersionedType,Boolean> _function = new Function1<VersionedType,Boolean>() {
        public Boolean apply(final VersionedType e) {
          String _name = e.getName();
          String _name_1 = t.getName();
          boolean _equals = Objects.equal(_name, _name_1);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<VersionedType> _filter_1 = IterableExtensions.<VersionedType>filter(_filter, _function);
    List<VersionedType> _list = IterableExtensions.<VersionedType>toList(_filter_1);
    Type _findLatestMatchingVersionedTypeFromProfile = this.findLatestMatchingVersionedTypeFromProfile(_list, majorVersion);
    boolean _equals = Objects.equal(_findLatestMatchingVersionedTypeFromProfile, t);
    return _equals;
  }
  
  /**
   * Checks if type declaration is the latest version matching the following constraint
   * 		- same major version
   *      - matches a given minimal lifecycle state
   */
  private Type _findLatestMatchingVersionedTypeFromProfile(final List<VersionedType> types, final Integer majorVersion) {
    final Function1<VersionedType,Boolean> _function = new Function1<VersionedType,Boolean>() {
        public Boolean apply(final VersionedType e) {
          Version _version = e.getVersion();
          boolean _versionMatches = LatestMatchingTypeFinder.this._versionMatcher.versionMatches(_version, majorVersion);
          return Boolean.valueOf(_versionMatches);
        }
      };
    Iterable<VersionedType> _filter = IterableExtensions.<VersionedType>filter(types, _function);
    final Function1<VersionedType,String> _function_1 = new Function1<VersionedType,String>() {
        public String apply(final VersionedType e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          return _version_1;
        }
      };
    List<VersionedType> _sortBy = IterableExtensions.<VersionedType, String>sortBy(_filter, _function_1);
    VersionedType _last = IterableExtensions.<VersionedType>last(_sortBy);
    return _last;
  }
  
  /**
   * Type reference resolution
   * 		find the lastest type declaration matching
   *  	- the version constraint defined in the reference
   */
  protected Type _findLatestMatchingType(final DataTypeRef t) {
    DataType _type = t.getType();
    return _type;
  }
  
  protected Type _findLatestMatchingType(final AttributeDataTypeRef t) {
    DataType _type = t.getType();
    return _type;
  }
  
  protected Type _findLatestMatchingType(final DataTypeRef t, final LifecycleState minState) {
    DataType _type = t.getType();
    return _type;
  }
  
  protected String _toTypeName(final AbstractType t) {
    String _name = t.getName();
    return _name;
  }
  
  public VersionedType selectLatestMatchingType(final VersionedTypeRef ref) {
    {
      return _selectLatestMatchingType(ref);
    }
  }
  
  public boolean isLatestMatchingType(final VersionedType t, final Integer majorVersion) {
    {
      return _isLatestMatchingType(t, majorVersion);
    }
  }
  
  private Type findLatestMatchingVersionedTypeFromProfile(final List<VersionedType> types, final Integer majorVersion) {
    {
      return _findLatestMatchingVersionedTypeFromProfile(types, majorVersion);
    }
  }
  
  public Type findLatestMatchingType(final EObject t) {
    if (t instanceof DataTypeRef) {
      return _findLatestMatchingType((DataTypeRef)t);
    } else if (t instanceof AttributeDataTypeRef) {
      return _findLatestMatchingType((AttributeDataTypeRef)t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t).toString());
    }
  }
  
  public Type findLatestMatchingType(final DataTypeRef t, final LifecycleState minState) {
    {
      return _findLatestMatchingType(t, minState);
    }
  }
  
  public String toTypeName(final AbstractType t) {
    {
      return _toTypeName(t);
    }
  }
}
