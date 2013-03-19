package org.fornax.soa.bindingdsl.generator.sca;

import com.google.common.base.Objects;
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
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.basedsl.search.IEObjectLookup;
import org.fornax.soa.basedsl.search.IPredicateSearch;
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver;
import org.fornax.soa.bindingDsl.Binding;
import org.fornax.soa.bindingDsl.BindingModel;
import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.bindingDsl.ModuleRef;
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions;
import org.fornax.soa.bindingdsl.generator.templates.vendor.ibm.SCAExportExtension;
import org.fornax.soa.bindingdsl.generator.templates.vendor.ibm.SCAExportTemplates;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.moduledsl.moduleDsl.AssemblyType;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;

@SuppressWarnings("all")
public class IBMScaExportsGenerator implements IGenerator {
  @Inject
  private SCAExportTemplates scaExportTpl;
  
  @Inject
  private SCAExportExtension scaExportExt;
  
  @Inject
  private BindingExtensions bindingExt;
  
  @Inject
  @Named(value = "profileName")
  private String profileName;
  
  @Inject
  @Named(value = "moduleBindingNames")
  private List<String> moduleBindingNames;
  
  @Inject
  @Named(value = "domainBindingNames")
  private List<String> domainBindingNames;
  
  @Inject
  @Named(value = "namespaces")
  private List<String> namespaces;
  
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
  private EnvironmentBindingResolver _environmentBindingResolver;
  
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
      this.logger.severe("No profileName has been supplied to the Generator. Please proved the name an architecture profile to be applied.");
      hasValidParameters = false;
    }
    final SOAProfile profile = this.eObjectLookup.<SOAProfile>getModelElementByName(this.profileName, resource, "SOAProfile");
    boolean _equals_4 = Objects.equal(profile, null);
    if (_equals_4) {
      String _plus = ("No profile found mathing the name " + this.profileName);
      this.logger.severe(_plus);
      hasValidParameters = false;
    }
    EList<EObject> _contents = resource.getContents();
    final EObject contentRoot = IterableExtensions.<EObject>head(_contents);
    if ((contentRoot instanceof BindingModel)) {
      EList<EObject> _contents_1 = resource.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents_1);
      BindingModel model = ((BindingModel) _head);
      EList<Binding> _bindings = model.getBindings();
      for (final Binding binding : _bindings) {
        if ((binding instanceof ModuleBinding)) {
          final ModuleBinding modBind = ((ModuleBinding) binding);
          ModuleRef _module = modBind.getModule();
          final Module module = _module.getModule();
          final AssemblyType assemblyType = module.getAssemblyType();
          boolean _and = false;
          Environment _resolveEnvironment = this._environmentBindingResolver.resolveEnvironment(modBind);
          String _name = _resolveEnvironment.getName();
          boolean _matches = Pattern.matches(this.targetEnvironmentName, _name);
          if (!_matches) {
            _and = false;
          } else {
            boolean _equals_5 = Objects.equal(assemblyType, AssemblyType.SCA_EAR);
            _and = (_matches && _equals_5);
          }
          if (_and) {
            final Function1<String,Boolean> _function = new Function1<String,Boolean>() {
                public Boolean apply(final String bindName) {
                  String _name = modBind.getName();
                  boolean _matches = Pattern.matches(bindName, _name);
                  return Boolean.valueOf(_matches);
                }
              };
            boolean _exists = IterableExtensions.<String>exists(this.moduleBindingNames, _function);
            if (_exists) {
              this.compile(modBind, resource);
            }
          }
        }
      }
    }
  }
  
  protected void _compile(final ModuleBinding binding, final Resource res) {
    final SOAProfile profile = this.eObjectLookup.<SOAProfile>getModelElementByName(this.profileName, res, "SOAProfile");
    this.scaExportTpl.toSCAModuleExport(binding, profile);
  }
  
  protected void compile(final ModuleBinding binding, final Resource res) {
    {
      _compile(binding, res);
      return;
    }
  }
}
