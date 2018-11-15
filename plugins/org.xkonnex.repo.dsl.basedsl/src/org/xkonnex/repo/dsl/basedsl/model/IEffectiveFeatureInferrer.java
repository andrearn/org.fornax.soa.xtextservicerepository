package org.xkonnex.repo.dsl.basedsl.model;

import com.google.inject.ImplementedBy;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.xkonnex.repo.dsl.basedsl.model.BottomUpEffectiveComponentInferrer;

/**
 * Inferrer of {@link EObject} features from object hierarchies
 * @author aarnold
 *
 */
@ImplementedBy(BottomUpEffectiveComponentInferrer.class)
public interface IEffectiveFeatureInferrer {

	/**
	 * Infer the feature value of feature {@code featureName} from the most specific {@link EObject} 
	 * in the {@code objectHierarchy}
	 * @param <T> The type of the feature
	 * 
	 * @param objectHierarchy {@link EObject}s ordered from bottom to top of the object hierarchy
	 * @param featureName name of the feature to be inferred
	 * @return the inferred value of the feature
	 */
	public <T> T inferFeatureValue (final List<EObject> objectHierarchy, final String featureName);
	
	/**
	 * Infer the feature value of feature {@code featureName} from the most specific {@link EObject} 
	 * in the {@code objectHierarchy}
	 * @param <T> The type of the feature
	 * 
	 * @param objectHierarchy {@link EObject}s ordered from bottom to top of the object hierarchy
	 * @param feature the feature to be inferred
	 * @return the inferred value of the feature
	 */
	public <T> T inferFeatureValue (final List<EObject> objectHierarchy, final EStructuralFeature feature);
	
	/**
	 * Infer the feature values of all features of the {@code target} object from the most specific {@link EObject} 
	 * in the {@code objectHierarchy}
	 * 
	 * @param objectHierarchy {@link EObject}s ordered from bottom to top of the object hierarchy
	 * @param target object whose feature values shall be inferred
	 * @return the target  object with the feature values
	 */
	public EObject inferFeatureValues (final List<EObject> objectHierarchy, EObject target);

}
