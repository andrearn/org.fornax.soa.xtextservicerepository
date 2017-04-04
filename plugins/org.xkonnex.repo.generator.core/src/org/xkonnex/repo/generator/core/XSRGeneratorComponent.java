package org.xkonnex.repo.generator.core;

import static com.google.common.collect.Maps.newLinkedHashMap;
import static com.google.common.collect.Maps.uniqueIndex;

import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.generator.GeneratorComponent;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;

import com.google.common.base.Function;
import com.google.inject.Injector;

public class XSRGeneratorComponent extends GeneratorComponent {

	private Injector injector;

	@Override
	public void setRegister(ISetup setup) {
		injector = setup.createInjectorAndDoEMFRegistration();
		super.setInjector(injector);
	}
	
	@Override
	protected Map<String, OutputConfiguration> getOutputConfigurations() {
		IOutputConfigurationProvider outputConfigurationProvider =  injector.getInstance(IOutputConfigurationProvider.class);
		Set<OutputConfiguration> configurations = outputConfigurationProvider.getOutputConfigurations();
			return newLinkedHashMap(uniqueIndex(configurations, new Function<OutputConfiguration, String>() {
				public String apply(OutputConfiguration from) {
				return from.getName();
			}
		}));
	}

}
