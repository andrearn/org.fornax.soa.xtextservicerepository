/**
 * <copyright>
 * </copyright>
 *

 */
package org.fornax.soa.sladsl.sLADsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Capacity Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.CapacityRequirement#getRequestNum <em>Request Num</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.CapacityRequirement#getTimeUnit <em>Time Unit</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.CapacityRequirement#getMessageSize <em>Message Size</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.CapacityRequirement#getEscalation <em>Escalation</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.CapacityRequirement#getPenalty <em>Penalty</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getCapacityRequirement()
 * @model
 * @generated
 */
public interface CapacityRequirement extends ServiceQualityProperty
{
  /**
   * Returns the value of the '<em><b>Request Num</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Request Num</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Request Num</em>' attribute.
   * @see #setRequestNum(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getCapacityRequirement_RequestNum()
   * @model
   * @generated
   */
  String getRequestNum();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.CapacityRequirement#getRequestNum <em>Request Num</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Request Num</em>' attribute.
   * @see #getRequestNum()
   * @generated
   */
  void setRequestNum(String value);

  /**
   * Returns the value of the '<em><b>Time Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Time Unit</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Time Unit</em>' attribute.
   * @see #setTimeUnit(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getCapacityRequirement_TimeUnit()
   * @model
   * @generated
   */
  String getTimeUnit();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.CapacityRequirement#getTimeUnit <em>Time Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Time Unit</em>' attribute.
   * @see #getTimeUnit()
   * @generated
   */
  void setTimeUnit(String value);

  /**
   * Returns the value of the '<em><b>Message Size</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Message Size</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Message Size</em>' attribute.
   * @see #setMessageSize(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getCapacityRequirement_MessageSize()
   * @model
   * @generated
   */
  String getMessageSize();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.CapacityRequirement#getMessageSize <em>Message Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message Size</em>' attribute.
   * @see #getMessageSize()
   * @generated
   */
  void setMessageSize(String value);

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
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getCapacityRequirement_Escalation()
   * @model containment="true"
   * @generated
   */
  Escalation getEscalation();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.CapacityRequirement#getEscalation <em>Escalation</em>}' containment reference.
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
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getCapacityRequirement_Penalty()
   * @model
   * @generated
   */
  String getPenalty();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.CapacityRequirement#getPenalty <em>Penalty</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Penalty</em>' attribute.
   * @see #getPenalty()
   * @generated
   */
  void setPenalty(String value);

} // CapacityRequirement
