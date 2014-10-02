package org.xkonnex.repo.generator.moduledsl;

import java.util.Set;

import javax.naming.NameParser;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.lib.FunctionExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.xkonnex.repo.dsl.basedsl.version.VersionComparator;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.LifecycleState;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.IStateMatcher;
import org.xkonnex.repo.dsl.moduledsl.query.ModuleLookup;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class VersionedModuleSelector {

	private String name;
	private String version;
	private boolean useOtherVersionIfNotInEnvironment;
	private boolean selectTypeVersionsByEnvironment;
	private boolean generateProvidedServices;
	private boolean generateUsedServices;
	private String endpointQualifier;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public boolean isUseOtherVersionIfNotInEnvironment() {
		return useOtherVersionIfNotInEnvironment;
	}

	public void setUseOtherVersionIfNotInEnvironment(
			boolean useOtherVersionIfNotInEnvironment) {
		this.useOtherVersionIfNotInEnvironment = useOtherVersionIfNotInEnvironment;
	}

	public boolean isSelectTypeVersionsByEnvironment() {
		return selectTypeVersionsByEnvironment;
	}

	public void setSelectTypeVersionsByEnvironment(
			boolean selectTypeVersionsByEnvironment) {
		this.selectTypeVersionsByEnvironment = selectTypeVersionsByEnvironment;
	}

	public boolean isGenerateProvidedServices() {
		return generateProvidedServices;
	}

	public void setGenerateProvidedServices(boolean generateProvidedServices) {
		this.generateProvidedServices = generateProvidedServices;
	}

	public boolean isGenerateUsedServices() {
		return generateUsedServices;
	}

	public void setGenerateUsedServices(boolean generateUsedServices) {
		this.generateUsedServices = generateUsedServices;
	}

	public String getEndpointQualifier() {
		return endpointQualifier;
	}

	public void setEndpointQualifier(String providerEndpointQualifier) {
		this.endpointQualifier = providerEndpointQualifier;
	}

	public boolean matches (final Module mod, final LifecycleState minState, final ModuleLookup modLookup, final IStateMatcher stateMatcher, final IQualifiedNameProvider qualifiedNameProvider) {
		boolean matchesQualifier = moduleMatchesQualifier(mod,
				qualifiedNameProvider);
		if (name.equals(qualifiedNameProvider.getFullyQualifiedName (mod).toString()) && matchesQualifier) {
			if (version != null
					&& version.equals(mod.getVersion().getVersion())
					&& stateMatcher.matches(minState, mod.getState())) {
				return true;
			} else if (version != null && !version.equals(mod.getVersion().getVersion()) 
					&& useOtherVersionIfNotInEnvironment
					&& stateMatcher.matches(minState, mod.getState())) {
				boolean hasExactModuleVersion = hasExactMatchingModule (
						minState, modLookup, stateMatcher,
						qualifiedNameProvider, mod.eResource().getResourceSet());
				if (!hasExactModuleVersion) {
					Module alternativeMatchingModule = findLatestMatchingModule (minState, modLookup, stateMatcher,
							qualifiedNameProvider, mod.eResource().getResourceSet());
					if (alternativeMatchingModule != null 
							&& mod.getVersion().getVersion().equals(alternativeMatchingModule.getVersion().getVersion())) {
						return true;
					}
				}
			} else if (((version == null || "".equals(version)) && stateMatcher.matches (minState, mod.getState()))) {
				return true;
			}
		}
		return false;
	}

	private boolean hasExactMatchingModule(
			final LifecycleState minState, final ModuleLookup modLookup,
			final IStateMatcher stateMatcher,
			final IQualifiedNameProvider qualifiedNameProvider, final ResourceSet resourceSet) {
		final String modVersion = version;
		Set<Module> moduleVersions = modLookup.findAllModuleVersionsByName(name, resourceSet);
		boolean hasExactModuleVersion = Iterables.any (moduleVersions, new Predicate<Module>(){

					public boolean apply(Module input) {
						return input.getVersion().getVersion()
								.equals(modVersion)
								&& stateMatcher.matches(minState,
										input.getState())
								&& moduleMatchesQualifier(input,
										qualifiedNameProvider);
					}
				});
		return hasExactModuleVersion;
	}
	
	private Module findLatestMatchingModule (
			final LifecycleState minState, final ModuleLookup modLookup,
			final IStateMatcher stateMatcher,
			final IQualifiedNameProvider qualifiedNameProvider, final ResourceSet resourceSet) {
		Set<Module> moduleVersions = modLookup.findAllModuleVersionsByName(name, resourceSet);
		Iterable<Module> matchingModuleVersions = Iterables.filter (moduleVersions, new Predicate<Module>(){

					public boolean apply(Module input) {
						return stateMatcher.matches(minState,
										input.getState())
								&& moduleMatchesQualifier(input,
										qualifiedNameProvider);
					}
				});
		Module latestMatchingModuleVersion = null;
		for (Module modVer : matchingModuleVersions) {
			if (latestMatchingModuleVersion == null) {
				latestMatchingModuleVersion = modVer;
			} else if (VersionComparator.compare(modVer.getVersion().getVersion(), latestMatchingModuleVersion.getVersion().getVersion()) > 0){
				latestMatchingModuleVersion = modVer;
			}
		}
		return latestMatchingModuleVersion;
	}

	private boolean moduleMatchesQualifier(final Module mod,
			final IQualifiedNameProvider qualifiedNameProvider) {
		boolean matchesQualifier = false;
		if (endpointQualifier != null && !"".equals(endpointQualifier)) {
			if (mod.getEndpointQualifierRef() != null
					&& endpointQualifier
							.equals(qualifiedNameProvider
									.getFullyQualifiedName(
											mod.getEndpointQualifierRef()
													.getEndpointQualifier())
									.toString())) {
				matchesQualifier = true;
			}
		} else {
			matchesQualifier = true;
		}
		return matchesQualifier;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VersionedModuleSelector other = (VersionedModuleSelector) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

}
