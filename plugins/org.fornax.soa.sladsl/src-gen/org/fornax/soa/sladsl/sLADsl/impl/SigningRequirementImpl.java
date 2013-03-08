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

import org.fornax.soa.sladsl.sLADsl.MessagePartRef;
import org.fornax.soa.sladsl.sLADsl.SLADslPackage;
import org.fornax.soa.sladsl.sLADsl.SigningAlgothm;
import org.fornax.soa.sladsl.sLADsl.SigningRequirement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Signing Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SigningRequirementImpl#getSupportedSigningAlgorithms <em>Supported Signing Algorithms</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SigningRequirementImpl#getRequiredSigningAlgorithm <em>Required Signing Algorithm</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SigningRequirementImpl#getSignedParts <em>Signed Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SigningRequirementImpl extends SecurityRequirementImpl implements SigningRequirement
{
  /**
   * The cached value of the '{@link #getSupportedSigningAlgorithms() <em>Supported Signing Algorithms</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSupportedSigningAlgorithms()
   * @generated
   * @ordered
   */
  protected EList<SigningAlgothm> supportedSigningAlgorithms;

  /**
   * The default value of the '{@link #getRequiredSigningAlgorithm() <em>Required Signing Algorithm</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequiredSigningAlgorithm()
   * @generated
   * @ordered
   */
  protected static final SigningAlgothm REQUIRED_SIGNING_ALGORITHM_EDEFAULT = SigningAlgothm.NONE;

  /**
   * The cached value of the '{@link #getRequiredSigningAlgorithm() <em>Required Signing Algorithm</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequiredSigningAlgorithm()
   * @generated
   * @ordered
   */
  protected SigningAlgothm requiredSigningAlgorithm = REQUIRED_SIGNING_ALGORITHM_EDEFAULT;

  /**
   * The cached value of the '{@link #getSignedParts() <em>Signed Parts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSignedParts()
   * @generated
   * @ordered
   */
  protected EList<MessagePartRef> signedParts;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SigningRequirementImpl()
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
    return SLADslPackage.Literals.SIGNING_REQUIREMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SigningAlgothm> getSupportedSigningAlgorithms()
  {
    if (supportedSigningAlgorithms == null)
    {
      supportedSigningAlgorithms = new EDataTypeEList<SigningAlgothm>(SigningAlgothm.class, this, SLADslPackage.SIGNING_REQUIREMENT__SUPPORTED_SIGNING_ALGORITHMS);
    }
    return supportedSigningAlgorithms;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SigningAlgothm getRequiredSigningAlgorithm()
  {
    return requiredSigningAlgorithm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRequiredSigningAlgorithm(SigningAlgothm newRequiredSigningAlgorithm)
  {
    SigningAlgothm oldRequiredSigningAlgorithm = requiredSigningAlgorithm;
    requiredSigningAlgorithm = newRequiredSigningAlgorithm == null ? REQUIRED_SIGNING_ALGORITHM_EDEFAULT : newRequiredSigningAlgorithm;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.SIGNING_REQUIREMENT__REQUIRED_SIGNING_ALGORITHM, oldRequiredSigningAlgorithm, requiredSigningAlgorithm));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<MessagePartRef> getSignedParts()
  {
    if (signedParts == null)
    {
      signedParts = new EObjectContainmentEList<MessagePartRef>(MessagePartRef.class, this, SLADslPackage.SIGNING_REQUIREMENT__SIGNED_PARTS);
    }
    return signedParts;
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
      case SLADslPackage.SIGNING_REQUIREMENT__SIGNED_PARTS:
        return ((InternalEList<?>)getSignedParts()).basicRemove(otherEnd, msgs);
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
      case SLADslPackage.SIGNING_REQUIREMENT__SUPPORTED_SIGNING_ALGORITHMS:
        return getSupportedSigningAlgorithms();
      case SLADslPackage.SIGNING_REQUIREMENT__REQUIRED_SIGNING_ALGORITHM:
        return getRequiredSigningAlgorithm();
      case SLADslPackage.SIGNING_REQUIREMENT__SIGNED_PARTS:
        return getSignedParts();
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
      case SLADslPackage.SIGNING_REQUIREMENT__SUPPORTED_SIGNING_ALGORITHMS:
        getSupportedSigningAlgorithms().clear();
        getSupportedSigningAlgorithms().addAll((Collection<? extends SigningAlgothm>)newValue);
        return;
      case SLADslPackage.SIGNING_REQUIREMENT__REQUIRED_SIGNING_ALGORITHM:
        setRequiredSigningAlgorithm((SigningAlgothm)newValue);
        return;
      case SLADslPackage.SIGNING_REQUIREMENT__SIGNED_PARTS:
        getSignedParts().clear();
        getSignedParts().addAll((Collection<? extends MessagePartRef>)newValue);
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
      case SLADslPackage.SIGNING_REQUIREMENT__SUPPORTED_SIGNING_ALGORITHMS:
        getSupportedSigningAlgorithms().clear();
        return;
      case SLADslPackage.SIGNING_REQUIREMENT__REQUIRED_SIGNING_ALGORITHM:
        setRequiredSigningAlgorithm(REQUIRED_SIGNING_ALGORITHM_EDEFAULT);
        return;
      case SLADslPackage.SIGNING_REQUIREMENT__SIGNED_PARTS:
        getSignedParts().clear();
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
      case SLADslPackage.SIGNING_REQUIREMENT__SUPPORTED_SIGNING_ALGORITHMS:
        return supportedSigningAlgorithms != null && !supportedSigningAlgorithms.isEmpty();
      case SLADslPackage.SIGNING_REQUIREMENT__REQUIRED_SIGNING_ALGORITHM:
        return requiredSigningAlgorithm != REQUIRED_SIGNING_ALGORITHM_EDEFAULT;
      case SLADslPackage.SIGNING_REQUIREMENT__SIGNED_PARTS:
        return signedParts != null && !signedParts.isEmpty();
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
    result.append(" (supportedSigningAlgorithms: ");
    result.append(supportedSigningAlgorithms);
    result.append(", requiredSigningAlgorithm: ");
    result.append(requiredSigningAlgorithm);
    result.append(')');
    return result.toString();
  }

} //SigningRequirementImpl
