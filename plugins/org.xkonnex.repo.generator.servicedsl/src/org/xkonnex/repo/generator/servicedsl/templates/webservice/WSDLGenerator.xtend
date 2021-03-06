package org.xkonnex.repo.generator.servicedsl.templates.webservice

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.List
import java.util.logging.Logger
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.generator.IFileSystemAccess
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.generator.profiledsl.schema.ProfileSchemaNamespaceExtensions
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.profileDsl.MessageHeader
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Property
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile
import org.xkonnex.repo.dsl.servicedsl.service.query.HeaderFinder
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceImportQueries
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DomainNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ExceptionRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.InternalNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Parameter
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaTypeExtensions
import org.xkonnex.repo.generator.servicedsl.templates.xsd.XSDGenerator
import org.xkonnex.repo.dsl.profiledsl.query.namespace.TechnicalNamespaceImportQueries
import java.util.Set
import org.xkonnex.repo.dsl.profiledsl.versioning.VersionedTechnicalNamespace
import org.xkonnex.repo.generator.servicedsl.templates.CommonTemplateExtensions
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SwaRefSchemaGenerator
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.ILifecycleStateResolver
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile
import org.xkonnex.repo.dsl.servicedsl.service.namespace.ServiceNamespaceURIProvider
import org.xkonnex.repo.dsl.profiledsl.namespace.ProfileNamespaceURIProvider

/*
 * Template class for generation of abstract WSDLs
 */
class WSDLGenerator {
	
	@Inject IFileSystemAccess fsa

	@Inject extension CommonTemplateExtensions
	@Inject extension org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions schemaNamespaceExt
	@Inject extension SchemaTypeExtensions schemaTypeExt
	@Inject extension ServiceTemplateExtensions
	@Inject extension ServiceNamespaceURIProvider
	@Inject extension HeaderFinder
	@Inject extension NamespaceQuery
	@Inject extension NamespaceImportQueries
	@Inject extension XSDGenerator
	@Inject extension WsdlParameterExtensions
	@Inject extension ILifecycleStateResolver

	@Inject TechnicalNamespaceImportQueries techNsImportQueries
	@Inject VersionQualifierExtensions versionQualifier
	@Inject ProfileSchemaNamespaceExtensions profileSchemaNamespaceExt
	@Inject IEObjectDocumentationProvider docProvider
	@Inject SwaRefSchemaGenerator swarefSchemaGenerator
	@Inject ProfileNamespaceURIProvider profileNamespaceURIProvider
	
	@Inject @Named ("noDependencies") 		
	Boolean noDependencies

	@Inject 
	private Logger log
	
	def dispatch toWSDL (Service s, DomainNamespace subDom, LifecycleState minState, Profile enforcedProfile, String registryBaseUrl) {
		val profile = subDom.getApplicableProfile(enforcedProfile)
		val allServiceExceptionRefs = s.operations.map (o|o.^throws).flatten;
		val content = '''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<wsdl:definitions xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
			xmlns:tns="«s.toTargetNamespace()»"
			xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" 
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			xmlns:jaxws="http://java.sun.com/xml/ns/jaxws"
			xmlns:ref="http://ws-i.org/profiles/basic/1.1/xsd"
			name="«s.name»" 
			targetNamespace="«s.toTargetNamespace()»">
			<wsdl:documentation>
				Version «versionQualifier.toVersionNumber(s.version)»
				Lifecycle state: «s.lifecycleState.toStateName»
				
				«docProvider.getDocumentation (s)»
			</wsdl:documentation>
			
			«s.toTypes (minState, profile, registryBaseUrl)»
			«s.operations.map (e|e.toMessages ()).join»
			«allServiceExceptionRefs.map (t|t.exception.name).toSet().map (e|e.toFaultMessages (allServiceExceptionRefs.toList)).join »
			«s.toPortType»
		</wsdl:definitions>''';
		
		val wsdlFileName = s.toFileNameFragment() + ".wsdl";
		fsa.generateFile (wsdlFileName, content);
	}

	def dispatch toWSDL (Service s, InternalNamespace subDom, LifecycleState minState, Profile enforcedProfile, String registryBaseUrl) {
		val profile = subDom.getApplicableProfile(enforcedProfile)
		val allServiceExceptionRefs = s.operations.map (o|o.^throws).flatten;
		val content = '''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<wsdl:definitions xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
			xmlns:tns="«s.toTargetNamespace()»"
			xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" 
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			xmlns:ref="http://ws-i.org/profiles/basic/1.1/xsd"

		«/*	
			xmlns:jaxws="http://java.sun.com/xml/ns/jaxws"
		*/»
			name="«s.name»" 
			targetNamespace="«s.toTargetNamespace()»">
			<wsdl:documentation>
				<![CDATA[Version «versionQualifier.toVersionNumber(s.version)»
				Lifecycle state: «s.lifecycleState.toStateName»
				
				«docProvider.getDocumentation (s)»]]>
			</wsdl:documentation>
			
			«s.toTypes (minState, profile, registryBaseUrl)»
			«s.operations.map (e|e.toMessages ()).join»
			«allServiceExceptionRefs.map (t|t.exception.name).toSet().map (e|e.toFaultMessages (allServiceExceptionRefs.toList)).join »
			«s.toPortType ()»
		</wsdl:definitions>''';
		
		val wsdlFileName = subDom.toFileNameFragment() + "-" + s.name + "-" + s.version.toVersionPostfix() + ".wsdl";
		fsa.generateFile (wsdlFileName, content);
	}


