/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.solutionDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.fornax.soa.semanticsDsl.Tag;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.solutionDsl.Module#getName <em>Name</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Module#getKind <em>Kind</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Module#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Module#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Module#getModules <em>Modules</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.Module#getTags <em>Tags</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getModule()
 * @model
 * @generated
 */
public interface Module extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getModule_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.fornax.soa.solutionDsl.Module#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The literals are from the enumeration {@link org.fornax.soa.solutionDsl.ModuleKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see org.fornax.soa.solutionDsl.ModuleKind
   * @see #setKind(ModuleKind)
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getModule_Kind()
   * @model
   * @generated
   */
  ModuleKind getKind();

  /**
   * Sets the value of the '{@link org.fornax.soa.solutionDsl.Module#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see org.fornax.soa.solutionDsl.ModuleKind
   * @see #getKind()
   * @generated
   */
  void setKind(ModuleKind value);

  /**
   * Returns the value of the '<em><b>Requires</b></em>' containment reference list.
   * The list contents are of type {@link org.fornax.soa.solutionDsl.ServiceRef}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Requires</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requires</em>' containment reference list.
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getModule_Requires()
   * @model containment="true"
   * @generated
   */
  EList<ServiceRef> getRequires();

  /**
   * Returns the value of the '<em><b>Features</b></em>' containment reference list.
   * The list contents are of type {@link org.fornax.soa.solutionDsl.Feature}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Features</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Features</em>' containment reference list.
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getModule_Features()
   * @model containment="true"
   * @generated
   */
  EList<Feature> getFeatures();

  /**
   * Returns the value of the '<em><b>Modules</b></em>' containment reference list.
   * The list contents are of type {@link org.fornax.soa.solutionDsl.Module}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Modules</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modules</em>' containment reference list.
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getModule_Modules()
   * @model containment="true"
   * @generated
   */
  EList<Module> getModules();

  /**
   * Returns the value of the '<em><b>Tags</b></em>' reference list.
   * The list contents are of type {@link org.fornax.soa.semanticsDsl.Tag}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tags</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tags</em>' reference list.
   * @see org.fornax.soa.solutionDsl.SolutionDslPackage#getModule_Tags()
   * @model
   * @generated
   */
  EList<Tag> getTags();

} // Module
