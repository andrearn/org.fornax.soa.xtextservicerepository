package org.xkonnex.repo.dsl.solutiondsl.ui.internal;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.RegistryFactory;
import org.osgi.framework.BundleContext;
import org.xkonnex.repo.dsl.basedsl.validation.AbstractPluggableDeclarativeValidator;
import org.xkonnex.repo.dsl.basedsl.validation.IPluggableValidatorProvider;
import org.xkonnex.repo.dsl.solutiondsl.ui.internal.SolutiondslActivator;

import com.google.inject.Injector;

public class CustomSolutionDslActivator extends SolutiondslActivator {

	private Set<AbstractPluggableDeclarativeValidator> validatorContributions = new HashSet<AbstractPluggableDeclarativeValidator>();

	@Override
	public void start(BundleContext context) throws Exception {
		super.start (context);
		Injector injector = getInjector (ORG_XKONNEX_REPO_DSL_SOLUTIONDSL_SOLUTIONDSL);
		IPluggableValidatorProvider validatorProvider = injector.getInstance (IPluggableValidatorProvider.class);
	
        try {
            final IConfigurationElement[] confEl = RegistryFactory.getRegistry().getConfigurationElementsFor ("org.xkonnex.repo.dsl.semanticsdsl.solutiondsl.ui.SolutionDSLValidator");

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
