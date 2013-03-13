/**
 * <copyright>
 * </copyright>
 *

 */
package org.fornax.soa.sladsl.sLADsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Accuracy Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.AccuracyRequirement#getMaxErrorRate <em>Max Error Rate</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.AccuracyRequirement#getEscalation <em>Escalation</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.AccuracyRequirement#getPenalty <em>Penalty</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getAccuracyRequirement()
 * @model
 * @generated
 */
public interface AccuracyRequirement extends ServiceQualityProperty
{
  /**
   * Returns the value of the '<em><b>Max Error Rate</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Max Error Rate</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Max Error Rate</em>' attribute.
   * @see #setMaxErrorRate(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getAccuracyRequirement_MaxErrorRate()
   * @model
   * @generated
   */
  String getMaxErrorRate();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.AccuracyRequirement#getMaxErrorRate <em>Max Error Rate</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Max Error Rate</em>' attribute.
   * @see #getMaxErrorRate()
   * @generated
   */
  void setMaxErrorRate(String value);

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
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getAccuracyRequirement_Escalation()
   * @model containment="true"
   * @generated
   */
  Escalation getEscalation();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.AccuracyRequirement#getEscalation <em>Escalation</em>}' containment reference.
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
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getAccuracyRequirement_Penalty()
   * @model
   * @generated
   */
  String getPenalty();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.AccuracyRequirement#getPenalty <em>Penalty</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Penalty</em>' attribute.
   * @see #getPenalty()
   * @generated
   */
  void setPenalty(String value);

} // AccuracyRequirement
