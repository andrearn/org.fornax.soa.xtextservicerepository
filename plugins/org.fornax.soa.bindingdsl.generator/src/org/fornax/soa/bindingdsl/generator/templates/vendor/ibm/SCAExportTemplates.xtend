package org.fornax.soa.bindingdsl.generator.templates.vendor.ibm

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.fornax.soa.binding.query.environment.EnvironmentBindingResolver
import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.bindingDsl.SCA
import org.fornax.soa.bindingDsl.SOAP
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions
import org.fornax.soa.bindingdsl.generator.templates.soap.SoapBindingResolver
import org.fornax.soa.moduledsl.moduleDsl.AssemblyType
import org.fornax.soa.moduledsl.query.DefaultModuleServiceResolver
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.servicedsl.generator.templates.webservice.ServiceTemplateExtensions
import org.fornax.soa.moduledsl.query.IModuleServiceResolver
import org.fornax.soa.binding.query.BindingLookup


/* 
 * Generator for IBM SCA export components for the IBM WebSphere ESB. For each service provided from the module referenced in the binding
 * that supports an SCA protocol and is eligible for the bindings target environment as of their lifecycle state 
 * an SCA export component is being generated.
 */
class SCAExportTemplates {

	
	@Inject extension BindingLookup
	@Inject extension IModuleServiceResolver
	@Inject extension ServiceTemplateExtensions
	@Inject extension SCAExportExtension
	@Inject extension SoapBindingResolver
	@Inject extension EnvironmentBindingResolver		


	@Inject IFileSystemAccess fsa

	def dispatch void toSCAModuleExport (BindingProtocol protocol, SOAProfile profile) {
	}
	
	
	def dispatch void toSCAModuleExport (ModuleBinding binding, SOAProfile profile) {
		if (binding.module.module.assemblyType == AssemblyType::SCA_EAR) {
			for (provSvc : binding.module.module.providedServices) {
				val svc = provSvc.resolveModuleServiceRef (binding.resolveEnvironment);
				if (svc != null) {
					svc.getMostSpecificBinding (binding).protocol.forEach (p|p.toServiceExport (binding, svc, profile));
				}
			}
		}
	}
	
	def dispatch void toServiceExport (BindingProtocol protocol, ModuleBinding modBind, Service svc, SOAProfile profile) {
	}
	
	def dispatch toServiceExport (SOAP protocol, ModuleBinding modBind, Service svc, SOAProfile profile) {
		val exportFile = svc.getExportFileName (protocol);
		val content = '''
		<?xml version="1.0" encoding="UTF-8"?>
		<scdl:export 
				xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
				xmlns:jaxws="http://www.ibm.com/xmlns/prod/websphere/scdl/jaxws/6.0.0" 
				xmlns:ns1="«svc.toTargetNamespace()»" 
				xmlns:scdl="http://www.ibm.com/xmlns/prod/websphere/scdl/6.0.0" 
				xmlns:wsdl="http://www.ibm.com/xmlns/prod/websphere/scdl/wsdl/6.0.0" 
				displayName="«svc.getExportDisplayName (protocol)»" 
				name="«svc.getExportName (protocol)»"
			> 
			<interfaces>
				<interface xsi:type="wsdl:WSDLPortType" preferredInteractionStyle="sync" portType="ns1:«svc.name»"/>
			</interfaces>
			<esbBinding xsi:type="jaxws:JaxWsExportBinding" port="ns1:«svc.toScopedPortName (modBind, protocol)»" service="ns1:«svc.name»"/>
		</scdl:export>
		''';
		
		fsa.generateFile (exportFile, content);
	}
	
	def dispatch toServiceExport (SCA protocol, ModuleBinding modBind, Service svc, SOAProfile profile) {
		val exportFile = svc.getExportFileName (protocol);
		val content = '''
		<?xml version="1.0" encoding="UTF-8"?>
		<scdl:export 
				xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
				xmlns:jaxws="http://www.ibm.com/xmlns/prod/websphere/scdl/jaxws/6.0.0" 
				xmlns:ns1="«svc.toTargetNamespace()»" 
				xmlns:scdl="http://www.ibm.com/xmlns/prod/websphere/scdl/6.0.0" 
				xmlns:wsdl="http://www.ibm.com/xmlns/prod/websphere/scdl/wsdl/6.0.0" 
				displayName="«svc.getExportDisplayName (protocol)»" 
				name="«svc.getExportName (protocol)»"
			> 
			<interfaces>
				<interface xsi:type="wsdl:WSDLPortType" preferredInteractionStyle="sync" portType="ns1:«svc.name»"/>
			</interfaces>
		</scdl:export>
		''';
		
		fsa.generateFile (exportFile, content);
	}
	
	def dispatch void toSCAModuleExport (SCA protocol) {
	}
}