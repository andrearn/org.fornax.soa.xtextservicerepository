package org.xkonnex.repo.dsl.basedsl.scoping

import com.google.common.base.Function
import com.google.common.collect.Lists
import com.google.common.collect.Maps
import com.google.inject.Inject
import com.google.inject.Provider
import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.JvmFeature
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider
import org.eclipse.xtext.util.SimpleAttributeResolver
import org.xkonnex.repo.dsl.basedsl.baseDsl.Assignment
import org.xkonnex.repo.dsl.basedsl.baseDsl.Component
import org.xkonnex.repo.dsl.basedsl.baseDsl.Value
import org.eclipse.emf.ecore.EReference
import org.xkonnex.repo.dsl.basedsl.baseDsl.BaseDslPackage
import org.xkonnex.repo.dsl.basedsl.baseDsl.Reference

@SuppressWarnings("restriction") 
abstract class AbstractComponentScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {
	
	@Inject extension ComponentExtensions
	@Inject IInjectableFeatureLookup featureLookup
	@Inject Provider<NameComputation> nameComputationProvider
	@Inject JavaNamespaceAwareScopeProvider javaNamespaceAwareScopeProvider
	
	def override IScope getScope(EObject context, EReference reference) {
		if (context instanceof Assignment && reference == BaseDslPackage.Literals.ASSIGNMENT__FEATURE) {
			if (context.eContainer() == null)
				throw new IllegalStateException("context.eContainer may not be null");
			if (!(context.eContainer() instanceof Component))
				throw new IllegalStateException("context.eContainer has to be instance of Component");
			val container = context.eContainer() as Component;
			return createComponentFeaturesScope(container);
		}
		if (context instanceof Reference && reference == BaseDslPackage.Literals.REFERENCE__REFERABLE) {
			return createComponentReferenceScopeUpTo(context.eContainer(), false);
		}
		if (context instanceof Assignment && reference == BaseDslPackage.Literals.REFERENCE__REFERABLE) {
			return createComponentReferenceScopeUpTo(context.eContainer(), true);
		}
		return javaNamespaceAwareScopeProvider.getScope(context, reference);
	}

	def IScope createComponentReferenceScopeUpTo(EObject object, boolean allowObjects) {
		var List<Component> result = Lists.newArrayList()
		collectReferablesUpTo(object, allowObjects, result)
		return createLocalComponentScope(result)
	}

	def void collectReferablesUpTo(EObject object, boolean allowObjects, List<Component> result) {
		var Component component = EcoreUtil2.getContainerOfType(object, Component)
		if(allowObjects) collectReferablesUpTo(component, object, result)
	}

	def protected boolean isAllowed(Value value, boolean allowObjects) {
		return allowObjects || !(value instanceof Component) // TODO: discuss
		// how we handle
		// component
		// references in
		// strings
	}

	def boolean collectReferablesUpTo(Component component, EObject object, List<Component> result) {
		result.add(component)
		if(component === object) return false
		for (Assignment assignment : component.getAssignment()) {
			if(assignment === object) return false
			if (assignment.getValue() instanceof Component) {
				if(!collectReferablesUpTo((assignment.getValue() as Component), object, result)) return false
			}
		}
		return true
	}

	def IScope createComponentFeaturesScope(Component container) {
		val JvmType containerType = container.getActualType();
		if (containerType == null || containerType.eIsProxy())
			return IScope.NULLSCOPE;
		val Map<QualifiedName, JvmFeature> features = Maps.newHashMap();
//		var JvmType createType = factorySupport.findFactoriesCreationType(containerType);
//		if (createType != null) {
//			features.putAll(featureLookup.getInjectableFeatures(createType));
//		}
		features.putAll(featureLookup.getInjectableFeatures(containerType));
		return new MapBasedScope(features);
	}

	def protected IScope createLocalComponentScope(List<? extends EObject> elements) {
		return Scopes.scopeFor(elements, nameComputationProvider.get(), IScope.NULLSCOPE)
	}

	def void setFeatureLookup(IInjectableFeatureLookup featureLookup) {
		this.featureLookup = featureLookup
	}

	def IInjectableFeatureLookup getFeatureLookup() {
		return featureLookup
	}

	protected static class NameComputation implements Function<EObject, QualifiedName> {
		@Inject IQualifiedNameConverter qualifiedNameConverter
		SimpleAttributeResolver<EObject, String> nameResolver = SimpleAttributeResolver.newResolver(String, "name")

		override QualifiedName apply(EObject from) {
			var String name = nameResolver.apply(from)
			if(name !== null && name.length() > 0) return qualifiedNameConverter.toQualifiedName(
				nameResolver.apply(from))
			return null
		}
	}
}
