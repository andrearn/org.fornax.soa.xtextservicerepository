package org.fornax.soa.servicedsl.generator.templates.xsd

import com.google.inject.Inject
import java.util.List
import java.util.logging.Logger
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.generator.IFileSystemAccess
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader
import org.fornax.soa.profiledsl.sOAProfileDsl.Property
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.service.query.HeaderFinder
import org.fornax.soa.service.query.namespace.NamespaceImportQueries
import org.fornax.soa.serviceDsl.DomainNamespace
import org.fornax.soa.serviceDsl.ExceptionRef
import org.fornax.soa.serviceDsl.InternalNamespace
import org.fornax.soa.serviceDsl.Operation
import org.fornax.soa.serviceDsl.Parameter
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.SubNamespace
import org.fornax.soa.servicedsl.generator.templates.webservice.ServiceTemplateExtensions
import org.fornax.soa.profiledsl.versioning.VersionedTechnicalNamespace
import java.util.Set

class EventXSDGenerator {
	

	@Inject IFileSystemAccess fsa

	@Inject extension SchemaNamespaceExtensions
	@Inject extension SchemaTypeExtensions
	@Inject extension ServiceTemplateExtensions
	@Inject extension VersionQualifierExtensions
	@Inject extension HeaderFinder
	@Inject extension NamespaceImportQueries
	
	@Inject IEObjectDocumentationProvider docProvider

	@Inject 
	private Logger log
	
	
	def toEventsInclSubNamespaces (String namespace, List<SubNamespace> namespaces, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		for (ns : namespaces.filter (e|e.name.startsWith (namespace))) {
			ns.toEvents (minState, profile, registryBaseUrl);
		}
	}
	
	def toEvents (SubNamespace ns, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		ns.services.forEach (s|s.toEvents (ns, minState, profile, registryBaseUrl));
	}
	
	def dispatch void toEvents (Service svc, SubNamespace subDom, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
	}
	
	def dispatch toEvents (Service svc, DomainNamespace subDom, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		val Set<VersionedTechnicalNamespace> headerImports = svc.collectTechnicalVersionedNamespaceImports (profile)
		val content = '''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<xsd:schema targetNamespace="«svc.toTargetNamespace()»"
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			xmlns:jxb="http://java.sun.com/xml/ns/jaxb"
			«FOR imp : svc.allImportedVersionedNS(svc.version.toMajorVersionNumber(), minState)»
				xmlns:«imp.toPrefix()+imp.version.toMajorVersionNumber()»="«imp.toNamespace()»"
			«ENDFOR»
			«IF !headerImports.empty»
				«FOR headerImp : headerImports»
					xmlns:«headerImp.toPrefix()+headerImp.version.toMajorVersionNumber()»="«headerImp.toNamespace()»"
				«ENDFOR»
			«ENDIF»
			elementFormDefault="qualified"
			attributeFormDefault="unqualified"
			>
			
			«FOR imp : svc.allImportedVersionedNS(svc.version.toMajorVersionNumber(), minState)»
				<xsd:import schemaLocation="«imp.toSchemaAssetUrl (registryBaseUrl)».xsd"
					namespace="«imp.toNamespace()»"/>
			«ENDFOR»
			«IF !headerImports.empty»
				«FOR headerImp : headerImports»
					<xsd:import schemaLocation="«headerImp.toSchemaAssetUrl (registryBaseUrl)».xsd"
						namespace="«headerImp.toNamespace()»"/>
				«ENDFOR»
			«ENDIF»
			
			<xsd:annotation>
		   		<xsd:documentation>
					<![CDATA[Version «svc.version.toVersionNumber()»
					Lifecycle state: «svc.state.name»
					
					«docProvider.getDocumentation (svc)»]]>
			   	</xsd:documentation>
		   	</xsd:annotation>
			
			«svc.toEventMessages (minState, profile)»
		</xsd:schema>
		'''
	
		val xsdFileName = svc.toFileNameFragment() + "Events.xsd";
		fsa.generateFile (xsdFileName, content);
	}
	
