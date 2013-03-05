package org.fornax.soa.bindingdsl.generator.templates.soap;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.fornax.soa.basedsl.sOABaseDsl.Version;
import org.fornax.soa.binding.query.BindingLookup;
import org.fornax.soa.binding.query.BindingResolver;
import org.fornax.soa.binding.query.ProtocolMatcher;
import org.fornax.soa.binding.query.environment.AssetStateEnvironmentEligibilityChecker;
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver;
import org.fornax.soa.binding.query.services.ServiceRefBindingDescription;
import org.fornax.soa.bindingDsl.Binding;
import org.fornax.soa.bindingDsl.BindingProtocol;
import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.bindingDsl.ModuleRef;
import org.fornax.soa.bindingDsl.SOAP;
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions;
import org.fornax.soa.bindingdsl.generator.templates.IProtocolContractBuilder;
import org.fornax.soa.bindingdsl.generator.templates.soap.ConcreteWsdlGenerator;
import org.fornax.soa.bindingdsl.generator.templates.xsd.XSDBuilder;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.moduledsl.moduleDsl.AbstractServiceRef;
import org.fornax.soa.moduledsl.moduleDsl.EndpointQualifierRef;
import org.fornax.soa.moduledsl.moduleDsl.ImportBindingProtocol;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.moduledsl.query.IModuleServiceResolver;
import org.fornax.soa.profiledsl.generator.templates.MessageHeaderXSDTemplates;
import org.fornax.soa.profiledsl.query.LifecycleQueries;
import org.fornax.soa.profiledsl.sOAProfileDsl.Lifecycle;
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.service.VersionedDomainNamespace;
import org.fornax.soa.service.query.HeaderFinder;
import org.fornax.soa.service.query.namespace.NamespaceImportQueries;
import org.fornax.soa.service.query.namespace.NamespaceQuery;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.servicedsl.generator.templates.webservice.WSDLGenerator;

/**
 * Generates WSDLs and XSDs for SOAP based service endpoints
 */
@SuppressWarnings("all")
public class SOAPProtocolContractBuilder implements IProtocolContractBuilder {
  @Inject
  private NamespaceQuery _namespaceQuery;
  
  @Inject
  private BindingExtensions _bindingExtensions;
  
  @Inject
  private AssetStateEnvironmentEligibilityChecker _assetStateEnvironmentEligibilityChecker;
  
  @Inject
  private BindingLookup _bindingLookup;
  
  @Inject
  private NamespaceImportQueries _namespaceImportQueries;
  
  @Inject
  private HeaderFinder _headerFinder;
  
  @Inject
  private EnvironmentBindingResolver _environmentBindingResolver;
  
  @Inject
  private WSDLGenerator wsdlGenerator;
  
  @Inject
  private XSDBuilder xsdGenerator;
  
  @Inject
  private ConcreteWsdlGenerator concreteWsdlGenerator;
  
  @Inject
  private MessageHeaderXSDTemplates msgHeaderGenerator;
  
  @Inject
  private BindingResolver bindingResolver;
  
  @Inject
  private IQualifiedNameProvider nameProvider;
  
  @Inject
  private ProtocolMatcher protocolMatcher;
  
  @Inject
  private LifecycleQueries lifecycleQueries;
  
  @Inject
  private IModuleServiceResolver modServiceResolver;
  
  @Inject
  @Named(value = "noDependencies")
  private Boolean noDependencies;
  
  @Inject
  @Named(value = "forceRelativePaths")
  private Boolean forceRelativePaths;
  
  @Inject
  private Logger log;
  
