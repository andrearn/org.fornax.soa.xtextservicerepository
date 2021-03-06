package org.xkonnex.repo.generator.servicedsl.templates.webservice

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.List
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.generator.IFileSystemAccess
import org.xkonnex.repo.dsl.basedsl.CommonStringExtensions
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState
import org.xkonnex.repo.dsl.profiledsl.profileDsl.MessageHeader
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Property
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile
import org.xkonnex.repo.dsl.servicedsl.service.query.HeaderFinder
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceImportQueries
import org.xkonnex.repo.dsl.servicedsl.service.query.namespace.NamespaceQuery
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DomainNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ExceptionRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.InternalNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Parameter
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.generator.servicedsl.templates.xsd.OperationWrapperTypesGenerator
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaTemplateExtensions
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaTypeExtensions
import org.xkonnex.repo.generator.servicedsl.templates.xsd.XSDGenerator
import org.xkonnex.repo.generator.servicedsl.templates.CommonTemplateExtensions
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.ILifecycleStateResolver
import org.xkonnex.repo.dsl.servicedsl.service.namespace.ServiceNamespaceURIProvider

class WrappedWsdlGenerator {
	
	
	@Inject IFileSystemAccess fsa

	@Inject extension CommonTemplateExtensions
	@Inject extension org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions schemaNamespaceExt
	@Inject extension SchemaTypeExtensions schemaTypeExt
	@Inject extension ServiceTemplateExtensions
	@Inject extension ServiceNamespaceURIProvider
	@Inject extension VersionQualifierExtensions
	@Inject extension NamespaceQuery
	@Inject extension NamespaceImportQueries
	@Inject extension XSDGenerator
	@Inject extension OperationWrapperTypesGenerator
	@Inject extension ILifecycleStateResolver
	
	@Inject IEObjectDocumentationProvider docProvider
	
	@Inject @Named ("noDependencies") 		
	Boolean noDependencies
	
	
	/*
		CARTRIDGE ENTRYPOINT for generation of abstract wrapped  WSDLs
		Abstract WSDLs only define the abstract interface of a service. The binding is declared
		in a separate WSDL that imports this abstract WSDL
		
		A WSDL for each Service in the given SubNamespace matching the given minimal LifecycleState
		will be generated. For each major version of a service WSDL is generated for the latest minor
		version in that major version matching the minimal Lifecycle constraint is be generated
	*/
	def void toWrappedWSDL(Service svc, LifecycleState minState, Profile profile, String registryBaseUrl) {
		svc.toWrappedWSDL (svc.findSubdomain(), minState, profile, registryBaseUrl);
	}
	
	def dispatch void toWrappedWSDL(Service svc, SubNamespace subDom, LifecycleState minState, Profile profile, String registryBaseUrl) {
		throw new UnsupportedOperationException ()
	}
	
	def dispatch void toWrappedWSDL(Service svc, DomainNamespace subDom, LifecycleState minState, Profile enforcedProfile, String registryBaseUrl) {
		val profile = subDom.getApplicableProfile(enforcedProfile)
		val allServiceExceptionRefs = svc.operations.map (o|o.^throws).flatten;
		svc.toOperationWrappers (subDom, minState, profile, registryBaseUrl);
		val content = '''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<wsdl:definitions xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
			xmlns:tns="«svc.toWrapperServiceTargetNamespace()»"
			xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" 
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			xmlns:ref="http://ws-i.org/profiles/basic/1.1/xsd"
			xmlns:jaxws="http://java.sun.com/xml/ns/jaxws"
			name="«svc.name»" 
			targetNamespace="«svc.toWrapperServiceTargetNamespace()»">
			<wsdl:documentation>
				<![CDATA[Version «svc.version.toVersionNumber()»
				Lifecycle state: «svc.lifecycleState.toStateName»
				
				«docProvider.getDocumentation (svc)»]]>
			</wsdl:documentation>
			
			«svc.toTypes (minState, profile, registryBaseUrl)»
			«svc.operations.map (o|o.toMessages ()).join»
			«allServiceExceptionRefs.map (r|r.exception.name).toSet().map (n|n.toFaultMessages(allServiceExceptionRefs.toList)).join»
			«svc.toPortType()»
		</wsdl:definitions>
		'''
		val xsdFileName = svc.getWrappedWSDLFileName();
		fsa.generateFile (xsdFileName, content);
	}
	
