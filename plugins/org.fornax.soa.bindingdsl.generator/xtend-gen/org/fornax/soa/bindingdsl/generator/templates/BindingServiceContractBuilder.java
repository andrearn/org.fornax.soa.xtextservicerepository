package org.fornax.soa.bindingdsl.generator.templates;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.bindingdsl.generator.ProvidedProtocolContractBuilder;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.moduledsl.moduleDsl.EndpointQualifierRef;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;

@SuppressWarnings("all")
public class BindingServiceContractBuilder {
  @Inject
  private Set<ProvidedProtocolContractBuilder> protocolContractBuilders;
  
  @Inject
  @Named(value = "noDependencies")
  private Boolean noDependencies;
  
  @Inject
  @Named(value = "forceRelativePaths")
  private Boolean forceRelativePaths;
  
  @Inject
  private Logger log;
  
  protected void _build(final ModuleBinding binding, final SOAProfile profile) {
    for (final ProvidedProtocolContractBuilder protContractBuilder : this.protocolContractBuilders) {
      try {
        protContractBuilder.buildServiceContracts(binding, profile);
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception ex = (Exception)_t;
          this.log.log(Level.SEVERE, "Error generating contracts\n", ex);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
  }
  
  public void build(final Module module, final Environment targetEnvironment, final boolean generateProvidedServices, final boolean generateUsedServices, final EndpointQualifierRef providerEndpointQualifier, final SOAProfile profile) {
    for (final ProvidedProtocolContractBuilder protContractBuilder : this.protocolContractBuilders) {
      try {
        if (generateProvidedServices) {
          protContractBuilder.buildProvidedServiceContracts(module, targetEnvironment, providerEndpointQualifier, profile);
        }
        if (generateUsedServices) {
          protContractBuilder.buildUsedServiceContracts(module, targetEnvironment, profile);
        }
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception ex = (Exception)_t;
          this.log.log(Level.SEVERE, "Error generating contracts\n", ex);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
  }
  
  public void build(final ModuleBinding binding, final SOAProfile profile) {
    {
      _build(binding, profile);
      return;
    }
  }
}
