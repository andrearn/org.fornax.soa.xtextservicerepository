/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl;

import org.fornax.soa.basedsl.sOABaseDsl.User;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.UserRef#getRepresentative <em>Representative</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getUserRef()
 * @model
 * @generated
 */
public interface UserRef extends Representative
{
  /**
   * Returns the value of the '<em><b>Representative</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Representative</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Representative</em>' reference.
   * @see #setRepresentative(User)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getUserRef_Representative()
   * @model
   * @generated
   */
  User getRepresentative();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.UserRef#getRepresentative <em>Representative</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Representative</em>' reference.
   * @see #getRepresentative()
   * @generated
   */
  void setRepresentative(User value);

} // UserRef
