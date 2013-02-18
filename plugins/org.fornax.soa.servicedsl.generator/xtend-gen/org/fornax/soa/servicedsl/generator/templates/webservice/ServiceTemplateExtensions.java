package org.fornax.soa.servicedsl.generator.templates.webservice;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.basedsl.version.VersionQualifierExtensions;
import org.fornax.soa.profiledsl.query.namespace.TechnicalNamespaceImportQueries;
import org.fornax.soa.profiledsl.sOAProfileDsl.DesignRules;
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader;
import org.fornax.soa.profiledsl.sOAProfileDsl.OperationDefPolicy;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.profiledsl.sOAProfileDsl.ServiceDefPolicy;
import org.fornax.soa.profiledsl.sOAProfileDsl.ServiceVersionEvolution;
import org.fornax.soa.profiledsl.sOAProfileDsl.TypeDefPolicy;
import org.fornax.soa.profiledsl.sOAProfileDsl.TypeVersionEvolution;
import org.fornax.soa.profiledsl.versioning.VersionedTechnicalNamespace;
import org.fornax.soa.service.query.HeaderFinder;
import org.fornax.soa.serviceDsl.Operation;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaTemplateExtensions;

@SuppressWarnings("all")
public class ServiceTemplateExtensions {
  @Inject
  private VersionQualifierExtensions versionQualifier;
  
  @Inject
  private TechnicalNamespaceImportQueries techNsImportQueries;
  
  @Inject
  private SchemaNamespaceExtensions _schemaNamespaceExtensions;
  
  @Inject
  private SchemaTemplateExtensions _schemaTemplateExtensions;
  
  @Inject
  private HeaderFinder _headerFinder;
  
  protected String _toTargetNamespace(final Object svc) {
    return "";
  }
  
  protected String _toTargetNamespace(final Service svc) {
    String _xblockexpression = null;
    {
      EObject _eContainer = svc.eContainer();
      String _unversionedNamespace = this._schemaNamespaceExtensions.toUnversionedNamespace(_eContainer);
      String _plus = (_unversionedNamespace + "/");
      String _name = svc.getName();
      String _plus_1 = (_plus + _name);
      String _plus_2 = (_plus_1 + "/");
      String _versionPostfix = this.toVersionPostfix(svc);
      String _plus_3 = (_plus_2 + _versionPostfix);
      String tns = (_plus_3 + "/");
      _xblockexpression = (tns);
    }
    return _xblockexpression;
  }
  
  protected String _toWrapperTargetNamespace(final Object svc) {
    return "";
  }
  
  protected String _toWrapperTargetNamespace(final Service svc) {
    EObject _eContainer = svc.eContainer();
    String _unversionedNamespace = this._schemaNamespaceExtensions.toUnversionedNamespace(_eContainer);
    String _plus = (_unversionedNamespace + 
      "/");
    String _name = svc.getName();
    String _plus_1 = (_plus + _name);
    String _plus_2 = (_plus_1 + "Wrapped/");
    String _versionPostfix = this.toVersionPostfix(svc);
    String _plus_3 = (_plus_2 + _versionPostfix);
    String _plus_4 = (_plus_3 + "/wrapper/");
    return _plus_4;
  }
  
  public String toWrapperServiceTargetNamespace(final Service svc) {
    EObject _eContainer = svc.eContainer();
    String _unversionedNamespace = this._schemaNamespaceExtensions.toUnversionedNamespace(_eContainer);
    String _plus = (_unversionedNamespace + 
      "/");
    String _name = svc.getName();
    String _plus_1 = (_plus + _name);
    String _plus_2 = (_plus_1 + "Wrapped/");
    String _versionPostfix = this.toVersionPostfix(svc);
    String _plus_3 = (_plus_2 + _versionPostfix);
    String _plus_4 = (_plus_3 + "/");
    return _plus_4;
  }
  
