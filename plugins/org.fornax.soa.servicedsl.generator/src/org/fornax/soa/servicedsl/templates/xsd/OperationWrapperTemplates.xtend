package org.fornax.soa.servicedsl.templates.xsd

import java.util.List
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.DomainNamespace
import org.eclipse.xtext.generator.IFileSystemAccess
import com.google.inject.Inject
import org.fornax.soa.basedsl.CommonStringExtensions
import org.fornax.soa.servicedsl.templates.webservice.ServiceTemplateExtensions
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.servicedsl.query.HeaderFinder
import org.fornax.soa.servicedsl.query.namespace.NamespaceImportQueries
import org.fornax.soa.serviceDsl.InternalNamespace
import org.fornax.soa.serviceDsl.Operation
import org.fornax.soa.serviceDsl.Parameter
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader


class OperationWrapperTemplates {
	
	@Inject IFileSystemAccess fsa

	@Inject extension CommonStringExtensions
	@Inject extension SchemaNamespaceExtensions
	@Inject extension SchemaTemplateExtensions
	@Inject extension SchemaTypeExtensions
	@Inject extension ServiceTemplateExtensions
	@Inject extension VersionQualifierExtensions
	@Inject extension HeaderFinder
	@Inject extension NamespaceImportQueries
	@Inject extension XSDTemplates

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
		var content = '''<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<xsd:schema targetNamespace="«service.toWrapperTargetNamespace()»"
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			xmlns:jxb="http://java.sun.com/xml/ns/jaxb"
			«FOR imp : service.allImportedVersionedNS (service.version.toMajorVersionNumber(), minState)»
			xmlns:«imp.toPrefix()+imp.version.toMajorVersionNumber()»="«imp.toNamespace()»"
			«ENDFOR»
			«IF service.findBestMatchingHeader(profile) != null»
				«FOR headerImp : service.findBestMatchingHeader(profile).allImportedVersionedNS(service.version.toMajorVersionNumber())»
					xmlns:«headerImp.toPrefix() + headerImp.version.toMajorVersionNumber()»="«headerImp.toNamespace()»"
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
			<xsd:import schemaLocation="«headerImp.toRegistryAssetUrl (registryBaseUrl)».xsd"
				namespace="«headerImp.toNamespace()»"/>
				«ENDFOR»
			«ENDIF»
			
			<xsd:annotation>
		   		<xsd:documentation>
					<![CDATA[Version «service.version.toVersionNumber()»
					Lifecycle state: «service.state.toString()»
					
					«service.doc?.trim()?.stripCommentBraces()»]]>
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
					xmlns:«headerImp.toPrefix()+headerImp.version.toMajorVersionNumber()»="«headerImp.toNamespace()»"
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
					<xsd:import schemaLocation="«headerImp.toRegistryAssetUrl (registryBaseUrl)».xsd"
						namespace="«headerImp.toNamespace()»"/>
				«ENDFOR»
			«ENDIF»
			
			<xsd:annotation>
		    	<xsd:documentation>
					<![CDATA[Version «service.version.toVersionNumber()»
					Lifecycle state: «service.state.toString()»
					
					«service.doc?.trim()?.stripCommentBraces()»]]>
		    	</xsd:documentation>
		    </xsd:annotation>
			
			«service.toOperationWrapperMessages (minState, profile)»
		</xsd:schema>
		'''
		
		val xsdFileName = service.toOpWrapperXSDFileName();
		fsa .generateFile (xsdFileName, content);
	}
	
	
	def dispatch toOperationWrapperMessages (Service service, LifecycleState minState, SOAProfile profile) {
		service.operations.forEach (e|e.toConcreteOperationWrapperTypes (profile))
	}
	
	
	def dispatch toConcreteOperationWrapperTypes (Operation op, SOAProfile profile) '''
				<xsd:complexType name="«op.toOperationWrapperRequestType()»">
					<xsd:sequence>
						«IF op.findBestMatchingHeader(profile) != null»
						«op.findBestMatchingHeader (profile).toParameter()»
						«ENDIF»
						«op.parameters.forEach (p|p.toParameter())»
	   				</xsd:sequence>
				</xsd:complexType>
				<xsd:complexType name="«op.toOperationWrapperResponseType()»">
					<xsd:sequence>
						«IF op.findBestMatchingHeader(profile) != null»
							«op.findBestMatchingHeader (profile).toParameter()»
						«ENDIF»
						«op.^return.forEach (r|r.toParameter())»
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
		«header.parameters.forEach (p|p.toParameter())»
	'''
	
}