/**
 * <copyright>
 * </copyright>
 *

 */
package org.fornax.soa.sladsl.sLADsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.fornax.soa.basedsl.sOABaseDsl.User;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Escalation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Escalation#getCause <em>Cause</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Escalation#getEscalationTargets <em>Escalation Targets</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Escalation#getProcedure <em>Procedure</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getEscalation()
 * @model
 * @generated
 */
public interface Escalation extends EObject
{
  /**
   * Returns the value of the '<em><b>Cause</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cause</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cause</em>' attribute.
   * @see #setCause(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getEscalation_Cause()
   * @model
   * @generated
   */
  String getCause();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.Escalation#getCause <em>Cause</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cause</em>' attribute.
   * @see #getCause()
   * @generated
   */
  void setCause(String value);

  /**
   * Returns the value of the '<em><b>Escalation Targets</b></em>' reference list.
   * The list contents are of type {@link org.fornax.soa.basedsl.sOABaseDsl.User}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Escalation Targets</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Escalation Targets</em>' reference list.
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getEscalation_EscalationTargets()
   * @model
   * @generated
   */
  EList<User> getEscalationTargets();

  /**
   * Returns the value of the '<em><b>Procedure</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Procedure</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Procedure</em>' attribute.
   * @see #setProcedure(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getEscalation_Procedure()
   * @model
   * @generated
   */
  String getProcedure();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.Escalation#getProcedure <em>Procedure</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Procedure</em>' attribute.
   * @see #getProcedure()
   * @generated
   */
  void setProcedure(String value);

} // Escalation