	def toTypes(Service s, LifecycleState minState, Profile profile, String registryBaseUrl) {
		swarefSchemaGenerator.generateSwaRefSchema11
		val Set<VersionedTechnicalNamespace> headerImports = s.collectTechnicalVersionedNamespaceImports (profile)
		'''
		<wsdl:types>
			<xsd:schema targetNamespace="«s.toTargetNamespace()»"
				xmlns:ref="http://ws-i.org/profiles/basic/1.1/xsd"
				«IF minState !== null»
					«FOR imp : s.importedVersionedNS (versionQualifier.toMajorVersionNumber (s.version), minState) »
						xmlns:«imp.versionedNamespacePrefix»="«imp.versionedNamespaceURI»"
					«ENDFOR»
				«ELSE»
					«FOR imp : s.importedVersionedNS (versionQualifier.toMajorVersionNumber (s.version)) »
						xmlns:«imp.versionedNamespacePrefix»="«imp.versionedNamespaceURI»"
					«ENDFOR»
				«ENDIF»
				«IF !headerImports.empty»
					«FOR headerImp : headerImports»
						xmlns:«profileNamespaceURIProvider.getVersionedNamespacePrefix(headerImp)»="«profileNamespaceURIProvider.getVersionedNamespaceURI(headerImp)»"
					«ENDFOR»
				«ENDIF»
				elementFormDefault="qualified"
				attributeFormDefault="unqualified"
			>
				<xsd:import schemaLocation="swaref.xsd"
					namespace="http://ws-i.org/profiles/basic/1.1/xsd" />
				«/*<xsd:import
					namespace="http://ws-i.org/profiles/basic/1.1/xsd"
					schemaLocation="http://ws-i.org/profiles/basic/1.1/xsd"/>*/»
				«IF minState !== null»
					«FOR imp : s.importedVersionedNS (versionQualifier.toMajorVersionNumber(s.version), minState)»
						<xsd:import schemaLocation="«imp.toSchemaAssetUrl (registryBaseUrl)».xsd"
							namespace="«imp.versionedNamespaceURI»"/>
					«ENDFOR»
				«ELSE»
					«FOR imp : s.importedVersionedNS (versionQualifier.toMajorVersionNumber(s.version))»
						<xsd:import schemaLocation="«imp.toSchemaAssetUrl (registryBaseUrl)».xsd"
							namespace="«imp.versionedNamespaceURI»"/>
					«ENDFOR»
				«ENDIF»
				«IF !headerImports.empty»
					«FOR headerImp : headerImports»
						<xsd:import schemaLocation="«profileSchemaNamespaceExt.toRegistryAssetUrl (headerImp, registryBaseUrl)».xsd"
							namespace="«profileNamespaceURIProvider.getVersionedNamespaceURI(headerImp)»"/>
					«ENDFOR»
				«ENDIF»
				«s.operations.map (e|e.toOperationWrapperTypes (profile)).join»
				«s.operations.map (o|o.^throws).flatten.map(t|t.exception.name).toSet().map (e|e.toOperationFaultWrapperTypes (s.operations.map (o|o.^throws).flatten.toList)).join»
			</xsd:schema>
		</wsdl:types>
		'''
	}


	def toOperationWrapperTypes (Operation o, Profile profile)  '''
		<xsd:element name="«o.name»">
			<xsd:complexType>
				<xsd:sequence>
					«IF o.findBestMatchingRequestHeader (profile) !== null»
						«o.findBestMatchingRequestHeader (profile).toParameter»
					«ENDIF»
					«o.parameters.map (p|p.toParameter()).join»
					«/*
					«IF	o.fetchProfile.size > 1-»
					<xsd:element name="fetchProfileName" type="xsd:string" minOccurs="0" maxOccurs="1" />
					«ENDIF-»
					*/»
					«IF profile.operationsUseExtensibleParameters()»
						<xsd:any maxOccurs="unbounded" minOccurs="0" namespace="##other"
							processContents="skip"/>
					«ENDIF»
				</xsd:sequence>
				«IF profile.operationsUseExtensibleXMLAttributes()»
					<xsd:anyAttribute namespace="##any"/>
	    		«ENDIF»
			</xsd:complexType>
		</xsd:element>
		<xsd:element name="«o.name»Response">
			<xsd:complexType>
				<xsd:sequence>
					«IF o.findBestMatchingResponseHeader(profile) !== null»
						«o.findBestMatchingResponseHeader (profile).toParameter»
					«ENDIF»
					«o.^return.map(r|r.toParameter()).join»
					«IF profile.operationsUseExtensibleParameters()»
						<xsd:any maxOccurs="unbounded" minOccurs="0" namespace="##other"
							processContents="skip"/>
					«ENDIF»
				</xsd:sequence>
				«IF profile.operationsUseExtensibleXMLAttributes()»
					<xsd:anyAttribute namespace="##any"/>
	    		«ENDIF»
			</xsd:complexType>
		</xsd:element>
	'''
	
