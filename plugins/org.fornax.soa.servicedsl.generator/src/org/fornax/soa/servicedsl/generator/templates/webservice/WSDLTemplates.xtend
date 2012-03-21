package org.fornax.soa.servicedsl.generator.templates.webservice

import org.fornax.soa.serviceDsl.DomainNamespace
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.serviceDsl.Service
import com.google.inject.Inject
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
import org.fornax.soa.serviceDsl.InternalNamespace
import org.fornax.soa.basedsl.generator.version.VersionQualifierExtensions
import org.eclipse.xtext.generator.IFileSystemAccess
import org.fornax.soa.basedsl.generator.CommonStringExtensions
import org.fornax.soa.servicedsl.generator.query.HeaderFinder
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaTemplateExtensions
import org.fornax.soa.serviceDsl.Operation
import java.util.List
import org.fornax.soa.serviceDsl.ExceptionRef
import org.fornax.soa.serviceDsl.Parameter
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaTypeExtensions
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader
import org.fornax.soa.servicedsl.generator.query.namespace.NamespaceImportQueries
import org.fornax.soa.servicedsl.generator.templates.xsd.XSDTemplates
import org.fornax.soa.servicedsl.generator.query.type.LatestMatchingTypeFinder
import com.google.inject.name.Named
import org.fornax.soa.profiledsl.generator.schema.ProfileSchemaNamespaceExtensions
import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider

/*
 * Template class for generation of abstract WSDLs
 */
class WSDLTemplates {
	
	@Inject IFileSystemAccess fsa

	@Inject extension CommonStringExtensions
	@Inject extension WsdlExtensions
	@Inject extension org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
	@Inject extension SchemaTemplateExtensions
	@Inject extension SchemaTypeExtensions
	@Inject extension ServiceTemplateExtensions
	@Inject extension HeaderFinder
	@Inject extension NamespaceImportQueries
	@Inject extension XSDTemplates
	@Inject extension LatestMatchingTypeFinder

	@Inject VersionQualifierExtensions versionQualifier
	@Inject ProfileSchemaNamespaceExtensions profileSchemaNamespaceExt
	@Inject IEObjectDocumentationProvider docProvider	
	
	@Inject @Named ("noDependencies") 		
	Boolean noDependencies
	
