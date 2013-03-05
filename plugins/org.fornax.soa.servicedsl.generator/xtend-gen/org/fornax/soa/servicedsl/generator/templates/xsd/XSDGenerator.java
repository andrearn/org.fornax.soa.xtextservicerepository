package org.fornax.soa.servicedsl.generator.templates.xsd;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.fornax.soa.basedsl.CommonStringExtensions;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.version.VersionQualifierExtensions;
import org.fornax.soa.profiledsl.query.LifecycleQueries;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher;
import org.fornax.soa.service.VersionedDomainNamespace;
import org.fornax.soa.service.namespace.NamespaceSplitter;
import org.fornax.soa.service.query.namespace.NamespaceImportQueries;
import org.fornax.soa.service.versioning.IExceptionResolver;
import org.fornax.soa.service.versioning.ITypeResolver;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.BusinessObjectRef;
import org.fornax.soa.serviceDsl.DataTypeRef;
import org.fornax.soa.serviceDsl.EnumLiteral;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.serviceDsl.ExceptionRef;
import org.fornax.soa.serviceDsl.OrganizationNamespace;
import org.fornax.soa.serviceDsl.Property;
import org.fornax.soa.serviceDsl.QueryObject;
import org.fornax.soa.serviceDsl.QueryObjectRef;
import org.fornax.soa.serviceDsl.SimpleAttribute;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.Type;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaTypeExtensions;

/**
 * Templates for XSD generation
 */
@SuppressWarnings("all")
public class XSDGenerator {
  @Inject
  private IFileSystemAccess fsa;
  
  @Inject
  private CommonStringExtensions _commonStringExtensions;
  
  @Inject
  private SchemaNamespaceExtensions _schemaNamespaceExtensions;
  
  @Inject
  private SchemaTypeExtensions _schemaTypeExtensions;
  
  @Inject
  private NamespaceSplitter _namespaceSplitter;
  
  @Inject
  private NamespaceImportQueries _namespaceImportQueries;
  
  @Inject
  private ITypeResolver _iTypeResolver;
  
  @Inject
  private IStateMatcher _iStateMatcher;
  
  @Inject
  private IExceptionResolver exceptionResolver;
  
  @Inject
  private VersionQualifierExtensions versionQualifier;
  
  @Inject
  @Named(value = "noDependencies")
  private Boolean noDependencies;
  
  @Inject
  private IQualifiedNameProvider nameProvider;
  
  @Inject
  private IEObjectDocumentationProvider docProvider;
  
  @Inject
  private LifecycleQueries lifecycleQueries;
  
  @Inject
  private Logger log;
  
  /**
   * CARTRIDGE ENTRYPOINT for generation of XSDs from namespaces.
   * 
   * Generate an XSD for each VersionedDomainNamespace derived from the given SubNamespace
   * applying splitting by major version of owned VersionedTypes and Exceptions in the
   * given minimal LifecycleState.
   */
  protected void _toXSD(final SubNamespace ns, final String minState, final SOAProfile profile, final String registryBaseUrl) {
    Resource _eResource = ns.eResource();
    LifecycleState _stateByName = this.lifecycleQueries.stateByName(minState, _eResource);
    this.toXSD(ns, _stateByName, profile, registryBaseUrl);
  }
  
  protected void _toXSD(final SubNamespace ns, final String minState, final SOAProfile profile, final String registryBaseUrl, final boolean noDeps, final boolean includeSubNamespaces) {
    Resource _eResource = ns.eResource();
    LifecycleState _stateByName = this.lifecycleQueries.stateByName(minState, _eResource);
    this.toXSD(ns, _stateByName, profile, registryBaseUrl, noDeps, includeSubNamespaces);
  }
  
  /**
   * Generate an XSD for each VersionedDomainNamespace derived from the given SubNamespace
   * applying splitting by major version of owned VersionedTypes and Exceptions in the
   * given minimal LifecycleState.
   */
  protected void _toXSD(final SubNamespace ns, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    Set<VersionedDomainNamespace> _splitNamespaceByMajorVersion = this._namespaceSplitter.splitNamespaceByMajorVersion(ns);
    Set<VersionedDomainNamespace> nsVersions = this._namespaceSplitter.getAllLatestSubNamespacesByMajorVersion(_splitNamespaceByMajorVersion);
    for (final VersionedDomainNamespace nsVer : nsVersions) {
      {
        this.toXSDVersion(nsVer, minState, profile, registryBaseUrl);
        boolean _not = (!this.noDependencies);
        if (_not) {
          Set<VersionedDomainNamespace> _allImportedVersionedNS = this._namespaceImportQueries.allImportedVersionedNS(nsVer, minState);
          Iterable<VersionedDomainNamespace> _filter = Iterables.<VersionedDomainNamespace>filter(_allImportedVersionedNS, VersionedDomainNamespace.class);
          final Function1<VersionedDomainNamespace,Boolean> _function = new Function1<VersionedDomainNamespace,Boolean>() {
              public Boolean apply(final VersionedDomainNamespace e) {
                boolean _and = false;
                EObject _subdomain = e.getSubdomain();
                EObject _subdomain_1 = nsVer.getSubdomain();
                boolean _equals = Objects.equal(_subdomain, _subdomain_1);
                if (!_equals) {
                  _and = false;
                } else {
                  String _version = e.getVersion();
                  String _majorVersionNumber = XSDGenerator.this.versionQualifier.toMajorVersionNumber(_version);
                  String _version_1 = nsVer.getVersion();
                  String _majorVersionNumber_1 = XSDGenerator.this.versionQualifier.toMajorVersionNumber(_version_1);
                  boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
                  _and = (_equals && _equals_1);
                }
                boolean _not = (!_and);
                return Boolean.valueOf(_not);
              }
            };
          Iterable<VersionedDomainNamespace> _filter_1 = IterableExtensions.<VersionedDomainNamespace>filter(_filter, _function);
          final Procedure1<VersionedDomainNamespace> _function_1 = new Procedure1<VersionedDomainNamespace>() {
              public void apply(final VersionedDomainNamespace e) {
                XSDGenerator.this.toXSDVersion(e, minState, profile, registryBaseUrl);
              }
            };
          IterableExtensions.<VersionedDomainNamespace>forEach(_filter_1, _function_1);
        }
      }
    }
  }
  
  /**
   * TODO: review for use as noDependencies flag is being injected already
   */
  protected void _toXSD(final SubNamespace ns, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl, final boolean noDeps, final boolean includeSubNamespaces) {
    Set<VersionedDomainNamespace> _splitNamespaceByMajorVersion = this._namespaceSplitter.splitNamespaceByMajorVersion(ns);
    Set<VersionedDomainNamespace> nsVersions = this._namespaceSplitter.getAllLatestSubNamespacesByMajorVersion(_splitNamespaceByMajorVersion);
    for (final VersionedDomainNamespace nsVer : nsVersions) {
      {
        this.toXSDVersion(nsVer, minState, profile, registryBaseUrl, noDeps, includeSubNamespaces);
        boolean _not = (!noDeps);
        if (_not) {
          Set<VersionedDomainNamespace> _allImportedVersionedNS = this._namespaceImportQueries.allImportedVersionedNS(nsVer, minState);
          Iterable<VersionedDomainNamespace> _filter = Iterables.<VersionedDomainNamespace>filter(_allImportedVersionedNS, VersionedDomainNamespace.class);
          final Function1<VersionedDomainNamespace,Boolean> _function = new Function1<VersionedDomainNamespace,Boolean>() {
              public Boolean apply(final VersionedDomainNamespace e) {
                boolean _and = false;
                EObject _subdomain = e.getSubdomain();
                EObject _subdomain_1 = nsVer.getSubdomain();
                boolean _equals = Objects.equal(_subdomain, _subdomain_1);
                if (!_equals) {
                  _and = false;
                } else {
                  String _version = e.getVersion();
                  String _majorVersionNumber = XSDGenerator.this.versionQualifier.toMajorVersionNumber(_version);
                  String _version_1 = nsVer.getVersion();
                  String _majorVersionNumber_1 = XSDGenerator.this.versionQualifier.toMajorVersionNumber(_version_1);
                  boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
                  _and = (_equals && _equals_1);
                }
                boolean _not = (!_and);
                return Boolean.valueOf(_not);
              }
            };
          Iterable<VersionedDomainNamespace> _filter_1 = IterableExtensions.<VersionedDomainNamespace>filter(_filter, _function);
          final Procedure1<VersionedDomainNamespace> _function_1 = new Procedure1<VersionedDomainNamespace>() {
              public void apply(final VersionedDomainNamespace e) {
                XSDGenerator.this.toXSDVersion(e, minState, profile, registryBaseUrl, noDeps, includeSubNamespaces);
              }
            };
          IterableExtensions.<VersionedDomainNamespace>forEach(_filter_1, _function_1);
        }
      }
    }
  }
  
