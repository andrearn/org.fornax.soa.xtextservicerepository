package org.xkonnex.repo.generator.bindingdsl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.util.Modules2;
import org.xkonnex.repo.generator.moduledsl.ModuleDslGeneratorModule;
import org.xkonnex.repo.generator.moduledsl.VersionedModuleSelector;
import org.xkonnex.repo.generator.profiledsl.ProfileDslGeneratorModule;
import org.xkonnex.repo.generator.profiledsl.ProfileGeneratorConstants;
import org.xkonnex.repo.generator.core.XSRGeneratorConstants;
import org.xkonnex.repo.generator.core.XSRGeneratorModule;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.ILifecycleStateResolver;
import org.xkonnex.repo.dsl.profiledsl.state.DefaultStateResolver;
import org.xkonnex.repo.generator.environmentdsl.EnvironmentDslGeneratorModule;
import org.xkonnex.repo.generator.basedsl.BaseDslGeneratorModule;
import org.xkonnex.repo.generator.bindingdsl.templates.IProtocolContractBuilder;
import org.xkonnex.repo.generator.servicedsl.ServiceDslGeneratorModule;

import com.google.common.collect.Maps;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

public class DefaultBindingContractGeneratorSetup implements ISetup {

	private String profileName = "";
	private List<String> moduleBindingNames = new ArrayList<String>();
	private List<VersionedModuleSelector> modules = new ArrayList<VersionedModuleSelector>();
	private List<ModuleBindingSelector> moduleBindings = new ArrayList<ModuleBindingSelector>();
	private List<String> namespaces = new ArrayList<String>();
	private List<String> domainNamespaces = new ArrayList<String>();
	private List<String> internalNamespaces = new ArrayList<String>();
	private Boolean noDependencies = false;
	private Boolean includeSubNamespaces = false;
	private Boolean useNestedPaths = false;
	private Boolean useRegistryBasedFilePaths = false;
	private String targetEnvironmentName = "*";
	private Boolean ignoreEndpointQualifierNames = false;

	public Injector createInjectorAndDoEMFRegistration() {
		Injector injector = Guice.createInjector (Modules2.mixin (
				new BaseDslGeneratorModule (),
				new ServiceDslGeneratorModule (),
				new EnvironmentDslGeneratorModule (),
				new ModuleDslGeneratorModule (),
				new ProfileDslGeneratorModule (), 
				new BindingDslGeneratorModule (),
				new XSRGeneratorModule (),
				
				new AbstractModule () {

					@Override
					protected void configure () {
						bind (IGenerator.class).to (
								DefaultBindingContractGenerators.class);

						bind (Boolean.class)
								.annotatedWith (
										Names.named (XSRGeneratorConstants.USE_REGISTRY_BASED_FILE_PATHS))
								.toInstance (useRegistryBasedFilePaths);
						bind (Boolean.class)
								.annotatedWith (
										Names.named (XSRGeneratorConstants.USE_NESTED_PATHS))
								.toInstance (useNestedPaths);

						bind (new TypeLiteral<List<String>>() {})
								.annotatedWith (
										Names.named (BindingDSLGeneratorConstants.MODULE_BINDING_NAMES))
								.toInstance (moduleBindingNames);
						bind (new TypeLiteral<List<ModuleBindingSelector>>() {})
							.annotatedWith (
								Names.named (BindingDSLGeneratorConstants.MODULE_BINDINGS))
							.toInstance (getModuleBindings());
						bind (new TypeLiteral<List<VersionedModuleSelector>>() {})
							.annotatedWith (
								Names.named (BindingDSLGeneratorConstants.MODULES))
							.toInstance (modules);
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
						bind (Boolean.class)
							.annotatedWith (
								Names.named (BindingDSLGeneratorConstants.IGNORE_ENDPOINT_QUALIFIER_NAMES))
							.toInstance (ignoreEndpointQualifierNames);

						JavaIoFileSystemAccess fileSystemAccess = new JavaIoFileSystemAccess ();
						OutputConfiguration out = new OutputConfiguration ("DEFAULT_OUTPUT");
						Map<String, OutputConfiguration> outputs = Maps.newHashMap ();
						outputs.put ("DEFAULT_OUTPUT", out);
						fileSystemAccess.setOutputConfigurations (outputs);

						bind (IFileSystemAccess.class).toInstance (fileSystemAccess);
						bind (JavaIoFileSystemAccess.class).toInstance (fileSystemAccess);
						bind (ILifecycleStateResolver.class).to(DefaultStateResolver.class);
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

	public List<VersionedModuleSelector> getServiceModules () {
		return modules;
	}

	public void addServiceModule (VersionedModuleSelector module) {
		modules.add (module);
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



	public Boolean getUseRegistryBasedFilePaths () {
		return useRegistryBasedFilePaths;
	}



	public void setUseRegistryBasedFilePaths (Boolean useRegistryBasedFilePaths) {
		this.useRegistryBasedFilePaths = useRegistryBasedFilePaths;
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


	public Boolean getIgnoreEndpointQualifierNames() {
		return ignoreEndpointQualifierNames;
	}


	public void setIgnoreEndpointQualifierNames(
			Boolean ignoreEndpointQualifierNames) {
		this.ignoreEndpointQualifierNames = ignoreEndpointQualifierNames;
	}


	public List<ModuleBindingSelector> getModuleBindings() {
		return moduleBindings;
	}


	public void addModuleBindings(ModuleBindingSelector moduleBinding) {
		this.moduleBindings.add (moduleBinding);
	}

}
