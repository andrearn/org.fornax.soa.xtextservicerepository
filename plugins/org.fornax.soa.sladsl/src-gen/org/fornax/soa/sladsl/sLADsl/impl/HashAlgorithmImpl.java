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

import org.fornax.soa.sladsl.sLADsl.HashAlgKind;
import org.fornax.soa.sladsl.sLADsl.HashAlgorithm;
import org.fornax.soa.sladsl.sLADsl.SLADslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hash Algorithm</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.HashAlgorithmImpl#isOptional <em>Optional</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.HashAlgorithmImpl#isUseBase64 <em>Use Base64</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.HashAlgorithmImpl#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HashAlgorithmImpl extends MinimalEObjectImpl.Container implements HashAlgorithm
{
  /**
   * The default value of the '{@link #isOptional() <em>Optional</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOptional()
   * @generated
   * @ordered
   */
  protected static final boolean OPTIONAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isOptional() <em>Optional</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOptional()
   * @generated
   * @ordered
   */
  protected boolean optional = OPTIONAL_EDEFAULT;

  /**
   * The default value of the '{@link #isUseBase64() <em>Use Base64</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUseBase64()
   * @generated
   * @ordered
   */
  protected static final boolean USE_BASE64_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isUseBase64() <em>Use Base64</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUseBase64()
   * @generated
   * @ordered
   */
  protected boolean useBase64 = USE_BASE64_EDEFAULT;

  /**
   * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected static final HashAlgKind KIND_EDEFAULT = HashAlgKind.MD5;

  /**
   * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected HashAlgKind kind = KIND_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HashAlgorithmImpl()
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
    return SLADslPackage.Literals.HASH_ALGORITHM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isOptional()
  {
    return optional;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOptional(boolean newOptional)
  {
    boolean oldOptional = optional;
    optional = newOptional;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.HASH_ALGORITHM__OPTIONAL, oldOptional, optional));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isUseBase64()
  {
    return useBase64;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUseBase64(boolean newUseBase64)
  {
    boolean oldUseBase64 = useBase64;
    useBase64 = newUseBase64;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.HASH_ALGORITHM__USE_BASE64, oldUseBase64, useBase64));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public HashAlgKind getKind()
  {
    return kind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKind(HashAlgKind newKind)
  {
    HashAlgKind oldKind = kind;
    kind = newKind == null ? KIND_EDEFAULT : newKind;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.HASH_ALGORITHM__KIND, oldKind, kind));
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
      case SLADslPackage.HASH_ALGORITHM__OPTIONAL:
        return isOptional();
      case SLADslPackage.HASH_ALGORITHM__USE_BASE64:
        return isUseBase64();
      case SLADslPackage.HASH_ALGORITHM__KIND:
        return getKind();
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
      case SLADslPackage.HASH_ALGORITHM__OPTIONAL:
        setOptional((Boolean)newValue);
        return;
      case SLADslPackage.HASH_ALGORITHM__USE_BASE64:
        setUseBase64((Boolean)newValue);
        return;
      case SLADslPackage.HASH_ALGORITHM__KIND:
        setKind((HashAlgKind)newValue);
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
      case SLADslPackage.HASH_ALGORITHM__OPTIONAL:
        setOptional(OPTIONAL_EDEFAULT);
        return;
      case SLADslPackage.HASH_ALGORITHM__USE_BASE64:
        setUseBase64(USE_BASE64_EDEFAULT);
        return;
      case SLADslPackage.HASH_ALGORITHM__KIND:
        setKind(KIND_EDEFAULT);
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
      case SLADslPackage.HASH_ALGORITHM__OPTIONAL:
        return optional != OPTIONAL_EDEFAULT;
      case SLADslPackage.HASH_ALGORITHM__USE_BASE64:
        return useBase64 != USE_BASE64_EDEFAULT;
      case SLADslPackage.HASH_ALGORITHM__KIND:
        return kind != KIND_EDEFAULT;
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
    result.append(" (optional: ");
    result.append(optional);
    result.append(", useBase64: ");
    result.append(useBase64);
    result.append(", kind: ");
    result.append(kind);
    result.append(')');
    return result.toString();
  }

} //HashAlgorithmImpl
