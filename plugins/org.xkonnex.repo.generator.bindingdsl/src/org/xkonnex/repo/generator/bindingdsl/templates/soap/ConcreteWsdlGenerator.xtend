package org.xkonnex.repo.generator.bindingdsl.templates.soap

import com.google.inject.Inject
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.eclipse.xtext.generator.IFileSystemAccess
import org.xkonnex.repo.dsl.basedsl.version.VersionQualifierExtensions
import org.xkonnex.repo.dsl.bindingdsl.binding.query.environment.EnvironmentBindingResolver
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.AnyBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.Binding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.BindingProtocol
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ModuleBinding
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.SOAP
import org.xkonnex.repo.dsl.bindingdsl.bindingDsl.ServiceBinding
import org.xkonnex.repo.dsl.bindingdsl.model.EffectiveBinding
import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Server
import org.xkonnex.repo.dsl.profiledsl.profileDsl.Profile
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.ILifecycleStateResolver
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Type
import org.xkonnex.repo.generator.bindingdsl.templates.BindingExtensions
import org.xkonnex.repo.generator.bindingdsl.templates.naming.DefaultEndpointQualifierNameProvider
import org.xkonnex.repo.generator.bindingdsl.templates.wsdl.ConcreteWsdlFileNameProvider
import org.xkonnex.repo.generator.servicedsl.templates.CommonTemplateExtensions
import org.xkonnex.repo.generator.servicedsl.templates.webservice.ServiceTemplateExtensions
import org.xkonnex.repo.generator.servicedsl.templates.xsd.SchemaNamespaceExtensions

/*
 * Generate concrete public endpoint WSDLs that define port, binding and service endpoint for each elegible service 
 * from a DomainBinding or ModuleBinding. Whether a service is eligible is determined from it's lifecycle state checking
 * whether the state is supported in the bindings target environment.<br/><br/>
 * 
 * Each concrete WSDL imports the abstract WSDL of the respective service. Generation of the abstract WSDL is being 
 * delegated to the Service DSL generator.
 */
class ConcreteWsdlGenerator {
	
	@Inject extension CommonTemplateExtensions
	@Inject extension BindingExtensions
	@Inject extension ConcreteWsdlFileNameProvider
	@Inject extension SoapBindingResolver
	@Inject extension SchemaNamespaceExtensions
	@Inject extension ServiceTemplateExtensions
	@Inject extension SoapEndpointAddressResolver
	@Inject extension EnvironmentBindingResolver
	@Inject extension DefaultEndpointQualifierNameProvider
	@Inject extension ILifecycleStateResolver

	@Inject VersionQualifierExtensions versionQualifier
	@Inject IEObjectDocumentationProvider docProvider
	
	@Inject IFileSystemAccess fsa
		
	/* 
	 * Generate a concrete pubplic endpoint WSDL for a service bound by a ModuleBinding 
	 * with the given protocol definition applying the supplied profile
	 */
	def dispatch void toWSDL (ModuleBinding binding, Service svc, SOAP prot, Profile profile) {
		svc.toWSDL (binding, prot, profile);
	}
	/* 
	 * Generate a concrete pubplic endpoint WSDL for a service bound by a ModuleBinding 
	 * with the given protocol definition applying the supplied profile
	 */
	def dispatch void toWSDL (EffectiveBinding binding, Service svc, SOAP prot, Profile profile) {
		svc.toWSDL (binding.moduleBinding, prot, profile);
	}
	
	
	def dispatch void toWSDL(Service svc, ServiceBinding svcBind, SOAP prot, Profile enforcedProfile) {
		val wsdlFile = svc.getConcreteWsdlFileNameFragment(svcBind, prot) + ".wsdl";
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
				Lifecycle state: «svc.lifecycleState.toStateName»
				
				«docProvider.getDocumentation (svc)»
			</wsdl:documentation>

		    <wsdl:import namespace="«svc.toTargetNamespace()»" location="«svc.toSchemaAssetUrl (svcBind.getRegistryBaseUrl())».wsdl"></wsdl:import>
			
			«svcBind.protocol.filter (typeof(SOAP)).map (p|p.toSOAPBinding (svc)).join»

			«svcBind.protocol.filter (typeof(SOAP)).map (p|p.toWsdlService(svc, svcBind.resolveServer, svcBind)).join»
		</wsdl:definitions>
		''';
		fsa.generateFile (wsdlFile, content);
	}
	
	def dispatch void toWSDL(Service svc, AnyBinding svcBind, SOAP prot, Profile enforcedProfile) {
		val wsdlFile = svc.getConcreteWsdlFileNameFragment(svcBind, prot) + ".wsdl";
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
				Lifecycle state: «svc.lifecycleState.toStateName»
				
				«docProvider.getDocumentation (svc)»
			</wsdl:documentation>

		    <wsdl:import namespace="«svc.toTargetNamespace()»" location="«svc.toSchemaAssetUrl (svcBind.getRegistryBaseUrl())».wsdl"></wsdl:import>
			
			«svcBind.protocol.filter (typeof(SOAP)).map (p|p.toSOAPBinding (svc)).join»

			«svcBind.protocol.filter (typeof(SOAP)).map (p|p.toWsdlService(svc, svcBind.resolveServer, svcBind)).join»
		</wsdl:definitions>
		''';
		fsa.generateFile (wsdlFile, content);
	}
	
