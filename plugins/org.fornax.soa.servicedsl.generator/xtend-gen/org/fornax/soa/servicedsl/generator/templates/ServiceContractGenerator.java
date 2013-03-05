package org.fornax.soa.servicedsl.generator.templates;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.fornax.soa.basedsl.CommonStringExtensions;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.service.VersionedDomainNamespace;
import org.fornax.soa.service.namespace.NamespaceSplitter;
import org.fornax.soa.service.query.ServiceQueries;
import org.fornax.soa.service.versioning.IServiceResolver;
import org.fornax.soa.serviceDsl.DomainNamespace;
import org.fornax.soa.serviceDsl.InternalNamespace;
import org.fornax.soa.serviceDsl.OrganizationNamespace;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.servicedsl.generator.templates.webservice.WSDLGenerator;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions;
import org.fornax.soa.servicedsl.generator.templates.xsd.XSDGenerator;

@SuppressWarnings("all")
public class ServiceContractGenerator {
  @Inject
  private CommonStringExtensions _commonStringExtensions;
  
  @Inject
  private NamespaceSplitter _namespaceSplitter;
  
  @Inject
  private SchemaNamespaceExtensions _schemaNamespaceExtensions;
  
  @Inject
  private ServiceQueries _serviceQueries;
  
  @Inject
  private IServiceResolver _iServiceResolver;
  
  @Inject
  private WSDLGenerator _wSDLGenerator;
  
  @Inject
  private XSDGenerator _xSDGenerator;
  
  @Inject
  @Named(value = "noDependencies")
  private Boolean noDependencies;
  
  public void toOrganizationNamespace(final OrganizationNamespace orgNs, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    EList<SubNamespace> _subNamespaces = orgNs.getSubNamespaces();
    final Procedure1<SubNamespace> _function = new Procedure1<SubNamespace>() {
        public void apply(final SubNamespace n) {
          ServiceContractGenerator.this.toSubNamespace(n, minState, profile, registryBaseUrl);
        }
      };
    IterableExtensions.<SubNamespace>forEach(_subNamespaces, _function);
  }
  
  protected void _toSubNamespace(final SubNamespace ns, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
  }
  
  protected void _toSubNamespace(final DomainNamespace ns, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    EList<InternalNamespace> _interalNamespaces = ns.getInteralNamespaces();
    final Procedure1<InternalNamespace> _function = new Procedure1<InternalNamespace>() {
        public void apply(final InternalNamespace n) {
          ServiceContractGenerator.this.toSubNamespace(n, minState, profile, registryBaseUrl);
        }
      };
    IterableExtensions.<InternalNamespace>forEach(_interalNamespaces, _function);
    final Set<VersionedDomainNamespace> verNs = this._namespaceSplitter.splitNamespaceByMajorVersion(ns);
    final Procedure1<VersionedDomainNamespace> _function_1 = new Procedure1<VersionedDomainNamespace>() {
        public void apply(final VersionedDomainNamespace v) {
          List _servicesWithMinState = ServiceContractGenerator.this._serviceQueries.servicesWithMinState(v, minState);
          Iterable<Service> _filter = Iterables.<Service>filter(_servicesWithMinState, Service.class);
          final Function1<Service,Boolean> _function = new Function1<Service,Boolean>() {
              public Boolean apply(final Service e) {
                String _version = v.getVersion();
                Integer _asInteger = ServiceContractGenerator.this._commonStringExtensions.asInteger(_version);
                boolean _isMatchingService = ServiceContractGenerator.this._iServiceResolver.isMatchingService(e, (_asInteger).intValue(), minState);
                return Boolean.valueOf(_isMatchingService);
              }
            };
          Iterable<Service> _filter_1 = IterableExtensions.<Service>filter(_filter, _function);
          final Function1<Service,Boolean> _function_1 = new Function1<Service,Boolean>() {
              public Boolean apply(final Service e) {
                String _providedContractUrl = e.getProvidedContractUrl();
                boolean _equals = Objects.equal(_providedContractUrl, null);
                return Boolean.valueOf(_equals);
              }
            };
          Iterable<Service> _filter_2 = IterableExtensions.<Service>filter(_filter_1, _function_1);
          final Procedure1<Service> _function_2 = new Procedure1<Service>() {
              public void apply(final Service s) {
                ServiceContractGenerator.this.toService(s, ns, minState, profile, registryBaseUrl);
              }
            };
          IterableExtensions.<Service>forEach(_filter_2, _function_2);
        }
      };
    IterableExtensions.<VersionedDomainNamespace>forEach(verNs, _function_1);
    boolean _not = (!this.noDependencies);
    if (_not) {
      this.toBusinessObject(ns, minState, profile, registryBaseUrl);
    }
  }
  
