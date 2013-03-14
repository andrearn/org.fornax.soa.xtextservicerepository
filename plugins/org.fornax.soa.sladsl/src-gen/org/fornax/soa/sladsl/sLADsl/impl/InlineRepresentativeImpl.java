/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.fornax.soa.sladsl.sLADsl.InlineRepresentative;
import org.fornax.soa.sladsl.sLADsl.SLADslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inline Representative</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.InlineRepresentativeImpl#getFirstname <em>Firstname</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.InlineRepresentativeImpl#getLastname <em>Lastname</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.InlineRepresentativeImpl#getOrg <em>Org</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.InlineRepresentativeImpl#getOrgUnit <em>Org Unit</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.InlineRepresentativeImpl#getEmail <em>Email</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.InlineRepresentativeImpl#getPhone <em>Phone</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InlineRepresentativeImpl extends RepresentativeImpl implements InlineRepresentative
{
  /**
   * The default value of the '{@link #getFirstname() <em>Firstname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirstname()
   * @generated
   * @ordered
   */
  protected static final String FIRSTNAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFirstname() <em>Firstname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirstname()
   * @generated
   * @ordered
   */
  protected String firstname = FIRSTNAME_EDEFAULT;

  /**
   * The default value of the '{@link #getLastname() <em>Lastname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLastname()
   * @generated
   * @ordered
   */
  protected static final String LASTNAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLastname() <em>Lastname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLastname()
   * @generated
   * @ordered
   */
  protected String lastname = LASTNAME_EDEFAULT;

  /**
   * The default value of the '{@link #getOrg() <em>Org</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOrg()
   * @generated
   * @ordered
   */
  protected static final String ORG_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOrg() <em>Org</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOrg()
   * @generated
   * @ordered
   */
  protected String org = ORG_EDEFAULT;

  /**
   * The default value of the '{@link #getOrgUnit() <em>Org Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOrgUnit()
   * @generated
   * @ordered
   */
  protected static final String ORG_UNIT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOrgUnit() <em>Org Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOrgUnit()
   * @generated
   * @ordered
   */
  protected String orgUnit = ORG_UNIT_EDEFAULT;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InlineRepresentativeImpl()
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
    return SLADslPackage.Literals.INLINE_REPRESENTATIVE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFirstname()
  {
    return firstname;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFirstname(String newFirstname)
  {
    String oldFirstname = firstname;
    firstname = newFirstname;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.INLINE_REPRESENTATIVE__FIRSTNAME, oldFirstname, firstname));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLastname()
  {
    return lastname;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLastname(String newLastname)
  {
    String oldLastname = lastname;
    lastname = newLastname;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.INLINE_REPRESENTATIVE__LASTNAME, oldLastname, lastname));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOrg()
  {
    return org;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOrg(String newOrg)
  {
    String oldOrg = org;
    org = newOrg;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.INLINE_REPRESENTATIVE__ORG, oldOrg, org));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOrgUnit()
  {
    return orgUnit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOrgUnit(String newOrgUnit)
  {
    String oldOrgUnit = orgUnit;
    orgUnit = newOrgUnit;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.INLINE_REPRESENTATIVE__ORG_UNIT, oldOrgUnit, orgUnit));
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
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.INLINE_REPRESENTATIVE__EMAIL, oldEmail, email));
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
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.INLINE_REPRESENTATIVE__PHONE, oldPhone, phone));
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
      case SLADslPackage.INLINE_REPRESENTATIVE__FIRSTNAME:
        return getFirstname();
      case SLADslPackage.INLINE_REPRESENTATIVE__LASTNAME:
        return getLastname();
      case SLADslPackage.INLINE_REPRESENTATIVE__ORG:
        return getOrg();
      case SLADslPackage.INLINE_REPRESENTATIVE__ORG_UNIT:
        return getOrgUnit();
      case SLADslPackage.INLINE_REPRESENTATIVE__EMAIL:
        return getEmail();
      case SLADslPackage.INLINE_REPRESENTATIVE__PHONE:
        return getPhone();
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
      case SLADslPackage.INLINE_REPRESENTATIVE__FIRSTNAME:
        setFirstname((String)newValue);
        return;
      case SLADslPackage.INLINE_REPRESENTATIVE__LASTNAME:
        setLastname((String)newValue);
        return;
      case SLADslPackage.INLINE_REPRESENTATIVE__ORG:
        setOrg((String)newValue);
        return;
      case SLADslPackage.INLINE_REPRESENTATIVE__ORG_UNIT:
        setOrgUnit((String)newValue);
        return;
      case SLADslPackage.INLINE_REPRESENTATIVE__EMAIL:
        setEmail((String)newValue);
        return;
      case SLADslPackage.INLINE_REPRESENTATIVE__PHONE:
        setPhone((String)newValue);
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
      case SLADslPackage.INLINE_REPRESENTATIVE__FIRSTNAME:
        setFirstname(FIRSTNAME_EDEFAULT);
        return;
      case SLADslPackage.INLINE_REPRESENTATIVE__LASTNAME:
        setLastname(LASTNAME_EDEFAULT);
        return;
      case SLADslPackage.INLINE_REPRESENTATIVE__ORG:
        setOrg(ORG_EDEFAULT);
        return;
      case SLADslPackage.INLINE_REPRESENTATIVE__ORG_UNIT:
        setOrgUnit(ORG_UNIT_EDEFAULT);
        return;
      case SLADslPackage.INLINE_REPRESENTATIVE__EMAIL:
        setEmail(EMAIL_EDEFAULT);
        return;
      case SLADslPackage.INLINE_REPRESENTATIVE__PHONE:
        setPhone(PHONE_EDEFAULT);
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
      case SLADslPackage.INLINE_REPRESENTATIVE__FIRSTNAME:
        return FIRSTNAME_EDEFAULT == null ? firstname != null : !FIRSTNAME_EDEFAULT.equals(firstname);
      case SLADslPackage.INLINE_REPRESENTATIVE__LASTNAME:
        return LASTNAME_EDEFAULT == null ? lastname != null : !LASTNAME_EDEFAULT.equals(lastname);
      case SLADslPackage.INLINE_REPRESENTATIVE__ORG:
        return ORG_EDEFAULT == null ? org != null : !ORG_EDEFAULT.equals(org);
      case SLADslPackage.INLINE_REPRESENTATIVE__ORG_UNIT:
        return ORG_UNIT_EDEFAULT == null ? orgUnit != null : !ORG_UNIT_EDEFAULT.equals(orgUnit);
      case SLADslPackage.INLINE_REPRESENTATIVE__EMAIL:
        return EMAIL_EDEFAULT == null ? email != null : !EMAIL_EDEFAULT.equals(email);
      case SLADslPackage.INLINE_REPRESENTATIVE__PHONE:
        return PHONE_EDEFAULT == null ? phone != null : !PHONE_EDEFAULT.equals(phone);
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
    result.append(" (firstname: ");
    result.append(firstname);
    result.append(", lastname: ");
    result.append(lastname);
    result.append(", org: ");
    result.append(org);
    result.append(", orgUnit: ");
    result.append(orgUnit);
    result.append(", email: ");
    result.append(email);
    result.append(", phone: ");
    result.append(phone);
    result.append(')');
    return result.toString();
  }

} //InlineRepresentativeImpl
