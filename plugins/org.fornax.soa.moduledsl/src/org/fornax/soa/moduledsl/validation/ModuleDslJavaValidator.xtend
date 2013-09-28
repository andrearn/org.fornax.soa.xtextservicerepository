package org.fornax.soa.moduledsl.validation

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.validation.Check;
import org.fornax.soa.basedsl.search.IEObjectLookup;
import org.fornax.soa.basedsl.validation.PluggableChecks;
import org.fornax.soa.basedsl.version.VersionMatcher;
import org.fornax.soa.moduledsl.moduleDsl.AbstractServiceRef;
import org.fornax.soa.moduledsl.moduleDsl.ImportServiceRef;
import org.fornax.soa.moduledsl.moduleDsl.Module;
import org.fornax.soa.moduledsl.moduleDsl.ModuleDslPackage;
import org.fornax.soa.moduledsl.moduleDsl.ServiceRef;
import org.fornax.soa.moduledsl.query.IModuleServiceResolver;
import org.fornax.soa.moduledsl.query.ModuleLookup;
import org.fornax.soa.service.util.CandidateServicesPredicate;
import org.fornax.soa.serviceDsl.Service;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.fornax.soa.moduledsl.moduleDsl.ServiceModuleRef

@PluggableChecks (validators = #[
	typeof (ModuleLifecycleStateValidator)
])
class ModuleDslJavaValidator extends AbstractModuleDslJavaValidator {
	@Inject
	private IEObjectLookup objLookup;
	@Inject
	private ModuleLookup modLookup;
	@Inject 
	private IModuleServiceResolver modServiceResolver;
	@Inject
	private IQualifiedNameProvider nameProvider;

	@Check
	def void importServiceRefHasProvidingmodule(ImportServiceRef importServiceRef) {
		val Module owningModule = objLookup.getOwnerByType(importServiceRef, typeof(Module))
		if (importServiceRef.getModules().isEmpty()) {
			var List<Service> candServices = new ArrayList<Service>();
			var Set<Module> allModules = modLookup.findAllModules (importServiceRef.eResource().getResourceSet())
			for (Module mod : allModules) {
				if (!mod.equals(owningModule)) {
					extractProvidedServices(importServiceRef, candServices, mod)
				}
			}
			if (!candServices.contains(importServiceRef.getService())) {
				error ('''The service «nameProvider.getFullyQualifiedName (importServiceRef.getService()).toString()» is not being provided by any module.''', ModuleDslPackage.Literals.ABSTRACT_SERVICE_REF__SERVICE)
			}
		}
	}
	
	@Check
	def void importServiceRefServiceProvidedByModule(ServiceModuleRef modRef) {
		var Module owningModule = objLookup.getOwnerByType(modRef, typeof (Module))
		if (modRef.eContainer instanceof ImportServiceRef) {
			var ImportServiceRef importServiceRef = modRef.eContainer as ImportServiceRef
			var List<Service> candServices = new ArrayList<Service>();
			if (modRef.module != owningModule) {
				extractProvidedServices(importServiceRef, candServices, modRef.module)
			}
			if (!candServices.contains(importServiceRef.getService())) {
				error ('''The service «nameProvider.getFullyQualifiedName (importServiceRef.getService()).toString()» is not being provided by module «nameProvider.getFullyQualifiedName (modRef.module).toString».''', ModuleDslPackage.Literals.SERVICE_MODULE_REF__MODULE);
			}
		}
	}
	
	def private void extractProvidedServices(EObject context,
			List<Service> candServices, Module targetModule) {
		var mod = targetModule
		if (mod != null) {
			if (mod.eIsProxy())
				mod = EcoreUtil.resolve (targetModule, context.eResource().getResourceSet()) as Module
			val Set<AbstractServiceRef> providedServiceRefs = modServiceResolver.getAllProvidedServiceRefs(targetModule)
			for (AbstractServiceRef serviceRef : providedServiceRefs) {
				var svcRef = serviceRef
				if (svcRef.eIsProxy()) {
					svcRef = EcoreUtil.resolve (svcRef, context.eResource().getResourceSet()) as ServiceRef;
				}
				if (svcRef.getService() != null)
					candServices.add (svcRef.getService())
			}
		}
	}
	
}