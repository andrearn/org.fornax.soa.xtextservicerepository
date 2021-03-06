/*
 * generated by Xtext 2.9.1
 */
package org.xkonnex.repo.dsl.servicedsl.formatting2

import com.google.inject.Inject
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.xkonnex.repo.dsl.basedsl.baseDsl.Import
import org.xkonnex.repo.dsl.basedsl.baseDsl.Namespace
import org.xkonnex.repo.dsl.basedsl.formatting2.BaseDslFormatter
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.OrganizationNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceModel
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Type
import org.xkonnex.repo.dsl.servicedsl.services.ServiceDslGrammarAccess

class ServiceDslFormatter extends BaseDslFormatter {
	
	@Inject extension ServiceDslGrammarAccess

	def dispatch void format(ServiceModel serviceModel, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (Import imports : serviceModel.getImports()) {
			imports.format;
		}
		for (Namespace namespaces : serviceModel.getNamespaces()) {
			namespaces.format;
		}
		for (Type types : serviceModel.getTypes()) {
			types.format;
		}
	}

	def dispatch void format(OrganizationNamespace organizationNamespace, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (SubNamespace subNamespaces : organizationNamespace.getSubNamespaces()) {
			subNamespaces.format;
		}
	}
	
	// TODO: implement for DomainNamespace, InternalNamespace, BusinessObject, ValueObject, Aggregate, Entity, QueryObject, VersionedTypeRef, EnumTypeRef, DataObjectRef, Property, SimpleAttribute, Enumeration, Service, Operation, Parameter, Exception, ExceptionRef, ServiceRef, RequiredServiceRef, OperationRef, ConsiderationSpec, ConsiderationParameterRef, ComplexConsiderationPropertyRef, MessageHeaderRef, CapabilityRef, Event, EventRef, Command, CommandRef, Channel
}
