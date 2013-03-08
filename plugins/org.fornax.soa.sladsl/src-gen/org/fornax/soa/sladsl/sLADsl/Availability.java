/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Availability</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Availability#getAvailability <em>Availability</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Availability#getPercentile <em>Percentile</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Availability#getMtbf <em>Mtbf</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Availability#getMttr <em>Mttr</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Availability#getMttrPercentile <em>Mttr Percentile</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.Availability#getRegularDownTimes <em>Regular Down Times</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getAvailability()
 * @model
 * @generated
 */
public interface Availability extends ServiceQualityProperty
{
  /**
   * Returns the value of the '<em><b>Availability</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Availability</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Availability</em>' attribute.
   * @see #setAvailability(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getAvailability_Availability()
   * @model
   * @generated
   */
  String getAvailability();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.Availability#getAvailability <em>Availability</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Availability</em>' attribute.
   * @see #getAvailability()
   * @generated
   */
  void setAvailability(String value);

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
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getAvailability_Percentile()
   * @model containment="true"
   * @generated
   */
  Percentile getPercentile();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.Availability#getPercentile <em>Percentile</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Percentile</em>' containment reference.
   * @see #getPercentile()
   * @generated
   */
  void setPercentile(Percentile value);

  /**
   * Returns the value of the '<em><b>Mtbf</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mtbf</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mtbf</em>' attribute.
   * @see #setMtbf(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getAvailability_Mtbf()
   * @model
   * @generated
   */
  String getMtbf();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.Availability#getMtbf <em>Mtbf</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mtbf</em>' attribute.
   * @see #getMtbf()
   * @generated
   */
  void setMtbf(String value);

  /**
   * Returns the value of the '<em><b>Mttr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mttr</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mttr</em>' attribute.
   * @see #setMttr(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getAvailability_Mttr()
   * @model
   * @generated
   */
  String getMttr();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.Availability#getMttr <em>Mttr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mttr</em>' attribute.
   * @see #getMttr()
   * @generated
   */
  void setMttr(String value);

  /**
   * Returns the value of the '<em><b>Mttr Percentile</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mttr Percentile</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mttr Percentile</em>' containment reference.
   * @see #setMttrPercentile(Percentile)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getAvailability_MttrPercentile()
   * @model containment="true"
   * @generated
   */
  Percentile getMttrPercentile();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.Availability#getMttrPercentile <em>Mttr Percentile</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mttr Percentile</em>' containment reference.
   * @see #getMttrPercentile()
   * @generated
   */
  void setMttrPercentile(Percentile value);

  /**
   * Returns the value of the '<em><b>Regular Down Times</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Regular Down Times</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Regular Down Times</em>' attribute.
   * @see #setRegularDownTimes(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getAvailability_RegularDownTimes()
   * @model
   * @generated
   */
  String getRegularDownTimes();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.Availability#getRegularDownTimes <em>Regular Down Times</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Regular Down Times</em>' attribute.
   * @see #getRegularDownTimes()
   * @generated
   */
  void setRegularDownTimes(String value);

} // Availability
