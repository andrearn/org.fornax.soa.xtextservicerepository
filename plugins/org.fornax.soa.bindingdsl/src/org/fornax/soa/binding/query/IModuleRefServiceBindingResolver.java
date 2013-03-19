package org.fornax.soa.binding.query;

import java.util.Set;

import org.fornax.soa.binding.query.services.ServiceRefBindingDescription;
import org.fornax.soa.environmentDsl.Environment;
import org.fornax.soa.moduledsl.moduleDsl.EndpointQualifierRef;
import org.fornax.soa.moduledsl.moduleDsl.Module;

import com.google.inject.ImplementedBy;

/**
 * Resolve bindings for modules to {@link ServiceRefBindingDescription}s describing with which binding
 * providing module provide which set of services.
 * 
 * @author aarnold
 */
@ImplementedBy (DefaultModuleRefServiceBindingResolver.class)
public interface IModuleRefServiceBindingResolver {

	/**
	 * Resolve Bindings of services used by a module in the given environment. Endpoint qualifiers in the module definition that select used endpoints of used services
	 * are used as additional filter criteria on the selected bindings.  For each applicable binding and provided service
	 * a ServiceBindingDescription is returned.
	 * 
	 * @param module 				the module, for which ServiceBindingDescriptions are to be build for all used services
	 * @param targetEnvironment 	the environment a binding applicable for the used service must bind to 
	 * @param endpointQualifier 	selects an endpoint of a service by selecting the most specific binding for 
	 * 								that service having	this effective endpoint qualifier. If, null applicable bindings may
	 * 								have any or no potentially effective endpoint qualifier
	 */
	public abstract Set<ModuleRefServiceBindingDescription> resolveCompatibleUsedServiceBindings(final Module module,
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
	 */
	public abstract ModuleRefServiceBindingDescription resolveCompatibleProvidedServiceBindings(
			final Module module, final Environment targetEnvironment, final EndpointQualifierRef endpointQualifier);

}
