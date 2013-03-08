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

import org.fornax.soa.sladsl.sLADsl.Repesentative;
import org.fornax.soa.sladsl.sLADsl.SLADslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repesentative</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.RepesentativeImpl#getFullname <em>Fullname</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.RepesentativeImpl#getPhone <em>Phone</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.RepesentativeImpl#getEmail <em>Email</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RepesentativeImpl extends MinimalEObjectImpl.Container implements Repesentative
{
  /**
   * The default value of the '{@link #getFullname() <em>Fullname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFullname()
   * @generated
   * @ordered
   */
  protected static final String FULLNAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFullname() <em>Fullname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFullname()
   * @generated
   * @ordered
   */
  protected String fullname = FULLNAME_EDEFAULT;

  /**
   * The default value of the '{@link #getPhone() <em>Phone</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPhone()
   * @generated
   * @ordered
   */
  protected static final String PHONE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPhone() <em>Phone</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPhone()
   * @generated
   * @ordered
   */
  protected String phone = PHONE_EDEFAULT;

  /**
   * The default value of the '{@link #getEmail() <em>Email</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEmail()
   * @generated
   * @ordered
   */
  protected static final String EMAIL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEmail() <em>Email</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEmail()
   * @generated
   * @ordered
   */
  protected String email = EMAIL_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RepesentativeImpl()
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
    return SLADslPackage.Literals.REPESENTATIVE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFullname()
  {
    return fullname;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFullname(String newFullname)
  {
    String oldFullname = fullname;
    fullname = newFullname;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.REPESENTATIVE__FULLNAME, oldFullname, fullname));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPhone()
  {
    return phone;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPhone(String newPhone)
  {
    String oldPhone = phone;
    phone = newPhone;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.REPESENTATIVE__PHONE, oldPhone, phone));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEmail()
  {
    return email;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEmail(String newEmail)
  {
    String oldEmail = email;
    email = newEmail;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.REPESENTATIVE__EMAIL, oldEmail, email));
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
      case SLADslPackage.REPESENTATIVE__FULLNAME:
        return getFullname();
      case SLADslPackage.REPESENTATIVE__PHONE:
        return getPhone();
      case SLADslPackage.REPESENTATIVE__EMAIL:
        return getEmail();
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
      case SLADslPackage.REPESENTATIVE__FULLNAME:
        setFullname((String)newValue);
        return;
      case SLADslPackage.REPESENTATIVE__PHONE:
        setPhone((String)newValue);
        return;
      case SLADslPackage.REPESENTATIVE__EMAIL:
        setEmail((String)newValue);
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
      case SLADslPackage.REPESENTATIVE__FULLNAME:
        setFullname(FULLNAME_EDEFAULT);
        return;
      case SLADslPackage.REPESENTATIVE__PHONE:
        setPhone(PHONE_EDEFAULT);
        return;
      case SLADslPackage.REPESENTATIVE__EMAIL:
        setEmail(EMAIL_EDEFAULT);
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
      case SLADslPackage.REPESENTATIVE__FULLNAME:
        return FULLNAME_EDEFAULT == null ? fullname != null : !FULLNAME_EDEFAULT.equals(fullname);
      case SLADslPackage.REPESENTATIVE__PHONE:
        return PHONE_EDEFAULT == null ? phone != null : !PHONE_EDEFAULT.equals(phone);
      case SLADslPackage.REPESENTATIVE__EMAIL:
        return EMAIL_EDEFAULT == null ? email != null : !EMAIL_EDEFAULT.equals(email);
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
    result.append(" (fullname: ");
    result.append(fullname);
    result.append(", phone: ");
    result.append(phone);
    result.append(", email: ");
    result.append(email);
    result.append(')');
    return result.toString();
  }

} //RepesentativeImpl
