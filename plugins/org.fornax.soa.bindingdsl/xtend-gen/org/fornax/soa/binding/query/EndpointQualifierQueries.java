package org.fornax.soa.binding.query;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.basedsl.search.IEObjectLookup;
import org.fornax.soa.binding.EndpointQualifierDescriptor;
import org.fornax.soa.binding.query.environment.BindingConnectorResolver;
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver;
import org.fornax.soa.bindingDsl.Binding;
import org.fornax.soa.bindingDsl.BindingProtocol;
import org.fornax.soa.bindingDsl.EndpointQualifierRef;
import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.environmentDsl.Connector;
import org.fornax.soa.environmentDsl.EndpointVisibility;
import org.fornax.soa.environmentDsl.Server;
import org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.moduledsl.moduleDsl.ModuleRef;
import org.fornax.soa.moduledsl.moduleDsl.ServiceModuleRef;
import org.fornax.soa.semanticsDsl.Qualifier;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.Visibility;

@SuppressWarnings("all")
public class EndpointQualifierQueries {
  @Inject
  private BindingConnectorResolver connectorResolver;
  
  @Inject
  private EnvironmentBindingResolver envResolver;
  
  @Inject
  private IEObjectLookup objLookup;
  
  protected Qualifier _getEffectiveEndpointQualifier(final EObject o) {
    Qualifier _xifexpression = null;
    EObject _eContainer = o.eContainer();
    boolean _notEquals = (!Objects.equal(_eContainer, null));
    if (_notEquals) {
      EObject _eContainer_1 = o.eContainer();
      Qualifier _effectiveEndpointQualifier = this.getEffectiveEndpointQualifier(_eContainer_1);
      _xifexpression = _effectiveEndpointQualifier;
    } else {
      return null;
    }
    return _xifexpression;
  }
  
  /**
   * Get the effective endpoint qualifier. An endpoint qualifier on a more specific binding
   * overrides an endpoint qualifier from a higher level more general binding definition.
   * Endpoint qualifiers on the protocols defined inside the binding are ignored.
   */
  protected Qualifier _getEffectiveEndpointQualifier(final Binding binding) {
    EndpointQualifierRef _endpointQualifierRef = binding.getEndpointQualifierRef();
    Qualifier _endpointQualifier = _endpointQualifierRef==null?(Qualifier)null:_endpointQualifierRef.getEndpointQualifier();
    boolean _notEquals = (!Objects.equal(_endpointQualifier, null));
    if (_notEquals) {
      EndpointQualifierRef _endpointQualifierRef_1 = binding.getEndpointQualifierRef();
      return _endpointQualifierRef_1.getEndpointQualifier();
    } else {
      boolean _and = false;
      boolean _not = (!(binding instanceof ModuleBinding));
      if (!_not) {
        _and = false;
      } else {
        EObject _eContainer = binding.eContainer();
        _and = (_not && (_eContainer instanceof Binding));
      }
      if (_and) {
        EObject _eContainer_1 = binding.eContainer();
        return this.getEffectiveEndpointQualifier(((Binding) _eContainer_1));
      } else {
        return null;
      }
    }
  }
  
  /**
   * Get the effective endpoint qualifier. An endpoint qualifier on the protocol definition
   * overrides an endpoint qualifier from it's declaring binding or a higher level more general binding definition.
   */
  protected Qualifier _getEffectiveEndpointQualifier(final BindingProtocol prot) {
    EndpointQualifierRef _endpointQualifierRef = prot.getEndpointQualifierRef();
    Qualifier _endpointQualifier = _endpointQualifierRef==null?(Qualifier)null:_endpointQualifierRef.getEndpointQualifier();
    boolean _notEquals = (!Objects.equal(_endpointQualifier, null));
    if (_notEquals) {
      EndpointQualifierRef _endpointQualifierRef_1 = prot.getEndpointQualifierRef();
      return _endpointQualifierRef_1==null?(Qualifier)null:_endpointQualifierRef_1.getEndpointQualifier();
    } else {
      EObject _eContainer = prot.eContainer();
      if ((_eContainer instanceof Binding)) {
        EObject _eContainer_1 = prot.eContainer();
        return this.getEffectiveEndpointQualifier(((Binding) _eContainer_1));
      } else {
        return null;
      }
    }
  }
  
