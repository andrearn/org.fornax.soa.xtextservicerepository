package org.fornax.soa.servicedsl.generator.templates.xsd;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.fornax.soa.basedsl.CommonEObjectExtensions;
import org.fornax.soa.basedsl.CommonStringExtensions;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.version.VersionQualifierExtensions;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace;
import org.fornax.soa.service.VersionedDomainNamespace;
import org.fornax.soa.service.query.ExceptionFinder;
import org.fornax.soa.service.query.ServiceQueries;
import org.fornax.soa.service.query.namespace.NamespaceQuery;
import org.fornax.soa.service.query.type.TypesByLifecycleStateFinder;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.BusinessObjectRef;
import org.fornax.soa.serviceDsl.DomainNamespace;
import org.fornax.soa.serviceDsl.EnumTypeRef;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.serviceDsl.InternalNamespace;
import org.fornax.soa.serviceDsl.OrganizationNamespace;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.ServiceModel;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.Type;

/**
 * domains.ext
 */
@SuppressWarnings("all")
public class SchemaNamespaceExtensions {
  @Inject
  private CommonEObjectExtensions _commonEObjectExtensions;
  
  @Inject
  private CommonStringExtensions _commonStringExtensions;
  
  @Inject
  private VersionQualifierExtensions versionQualifier;
  
  @Inject
  private NamespaceQuery _namespaceQuery;
  
  @Inject
  private TypesByLifecycleStateFinder _typesByLifecycleStateFinder;
  
  @Inject
  private ServiceQueries _serviceQueries;
  
  @Inject
  private ExceptionFinder _exceptionFinder;
  
  @Inject
  @Named(value = "forceRelativePaths")
  private Boolean forceRelativePaths;
  
  @Inject
  @Named(value = "useNestedPaths")
  private Boolean useNestedPaths;
  
  @Inject
  private IQualifiedNameProvider nameProvider;
  
  public boolean forceRelativePaths() {
    return (this.forceRelativePaths).booleanValue();
  }
  
  protected String _toUnversionedNamespace(final Object o) {
    return "unknown";
  }
  
  protected String _fqn(final SubNamespace s) {
    OrganizationNamespace _findOrgNamespace = this._namespaceQuery.findOrgNamespace(s);
    String _name = ((OrganizationNamespace) _findOrgNamespace).getName();
    String _stripXtextEscapes = this._commonStringExtensions.stripXtextEscapes(_name);
    String _plus = (_stripXtextEscapes + ".");
    ArrayList<SubNamespace> _newArrayList = CollectionLiterals.<SubNamespace>newArrayList(s);
    List<SubNamespace> _subNamespacePath = this.toSubNamespacePath(_newArrayList);
    final Function1<SubNamespace,String> _function = new Function1<SubNamespace,String>() {
        public String apply(final SubNamespace n) {
          String _name = n.getName();
          String _stripXtextEscapes = SchemaNamespaceExtensions.this._commonStringExtensions.stripXtextEscapes(_name);
          return _stripXtextEscapes;
        }
      };
    List<String> _map = ListExtensions.<SubNamespace, String>map(_subNamespacePath, _function);
    String _join = IterableExtensions.join(_map, ".");
    String _plus_1 = (_plus + _join);
    return _plus_1;
  }
  
  protected String _toNamespace(final EObject o) {
    return null;
  }
  
  protected String _toNamespace(final OrganizationNamespace domain) {
    String _unversionedNamespace = this.toUnversionedNamespace(domain);
    String _plus = (_unversionedNamespace + "/");
    String _versionPostfix = this.toVersionPostfix(domain);
    String ns = (_plus + _versionPostfix);
    boolean _hasTrailingSlash = this.hasTrailingSlash(domain);
    if (_hasTrailingSlash) {
      return (ns + "/");
    } else {
      return (ns + "");
    }
  }
  
  protected String _toNamespace(final SubNamespace leafDomainNamespace) {
    String _unversionedNamespace = this.toUnversionedNamespace(leafDomainNamespace);
    String _plus = (_unversionedNamespace + "/");
    String _versionPostfix = this.toVersionPostfix(leafDomainNamespace);
    String ns = (_plus + _versionPostfix);
    boolean _hasTrailingSlash = this.hasTrailingSlash(leafDomainNamespace);
    if (_hasTrailingSlash) {
      return (ns + "/");
    } else {
      return (ns + "");
    }
  }
  