	def dispatch void toWrappedWSDL(Service svc, InternalNamespace subDom, LifecycleState minState, Profile profile, String registryBaseUrl) {
		val allServiceExceptionRefs = svc.operations.map (o|o.^throws).flatten;
		
		svc.toOperationWrappers (subDom, minState, profile, registryBaseUrl);
		val xsdFileName = subDom.toFileNameFragment() + "-" + svc.name + "-" + schemaNamespaceExt.toVersionPostfix(svc.version) + "Wrapped.wsdl";
		val content = '''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<wsdl:definitions xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
			xmlns:tns="«svc.toWrapperServiceTargetNamespace()»"
			xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" 
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			xmlns:ref="http://ws-i.org/profiles/basic/1.1/xsd"
			«/*	
				xmlns:jaxws="http://java.sun.com/xml/ns/jaxws"
			*/»
			name="«svc.name»" 
			targetNamespace="«svc.toWrapperServiceTargetNamespace()»">
			<wsdl:documentation>
				<![CDATA[Version «svc.version.toVersionNumber()»
				Lifecycle state: «svc.lifecycleState.toStateName»
				
				«docProvider.getDocumentation (svc)»]]>
			</wsdl:documentation>
			
			«svc.toTypes(minState, profile, registryBaseUrl)»
			«svc.operations.map (o|o.toMessages()).join»
			«allServiceExceptionRefs.map(r|r.exception.name).toSet().map (n|n.toFaultMessages(allServiceExceptionRefs.toList)).join»
			«svc.toPortType»
		</wsdl:definitions>
		'''
		fsa.generateFile (xsdFileName, content);
	}
	
	def protected toTypes(Service svc, LifecycleState minState, Profile profile, String registryBaseUrl) '''
		<wsdl:types>
			<xsd:schema targetNamespace="«svc.toWrapperServiceTargetNamespace()»"
				«FOR imp : svc.importedVersionedNS(svc.version.toMajorVersionNumber(), minState)»
					xmlns:«imp.versionedNamespacePrefix»="«imp.versionedNamespaceURI»"
				«ENDFOR»
				xmlns:svc="«svc.toWrapperTargetNamespace()»"
				elementFormDefault="qualified"
				attributeFormDefault="unqualified"
			>
				«FOR imp : svc.importedVersionedNS(svc.version.toMajorVersionNumber(), minState) »
					<xsd:import schemaLocation="«imp.toSchemaAssetUrl (registryBaseUrl)».xsd"
						namespace="«schemaNamespaceExt.toNamespace(imp)»"/>
				«ENDFOR»
				<xsd:import schemaLocation="«svc.getRegisteredOperationWrapperUrl (registryBaseUrl)»"
					namespace="«svc.toWrapperTargetNamespace()»"/>
				«svc.operations.map (o|o.toOperationWrapperTypes (profile)).join»
				«svc.operations.map (o|o.^throws).flatten.map(t|t.exception.name).toSet().map (n|n.toOperationFaultWrapperTypes (svc.operations.map (o|o.^throws).flatten.toList)).join»
			</xsd:schema>
		</wsdl:types>
	'''
	
