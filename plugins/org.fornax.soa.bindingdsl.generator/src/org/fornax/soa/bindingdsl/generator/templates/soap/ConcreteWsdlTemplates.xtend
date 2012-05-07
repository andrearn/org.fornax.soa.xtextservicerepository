package org.fornax.soa.bindingdsl.generator.templates.soap

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtext.generator.IFileSystemAccess
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
import org.fornax.soa.serviceDsl.DomainNamespace
import org.fornax.soa.serviceDsl.Operation
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.serviceDsl.Type
import org.fornax.soa.servicedsl.generator.query.ServiceFinder
import org.fornax.soa.servicedsl.generator.query.type.LatestMatchingTypeFinder
import org.fornax.soa.servicedsl.generator.templates.webservice.ServiceTemplateExtensions
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaTypeExtensions
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider

/*
 * Generate concrete public endpoint WSDLs that define port, binding and service endpoint for each elegible service 
 * from a DomainBinding or ModuleBinding.<br/><br/>
 * 
 * Each concrete WSDL imports the abstract WSDL of the respective service. Generation of the abstract WSDL is being 
 * delegated to the Service DSL generator.
 */
class ConcreteWsdlTemplates {
	
	@Inject extension CommonStringExtensions
	@Inject extension ServiceFinder
	@Inject extension EndpointResolver
	@Inject extension BindingExtensions
	@Inject extension SoapBindingResolver
	@Inject extension org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions
	@Inject extension SchemaTypeExtensions
	@Inject extension ServiceTemplateExtensions
	@Inject extension LatestMatchingTypeFinder
	@Inject extension SoapEndpointAddressResolver

	@Inject VersionQualifierExtensions versionQualifier
	@Inject IEObjectDocumentationProvider docProvider
	
	@Inject IFileSystemAccess fsa
	
	/* 
	 * Generate concrete pubplic endpoint WSDLs for services bound by a DomainBinding 
	 * with the given protocol definition applying the supplied profile
	 */
	def toWSDL (DomainBinding binding, BindingProtocol prot, SOAProfile profile) {
		if (binding.subNamespace instanceof DomainNamespace) {
			val services = binding.subNamespace.services.filter (e|e.isLatestMatchingService (versionQualifier.toMajorVersionNumber(e.version).asInteger(), binding.environment.getMinLifecycleState(e, profile.lifecycle)));
			services.forEach (s|s.toWSDL (binding, prot, profile)); 
		}
	}
	
	/* 
	 * Generate a concrete pubplic endpoint WSDL for a service bound by a ModuleBinding 
	 * with the given protocol definition applying the supplied profile
	 */
	def dispatch toWSDL (ModuleBinding binding, Service svc, SOAP prot, SOAProfile profile) {
		svc.toWSDL (binding, prot, profile);
	}
	
	def toWSDLByServiceName (DomainBinding binding, List<String> serviceNames, BindingProtocol prot, SOAProfile profile) {
		if (binding.subNamespace instanceof DomainNamespace) {
			val services = binding.subNamespace.services.filter (e| serviceNames.contains (e.name) && e.isLatestMatchingService (versionQualifier.toMajorVersionNumber(e.version).asInteger(), binding.environment.getMinLifecycleState(e, profile.lifecycle)));
			services.forEach (s|s.toWSDL (binding, prot, profile));
		}
	}
	
	def dispatch toWSDL (Service svc, DomainBinding domBind, BindingProtocol prot, SOAProfile profile) {
		val wsdlFile = svc.getConcreteWsdlFileNameFragment ("Public") + ".wsdl";
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
			
			«domBind.protocol.filter (typeof(SOAP)).map (p|p.toSOAPBinding (svc)).join»

			«domBind.protocol.filter (typeof(SOAP)).map (p|p.toWsdlService (svc)).join»
		</wsdl:definitions>
		''';
		fsa.generateFile (wsdlFile, content);
	}
	
	def dispatch toWSDL(Service svc, ServiceBinding svcBind, SOAP prot, SOAProfile profile) {
		val wsdlFile = svc.getConcreteWsdlFileNameFragment("Public") + ".wsdl";
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
				Lifecycle state: «svc.state.toString()»
				
				«docProvider.getDocumentation (svc)»
			</wsdl:documentation>

		    <wsdl:import namespace="«svc.toTargetNamespace()»" location="«svc.toRegistryAssetUrl (svcBind.getRegistryBaseUrl())».wsdl"></wsdl:import>
			
			«svcBind.protocol.filter (typeof(SOAP)).map (p|p.toSOAPBinding (svc)).join»

			«svcBind.protocol.filter (typeof(SOAP)).map (p|p.toWsdlService(svc)).join»
		</wsdl:definitions>
		''';
		fsa.generateFile (wsdlFile, content);
	}
	
