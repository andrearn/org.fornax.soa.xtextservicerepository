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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.fornax.soa.sladsl.sLADsl.AuthToken;
import org.fornax.soa.sladsl.sLADsl.AuthenticationRequirement;
import org.fornax.soa.sladsl.sLADsl.HashAlgorithm;
import org.fornax.soa.sladsl.sLADsl.SLADslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Authentication Requirement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.AuthenticationRequirementImpl#isOptional <em>Optional</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.AuthenticationRequirementImpl#getAuthTokens <em>Auth Tokens</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.AuthenticationRequirementImpl#getHashAlgorithms <em>Hash Algorithms</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.AuthenticationRequirementImpl#isUseNonce <em>Use Nonce</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.AuthenticationRequirementImpl#getIssuer <em>Issuer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AuthenticationRequirementImpl extends SecurityRequirementImpl implements AuthenticationRequirement
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
   * The cached value of the '{@link #getAuthTokens() <em>Auth Tokens</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAuthTokens()
   * @generated
   * @ordered
   */
  protected EList<AuthToken> authTokens;

  /**
   * The cached value of the '{@link #getHashAlgorithms() <em>Hash Algorithms</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHashAlgorithms()
   * @generated
   * @ordered
   */
  protected EList<HashAlgorithm> hashAlgorithms;

  /**
   * The default value of the '{@link #isUseNonce() <em>Use Nonce</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUseNonce()
   * @generated
   * @ordered
   */
  protected static final boolean USE_NONCE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isUseNonce() <em>Use Nonce</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUseNonce()
   * @generated
   * @ordered
   */
  protected boolean useNonce = USE_NONCE_EDEFAULT;

  /**
   * The default value of the '{@link #getIssuer() <em>Issuer</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIssuer()
   * @generated
   * @ordered
   */
  protected static final String ISSUER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getIssuer() <em>Issuer</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIssuer()
   * @generated
   * @ordered
   */
  protected String issuer = ISSUER_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AuthenticationRequirementImpl()
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
    return SLADslPackage.Literals.AUTHENTICATION_REQUIREMENT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.AUTHENTICATION_REQUIREMENT__OPTIONAL, oldOptional, optional));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AuthToken> getAuthTokens()
  {
    if (authTokens == null)
    {
      authTokens = new EObjectContainmentEList<AuthToken>(AuthToken.class, this, SLADslPackage.AUTHENTICATION_REQUIREMENT__AUTH_TOKENS);
    }
    return authTokens;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<HashAlgorithm> getHashAlgorithms()
  {
    if (hashAlgorithms == null)
    {
      hashAlgorithms = new EObjectContainmentEList<HashAlgorithm>(HashAlgorithm.class, this, SLADslPackage.AUTHENTICATION_REQUIREMENT__HASH_ALGORITHMS);
    }
    return hashAlgorithms;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isUseNonce()
  {
    return useNonce;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUseNonce(boolean newUseNonce)
  {
    boolean oldUseNonce = useNonce;
    useNonce = newUseNonce;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.AUTHENTICATION_REQUIREMENT__USE_NONCE, oldUseNonce, useNonce));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getIssuer()
  {
    return issuer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIssuer(String newIssuer)
  {
    String oldIssuer = issuer;
    issuer = newIssuer;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.AUTHENTICATION_REQUIREMENT__ISSUER, oldIssuer, issuer));
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
      case SLADslPackage.AUTHENTICATION_REQUIREMENT__AUTH_TOKENS:
        return ((InternalEList<?>)getAuthTokens()).basicRemove(otherEnd, msgs);
      case SLADslPackage.AUTHENTICATION_REQUIREMENT__HASH_ALGORITHMS:
        return ((InternalEList<?>)getHashAlgorithms()).basicRemove(otherEnd, msgs);
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
      case SLADslPackage.AUTHENTICATION_REQUIREMENT__OPTIONAL:
        return isOptional();
      case SLADslPackage.AUTHENTICATION_REQUIREMENT__AUTH_TOKENS:
        return getAuthTokens();
      case SLADslPackage.AUTHENTICATION_REQUIREMENT__HASH_ALGORITHMS:
        return getHashAlgorithms();
      case SLADslPackage.AUTHENTICATION_REQUIREMENT__USE_NONCE:
        return isUseNonce();
      case SLADslPackage.AUTHENTICATION_REQUIREMENT__ISSUER:
        return getIssuer();
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
      case SLADslPackage.AUTHENTICATION_REQUIREMENT__OPTIONAL:
        setOptional((Boolean)newValue);
        return;
      case SLADslPackage.AUTHENTICATION_REQUIREMENT__AUTH_TOKENS:
        getAuthTokens().clear();
        getAuthTokens().addAll((Collection<? extends AuthToken>)newValue);
        return;
      case SLADslPackage.AUTHENTICATION_REQUIREMENT__HASH_ALGORITHMS:
        getHashAlgorithms().clear();
        getHashAlgorithms().addAll((Collection<? extends HashAlgorithm>)newValue);
        return;
      case SLADslPackage.AUTHENTICATION_REQUIREMENT__USE_NONCE:
        setUseNonce((Boolean)newValue);
        return;
      case SLADslPackage.AUTHENTICATION_REQUIREMENT__ISSUER:
        setIssuer((String)newValue);
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
      case SLADslPackage.AUTHENTICATION_REQUIREMENT__OPTIONAL:
        setOptional(OPTIONAL_EDEFAULT);
        return;
      case SLADslPackage.AUTHENTICATION_REQUIREMENT__AUTH_TOKENS:
        getAuthTokens().clear();
        return;
      case SLADslPackage.AUTHENTICATION_REQUIREMENT__HASH_ALGORITHMS:
        getHashAlgorithms().clear();
        return;
      case SLADslPackage.AUTHENTICATION_REQUIREMENT__USE_NONCE:
        setUseNonce(USE_NONCE_EDEFAULT);
        return;
      case SLADslPackage.AUTHENTICATION_REQUIREMENT__ISSUER:
        setIssuer(ISSUER_EDEFAULT);
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
      case SLADslPackage.AUTHENTICATION_REQUIREMENT__OPTIONAL:
        return optional != OPTIONAL_EDEFAULT;
      case SLADslPackage.AUTHENTICATION_REQUIREMENT__AUTH_TOKENS:
        return authTokens != null && !authTokens.isEmpty();
      case SLADslPackage.AUTHENTICATION_REQUIREMENT__HASH_ALGORITHMS:
        return hashAlgorithms != null && !hashAlgorithms.isEmpty();
      case SLADslPackage.AUTHENTICATION_REQUIREMENT__USE_NONCE:
        return useNonce != USE_NONCE_EDEFAULT;
      case SLADslPackage.AUTHENTICATION_REQUIREMENT__ISSUER:
        return ISSUER_EDEFAULT == null ? issuer != null : !ISSUER_EDEFAULT.equals(issuer);
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
    result.append(", useNonce: ");
    result.append(useNonce);
    result.append(", issuer: ");
    result.append(issuer);
    result.append(')');
    return result.toString();
  }

} //AuthenticationRequirementImpl
