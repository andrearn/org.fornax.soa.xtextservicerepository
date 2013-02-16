package org.fornax.soa.bindingdsl.generator.templates.vendor.ibm;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.bindingDsl.BindingProtocol;
import org.fornax.soa.bindingDsl.SCA;
import org.fornax.soa.bindingDsl.SOAP;
import org.fornax.soa.bindingdsl.generator.templates.naming.DefaultEndpointQualifierNameProvider;
import org.fornax.soa.service.query.namespace.NamespaceQuery;
import org.fornax.soa.serviceDsl.OrganizationNamespace;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions;

@SuppressWarnings("all")
public class SCAExportExtension {
  @Inject
  private SchemaNamespaceExtensions _schemaNamespaceExtensions;
  
  @Inject
  private NamespaceQuery _namespaceQuery;
  
  @Inject
  private DefaultEndpointQualifierNameProvider _defaultEndpointQualifierNameProvider;
  
  protected String _getExportName(final Service s, final BindingProtocol prot) {
    OrganizationNamespace _findOrgNamespace = this._namespaceQuery.findOrgNamespace(s);
    String _prefix = this._schemaNamespaceExtensions.toPrefix(_findOrgNamespace);
    String _plus = (_prefix + "_");
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(s);
    String _name = _findSubdomain.getName();
    String _replaceAll = _name.replaceAll("\\.", "_");
    String _plus_1 = (_plus + _replaceAll);
    String _plus_2 = (_plus_1 + "_");
    String _name_1 = s.getName();
    String _plus_3 = (_plus_2 + _name_1);
    String _serviceVisibilityName = this._defaultEndpointQualifierNameProvider.getServiceVisibilityName(s);
    String _plus_4 = (_plus_3 + _serviceVisibilityName);
    String _plus_5 = (_plus_4 + "_");
    Version _version = s.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_6 = (_plus_5 + _versionPostfix);
    return _plus_6;
  }
  
  protected String _getExportName(final Service s, final SOAP prot) {
    OrganizationNamespace _findOrgNamespace = this._namespaceQuery.findOrgNamespace(s);
    String _prefix = this._schemaNamespaceExtensions.toPrefix(_findOrgNamespace);
    String _plus = (_prefix + "_");
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(s);
    String _name = _findSubdomain.getName();
    String _replaceAll = _name.replaceAll("\\.", "_");
    String _plus_1 = (_plus + _replaceAll);
    String _plus_2 = (_plus_1 + "_");
    String _name_1 = s.getName();
    String _plus_3 = (_plus_2 + _name_1);
    String _plus_4 = (_plus_3 + "SOAP");
    String _serviceVisibilityName = this._defaultEndpointQualifierNameProvider.getServiceVisibilityName(s);
    String _plus_5 = (_plus_4 + _serviceVisibilityName);
    String _plus_6 = (_plus_5 + "_");
    Version _version = s.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_7 = (_plus_6 + _versionPostfix);
    return _plus_7;
  }
  
  protected String _getExportName(final Service s, final SCA prot) {
    String _xifexpression = null;
    String _promote = prot.getPromote();
    boolean _notEquals = (!Objects.equal(_promote, null));
    if (_notEquals) {
      String _promote_1 = prot.getPromote();
      _xifexpression = _promote_1;
    } else {
      OrganizationNamespace _findOrgNamespace = this._namespaceQuery.findOrgNamespace(s);
      String _prefix = this._schemaNamespaceExtensions.toPrefix(_findOrgNamespace);
      String _plus = (_prefix + "_");
      SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(s);
      String _name = _findSubdomain.getName();
      String _replaceAll = _name.replaceAll("\\.", "_");
      String _plus_1 = (_plus + _replaceAll);
      String _plus_2 = (_plus_1 + "_");
      String _name_1 = s.getName();
      String _plus_3 = (_plus_2 + _name_1);
      String _plus_4 = (_plus_3 + "SCA");
      String _serviceVisibilityName = this._defaultEndpointQualifierNameProvider.getServiceVisibilityName(s);
      String _plus_5 = (_plus_4 + _serviceVisibilityName);
      String _plus_6 = (_plus_5 + "_");
      Version _version = s.getVersion();
      String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
      String _plus_7 = (_plus_6 + _versionPostfix);
      _xifexpression = _plus_7;
    }
    return _xifexpression;
  }
  
