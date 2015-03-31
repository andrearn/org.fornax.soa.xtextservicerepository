package org.xkonnex.repo.server.core.resource;

import java.util.List;

import org.eclipse.xtext.ISetup;
import org.xkonnex.repo.dsl.basedsl.SOABaseDslStandaloneSetup;
import org.xkonnex.repo.dsl.bindingdsl.BindingDslStandaloneSetup;
import org.xkonnex.repo.dsl.businessdsl.BusinessDslStandaloneSetup;
import org.xkonnex.repo.dsl.environmentdsl.EnvironmentDslStandaloneSetup;
import org.xkonnex.repo.dsl.moduledsl.ModuleDslStandaloneSetup;
import org.xkonnex.repo.dsl.profiledsl.SOAProfileDslStandaloneSetup;
import org.xkonnex.repo.dsl.semanticsdsl.SemanticsDslStandaloneSetup;
import org.xkonnex.repo.dsl.servicedsl.ServiceDslStandaloneSetup;

import com.google.common.collect.Lists;
import com.google.inject.Injector;

/**
 * Initializes the DSL infrastructure calling the {@link ISetup}s of the languages
 * @author aarnold
 *
 */
public class DSLConfigurer {

	private List<Injector> injectors = Lists.newArrayList();
	
	public DSLConfigurer() {
		addRegister(new SOABaseDslStandaloneSetup());
		addRegister(new SemanticsDslStandaloneSetup());
	    addRegister(new EnvironmentDslStandaloneSetup());
	    addRegister(new SOAProfileDslStandaloneSetup());
	    addRegister(new BusinessDslStandaloneSetup());
		addRegister(new ServiceDslStandaloneSetup());
	    addRegister(new ModuleDslStandaloneSetup());
	    addRegister(new BindingDslStandaloneSetup());
	}
	
	private void addRegister(ISetup setup) {
		getInjectors().add(setup.createInjectorAndDoEMFRegistration());
	}

	public List<Injector> getInjectors() {
		return injectors;
	}


}
