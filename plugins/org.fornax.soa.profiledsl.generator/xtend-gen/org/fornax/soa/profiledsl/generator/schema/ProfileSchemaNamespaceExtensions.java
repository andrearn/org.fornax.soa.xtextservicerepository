package org.fornax.soa.profiledsl.generator.schema;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.fornax.soa.basedsl.CommonStringExtensions;
import org.fornax.soa.basedsl.version.VersionQualifierExtensions;
import org.fornax.soa.profiledsl.sOAProfileDsl.BaseNamespaceAlias;
import org.fornax.soa.profiledsl.sOAProfileDsl.NamespaceRules;
import org.fornax.soa.profiledsl.sOAProfileDsl.OrganizationNamespace;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace;
import org.fornax.soa.profiledsl.versioning.VersionedTechnicalNamespace;

@SuppressWarnings("all")
public class ProfileSchemaNamespaceExtensions {
  @Inject
  private CommonStringExtensions _commonStringExtensions;
  
  @Inject
  private VersionQualifierExtensions versionQualifier;
  
  @Inject
  @Named(value = "forceRelativePaths")
  private Boolean forceRelativePaths;
  
  @Inject
  @Named(value = "useNestedPaths")
  private Boolean useNestedPaths;
  
  protected String _fqn(final OrganizationNamespace s) {
    String _name = s.getName();
    String _stripXtextEscapes = this._commonStringExtensions.stripXtextEscapes(_name);
    return _stripXtextEscapes;
  }
  
  protected List<TechnicalNamespace> _toNamespacePath(final Object o) {
    ArrayList<TechnicalNamespace> _newArrayList = CollectionLiterals.<TechnicalNamespace>newArrayList();
    return _newArrayList;
  }
  
  protected List<TechnicalNamespace> _toNamespacePath(final List<TechnicalNamespace> nsList) {
    List<TechnicalNamespace> _xifexpression = null;
    TechnicalNamespace _last = IterableExtensions.<TechnicalNamespace>last(nsList);
    EObject _eContainer = _last.eContainer();
    if ((_eContainer instanceof TechnicalNamespace)) {
      List<TechnicalNamespace> _xblockexpression = null;
      {
        List<TechnicalNamespace> _list = IterableExtensions.<TechnicalNamespace>toList(nsList);
        TechnicalNamespace _last_1 = IterableExtensions.<TechnicalNamespace>last(_list);
        EObject _eContainer_1 = _last_1.eContainer();
        nsList.add(((TechnicalNamespace) _eContainer_1));
        List<TechnicalNamespace> _namespacePath = this.toNamespacePath(nsList);
        _xblockexpression = (_namespacePath);
      }
      _xifexpression = _xblockexpression;
    } else {
      Iterable<TechnicalNamespace> _filter = Iterables.<TechnicalNamespace>filter(nsList, TechnicalNamespace.class);
      List<TechnicalNamespace> _list = IterableExtensions.<TechnicalNamespace>toList(_filter);
      List<TechnicalNamespace> _reverse = ListExtensions.<TechnicalNamespace>reverse(_list);
      _xifexpression = _reverse;
    }
    return _xifexpression;
  }
  
  protected String _fqn(final TechnicalNamespace s) {
    OrganizationNamespace _findOrgNamespace = this.findOrgNamespace(s);
    String _name = ((OrganizationNamespace) _findOrgNamespace).getName();
    String _stripXtextEscapes = this._commonStringExtensions.stripXtextEscapes(_name);
    String _plus = (_stripXtextEscapes + ".");
    ArrayList<TechnicalNamespace> _newArrayList = CollectionLiterals.<TechnicalNamespace>newArrayList(s);
    List<TechnicalNamespace> _namespacePath = this.toNamespacePath(_newArrayList);
    final Function1<TechnicalNamespace,String> _function = new Function1<TechnicalNamespace,String>() {
        public String apply(final TechnicalNamespace n) {
          String _name = n.getName();
          String _stripXtextEscapes = ProfileSchemaNamespaceExtensions.this._commonStringExtensions.stripXtextEscapes(_name);
          return _stripXtextEscapes;
        }
      };
    List<String> _map = ListExtensions.<TechnicalNamespace, String>map(_namespacePath, _function);
    String _join = IterableExtensions.join(_map, ".");
    String _plus_1 = (_plus + _join);
    return _plus_1;
  }
  
