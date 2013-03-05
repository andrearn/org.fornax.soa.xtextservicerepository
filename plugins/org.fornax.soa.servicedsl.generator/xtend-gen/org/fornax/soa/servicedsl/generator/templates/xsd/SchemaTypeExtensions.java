package org.fornax.soa.servicedsl.generator.templates.xsd;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;
import org.fornax.soa.basedsl.search.IEObjectLookup;
import org.fornax.soa.basedsl.version.VersionMatcher;
import org.fornax.soa.basedsl.version.VersionQualifierExtensions;
import org.fornax.soa.profiledsl.generator.schema.ProfileSchemaTypeExtensions;
import org.fornax.soa.profiledsl.query.namespace.TechnicalNamespaceQueries;
import org.fornax.soa.profiledsl.sOAProfileDsl.AttributeDataTypeRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.ClassRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.DataType;
import org.fornax.soa.profiledsl.sOAProfileDsl.DesignRules;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace;
import org.fornax.soa.profiledsl.sOAProfileDsl.Type;
import org.fornax.soa.profiledsl.sOAProfileDsl.TypeDefPolicy;
import org.fornax.soa.profiledsl.sOAProfileDsl.TypeVersionEvolution;
import org.fornax.soa.service.VersionedDomainNamespace;
import org.fornax.soa.service.query.VersionQueries;
import org.fornax.soa.service.query.namespace.NamespaceQuery;
import org.fornax.soa.service.versioning.IExceptionResolver;
import org.fornax.soa.service.versioning.ITypeResolver;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.BusinessObjectRef;
import org.fornax.soa.serviceDsl.DataTypeRef;
import org.fornax.soa.serviceDsl.EnumTypeRef;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.serviceDsl.ExceptionRef;
import org.fornax.soa.serviceDsl.Property;
import org.fornax.soa.serviceDsl.QueryObject;
import org.fornax.soa.serviceDsl.QueryObjectRef;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.serviceDsl.VersionedType;
import org.fornax.soa.serviceDsl.VersionedTypeRef;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions;

