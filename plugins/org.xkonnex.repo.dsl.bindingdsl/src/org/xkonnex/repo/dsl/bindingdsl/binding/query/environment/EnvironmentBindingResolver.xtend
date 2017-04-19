package org.xkonnex.repo.dsl.bindingdsl.binding.query.environment

import com.google.inject.Inject
import java.util.Set
import org.xkonnex.repo.dsl.bindingdsl.binding.query.BindingLookup
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.OperationBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ServiceBinding
import org.xkonnex.repo.dsl.environmentdsl.environment.query.EnvironmentLookup
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Environment
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Server
import org.xkonnex.repo.dsl.moduledsl.moduleDsl.Module
import org.xkonnex.repo.dsl.moduledsl.query.ModuleLookup
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import org.xkonnex.repo.dsl.bindingdsl.model.EffectiveBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ResourceBinding

/**
 * Resolver, that resolves environment assets such as servers from Bindings
 */
class EnvironmentBindingResolver {

	@Inject
	private BindingLookup bindingLookup
	@Inject
	private ModuleLookup moduleLookup
	@Inject
	private EnvironmentLookup envLookup
	

	def dispatch Server resolveServer (Binding bind, BindingProtocol prot) {
		throw new UnsupportedOperationException ()
	}
	
	/*
	 * Return the server to bind to. If not stated explicitly in the ModuleBinding
	 * the environments default ESB is being used
	 */
	def dispatch Server resolveServer (ModuleBinding bind, BindingProtocol prot) {
		val server = bind.provServer
		return if (server !== null) server else bind.resolveEnvironment.defaultESB
	}
		
	def dispatch Server resolveServer (ServiceBinding bind, BindingProtocol prot) {
		(bind.eContainer as Binding).resolveServer(prot)
	}
		
	def dispatch Server resolveServer (ResourceBinding bind, BindingProtocol prot) {
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
		return if (server !== null) server else bind.resolveEnvironment.defaultESB
	}
		
	def dispatch Server resolveServer (ServiceBinding bind) {
		(bind.eContainer as Binding).resolveServer
	}
		
	def dispatch Server resolveServer (ResourceBinding bind) {
		(bind.eContainer as Binding).resolveServer
	}
	
	def dispatch Server resolveServer (OperationBinding bind) {
		(bind.eContainer as Binding).resolveServer
	}
	
	def dispatch Server resolveServer (EObject bind) {
		bind.eContainer?.resolveServer
	}
	def dispatch Server resolveServer (EffectiveBinding bind) {
		val server = bind.provServer
		return if (server !== null) server else bind.resolveEnvironment.defaultESB
	}
	
	def dispatch Environment resolveEnvironment (Server server) {
		server.eContainer as Environment
	}
	
	def dispatch Environment resolveEnvironment (EObject o) {
		o.eContainer?.resolveEnvironment
	}
	
	def dispatch Environment resolveEnvironment (EffectiveBinding bind) {
		if (bind.provServer !== null) {
			bind.provServer.resolveEnvironment
		} else {
			bind.environment
		}
	}
	
	def dispatch Environment resolveEnvironment (ModuleBinding bind) {
		if (bind.provServer !== null) {
			bind.provServer.resolveEnvironment
		} else {
			bind.environment
		}
	}
	
	def dispatch Environment resolveEnvironment (ServiceBinding bind) {
		val modBind = EcoreUtil2.getContainerOfType(bind, typeof(ModuleBinding))
		modBind.resolveEnvironment
	}
	
	def dispatch Environment resolveEnvironment (OperationBinding bind) {
		val modBind = EcoreUtil2.getContainerOfType(bind, typeof(ModuleBinding))
		modBind.resolveEnvironment
	}
	
	/*
	 * Get all environments to which the module is not bound
	 */
	def Set<Environment> findUnboundEnvironmentForCompatibleModule (Module module) {
		val allBindings = bindingLookup.getAllBindings(module.eResource?.resourceSet).filter (typeof (ModuleBinding))
		val compatibleModules = moduleLookup.findCompatibleModules(module).toSet
		val bindings = allBindings.filter (e|compatibleModules.contains (e.module)).toSet;
		val boundEnvironments = bindings.map(b|b.resolveEnvironment).toSet
		val allEnvironments = envLookup.findAllEnvironments(module.eResource?.resourceSet)
		return allEnvironments.filter(e| !boundEnvironments.contains(e)).toSet
	}

}