package org.fornax.soa.bindingdsl.generator.templates.soap

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtext.generator.IFileSystemAccess
import org.fornax.soa.basedsl.generator.CommonEObjectExtensions
import org.fornax.soa.basedsl.generator.CommonStringExtensions
import org.fornax.soa.basedsl.generator.version.VersionQualifierExtensions
import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.bindingDsl.DomainBinding
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingDsl.SOAP
import org.fornax.soa.bindingDsl.ServiceBinding
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions
import org.fornax.soa.environmentDsl.Server
import org.fornax.soa.environmentdsl.generator.EndpointResolver
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.profiledsl.scoping.versions.IStateMatcher
import org.fornax.soa.serviceDsl.Operation
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.servicedsl.generator.query.ServiceFinder
import org.fornax.soa.servicedsl.generator.query.type.LatestMatchingTypeFinder
import org.fornax.soa.servicedsl.generator.templates.webservice.ServiceTemplateExtensions
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaTypeExtensions
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider

class ConcreteProviderWsdlTemplates {

	@Inject extension CommonEObjectExtensions
	@Inject extension CommonStringExtensions
	@Inject extension BindingExtensions
	@Inject extension EndpointResolver
	@Inject extension ServiceFinder
	@Inject extension SoapBindingResolver
	@Inject extension SchemaNamespaceExtensions
	@Inject extension SchemaTypeExtensions
	@Inject extension ServiceTemplateExtensions
	@Inject extension LatestMatchingTypeFinder
	@Inject extension SoapEndpointAddressResolver
	@Inject IStateMatcher stateMatcher
	
	@Inject VersionQualifierExtensions versionQualifier
	@Inject IFileSystemAccess fsa
	@Inject IEObjectDocumentationProvider docProvider
	
	def toWSDL(DomainBinding binding, BindingProtocol prot, SOAProfile profile) {
		val services = binding.subNamespace.services.filter (e|stateMatcher.matches (binding.environment.getMinLifecycleState(e, profile.lifecycle), e.state) && e.isLatestMatchingService(versionQualifier.toMajorVersionNumber(e.version).asInteger(), binding.environment.getMinLifecycleState(e, profile.lifecycle)));
		services.forEach (s|s.toWSDL (binding, prot, profile));
	}
	
	def toWSDLByServiceName(DomainBinding binding, List<String> serviceNames, BindingProtocol prot, SOAProfile profile) {
		val services = binding.subNamespace.services.filter (e|serviceNames.contains(e.name) && stateMatcher.matches (binding.environment.getMinLifecycleState(e, profile.lifecycle), e.state) && e.isLatestMatchingService(versionQualifier.toMajorVersionNumber(e.version).asInteger(), binding.environment.getMinLifecycleState(e, profile.lifecycle)));
		services.forEach (s|s.toWSDL (binding, prot, profile)); 
	}
	
	
	def dispatch toWSDL(Service svc, DomainBinding domBind, BindingProtocol prot, SOAProfile profile) {
		val wsdlFile = svc.getConcreteWsdlFileNameFragment("Private") + ".wsdl";
		val content = '''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<wsdl:definitions xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
			xmlns:tns="«svc.toTargetNamespace()»"
			xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" 
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			name="«svc.name»" 
			targetNamespace="«svc.toTargetNamespace()»">

			<wsdl:documentation>
				Version «versionQualifier.toVersionNumber(svc.version)»
				Lifecycle state: «svc.state.name»
				
				«docProvider.getDocumentation (svc)»
			</wsdl:documentation>

		    <wsdl:import namespace="«svc.toTargetNamespace()»" location="«svc.toRegistryAssetUrl (domBind.getRegistryBaseUrl())».wsdl"></wsdl:import>
			
			«domBind.protocol.filter (typeof (SOAP)).map (p|p.toSOAPBinding(svc)).join»

			«domBind.protocol.filter (typeof (SOAP)).map (p|p.toWsdlService(svc)).join»
		</wsdl:definitions>
		''';
		fsa.generateFile (wsdlFile, content);
	}
	
	def dispatch toWSDL(Service svc, ServiceBinding svcBind, BindingProtocol prot, SOAProfile profile) {
		val wsdlFile = svc.getConcreteWsdlFileNameFragment("Private") + ".wsdl";
		val content = '''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<wsdl:definitions xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
			xmlns:tns="«svc.toTargetNamespace()»"
			xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" 
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			name="«svc.name»" 
			targetNamespace="«svc.toTargetNamespace()»">

			<wsdl:documentation>
				Version «versionQualifier.toVersionNumber(svc.version)»
				Lifecycle state: «svc.state.name»
				
				«docProvider.getDocumentation (svc)»
			</wsdl:documentation>

		    <wsdl:import namespace="«svc.toTargetNamespace()»" location="«svc.toRegistryAssetUrl (svcBind.getRegistryBaseUrl())».wsdl"></wsdl:import>
			
		«svcBind.protocol.filter (typeof (SOAP)).map (p|p.toSOAPBinding (svc)).join»

		«svcBind.protocol.filter (typeof (SOAP)).map (p|p.toWsdlService (svc)).join»
		</wsdl:definitions>
		'''
	}
	
