/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;

import org.fornax.soa.sladsl.sLADsl.AssetRef;
import org.fornax.soa.sladsl.sLADsl.SLADslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Asset Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.AssetRefImpl#getAsset <em>Asset</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.AssetRefImpl#getVersionRef <em>Version Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssetRefImpl extends MinimalEObjectImpl.Container implements AssetRef
{
  /**
   * The cached value of the '{@link #getAsset() <em>Asset</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAsset()
   * @generated
   * @ordered
   */
  protected EObject asset;

  /**
   * The cached value of the '{@link #getVersionRef() <em>Version Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVersionRef()
   * @generated
   * @ordered
   */
  protected VersionRef versionRef;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssetRefImpl()
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
    return SLADslPackage.Literals.ASSET_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getAsset()
  {
    if (asset != null && asset.eIsProxy())
    {
      InternalEObject oldAsset = (InternalEObject)asset;
      asset = eResolveProxy(oldAsset);
      if (asset != oldAsset)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SLADslPackage.ASSET_REF__ASSET, oldAsset, asset));
      }
    }
    return asset;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject basicGetAsset()
  {
    return asset;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAsset(EObject newAsset)
  {
    EObject oldAsset = asset;
    asset = newAsset;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.ASSET_REF__ASSET, oldAsset, asset));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VersionRef getVersionRef()
  {
    return versionRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVersionRef(VersionRef newVersionRef, NotificationChain msgs)
  {
    VersionRef oldVersionRef = versionRef;
    versionRef = newVersionRef;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SLADslPackage.ASSET_REF__VERSION_REF, oldVersionRef, newVersionRef);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVersionRef(VersionRef newVersionRef)
  {
    if (newVersionRef != versionRef)
    {
      NotificationChain msgs = null;
      if (versionRef != null)
        msgs = ((InternalEObject)versionRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SLADslPackage.ASSET_REF__VERSION_REF, null, msgs);
      if (newVersionRef != null)
        msgs = ((InternalEObject)newVersionRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SLADslPackage.ASSET_REF__VERSION_REF, null, msgs);
      msgs = basicSetVersionRef(newVersionRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.ASSET_REF__VERSION_REF, newVersionRef, newVersionRef));
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
      case SLADslPackage.ASSET_REF__VERSION_REF:
        return basicSetVersionRef(null, msgs);
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
      case SLADslPackage.ASSET_REF__ASSET:
        if (resolve) return getAsset();
        return basicGetAsset();
      case SLADslPackage.ASSET_REF__VERSION_REF:
        return getVersionRef();
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
      case SLADslPackage.ASSET_REF__ASSET:
        setAsset((EObject)newValue);
        return;
      case SLADslPackage.ASSET_REF__VERSION_REF:
        setVersionRef((VersionRef)newValue);
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
      case SLADslPackage.ASSET_REF__ASSET:
        setAsset((EObject)null);
        return;
      case SLADslPackage.ASSET_REF__VERSION_REF:
        setVersionRef((VersionRef)null);
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
      case SLADslPackage.ASSET_REF__ASSET:
        return asset != null;
      case SLADslPackage.ASSET_REF__VERSION_REF:
        return versionRef != null;
    }
    return super.eIsSet(featureID);
  }

} //AssetRefImpl
