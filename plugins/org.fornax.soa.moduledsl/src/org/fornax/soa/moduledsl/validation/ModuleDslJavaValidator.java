package org.fornax.soa.moduledsl.validation;

import org.fornax.soa.basedsl.validation.PluggableChecks;
 
@PluggableChecks (validators = {
	ModuleLifecycleStateValidator.class
})
public class ModuleDslJavaValidator extends AbstractModuleDslJavaValidator {

	
}
