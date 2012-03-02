package org.fornax.soa.bindingdsl.generator.templates.vendor.ibm

import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile
import org.fornax.soa.bindingDsl.BindingProtocol
import org.fornax.soa.bindingDsl.ModuleBinding
import org.fornax.soa.moduledsl.moduleDsl.AssemblyType
import org.fornax.soa.servicedsl.generator.query.ServiceFinder
import com.google.inject.Inject
import org.fornax.soa.serviceDsl.Service
import org.fornax.soa.bindingDsl.SOAP
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions
import org.fornax.soa.environmentdsl.generator.EndpointResolver
import org.fornax.soa.bindingdsl.generator.queries.services.BindingServiceResolver
import org.fornax.soa.basedsl.generator.version.VersionQualifierExtensions
import org.fornax.soa.servicedsl.generator.templates.webservice.ServiceTemplateExtensions
import org.fornax.soa.bindingdsl.generator.templates.soap.SoapBindingResolver
import org.fornax.soa.bindingDsl.SCA
import org.eclipse.xtext.generator.IFileSystemAccess


/* Generator for IBM SCA export components */
class SCAExportTemplates {

	
	@Inject extension VersionQualifierExtensions
	@Inject extension ServiceFinder
	@Inject extension BindingExtensions
	@Inject extension BindingServiceResolver
	@Inject extension ServiceTemplateExtensions
	@Inject extension SCAExportExtension
	@Inject extension SoapBindingResolver
	@Inject extension EndpointResolver


	@Inject IFileSystemAccess fsa

	def dispatch void toSCAModuleExport (BindingProtocol protocol, SOAProfile profile) {
	}
	
	
	def dispatch void toSCAModuleExport (ModuleBinding binding, SOAProfile profile) {
		if (binding.module.module.assemblyType == AssemblyType::SCA_EAR) {
			for (provSvc : binding.module.module.providedServices) {
				val svc = provSvc.latestServiceInEnvironment (binding.environment);
				if (svc != null) {
					binding.getMostSpecificBinding (svc).protocol.forEach (p|p.toServiceExport (binding, svc, profile));
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
			<esbBinding xsi:type="jaxws:JaxWsExportBinding" port="ns1:«svc.toScopedPortName (protocol)»" service="ns1:«svc.name»"/>
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