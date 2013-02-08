package org.fornax.soa.binding.query.environment

import com.google.inject.Inject
import java.util.Set
import org.fornax.soa.binding.query.BindingLookup
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingDsl.OperationBinding
import org.fornax.soa.bindingDsl.ServiceBinding
import org.fornax.soa.environment.query.EnvironmentLookup
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.environmentDsl.Server
import org.fornax.soa.moduledsl.moduleDsl.Module
import org.fornax.soa.moduledsl.query.ModuleLookup
import org.eclipse.emf.ecore.EObject

class EnvironmentBindingResolver {

	@Inject
	private BindingLookup bindingLookup
	@Inject
	private ModuleLookup moduleLookup
	@Inject
	private EnvironmentLookup envLookup
	
	
	/*
	 * Find all ModuleBindings that directly refer to this module or a compatible module and bind it to the given 
	 * target environment
	 */
	def Set<Environment> findUnboundEnvironmentForCompatibleModule (Module module) {
		val allBindings = bindingLookup.getAllBindings(module.eResource?.resourceSet).filter (typeof (ModuleBinding))
		val compatibleModules = moduleLookup.findCompatibleModules(module).toSet
		val bindings = allBindings.filter (e|compatibleModules.contains (e.module)).toSet;
		val boundEnvironments = bindings.map(b|b.resolveEnvironment).toSet
		val allEnvironments = envLookup.findAllEnvironments(module.eResource?.resourceSet)
		return allEnvironments.filter(e| !boundEnvironments.contains(e)).toSet
	}

	def dispatch Server resolveServer (Binding bind, BindingProtocol prot) {
		throw new UnsupportedOperationException ()
	}
	
	/*
	 * Return the server to bind to. If not stated explicitly in the ModuleBinding
	 * the environments default ESB is being used
	 */
	def dispatch Server resolveServer (ModuleBinding bind, BindingProtocol prot) {
		val server = bind.provServer
		return if (server != null) server else bind.resolveEnvironment.defaultESB
	}
		
	def dispatch Server resolveServer (ServiceBinding bind, BindingProtocol prot) {
		(bind.eContainer as Binding).resolveServer(prot)
	}
	
	def dispatch Server resolveServer (OperationBinding bind, BindingProtocol prot) {
		(bind.eContainer as Binding).resolveServer(prot)
	}
	
	def dispatch Server resolveServer (EObject bind, BindingProtocol prot) {
		bind.eContainer?.resolveServer(prot)
	}
	
	
	def dispatch Server resolveServer (ModuleBinding bind) {
		val server = bind.provServer
		return if (server != null) server else bind.resolveEnvironment.defaultESB
	}
		
	def dispatch Server resolveServer (ServiceBinding bind) {
		(bind.eContainer as Binding).resolveServer
	}
	
	def dispatch Server resolveServer (OperationBinding bind) {
		(bind.eContainer as Binding).resolveServer
	}
	
	def dispatch Server resolveServer (EObject bind) {
		bind.eContainer?.resolveServer
	}
	
	def dispatch Environment resolveEnvironment (Server server) {
		server.eContainer as Environment
	}
	
	def dispatch Environment resolveEnvironment (EObject o) {
		o.eContainer?.resolveEnvironment
	}
	def dispatch Environment resolveEnvironment (Binding bind) {
		bind.resolveEnvironment
	}
	def dispatch Environment resolveEnvironment (ModuleBinding bind) {
		if (bind.provServer != null) {
			bind.provServer.resolveEnvironment
		} else {
			bind.environment
		}
	}
	def dispatch Environment getEnvironment (ServiceBinding bind) {
		(bind.eContainer as Binding).resolveEnvironment
	}
	def dispatch Environment getEnvironment (OperationBinding bind) {
		(bind.eContainer as Binding).resolveEnvironment
	}

}