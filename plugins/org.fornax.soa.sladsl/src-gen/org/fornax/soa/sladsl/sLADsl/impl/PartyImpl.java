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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.fornax.soa.sladsl.sLADsl.Party;
import org.fornax.soa.sladsl.sLADsl.Repesentative;
import org.fornax.soa.sladsl.sLADsl.Responsibility;
import org.fornax.soa.sladsl.sLADsl.SLADslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Party</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.PartyImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.PartyImpl#getRepresentatives <em>Representatives</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.PartyImpl#getResponsibilities <em>Responsibilities</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PartyImpl extends MinimalEObjectImpl.Container implements Party
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getRepresentatives() <em>Representatives</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRepresentatives()
   * @generated
   * @ordered
   */
  protected EList<Repesentative> representatives;

  /**
   * The cached value of the '{@link #getResponsibilities() <em>Responsibilities</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResponsibilities()
   * @generated
   * @ordered
   */
  protected EList<Responsibility> responsibilities;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PartyImpl()
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
    return SLADslPackage.Literals.PARTY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.PARTY__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Repesentative> getRepresentatives()
  {
    if (representatives == null)
    {
      representatives = new EObjectContainmentEList<Repesentative>(Repesentative.class, this, SLADslPackage.PARTY__REPRESENTATIVES);
    }
    return representatives;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Responsibility> getResponsibilities()
  {
    if (responsibilities == null)
    {
      responsibilities = new EObjectContainmentEList<Responsibility>(Responsibility.class, this, SLADslPackage.PARTY__RESPONSIBILITIES);
    }
    return responsibilities;
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
      case SLADslPackage.PARTY__REPRESENTATIVES:
        return ((InternalEList<?>)getRepresentatives()).basicRemove(otherEnd, msgs);
      case SLADslPackage.PARTY__RESPONSIBILITIES:
        return ((InternalEList<?>)getResponsibilities()).basicRemove(otherEnd, msgs);
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
      case SLADslPackage.PARTY__NAME:
        return getName();
      case SLADslPackage.PARTY__REPRESENTATIVES:
        return getRepresentatives();
      case SLADslPackage.PARTY__RESPONSIBILITIES:
        return getResponsibilities();
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
      case SLADslPackage.PARTY__NAME:
        setName((String)newValue);
        return;
      case SLADslPackage.PARTY__REPRESENTATIVES:
        getRepresentatives().clear();
        getRepresentatives().addAll((Collection<? extends Repesentative>)newValue);
        return;
      case SLADslPackage.PARTY__RESPONSIBILITIES:
        getResponsibilities().clear();
        getResponsibilities().addAll((Collection<? extends Responsibility>)newValue);
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
      case SLADslPackage.PARTY__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SLADslPackage.PARTY__REPRESENTATIVES:
        getRepresentatives().clear();
        return;
      case SLADslPackage.PARTY__RESPONSIBILITIES:
        getResponsibilities().clear();
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
      case SLADslPackage.PARTY__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SLADslPackage.PARTY__REPRESENTATIVES:
        return representatives != null && !representatives.isEmpty();
      case SLADslPackage.PARTY__RESPONSIBILITIES:
        return responsibilities != null && !responsibilities.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //PartyImpl