  public String toVersionPostfix(final Service svc) {
    String _xifexpression = null;
    Version _version = svc.getVersion();
    boolean _notEquals = (!Objects.equal(_version, null));
    if (_notEquals) {
      Version _version_1 = svc.getVersion();
      String _versionPostfix = this.versionQualifier.toVersionPostfix(_version_1);
      _xifexpression = _versionPostfix;
    } else {
      String _defaultVersionPostfix = this.versionQualifier.toDefaultVersionPostfix();
      _xifexpression = _defaultVersionPostfix;
    }
    return _xifexpression;
  }
  
  public String toServiceName(final Service svc) {
    String _name = svc.getName();
    return _name;
  }
  
  public String toBindingName(final Service svc) {
    String _serviceName = this.toServiceName(svc);
    String _plus = (_serviceName + "SOAP");
    return _plus;
  }
  
  public String getWsdlFilename(final Service s) {
    EObject _eContainer = s.eContainer();
    String _fileNameFragment = this._schemaNamespaceExtensions.toFileNameFragment(_eContainer);
    String _plus = (_fileNameFragment + "-v");
    Version _version = s.getVersion();
    String _majorVersionNumber = this.versionQualifier.toMajorVersionNumber(_version);
    String _plus_1 = (_plus + _majorVersionNumber);
    String _plus_2 = (_plus_1 + ".wsdl");
    return _plus_2;
  }
  
  public boolean operationsUseExtendableParameters(final SOAProfile p) {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _and_2 = false;
    DesignRules _designRules = p.getDesignRules();
    boolean _notEquals = (!Objects.equal(_designRules, null));
    if (!_notEquals) {
      _and_2 = false;
    } else {
      DesignRules _designRules_1 = p.getDesignRules();
      ServiceDefPolicy _serviceDefPolicy = _designRules_1.getServiceDefPolicy();
      boolean _notEquals_1 = (!Objects.equal(_serviceDefPolicy, null));
      _and_2 = (_notEquals && _notEquals_1);
    }
    if (!_and_2) {
      _and_1 = false;
    } else {
      DesignRules _designRules_2 = p.getDesignRules();
      ServiceDefPolicy _serviceDefPolicy_1 = _designRules_2.getServiceDefPolicy();
      OperationDefPolicy _operationRules = _serviceDefPolicy_1.getOperationRules();
      boolean _notEquals_2 = (!Objects.equal(_operationRules, null));
      _and_1 = (_and_2 && _notEquals_2);
    }
    if (!_and_1) {
      _and = false;
    } else {
      DesignRules _designRules_3 = p.getDesignRules();
      ServiceDefPolicy _serviceDefPolicy_2 = _designRules_3.getServiceDefPolicy();
      OperationDefPolicy _operationRules_1 = _serviceDefPolicy_2.getOperationRules();
      ServiceVersionEvolution _versionEvolution = _operationRules_1.getVersionEvolution();
      boolean _notEquals_3 = (!Objects.equal(_versionEvolution, null));
      _and = (_and_1 && _notEquals_3);
    }
    if (_and) {
      DesignRules _designRules_4 = p.getDesignRules();
      ServiceDefPolicy _serviceDefPolicy_3 = _designRules_4.getServiceDefPolicy();
      OperationDefPolicy _operationRules_2 = _serviceDefPolicy_3.getOperationRules();
      ServiceVersionEvolution _versionEvolution_1 = _operationRules_2.getVersionEvolution();
      return _versionEvolution_1.isExtendibleParameters();
    } else {
      return false;
    }
  }
  
