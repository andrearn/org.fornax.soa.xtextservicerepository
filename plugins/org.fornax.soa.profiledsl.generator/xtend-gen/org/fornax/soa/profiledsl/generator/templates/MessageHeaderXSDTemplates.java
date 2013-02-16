package org.fornax.soa.profiledsl.generator.templates;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.fornax.soa.basedsl.CommonStringExtensions;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.version.VersionMatcher;
import org.fornax.soa.basedsl.version.VersionQualifierExtensions;
import org.fornax.soa.profiledsl.generator.schema.ProfileSchemaNamespaceExtensions;
import org.fornax.soa.profiledsl.generator.schema.ProfileSchemaTypeExtensions;
import org.fornax.soa.profiledsl.query.namespace.TechnicalNamespaceImportQueries;
import org.fornax.soa.profiledsl.query.type.LatestMatchingTypeFinder;
import org.fornax.soa.profiledsl.sOAProfileDsl.AbstractProperty;
import org.fornax.soa.profiledsl.sOAProfileDsl.Attribute;
import org.fornax.soa.profiledsl.sOAProfileDsl.AttributeDataTypeRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.ClassRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.EnumLiteral;
import org.fornax.soa.profiledsl.sOAProfileDsl.Enumeration;
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader;
import org.fornax.soa.profiledsl.sOAProfileDsl.Messaging;
import org.fornax.soa.profiledsl.sOAProfileDsl.Property;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace;
import org.fornax.soa.profiledsl.sOAProfileDsl.Type;
import org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType;
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedTypeRef;
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher;
import org.fornax.soa.profiledsl.versioning.TechnicalNamespaceSplitter;
import org.fornax.soa.profiledsl.versioning.VersionedTechnicalNamespace;

/**
 * A template class to generate an XSD for a TechnicalNamespace
 * declaring the complextype used by message headers
 */
@SuppressWarnings("all")
public class MessageHeaderXSDTemplates {
  @Inject
  private IFileSystemAccess fsa;
  
  @Inject
  private IStateMatcher _iStateMatcher;
  
  @Inject
  private VersionMatcher _versionMatcher;
  
  @Inject
  private CommonStringExtensions _commonStringExtensions;
  
  @Inject
  private ProfileSchemaNamespaceExtensions _profileSchemaNamespaceExtensions;
  
  @Inject
  private ProfileSchemaTypeExtensions _profileSchemaTypeExtensions;
  
  @Inject
  private VersionQualifierExtensions _versionQualifierExtensions;
  
  @Inject
  private TechnicalNamespaceSplitter _technicalNamespaceSplitter;
  
  @Inject
  private TechnicalNamespaceImportQueries _technicalNamespaceImportQueries;
  
  @Inject
  private LatestMatchingTypeFinder _latestMatchingTypeFinder;
  
  @Inject
  private IEObjectDocumentationProvider docProvider;
  
  /**
   * <b>CARTRIDGE ENTRYPOINT</b> for generation message headers defined in the give SOAProfile<br/><br/>
   * 
   * An XSD for each TechnicalNamespace of all parameters of all message headers defined in
   * the SOAProfile will be generated
   */
  protected void _toMessageHeaderXSD(final SOAProfile profile) {
    Messaging _messaging = profile.getMessaging();
    EList<MessageHeader> _messageHeaders = _messaging.getMessageHeaders();
    for (final MessageHeader h : _messageHeaders) {
      EList<Property> _parameters = h.getParameters();
      final Function1<Property,TypeRef> _function = new Function1<Property,TypeRef>() {
          public TypeRef apply(final Property p) {
            TypeRef _type = p.getType();
            return _type;
          }
        };
      List<TypeRef> _map = ListExtensions.<Property, TypeRef>map(_parameters, _function);
      Iterable<VersionedTypeRef> _filter = Iterables.<VersionedTypeRef>filter(_map, VersionedTypeRef.class);
      final Function1<VersionedTypeRef,EObject> _function_1 = new Function1<VersionedTypeRef,EObject>() {
          public EObject apply(final VersionedTypeRef vRef) {
            VersionedType _type = vRef.getType();
            EObject _eContainer = _type.eContainer();
            return _eContainer;
          }
        };
      Iterable<EObject> _map_1 = IterableExtensions.<VersionedTypeRef, EObject>map(_filter, _function_1);
      Iterable<TechnicalNamespace> _filter_1 = Iterables.<TechnicalNamespace>filter(_map_1, TechnicalNamespace.class);
      Set<TechnicalNamespace> _set = IterableExtensions.<TechnicalNamespace>toSet(_filter_1);
      final Procedure1<TechnicalNamespace> _function_2 = new Procedure1<TechnicalNamespace>() {
          public void apply(final TechnicalNamespace ns) {
            MessageHeaderXSDTemplates.this.toMessageHeaderXSD(ns, profile, h);
          }
        };
      IterableExtensions.<TechnicalNamespace>forEach(_set, _function_2);
    }
  }
  
  /**
   * <b>CARTRIDGE ENTRYPOINT</b> for generation message headers defined in the give SOAProfile<br/><br/>
   * 
   * An XSD for each TechnicalNamespace of all parameters of all message headers defined in
   * the SOAProfile will be generated
   * Prefixes all imports with given registryBaseUrl. Referenced imported XSDs must be
   * available under the calculated URL
   */
  protected void _toAllMessageHeadersXSD(final SOAProfile profile) {
    Messaging _messaging = profile.getMessaging();
    EList<MessageHeader> _messageHeaders = _messaging.getMessageHeaders();
    for (final MessageHeader h : _messageHeaders) {
      EList<Property> _parameters = h.getParameters();
      final Function1<Property,TypeRef> _function = new Function1<Property,TypeRef>() {
          public TypeRef apply(final Property p) {
            TypeRef _type = p.getType();
            return _type;
          }
        };
      List<TypeRef> _map = ListExtensions.<Property, TypeRef>map(_parameters, _function);
      Iterable<VersionedTypeRef> _filter = Iterables.<VersionedTypeRef>filter(_map, VersionedTypeRef.class);
      final Function1<VersionedTypeRef,EObject> _function_1 = new Function1<VersionedTypeRef,EObject>() {
          public EObject apply(final VersionedTypeRef vRef) {
            VersionedType _type = vRef.getType();
            EObject _eContainer = _type.eContainer();
            return _eContainer;
          }
        };
      Iterable<EObject> _map_1 = IterableExtensions.<VersionedTypeRef, EObject>map(_filter, _function_1);
      Iterable<TechnicalNamespace> _filter_1 = Iterables.<TechnicalNamespace>filter(_map_1, TechnicalNamespace.class);
      Set<TechnicalNamespace> _set = IterableExtensions.<TechnicalNamespace>toSet(_filter_1);
      final Procedure1<TechnicalNamespace> _function_2 = new Procedure1<TechnicalNamespace>() {
          public void apply(final TechnicalNamespace ns) {
            MessageHeaderXSDTemplates.this.toMessageHeaderXSD(ns, profile, h);
          }
        };
      IterableExtensions.<TechnicalNamespace>forEach(_set, _function_2);
    }
  }
  
