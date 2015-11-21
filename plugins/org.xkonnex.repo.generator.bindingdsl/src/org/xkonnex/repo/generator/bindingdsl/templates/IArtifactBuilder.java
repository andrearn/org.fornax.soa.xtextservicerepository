package org.xkonnex.repo.generator.bindingdsl.templates;

import java.util.List;

import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointQualifierRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.profiledsl.sOAProfileDsl.AbstractProfile;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace;

/**
 * A builder, that build technical artifacts from Bindings and Modules, such as technical contracts like WSDLs.
 * The builder delegate to 
 */
public interface IArtifactBuilder {

	public abstract void build(final ModuleBinding binding, final AbstractProfile profile);

	public abstract void build(final ModuleBinding binding, final AbstractProfile profile, final boolean noDeps,
			final boolean includeSubNamespaces);

	public abstract void build(final Module module, final Environment environment, final boolean selectTypeVersionsByEnvironment, final boolean generateProvidedServices,
			final boolean generateUsedServices, final EndpointQualifierRef endpointQualifierRef, final AbstractProfile enforcedProfile);

	public abstract void buildEvents(final SubNamespace ns, final List<Environment> environments, final String targetEnv,
			final AbstractProfile enforcedProfile);

	public abstract void buildEventsInclSubNamespaces(final String namespaceName, final List<SubNamespace> namespaces,
			final List<Environment> environments, final String targetEnv, final AbstractProfile enforcedProfile);

}