	def toOperationFaultWrapperTypes(String name, List<ExceptionRef> exceptions) {
		val exRef = exceptions.findFirst (e|e.exception.name == name)
		if (exRef !== null) {
			'''
			<xsd:element name="«exRef.exception.name»" type="«exRef.toExceptionNameRef()»"/>
			'''
		} else {
			''''''
		}
	}
	
	
	def dispatch toParameter (Parameter p) '''
		<xsd:element name="«p.name»" type="«p.toElementType ()»" «IF p.type.isMimeContentMultiPartAttachment()»«p.type.toMimeFragment»«ELSE»«p.toElementCardinality»«ENDIF»></xsd:element>
	'''
	
	def private toElementCardinality(Parameter param) {
		'''«IF param.optional»minOccurs="0"«ENDIF»	«IF param.type.isMany()»maxOccurs="unbounded"«ENDIF»'''
	}
	
	
	def dispatch toParameter (org.xkonnex.repo.dsl.profiledsl.profileDsl.Property prop) '''
		<xsd:element name="«prop.name»" type="«prop.type.toTypeNameRef ()»" «IF prop.optional»minOccurs="0" «ENDIF»«IF prop.type.isMany()»maxOccurs="unbounded"«ENDIF»></xsd:element>
	'''

	
	def toParameter (MessageHeader header) '''
		«header.parameters.map (p|p.toParameter).join»
	'''
	
	
	def toMessages (Operation o) '''
		<wsdl:message name="«o.name»Request">
			<wsdl:part element="tns:«o.name»" name="parameters" />
		</wsdl:message>
		<wsdl:message name="«o.name»Response">
			<wsdl:part element="tns:«o.name»Response" name="parameters" />
		</wsdl:message>
	'''
	
	
	def toPortType (Service s) '''
		<wsdl:portType name="«s.name»">
			<wsdl:documentation>
					<![CDATA[
						Version:	«versionQualifier.toVersionNumber(s.version)»
						Lifecycle state: «s.state.toStateName»

						«docProvider.getDocumentation (s)»
					]]>   			
			</wsdl:documentation>
			«/*
			<jaxws:class>
				<jaxws:javadoc>
					<![CDATA[Version:	«s.version.toVersionNumber()»
					Lifecycle state: «s.state.toString()»
					«IF s.doc != null-»
										
					«s.doc?.stripCommentBraces().trim()»
					«ENDIF-» ]]>   			
				</jaxws:javadoc>
			</jaxws:class>
			*/»
			«s.operations.map (e|e.toOperation ()).join»
		</wsdl:portType>
	'''
	
	
	def toOperation (Operation o) '''
		<wsdl:operation name="«o.name»">
			<wsdl:documentation>
				<![CDATA[«docProvider.getDocumentation (o)»]]>   			
			</wsdl:documentation>
			«/*
				<jaxws:method>
					<jaxws:javadoc>
						<![CDATA[«o.doc?.stripCommentBraces().trim()»]]>   			
					</jaxws:javadoc>
				</jaxws:method>
			*/»
			<wsdl:input message="tns:«o.name»Request" />
			<wsdl:output message="tns:«o.name»Response" />
			«o.toFault()»
		</wsdl:operation>
	'''
	
	
	def toFaultMessages (String name, List<ExceptionRef> exceptions) '''
		<wsdl:message name="«exceptions.findFirst (e|e.exception.name == name)?.exception.name»">
			<wsdl:part name="parameters" element="tns:«exceptions.findFirst (e|e.exception.name == name).exception.name»"></wsdl:part>
		</wsdl:message>
	'''
	
	
	def toFault (Operation o) '''
		«FOR fault : o.^throws»
			<wsdl:fault name="«fault.exception.name.toFirstLower()»" message="tns:«fault.exception.name»"></wsdl:fault>
		«ENDFOR»
	'''
	
	
	def toBinding (Service s) '''
		<wsdl:binding name="«s.name»SOAP"
			type="tns:«s.name»">
			<soap:binding style="document"
				transport="http://schemas.xmlsoap.org/soap/http" />
			«s.operations.map (o|o.toBindingOperation()).join»
		</wsdl:binding>
	'''
	
	
	def toBindingOperation (Operation o) '''
		<wsdl:operation name="«o.name»">
			<soap:operation
				soapAction="«schemaTypeExt.toNamespace(o.eContainer) + o.name»" />
			<wsdl:input>
				<soap:body use="literal" />
			</wsdl:input>
			<wsdl:output>
				<soap:body use="literal" />
			</wsdl:output>
		</wsdl:operation>
	'''
}