  protected void _toSubNamespace(final InternalNamespace ns, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    final Set<VersionedDomainNamespace> verNs = this._namespaceSplitter.splitNamespaceByMajorVersion(ns);
    final Procedure1<VersionedDomainNamespace> _function = new Procedure1<VersionedDomainNamespace>() {
        public void apply(final VersionedDomainNamespace v) {
          List _servicesWithMinState = ServiceContractGenerator.this._serviceQueries.servicesWithMinState(v, minState);
          Iterable<Service> _filter = Iterables.<Service>filter(_servicesWithMinState, Service.class);
          final Function1<Service,Boolean> _function = new Function1<Service,Boolean>() {
              public Boolean apply(final Service e) {
                String _version = v.getVersion();
                Integer _asInteger = ServiceContractGenerator.this._commonStringExtensions.asInteger(_version);
                boolean _isMatchingService = ServiceContractGenerator.this._iServiceResolver.isMatchingService(e, (_asInteger).intValue(), minState);
                return Boolean.valueOf(_isMatchingService);
              }
            };
          Iterable<Service> _filter_1 = IterableExtensions.<Service>filter(_filter, _function);
          final Function1<Service,Boolean> _function_1 = new Function1<Service,Boolean>() {
              public Boolean apply(final Service e) {
                String _providedContractUrl = e.getProvidedContractUrl();
                boolean _equals = Objects.equal(_providedContractUrl, null);
                return Boolean.valueOf(_equals);
              }
            };
          Iterable<Service> _filter_2 = IterableExtensions.<Service>filter(_filter_1, _function_1);
          final Procedure1<Service> _function_2 = new Procedure1<Service>() {
              public void apply(final Service s) {
                ServiceContractGenerator.this.toService(s, ns, minState, profile, registryBaseUrl);
              }
            };
          IterableExtensions.<Service>forEach(_filter_2, _function_2);
        }
      };
    IterableExtensions.<VersionedDomainNamespace>forEach(verNs, _function);
    boolean _not = (!this.noDependencies);
    if (_not) {
      this.toBusinessObject(ns, minState, profile, registryBaseUrl);
    }
  }
  
  protected void _toService(final Service s, final DomainNamespace subDom, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    this._wSDLGenerator.toWSDL(s, subDom, minState, profile, registryBaseUrl);
  }
  
  protected void _toService(final Service s, final InternalNamespace subDom, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    this._wSDLGenerator.toWSDL(s, subDom, minState, profile, registryBaseUrl);
  }
  
  protected void _toBusinessObject(final DomainNamespace ns, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    this._xSDGenerator.toXSD(ns, minState, profile, registryBaseUrl);
  }
  
  protected void _toBusinessObject(final InternalNamespace ns, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    this._xSDGenerator.toXSD(ns, minState, profile, registryBaseUrl);
  }
  
  public void toSubNamespace(final SubNamespace ns, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    if (ns instanceof DomainNamespace) {
      _toSubNamespace((DomainNamespace)ns, minState, profile, registryBaseUrl);
      return;
    } else if (ns instanceof InternalNamespace) {
      _toSubNamespace((InternalNamespace)ns, minState, profile, registryBaseUrl);
      return;
    } else if (ns != null) {
      _toSubNamespace(ns, minState, profile, registryBaseUrl);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ns, minState, profile, registryBaseUrl).toString());
    }
  }
  
  public void toService(final Service s, final SubNamespace subDom, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    if (subDom instanceof DomainNamespace) {
      _toService(s, (DomainNamespace)subDom, minState, profile, registryBaseUrl);
      return;
    } else if (subDom instanceof InternalNamespace) {
      _toService(s, (InternalNamespace)subDom, minState, profile, registryBaseUrl);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s, subDom, minState, profile, registryBaseUrl).toString());
    }
  }
  
  public void toBusinessObject(final SubNamespace ns, final LifecycleState minState, final SOAProfile profile, final String registryBaseUrl) {
    if (ns instanceof DomainNamespace) {
      _toBusinessObject((DomainNamespace)ns, minState, profile, registryBaseUrl);
      return;
    } else if (ns instanceof InternalNamespace) {
      _toBusinessObject((InternalNamespace)ns, minState, profile, registryBaseUrl);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ns, minState, profile, registryBaseUrl).toString());
    }
  }
}