	def dispatch toWSDL(Service svc, ModuleBinding modBind, BindingProtocol prot, SOAProfile profile) {
		val wsdlFile = svc.getConcreteWsdlFileNameFragment(modBind.getPublicEndpointQualifier (svc)) + ".wsdl";
		val content ='''
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
			
			«prot.toSOAPBinding (svc, modBind.getPublicEndpointQualifier(svc))»

			«prot.toWsdlService (svc, modBind.provider.provServer, modBind)»
		</wsdl:definitions>
		''';
		fsa.generateFile (wsdlFile, content);
	}
	
	def dispatch void toSOAPBinding (BindingProtocol protocol, Service svc) {}

	def dispatch void toSOAPBinding (BindingProtocol protocol, Service svc, String qualifierName) {}
	
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
	
	def toSOAPBindingOperation (Operation op, SOAP protocol) '''

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
	
	def dispatch toWsdlService (BindingProtocol protocol, Service svc) {}
	def dispatch toWsdlService (BindingProtocol protocol, Service svc, String qualifierName) {}
	
	def dispatch toWsdlService(SOAP protocol, Service svc) '''
		<wsdl:service name="«svc.name»">
			<wsdl:port binding="tns:«svc.toBindingName (protocol)»"
				name="«svc.toScopedPortName (protocol)»">
				<soap:address location="«svc.toEndpointAddress (protocol.eContainer)»" />
			</wsdl:port>
		</wsdl:service>
	'''
	
	def dispatch toWsdlService(SOAP protocol, Service svc, String qualifierName) '''
		<wsdl:service name="«svc.name»">
			<wsdl:port binding="tns:«svc.toBindingName (protocol, qualifierName)»"
				name="«svc.toScopedPortName (protocol, qualifierName)»">
				<soap:address location="«svc.toEndpointAddress (protocol.eContainer)»" />
			</wsdl:port>
		</wsdl:service>
	'''
	
	def dispatch void toWsdlService (BindingProtocol protocol, Service svc, Server server, ModuleBinding bind) {}
	
	def dispatch toWsdlService (SOAP protocol, Service svc, Server server, ModuleBinding bind) '''
		<wsdl:service name="«svc.name»">
			<wsdl:port binding="tns:«svc.toBindingName (protocol, bind.getPublicEndpointQualifier (svc))»"
				name="«svc.toScopedPortName (protocol, bind.getPublicEndpointQualifier (svc))»">
				<soap:address location="«svc.toEndpointAddress (server, protocol, bind.module.module)»" />
			</wsdl:port>
		</wsdl:service>
	'''
	
	def toSecPolicies (Type type) '''
		<wsp:Policy wsu:Id="UP_policy"
			xmlns:wsp="http://schemas.xmlsoap.org/ws/2004/09/policy"
			xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd">
		
		</wsp:Policy>
	'''
	
	def toTransportPolicy (Type type) '''
		<sp:TransportBinding
			xmlns:sp="http://schemas.xmlsoap.org/ws/2005/07/securitypolicy">
			<wsp:Policy>
				<sp:TransportToken>
					<wsp:Policy>
						<sp:HttpsToken />
					</wsp:Policy>
				</sp:TransportToken>
				<sp:Layout>
					<wsp:Policy>
						<sp:Strict />
					</wsp:Policy>
				</sp:Layout>
				<sp:AlgorithmSuite>
					<wsp:Policy>
						<sp:Basic128 />
					</wsp:Policy>
				</sp:AlgorithmSuite>
			</wsp:Policy>
		</sp:TransportBinding>
	'''
	
	def toAuthPolicy (Type type) '''
		<sp:SupportingTokens
			xmlns:sp="http://schemas.xmlsoap.org/ws/2005/07/securitypolicy">
			<wsp:Policy>
				<sp:UsernameToken
					xmlns:sp="http://schemas.xmlsoap.org/ws/2005/07/securitypolicy"
					sp:IncludeToken="http://schemas.xmlsoap.org/ws/2005/07/securitypolicy/IncludeToken/Always">
					<wsp:Policy>
						<sp:WssUsernameToken11 />
					</wsp:Policy>
				</sp:UsernameToken>
			</wsp:Policy>
		</sp:SupportingTokens>
	'''	
}