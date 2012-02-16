package org.fornax.soa.servicedsl.templates.webservice

import org.fornax.soa.serviceDsl.DomainNamespace
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.serviceDsl.Service
import com.google.inject.Inject
import org.fornax.soa.servicedsl.templates.xsd.SchemaNamespaceExtensions
import org.fornax.soa.serviceDsl.InternalNamespace
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.eclipse.xtext.generator.IFileSystemAccess
import org.fornax.soa.basedsl.CommonStringExtensions
import org.fornax.soa.servicedsl.query.HeaderFinder
import org.fornax.soa.servicedsl.templates.xsd.SchemaTemplateExtensions
import org.fornax.soa.serviceDsl.Operation
import java.util.List
import org.fornax.soa.serviceDsl.ExceptionRef
import org.fornax.soa.serviceDsl.Parameter
import org.fornax.soa.servicedsl.templates.xsd.SchemaTypeExtensions
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader
import org.fornax.soa.servicedsl.query.namespace.NamespaceImportQueries
import org.fornax.soa.servicedsl.templates.xsd.XSDTemplates

class WSDLTemplates {
	
	@Inject IFileSystemAccess fsa

	@Inject extension CommonStringExtensions
	@Inject extension WsdlExtensions
	@Inject extension SchemaNamespaceExtensions
	@Inject extension SchemaTemplateExtensions
	@Inject extension SchemaTypeExtensions
	@Inject extension ServiceTemplateExtensions
	@Inject extension VersionQualifierExtensions
	@Inject extension HeaderFinder
	@Inject extension NamespaceImportQueries
	@Inject extension XSDTemplates
	
	
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
				Version «s.version.toVersionNumber()»
				Lifecycle state: «s.state.toString()»
				
				«s.doc.trim().stripCommentBraces()»
			</wsdl:documentation>
			
			«s.toTypes (minState, profile, registryBaseUrl)»
			«s.operations.forEach (e|e.toMessages ())»
			«allServiceExceptionRefs.map (t|t.exception.name).toSet().forEach (e|e.toFaultMessages (allServiceExceptionRefs.toList)) »
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
				<![CDATA[Version «s.version.toVersionNumber()»
				Lifecycle state: «s.state.toString()»
				
				«s.doc.trim().stripCommentBraces()»]]>
			</wsdl:documentation>
			
			«s.toTypes (minState, profile, registryBaseUrl)»
			«s.operations.forEach (e|e.toMessages ())»
			«allServiceExceptionRefs.map (t|t.exception.name).toSet().forEach (e|e.toFaultMessages (allServiceExceptionRefs.toList)) »
			«s.toPortType ()»
		</wsdl:definitions>''';
		
		val wsdlFileName = subDom.toFileNameFragment() + "-" + s.name + "-" + s.version.toVersionPostfix() + ".wsdl";
		fsa.generateFile (wsdlFileName, content);
	}


	def toTypes(Service s, LifecycleState minState, SOAProfile profile, String registryBaseUrl) '''
		<wsdl:types>
			<xsd:schema targetNamespace="«s.toTargetNamespace()»"
				«FOR imp : s.importedVersionedNS (s.version.toMajorVersionNumber(), minState) »
				xmlns:«imp.toPrefix() + imp.version.toMajorVersionNumber()»="«imp.toNamespace()»"
				«ENDFOR»
				«IF s.findBestMatchingHeader(profile) != null»
				«FOR headerImp : s.findBestMatchingHeader(profile).allImportedVersionedNS(s.version.toMajorVersionNumber())»
				xmlns:«headerImp.toPrefix()+headerImp.version.toMajorVersionNumber()»="«headerImp.toNamespace()»"
				«ENDFOR»
				«ENDIF»
				elementFormDefault="qualified"
				attributeFormDefault="unqualified"
			>
				«FOR imp : s.importedVersionedNS (s.version.toMajorVersionNumber(), minState)»
				<xsd:import schemaLocation="«imp.getRegisteredUrl (registryBaseUrl)».xsd"
					namespace="«imp.toNamespace()»"/>
				«ENDFOR»
				«IF s.findBestMatchingHeader (profile) != null»
				«FOR headerImp : s.findBestMatchingHeader (profile).allImportedVersionedNS (s.version.toMajorVersionNumber())»
				<xsd:import schemaLocation="«headerImp.getRegisteredUrl (registryBaseUrl)».xsd"
					namespace="«headerImp.toNamespace()»"/>
				«ENDFOR»
				«ENDIF»
				«s.operations.forEach (e|e.toOperationWrapperTypes (profile))»
				«s.operations.map (o|o.throws).flatten.map(t|t.exception.name).toSet().forEach (e|e.toOperationFaultWrapperTypes (s.operations.map (o|o.throws).flatten.toList))»
			</xsd:schema>
		</wsdl:types>
	'''


	def void toOperationWrapperTypes (Operation o, SOAProfile profile)  
		'''		<xsd:element name="«o.name»">
					<xsd:complexType>
						<xsd:sequence>
							«IF o.findBestMatchingHeader (profile) != null»
							«o.findBestMatchingHeader (profile).toParameter»
							«ENDIF»
							«o.parameters.forEach (p|p.toParameter())»
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
							«o.^return.forEach(r|r.toParameter())»
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
	