  public boolean operationsUseExtendableXMLAttributes(final SOAProfile p) {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _and_2 = false;
    DesignRules _designRules = p.getDesignRules();
    boolean _notEquals = (!Objects.equal(_designRules, null));
    if (!_notEquals) {
      _and_2 = false;
    } else {
      DesignRules _designRules_1 = p.getDesignRules();
      ServiceDefPolicy _serviceDefPolicy = _designRules_1.getServiceDefPolicy();
      boolean _notEquals_1 = (!Objects.equal(_serviceDefPolicy, null));
      _and_2 = (_notEquals && _notEquals_1);
    }
    if (!_and_2) {
      _and_1 = false;
    } else {
      DesignRules _designRules_2 = p.getDesignRules();
      ServiceDefPolicy _serviceDefPolicy_1 = _designRules_2.getServiceDefPolicy();
      OperationDefPolicy _operationRules = _serviceDefPolicy_1.getOperationRules();
      boolean _notEquals_2 = (!Objects.equal(_operationRules, null));
      _and_1 = (_and_2 && _notEquals_2);
    }
    if (!_and_1) {
      _and = false;
    } else {
      DesignRules _designRules_3 = p.getDesignRules();
      ServiceDefPolicy _serviceDefPolicy_2 = _designRules_3.getServiceDefPolicy();
      OperationDefPolicy _operationRules_1 = _serviceDefPolicy_2.getOperationRules();
      ServiceVersionEvolution _versionEvolution = _operationRules_1.getVersionEvolution();
      boolean _notEquals_3 = (!Objects.equal(_versionEvolution, null));
      _and = (_and_1 && _notEquals_3);
    }
    if (_and) {
      DesignRules _designRules_4 = p.getDesignRules();
      ServiceDefPolicy _serviceDefPolicy_3 = _designRules_4.getServiceDefPolicy();
      OperationDefPolicy _operationRules_2 = _serviceDefPolicy_3.getOperationRules();
      ServiceVersionEvolution _versionEvolution_1 = _operationRules_2.getVersionEvolution();
      return _versionEvolution_1.isExtendibleXMLAttributes();
    } else {
      return false;
    }
  }
  
