package org.fornax.soa.bindingdsl.generator.templates

import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.bindingDsl.Binding
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.bindingDsl.SOAP
import com.google.inject.Inject
import org.fornax.soa.servicedsl.generator.templates.webservice.WSDLTemplates
import org.fornax.soa.servicedsl.generator.templates.ServiceTemplates
import org.fornax.soa.bindingdsl.generator.templates.xsd.EventXSDTemplates
import org.fornax.soa.bindingdsl.generator.templates.soap.ConcreteWsdlTemplates
import org.fornax.soa.bindingdsl.generator.templates.soap.ConcreteProviderWsdlTemplates
import org.fornax.soa.profiledsl.generator.templates.MessageHeaderXSDTemplates
import org.fornax.soa.bindingdsl.generator.queries.services.BoundServiceLookup
import org.fornax.soa.bindingdsl.generator.queries.modules.ModuleBindingResolver
import org.fornax.soa.bindingdsl.generator.queries.services.BindingServiceResolver
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaTypeExtensions
import org.fornax.soa.servicedsl.generator.query.namespace.NamespaceImportQueries
import org.fornax.soa.servicedsl.generator.domain.NamespaceSplitter
import org.fornax.soa.basedsl.generator.lifecycle.StateMatcher
import org.fornax.soa.servicedsl.generator.query.ServiceFinder
import org.fornax.soa.basedsl.generator.CommonStringExtensions
import org.fornax.soa.servicedsl.generator.query.namespace.NamespaceQuery
import org.fornax.soa.bindingdsl.generator.templates.xsd.XSDTemplates
import com.google.inject.name.Named
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.servicedsl.generator.query.type.ReferencedTypesFinder
import org.fornax.soa.servicedsl.generator.query.HeaderFinder
import org.fornax.soa.bindingDsl.DomainBinding

class BindingProtocolServiceContractBuilder {

	@Inject extension NamespaceQuery
	@Inject extension CommonStringExtensions
	@Inject extension ServiceFinder
	@Inject extension BindingExtensions
	@Inject extension StateMatcher
	@Inject extension NamespaceImportQueries
	@Inject extension org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
	@Inject extension SchemaTypeExtensions
	@Inject extension BindingServiceResolver
	@Inject extension ModuleBindingResolver
	@Inject extension ReferencedTypesFinder
	@Inject extension HeaderFinder
		
	
	@Inject WSDLTemplates 					wsdlGenerator
	@Inject XSDTemplates 					xsdGenerator
	@Inject ServiceTemplates 				serviceGenerator
	@Inject EventXSDTemplates 				eventXsdGenerator
	@Inject ConcreteWsdlTemplates 			concreteWsdlGenerator
	@Inject ConcreteProviderWsdlTemplates 	concreteProviderWsdlGenerator
	@Inject MessageHeaderXSDTemplates 		msgHeaderGenerator
	@Inject BoundServiceLookup				serviceLookup

	
	@Inject @Named ("noDependencies") 		
	Boolean noDependencies
	@Inject @Named ("forceRelativePaths") 		
	Boolean forceRelativePaths

	
	def dispatch toContractForProtocol (Service svc, ModuleBinding bind, BindingProtocol prot, SOAProfile profile) {
		
	}
	
	def dispatch toContractForProtocol (Service svc, DomainBinding bind, BindingProtocol prot, SOAProfile profile) {
		
	}
	
	
	def dispatch toContractForProtocol (Service svc, ModuleBinding binding, SOAP prot, SOAProfile profile) {
		if (svc.providedContractUrl == null && svc.isEligibleForEnvironment (binding.environment)) {
			val namespace = svc.findSubdomain();
			
			wsdlGenerator.toWSDL (svc, namespace, namespace.minStateByEnvironment (binding.environment), profile, binding.getRegistryBaseUrl());
			
			if (svc.isPublicEndpoint (binding.provider.provServer)) {
				concreteWsdlGenerator.toWSDL(binding, svc, prot, profile);
			} else {
				concreteProviderWsdlGenerator.toWSDL(svc, binding, prot, profile);
			}
			
			if ( ! noDependencies) {
				val verNamespaces = svc.importedVersionedNS (namespace.minStateByEnvironment (binding.environment));
				verNamespaces.forEach (n | xsdGenerator.toXSD(n, namespace.minStateByEnvironment (binding.environment), binding, profile));
				
				val header = svc.findBestMatchingHeader (profile);
				if (forceRelativePaths)
					msgHeaderGenerator.toMessageHeaderXSD(header, profile, binding.getRegistryBaseUrl())
				else 
					msgHeaderGenerator.toMessageHeaderXSD(header, profile)
			}
		}
	}

	def dispatch toContractForProtocol (Service svc, DomainBinding binding, SOAP prot, SOAProfile profile) {
	}
}