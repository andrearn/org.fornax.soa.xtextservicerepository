package org.fornax.soa.bindingdsl.generator.templates;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.List;
import java.util.logging.Logger;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions;
import org.fornax.soa.bindingdsl.generator.templates.BindingServiceContractBuilder;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.moduledsl.moduleDsl.EndpointQualifierRef;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.profiledsl.query.LifecycleQueries;
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.servicedsl.generator.templates.xsd.EventXSDTemplates;

/**
 * Builds all technical artifacts that represent a binding (WSDLs/XSDs etc.).
 */
@SuppressWarnings("all")
public class BindingBuilder {
  @Inject
  private BindingExtensions _bindingExtensions;
  
  @Inject
  private LifecycleQueries _lifecycleQueries;
  
  @Inject
  private BindingServiceContractBuilder contractBuilder;
  
  @Inject
  private EventXSDTemplates eventXsdGenerator;
  
  @Inject
  private IQualifiedNameProvider nameProvider;
  
  @Inject
  @Named(value = "noDependencies")
  private Boolean noDependencies;
  
  @Inject
  private Logger log;
  
  /**
   * ENTRYPOINT for generation of concrete and imported abstract WSDLs and their required XSDs
   * 	for a gibven ModuleBindings. The ModuleBinding binds all Services provided by the module
   * 	to a certain Environment. Generates artifacts for all ModuleBindings
   * 	that target an Environment matching the given environment name.
   * 
   * 	All Services referenced by the Module and their required XSDs that match the minimal given
   * 	LifecycleState derived from the profile's Environment and the minimal required LifecycleState
   * 	of the respective Service / owning SubNamespace
   */
  public void toBinding(final ModuleBinding binding, final SOAProfile profile) {
    String _name = binding.getName();
    String _plus = ("Generating technical service contracts for binding " + _name);
    this.log.info(_plus);
    try {
      this.contractBuilder.build(binding, profile);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
        String _name_1 = binding.getName();
        String _plus_1 = ("Error generating technical service contracts for binding " + _name_1);
        String _plus_2 = (_plus_1 + "\n");
        String _message = ex.getMessage();
        String _plus_3 = (_plus_2 + _message);
        this.log.severe(_plus_3);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void toBinding(final ModuleBinding binding, final SOAProfile profile, final boolean noDeps, final boolean includeSubNamespaces) {
    String _name = binding.getName();
    String _plus = ("Generating technical service contracts for binding " + _name);
    this.log.info(_plus);
    try {
      this.contractBuilder.build(binding, profile);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
        String _name_1 = binding.getName();
        String _plus_1 = ("Error generating technical service contracts for binding " + _name_1);
        String _plus_2 = (_plus_1 + "\n");
        String _message = ex.getMessage();
        String _plus_3 = (_plus_2 + _message);
        this.log.severe(_plus_3);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void toBinding(final Module module, final Environment environment, final boolean generateProvidedServices, final boolean generateUsedServices, final EndpointQualifierRef providerEndpointQualifier, final SOAProfile profile) {
    String _name = module.getName();
    String _plus = ("Generating technical service contracts for services used by module " + _name);
    String _plus_1 = (_plus + " with modules providing the services bound to environment ");
    String _name_1 = environment.getName();
    String _plus_2 = (_plus_1 + _name_1);
    this.log.info(_plus_2);
    try {
      this.contractBuilder.build(module, environment, generateProvidedServices, generateUsedServices, providerEndpointQualifier, profile);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
        String _name_2 = module.getName();
        String _plus_3 = ("Error generating technical service contracts for services used by module " + _name_2);
        String _plus_4 = (_plus_3 + " with modules providing the services bound to environment ");
        String _name_3 = environment.getName();
        String _plus_5 = (_plus_4 + _name_3);
        String _plus_6 = (_plus_5 + "\n");
        String _message = ex.getMessage();
        String _plus_7 = (_plus_6 + _message);
        this.log.severe(_plus_7);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * Event XSDs for Services having an request and an response event for each service operation
   */
  public void toEventsInclSubNamespaces(final String namespaceName, final List<SubNamespace> namespaces, final List<Environment> environments, final String targetEnv, final List<SOAProfile> profiles, final String profileName) {
    boolean _notEquals = (!Objects.equal(namespaceName, null));
    if (_notEquals) {
      final Function1<SubNamespace,Boolean> _function = new Function1<SubNamespace,Boolean>() {
          public Boolean apply(final SubNamespace e) {
            String _name = e.getName();
            boolean _startsWith = _name.startsWith(namespaceName);
            return Boolean.valueOf(_startsWith);
          }
        };
      Iterable<SubNamespace> _filter = IterableExtensions.<SubNamespace>filter(namespaces, _function);
      for (final SubNamespace ns : _filter) {
        this.toEvents(ns, environments, targetEnv, profiles, profileName);
      }
    } else {
      this.log.severe("No namespace name expression has been supplied");
    }
  }
  
  public void toEvents(final SubNamespace ns, final List<Environment> environments, final String targetEnv, final List<SOAProfile> profiles, final String profileName) {
    final Function1<Environment,Boolean> _function = new Function1<Environment,Boolean>() {
        public Boolean apply(final Environment e) {
          String _name = e.getName();
          boolean _equals = Objects.equal(_name, targetEnv);
          return Boolean.valueOf(_equals);
        }
      };
    final Environment env = IterableExtensions.<Environment>findFirst(environments, _function);
    final Function1<SOAProfile,Boolean> _function_1 = new Function1<SOAProfile,Boolean>() {
        public Boolean apply(final SOAProfile e) {
          String _name = e.getName();
          boolean _equals = Objects.equal(_name, profileName);
          return Boolean.valueOf(_equals);
        }
      };
    final SOAProfile profile = IterableExtensions.<SOAProfile>findFirst(profiles, _function_1);
    QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(ns);
    String _plus = ("Generating event data definitions for services in namespace " + _fullyQualifiedName);
    String _plus_1 = (_plus + " applicable for Environment ");
    String _name = env.getName();
    String _plus_2 = (_plus_1 + _name);
    this.log.info(_plus_2);
    try {
      Lifecycle _lifecycle = profile.getLifecycle();
      LifecycleState _minLifecycleState = this._lifecycleQueries.getMinLifecycleState(env, _lifecycle);
      String _registryBaseUrl = this._bindingExtensions.getRegistryBaseUrl(env);
      this.eventXsdGenerator.toEvents(ns, _minLifecycleState, profile, _registryBaseUrl);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
        QualifiedName _fullyQualifiedName_1 = this.nameProvider.getFullyQualifiedName(ns);
        String _plus_3 = ("Error generating event data definitions for services in namespace " + _fullyQualifiedName_1);
        String _plus_4 = (_plus_3 + " applicable for Environment ");
        String _name_1 = env.getName();
        String _plus_5 = (_plus_4 + _name_1);
        String _plus_6 = (_plus_5 + "\n");
        String _message = ex.getMessage();
        String _plus_7 = (_plus_6 + _message);
        this.log.severe(_plus_7);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
