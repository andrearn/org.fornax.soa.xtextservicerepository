package org.xkonnex.repo.dsl.basedsl.model

import com.google.inject.Inject
import java.util.List
import org.xkonnex.repo.dsl.basedsl.ext.infer.IComponentInferrer
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature

class BottomUpEffectiveComponentInferrer implements IEffectiveFeatureInferrer {
	
	@Inject IComponentInferrer componentInferrer
	
	override <T> T inferFeatureValue(List<EObject> objectHierarchy, String featureName) {
		var Object effectiveFeatureValue = null
		val hierarchyIt = objectHierarchy.iterator
		while (effectiveFeatureValue == null && hierarchyIt.hasNext) {
			val curObj = hierarchyIt.next
			val feature = curObj.eClass.getEStructuralFeature(featureName)
			if (feature != null) {
				effectiveFeatureValue = curObj.eGet(feature);
			}
		}
		effectiveFeatureValue as T
	}
	
	override <T> T inferFeatureValue(List<EObject> objectHierarchy, EStructuralFeature feature) {
		var Object effectiveFeatureValue = null
		for (curObj : objectHierarchy) {
			val objFeature = curObj.eClass.getEStructuralFeature(feature.name)
			if (objFeature != null) {
				effectiveFeatureValue = curObj.eGet(objFeature, true);
				if (effectiveFeatureValue != null)
					return effectiveFeatureValue as T
			}
		}
		return null
	}
	
	override EObject inferFeatureValues(List<EObject> objectHierarchy, EObject target) {
		var specObj = objectHierarchy.head
		val features = target.eClass.EStructuralFeatures
		for (feature : features) {
			if (feature.isChangeable && !feature.derived) {
				val Object featureValue = inferFeatureValue(objectHierarchy, feature)
				target.eSet(feature, featureValue);
			}
		}
		return target
	}
	
}