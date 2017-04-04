package org.xkonnex.repo.dsl.basedsl.scoping

import com.google.common.base.Function
import com.google.common.collect.Lists
import com.google.common.collect.Maps
import com.google.inject.Inject
import com.google.inject.Provider
import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.JvmFeature
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.ImportNormalizer
import org.eclipse.xtext.util.SimpleAttributeResolver
import org.xkonnex.repo.dsl.basedsl.baseDsl.Assignment
import org.xkonnex.repo.dsl.basedsl.baseDsl.BaseDslPackage
import org.xkonnex.repo.dsl.basedsl.baseDsl.Component
import org.xkonnex.repo.dsl.basedsl.baseDsl.EnumLiteralValue
import org.xkonnex.repo.dsl.basedsl.baseDsl.Reference
import org.xkonnex.repo.dsl.basedsl.baseDsl.Value
import org.xkonnex.repo.dsl.basedsl.scoping.versions.filter.VersionedImportedNamespaceAwareScopeProvider
import org.eclipse.xtext.scoping.impl.FilteringScope
import java.util.function.Predicate
import org.eclipse.xtext.resource.IEObjectDescription

@SuppressWarnings("restriction") 
abstract class ComponentAwareVersionedScopeProvider extends VersionedImportedNamespaceAwareScopeProvider {
	
	@Inject extension ComponentExtensions
	@Inject IInjectableFeatureLookup featureLookup
	@Inject Provider<NameComputation> nameComputationProvider
	
	def override IScope getScope(EObject context, EReference reference) {
		if (context instanceof Assignment && reference == BaseDslPackage.Literals.ASSIGNMENT__FEATURE) {
			if (context.eContainer() === null)
				throw new IllegalStateException("context.eContainer may not be null");
			val component = EcoreUtil2.getContainerOfType(context, typeof(Component))
			if (component === null)
				throw new IllegalStateException("No containing Component");
			return createComponentFeaturesScope(component);
		}
		if (context instanceof Reference && reference == BaseDslPackage.Literals.REFERENCE__REFERABLE) {
//			return createComponentReferenceScopeUpTo(context.eContainer(), false);
			return super.getScope(context, reference)
		}
		if (context instanceof Assignment && reference == BaseDslPackage.Literals.REFERENCE__REFERABLE) {
			val assign = context as Assignment
			val type = assign.getActualType
			val delegateScope = super.getScope(context, reference)
			val scope = new FilteringScope(delegateScope, new com.google.common.base.Predicate<IEObjectDescription>() {
				
				override apply(IEObjectDescription desc) {
					return desc.EClass.instanceClass.canonicalName == type.qualifiedName
				}
				
			})
			return scope
		}
		if (context instanceof EnumLiteralValue && reference == BaseDslPackage.Literals.ENUM_LITERAL_VALUE__VALUE) {
			val eńumLitType = context as EnumLiteralValue
			return createEnumLiteralValueFeaturesScope(eńumLitType)
		}
		return super.getScope(context, reference)
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
		return allowObjects || !(value instanceof Component) 
	}

	def boolean collectReferablesUpTo(Component component, EObject object, List<Component> result) {
		result.add(component)
		if(component === object) return false
		for (Assignment assignment : component.getAssignment()) {
			if(assignment === object) return false
			if (assignment.getValue() instanceof EObject) {
				if(!collectReferablesUpTo((assignment.getValue() as Component), object, result)) return false
			}
		}
		return true
	}

	def IScope createComponentFeaturesScope(Component container) {
		val JvmType containerType = container.getActualType();
		if (containerType === null || containerType.eIsProxy())
			return IScope.NULLSCOPE;
		val Map<QualifiedName, JvmFeature> features = Maps.newHashMap();
//		var JvmType createType = factorySupport.findFactoriesCreationType(containerType);
//		if (createType != null) {
//			features.putAll(featureLookup.getInjectableFeatures(createType));
//		}
		features.putAll(featureLookup.getInjectableFeatures(containerType));
		return new MapBasedScope(features);
	}

	def IScope createEnumLiteralValueFeaturesScope(EnumLiteralValue container) {
		val JvmType containerType = container.getActualType();
		if (containerType === null || containerType.eIsProxy())
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

	
	protected override List<ImportNormalizer> getImplicitImports(boolean ignoreCase) {
		val List<ImportNormalizer> result = newArrayList();
		result.add(createImportedNamespaceResolver("java.lang.*", ignoreCase));
		return result;
	}

}