  protected String _toNamespace(final VersionedDomainNamespace s) {
    EObject _subdomain = s.getSubdomain();
    String _unversionedNamespace = this.toUnversionedNamespace(_subdomain);
    String _stripXtextEscapes = this._commonStringExtensions.stripXtextEscapes(_unversionedNamespace);
    String _plus = (_stripXtextEscapes + "/");
    String _versionPostfix = this.toVersionPostfix(s);
    String ns = (_plus + _versionPostfix);
    EObject _subdomain_1 = s.getSubdomain();
    boolean _hasTrailingSlash = this.hasTrailingSlash(_subdomain_1);
    if (_hasTrailingSlash) {
      return (ns + "/");
    } else {
      return (ns + "");
    }
  }
  
  protected boolean _hasTrailingSlash(final Object o) {
    return true;
  }
  
  protected String _toVersionPostfix(final Object o) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException();
    throw _unsupportedOperationException;
  }
  
  protected String _toVersionPostfix(final Version v) {
    String _versionPostfix = this.versionQualifier.toVersionPostfix(v);
    return _versionPostfix;
  }
  
  protected String _toVersionPostfix(final OrganizationNamespace d) {
    String _defaultVersionPostfix = this.versionQualifier.toDefaultVersionPostfix();
    return _defaultVersionPostfix;
  }
  
  protected String _toVersionPostfix(final DomainNamespace s) {
    String _xifexpression = null;
    boolean _and = false;
    Version _version = s.getVersion();
    boolean _notEquals = (!Objects.equal(_version, null));
    if (!_notEquals) {
      _and = false;
    } else {
      Version _version_1 = s.getVersion();
      String _version_2 = _version_1.getVersion();
      boolean _notEquals_1 = (!Objects.equal(_version_2, null));
      _and = (_notEquals && _notEquals_1);
    }
    if (_and) {
      Version _version_3 = s.getVersion();
      String _versionPostfix = this.versionQualifier.toVersionPostfix(_version_3);
      _xifexpression = _versionPostfix;
    } else {
      String _defaultVersionPostfix = this.versionQualifier.toDefaultVersionPostfix();
      _xifexpression = _defaultVersionPostfix;
    }
    return _xifexpression;
  }
  
  protected String _toVersionPostfix(final VersionedDomainNamespace s) {
    String _xifexpression = null;
    String _version = s.getVersion();
    boolean _notEquals = (!Objects.equal(_version, null));
    if (_notEquals) {
      String _version_1 = s.getVersion();
      String _versionPostfix = this.versionQualifier.toVersionPostfix(_version_1);
      _xifexpression = _versionPostfix;
    } else {
      String _defaultVersionPostfix = this.versionQualifier.toDefaultVersionPostfix();
      _xifexpression = _defaultVersionPostfix;
    }
    return _xifexpression;
  }
  
  protected String _toUnversionedNamespace(final OrganizationNamespace domain) {
    String _name = domain.getName();
    String[] _split = _name.split(".");
    List<String> _reverse = ListExtensions.<String>reverse(((List<String>)Conversions.doWrapArray(_split)));
    String _join = IterableExtensions.join(_reverse, ".");
    String _plus = ("http://" + _join);
    return _plus;
  }
  
  protected String _toUnversionedNamespace(final SubNamespace leafDomainNamespace) {
    OrganizationNamespace _findOrgNamespace = this._namespaceQuery.findOrgNamespace(leafDomainNamespace);
    String _hostPart = this.toHostPart(_findOrgNamespace);
    String _plus = ("http://" + _hostPart);
    String _plus_1 = (_plus + "/");
    ArrayList<SubNamespace> _newArrayList = CollectionLiterals.<SubNamespace>newArrayList(leafDomainNamespace);
    List<SubNamespace> _subNamespacePath = this.toSubNamespacePath(_newArrayList);
    final Function1<SubNamespace,String> _function = new Function1<SubNamespace,String>() {
        public String apply(final SubNamespace n) {
          String _name = n.getName();
          String _stripXtextEscapes = SchemaNamespaceExtensions.this._commonStringExtensions.stripXtextEscapes(_name);
          String _replaceAll = _stripXtextEscapes.replaceAll("\\.", "/");
          return _replaceAll;
        }
      };
    List<String> _map = ListExtensions.<SubNamespace, String>map(_subNamespacePath, _function);
    String _join = IterableExtensions.join(_map, "/");
    String _plus_2 = (_plus_1 + _join);
    return _plus_2;
  }
  
  protected String _toUnversionedNamespace(final VersionedDomainNamespace s) {
    EObject _subdomain = s.getSubdomain();
    String _unversionedNamespace = this.toUnversionedNamespace(_subdomain);
    return _unversionedNamespace;
  }
  
  protected String _toHostPart(final OrganizationNamespace d) {
    String _name = d.getName();
    String[] _split = _name.split("\\.");
    List<String> _reverse = ListExtensions.<String>reverse(((List<String>)Conversions.doWrapArray(_split)));
    String _join = IterableExtensions.join(_reverse, ".");
    return _join;
  }
  
  public List<SubNamespace> toSubNamespacePath(final List<SubNamespace> domList) {
    SubNamespace _last = IterableExtensions.<SubNamespace>last(domList);
    EObject _eContainer = _last==null?(EObject)null:_last.eContainer();
    if ((_eContainer instanceof SubNamespace)) {
      SubNamespace _last_1 = IterableExtensions.<SubNamespace>last(domList);
      EObject _eContainer_1 = _last_1.eContainer();
      domList.add(((SubNamespace) _eContainer_1));
      this.toSubNamespacePath(domList);
      return domList;
    } else {
      Iterable<SubNamespace> _filter = Iterables.<SubNamespace>filter(domList, SubNamespace.class);
      List<SubNamespace> _list = IterableExtensions.<SubNamespace>toList(_filter);
      return ListExtensions.<SubNamespace>reverse(_list);
    }
  }
  
  /**
   * List[sOAProfileDsl::TechnicalNamespace] getNamespacePath (List[SubNamespace] nsList) :
   * SubNamespace.isInstance(nsList.last().eContainer) ?
   * getNamespacePath (nsList.add ((SubNamespace)nsList.last().eContainer) -> nsList)
   * :
   * nsList.typeSelect(SubNamespace).reverse();
   */
  protected String _toShortName(final SubNamespace s) {
    String _xifexpression = null;
    String _prefix = s.getPrefix();
    boolean _equals = Objects.equal(_prefix, null);
    if (_equals) {
      String _prefix_1 = this.toPrefix(s);
      _xifexpression = _prefix_1;
    } else {
      String _prefix_2 = s.getPrefix();
      _xifexpression = _prefix_2;
    }
    return _xifexpression;
  }
  
  protected String _toShortName(final TechnicalNamespace s) {
    String _xifexpression = null;
    String _prefix = s.getPrefix();
    boolean _equals = Objects.equal(_prefix, null);
    if (_equals) {
      String _prefix_1 = this.toPrefix(s);
      _xifexpression = _prefix_1;
    } else {
      String _prefix_2 = s.getPrefix();
      _xifexpression = _prefix_2;
    }
    return _xifexpression;
  }
  
  protected String _toRegistryAssetUrl(final Service s, final String registryUrl) {
    String _xifexpression = null;
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(registryUrl, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _forceRelativePaths = this.forceRelativePaths();
      boolean _not = (!_forceRelativePaths);
      _and = (_notEquals && _not);
    }
    if (_and) {
      String _plus = (registryUrl + "/");
      String _fileNameFragment = this.toFileNameFragment(s);
      String _plus_1 = (_plus + _fileNameFragment);
      _xifexpression = _plus_1;
    } else {
      String _fileNameFragment_1 = this.toFileNameFragment(s);
      _xifexpression = _fileNameFragment_1;
    }
    return _xifexpression;
  }
  
  protected String _toRegistryAssetUrl(final OrganizationNamespace s, final String registryUrl) {
    String _xifexpression = null;
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(registryUrl, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _forceRelativePaths = this.forceRelativePaths();
      boolean _not = (!_forceRelativePaths);
      _and = (_notEquals && _not);
    }
    if (_and) {
      String _plus = (registryUrl + "/");
      String _fileNameFragment = this.toFileNameFragment(s);
      String _plus_1 = (_plus + _fileNameFragment);
      _xifexpression = _plus_1;
    } else {
      String _fileNameFragment_1 = this.toFileNameFragment(s);
      _xifexpression = _fileNameFragment_1;
    }
    return _xifexpression;
  }
  
  protected String _toRegistryAssetUrl(final DomainNamespace s, final String registryUrl) {
    String _xifexpression = null;
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(registryUrl, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _forceRelativePaths = this.forceRelativePaths();
      boolean _not = (!_forceRelativePaths);
      _and = (_notEquals && _not);
    }
    if (_and) {
      String _plus = (registryUrl + "/");
      String _fileNameFragment = this.toFileNameFragment(s);
      String _plus_1 = (_plus + _fileNameFragment);
      _xifexpression = _plus_1;
    } else {
      String _fileNameFragment_1 = this.toFileNameFragment(s);
      _xifexpression = _fileNameFragment_1;
    }
    return _xifexpression;
  }
  
  protected String _toRegistryAssetUrl(final InternalNamespace s, final String registryUrl) {
    String _xifexpression = null;
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(registryUrl, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _forceRelativePaths = this.forceRelativePaths();
      boolean _not = (!_forceRelativePaths);
      _and = (_notEquals && _not);
    }
    if (_and) {
      String _plus = (registryUrl + "/");
      String _fileNameFragment = this.toFileNameFragment(s);
      String _plus_1 = (_plus + _fileNameFragment);
      _xifexpression = _plus_1;
    } else {
      String _fileNameFragment_1 = this.toFileNameFragment(s);
      _xifexpression = _fileNameFragment_1;
    }
    return _xifexpression;
  }
  
  protected String _toRegistryAssetUrl(final VersionedDomainNamespace s, final String registryUrl) {
    String _xifexpression = null;
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(registryUrl, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _forceRelativePaths = this.forceRelativePaths();
      boolean _not = (!_forceRelativePaths);
      _and = (_notEquals && _not);
    }
    if (_and) {
      String _plus = (registryUrl + "/");
      String _fileNameFragment = this.toFileNameFragment(s);
      String _plus_1 = (_plus + _fileNameFragment);
      _xifexpression = _plus_1;
    } else {
      String _fileNameFragment_1 = this.toFileNameFragment(s);
      _xifexpression = _fileNameFragment_1;
    }
    return _xifexpression;
  }
  
  protected String _toRegistryAssetUrl(final EObject o, final Void registryUrl) {
    return null;
  }
  
  protected String _toRegistryAssetUrl(final Service s, final Void registryUrl) {
    String _fileNameFragment = this.toFileNameFragment(s);
    return _fileNameFragment;
  }
  
  protected String _toRegistryAssetUrl(final OrganizationNamespace s, final Void registryUrl) {
    String _fileNameFragment = this.toFileNameFragment(s);
    return _fileNameFragment;
  }
  
  protected String _toRegistryAssetUrl(final DomainNamespace s, final Void registryUrl) {
    String _fileNameFragment = this.toFileNameFragment(s);
    return _fileNameFragment;
  }
  
  protected String _toRegistryAssetUrl(final InternalNamespace s, final Void registryUrl) {
    String _fileNameFragment = this.toFileNameFragment(s);
    return _fileNameFragment;
  }
  
  protected String _toRegistryAssetUrl(final VersionedDomainNamespace s, final Void registryUrl) {
    String _fileNameFragment = this.toFileNameFragment(s);
    return _fileNameFragment;
  }
  
  protected String _toFileNameFragment(final EObject s) {
    return null;
  }
  
  protected String _toFileNameFragment(final Service s) {
    EObject _eContainer = s.eContainer();
    String _fileNameFragment = this.toFileNameFragment(_eContainer);
    String _replaceAll = _fileNameFragment.replaceAll("\\.", "-");
    String _plus = (_replaceAll + "-");
    String _name = s.getName();
    String _stripXtextEscapes = this._commonStringExtensions.stripXtextEscapes(_name);
    String _plus_1 = (_plus + _stripXtextEscapes);
    String _plus_2 = (_plus_1 + "-");
    Version _version = s.getVersion();
    String _versionPostfix = this.toVersionPostfix(_version);
    String _plus_3 = (_plus_2 + _versionPostfix);
    return _plus_3;
  }
  
  protected String _toFileNameFragment(final OrganizationNamespace s) {
    OrganizationNamespace _findOrgNamespace = this._namespaceQuery.findOrgNamespace(s);
    String _prefix = this.toPrefix(_findOrgNamespace);
    String _replaceAll = _prefix.replaceAll("\\.", "-");
    return _replaceAll;
  }
  
  protected String _toFileNameFragment(final DomainNamespace s) {
    String _xblockexpression = null;
    {
      ArrayList<SubNamespace> _arrayList = new ArrayList<SubNamespace>();
      final ArrayList<SubNamespace> namespaces = _arrayList;
      namespaces.add(s);
      OrganizationNamespace _findOrgNamespace = this._namespaceQuery.findOrgNamespace(s);
      String _prefix = this.toPrefix(_findOrgNamespace);
      String _replaceAll = _prefix.replaceAll("\\.", "-");
      String _plus = (_replaceAll + "-");
      List<SubNamespace> _subNamespacePath = this.toSubNamespacePath(namespaces);
      final Function1<SubNamespace,String> _function = new Function1<SubNamespace,String>() {
          public String apply(final SubNamespace n) {
            String _name = n.getName();
            String _stripXtextEscapes = SchemaNamespaceExtensions.this._commonStringExtensions.stripXtextEscapes(_name);
            String _replaceAll = _stripXtextEscapes.replaceAll("\\.", "-");
            return _replaceAll;
          }
        };
      List<String> _map = ListExtensions.<SubNamespace, String>map(_subNamespacePath, _function);
      String _join = IterableExtensions.join(_map, "-");
      String _plus_1 = (_plus + _join);
      _xblockexpression = (_plus_1);
    }
    return _xblockexpression;
  }
  
  protected String _toFileNameFragment(final InternalNamespace s) {
    String _xblockexpression = null;
    {
      ArrayList<SubNamespace> _arrayList = new ArrayList<SubNamespace>();
      final ArrayList<SubNamespace> namespaces = _arrayList;
      namespaces.add(s);
      OrganizationNamespace _findOrgNamespace = this._namespaceQuery.findOrgNamespace(s);
      String _prefix = this.toPrefix(_findOrgNamespace);
      String _replaceAll = _prefix.replaceAll("\\.", "-");
      String _plus = (_replaceAll + "-");
      List<SubNamespace> _subNamespacePath = this.toSubNamespacePath(namespaces);
      final Function1<SubNamespace,String> _function = new Function1<SubNamespace,String>() {
          public String apply(final SubNamespace n) {
            String _name = n.getName();
            String _stripXtextEscapes = SchemaNamespaceExtensions.this._commonStringExtensions.stripXtextEscapes(_name);
            String _replaceAll = _stripXtextEscapes.replaceAll("\\.", "-");
            return _replaceAll;
          }
        };
      List<String> _map = ListExtensions.<SubNamespace, String>map(_subNamespacePath, _function);
      String _join = IterableExtensions.join(_map, "-");
      String _plus_1 = (_plus + _join);
      _xblockexpression = (_plus_1);
    }
    return _xblockexpression;
  }
  
  protected String _toFileNameFragment(final VersionedDomainNamespace s) {
    EObject _subdomain = s.getSubdomain();
    String _fileNameFragment = this.toFileNameFragment(_subdomain);
    String _plus = (_fileNameFragment + "-v");
    String _version = s.getVersion();
    String _majorVersionNumber = this.versionQualifier.toMajorVersionNumber(_version);
    String _plus_1 = (_plus + _majorVersionNumber);
    return _plus_1;
  }
  
  protected String _toShortName(final OrganizationNamespace d) {
    String _xifexpression = null;
    String _prefix = d.getPrefix();
    boolean _notEquals = (!Objects.equal(_prefix, null));
    if (_notEquals) {
      String _prefix_1 = d.getPrefix();
      _xifexpression = _prefix_1;
    } else {
      String _name = d.getName();
      _xifexpression = _name;
    }
    return _xifexpression;
  }
  
  /**
   * XML Namespace prefixes / aliases
   */
  protected String _toPrefix(final EObject o) {
    return "tns";
  }
  
  protected String _toPrefix(final OrganizationNamespace o) {
    String _xifexpression = null;
    String _prefix = o.getPrefix();
    boolean _notEquals = (!Objects.equal(_prefix, null));
    if (_notEquals) {
      String _prefix_1 = o.getPrefix();
      _xifexpression = _prefix_1;
    } else {
      QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(o);
      List<String> _segments = _fullyQualifiedName.getSegments();
      final Function1<String,String> _function = new Function1<String,String>() {
          public String apply(final String e) {
            String _substring = e.substring(0, 1);
            return _substring;
          }
        };
      List<String> _map = ListExtensions.<String, String>map(_segments, _function);
      String _join = IterableExtensions.join(_map);
      _xifexpression = _join;
    }
    return _xifexpression;
  }
  
  protected String _toPrefix(final SubNamespace s) {
    String _xifexpression = null;
    String _prefix = s.getPrefix();
    boolean _notEquals = (!Objects.equal(_prefix, null));
    if (_notEquals) {
      String _prefix_1 = s.getPrefix();
      _xifexpression = _prefix_1;
    } else {
      QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(s);
      List<String> _segments = _fullyQualifiedName.getSegments();
      final Function1<String,String> _function = new Function1<String,String>() {
          public String apply(final String e) {
            String _substring = e.substring(0, 1);
            return _substring;
          }
        };
      List<String> _map = ListExtensions.<String, String>map(_segments, _function);
      String _join = IterableExtensions.join(_map);
      _xifexpression = _join;
    }
    return _xifexpression;
  }
  
  protected String _toPrefix(final VersionedDomainNamespace s) {
    String _xifexpression = null;
    String _shortName = s.getShortName();
    boolean _notEquals = (!Objects.equal(_shortName, null));
    if (_notEquals) {
      String _shortName_1 = s.getShortName();
      _xifexpression = _shortName_1;
    } else {
      EObject _subdomain = s.getSubdomain();
      QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(((EObject) _subdomain));
      List<String> _segments = _fullyQualifiedName.getSegments();
      final Function1<String,String> _function = new Function1<String,String>() {
          public String apply(final String e) {
            String _substring = e.substring(0, 1);
            return _substring;
          }
        };
      List<String> _map = ListExtensions.<String, String>map(_segments, _function);
      String _join = IterableExtensions.join(_map);
      _xifexpression = _join;
    }
    return _xifexpression;
  }
  
  public List<ServiceModel> getAllServiceModels(final ServiceModel m) {
    Set<ServiceModel> models = CollectionLiterals.<ServiceModel>newHashSet(m);
    TreeIterator<EObject> eAllContIt = m.eAllContents();
    boolean _hasNext = eAllContIt.hasNext();
    boolean _while = _hasNext;
    while (_while) {
      {
        EObject o = eAllContIt.next();
        boolean _and = false;
        if (!(o instanceof BusinessObjectRef)) {
          _and = false;
        } else {
          BusinessObject _type = ((BusinessObjectRef) o).getType();
          EObject _eRootContainer = this._commonEObjectExtensions.eRootContainer(_type);
          _and = ((o instanceof BusinessObjectRef) && (_eRootContainer instanceof ServiceModel));
        }
        if (_and) {
          models.add(((ServiceModel) o));
        } else {
          boolean _and_1 = false;
          if (!(o instanceof EnumTypeRef)) {
            _and_1 = false;
          } else {
            Enumeration _type_1 = ((EnumTypeRef) o).getType();
            EObject _eRootContainer_1 = this._commonEObjectExtensions.eRootContainer(_type_1);
            _and_1 = ((o instanceof EnumTypeRef) && (_eRootContainer_1 instanceof ServiceModel));
          }
          if (_and_1) {
            models.add(((ServiceModel) o));
          }
        }
      }
      boolean _hasNext_1 = eAllContIt.hasNext();
      _while = _hasNext_1;
    }
    final List<ServiceModel> result = IterableExtensions.<ServiceModel>toList(models);
    return result;
  }
  
  protected boolean _hasTypesInMinState(final SubNamespace ns, final LifecycleState state) {
    List<Type> _typesWithMinState = this._typesByLifecycleStateFinder.typesWithMinState(ns, state);
    int _size = _typesWithMinState.size();
    boolean _greaterThan = (_size > 0);
    return _greaterThan;
  }
  
  protected boolean _hasServicesInMinState(final SubNamespace ns, final LifecycleState state) {
    List _servicesWithMinState = this._serviceQueries.servicesWithMinState(ns, state);
    int _size = _servicesWithMinState.size();
    boolean _greaterThan = (_size > 0);
    return _greaterThan;
  }
  
  protected boolean _hasExceptionsInMinState(final SubNamespace ns, final LifecycleState state) {
    List _exceptionsWithMinState = this._exceptionFinder.exceptionsWithMinState(ns, state);
    int _size = _exceptionsWithMinState.size();
    boolean _greaterThan = (_size > 0);
    return _greaterThan;
  }
  
  protected boolean _hasTypesInMinState(final VersionedDomainNamespace ns, final LifecycleState state) {
    List<Type> _typesWithMinState = this._typesByLifecycleStateFinder.typesWithMinState(ns, state);
    int _size = _typesWithMinState.size();
    boolean _greaterThan = (_size > 0);
    return _greaterThan;
  }
  
  protected boolean _hasServicesInMinState(final VersionedDomainNamespace ns, final LifecycleState state) {
    List _servicesWithMinState = this._serviceQueries.servicesWithMinState(ns, state);
    int _size = _servicesWithMinState.size();
    boolean _greaterThan = (_size > 0);
    return _greaterThan;
  }
  
  protected boolean _hasExceptionsInMinState(final VersionedDomainNamespace ns, final LifecycleState state) {
    List _exceptionsWithMinState = this._exceptionFinder.exceptionsWithMinState(ns, state);
    int _size = _exceptionsWithMinState.size();
    boolean _greaterThan = (_size > 0);
    return _greaterThan;
  }
  
  public String toUnversionedNamespace(final Object domain) {
    if (domain instanceof OrganizationNamespace) {
      return _toUnversionedNamespace((OrganizationNamespace)domain);
    } else if (domain instanceof SubNamespace) {
      return _toUnversionedNamespace((SubNamespace)domain);
    } else if (domain instanceof VersionedDomainNamespace) {
      return _toUnversionedNamespace((VersionedDomainNamespace)domain);
    } else if (domain != null) {
      return _toUnversionedNamespace(domain);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(domain).toString());
    }
  }
  
  public String fqn(final SubNamespace s) {
    {
      return _fqn(s);
    }
  }
  
  public String toNamespace(final Object domain) {
    if (domain instanceof OrganizationNamespace) {
      return _toNamespace((OrganizationNamespace)domain);
    } else if (domain instanceof SubNamespace) {
      return _toNamespace((SubNamespace)domain);
    } else if (domain instanceof EObject) {
      return _toNamespace((EObject)domain);
    } else if (domain instanceof VersionedDomainNamespace) {
      return _toNamespace((VersionedDomainNamespace)domain);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(domain).toString());
    }
  }
  
  public boolean hasTrailingSlash(final Object o) {
    {
      return _hasTrailingSlash(o);
    }
  }
  
  public String toVersionPostfix(final Object s) {
    if (s instanceof DomainNamespace) {
      return _toVersionPostfix((DomainNamespace)s);
    } else if (s instanceof Version) {
      return _toVersionPostfix((Version)s);
    } else if (s instanceof OrganizationNamespace) {
      return _toVersionPostfix((OrganizationNamespace)s);
    } else if (s instanceof VersionedDomainNamespace) {
      return _toVersionPostfix((VersionedDomainNamespace)s);
    } else if (s != null) {
      return _toVersionPostfix(s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s).toString());
    }
  }
  
  public String toHostPart(final OrganizationNamespace d) {
    {
      return _toHostPart(d);
    }
  }
  
  public String toShortName(final EObject s) {
    if (s instanceof TechnicalNamespace) {
      return _toShortName((TechnicalNamespace)s);
    } else if (s instanceof OrganizationNamespace) {
      return _toShortName((OrganizationNamespace)s);
    } else if (s instanceof SubNamespace) {
      return _toShortName((SubNamespace)s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s).toString());
    }
  }
  
  public String toRegistryAssetUrl(final Object s, final String registryUrl) {
    if (s instanceof DomainNamespace
         && registryUrl != null) {
      return _toRegistryAssetUrl((DomainNamespace)s, registryUrl);
    } else if (s instanceof InternalNamespace
         && registryUrl != null) {
      return _toRegistryAssetUrl((InternalNamespace)s, registryUrl);
    } else if (s instanceof DomainNamespace
         && registryUrl == null) {
      return _toRegistryAssetUrl((DomainNamespace)s, (Void)null);
    } else if (s instanceof InternalNamespace
         && registryUrl == null) {
      return _toRegistryAssetUrl((InternalNamespace)s, (Void)null);
    } else if (s instanceof OrganizationNamespace
         && registryUrl != null) {
      return _toRegistryAssetUrl((OrganizationNamespace)s, registryUrl);
    } else if (s instanceof Service
         && registryUrl != null) {
      return _toRegistryAssetUrl((Service)s, registryUrl);
    } else if (s instanceof OrganizationNamespace
         && registryUrl == null) {
      return _toRegistryAssetUrl((OrganizationNamespace)s, (Void)null);
    } else if (s instanceof Service
         && registryUrl == null) {
      return _toRegistryAssetUrl((Service)s, (Void)null);
    } else if (s instanceof EObject
         && registryUrl == null) {
      return _toRegistryAssetUrl((EObject)s, (Void)null);
    } else if (s instanceof VersionedDomainNamespace
         && registryUrl != null) {
      return _toRegistryAssetUrl((VersionedDomainNamespace)s, registryUrl);
    } else if (s instanceof VersionedDomainNamespace
         && registryUrl == null) {
      return _toRegistryAssetUrl((VersionedDomainNamespace)s, (Void)null);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s, registryUrl).toString());
    }
  }
  
  public String toFileNameFragment(final Object s) {
    if (s instanceof DomainNamespace) {
      return _toFileNameFragment((DomainNamespace)s);
    } else if (s instanceof InternalNamespace) {
      return _toFileNameFragment((InternalNamespace)s);
    } else if (s instanceof OrganizationNamespace) {
      return _toFileNameFragment((OrganizationNamespace)s);
    } else if (s instanceof Service) {
      return _toFileNameFragment((Service)s);
    } else if (s instanceof EObject) {
      return _toFileNameFragment((EObject)s);
    } else if (s instanceof VersionedDomainNamespace) {
      return _toFileNameFragment((VersionedDomainNamespace)s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s).toString());
    }
  }
  
  public String toPrefix(final Object o) {
    if (o instanceof OrganizationNamespace) {
      return _toPrefix((OrganizationNamespace)o);
    } else if (o instanceof SubNamespace) {
      return _toPrefix((SubNamespace)o);
    } else if (o instanceof EObject) {
      return _toPrefix((EObject)o);
    } else if (o instanceof VersionedDomainNamespace) {
      return _toPrefix((VersionedDomainNamespace)o);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(o).toString());
    }
  }
  
  public boolean hasTypesInMinState(final Object ns, final LifecycleState state) {
    if (ns instanceof SubNamespace) {
      return _hasTypesInMinState((SubNamespace)ns, state);
    } else if (ns instanceof VersionedDomainNamespace) {
      return _hasTypesInMinState((VersionedDomainNamespace)ns, state);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ns, state).toString());
    }
  }
  
  public boolean hasServicesInMinState(final Object ns, final LifecycleState state) {
    if (ns instanceof SubNamespace) {
      return _hasServicesInMinState((SubNamespace)ns, state);
    } else if (ns instanceof VersionedDomainNamespace) {
      return _hasServicesInMinState((VersionedDomainNamespace)ns, state);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ns, state).toString());
    }
  }
  
  public boolean hasExceptionsInMinState(final Object ns, final LifecycleState state) {
    if (ns instanceof SubNamespace) {
      return _hasExceptionsInMinState((SubNamespace)ns, state);
    } else if (ns instanceof VersionedDomainNamespace) {
      return _hasExceptionsInMinState((VersionedDomainNamespace)ns, state);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ns, state).toString());
    }
  }
}
