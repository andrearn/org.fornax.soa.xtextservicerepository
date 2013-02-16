package org.fornax.soa.profiledsl.generator.schema;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.version.VersionQualifierExtensions;
import org.fornax.soa.profiledsl.generator.schema.ProfileSchemaNamespaceExtensions;
import org.fornax.soa.profiledsl.query.ProfileVersionQueries;
import org.fornax.soa.profiledsl.query.namespace.TechnicalNamespaceQueries;
import org.fornax.soa.profiledsl.query.type.LatestMatchingTypeFinder;
import org.fornax.soa.profiledsl.sOAProfileDsl.AttributeDataTypeRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.DataType;
import org.fornax.soa.profiledsl.sOAProfileDsl.DataTypeRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader;
import org.fornax.soa.profiledsl.sOAProfileDsl.TechnicalNamespace;
import org.fornax.soa.profiledsl.sOAProfileDsl.Type;
import org.fornax.soa.profiledsl.sOAProfileDsl.TypeRef;
import org.fornax.soa.profiledsl.sOAProfileDsl.TypeVersionEvolution;
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedType;
import org.fornax.soa.profiledsl.sOAProfileDsl.VersionedTypeRef;
import org.fornax.soa.profiledsl.versioning.TechnicalNamespaceSplitter;
import org.fornax.soa.profiledsl.versioning.VersionedTechnicalNamespace;

@SuppressWarnings("all")
public class ProfileSchemaTypeExtensions {
  @Inject
  private TechnicalNamespaceSplitter _technicalNamespaceSplitter;
  
  @Inject
  private TechnicalNamespaceQueries _technicalNamespaceQueries;
  
  @Inject
  private ProfileSchemaNamespaceExtensions _profileSchemaNamespaceExtensions;
  
  @Inject
  private ProfileVersionQueries profileVersionQueries;
  
  @Inject
  private LatestMatchingTypeFinder _latestMatchingTypeFinder;
  
  @Inject
  private VersionQualifierExtensions versionQualifiers;
  
  protected String _toTypeNameRef(final TypeRef t, final VersionedTechnicalNamespace currNs) {
    return null;
  }
  
  protected String _toTypeNameRef(final DataTypeRef t, final VersionedTechnicalNamespace currentDomNs) {
    Type _findLatestMatchingType = this._latestMatchingTypeFinder.findLatestMatchingType(t);
    String _typeNameRef = this.toTypeNameRef(_findLatestMatchingType, currentDomNs);
    return _typeNameRef;
  }
  
  protected String _toTypeNameRef(final DataType t, final VersionedTechnicalNamespace currentDomNs) {
    String _typeNameRef = this.toTypeNameRef(t);
    return _typeNameRef;
  }
  
  protected String _toTypeNameRef(final AttributeDataTypeRef t, final VersionedTechnicalNamespace currentDomNs) {
    Type _findLatestMatchingType = this._latestMatchingTypeFinder.findLatestMatchingType(t);
    String _typeNameRef = this.toTypeNameRef(_findLatestMatchingType, currentDomNs);
    return _typeNameRef;
  }
  
  /**
   * <b>TODO CHECK</b> getOwnerVersion for VersionedTypeRef!!!
   */
  protected String _toTypeNameRef(final VersionedTypeRef t, final VersionedTechnicalNamespace currNs) {
    String _xifexpression = null;
    boolean _and = false;
    VersionedType _type = t.getType();
    TechnicalNamespace _findTechnicalNamespace = this._technicalNamespaceQueries.findTechnicalNamespace(_type);
    String _unversionedNamespace = this._profileSchemaNamespaceExtensions.toUnversionedNamespace(_findTechnicalNamespace);
    TechnicalNamespace _namespace = currNs.getNamespace();
    String _unversionedNamespace_1 = this._profileSchemaNamespaceExtensions.toUnversionedNamespace(((TechnicalNamespace) _namespace));
    boolean _equals = Objects.equal(_unversionedNamespace, _unversionedNamespace_1);
    if (!_equals) {
      _and = false;
    } else {
      Version _ownerVersion = this.profileVersionQueries.getOwnerVersion(t);
      String _majorVersionNumber = this.versionQualifiers.toMajorVersionNumber(_ownerVersion);
      VersionedType _type_1 = t.getType();
      Version _version = _type_1.getVersion();
      String _majorVersionNumber_1 = this.versionQualifiers.toMajorVersionNumber(_version);
      boolean _equals_1 = Objects.equal(_majorVersionNumber, _majorVersionNumber_1);
      _and = (_equals && _equals_1);
    }
    if (_and) {
      VersionedType _type_2 = t.getType();
      String _name = _type_2.getName();
      String _plus = ("tns:" + _name);
      _xifexpression = _plus;
    } else {
      VersionedType _type_3 = t.getType();
      TechnicalNamespace _findTechnicalNamespace_1 = this._technicalNamespaceQueries.findTechnicalNamespace(_type_3);
      String _shortName = this._profileSchemaNamespaceExtensions.toShortName(_findTechnicalNamespace_1);
      VersionedType _type_4 = t.getType();
      Version _version_1 = _type_4.getVersion();
      String _majorVersionNumber_2 = this.versionQualifiers.toMajorVersionNumber(_version_1);
      String _plus_1 = (_shortName + _majorVersionNumber_2);
      String _plus_2 = (_plus_1 + ":");
      VersionedType _type_5 = t.getType();
      String _name_1 = _type_5.getName();
      String _plus_3 = (_plus_2 + _name_1);
      _xifexpression = _plus_3;
    }
    return _xifexpression;
  }
  
