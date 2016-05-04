package org.xkonnex.repo.generator.bindingdsl.rest.raml.templates

import java.util.logging.Logger
import javax.inject.Inject
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.xkonnex.repo.dsl.basedsl.ext.infer.IComponentInferrer
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.EnvironmentBindingResolver
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding
import org.xkonnex.repo.dsl.bindingdsl.model.IEffectiveBindingBuilder
import org.xkonnex.repo.dsl.moduledsl.model.IEffectiveProvidingEndpointBuilder
import org.xkonnex.repo.dsl.profiledsl.namespace.ProfileNamespaceURIProvider
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile
import org.xkonnex.repo.dsl.servicedsl.service.namespace.ServiceNamespaceURIProvider
import org.xkonnex.repo.dsl.servicedsl.service.query.HeaderFinder
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceImportQueries
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.generator.bindingdsl.rest.RESTEndpointAddressResolver
import org.xkonnex.repo.generator.bindingdsl.templates.BindingExtensions
import org.xkonnex.repo.generator.bindingdsl.templates.DefaultServiceContractFilenameProvider
import org.xkonnex.repo.generator.profiledsl.schema.ProfileSchemaNamespaceExtensions
import org.xkonnex.repo.generator.servicedsl.templates.webservice.ServiceTemplateExtensions
import org.xkonnex.repo.generator.servicedsl.templates.xsd.OperationWrapperTypesGenerator
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaTypeExtensions

class RAMLContractGenerator {
	
	@Inject extension SchemaTypeExtensions schemaTypeExt
	@Inject extension ServiceTemplateExtensions
	@Inject extension ServiceNamespaceURIProvider
	@Inject extension HeaderFinder
	@Inject extension NamespaceQuery
	@Inject extension NamespaceImportQueries
	@Inject VersionQualifierExtensions versionQualifier
	@Inject extension RESTEndpointAddressResolver
	@Inject extension IComponentInferrer
	@Inject extension BindingExtensions
	@Inject extension IQualifiedNameProvider

	@Inject extension SchemaNamespaceExtensions schemaNamespaceExt
	@Inject ProfileSchemaNamespaceExtensions profileSchemaNamespaceExt
	@Inject IEObjectDocumentationProvider docProvider
	@Inject ProfileNamespaceURIProvider profileNamespaceURIProvider
	@Inject EnvironmentBindingResolver environmentResolver
	@Inject IEffectiveBindingBuilder bindingBuilder
	@Inject IEffectiveProvidingEndpointBuilder endpointBuilder
	@Inject extension DefaultServiceContractFilenameProvider
	@Inject OperationWrapperTypesGenerator wrapperTypesGenerator

	@Inject IFileSystemAccess fsa
	@Inject Logger log
	
	def toRAML (AnyBinding binding, Service svc, LifecycleState minState, Profile profile) {
		
	}
	
}