/**
 * Extension functions for
 * Type representations and references in XSDs
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
  private VersionQualifierExtensions _versionQualifierExtensions;
  
  @Inject
  private VersionQueries _versionQueries;
  
  @Inject
  private ITypeResolver _iTypeResolver;
  
  @Inject
  private IExceptionResolver _iExceptionResolver;
  
  @Inject
  private IEObjectLookup _iEObjectLookup;
  
  @Inject
  private ProfileSchemaTypeExtensions profileSchemaTypes;
  
  @Inject
  private TechnicalNamespaceQueries profileNSQueries;
  
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
        SubNamespace _findTypeRefOwnerSubdomain = this._namespaceQuery.findTypeRefOwnerSubdomain(t);
        VersionedType _type_1 = t.getType();
        SubNamespace _findSubdomain_1 = this._namespaceQuery.findSubdomain(_type_1);
        boolean _equals = Objects.equal(_findTypeRefOwnerSubdomain, _findSubdomain_1);
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
          EObject _statefulOwner = this._iEObjectLookup.getStatefulOwner(t);
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
        SubNamespace _findTypeRefOwnerSubdomain = this._namespaceQuery.findTypeRefOwnerSubdomain(t);
        BusinessObject _type_1 = t.getType();
        SubNamespace _findSubdomain_1 = this._namespaceQuery.findSubdomain(_type_1);
        boolean _equals = Objects.equal(_findTypeRefOwnerSubdomain, _findSubdomain_1);
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
          EObject _statefulOwner = this._iEObjectLookup.getStatefulOwner(t);
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
        SubNamespace _findTypeRefOwnerSubdomain = this._namespaceQuery.findTypeRefOwnerSubdomain(t);
        QueryObject _type_1 = t.getType();
        SubNamespace _findSubdomain_1 = this._namespaceQuery.findSubdomain(_type_1);
        boolean _equals = Objects.equal(_findTypeRefOwnerSubdomain, _findSubdomain_1);
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
          EObject _statefulOwner = this._iEObjectLookup.getStatefulOwner(t);
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
        SubNamespace _findTypeRefOwnerSubdomain = this._namespaceQuery.findTypeRefOwnerSubdomain(t);
        Enumeration _type_1 = t.getType();
        SubNamespace _findSubdomain_1 = this._namespaceQuery.findSubdomain(_type_1);
        boolean _equals = Objects.equal(_findTypeRefOwnerSubdomain, _findSubdomain_1);
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
          EObject _statefulOwner = this._iEObjectLookup.getStatefulOwner(t);
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
        SubNamespace _findExceptionRefOwnerSubdomain = this._namespaceQuery.findExceptionRefOwnerSubdomain(exRef);
        org.fornax.soa.serviceDsl.Exception _exception_1 = exRef.getException();
        SubNamespace _findSubdomain_1 = this._namespaceQuery.findSubdomain(_exception_1);
        boolean _equals = Objects.equal(_findExceptionRefOwnerSubdomain, _findSubdomain_1);
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
          EObject _statefulOwner = this._iEObjectLookup.getStatefulOwner(exRef);
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
  
  /**
   * Calculate the plain type name used when a type needs to be referenced. The type name is not
   * qualified by namespace prefixes
   */
  protected String _toTypeNameRef(final TypeRef typeRef, final VersionedDomainNamespace currNs) {
    return null;
  }
  
  /**
   * Calculate the plain type name used when a type needs to be referenced. The type name is not
   * qualified by namespace prefixes
   */
  protected String _toTypeNameRef(final org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef typeRef, final VersionedDomainNamespace currNs) {
    return null;
  }
  
  /**
   * Calculate the plain type name used when a type needs to be referenced. The type name is not
   * qualified by namespace prefixes
   */
  protected String _toTypeNameRef(final DataTypeRef typeRef, final VersionedDomainNamespace currentDomNs) {
    Type _findMatchingType = this._iTypeResolver.findMatchingType(typeRef);
    String _typeNameRef = this.toTypeNameRef(_findMatchingType);
    return _typeNameRef;
  }
  
  /**
   * Calculate the plain type name used when a type needs to be referenced. The type name is not
   * qualified by namespace prefixes
   */
  protected String _toTypeNameRef(final VersionedTypeRef typeRef, final VersionedDomainNamespace currNs) {
    String _xifexpression = null;
    boolean _and = false;
    boolean _and_1 = false;
    VersionedType _type = typeRef.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    String _unversionedNamespace = this._schemaNamespaceExtensions.toUnversionedNamespace(_findSubdomain);
    EObject _subdomain = currNs.getSubdomain();
    String _unversionedNamespace_1 = this._schemaNamespaceExtensions.toUnversionedNamespace(_subdomain);
    boolean _equals = Objects.equal(_unversionedNamespace, _unversionedNamespace_1);
    if (!_equals) {
      _and_1 = false;
    } else {
      Version _ownerVersion = this._versionQueries.getOwnerVersion(typeRef);
      String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_ownerVersion);
      VersionedType _type_1 = typeRef.getType();
      Version _version = _type_1.getVersion();
      String _majorVersionNumber_1 = this._versionQualifierExtensions.toMajorVersionNumber(_version);
      boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
      _and_1 = (_equals && _equals_1);
    }
    if (!_and_1) {
      _and = false;
    } else {
      EObject _statefulOwner = this._iEObjectLookup.getStatefulOwner(typeRef);
      boolean _not = (!(_statefulOwner instanceof Service));
      _and = (_and_1 && _not);
    }
    if (_and) {
      VersionedType _type_2 = typeRef.getType();
      String _name = _type_2.getName();
      String _plus = ("tns:" + _name);
      _xifexpression = _plus;
    } else {
      VersionedType _type_3 = typeRef.getType();
      SubNamespace _findSubdomain_1 = this._namespaceQuery.findSubdomain(_type_3);
      String _shortName = this._schemaNamespaceExtensions.toShortName(_findSubdomain_1);
      VersionedType _type_4 = typeRef.getType();
      Version _version_1 = _type_4.getVersion();
      String _majorVersionNumber_2 = this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
      String _plus_1 = (_shortName + _majorVersionNumber_2);
      String _plus_2 = (_plus_1 + ":");
      VersionedType _type_5 = typeRef.getType();
      String _name_1 = _type_5.getName();
      String _plus_3 = (_plus_2 + _name_1);
      _xifexpression = _plus_3;
    }
    return _xifexpression;
  }
  
  /**
   * Calculate the plain type name used when a type needs to be referenced. The type name is not
   * qualified by namespace prefixes
   */
  protected String _toTypeNameRef(final BusinessObjectRef typeRef, final VersionedDomainNamespace currNs) {
    String _xifexpression = null;
    boolean _and = false;
    boolean _and_1 = false;
    BusinessObject _type = typeRef.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    String _unversionedNamespace = this._schemaNamespaceExtensions.toUnversionedNamespace(_findSubdomain);
    EObject _subdomain = currNs.getSubdomain();
    String _unversionedNamespace_1 = this._schemaNamespaceExtensions.toUnversionedNamespace(_subdomain);
    boolean _equals = Objects.equal(_unversionedNamespace, _unversionedNamespace_1);
    if (!_equals) {
      _and_1 = false;
    } else {
      Version _ownerVersion = this._versionQueries.getOwnerVersion(typeRef);
      String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_ownerVersion);
      BusinessObject _type_1 = typeRef.getType();
      Version _version = _type_1.getVersion();
      String _majorVersionNumber_1 = this._versionQualifierExtensions.toMajorVersionNumber(_version);
      boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
      _and_1 = (_equals && _equals_1);
    }
    if (!_and_1) {
      _and = false;
    } else {
      EObject _statefulOwner = this._iEObjectLookup.getStatefulOwner(typeRef);
      boolean _not = (!(_statefulOwner instanceof Service));
      _and = (_and_1 && _not);
    }
    if (_and) {
      BusinessObject _type_2 = typeRef.getType();
      String _name = _type_2.getName();
      String _plus = ("tns:" + _name);
      _xifexpression = _plus;
    } else {
      BusinessObject _type_3 = typeRef.getType();
      SubNamespace _findSubdomain_1 = this._namespaceQuery.findSubdomain(_type_3);
      String _shortName = this._schemaNamespaceExtensions.toShortName(_findSubdomain_1);
      BusinessObject _type_4 = typeRef.getType();
      Version _version_1 = _type_4.getVersion();
      String _majorVersionNumber_2 = this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
      String _plus_1 = (_shortName + _majorVersionNumber_2);
      String _plus_2 = (_plus_1 + ":");
      BusinessObject _type_5 = typeRef.getType();
      String _name_1 = _type_5.getName();
      String _plus_3 = (_plus_2 + _name_1);
      _xifexpression = _plus_3;
    }
    return _xifexpression;
  }
  
  /**
   * Calculate the plain type name used when a type needs to be referenced. The type name is not
   * qualified by namespace prefixes
   */
  protected String _toTypeNameRef(final QueryObjectRef typeRef, final VersionedDomainNamespace currNs) {
    String _xifexpression = null;
    boolean _and = false;
    boolean _and_1 = false;
    QueryObject _type = typeRef.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    String _unversionedNamespace = this._schemaNamespaceExtensions.toUnversionedNamespace(_findSubdomain);
    EObject _subdomain = currNs.getSubdomain();
    String _unversionedNamespace_1 = this._schemaNamespaceExtensions.toUnversionedNamespace(_subdomain);
    boolean _equals = Objects.equal(_unversionedNamespace, _unversionedNamespace_1);
    if (!_equals) {
      _and_1 = false;
    } else {
      Version _ownerVersion = this._versionQueries.getOwnerVersion(typeRef);
      String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_ownerVersion);
      QueryObject _type_1 = typeRef.getType();
      Version _version = _type_1.getVersion();
      String _majorVersionNumber_1 = this._versionQualifierExtensions.toMajorVersionNumber(_version);
      boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
      _and_1 = (_equals && _equals_1);
    }
    if (!_and_1) {
      _and = false;
    } else {
      EObject _statefulOwner = this._iEObjectLookup.getStatefulOwner(typeRef);
      boolean _not = (!(_statefulOwner instanceof Service));
      _and = (_and_1 && _not);
    }
    if (_and) {
      QueryObject _type_2 = typeRef.getType();
      String _name = _type_2.getName();
      String _plus = ("tns:" + _name);
      _xifexpression = _plus;
    } else {
      QueryObject _type_3 = typeRef.getType();
      SubNamespace _findSubdomain_1 = this._namespaceQuery.findSubdomain(_type_3);
      String _shortName = this._schemaNamespaceExtensions.toShortName(_findSubdomain_1);
      QueryObject _type_4 = typeRef.getType();
      Version _version_1 = _type_4.getVersion();
      String _majorVersionNumber_2 = this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
      String _plus_1 = (_shortName + _majorVersionNumber_2);
      String _plus_2 = (_plus_1 + ":");
      QueryObject _type_5 = typeRef.getType();
      String _name_1 = _type_5.getName();
      String _plus_3 = (_plus_2 + _name_1);
      _xifexpression = _plus_3;
    }
    return _xifexpression;
  }
  
  /**
   * Calculate the plain type name used when a type needs to be referenced. The type name is not
   * qualified by namespace prefixes
   */
  protected String _toTypeNameRef(final EnumTypeRef typeRef, final VersionedDomainNamespace currNs) {
    String _xifexpression = null;
    boolean _and = false;
    boolean _and_1 = false;
    Enumeration _type = typeRef.getType();
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(_type);
    String _unversionedNamespace = this._schemaNamespaceExtensions.toUnversionedNamespace(_findSubdomain);
    EObject _subdomain = currNs.getSubdomain();
    String _unversionedNamespace_1 = this._schemaNamespaceExtensions.toUnversionedNamespace(_subdomain);
    boolean _equals = Objects.equal(_unversionedNamespace, _unversionedNamespace_1);
    if (!_equals) {
      _and_1 = false;
    } else {
      Version _ownerVersion = this._versionQueries.getOwnerVersion(typeRef);
      String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_ownerVersion);
      Enumeration _type_1 = typeRef.getType();
      Version _version = _type_1.getVersion();
      String _majorVersionNumber_1 = this._versionQualifierExtensions.toMajorVersionNumber(_version);
      boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
      _and_1 = (_equals && _equals_1);
    }
    if (!_and_1) {
      _and = false;
    } else {
      EObject _statefulOwner = this._iEObjectLookup.getStatefulOwner(typeRef);
      boolean _not = (!(_statefulOwner instanceof Service));
      _and = (_and_1 && _not);
    }
    if (_and) {
      Enumeration _type_2 = typeRef.getType();
      String _name = _type_2.getName();
      String _plus = ("tns:" + _name);
      _xifexpression = _plus;
    } else {
      Enumeration _type_3 = typeRef.getType();
      SubNamespace _findSubdomain_1 = this._namespaceQuery.findSubdomain(_type_3);
      String _shortName = this._schemaNamespaceExtensions.toShortName(_findSubdomain_1);
      Enumeration _type_4 = typeRef.getType();
      Version _version_1 = _type_4.getVersion();
      String _majorVersionNumber_2 = this._versionQualifierExtensions.toMajorVersionNumber(_version_1);
      String _plus_1 = (_shortName + _majorVersionNumber_2);
      String _plus_2 = (_plus_1 + ":");
      Enumeration _type_5 = typeRef.getType();
      String _name_1 = _type_5.getName();
      String _plus_3 = (_plus_2 + _name_1);
      _xifexpression = _plus_3;
    }
    return _xifexpression;
  }
  
  /**
   * Calculate the plain type name used when a type needs to be referenced. The type name is not
   * qualified by namespace prefixes
   */
  protected String _toTypeNameRef(final org.fornax.soa.serviceDsl.Type type) {
    return "";
  }
  
  /**
   * Calculate the plain type name used when a type needs to be referenced. The type name is not
   * qualified by namespace prefixes
   */
  protected String _toTypeNameRef(final ClassRef typeRef, final VersionedDomainNamespace currNs) {
    String _xifexpression = null;
    boolean _and = false;
    org.fornax.soa.profiledsl.sOAProfileDsl.Class _type = typeRef.getType();
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
      VersionRef _versionRef = typeRef.getVersionRef();
      boolean _versionMatches = this._versionMatcher.versionMatches(_version_1, _versionRef);
      _and = (_equals && _versionMatches);
    }
    if (_and) {
      org.fornax.soa.profiledsl.sOAProfileDsl.Class _type_1 = typeRef.getType();
      String _name = _type_1.getName();
      String _plus = ("tns:" + _name);
      _xifexpression = _plus;
    } else {
      org.fornax.soa.profiledsl.sOAProfileDsl.Class _type_2 = typeRef.getType();
      SubNamespace _findSubdomain_1 = this._namespaceQuery.findSubdomain(_type_2);
      String _shortName = this._schemaNamespaceExtensions.toShortName(_findSubdomain_1);
      org.fornax.soa.profiledsl.sOAProfileDsl.Class _type_3 = typeRef.getType();
      Version _version_2 = _type_3.getVersion();
      String _majorVersionNumber = this._versionQualifierExtensions.toMajorVersionNumber(_version_2);
      String _plus_1 = (_shortName + _majorVersionNumber);
      String _plus_2 = (_plus_1 + ":");
      org.fornax.soa.profiledsl.sOAProfileDsl.Class _type_4 = typeRef.getType();
      String _name_1 = _type_4.getName();
      String _plus_3 = (_plus_2 + _name_1);
      _xifexpression = _plus_3;
    }
    return _xifexpression;
  }
  
  /**
   * Calculate the type name used when a type needs to be referenced. The type name is prefixed
   * with a namespace alias calculate from the (major) versioned namespace
   */
  protected String _toNsPrefixedTypeNameRef(final TypeRef t, final VersionedDomainNamespace currNs) {
    return null;
  }
  
  /**
   * Calculate the type name used when a type needs to be referenced. The type name is prefixed
   * with a namespace alias calculate from the (major) versioned namespace
   */
  protected String _toNsPrefixedTypeNameRef(final DataTypeRef t, final VersionedDomainNamespace currentDomNs) {
    Type _findMatchingType = this._iTypeResolver.findMatchingType(t);
    String _nsPrefixedTypeNameRef = this.toNsPrefixedTypeNameRef(_findMatchingType);
    return _nsPrefixedTypeNameRef;
  }
  
  /**
   * Calculate the type name used when a type needs to be referenced. The type name is prefixed
   * with a namespace alias calculate from the (major) versioned namespace
   */
  protected String _toNsPrefixedTypeNameRef(final VersionedTypeRef t, final VersionedDomainNamespace currNs) {
    String _namespace = this.toNamespace(t);
    VersionedType _type = t.getType();
    String _name = _type.getName();
    String _plus = (_namespace + _name);
    return _plus;
  }
  
  /**
   * Calculate the type name used when a type needs to be referenced. The type name is prefixed
   * with a namespace alias calculate from the (major) versioned namespace
   */
  protected String _toNsPrefixedTypeNameRef(final BusinessObjectRef t, final VersionedDomainNamespace currNs) {
    String _namespace = this.toNamespace(t);
    BusinessObject _type = t.getType();
    String _name = _type.getName();
    String _plus = (_namespace + _name);
    return _plus;
  }
  
  /**
   * Calculate the type name used when a type needs to be referenced. The type name is prefixed
   * with a namespace alias calculate from the (major) versioned namespace
   */
  protected String _toNsPrefixedTypeNameRef(final QueryObjectRef t, final VersionedDomainNamespace currNs) {
    String _namespace = this.toNamespace(t);
    QueryObject _type = t.getType();
    String _name = _type.getName();
    String _plus = (_namespace + _name);
    return _plus;
  }
  
  /**
   * Calculate the type name used when a type needs to be referenced. The type name is prefixed
   * with a namespace alias calculate from the (major) versioned namespace
   */
  protected String _toNsPrefixedTypeNameRef(final EnumTypeRef t, final VersionedDomainNamespace currNs) {
    String _namespace = this.toNamespace(t);
    Enumeration _type = t.getType();
    String _name = _type.getName();
    String _plus = (_namespace + _name);
    return _plus;
  }
  
  /**
   * Calculate the type name used when a type needs to be referenced. The type name is prefixed
   * with a namespace alias calculate from the (major) versioned namespace
   */
  protected String _toNsPrefixedTypeNameRef(final org.fornax.soa.serviceDsl.Type t) {
    return "";
  }
  
  /**
   * Calculate the type name used when a type needs to be referenced. The type name is prefixed
   * with a namespace alias calculate from the (major) versioned namespace
   */
  protected String _toNsPrefixedTypeNameRef(final DataType t) {
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
  
  protected boolean _isMimeContent(final TypeRef t) {
    return false;
  }
  
  protected boolean _isMimeContent(final DataTypeRef t) {
    String _contentType = t.getContentType();
    return (!Objects.equal(_contentType, null));
  }
  
  protected boolean _isMimeContentMultiPartAttachment(final TypeRef t) {
    return false;
  }
  
  protected boolean _isMimeContentMultiPartAttachment(final DataTypeRef t) {
    boolean _xifexpression = false;
    String _contentType = t.getContentType();
    boolean _notEquals = (!Objects.equal(_contentType, null));
    if (_notEquals) {
      boolean _switchResult = false;
      DataType _type = t.getType();
      String _name = _type.getName();
      final String _switchValue = _name;
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(_switchValue,"attachment")) {
          _matched=true;
          _switchResult = true;
        }
      }
      if (!_matched) {
        _switchResult = false;
      }
      _xifexpression = _switchResult;
    } else {
      _xifexpression = false;
    }
    return _xifexpression;
  }
  
  public String toExceptionNameRef(final ExceptionRef t, final VersionedDomainNamespace currNs) {
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
      EObject _statefulOwner = this._iEObjectLookup.getStatefulOwner(t);
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
  
  /**
   * Is the XSD element optional? Returns true, when flagged with one of the keywords:
   * <ul>
   * 	<li><b>optional</b> 		- optional for business reasons</li>
   * 	<li><b>weak</b> 			- optional for technical reasons, such as not loaded under some conditions</li>
   * 	<li><b>provided-key</b> 	- a key generated in the backend, that is not always set, such as when the object has just been created, but not yet persisted</li>
   * </ul>
   */
  public boolean isOptionalElement(final Property p) {
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
  
  /**
   * Has the type reference a many cardinality?
   */
  protected boolean _isMany(final TypeRef t) {
    return false;
  }
  
  /**
   * Has the type reference a many cardinality?
   */
  protected boolean _isMany(final DataTypeRef t) {
    boolean _isMany = t.isMany();
    return _isMany;
  }
  
  /**
   * Has the type reference a many cardinality?
   */
  protected boolean _isMany(final BusinessObjectRef t) {
    return false;
  }
  
  /**
   * Has the type reference a many cardinality?
   */
  protected boolean _isMany(final QueryObjectRef t) {
    return false;
  }
  
  /**
   * Has the type reference a many cardinality?
   */
  protected boolean _isMany(final VersionedTypeRef t) {
    boolean _isMany = t.isMany();
    return _isMany;
  }
  
  /**
   * Calculate the namespace URL
   */
  protected String _toNamespace(final TypeRef t) {
    return null;
  }
  
  /**
   * Calculate the namespace URL
   */
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
  
  /**
   * Calculate the namespace URL
   */
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
  
  /**
   * Calculate the namespace URL
   */
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
  
  /**
   * Calculate the namespace URL
   */
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
  
  /**
   * Calculate the namespace URL
   */
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
  
  /**
   * Calculate the namespace URL
   */
  protected String _toNamespace(final SubNamespace ns) {
    String _unversionedNamespace = this._schemaNamespaceExtensions.toUnversionedNamespace(ns);
    String _plus = (_unversionedNamespace + "/");
    return _plus;
  }
  
  /**
   * Calculate the namespace URL
   */
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
  
  /**
   * Determine, whether XSD type definitions should be made extendible for unknown elements in
   * the complexType
   */
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
  
  /**
   * Determine, whether XSD type definitions should be made extendible for unknown XML attributes
   */
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
  
  /**
   * Determine, whether XSD type definitions, that subtype another type definition,
   * should be made extendible for unknown XML elements or attributes
   */
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
  
  /**
   * Get the XSD any clause that makes complexTypes backward compatible allowing additional
   * optional elements
   */
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
  
  /**
   * Get the XSD anyAttribute clause that makes complexTypes backward compatible allowing additional
   * optional XML attributes in the type
   */
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
  
  public String toTypeNameRef(final EObject typeRef, final VersionedDomainNamespace currNs) {
    if (typeRef instanceof BusinessObjectRef) {
      return _toTypeNameRef((BusinessObjectRef)typeRef, currNs);
    } else if (typeRef instanceof EnumTypeRef) {
      return _toTypeNameRef((EnumTypeRef)typeRef, currNs);
    } else if (typeRef instanceof QueryObjectRef) {
      return _toTypeNameRef((QueryObjectRef)typeRef, currNs);
    } else if (typeRef instanceof VersionedTypeRef) {
      return _toTypeNameRef((VersionedTypeRef)typeRef, currNs);
    } else if (typeRef instanceof DataTypeRef) {
      return _toTypeNameRef((DataTypeRef)typeRef, currNs);
    } else if (typeRef instanceof ClassRef) {
      return _toTypeNameRef((ClassRef)typeRef, currNs);
    } else if (typeRef instanceof org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef) {
      return _toTypeNameRef((org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef)typeRef, currNs);
    } else if (typeRef instanceof TypeRef) {
      return _toTypeNameRef((TypeRef)typeRef, currNs);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(typeRef, currNs).toString());
    }
  }
  
  public String toNsPrefixedTypeNameRef(final TypeRef t, final VersionedDomainNamespace currNs) {
    if (t instanceof BusinessObjectRef) {
      return _toNsPrefixedTypeNameRef((BusinessObjectRef)t, currNs);
    } else if (t instanceof EnumTypeRef) {
      return _toNsPrefixedTypeNameRef((EnumTypeRef)t, currNs);
    } else if (t instanceof QueryObjectRef) {
      return _toNsPrefixedTypeNameRef((QueryObjectRef)t, currNs);
    } else if (t instanceof VersionedTypeRef) {
      return _toNsPrefixedTypeNameRef((VersionedTypeRef)t, currNs);
    } else if (t instanceof DataTypeRef) {
      return _toNsPrefixedTypeNameRef((DataTypeRef)t, currNs);
    } else if (t != null) {
      return _toNsPrefixedTypeNameRef(t, currNs);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t, currNs).toString());
    }
  }
  
  public String toNsPrefixedTypeNameRef(final EObject t) {
    if (t instanceof DataType) {
      return _toNsPrefixedTypeNameRef((DataType)t);
    } else if (t instanceof org.fornax.soa.serviceDsl.Type) {
      return _toNsPrefixedTypeNameRef((org.fornax.soa.serviceDsl.Type)t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t).toString());
    }
  }
  
  public boolean isMimeContent(final TypeRef t) {
    if (t instanceof DataTypeRef) {
      return _isMimeContent((DataTypeRef)t);
    } else if (t != null) {
      return _isMimeContent(t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t).toString());
    }
  }
  
  public boolean isMimeContentMultiPartAttachment(final TypeRef t) {
    if (t instanceof DataTypeRef) {
      return _isMimeContentMultiPartAttachment((DataTypeRef)t);
    } else if (t != null) {
      return _isMimeContentMultiPartAttachment(t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t).toString());
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
