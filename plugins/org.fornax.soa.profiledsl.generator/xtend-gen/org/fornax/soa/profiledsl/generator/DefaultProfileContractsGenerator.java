package org.fornax.soa.profiledsl.generator;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.regex.Pattern;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.fornax.soa.profiledsl.generator.templates.MessageHeaderXSDTemplates;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfileModel;

@SuppressWarnings("all")
public class DefaultProfileContractsGenerator implements IGenerator {
  @Inject
  @Named(value = "profileName")
  private String profileName;
  
  @Inject
  private ResourceSetBasedResourceDescriptions resourceDescriptions;
  
  @Inject
  private MessageHeaderXSDTemplates msgHeaderTpl;
  
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    ResourceSet resourceSet = resource.getResourceSet();
    this.resourceDescriptions.setContext(resourceSet);
    EList<EObject> _contents = resource.getContents();
    final EObject contentRoot = IterableExtensions.<EObject>head(_contents);
    if ((contentRoot instanceof SOAProfileModel)) {
      final SOAProfileModel profileModel = ((SOAProfileModel) contentRoot);
      EList<SOAProfile> _profiles = profileModel.getProfiles();
      final Function1<SOAProfile,Boolean> _function = new Function1<SOAProfile,Boolean>() {
          public Boolean apply(final SOAProfile p) {
            String _name = p.getName();
            boolean _matches = Pattern.matches(DefaultProfileContractsGenerator.this.profileName, _name);
            return Boolean.valueOf(_matches);
          }
        };
      Iterable<SOAProfile> _filter = IterableExtensions.<SOAProfile>filter(_profiles, _function);
      final Procedure1<SOAProfile> _function_1 = new Procedure1<SOAProfile>() {
          public void apply(final SOAProfile e) {
            DefaultProfileContractsGenerator.this.compile(e, resource);
          }
        };
      IterableExtensions.<SOAProfile>forEach(_filter, _function_1);
    }
  }
  
  protected void compile(final SOAProfile profile, final Resource res) {
    this.msgHeaderTpl.toMessageHeaderXSD(profile);
  }
}
