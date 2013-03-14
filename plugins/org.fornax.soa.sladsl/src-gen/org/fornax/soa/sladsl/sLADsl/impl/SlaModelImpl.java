/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.fornax.soa.sladsl.sLADsl.SLA;
import org.fornax.soa.sladsl.sLADsl.SLADslPackage;
import org.fornax.soa.sladsl.sLADsl.SlaModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sla Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SlaModelImpl#getAgreements <em>Agreements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SlaModelImpl extends MinimalEObjectImpl.Container implements SlaModel
{
  /**
   * The cached value of the '{@link #getAgreements() <em>Agreements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAgreements()
   * @generated
   * @ordered
   */
  protected EList<SLA> agreements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SlaModelImpl()
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
    return SLADslPackage.Literals.SLA_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SLA> getAgreements()
  {
    if (agreements == null)
    {
      agreements = new EObjectContainmentEList<SLA>(SLA.class, this, SLADslPackage.SLA_MODEL__AGREEMENTS);
    }
    return agreements;
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
      case SLADslPackage.SLA_MODEL__AGREEMENTS:
        return ((InternalEList<?>)getAgreements()).basicRemove(otherEnd, msgs);
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
      case SLADslPackage.SLA_MODEL__AGREEMENTS:
        return getAgreements();
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
      case SLADslPackage.SLA_MODEL__AGREEMENTS:
        getAgreements().clear();
        getAgreements().addAll((Collection<? extends SLA>)newValue);
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
      case SLADslPackage.SLA_MODEL__AGREEMENTS:
        getAgreements().clear();
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
      case SLADslPackage.SLA_MODEL__AGREEMENTS:
        return agreements != null && !agreements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SlaModelImpl
