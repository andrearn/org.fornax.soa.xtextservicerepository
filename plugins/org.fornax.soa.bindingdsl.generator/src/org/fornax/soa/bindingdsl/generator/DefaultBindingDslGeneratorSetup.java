package org.fornax.soa.bindingdsl.generator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.Modules2;
import org.fornax.soa.basedsl.generator.BaseDslGeneratorModule;
import org.fornax.soa.environmentdsl.generator.EnvironmentDslGeneratorModule;
import org.fornax.soa.moduledsl.generator.ModuleDslGeneratorModule;
import org.fornax.soa.profiledsl.generator.ProfileDslGeneratorModule;
import org.fornax.soa.servicedsl.generator.ServiceDSLGeneratorConstants;
import org.fornax.soa.servicedsl.generator.ServiceDslGeneratorModule;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

public class DefaultBindingDslGeneratorSetup implements ISetup {

	private String profileName;
	private List<String> moduleBindingNames = new ArrayList<String>();
	private List<String> domainBindingNames = new ArrayList<String>();
	private List<String> namespaces = new ArrayList<String>();
	private Boolean noDependencies;
	private Boolean includeSubNamespaces;
	private Boolean useNestedPaths;
	private Boolean forceRelativePaths;
	private Boolean generatePrivateWsdlForProviderHost;

	public Injector createInjectorAndDoEMFRegistration() {
		Injector injector = Guice.createInjector (Modules2.mixin (
				new BaseDslGeneratorModule (),
				new ServiceDslGeneratorModule (),
				new EnvironmentDslGeneratorModule (),
				new ModuleDslGeneratorModule (),
				new ProfileDslGeneratorModule (), 
				new BindingDslGeneratorModule (),
				
				new AbstractModule () {

					@Override
					protected void configure () {
						bind (IGenerator.class).to (
								DefaultBindingDslContractGenerators.class);

						bind (Boolean.class)
								.annotatedWith (
										Names.named (ServiceDSLGeneratorConstants.FORCE_RELATIVE_PATHS))
								.toInstance (forceRelativePaths);
						bind (Boolean.class)
								.annotatedWith (
										Names.named (ServiceDSLGeneratorConstants.USE_NESTED_PATHS))
								.toInstance (useNestedPaths);
						bind (Boolean.class)
								.annotatedWith (
										Names.named (BindingDSLGeneratorConstants.GENERATE_PRIVATE_WSDL_FOR_PROVIDER_HOST))
								.toInstance (generatePrivateWsdlForProviderHost);

						bind (String.class)
								.annotatedWith (
										Names.named (BindingDSLGeneratorConstants.PROFILE_NAME))
								.toInstance (profileName);
						bind (new TypeLiteral<List<String>>() {})
								.annotatedWith (
										Names.named (BindingDSLGeneratorConstants.MODULE_BINDING_NAMES))
								.toInstance (moduleBindingNames);
						bind (new TypeLiteral<List<String>>() {})
								.annotatedWith (
										Names.named (BindingDSLGeneratorConstants.DOMAIN_BINDING_NAMES))
								.toInstance (domainBindingNames);
						bind (new TypeLiteral<List<String>>() {})
								.annotatedWith (
										Names.named (BindingDSLGeneratorConstants.NAME_SPACES))
								.toInstance (namespaces);
						bind (Boolean.class)
								.annotatedWith (
										Names.named (BindingDSLGeneratorConstants.NO_DEPENDENCIES))
								.toInstance (noDependencies);
						bind (Boolean.class)
								.annotatedWith (
										Names.named (BindingDSLGeneratorConstants.INCLUDE_SUB_NAMESPACES))
								.toInstance (includeSubNamespaces);
						
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

	public void addModuleBindingNames (String moduleBindingName) {
		moduleBindingNames.add (moduleBindingName);
	}

	public List<String> getDomainBindingNames () {
		return domainBindingNames;
	}

	public void addDomainBindingNames (String domainBindingName) {
		domainBindingNames.add (domainBindingName);
	}

	public List<String> getNamespacesNames () {
		return namespaces;
	}

	public void addNamespaces (String namespaceName) {
		namespaces.add (namespaceName);
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



	public Boolean getGeneratePrivateWsdlForProviderHost () {
		return generatePrivateWsdlForProviderHost;
	}



	public void setGeneratePrivateWsdlForProviderHost (
			Boolean generatePrivateWsdlForProviderHost) {
		this.generatePrivateWsdlForProviderHost = generatePrivateWsdlForProviderHost;
	}

	public List<String> getNamespaces () {
		return namespaces;
	}

}