	def protected toOperationWrapperTypes (Operation op, Profile profile) '''
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
	
	def protected toOperationFaultWrapperTypes(String faultName, List<ExceptionRef> exceptions) {
		val exceptionRef = exceptions.findFirst(e|e.exception.name == faultName);
		if (exceptionRef !== null) {
			'''
			<xsd:element name="«exceptionRef?.exception.name»" type="«exceptionRef?.toExceptionNameRef()»"/>
			'''
		}
	}
	
	def protected dispatch toParameter (Parameter param) '''
		<xsd:element name="«param.name»" type="«param.type.toTypeNameRef ()»" «IF param.optional»minOccurs="0" «ENDIF»«IF param.type.isMany()»maxOccurs="unbounded"«ENDIF» «IF param.type.isMimeContentMultiPartAttachment()»«param.type.toMimeFragment()»«ENDIF»></xsd:element>
	'''
	
	def protected dispatch toParameter (Property prop) '''
		<xsd:element name="«prop.name»" type="«prop.type.toTypeNameRef ()»" «IF prop.optional»minOccurs="0" «ENDIF»«IF prop.type.isMany()»maxOccurs="unbounded"«ENDIF»></xsd:element>
	'''
	
	def protected dispatch toParameter (MessageHeader header) '''
		«header.parameters.map (p|p.toParameter()).join»
	'''
	
	
	def protected toMessages (Operation op) '''
		<wsdl:message name="«op.name»Request">
			<wsdl:part element="tns:«op.name»" name="parameters" />
		</wsdl:message>
		<wsdl:message name="«op.name»Response">
			<wsdl:part element="tns:«op.name»Response" name="parameters" />
		</wsdl:message>
	'''
	
	def protected toPortType (Service svc) '''
		<wsdl:portType name="«svc.name»Wrapped">
			<wsdl:documentation>
					<![CDATA[Version:	«svc.version.toVersionNumber()»
					Lifecycle state: «svc.lifecycleState.toStateName»
										
					«docProvider.getDocumentation (svc)»]]>
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
			«svc.operations.map (o|o.toOperation ()).join»
		</wsdl:portType>
	'''
	
	def protected toOperation (Operation op) '''
		<wsdl:operation name="«op.name»">
			<wsdl:documentation>
				<![CDATA[«docProvider.getDocumentation (op)»]]>   			
			</wsdl:documentation>
			«/*
				<jaxws:method>
					<jaxws:javadoc>
						<![CDATA[«doc.stripCommentBraces()?.trim()»]]>   			
					</jaxws:javadoc>
				</jaxws:method>
			*/»
			<wsdl:input message="tns:«op.name»Request" />
			<wsdl:output message="tns:«op.name»Response" />
			«op.toFault()»
		</wsdl:operation>
	'''
	
	def protected toFaultMessages(String faultName, List<ExceptionRef> exceptions) {
		val exceptionRef = exceptions.findFirst(e|e.exception.name == faultName);
		if (exceptionRef !== null) {
			'''
			<wsdl:message name="«exceptions.findFirst(e|e.exception.name == faultName).exception.name»">
				<wsdl:part name="parameters" element="tns:«exceptionRef?.exception.name»"></wsdl:part>
			</wsdl:message>
			'''
		}
	}
	def protected toFault (Operation op) '''
		«FOR fault : op.^throws»
				<wsdl:fault name="«fault?.exception.name.toFirstLower()»" message="tns:«fault?.exception.name»"></wsdl:fault>
		«ENDFOR»
	'''
	
	def protected toBinding (Service svc) '''
		<wsdl:binding name="«svc.name»SOAP"
			type="tns:«svc.name»">
			<soap:binding style="document"
				transport="http://schemas.xmlsoap.org/soap/http" />
			«svc.operations.map (o|o.toBindingOperation ()).join »
		</wsdl:binding>
	'''
	
	def protected toBindingOperation (Operation op) '''
		<wsdl:operation name="«op.name»">
			<soap:operation
				soapAction="«schemaTypeExt.toNamespace(op.eContainer) + op.name»" />
			<wsdl:input>
				<soap:body use="literal" />
			</wsdl:input>
			<wsdl:output>
				<soap:body use="literal" />
			</wsdl:output>
		</wsdl:operation>
	'''
}