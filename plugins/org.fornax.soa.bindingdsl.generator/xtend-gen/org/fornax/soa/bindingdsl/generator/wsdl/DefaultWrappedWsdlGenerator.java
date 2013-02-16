package org.fornax.soa.bindingdsl.generator.wsdl;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.fornax.soa.basedsl.search.IEObjectLookup;
import org.fornax.soa.basedsl.search.IPredicateSearch;
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions;
import org.fornax.soa.bindingdsl.generator.templates.wsdl.WrappedWSDLTemplates;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.serviceDsl.DomainNamespace;
import org.fornax.soa.serviceDsl.InternalNamespace;
import org.fornax.soa.serviceDsl.OrganizationNamespace;
import org.fornax.soa.serviceDsl.ServiceModel;
import org.fornax.soa.serviceDsl.SubNamespace;

@SuppressWarnings("all")
public class DefaultWrappedWsdlGenerator implements IGenerator {
  @Inject
  private WrappedWSDLTemplates wsdlTpl;
  
  @Inject
  private BindingExtensions bindingExt;
  
  @Inject
  @Named(value = "profileName")
  private String profileName;
  
  @Inject
  @Named(value = "namespaces")
  private List<String> namespaces;
  
  @Inject
  @Named(value = "domainNamespaces")
  private List<String> domainNamespaces;
  
  @Inject
  @Named(value = "internalNamespaces")
  private List<String> internalNamespaces;
  
  @Inject
  @Named(value = "noDependencies")
  private Boolean noDependencies;
  
  @Inject
  @Named(value = "includeSubNamespaces")
  private Boolean includeSubNamespaces;
  
  @Inject
  @Named(value = "targetEnvironmentName")
  private String targetEnvironmentName;
  
  @Inject
  private IPredicateSearch searchEngine;
  
  @Inject
  private ResourceSetBasedResourceDescriptions resourceDescriptions;
  
  @Inject
  private IQualifiedNameProvider nameProvider;
  
  @Inject
  private IEObjectLookup eObjectLookup;
  
  @Inject
  private Logger logger;
  
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    ResourceSet resourceSet = resource.getResourceSet();
    this.resourceDescriptions.setContext(resourceSet);
    boolean hasValidParameters = true;
    boolean _or = false;
    boolean _equals = Objects.equal(this.targetEnvironmentName, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _equals_1 = "".equals(this.targetEnvironmentName);
      _or = (_equals || _equals_1);
    }
    if (_or) {
      this.logger.severe("No targetEnvironmentName has been supplied to the Generator. Please provide the name of the environment to generate contracts for.");
      hasValidParameters = false;
    }
    boolean _or_1 = false;
    boolean _equals_2 = Objects.equal(this.profileName, null);
    if (_equals_2) {
      _or_1 = true;
    } else {
      boolean _equals_3 = "".equals(this.profileName);
      _or_1 = (_equals_2 || _equals_3);
    }
    if (_or_1) {
      this.logger.severe("No profileName has been supplied to the Generator. Please proved the name of an architecture profile to be applied.");
      hasValidParameters = false;
    }
    final SOAProfile profile = this.eObjectLookup.<SOAProfile>getModelElementByName(this.profileName, resource, "SOAProfile");
    boolean _equals_4 = Objects.equal(profile, null);
    if (_equals_4) {
      String _plus = ("No profile found matching the name " + this.profileName);
      this.logger.severe(_plus);
      hasValidParameters = false;
    }
    if (hasValidParameters) {
      EList<EObject> _contents = resource.getContents();
      final EObject contentRoot = IterableExtensions.<EObject>head(_contents);
      if ((contentRoot instanceof ServiceModel)) {
        final ServiceModel svcModel = ((ServiceModel) contentRoot);
        EList<OrganizationNamespace> _orgNamespaces = svcModel.getOrgNamespaces();
        final Function1<OrganizationNamespace,EList<SubNamespace>> _function = new Function1<OrganizationNamespace,EList<SubNamespace>>() {
            public EList<SubNamespace> apply(final OrganizationNamespace ons) {
              EList<SubNamespace> _subNamespaces = ons.getSubNamespaces();
              return _subNamespaces;
            }
          };
        List<EList<SubNamespace>> _map = ListExtensions.<OrganizationNamespace, EList<SubNamespace>>map(_orgNamespaces, _function);
        final Iterable<? extends SubNamespace> subNamespaces = Iterables.<SubNamespace>concat(_map);
        for (final SubNamespace ns : subNamespaces) {
          for (final String nsName : this.namespaces) {
            QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(ns);
            String _string = _fullyQualifiedName.toString();
            boolean _matches = Pattern.matches(nsName, _string);
            if (_matches) {
              this.compile(((SubNamespace) ns), resource);
            }
          }
        }
        Iterable<DomainNamespace> _filter = Iterables.<DomainNamespace>filter(subNamespaces, DomainNamespace.class);
        for (final DomainNamespace ns_1 : _filter) {
          for (final String nsName_1 : this.domainNamespaces) {
            QualifiedName _fullyQualifiedName_1 = this.nameProvider.getFullyQualifiedName(ns_1);
            String _string_1 = _fullyQualifiedName_1.toString();
            boolean _matches_1 = Pattern.matches(nsName_1, _string_1);
            if (_matches_1) {
              this.compile(((SubNamespace) ns_1), resource);
            }
          }
        }
        Iterable<InternalNamespace> _filter_1 = Iterables.<InternalNamespace>filter(subNamespaces, InternalNamespace.class);
        for (final InternalNamespace ns_2 : _filter_1) {
          for (final String nsName_2 : this.internalNamespaces) {
            QualifiedName _fullyQualifiedName_2 = this.nameProvider.getFullyQualifiedName(ns_2);
            String _string_2 = _fullyQualifiedName_2.toString();
            boolean _matches_2 = Pattern.matches(nsName_2, _string_2);
            if (_matches_2) {
              this.compile(((SubNamespace) ns_2), resource);
            }
          }
        }
      }
    }
  }
  
  protected void _compile(final SubNamespace namespace, final Resource res) {
    final SOAProfile profile = this.eObjectLookup.<SOAProfile>getModelElementByName(this.profileName, res, "SOAProfile");
    final Environment env = this.eObjectLookup.<Environment>getModelElementByName(this.targetEnvironmentName, res, "Environment");
    this.wsdlTpl.toWrappedWSDL(namespace, profile, env);
  }
  
  protected void compile(final SubNamespace namespace, final Resource res) {
    {
      _compile(namespace, res);
      return;
    }
  }
}
