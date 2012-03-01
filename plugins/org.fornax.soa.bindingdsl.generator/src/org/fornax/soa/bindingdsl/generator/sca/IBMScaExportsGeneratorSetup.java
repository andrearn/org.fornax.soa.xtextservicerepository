package org.fornax.soa.bindingdsl.generator.sca;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.util.Modules2;
import org.fornax.soa.basedsl.generator.BaseDslGeneratorModule;
import org.fornax.soa.bindingdsl.generator.BindingDSLGeneratorConstants;
import org.fornax.soa.bindingdsl.generator.BindingDslGeneratorModule;
import org.fornax.soa.environmentdsl.generator.EnvironmentDslGeneratorModule;
import org.fornax.soa.moduledsl.generator.ModuleDslGeneratorModule;
import org.fornax.soa.profiledsl.generator.ProfileDslGeneratorModule;
import org.fornax.soa.profiledsl.generator.ProfileGeneratorConstants;
import org.fornax.soa.servicedsl.generator.ServiceDslGeneratorModule;
import org.fornax.soa.xtextservicerepo.generator.XtextServiceRepositoryGeneratorConstants;
import org.fornax.soa.xtextservicerepo.generator.XtextServiceRepositoryGeneratorModule;

import com.google.common.collect.Maps;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

public class IBMScaExportsGeneratorSetup implements ISetup {

	private String profileName;
	private List<String> moduleBindingNames = new ArrayList<String>();
	private Boolean noDependencies = false;
	private Boolean includeSubNamespaces = false;
	private Boolean useNestedPaths = false;
	private Boolean forceRelativePaths = false;
	private String targetEnvironmentName;

	@Override
	public Injector createInjectorAndDoEMFRegistration () {
		if (targetEnvironmentName == null)
			targetEnvironmentName = ".*";
		Injector injector = Guice.createInjector (Modules2.mixin (
				new BaseDslGeneratorModule (),
				new ServiceDslGeneratorModule (),
				new EnvironmentDslGeneratorModule (),
				new ModuleDslGeneratorModule (),
				new ProfileDslGeneratorModule (), 
				new BindingDslGeneratorModule (),
				new XtextServiceRepositoryGeneratorModule (),
				
				new AbstractModule () {

					@Override
					protected void configure () {
						bind (IGenerator.class).to (
								IBMScaExportsGenerator.class);

						bind (Boolean.class)
								.annotatedWith (
										Names.named (XtextServiceRepositoryGeneratorConstants.FORCE_RELATIVE_PATHS))
								.toInstance (forceRelativePaths);
						bind (Boolean.class)
								.annotatedWith (
										Names.named (XtextServiceRepositoryGeneratorConstants.USE_NESTED_PATHS))
								.toInstance (useNestedPaths);
						bind (String.class)
								.annotatedWith (
										Names.named (ProfileGeneratorConstants.PROFILE_NAME))
								.toInstance (profileName);
						bind (new TypeLiteral<List<String>>() {})
								.annotatedWith (
										Names.named (BindingDSLGeneratorConstants.MODULE_BINDING_NAMES))
								.toInstance (moduleBindingNames);
						bind (Boolean.class)
								.annotatedWith (
										Names.named (BindingDSLGeneratorConstants.NO_DEPENDENCIES))
								.toInstance (noDependencies);
						bind (Boolean.class)
								.annotatedWith (
										Names.named (BindingDSLGeneratorConstants.INCLUDE_SUB_NAMESPACES))
								.toInstance (includeSubNamespaces);
						bind (String.class)
								.annotatedWith (
										Names.named (BindingDSLGeneratorConstants.TARGET_ENVIRONMENT_NAME))
								.toInstance (getTargetEnvironmentName ());

						JavaIoFileSystemAccess fileSystemAccess = new JavaIoFileSystemAccess ();
						OutputConfiguration out = new OutputConfiguration ("DEFAULT_OUTPUT");
						Map<String, OutputConfiguration> outputs = Maps.newHashMap ();
						outputs.put ("DEFAULT_OUTPUT", out);
						fileSystemAccess.setOutputConfigurations (outputs);

						bind (IFileSystemAccess.class).toInstance (fileSystemAccess);
						bind (JavaIoFileSystemAccess.class).toInstance (fileSystemAccess);
					}

				}));

		return injector;
	}

	public String getProfileName () {
		return profileName;
	}

	public void setProfileName (String profileName) {
		this.profileName = profileName;
	}

	public List<String> getModuleBindingNames () {
		return moduleBindingNames;
	}

	public void addModuleBindingName (String moduleBindingName) {
		this.moduleBindingNames.add (moduleBindingName);
	}

	public Boolean getNoDependencies () {
		return noDependencies;
	}

	public void setNoDependencies (Boolean noDependencies) {
		this.noDependencies = noDependencies;
	}

	public Boolean getIncludeSubNamespaces () {
		return includeSubNamespaces;
	}

	public void setIncludeSubNamespaces (Boolean includeSubNamespaces) {
		this.includeSubNamespaces = includeSubNamespaces;
	}

	
	public Boolean getUseNestedPaths () {
		return useNestedPaths;
	}

	public void setUseNestedPaths (Boolean useNestedPaths) {
		this.useNestedPaths = useNestedPaths;
	}

	public Boolean getForceRelativePaths () {
		return forceRelativePaths;
	}

	public void setForceRelativePaths (Boolean forceRelativePaths) {
		this.forceRelativePaths = forceRelativePaths;
	}

	public void setTargetEnvironmentName (String environmentName) {
		this.targetEnvironmentName = environmentName;
	}

	public String getTargetEnvironmentName () {
		return targetEnvironmentName;
	}

}
