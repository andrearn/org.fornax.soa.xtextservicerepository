package org.fornax.soa.servicedsl.generator.templates.xsd;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.basedsl.version.VersionMatcher;
import org.fornax.soa.basedsl.version.VersionQualifierExtensions;
import org.fornax.soa.profiledsl.generator.schema.ProfileSchemaNamespaceExtensions;
import org.fornax.soa.profiledsl.generator.schema.ProfileSchemaTypeExtensions;
import org.fornax.soa.profiledsl.query.LifecycleQueries;
import org.fornax.soa.profiledsl.query.namespace.TechnicalNamespaceQueries;
import org.fornax.soa.profiledsl.sOAProfileDsl.AttributeDataTypeRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.ClassRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.DataType;
import org.fornax.soa.profiledsl.sOAProfileDsl.DesignRules;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace;
import org.fornax.soa.profiledsl.sOAProfileDsl.Type;
import org.fornax.soa.profiledsl.sOAProfileDsl.TypeDefPolicy;
import org.fornax.soa.profiledsl.sOAProfileDsl.TypeVersionEvolution;
import org.fornax.soa.service.VersionedDomainNamespace;
import org.fornax.soa.service.namespace.NamespaceSplitter;
import org.fornax.soa.service.query.VersionQueries;
import org.fornax.soa.service.query.namespace.NamespaceQuery;
import org.fornax.soa.service.query.type.BusinessObjectQueries;
import org.fornax.soa.service.versioning.IExceptionResolver;
import org.fornax.soa.service.versioning.ITypeResolver;
import org.fornax.soa.serviceDsl.Attribute;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.BusinessObjectRef;
import org.fornax.soa.serviceDsl.DataTypeRef;
import org.fornax.soa.serviceDsl.EnumTypeRef;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.serviceDsl.ExceptionRef;
import org.fornax.soa.serviceDsl.Property;
import org.fornax.soa.serviceDsl.QueryObject;
import org.fornax.soa.serviceDsl.QueryObjectRef;
import org.fornax.soa.serviceDsl.Reference;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.serviceDsl.VersionedType;
import org.fornax.soa.serviceDsl.VersionedTypeRef;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions;

/**
 * Extension functions Type representations and references in XSDs
 */
@SuppressWarnings("all")
public class SchemaTypeExtensions {
  @Inject
  private VersionMatcher _versionMatcher;
  
  @Inject
  private SchemaNamespaceExtensions _schemaNamespaceExtensions;
  
  @Inject
  private NamespaceQuery _namespaceQuery;
  
  @Inject
  private NamespaceSplitter _namespaceSplitter;
  
  @Inject
  private VersionQualifierExtensions _versionQualifierExtensions;
  
  @Inject
  private LifecycleQueries _lifecycleQueries;
  
  @Inject
  private VersionQueries _versionQueries;
  
  @Inject
  private ITypeResolver _iTypeResolver;
  
  @Inject
  private BusinessObjectQueries _businessObjectQueries;
  
  @Inject
  private IExceptionResolver _iExceptionResolver;
  
  @Inject
  private ProfileSchemaTypeExtensions profileSchemaTypes;
  
  @Inject
  private TechnicalNamespaceQueries profileNSQueries;
  
  @Inject
  private ProfileSchemaNamespaceExtensions profileSchemaNSExt;
  
  /**
   * Return the XSD type name for a type reference including it's derived namespace prefix
   */
  protected String _toTypeNameRef(final TypeRef t) {
    return null;
  }
  
  protected String _toTypeNameRef(final org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef t) {
    return null;
  }
  
  protected String _toTypeNameRef(final DataTypeRef t) {
    DataType _type = t.getType();
    String _typeNameRef = this.toTypeNameRef(_type);
    return _typeNameRef;
  }
  
  protected String _toTypeNameRef(final DataType t) {
    String _typeNameRef = this.profileSchemaTypes.toTypeNameRef(t);
    return _typeNameRef;
  }
  
  protected String _toTypeNameRef(final org.fornax.soa.profiledsl.sOAProfileDsl.DataTypeRef t) {
    DataType _type = t.getType();
    String _typeNameRef = this.toTypeNameRef(_type);
    return _typeNameRef;
  }
  
  protected String _toTypeNameRef(final AttributeDataTypeRef t) {
    DataType _type = t.getType();
    String _typeNameRef = this.toTypeNameRef(_type);
    return _typeNameRef;
  }
  
