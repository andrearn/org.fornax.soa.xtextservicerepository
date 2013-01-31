package org.fornax.soa.bindingdsl.generator;

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
import org.fornax.soa.environmentdsl.generator.EnvironmentDslGeneratorModule;
import org.fornax.soa.moduledsl.generator.ModuleDslGeneratorModule;
import org.fornax.soa.moduledsl.generator.VersionedModuleSelector;
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

public class DefaultBindingContractGeneratorSetup implements ISetup {

	private String profileName = ".*";
	private List<String> moduleBindingNames = new ArrayList<String>();
	private List<String> moduleNames = new ArrayList<String>();
	private List<VersionedModuleSelector> modules = new ArrayList<VersionedModuleSelector>();
	private List<String> domainBindingNames = new ArrayList<String>();
	private List<String> namespaces = new ArrayList<String>();
	private List<String> domainNamespaces = new ArrayList<String>();
	private List<String> internalNamespaces = new ArrayList<String>();
	private Boolean noDependencies = false;
	private Boolean includeSubNamespaces = false;
	private Boolean useNestedPaths = false;
	private Boolean forceRelativePaths = false;
	private String targetEnvironmentName = ".*";

	public Injector createInjectorAndDoEMFRegistration() {
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
								DefaultBindingContractGenerators.class);

						bind (Boolean.class)
								.annotatedWith (
										Names.named (XtextServiceRepositoryGeneratorConstants.FORCE_RELATIVE_PATHS))
								.toInstance (forceRelativePaths);
						bind (Boolean.class)
								.annotatedWith (
										Names.named (XtextServiceRepositoryGeneratorConstants.USE_NESTED_PATHS))
								.toInstance (useNestedPaths);

						bind (new TypeLiteral<List<String>>() {})
								.annotatedWith (
										Names.named (BindingDSLGeneratorConstants.MODULE_BINDING_NAMES))
								.toInstance (moduleBindingNames);
						bind (new TypeLiteral<List<VersionedModuleSelector>>() {})
								.annotatedWith (
										Names.named (BindingDSLGeneratorConstants.MODULES))
								.toInstance (modules);
						bind (new TypeLiteral<List<String>>() {})
								.annotatedWith (
										Names.named (BindingDSLGeneratorConstants.DOMAIN_BINDING_NAMES))
								.toInstance (domainBindingNames);
						bind (new TypeLiteral<List<String>>() {})
								.annotatedWith (
										Names.named (BindingDSLGeneratorConstants.NAME_SPACES))
								.toInstance (namespaces);
						bind (new TypeLiteral<List<String>>() {})
								.annotatedWith (
										Names.named (BindingDSLGeneratorConstants.DOMAIN_NAME_SPACES))
								.toInstance (getDomainNamespaces());
						bind (new TypeLiteral<List<String>>() {})
								.annotatedWith (
										Names.named (BindingDSLGeneratorConstants.INTERNAL_NAME_SPACES))
								.toInstance (getInternalNamespaces());
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
						bind (String.class)
							.annotatedWith (
								Names.named (BindingDSLGeneratorConstants.PROFILE_NAME))
							.toInstance (getProfileName ());

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
		moduleBindingNames.add (moduleBindingName);
	}

	public List<String> getModuleNames () {
		return moduleNames;
	}

	public void addModuleName (String moduleName) {
		moduleNames.add (moduleName);
	}

	public List<VersionedModuleSelector> getServiceModules () {
		return modules;
	}

	public void addServiceModule (VersionedModuleSelector module) {
		modules.add (module);
	}

	public List<String> getDomainBindingNames () {
		return domainBindingNames;
	}

	public void addDomainBindingName (String domainBindingName) {
		domainBindingNames.add (domainBindingName);
	}
	
	public void addNamespace (String namespaceName) {
		namespaces.add (namespaceName);
	}

	public List<String> getNamespaces () {
		return namespaces;
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


	public void addDomainNamespace(String domainNamespace) {
		this.domainNamespaces.add (domainNamespace);
	}


	public List<String> getDomainNamespaces() {
		return domainNamespaces;
	}


	public void addInternalNamespace(String internalNamespace) {
		this.internalNamespaces.add (internalNamespace);
	}


	public List<String> getInternalNamespaces() {
		return internalNamespaces;
	}

}
