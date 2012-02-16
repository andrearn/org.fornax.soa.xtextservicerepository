package org.fornax.soa.bindingdsl.generator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.ISetup;
import org.fornax.soa.basedsl.generator.BaseDslGeneratorModule;
import org.fornax.soa.environmentdsl.generator.EnvironmentDslGeneratorModule;
import org.fornax.soa.moduledsl.generator.ModuleDslGeneratorModule;
import org.fornax.soa.profiledsl.generator.ProfileDslGeneratorModule;
import org.fornax.soa.servicedsl.generator.ServiceDslGeneratorModule;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class DefaultBindingDslGeneratorSetup implements ISetup {
	
	private String profileName;
	private List<String> moduleBindingNames = new ArrayList<String>();
	private List<String> namespacesNames = new ArrayList<String>();
	private Boolean noDependencies;
	private Boolean includeSubNamespaces;

	public Injector createInjectorAndDoEMFRegistration() {
		Injector injector = Guice.createInjector(new BaseDslGeneratorModule(), 
				new ServiceDslGeneratorModule(), 
				new BindingDslGeneratorModule(), 
				new EnvironmentDslGeneratorModule(),
				new ModuleDslGeneratorModule(),
				new ProfileDslGeneratorModule());
		
		return injector;
	}
	
	
	
	
	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public List<String> getModuleBindingNames() {
		return moduleBindingNames;
	}

	public void setModuleBindingNames(List<String> moduleBindingNames) {
		this.moduleBindingNames = moduleBindingNames;
	}

	public void addModuleBindingNames(String moduleBindingName) {
		moduleBindingNames.add (moduleBindingName);
	}
	
	public List<String> getNamespacesNames() {
		return namespacesNames;
	}

	public void setNamespacesNames(List<String> namespacesNames) {
		this.namespacesNames = namespacesNames;
	}

	public void addNamespacesNames(String namespaceName) {
		namespacesNames.add (namespaceName);
	}
	public Boolean getNoDependencies() {
		return noDependencies;
	}

	public void setNoDependencies(Boolean noDependencies) {
		this.noDependencies = noDependencies;
	}

	public Boolean getIncludeSubNamespaces() {
		return includeSubNamespaces;
	}

	public void setIncludeSubNamespaces(Boolean includeSubNamespaces) {
		this.includeSubNamespaces = includeSubNamespaces;
	}


}
