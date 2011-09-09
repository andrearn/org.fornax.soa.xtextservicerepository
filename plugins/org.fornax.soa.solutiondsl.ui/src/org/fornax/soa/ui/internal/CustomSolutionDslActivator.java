package org.fornax.soa.ui.internal;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.RegistryFactory;
import org.fornax.soa.basedsl.validation.AbstractPluggableDeclarativeValidator;
import org.fornax.soa.basedsl.validation.IPluggableValidatorProvider;
import org.fornax.soa.ui.internal.SolutionDslActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Injector;

public class CustomSolutionDslActivator extends SolutionDslActivator {

	private Set<AbstractPluggableDeclarativeValidator> validatorContributions = new HashSet<AbstractPluggableDeclarativeValidator>();

	@Override
	public void start(BundleContext context) throws Exception {
		super.start (context);
		Injector injector = getInjector ("org.fornax.soa.SolutionDsl");
		IPluggableValidatorProvider validatorProvider = injector.getInstance (IPluggableValidatorProvider.class);
	
        try {
            final IConfigurationElement[] confEl = RegistryFactory.getRegistry().getConfigurationElementsFor ("org.fornax.soa.solutiondsl.ui.SolutionDSLValidator");

            for (IConfigurationElement curEl: confEl) {
                final Object o = curEl.createExecutableExtension ("class");
                validatorContributions.add ((AbstractPluggableDeclarativeValidator) o);
            }
            
            validatorProvider.setValidators (validatorContributions);
        }
        catch (Exception ex) {
            //TODO handle exception
        }

	}
	
	@Override
	public void stop(BundleContext context) throws Exception {
		validatorContributions.clear();
		super.stop (context);
	}

}
