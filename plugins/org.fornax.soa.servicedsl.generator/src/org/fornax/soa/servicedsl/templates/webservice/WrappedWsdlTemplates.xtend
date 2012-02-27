package org.fornax.soa.servicedsl.templates.webservice

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtext.generator.IFileSystemAccess
import org.fornax.soa.basedsl.CommonStringExtensions
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState
import org.fornax.soa.basedsl.version.VersionQualifierExtensions
import org.fornax.soa.profiledsl.sOAProfileDsl.MessageHeader
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
import org.fornax.soa.servicedsl.templates.xsd.OperationWrapperTemplates
import org.fornax.soa.servicedsl.templates.xsd.SchemaNamespaceExtensions
import org.fornax.soa.servicedsl.templates.xsd.SchemaTemplateExtensions
import org.fornax.soa.servicedsl.templates.xsd.SchemaTypeExtensions
import org.fornax.soa.servicedsl.templates.xsd.XSDTemplates
import org.fornax.soa.profiledsl.sOAProfileDsl.Property
import org.fornax.soa.servicedsl.query.type.LatestMatchingTypeFinder

class WrappedWsdlTemplates {
	
	
	@Inject IFileSystemAccess fsa

	@Inject extension CommonStringExtensions
	@Inject extension WsdlExtensions
	@Inject extension org.fornax.soa.servicedsl.templates.xsd.SchemaNamespaceExtensions
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
	
	
	/*
		CARTRIDGE ENTRYPOINT for generation of abstract wrapped  WSDLs
		Abstract WSDLs only define the abstract interface of a service. The binding is declared
		in a separate WSDL that imports this abstract WSDL
		
		A WSDL for each Service in the given SubNamespace matching the given minimal LifecycleState
		will be generated. For each major version of a service WSDL is generated for the latest minor
		version in that major version matching the minimal Lifecycle constraint is be generated
	*/
	def dispatch toWrappedWSDL(Service svc, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		svc.toWrappedWSDL (svc.findSubdomain(), minState, profile, registryBaseUrl);
	}
	
	def dispatch void toWrappedWSDL(Service svc, SubNamespace subDom, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
	}
	
	def dispatch WrappedWSDL(Service svc, DomainNamespace subDom, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		val allServiceExceptionRefs = svc.operations.map (o|o.throws).flatten;
		svc.toOperationWrappers (subDom, minState, profile, registryBaseUrl);
		val content = '''<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<wsdl:definitions xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
			xmlns:tns="«svc.toWrapperServiceTargetNamespace()»"
			xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" 
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			xmlns:jaxws="http://java.sun.com/xml/ns/jaxws"
			name="«svc.name»" 
			targetNamespace="«svc.toWrapperServiceTargetNamespace()»">
			<wsdl:documentation>
				Version «svc.version.toVersionNumber()»
				Lifecycle state: «svc.state.toString()»
				
				«svc.doc?.trim()?.stripCommentBraces()»
			</wsdl:documentation>
			
			«svc.toTypes(minState, profile, registryBaseUrl)»
			«svc.operations.forEach (o|o.toMessages ())»
			«allServiceExceptionRefs.map (r|r.exception.name).toSet().forEach (n|n.toFaultMessages(allServiceExceptionRefs.toList))»
			«svc.toPortType()»
		</wsdl:definitions>
		'''
		val xsdFileName = svc.getWrappedWSDLFileName();
		fsa.generateFile (xsdFileName, content);
	}
	
