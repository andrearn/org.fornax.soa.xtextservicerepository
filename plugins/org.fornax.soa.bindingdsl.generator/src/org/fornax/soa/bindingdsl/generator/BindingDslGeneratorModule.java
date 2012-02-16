package org.fornax.soa.bindingdsl.generator;

import org.fornax.soa.BindingDslRuntimeModule;
import org.fornax.soa.bindingdsl.queries.modules.ModuleBindingResolver;
import org.fornax.soa.bindingdsl.queries.services.BindingServiceResolver;
import org.fornax.soa.bindingdsl.templates.BindingExtensions;
import org.fornax.soa.bindingdsl.templates.BindingTemplates;
import org.fornax.soa.bindingdsl.templates.soap.ConcreteProviderWsdlTemplates;
import org.fornax.soa.bindingdsl.templates.soap.ConcreteWsdlTemplates;
import org.fornax.soa.bindingdsl.templates.soap.SoapBindingResolver;
import org.fornax.soa.bindingdsl.templates.soap.SoapVendorBindingsResolver;
import org.fornax.soa.bindingdsl.templates.vendor.ibm.SCAExportExtension;
import org.fornax.soa.bindingdsl.templates.vendor.ibm.SCAExportTemplates;
import org.fornax.soa.bindingdsl.templates.wsdl.WrappedWSDLTemplates;
import org.fornax.soa.servicedsl.templates.webservice.WrappedWsdlTemplates;

public class BindingDslGeneratorModule extends BindingDslRuntimeModule {

	public Class<? extends ModuleBindingResolver> bindModuleBindingResolver () {
		return ModuleBindingResolver.class;
	}
	
	public Class<? extends BindingServiceResolver> bindBindingServiceResolver () {
		return BindingServiceResolver.class;
	}
	
	public Class<? extends BindingExtensions> bindBindingExtensions () {
		return BindingExtensions.class;
	}
	
	public Class<? extends BindingTemplates> bindBindingTemplates () {
		return BindingTemplates.class;
	}
	
	public Class<? extends ConcreteProviderWsdlTemplates> bindConcreteProviderWsdlTemplates () {
		return ConcreteProviderWsdlTemplates.class;
	}
	
	public Class<? extends ConcreteWsdlTemplates> bindConcreteWsdlTemplates () {
		return ConcreteWsdlTemplates.class;
	}
	
	public Class<? extends SoapBindingResolver> bindSoapBindingResolver () {
		return SoapBindingResolver.class;
	}
	
	public Class<? extends SoapVendorBindingsResolver> bindSoapVendorBindingsResolver () {
		return SoapVendorBindingsResolver.class;
	}
	
	public Class<? extends SCAExportExtension> bindSCAExportExtension () {
		return SCAExportExtension.class;
	}
	
	public Class<? extends SCAExportTemplates> bindSCAExportTemplates () {
		return SCAExportTemplates.class;
	}
	
	public Class<? extends WrappedWSDLTemplates> bindWrappedWSDLTemplates () {
		return WrappedWSDLTemplates.class;
	}
}