  protected void _toAllMessageHeadersXSD(final SOAProfile profile, final Void registryBaseUrl) {
    Messaging _messaging = profile.getMessaging();
    EList<MessageHeader> _messageHeaders = _messaging.getMessageHeaders();
    for (final MessageHeader h : _messageHeaders) {
      EList<Property> _parameters = h.getParameters();
      final Function1<Property,TypeRef> _function = new Function1<Property,TypeRef>() {
          public TypeRef apply(final Property p) {
            TypeRef _type = p.getType();
            return _type;
          }
        };
      List<TypeRef> _map = ListExtensions.<Property, TypeRef>map(_parameters, _function);
      Iterable<VersionedTypeRef> _filter = Iterables.<VersionedTypeRef>filter(_map, VersionedTypeRef.class);
      final Function1<VersionedTypeRef,EObject> _function_1 = new Function1<VersionedTypeRef,EObject>() {
          public EObject apply(final VersionedTypeRef vRef) {
            VersionedType _type = vRef.getType();
            EObject _eContainer = _type.eContainer();
            return _eContainer;
          }
        };
      Iterable<EObject> _map_1 = IterableExtensions.<VersionedTypeRef, EObject>map(_filter, _function_1);
      Iterable<TechnicalNamespace> _filter_1 = Iterables.<TechnicalNamespace>filter(_map_1, TechnicalNamespace.class);
      Set<TechnicalNamespace> _set = IterableExtensions.<TechnicalNamespace>toSet(_filter_1);
      final Procedure1<TechnicalNamespace> _function_2 = new Procedure1<TechnicalNamespace>() {
          public void apply(final TechnicalNamespace ns) {
            MessageHeaderXSDTemplates.this.toMessageHeaderXSD(ns, profile, h);
          }
        };
      IterableExtensions.<TechnicalNamespace>forEach(_set, _function_2);
    }
  }
  
  protected void _toAllMessageHeadersXSD(final SOAProfile profile, final String registryBaseUrl) {
    Messaging _messaging = profile.getMessaging();
    EList<MessageHeader> _messageHeaders = _messaging.getMessageHeaders();
    for (final MessageHeader h : _messageHeaders) {
      EList<Property> _parameters = h.getParameters();
      final Function1<Property,TypeRef> _function = new Function1<Property,TypeRef>() {
          public TypeRef apply(final Property p) {
            TypeRef _type = p.getType();
            return _type;
          }
        };
      List<TypeRef> _map = ListExtensions.<Property, TypeRef>map(_parameters, _function);
      Iterable<VersionedTypeRef> _filter = Iterables.<VersionedTypeRef>filter(_map, VersionedTypeRef.class);
      final Function1<VersionedTypeRef,EObject> _function_1 = new Function1<VersionedTypeRef,EObject>() {
          public EObject apply(final VersionedTypeRef vRef) {
            VersionedType _type = vRef.getType();
            EObject _eContainer = _type.eContainer();
            return _eContainer;
          }
        };
      Iterable<EObject> _map_1 = IterableExtensions.<VersionedTypeRef, EObject>map(_filter, _function_1);
      Iterable<TechnicalNamespace> _filter_1 = Iterables.<TechnicalNamespace>filter(_map_1, TechnicalNamespace.class);
      Set<TechnicalNamespace> _set = IterableExtensions.<TechnicalNamespace>toSet(_filter_1);
      final Procedure1<TechnicalNamespace> _function_2 = new Procedure1<TechnicalNamespace>() {
          public void apply(final TechnicalNamespace ns) {
            MessageHeaderXSDTemplates.this.toMessageHeaderXSD(ns, profile, registryBaseUrl, h);
          }
        };
      IterableExtensions.<TechnicalNamespace>forEach(_set, _function_2);
    }
  }
  
  protected void _toMessageHeaderXSD(final MessageHeader header, final SOAProfile profile) {
    EList<Property> _parameters = header.getParameters();
    final Function1<Property,TypeRef> _function = new Function1<Property,TypeRef>() {
        public TypeRef apply(final Property p) {
          TypeRef _type = p.getType();
          return _type;
        }
      };
    List<TypeRef> _map = ListExtensions.<Property, TypeRef>map(_parameters, _function);
    Iterable<VersionedTypeRef> _filter = Iterables.<VersionedTypeRef>filter(_map, VersionedTypeRef.class);
    final Function1<VersionedTypeRef,EObject> _function_1 = new Function1<VersionedTypeRef,EObject>() {
        public EObject apply(final VersionedTypeRef vRef) {
          VersionedType _type = vRef.getType();
          EObject _eContainer = _type.eContainer();
          return _eContainer;
        }
      };
    Iterable<EObject> _map_1 = IterableExtensions.<VersionedTypeRef, EObject>map(_filter, _function_1);
    Iterable<TechnicalNamespace> _filter_1 = Iterables.<TechnicalNamespace>filter(_map_1, TechnicalNamespace.class);
    Set<TechnicalNamespace> _set = IterableExtensions.<TechnicalNamespace>toSet(_filter_1);
    final Procedure1<TechnicalNamespace> _function_2 = new Procedure1<TechnicalNamespace>() {
        public void apply(final TechnicalNamespace ns) {
          MessageHeaderXSDTemplates.this.toMessageHeaderXSD(ns, profile, header);
        }
      };
    IterableExtensions.<TechnicalNamespace>forEach(_set, _function_2);
  }
  