	def dispatch toWSDL (Service s, DomainNamespace subDom, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		val allServiceExceptionRefs = s.operations.map (o|o.throws).flatten;
		val content = '''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<wsdl:definitions xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
			xmlns:tns="«s.toTargetNamespace()»"
			xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" 
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			xmlns:jaxws="http://java.sun.com/xml/ns/jaxws"
			name="«s.name»" 
			targetNamespace="«s.toTargetNamespace()»">
			<wsdl:documentation>
				Version «versionQualifier.toVersionNumber(s.version)»
				Lifecycle state: «s.state.name»
				
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

	def dispatch toWSDL (Service s, InternalNamespace subDom, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		val allServiceExceptionRefs = s.operations.map (o|o.throws).flatten;
		val content = '''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<wsdl:definitions xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
			xmlns:tns="«s.toTargetNamespace()»"
			xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" 
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
		«/*	
			xmlns:jaxws="http://java.sun.com/xml/ns/jaxws"
		*/»
			name="«s.name»" 
			targetNamespace="«s.toTargetNamespace()»">
			<wsdl:documentation>
				<![CDATA[Version «versionQualifier.toVersionNumber(s.version)»
				Lifecycle state: «s.state.name»
				
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


	def toTypes(Service s, LifecycleState minState, SOAProfile profile, String registryBaseUrl) '''
		<wsdl:types>
			<xsd:schema targetNamespace="«s.toTargetNamespace()»"
				«FOR imp : s.importedVersionedNS (versionQualifier.toMajorVersionNumber (s.version), minState) »
					xmlns:«imp.toPrefix() + versionQualifier.toMajorVersionNumber (imp.version)»="«imp.toNamespace()»"
				«ENDFOR»
				«IF s.findBestMatchingHeader(profile) != null»
					«FOR headerImp : s.findBestMatchingHeader (profile).allImportedVersionedNS(versionQualifier.toMajorVersionNumber(s.version))»
						xmlns:«profileSchemaNamespaceExt.toPrefix (headerImp)+versionQualifier.toMajorVersionNumber (headerImp.version)»="«profileSchemaNamespaceExt.toNamespace(headerImp)»"
					«ENDFOR»
				«ENDIF»
				elementFormDefault="qualified"
				attributeFormDefault="unqualified"
			>
				«FOR imp : s.importedVersionedNS (versionQualifier.toMajorVersionNumber(s.version), minState)»
					<xsd:import schemaLocation="«imp.toRegistryAssetUrl (registryBaseUrl)».xsd"
						namespace="«imp.toNamespace ()»"/>
				«ENDFOR»
				«IF s.findBestMatchingHeader (profile) != null»
					«FOR headerImp : s.findBestMatchingHeader (profile).allImportedVersionedNS (versionQualifier.toMajorVersionNumber(s.version))»
						<xsd:import schemaLocation="«profileSchemaNamespaceExt.toRegistryAssetUrl (headerImp, registryBaseUrl)».xsd"
							namespace="«profileSchemaNamespaceExt.toNamespace (headerImp)»"/>
					«ENDFOR»
				«ENDIF»
				«s.operations.map (e|e.toOperationWrapperTypes (profile)).join»
				«s.operations.map (o|o.throws).flatten.map(t|t.exception.name).toSet().map (e|e.toOperationFaultWrapperTypes (s.operations.map (o|o.throws).flatten.toList)).join»
			</xsd:schema>
		</wsdl:types>
	'''


	def toOperationWrapperTypes (Operation o, SOAProfile profile)  '''
		<xsd:element name="«o.name»">
			<xsd:complexType>
				<xsd:sequence>
					«IF o.findBestMatchingHeader (profile) != null»
						«o.findBestMatchingHeader (profile).toParameter»
					«ENDIF»
					«o.parameters.map (p|p.toParameter()).join»
					«/*
					«IF	o.fetchProfile.size > 1-»
					<xsd:element name="fetchProfileName" type="xsd:string" minOccurs="0" maxOccurs="1" />
					«ENDIF-»
					*/»
					«IF profile.operationsUseExtendableParameters()»
						<xsd:any maxOccurs="unbounded" minOccurs="0" namespace="##other"
							processContents="skip"/>
					«ENDIF»
	    		</xsd:sequence>
	    		«IF profile.operationsUseExtendableXMLAttributes()»
					<xsd:anyAttribute namespace="##any"/>
	    		«ENDIF»
			</xsd:complexType>
		</xsd:element>
		<xsd:element name="«o.name»Response">
			<xsd:complexType>
				<xsd:sequence>
					«IF o.findBestMatchingHeader(profile) != null»
						«o.findBestMatchingHeader (profile).toParameter»
					«ENDIF»
					«o.^return.map(r|r.toParameter()).join»
					«IF profile.operationsUseExtendableParameters()»
						<xsd:any maxOccurs="unbounded" minOccurs="0" namespace="##other"
							processContents="skip"/>
					«ENDIF»
				</xsd:sequence>
	    		«IF profile.operationsUseExtendableXMLAttributes()»
					<xsd:anyAttribute namespace="##any"/>
				«ENDIF»
			</xsd:complexType>
		</xsd:element>
	'''
	
	def toOperationFaultWrapperTypes(String name, List<ExceptionRef> exceptions) {
		val exRef = exceptions.findFirst (e|e.exception.name == name)
		'''
		<xsd:element name="«exRef.exception.toTypeName()»" type="«exRef.toExceptionNameRef()»"/>
		'''
	
	}
	
	
	def dispatch toParameter (Parameter p) '''
		<xsd:element name="«p.name»" type="«p.type.toTypeNameRef ()»" «IF p.optional»minOccurs="0" «ENDIF»«IF p.type.isMany()»maxOccurs="unbounded"«ENDIF» «IF p.type.isAttachment()»«p.type.toAttachmentMimeFragment»«ENDIF»></xsd:element>
	'''
	
	
	def dispatch toParameter (org.fornax.soa.profiledsl.sOAProfileDsl.Property prop) '''
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
						Lifecycle state: «s.state.name»

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
		<wsdl:message name="«exceptions.findFirst (e|e.exception.name == name).exception.toTypeName()»">
	  		<wsdl:part name="parameters" element="tns:«exceptions.findFirst (e|e.exception.name == name).exception.toTypeName()»"></wsdl:part>
		</wsdl:message>
	'''
	
	
	def toFault (Operation o) '''
		«FOR fault : o.throws»
			<wsdl:fault name="«fault.exception.toTypeName().toFirstLower()»" message="tns:«fault.exception.toTypeName()»"></wsdl:fault>
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
				soapAction="«o.eContainer.toNamespace() + o.name»" />
			<wsdl:input>
				<soap:body use="literal" />
			</wsdl:input>
			<wsdl:output>
				<soap:body use="literal" />
			</wsdl:output>
		</wsdl:operation>
	'''
}