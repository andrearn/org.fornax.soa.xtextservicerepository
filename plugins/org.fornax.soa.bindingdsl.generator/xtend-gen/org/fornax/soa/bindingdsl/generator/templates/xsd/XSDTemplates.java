package org.fornax.soa.bindingdsl.generator.templates.xsd;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver;
import org.fornax.soa.bindingDsl.Binding;
import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.bindingDsl.ServiceBinding;
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.profiledsl.query.LifecycleQueries;
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.service.VersionedDomainNamespace;
import org.fornax.soa.serviceDsl.SubNamespace;

/**
 * Generate an XSD for a SubNamespace. Types and exceptions are filtered by their lifecycle state, determining whether it
 * is supported by the given target environment.
 */
@SuppressWarnings("all")
public class XSDTemplates {
  @Inject
  private BindingExtensions _bindingExtensions;
  
  @Inject
  private EnvironmentBindingResolver _environmentBindingResolver;
  
  @Inject
  private LifecycleQueries _lifecycleQueries;
  
  @Inject
  private org.fornax.soa.servicedsl.generator.templates.xsd.XSDTemplates xsdGenerator;
  
  @Inject
  private IQualifiedNameProvider nameProvider;
  
  @Inject
  @Named(value = "noDependencies")
  private Boolean noDependencies;
  
  @Inject
  private Logger log;
  
  public void toXSD(final SubNamespace ns, final List<Environment> env, final String targetEnv, final List<SOAProfile> profiles, final String profileName) {
    final Function1<Environment,Boolean> _function = new Function1<Environment,Boolean>() {
        public Boolean apply(final Environment e) {
          String _name = e.getName();
          boolean _equals = Objects.equal(_name, targetEnv);
          return Boolean.valueOf(_equals);
        }
      };
    Environment _findFirst = IterableExtensions.<Environment>findFirst(env, _function);
    final Function1<SOAProfile,Boolean> _function_1 = new Function1<SOAProfile,Boolean>() {
        public Boolean apply(final SOAProfile e) {
          String _name = e.getName();
          boolean _equals = Objects.equal(_name, profileName);
          return Boolean.valueOf(_equals);
        }
      };
    SOAProfile _findFirst_1 = IterableExtensions.<SOAProfile>findFirst(profiles, _function_1);
    this.toXSD(ns, _findFirst, _findFirst_1);
  }
  
  public void toXSD(final SubNamespace ns, final Environment env, final SOAProfile profile) {
    QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(ns);
    String _string = _fullyQualifiedName.toString();
    String _plus = ("Generating XSDs for namespace " + _string);
    this.log.fine(_plus);
    try {
      Lifecycle _lifecycle = profile.getLifecycle();
      LifecycleState _minLifecycleState = this._lifecycleQueries.getMinLifecycleState(env, _lifecycle);
      String _registryBaseUrl = this._bindingExtensions.getRegistryBaseUrl(env);
      this.xsdGenerator.toXSD(ns, _minLifecycleState, profile, _registryBaseUrl);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
        QualifiedName _fullyQualifiedName_1 = this.nameProvider.getFullyQualifiedName(ns);
        String _string_1 = _fullyQualifiedName_1.toString();
        String _plus_1 = ("Error generating XSDs for namespace " + _string_1);
        String _plus_2 = (_plus_1 + "\n");
        this.log.log(Level.SEVERE, _plus_2, ex);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void toXSD(final VersionedDomainNamespace ns, final Environment env, final SOAProfile profile) {
    String _fqn = ns.getFqn();
    String _plus = ("Generating XSDs for namespace " + _fqn);
    String _plus_1 = (_plus + " with major version ");
    String _version = ns.getVersion();
    String _plus_2 = (_plus_1 + _version);
    this.log.fine(_plus_2);
    try {
      Lifecycle _lifecycle = profile.getLifecycle();
      LifecycleState _minLifecycleState = this._lifecycleQueries.getMinLifecycleState(env, _lifecycle);
      String _registryBaseUrl = this._bindingExtensions.getRegistryBaseUrl(env);
      this.xsdGenerator.toXSD(ns, _minLifecycleState, profile, _registryBaseUrl);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
        String _fqn_1 = ns.getFqn();
        String _plus_3 = ("Error generating XSDs for namespace " + _fqn_1);
        String _plus_4 = (_plus_3 + " with major version ");
        String _version_1 = ns.getVersion();
        String _plus_5 = (_plus_4 + _version_1);
        String _plus_6 = (_plus_5 + "\n");
        this.log.log(Level.SEVERE, _plus_6, ex);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected void _toXSD(final VersionedDomainNamespace ns, final LifecycleState minState, final Binding bind, final SOAProfile profile) {
  }
  
  protected void _toXSD(final VersionedDomainNamespace ns, final LifecycleState minState, final ServiceBinding bind, final SOAProfile profile) {
    EObject _eContainer = bind.eContainer();
    this.toXSD(ns, minState, ((Binding) _eContainer), profile);
  }
  
  protected void _toXSD(final VersionedDomainNamespace ns, final LifecycleState minState, final ModuleBinding bind, final SOAProfile profile) {
    String _fqn = ns.getFqn();
    String _plus = ("Generating XSDs for namespace " + _fqn);
    String _plus_1 = (_plus + " with major version ");
    String _version = ns.getVersion();
    String _plus_2 = (_plus_1 + _version);
    this.log.fine(_plus_2);
    try {
      Environment _resolveEnvironment = this._environmentBindingResolver.resolveEnvironment(bind);
      Lifecycle _lifecycle = profile.getLifecycle();
      LifecycleState _minLifecycleState = this._lifecycleQueries.getMinLifecycleState(_resolveEnvironment, _lifecycle);
      String _registryBaseUrl = this._bindingExtensions.getRegistryBaseUrl(bind);
      this.xsdGenerator.toXSD(ns, _minLifecycleState, profile, _registryBaseUrl);
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
        String _fqn_1 = ns.getFqn();
        String _plus_3 = ("Error generating XSDs for namespace " + _fqn_1);
        String _plus_4 = (_plus_3 + " with major version ");
        String _version_1 = ns.getVersion();
        String _plus_5 = (_plus_4 + _version_1);
        String _plus_6 = (_plus_5 + "\n");
        this.log.log(Level.SEVERE, _plus_6, ex);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void toXSD(final VersionedDomainNamespace ns, final LifecycleState minState, final Binding bind, final SOAProfile profile) {
    if (bind instanceof ModuleBinding) {
      _toXSD(ns, minState, (ModuleBinding)bind, profile);
      return;
    } else if (bind instanceof ServiceBinding) {
      _toXSD(ns, minState, (ServiceBinding)bind, profile);
      return;
    } else if (bind != null) {
      _toXSD(ns, minState, bind, profile);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ns, minState, bind, profile).toString());
    }
  }
}