  public void buildServiceContracts(final ModuleBinding binding, final SOAProfile profile) {
    String _name = binding.getName();
    String _plus = ("Generating WSDLs and XSDs for binding " + _name);
    this.log.fine(_plus);
    ModuleRef _module = binding.getModule();
    Module _module_1 = _module.getModule();
    final Set<AbstractServiceRef> providedServices = this.modServiceResolver.getAllProvidedServiceRefs(_module_1);
    for (final AbstractServiceRef provSvcRef : providedServices) {
      {
        Environment _resolveEnvironment = this._environmentBindingResolver.resolveEnvironment(binding);
        final Service svc = this.modServiceResolver.resolveModuleServiceRef(provSvcRef, _resolveEnvironment);
        boolean _notEquals = (!Objects.equal(svc, null));
        if (_notEquals) {
          try {
            final Binding specBinding = this._bindingLookup.getMostSpecificBinding(svc, binding);
            EList<BindingProtocol> _protocol = specBinding.getProtocol();
            final Function1<BindingProtocol,Boolean> _function = new Function1<BindingProtocol,Boolean>() {
                public Boolean apply(final BindingProtocol p) {
                  return Boolean.valueOf((p instanceof SOAP));
                }
              };
            Iterable<BindingProtocol> _filter = IterableExtensions.<BindingProtocol>filter(_protocol, _function);
            final Function1<BindingProtocol,SOAP> _function_1 = new Function1<BindingProtocol,SOAP>() {
                public SOAP apply(final BindingProtocol e) {
                  return ((SOAP) e);
                }
              };
            Iterable<SOAP> _map = IterableExtensions.<BindingProtocol, SOAP>map(_filter, _function_1);
            for (final SOAP soapProt : _map) {
              boolean _and = false;
              String _providedContractUrl = svc.getProvidedContractUrl();
              boolean _equals = Objects.equal(_providedContractUrl, null);
              if (!_equals) {
                _and = false;
              } else {
                Environment _resolveEnvironment_1 = this._environmentBindingResolver.resolveEnvironment(binding);
                boolean _isEligibleForEnvironment = this._assetStateEnvironmentEligibilityChecker.isEligibleForEnvironment(svc, _resolveEnvironment_1);
                _and = (_equals && _isEligibleForEnvironment);
              }
              if (_and) {
                final SubNamespace namespace = this._namespaceQuery.findSubdomain(svc);
                Environment _resolveEnvironment_2 = this._environmentBindingResolver.resolveEnvironment(binding);
                Lifecycle _lifecycle = profile.getLifecycle();
                final LifecycleState minState = this.lifecycleQueries.getMinLifecycleState(_resolveEnvironment_2, _lifecycle);
                String _registryBaseUrl = this._bindingExtensions.getRegistryBaseUrl(binding);
                this.wsdlGenerator.toWSDL(svc, namespace, minState, profile, _registryBaseUrl);
                this.concreteWsdlGenerator.toWSDL(binding, svc, soapProt, profile);
                boolean _not = (!this.noDependencies);
                if (_not) {
                  final Set<VersionedDomainNamespace> verNamespaces = this._namespaceImportQueries.importedVersionedNS(svc, minState);
                  final Procedure1<VersionedDomainNamespace> _function_2 = new Procedure1<VersionedDomainNamespace>() {
                      public void apply(final VersionedDomainNamespace n) {
                        SOAPProtocolContractBuilder.this.xsdGenerator.toXSD(n, minState, binding, profile);
                      }
                    };
                  IterableExtensions.<VersionedDomainNamespace>forEach(verNamespaces, _function_2);
                  final MessageHeader requestHeader = this._headerFinder.findBestMatchingRequestHeader(svc, profile);
                  if ((this.forceRelativePaths).booleanValue()) {
                    String _registryBaseUrl_1 = this._bindingExtensions.getRegistryBaseUrl(binding);
                    this.msgHeaderGenerator.toMessageHeaderXSD(requestHeader, profile, _registryBaseUrl_1);
                  } else {
                    this.msgHeaderGenerator.toMessageHeaderXSD(requestHeader, profile);
                  }
                  final MessageHeader responseHeader = this._headerFinder.findBestMatchingResponseHeader(svc, profile);
                  if ((this.forceRelativePaths).booleanValue()) {
                    String _registryBaseUrl_2 = this._bindingExtensions.getRegistryBaseUrl(binding);
                    this.msgHeaderGenerator.toMessageHeaderXSD(responseHeader, profile, _registryBaseUrl_2);
                  } else {
                    this.msgHeaderGenerator.toMessageHeaderXSD(responseHeader, profile);
                  }
                }
              }
            }
          } catch (final Throwable _t) {
            if (_t instanceof Exception) {
              final Exception ex = (Exception)_t;
              QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(svc);
              String _string = _fullyQualifiedName.toString();
              String _plus_1 = ("Error generating contracts for service " + _string);
              String _plus_2 = (_plus_1 + " and version ");
              Version _version = svc.getVersion();
              String _version_1 = _version.getVersion();
              String _plus_3 = (_plus_2 + _version_1);
              String _plus_4 = (_plus_3 + "\n");
              this.log.log(Level.SEVERE, _plus_4, ex);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        }
      }
    }
  }
  
  public void buildProvidedServiceContracts(final Module module, final Environment targetEnvironment, final EndpointQualifierRef providerEndpointQualifier, final SOAProfile profile) {
    String _name = module.getName();
    String _plus = ("Generating WSDLs and XSDs for services provided by module " + _name);
    String _plus_1 = (_plus + " looking up binding for used module to environment ");
    String _name_1 = targetEnvironment.getName();
    String _plus_2 = (_plus_1 + _name_1);
    this.log.fine(_plus_2);
    final Set<ServiceRefBindingDescription> bindingDescs = this.bindingResolver.resolveCompatibleProvidedServiceBindings(module, targetEnvironment, providerEndpointQualifier);
    for (final ServiceRefBindingDescription specBindingDesc : bindingDescs) {
      {
        final Service svc = specBindingDesc.getResolvedService();
        boolean _notEquals = (!Objects.equal(svc, null));
        if (_notEquals) {
          try {
            Binding _applicableBinding = specBindingDesc.getApplicableBinding();
            boolean _supportsImportBindingProtocol = this.protocolMatcher.supportsImportBindingProtocol(_applicableBinding, ImportBindingProtocol.SOAP);
            if (_supportsImportBindingProtocol) {
              this.doBuildServiceContracts(specBindingDesc, profile);
            }
          } catch (final Throwable _t) {
            if (_t instanceof Exception) {
              final Exception ex = (Exception)_t;
              QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(svc);
              String _string = _fullyQualifiedName.toString();
              String _plus_3 = ("Error generating contracts for service " + _string);
              String _plus_4 = (_plus_3 + " and version ");
              Version _version = svc.getVersion();
              String _version_1 = _version.getVersion();
              String _plus_5 = (_plus_4 + _version_1);
              String _plus_6 = (_plus_5 + "\n");
              this.log.log(Level.SEVERE, _plus_6, ex);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        } else {
          AbstractServiceRef _serviceRef = specBindingDesc.getServiceRef();
          Service _service = _serviceRef.getService();
          QualifiedName _fullyQualifiedName_1 = this.nameProvider.getFullyQualifiedName(_service);
          String _string_1 = _fullyQualifiedName_1.toString();
          String _plus_7 = ("Error generating contracts for service " + _string_1);
          String _plus_8 = (_plus_7 + " and version ");
          AbstractServiceRef _serviceRef_1 = specBindingDesc.getServiceRef();
          Service _service_1 = _serviceRef_1.getService();
          Version _version_2 = _service_1.getVersion();
          String _version_3 = _version_2.getVersion();
          String _plus_9 = (_plus_8 + _version_3);
          String _plus_10 = (_plus_9 + " of module ");
          String _name_2 = module.getName();
          String _plus_11 = (_plus_10 + _name_2);
          String _plus_12 = (_plus_11 + ". Service could not be resolved for environment ");
          String _name_3 = targetEnvironment.getName();
          String _plus_13 = (_plus_12 + _name_3);
          this.log.severe(_plus_13);
        }
      }
    }
  }
  
  public void buildUsedServiceContracts(final Module module, final Environment targetEnvironment, final SOAProfile profile) {
    String _name = module.getName();
    String _plus = ("Generating WSDLs and XSDs for used services in module " + _name);
    String _plus_1 = (_plus + " looking up binding for used module to environment ");
    String _name_1 = targetEnvironment.getName();
    String _plus_2 = (_plus_1 + _name_1);
    this.log.fine(_plus_2);
    final Set<ServiceRefBindingDescription> bindingDescs = this.bindingResolver.resolveCompatibleUsedServiceBindings(module, targetEnvironment);
    for (final ServiceRefBindingDescription specBindingDesc : bindingDescs) {
      {
        final Service svc = specBindingDesc.getResolvedService();
        boolean _notEquals = (!Objects.equal(svc, null));
        if (_notEquals) {
          try {
            Binding _applicableBinding = specBindingDesc.getApplicableBinding();
            boolean _supportsImportBindingProtocol = this.protocolMatcher.supportsImportBindingProtocol(_applicableBinding, ImportBindingProtocol.SOAP);
            if (_supportsImportBindingProtocol) {
              this.doBuildServiceContracts(specBindingDesc, profile);
            }
          } catch (final Throwable _t) {
            if (_t instanceof Exception) {
              final Exception ex = (Exception)_t;
              QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(svc);
              String _string = _fullyQualifiedName.toString();
              String _plus_3 = ("Error generating contracts for service " + _string);
              String _plus_4 = (_plus_3 + " and version ");
              Version _version = svc.getVersion();
              String _version_1 = _version.getVersion();
              String _plus_5 = (_plus_4 + _version_1);
              String _plus_6 = (_plus_5 + "\n");
              this.log.log(Level.SEVERE, _plus_6, ex);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
        } else {
          AbstractServiceRef _serviceRef = specBindingDesc.getServiceRef();
          Service _service = _serviceRef.getService();
          QualifiedName _fullyQualifiedName_1 = this.nameProvider.getFullyQualifiedName(_service);
          String _string_1 = _fullyQualifiedName_1.toString();
          String _plus_7 = ("Error generating contracts for service " + _string_1);
          String _plus_8 = (_plus_7 + " and version ");
          AbstractServiceRef _serviceRef_1 = specBindingDesc.getServiceRef();
          Service _service_1 = _serviceRef_1.getService();
          Version _version_2 = _service_1.getVersion();
          String _version_3 = _version_2.getVersion();
          String _plus_9 = (_plus_8 + _version_3);
          String _plus_10 = (_plus_9 + " of module ");
          String _name_2 = module.getName();
          String _plus_11 = (_plus_10 + _name_2);
          String _plus_12 = (_plus_11 + ". Service could not be resolved for environment ");
          String _name_3 = targetEnvironment.getName();
          String _plus_13 = (_plus_12 + _name_3);
          this.log.severe(_plus_13);
        }
      }
    }
  }
  
  protected void doBuildServiceContracts(final ServiceRefBindingDescription serviceBindingDescription, final SOAProfile profile) {
    AbstractServiceRef _serviceRef = serviceBindingDescription.getServiceRef();
    final Service service = _serviceRef.getService();
    final Binding specBinding = serviceBindingDescription.getApplicableBinding();
    EList<BindingProtocol> _protocol = specBinding.getProtocol();
    final Function1<BindingProtocol,Boolean> _function = new Function1<BindingProtocol,Boolean>() {
        public Boolean apply(final BindingProtocol p) {
          return Boolean.valueOf((p instanceof SOAP));
        }
      };
    Iterable<BindingProtocol> _filter = IterableExtensions.<BindingProtocol>filter(_protocol, _function);
    final Function1<BindingProtocol,SOAP> _function_1 = new Function1<BindingProtocol,SOAP>() {
        public SOAP apply(final BindingProtocol e) {
          return ((SOAP) e);
        }
      };
    Iterable<SOAP> _map = IterableExtensions.<BindingProtocol, SOAP>map(_filter, _function_1);
    for (final SOAP soapProt : _map) {
      try {
        boolean _and = false;
        String _providedContractUrl = service.getProvidedContractUrl();
        boolean _equals = Objects.equal(_providedContractUrl, null);
        if (!_equals) {
          _and = false;
        } else {
          Environment _resolveEnvironment = this._environmentBindingResolver.resolveEnvironment(specBinding);
          boolean _isEligibleForEnvironment = this._assetStateEnvironmentEligibilityChecker.isEligibleForEnvironment(service, _resolveEnvironment);
          _and = (_equals && _isEligibleForEnvironment);
        }
        if (_and) {
          final SubNamespace namespace = this._namespaceQuery.findSubdomain(service);
          Environment _resolveEnvironment_1 = this._environmentBindingResolver.resolveEnvironment(specBinding);
          Lifecycle _lifecycle = profile.getLifecycle();
          final LifecycleState minState = this.lifecycleQueries.getMinLifecycleState(_resolveEnvironment_1, _lifecycle);
          String _registryBaseUrl = this._bindingExtensions.getRegistryBaseUrl(specBinding);
          this.wsdlGenerator.toWSDL(service, namespace, minState, profile, _registryBaseUrl);
          this.concreteWsdlGenerator.toWSDL(specBinding, service, soapProt, profile);
          boolean _not = (!this.noDependencies);
          if (_not) {
            final Set<VersionedDomainNamespace> verNamespaces = this._namespaceImportQueries.importedVersionedNS(service, minState);
            final Procedure1<VersionedDomainNamespace> _function_2 = new Procedure1<VersionedDomainNamespace>() {
                public void apply(final VersionedDomainNamespace n) {
                  SOAPProtocolContractBuilder.this.xsdGenerator.toXSD(n, minState, specBinding, profile);
                }
              };
            IterableExtensions.<VersionedDomainNamespace>forEach(verNamespaces, _function_2);
            final MessageHeader requestHeader = this._headerFinder.findBestMatchingRequestHeader(service, profile);
            if ((this.forceRelativePaths).booleanValue()) {
              String _registryBaseUrl_1 = this._bindingExtensions.getRegistryBaseUrl(specBinding);
              this.msgHeaderGenerator.toMessageHeaderXSD(requestHeader, profile, _registryBaseUrl_1);
            } else {
              this.msgHeaderGenerator.toMessageHeaderXSD(requestHeader, profile);
            }
            final MessageHeader responseHeader = this._headerFinder.findBestMatchingRequestHeader(service, profile);
            if ((this.forceRelativePaths).booleanValue()) {
              String _registryBaseUrl_2 = this._bindingExtensions.getRegistryBaseUrl(specBinding);
              this.msgHeaderGenerator.toMessageHeaderXSD(responseHeader, profile, _registryBaseUrl_2);
            } else {
              this.msgHeaderGenerator.toMessageHeaderXSD(responseHeader, profile);
            }
          }
        }
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception ex = (Exception)_t;
          QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(service);
          String _string = _fullyQualifiedName.toString();
          String _plus = ("Error generating contracts for service " + _string);
          String _plus_1 = (_plus + " and version ");
          Version _version = service.getVersion();
          String _version_1 = _version.getVersion();
          String _plus_2 = (_plus_1 + _version_1);
          String _plus_3 = (_plus_2 + "\n");
          this.log.log(Level.SEVERE, _plus_3, ex);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
  }
  
  public void buildTypeDefinitions(final SubNamespace namespace, final Environment env, final SOAProfile profile) {
    QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(namespace);
    String _string = _fullyQualifiedName.toString();
    String _plus = ("Generating XSDs for namespace " + _string);
    this.log.fine(_plus);
    this.xsdGenerator.toXSD(namespace, env, profile);
  }
  
  public void buildTypeDefinitions(final VersionedDomainNamespace namespace, final Environment env, final SOAProfile profile) {
    String _fqn = namespace.getFqn();
    String _plus = ("Generating XSD for namespace " + _fqn);
    String _plus_1 = (_plus + " with major version ");
    String _version = namespace.getVersion();
    String _plus_2 = (_plus_1 + _version);
    this.log.fine(_plus_2);
    this.xsdGenerator.toXSD(namespace, env, profile);
  }
}
