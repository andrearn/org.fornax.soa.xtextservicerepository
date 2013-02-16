package org.fornax.soa.profiledsl.query.namespace;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.fornax.soa.profiledsl.query.type.ReferencedTypesFinder;
import org.fornax.soa.profiledsl.query.type.VersionedTypeFilter;
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader;
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace;
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType;
import org.fornax.soa.profiledsl.versioning.TechnicalNamespaceSplitter;
import org.fornax.soa.profiledsl.versioning.VersionedTechnicalNamespace;

/**
 * Calculation of all VersionedTechnicalNamespaces imported by a given or derived
 * 	VersionedTechnicalNamespace. Transitive dependencies are not yet calculated
 */
@SuppressWarnings("all")
public class TechnicalNamespaceImportQueries {
  @Inject
  private VersionedTypeFilter _versionedTypeFilter;
  
  @Inject
  private ReferencedTypesFinder _referencedTypesFinder;
  
  @Inject
  private TechnicalNamespaceSplitter _technicalNamespaceSplitter;
  
  /**
   * Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
   * 	are derived from the versioned dependencies of all owned VersiondTypes, Exceptions and Service in the given
   * 	VersionedDomainNamespace. The owning VersiondDomainNamespace of the found dependencies are returned.
   */
  public Set<VersionedTechnicalNamespace> allImportedVersionedNS(final VersionedTechnicalNamespace s) {
    HashSet<VersionedTechnicalNamespace> _hashSet = new HashSet<VersionedTechnicalNamespace>();
    Set<VersionedTechnicalNamespace> _allImportedVersionedNS = this.allImportedVersionedNS(s, _hashSet);
    Iterable<VersionedTechnicalNamespace> _filter = Iterables.<VersionedTechnicalNamespace>filter(_allImportedVersionedNS, VersionedTechnicalNamespace.class);
    Set<VersionedTechnicalNamespace> _set = IterableExtensions.<VersionedTechnicalNamespace>toSet(_filter);
    return _set;
  }
  
  protected Set<VersionedTechnicalNamespace> _allImportedVersionedNS(final VersionedTechnicalNamespace s, final Set<VersionedTechnicalNamespace> visited) {
    Set<VersionedTechnicalNamespace> _xifexpression = null;
    boolean _contains = visited.contains(s);
    boolean _not = (!_contains);
    if (_not) {
      Set<VersionedTechnicalNamespace> _xblockexpression = null;
      {
        visited.add(s);
        TechnicalNamespace _namespace = s.getNamespace();
        String _version = s.getVersion();
        Set<VersionedTechnicalNamespace> _allImportedVersionedNS = this.allImportedVersionedNS(_namespace, _version);
        final Function1<VersionedTechnicalNamespace,Set<VersionedTechnicalNamespace>> _function = new Function1<VersionedTechnicalNamespace,Set<VersionedTechnicalNamespace>>() {
            public Set<VersionedTechnicalNamespace> apply(final VersionedTechnicalNamespace vns) {
              Set<VersionedTechnicalNamespace> _allImportedVersionedNS = TechnicalNamespaceImportQueries.this.allImportedVersionedNS(vns, visited);
              return _allImportedVersionedNS;
            }
          };
        Iterable<Set<VersionedTechnicalNamespace>> _map = IterableExtensions.<VersionedTechnicalNamespace, Set<VersionedTechnicalNamespace>>map(_allImportedVersionedNS, _function);
        Iterable<VersionedTechnicalNamespace> _flatten = Iterables.<VersionedTechnicalNamespace>concat(_map);
        Iterable<VersionedTechnicalNamespace> _filter = Iterables.<VersionedTechnicalNamespace>filter(_flatten, VersionedTechnicalNamespace.class);
        Set<VersionedTechnicalNamespace> _set = IterableExtensions.<VersionedTechnicalNamespace>toSet(_filter);
        _xblockexpression = (_set);
      }
      _xifexpression = _xblockexpression;
    } else {
      Iterable<VersionedTechnicalNamespace> _filter = Iterables.<VersionedTechnicalNamespace>filter(visited, VersionedTechnicalNamespace.class);
      Set<VersionedTechnicalNamespace> _set = IterableExtensions.<VersionedTechnicalNamespace>toSet(_filter);
      _xifexpression = _set;
    }
    return _xifexpression;
  }
  
