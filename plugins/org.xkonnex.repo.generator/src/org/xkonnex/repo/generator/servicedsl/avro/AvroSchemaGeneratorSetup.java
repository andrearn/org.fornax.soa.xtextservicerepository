package org.xkonnex.repo.generator.servicedsl.avro;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator2;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.util.Modules2;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.ILifecycleStateResolver;
import org.xkonnex.repo.dsl.profiledsl.state.DefaultStateResolver;
import org.xkonnex.repo.generator.basedsl.BaseDslGeneratorModule;
import org.xkonnex.repo.generator.core.XSRGeneratorConstants;
import org.xkonnex.repo.generator.core.XSRGeneratorModule;
import org.xkonnex.repo.generator.profiledsl.ProfileDslGeneratorModule;
import org.xkonnex.repo.generator.servicedsl.ServiceDslGeneratorModule;
import org.xkonnex.repo.generator.servicedsl.VersionedTypeDescriptor;

import com.google.common.collect.Maps;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

public class AvroSchemaGeneratorSetup implements ISetup {

	public final static String NAME_SPACES = "namespaces";
	public final static String DOMAIN_NAME_SPACES = "domainNamespaces";
	public final static String INTERNAL_NAME_SPACES = "internalNamespaces";
	public final static String NO_DEPENDENCIES = "noDependencies";
	public final static String INCLUDE_SUB_NAMESPACES = "includeSubNamespaces";
	public final static String TARGET_ENVIRONMENT_NAME = "targetEnvironmentName";
	public final static String PROFILE_NAME = "profileName";

	private String profileName = "";
	private String registryUrl = "";
	private List<VersionedTypeDescriptor> versionedTypes = new ArrayList<VersionedTypeDescriptor>();
	private List<String> namespaces = new ArrayList<String>();
	private List<String> domainNamespaces = new ArrayList<String>();
	private List<String> internalNamespaces = new ArrayList<String>();
	private Boolean noDependencies = false;
	private Boolean includeSubNamespaces = false;
	private Boolean useNestedPaths = false;
	private Boolean useRegistryBasedFilePaths = false;

	@Override
	public Injector createInjectorAndDoEMFRegistration() {
		Injector injector = Guice.createInjector (Modules2.mixin (
				new BaseDslGeneratorModule (),
				new ServiceDslGeneratorModule (),
				new ProfileDslGeneratorModule (), 
				new XSRGeneratorModule (),
				
				new AbstractModule () {

					@Override
					protected void configure() {
						bind (IGenerator2.class).to (
							AvroSchemaGenerator.class);

						bind (Boolean.class)
							.annotatedWith (
								Names.named (XSRGeneratorConstants.USE_REGISTRY_BASED_FILE_PATHS))
							.toInstance (useRegistryBasedFilePaths);
						bind (Boolean.class)
							.annotatedWith (
								Names.named (XSRGeneratorConstants.USE_NESTED_PATHS))
							.toInstance (useNestedPaths);

						bind (new TypeLiteral<List<VersionedTypeDescriptor>>() {})
							.annotatedWith (
								Names.named ("versionedTypes"))
							.toInstance (versionedTypes);
						bind (new TypeLiteral<List<String>>() {})
							.annotatedWith (
								Names.named (NAME_SPACES))
							.toInstance (namespaces);
						bind (new TypeLiteral<List<String>>() {})
							.annotatedWith (
								Names.named (DOMAIN_NAME_SPACES))
							.toInstance (getDomainNamespaces());
						bind (new TypeLiteral<List<String>>() {})
							.annotatedWith (
								Names.named (INTERNAL_NAME_SPACES))
							.toInstance (getInternalNamespaces());
						bind (Boolean.class)
							.annotatedWith (
								Names.named (NO_DEPENDENCIES))
							.toInstance (noDependencies);
						bind (Boolean.class)
							.annotatedWith (
								Names.named (INCLUDE_SUB_NAMESPACES))
							.toInstance (includeSubNamespaces);
						bind (String.class)
							.annotatedWith (Names.named (PROFILE_NAME)).toInstance (getProfileName ());
						bind (String.class)
							.annotatedWith(Names.named("registryUrl")).toInstance(getRegistryUrl());

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
	
	public void addVersionedType(VersionedTypeDescriptor versionedType) {
		getVersionedTypes().add(versionedType);
	}
	
	public List<VersionedTypeDescriptor> getVersionedTypes() {
		return versionedTypes;
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

	public String getRegistryUrl() {
		return registryUrl;
	}

	public void setRegistryUrl(String registryUrl) {
		this.registryUrl = registryUrl;
	}

}