  public String getOperationsExtendibleParametersClause(final SOAProfile p) {
    boolean _operationsUseExtendableParameters = this.operationsUseExtendableParameters(p);
    if (_operationsUseExtendableParameters) {
      DesignRules _designRules = p.getDesignRules();
      TypeDefPolicy _typeDefPolicy = _designRules.getTypeDefPolicy();
      TypeVersionEvolution _versionEvolution = _typeDefPolicy.getVersionEvolution();
      String _extendibleXMLClause = _versionEvolution.getExtendibleXMLClause();
      boolean _notEquals = (!Objects.equal(_extendibleXMLClause, null));
      if (_notEquals) {
        DesignRules _designRules_1 = p.getDesignRules();
        ServiceDefPolicy _serviceDefPolicy = _designRules_1.getServiceDefPolicy();
        OperationDefPolicy _operationRules = _serviceDefPolicy.getOperationRules();
        ServiceVersionEvolution _versionEvolution_1 = _operationRules.getVersionEvolution();
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
  
  public String getOperationsExtendibleXMLAttributesClause(final SOAProfile p) {
    boolean _operationsUseExtendableXMLAttributes = this.operationsUseExtendableXMLAttributes(p);
    if (_operationsUseExtendableXMLAttributes) {
      DesignRules _designRules = p.getDesignRules();
      ServiceDefPolicy _serviceDefPolicy = _designRules.getServiceDefPolicy();
      OperationDefPolicy _operationRules = _serviceDefPolicy.getOperationRules();
      ServiceVersionEvolution _versionEvolution = _operationRules.getVersionEvolution();
      String _extendibleXMLAttributeClause = _versionEvolution.getExtendibleXMLAttributeClause();
      boolean _notEquals = (!Objects.equal(_extendibleXMLAttributeClause, null));
      if (_notEquals) {
        DesignRules _designRules_1 = p.getDesignRules();
        ServiceDefPolicy _serviceDefPolicy_1 = _designRules_1.getServiceDefPolicy();
        OperationDefPolicy _operationRules_1 = _serviceDefPolicy_1.getOperationRules();
        ServiceVersionEvolution _versionEvolution_1 = _operationRules_1.getVersionEvolution();
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
  
  public String toOperationWrapperRequestType(final Operation op) {
    String _name = op.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    return _firstUpper;
  }
  
  public String toOperationWrapperResponseType(final Operation op) {
    String _name = op.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    String _plus = (_firstUpper + "Response");
    return _plus;
  }
  
  public String getWrappedWSDLFileName(final Service s) {
    String _fileNameFragment = this._schemaNamespaceExtensions.toFileNameFragment(s);
    String _plus = (_fileNameFragment + "Wrapped.wsdl");
    return _plus;
  }
  
  public String getWrappedFileNameFragment(final Service s) {
    String _fileNameFragment = this._schemaNamespaceExtensions.toFileNameFragment(s);
    String _plus = (_fileNameFragment + "-Wrapped");
    return _plus;
  }
  
  public String getRegisteredOperationWrapperUrl(final Service s, final String registryUrl) {
    String _xifexpression = null;
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(registryUrl, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _forceRelativePaths = this._schemaNamespaceExtensions.forceRelativePaths();
      boolean _not = (!_forceRelativePaths);
      _and = (_notEquals && _not);
    }
    if (_and) {
      String _plus = (registryUrl + "/");
      String _opWrapperXSDFileName = this._schemaTemplateExtensions.toOpWrapperXSDFileName(s);
      String _plus_1 = (_plus + _opWrapperXSDFileName);
      _xifexpression = _plus_1;
    } else {
      String _opWrapperXSDFileName_1 = this._schemaTemplateExtensions.toOpWrapperXSDFileName(s);
      _xifexpression = _opWrapperXSDFileName_1;
    }
    return _xifexpression;
  }
  
  public Set<VersionedTechnicalNamespace> collectTechnicalVersionedNamespaceImports(final Service service, final SOAProfile profile) {
    final Set<VersionedTechnicalNamespace> headerImports = CollectionLiterals.<VersionedTechnicalNamespace>newHashSet();
    MessageHeader _findBestMatchingRequestHeader = this._headerFinder.findBestMatchingRequestHeader(service, profile);
    boolean _notEquals = (!Objects.equal(_findBestMatchingRequestHeader, null));
    if (_notEquals) {
      MessageHeader _findBestMatchingRequestHeader_1 = this._headerFinder.findBestMatchingRequestHeader(service, profile);
      Version _version = service.getVersion();
      String _majorVersionNumber = this.versionQualifier.toMajorVersionNumber(_version);
      Set<VersionedTechnicalNamespace> _allImportedVersionedNS = this.techNsImportQueries.allImportedVersionedNS(_findBestMatchingRequestHeader_1, _majorVersionNumber);
      for (final VersionedTechnicalNamespace headerImp : _allImportedVersionedNS) {
        headerImports.add(headerImp);
      }
    }
    MessageHeader _findBestMatchingResponseHeader = this._headerFinder.findBestMatchingResponseHeader(service, profile);
    boolean _notEquals_1 = (!Objects.equal(_findBestMatchingResponseHeader, null));
    if (_notEquals_1) {
      MessageHeader _findBestMatchingResponseHeader_1 = this._headerFinder.findBestMatchingResponseHeader(service, profile);
      Version _version_1 = service.getVersion();
      String _majorVersionNumber_1 = this.versionQualifier.toMajorVersionNumber(_version_1);
      Set<VersionedTechnicalNamespace> _allImportedVersionedNS_1 = this.techNsImportQueries.allImportedVersionedNS(_findBestMatchingResponseHeader_1, _majorVersionNumber_1);
      for (final VersionedTechnicalNamespace headerImp_1 : _allImportedVersionedNS_1) {
        headerImports.add(headerImp_1);
      }
    }
    return headerImports;
  }
  
  public String toTargetNamespace(final Object svc) {
    if (svc instanceof Service) {
      return _toTargetNamespace((Service)svc);
    } else if (svc != null) {
      return _toTargetNamespace(svc);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(svc).toString());
    }
  }
  
  public String toWrapperTargetNamespace(final Object svc) {
    if (svc instanceof Service) {
      return _toWrapperTargetNamespace((Service)svc);
    } else if (svc != null) {
      return _toWrapperTargetNamespace(svc);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(svc).toString());
    }
  }
}
