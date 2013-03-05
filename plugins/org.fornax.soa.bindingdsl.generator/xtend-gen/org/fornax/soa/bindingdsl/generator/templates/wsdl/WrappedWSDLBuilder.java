package org.fornax.soa.bindingdsl.generator.templates.wsdl;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.fornax.soa.binding.query.environment.AssetStateEnvironmentEligibilityChecker;
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.profiledsl.query.LifecycleQueries;
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.servicedsl.generator.templates.webservice.WrappedWsdlGenerator;

/**
 * Generate a WSDL where all input and output parameters are wrapped into a Wrappertype.
 */
@SuppressWarnings("all")
public class WrappedWSDLBuilder {
  @Inject
  private WrappedWsdlGenerator _wrappedWsdlGenerator;
  
  @Inject
  private BindingExtensions _bindingExtensions;
  
  @Inject
  private LifecycleQueries _lifecycleQueries;
  
  @Inject
  private AssetStateEnvironmentEligibilityChecker _assetStateEnvironmentEligibilityChecker;
  
  /**
   * <b>CARTRIDGE ENTRYPOINT</b> for generation of abstract wrapped  WSDLs
   * Abstract WSDLs only define the abstract interface of a service. The binding is declared
   * in a separate WSDL that imports this abstract WSDL. <br/>
   * 
   * A WSDL for each Service in the given SubNamespace matching the given minimal LifecycleState
   * will be generated. For each major version of a service WSDL is generated for the latest minor
   * version in that major version matching the minimal Lifecycle constraint is be generated
   */
  protected void _toWrappedWSDL(final SubNamespace ns, final SOAProfile profileName, final Environment targetEnvironment) {
    EList<Service> _services = ns.getServices();
    final Function1<Service,Boolean> _function = new Function1<Service,Boolean>() {
        public Boolean apply(final Service s) {
          boolean _isEligibleForEnvironment = WrappedWSDLBuilder.this._assetStateEnvironmentEligibilityChecker.isEligibleForEnvironment(s, targetEnvironment);
          return Boolean.valueOf(_isEligibleForEnvironment);
        }
      };
    Iterable<Service> _filter = IterableExtensions.<Service>filter(_services, _function);
    final Procedure1<Service> _function_1 = new Procedure1<Service>() {
        public void apply(final Service e) {
          WrappedWSDLBuilder.this.toWrappedWSDL(e, profileName, targetEnvironment);
        }
      };
    IterableExtensions.<Service>forEach(_filter, _function_1);
  }
  
  protected void _toWrappedWSDL(final SubNamespace ns, final List<SOAProfile> profiles, final String profileName, final List<Environment> environments, final String targetEnvironment) {
    final Function1<SOAProfile,Boolean> _function = new Function1<SOAProfile,Boolean>() {
        public Boolean apply(final SOAProfile p) {
          String _name = p.getName();
          boolean _equals = Objects.equal(_name, profileName);
          return Boolean.valueOf(_equals);
        }
      };
    final SOAProfile prof = IterableExtensions.<SOAProfile>findFirst(profiles, _function);
    final Function1<Environment,Boolean> _function_1 = new Function1<Environment,Boolean>() {
        public Boolean apply(final Environment e) {
          String _name = e.getName();
          boolean _equals = Objects.equal(_name, targetEnvironment);
          return Boolean.valueOf(_equals);
        }
      };
    final Environment env = IterableExtensions.<Environment>findFirst(environments, _function_1);
    EList<Service> _services = ns.getServices();
    final Function1<Service,Boolean> _function_2 = new Function1<Service,Boolean>() {
        public Boolean apply(final Service s) {
          boolean _isEligibleForEnvironment = WrappedWSDLBuilder.this._assetStateEnvironmentEligibilityChecker.isEligibleForEnvironment(s, env);
          return Boolean.valueOf(_isEligibleForEnvironment);
        }
      };
    Iterable<Service> _filter = IterableExtensions.<Service>filter(_services, _function_2);
    final Procedure1<Service> _function_3 = new Procedure1<Service>() {
        public void apply(final Service e) {
          WrappedWSDLBuilder.this.toWrappedWSDL(e, prof, env);
        }
      };
    IterableExtensions.<Service>forEach(_filter, _function_3);
  }
  
  protected void _toWrappedWSDL(final Service svc, final List<SOAProfile> profiles, final String profileName, final List<Environment> environments, final String targetEnvironment) {
    final Function1<Environment,Boolean> _function = new Function1<Environment,Boolean>() {
        public Boolean apply(final Environment e) {
          String _name = e.getName();
          boolean _equals = Objects.equal(_name, targetEnvironment);
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
    SOAProfile _findFirst = IterableExtensions.<SOAProfile>findFirst(profiles, _function_1);
    this.toWrappedWSDL(svc, _findFirst, env);
  }
  
  protected void _toWrappedWSDL(final Service svc, final SOAProfile profile, final Environment environment) {
    Lifecycle _lifecycle = profile.getLifecycle();
    LifecycleState _minLifecycleState = this._lifecycleQueries.getMinLifecycleState(environment, _lifecycle);
    String _registryBaseUrl = this._bindingExtensions.getRegistryBaseUrl(environment);
    this._wrappedWsdlGenerator.toWrappedWSDL(svc, _minLifecycleState, profile, _registryBaseUrl);
  }
  
  public void toWrappedWSDL(final EObject svc, final SOAProfile profile, final Environment environment) {
    if (svc instanceof Service) {
      _toWrappedWSDL((Service)svc, profile, environment);
      return;
    } else if (svc instanceof SubNamespace) {
      _toWrappedWSDL((SubNamespace)svc, profile, environment);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(svc, profile, environment).toString());
    }
  }
  
  public void toWrappedWSDL(final EObject svc, final List<SOAProfile> profiles, final String profileName, final List<Environment> environments, final String targetEnvironment) {
    if (svc instanceof Service) {
      _toWrappedWSDL((Service)svc, profiles, profileName, environments, targetEnvironment);
      return;
    } else if (svc instanceof SubNamespace) {
      _toWrappedWSDL((SubNamespace)svc, profiles, profileName, environments, targetEnvironment);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(svc, profiles, profileName, environments, targetEnvironment).toString());
    }
  }
}