	def dispatch toWrappedWSDL(Service svc, InternalNamespace subDom, LifecycleState minState, SOAProfile profile, String registryBaseUrl) {
		val allServiceExceptionRefs = svc.operations.map (o|o.throws).flatten;
		
	svc.toOperationWrappers (subDom, minState, profile, registryBaseUrl);
	val xsdFileName = subDom.toFileNameFragment() + "-" + svc.name + "-" + svc.version.toVersionPostfix() + "Wrapped.wsdl";
	val content = '''<?xml version="1.0" encoding="UTF-8" standalone="no"?>
	<wsdl:definitions xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
		xmlns:tns="«svc.toWrapperServiceTargetNamespace()»"
		xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" 
		xmlns:xsd="http://www.w3.org/2001/XMLSchema"
	«/*	
		xmlns:jaxws="http://java.sun.com/xml/ns/jaxws"
	*/»
		name="«svc.name»" 
		targetNamespace="«svc.toWrapperServiceTargetNamespace()»">
		<wsdl:documentation>
			<![CDATA[Version «svc.version.toVersionNumber()»
			Lifecycle state: «svc.state.toString()»
			
			«svc.doc?.trim()?.stripCommentBraces()»]]>
		</wsdl:documentation>
		
		«svc.toTypes(minState, profile, registryBaseUrl)»
		«svc.operations.forEach (o|o.toMessages())»
		«allServiceExceptionRefs.map(r|r.exception.name).toSet().forEach (n|n.toFaultMessages(allServiceExceptionRefs.toList))»
		«svc.toPortType»
	</wsdl:definitions>
	'''
	}
	
	def dispatch toTypes(Service svc, LifecycleState minState, SOAProfile profile, String registryBaseUrl) '''
		<wsdl:types>
			<xsd:schema targetNamespace="«svc.toWrapperServiceTargetNamespace()»"
				«FOR imp : svc.importedVersionedNS(svc.version.toMajorVersionNumber(), minState)»
				xmlns:«imp.toPrefix()+imp.version.toMajorVersionNumber()»="«imp.toNamespace()»"
				«ENDFOR»
				xmlns:svc="«svc.toWrapperTargetNamespace()»"
				elementFormDefault="qualified"
				attributeFormDefault="unqualified"
			>
				«FOR imp : svc.importedVersionedNS(svc.version.toMajorVersionNumber(), minState) »
				<xsd:import schemaLocation="«imp.toRegistryAssetUrl (registryBaseUrl)».xsd"
					namespace="«imp.toNamespace()»"/>
				«ENDFOR»
				<xsd:import schemaLocation="«svc.getRegisteredOperationWrapperUrl (registryBaseUrl)»"
					namespace="«svc.toWrapperTargetNamespace()»"/>
				«svc.operations.forEach (o|o.toOperationWrapperTypes (profile))»
				«svc.operations.map (o|o.throws).flatten.map(t|t.exception.name).toSet().forEach (n|n.toOperationFaultWrapperTypes (svc.operations.map (o|o.throws).flatten.toList))»
			</xsd:schema>
		</wsdl:types>
	'''
	
	def dispatch toOperationWrapperTypes (Operation op, SOAProfile profile) '''
		<xsd:element name="«op.name»">
			<xsd:complexType>
				<xsd:sequence>
					<xsd:element name="request" type="svc:«op.toOperationWrapperRequestType()»"/>
				</xsd:sequence>
			</xsd:complexType>
		</xsd:element>
		<xsd:element name="«op.name»Response">
			<xsd:complexType>
				<xsd:sequence>
					<xsd:element name="response" type="svc:«op.toOperationWrapperResponseType()»"/>
				</xsd:sequence>
			</xsd:complexType>
		</xsd:element>
	'''
	
	def dispatch toOperationFaultWrapperTypes(String faultName, List<ExceptionRef> exceptions) '''
		<xsd:element name="«exceptions.findFirst(e|e.exception.name == faultName).exception.toTypeName()»" type="«exceptions.findFirst(e|e.exception.name == this).toExceptionNameRef()»"/>
	'''
	
	def dispatch toParameter (Parameter param) '''
		<xsd:element name="«param.name»" type="«param.type.toTypeNameRef ()»" «IF param.optional»minOccurs="0" «ENDIF»«IF param.type.isMany()»maxOccurs="unbounded"«ENDIF» «IF param.type.isAttachment()»«param.type.toAttachmentMimeFragment()»«ENDIF»></xsd:element>
	'''
	