  protected String _toPrefix(final OrganizationNamespace o) {
    String _xifexpression = null;
    String _prefix = o.getPrefix();
    boolean _notEquals = (!Objects.equal(_prefix, null));
    if (_notEquals) {
      String _prefix_1 = o.getPrefix();
      _xifexpression = _prefix_1;
    } else {
      String _name = o.getName();
      String[] _split = _name.split("\\.");
      final Function1<String,String> _function = new Function1<String,String>() {
          public String apply(final String e) {
            String _substring = e.substring(0, 1);
            return _substring;
          }
        };
      List<String> _map = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(_split)), _function);
      String _join = IterableExtensions.join(_map);
      _xifexpression = _join;
    }
    return _xifexpression;
  }
  
  protected String _toPrefix(final TechnicalNamespace s) {
    String _xifexpression = null;
    String _prefix = s.getPrefix();
    boolean _notEquals = (!Objects.equal(_prefix, null));
    if (_notEquals) {
      String _prefix_1 = s.getPrefix();
      _xifexpression = _prefix_1;
    } else {
      ArrayList<TechnicalNamespace> _newArrayList = CollectionLiterals.<TechnicalNamespace>newArrayList(s);
      List<TechnicalNamespace> _namespacePath = this.toNamespacePath(_newArrayList);
      final Function1<TechnicalNamespace,String> _function = new Function1<TechnicalNamespace,String>() {
          public String apply(final TechnicalNamespace n) {
            String _name = n.getName();
            String[] _split = _name.split("\\.");
            final Function1<String,String> _function = new Function1<String,String>() {
                public String apply(final String e) {
                  String _substring = e.substring(0, 1);
                  return _substring;
                }
              };
            List<String> _map = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(_split)), _function);
            String _join = IterableExtensions.join(_map);
            return _join;
          }
        };
      List<String> _map = ListExtensions.<TechnicalNamespace, String>map(_namespacePath, _function);
      String _join = IterableExtensions.join(_map);
      _xifexpression = _join;
    }
    return _xifexpression;
  }
  
  protected String _toPrefix(final VersionedTechnicalNamespace s) {
    String _xifexpression = null;
    String _shortName = s.getShortName();
    boolean _notEquals = (!Objects.equal(_shortName, null));
    if (_notEquals) {
      String _shortName_1 = s.getShortName();
      _xifexpression = _shortName_1;
    } else {
      TechnicalNamespace _namespace = s.getNamespace();
      ArrayList<TechnicalNamespace> _newArrayList = CollectionLiterals.<TechnicalNamespace>newArrayList(_namespace);
      List<TechnicalNamespace> _namespacePath = this.toNamespacePath(_newArrayList);
      final Function1<TechnicalNamespace,String> _function = new Function1<TechnicalNamespace,String>() {
          public String apply(final TechnicalNamespace n) {
            String _name = n.getName();
            String[] _split = _name.split("\\.");
            final Function1<String,String> _function = new Function1<String,String>() {
                public String apply(final String e) {
                  String _substring = e.substring(0, 1);
                  return _substring;
                }
              };
            List<String> _map = ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(_split)), _function);
            String _join = IterableExtensions.join(_map);
            return _join;
          }
        };
      List<String> _map = ListExtensions.<TechnicalNamespace, String>map(_namespacePath, _function);
      String _join = IterableExtensions.join(_map);
      _xifexpression = _join;
    }
    return _xifexpression;
  }
  
  protected String _toNamespace(final OrganizationNamespace org) {
    String _unversionedNamespace = this.toUnversionedNamespace(org);
    String _plus = (_unversionedNamespace + "/");
    String _versionPostfix = this.toVersionPostfix(org);
    String ns = (_plus + _versionPostfix);
    boolean _hasTrailingSlash = this.hasTrailingSlash(org);
    if (_hasTrailingSlash) {
      return (ns + "/");
    } else {
      return (ns + "");
    }
  }
  
  protected String _toNamespace(final TechnicalNamespace leafNamespace) {
    String _unversionedNamespace = this.toUnversionedNamespace(leafNamespace);
    String _plus = (_unversionedNamespace + "/");
    String _versionPostfix = this.toVersionPostfix(leafNamespace);
    String ns = (_plus + _versionPostfix);
    boolean _hasTrailingSlash = this.hasTrailingSlash(leafNamespace);
    if (_hasTrailingSlash) {
      return (ns + "/");
    } else {
      return (ns + "");
    }
  }
  
  protected boolean _hasTrailingSlash(final OrganizationNamespace ns) {
    return false;
  }
  
  protected boolean _hasTrailingSlash(final TechnicalNamespace ns) {
    boolean _isNoTrailingSlash = ns.isNoTrailingSlash();
    boolean _not = (!_isNoTrailingSlash);
    return _not;
  }
  
  protected String _toVersionPostfix(final OrganizationNamespace d) {
    String _defaultVersionPostfix = this.versionQualifier.toDefaultVersionPostfix();
    return _defaultVersionPostfix;
  }
  
  protected String _toVersionPostfix(final TechnicalNamespace s) {
    String _defaultVersionPostfix = this.versionQualifier.toDefaultVersionPostfix();
    return _defaultVersionPostfix;
  }
  
  protected String _toUnversionedNamespace(final OrganizationNamespace domain) {
    String _name = domain.getName();
    String[] _split = _name.split(".");
    List<String> _reverse = ListExtensions.<String>reverse(((List<String>)Conversions.doWrapArray(_split)));
    String _join = IterableExtensions.join(_reverse, ".");
    String _plus = ("http://" + _join);
    return _plus;
  }
  
  protected String _toUnversionedNamespace(final TechnicalNamespace leafDomainNamespace) {
    OrganizationNamespace _findOrgNamespace = this.findOrgNamespace(leafDomainNamespace);
    String _hostPart = this.toHostPart(_findOrgNamespace);
    String _plus = ("http://" + _hostPart);
    String _plus_1 = (_plus + "/");
    ArrayList<TechnicalNamespace> _newArrayList = CollectionLiterals.<TechnicalNamespace>newArrayList(leafDomainNamespace);
    List<TechnicalNamespace> _namespacePath = this.toNamespacePath(_newArrayList);
    final Function1<TechnicalNamespace,String> _function = new Function1<TechnicalNamespace,String>() {
        public String apply(final TechnicalNamespace n) {
          String _name = n.getName();
          String _stripXtextEscapes = ProfileSchemaNamespaceExtensions.this._commonStringExtensions.stripXtextEscapes(_name);
          String _replaceAll = _stripXtextEscapes.replaceAll("\\.", "/");
          return _replaceAll;
        }
      };
    List<String> _map = ListExtensions.<TechnicalNamespace, String>map(_namespacePath, _function);
    String _join = IterableExtensions.join(_map, "/");
    String _plus_2 = (_plus_1 + _join);
    return _plus_2;
  }
  
  protected String _toHostPart(final OrganizationNamespace d) {
    String _name = d.getName();
    String[] _split = _name.split("\\.");
    List<String> _reverse = ListExtensions.<String>reverse(((List<String>)Conversions.doWrapArray(_split)));
    String _join = IterableExtensions.join(_reverse, ".");
    return _join;
  }
  
  protected OrganizationNamespace _findOrgNamespace(final TechnicalNamespace o) {
    OrganizationNamespace _xifexpression = null;
    EObject _eContainer = o.eContainer();
    if ((_eContainer instanceof OrganizationNamespace)) {
      EObject _eContainer_1 = o.eContainer();
      _xifexpression = ((OrganizationNamespace) _eContainer_1);
    } else {
      EObject _eContainer_2 = o.eContainer();
      OrganizationNamespace _findOrgNamespace = this==null?(OrganizationNamespace)null:this.findOrgNamespace(((TechnicalNamespace) _eContainer_2));
      _xifexpression = ((OrganizationNamespace) _findOrgNamespace);
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
  
  public String shorten(final OrganizationNamespace d, final SOAProfile p) {
    String _xifexpression = null;
    NamespaceRules _namespaceRules = p.getNamespaceRules();
    EList<BaseNamespaceAlias> _aliases = _namespaceRules.getAliases();
    final Function1<BaseNamespaceAlias,Boolean> _function = new Function1<BaseNamespaceAlias,Boolean>() {
        public Boolean apply(final BaseNamespaceAlias e) {
          String _baseNamespaceFragment = e.getBaseNamespaceFragment();
          String _name = d.getName();
          boolean _equals = Objects.equal(_baseNamespaceFragment, _name);
          return Boolean.valueOf(_equals);
        }
      };
    Iterable<BaseNamespaceAlias> _filter = IterableExtensions.<BaseNamespaceAlias>filter(_aliases, _function);
    boolean _isEmpty = IterableExtensions.isEmpty(_filter);
    boolean _not = (!_isEmpty);
    if (_not) {
      NamespaceRules _namespaceRules_1 = p.getNamespaceRules();
      EList<BaseNamespaceAlias> _aliases_1 = _namespaceRules_1.getAliases();
      final Function1<BaseNamespaceAlias,Boolean> _function_1 = new Function1<BaseNamespaceAlias,Boolean>() {
          public Boolean apply(final BaseNamespaceAlias e) {
            String _baseNamespaceFragment = e.getBaseNamespaceFragment();
            String _name = d.getName();
            boolean _equals = Objects.equal(_baseNamespaceFragment, _name);
            return Boolean.valueOf(_equals);
          }
        };
      Iterable<BaseNamespaceAlias> _filter_1 = IterableExtensions.<BaseNamespaceAlias>filter(_aliases_1, _function_1);
      final Function1<BaseNamespaceAlias,String> _function_2 = new Function1<BaseNamespaceAlias,String>() {
          public String apply(final BaseNamespaceAlias n) {
            String _shortenedBaseNamespaceFragment = n.getShortenedBaseNamespaceFragment();
            return _shortenedBaseNamespaceFragment;
          }
        };
      Iterable<String> _map = IterableExtensions.<BaseNamespaceAlias, String>map(_filter_1, _function_2);
      String _join = IterableExtensions.join(_map);
      _xifexpression = _join;
    } else {
      String _name = d.getName();
      _xifexpression = _name;
    }
    return _xifexpression;
  }
  
  protected String _shorten(final OrganizationNamespace d) {
    String _prefix = d.getPrefix();
    return _prefix;
  }
  
  protected String _toRegistryAssetUrl(final TechnicalNamespace s, final String registryUrl) {
    String _xifexpression = null;
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(registryUrl, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _not = (!this.forceRelativePaths);
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
  
  protected String _toRegistryAssetUrl(final VersionedTechnicalNamespace s, final String registryUrl) {
    String _xifexpression = null;
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(registryUrl, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _not = (!this.forceRelativePaths);
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
  
  protected String _toFileNameFragment(final TechnicalNamespace s) {
    OrganizationNamespace _findOrgNamespace = this.findOrgNamespace(s);
    String _shorten = this.shorten(_findOrgNamespace);
    String _replaceAll = _shorten.replaceAll("\\.", "-");
    String _plus = (_replaceAll + "-");
    ArrayList<TechnicalNamespace> _newArrayList = CollectionLiterals.<TechnicalNamespace>newArrayList(s);
    List<TechnicalNamespace> _namespacePath = this.toNamespacePath(_newArrayList);
    final Function1<TechnicalNamespace,String> _function = new Function1<TechnicalNamespace,String>() {
        public String apply(final TechnicalNamespace n) {
          String _name = n.getName();
          String _stripXtextEscapes = ProfileSchemaNamespaceExtensions.this._commonStringExtensions.stripXtextEscapes(_name);
          String _replaceAll = _stripXtextEscapes.replaceAll("\\.", "-");
          return _replaceAll;
        }
      };
    List<String> _map = ListExtensions.<TechnicalNamespace, String>map(_namespacePath, _function);
    String _join = IterableExtensions.join(_map, "-");
    String _plus_1 = (_plus + _join);
    return _plus_1;
  }
  
  protected String _toFileNameFragment(final VersionedTechnicalNamespace s) {
    TechnicalNamespace _namespace = s.getNamespace();
    String _fileNameFragment = this.toFileNameFragment(_namespace);
    String _plus = (_fileNameFragment + "-v");
    String _version = s.getVersion();
    String _majorVersionNumber = this.versionQualifier.toMajorVersionNumber(_version);
    String _plus_1 = (_plus + _majorVersionNumber);
    return _plus_1;
  }
  
  protected String _toNamespace(final VersionedTechnicalNamespace s) {
    TechnicalNamespace _namespace = s.getNamespace();
    String _unversionedNamespace = this.toUnversionedNamespace(_namespace);
    String _stripXtextEscapes = this._commonStringExtensions.stripXtextEscapes(_unversionedNamespace);
    String _plus = (_stripXtextEscapes + "/");
    String _version = s.getVersion();
    String _versionPostfix = this.versionQualifier.toVersionPostfix(_version);
    String ns = (_plus + _versionPostfix);
    TechnicalNamespace _namespace_1 = s.getNamespace();
    boolean _hasTrailingSlash = this.hasTrailingSlash(_namespace_1);
    if (_hasTrailingSlash) {
      return (ns + "/");
    } else {
      return (ns + "");
    }
  }
  
  public String fqn(final EObject s) {
    if (s instanceof OrganizationNamespace) {
      return _fqn((OrganizationNamespace)s);
    } else if (s instanceof TechnicalNamespace) {
      return _fqn((TechnicalNamespace)s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s).toString());
    }
  }
  
  public List<TechnicalNamespace> toNamespacePath(final Object nsList) {
    if (nsList instanceof List) {
      return _toNamespacePath((List<TechnicalNamespace>)nsList);
    } else if (nsList != null) {
      return _toNamespacePath(nsList);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(nsList).toString());
    }
  }
  
  public String toPrefix(final Object o) {
    if (o instanceof OrganizationNamespace) {
      return _toPrefix((OrganizationNamespace)o);
    } else if (o instanceof TechnicalNamespace) {
      return _toPrefix((TechnicalNamespace)o);
    } else if (o instanceof VersionedTechnicalNamespace) {
      return _toPrefix((VersionedTechnicalNamespace)o);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(o).toString());
    }
  }
  
  public String toNamespace(final Object org) {
    if (org instanceof OrganizationNamespace) {
      return _toNamespace((OrganizationNamespace)org);
    } else if (org instanceof TechnicalNamespace) {
      return _toNamespace((TechnicalNamespace)org);
    } else if (org instanceof VersionedTechnicalNamespace) {
      return _toNamespace((VersionedTechnicalNamespace)org);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(org).toString());
    }
  }
  
  public boolean hasTrailingSlash(final EObject ns) {
    if (ns instanceof OrganizationNamespace) {
      return _hasTrailingSlash((OrganizationNamespace)ns);
    } else if (ns instanceof TechnicalNamespace) {
      return _hasTrailingSlash((TechnicalNamespace)ns);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ns).toString());
    }
  }
  
  public String toVersionPostfix(final EObject d) {
    if (d instanceof OrganizationNamespace) {
      return _toVersionPostfix((OrganizationNamespace)d);
    } else if (d instanceof TechnicalNamespace) {
      return _toVersionPostfix((TechnicalNamespace)d);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(d).toString());
    }
  }
  
  public String toUnversionedNamespace(final EObject domain) {
    if (domain instanceof OrganizationNamespace) {
      return _toUnversionedNamespace((OrganizationNamespace)domain);
    } else if (domain instanceof TechnicalNamespace) {
      return _toUnversionedNamespace((TechnicalNamespace)domain);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(domain).toString());
    }
  }
  
  public String toHostPart(final OrganizationNamespace d) {
    {
      return _toHostPart(d);
    }
  }
  
  public OrganizationNamespace findOrgNamespace(final TechnicalNamespace o) {
    {
      return _findOrgNamespace(o);
    }
  }
  
  public String toShortName(final TechnicalNamespace s) {
    {
      return _toShortName(s);
    }
  }
  
  public String shorten(final OrganizationNamespace d) {
    {
      return _shorten(d);
    }
  }
  
  public String toRegistryAssetUrl(final Object s, final String registryUrl) {
    if (s instanceof TechnicalNamespace) {
      return _toRegistryAssetUrl((TechnicalNamespace)s, registryUrl);
    } else if (s instanceof VersionedTechnicalNamespace) {
      return _toRegistryAssetUrl((VersionedTechnicalNamespace)s, registryUrl);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s, registryUrl).toString());
    }
  }
  
  public String toFileNameFragment(final Object s) {
    if (s instanceof TechnicalNamespace) {
      return _toFileNameFragment((TechnicalNamespace)s);
    } else if (s instanceof VersionedTechnicalNamespace) {
      return _toFileNameFragment((VersionedTechnicalNamespace)s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s).toString());
    }
  }
}