  /**
   * Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
   * 	are derived from the versioned dependencies of all owned VersiondTypes in the given
   * 	TechnicalNamespace matching the given major version. The owning VersiondDomainNamespace
   * 	of the found dependencies are returned.
   */
  protected Set<VersionedTechnicalNamespace> _allImportedVersionedNS(final TechnicalNamespace s, final String nameSpaceMajorVersion) {
    List<VersionedType> _allTypesByMajorVersion = this._versionedTypeFilter.allTypesByMajorVersion(s, nameSpaceMajorVersion);
    Iterable<org.fornax.soa.profiledsl.sOAProfileDsl.Class> _filter = Iterables.<org.fornax.soa.profiledsl.sOAProfileDsl.Class>filter(_allTypesByMajorVersion, org.fornax.soa.profiledsl.sOAProfileDsl.Class.class);
    final Function1<org.fornax.soa.profiledsl.sOAProfileDsl.Class,List<VersionedType>> _function = new Function1<org.fornax.soa.profiledsl.sOAProfileDsl.Class,List<VersionedType>>() {
        public List<VersionedType> apply(final org.fornax.soa.profiledsl.sOAProfileDsl.Class e) {
          List<VersionedType> _allReferencedVersionedTypes = TechnicalNamespaceImportQueries.this._referencedTypesFinder.allReferencedVersionedTypes(e);
          return _allReferencedVersionedTypes;
        }
      };
    Iterable<List<VersionedType>> _map = IterableExtensions.<org.fornax.soa.profiledsl.sOAProfileDsl.Class, List<VersionedType>>map(_filter, _function);
    Iterable<VersionedType> _flatten = Iterables.<VersionedType>concat(_map);
    final Function1<VersionedType,VersionedTechnicalNamespace> _function_1 = new Function1<VersionedType,VersionedTechnicalNamespace>() {
        public VersionedTechnicalNamespace apply(final VersionedType v) {
          VersionedTechnicalNamespace _createVersionedTechnicalNamespace = TechnicalNamespaceImportQueries.this._technicalNamespaceSplitter.createVersionedTechnicalNamespace(v);
          return _createVersionedTechnicalNamespace;
        }
      };
    Iterable<VersionedTechnicalNamespace> _map_1 = IterableExtensions.<VersionedType, VersionedTechnicalNamespace>map(_flatten, _function_1);
    Set<VersionedTechnicalNamespace> _set = IterableExtensions.<VersionedTechnicalNamespace>toSet(_map_1);
    return _set;
  }
  
  protected Set<VersionedTechnicalNamespace> _allImportedVersionedNS(final MessageHeader t, final String nameSpaceMajorVersion) {
    List<VersionedType> _allReferencedVersionedTypes = this._referencedTypesFinder.allReferencedVersionedTypes(t);
    final Function1<VersionedType,VersionedTechnicalNamespace> _function = new Function1<VersionedType,VersionedTechnicalNamespace>() {
        public VersionedTechnicalNamespace apply(final VersionedType e) {
          VersionedTechnicalNamespace _createVersionedTechnicalNamespace = TechnicalNamespaceImportQueries.this._technicalNamespaceSplitter.createVersionedTechnicalNamespace(e);
          return _createVersionedTechnicalNamespace;
        }
      };
    List<VersionedTechnicalNamespace> _map = ListExtensions.<VersionedType, VersionedTechnicalNamespace>map(_allReferencedVersionedTypes, _function);
    Set<VersionedTechnicalNamespace> _set = IterableExtensions.<VersionedTechnicalNamespace>toSet(_map);
    return _set;
  }
  
