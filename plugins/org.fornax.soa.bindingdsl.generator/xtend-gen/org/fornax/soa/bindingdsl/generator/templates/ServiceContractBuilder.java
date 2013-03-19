package org.fornax.soa.bindingdsl.generator.templates;

import com.google.inject.Inject;
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

/**
 * A builder that builds service contracts. The builder delegates to a chain of {@link IProtocolContractBuilder}s
 * to build service contracts for each protocol defined in the binding
 */
@SuppressWarnings("all")
public class ServiceContractBuilder {
  @Inject
  private Set<ProvidedProtocolContractBuilder> protocolContractBuilders;
  
  @Inject
  private Logger log;
  
  /**
   * Build service contracts for the given binding, respecting the rules defined in the architecture profile. Service
   * contracts are build for each service provided by the bound module. Endpoints will point to environment defined
   * in the binding model. <br/><br/>
   * 
   * @param binding The module binding to generate service contracts for
   * @param profile The architecture profile defining the architectural rules, generated service contracts must
   * be compliant to
   */
  public void build(final ModuleBinding binding, final SOAProfile profile) {
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
  
  /**
   * Build service contracts for provided and/or used services by the module, respecting the rules defined
   * in the architecture profile. <br/>
   * The build is based on binding definitions that bind the providing module to the given targetEnvironment.
   * Bindings are looked up for provided and used services. The most specific binding will be used for regarding
   * each provided or used service respectively. <br/><br/>
   * 
   * <b>Lookup of bindings for provided services:</b> <br/>
   * Looks for a binding that binds the module (or a compatible newer version of it) to the given target environment.
   * 
   * <br/><br/>
   * <b>Lookup of bindings for used services:</b> <br/>
   * Looks for a binding that binds the used module, either defined as direct reference of via a service reference with
   * providing module in the module definition, to the given target environment.
   * If no binding for resolved providing module can be found, the binding of a a compatible newer version of it will be
   * used.
   * 
   * @param module The module, for which to build service contracts for provided and/or used services
   * @param targetEnvironment The environment to build service contracts for.
   * @param generateProvidedServices If true, contracts for services provided by the module will be generated
   * @param generateUsedServices If true, contracts for services provided by the module will be generated
   * @param endpointQualifierRef Only generate for looked up bindings that are tagged with this endpoint qualifier
   * @param profile The architecture profile defining the architectural rules, generated service contracts must be compliant to
   */
  public void build(final Module module, final Environment targetEnvironment, final boolean generateProvidedServices, final boolean generateUsedServices, final EndpointQualifierRef endpointQualifierRef, final SOAProfile profile) {
    for (final ProvidedProtocolContractBuilder protContractBuilder : this.protocolContractBuilders) {
      try {
        if (generateProvidedServices) {
          protContractBuilder.buildProvidedServiceContracts(module, targetEnvironment, endpointQualifierRef, profile);
        }
        if (generateUsedServices) {
          protContractBuilder.buildUsedServiceContracts(module, targetEnvironment, endpointQualifierRef, profile);
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
}