	def dispatch toWSDL(Service svc, ModuleBinding modBind, BindingProtocol prot, SOAProfile profile) {
		val wsdlFile = svc.getConcreteWsdlFileNameFragment(modBind.getProviderEndpointQualifier(svc)) + ".wsdl";
		val content = '''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<wsdl:definitions xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
			xmlns:tns="«svc.toTargetNamespace()»"
			xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" 
			xmlns:xsd="http://www.w3.org/2001/XMLSchema"
			name="«svc.name»" 
			targetNamespace="«svc.toTargetNamespace()»">

			<wsdl:documentation>
				Version «versionQualifier.toVersionNumber(svc.version)»
				Lifecycle state: «svc.state.name»
				
				«docProvider.getDocumentation (svc)»
			</wsdl:documentation>

		    <wsdl:import namespace="«svc.toTargetNamespace()»" location="«svc.toRegistryAssetUrl (modBind.getRegistryBaseUrl())».wsdl"></wsdl:import>
			
			«prot.toSOAPBinding (svc, modBind.getProviderEndpointQualifier(svc))»

			«prot.toWsdlService (svc, modBind.provider.provServer, modBind)»
		</wsdl:definitions>
		''';
		fsa.generateFile (wsdlFile, content);
	}
	
	def dispatch void toSOAPBinding (BindingProtocol prot, Service svc) {}
	def dispatch void toSOAPBinding (BindingProtocol prot, Service svc, String qualifierName) {}
	
	def dispatch toSOAPBinding(SOAP protocol, Service svc) '''
		<wsdl:binding name="«svc.toBindingName (protocol)»"
			type="tns:«svc.name»">
			<soap:binding style="«protocol.getWsdlBindingStyle()»"
				transport="http://schemas.xmlsoap.org/soap/http" />
			«svc.operations.map (o|o.toSOAPBindingOperation (protocol)).join»
		</wsdl:binding>
	'''
	def dispatch toSOAPBinding(SOAP protocol, Service svc, String qualifierName) '''
		<wsdl:binding name="«svc.toBindingName (protocol, qualifierName)»"
			type="tns:«svc.name»">
			<soap:binding style="«protocol.getWsdlBindingStyle()»"
				transport="http://schemas.xmlsoap.org/soap/http" />
			«svc.operations.map (o|o.toSOAPBindingOperation (protocol)).join»
		</wsdl:binding>
	'''
	
	def toSOAPBindingOperation(Operation op, SOAP protocol) '''

		<wsdl:operation name="«op.name»">
			<soap:operation
				soapAction="«op.eContainer.toTargetNamespace()»«op.name»" />
			<wsdl:input>
				<soap:body use="«protocol.getSoapEncoding()»" />
			</wsdl:input>
			<wsdl:output>
				<soap:body use="«protocol.getSoapEncoding()»" />
			</wsdl:output>
			«FOR fault : op.^throws»
				<wsdl:fault name="«fault.exception.toTypeName().toFirstLower()»">
					<soap:fault name="«fault.exception.toTypeName().toFirstLower()»" use="«protocol.getSoapEncoding()»"/>
				</wsdl:fault>
			«ENDFOR»
		</wsdl:operation>
	'''
	
	def dispatch void toWsdlService (BindingProtocol protocol, Service svc) {}
	def dispatch void toWsdlService (BindingProtocol protocol, Service svc, String qualifierName) {}
	
	def dispatch toWsdlService(SOAP protocol, Service svc) '''
		<wsdl:service name="«svc.name»">
			<wsdl:port binding="tns:«svc.toBindingName (protocol)»"
				name="«svc.toPortName (protocol)»">
				<soap:address location="«svc.toProviderEndpointAddress (protocol.eContainer)»" />
			</wsdl:port>
		</wsdl:service>
	'''

	def dispatch toWsdlService(SOAP protocol, Service svc, String qualifierName) '''
		<wsdl:service name="«svc.name»">
			<wsdl:port binding="tns:«svc.toBindingName (protocol, qualifierName)»"
				name="«svc.toPortName (protocol, qualifierName)»">
				<soap:address location="«svc.toProviderEndpointAddress (protocol.eContainer)»" />
			</wsdl:port>
		</wsdl:service>
	'''
	
	def dispatch void toWsdlService (BindingProtocol protocol, Service svc, Server server, ModuleBinding bind) {}
	
	def dispatch toWsdlService (SOAP protocol, Service svc, Server server, ModuleBinding bind) '''
		<wsdl:service name="«svc.name»">
			<wsdl:port binding="tns:«svc.toBindingName (protocol, bind.getProviderEndpointQualifier(svc))»"
				name="«svc.toPrivatePortName (protocol, bind.getProviderEndpointQualifier(svc))»">
				<soap:address location="«svc.toProviderEndpointAddress (server, protocol, bind.module.module)»" />
			</wsdl:port>
		</wsdl:service>
	'''
	
}