  /**
   * Find all imported VersionedDomainSpaces, i.e. major version filtered slices of SubNamespaces. VersionedDomainNamespaces
   * 	are derived from the versioned dependencies of all owned VersiondTypes in the given
   * 	TechnicalNamespace matching the given major version. The owning VersiondDomainNamespace
   * 	of the found dependencies are returned.
   */
  protected Set<VersionedTechnicalNamespace> _importedVersionedNS(final TechnicalNamespace s, final String nameSpaceMajorVersion) {
    List<VersionedType> _allTypesByMajorVersion = this._versionedTypeFilter.allTypesByMajorVersion(s, nameSpaceMajorVersion);
    Iterable<org.fornax.soa.profiledsl.sOAProfileDsl.Class> _filter = Iterables.<org.fornax.soa.profiledsl.sOAProfileDsl.Class>filter(_allTypesByMajorVersion, org.fornax.soa.profiledsl.sOAProfileDsl.Class.class);
    final Function1<org.fornax.soa.profiledsl.sOAProfileDsl.Class,List<VersionedType>> _function = new Function1<org.fornax.soa.profiledsl.sOAProfileDsl.Class,List<VersionedType>>() {
        public List<VersionedType> apply(final org.fornax.soa.profiledsl.sOAProfileDsl.Class e) {
          List<VersionedType> _allReferencedVersionedTypes = TechnicalNamespaceImportQueries.this._referencedTypesFinder.allReferencedVersionedTypes(e);
          return _allReferencedVersionedTypes;
        }
      };
    Iterable<List<VersionedType>> _map = IterableExtensions.<org.fornax.soa.profiledsl.sOAProfileDsl.Class, List<VersionedType>>map(_filter, _function);
    Iterable<VersionedType> _flatten = Iterables.<VersionedType>concat(_map);
    final Function1<VersionedType,VersionedTechnicalNamespace> _function_1 = new Function1<VersionedType,VersionedTechnicalNamespace>() {
        public VersionedTechnicalNamespace apply(final VersionedType v) {
          VersionedTechnicalNamespace _createVersionedTechnicalNamespace = TechnicalNamespaceImportQueries.this._technicalNamespaceSplitter.createVersionedTechnicalNamespace(v);
          return _createVersionedTechnicalNamespace;
        }
      };
    Iterable<VersionedTechnicalNamespace> _map_1 = IterableExtensions.<VersionedType, VersionedTechnicalNamespace>map(_flatten, _function_1);
    Set<VersionedTechnicalNamespace> _set = IterableExtensions.<VersionedTechnicalNamespace>toSet(_map_1);
    return _set;
  }
  
  public Set<VersionedTechnicalNamespace> allImportedVersionedNS(final Object t, final Object nameSpaceMajorVersion) {
    if (t instanceof MessageHeader
         && nameSpaceMajorVersion instanceof String) {
      return _allImportedVersionedNS((MessageHeader)t, (String)nameSpaceMajorVersion);
    } else if (t instanceof TechnicalNamespace
         && nameSpaceMajorVersion instanceof String) {
      return _allImportedVersionedNS((TechnicalNamespace)t, (String)nameSpaceMajorVersion);
    } else if (t instanceof VersionedTechnicalNamespace
         && nameSpaceMajorVersion instanceof Set) {
      return _allImportedVersionedNS((VersionedTechnicalNamespace)t, (Set<VersionedTechnicalNamespace>)nameSpaceMajorVersion);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t, nameSpaceMajorVersion).toString());
    }
  }
  
  public Set<VersionedTechnicalNamespace> importedVersionedNS(final TechnicalNamespace s, final String nameSpaceMajorVersion) {
    {
      return _importedVersionedNS(s, nameSpaceMajorVersion);
    }
  }
}