  protected String _getExportDisplayName(final Service s, final BindingProtocol prot) {
    OrganizationNamespace _findOrgNamespace = this._namespaceQuery.findOrgNamespace(s);
    String _prefix = this._schemaNamespaceExtensions.toPrefix(_findOrgNamespace);
    String _plus = (_prefix + ".");
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(s);
    String _name = _findSubdomain.getName();
    String _replaceAll = _name.replaceAll("\\.", ".");
    String _plus_1 = (_plus + _replaceAll);
    String _plus_2 = (_plus_1 + ".");
    String _name_1 = s.getName();
    String _plus_3 = (_plus_2 + _name_1);
    String _serviceVisibilityName = this._defaultEndpointQualifierNameProvider.getServiceVisibilityName(s);
    String _plus_4 = (_plus_3 + _serviceVisibilityName);
    String _plus_5 = (_plus_4 + ".");
    Version _version = s.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_6 = (_plus_5 + _versionPostfix);
    return _plus_6;
  }
  
  protected String _getExportDisplayName(final Service s, final SOAP prot) {
    OrganizationNamespace _findOrgNamespace = this._namespaceQuery.findOrgNamespace(s);
    String _prefix = this._schemaNamespaceExtensions.toPrefix(_findOrgNamespace);
    String _plus = (_prefix + ".");
    SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(s);
    String _name = _findSubdomain.getName();
    String _replaceAll = _name.replaceAll("\\.", ".");
    String _plus_1 = (_plus + _replaceAll);
    String _plus_2 = (_plus_1 + ".");
    String _name_1 = s.getName();
    String _plus_3 = (_plus_2 + _name_1);
    String _plus_4 = (_plus_3 + "SOAP");
    String _serviceVisibilityName = this._defaultEndpointQualifierNameProvider.getServiceVisibilityName(s);
    String _plus_5 = (_plus_4 + _serviceVisibilityName);
    String _plus_6 = (_plus_5 + ".");
    Version _version = s.getVersion();
    String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
    String _plus_7 = (_plus_6 + _versionPostfix);
    return _plus_7;
  }
  
  protected String _getExportDisplayName(final Service s, final SCA prot) {
    String _xifexpression = null;
    String _promote = prot.getPromote();
    boolean _notEquals = (!Objects.equal(_promote, null));
    if (_notEquals) {
      String _promote_1 = prot.getPromote();
      _xifexpression = _promote_1;
    } else {
      OrganizationNamespace _findOrgNamespace = this._namespaceQuery.findOrgNamespace(s);
      String _prefix = this._schemaNamespaceExtensions.toPrefix(_findOrgNamespace);
      String _plus = (_prefix + ".");
      SubNamespace _findSubdomain = this._namespaceQuery.findSubdomain(s);
      String _name = _findSubdomain.getName();
      String _replaceAll = _name.replaceAll("\\.", ".");
      String _plus_1 = (_plus + _replaceAll);
      String _plus_2 = (_plus_1 + ".");
      String _name_1 = s.getName();
      String _plus_3 = (_plus_2 + _name_1);
      String _plus_4 = (_plus_3 + "SCA");
      String _serviceVisibilityName = this._defaultEndpointQualifierNameProvider.getServiceVisibilityName(s);
      String _plus_5 = (_plus_4 + _serviceVisibilityName);
      String _plus_6 = (_plus_5 + ".");
      Version _version = s.getVersion();
      String _versionPostfix = this._schemaNamespaceExtensions.toVersionPostfix(_version);
      String _plus_7 = (_plus_6 + _versionPostfix);
      _xifexpression = _plus_7;
    }
    return _xifexpression;
  }
  
  public String getExportFileName(final Service s, final BindingProtocol prot) {
    String _exportName = this.getExportName(s, prot);
    String _plus = (_exportName + ".export");
    return _plus;
  }
  
  public String getExportName(final Service s, final BindingProtocol prot) {
    if (prot instanceof SCA) {
      return _getExportName(s, (SCA)prot);
    } else if (prot instanceof SOAP) {
      return _getExportName(s, (SOAP)prot);
    } else if (prot != null) {
      return _getExportName(s, prot);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s, prot).toString());
    }
  }
  
  public String getExportDisplayName(final Service s, final BindingProtocol prot) {
    if (prot instanceof SCA) {
      return _getExportDisplayName(s, (SCA)prot);
    } else if (prot instanceof SOAP) {
      return _getExportDisplayName(s, (SOAP)prot);
    } else if (prot != null) {
      return _getExportDisplayName(s, prot);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s, prot).toString());
    }
  }
}
