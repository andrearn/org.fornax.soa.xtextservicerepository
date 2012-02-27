package org.fornax.soa.servicedsl.templates.xsd

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtext.generator.IFileSystemAccess
import org.fornax.soa.basedsl.CommonStringExtensions
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader
import org.fornax.soa.profiledsl.sOAProfileDsl.Property
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.serviceDsl.DomainNamespace
import org.fornax.soa.serviceDsl.ExceptionRef
import org.fornax.soa.serviceDsl.InternalNamespace
import org.fornax.soa.serviceDsl.Operation
import org.fornax.soa.serviceDsl.Parameter
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.servicedsl.query.HeaderFinder
import org.fornax.soa.servicedsl.query.namespace.NamespaceImportQueries
import org.fornax.soa.servicedsl.query.namespace.NamespaceQuery
import org.fornax.soa.servicedsl.templates.webservice.ServiceTemplateExtensions
import org.fornax.soa.servicedsl.templates.webservice.WsdlExtensions
import org.fornax.soa.servicedsl.query.type.LatestMatchingTypeFinder

class EventXSDTemplates {
	

	@Inject IFileSystemAccess fsa

	@Inject extension CommonStringExtensions
	@Inject extension WsdlExtensions
	@Inject extension SchemaNamespaceExtensions
	@Inject extension SchemaTemplateExtensions
	@Inject extension SchemaTypeExtensions
	@Inject extension ServiceTemplateExtensions
	@Inject extension VersionQualifierExtensions
	@Inject extension HeaderFinder
	@Inject extension NamespaceQuery
	@Inject extension NamespaceImportQueries
	@Inject extension XSDTemplates
	@Inject extension OperationWrapperTemplates
	@Inject extension LatestMatchingTypeFinder
	
	
	def dispatch toEventsInclSubNamespaces (String namespace, List<SubNamespace> namespaces, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		for (ns : namespaces.filter (e|e.name.startsWith (namespace))) {
			ns.toEvents (minState, profile, registryBaseUrl);
		}
	}
	
	def dispatch toEvents (SubNamespace ns, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		ns.services.forEach (s|s.toEvents (ns, minState, profile, registryBaseUrl));
	}
	
	def dispatch void toEvents (Service svc, SubNamespace subDom, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
	}
	
	def dispatch toEvents (Service svc, DomainNamespace subDom, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		val content = '''<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<xsd:schema targetNamespace="«svc.toTargetNamespace()»"
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			xmlns:jxb="http://java.sun.com/xml/ns/jaxb"
			«FOR imp : svc.allImportedVersionedNS(svc.version.toMajorVersionNumber(), minState)»
				xmlns:«imp.toPrefix()+imp.version.toMajorVersionNumber()»="«imp.toNamespace()»"
			«ENDFOR»
			«IF svc.findBestMatchingHeader(profile) != null»
				«FOR headerImp : svc.findBestMatchingHeader(profile).allImportedVersionedNS(svc.version.toMajorVersionNumber())»
					xmlns:«headerImp.toPrefix()+headerImp.version.toMajorVersionNumber()»="«headerImp.toNamespace()»"
				«ENDFOR»
			«ENDIF»
			elementFormDefault="qualified"
			attributeFormDefault="unqualified"
			>
			
			«FOR imp : svc.allImportedVersionedNS(svc.version.toMajorVersionNumber(), minState)»
				<xsd:import schemaLocation="«imp.toRegistryAssetUrl (registryBaseUrl)».xsd"
					namespace="«imp.toNamespace()»"/>
			«ENDFOR»
			«IF svc.findBestMatchingHeader(profile) != null»
				«FOR headerImp : svc.findBestMatchingHeader(profile).allImportedVersionedNS(svc.version.toMajorVersionNumber())»
			<xsd:import schemaLocation="«headerImp.toRegistryAssetUrl (registryBaseUrl)».xsd"
				namespace="«headerImp.toNamespace()»"/>
				«ENDFOR»
			«ENDIF»
			
			<xsd:annotation>
		   		<xsd:documentation>
					<![CDATA[Version «svc.version.toVersionNumber()»
					Lifecycle state: «svc.state.toString()»
					
					«svc.doc?.trim()?.stripCommentBraces()»]]>
			   	</xsd:documentation>
		   	</xsd:annotation>
			
			«svc.toEventMessages (minState, profile)»
		</xsd:schema>
		'''
	
		val xsdFileName = svc.toFileNameFragment() + "Events.xsd";
		fsa.generateFile (xsdFileName, content);
	}
	
