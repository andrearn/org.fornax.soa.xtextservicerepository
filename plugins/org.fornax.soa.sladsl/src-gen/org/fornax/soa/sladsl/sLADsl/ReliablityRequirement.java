/**
 * <copyright>
 * </copyright>
 *

 */
package org.fornax.soa.sladsl.sLADsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reliablity Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.ReliablityRequirement#getReliability <em>Reliability</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.ReliablityRequirement#isInOrderDelivery <em>In Order Delivery</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getReliablityRequirement()
 * @model
 * @generated
 */
public interface ReliablityRequirement extends ServiceQualityProperty
{
  /**
   * Returns the value of the '<em><b>Reliability</b></em>' attribute.
   * The literals are from the enumeration {@link org.fornax.soa.sladsl.sLADsl.ReliablilityKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reliability</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reliability</em>' attribute.
   * @see org.fornax.soa.sladsl.sLADsl.ReliablilityKind
   * @see #setReliability(ReliablilityKind)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getReliablityRequirement_Reliability()
   * @model
   * @generated
   */
  ReliablilityKind getReliability();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.ReliablityRequirement#getReliability <em>Reliability</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reliability</em>' attribute.
   * @see org.fornax.soa.sladsl.sLADsl.ReliablilityKind
   * @see #getReliability()
   * @generated
   */
  void setReliability(ReliablilityKind value);

  /**
   * Returns the value of the '<em><b>In Order Delivery</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>In Order Delivery</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>In Order Delivery</em>' attribute.
   * @see #setInOrderDelivery(boolean)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getReliablityRequirement_InOrderDelivery()
   * @model
   * @generated
   */
  boolean isInOrderDelivery();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.ReliablityRequirement#isInOrderDelivery <em>In Order Delivery</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>In Order Delivery</em>' attribute.
   * @see #isInOrderDelivery()
   * @generated
   */
  void setInOrderDelivery(boolean value);

} // ReliablityRequirement
