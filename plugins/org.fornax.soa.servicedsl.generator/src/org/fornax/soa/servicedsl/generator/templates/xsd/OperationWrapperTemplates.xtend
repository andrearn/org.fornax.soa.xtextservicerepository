package org.fornax.soa.servicedsl.generator.templates.xsd

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.List
import java.util.logging.Logger
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.generator.IFileSystemAccess
import org.fornax.soa.basedsl.CommonStringExtensions
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.profiledsl.generator.schema.ProfileSchemaNamespaceExtensions
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader
import org.fornax.soa.profiledsl.sOAProfileDsl.Property
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.service.query.namespace.NamespaceImportQueries
import org.fornax.soa.serviceDsl.DomainNamespace
import org.fornax.soa.serviceDsl.InternalNamespace
import org.fornax.soa.serviceDsl.Operation
import org.fornax.soa.serviceDsl.Parameter
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.service.query.HeaderFinder
import org.fornax.soa.servicedsl.generator.templates.webservice.ServiceTemplateExtensions


class OperationWrapperTemplates {
	
	@Inject IFileSystemAccess fsa

	@Inject extension SchemaNamespaceExtensions
	@Inject extension SchemaTemplateExtensions
	@Inject extension SchemaTypeExtensions
	@Inject extension ServiceTemplateExtensions
	@Inject extension VersionQualifierExtensions
	@Inject extension HeaderFinder
	@Inject extension NamespaceImportQueries
	
	@Inject ProfileSchemaNamespaceExtensions profileSchemaNamespaceExt
	
	@Inject @Named ("noDependencies") 		
	Boolean noDependencies
	
	@Inject
	IEObjectDocumentationProvider docProvider

	@Inject 
	private Logger log

	def dispatch toOperationWrappersInclSubNamespaces (String serviceName, List<SubNamespace> namespaces, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		for (ns : namespaces.filter(e|e.name.startsWith (serviceName))) {
			ns.toOperationWrappers (minState, profile, registryBaseUrl);
		}
	}
	
	def dispatch toOperationWrappers (SubNamespace namespace, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		namespace.services.forEach (s|s.toOperationWrappers (namespace, minState, profile, registryBaseUrl));
	}
	
	def dispatch void toOperationWrappers (Service service, SubNamespace subDom, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		
	}
	
	def dispatch toOperationWrappers (Service service, DomainNamespace subDom, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		var content = '''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<xsd:schema targetNamespace="«service.toWrapperTargetNamespace()»"
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			xmlns:jxb="http://java.sun.com/xml/ns/jaxb"
			«FOR imp : service.allImportedVersionedNS (service.version.toMajorVersionNumber(), minState)»
				xmlns:«imp.toPrefix()+imp.version.toMajorVersionNumber()»="«imp.toNamespace()»"
			«ENDFOR»
			«IF service.findBestMatchingHeader(profile) != null»
				«FOR headerImp : service.findBestMatchingHeader (profile).allImportedVersionedNS (service.version.toMajorVersionNumber())»
					xmlns:«profileSchemaNamespaceExt.toPrefix (headerImp) + headerImp.version.toMajorVersionNumber()»="«profileSchemaNamespaceExt.toNamespace (headerImp)»"
				«ENDFOR»
			«ENDIF»
			elementFormDefault="qualified"
			attributeFormDefault="unqualified"
			>
			
			«FOR imp : service.allImportedVersionedNS(service.version.toMajorVersionNumber(), minState)»
				<xsd:import schemaLocation="«imp.toRegistryAssetUrl (registryBaseUrl)».xsd"
					namespace="«imp.toNamespace()»"/>
			«ENDFOR»
			«IF service.findBestMatchingHeader(profile) != null»
				«FOR headerImp : service.findBestMatchingHeader(profile).allImportedVersionedNS(service.version.toMajorVersionNumber())»
					<xsd:import schemaLocation="«profileSchemaNamespaceExt.toRegistryAssetUrl (headerImp, registryBaseUrl)».xsd"
						namespace="«profileSchemaNamespaceExt.toNamespace (headerImp)»"/>
				«ENDFOR»
			«ENDIF»
			
			<xsd:annotation>
		   		<xsd:documentation>
					<![CDATA[Version «service.version.toVersionNumber()»
					Lifecycle state: «service.state.name»
					
					«docProvider.getDocumentation (service)»]]>
			   	</xsd:documentation>
		   	</xsd:annotation>
			
			«service.toOperationWrapperMessages (minState, profile)»
		</xsd:schema>
		''';
		val xsdFileName = service.toOpWrapperXSDFileName();
		fsa.generateFile (xsdFileName, content);
	}
	
