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
 * A representation of the model object '<em><b>Responsibility</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Responsibility#getName <em>Name</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Responsibility#getEscalations <em>Escalations</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Responsibility#getPenalty <em>Penalty</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getResponsibility()
 * @model
 * @generated
 */
public interface Responsibility extends EObject
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
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getResponsibility_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.Responsibility#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Escalations</b></em>' containment reference list.
   * The list contents are of type {@link org.fornax.soa.sladsl.sLADsl.Escalation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Escalations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Escalations</em>' containment reference list.
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getResponsibility_Escalations()
   * @model containment="true"
   * @generated
   */
  EList<Escalation> getEscalations();

  /**
   * Returns the value of the '<em><b>Penalty</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Penalty</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Penalty</em>' attribute.
   * @see #setPenalty(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getResponsibility_Penalty()
   * @model
   * @generated
   */
  String getPenalty();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.Responsibility#getPenalty <em>Penalty</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Penalty</em>' attribute.
   * @see #getPenalty()
   * @generated
   */
  void setPenalty(String value);

} // Responsibility
