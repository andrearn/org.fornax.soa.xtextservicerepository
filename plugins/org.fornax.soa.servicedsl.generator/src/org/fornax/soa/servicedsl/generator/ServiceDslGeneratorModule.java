package org.fornax.soa.servicedsl.generator;

import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.fornax.soa.ServiceDslRuntimeModule;
import org.fornax.soa.basedsl.sOABaseDsl.SOABaseDslFactory;
import org.fornax.soa.basedsl.sOABaseDsl.impl.SOABaseDslFactoryImpl;
import org.fornax.soa.basedsl.version.VersionMatcher;
import org.fornax.soa.basedsl.version.VersionQualifierExtensions;
import org.fornax.soa.profiledsl.generator.templates.MessageHeaderXSDTemplates;
import org.fornax.soa.service.query.ExceptionFinder;
import org.fornax.soa.service.query.HeaderFinder;
import org.fornax.soa.service.query.LifecycleQueries;
import org.fornax.soa.service.query.ServiceQueries;
import org.fornax.soa.service.query.VersionQueries;
import org.fornax.soa.service.query.namespace.NamespaceImportQueries;
import org.fornax.soa.service.query.namespace.NamespaceQuery;
import org.fornax.soa.service.query.type.BusinessObjectQueries;
import org.fornax.soa.service.query.type.ReferencedTypesFinder;
import org.fornax.soa.service.query.type.TypesByLifecycleStateFinder;
import org.fornax.soa.service.query.type.VersionedTypeFilter;
import org.fornax.soa.service.namespace.NamespaceSplitter;
import org.fornax.soa.servicedsl.generator.templates.CommonTemplateExtensions;
import org.fornax.soa.servicedsl.generator.templates.ServiceTemplates;
import org.fornax.soa.servicedsl.generator.templates.webservice.ServiceTemplateExtensions;
import org.fornax.soa.servicedsl.generator.templates.webservice.WSDLTemplates;
import org.fornax.soa.servicedsl.generator.templates.webservice.WrappedWsdlTemplates;
import org.fornax.soa.servicedsl.generator.templates.webservice.WsdlExtensions;
import org.fornax.soa.servicedsl.generator.templates.xsd.EventXSDTemplates;
import org.fornax.soa.servicedsl.generator.templates.xsd.OperationWrapperTemplates;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaTemplateExtensions;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaTypeExtensions;
import org.fornax.soa.servicedsl.generator.templates.xsd.XSDTemplates;
import org.fornax.soa.xtextservicerepo.generator.XtextServiceRepositoryGeneratorConstants;

import com.google.inject.Binder;
import com.google.inject.name.Names;

public class ServiceDslGeneratorModule extends ServiceDslRuntimeModule {
	
	public Class<? extends NamespaceSplitter> bindNamespaceSplitter () {
		return NamespaceSplitter.class;
	}
	
	public Class<? extends NamespaceImportQueries> bindNamespaceImportQueries () {
		return NamespaceImportQueries.class;
	}

	public Class<? extends NamespaceQuery> bindNamespaceQuery () {
		return NamespaceQuery.class;
	}
	
	public Class<? extends BusinessObjectQueries> bindBusinessObjectQueries () {
		return BusinessObjectQueries.class;
	}
	
	public Class<? extends ReferencedTypesFinder> bindReferencedTypesFinder () {
		return ReferencedTypesFinder.class;
	}
	
	public Class<? extends TypesByLifecycleStateFinder> bindTypesByLifecycleStateFinder () {
		return TypesByLifecycleStateFinder.class;
	}
	
	public Class<? extends VersionedTypeFilter> bindVersionedTypeFilter () {
		return VersionedTypeFilter.class;
	}
	
	public Class<? extends ExceptionFinder> bindExceptionFinder () {
		return ExceptionFinder.class;
	}
	
	public Class<? extends HeaderFinder> bindHeaderFinder () {
		return HeaderFinder.class;
	}
	
	public Class<? extends LifecycleQueries> bindLifecycleQueries () {
		return LifecycleQueries.class;
	}
	
	public Class<? extends ServiceQueries> bindServiceFinder () {
		return ServiceQueries.class;
	}
	
	public Class<? extends VersionQueries> bindVersionQueries () {
		return VersionQueries.class;
	}
	
	public Class<? extends CommonTemplateExtensions> bindCommonTemplateExtensions () {
		return CommonTemplateExtensions.class;
	}
	
	
	
	public Class<? extends ServiceTemplates> bindServiceTemplates () {
		return ServiceTemplates.class;
	}
	
	public Class<? extends EventXSDTemplates> bindEventXSDTemplates () {
		return EventXSDTemplates.class;
	}
	
	public Class<? extends MessageHeaderXSDTemplates> bindMessageHeaderXSDTemplates () {
		return MessageHeaderXSDTemplates.class;
	}
	
	public Class<? extends OperationWrapperTemplates> bindOperationWrapperTemplates () {
		return OperationWrapperTemplates.class;
	}
	
	public Class<? extends SchemaNamespaceExtensions> bindSchemaNamespaceExtensions () {
		return SchemaNamespaceExtensions.class;
	}
	
	public Class<? extends SchemaTemplateExtensions> bindSchemaTemplateExtensions () {
		return SchemaTemplateExtensions.class;
	}
	
	public Class<? extends SchemaTypeExtensions> bindSchemaTypeExtensions () {
		return SchemaTypeExtensions.class;
	}
	
	public Class<? extends XSDTemplates> bindXSDTemplates () {
		return XSDTemplates.class;
	}
	
	public Class<? extends ServiceTemplateExtensions> bindServiceTemplateExtensions () {
		return ServiceTemplateExtensions.class;
	}
	
	public Class<? extends WrappedWsdlTemplates> bindWrappedWsdlTemplates () {
		return WrappedWsdlTemplates.class;
	}
	
	public Class<? extends WsdlExtensions> bindWsdlExtensions () {
		return WsdlExtensions.class;
	}
	
	public Class<? extends WSDLTemplates> bindWSDLTemplates () {
		return WSDLTemplates.class;
	}
	
	public void configureNoDependencies (Binder binder) {
		binder.bind (Boolean.class).annotatedWith (Names.named ("noDependencies")).toInstance (false); 		
	}
	
	public void configureUseNestedPaths (Binder binder) {
		binder.bind (Boolean.class).annotatedWith (Names.named (XtextServiceRepositoryGeneratorConstants.USE_NESTED_PATHS))
			.toInstance (false);
	}
	public Class<? extends SOABaseDslFactory> bindSOABaseDslFactory () {
		return SOABaseDslFactoryImpl.class;
	}
	
	public Class<? extends VersionQualifierExtensions> bindVersionQualifierExtensions () {
		return VersionQualifierExtensions.class;
	}
	
	public Class<? extends VersionMatcher> bindVersionMatcher () {
		return VersionMatcher.class;
	}	
	
	public Class<? extends IFileSystemAccess> bindIFileSystemAccess () {
		return JavaIoFileSystemAccess.class;
	}

	
	
}
