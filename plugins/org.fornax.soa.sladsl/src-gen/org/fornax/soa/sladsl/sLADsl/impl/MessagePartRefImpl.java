/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.fornax.soa.sladsl.sLADsl.MessagePartRef;
import org.fornax.soa.sladsl.sLADsl.MessagePartRefKind;
import org.fornax.soa.sladsl.sLADsl.SLADslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Part Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.MessagePartRefImpl#getMessagePartRef <em>Message Part Ref</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.MessagePartRefImpl#getPartRefExpression <em>Part Ref Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MessagePartRefImpl extends MinimalEObjectImpl.Container implements MessagePartRef
{
  /**
   * The default value of the '{@link #getMessagePartRef() <em>Message Part Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessagePartRef()
   * @generated
   * @ordered
   */
  protected static final MessagePartRefKind MESSAGE_PART_REF_EDEFAULT = MessagePartRefKind.HEADER;

  /**
   * The cached value of the '{@link #getMessagePartRef() <em>Message Part Ref</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessagePartRef()
   * @generated
   * @ordered
   */
  protected MessagePartRefKind messagePartRef = MESSAGE_PART_REF_EDEFAULT;

  /**
   * The default value of the '{@link #getPartRefExpression() <em>Part Ref Expression</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPartRefExpression()
   * @generated
   * @ordered
   */
  protected static final String PART_REF_EXPRESSION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPartRefExpression() <em>Part Ref Expression</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPartRefExpression()
   * @generated
   * @ordered
   */
  protected String partRefExpression = PART_REF_EXPRESSION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MessagePartRefImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return SLADslPackage.Literals.MESSAGE_PART_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MessagePartRefKind getMessagePartRef()
  {
    return messagePartRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMessagePartRef(MessagePartRefKind newMessagePartRef)
  {
    MessagePartRefKind oldMessagePartRef = messagePartRef;
    messagePartRef = newMessagePartRef == null ? MESSAGE_PART_REF_EDEFAULT : newMessagePartRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.MESSAGE_PART_REF__MESSAGE_PART_REF, oldMessagePartRef, messagePartRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPartRefExpression()
  {
    return partRefExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPartRefExpression(String newPartRefExpression)
  {
    String oldPartRefExpression = partRefExpression;
    partRefExpression = newPartRefExpression;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.MESSAGE_PART_REF__PART_REF_EXPRESSION, oldPartRefExpression, partRefExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case SLADslPackage.MESSAGE_PART_REF__MESSAGE_PART_REF:
        return getMessagePartRef();
      case SLADslPackage.MESSAGE_PART_REF__PART_REF_EXPRESSION:
        return getPartRefExpression();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SLADslPackage.MESSAGE_PART_REF__MESSAGE_PART_REF:
        setMessagePartRef((MessagePartRefKind)newValue);
        return;
      case SLADslPackage.MESSAGE_PART_REF__PART_REF_EXPRESSION:
        setPartRefExpression((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case SLADslPackage.MESSAGE_PART_REF__MESSAGE_PART_REF:
        setMessagePartRef(MESSAGE_PART_REF_EDEFAULT);
        return;
      case SLADslPackage.MESSAGE_PART_REF__PART_REF_EXPRESSION:
        setPartRefExpression(PART_REF_EXPRESSION_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case SLADslPackage.MESSAGE_PART_REF__MESSAGE_PART_REF:
        return messagePartRef != MESSAGE_PART_REF_EDEFAULT;
      case SLADslPackage.MESSAGE_PART_REF__PART_REF_EXPRESSION:
        return PART_REF_EXPRESSION_EDEFAULT == null ? partRefExpression != null : !PART_REF_EXPRESSION_EDEFAULT.equals(partRefExpression);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (messagePartRef: ");
    result.append(messagePartRef);
    result.append(", partRefExpression: ");
    result.append(partRefExpression);
    result.append(')');
    return result.toString();
  }

} //MessagePartRefImpl
