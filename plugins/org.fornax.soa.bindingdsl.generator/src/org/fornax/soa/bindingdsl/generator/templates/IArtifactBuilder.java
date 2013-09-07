package org.fornax.soa.bindingdsl.generator.templates;

import java.util.List;

import org.fornax.soa.bindingDsl.ModuleBinding;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.moduledsl.moduleDsl.EndpointQualifierRef;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.serviceDsl.SubNamespace;

/**
 * A builder, that build technical artifacts from Bindings and Modules, such as technical contracts like WSDLs.
 * The builder delegate to 
 */
public interface IArtifactBuilder {

	public abstract void build(final ModuleBinding binding, final SOAProfile profile);

	public abstract void build(final ModuleBinding binding, final SOAProfile profile, final boolean noDeps,
			final boolean includeSubNamespaces);

	public abstract void build(final Module module, final Environment environment, final boolean selectTypeVersionsByEnvironment, final boolean generateProvidedServices,
			final boolean generateUsedServices, final EndpointQualifierRef endpointQualifierRef, final SOAProfile profile);

	public abstract void buildEvents(final SubNamespace ns, final List<Environment> environments, final String targetEnv,
			final List<SOAProfile> profiles, final String profileName);

	public abstract void buildEventsInclSubNamespaces(final String namespaceName, final List<SubNamespace> namespaces,
			final List<Environment> environments, final String targetEnv, final List<SOAProfile> profiles, final String profileName);

}
