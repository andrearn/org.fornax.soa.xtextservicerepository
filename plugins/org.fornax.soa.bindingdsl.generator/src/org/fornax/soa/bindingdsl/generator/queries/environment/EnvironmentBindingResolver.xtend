package org.fornax.soa.bindingdsl.generator.queries.environment

import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingDsl.DomainBinding
import org.fornax.soa.bindingDsl.ServiceBinding
import org.fornax.soa.environmentDsl.Server
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.bindingDsl.OperationBinding
import org.fornax.soa.bindingDsl.BindingProtocol
import com.google.inject.Inject
import org.fornax.soa.bindingdsl.generator.templates.BindingResolver

class EnvironmentBindingResolver {

	@Inject BindingResolver		bindingResolver
	
	def dispatch Server resolveServer (Binding bind, BindingProtocol prot) {
		throw new UnsupportedOperationException ()
	}
	
	/*
	 * Return the server to bind to. If not stated explicitely in the ModuleBinding
	 * the environments default ESB is being used
	 */
	def dispatch Server resolveServer (ModuleBinding bind, BindingProtocol prot) {
		val server = bind.provider.provServer
		return if (server != null) server else bind.resolveEnvironment.defaultESB
	}
	
	def dispatch Server resolveServer (DomainBinding bind, BindingProtocol prot) {
		if (prot == null)
			return bind.environment.defaultESB
		var publisher = bindingResolver.getPublisher (prot)
		var provider = bindingResolver.getProvider (prot)
		if (publisher?.pubServer != null)
			return publisher.pubServer
		else if (provider?.provServer != null)
			return provider.provServer
		else
			bind.environment.defaultESB
	}
	
	def dispatch Server resolveServer (ServiceBinding bind, BindingProtocol prot) {
		(bind.eContainer as Binding).resolveServer(prot)
	}
	
	def dispatch Server resolveServer (OperationBinding bind, BindingProtocol prot) {
		(bind.eContainer as Binding).resolveServer(prot)
	}
	
	def dispatch Environment resolveEnvironment (Binding bind) {
		bind.resolveEnvironment
	}
	def dispatch Environment resolveEnvironment (ModuleBinding bind) {
		bind.environment
	}
	def dispatch Environment resolveEnvironment (DomainBinding bind) {
		bind.environment
	}
	def dispatch Environment getEnvironment (ServiceBinding bind) {
		(bind.eContainer as Binding).resolveEnvironment
	}
	def dispatch Environment getEnvironment (OperationBinding bind) {
		(bind.eContainer as Binding).resolveEnvironment
	}

}