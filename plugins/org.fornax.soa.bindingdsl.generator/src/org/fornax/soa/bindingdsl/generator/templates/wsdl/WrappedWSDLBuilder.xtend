package org.fornax.soa.bindingdsl.generator.templates.wsdl

import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import java.util.List
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.serviceDsl.Service
import com.google.inject.Inject
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions
import org.fornax.soa.profiledsl.query.LifecycleQueries
import org.fornax.soa.binding.query.environment.AssetStateEnvironmentEligibilityChecker
import org.fornax.soa.servicedsl.generator.templates.webservice.WrappedWsdlGenerator

/*
 * Generate a WSDL where all input and output parameters are wrapped into a Wrappertype. 
 */
class WrappedWSDLBuilder {
	
	
	@Inject extension WrappedWsdlGenerator
	@Inject extension BindingExtensions
	@Inject extension LifecycleQueries
	@Inject extension AssetStateEnvironmentEligibilityChecker
	
	
	/*
		<b>CARTRIDGE ENTRYPOINT</b> for generation of abstract wrapped  WSDLs
		Abstract WSDLs only define the abstract interface of a service. The binding is declared
		in a separate WSDL that imports this abstract WSDL. <br/>
		
		A WSDL for each Service in the given SubNamespace matching the given minimal LifecycleState
		will be generated. For each major version of a service WSDL is generated for the latest minor
		version in that major version matching the minimal Lifecycle constraint is be generated
	*/
	def dispatch toWrappedWSDL (SubNamespace ns, SOAProfile profileName, Environment targetEnvironment) {
		ns.services.filter (s|s.isEligibleForEnvironment (targetEnvironment))
			.forEach (e|e.toWrappedWSDL (profileName, targetEnvironment));
	}
	
	def dispatch toWrappedWSDL (SubNamespace ns, List<SOAProfile> profiles, String profileName, List<Environment> environments, String targetEnvironment) {
		val prof = profiles.findFirst (p|p.name==profileName);
		val env = environments.findFirst (e|e.name==targetEnvironment);
		ns.services.filter (s|s.isEligibleForEnvironment (env)).forEach (e|e.toWrappedWSDL (prof, env));
	}
	
	def dispatch toWrappedWSDL (Service svc, List<SOAProfile> profiles, String profileName, List<Environment> environments, String targetEnvironment) {
		val env = environments.findFirst (e|e.name==targetEnvironment);
		svc.toWrappedWSDL (profiles.findFirst (e|e.name==profileName), env);
	}
	
	
	def dispatch toWrappedWSDL (Service svc, SOAProfile profile, Environment environment) {
		svc.toWrappedWSDL (environment.getMinLifecycleState (profile.lifecycle), profile, environment.getRegistryBaseUrl());
	}

}