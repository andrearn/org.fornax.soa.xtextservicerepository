/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cost</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Cost#getCostsAmount <em>Costs Amount</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Cost#getBilledUnit <em>Billed Unit</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Cost#getEffortAccounting <em>Effort Accounting</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Cost#getEscalation <em>Escalation</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Cost#getPenalty <em>Penalty</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getCost()
 * @model
 * @generated
 */
public interface Cost extends EObject
{
  /**
   * Returns the value of the '<em><b>Costs Amount</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Costs Amount</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Costs Amount</em>' attribute.
   * @see #setCostsAmount(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getCost_CostsAmount()
   * @model
   * @generated
   */
  String getCostsAmount();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.Cost#getCostsAmount <em>Costs Amount</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Costs Amount</em>' attribute.
   * @see #getCostsAmount()
   * @generated
   */
  void setCostsAmount(String value);

  /**
   * Returns the value of the '<em><b>Billed Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Billed Unit</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Billed Unit</em>' attribute.
   * @see #setBilledUnit(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getCost_BilledUnit()
   * @model
   * @generated
   */
  String getBilledUnit();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.Cost#getBilledUnit <em>Billed Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Billed Unit</em>' attribute.
   * @see #getBilledUnit()
   * @generated
   */
  void setBilledUnit(String value);

  /**
   * Returns the value of the '<em><b>Effort Accounting</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Effort Accounting</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Effort Accounting</em>' attribute.
   * @see #setEffortAccounting(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getCost_EffortAccounting()
   * @model
   * @generated
   */
  String getEffortAccounting();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.Cost#getEffortAccounting <em>Effort Accounting</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Effort Accounting</em>' attribute.
   * @see #getEffortAccounting()
   * @generated
   */
  void setEffortAccounting(String value);

  /**
   * Returns the value of the '<em><b>Escalation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Escalation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Escalation</em>' containment reference.
   * @see #setEscalation(Escalation)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getCost_Escalation()
   * @model containment="true"
   * @generated
   */
  Escalation getEscalation();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.Cost#getEscalation <em>Escalation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Escalation</em>' containment reference.
   * @see #getEscalation()
   * @generated
   */
  void setEscalation(Escalation value);

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
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getCost_Penalty()
   * @model
   * @generated
   */
  String getPenalty();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.Cost#getPenalty <em>Penalty</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Penalty</em>' attribute.
   * @see #getPenalty()
   * @generated
   */
  void setPenalty(String value);

} // Cost
