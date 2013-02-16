package org.fornax.soa.profiledsl.query.type;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.version.VersionMatcher;
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace;
import org.fornax.soa.profiledsl.sOAProfileDsl.Type;
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType;

@SuppressWarnings("all")
public class VersionedTypeFilter {
  @Inject
  private VersionMatcher _versionMatcher;
  
  protected List<VersionedType> _allTypesByMajorVersion(final TechnicalNamespace s, final String majorVersion) {
    EList<Type> _types = s.getTypes();
    Iterable<VersionedType> _filter = Iterables.<VersionedType>filter(_types, VersionedType.class);
    final Function1<VersionedType,Boolean> _function = new Function1<VersionedType,Boolean>() {
        public Boolean apply(final VersionedType t) {
          Version _version = t.getVersion();
          boolean _matchesMajorVersion = VersionedTypeFilter.this._versionMatcher.matchesMajorVersion(_version, majorVersion);
          return Boolean.valueOf(_matchesMajorVersion);
        }
      };
    Iterable<VersionedType> _filter_1 = IterableExtensions.<VersionedType>filter(_filter, _function);
    List<VersionedType> _list = IterableExtensions.<VersionedType>toList(_filter_1);
    return _list;
  }
  
  public List<VersionedType> allTypesByMajorVersion(final TechnicalNamespace s, final String majorVersion) {
    {
      return _allTypesByMajorVersion(s, majorVersion);
    }
  }
}
