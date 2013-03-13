/**
 * <copyright>
 * </copyright>
 *

 */
package org.fornax.soa.sladsl.sLADsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Throughput</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Throughput#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Throughput#getScore <em>Score</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Throughput#getEscalation <em>Escalation</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Throughput#getPenalty <em>Penalty</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getThroughput()
 * @model
 * @generated
 */
public interface Throughput extends ServiceQualityProperty
{
  /**
   * Returns the value of the '<em><b>Definition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Definition</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Definition</em>' attribute.
   * @see #setDefinition(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getThroughput_Definition()
   * @model
   * @generated
   */
  String getDefinition();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.Throughput#getDefinition <em>Definition</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Definition</em>' attribute.
   * @see #getDefinition()
   * @generated
   */
  void setDefinition(String value);

  /**
   * Returns the value of the '<em><b>Score</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Score</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Score</em>' attribute.
   * @see #setScore(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getThroughput_Score()
   * @model
   * @generated
   */
  String getScore();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.Throughput#getScore <em>Score</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Score</em>' attribute.
   * @see #getScore()
   * @generated
   */
  void setScore(String value);

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
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getThroughput_Escalation()
   * @model containment="true"
   * @generated
   */
  Escalation getEscalation();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.Throughput#getEscalation <em>Escalation</em>}' containment reference.
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
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getThroughput_Penalty()
   * @model
   * @generated
   */
  String getPenalty();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.Throughput#getPenalty <em>Penalty</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Penalty</em>' attribute.
   * @see #getPenalty()
   * @generated
   */
  void setPenalty(String value);

} // Throughput
