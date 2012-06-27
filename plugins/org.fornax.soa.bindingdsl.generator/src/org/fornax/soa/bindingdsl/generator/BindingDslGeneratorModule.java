package org.fornax.soa.bindingdsl.generator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.fornax.soa.BindingDslRuntimeModule;
import org.fornax.soa.bindingdsl.generator.queries.modules.ModuleBindingResolver;
import org.fornax.soa.bindingdsl.generator.queries.services.BindingServiceResolver;
import org.fornax.soa.bindingdsl.generator.templates.BindingBuilder;
import org.fornax.soa.bindingdsl.generator.templates.BindingExtensions;
import org.fornax.soa.bindingdsl.generator.templates.IProtocolContractBuilder;
import org.fornax.soa.bindingdsl.generator.templates.soap.ConcreteProviderWsdlTemplates;
import org.fornax.soa.bindingdsl.generator.templates.soap.ConcreteWsdlTemplates;
import org.fornax.soa.bindingdsl.generator.templates.soap.SOAPProtocolContractBuilder;
import org.fornax.soa.bindingdsl.generator.templates.soap.SoapBindingResolver;
import org.fornax.soa.bindingdsl.generator.templates.soap.SoapVendorBindingsResolver;
import org.fornax.soa.bindingdsl.generator.templates.vendor.ibm.SCAExportExtension;
import org.fornax.soa.bindingdsl.generator.templates.vendor.ibm.SCAExportTemplates;
import org.fornax.soa.bindingdsl.generator.templates.wsdl.WrappedWSDLTemplates;

import com.google.inject.Binder;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

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
	
	public Class<? extends BindingBuilder> bindBindingTemplates () {
		return BindingBuilder.class;
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
	
	public void configureModuleBindingNames (Binder binder) {
		binder.bind (new TypeLiteral<List<String>>() {})
			.annotatedWith (
					Names.named (BindingDSLGeneratorConstants.MODULE_BINDING_NAMES))
			.toInstance (new ArrayList <String>());
	}

	public void configureDomainBindingNames (Binder binder) {
		binder.bind (new TypeLiteral<List<String>>() {})
			.annotatedWith (
					Names.named (BindingDSLGeneratorConstants.DOMAIN_BINDING_NAMES))
			.toInstance (new ArrayList <String>());
	}

	public void configureNameSpaces (Binder binder) {
		binder.bind (new TypeLiteral<List<String>>() {})
			.annotatedWith (
					Names.named (BindingDSLGeneratorConstants.NAME_SPACES))
			.toInstance (new ArrayList <String>());
	}
	
	public void configureNoDependencies (Binder binder) {
		binder.bind (Boolean.class)
			.annotatedWith (
					Names.named (BindingDSLGeneratorConstants.NO_DEPENDENCIES))
			.toInstance (false);
	}
	
	public void configureIncludeSubNamespace (Binder binder) {
		binder.bind (Boolean.class)
			.annotatedWith (
					Names.named (BindingDSLGeneratorConstants.INCLUDE_SUB_NAMESPACES))
			.toInstance (false);
	}

	public void configureGeneratePrivateWsdlForProviderHost (Binder binder) {
		binder.bind (Boolean.class)
			.annotatedWith (
					Names.named (BindingDSLGeneratorConstants.GENERATE_PRIVATE_WSDL_FOR_PROVIDER_HOST))
			.toInstance (false);
	}
	
	public void configureBindingTemplates (final Binder binder) {
		binder.bind (new TypeLiteral<Set<ProvidedProtocolContractBuilder>> () {}).toInstance (
			new HashSet<ProvidedProtocolContractBuilder> () {
				{
					add (getLazyProtocolContractProvider (binder, SOAPProtocolContractBuilder.class));
				}
			}
		);
	}
	
	public void configureForceRelativePaths (final Binder binder) {
		binder.bind(Boolean.class).annotatedWith(Names.named("forceRelativePaths")).toInstance(true);
	}
	
	protected ProvidedProtocolContractBuilder getLazyProtocolContractProvider (final Binder binder, Class<? extends IProtocolContractBuilder> clazz) {
		return new ProvidedProtocolContractBuilder (binder.getProvider (clazz));
	}

}
