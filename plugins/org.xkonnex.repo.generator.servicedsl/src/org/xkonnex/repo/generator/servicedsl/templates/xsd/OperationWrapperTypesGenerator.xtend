package org.xkonnex.repo.generator.servicedsl.templates.xsd

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.List
import java.util.logging.Logger
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.generator.IFileSystemAccess
import org.xkonnex.repo.dsl.basedsl.CommonStringExtensions
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.generator.profiledsl.schema.ProfileSchemaNamespaceExtensions
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.profileDsl.MessageHeader
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Property
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceImportQueries
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DomainNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.InternalNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Parameter
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.dsl.servicedsl.service.query.HeaderFinder
import org.xkonnex.repo.generator.servicedsl.templates.webservice.ServiceTemplateExtensions
import java.util.Set
import org.xkonnex.repo.dsl.profiledsl.versioning.VersionedTechnicalNamespace
import org.xkonnex.repo.generator.servicedsl.templates.CommonTemplateExtensions
import org.xkonnex.repo.dsl.servicedsl.service.namespace.ServiceNamespaceURIProvider
import org.xkonnex.repo.dsl.profiledsl.namespace.ProfileNamespaceURIProvider

/**
 * Create XSDs defining wrapper types for service operations
 */
class OperationWrapperTypesGenerator {
	
	@Inject IFileSystemAccess fsa

	@Inject extension CommonTemplateExtensions
	@Inject extension SchemaNamespaceExtensions schemaNamespaceExt
	@Inject extension ServiceNamespaceURIProvider
	@Inject extension SchemaTemplateExtensions
	@Inject extension SchemaTypeExtensions schemaTypeExt
	@Inject extension ServiceTemplateExtensions
	@Inject extension VersionQualifierExtensions
	@Inject extension HeaderFinder
	@Inject extension NamespaceImportQueries
	
	@Inject ProfileSchemaNamespaceExtensions profileSchemaNamespaceExt
	@Inject ProfileNamespaceURIProvider profileNamespaceURIProvider
	
	@Inject @Named ("noDependencies") 		
	Boolean noDependencies
	
	@Inject
	IEObjectDocumentationProvider docProvider

	@Inject 
	private Logger log

	def dispatch toOperationWrappersInclSubNamespaces (String serviceName, List<SubNamespace> namespaces, LifecycleState minState, Profile profile, String registryBaseUrl) {
		for (ns : namespaces.filter(e|e.name.startsWith (serviceName))) {
			ns.toOperationWrappers (minState, profile, registryBaseUrl);
		}
	}
	
	def dispatch toOperationWrappers (SubNamespace namespace, LifecycleState minState, Profile profile, String registryBaseUrl) {
		namespace.services.forEach (s|s.toOperationWrappers (namespace, minState, profile, registryBaseUrl));
	}
	
	def dispatch Void toOperationWrappers (Service service, SubNamespace subDom, LifecycleState minState, Profile profile, String registryBaseUrl) {
		
	}
	
	def dispatch toOperationWrappers (Service service, DomainNamespace subDom, LifecycleState minState, Profile profile, String registryBaseUrl) {
		val Set<VersionedTechnicalNamespace> headerImports = service.collectTechnicalVersionedNamespaceImports (profile)
		var content = '''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<xsd:schema targetNamespace="«service.toWrapperTargetNamespace()»"
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			xmlns:jxb="http://java.sun.com/xml/ns/jaxb"
			«FOR imp : service.allImportedVersionedNS (service.version.toMajorVersionNumber(), minState)»
				xmlns:«imp.versionedNamespacePrefix»="«imp.versionedNamespaceURI»"
			«ENDFOR»
			«IF !headerImports.empty»
				«FOR headerImp : headerImports»
					xmlns:«profileNamespaceURIProvider.getVersionedNamespacePrefix(headerImp)»="«profileNamespaceURIProvider.getVersionedNamespaceURI(headerImp)»"
				«ENDFOR»
			«ENDIF»
			elementFormDefault="qualified"
			attributeFormDefault="unqualified"
			>
			
			«FOR imp : service.allImportedVersionedNS(service.version.toMajorVersionNumber(), minState)»
				<xsd:import schemaLocation="«imp.toSchemaAssetUrl (registryBaseUrl)».xsd"
					namespace="«schemaNamespaceExt.toNamespace(imp)»"/>
			«ENDFOR»
			«IF !headerImports.empty»
				«FOR headerImp : headerImports»
					<xsd:import schemaLocation="«profileSchemaNamespaceExt.toRegistryAssetUrl (headerImp, registryBaseUrl)».xsd"
						namespace="«profileNamespaceURIProvider.getVersionedNamespaceURI(headerImp)»"/>
				«ENDFOR»
			«ENDIF»
			
			<xsd:annotation>
		   		<xsd:documentation>
					<![CDATA[Version «service.version.toVersionNumber()»
					Lifecycle state: «service.state.toStateName»
					
					«docProvider.getDocumentation (service)»]]>
			   	</xsd:documentation>
		   	</xsd:annotation>
			
			«service.toOperationWrapperMessages (minState, profile)»
		</xsd:schema>
		''';
		val xsdFileName = service.toOperationWrapperXSDFileName();
		fsa.generateFile (xsdFileName, content);
	}
	