  protected Qualifier _getEffectiveEndpointQualifier(final ServiceModuleRef ref) {
    EObject _eContainer = ref.eContainer();
    Qualifier _effectiveEndpointQualifier = this.getEffectiveEndpointQualifier(_eContainer);
    return _effectiveEndpointQualifier;
  }
  
  protected Qualifier _getEffectiveEndpointQualifier(final ModuleRef ref) {
    org.fornax.soa.moduledsl.moduleDsl.EndpointQualifierRef _endpointQualifierRef = ref.getEndpointQualifierRef();
    boolean _notEquals = (!Objects.equal(_endpointQualifierRef, null));
    if (_notEquals) {
      org.fornax.soa.moduledsl.moduleDsl.EndpointQualifierRef _endpointQualifierRef_1 = ref.getEndpointQualifierRef();
      return _endpointQualifierRef_1.getEndpointQualifier();
    } else {
      final Module mod = this.objLookup.<Module>getOwnerByType(ref, Module.class);
      org.fornax.soa.moduledsl.moduleDsl.EndpointQualifierRef _endpointQualifierRef_2 = mod.getEndpointQualifierRef();
      return _endpointQualifierRef_2==null?(Qualifier)null:_endpointQualifierRef_2.getEndpointQualifier();
    }
  }
  
  protected Qualifier _getEffectiveEndpointQualifier(final ImportServiceRef ref) {
    org.fornax.soa.moduledsl.moduleDsl.EndpointQualifierRef _endpointQualifierRef = ref.getEndpointQualifierRef();
    boolean _notEquals = (!Objects.equal(_endpointQualifierRef, null));
    if (_notEquals) {
      org.fornax.soa.moduledsl.moduleDsl.EndpointQualifierRef _endpointQualifierRef_1 = ref.getEndpointQualifierRef();
      return _endpointQualifierRef_1.getEndpointQualifier();
    } else {
      final Module mod = this.objLookup.<Module>getOwnerByType(ref, Module.class);
      org.fornax.soa.moduledsl.moduleDsl.EndpointQualifierRef _endpointQualifierRef_2 = mod.getEndpointQualifierRef();
      return _endpointQualifierRef_2==null?(Qualifier)null:_endpointQualifierRef_2.getEndpointQualifier();
    }
  }
  
  /**
   * Get the effective endpoint qualifier and qualifiers defined on protocols declared inside the binding.
   * An endpoint qualifier on a more specific binding  overrides an endpoint qualifier from a higher level
   * more general binding definition.
   * Endpoint qualifiers on the protocols defined inside the binding are added at end of the list.
   */
  public EndpointQualifierDescriptor getPotentialEffectiveEndpointQualifiers(final Binding binding) {
    EndpointQualifierDescriptor _endpointQualifierDescriptor = new EndpointQualifierDescriptor();
    EndpointQualifierDescriptor qualifierDesc = _endpointQualifierDescriptor;
    EndpointQualifierDescriptor _potentialEffectiveEndpointQualifiersInternal = this.getPotentialEffectiveEndpointQualifiersInternal(binding, qualifierDesc);
    qualifierDesc = _potentialEffectiveEndpointQualifiersInternal;
    return qualifierDesc;
  }
  