	def dispatch toParameter (Property prop) '''
		<xsd:element name="«prop.name»" type="«prop.type.toTypeNameRef ()»" «IF prop.optional»minOccurs="0" «ENDIF»«IF prop.type.isMany()»maxOccurs="unbounded"«ENDIF»></xsd:element>
	'''
	
	def dispatch toParameter (MessageHeader header) '''
		«header.parameters.forEach (p|p.toParameter())»
	'''
	
	
	def dispatch toMessages (Operation op) '''
		<wsdl:message name="«op.name»Request">
			<wsdl:part element="tns:«op.name»" name="parameters" />
		</wsdl:message>
		<wsdl:message name="«op.name»Response">
			<wsdl:part element="tns:«op.name»Response" name="parameters" />
		</wsdl:message>
	'''
	
	def dispatch toPortType (Service svc) '''
		<wsdl:portType name="«svc.name»Wrapped">
			<wsdl:documentation>
					<![CDATA[Version:	«svc.version.toVersionNumber()»
					Lifecycle state: «svc.state.toString()»
					«IF svc.doc != null»
										
					«svc.doc?.stripCommentBraces()?.trim()»
					«ENDIF» ]]>   			
			</wsdl:documentation>
			«/*
			<jaxws:class>
				<jaxws:javadoc>
					<![CDATA[Version:	«version.toVersionNumber()»
					Lifecycle state: «state.toString()»
					«IF doc != null-»
										
					«doc?.stripCommentBraces()?.trim()»
					«ENDIF-» ]]>   			
				</jaxws:javadoc>
			</jaxws:class>
			*/»
			«svc.operations.forEach (o|o.toOperation ())»
		</wsdl:portType>
	'''
	
	def dispatch toOperation (Operation op) '''
			<wsdl:operation name="«op.name»">
				«IF op.doc != null»
				<wsdl:documentation>
					<![CDATA[«op.doc?.stripCommentBraces()?.trim()»]]>   			
				</wsdl:documentation>
				«/*
					<jaxws:method>
						<jaxws:javadoc>
							<![CDATA[«doc.stripCommentBraces()?.trim()»]]>   			
						</jaxws:javadoc>
					</jaxws:method>
				*/»
				«ENDIF»
				<wsdl:input message="tns:«op.name»Request" />
				<wsdl:output message="tns:«op.name»Response" />
				«op.toFault()»
			</wsdl:operation>
	'''
	
	def dispatch toFaultMessages(String faultName, List<ExceptionRef> exceptions) '''
		<wsdl:message name="«exceptions.findFirst(e|e.exception.name == faultName).exception.toTypeName()»">
	  		<wsdl:part name="parameters" element="tns:«exceptions.findFirst(e|e.exception.name == faultName).exception.toTypeName()»"></wsdl:part>
		</wsdl:message>
	'''
	
	def dispatch toFault (Operation op) '''
		«FOR fault : op.throws»
				<wsdl:fault name="«fault.exception.toTypeName().toFirstLower()»" message="tns:«fault.exception.toTypeName()»"></wsdl:fault>
		«ENDFOR»
	'''
	
	def dispatch toBinding (Service svc) '''
		<wsdl:binding name="«svc.name»SOAP"
			type="tns:«svc.name»">
			<soap:binding style="document"
				transport="http://schemas.xmlsoap.org/soap/http" />
			«svc.operations.forEach (o|o.toBindingOperation ()) »
		</wsdl:binding>
	'''
	
	def dispatch toBindingOperation (Operation op) '''
		<wsdl:operation name="«op.name»">
			<soap:operation
				soapAction="«op.eContainer.toNamespace() + op.name»" />
			<wsdl:input>
				<soap:body use="literal" />
			</wsdl:input>
			<wsdl:output>
				<soap:body use="literal" />
			</wsdl:output>
		</wsdl:operation>
	'''
}