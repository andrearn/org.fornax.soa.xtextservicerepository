/**
 * <copyright>
 * </copyright>
 *

 */
package org.fornax.soa.sladsl.sLADsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Party</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Party#getName <em>Name</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Party#getRepresentatives <em>Representatives</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Party#getResponsibilities <em>Responsibilities</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getParty()
 * @model
 * @generated
 */
public interface Party extends EObject
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
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getParty_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.Party#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Representatives</b></em>' containment reference list.
   * The list contents are of type {@link org.fornax.soa.sladsl.sLADsl.Repesentative}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Representatives</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Representatives</em>' containment reference list.
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getParty_Representatives()
   * @model containment="true"
   * @generated
   */
  EList<Repesentative> getRepresentatives();

  /**
   * Returns the value of the '<em><b>Responsibilities</b></em>' containment reference list.
   * The list contents are of type {@link org.fornax.soa.sladsl.sLADsl.Responsibility}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Responsibilities</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Responsibilities</em>' containment reference list.
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getParty_Responsibilities()
   * @model containment="true"
   * @generated
   */
  EList<Responsibility> getResponsibilities();

} // Party