  protected void _toXSD(final VersionedDomainNamespace ns, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    this.toXSDVersion(ns, minState, profile, registryBaseUrl);
    Set<VersionedDomainNamespace> _allImportedVersionedNS = this._namespaceImportQueries.allImportedVersionedNS(ns, minState);
    Iterable<VersionedDomainNamespace> _filter = Iterables.<VersionedDomainNamespace>filter(_allImportedVersionedNS, VersionedDomainNamespace.class);
    final Function1<VersionedDomainNamespace,Boolean> _function = new Function1<VersionedDomainNamespace,Boolean>() {
        public Boolean apply(final VersionedDomainNamespace e) {
          boolean _and = false;
          EObject _subdomain = e.getSubdomain();
          EObject _subdomain_1 = ns.getSubdomain();
          boolean _equals = Objects.equal(_subdomain, _subdomain_1);
          if (!_equals) {
            _and = false;
          } else {
            String _version = e.getVersion();
            String _majorVersionNumber = XSDGenerator.this.versionQualifier.toMajorVersionNumber(_version);
            String _version_1 = ns.getVersion();
            String _majorVersionNumber_1 = XSDGenerator.this.versionQualifier.toMajorVersionNumber(_version_1);
            boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
            _and = (_equals && _equals_1);
          }
          boolean _not = (!_and);
          return Boolean.valueOf(_not);
        }
      };
    Iterable<VersionedDomainNamespace> _filter_1 = IterableExtensions.<VersionedDomainNamespace>filter(_filter, _function);
    final Procedure1<VersionedDomainNamespace> _function_1 = new Procedure1<VersionedDomainNamespace>() {
        public void apply(final VersionedDomainNamespace e) {
          XSDGenerator.this.toXSDVersion(e, minState, profile, registryBaseUrl);
        }
      };
    IterableExtensions.<VersionedDomainNamespace>forEach(_filter_1, _function_1);
  }
  
  /**
   * Generate XSDs for all VersionedDomainNamespaces derived from the given SubNamespace by applying
   * the major version splitting algorithm filtered by the given minimal LifecycleState
   */
  public void toXSDForImports(final SubNamespace ns, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    Set<VersionedDomainNamespace> _splitNamespaceByMajorVersion = this._namespaceSplitter.splitNamespaceByMajorVersion(ns);
    Set<VersionedDomainNamespace> _allLatestSubNamespacesByMajorVersion = this._namespaceSplitter.getAllLatestSubNamespacesByMajorVersion(_splitNamespaceByMajorVersion);
    for (final VersionedDomainNamespace nsVer : _allLatestSubNamespacesByMajorVersion) {
      {
        this.toXSDVersion(nsVer, minState, profile, registryBaseUrl);
        Set<VersionedDomainNamespace> _allImportedVersionedNS = this._namespaceImportQueries.allImportedVersionedNS(nsVer, minState);
        Iterable<VersionedDomainNamespace> _filter = Iterables.<VersionedDomainNamespace>filter(_allImportedVersionedNS, VersionedDomainNamespace.class);
        final Function1<VersionedDomainNamespace,Boolean> _function = new Function1<VersionedDomainNamespace,Boolean>() {
            public Boolean apply(final VersionedDomainNamespace e) {
              boolean _and = false;
              EObject _subdomain = e.getSubdomain();
              EObject _subdomain_1 = nsVer.getSubdomain();
              boolean _equals = Objects.equal(_subdomain, _subdomain_1);
              if (!_equals) {
                _and = false;
              } else {
                String _version = e.getVersion();
                String _majorVersionNumber = XSDGenerator.this.versionQualifier.toMajorVersionNumber(_version);
                String _version_1 = nsVer.getVersion();
                String _majorVersionNumber_1 = XSDGenerator.this.versionQualifier.toMajorVersionNumber(_version_1);
                boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
                _and = (_equals && _equals_1);
              }
              boolean _not = (!_and);
              return Boolean.valueOf(_not);
            }
          };
        Iterable<VersionedDomainNamespace> _filter_1 = IterableExtensions.<VersionedDomainNamespace>filter(_filter, _function);
        final Procedure1<VersionedDomainNamespace> _function_1 = new Procedure1<VersionedDomainNamespace>() {
            public void apply(final VersionedDomainNamespace e) {
              XSDGenerator.this.toXSDVersion(e, minState, profile, registryBaseUrl);
            }
          };
        IterableExtensions.<VersionedDomainNamespace>forEach(_filter_1, _function_1);
      }
    }
  }
  
