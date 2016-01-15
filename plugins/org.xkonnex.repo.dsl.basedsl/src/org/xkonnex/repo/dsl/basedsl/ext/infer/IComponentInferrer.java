package org.xkonnex.repo.dsl.basedsl.ext.infer;

import java.util.List;

import org.eclipse.xtext.common.types.JvmType;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Assignment;

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
	 * 
	 * @param type
	 *            The referenced Java type. Should be acquired from the
	 *            extensible model element.
	 * @return
	 */
	public <T> T inferComponent(JvmType type);

	/**
	 * infer a new instance of the referenced JvmType with all assignments
	 * applied. Nested component instances will also be inferred recursively. 
	 * 
	 * @param type
	 *            The referenced Java type. Should be acquired from the
	 *            extensible model element.
	 * @param assignments
	 *            The value {@link Assignment}s from the model element. Should
	 *            be acquired from the extensible model element that provides
	 *            the type.
	 * @return
	 */
	public <T> T inferComponent(JvmType type, List<Assignment> assignments);

}
