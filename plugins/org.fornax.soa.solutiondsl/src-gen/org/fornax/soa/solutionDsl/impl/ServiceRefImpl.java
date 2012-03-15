/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.solutionDsl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.fornax.soa.basedsl.sOABaseDsl.VersionRef;

import org.fornax.soa.serviceDsl.Service;

import org.fornax.soa.solutionDsl.ServiceRef;
import org.fornax.soa.solutionDsl.SolutionDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.ServiceRefImpl#getService <em>Service</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.ServiceRefImpl#getVersionRef <em>Version Ref</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.ServiceRefImpl#isIsResponseHandler <em>Is Response Handler</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceRefImpl extends MinimalEObjectImpl.Container implements ServiceRef
{
  /**
   * The cached value of the '{@link #getService() <em>Service</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getService()
   * @generated
   * @ordered
   */
  protected Service service;

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
   * The default value of the '{@link #isIsResponseHandler() <em>Is Response Handler</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsResponseHandler()
   * @generated
   * @ordered
   */
  protected static final boolean IS_RESPONSE_HANDLER_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isIsResponseHandler() <em>Is Response Handler</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isIsResponseHandler()
   * @generated
   * @ordered
   */
  protected boolean isResponseHandler = IS_RESPONSE_HANDLER_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ServiceRefImpl()
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
    return SolutionDslPackage.Literals.SERVICE_REF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Service getService()
  {
    if (service != null && service.eIsProxy())
    {
      InternalEObject oldService = (InternalEObject)service;
      service = (Service)eResolveProxy(oldService);
      if (service != oldService)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SolutionDslPackage.SERVICE_REF__SERVICE, oldService, service));
      }
    }
    return service;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Service basicGetService()
  {
    return service;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setService(Service newService)
  {
    Service oldService = service;
    service = newService;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SolutionDslPackage.SERVICE_REF__SERVICE, oldService, service));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SolutionDslPackage.SERVICE_REF__VERSION_REF, oldVersionRef, newVersionRef);
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
        msgs = ((InternalEObject)versionRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SolutionDslPackage.SERVICE_REF__VERSION_REF, null, msgs);
      if (newVersionRef != null)
        msgs = ((InternalEObject)newVersionRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SolutionDslPackage.SERVICE_REF__VERSION_REF, null, msgs);
      msgs = basicSetVersionRef(newVersionRef, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SolutionDslPackage.SERVICE_REF__VERSION_REF, newVersionRef, newVersionRef));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isIsResponseHandler()
  {
    return isResponseHandler;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIsResponseHandler(boolean newIsResponseHandler)
  {
    boolean oldIsResponseHandler = isResponseHandler;
    isResponseHandler = newIsResponseHandler;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SolutionDslPackage.SERVICE_REF__IS_RESPONSE_HANDLER, oldIsResponseHandler, isResponseHandler));
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
      case SolutionDslPackage.SERVICE_REF__VERSION_REF:
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
      case SolutionDslPackage.SERVICE_REF__SERVICE:
        if (resolve) return getService();
        return basicGetService();
      case SolutionDslPackage.SERVICE_REF__VERSION_REF:
        return getVersionRef();
      case SolutionDslPackage.SERVICE_REF__IS_RESPONSE_HANDLER:
        return isIsResponseHandler();
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
      case SolutionDslPackage.SERVICE_REF__SERVICE:
        setService((Service)newValue);
        return;
      case SolutionDslPackage.SERVICE_REF__VERSION_REF:
        setVersionRef((VersionRef)newValue);
        return;
      case SolutionDslPackage.SERVICE_REF__IS_RESPONSE_HANDLER:
        setIsResponseHandler((Boolean)newValue);
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
      case SolutionDslPackage.SERVICE_REF__SERVICE:
        setService((Service)null);
        return;
      case SolutionDslPackage.SERVICE_REF__VERSION_REF:
        setVersionRef((VersionRef)null);
        return;
      case SolutionDslPackage.SERVICE_REF__IS_RESPONSE_HANDLER:
        setIsResponseHandler(IS_RESPONSE_HANDLER_EDEFAULT);
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
      case SolutionDslPackage.SERVICE_REF__SERVICE:
        return service != null;
      case SolutionDslPackage.SERVICE_REF__VERSION_REF:
        return versionRef != null;
      case SolutionDslPackage.SERVICE_REF__IS_RESPONSE_HANDLER:
        return isResponseHandler != IS_RESPONSE_HANDLER_EDEFAULT;
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
    result.append(" (isResponseHandler: ");
    result.append(isResponseHandler);
    result.append(')');
    return result.toString();
  }

} //ServiceRefImpl