	def dispatch toOperationWrappers (Service service, InternalNamespace subDom, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		var content = '''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<xsd:schema targetNamespace="«service.toWrapperTargetNamespace()»"
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			«FOR imp : service.allImportedVersionedNS(service.version.toMajorVersionNumber(), minState)»
				xmlns:«imp.toPrefix()+imp.version.toMajorVersionNumber()»="«imp.toNamespace()»"
			«ENDFOR»
			«IF service.findBestMatchingHeader(profile) != null»
				«FOR headerImp : service.findBestMatchingHeader(profile).allImportedVersionedNS(service.version.toMajorVersionNumber())»
					xmlns:«profileSchemaNamespaceExt.toPrefix (headerImp) + headerImp.version.toMajorVersionNumber()»="«profileSchemaNamespaceExt.toNamespace (headerImp)»"
				«ENDFOR»
			«ENDIF»
			elementFormDefault="qualified"
			attributeFormDefault="unqualified"
			>
			
			«FOR imp : service.allImportedVersionedNS(service.version.toMajorVersionNumber(), minState)»
			<xsd:import schemaLocation="«imp.toRegistryAssetUrl (registryBaseUrl)».xsd"
				namespace="«imp.toNamespace()»"/>
			«ENDFOR»
			«IF service.findBestMatchingHeader(profile) != null»
				«FOR headerImp : service.findBestMatchingHeader (profile).allImportedVersionedNS (service.version.toMajorVersionNumber())»
					<xsd:import schemaLocation="«profileSchemaNamespaceExt.toRegistryAssetUrl (headerImp, registryBaseUrl)».xsd"
						namespace="«profileSchemaNamespaceExt.toNamespace (headerImp)»"/>
				«ENDFOR»
			«ENDIF»
			
			<xsd:annotation>
		    	<xsd:documentation>
					<![CDATA[Version «service.version.toVersionNumber()»
					Lifecycle state: «service.state.name»
					
					«docProvider.getDocumentation (service)»]]>
		    	</xsd:documentation>
		    </xsd:annotation>
			
			«service.toOperationWrapperMessages (minState, profile)»
		</xsd:schema>
		'''
		
		val xsdFileName = service.toOpWrapperXSDFileName();
		fsa .generateFile (xsdFileName, content);
	}
	
	
	def dispatch toOperationWrapperMessages (Service service, LifecycleState minState, SOAProfile profile) {
		service.operations.map (e|e.toConcreteOperationWrapperTypes (profile)).join
	}
	
	
	def dispatch toConcreteOperationWrapperTypes (Operation op, SOAProfile profile) '''
		<xsd:complexType name="«op.toOperationWrapperRequestType()»">
			<xsd:sequence>
				«IF op.findBestMatchingHeader(profile) != null»
					«op.findBestMatchingHeader (profile)?.toParameter()»
				«ENDIF»
				«op.parameters.map (p|p.toParameter()).join»
			</xsd:sequence>
		</xsd:complexType>
		<xsd:complexType name="«op.toOperationWrapperResponseType()»">
			<xsd:sequence>
				«IF op.findBestMatchingHeader(profile) != null»
					«op.findBestMatchingHeader (profile)?.toParameter()»
				«ENDIF»
				«op.^return.map (r|r.toParameter()).join»
			</xsd:sequence>
		</xsd:complexType>
	'''
	
	def dispatch toParameter (Parameter param) '''
		<xsd:element name="«param.name»" type="«param.type.toTypeNameRef ()»" «IF param.optional»minOccurs="0" «ENDIF»«IF param.type.isMany()»maxOccurs="unbounded"«ENDIF»></xsd:element>
	'''
	
	def dispatch toParameter (org.fornax.soa.profiledsl.sOAProfileDsl.Property prop) '''
		<xsd:element name="«prop.name»" type="«prop.type.toTypeNameRef ()»" «IF prop.optional»minOccurs="0" «ENDIF»«IF prop.type.isMany()»maxOccurs="unbounded"«ENDIF»></xsd:element>
	'''
	
	def dispatch toParameter (MessageHeader header) '''
		«header.parameters.map (p|p.toParameter()).join»
	'''
	
}