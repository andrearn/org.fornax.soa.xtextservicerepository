package org.fornax.soa.bindingdsl.generator.queries.environment

import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingDsl.DomainBinding
import org.fornax.soa.bindingDsl.ServiceBinding
import org.fornax.soa.environmentDsl.Server
import org.fornax.soa.environmentDsl.Environment
import org.fornax.soa.bindingDsl.OperationBinding

class EnvironmentBindingResolver {
	
	def dispatch Server resolveServer (Binding bind) {
		
	}
	def dispatch Server resolveServer (ModuleBinding bind) {
		bind.provider.provServer
	}
	def dispatch Server resolveServer (DomainBinding bind) {
	}
	def dispatch Server resolveServer (ServiceBinding bind) {
		(bind.eContainer as Binding).resolveServer
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