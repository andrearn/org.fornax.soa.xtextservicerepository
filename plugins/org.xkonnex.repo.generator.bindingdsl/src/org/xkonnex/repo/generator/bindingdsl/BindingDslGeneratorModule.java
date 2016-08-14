package org.xkonnex.repo.generator.bindingdsl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.xkonnex.repo.generator.profiledsl.ProfileGeneratorConstants;
import org.xkonnex.repo.dsl.bindingdsl.BindingDslRuntimeModule;
import org.xkonnex.repo.dsl.bindingdsl.binding.query.BindingLookup;
import org.xkonnex.repo.generator.bindingdsl.rest.raml.DefaultRAMLContractBuilder;
import org.xkonnex.repo.generator.bindingdsl.rest.wadl.DefaultWADLContractBuilder;
import org.xkonnex.repo.generator.bindingdsl.templates.BindingExtensions;
import org.xkonnex.repo.generator.bindingdsl.templates.TechnicalContractArtifactsBuilder;
import org.xkonnex.repo.generator.bindingdsl.templates.naming.DefaultEndpointQualifierNameProvider;
import org.xkonnex.repo.generator.bindingdsl.templates.soap.ConcreteWsdlGenerator;
import org.xkonnex.repo.generator.bindingdsl.templates.soap.SOAPProtocolContractBuilder;
import org.xkonnex.repo.generator.bindingdsl.templates.soap.SoapBindingResolver;
import org.xkonnex.repo.generator.bindingdsl.templates.soap.SoapVendorEndpointAddressResolver;
import org.xkonnex.repo.generator.bindingdsl.templates.vendor.ibm.SCAExportExtension;
import org.xkonnex.repo.generator.bindingdsl.templates.vendor.ibm.SCAExportTemplates;
import org.xkonnex.repo.generator.bindingdsl.templates.wsdl.WrappedWSDLBuilder;
import org.xkonnex.repo.generator.bindingdsl.templates.IArtifactBuilder;
import org.xkonnex.repo.generator.bindingdsl.templates.IProtocolContractBuilder;
import org.xkonnex.repo.generator.bindingdsl.templates.naming.IEndpointQualifierNameProvider;

import com.google.inject.Binder;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

public class BindingDslGeneratorModule extends BindingDslRuntimeModule {

	public Class<? extends BindingLookup> bindModuleBindingResolver () {
		return BindingLookup.class;
	}
	
	public Class<? extends BindingExtensions> bindBindingExtensions () {
		return BindingExtensions.class;
	}
	
	public Class<? extends IArtifactBuilder> bindBindingTemplates () {
		return TechnicalContractArtifactsBuilder.class;
	}
	
	public Class<? extends ConcreteWsdlGenerator> bindConcreteWsdlTemplates () {
		return ConcreteWsdlGenerator.class;
	}
	
	public Class<? extends SoapBindingResolver> bindSoapBindingResolver () {
		return SoapBindingResolver.class;
	}
	
	public Class<? extends SoapVendorEndpointAddressResolver> bindSoapVendorBindingsResolver () {
		return SoapVendorEndpointAddressResolver.class;
	}
	
	public Class<? extends SCAExportExtension> bindSCAExportExtension () {
		return SCAExportExtension.class;
	}
	
	public Class<? extends SCAExportTemplates> bindSCAExportTemplates () {
		return SCAExportTemplates.class;
	}
	
	public Class<? extends WrappedWSDLBuilder> bindWrappedWSDLTemplates () {
		return WrappedWSDLBuilder.class;
	}
	
	public Class<? extends IEndpointQualifierNameProvider> bindIEndpointQualifierNameProvider() {
		return DefaultEndpointQualifierNameProvider.class;
	}
	
	public void configureModuleBindingNames (Binder binder) {
		binder.bind (new TypeLiteral<List<String>>() {})
			.annotatedWith (
					Names.named (BindingDSLGeneratorConstants.MODULE_BINDING_NAMES))
			.toInstance (new ArrayList <String>());
	}
	
	public void configureModuleNames (Binder binder) {
		binder.bind (new TypeLiteral<List<String>>() {})
			.annotatedWith (
					Names.named (BindingDSLGeneratorConstants.MODULE_NAMES))
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
	
	public void configureBindingTemplates (final Binder binder) {
		binder.bind (new TypeLiteral<Set<ProvidedProtocolContractBuilder>> () {}).toInstance (
			new HashSet<ProvidedProtocolContractBuilder> () {
				{
					add (getLazyProtocolContractProvider (binder, SOAPProtocolContractBuilder.class));
					add (getLazyProtocolContractProvider(binder, DefaultWADLContractBuilder.class));
					add (getLazyProtocolContractProvider(binder, DefaultRAMLContractBuilder.class));
				}
			}
		);
	}
	
	public void configureProfileName (final Binder binder) {
		binder.bind (String.class)
			.annotatedWith (
					Names.named (ProfileGeneratorConstants.PROFILE_NAME))
			.toInstance ("");
	}
	
	public void configureTargetEnvironmentName (final Binder binder) {
		binder.bind (String.class)
			.annotatedWith (
					Names.named (BindingDSLGeneratorConstants.TARGET_ENVIRONMENT_NAME))
			.toInstance ("");
	}
	
	protected ProvidedProtocolContractBuilder getLazyProtocolContractProvider (final Binder binder, Class<? extends IProtocolContractBuilder> clazz) {
		return new ProvidedProtocolContractBuilder (binder.getProvider (clazz));
	}

}
