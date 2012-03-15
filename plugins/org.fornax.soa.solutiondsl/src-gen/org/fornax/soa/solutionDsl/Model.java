/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.solutionDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.fornax.soa.basedsl.sOABaseDsl.Import;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.solutionDsl.Model#getImports <em>Imports</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Model#getSolution <em>Solution</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getModel()
 * @model
 * @generated
 */
public interface Model extends EObject
{
  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link org.fornax.soa.basedsl.sOABaseDsl.Import}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getModel_Imports()
   * @model containment="true"
   * @generated
   */
  EList<Import> getImports();

  /**
   * Returns the value of the '<em><b>Solution</b></em>' containment reference list.
   * The list contents are of type {@link org.fornax.soa.solutionDsl.Solution}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Solution</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Solution</em>' containment reference list.
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getModel_Solution()
   * @model containment="true"
   * @generated
   */
  EList<Solution> getSolution();

} // Model
