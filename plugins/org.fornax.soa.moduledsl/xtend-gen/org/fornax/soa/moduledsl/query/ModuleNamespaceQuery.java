package org.fornax.soa.moduledsl.query;

import com.google.inject.Inject;
import java.util.Arrays;
import org.fornax.soa.moduledsl.moduleDsl.AbstractServiceRef;
import org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef;
import org.fornax.soa.moduledsl.moduleDsl.ServiceRef;
import org.fornax.soa.service.query.namespace.NamespaceQuery;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.SubNamespace;

@SuppressWarnings("all")
public class ModuleNamespaceQuery {
  @Inject
  private NamespaceQuery nsQuery;
  
  protected SubNamespace _findSubdomain(final ServiceRef s) {
    Service _service = s.getService();
    SubNamespace _findSubdomain = this.nsQuery.findSubdomain(_service);
    return _findSubdomain;
  }
  
  protected SubNamespace _findSubdomain(final ImportServiceRef s) {
    Service _service = s.getService();
    SubNamespace _findSubdomain = this.nsQuery.findSubdomain(_service);
    return _findSubdomain;
  }
  
  public SubNamespace findSubdomain(final AbstractServiceRef s) {
    if (s instanceof ImportServiceRef) {
      return _findSubdomain((ImportServiceRef)s);
    } else if (s instanceof ServiceRef) {
      return _findSubdomain((ServiceRef)s);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s).toString());
    }
  }
}