	def dispatch toOperationWrappers (Service service, InternalNamespace subDom, LifecycleState minState, Profile profile, String registryBaseUrl) {
		val Set<VersionedTechnicalNamespace> headerImports = service.collectTechnicalVersionedNamespaceImports (profile)
		var content = '''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<xsd:schema targetNamespace="«service.toWrapperTargetNamespace()»"
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			«FOR imp : service.allImportedVersionedNS(service.version.toMajorVersionNumber(), minState)»
				xmlns:«imp.versionedNamespacePrefix»="«imp.versionedNamespaceURI»"
			«ENDFOR»
			«IF !headerImports.empty»
				«FOR headerImp : headerImports»
					xmlns:«profileNamespaceURIProvider.getVersionedNamespacePrefix(headerImp)»="«profileNamespaceURIProvider.getVersionedNamespaceURI(headerImp)»"
				«ENDFOR»
			«ENDIF»
			elementFormDefault="qualified"
			attributeFormDefault="unqualified"
			>
			
			«FOR imp : service.allImportedVersionedNS(service.version.toMajorVersionNumber(), minState)»
			<xsd:import schemaLocation="«imp.toSchemaAssetUrl (registryBaseUrl)».xsd"
				namespace="«imp.versionedNamespaceURI»"/>
			«ENDFOR»
			«IF !headerImports.empty»
				«FOR headerImp : headerImports»
					<xsd:import schemaLocation="«profileSchemaNamespaceExt.toRegistryAssetUrl (headerImp, registryBaseUrl)».xsd"
						namespace="«profileNamespaceURIProvider.getVersionedNamespaceURI(headerImp)»"/>
				«ENDFOR»
			«ENDIF»
			
			<xsd:annotation>
		    	<xsd:documentation>
					<![CDATA[Version «service.version.toVersionNumber()»
					Lifecycle state: «service.state.toStateName»
					
					«docProvider.getDocumentation (service)»]]>
		    	</xsd:documentation>
		    </xsd:annotation>
			
			«service.toOperationWrapperMessages (minState, profile)»
		</xsd:schema>
		'''
		
		val xsdFileName = service.toOperationWrapperXSDFileName();
		fsa .generateFile (xsdFileName, content);
	}
	
	
	def dispatch toOperationWrapperMessages (Service service, LifecycleState minState, Profile profile) {
		service.operations.map (e|e.toConcreteOperationWrapperTypes (profile)).join
	}
	
	
	def dispatch toConcreteOperationWrapperTypes (Operation op, Profile profile) '''
		<xsd:complexType name="«op.toOperationWrapperRequestType()»">
			<xsd:sequence>
				«IF op.findBestMatchingRequestHeader(profile) != null»
					«op.findBestMatchingRequestHeader (profile)?.toParameter()»
				«ENDIF»
				«op.parameters.map (p|p.toParameter()).join»
			</xsd:sequence>
		</xsd:complexType>
		<xsd:complexType name="«op.toOperationWrapperResponseType()»">
			<xsd:sequence>
				«IF op.findBestMatchingResponseHeader(profile) != null»
					«op.findBestMatchingResponseHeader (profile)?.toParameter()»
				«ENDIF»
				«op.^return.map (r|r.toParameter()).join»
			</xsd:sequence>
		</xsd:complexType>
	'''
	
	def dispatch toParameter (Parameter param) '''
		<xsd:element name="«param.name»" type="«param.type.toTypeNameRef ()»" «IF param.optional»minOccurs="0" «ENDIF»«IF param.type.isMany()»maxOccurs="unbounded"«ENDIF»></xsd:element>
	'''
	
	def dispatch toParameter (org.xkonnex.repo.dsl.profiledsl.profileDsl.Property prop) '''
		<xsd:element name="«prop.name»" type="«prop.type.toTypeNameRef ()»" «IF prop.optional»minOccurs="0" «ENDIF»«IF prop.type.isMany()»maxOccurs="unbounded"«ENDIF»></xsd:element>
	'''
	
	def dispatch toParameter (MessageHeader header) '''
		«header.parameters.map (p|p.toParameter()).join»
	'''
	
}