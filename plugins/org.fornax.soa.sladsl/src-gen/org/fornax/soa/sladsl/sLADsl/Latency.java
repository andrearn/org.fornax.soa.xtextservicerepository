/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Latency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Latency#getLatency <em>Latency</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Latency#getPercentile <em>Percentile</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Latency#getEscalation <em>Escalation</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Latency#getPenalty <em>Penalty</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getLatency()
 * @model
 * @generated
 */
public interface Latency extends ServiceQualityProperty
{
  /**
   * Returns the value of the '<em><b>Latency</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Latency</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Latency</em>' attribute.
   * @see #setLatency(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getLatency_Latency()
   * @model
   * @generated
   */
  String getLatency();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.Latency#getLatency <em>Latency</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Latency</em>' attribute.
   * @see #getLatency()
   * @generated
   */
  void setLatency(String value);

  /**
   * Returns the value of the '<em><b>Percentile</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Percentile</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Percentile</em>' containment reference.
   * @see #setPercentile(Percentile)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getLatency_Percentile()
   * @model containment="true"
   * @generated
   */
  Percentile getPercentile();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.Latency#getPercentile <em>Percentile</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Percentile</em>' containment reference.
   * @see #getPercentile()
   * @generated
   */
  void setPercentile(Percentile value);

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
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getLatency_Escalation()
   * @model containment="true"
   * @generated
   */
  Escalation getEscalation();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.Latency#getEscalation <em>Escalation</em>}' containment reference.
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
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getLatency_Penalty()
   * @model
   * @generated
   */
  String getPenalty();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.Latency#getPenalty <em>Penalty</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Penalty</em>' attribute.
   * @see #getPenalty()
   * @generated
   */
  void setPenalty(String value);

} // Latency