  protected void _toMessageHeaderXSD(final MessageHeader header, final SOAProfile profile, final Void registryBaseUrl) {
    EList<Property> _parameters = header.getParameters();
    final Function1<Property,TypeRef> _function = new Function1<Property,TypeRef>() {
        public TypeRef apply(final Property p) {
          TypeRef _type = p.getType();
          return _type;
        }
      };
    List<TypeRef> _map = ListExtensions.<Property, TypeRef>map(_parameters, _function);
    Iterable<VersionedTypeRef> _filter = Iterables.<VersionedTypeRef>filter(_map, VersionedTypeRef.class);
    final Function1<VersionedTypeRef,EObject> _function_1 = new Function1<VersionedTypeRef,EObject>() {
        public EObject apply(final VersionedTypeRef vRef) {
          VersionedType _type = vRef.getType();
          EObject _eContainer = _type.eContainer();
          return _eContainer;
        }
      };
    Iterable<EObject> _map_1 = IterableExtensions.<VersionedTypeRef, EObject>map(_filter, _function_1);
    Iterable<TechnicalNamespace> _filter_1 = Iterables.<TechnicalNamespace>filter(_map_1, TechnicalNamespace.class);
    Set<TechnicalNamespace> _set = IterableExtensions.<TechnicalNamespace>toSet(_filter_1);
    final Procedure1<TechnicalNamespace> _function_2 = new Procedure1<TechnicalNamespace>() {
        public void apply(final TechnicalNamespace ns) {
          MessageHeaderXSDTemplates.this.toMessageHeaderXSD(ns, profile, header);
        }
      };
    IterableExtensions.<TechnicalNamespace>forEach(_set, _function_2);
  }
  
  protected void _toMessageHeaderXSD(final MessageHeader header, final SOAProfile profile, final String registryBaseUrl) {
    EList<Property> _parameters = header.getParameters();
    final Function1<Property,TypeRef> _function = new Function1<Property,TypeRef>() {
        public TypeRef apply(final Property p) {
          TypeRef _type = p.getType();
          return _type;
        }
      };
    List<TypeRef> _map = ListExtensions.<Property, TypeRef>map(_parameters, _function);
    Iterable<VersionedTypeRef> _filter = Iterables.<VersionedTypeRef>filter(_map, VersionedTypeRef.class);
    final Function1<VersionedTypeRef,EObject> _function_1 = new Function1<VersionedTypeRef,EObject>() {
        public EObject apply(final VersionedTypeRef vRef) {
          VersionedType _type = vRef.getType();
          EObject _eContainer = _type.eContainer();
          return _eContainer;
        }
      };
    Iterable<EObject> _map_1 = IterableExtensions.<VersionedTypeRef, EObject>map(_filter, _function_1);
    Iterable<TechnicalNamespace> _filter_1 = Iterables.<TechnicalNamespace>filter(_map_1, TechnicalNamespace.class);
    Set<TechnicalNamespace> _set = IterableExtensions.<TechnicalNamespace>toSet(_filter_1);
    final Procedure1<TechnicalNamespace> _function_2 = new Procedure1<TechnicalNamespace>() {
        public void apply(final TechnicalNamespace ns) {
          MessageHeaderXSDTemplates.this.toMessageHeaderXSD(ns, profile, registryBaseUrl, header);
        }
      };
    IterableExtensions.<TechnicalNamespace>forEach(_set, _function_2);
  }
  
  /**
   * Generate a message header XSD for each header defided inthe given profile
   * and for each major version of a TechnicalNamespace<br/><br/>
   * 
   * @param namespace			the TechnicalNamespace to generate XSDs for<br/>
   * @param profile			the Profile to be applied<br/>
   * @param header			the header definition of the profile to be selected for generation<br/>
   */
  protected void _toMessageHeaderXSD(final TechnicalNamespace namespace, final SOAProfile profile, final MessageHeader header) {
    Set<VersionedTechnicalNamespace> _versionedTechnicalNamespaces = this._technicalNamespaceSplitter.toVersionedTechnicalNamespaces(namespace);
    final Procedure1<VersionedTechnicalNamespace> _function = new Procedure1<VersionedTechnicalNamespace>() {
        public void apply(final VersionedTechnicalNamespace vns) {
          MessageHeaderXSDTemplates.this.toMessageHeaderXSD(vns, profile, header);
        }
      };
    IterableExtensions.<VersionedTechnicalNamespace>forEach(_versionedTechnicalNamespaces, _function);
  }
  
  /**
   * Generate a message header XSD for each header defided inthe given profile
   * and for each major version of a TechnicalNamespace<br/><br/>
   * 
   * @param namespace			the TechnicalNamespace to generate XSDs for<br/>
   * @param profile			the Profile to be applied<br/>
   * @param registryBaseUrl	Import URLs are prefixed with the registryBaseUrl<br/>
   * @param header			the header definition of the profile to be selected for generation<br/>
   */
  protected void _toMessageHeaderXSD(final TechnicalNamespace namespace, final SOAProfile profile, final String registryBaseUrl, final MessageHeader header) {
    Set<VersionedTechnicalNamespace> _versionedTechnicalNamespaces = this._technicalNamespaceSplitter.toVersionedTechnicalNamespaces(namespace);
    final Procedure1<VersionedTechnicalNamespace> _function = new Procedure1<VersionedTechnicalNamespace>() {
        public void apply(final VersionedTechnicalNamespace vns) {
          MessageHeaderXSDTemplates.this.toMessageHeaderXSD(vns, profile, registryBaseUrl, header);
        }
      };
    IterableExtensions.<VersionedTechnicalNamespace>forEach(_versionedTechnicalNamespaces, _function);
  }
  