  /**
   * Generate the XSD for the given VersionedDomainNamespace. Only consider VersionedTypes and Exceptions
   * that match the given minimal LifecycleState.
   */
  public void toXSDVersion(final VersionedDomainNamespace vns, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    Set<VersionedDomainNamespace> _importedVersionedNS = this._namespaceImportQueries.importedVersionedNS(vns, minState);
    final Function1<VersionedDomainNamespace,Boolean> _function = new Function1<VersionedDomainNamespace,Boolean>() {
        public Boolean apply(final VersionedDomainNamespace e) {
          String _namespace = XSDGenerator.this._schemaTypeExtensions.toNamespace(e);
          String _namespace_1 = XSDGenerator.this._schemaTypeExtensions.toNamespace(vns);
          boolean _notEquals = (!Objects.equal(_namespace, _namespace_1));
          return Boolean.valueOf(_notEquals);
        }
      };
    final Iterable<VersionedDomainNamespace> imports = IterableExtensions.<VersionedDomainNamespace>filter(_importedVersionedNS, _function);
    List<Type> _types = vns.getTypes();
    Iterable<BusinessObject> _filter = Iterables.<BusinessObject>filter(_types, BusinessObject.class);
    final Function1<BusinessObject,Boolean> _function_1 = new Function1<BusinessObject,Boolean>() {
        public Boolean apply(final BusinessObject b) {
          LifecycleState _state = b.getState();
          boolean _isIsEnd = _state.isIsEnd();
          boolean _not = (!_isIsEnd);
          return Boolean.valueOf(_not);
        }
      };
    Iterable<BusinessObject> _filter_1 = IterableExtensions.<BusinessObject>filter(_filter, _function_1);
    final Function1<BusinessObject,Boolean> _function_2 = new Function1<BusinessObject,Boolean>() {
        public Boolean apply(final BusinessObject e) {
          boolean _and = false;
          LifecycleState _state = e.getState();
          boolean _matches = XSDGenerator.this._iStateMatcher.matches(minState, _state);
          if (!_matches) {
            _and = false;
          } else {
            String _version = vns.getVersion();
            String _majorVersionNumber = XSDGenerator.this.versionQualifier.toMajorVersionNumber(_version);
            Integer _asInteger = XSDGenerator.this._commonStringExtensions.asInteger(_majorVersionNumber);
            boolean _isMatchingType = XSDGenerator.this._iTypeResolver.isMatchingType(e, _asInteger, minState);
            _and = (_matches && _isMatchingType);
          }
          return Boolean.valueOf(_and);
        }
      };
    final Iterable<BusinessObject> bos = IterableExtensions.<BusinessObject>filter(_filter_1, _function_2);
    List<Type> _types_1 = vns.getTypes();
    Iterable<QueryObject> _filter_2 = Iterables.<QueryObject>filter(_types_1, QueryObject.class);
    final Function1<QueryObject,Boolean> _function_3 = new Function1<QueryObject,Boolean>() {
        public Boolean apply(final QueryObject b) {
          LifecycleState _state = b.getState();
          boolean _isIsEnd = _state.isIsEnd();
          boolean _not = (!_isIsEnd);
          return Boolean.valueOf(_not);
        }
      };
    Iterable<QueryObject> _filter_3 = IterableExtensions.<QueryObject>filter(_filter_2, _function_3);
    final Function1<QueryObject,Boolean> _function_4 = new Function1<QueryObject,Boolean>() {
        public Boolean apply(final QueryObject e) {
          boolean _and = false;
          LifecycleState _state = e.getState();
          boolean _matches = XSDGenerator.this._iStateMatcher.matches(minState, _state);
          if (!_matches) {
            _and = false;
          } else {
            String _version = vns.getVersion();
            String _majorVersionNumber = XSDGenerator.this.versionQualifier.toMajorVersionNumber(_version);
            Integer _asInteger = XSDGenerator.this._commonStringExtensions.asInteger(_majorVersionNumber);
            boolean _isMatchingType = XSDGenerator.this._iTypeResolver.isMatchingType(e, _asInteger, minState);
            _and = (_matches && _isMatchingType);
          }
          return Boolean.valueOf(_and);
        }
      };
    final Iterable<QueryObject> qos = IterableExtensions.<QueryObject>filter(_filter_3, _function_4);
    List<Type> _types_2 = vns.getTypes();
    Iterable<Enumeration> _filter_4 = Iterables.<Enumeration>filter(_types_2, Enumeration.class);
    final Function1<Enumeration,Boolean> _function_5 = new Function1<Enumeration,Boolean>() {
        public Boolean apply(final Enumeration en) {
          boolean _and = false;
          LifecycleState _state = en.getState();
          boolean _matches = XSDGenerator.this._iStateMatcher.matches(minState, _state);
          if (!_matches) {
            _and = false;
          } else {
            String _version = vns.getVersion();
            String _majorVersionNumber = XSDGenerator.this.versionQualifier.toMajorVersionNumber(_version);
            Integer _asInteger = XSDGenerator.this._commonStringExtensions.asInteger(_majorVersionNumber);
            boolean _isMatchingType = XSDGenerator.this._iTypeResolver.isMatchingType(en, _asInteger, minState);
            _and = (_matches && _isMatchingType);
          }
          return Boolean.valueOf(_and);
        }
      };
    final Iterable<Enumeration> enums = IterableExtensions.<Enumeration>filter(_filter_4, _function_5);
    List<org.fornax.soa.serviceDsl.Exception> _exceptions = vns.getExceptions();
    Iterable<org.fornax.soa.serviceDsl.Exception> _filter_5 = Iterables.<org.fornax.soa.serviceDsl.Exception>filter(_exceptions, org.fornax.soa.serviceDsl.Exception.class);
    final Function1<org.fornax.soa.serviceDsl.Exception,Boolean> _function_6 = new Function1<org.fornax.soa.serviceDsl.Exception,Boolean>() {
        public Boolean apply(final org.fornax.soa.serviceDsl.Exception ex) {
          boolean _and = false;
          LifecycleState _state = ex.getState();
          boolean _matches = XSDGenerator.this._iStateMatcher.matches(minState, _state);
          if (!_matches) {
            _and = false;
          } else {
            String _version = vns.getVersion();
            String _majorVersionNumber = XSDGenerator.this.versionQualifier.toMajorVersionNumber(_version);
            Integer _asInteger = XSDGenerator.this._commonStringExtensions.asInteger(_majorVersionNumber);
            boolean _isMatchingException = XSDGenerator.this.exceptionResolver.isMatchingException(ex, _asInteger, minState);
            _and = (_matches && _isMatchingException);
          }
          return Boolean.valueOf(_and);
        }
      };
    final Iterable<org.fornax.soa.serviceDsl.Exception> exceptions = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>filter(_filter_5, _function_6);
    boolean _or = false;
    boolean _or_1 = false;
    boolean _or_2 = false;
    boolean _isEmpty = IterableExtensions.isEmpty(bos);
    boolean _not = (!_isEmpty);
    if (_not) {
      _or_2 = true;
    } else {
      boolean _isEmpty_1 = IterableExtensions.isEmpty(qos);
      boolean _not_1 = (!_isEmpty_1);
      _or_2 = (_not || _not_1);
    }
    if (_or_2) {
      _or_1 = true;
    } else {
      boolean _isEmpty_2 = IterableExtensions.isEmpty(enums);
      boolean _not_2 = (!_isEmpty_2);
      _or_1 = (_or_2 || _not_2);
    }
    if (_or_1) {
      _or = true;
    } else {
      boolean _isEmpty_3 = IterableExtensions.isEmpty(exceptions);
      boolean _not_3 = (!_isEmpty_3);
      _or = (_or_1 || _not_3);
    }
    if (_or) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder.newLine();
      _builder.append("<xsd:schema xmlns:tns=\"");
      String _namespace = this._schemaTypeExtensions.toNamespace(vns);
      _builder.append(_namespace, "");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      Set<VersionedDomainNamespace> _importedVersionedNS_1 = this._namespaceImportQueries.importedVersionedNS(vns, minState);
      final Function1<VersionedDomainNamespace,CharSequence> _function_7 = new Function1<VersionedDomainNamespace,CharSequence>() {
          public CharSequence apply(final VersionedDomainNamespace e) {
            CharSequence _namespaceDeclaration = XSDGenerator.this.toNamespaceDeclaration(e);
            return _namespaceDeclaration;
          }
        };
      Iterable<CharSequence> _map = IterableExtensions.<VersionedDomainNamespace, CharSequence>map(_importedVersionedNS_1, _function_7);
      String _join = IterableExtensions.join(_map);
      _builder.append(_join, "	");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("xmlns=\"");
      String _namespace_1 = this._schemaTypeExtensions.toNamespace(vns);
      _builder.append(_namespace_1, "	");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("xmlns:xmime=\"http://www.w3.org/2005/05/xmlmime\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("elementFormDefault=\"qualified\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("attributeFormDefault=\"unqualified\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("targetNamespace=\"");
      String _namespace_2 = this._schemaTypeExtensions.toNamespace(vns);
      _builder.append(_namespace_2, "	");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append(">");
      _builder.newLine();
      _builder.append("\t");
      final Function1<VersionedDomainNamespace,CharSequence> _function_8 = new Function1<VersionedDomainNamespace,CharSequence>() {
          public CharSequence apply(final VersionedDomainNamespace e) {
            CharSequence _importDeclaration = XSDGenerator.this.toImportDeclaration(e, registryBaseUrl);
            return _importDeclaration;
          }
        };
      Iterable<CharSequence> _map_1 = IterableExtensions.<VersionedDomainNamespace, CharSequence>map(imports, _function_8);
      String _join_1 = IterableExtensions.join(_map_1);
      _builder.append(_join_1, "	");
      _builder.append(" \t");
      _builder.newLineIfNotEmpty();
      {
        EObject _subdomain = vns.getSubdomain();
        if ((_subdomain instanceof SubNamespace)) {
          _builder.append("\t");
          final Function1<BusinessObject,CharSequence> _function_9 = new Function1<BusinessObject,CharSequence>() {
              public CharSequence apply(final BusinessObject e) {
                CharSequence _complexType = XSDGenerator.this.toComplexType(e, vns, profile, minState);
                return _complexType;
              }
            };
          Iterable<CharSequence> _map_2 = IterableExtensions.<BusinessObject, CharSequence>map(bos, _function_9);
          String _join_2 = IterableExtensions.join(_map_2);
          _builder.append(_join_2, "	");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          final Function1<QueryObject,CharSequence> _function_10 = new Function1<QueryObject,CharSequence>() {
              public CharSequence apply(final QueryObject e) {
                CharSequence _complexType = XSDGenerator.this.toComplexType(e, vns, profile, minState);
                return _complexType;
              }
            };
          Iterable<CharSequence> _map_3 = IterableExtensions.<QueryObject, CharSequence>map(qos, _function_10);
          String _join_3 = IterableExtensions.join(_map_3);
          _builder.append(_join_3, "	");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          final Function1<Enumeration,CharSequence> _function_11 = new Function1<Enumeration,CharSequence>() {
              public CharSequence apply(final Enumeration e) {
                CharSequence _simpleType = XSDGenerator.this.toSimpleType(e, minState);
                return _simpleType;
              }
            };
          Iterable<CharSequence> _map_4 = IterableExtensions.<Enumeration, CharSequence>map(enums, _function_11);
          String _join_4 = IterableExtensions.join(_map_4);
          _builder.append(_join_4, "	");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          final Function1<org.fornax.soa.serviceDsl.Exception,CharSequence> _function_12 = new Function1<org.fornax.soa.serviceDsl.Exception,CharSequence>() {
              public CharSequence apply(final org.fornax.soa.serviceDsl.Exception e) {
                CharSequence _faultType = XSDGenerator.this.toFaultType(e, vns, profile, minState);
                return _faultType;
              }
            };
          Iterable<CharSequence> _map_5 = IterableExtensions.<org.fornax.soa.serviceDsl.Exception, CharSequence>map(exceptions, _function_12);
          String _join_5 = IterableExtensions.join(_map_5);
          _builder.append(_join_5, "	");
          _builder.newLineIfNotEmpty();
        } else {
          EObject _subdomain_1 = vns.getSubdomain();
          if ((_subdomain_1 instanceof OrganizationNamespace)) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.newLine();
          }
        }
      }
      _builder.append("</xsd:schema>");
      CharSequence content = _builder;
      String _fileNameFragment = this._schemaNamespaceExtensions.toFileNameFragment(vns);
      String fileName = (_fileNameFragment + ".xsd");
      this.fsa.generateFile(fileName, content);
    }
  }
  
  /**
   * Generate the XSD for the given VersionedDomainNamespace. Only consider VersionedTypes and Exceptions
   * that match the given minimal LifecycleState.
   */
  public void toXSDVersion(final VersionedDomainNamespace vns, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl, final boolean noDeps, final boolean includeSubNamespaces) {
    Set<VersionedDomainNamespace> _importedVersionedNS = this._namespaceImportQueries.importedVersionedNS(vns, minState);
    final Function1<VersionedDomainNamespace,Boolean> _function = new Function1<VersionedDomainNamespace,Boolean>() {
        public Boolean apply(final VersionedDomainNamespace e) {
          String _namespace = XSDGenerator.this._schemaTypeExtensions.toNamespace(e);
          String _namespace_1 = XSDGenerator.this._schemaTypeExtensions.toNamespace(vns);
          boolean _notEquals = (!Objects.equal(_namespace, _namespace_1));
          return Boolean.valueOf(_notEquals);
        }
      };
    final Iterable<VersionedDomainNamespace> imports = IterableExtensions.<VersionedDomainNamespace>filter(_importedVersionedNS, _function);
    List<Type> _types = vns.getTypes();
    Iterable<BusinessObject> _filter = Iterables.<BusinessObject>filter(_types, BusinessObject.class);
    final Function1<BusinessObject,Boolean> _function_1 = new Function1<BusinessObject,Boolean>() {
        public Boolean apply(final BusinessObject b) {
          LifecycleState _state = b.getState();
          boolean _isIsEnd = _state.isIsEnd();
          boolean _not = (!_isIsEnd);
          return Boolean.valueOf(_not);
        }
      };
    Iterable<BusinessObject> _filter_1 = IterableExtensions.<BusinessObject>filter(_filter, _function_1);
    final Function1<BusinessObject,Boolean> _function_2 = new Function1<BusinessObject,Boolean>() {
        public Boolean apply(final BusinessObject e) {
          boolean _and = false;
          LifecycleState _state = e.getState();
          boolean _matches = XSDGenerator.this._iStateMatcher.matches(minState, _state);
          if (!_matches) {
            _and = false;
          } else {
            String _version = vns.getVersion();
            String _majorVersionNumber = XSDGenerator.this.versionQualifier.toMajorVersionNumber(_version);
            Integer _asInteger = XSDGenerator.this._commonStringExtensions.asInteger(_majorVersionNumber);
            boolean _isMatchingType = XSDGenerator.this._iTypeResolver.isMatchingType(e, _asInteger, minState);
            _and = (_matches && _isMatchingType);
          }
          return Boolean.valueOf(_and);
        }
      };
    final Iterable<BusinessObject> bos = IterableExtensions.<BusinessObject>filter(_filter_1, _function_2);
    List<Type> _types_1 = vns.getTypes();
    Iterable<QueryObject> _filter_2 = Iterables.<QueryObject>filter(_types_1, QueryObject.class);
    final Function1<QueryObject,Boolean> _function_3 = new Function1<QueryObject,Boolean>() {
        public Boolean apply(final QueryObject b) {
          LifecycleState _state = b.getState();
          boolean _isIsEnd = _state.isIsEnd();
          boolean _not = (!_isIsEnd);
          return Boolean.valueOf(_not);
        }
      };
    Iterable<QueryObject> _filter_3 = IterableExtensions.<QueryObject>filter(_filter_2, _function_3);
    final Function1<QueryObject,Boolean> _function_4 = new Function1<QueryObject,Boolean>() {
        public Boolean apply(final QueryObject e) {
          boolean _and = false;
          LifecycleState _state = e.getState();
          boolean _matches = XSDGenerator.this._iStateMatcher.matches(minState, _state);
          if (!_matches) {
            _and = false;
          } else {
            String _version = vns.getVersion();
            String _majorVersionNumber = XSDGenerator.this.versionQualifier.toMajorVersionNumber(_version);
            Integer _asInteger = XSDGenerator.this._commonStringExtensions.asInteger(_majorVersionNumber);
            boolean _isMatchingType = XSDGenerator.this._iTypeResolver.isMatchingType(e, _asInteger, minState);
            _and = (_matches && _isMatchingType);
          }
          return Boolean.valueOf(_and);
        }
      };
    final Iterable<QueryObject> qos = IterableExtensions.<QueryObject>filter(_filter_3, _function_4);
    List<Type> _types_2 = vns.getTypes();
    Iterable<Enumeration> _filter_4 = Iterables.<Enumeration>filter(_types_2, Enumeration.class);
    final Function1<Enumeration,Boolean> _function_5 = new Function1<Enumeration,Boolean>() {
        public Boolean apply(final Enumeration en) {
          boolean _and = false;
          LifecycleState _state = en.getState();
          boolean _matches = XSDGenerator.this._iStateMatcher.matches(minState, _state);
          if (!_matches) {
            _and = false;
          } else {
            String _version = vns.getVersion();
            String _majorVersionNumber = XSDGenerator.this.versionQualifier.toMajorVersionNumber(_version);
            Integer _asInteger = XSDGenerator.this._commonStringExtensions.asInteger(_majorVersionNumber);
            boolean _isMatchingType = XSDGenerator.this._iTypeResolver.isMatchingType(en, _asInteger, minState);
            _and = (_matches && _isMatchingType);
          }
          return Boolean.valueOf(_and);
        }
      };
    final Iterable<Enumeration> enums = IterableExtensions.<Enumeration>filter(_filter_4, _function_5);
    List<org.fornax.soa.serviceDsl.Exception> _exceptions = vns.getExceptions();
    Iterable<org.fornax.soa.serviceDsl.Exception> _filter_5 = Iterables.<org.fornax.soa.serviceDsl.Exception>filter(_exceptions, org.fornax.soa.serviceDsl.Exception.class);
    final Function1<org.fornax.soa.serviceDsl.Exception,Boolean> _function_6 = new Function1<org.fornax.soa.serviceDsl.Exception,Boolean>() {
        public Boolean apply(final org.fornax.soa.serviceDsl.Exception e) {
          boolean _and = false;
          LifecycleState _state = e.getState();
          boolean _matches = XSDGenerator.this._iStateMatcher.matches(minState, _state);
          if (!_matches) {
            _and = false;
          } else {
            String _version = vns.getVersion();
            String _majorVersionNumber = XSDGenerator.this.versionQualifier.toMajorVersionNumber(_version);
            Integer _asInteger = XSDGenerator.this._commonStringExtensions.asInteger(_majorVersionNumber);
            boolean _isMatchingException = XSDGenerator.this.exceptionResolver.isMatchingException(e, _asInteger, minState);
            _and = (_matches && _isMatchingException);
          }
          return Boolean.valueOf(_and);
        }
      };
    final Iterable<org.fornax.soa.serviceDsl.Exception> exceptions = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>filter(_filter_5, _function_6);
    boolean _or = false;
    boolean _or_1 = false;
    boolean _or_2 = false;
    boolean _isEmpty = IterableExtensions.isEmpty(bos);
    boolean _not = (!_isEmpty);
    if (_not) {
      _or_2 = true;
    } else {
      boolean _isEmpty_1 = IterableExtensions.isEmpty(qos);
      boolean _not_1 = (!_isEmpty_1);
      _or_2 = (_not || _not_1);
    }
    if (_or_2) {
      _or_1 = true;
    } else {
      boolean _isEmpty_2 = IterableExtensions.isEmpty(enums);
      boolean _not_2 = (!_isEmpty_2);
      _or_1 = (_or_2 || _not_2);
    }
    if (_or_1) {
      _or = true;
    } else {
      boolean _isEmpty_3 = IterableExtensions.isEmpty(exceptions);
      boolean _not_3 = (!_isEmpty_3);
      _or = (_or_1 || _not_3);
    }
    if (_or) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
      _builder.newLine();
      _builder.append("<xsd:schema xmlns:tns=\"");
      String _namespace = this._schemaTypeExtensions.toNamespace(vns);
      _builder.append(_namespace, "");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      Set<VersionedDomainNamespace> _importedVersionedNS_1 = this._namespaceImportQueries.importedVersionedNS(vns, minState);
      final Function1<VersionedDomainNamespace,CharSequence> _function_7 = new Function1<VersionedDomainNamespace,CharSequence>() {
          public CharSequence apply(final VersionedDomainNamespace e) {
            CharSequence _namespaceDeclaration = XSDGenerator.this.toNamespaceDeclaration(e);
            return _namespaceDeclaration;
          }
        };
      Iterable<CharSequence> _map = IterableExtensions.<VersionedDomainNamespace, CharSequence>map(_importedVersionedNS_1, _function_7);
      String _join = IterableExtensions.join(_map);
      _builder.append(_join, "	");
      _builder.append(" ");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("xmlns=\"");
      String _namespace_1 = this._schemaTypeExtensions.toNamespace(vns);
      _builder.append(_namespace_1, "	");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("xmlns:xmime=\"http://www.w3.org/2005/05/xmlmime\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("elementFormDefault=\"qualified\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("attributeFormDefault=\"unqualified\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("targetNamespace=\"");
      String _namespace_2 = this._schemaTypeExtensions.toNamespace(vns);
      _builder.append(_namespace_2, "	");
      _builder.append("\"");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append(">");
      _builder.newLine();
      _builder.append("\t");
      final Function1<VersionedDomainNamespace,CharSequence> _function_8 = new Function1<VersionedDomainNamespace,CharSequence>() {
          public CharSequence apply(final VersionedDomainNamespace e) {
            CharSequence _importDeclaration = XSDGenerator.this.toImportDeclaration(e, registryBaseUrl);
            return _importDeclaration;
          }
        };
      Iterable<CharSequence> _map_1 = IterableExtensions.<VersionedDomainNamespace, CharSequence>map(imports, _function_8);
      String _join_1 = IterableExtensions.join(_map_1);
      _builder.append(_join_1, "	");
      _builder.append(" \t");
      _builder.newLineIfNotEmpty();
      {
        EObject _subdomain = vns.getSubdomain();
        if ((_subdomain instanceof SubNamespace)) {
          _builder.append("\t");
          final Function1<BusinessObject,CharSequence> _function_9 = new Function1<BusinessObject,CharSequence>() {
              public CharSequence apply(final BusinessObject e) {
                CharSequence _complexType = XSDGenerator.this.toComplexType(e, vns, profile, minState);
                return _complexType;
              }
            };
          Iterable<CharSequence> _map_2 = IterableExtensions.<BusinessObject, CharSequence>map(bos, _function_9);
          String _join_2 = IterableExtensions.join(_map_2);
          _builder.append(_join_2, "	");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          final Function1<QueryObject,CharSequence> _function_10 = new Function1<QueryObject,CharSequence>() {
              public CharSequence apply(final QueryObject e) {
                CharSequence _complexType = XSDGenerator.this.toComplexType(e, vns, profile, minState);
                return _complexType;
              }
            };
          Iterable<CharSequence> _map_3 = IterableExtensions.<QueryObject, CharSequence>map(qos, _function_10);
          String _join_3 = IterableExtensions.join(_map_3);
          _builder.append(_join_3, "	");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          final Function1<Enumeration,CharSequence> _function_11 = new Function1<Enumeration,CharSequence>() {
              public CharSequence apply(final Enumeration e) {
                CharSequence _simpleType = XSDGenerator.this.toSimpleType(e, minState);
                return _simpleType;
              }
            };
          Iterable<CharSequence> _map_4 = IterableExtensions.<Enumeration, CharSequence>map(enums, _function_11);
          String _join_4 = IterableExtensions.join(_map_4);
          _builder.append(_join_4, "	");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          final Function1<org.fornax.soa.serviceDsl.Exception,CharSequence> _function_12 = new Function1<org.fornax.soa.serviceDsl.Exception,CharSequence>() {
              public CharSequence apply(final org.fornax.soa.serviceDsl.Exception e) {
                CharSequence _faultType = XSDGenerator.this.toFaultType(e, vns, profile, minState);
                return _faultType;
              }
            };
          Iterable<CharSequence> _map_5 = IterableExtensions.<org.fornax.soa.serviceDsl.Exception, CharSequence>map(exceptions, _function_12);
          String _join_5 = IterableExtensions.join(_map_5);
          _builder.append(_join_5, "	");
          _builder.newLineIfNotEmpty();
        } else {
          EObject _subdomain_1 = vns.getSubdomain();
          if ((_subdomain_1 instanceof OrganizationNamespace)) {
            _builder.append("\t");
            _builder.append("\t");
            _builder.newLine();
          }
        }
      }
      _builder.append("</xsd:schema>");
      CharSequence content = _builder;
      String _fileNameFragment = this._schemaNamespaceExtensions.toFileNameFragment(vns);
      String fileName = (_fileNameFragment + ".xsd");
      this.fsa.generateFile(fileName, content);
    }
  }
  
  public CharSequence toNamespaceDeclaration(final VersionedDomainNamespace vns) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("xmlns:");
    String _prefix = this._schemaNamespaceExtensions.toPrefix(vns);
    String _version = vns.getVersion();
    String _majorVersionNumber = this.versionQualifier.toMajorVersionNumber(_version);
    String _plus = (_prefix + _majorVersionNumber);
    _builder.append(_plus, "");
    _builder.append("=\"");
    String _namespace = this._schemaTypeExtensions.toNamespace(vns);
    _builder.append(_namespace, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence toImportDeclaration(final VersionedDomainNamespace vns, final String registryBaseUrl) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<xsd:import schemaLocation=\"");
    String _registryAssetUrl = this._schemaNamespaceExtensions.toRegistryAssetUrl(vns, registryBaseUrl);
    _builder.append(_registryAssetUrl, "");
    _builder.append(".xsd\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("namespace=\"");
    String _namespace = this._schemaTypeExtensions.toNamespace(vns);
    _builder.append(_namespace, "	");
    _builder.append("\"></xsd:import>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  /**
   * Generate a ComplexType for a BusinessObject respecting the major version of the containing
   * XSD. Hence, the same VersionedDomainNamespace as for the containing XSD must be used.
   * 
   * @param 		currNs	The VersionedDomainNamespace currently in use for the containing
   * XSD being generated
   * @param		profile	The SOAProfile defining the governing architecture rules.
   */
  public CharSequence toComplexType(final BusinessObject bo, final VersionedDomainNamespace currNs, final SOAProfile profile, final LifecycleState minState) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("<xsd:complexType name=\"");
    String _name = bo.getName();
    _builder.append(_name, "");
    _builder.append("\"");
    {
      boolean _isAbstract = bo.isAbstract();
      if (_isAbstract) {
        _builder.append(" abstract=\"true\"");
      }
    }
    _builder.append(">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<xsd:annotation>");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("<xsd:documentation>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<![CDATA[");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Version:\t\t\t");
    Version _version = bo.getVersion();
    String _versionNumber = this.versionQualifier.toVersionNumber(_version);
    _builder.append(_versionNumber, "				");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("Lifecycle state: \t");
    LifecycleState _state = bo.getState();
    String _name_1 = _state.getName();
    _builder.append(_name_1, "				");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    String _documentation = this.docProvider.getDocumentation(bo);
    _builder.append(_documentation, "				");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("]]>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</xsd:documentation>");
    _builder.newLine();
    _builder.append("\t\t\t\t ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</xsd:annotation>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      BusinessObjectRef _superBusinessObject = bo.getSuperBusinessObject();
      boolean _notEquals = (!Objects.equal(_superBusinessObject, null));
      if (_notEquals) {
        _builder.append("\t");
        _builder.append("<xsd:complexContent>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("<xsd:extension base=\"");
        BusinessObjectRef _superBusinessObject_1 = bo.getSuperBusinessObject();
        String _typeNameRef = this._schemaTypeExtensions.toTypeNameRef(_superBusinessObject_1, currNs);
        _builder.append(_typeNameRef, "		");
        _builder.append("\">");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        CharSequence _propertySequence = this.toPropertySequence(bo, currNs, profile, minState);
        _builder.append(_propertySequence, "			");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("</xsd:extension>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("</xsd:complexContent>");
        _builder.newLine();
      } else {
        _builder.append("\t");
        CharSequence _propertySequenceWithAny = this.toPropertySequenceWithAny(bo, currNs, profile, minState);
        _builder.append(_propertySequenceWithAny, "	");
        _builder.newLineIfNotEmpty();
        {
          boolean _typesUseExtendibleXMLAttributes = this._schemaTypeExtensions.typesUseExtendibleXMLAttributes(profile);
          if (_typesUseExtendibleXMLAttributes) {
            _builder.append("\t");
            String _typesExtendibleXMLAttributesClause = this._schemaTypeExtensions.getTypesExtendibleXMLAttributesClause(profile);
            _builder.append(_typesExtendibleXMLAttributesClause, "	");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("</xsd:complexType>");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * Generate a ComplexType for a QueryObject respecting the major version of the containing
   * XSD. Hence, the same VersionedDomainNamespace as for the containing XSD must be used.
   * 
   * @param 		currNs	The VersionedDomainNamespace currently in use for the containing
   * XSD being generated
   * @param		profile	The SOAProfile defining the governing architecture rules.
   */
  public CharSequence toComplexType(final QueryObject qo, final VersionedDomainNamespace currNs, final SOAProfile profile, final LifecycleState minState) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("<xsd:complexType name=\"");
    String _name = qo.getName();
    _builder.append(_name, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<xsd:annotation>");
    _builder.newLine();
    _builder.append("    \t");
    _builder.append("<xsd:documentation>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<![CDATA[");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Version:\t\t\t");
    Version _version = qo.getVersion();
    String _versionNumber = this.versionQualifier.toVersionNumber(_version);
    _builder.append(_versionNumber, "				");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("Lifecycle state: \t");
    LifecycleState _state = qo.getState();
    String _name_1 = _state.getName();
    _builder.append(_name_1, "				");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    String _documentation = this.docProvider.getDocumentation(qo);
    _builder.append(_documentation, "				");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("]]>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</xsd:documentation>");
    _builder.newLine();
    _builder.append("\t\t\t\t ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</xsd:annotation>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      QueryObjectRef _superQueryObject = qo.getSuperQueryObject();
      boolean _notEquals = (!Objects.equal(_superQueryObject, null));
      if (_notEquals) {
        _builder.append("\t");
        _builder.append("<xsd:complexContent>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("<xsd:extension base=\"");
        QueryObjectRef _superQueryObject_1 = qo.getSuperQueryObject();
        String _typeNameRef = this._schemaTypeExtensions.toTypeNameRef(_superQueryObject_1, currNs);
        _builder.append(_typeNameRef, "		");
        _builder.append("\">");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        CharSequence _propertySequence = this.toPropertySequence(qo, currNs, profile, minState);
        _builder.append(_propertySequence, "			");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("</xsd:extension>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("</xsd:complexContent>");
        _builder.newLine();
      } else {
        _builder.append("\t");
        CharSequence _propertySequenceWithAny = this.toPropertySequenceWithAny(qo, currNs, profile, minState);
        _builder.append(_propertySequenceWithAny, "	");
        _builder.newLineIfNotEmpty();
        {
          boolean _typesUseExtendibleXMLAttributes = this._schemaTypeExtensions.typesUseExtendibleXMLAttributes(profile);
          if (_typesUseExtendibleXMLAttributes) {
            _builder.append("\t");
            String _typesExtendibleXMLAttributesClause = this._schemaTypeExtensions.getTypesExtendibleXMLAttributesClause(profile);
            _builder.append(_typesExtendibleXMLAttributesClause, "	");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("</xsd:complexType>");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * Generate a sequence of elements for properties plus an additional any as placeholder for future
   * backward compatible extensions of the ComplexType / BusinessObject
   * 
   * @param 		currNs	The VersionedDomainNamespace currently in use for the containing
   * XSD being generated
   * @param		profile	The SOAProfile defining the governing architecture rules.
   */
  protected CharSequence _toPropertySequenceWithAny(final BusinessObject bo, final VersionedDomainNamespace currNs, final SOAProfile profile, final LifecycleState minState) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<xsd:sequence>");
    _builder.newLine();
    _builder.append("\t");
    EList<Property> _properties = bo.getProperties();
    final Function1<Property,CharSequence> _function = new Function1<Property,CharSequence>() {
        public CharSequence apply(final Property e) {
          CharSequence _property = XSDGenerator.this.toProperty(e, currNs, profile, minState);
          return _property;
        }
      };
    List<CharSequence> _map = ListExtensions.<Property, CharSequence>map(_properties, _function);
    String _join = IterableExtensions.join(_map);
    _builder.append(_join, "	");
    _builder.newLineIfNotEmpty();
    {
      boolean _typesUseExtendibleProperties = this._schemaTypeExtensions.typesUseExtendibleProperties(profile);
      if (_typesUseExtendibleProperties) {
        _builder.append("\t");
        String _typesExtendiblePropertiesClause = this._schemaTypeExtensions.getTypesExtendiblePropertiesClause(profile);
        _builder.append(_typesExtendiblePropertiesClause, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</xsd:sequence>");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * Generate a sequence of elements for properties plus an additional any as placeholder for future
   * backward compatible extensions of the ComplexType / BusinessObject
   * 
   * @param 		currNs	The VersionedDomainNamespace currently in use for the containing
   * XSD being generated
   * @param		profile	The SOAProfile defining the governing architecture rules.
   */
  protected CharSequence _toPropertySequenceWithAny(final QueryObject qo, final VersionedDomainNamespace currNs, final SOAProfile profile, final LifecycleState minState) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<xsd:sequence>");
    _builder.newLine();
    _builder.append("\t");
    EList<Property> _properties = qo.getProperties();
    final Function1<Property,CharSequence> _function = new Function1<Property,CharSequence>() {
        public CharSequence apply(final Property e) {
          CharSequence _property = XSDGenerator.this.toProperty(e, currNs, profile, minState);
          return _property;
        }
      };
    List<CharSequence> _map = ListExtensions.<Property, CharSequence>map(_properties, _function);
    String _join = IterableExtensions.join(_map);
    _builder.append(_join, "	");
    _builder.newLineIfNotEmpty();
    {
      boolean _typesUseExtendibleProperties = this._schemaTypeExtensions.typesUseExtendibleProperties(profile);
      if (_typesUseExtendibleProperties) {
        _builder.append("\t");
        String _typesExtendiblePropertiesClause = this._schemaTypeExtensions.getTypesExtendiblePropertiesClause(profile);
        _builder.append(_typesExtendiblePropertiesClause, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</xsd:sequence>");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * Generate a sequence of elements for properties without a placeholder for future
   * backward compatible extensions of the ComplexType / BusinessObject
   * 
   * @param 		currNs	The VersionedDomainNamespace currently in use for the containing
   * XSD being generated
   * @param		profile	The SOAProfile defining the governing architecture rules.
   */
  protected CharSequence _toPropertySequence(final BusinessObject bo, final VersionedDomainNamespace currNs, final SOAProfile profile, final LifecycleState minState) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<xsd:sequence>");
    _builder.newLine();
    _builder.append("\t");
    EList<Property> _properties = bo.getProperties();
    final Function1<Property,CharSequence> _function = new Function1<Property,CharSequence>() {
        public CharSequence apply(final Property e) {
          CharSequence _property = XSDGenerator.this.toProperty(e, currNs, profile, minState);
          return _property;
        }
      };
    List<CharSequence> _map = ListExtensions.<Property, CharSequence>map(_properties, _function);
    String _join = IterableExtensions.join(_map);
    _builder.append(_join, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("</xsd:sequence>");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * Generate a sequence of elements for properties without a placeholder for future
   * backward compatible extensions of the ComplexType / BusinessObject
   * 
   * @param 		currNs	The VersionedDomainNamespace currently in use for the containing
   * XSD being generated
   * @param		profile	The SOAProfile defining the governing architecture rules.
   */
  protected CharSequence _toPropertySequence(final QueryObject qo, final VersionedDomainNamespace currNs, final SOAProfile profile, final LifecycleState minState) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<xsd:sequence>");
    _builder.newLine();
    _builder.append("\t");
    EList<Property> _properties = qo.getProperties();
    final Function1<Property,CharSequence> _function = new Function1<Property,CharSequence>() {
        public CharSequence apply(final Property e) {
          CharSequence _property = XSDGenerator.this.toProperty(e, currNs, profile, minState);
          return _property;
        }
      };
    List<CharSequence> _map = ListExtensions.<Property, CharSequence>map(_properties, _function);
    String _join = IterableExtensions.join(_map);
    _builder.append(_join, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("</xsd:sequence>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _toPropertySequenceWithAny(final org.fornax.soa.serviceDsl.Exception ex, final VersionedDomainNamespace currNs, final SOAProfile profile, final LifecycleState minState) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<xsd:sequence>");
    _builder.newLine();
    _builder.append("\t");
    EList<SimpleAttribute> _properties = ex.getProperties();
    final Function1<SimpleAttribute,CharSequence> _function = new Function1<SimpleAttribute,CharSequence>() {
        public CharSequence apply(final SimpleAttribute e) {
          CharSequence _property = XSDGenerator.this.toProperty(e, currNs, profile, minState);
          return _property;
        }
      };
    List<CharSequence> _map = ListExtensions.<SimpleAttribute, CharSequence>map(_properties, _function);
    String _join = IterableExtensions.join(_map);
    _builder.append(_join, "	");
    _builder.newLineIfNotEmpty();
    {
      boolean _typesUseExtendibleProperties = this._schemaTypeExtensions.typesUseExtendibleProperties(profile);
      if (_typesUseExtendibleProperties) {
        _builder.append("\t");
        String _typesExtendiblePropertiesClause = this._schemaTypeExtensions.getTypesExtendiblePropertiesClause(profile);
        _builder.append(_typesExtendiblePropertiesClause, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</xsd:sequence>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _toPropertySequence(final org.fornax.soa.serviceDsl.Exception ex, final VersionedDomainNamespace currNs, final SOAProfile profile, final LifecycleState minState) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<xsd:sequence>");
    _builder.newLine();
    _builder.append("\t");
    EList<SimpleAttribute> _properties = ex.getProperties();
    final Function1<SimpleAttribute,CharSequence> _function = new Function1<SimpleAttribute,CharSequence>() {
        public CharSequence apply(final SimpleAttribute e) {
          CharSequence _property = XSDGenerator.this.toProperty(e, currNs, profile, minState);
          return _property;
        }
      };
    List<CharSequence> _map = ListExtensions.<SimpleAttribute, CharSequence>map(_properties, _function);
    String _join = IterableExtensions.join(_map);
    _builder.append(_join, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("</xsd:sequence>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence toSimpleType(final Enumeration en, final LifecycleState minState) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("<xsd:simpleType name=\"");
    String _name = en.getName();
    _builder.append(_name, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<xsd:annotation>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<xsd:documentation>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<![CDATA[");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Version:\t\t\t");
    Version _version = en.getVersion();
    String _versionNumber = this.versionQualifier.toVersionNumber(_version);
    _builder.append(_versionNumber, "				");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.append("Lifecycle state: \t");
    LifecycleState _state = en.getState();
    String _name_1 = _state.getName();
    _builder.append(_name_1, "				");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    String _documentation = this.docProvider.getDocumentation(en);
    _builder.append(_documentation, "				");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("]]>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</xsd:documentation>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</xsd:annotation>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<xsd:restriction base=\"xsd:string\">");
    _builder.newLine();
    _builder.append("\t\t");
    EList<EnumLiteral> _literals = en.getLiterals();
    final Function1<EnumLiteral,CharSequence> _function = new Function1<EnumLiteral,CharSequence>() {
        public CharSequence apply(final EnumLiteral e) {
          CharSequence _enumLiteral = XSDGenerator.this.toEnumLiteral(e);
          return _enumLiteral;
        }
      };
    List<CharSequence> _map = ListExtensions.<EnumLiteral, CharSequence>map(_literals, _function);
    String _join = IterableExtensions.join(_map);
    _builder.append(_join, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</xsd:restriction>");
    _builder.newLine();
    _builder.append("</xsd:simpleType>");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * Generate a ComplexType for a given Exception. The ComplextType is being genereated for a containing
   * versioned XSD. Hence, the VersionedDomainNamespace on which the XSD is based is required.
   * 
   * @param 		currNs	The VersionedDomainNamespace currently in use for the containing
   * XSD being generated
   * @param		profile	The SOAProfile defining the governing architecture rules.
   */
  public CharSequence toFaultType(final org.fornax.soa.serviceDsl.Exception ex, final VersionedDomainNamespace currNs, final SOAProfile profile, final LifecycleState minState) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("<xsd:complexType name=\"");
    String _name = ex.getName();
    _builder.append(_name, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<xsd:annotation>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<xsd:documentation>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("<![CDATA[");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("Version:\t\t\t");
    Version _version = ex.getVersion();
    String _versionNumber = this.versionQualifier.toVersionNumber(_version);
    _builder.append(_versionNumber, "				");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t    ");
    _builder.append("Lifecycle state: \t");
    LifecycleState _state = ex.getState();
    String _name_1 = _state.getName();
    _builder.append(_name_1, "			    ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    String _documentation = this.docProvider.getDocumentation(ex);
    _builder.append(_documentation, "				");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("]]>   \t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("</xsd:documentation>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</xsd:annotation>");
    _builder.newLine();
    _builder.newLine();
    {
      ExceptionRef _superException = ex.getSuperException();
      boolean _notEquals = (!Objects.equal(_superException, null));
      if (_notEquals) {
        _builder.append("\t");
        _builder.append("<xsd:complexContent>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("<xsd:extension base=\"");
        ExceptionRef _superException_1 = ex.getSuperException();
        String _exceptionNameRef = this._schemaTypeExtensions.toExceptionNameRef(_superException_1, currNs);
        _builder.append(_exceptionNameRef, "		");
        _builder.append("\">");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        CharSequence _propertySequence = this.toPropertySequence(ex, currNs, profile, minState);
        _builder.append(_propertySequence, "			");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("</xsd:extension>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("</xsd:complexContent>");
        _builder.newLine();
      } else {
        _builder.append("\t");
        CharSequence _propertySequenceWithAny = this.toPropertySequenceWithAny(ex, currNs, profile, minState);
        _builder.append(_propertySequenceWithAny, "	");
        _builder.newLineIfNotEmpty();
        {
          boolean _typesUseExtendibleXMLAttributes = this._schemaTypeExtensions.typesUseExtendibleXMLAttributes(profile);
          if (_typesUseExtendibleXMLAttributes) {
            _builder.append("\t");
            String _typesExtendibleXMLAttributesClause = this._schemaTypeExtensions.getTypesExtendibleXMLAttributesClause(profile);
            _builder.append(_typesExtendibleXMLAttributesClause, "	");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("</xsd:complexType>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _toProperty(final Property attr, final VersionedDomainNamespace currNs, final SOAProfile profile, final LifecycleState minState) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _documentation = this.docProvider.getDocumentation(attr);
      boolean _notEquals = (!Objects.equal(_documentation, null));
      if (_notEquals) {
        _builder.append("<xsd:element name=\"");
        String _name = attr.getName();
        _builder.append(_name, "");
        _builder.append("\" ");
        CharSequence _elementCardinality = this.toElementCardinality(attr);
        _builder.append(_elementCardinality, "");
        _builder.append(" type=\"");
        TypeRef _type = attr.getType();
        String _typeNameRef = this._schemaTypeExtensions.toTypeNameRef(_type, currNs);
        _builder.append(_typeNameRef, "");
        _builder.append("\" ");
        {
          TypeRef _type_1 = attr.getType();
          boolean _isMimeContent = this._schemaTypeExtensions.isMimeContent(_type_1);
          if (_isMimeContent) {
            TypeRef _type_2 = attr.getType();
            CharSequence _mimeFragment = this.toMimeFragment(_type_2);
            _builder.append(_mimeFragment, "");
          }
        }
        _builder.append(" >");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("<xsd:annotation>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<xsd:documentation>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("<![CDATA[");
        String _documentation_1 = this.docProvider.getDocumentation(attr);
        _builder.append(_documentation_1, "			");
        _builder.append("]]>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("</xsd:documentation>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("</xsd:annotation>");
        _builder.newLine();
        _builder.append("</xsd:element>");
        _builder.newLine();
      } else {
        _builder.append("<xsd:element name=\"");
        String _name_1 = attr.getName();
        _builder.append(_name_1, "");
        _builder.append("\" ");
        CharSequence _elementCardinality_1 = this.toElementCardinality(attr);
        _builder.append(_elementCardinality_1, "");
        _builder.append(" type=\"");
        TypeRef _type_3 = attr.getType();
        String _typeNameRef_1 = this._schemaTypeExtensions.toTypeNameRef(_type_3, currNs);
        _builder.append(_typeNameRef_1, "");
        _builder.append("\" ");
        {
          TypeRef _type_4 = attr.getType();
          boolean _isMimeContent_1 = this._schemaTypeExtensions.isMimeContent(_type_4);
          if (_isMimeContent_1) {
            TypeRef _type_5 = attr.getType();
            CharSequence _mimeFragment_1 = this.toMimeFragment(_type_5);
            _builder.append(_mimeFragment_1, "");
          }
        }
        _builder.append(" />");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  protected CharSequence _toProperty(final SimpleAttribute attr, final VersionedDomainNamespace currNs, final SOAProfile profile, final LifecycleState minState) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _documentation = this.docProvider.getDocumentation(attr);
      boolean _equals = Objects.equal(_documentation, null);
      if (_equals) {
        _builder.append("<xsd:element name=\"");
        String _name = attr.getName();
        _builder.append(_name, "");
        _builder.append("\" ");
        CharSequence _elementCardinality = this.toElementCardinality(attr);
        _builder.append(_elementCardinality, "");
        _builder.append(" type=\"");
        TypeRef _type = attr.getType();
        String _typeNameRef = this._schemaTypeExtensions.toTypeNameRef(_type, currNs);
        _builder.append(_typeNameRef, "");
        _builder.append("\" ");
        {
          TypeRef _type_1 = attr.getType();
          boolean _isMimeContent = this._schemaTypeExtensions.isMimeContent(_type_1);
          if (_isMimeContent) {
            TypeRef _type_2 = attr.getType();
            CharSequence _mimeFragment = this.toMimeFragment(_type_2);
            _builder.append(_mimeFragment, "");
          }
        }
        _builder.append("/>");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("<xsd:element name=\"");
        String _name_1 = attr.getName();
        _builder.append(_name_1, "");
        _builder.append("\" ");
        CharSequence _elementCardinality_1 = this.toElementCardinality(attr);
        _builder.append(_elementCardinality_1, "");
        _builder.append(" type=\"");
        TypeRef _type_3 = attr.getType();
        String _typeNameRef_1 = this._schemaTypeExtensions.toTypeNameRef(_type_3, currNs);
        _builder.append(_typeNameRef_1, "");
        _builder.append("\" ");
        {
          TypeRef _type_4 = attr.getType();
          boolean _isMimeContent_1 = this._schemaTypeExtensions.isMimeContent(_type_4);
          if (_isMimeContent_1) {
            TypeRef _type_5 = attr.getType();
            CharSequence _mimeFragment_1 = this.toMimeFragment(_type_5);
            _builder.append(_mimeFragment_1, "");
          }
        }
        _builder.append(">");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("<xsd:annotation>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<xsd:documentation>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("<![CDATA[");
        String _documentation_1 = this.docProvider.getDocumentation(attr);
        _builder.append(_documentation_1, "			");
        _builder.append("]]>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("</xsd:documentation>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("</xsd:annotation>");
        _builder.newLine();
        _builder.append("</xsd:element>");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  private CharSequence toElementCardinality(final Property attr) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isOptionalElement = this._schemaTypeExtensions.isOptionalElement(attr);
      if (_isOptionalElement) {
        _builder.append("minOccurs=\"0\"");
      }
    }
    _builder.append(" ");
    {
      TypeRef _type = attr.getType();
      boolean _isMany = this._schemaTypeExtensions.isMany(_type);
      if (_isMany) {
        _builder.append("maxOccurs=\"unbounded\"");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private CharSequence toElementCardinality(final SimpleAttribute attr) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isOptional = attr.isOptional();
      if (_isOptional) {
        _builder.append("minOccurs=\"0\"");
      }
    }
    _builder.append(" ");
    {
      TypeRef _type = attr.getType();
      boolean _isMany = this._schemaTypeExtensions.isMany(_type);
      if (_isMany) {
        _builder.append("maxOccurs=\"unbounded\"");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence toEnumLiteral(final EnumLiteral enumLit) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<xsd:enumeration value=\"");
    String _name = enumLit.getName();
    _builder.append(_name, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence toMimeFragment(final TypeRef t) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("xmime:expectedContentTypes=\"application/octet-stream\"");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence toAttachmentMimeFragment(final DataTypeRef t) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _contentType = t.getContentType();
      boolean _notEquals = (!Objects.equal(_contentType, null));
      if (_notEquals) {
        _builder.append("xmime:expectedContentTypes=\"");
        String _contentType_1 = t.getContentType();
        _builder.append(_contentType_1, "");
        _builder.append("\"");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("xmime:expectedContentTypes=\"application/octet-stream\"");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public void toXSD(final Object ns, final Object minState, final SOAProfile profile, final String registryBaseUrl) {
    if (ns instanceof SubNamespace
         && minState instanceof LifecycleState) {
      _toXSD((SubNamespace)ns, (LifecycleState)minState, profile, registryBaseUrl);
      return;
    } else if (ns instanceof SubNamespace
         && minState instanceof String) {
      _toXSD((SubNamespace)ns, (String)minState, profile, registryBaseUrl);
      return;
    } else if (ns instanceof VersionedDomainNamespace
         && minState instanceof LifecycleState) {
      _toXSD((VersionedDomainNamespace)ns, (LifecycleState)minState, profile, registryBaseUrl);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ns, minState, profile, registryBaseUrl).toString());
    }
  }
  
  public void toXSD(final SubNamespace ns, final Object minState, final SOAProfile profile, final String registryBaseUrl, final boolean noDeps, final boolean includeSubNamespaces) {
    if (minState instanceof LifecycleState) {
      _toXSD(ns, (LifecycleState)minState, profile, registryBaseUrl, noDeps, includeSubNamespaces);
      return;
    } else if (minState instanceof String) {
      _toXSD(ns, (String)minState, profile, registryBaseUrl, noDeps, includeSubNamespaces);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ns, minState, profile, registryBaseUrl, noDeps, includeSubNamespaces).toString());
    }
  }
  
  public CharSequence toPropertySequenceWithAny(final EObject bo, final VersionedDomainNamespace currNs, final SOAProfile profile, final LifecycleState minState) {
    if (bo instanceof BusinessObject) {
      return _toPropertySequenceWithAny((BusinessObject)bo, currNs, profile, minState);
    } else if (bo instanceof QueryObject) {
      return _toPropertySequenceWithAny((QueryObject)bo, currNs, profile, minState);
    } else if (bo instanceof org.fornax.soa.serviceDsl.Exception) {
      return _toPropertySequenceWithAny((org.fornax.soa.serviceDsl.Exception)bo, currNs, profile, minState);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(bo, currNs, profile, minState).toString());
    }
  }
  
  public CharSequence toPropertySequence(final EObject bo, final VersionedDomainNamespace currNs, final SOAProfile profile, final LifecycleState minState) {
    if (bo instanceof BusinessObject) {
      return _toPropertySequence((BusinessObject)bo, currNs, profile, minState);
    } else if (bo instanceof QueryObject) {
      return _toPropertySequence((QueryObject)bo, currNs, profile, minState);
    } else if (bo instanceof org.fornax.soa.serviceDsl.Exception) {
      return _toPropertySequence((org.fornax.soa.serviceDsl.Exception)bo, currNs, profile, minState);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(bo, currNs, profile, minState).toString());
    }
  }
  
  public CharSequence toProperty(final EObject attr, final VersionedDomainNamespace currNs, final SOAProfile profile, final LifecycleState minState) {
    if (attr instanceof Property) {
      return _toProperty((Property)attr, currNs, profile, minState);
    } else if (attr instanceof SimpleAttribute) {
      return _toProperty((SimpleAttribute)attr, currNs, profile, minState);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(attr, currNs, profile, minState).toString());
    }
  }
}