  private EndpointQualifierDescriptor getPotentialEffectiveEndpointQualifiersInternal(final Binding binding, final EndpointQualifierDescriptor qualifierDescriptor) {
    boolean _and = false;
    EndpointQualifierRef _endpointQualifierRef = binding.getEndpointQualifierRef();
    Qualifier _endpointQualifier = _endpointQualifierRef==null?(Qualifier)null:_endpointQualifierRef.getEndpointQualifier();
    boolean _notEquals = (!Objects.equal(_endpointQualifier, null));
    if (!_notEquals) {
      _and = false;
    } else {
      Qualifier _effectiveEndpointQualifier = qualifierDescriptor.getEffectiveEndpointQualifier();
      boolean _equals = Objects.equal(_effectiveEndpointQualifier, null);
      _and = (_notEquals && _equals);
    }
    if (_and) {
      EndpointQualifierRef _endpointQualifierRef_1 = binding.getEndpointQualifierRef();
      Qualifier _endpointQualifier_1 = _endpointQualifierRef_1.getEndpointQualifier();
      qualifierDescriptor.setEffectiveEndpointQualifier(_endpointQualifier_1);
    }
    EList<BindingProtocol> _protocol = binding.getProtocol();
    for (final BindingProtocol prot : _protocol) {
      boolean _and_1 = false;
      EndpointQualifierRef _endpointQualifierRef_2 = prot.getEndpointQualifierRef();
      Qualifier _endpointQualifier_2 = _endpointQualifierRef_2==null?(Qualifier)null:_endpointQualifierRef_2.getEndpointQualifier();
      boolean _notEquals_1 = (!Objects.equal(_endpointQualifier_2, null));
      if (!_notEquals_1) {
        _and_1 = false;
      } else {
        Map<BindingProtocol,Qualifier> _potentialEndpointQualifiers = qualifierDescriptor.getPotentialEndpointQualifiers();
        Qualifier _get = _potentialEndpointQualifiers.get(prot);
        boolean _equals_1 = Objects.equal(_get, null);
        _and_1 = (_notEquals_1 && _equals_1);
      }
      if (_and_1) {
        EndpointQualifierRef _endpointQualifierRef_3 = prot.getEndpointQualifierRef();
        Qualifier _endpointQualifier_3 = _endpointQualifierRef_3.getEndpointQualifier();
        qualifierDescriptor.addPotentialEndpointQualifiers(prot, _endpointQualifier_3);
      }
    }
    boolean _and_2 = false;
    boolean _not = (!(binding instanceof ModuleBinding));
    if (!_not) {
      _and_2 = false;
    } else {
      EObject _eContainer = binding.eContainer();
      _and_2 = (_not && (_eContainer instanceof Binding));
    }
    if (_and_2) {
      EObject _eContainer_1 = binding.eContainer();
      return this.getPotentialEffectiveEndpointQualifiersInternal(((Binding) _eContainer_1), qualifierDescriptor);
    } else {
      return qualifierDescriptor;
    }
  }
  
  public boolean isPublicEndpoint(final Service service, final Binding binding, final BindingProtocol prot) {
    Server _resolveServer = this.envResolver.resolveServer(binding, prot);
    final Connector connector = this.connectorResolver.resolveConnector(_resolveServer, binding, prot);
    boolean _and = false;
    EndpointVisibility _endpointVisibility = connector.getEndpointVisibility();
    boolean _equals = Objects.equal(_endpointVisibility, EndpointVisibility.PUBLIC);
    if (!_equals) {
      _and = false;
    } else {
      Visibility _visibility = service.getVisibility();
      boolean _notEquals = (!Objects.equal(_visibility, Visibility.PRIVATE));
      _and = (_equals && _notEquals);
    }
    return _and;
  }
  
  public boolean isExtenalEndpoint(final Service service, final Binding binding, final BindingProtocol prot) {
    Server _resolveServer = this.envResolver.resolveServer(binding, prot);
    final Connector connector = this.connectorResolver.resolveConnector(_resolveServer, binding, prot);
    EndpointVisibility _endpointVisibility = connector.getEndpointVisibility();
    return Objects.equal(_endpointVisibility, EndpointVisibility.EXTERNAL);
  }
  
  public boolean isPrivateEndpoint(final Service service, final Binding binding, final BindingProtocol prot) {
    Server _resolveServer = this.envResolver.resolveServer(binding, prot);
    final Connector connector = this.connectorResolver.resolveConnector(_resolveServer, binding, prot);
    boolean _or = false;
    EndpointVisibility _endpointVisibility = connector.getEndpointVisibility();
    boolean _equals = Objects.equal(_endpointVisibility, EndpointVisibility.PRIVATE);
    if (_equals) {
      _or = true;
    } else {
      EndpointVisibility _endpointVisibility_1 = connector.getEndpointVisibility();
      boolean _equals_1 = Objects.equal(_endpointVisibility_1, null);
      _or = (_equals || _equals_1);
    }
    return _or;
  }
  
  public Qualifier getEffectiveEndpointQualifier(final EObject ref) {
    if (ref instanceof ImportServiceRef) {
      return _getEffectiveEndpointQualifier((ImportServiceRef)ref);
    } else if (ref instanceof Binding) {
      return _getEffectiveEndpointQualifier((Binding)ref);
    } else if (ref instanceof BindingProtocol) {
      return _getEffectiveEndpointQualifier((BindingProtocol)ref);
    } else if (ref instanceof ModuleRef) {
      return _getEffectiveEndpointQualifier((ModuleRef)ref);
    } else if (ref instanceof ServiceModuleRef) {
      return _getEffectiveEndpointQualifier((ServiceModuleRef)ref);
    } else if (ref != null) {
      return _getEffectiveEndpointQualifier(ref);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ref).toString());
    }
  }
}