  protected String _toTypeNameRef(final DataType t) {
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
  
  protected String _toFullTypeNameRef(final DataTypeRef t, final VersionedTechnicalNamespace currentDomNs) {
    Type _findLatestMatchingType = this._latestMatchingTypeFinder.findLatestMatchingType(t);
    String _fullTypeNameRef = this.toFullTypeNameRef(_findLatestMatchingType);
    return _fullTypeNameRef;
  }
  
  protected String _toFullTypeNameRef(final VersionedTypeRef t, final VersionedTechnicalNamespace currNs) {
    VersionedType _type = t.getType();
    TechnicalNamespace _findTechnicalNamespace = this._technicalNamespaceQueries.findTechnicalNamespace(_type);
    String _namespace = this._profileSchemaNamespaceExtensions.toNamespace(_findTechnicalNamespace);
    VersionedType _type_1 = t.getType();
    String _name = _type_1.getName();
    String _plus = (_namespace + _name);
    return _plus;
  }
  
  protected String _toFullTypeNameRef(final Type t) {
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
  
  protected boolean _isMany(final TypeRef t) {
    return false;
  }
  
  protected boolean _isMany(final DataTypeRef t) {
    return false;
  }
  
  protected boolean _isMany(final VersionedTypeRef t) {
    boolean _isMany = t.isMany();
    return _isMany;
  }
  
  public boolean typesUseExtendibleProperties(final MessageHeader header) {
    TypeVersionEvolution _versionEvolution = header.getVersionEvolution();
    boolean _notEquals = (!Objects.equal(_versionEvolution, null));
    if (_notEquals) {
      TypeVersionEvolution _versionEvolution_1 = header.getVersionEvolution();
      return _versionEvolution_1.isExtendibleProperties();
    } else {
      return false;
    }
  }
  
  public boolean typesUseExtendibleXMLAttributes(final MessageHeader header) {
    TypeVersionEvolution _versionEvolution = header.getVersionEvolution();
    boolean _notEquals = (!Objects.equal(_versionEvolution, null));
    if (_notEquals) {
      TypeVersionEvolution _versionEvolution_1 = header.getVersionEvolution();
      return _versionEvolution_1.isExtendibleXMLAttributes();
    } else {
      return false;
    }
  }
  
  public String getTypesExtendiblePropertiesClause(final MessageHeader header) {
    boolean _typesUseExtendibleProperties = this.typesUseExtendibleProperties(header);
    if (_typesUseExtendibleProperties) {
      TypeVersionEvolution _versionEvolution = header.getVersionEvolution();
      String _extendibleXMLClause = _versionEvolution.getExtendibleXMLClause();
      boolean _notEquals = (!Objects.equal(_extendibleXMLClause, null));
      if (_notEquals) {
        TypeVersionEvolution _versionEvolution_1 = header.getVersionEvolution();
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
  
  public String getTypesExtendibleXMLAttributesClause(final MessageHeader header) {
    boolean _typesUseExtendibleXMLAttributes = this.typesUseExtendibleXMLAttributes(header);
    if (_typesUseExtendibleXMLAttributes) {
      TypeVersionEvolution _versionEvolution = header.getVersionEvolution();
      String _extendibleXMLAttributeClause = _versionEvolution.getExtendibleXMLAttributeClause();
      boolean _notEquals = (!Objects.equal(_extendibleXMLAttributeClause, null));
      if (_notEquals) {
        TypeVersionEvolution _versionEvolution_1 = header.getVersionEvolution();
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
  
  public String toTypeNameRef(final EObject t, final VersionedTechnicalNamespace currentDomNs) {
    if (t instanceof DataType) {
      return _toTypeNameRef((DataType)t, currentDomNs);
    } else if (t instanceof DataTypeRef) {
      return _toTypeNameRef((DataTypeRef)t, currentDomNs);
    } else if (t instanceof VersionedTypeRef) {
      return _toTypeNameRef((VersionedTypeRef)t, currentDomNs);
    } else if (t instanceof AttributeDataTypeRef) {
      return _toTypeNameRef((AttributeDataTypeRef)t, currentDomNs);
    } else if (t instanceof TypeRef) {
      return _toTypeNameRef((TypeRef)t, currentDomNs);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t, currentDomNs).toString());
    }
  }
  
  public String toTypeNameRef(final DataType t) {
    {
      return _toTypeNameRef(t);
    }
  }
  
  public String toFullTypeNameRef(final TypeRef t, final VersionedTechnicalNamespace currentDomNs) {
    if (t instanceof DataTypeRef) {
      return _toFullTypeNameRef((DataTypeRef)t, currentDomNs);
    } else if (t instanceof VersionedTypeRef) {
      return _toFullTypeNameRef((VersionedTypeRef)t, currentDomNs);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t, currentDomNs).toString());
    }
  }
  
  public String toFullTypeNameRef(final Type t) {
    if (t instanceof DataType) {
      return _toFullTypeNameRef((DataType)t);
    } else if (t != null) {
      return _toFullTypeNameRef(t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t).toString());
    }
  }
  
  public boolean isMany(final TypeRef t) {
    if (t instanceof DataTypeRef) {
      return _isMany((DataTypeRef)t);
    } else if (t instanceof VersionedTypeRef) {
      return _isMany((VersionedTypeRef)t);
    } else if (t != null) {
      return _isMany(t);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(t).toString());
    }
  }
}
