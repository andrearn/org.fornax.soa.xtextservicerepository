package org.xkonnex.repo.dsl.bindingdsl.binding.query;

import java.util.Set;

import org.xkonnex.repo.dsl.bindingdsl.binding.query.services.ServiceRefBindingDescription;
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.EndpointQualifierRef;
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Channel;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;

import com.google.inject.ImplementedBy;

/**
 * Resolve bindings for modules to {@link ServiceRefBindingDescription}s describing with which binding
 * providing module provide which set of services.
 * 
 * @author aarnold
 */
public interface IModuleRefServiceBindingResolver {

	/**
	 * Resolve Bindings of services used by a module in the given environment. Endpoint qualifiers in the module definition that select used endpoints of used services
	 * are used as additional filter criteria on the selected bindings.  For each applicable binding and provided service
	 * a ServiceBindingDescription is returned.
	 * 
	 * @param module 				the module, for which ServiceBindingDescriptions are to be build for all used services
	 * @param targetEnvironment 	the environment a binding applicable for the used service must bind to 
	 * @param endpointQualifierRef 	selects an endpoint of a service by selecting the most specific binding for 
	 * 								that service having	this effective endpoint qualifier. If, null applicable bindings may
	 * 								have any or no potentially effective endpoint qualifier
	 * @return Set of {@link ModuleRefServiceBindingDescription}s that describe all Bindings to {@link Service}s, {@link Resource}s and {@link Channel}s 
	 * used by the {@link Module} 
	 */
	public abstract Set<ModuleRefServiceBindingDescription> resolveUsedServiceBindings (final Module module,
			final Environment targetEnvironment, final EndpointQualifierRef endpointQualifierRef);

	/**
	 * Resolve Bindings of all services provided by a module in the given environment. Endpoint qualifiers in the module definition that select used endpoints of used services
	 * are used as additional filter criteria on the selected bindings. For each applicable binding and provided service
	 * a ServiceBindingDescription is returned.
	 * 
	 * @param module 				the module, for which ServiceBindingDescriptions are to be build for all used services
	 * @param targetEnvironment 	the environment a binding applicable for the used service must bind to 
	 * @param endpointQualifier 	selects an endpoint of a service by selecting the most specific binding for 
	 * 								that service having	this effective endpoint qualifier. If, null applicable bindings may
	 * 								have any or no potentially effective endpoint qualifier
	 * @return Set of {@link ModuleRefServiceBindingDescription}s that describe all Bindings to {@link Service}s, {@link Resource}s and {@link Channel}s 
	 * provided by the {@link Module} 
	 */
	public abstract ModuleRefServiceBindingDescription resolveProvidedServiceBindings (
			final Module module, final Environment targetEnvironment, final EndpointQualifierRef endpointQualifier);

}
