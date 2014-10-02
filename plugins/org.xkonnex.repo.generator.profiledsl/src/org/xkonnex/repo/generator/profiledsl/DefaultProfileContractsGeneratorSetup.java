package org.xkonnex.repo.generator.profiledsl;

import java.util.Map;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.util.Modules2;
import org.xkonnex.repo.generator.core.XtextServiceRepositoryGeneratorConstants;
import org.xkonnex.repo.generator.core.XtextServiceRepositoryGeneratorModule;
import org.xkonnex.repo.generator.basedsl.BaseDslGeneratorModule;

import com.google.common.collect.Maps;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;

public class DefaultProfileContractsGeneratorSetup implements ISetup {

	private String profileName;
	private Boolean noDependencies = false;
	private Boolean useNestedPaths = false;
	private Boolean useRegistryBasedFilePaths = false;

	public Injector createInjectorAndDoEMFRegistration () {
		Injector injector = Guice.createInjector (Modules2.mixin (
				new BaseDslGeneratorModule (),
				new ProfileDslGeneratorModule (), 
				new XtextServiceRepositoryGeneratorModule (),
				
				new AbstractModule () {

					@Override
					protected void configure () {
						bind (IGenerator.class).to (
								DefaultProfileContractsGenerator.class);

						bind (Boolean.class)
								.annotatedWith (
										Names.named (XtextServiceRepositoryGeneratorConstants.USE_REGISTRY_BASED_FILE_PATHS))
								.toInstance (useRegistryBasedFilePaths);
						bind (Boolean.class)
								.annotatedWith (
										Names.named (XtextServiceRepositoryGeneratorConstants.USE_NESTED_PATHS))
								.toInstance (useNestedPaths);
						bind (String.class)
								.annotatedWith (
										Names.named (ProfileGeneratorConstants.PROFILE_NAME))
								.toInstance (profileName);
						
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

	public Boolean getNoDependencies () {
		return noDependencies;
	}

	public void setNoDependencies (Boolean noDependencies) {
		this.noDependencies = noDependencies;
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

}
