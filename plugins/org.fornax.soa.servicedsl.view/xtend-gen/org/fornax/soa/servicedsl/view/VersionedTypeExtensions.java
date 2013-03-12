package org.fornax.soa.servicedsl.view;

import com.google.common.base.Objects;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.serviceDsl.OrganizationNamespace;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.serviceDsl.VersionedType;

@SuppressWarnings("all")
public class VersionedTypeExtensions {
  protected String _toNamespaceName(final EObject o) {
    return "";
  }
  
  protected String _toNamespaceName(final VersionedType type) {
    EObject _eContainer = type.eContainer();
    String _namespaceName = this.toNamespaceName(_eContainer);
    return _namespaceName;
  }
  
  protected String _toNamespaceName(final OrganizationNamespace ns) {
    String _xifexpression = null;
    String _prefix = ns.getPrefix();
    boolean _notEquals = (!Objects.equal(_prefix, null));
    if (_notEquals) {
      String _prefix_1 = ns.getPrefix();
      _xifexpression = _prefix_1;
    } else {
      String _name = ns.getName();
      _xifexpression = _name;
    }
    return _xifexpression;
  }
  
  protected String _toNamespaceName(final SubNamespace ns) {
    String _xifexpression = null;
    EObject _eContainer = ns.eContainer();
    boolean _notEquals = (!Objects.equal(_eContainer, null));
    if (_notEquals) {
      EObject _eContainer_1 = ns.eContainer();
      String _namespaceName = this.toNamespaceName(_eContainer_1);
      String _plus = (_namespaceName + ".");
      String _name = ns.getName();
      String _plus_1 = (_plus + _name);
      _xifexpression = _plus_1;
    } else {
      String _name_1 = ns.getName();
      _xifexpression = _name_1;
    }
    return _xifexpression;
  }
  
  public String toNamespaceName(final EObject type) {
    if (type instanceof VersionedType) {
      return _toNamespaceName((VersionedType)type);
    } else if (type instanceof OrganizationNamespace) {
      return _toNamespaceName((OrganizationNamespace)type);
    } else if (type instanceof SubNamespace) {
      return _toNamespaceName((SubNamespace)type);
    } else if (type != null) {
      return _toNamespaceName(type);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(type).toString());
    }
  }
}
