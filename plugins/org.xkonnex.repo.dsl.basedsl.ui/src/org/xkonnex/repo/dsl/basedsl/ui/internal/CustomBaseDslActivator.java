package org.xkonnex.repo.dsl.basedsl.ui.internal;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.RegistryFactory;
import org.osgi.framework.BundleContext;
import org.xkonnex.repo.dsl.basedsl.ui.internal.BasedslActivator;
import org.xkonnex.repo.dsl.basedsl.validation.AbstractPluggableDeclarativeValidator;
import org.xkonnex.repo.dsl.basedsl.validation.IPluggableValidatorProvider;

import com.google.inject.Injector;

public class CustomBaseDslActivator extends BasedslActivator {


	private Set<AbstractPluggableDeclarativeValidator> validatorContributions = new HashSet<AbstractPluggableDeclarativeValidator>();

	@Override
	public void start(BundleContext context) throws Exception {
		super.start (context);
		Injector injector = getInjector (ORG_XKONNEX_REPO_DSL_BASEDSL_BASEDSL);
		IPluggableValidatorProvider validatorProvider = injector.getInstance (IPluggableValidatorProvider.class);
	
        try {
            final IConfigurationElement[] confEl = RegistryFactory.getRegistry().getConfigurationElementsFor ("org.fornax.soa.soabasedsl.ui.SOABaseDSLValidator");

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