	def dispatch toEvents (Service svc, InternalNamespace subDom, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		val content = '''<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<xsd:schema targetNamespace="«svc.toTargetNamespace()»"
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			«FOR imp : svc.allImportedVersionedNS(svc.version.toMajorVersionNumber(), minState)»
			xmlns:«imp.toPrefix()+imp.version.toMajorVersionNumber()»="«imp.toNamespace()»"
			«ENDFOR»
			«IF svc.findBestMatchingHeader(profile) != null»
				«FOR headerImp : svc.findBestMatchingHeader(profile).allImportedVersionedNS(svc.version.toMajorVersionNumber())»
			xmlns:«headerImp.toPrefix()+headerImp.version.toMajorVersionNumber()»="«headerImp.toNamespace()»"
				«ENDFOR»
			«ENDIF»
			elementFormDefault="qualified"
			attributeFormDefault="unqualified"
			>
			
			«FOR imp : svc.allImportedVersionedNS(svc.version.toMajorVersionNumber(), minState)»
			<xsd:import schemaLocation="«imp.toRegistryAssetUrl (registryBaseUrl)».xsd"
				namespace="«imp.toNamespace()»"/>
			«ENDFOR»
			«IF svc.findBestMatchingHeader(profile) != null»
				«FOR headerImp : svc.findBestMatchingHeader(profile).allImportedVersionedNS(svc.version.toMajorVersionNumber())»
			<xsd:import schemaLocation="«headerImp.toRegistryAssetUrl (registryBaseUrl)».xsd"
				namespace="«headerImp.toNamespace()»"/>
				«ENDFOR»
			«ENDIF»
			
			<xsd:annotation>
		    	<xsd:documentation>
					<![CDATA[Version «svc.version.toVersionNumber()»
					Lifecycle state: «svc.state.toString()»
					
					«svc.doc?.trim()?.stripCommentBraces()»]]>
		    	</xsd:documentation>
		    </xsd:annotation>
			
			«svc.toEventMessages(minState, profile)»
		</xsd:schema>
		'''
		val xsdFileName = subDom.toFileNameFragment() + "-" + svc.name + "-" + svc.version.toVersionPostfix() + "Events.xsd";
		fsa.generateFile (xsdFileName, content);
	}
	
	
	def dispatch toEventMessages(Service svc, LifecycleState minState, SOAProfile profile) '''
		«svc.operations.forEach (o|o.toOperationWrapperTypes (profile))»
		«svc.operations.map (o|o.throws).flatten.map (t|t.exception.name).toSet().forEach (o|o.toOperationFaultWrapperTypes(svc.operations.map (op|op.throws).flatten.toList()))»
	'''
	
	
	def dispatch toOperationWrapperTypes (Operation op, SOAProfile profile) '''
		<xsd:element name="«op.name.toFirstUpper()»">
			<xsd:complexType>
				<xsd:sequence>
					«IF op.findBestMatchingHeader(profile) != null»
						«op.findBestMatchingHeader (profile).toParameter()»
					«ENDIF»
					«op.parameters.map (p|p.toParameter ())»
				</xsd:sequence>
			</xsd:complexType>
		</xsd:element>
		<xsd:element name="«op.name.toFirstUpper()»Response">
			<xsd:complexType>
				<xsd:sequence>
					«IF op.findBestMatchingHeader(profile) != null»
						«op.findBestMatchingHeader (profile).toParameter ()»
					«ENDIF»
					«op.^return.map (r|r.toParameter ())»
				</xsd:sequence>
			</xsd:complexType>
		</xsd:element>
	'''
	
	def dispatch toOperationFaultWrapperTypes(String faultName, List<ExceptionRef> exceptions) '''
    	<xsd:element name="«exceptions.findFirst(e|e.exception.name == faultName).exception.toTypeName()»" type="«exceptions.findFirst (e|e.exception.name == faultName).toExceptionNameRef()»"/>
	'''
	
	def dispatch toParameter (Parameter param) '''
		<xsd:element param.name="«param.name»" type="«param.type.toTypeNameRef ()»" «IF param.optional»minOccurs="0" «ENDIF»«IF param.type.isMany()»maxOccurs="unbounded"«ENDIF»></xsd:element>
	'''
	
	def dispatch toParameter (org.fornax.soa.profiledsl.sOAProfileDsl.Property prop) '''
		<xsd:element name="«prop.name»" type="«prop.type.toTypeNameRef ()»" «IF prop.optional»minOccurs="0" «ENDIF»«IF prop.type.isMany()»maxOccurs="unbounded"«ENDIF»></xsd:element>
	'''
	
	def dispatch toParameter (MessageHeader header) '''
		«header.parameters.forEach (p|p.toParameter)»
	'''
		
}