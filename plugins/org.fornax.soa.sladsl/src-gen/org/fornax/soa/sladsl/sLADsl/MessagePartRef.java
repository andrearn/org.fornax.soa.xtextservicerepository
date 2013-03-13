/**
 * <copyright>
 * </copyright>
 *

 */
package org.fornax.soa.sladsl.sLADsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Part Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.MessagePartRef#getMessagePartRef <em>Message Part Ref</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.MessagePartRef#getPartRefExpression <em>Part Ref Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getMessagePartRef()
 * @model
 * @generated
 */
public interface MessagePartRef extends EObject
{
  /**
   * Returns the value of the '<em><b>Message Part Ref</b></em>' attribute.
   * The literals are from the enumeration {@link org.fornax.soa.sladsl.sLADsl.MessagePartRefKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Message Part Ref</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Message Part Ref</em>' attribute.
   * @see org.fornax.soa.sladsl.sLADsl.MessagePartRefKind
   * @see #setMessagePartRef(MessagePartRefKind)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getMessagePartRef_MessagePartRef()
   * @model
   * @generated
   */
  MessagePartRefKind getMessagePartRef();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.MessagePartRef#getMessagePartRef <em>Message Part Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message Part Ref</em>' attribute.
   * @see org.fornax.soa.sladsl.sLADsl.MessagePartRefKind
   * @see #getMessagePartRef()
   * @generated
   */
  void setMessagePartRef(MessagePartRefKind value);

  /**
   * Returns the value of the '<em><b>Part Ref Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Part Ref Expression</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Part Ref Expression</em>' attribute.
   * @see #setPartRefExpression(String)
   * @see org.fornax.soa.sladsl.sLADsl.SLADslPackage#getMessagePartRef_PartRefExpression()
   * @model
   * @generated
   */
  String getPartRefExpression();

  /**
   * Sets the value of the '{@link org.fornax.soa.sladsl.sLADsl.MessagePartRef#getPartRefExpression <em>Part Ref Expression</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Part Ref Expression</em>' attribute.
   * @see #getPartRefExpression()
   * @generated
   */
  void setPartRefExpression(String value);

} // MessagePartRef