  /**
   * Generates a message header XSD for a major version of a TechnicalNamespace
   */
  protected void _toMessageHeaderXSD(final VersionedTechnicalNamespace vns, final SOAProfile profile, final MessageHeader header) {
    Set<VersionedTechnicalNamespace> _allImportedVersionedNS = this._technicalNamespaceImportQueries.allImportedVersionedNS(vns);
    final Function1<VersionedTechnicalNamespace,Boolean> _function = new Function1<VersionedTechnicalNamespace,Boolean>() {
        public Boolean apply(final VersionedTechnicalNamespace e) {
          boolean _and = false;
          TechnicalNamespace _namespace = e.getNamespace();
          TechnicalNamespace _namespace_1 = vns.getNamespace();
          boolean _equals = Objects.equal(_namespace, _namespace_1);
          if (!_equals) {
            _and = false;
          } else {
            String _version = e.getVersion();
            String _majorVersionNumber = MessageHeaderXSDTemplates.this._versionQualifierExtensions.toMajorVersionNumber(_version);
            String _version_1 = vns.getVersion();
            String _majorVersionNumber_1 = MessageHeaderXSDTemplates.this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
            boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
            _and = (_equals && _equals_1);
          }
          boolean _not = (!_and);
          return Boolean.valueOf(_not);
        }
      };
    final Iterable<VersionedTechnicalNamespace> imports = IterableExtensions.<VersionedTechnicalNamespace>filter(_allImportedVersionedNS, _function);
    TechnicalNamespace _namespace = vns.getNamespace();
    EList<Type> _types = ((TechnicalNamespace) _namespace).getTypes();
    Iterable<org.fornax.soa.profiledsl.sOAProfileDsl.Class> _filter = Iterables.<org.fornax.soa.profiledsl.sOAProfileDsl.Class>filter(_types, org.fornax.soa.profiledsl.sOAProfileDsl.Class.class);
    final Function1<org.fornax.soa.profiledsl.sOAProfileDsl.Class,Boolean> _function_1 = new Function1<org.fornax.soa.profiledsl.sOAProfileDsl.Class,Boolean>() {
        public Boolean apply(final org.fornax.soa.profiledsl.sOAProfileDsl.Class e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          String _majorVersionNumber = MessageHeaderXSDTemplates.this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
          String _version_2 = vns.getVersion();
          String _majorVersionNumber_1 = MessageHeaderXSDTemplates.this._versionQualifierExtensions.toMajorVersionNumber(_version_2);
          boolean _equals = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
          return Boolean.valueOf(_equals);
        }
      };
    final Iterable<org.fornax.soa.profiledsl.sOAProfileDsl.Class> classes = IterableExtensions.<org.fornax.soa.profiledsl.sOAProfileDsl.Class>filter(_filter, _function_1);
    TechnicalNamespace _namespace_1 = vns.getNamespace();
    EList<Type> _types_1 = ((TechnicalNamespace) _namespace_1).getTypes();
    Iterable<Enumeration> _filter_1 = Iterables.<Enumeration>filter(_types_1, Enumeration.class);
    final Function1<Enumeration,Boolean> _function_2 = new Function1<Enumeration,Boolean>() {
        public Boolean apply(final Enumeration e) {
          String _version = vns.getVersion();
          String _majorVersionNumber = MessageHeaderXSDTemplates.this._versionQualifierExtensions.toMajorVersionNumber(_version);
          Integer _asInteger = MessageHeaderXSDTemplates.this._commonStringExtensions.asInteger(_majorVersionNumber);
          boolean _isLatestMatchingType = MessageHeaderXSDTemplates.this._latestMatchingTypeFinder.isLatestMatchingType(e, _asInteger);
          return Boolean.valueOf(_isLatestMatchingType);
        }
      };
    final Iterable<Enumeration> enumerations = IterableExtensions.<Enumeration>filter(_filter_1, _function_2);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    _builder.newLine();
    _builder.append("<xsd:schema xmlns:tns=\"");
    String _namespace_2 = this._profileSchemaNamespaceExtensions.toNamespace(vns);
    _builder.append(_namespace_2, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    Set<VersionedTechnicalNamespace> _allImportedVersionedNS_1 = this._technicalNamespaceImportQueries.allImportedVersionedNS(vns);
    final Function1<VersionedTechnicalNamespace,Boolean> _function_3 = new Function1<VersionedTechnicalNamespace,Boolean>() {
        public Boolean apply(final VersionedTechnicalNamespace e) {
          boolean _and = false;
          TechnicalNamespace _namespace = e.getNamespace();
          TechnicalNamespace _namespace_1 = vns.getNamespace();
          boolean _equals = Objects.equal(_namespace, _namespace_1);
          if (!_equals) {
            _and = false;
          } else {
            String _version = e.getVersion();
            String _majorVersionNumber = MessageHeaderXSDTemplates.this._versionQualifierExtensions.toMajorVersionNumber(_version);
            String _version_1 = vns.getVersion();
            String _majorVersionNumber_1 = MessageHeaderXSDTemplates.this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
            boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
            _and = (_equals && _equals_1);
          }
          boolean _not = (!_and);
          return Boolean.valueOf(_not);
        }
      };
    Iterable<VersionedTechnicalNamespace> _filter_2 = IterableExtensions.<VersionedTechnicalNamespace>filter(_allImportedVersionedNS_1, _function_3);
    final Function1<VersionedTechnicalNamespace,CharSequence> _function_4 = new Function1<VersionedTechnicalNamespace,CharSequence>() {
        public CharSequence apply(final VersionedTechnicalNamespace ns) {
          CharSequence _namespaceDeclaration = MessageHeaderXSDTemplates.this.toNamespaceDeclaration(ns);
          return _namespaceDeclaration;
        }
      };
    Iterable<CharSequence> _map = IterableExtensions.<VersionedTechnicalNamespace, CharSequence>map(_filter_2, _function_4);
    String _join = IterableExtensions.join(_map);
    _builder.append(_join, "	");
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("elementFormDefault=\"qualified\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("attributeFormDefault=\"unqualified\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("targetNamespace=\"");
    String _namespace_3 = this._profileSchemaNamespaceExtensions.toNamespace(vns);
    _builder.append(_namespace_3, "	");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(">");
    _builder.newLine();
    _builder.append("\t");
    final Function1<VersionedTechnicalNamespace,CharSequence> _function_5 = new Function1<VersionedTechnicalNamespace,CharSequence>() {
        public CharSequence apply(final VersionedTechnicalNamespace ns) {
          CharSequence _importDeclaration = MessageHeaderXSDTemplates.this.toImportDeclaration(ns);
          return _importDeclaration;
        }
      };
    Iterable<CharSequence> _map_1 = IterableExtensions.<VersionedTechnicalNamespace, CharSequence>map(imports, _function_5);
    String _join_1 = IterableExtensions.join(_map_1);
    _builder.append(_join_1, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    final Function1<org.fornax.soa.profiledsl.sOAProfileDsl.Class,CharSequence> _function_6 = new Function1<org.fornax.soa.profiledsl.sOAProfileDsl.Class,CharSequence>() {
        public CharSequence apply(final org.fornax.soa.profiledsl.sOAProfileDsl.Class t) {
          CharSequence _complexType = MessageHeaderXSDTemplates.this.toComplexType(t, vns, profile, header);
          return _complexType;
        }
      };
    Iterable<CharSequence> _map_2 = IterableExtensions.<org.fornax.soa.profiledsl.sOAProfileDsl.Class, CharSequence>map(classes, _function_6);
    String _join_2 = IterableExtensions.join(_map_2);
    _builder.append(_join_2, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    final Function1<Enumeration,CharSequence> _function_7 = new Function1<Enumeration,CharSequence>() {
        public CharSequence apply(final Enumeration t) {
          CharSequence _simpleType = MessageHeaderXSDTemplates.this.toSimpleType(t, profile);
          return _simpleType;
        }
      };
    Iterable<CharSequence> _map_3 = IterableExtensions.<Enumeration, CharSequence>map(enumerations, _function_7);
    String _join_3 = IterableExtensions.join(_map_3);
    _builder.append(_join_3, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("</xsd:schema>");
    _builder.newLine();
    final CharSequence content = _builder;
    String _fileNameFragment = this._profileSchemaNamespaceExtensions.toFileNameFragment(vns);
    final String xsdFileName = (_fileNameFragment + ".xsd");
    this.fsa.generateFile(xsdFileName, content);
  }
  
  protected void _toMessageHeaderXSD(final VersionedTechnicalNamespace vns, final SOAProfile profile, final String registryBaseUrl, final MessageHeader header) {
    Set<VersionedTechnicalNamespace> _allImportedVersionedNS = this._technicalNamespaceImportQueries.allImportedVersionedNS(vns);
    final Function1<VersionedTechnicalNamespace,Boolean> _function = new Function1<VersionedTechnicalNamespace,Boolean>() {
        public Boolean apply(final VersionedTechnicalNamespace e) {
          boolean _and = false;
          TechnicalNamespace _namespace = e.getNamespace();
          TechnicalNamespace _namespace_1 = vns.getNamespace();
          boolean _equals = Objects.equal(_namespace, _namespace_1);
          if (!_equals) {
            _and = false;
          } else {
            String _version = e.getVersion();
            String _majorVersionNumber = MessageHeaderXSDTemplates.this._versionQualifierExtensions.toMajorVersionNumber(_version);
            String _version_1 = vns.getVersion();
            String _majorVersionNumber_1 = MessageHeaderXSDTemplates.this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
            boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
            _and = (_equals && _equals_1);
          }
          boolean _not = (!_and);
          return Boolean.valueOf(_not);
        }
      };
    final Iterable<VersionedTechnicalNamespace> imports = IterableExtensions.<VersionedTechnicalNamespace>filter(_allImportedVersionedNS, _function);
    TechnicalNamespace _namespace = vns.getNamespace();
    EList<Type> _types = ((TechnicalNamespace) _namespace).getTypes();
    Iterable<org.fornax.soa.profiledsl.sOAProfileDsl.Class> _filter = Iterables.<org.fornax.soa.profiledsl.sOAProfileDsl.Class>filter(_types, org.fornax.soa.profiledsl.sOAProfileDsl.Class.class);
    final Function1<org.fornax.soa.profiledsl.sOAProfileDsl.Class,Boolean> _function_1 = new Function1<org.fornax.soa.profiledsl.sOAProfileDsl.Class,Boolean>() {
        public Boolean apply(final org.fornax.soa.profiledsl.sOAProfileDsl.Class e) {
          Version _version = e.getVersion();
          String _version_1 = _version.getVersion();
          String _majorVersionNumber = MessageHeaderXSDTemplates.this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
          String _version_2 = vns.getVersion();
          String _majorVersionNumber_1 = MessageHeaderXSDTemplates.this._versionQualifierExtensions.toMajorVersionNumber(_version_2);
          boolean _equals = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
          return Boolean.valueOf(_equals);
        }
      };
    final Iterable<org.fornax.soa.profiledsl.sOAProfileDsl.Class> classes = IterableExtensions.<org.fornax.soa.profiledsl.sOAProfileDsl.Class>filter(_filter, _function_1);
    TechnicalNamespace _namespace_1 = vns.getNamespace();
    EList<Type> _types_1 = ((TechnicalNamespace) _namespace_1).getTypes();
    Iterable<Enumeration> _filter_1 = Iterables.<Enumeration>filter(_types_1, Enumeration.class);
    final Function1<Enumeration,Boolean> _function_2 = new Function1<Enumeration,Boolean>() {
        public Boolean apply(final Enumeration e) {
          String _version = vns.getVersion();
          String _majorVersionNumber = MessageHeaderXSDTemplates.this._versionQualifierExtensions.toMajorVersionNumber(_version);
          Integer _asInteger = MessageHeaderXSDTemplates.this._commonStringExtensions.asInteger(_majorVersionNumber);
          boolean _isLatestMatchingType = MessageHeaderXSDTemplates.this._latestMatchingTypeFinder.isLatestMatchingType(e, _asInteger);
          return Boolean.valueOf(_isLatestMatchingType);
        }
      };
    final Iterable<Enumeration> enumerations = IterableExtensions.<Enumeration>filter(_filter_1, _function_2);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    _builder.newLine();
    _builder.append("<xsd:schema xmlns:tns=\"");
    String _namespace_2 = this._profileSchemaNamespaceExtensions.toNamespace(vns);
    _builder.append(_namespace_2, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    Set<VersionedTechnicalNamespace> _allImportedVersionedNS_1 = this._technicalNamespaceImportQueries.allImportedVersionedNS(vns);
    final Function1<VersionedTechnicalNamespace,Boolean> _function_3 = new Function1<VersionedTechnicalNamespace,Boolean>() {
        public Boolean apply(final VersionedTechnicalNamespace e) {
          boolean _and = false;
          TechnicalNamespace _namespace = e.getNamespace();
          TechnicalNamespace _namespace_1 = vns.getNamespace();
          boolean _equals = Objects.equal(_namespace, _namespace_1);
          if (!_equals) {
            _and = false;
          } else {
            String _version = e.getVersion();
            String _majorVersionNumber = MessageHeaderXSDTemplates.this._versionQualifierExtensions.toMajorVersionNumber(_version);
            String _version_1 = vns.getVersion();
            String _majorVersionNumber_1 = MessageHeaderXSDTemplates.this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
            boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
            _and = (_equals && _equals_1);
          }
          boolean _not = (!_and);
          return Boolean.valueOf(_not);
        }
      };
    Iterable<VersionedTechnicalNamespace> _filter_2 = IterableExtensions.<VersionedTechnicalNamespace>filter(_allImportedVersionedNS_1, _function_3);
    final Procedure1<VersionedTechnicalNamespace> _function_4 = new Procedure1<VersionedTechnicalNamespace>() {
        public void apply(final VersionedTechnicalNamespace ns) {
          MessageHeaderXSDTemplates.this.toNamespaceDeclaration(ns);
        }
      };
    IterableExtensions.<VersionedTechnicalNamespace>forEach(_filter_2, _function_4);
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("elementFormDefault=\"qualified\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("attributeFormDefault=\"unqualified\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("targetNamespace=\"");
    String _namespace_3 = this._profileSchemaNamespaceExtensions.toNamespace(vns);
    _builder.append(_namespace_3, "	");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append(">");
    _builder.newLine();
    _builder.append("\t");
    final Function1<VersionedTechnicalNamespace,CharSequence> _function_5 = new Function1<VersionedTechnicalNamespace,CharSequence>() {
        public CharSequence apply(final VersionedTechnicalNamespace ns) {
          CharSequence _importDeclaration = MessageHeaderXSDTemplates.this.toImportDeclaration(ns, registryBaseUrl);
          return _importDeclaration;
        }
      };
    Iterable<CharSequence> _map = IterableExtensions.<VersionedTechnicalNamespace, CharSequence>map(imports, _function_5);
    String _join = IterableExtensions.join(_map);
    _builder.append(_join, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    final Function1<org.fornax.soa.profiledsl.sOAProfileDsl.Class,CharSequence> _function_6 = new Function1<org.fornax.soa.profiledsl.sOAProfileDsl.Class,CharSequence>() {
        public CharSequence apply(final org.fornax.soa.profiledsl.sOAProfileDsl.Class t) {
          CharSequence _complexType = MessageHeaderXSDTemplates.this.toComplexType(t, vns, profile, header);
          return _complexType;
        }
      };
    Iterable<CharSequence> _map_1 = IterableExtensions.<org.fornax.soa.profiledsl.sOAProfileDsl.Class, CharSequence>map(classes, _function_6);
    String _join_1 = IterableExtensions.join(_map_1);
    _builder.append(_join_1, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    final Function1<Enumeration,CharSequence> _function_7 = new Function1<Enumeration,CharSequence>() {
        public CharSequence apply(final Enumeration t) {
          CharSequence _simpleType = MessageHeaderXSDTemplates.this.toSimpleType(t, profile);
          return _simpleType;
        }
      };
    Iterable<CharSequence> _map_2 = IterableExtensions.<Enumeration, CharSequence>map(enumerations, _function_7);
    String _join_2 = IterableExtensions.join(_map_2);
    _builder.append(_join_2, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.newLine();
    _builder.append("</xsd:schema>");
    _builder.newLine();
    final CharSequence content = _builder;
    String _fileNameFragment = this._profileSchemaNamespaceExtensions.toFileNameFragment(vns);
    final String xsdFileName = (_fileNameFragment + ".xsd");
    this.fsa.generateFile(xsdFileName, content);
  }
  
  protected CharSequence _toNamespaceDeclaration(final VersionedTechnicalNamespace vns) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("xmlns:");
    String _prefix = this._profileSchemaNamespaceExtensions.toPrefix(vns);
    String _version = vns.getVersion();
    String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_version);
    String _plus = (_prefix + _majorVersionNumber);
    _builder.append(_plus, "");
    _builder.append("=\"");
    String _namespace = this._profileSchemaNamespaceExtensions.toNamespace(vns);
    _builder.append(_namespace, "");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _toImportDeclaration(final VersionedTechnicalNamespace vns) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<xsd:import schemaLocation=\"");
    String _registryAssetUrl = this._profileSchemaNamespaceExtensions.toRegistryAssetUrl(vns, null);
    _builder.append(_registryAssetUrl, "");
    _builder.append(".xsd\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("namespace=\"");
    String _namespace = this._profileSchemaNamespaceExtensions.toNamespace(vns);
    _builder.append(_namespace, "	");
    _builder.append("\"></xsd:import>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _toImportDeclaration(final VersionedTechnicalNamespace vns, final String registryBaseUrl) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<xsd:import schemaLocation=\"");
    String _registryAssetUrl = this._profileSchemaNamespaceExtensions.toRegistryAssetUrl(vns, registryBaseUrl);
    _builder.append(_registryAssetUrl, "");
    _builder.append(".xsd\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("namespace=\"");
    String _namespace = this._profileSchemaNamespaceExtensions.toNamespace(vns);
    _builder.append(_namespace, "	");
    _builder.append("\"></xsd:import>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _toComplexType(final org.fornax.soa.profiledsl.sOAProfileDsl.Class cls, final VersionedTechnicalNamespace currNs, final SOAProfile profile, final MessageHeader header) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("<xsd:complexType name=\"");
    String _name = cls.getName();
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
    _builder.append("Version:\t");
    Version _version = cls.getVersion();
    String _versionNumber = this._versionQualifierExtensions.toVersionNumber(_version);
    _builder.append(_versionNumber, "				");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t\t\t\t");
    String _documentation = this.docProvider.getDocumentation(cls);
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
    _builder.newLine();
    {
      ClassRef _superClass = cls.getSuperClass();
      boolean _notEquals = (!Objects.equal(_superClass, null));
      if (_notEquals) {
        _builder.append("\t");
        _builder.append("<xsd:complexContent>");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("<xsd:extension base=\"");
        ClassRef _superClass_1 = cls.getSuperClass();
        String _typeNameRef = this._profileSchemaTypeExtensions.toTypeNameRef(_superClass_1, currNs);
        _builder.append(_typeNameRef, "		");
        _builder.append("\">");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t\t");
        CharSequence _propertySequence = this.toPropertySequence(cls, currNs, profile);
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
        CharSequence _propertySequenceWithAny = this.toPropertySequenceWithAny(cls, currNs, profile, header);
        _builder.append(_propertySequenceWithAny, "	");
        _builder.newLineIfNotEmpty();
        {
          boolean _typesUseExtendibleXMLAttributes = this._profileSchemaTypeExtensions.typesUseExtendibleXMLAttributes(header);
          if (_typesUseExtendibleXMLAttributes) {
            _builder.append("\t");
            String _typesExtendibleXMLAttributesClause = this._profileSchemaTypeExtensions.getTypesExtendibleXMLAttributesClause(header);
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
  
  protected CharSequence _toPropertySequenceWithAny(final org.fornax.soa.profiledsl.sOAProfileDsl.Class cls, final VersionedTechnicalNamespace currNs, final SOAProfile profile, final MessageHeader header) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<xsd:sequence>");
    _builder.newLine();
    _builder.append("\t");
    EList<AbstractProperty> _properties = cls.getProperties();
    Iterable<Property> _filter = Iterables.<Property>filter(_properties, Property.class);
    final Function1<Property,CharSequence> _function = new Function1<Property,CharSequence>() {
        public CharSequence apply(final Property p) {
          CharSequence _property = MessageHeaderXSDTemplates.this.toProperty(p, currNs, profile);
          return _property;
        }
      };
    Iterable<CharSequence> _map = IterableExtensions.<Property, CharSequence>map(_filter, _function);
    String _join = IterableExtensions.join(_map);
    _builder.append(_join, "	");
    _builder.newLineIfNotEmpty();
    {
      boolean _typesUseExtendibleProperties = this._profileSchemaTypeExtensions.typesUseExtendibleProperties(header);
      if (_typesUseExtendibleProperties) {
        _builder.append("\t");
        String _typesExtendiblePropertiesClause = this._profileSchemaTypeExtensions.getTypesExtendiblePropertiesClause(header);
        _builder.append(_typesExtendiblePropertiesClause, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</xsd:sequence>");
    _builder.newLine();
    {
      EList<AbstractProperty> _properties_1 = cls.getProperties();
      Iterable<Attribute> _filter_1 = Iterables.<Attribute>filter(_properties_1, Attribute.class);
      boolean _isEmpty = IterableExtensions.isEmpty(_filter_1);
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.newLine();
        EList<AbstractProperty> _properties_2 = cls.getProperties();
        Iterable<Attribute> _filter_2 = Iterables.<Attribute>filter(_properties_2, Attribute.class);
        final Function1<Attribute,CharSequence> _function_1 = new Function1<Attribute,CharSequence>() {
            public CharSequence apply(final Attribute a) {
              CharSequence _property = MessageHeaderXSDTemplates.this.toProperty(a, currNs, profile);
              return _property;
            }
          };
        Iterable<CharSequence> _map_1 = IterableExtensions.<Attribute, CharSequence>map(_filter_2, _function_1);
        String _join_1 = IterableExtensions.join(_map_1);
        _builder.append(_join_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  protected CharSequence _toPropertySequence(final org.fornax.soa.profiledsl.sOAProfileDsl.Class cls, final VersionedTechnicalNamespace currNs, final SOAProfile profile) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<xsd:sequence>");
    _builder.newLine();
    _builder.append("\t");
    EList<AbstractProperty> _properties = cls.getProperties();
    Iterable<Property> _filter = Iterables.<Property>filter(_properties, Property.class);
    final Function1<Property,CharSequence> _function = new Function1<Property,CharSequence>() {
        public CharSequence apply(final Property p) {
          CharSequence _property = MessageHeaderXSDTemplates.this.toProperty(p, currNs, profile);
          return _property;
        }
      };
    Iterable<CharSequence> _map = IterableExtensions.<Property, CharSequence>map(_filter, _function);
    String _join = IterableExtensions.join(_map);
    _builder.append(_join, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("</xsd:sequence>");
    _builder.newLine();
    {
      EList<AbstractProperty> _properties_1 = cls.getProperties();
      Iterable<Attribute> _filter_1 = Iterables.<Attribute>filter(_properties_1, Attribute.class);
      boolean _isEmpty = IterableExtensions.isEmpty(_filter_1);
      boolean _not = (!_isEmpty);
      if (_not) {
        _builder.newLine();
        EList<AbstractProperty> _properties_2 = cls.getProperties();
        Iterable<Attribute> _filter_2 = Iterables.<Attribute>filter(_properties_2, Attribute.class);
        final Function1<Attribute,CharSequence> _function_1 = new Function1<Attribute,CharSequence>() {
            public CharSequence apply(final Attribute a) {
              CharSequence _property = MessageHeaderXSDTemplates.this.toProperty(a, currNs, profile);
              return _property;
            }
          };
        Iterable<CharSequence> _map_1 = IterableExtensions.<Attribute, CharSequence>map(_filter_2, _function_1);
        String _join_1 = IterableExtensions.join(_map_1);
        _builder.append(_join_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  protected CharSequence _toSimpleType(final Enumeration enumeration, final SOAProfile profile) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<xsd:simpleType name=\"");
    String _name = enumeration.getName();
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
    _builder.append("\t\t\t");
    _builder.append("Version:\t");
    Version _version = enumeration.getVersion();
    String _versionNumber = this._versionQualifierExtensions.toVersionNumber(_version);
    _builder.append(_versionNumber, "			");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    String _documentation = this.docProvider.getDocumentation(enumeration);
    _builder.append(_documentation, "			");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("]]> ");
    _builder.newLine();
    _builder.append("   \t\t");
    _builder.append("</xsd:documentation>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</xsd:annotation>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<xsd:restriction base=\"xsd:string\">");
    _builder.newLine();
    _builder.append("\t\t");
    EList<EnumLiteral> _literals = enumeration.getLiterals();
    final Procedure1<EnumLiteral> _function = new Procedure1<EnumLiteral>() {
        public void apply(final EnumLiteral lit) {
          MessageHeaderXSDTemplates.this.toEnumLiteral(lit, profile);
        }
      };
    IterableExtensions.<EnumLiteral>forEach(_literals, _function);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</xsd:restriction>");
    _builder.newLine();
    _builder.append("</xsd:simpleType>");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _toProperty(final Property prop, final VersionedTechnicalNamespace currNs, final SOAProfile profile) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _documentation = this.docProvider.getDocumentation(prop);
      boolean _equals = Objects.equal(_documentation, null);
      if (_equals) {
        _builder.append("<xsd:element name=\"");
        String _name = prop.getName();
        _builder.append(_name, "");
        _builder.append("\" ");
        {
          boolean _isOptional = prop.isOptional();
          if (_isOptional) {
            _builder.append("minOccurs=\"0\"");
          }
        }
        _builder.append(" ");
        {
          TypeRef _type = prop.getType();
          boolean _isMany = _type.isMany();
          if (_isMany) {
            _builder.append("maxOccurs=\"unbounded\"");
          }
        }
        _builder.append(" type=\"");
        TypeRef _type_1 = prop.getType();
        String _typeNameRef = this._profileSchemaTypeExtensions.toTypeNameRef(_type_1, currNs);
        _builder.append(_typeNameRef, "");
        _builder.append("\" />");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("<xsd:element name=\"");
        String _name_1 = prop.getName();
        _builder.append(_name_1, "");
        _builder.append("\" ");
        {
          boolean _isOptional_1 = prop.isOptional();
          if (_isOptional_1) {
            _builder.append("minOccurs=\"0\"");
          }
        }
        _builder.append(" ");
        {
          TypeRef _type_2 = prop.getType();
          boolean _isMany_1 = _type_2.isMany();
          if (_isMany_1) {
            _builder.append("maxOccurs=\"unbounded\"");
          }
        }
        _builder.append(" type=\"");
        TypeRef _type_3 = prop.getType();
        String _typeNameRef_1 = this._profileSchemaTypeExtensions.toTypeNameRef(_type_3, currNs);
        _builder.append(_typeNameRef_1, "");
        _builder.append("\" >");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("<xsd:annotation>");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("<xsd:documentation>");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("<![CDATA[");
        String _documentation_1 = this.docProvider.getDocumentation(prop);
        _builder.append(_documentation_1, "			");
        _builder.append("]]>");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("</xsd:documentation>");
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
  
  protected CharSequence _toProperty(final Attribute attr, final VersionedTechnicalNamespace currNs, final SOAProfile profile) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _documentation = this.docProvider.getDocumentation(attr);
      boolean _equals = Objects.equal(_documentation, null);
      if (_equals) {
        _builder.append("<xsd:attribute name=\"");
        String _name = attr.getName();
        _builder.append(_name, "");
        _builder.append("\" ");
        {
          boolean _isOptional = attr.isOptional();
          if (_isOptional) {
            _builder.append("use=\"optional\"");
          }
        }
        _builder.append(" type=\"");
        AttributeDataTypeRef _type = attr.getType();
        String _typeNameRef = this._profileSchemaTypeExtensions.toTypeNameRef(_type, currNs);
        _builder.append(_typeNameRef, "");
        _builder.append("\" />");
        _builder.newLineIfNotEmpty();
      } else {
        _builder.append("<xsd:attribute name=\"");
        String _name_1 = attr.getName();
        _builder.append(_name_1, "");
        _builder.append("\" ");
        {
          boolean _isOptional_1 = attr.isOptional();
          if (_isOptional_1) {
            _builder.append("use=\"optional\"");
          }
        }
        _builder.append(" type=\"");
        AttributeDataTypeRef _type_1 = attr.getType();
        String _typeNameRef_1 = this._profileSchemaTypeExtensions.toTypeNameRef(_type_1, currNs);
        _builder.append(_typeNameRef_1, "");
        _builder.append("\" >");
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
        _builder.append("\t");
        _builder.append("</xsd:annotation>");
        _builder.newLine();
        _builder.append("</xsd:attribute>");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  protected CharSequence _toEnumLiteral(final EnumLiteral enumLit, final SOAProfile profile) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<xsd:enumeration value=\"");
    String _name = enumLit.getName();
    _builder.append(_name, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public void toMessageHeaderXSD(final SOAProfile profile) {
    {
      _toMessageHeaderXSD(profile);
      return;
    }
  }
  
  public void toAllMessageHeadersXSD(final SOAProfile profile) {
    {
      _toAllMessageHeadersXSD(profile);
      return;
    }
  }
  
  public void toAllMessageHeadersXSD(final SOAProfile profile, final String registryBaseUrl) {
    if (registryBaseUrl != null) {
      _toAllMessageHeadersXSD(profile, registryBaseUrl);
      return;
    } else if (registryBaseUrl == null) {
      _toAllMessageHeadersXSD(profile, (Void)null);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(profile, registryBaseUrl).toString());
    }
  }
  
  public void toMessageHeaderXSD(final MessageHeader header, final SOAProfile profile) {
    {
      _toMessageHeaderXSD(header, profile);
      return;
    }
  }
  
  public void toMessageHeaderXSD(final Object namespace, final SOAProfile profile, final Object header) {
    if (namespace instanceof TechnicalNamespace
         && header instanceof MessageHeader) {
      _toMessageHeaderXSD((TechnicalNamespace)namespace, profile, (MessageHeader)header);
      return;
    } else if (namespace instanceof MessageHeader
         && header instanceof String) {
      _toMessageHeaderXSD((MessageHeader)namespace, profile, (String)header);
      return;
    } else if (namespace instanceof MessageHeader
         && header == null) {
      _toMessageHeaderXSD((MessageHeader)namespace, profile, (Void)null);
      return;
    } else if (namespace instanceof VersionedTechnicalNamespace
         && header instanceof MessageHeader) {
      _toMessageHeaderXSD((VersionedTechnicalNamespace)namespace, profile, (MessageHeader)header);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(namespace, profile, header).toString());
    }
  }
  
  public void toMessageHeaderXSD(final Object namespace, final SOAProfile profile, final String registryBaseUrl, final MessageHeader header) {
    if (namespace instanceof TechnicalNamespace) {
      _toMessageHeaderXSD((TechnicalNamespace)namespace, profile, registryBaseUrl, header);
      return;
    } else if (namespace instanceof VersionedTechnicalNamespace) {
      _toMessageHeaderXSD((VersionedTechnicalNamespace)namespace, profile, registryBaseUrl, header);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(namespace, profile, registryBaseUrl, header).toString());
    }
  }
  
  protected CharSequence toNamespaceDeclaration(final VersionedTechnicalNamespace vns) {
    {
      return _toNamespaceDeclaration(vns);
    }
  }
  
  protected CharSequence toImportDeclaration(final VersionedTechnicalNamespace vns) {
    {
      return _toImportDeclaration(vns);
    }
  }
  
  protected CharSequence toImportDeclaration(final VersionedTechnicalNamespace vns, final String registryBaseUrl) {
    {
      return _toImportDeclaration(vns, registryBaseUrl);
    }
  }
  
  protected CharSequence toComplexType(final org.fornax.soa.profiledsl.sOAProfileDsl.Class cls, final VersionedTechnicalNamespace currNs, final SOAProfile profile, final MessageHeader header) {
    {
      return _toComplexType(cls, currNs, profile, header);
    }
  }
  
  protected CharSequence toPropertySequenceWithAny(final org.fornax.soa.profiledsl.sOAProfileDsl.Class cls, final VersionedTechnicalNamespace currNs, final SOAProfile profile, final MessageHeader header) {
    {
      return _toPropertySequenceWithAny(cls, currNs, profile, header);
    }
  }
  
  protected CharSequence toPropertySequence(final org.fornax.soa.profiledsl.sOAProfileDsl.Class cls, final VersionedTechnicalNamespace currNs, final SOAProfile profile) {
    {
      return _toPropertySequence(cls, currNs, profile);
    }
  }
  
  protected CharSequence toSimpleType(final Enumeration enumeration, final SOAProfile profile) {
    {
      return _toSimpleType(enumeration, profile);
    }
  }
  
  protected CharSequence toProperty(final AbstractProperty attr, final VersionedTechnicalNamespace currNs, final SOAProfile profile) {
    if (attr instanceof Attribute) {
      return _toProperty((Attribute)attr, currNs, profile);
    } else if (attr instanceof Property) {
      return _toProperty((Property)attr, currNs, profile);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(attr, currNs, profile).toString());
    }
  }
  
  protected CharSequence toEnumLiteral(final EnumLiteral enumLit, final SOAProfile profile) {
    {
      return _toEnumLiteral(enumLit, profile);
    }
  }
}