	def dispatch void toWSDL(Service svc, ModuleBinding modBind, BindingProtocol prot, Profile enforcedProfile) {
		val wsdlFile = svc.getConcreteWsdlFileNameFragment(modBind, prot) + ".wsdl";
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
				Lifecycle state: «svc.lifecycleState.toStateName»
				
				«docProvider.getDocumentation (svc)»
			</wsdl:documentation>

		    <wsdl:import namespace="«svc.toTargetNamespace()»" location="«svc.toSchemaAssetUrl (modBind.getRegistryBaseUrl())».wsdl"></wsdl:import>
			
			«prot.toSOAPBinding (svc, modBind.getEndpointQualifierName(svc, prot))»

			«prot.toWsdlService (svc, modBind.resolveServer, modBind)»
		</wsdl:definitions>
		''';
		fsa.generateFile (wsdlFile, content);
	}
	
	def dispatch toSOAPBinding (BindingProtocol protocol, Service svc) {}

	def dispatch toSOAPBinding (BindingProtocol protocol, Service svc, String qualifierName) {}
	
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
				<wsdl:fault name="«fault.exception.name.toFirstLower()»">
					<soap:fault name="«fault.exception.name.toFirstLower()»" use="«protocol.getSoapEncoding()»"/>
				</wsdl:fault>
			«ENDFOR»
		</wsdl:operation>
	'''
	
	def dispatch toWsdlService (BindingProtocol protocol, Service svc, String qualifierName) {}
	
	def dispatch toWsdlService(SOAP protocol, Service svc, Binding bind) '''
		<wsdl:service name="«svc.name»">
			<wsdl:port binding="tns:«svc.toBindingName (protocol)»"
				name="«svc.toScopedPortName (bind, protocol)»">
				<soap:address location="«svc.toEndpointAddress (protocol.eContainer)»" />
			</wsdl:port>
		</wsdl:service>
	'''
	
	def dispatch toWsdlService(SOAP protocol, Service svc, String qualifierName, Binding bind) '''
		<wsdl:service name="«svc.name»">
			<wsdl:port binding="tns:«svc.toBindingName (protocol, qualifierName)»"
				name="«svc.toScopedPortName (bind, protocol, qualifierName)»">
				<soap:address location="«svc.toEndpointAddress (protocol.eContainer)»" />
			</wsdl:port>
		</wsdl:service>
	'''
	
	def dispatch toWsdlService (BindingProtocol protocol, Service svc, Server server, ModuleBinding bind) {}
	
	def dispatch toWsdlService (SOAP protocol, Service svc, Server server, ModuleBinding bind) '''
		<wsdl:service name="«svc.name»">
			<wsdl:port binding="tns:«svc.toBindingName (protocol, bind.getEndpointQualifierName (svc, protocol))»"
				name="«svc.toScopedPortName (bind, protocol, bind.getEndpointQualifierName (svc, protocol))»">
				<soap:address location="«svc.toEndpointAddress (server, protocol, bind.module.module)»" />
			</wsdl:port>
		</wsdl:service>
	'''
	
	def dispatch toWsdlService (SOAP protocol, Service svc, Server server, EffectiveBinding bind) '''
		<wsdl:service name="«svc.name»">
			<wsdl:port binding="tns:«svc.toBindingName (protocol, bind.getEndpointQualifierName (svc, protocol))»"
				name="«svc.toScopedPortName (bind.moduleBinding, protocol, bind.getEndpointQualifierName (svc, protocol))»">
				<soap:address location="«svc.toEndpointAddress (server, protocol, bind.moduleBinding.module.module)»" />
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