  protected String _toTypeNameRef(final VersionedTypeRef t) {
    String _xifexpression = null;
    VersionedType _type = t.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    boolean _notEquals = (!Objects.equal(_findSubdomain, null));
    if (_notEquals) {
      String _xblockexpression = null;
      {
        String prefix = "tns";
        boolean _and = false;
        boolean _and_1 = false;
        SubNamespace _findRefOwnerSubdomain = this._namespaceQuery.findRefOwnerSubdomain(t);
        VersionedType _type_1 = t.getType();
        SubNamespace _findSubdomain_1 = this._namespaceQuery.findSubdomain(_type_1);
        boolean _equals = Objects.equal(_findRefOwnerSubdomain, _findSubdomain_1);
        if (!_equals) {
          _and_1 = false;
        } else {
          Version _ownerVersion = this._versionQueries.getOwnerVersion(t);
          String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_ownerVersion);
          VersionedType _type_2 = t.getType();
          Version _version = _type_2.getVersion();
          String _majorVersionNumber_1 = this._versionQualifierExtensions.toMajorVersionNumber(_version);
          boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
          _and_1 = (_equals && _equals_1);
        }
        if (!_and_1) {
          _and = false;
        } else {
          EObject _statefulOwner = this._lifecycleQueries.getStatefulOwner(t);
          boolean _not = (!(_statefulOwner instanceof Service));
          _and = (_and_1 && _not);
        }
        boolean _not_1 = (!_and);
        if (_not_1) {
          VersionedType _type_3 = t.getType();
          SubNamespace _findSubdomain_2 = this._namespaceQuery.findSubdomain(_type_3);
          String _shortName = this._schemaNamespaceExtensions.toShortName(_findSubdomain_2);
          VersionedType _type_4 = t.getType();
          Version _version_1 = _type_4.getVersion();
          String _majorVersionNumber_2 = this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
          String _plus = (_shortName + _majorVersionNumber_2);
          prefix = _plus;
        }
        String _plus_1 = (prefix + ":");
        VersionedType _type_5 = t.getType();
        String _name = _type_5.getName();
        String _plus_2 = (_plus_1 + _name);
        _xblockexpression = (_plus_2);
      }
      _xifexpression = _xblockexpression;
    } else {
      VersionedType _type_1 = t.getType();
      String _name = _type_1.getName();
      _xifexpression = _name;
    }
    return _xifexpression;
  }
  
  protected String _toTypeNameRef(final org.fornax.soa.profiledsl.sOAProfileDsl.VersionedTypeRef t) {
    String _xifexpression = null;
    org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType _type = t.getType();
    TechnicalNamespace _findTechnicalNamespace = this.profileNSQueries.findTechnicalNamespace(_type);
    boolean _notEquals = (!Objects.equal(_findTechnicalNamespace, null));
    if (_notEquals) {
      String _xblockexpression = null;
      {
        String prefix = "tns";
        boolean _and = false;
        TechnicalNamespace _findOwnerSubdomain = this.profileNSQueries.findOwnerSubdomain(t);
        org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType _type_1 = t.getType();
        TechnicalNamespace _findTechnicalNamespace_1 = this.profileNSQueries.findTechnicalNamespace(_type_1);
        boolean _equals = Objects.equal(_findOwnerSubdomain, _findTechnicalNamespace_1);
        if (!_equals) {
          _and = false;
        } else {
          Version _ownerVersion = this._versionQueries.getOwnerVersion(t);
          String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_ownerVersion);
          org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType _type_2 = t.getType();
          Version _version = _type_2.getVersion();
          String _majorVersionNumber_1 = this._versionQualifierExtensions.toMajorVersionNumber(_version);
          boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
          _and = (_equals && _equals_1);
        }
        boolean _not = (!_and);
        if (_not) {
          org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType _type_3 = t.getType();
          TechnicalNamespace _findTechnicalNamespace_2 = this.profileNSQueries.findTechnicalNamespace(_type_3);
          String _shortName = this._schemaNamespaceExtensions.toShortName(_findTechnicalNamespace_2);
          org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType _type_4 = t.getType();
          Version _version_1 = _type_4.getVersion();
          String _majorVersionNumber_2 = this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
          String _plus = (_shortName + _majorVersionNumber_2);
          prefix = _plus;
        }
        String _plus_1 = (prefix + ":");
        org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType _type_5 = t.getType();
        String _name = _type_5.getName();
        String _plus_2 = (_plus_1 + _name);
        _xblockexpression = (_plus_2);
      }
      _xifexpression = _xblockexpression;
    } else {
      org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType _type_1 = t.getType();
      String _name = _type_1.getName();
      _xifexpression = _name;
    }
    return _xifexpression;
  }
  
  protected String _toTypeNameRef(final BusinessObjectRef t) {
    String _xifexpression = null;
    BusinessObject _type = t.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    boolean _notEquals = (!Objects.equal(_findSubdomain, null));
    if (_notEquals) {
      String _xblockexpression = null;
      {
        String prefix = "tns";
        boolean _and = false;
        boolean _and_1 = false;
        SubNamespace _findRefOwnerSubdomain = this._namespaceQuery.findRefOwnerSubdomain(t);
        BusinessObject _type_1 = t.getType();
        SubNamespace _findSubdomain_1 = this._namespaceQuery.findSubdomain(_type_1);
        boolean _equals = Objects.equal(_findRefOwnerSubdomain, _findSubdomain_1);
        if (!_equals) {
          _and_1 = false;
        } else {
          Version _ownerVersion = this._versionQueries.getOwnerVersion(t);
          String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_ownerVersion);
          BusinessObject _type_2 = t.getType();
          Version _version = _type_2.getVersion();
          String _majorVersionNumber_1 = this._versionQualifierExtensions.toMajorVersionNumber(_version);
          boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
          _and_1 = (_equals && _equals_1);
        }
        if (!_and_1) {
          _and = false;
        } else {
          EObject _statefulOwner = this._lifecycleQueries.getStatefulOwner(t);
          boolean _not = (!(_statefulOwner instanceof Service));
          _and = (_and_1 && _not);
        }
        boolean _not_1 = (!_and);
        if (_not_1) {
          BusinessObject _type_3 = t.getType();
          SubNamespace _findSubdomain_2 = this._namespaceQuery.findSubdomain(_type_3);
          String _shortName = this._schemaNamespaceExtensions.toShortName(_findSubdomain_2);
          BusinessObject _type_4 = t.getType();
          Version _version_1 = _type_4.getVersion();
          String _majorVersionNumber_2 = this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
          String _plus = (_shortName + _majorVersionNumber_2);
          prefix = _plus;
        }
        String _plus_1 = (prefix + ":");
        BusinessObject _type_5 = t.getType();
        String _name = _type_5.getName();
        String _plus_2 = (_plus_1 + _name);
        _xblockexpression = (_plus_2);
      }
      _xifexpression = _xblockexpression;
    } else {
      BusinessObject _type_1 = t.getType();
      String _name = _type_1.getName();
      _xifexpression = _name;
    }
    return _xifexpression;
  }
  
  protected String _toTypeNameRef(final QueryObjectRef t) {
    String _xifexpression = null;
    QueryObject _type = t.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    boolean _notEquals = (!Objects.equal(_findSubdomain, null));
    if (_notEquals) {
      String _xblockexpression = null;
      {
        String prefix = "tns";
        boolean _and = false;
        boolean _and_1 = false;
        SubNamespace _findRefOwnerSubdomain = this._namespaceQuery.findRefOwnerSubdomain(t);
        QueryObject _type_1 = t.getType();
        SubNamespace _findSubdomain_1 = this._namespaceQuery.findSubdomain(_type_1);
        boolean _equals = Objects.equal(_findRefOwnerSubdomain, _findSubdomain_1);
        if (!_equals) {
          _and_1 = false;
        } else {
          Version _ownerVersion = this._versionQueries.getOwnerVersion(t);
          String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_ownerVersion);
          QueryObject _type_2 = t.getType();
          Version _version = _type_2.getVersion();
          String _majorVersionNumber_1 = this._versionQualifierExtensions.toMajorVersionNumber(_version);
          boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
          _and_1 = (_equals && _equals_1);
        }
        if (!_and_1) {
          _and = false;
        } else {
          EObject _statefulOwner = this._lifecycleQueries.getStatefulOwner(t);
          boolean _not = (!(_statefulOwner instanceof Service));
          _and = (_and_1 && _not);
        }
        boolean _not_1 = (!_and);
        if (_not_1) {
          QueryObject _type_3 = t.getType();
          SubNamespace _findSubdomain_2 = this._namespaceQuery.findSubdomain(_type_3);
          String _shortName = this._schemaNamespaceExtensions.toShortName(_findSubdomain_2);
          QueryObject _type_4 = t.getType();
          Version _version_1 = _type_4.getVersion();
          String _majorVersionNumber_2 = this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
          String _plus = (_shortName + _majorVersionNumber_2);
          prefix = _plus;
        }
        String _plus_1 = (prefix + ":");
        QueryObject _type_5 = t.getType();
        String _name = _type_5.getName();
        String _plus_2 = (_plus_1 + _name);
        _xblockexpression = (_plus_2);
      }
      _xifexpression = _xblockexpression;
    } else {
      QueryObject _type_1 = t.getType();
      String _name = _type_1.getName();
      _xifexpression = _name;
    }
    return _xifexpression;
  }
  
  protected String _toTypeNameRef(final EnumTypeRef t) {
    String _xifexpression = null;
    Enumeration _type = t.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    boolean _notEquals = (!Objects.equal(_findSubdomain, null));
    if (_notEquals) {
      String _xblockexpression = null;
      {
        String prefix = "tns";
        boolean _and = false;
        boolean _and_1 = false;
        SubNamespace _findRefOwnerSubdomain = this._namespaceQuery.findRefOwnerSubdomain(t);
        Enumeration _type_1 = t.getType();
        SubNamespace _findSubdomain_1 = this._namespaceQuery.findSubdomain(_type_1);
        boolean _equals = Objects.equal(_findRefOwnerSubdomain, _findSubdomain_1);
        if (!_equals) {
          _and_1 = false;
        } else {
          Version _ownerVersion = this._versionQueries.getOwnerVersion(t);
          String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_ownerVersion);
          Enumeration _type_2 = t.getType();
          Version _version = _type_2.getVersion();
          String _majorVersionNumber_1 = this._versionQualifierExtensions.toMajorVersionNumber(_version);
          boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
          _and_1 = (_equals && _equals_1);
        }
        if (!_and_1) {
          _and = false;
        } else {
          EObject _statefulOwner = this._lifecycleQueries.getStatefulOwner(t);
          boolean _not = (!(_statefulOwner instanceof Service));
          _and = (_and_1 && _not);
        }
        boolean _not_1 = (!_and);
        if (_not_1) {
          Enumeration _type_3 = t.getType();
          SubNamespace _findSubdomain_2 = this._namespaceQuery.findSubdomain(_type_3);
          String _shortName = this._schemaNamespaceExtensions.toShortName(_findSubdomain_2);
          Enumeration _type_4 = t.getType();
          Version _version_1 = _type_4.getVersion();
          String _majorVersionNumber_2 = this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
          String _plus = (_shortName + _majorVersionNumber_2);
          prefix = _plus;
        }
        String _plus_1 = (prefix + ":");
        Enumeration _type_5 = t.getType();
        String _name = _type_5.getName();
        String _plus_2 = (_plus_1 + _name);
        _xblockexpression = (_plus_2);
      }
      _xifexpression = _xblockexpression;
    } else {
      Enumeration _type_1 = t.getType();
      String _name = _type_1.getName();
      _xifexpression = _name;
    }
    return _xifexpression;
  }
  
  public String toExceptionNameRef(final ExceptionRef exRef) {
    String _xifexpression = null;
    org.fornax.soa.serviceDsl.Exception _exception = exRef.getException();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_exception);
    boolean _notEquals = (!Objects.equal(_findSubdomain, null));
    if (_notEquals) {
      String _xblockexpression = null;
      {
        String prefix = "tns";
        boolean _and = false;
        boolean _and_1 = false;
        SubNamespace _findRefOwnerSubdomain = this._namespaceQuery.findRefOwnerSubdomain(exRef);
        org.fornax.soa.serviceDsl.Exception _exception_1 = exRef.getException();
        SubNamespace _findSubdomain_1 = this._namespaceQuery.findSubdomain(_exception_1);
        boolean _equals = Objects.equal(_findRefOwnerSubdomain, _findSubdomain_1);
        if (!_equals) {
          _and_1 = false;
        } else {
          Version _ownerVersion = this._versionQueries.getOwnerVersion(exRef);
          String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_ownerVersion);
          org.fornax.soa.serviceDsl.Exception _exception_2 = exRef.getException();
          Version _version = _exception_2.getVersion();
          String _majorVersionNumber_1 = this._versionQualifierExtensions.toMajorVersionNumber(_version);
          boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
          _and_1 = (_equals && _equals_1);
        }
        if (!_and_1) {
          _and = false;
        } else {
          EObject _statefulOwner = this._lifecycleQueries.getStatefulOwner(exRef);
          boolean _not = (!(_statefulOwner instanceof Service));
          _and = (_and_1 && _not);
        }
        boolean _not_1 = (!_and);
        if (_not_1) {
          org.fornax.soa.serviceDsl.Exception _exception_3 = exRef.getException();
          SubNamespace _findSubdomain_2 = this._namespaceQuery.findSubdomain(_exception_3);
          String _shortName = this._schemaNamespaceExtensions.toShortName(_findSubdomain_2);
          org.fornax.soa.serviceDsl.Exception _exception_4 = exRef.getException();
          Version _version_1 = _exception_4==null?(Version)null:_exception_4.getVersion();
          String _majorVersionNumber_2 = _version_1==null?(String)null:this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
          String _plus = (_shortName + _majorVersionNumber_2);
          prefix = _plus;
        }
        String _plus_1 = (prefix + ":");
        org.fornax.soa.serviceDsl.Exception _exception_5 = exRef.getException();
        String _name = _exception_5.getName();
        String _plus_2 = (_plus_1 + _name);
        _xblockexpression = (_plus_2);
      }
      _xifexpression = _xblockexpression;
    } else {
      org.fornax.soa.serviceDsl.Exception _exception_1 = exRef.getException();
      String _name = _exception_1.getName();
      _xifexpression = _name;
    }
    return _xifexpression;
  }
  
  protected String _toTypeNameRef(final TypeRef t, final VersionedDomainNamespace currNs) {
    return null;
  }
  
  protected String _toTypeNameRef(final org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef t, final VersionedDomainNamespace currNs) {
    return null;
  }
  
  protected String _toTypeNameRef(final DataTypeRef t, final VersionedDomainNamespace currentDomNs) {
    Type _findMatchingType = this._iTypeResolver.findMatchingType(t);
    String _typeNameRef = this.toTypeNameRef(_findMatchingType);
    return _typeNameRef;
  }
  
  protected String _toTypeNameRef(final VersionedTypeRef t, final VersionedDomainNamespace currNs) {
    String _xifexpression = null;
    boolean _and = false;
    boolean _and_1 = false;
    VersionedType _type = t.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    String _unversionedNamespace = this._schemaNamespaceExtensions.toUnversionedNamespace(_findSubdomain);
    EObject _subdomain = currNs.getSubdomain();
    String _unversionedNamespace_1 = this._schemaNamespaceExtensions.toUnversionedNamespace(_subdomain);
    boolean _equals = Objects.equal(_unversionedNamespace, _unversionedNamespace_1);
    if (!_equals) {
      _and_1 = false;
    } else {
      Version _ownerVersion = this._versionQueries.getOwnerVersion(t);
      String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_ownerVersion);
      VersionedType _type_1 = t.getType();
      Version _version = _type_1.getVersion();
      String _majorVersionNumber_1 = this._versionQualifierExtensions.toMajorVersionNumber(_version);
      boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
      _and_1 = (_equals && _equals_1);
    }
    if (!_and_1) {
      _and = false;
    } else {
      EObject _statefulOwner = this._lifecycleQueries.getStatefulOwner(t);
      boolean _not = (!(_statefulOwner instanceof Service));
      _and = (_and_1 && _not);
    }
    if (_and) {
      VersionedType _type_2 = t.getType();
      String _name = _type_2.getName();
      String _plus = ("tns:" + _name);
      _xifexpression = _plus;
    } else {
      VersionedType _type_3 = t.getType();
      SubNamespace _findSubdomain_1 = this._namespaceQuery.findSubdomain(_type_3);
      String _shortName = this._schemaNamespaceExtensions.toShortName(_findSubdomain_1);
      VersionedType _type_4 = t.getType();
      Version _version_1 = _type_4.getVersion();
      String _majorVersionNumber_2 = this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
      String _plus_1 = (_shortName + _majorVersionNumber_2);
      String _plus_2 = (_plus_1 + ":");
      VersionedType _type_5 = t.getType();
      String _name_1 = _type_5.getName();
      String _plus_3 = (_plus_2 + _name_1);
      _xifexpression = _plus_3;
    }
    return _xifexpression;
  }
  
  protected String _toTypeNameRef(final BusinessObjectRef t, final VersionedDomainNamespace currNs) {
    String _xifexpression = null;
    boolean _and = false;
    boolean _and_1 = false;
    BusinessObject _type = t.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    String _unversionedNamespace = this._schemaNamespaceExtensions.toUnversionedNamespace(_findSubdomain);
    EObject _subdomain = currNs.getSubdomain();
    String _unversionedNamespace_1 = this._schemaNamespaceExtensions.toUnversionedNamespace(_subdomain);
    boolean _equals = Objects.equal(_unversionedNamespace, _unversionedNamespace_1);
    if (!_equals) {
      _and_1 = false;
    } else {
      Version _ownerVersion = this._versionQueries.getOwnerVersion(t);
      String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_ownerVersion);
      BusinessObject _type_1 = t.getType();
      Version _version = _type_1.getVersion();
      String _majorVersionNumber_1 = this._versionQualifierExtensions.toMajorVersionNumber(_version);
      boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
      _and_1 = (_equals && _equals_1);
    }
    if (!_and_1) {
      _and = false;
    } else {
      EObject _statefulOwner = this._lifecycleQueries.getStatefulOwner(t);
      boolean _not = (!(_statefulOwner instanceof Service));
      _and = (_and_1 && _not);
    }
    if (_and) {
      BusinessObject _type_2 = t.getType();
      String _name = _type_2.getName();
      String _plus = ("tns:" + _name);
      _xifexpression = _plus;
    } else {
      BusinessObject _type_3 = t.getType();
      SubNamespace _findSubdomain_1 = this._namespaceQuery.findSubdomain(_type_3);
      String _shortName = this._schemaNamespaceExtensions.toShortName(_findSubdomain_1);
      BusinessObject _type_4 = t.getType();
      Version _version_1 = _type_4.getVersion();
      String _majorVersionNumber_2 = this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
      String _plus_1 = (_shortName + _majorVersionNumber_2);
      String _plus_2 = (_plus_1 + ":");
      BusinessObject _type_5 = t.getType();
      String _name_1 = _type_5.getName();
      String _plus_3 = (_plus_2 + _name_1);
      _xifexpression = _plus_3;
    }
    return _xifexpression;
  }
  
  protected String _toTypeNameRef(final QueryObjectRef t, final VersionedDomainNamespace currNs) {
    String _xifexpression = null;
    boolean _and = false;
    boolean _and_1 = false;
    QueryObject _type = t.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    String _unversionedNamespace = this._schemaNamespaceExtensions.toUnversionedNamespace(_findSubdomain);
    EObject _subdomain = currNs.getSubdomain();
    String _unversionedNamespace_1 = this._schemaNamespaceExtensions.toUnversionedNamespace(_subdomain);
    boolean _equals = Objects.equal(_unversionedNamespace, _unversionedNamespace_1);
    if (!_equals) {
      _and_1 = false;
    } else {
      Version _ownerVersion = this._versionQueries.getOwnerVersion(t);
      String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_ownerVersion);
      QueryObject _type_1 = t.getType();
      Version _version = _type_1.getVersion();
      String _majorVersionNumber_1 = this._versionQualifierExtensions.toMajorVersionNumber(_version);
      boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
      _and_1 = (_equals && _equals_1);
    }
    if (!_and_1) {
      _and = false;
    } else {
      EObject _statefulOwner = this._lifecycleQueries.getStatefulOwner(t);
      boolean _not = (!(_statefulOwner instanceof Service));
      _and = (_and_1 && _not);
    }
    if (_and) {
      QueryObject _type_2 = t.getType();
      String _name = _type_2.getName();
      String _plus = ("tns:" + _name);
      _xifexpression = _plus;
    } else {
      QueryObject _type_3 = t.getType();
      SubNamespace _findSubdomain_1 = this._namespaceQuery.findSubdomain(_type_3);
      String _shortName = this._schemaNamespaceExtensions.toShortName(_findSubdomain_1);
      QueryObject _type_4 = t.getType();
      Version _version_1 = _type_4.getVersion();
      String _majorVersionNumber_2 = this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
      String _plus_1 = (_shortName + _majorVersionNumber_2);
      String _plus_2 = (_plus_1 + ":");
      QueryObject _type_5 = t.getType();
      String _name_1 = _type_5.getName();
      String _plus_3 = (_plus_2 + _name_1);
      _xifexpression = _plus_3;
    }
    return _xifexpression;
  }
  
  protected String _toTypeNameRef(final EnumTypeRef t, final VersionedDomainNamespace currNs) {
    String _xifexpression = null;
    boolean _and = false;
    boolean _and_1 = false;
    Enumeration _type = t.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    String _unversionedNamespace = this._schemaNamespaceExtensions.toUnversionedNamespace(_findSubdomain);
    EObject _subdomain = currNs.getSubdomain();
    String _unversionedNamespace_1 = this._schemaNamespaceExtensions.toUnversionedNamespace(_subdomain);
    boolean _equals = Objects.equal(_unversionedNamespace, _unversionedNamespace_1);
    if (!_equals) {
      _and_1 = false;
    } else {
      Version _ownerVersion = this._versionQueries.getOwnerVersion(t);
      String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_ownerVersion);
      Enumeration _type_1 = t.getType();
      Version _version = _type_1.getVersion();
      String _majorVersionNumber_1 = this._versionQualifierExtensions.toMajorVersionNumber(_version);
      boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
      _and_1 = (_equals && _equals_1);
    }
    if (!_and_1) {
      _and = false;
    } else {
      EObject _statefulOwner = this._lifecycleQueries.getStatefulOwner(t);
      boolean _not = (!(_statefulOwner instanceof Service));
      _and = (_and_1 && _not);
    }
    if (_and) {
      Enumeration _type_2 = t.getType();
      String _name = _type_2.getName();
      String _plus = ("tns:" + _name);
      _xifexpression = _plus;
    } else {
      Enumeration _type_3 = t.getType();
      SubNamespace _findSubdomain_1 = this._namespaceQuery.findSubdomain(_type_3);
      String _shortName = this._schemaNamespaceExtensions.toShortName(_findSubdomain_1);
      Enumeration _type_4 = t.getType();
      Version _version_1 = _type_4.getVersion();
      String _majorVersionNumber_2 = this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
      String _plus_1 = (_shortName + _majorVersionNumber_2);
      String _plus_2 = (_plus_1 + ":");
      Enumeration _type_5 = t.getType();
      String _name_1 = _type_5.getName();
      String _plus_3 = (_plus_2 + _name_1);
      _xifexpression = _plus_3;
    }
    return _xifexpression;
  }
  
  protected String _toTypeNameRef(final org.fornax.soa.serviceDsl.Type t) {
    return "";
  }
  
  protected String _toTypeNameRef(final ClassRef t, final VersionedDomainNamespace currNs) {
    String _xifexpression = null;
    boolean _and = false;
    org.fornax.soa.profiledsl.sOAProfileDsl.Class _type = t.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    String _unversionedNamespace = this._schemaNamespaceExtensions.toUnversionedNamespace(_findSubdomain);
    EObject _subdomain = currNs.getSubdomain();
    String _unversionedNamespace_1 = this._schemaNamespaceExtensions.toUnversionedNamespace(_subdomain);
    boolean _equals = Objects.equal(_unversionedNamespace, _unversionedNamespace_1);
    if (!_equals) {
      _and = false;
    } else {
      String _version = currNs.getVersion();
      Version _version_1 = this._versionQualifierExtensions.toVersion(_version);
      VersionRef _versionRef = t.getVersionRef();
      boolean _versionMatches = this._versionMatcher.versionMatches(_version_1, _versionRef);
      _and = (_equals && _versionMatches);
    }
    if (_and) {
      org.fornax.soa.profiledsl.sOAProfileDsl.Class _type_1 = t.getType();
      String _name = _type_1.getName();
      String _plus = ("tns:" + _name);
      _xifexpression = _plus;
    } else {
      org.fornax.soa.profiledsl.sOAProfileDsl.Class _type_2 = t.getType();
      SubNamespace _findSubdomain_1 = this._namespaceQuery.findSubdomain(_type_2);
      String _shortName = this._schemaNamespaceExtensions.toShortName(_findSubdomain_1);
      org.fornax.soa.profiledsl.sOAProfileDsl.Class _type_3 = t.getType();
      Version _version_2 = _type_3.getVersion();
      String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_version_2);
      String _plus_1 = (_shortName + _majorVersionNumber);
      String _plus_2 = (_plus_1 + ":");
      org.fornax.soa.profiledsl.sOAProfileDsl.Class _type_4 = t.getType();
      String _name_1 = _type_4.getName();
      String _plus_3 = (_plus_2 + _name_1);
      _xifexpression = _plus_3;
    }
    return _xifexpression;
  }
  
  protected String _toFullTypeNameRef(final TypeRef t, final VersionedDomainNamespace currNs) {
    return null;
  }
  
  protected String _toFullTypeNameRef(final DataTypeRef t, final VersionedDomainNamespace currentDomNs) {
    Type _findMatchingType = this._iTypeResolver.findMatchingType(t);
    String _fullTypeNameRef = this.toFullTypeNameRef(_findMatchingType);
    return _fullTypeNameRef;
  }
  
  protected String _toFullTypeNameRef(final VersionedTypeRef t, final VersionedDomainNamespace currNs) {
    String _namespace = this.toNamespace(t);
    VersionedType _type = t.getType();
    String _name = _type.getName();
    String _plus = (_namespace + _name);
    return _plus;
  }
  
  protected String _toFullTypeNameRef(final BusinessObjectRef t, final VersionedDomainNamespace currNs) {
    String _namespace = this.toNamespace(t);
    BusinessObject _type = t.getType();
    String _name = _type.getName();
    String _plus = (_namespace + _name);
    return _plus;
  }
  
  protected String _toFullTypeNameRef(final QueryObjectRef t, final VersionedDomainNamespace currNs) {
    String _namespace = this.toNamespace(t);
    QueryObject _type = t.getType();
    String _name = _type.getName();
    String _plus = (_namespace + _name);
    return _plus;
  }
  
  protected String _toFullTypeNameRef(final EnumTypeRef t, final VersionedDomainNamespace currNs) {
    String _namespace = this.toNamespace(t);
    Enumeration _type = t.getType();
    String _name = _type.getName();
    String _plus = (_namespace + _name);
    return _plus;
  }
  
  protected String _toFullTypeNameRef(final org.fornax.soa.serviceDsl.Type t) {
    return "";
  }
  
  protected String _toFullTypeNameRef(final DataType t) {
    String _switchResult = null;
    String _name = t.getName();
    final String _switchValue = _name;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,"attachment")) {
        _matched=true;
        _switchResult = "xsd:base64Binary";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"binary")) {
        _matched=true;
        _switchResult = "xsd:hexBinary";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"base64Binary")) {
        _matched=true;
        _switchResult = "xsd:base64Binary";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"BigInteger")) {
        _matched=true;
        _switchResult = "xsd:decimal";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"BigDecimal")) {
        _matched=true;
        _switchResult = "xsd:decimal";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"char")) {
        _matched=true;
        _switchResult = "xsd:string";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"datetime")) {
        _matched=true;
        _switchResult = "xsd:dateTime";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"Object")) {
        _matched=true;
        _switchResult = "xsd:anyType";
      }
    }
    if (!_matched) {
      String _name_1 = t.getName();
      String _plus = ("xsd:" + _name_1);
      _switchResult = _plus;
    }
    return _switchResult;
  }
  
  protected boolean _isAttachment(final TypeRef t) {
    return false;
  }
  
  protected boolean _isAttachment(final DataTypeRef t) {
    boolean _switchResult = false;
    DataType _type = t.getType();
    String _name = _type.getName();
    final String _switchValue = _name;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,"base64Binary")) {
        _matched=true;
        _switchResult = true;
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,"attachment")) {
        _matched=true;
        _switchResult = true;
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
  
  /**
   * Resolve the type name of weak type reference, i.e. return the type name referenced type's businessKey
   */
  protected String _toWeakRefType(final TypeRef t) {
    String _typeNameRef = this.toTypeNameRef(t);
    return _typeNameRef;
  }
  
  protected String _toWeakRefType(final VersionedTypeRef t) {
    String _xifexpression = null;
    org.fornax.soa.serviceDsl.Type _findMatchingType = this._iTypeResolver.findMatchingType(t);
    if ((_findMatchingType instanceof BusinessObject)) {
      org.fornax.soa.serviceDsl.Type _findMatchingType_1 = this._iTypeResolver.findMatchingType(t);
      EList<Property> _properties = ((BusinessObject) _findMatchingType_1).getProperties();
      final Function1<Property,Boolean> _function = new Function1<Property,Boolean>() {
          public Boolean apply(final Property e) {
            boolean _isIsBusinessKey = e.isIsBusinessKey();
            return Boolean.valueOf(_isIsBusinessKey);
          }
        };
      Iterable<Property> _filter = IterableExtensions.<Property>filter(_properties, _function);
      Iterable<Attribute> _filter_1 = Iterables.<Attribute>filter(_filter, Attribute.class);
      List<Attribute> _list = IterableExtensions.<Attribute>toList(_filter_1);
      Attribute _head = IterableExtensions.<Attribute>head(_list);
      TypeRef _type = _head.getType();
      String _typeNameRef = this.toTypeNameRef(_type);
      _xifexpression = _typeNameRef;
    } else {
      String _xifexpression_1 = null;
      org.fornax.soa.serviceDsl.Type _findMatchingType_2 = this._iTypeResolver.findMatchingType(t);
      if ((_findMatchingType_2 instanceof QueryObject)) {
        org.fornax.soa.serviceDsl.Type _findMatchingType_3 = this._iTypeResolver.findMatchingType(t);
        EList<Property> _properties_1 = ((QueryObject) _findMatchingType_3).getProperties();
        final Function1<Property,Boolean> _function_1 = new Function1<Property,Boolean>() {
            public Boolean apply(final Property e) {
              boolean _isIsBusinessKey = e.isIsBusinessKey();
              return Boolean.valueOf(_isIsBusinessKey);
            }
          };
        Iterable<Property> _filter_2 = IterableExtensions.<Property>filter(_properties_1, _function_1);
        Iterable<Attribute> _filter_3 = Iterables.<Attribute>filter(_filter_2, Attribute.class);
        List<Attribute> _list_1 = IterableExtensions.<Attribute>toList(_filter_3);
        Attribute _head_1 = IterableExtensions.<Attribute>head(_list_1);
        TypeRef _type_1 = _head_1.getType();
        String _typeNameRef_1 = this.toTypeNameRef(_type_1);
        _xifexpression_1 = _typeNameRef_1;
      } else {
        String _typeNameRef_2 = this.toTypeNameRef(t);
        _xifexpression_1 = _typeNameRef_2;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  protected String _toWeakRefType(final BusinessObjectRef t) {
    org.fornax.soa.serviceDsl.Type _findMatchingType = this._iTypeResolver.findMatchingType(t);
    EList<Property> _properties = ((BusinessObject) _findMatchingType).getProperties();
    final Function1<Property,Boolean> _function = new Function1<Property,Boolean>() {
        public Boolean apply(final Property e) {
          boolean _isIsBusinessKey = e.isIsBusinessKey();
          return Boolean.valueOf(_isIsBusinessKey);
        }
      };
    Iterable<Property> _filter = IterableExtensions.<Property>filter(_properties, _function);
    Iterable<Attribute> _filter_1 = Iterables.<Attribute>filter(_filter, Attribute.class);
    List<Attribute> _list = IterableExtensions.<Attribute>toList(_filter_1);
    Attribute _head = IterableExtensions.<Attribute>head(_list);
    TypeRef _type = _head.getType();
    String _typeNameRef = this.toTypeNameRef(_type);
    return _typeNameRef;
  }
  
  protected String _toWeakRefType(final QueryObjectRef t) {
    org.fornax.soa.serviceDsl.Type _findMatchingType = this._iTypeResolver.findMatchingType(t);
    EList<Property> _properties = ((QueryObject) _findMatchingType).getProperties();
    final Function1<Property,Boolean> _function = new Function1<Property,Boolean>() {
        public Boolean apply(final Property e) {
          boolean _isIsBusinessKey = e.isIsBusinessKey();
          return Boolean.valueOf(_isIsBusinessKey);
        }
      };
    Iterable<Property> _filter = IterableExtensions.<Property>filter(_properties, _function);
    Iterable<Attribute> _filter_1 = Iterables.<Attribute>filter(_filter, Attribute.class);
    List<Attribute> _list = IterableExtensions.<Attribute>toList(_filter_1);
    Attribute _head = IterableExtensions.<Attribute>head(_list);
    TypeRef _type = _head.getType();
    String _typeNameRef = this.toTypeNameRef(_type);
    return _typeNameRef;
  }
  
  protected String _toWeakRefKeyAttr(final TypeRef t) {
    return null;
  }
  
  protected String _toWeakRefKeyAttr(final BusinessObjectRef t) {
    org.fornax.soa.serviceDsl.Type _findMatchingType = this._iTypeResolver.findMatchingType(t);
    EList<Property> _properties = ((BusinessObject) _findMatchingType).getProperties();
    final Function1<Property,Boolean> _function = new Function1<Property,Boolean>() {
        public Boolean apply(final Property e) {
          boolean _isIsBusinessKey = e.isIsBusinessKey();
          return Boolean.valueOf(_isIsBusinessKey);
        }
      };
    Iterable<Property> _filter = IterableExtensions.<Property>filter(_properties, _function);
    Iterable<Attribute> _filter_1 = Iterables.<Attribute>filter(_filter, Attribute.class);
    Attribute _head = IterableExtensions.<Attribute>head(_filter_1);
    String _name = _head.getName();
    return _name;
  }
  
  protected String _toWeakRefKeyAttr(final QueryObjectRef t) {
    org.fornax.soa.serviceDsl.Type _findMatchingType = this._iTypeResolver.findMatchingType(t);
    EList<Property> _properties = ((BusinessObject) _findMatchingType).getProperties();
    final Function1<Property,Boolean> _function = new Function1<Property,Boolean>() {
        public Boolean apply(final Property e) {
          boolean _isIsBusinessKey = e.isIsBusinessKey();
          return Boolean.valueOf(_isIsBusinessKey);
        }
      };
    Iterable<Property> _filter = IterableExtensions.<Property>filter(_properties, _function);
    Iterable<Attribute> _filter_1 = Iterables.<Attribute>filter(_filter, Attribute.class);
    Attribute _head = IterableExtensions.<Attribute>head(_filter_1);
    String _name = _head.getName();
    return _name;
  }
  
  protected String _toWeakRefType(final TypeRef t, final LifecycleState minState) {
    String _typeNameRef = this.toTypeNameRef(t);
    return _typeNameRef;
  }
  
  protected String _toWeakRefType(final VersionedTypeRef t, final LifecycleState minState) {
    String _xifexpression = null;
    boolean _and = false;
    org.fornax.soa.serviceDsl.Type _findMatchingTypeByState = this._iTypeResolver.findMatchingTypeByState(t, minState);
    if (!(_findMatchingTypeByState instanceof BusinessObject)) {
      _and = false;
    } else {
      org.fornax.soa.serviceDsl.Type _findMatchingTypeByState_1 = this._iTypeResolver.findMatchingTypeByState(t, minState);
      List<Property> _findAllVisibleProperties = this._businessObjectQueries.findAllVisibleProperties(((BusinessObject) _findMatchingTypeByState_1), minState);
      final Function1<Property,Boolean> _function = new Function1<Property,Boolean>() {
          public Boolean apply(final Property e) {
            boolean _isIsBusinessKey = e.isIsBusinessKey();
            return Boolean.valueOf(_isIsBusinessKey);
          }
        };
      Iterable<Property> _filter = IterableExtensions.<Property>filter(_findAllVisibleProperties, _function);
      Iterable<Attribute> _filter_1 = Iterables.<Attribute>filter(_filter, Attribute.class);
      boolean _isEmpty = IterableExtensions.isEmpty(_filter_1);
      boolean _not = (!_isEmpty);
      _and = ((_findMatchingTypeByState instanceof BusinessObject) && _not);
    }
    if (_and) {
      org.fornax.soa.serviceDsl.Type _findMatchingTypeByState_2 = this._iTypeResolver.findMatchingTypeByState(t, minState);
      List<Property> _findAllVisibleProperties_1 = this._businessObjectQueries.findAllVisibleProperties(((BusinessObject) _findMatchingTypeByState_2), minState);
      final Function1<Property,Boolean> _function_1 = new Function1<Property,Boolean>() {
          public Boolean apply(final Property e) {
            boolean _isIsBusinessKey = e.isIsBusinessKey();
            return Boolean.valueOf(_isIsBusinessKey);
          }
        };
      Iterable<Property> _filter_2 = IterableExtensions.<Property>filter(_findAllVisibleProperties_1, _function_1);
      Iterable<Attribute> _filter_3 = Iterables.<Attribute>filter(_filter_2, Attribute.class);
      List<Attribute> _list = IterableExtensions.<Attribute>toList(_filter_3);
      Attribute _head = IterableExtensions.<Attribute>head(_list);
      TypeRef _type = _head.getType();
      String _typeNameRef = this.toTypeNameRef(_type);
      _xifexpression = _typeNameRef;
    } else {
      String _typeNameRef_1 = this.toTypeNameRef(t);
      _xifexpression = _typeNameRef_1;
    }
    return _xifexpression;
  }
  
  protected String _toWeakRefType(final BusinessObjectRef t, final LifecycleState minState) {
    String _xifexpression = null;
    org.fornax.soa.serviceDsl.Type _findMatchingTypeByState = this._iTypeResolver.findMatchingTypeByState(t, minState);
    List<Property> _findAllVisibleProperties = this._businessObjectQueries.findAllVisibleProperties(((BusinessObject) _findMatchingTypeByState), minState);
    final Function1<Property,Boolean> _function = new Function1<Property,Boolean>() {
        public Boolean apply(final Property e) {
          boolean _isIsBusinessKey = e.isIsBusinessKey();
          return Boolean.valueOf(_isIsBusinessKey);
        }
      };
    Iterable<Property> _filter = IterableExtensions.<Property>filter(_findAllVisibleProperties, _function);
    Iterable<Attribute> _filter_1 = Iterables.<Attribute>filter(_filter, Attribute.class);
    boolean _isEmpty = IterableExtensions.isEmpty(_filter_1);
    boolean _not = (!_isEmpty);
    if (_not) {
      org.fornax.soa.serviceDsl.Type _findMatchingTypeByState_1 = this._iTypeResolver.findMatchingTypeByState(t, minState);
      List<Property> _findAllVisibleProperties_1 = this._businessObjectQueries.findAllVisibleProperties(((BusinessObject) _findMatchingTypeByState_1), minState);
      final Function1<Property,Boolean> _function_1 = new Function1<Property,Boolean>() {
          public Boolean apply(final Property e) {
            boolean _isIsBusinessKey = e.isIsBusinessKey();
            return Boolean.valueOf(_isIsBusinessKey);
          }
        };
      Iterable<Property> _filter_2 = IterableExtensions.<Property>filter(_findAllVisibleProperties_1, _function_1);
      Iterable<Attribute> _filter_3 = Iterables.<Attribute>filter(_filter_2, Attribute.class);
      List<Attribute> _list = IterableExtensions.<Attribute>toList(_filter_3);
      Attribute _head = IterableExtensions.<Attribute>head(_list);
      TypeRef _type = _head.getType();
      String _typeNameRef = this.toTypeNameRef(_type);
      _xifexpression = _typeNameRef;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  protected String _toWeakRefType(final QueryObjectRef t, final LifecycleState minState) {
    String _xifexpression = null;
    org.fornax.soa.serviceDsl.Type _findMatchingTypeByState = this._iTypeResolver.findMatchingTypeByState(t, minState);
    List<Property> _findAllVisibleProperties = this._businessObjectQueries.findAllVisibleProperties(((QueryObject) _findMatchingTypeByState), minState);
    final Function1<Property,Boolean> _function = new Function1<Property,Boolean>() {
        public Boolean apply(final Property e) {
          boolean _isIsBusinessKey = e.isIsBusinessKey();
          return Boolean.valueOf(_isIsBusinessKey);
        }
      };
    Iterable<Property> _filter = IterableExtensions.<Property>filter(_findAllVisibleProperties, _function);
    Iterable<Attribute> _filter_1 = Iterables.<Attribute>filter(_filter, Attribute.class);
    boolean _isEmpty = IterableExtensions.isEmpty(_filter_1);
    boolean _not = (!_isEmpty);
    if (_not) {
      org.fornax.soa.serviceDsl.Type _findMatchingTypeByState_1 = this._iTypeResolver.findMatchingTypeByState(t, minState);
      List<Property> _findAllVisibleProperties_1 = this._businessObjectQueries.findAllVisibleProperties(((QueryObject) _findMatchingTypeByState_1), minState);
      final Function1<Property,Boolean> _function_1 = new Function1<Property,Boolean>() {
          public Boolean apply(final Property e) {
            boolean _isIsBusinessKey = e.isIsBusinessKey();
            return Boolean.valueOf(_isIsBusinessKey);
          }
        };
      Iterable<Property> _filter_2 = IterableExtensions.<Property>filter(_findAllVisibleProperties_1, _function_1);
      Iterable<Attribute> _filter_3 = Iterables.<Attribute>filter(_filter_2, Attribute.class);
      List<Attribute> _list = IterableExtensions.<Attribute>toList(_filter_3);
      Attribute _head = IterableExtensions.<Attribute>head(_list);
      TypeRef _type = _head.getType();
      String _typeNameRef = this.toTypeNameRef(_type);
      _xifexpression = _typeNameRef;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  protected String _toWeakRefKeyAttr(final TypeRef t, final LifecycleState minState) {
    return null;
  }
  
  protected String _toWeakRefKeyAttr(final BusinessObjectRef t, final LifecycleState minState) {
    String _xifexpression = null;
    org.fornax.soa.serviceDsl.Type _findMatchingTypeByState = this._iTypeResolver.findMatchingTypeByState(t, minState);
    List<Property> _findAllVisibleProperties = this._businessObjectQueries.findAllVisibleProperties(((BusinessObject) _findMatchingTypeByState), minState);
    final Function1<Property,Boolean> _function = new Function1<Property,Boolean>() {
        public Boolean apply(final Property e) {
          boolean _isIsBusinessKey = e.isIsBusinessKey();
          return Boolean.valueOf(_isIsBusinessKey);
        }
      };
    Iterable<Property> _filter = IterableExtensions.<Property>filter(_findAllVisibleProperties, _function);
    Iterable<Attribute> _filter_1 = Iterables.<Attribute>filter(_filter, Attribute.class);
    boolean _isEmpty = IterableExtensions.isEmpty(_filter_1);
    boolean _not = (!_isEmpty);
    if (_not) {
      org.fornax.soa.serviceDsl.Type _findMatchingTypeByState_1 = this._iTypeResolver.findMatchingTypeByState(t, minState);
      List<Property> _findAllVisibleProperties_1 = this._businessObjectQueries.findAllVisibleProperties(((BusinessObject) _findMatchingTypeByState_1), minState);
      final Function1<Property,Boolean> _function_1 = new Function1<Property,Boolean>() {
          public Boolean apply(final Property e) {
            boolean _isIsBusinessKey = e.isIsBusinessKey();
            return Boolean.valueOf(_isIsBusinessKey);
          }
        };
      Iterable<Property> _filter_2 = IterableExtensions.<Property>filter(_findAllVisibleProperties_1, _function_1);
      Iterable<Attribute> _filter_3 = Iterables.<Attribute>filter(_filter_2, Attribute.class);
      Attribute _head = IterableExtensions.<Attribute>head(_filter_3);
      String _name = _head.getName();
      _xifexpression = _name;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  protected String _toWeakRefKeyAttr(final QueryObjectRef t, final LifecycleState minState) {
    String _xifexpression = null;
    org.fornax.soa.serviceDsl.Type _findMatchingTypeByState = this._iTypeResolver.findMatchingTypeByState(t, minState);
    List<Property> _findAllVisibleProperties = this._businessObjectQueries.findAllVisibleProperties(((QueryObject) _findMatchingTypeByState), minState);
    final Function1<Property,Boolean> _function = new Function1<Property,Boolean>() {
        public Boolean apply(final Property e) {
          boolean _isIsBusinessKey = e.isIsBusinessKey();
          return Boolean.valueOf(_isIsBusinessKey);
        }
      };
    Iterable<Property> _filter = IterableExtensions.<Property>filter(_findAllVisibleProperties, _function);
    Iterable<Attribute> _filter_1 = Iterables.<Attribute>filter(_filter, Attribute.class);
    boolean _isEmpty = IterableExtensions.isEmpty(_filter_1);
    boolean _not = (!_isEmpty);
    if (_not) {
      org.fornax.soa.serviceDsl.Type _findMatchingTypeByState_1 = this._iTypeResolver.findMatchingTypeByState(t, minState);
      List<Property> _findAllVisibleProperties_1 = this._businessObjectQueries.findAllVisibleProperties(((QueryObject) _findMatchingTypeByState_1), minState);
      final Function1<Property,Boolean> _function_1 = new Function1<Property,Boolean>() {
          public Boolean apply(final Property e) {
            boolean _isIsBusinessKey = e.isIsBusinessKey();
            return Boolean.valueOf(_isIsBusinessKey);
          }
        };
      Iterable<Property> _filter_2 = IterableExtensions.<Property>filter(_findAllVisibleProperties_1, _function_1);
      Iterable<Attribute> _filter_3 = Iterables.<Attribute>filter(_filter_2, Attribute.class);
      Attribute _head = IterableExtensions.<Attribute>head(_filter_3);
      String _name = _head.getName();
      _xifexpression = _name;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  protected String _toExceptionNameRef(final ExceptionRef t, final VersionedDomainNamespace currNs) {
    String _xifexpression = null;
    boolean _and = false;
    boolean _and_1 = false;
    org.fornax.soa.serviceDsl.Exception _exception = t.getException();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_exception);
    String _unversionedNamespace = this._schemaNamespaceExtensions.toUnversionedNamespace(_findSubdomain);
    EObject _subdomain = currNs.getSubdomain();
    String _unversionedNamespace_1 = this._schemaNamespaceExtensions.toUnversionedNamespace(_subdomain);
    boolean _equals = Objects.equal(_unversionedNamespace, _unversionedNamespace_1);
    if (!_equals) {
      _and_1 = false;
    } else {
      Version _ownerVersion = this._versionQueries.getOwnerVersion(t);
      String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_ownerVersion);
      org.fornax.soa.serviceDsl.Exception _exception_1 = t.getException();
      Version _version = _exception_1.getVersion();
      String _majorVersionNumber_1 = this._versionQualifierExtensions.toMajorVersionNumber(_version);
      boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
      _and_1 = (_equals && _equals_1);
    }
    if (!_and_1) {
      _and = false;
    } else {
      EObject _statefulOwner = this._lifecycleQueries.getStatefulOwner(t);
      boolean _not = (!(_statefulOwner instanceof Service));
      _and = (_and_1 && _not);
    }
    if (_and) {
      org.fornax.soa.serviceDsl.Exception _exception_2 = t.getException();
      String _name = _exception_2.getName();
      String _plus = ("tns:" + _name);
      _xifexpression = _plus;
    } else {
      org.fornax.soa.serviceDsl.Exception _exception_3 = t.getException();
      SubNamespace _findSubdomain_1 = this._namespaceQuery.findSubdomain(_exception_3);
      String _shortName = this._schemaNamespaceExtensions.toShortName(_findSubdomain_1);
      org.fornax.soa.serviceDsl.Exception _exception_4 = t.getException();
      Version _version_1 = _exception_4.getVersion();
      String _majorVersionNumber_2 = this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
      String _plus_1 = (_shortName + _majorVersionNumber_2);
      String _plus_2 = (_plus_1 + ":");
      org.fornax.soa.serviceDsl.Exception _exception_5 = t.getException();
      String _name_1 = _exception_5.getName();
      String _plus_3 = (_plus_2 + _name_1);
      _xifexpression = _plus_3;
    }
    return _xifexpression;
  }
  
  protected boolean _isOptionalElement(final Property p) {
    boolean _or = false;
    boolean _isOptional = p.isOptional();
    if (_isOptional) {
      _or = true;
    } else {
      boolean _isIsProvidedKey = p.isIsProvidedKey();
      _or = (_isOptional || _isIsProvidedKey);
    }
    return _or;
  }
  
  protected boolean _isOptionalElement(final Attribute p) {
    boolean _or = false;
    boolean _or_1 = false;
    boolean _isOptional = p.isOptional();
    if (_isOptional) {
      _or_1 = true;
    } else {
      boolean _isWeak = p.isWeak();
      _or_1 = (_isOptional || _isWeak);
    }
    if (_or_1) {
      _or = true;
    } else {
      boolean _isIsProvidedKey = p.isIsProvidedKey();
      _or = (_or_1 || _isIsProvidedKey);
    }
    return _or;
  }
  
  protected boolean _isOptionalElement(final Reference p) {
    boolean _isIsBusinessKey = p.isIsBusinessKey();
    return (!_isIsBusinessKey);
  }
  
  protected boolean _isMany(final TypeRef t) {
    return false;
  }
  
  protected boolean _isMany(final DataTypeRef t) {
    boolean _isMany = t.isMany();
    return _isMany;
  }
  
  protected boolean _isMany(final BusinessObjectRef t) {
    return false;
  }
  
  protected boolean _isMany(final QueryObjectRef t) {
    return false;
  }
  
  protected boolean _isMany(final VersionedTypeRef t) {
    boolean _isMany = t.isMany();
    return _isMany;
  }
  
  protected String _getXsdFilename(final BusinessObject c) {
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(c);
    String _fileNameFragment = this._schemaNamespaceExtensions.toFileNameFragment(_findSubdomain);
    String _plus = (_fileNameFragment + "-v");
    Version _version = c.getVersion();
    String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_version);
    String _plus_1 = (_plus + _majorVersionNumber);
    String _plus_2 = (_plus_1 + ".xsd");
    return _plus_2;
  }
  
  /**
   * Get the namespaces a given namespace (or element declared in that namespace) imports
   *  splitting the resultingnamespace with regard to their major versions
   */
  protected Set<VersionedDomainNamespace> _getImportedSubdomains(final Object s) {
    return null;
  }
  
  protected Set<VersionedDomainNamespace> _getImportedSubdomains(final VersionedDomainNamespace s) {
    EObject _subdomain = s.getSubdomain();
    Set<VersionedDomainNamespace> _importedSubdomains = this.getImportedSubdomains(((SubNamespace) _subdomain));
    return _importedSubdomains;
  }
  
  protected Set<VersionedDomainNamespace> _getImportedSubdomains(final SubNamespace s) {
    HashSet<VersionedDomainNamespace> _hashSet = new HashSet<VersionedDomainNamespace>();
    HashSet<VersionedDomainNamespace> ns = _hashSet;
    EList<org.fornax.soa.serviceDsl.Type> _types = s.getTypes();
    Iterable<BusinessObject> _filter = Iterables.<BusinessObject>filter(_types, BusinessObject.class);
    final Function1<BusinessObject,EList<Property>> _function = new Function1<BusinessObject,EList<Property>>() {
        public EList<Property> apply(final BusinessObject t) {
          EList<Property> _properties = t.getProperties();
          return _properties;
        }
      };
    Iterable<EList<Property>> _map = IterableExtensions.<BusinessObject, EList<Property>>map(_filter, _function);
    Iterable<Property> _flatten = Iterables.<Property>concat(_map);
    final Function1<Property,TypeRef> _function_1 = new Function1<Property,TypeRef>() {
        public TypeRef apply(final Property p) {
          TypeRef _type = p.getType();
          return _type;
        }
      };
    Iterable<TypeRef> _map_1 = IterableExtensions.<Property, TypeRef>map(_flatten, _function_1);
    Iterable<VersionedTypeRef> _filter_1 = Iterables.<VersionedTypeRef>filter(_map_1, VersionedTypeRef.class);
    final Function1<VersionedTypeRef,org.fornax.soa.serviceDsl.Type> _function_2 = new Function1<VersionedTypeRef,org.fornax.soa.serviceDsl.Type>() {
        public org.fornax.soa.serviceDsl.Type apply(final VersionedTypeRef r) {
          org.fornax.soa.serviceDsl.Type _findMatchingType = SchemaTypeExtensions.this._iTypeResolver.findMatchingType(r);
          return _findMatchingType;
        }
      };
    Iterable<org.fornax.soa.serviceDsl.Type> _map_2 = IterableExtensions.<VersionedTypeRef, org.fornax.soa.serviceDsl.Type>map(_filter_1, _function_2);
    final Function1<org.fornax.soa.serviceDsl.Type,Boolean> _function_3 = new Function1<org.fornax.soa.serviceDsl.Type,Boolean>() {
        public Boolean apply(final org.fornax.soa.serviceDsl.Type e) {
          boolean _notEquals = (!Objects.equal(e, null));
          return Boolean.valueOf(_notEquals);
        }
      };
    Iterable<org.fornax.soa.serviceDsl.Type> _filter_2 = IterableExtensions.<org.fornax.soa.serviceDsl.Type>filter(_map_2, _function_3);
    final Function1<org.fornax.soa.serviceDsl.Type,VersionedDomainNamespace> _function_4 = new Function1<org.fornax.soa.serviceDsl.Type,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final org.fornax.soa.serviceDsl.Type e) {
          VersionedDomainNamespace _createVersionedDomainNamespace = SchemaTypeExtensions.this._namespaceSplitter.createVersionedDomainNamespace(e);
          return _createVersionedDomainNamespace;
        }
      };
    Iterable<VersionedDomainNamespace> _map_3 = IterableExtensions.<org.fornax.soa.serviceDsl.Type, VersionedDomainNamespace>map(_filter_2, _function_4);
    Iterables.<VersionedDomainNamespace>addAll(ns, _map_3);
    EList<org.fornax.soa.serviceDsl.Type> _types_1 = s.getTypes();
    Iterable<QueryObject> _filter_3 = Iterables.<QueryObject>filter(_types_1, QueryObject.class);
    final Function1<QueryObject,EList<Property>> _function_5 = new Function1<QueryObject,EList<Property>>() {
        public EList<Property> apply(final QueryObject t) {
          EList<Property> _properties = t.getProperties();
          return _properties;
        }
      };
    Iterable<EList<Property>> _map_4 = IterableExtensions.<QueryObject, EList<Property>>map(_filter_3, _function_5);
    Iterable<Property> _flatten_1 = Iterables.<Property>concat(_map_4);
    final Function1<Property,TypeRef> _function_6 = new Function1<Property,TypeRef>() {
        public TypeRef apply(final Property p) {
          TypeRef _type = p.getType();
          return _type;
        }
      };
    Iterable<TypeRef> _map_5 = IterableExtensions.<Property, TypeRef>map(_flatten_1, _function_6);
    Iterable<VersionedTypeRef> _filter_4 = Iterables.<VersionedTypeRef>filter(_map_5, VersionedTypeRef.class);
    final Function1<VersionedTypeRef,org.fornax.soa.serviceDsl.Type> _function_7 = new Function1<VersionedTypeRef,org.fornax.soa.serviceDsl.Type>() {
        public org.fornax.soa.serviceDsl.Type apply(final VersionedTypeRef r) {
          org.fornax.soa.serviceDsl.Type _findMatchingType = SchemaTypeExtensions.this._iTypeResolver.findMatchingType(r);
          return _findMatchingType;
        }
      };
    Iterable<org.fornax.soa.serviceDsl.Type> _map_6 = IterableExtensions.<VersionedTypeRef, org.fornax.soa.serviceDsl.Type>map(_filter_4, _function_7);
    final Function1<org.fornax.soa.serviceDsl.Type,Boolean> _function_8 = new Function1<org.fornax.soa.serviceDsl.Type,Boolean>() {
        public Boolean apply(final org.fornax.soa.serviceDsl.Type e) {
          boolean _notEquals = (!Objects.equal(e, null));
          return Boolean.valueOf(_notEquals);
        }
      };
    Iterable<org.fornax.soa.serviceDsl.Type> _filter_5 = IterableExtensions.<org.fornax.soa.serviceDsl.Type>filter(_map_6, _function_8);
    final Function1<org.fornax.soa.serviceDsl.Type,VersionedDomainNamespace> _function_9 = new Function1<org.fornax.soa.serviceDsl.Type,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final org.fornax.soa.serviceDsl.Type e) {
          VersionedDomainNamespace _createVersionedDomainNamespace = SchemaTypeExtensions.this._namespaceSplitter.createVersionedDomainNamespace(e);
          return _createVersionedDomainNamespace;
        }
      };
    Iterable<VersionedDomainNamespace> _map_7 = IterableExtensions.<org.fornax.soa.serviceDsl.Type, VersionedDomainNamespace>map(_filter_5, _function_9);
    Iterables.<VersionedDomainNamespace>addAll(ns, _map_7);
    EList<org.fornax.soa.serviceDsl.Type> _types_2 = s.getTypes();
    Iterable<BusinessObject> _filter_6 = Iterables.<BusinessObject>filter(_types_2, BusinessObject.class);
    final Function1<BusinessObject,Boolean> _function_10 = new Function1<BusinessObject,Boolean>() {
        public Boolean apply(final BusinessObject e) {
          BusinessObjectRef _superBusinessObject = e.getSuperBusinessObject();
          boolean _notEquals = (!Objects.equal(_superBusinessObject, null));
          return Boolean.valueOf(_notEquals);
        }
      };
    Iterable<BusinessObject> _filter_7 = IterableExtensions.<BusinessObject>filter(_filter_6, _function_10);
    final Function1<BusinessObject,VersionedDomainNamespace> _function_11 = new Function1<BusinessObject,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final BusinessObject b) {
          BusinessObjectRef _superBusinessObject = b.getSuperBusinessObject();
          org.fornax.soa.serviceDsl.Type _findMatchingType = SchemaTypeExtensions.this._iTypeResolver.findMatchingType(_superBusinessObject);
          VersionedDomainNamespace _createVersionedDomainNamespace = SchemaTypeExtensions.this._namespaceSplitter.createVersionedDomainNamespace(_findMatchingType);
          return _createVersionedDomainNamespace;
        }
      };
    Iterable<VersionedDomainNamespace> _map_8 = IterableExtensions.<BusinessObject, VersionedDomainNamespace>map(_filter_7, _function_11);
    Iterables.<VersionedDomainNamespace>addAll(ns, _map_8);
    EList<org.fornax.soa.serviceDsl.Exception> _exceptions = s.getExceptions();
    final Function1<org.fornax.soa.serviceDsl.Exception,Boolean> _function_12 = new Function1<org.fornax.soa.serviceDsl.Exception,Boolean>() {
        public Boolean apply(final org.fornax.soa.serviceDsl.Exception e) {
          ExceptionRef _superException = e.getSuperException();
          boolean _notEquals = (!Objects.equal(_superException, null));
          return Boolean.valueOf(_notEquals);
        }
      };
    Iterable<org.fornax.soa.serviceDsl.Exception> _filter_8 = IterableExtensions.<org.fornax.soa.serviceDsl.Exception>filter(_exceptions, _function_12);
    final Function1<org.fornax.soa.serviceDsl.Exception,VersionedDomainNamespace> _function_13 = new Function1<org.fornax.soa.serviceDsl.Exception,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final org.fornax.soa.serviceDsl.Exception ex) {
          ExceptionRef _superException = ex.getSuperException();
          org.fornax.soa.serviceDsl.Exception _findMatchingException = SchemaTypeExtensions.this._iExceptionResolver.findMatchingException(_superException);
          VersionedDomainNamespace _createVersionedDomainNamespace = SchemaTypeExtensions.this._namespaceSplitter.createVersionedDomainNamespace(_findMatchingException);
          return _createVersionedDomainNamespace;
        }
      };
    Iterable<VersionedDomainNamespace> _map_9 = IterableExtensions.<org.fornax.soa.serviceDsl.Exception, VersionedDomainNamespace>map(_filter_8, _function_13);
    Iterables.<VersionedDomainNamespace>addAll(ns, _map_9);
    return ns;
  }
  
  protected Set<VersionedDomainNamespace> _getImportedSubdomains(final List<TypeRef> c) {
    final Function1<TypeRef,VersionedDomainNamespace> _function = new Function1<TypeRef,VersionedDomainNamespace>() {
        public VersionedDomainNamespace apply(final TypeRef e) {
          org.fornax.soa.serviceDsl.Type _findMatchingType = SchemaTypeExtensions.this._iTypeResolver.findMatchingType(e);
          VersionedDomainNamespace _createVersionedDomainNamespace = SchemaTypeExtensions.this._namespaceSplitter.createVersionedDomainNamespace(_findMatchingType);
          return _createVersionedDomainNamespace;
        }
      };
    List<VersionedDomainNamespace> _map = ListExtensions.<TypeRef, VersionedDomainNamespace>map(c, _function);
    Set<VersionedDomainNamespace> _set = IterableExtensions.<VersionedDomainNamespace>toSet(_map);
    return _set;
  }
  
  protected String _toNamespace(final TypeRef t) {
    return null;
  }
  
  protected String _toNamespace(final VersionedTypeRef t) {
    VersionedType _type = t.getType();
    EObject _eContainer = _type.eContainer();
    String _unversionedNamespace = this._schemaNamespaceExtensions.toUnversionedNamespace(_eContainer);
    String _plus = (_unversionedNamespace + "/");
    org.fornax.soa.serviceDsl.Type _findMatchingType = this._iTypeResolver.findMatchingType(t);
    Version _version = ((VersionedType) _findMatchingType).getVersion();
    String _versionPostfix = this._versionQualifierExtensions.toVersionPostfix(_version);
    String _plus_1 = (_plus + _versionPostfix);
    String _plus_2 = (_plus_1 + "/");
    return _plus_2;
  }
  
  protected String _toNamespace(final BusinessObjectRef t) {
    BusinessObject _type = t.getType();
    EObject _eContainer = _type.eContainer();
    String _unversionedNamespace = this._schemaNamespaceExtensions.toUnversionedNamespace(_eContainer);
    String _plus = (_unversionedNamespace + "/");
    org.fornax.soa.serviceDsl.Type _findMatchingType = this._iTypeResolver.findMatchingType(t);
    Version _version = ((BusinessObject) _findMatchingType).getVersion();
    String _versionPostfix = this._versionQualifierExtensions.toVersionPostfix(_version);
    String _plus_1 = (_plus + _versionPostfix);
    String _plus_2 = (_plus_1 + "/");
    return _plus_2;
  }
  
  protected String _toNamespace(final QueryObjectRef t) {
    QueryObject _type = t.getType();
    EObject _eContainer = _type.eContainer();
    String _unversionedNamespace = this._schemaNamespaceExtensions.toUnversionedNamespace(_eContainer);
    String _plus = (_unversionedNamespace + "/");
    org.fornax.soa.serviceDsl.Type _findMatchingType = this._iTypeResolver.findMatchingType(t);
    Version _version = ((QueryObject) _findMatchingType).getVersion();
    String _versionPostfix = this._versionQualifierExtensions.toVersionPostfix(_version);
    String _plus_1 = (_plus + _versionPostfix);
    String _plus_2 = (_plus_1 + "/");
    return _plus_2;
  }
  
  protected String _toNamespace(final EnumTypeRef t) {
    Enumeration _type = t.getType();
    EObject _eContainer = _type.eContainer();
    String _unversionedNamespace = this._schemaNamespaceExtensions.toUnversionedNamespace(_eContainer);
    String _plus = (_unversionedNamespace + "/");
    org.fornax.soa.serviceDsl.Type _findMatchingType = this._iTypeResolver.findMatchingType(t);
    Version _version = ((Enumeration) _findMatchingType).getVersion();
    String _versionPostfix = this._versionQualifierExtensions.toVersionPostfix(_version);
    String _plus_1 = (_plus + _versionPostfix);
    String _plus_2 = (_plus_1 + "/");
    return _plus_2;
  }
  
  protected String _toNamespace(final ExceptionRef t) {
    org.fornax.soa.serviceDsl.Exception _exception = t.getException();
    EObject _eContainer = _exception.eContainer();
    String _unversionedNamespace = this._schemaNamespaceExtensions.toUnversionedNamespace(_eContainer);
    String _plus = (_unversionedNamespace + "/");
    org.fornax.soa.serviceDsl.Exception _findMatchingException = this._iExceptionResolver.findMatchingException(t);
    Version _version = ((org.fornax.soa.serviceDsl.Exception) _findMatchingException).getVersion();
    String _versionPostfix = this._versionQualifierExtensions.toVersionPostfix(_version);
    String _plus_1 = (_plus + _versionPostfix);
    String _plus_2 = (_plus_1 + "/");
    return _plus_2;
  }
  
  protected String _toNamespace(final SubNamespace ns) {
    String _unversionedNamespace = this._schemaNamespaceExtensions.toUnversionedNamespace(ns);
    String _plus = (_unversionedNamespace + "/");
    return _plus;
  }
  
  protected String _toNamespace(final VersionedDomainNamespace ns) {
    String _unversionedNamespace = this._schemaNamespaceExtensions.toUnversionedNamespace(ns);
    String _plus = (_unversionedNamespace + "/");
    String _version = ns.getVersion();
    String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_version);
    String _versionPostfix = this._versionQualifierExtensions.toVersionPostfix(_majorVersionNumber);
    String _plus_1 = (_plus + _versionPostfix);
    String _plus_2 = (_plus_1 + "/");
    return _plus_2;
  }
  
  public boolean typesUseExtendibleProperties(final SOAProfile p) {
    boolean _and = false;
    boolean _and_1 = false;
    DesignRules _designRules = p.getDesignRules();
    boolean _notEquals = (!Objects.equal(_designRules, null));
    if (!_notEquals) {
      _and_1 = false;
    } else {
      DesignRules _designRules_1 = p.getDesignRules();
      TypeDefPolicy _typeDefPolicy = _designRules_1.getTypeDefPolicy();
      boolean _notEquals_1 = (!Objects.equal(_typeDefPolicy, null));
      _and_1 = (_notEquals && _notEquals_1);
    }
    if (!_and_1) {
      _and = false;
    } else {
      DesignRules _designRules_2 = p.getDesignRules();
      TypeDefPolicy _typeDefPolicy_1 = _designRules_2.getTypeDefPolicy();
      TypeVersionEvolution _versionEvolution = _typeDefPolicy_1.getVersionEvolution();
      boolean _notEquals_2 = (!Objects.equal(_versionEvolution, null));
      _and = (_and_1 && _notEquals_2);
    }
    if (_and) {
      DesignRules _designRules_3 = p.getDesignRules();
      TypeDefPolicy _typeDefPolicy_2 = _designRules_3.getTypeDefPolicy();
      TypeVersionEvolution _versionEvolution_1 = _typeDefPolicy_2.getVersionEvolution();
      return _versionEvolution_1.isExtendibleProperties();
    } else {
      return false;
    }
  }
  
  public boolean typesUseExtendibleXMLAttributes(final SOAProfile p) {
    boolean _and = false;
    boolean _and_1 = false;
    DesignRules _designRules = p.getDesignRules();
    boolean _notEquals = (!Objects.equal(_designRules, null));
    if (!_notEquals) {
      _and_1 = false;
    } else {
      DesignRules _designRules_1 = p.getDesignRules();
      TypeDefPolicy _typeDefPolicy = _designRules_1.getTypeDefPolicy();
      boolean _notEquals_1 = (!Objects.equal(_typeDefPolicy, null));
      _and_1 = (_notEquals && _notEquals_1);
    }
    if (!_and_1) {
      _and = false;
    } else {
      DesignRules _designRules_2 = p.getDesignRules();
      TypeDefPolicy _typeDefPolicy_1 = _designRules_2.getTypeDefPolicy();
      TypeVersionEvolution _versionEvolution = _typeDefPolicy_1.getVersionEvolution();
      boolean _notEquals_2 = (!Objects.equal(_versionEvolution, null));
      _and = (_and_1 && _notEquals_2);
    }
    if (_and) {
      DesignRules _designRules_3 = p.getDesignRules();
      TypeDefPolicy _typeDefPolicy_2 = _designRules_3.getTypeDefPolicy();
      TypeVersionEvolution _versionEvolution_1 = _typeDefPolicy_2.getVersionEvolution();
      return _versionEvolution_1.isExtendibleXMLAttributes();
    } else {
      return false;
    }
  }
  
  public boolean useExtendibleSubtypes(final SOAProfile p) {
    boolean _and = false;
    boolean _and_1 = false;
    DesignRules _designRules = p.getDesignRules();
    boolean _notEquals = (!Objects.equal(_designRules, null));
    if (!_notEquals) {
      _and_1 = false;
    } else {
      DesignRules _designRules_1 = p.getDesignRules();
      TypeDefPolicy _typeDefPolicy = _designRules_1.getTypeDefPolicy();
      boolean _notEquals_1 = (!Objects.equal(_typeDefPolicy, null));
      _and_1 = (_notEquals && _notEquals_1);
    }
    if (!_and_1) {
      _and = false;
    } else {
      DesignRules _designRules_2 = p.getDesignRules();
      TypeDefPolicy _typeDefPolicy_1 = _designRules_2.getTypeDefPolicy();
      TypeVersionEvolution _versionEvolution = _typeDefPolicy_1.getVersionEvolution();
      boolean _notEquals_2 = (!Objects.equal(_versionEvolution, null));
      _and = (_and_1 && _notEquals_2);
    }
    if (_and) {
      DesignRules _designRules_3 = p.getDesignRules();
      TypeDefPolicy _typeDefPolicy_2 = _designRules_3.getTypeDefPolicy();
      TypeVersionEvolution _versionEvolution_1 = _typeDefPolicy_2.getVersionEvolution();
      return _versionEvolution_1.isExtendibleSubTypes();
    } else {
      return false;
    }
  }
  
  public String getTypesExtendiblePropertiesClause(final SOAProfile p) {
    boolean _typesUseExtendibleProperties = this.typesUseExtendibleProperties(p);
    if (_typesUseExtendibleProperties) {
      DesignRules _designRules = p.getDesignRules();
      TypeDefPolicy _typeDefPolicy = _designRules.getTypeDefPolicy();
      TypeVersionEvolution _versionEvolution = _typeDefPolicy.getVersionEvolution();
      String _extendibleXMLClause = _versionEvolution.getExtendibleXMLClause();
      boolean _notEquals = (!Objects.equal(_extendibleXMLClause, null));
      if (_notEquals) {
        DesignRules _designRules_1 = p.getDesignRules();
        TypeDefPolicy _typeDefPolicy_1 = _designRules_1.getTypeDefPolicy();
        TypeVersionEvolution _versionEvolution_1 = _typeDefPolicy_1.getVersionEvolution();
        return _versionEvolution_1.getExtendibleXMLClause();
      } else {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("<xsd:any maxOccurs=\"unbounded\" minOccurs=\"0\" namespace=\"http://www.w3.org/2001/XMLSchema ##local\"");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("processContents=\"skip\"/>");
        _builder.newLine();
        return _builder.toString();
      }
    } else {
      return "";
    }
  }
  
  public String getTypesExtendibleXMLAttributesClause(final SOAProfile p) {
    boolean _typesUseExtendibleXMLAttributes = this.typesUseExtendibleXMLAttributes(p);
    if (_typesUseExtendibleXMLAttributes) {
      DesignRules _designRules = p.getDesignRules();
      TypeDefPolicy _typeDefPolicy = _designRules.getTypeDefPolicy();
      TypeVersionEvolution _versionEvolution = _typeDefPolicy.getVersionEvolution();
      String _extendibleXMLAttributeClause = _versionEvolution.getExtendibleXMLAttributeClause();
      boolean _notEquals = (!Objects.equal(_extendibleXMLAttributeClause, null));
      if (_notEquals) {
        DesignRules _designRules_1 = p.getDesignRules();
        TypeDefPolicy _typeDefPolicy_1 = _designRules_1.getTypeDefPolicy();
        TypeVersionEvolution _versionEvolution_1 = _typeDefPolicy_1.getVersionEvolution();
        return _versionEvolution_1.getExtendibleXMLAttributeClause();
      } else {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("<xsd:anyAttribute namespace=\"##any\"/>");
        _builder.newLine();
        return _builder.toString();
      }
    } else {
      return "";
    }
  }
  
  public String toTypeNameRef(final EObject t) {
    if (t instanceof BusinessObjectRef) {
      return _toTypeNameRef((BusinessObjectRef)t);
    } else if (t instanceof EnumTypeRef) {
      return _toTypeNameRef((EnumTypeRef)t);
    } else if (t instanceof QueryObjectRef) {
      return _toTypeNameRef((QueryObjectRef)t);
    } else if (t instanceof VersionedTypeRef) {
      return _toTypeNameRef((VersionedTypeRef)t);
    } else if (t instanceof DataType) {
      return _toTypeNameRef((DataType)t);
    } else if (t instanceof org.fornax.soa.profiledsl.sOAProfileDsl.DataTypeRef) {
      return _toTypeNameRef((org.fornax.soa.profiledsl.sOAProfileDsl.DataTypeRef)t);
    } else if (t instanceof org.fornax.soa.profiledsl.sOAProfileDsl.VersionedTypeRef) {
      return _toTypeNameRef((org.fornax.soa.profiledsl.sOAProfileDsl.VersionedTypeRef)t);
    } else if (t instanceof DataTypeRef) {
      return _toTypeNameRef((DataTypeRef)t);
    } else if (t instanceof AttributeDataTypeRef) {
      return _toTypeNameRef((AttributeDataTypeRef)t);
    } else if (t instanceof org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef) {
      return _toTypeNameRef((org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef)t);
    } else if (t instanceof org.fornax.soa.serviceDsl.Type) {
      return _toTypeNameRef((org.fornax.soa.serviceDsl.Type)t);
    } else if (t instanceof TypeRef) {
      return _toTypeNameRef((TypeRef)t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t).toString());
    }
  }
  
  public String toTypeNameRef(final EObject t, final VersionedDomainNamespace currNs) {
    if (t instanceof BusinessObjectRef) {
      return _toTypeNameRef((BusinessObjectRef)t, currNs);
    } else if (t instanceof EnumTypeRef) {
      return _toTypeNameRef((EnumTypeRef)t, currNs);
    } else if (t instanceof QueryObjectRef) {
      return _toTypeNameRef((QueryObjectRef)t, currNs);
    } else if (t instanceof VersionedTypeRef) {
      return _toTypeNameRef((VersionedTypeRef)t, currNs);
    } else if (t instanceof DataTypeRef) {
      return _toTypeNameRef((DataTypeRef)t, currNs);
    } else if (t instanceof ClassRef) {
      return _toTypeNameRef((ClassRef)t, currNs);
    } else if (t instanceof org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef) {
      return _toTypeNameRef((org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef)t, currNs);
    } else if (t instanceof TypeRef) {
      return _toTypeNameRef((TypeRef)t, currNs);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t, currNs).toString());
    }
  }
  
  public String toFullTypeNameRef(final TypeRef t, final VersionedDomainNamespace currNs) {
    if (t instanceof BusinessObjectRef) {
      return _toFullTypeNameRef((BusinessObjectRef)t, currNs);
    } else if (t instanceof EnumTypeRef) {
      return _toFullTypeNameRef((EnumTypeRef)t, currNs);
    } else if (t instanceof QueryObjectRef) {
      return _toFullTypeNameRef((QueryObjectRef)t, currNs);
    } else if (t instanceof VersionedTypeRef) {
      return _toFullTypeNameRef((VersionedTypeRef)t, currNs);
    } else if (t instanceof DataTypeRef) {
      return _toFullTypeNameRef((DataTypeRef)t, currNs);
    } else if (t != null) {
      return _toFullTypeNameRef(t, currNs);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t, currNs).toString());
    }
  }
  
  public String toFullTypeNameRef(final EObject t) {
    if (t instanceof DataType) {
      return _toFullTypeNameRef((DataType)t);
    } else if (t instanceof org.fornax.soa.serviceDsl.Type) {
      return _toFullTypeNameRef((org.fornax.soa.serviceDsl.Type)t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t).toString());
    }
  }
  
  public boolean isAttachment(final TypeRef t) {
    if (t instanceof DataTypeRef) {
      return _isAttachment((DataTypeRef)t);
    } else if (t != null) {
      return _isAttachment(t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t).toString());
    }
  }
  
  public String toWeakRefType(final TypeRef t) {
    if (t instanceof BusinessObjectRef) {
      return _toWeakRefType((BusinessObjectRef)t);
    } else if (t instanceof QueryObjectRef) {
      return _toWeakRefType((QueryObjectRef)t);
    } else if (t instanceof VersionedTypeRef) {
      return _toWeakRefType((VersionedTypeRef)t);
    } else if (t != null) {
      return _toWeakRefType(t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t).toString());
    }
  }
  
  public String toWeakRefKeyAttr(final TypeRef t) {
    if (t instanceof BusinessObjectRef) {
      return _toWeakRefKeyAttr((BusinessObjectRef)t);
    } else if (t instanceof QueryObjectRef) {
      return _toWeakRefKeyAttr((QueryObjectRef)t);
    } else if (t != null) {
      return _toWeakRefKeyAttr(t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t).toString());
    }
  }
  
  public String toWeakRefType(final TypeRef t, final LifecycleState minState) {
    if (t instanceof BusinessObjectRef) {
      return _toWeakRefType((BusinessObjectRef)t, minState);
    } else if (t instanceof QueryObjectRef) {
      return _toWeakRefType((QueryObjectRef)t, minState);
    } else if (t instanceof VersionedTypeRef) {
      return _toWeakRefType((VersionedTypeRef)t, minState);
    } else if (t != null) {
      return _toWeakRefType(t, minState);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t, minState).toString());
    }
  }
  
  public String toWeakRefKeyAttr(final TypeRef t, final LifecycleState minState) {
    if (t instanceof BusinessObjectRef) {
      return _toWeakRefKeyAttr((BusinessObjectRef)t, minState);
    } else if (t instanceof QueryObjectRef) {
      return _toWeakRefKeyAttr((QueryObjectRef)t, minState);
    } else if (t != null) {
      return _toWeakRefKeyAttr(t, minState);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t, minState).toString());
    }
  }
  
  public String toExceptionNameRef(final ExceptionRef t, final VersionedDomainNamespace currNs) {
    {
      return _toExceptionNameRef(t, currNs);
    }
  }
  
  public boolean isOptionalElement(final Property p) {
    if (p instanceof Attribute) {
      return _isOptionalElement((Attribute)p);
    } else if (p instanceof Reference) {
      return _isOptionalElement((Reference)p);
    } else if (p != null) {
      return _isOptionalElement(p);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(p).toString());
    }
  }
  
  public boolean isMany(final TypeRef t) {
    if (t instanceof BusinessObjectRef) {
      return _isMany((BusinessObjectRef)t);
    } else if (t instanceof QueryObjectRef) {
      return _isMany((QueryObjectRef)t);
    } else if (t instanceof VersionedTypeRef) {
      return _isMany((VersionedTypeRef)t);
    } else if (t instanceof DataTypeRef) {
      return _isMany((DataTypeRef)t);
    } else if (t != null) {
      return _isMany(t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t).toString());
    }
  }
  
  public String getXsdFilename(final BusinessObject c) {
    {
      return _getXsdFilename(c);
    }
  }
  
  public Set<VersionedDomainNamespace> getImportedSubdomains(final Object c) {
    if (c instanceof List) {
      return _getImportedSubdomains((List<TypeRef>)c);
    } else if (c instanceof SubNamespace) {
      return _getImportedSubdomains((SubNamespace)c);
    } else if (c instanceof VersionedDomainNamespace) {
      return _getImportedSubdomains((VersionedDomainNamespace)c);
    } else if (c != null) {
      return _getImportedSubdomains(c);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(c).toString());
    }
  }
  
  public String toNamespace(final Object t) {
    if (t instanceof BusinessObjectRef) {
      return _toNamespace((BusinessObjectRef)t);
    } else if (t instanceof EnumTypeRef) {
      return _toNamespace((EnumTypeRef)t);
    } else if (t instanceof QueryObjectRef) {
      return _toNamespace((QueryObjectRef)t);
    } else if (t instanceof VersionedTypeRef) {
      return _toNamespace((VersionedTypeRef)t);
    } else if (t instanceof ExceptionRef) {
      return _toNamespace((ExceptionRef)t);
    } else if (t instanceof SubNamespace) {
      return _toNamespace((SubNamespace)t);
    } else if (t instanceof TypeRef) {
      return _toNamespace((TypeRef)t);
    } else if (t instanceof VersionedDomainNamespace) {
      return _toNamespace((VersionedDomainNamespace)t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t).toString());
    }
  }
}