	def dispatch toEvents (Service svc, InternalNamespace subDom, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		val Set<VersionedTechnicalNamespace> headerImports = svc.collectTechnicalVersionedNamespaceImports (profile)
		val content = '''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<xsd:schema targetNamespace="«svc.toTargetNamespace()»"
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			«FOR imp : svc.allImportedVersionedNS(svc.version.toMajorVersionNumber(), minState)»
				xmlns:«imp.toPrefix()+imp.version.toMajorVersionNumber()»="«imp.toNamespace()»"
			«ENDFOR»
			«IF !headerImports.empty»
				«FOR headerImp : headerImports»
					xmlns:«headerImp.toPrefix()+headerImp.version.toMajorVersionNumber()»="«headerImp.toNamespace()»"
				«ENDFOR»
			«ENDIF»
			elementFormDefault="qualified"
			attributeFormDefault="unqualified"
			>
			
			«FOR imp : svc.allImportedVersionedNS(svc.version.toMajorVersionNumber(), minState)»
				<xsd:import schemaLocation="«imp.toSchemaAssetUrl (registryBaseUrl)».xsd"
					namespace="«imp.toNamespace()»"/>
			«ENDFOR»
			«IF !headerImports.empty»
				«FOR headerImp : headerImports»
					<xsd:import schemaLocation="«headerImp.toSchemaAssetUrl (registryBaseUrl)».xsd"
						namespace="«headerImp.toNamespace()»"/>
				«ENDFOR»
			«ENDIF»
			
			<xsd:annotation>
		    	<xsd:documentation>
					<![CDATA[Version «svc.version.toVersionNumber()»
					Lifecycle state: «svc.state.name»
					
					«docProvider.getDocumentation (svc)»]]>
		    	</xsd:documentation>
		    </xsd:annotation>
			
			«svc.toEventMessages(minState, profile)»
		</xsd:schema>
		'''
		val xsdFileName = subDom.toFileNameFragment() + "-" + svc.name + "-" + svc.version.toVersionPostfix() + "Events.xsd";
		fsa.generateFile (xsdFileName, content);
	}
	
	
	def toEventMessages(Service svc, LifecycleState minState, SOAProfile profile) '''
		«svc.operations.map (o|o.toOperationWrapperTypes (profile)).join»
		«svc.operations.map (o|o.^throws).flatten.map (t|t.exception.name).toSet().map (o|o.toOperationFaultWrapperTypes(svc.operations.map (op|op.^throws).flatten.toList())).join»
	'''
	
	
	def toOperationWrapperTypes (Operation op, SOAProfile profile) '''
		<xsd:element name="«op.name.toFirstUpper()»">
			<xsd:complexType>
				<xsd:sequence>
					«IF op.findBestMatchingRequestHeader(profile) != null»
						«op.findBestMatchingRequestHeader (profile).toParameter()»
					«ENDIF»
					«op.parameters.map (p|p.toParameter ()).join»
				</xsd:sequence>
			</xsd:complexType>
		</xsd:element>
		<xsd:element name="«op.name.toFirstUpper()»Response">
			<xsd:complexType>
				<xsd:sequence>
					«IF op.findBestMatchingResponseHeader(profile) != null»
						«op.findBestMatchingResponseHeader (profile).toParameter ()»
					«ENDIF»
					«op.^return?.map (r|r.toParameter ()).join»
				</xsd:sequence>
			</xsd:complexType>
		</xsd:element>
	'''
	
	def toOperationFaultWrapperTypes(String faultName, List<ExceptionRef> exceptions) { 
		val exceptionRef = exceptions.findFirst(e|e.exception.name == faultName);
		if (exceptionRef != null) {
			'''
	    	<xsd:element name="«exceptionRef?.exception.name»" type="«exceptionRef?.toExceptionNameRef()»"/>
			'''
		}
	}
	
	def dispatch toParameter (Parameter param) '''
		<xsd:element param.name="«param.name»" type="«param.type.toTypeNameRef ()»" «IF param.optional»minOccurs="0" «ENDIF»«IF param.type.isMany()»maxOccurs="unbounded"«ENDIF»></xsd:element>
	'''
	
	def dispatch toParameter (org.fornax.soa.profiledsl.sOAProfileDsl.Property prop) '''
		<xsd:element name="«prop.name»" type="«prop.type.toTypeNameRef ()»" «IF prop.optional»minOccurs="0" «ENDIF»«IF prop.type.isMany()»maxOccurs="unbounded"«ENDIF»></xsd:element>
	'''
	
	def dispatch toParameter (MessageHeader header) '''
		«header.parameters.map (p|p.toParameter).join»
	'''
		
}