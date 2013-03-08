/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.fornax.soa.sladsl.sLADsl.CipherAlgorithmKind;
import org.fornax.soa.sladsl.sLADsl.EncryptionRequirement;
import org.fornax.soa.sladsl.sLADsl.MessagePartRef;
import org.fornax.soa.sladsl.sLADsl.SLADslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Encryption Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.EncryptionRequirementImpl#getSupportedCipherAlgorithms <em>Supported Cipher Algorithms</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.EncryptionRequirementImpl#getRequiredCipherAlgorithm <em>Required Cipher Algorithm</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.EncryptionRequirementImpl#getEncryptedParts <em>Encrypted Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EncryptionRequirementImpl extends SecurityRequirementImpl implements EncryptionRequirement
{
  /**
   * The cached value of the '{@link #getSupportedCipherAlgorithms() <em>Supported Cipher Algorithms</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSupportedCipherAlgorithms()
   * @generated
   * @ordered
   */
  protected EList<CipherAlgorithmKind> supportedCipherAlgorithms;

  /**
   * The default value of the '{@link #getRequiredCipherAlgorithm() <em>Required Cipher Algorithm</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequiredCipherAlgorithm()
   * @generated
   * @ordered
   */
  protected static final CipherAlgorithmKind REQUIRED_CIPHER_ALGORITHM_EDEFAULT = CipherAlgorithmKind.NONE;

  /**
   * The cached value of the '{@link #getRequiredCipherAlgorithm() <em>Required Cipher Algorithm</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequiredCipherAlgorithm()
   * @generated
   * @ordered
   */
  protected CipherAlgorithmKind requiredCipherAlgorithm = REQUIRED_CIPHER_ALGORITHM_EDEFAULT;

  /**
   * The cached value of the '{@link #getEncryptedParts() <em>Encrypted Parts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEncryptedParts()
   * @generated
   * @ordered
   */
  protected EList<MessagePartRef> encryptedParts;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EncryptionRequirementImpl()
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
    return SLADslPackage.Literals.ENCRYPTION_REQUIREMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CipherAlgorithmKind> getSupportedCipherAlgorithms()
  {
    if (supportedCipherAlgorithms == null)
    {
      supportedCipherAlgorithms = new EDataTypeEList<CipherAlgorithmKind>(CipherAlgorithmKind.class, this, SLADslPackage.ENCRYPTION_REQUIREMENT__SUPPORTED_CIPHER_ALGORITHMS);
    }
    return supportedCipherAlgorithms;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CipherAlgorithmKind getRequiredCipherAlgorithm()
  {
    return requiredCipherAlgorithm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRequiredCipherAlgorithm(CipherAlgorithmKind newRequiredCipherAlgorithm)
  {
    CipherAlgorithmKind oldRequiredCipherAlgorithm = requiredCipherAlgorithm;
    requiredCipherAlgorithm = newRequiredCipherAlgorithm == null ? REQUIRED_CIPHER_ALGORITHM_EDEFAULT : newRequiredCipherAlgorithm;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.ENCRYPTION_REQUIREMENT__REQUIRED_CIPHER_ALGORITHM, oldRequiredCipherAlgorithm, requiredCipherAlgorithm));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MessagePartRef> getEncryptedParts()
  {
    if (encryptedParts == null)
    {
      encryptedParts = new EObjectContainmentEList<MessagePartRef>(MessagePartRef.class, this, SLADslPackage.ENCRYPTION_REQUIREMENT__ENCRYPTED_PARTS);
    }
    return encryptedParts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case SLADslPackage.ENCRYPTION_REQUIREMENT__ENCRYPTED_PARTS:
        return ((InternalEList<?>)getEncryptedParts()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case SLADslPackage.ENCRYPTION_REQUIREMENT__SUPPORTED_CIPHER_ALGORITHMS:
        return getSupportedCipherAlgorithms();
      case SLADslPackage.ENCRYPTION_REQUIREMENT__REQUIRED_CIPHER_ALGORITHM:
        return getRequiredCipherAlgorithm();
      case SLADslPackage.ENCRYPTION_REQUIREMENT__ENCRYPTED_PARTS:
        return getEncryptedParts();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case SLADslPackage.ENCRYPTION_REQUIREMENT__SUPPORTED_CIPHER_ALGORITHMS:
        getSupportedCipherAlgorithms().clear();
        getSupportedCipherAlgorithms().addAll((Collection<? extends CipherAlgorithmKind>)newValue);
        return;
      case SLADslPackage.ENCRYPTION_REQUIREMENT__REQUIRED_CIPHER_ALGORITHM:
        setRequiredCipherAlgorithm((CipherAlgorithmKind)newValue);
        return;
      case SLADslPackage.ENCRYPTION_REQUIREMENT__ENCRYPTED_PARTS:
        getEncryptedParts().clear();
        getEncryptedParts().addAll((Collection<? extends MessagePartRef>)newValue);
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
      case SLADslPackage.ENCRYPTION_REQUIREMENT__SUPPORTED_CIPHER_ALGORITHMS:
        getSupportedCipherAlgorithms().clear();
        return;
      case SLADslPackage.ENCRYPTION_REQUIREMENT__REQUIRED_CIPHER_ALGORITHM:
        setRequiredCipherAlgorithm(REQUIRED_CIPHER_ALGORITHM_EDEFAULT);
        return;
      case SLADslPackage.ENCRYPTION_REQUIREMENT__ENCRYPTED_PARTS:
        getEncryptedParts().clear();
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
      case SLADslPackage.ENCRYPTION_REQUIREMENT__SUPPORTED_CIPHER_ALGORITHMS:
        return supportedCipherAlgorithms != null && !supportedCipherAlgorithms.isEmpty();
      case SLADslPackage.ENCRYPTION_REQUIREMENT__REQUIRED_CIPHER_ALGORITHM:
        return requiredCipherAlgorithm != REQUIRED_CIPHER_ALGORITHM_EDEFAULT;
      case SLADslPackage.ENCRYPTION_REQUIREMENT__ENCRYPTED_PARTS:
        return encryptedParts != null && !encryptedParts.isEmpty();
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
    result.append(" (supportedCipherAlgorithms: ");
    result.append(supportedCipherAlgorithms);
    result.append(", requiredCipherAlgorithm: ");
    result.append(requiredCipherAlgorithm);
    result.append(')');
    return result.toString();
  }

} //EncryptionRequirementImpl
