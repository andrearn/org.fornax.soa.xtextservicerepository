package org.xkonnex.repo.dsl.basedsl.ext.infer;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmType;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Assignment;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Component;

import com.google.inject.ImplementedBy;

/**
 * Infer a referenced Component type of extensible DSL model elements. An
 * instance of the referenced type in the model will be created and all it's
 * properties will be set to values provided in the assignments, if any.
 * 
 * Should be used to access Java extensible model elements for in in code
 * generators or other components.
 * 
 * @author André Arnold
 * 
 */
@ImplementedBy(ComponentInferrer.class)
public interface IComponentInferrer {
	
	/**
	 * infer a new instance of the referenced JvmType. 
	 * @param <T> the component type
	 * 
	 * @param component The component to infer a Java Bean of it's referenced type with all assignments applied.
	 * @return the inferred new JvmType instance
	 */
	public <T> T inferComponent(Component component);
	
	/**
	 * infer a new instance of the referenced JvmType. 
	 * @param <T> The type of the Component
	 * 
	 * @param component
	 *            The component to infer a Java Bean of it's referenced type with all assignments applied.
	 * @param resourceSet The ResourceSet of the model
	 * @return the inferred new JvmType instance
	 */
	public <T> T inferComponent(Component component, ResourceSet resourceSet);

	/**
	 * infer a new instance of the referenced JvmType. 
	 * @param <T> The type of the Component
	 * 
	 * @param type
	 *            The referenced Java type. Should be acquired from the
	 *            extensible model element.
	 * @return the inferred new JvmType instance
	 */
	public <T> T inferComponent(JvmType type);

	/**
	 * infer a new instance of the referenced JvmType with all assignments
	 * applied. Nested component instances will also be inferred recursively. 
	 * @param <T> The type of the Component
	 * 
	 * @param type
	 *            The referenced Java type. Should be acquired from the
	 *            extensible model element.
	 * @param assignments
	 *            The value {@link Assignment}s from the model element. Should
	 *            be acquired from the extensible model element that provides
	 *            the type.
	 * @return the inferred new JvmType instance
	 */
	public <T> T inferComponent(JvmType type, List<Assignment> assignments);

}