	def toOperationFaultWrapperTypes(String name, List<ExceptionRef> exceptions) '''
		    	<xsd:element name="«exceptions.findFirst (e|e.exception.name == name).exception.toTypeName()»" type="«exceptions.findFirst (e|e.exception.name == name).toExceptionNameRef()»"/>
	'''
	
	
	def dispatch toParameter (Parameter p) '''
							<xsd:element name="«p.name»" type="«p.type.toTypeNameRef ()»" «IF p.optional»minOccurs="0" «ENDIF»«IF p.type.isMany()»maxOccurs="unbounded"«ENDIF» «IF p.type.isAttachment()»«p.type.toAttachmentMimeFragment»«ENDIF»></xsd:element>
	'''
	
	
	def dispatch toParameter (org.fornax.soa.profiledsl.sOAProfileDsl.Property prop) '''
							<xsd:element name="«prop.name»" type="«prop.type.toTypeNameRef ()»" «IF prop.optional»minOccurs="0" «ENDIF»«IF prop.type.isMany()»maxOccurs="unbounded"«ENDIF»></xsd:element>
	'''

	
	def toParameter (MessageHeader header) '''
		«header.parameters.forEach (p|p.toParameter)»
	'''
	
	
	def toMessages (Operation o) '''
		<wsdl:message name="«o.name»Request">
			<wsdl:part element="tns:«o.name»" name="parameters" />
		</wsdl:message>
		<wsdl:message name="«o.name»Response">
			<wsdl:part element="tns:«o.name»Response" name="parameters" />
		</wsdl:message>
	'''
	
	
	def void toPortType (Service s) '''
		<wsdl:portType name="«s.name»">
			<wsdl:documentation>
					<![CDATA[Version:	«s.version.toVersionNumber()»
					Lifecycle state: «s.state.toString()»
					«IF s.doc != null»
										
					«s.doc.stripCommentBraces().trim()»
					«ENDIF» ]]>   			
			</wsdl:documentation>
			«/*
			<jaxws:class>
				<jaxws:javadoc>
					<![CDATA[Version:	«s.version.toVersionNumber()»
					Lifecycle state: «s.state.toString()»
					«IF s.doc != null-»
										
					«s.doc.stripCommentBraces().trim()»
					«ENDIF-» ]]>   			
				</jaxws:javadoc>
			</jaxws:class>
			*/»
			«s.operations.forEach (e|e.toOperation ())»
		</wsdl:portType>
	'''
	
	
	def toOperation (Operation o) '''
			<wsdl:operation name="«o.name»">
				«IF o.doc != null»
				<wsdl:documentation>
					<![CDATA[«o.doc.stripCommentBraces().trim()»]]>   			
				</wsdl:documentation>
				«/*
					<jaxws:method>
						<jaxws:javadoc>
							<![CDATA[«o.doc.stripCommentBraces().trim()»]]>   			
						</jaxws:javadoc>
					</jaxws:method>
				*/»
				«ENDIF»
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
			«s.operations.forEach (o|o.toBindingOperation())»
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