/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.sladsl.sLADsl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.fornax.soa.sladsl.sLADsl.Availability;
import org.fornax.soa.sladsl.sLADsl.Percentile;
import org.fornax.soa.sladsl.sLADsl.SLADslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Availability</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.AvailabilityImpl#getAvailability <em>Availability</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.AvailabilityImpl#getPercentile <em>Percentile</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.AvailabilityImpl#getMtbf <em>Mtbf</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.AvailabilityImpl#getMttr <em>Mttr</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.AvailabilityImpl#getMttrPercentile <em>Mttr Percentile</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.AvailabilityImpl#getRegularDownTimes <em>Regular Down Times</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AvailabilityImpl extends ServiceQualityPropertyImpl implements Availability
{
  /**
   * The default value of the '{@link #getAvailability() <em>Availability</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAvailability()
   * @generated
   * @ordered
   */
  protected static final String AVAILABILITY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAvailability() <em>Availability</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAvailability()
   * @generated
   * @ordered
   */
  protected String availability = AVAILABILITY_EDEFAULT;

  /**
   * The cached value of the '{@link #getPercentile() <em>Percentile</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPercentile()
   * @generated
   * @ordered
   */
  protected Percentile percentile;

  /**
   * The default value of the '{@link #getMtbf() <em>Mtbf</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMtbf()
   * @generated
   * @ordered
   */
  protected static final String MTBF_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMtbf() <em>Mtbf</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMtbf()
   * @generated
   * @ordered
   */
  protected String mtbf = MTBF_EDEFAULT;

  /**
   * The default value of the '{@link #getMttr() <em>Mttr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMttr()
   * @generated
   * @ordered
   */
  protected static final String MTTR_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getMttr() <em>Mttr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMttr()
   * @generated
   * @ordered
   */
  protected String mttr = MTTR_EDEFAULT;

  /**
   * The cached value of the '{@link #getMttrPercentile() <em>Mttr Percentile</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMttrPercentile()
   * @generated
   * @ordered
   */
  protected Percentile mttrPercentile;

  /**
   * The default value of the '{@link #getRegularDownTimes() <em>Regular Down Times</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRegularDownTimes()
   * @generated
   * @ordered
   */
  protected static final String REGULAR_DOWN_TIMES_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRegularDownTimes() <em>Regular Down Times</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRegularDownTimes()
   * @generated
   * @ordered
   */
  protected String regularDownTimes = REGULAR_DOWN_TIMES_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AvailabilityImpl()
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
    return SLADslPackage.Literals.AVAILABILITY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAvailability()
  {
    return availability;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAvailability(String newAvailability)
  {
    String oldAvailability = availability;
    availability = newAvailability;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.AVAILABILITY__AVAILABILITY, oldAvailability, availability));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Percentile getPercentile()
  {
    return percentile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPercentile(Percentile newPercentile, NotificationChain msgs)
  {
    Percentile oldPercentile = percentile;
    percentile = newPercentile;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SLADslPackage.AVAILABILITY__PERCENTILE, oldPercentile, newPercentile);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPercentile(Percentile newPercentile)
  {
    if (newPercentile != percentile)
    {
      NotificationChain msgs = null;
      if (percentile != null)
        msgs = ((InternalEObject)percentile).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SLADslPackage.AVAILABILITY__PERCENTILE, null, msgs);
      if (newPercentile != null)
        msgs = ((InternalEObject)newPercentile).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SLADslPackage.AVAILABILITY__PERCENTILE, null, msgs);
      msgs = basicSetPercentile(newPercentile, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.AVAILABILITY__PERCENTILE, newPercentile, newPercentile));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMtbf()
  {
    return mtbf;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMtbf(String newMtbf)
  {
    String oldMtbf = mtbf;
    mtbf = newMtbf;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.AVAILABILITY__MTBF, oldMtbf, mtbf));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getMttr()
  {
    return mttr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMttr(String newMttr)
  {
    String oldMttr = mttr;
    mttr = newMttr;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.AVAILABILITY__MTTR, oldMttr, mttr));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Percentile getMttrPercentile()
  {
    return mttrPercentile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMttrPercentile(Percentile newMttrPercentile, NotificationChain msgs)
  {
    Percentile oldMttrPercentile = mttrPercentile;
    mttrPercentile = newMttrPercentile;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SLADslPackage.AVAILABILITY__MTTR_PERCENTILE, oldMttrPercentile, newMttrPercentile);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMttrPercentile(Percentile newMttrPercentile)
  {
    if (newMttrPercentile != mttrPercentile)
    {
      NotificationChain msgs = null;
      if (mttrPercentile != null)
        msgs = ((InternalEObject)mttrPercentile).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SLADslPackage.AVAILABILITY__MTTR_PERCENTILE, null, msgs);
      if (newMttrPercentile != null)
        msgs = ((InternalEObject)newMttrPercentile).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SLADslPackage.AVAILABILITY__MTTR_PERCENTILE, null, msgs);
      msgs = basicSetMttrPercentile(newMttrPercentile, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.AVAILABILITY__MTTR_PERCENTILE, newMttrPercentile, newMttrPercentile));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRegularDownTimes()
  {
    return regularDownTimes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRegularDownTimes(String newRegularDownTimes)
  {
    String oldRegularDownTimes = regularDownTimes;
    regularDownTimes = newRegularDownTimes;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.AVAILABILITY__REGULAR_DOWN_TIMES, oldRegularDownTimes, regularDownTimes));
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
      case SLADslPackage.AVAILABILITY__PERCENTILE:
        return basicSetPercentile(null, msgs);
      case SLADslPackage.AVAILABILITY__MTTR_PERCENTILE:
        return basicSetMttrPercentile(null, msgs);
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
      case SLADslPackage.AVAILABILITY__AVAILABILITY:
        return getAvailability();
      case SLADslPackage.AVAILABILITY__PERCENTILE:
        return getPercentile();
      case SLADslPackage.AVAILABILITY__MTBF:
        return getMtbf();
      case SLADslPackage.AVAILABILITY__MTTR:
        return getMttr();
      case SLADslPackage.AVAILABILITY__MTTR_PERCENTILE:
        return getMttrPercentile();
      case SLADslPackage.AVAILABILITY__REGULAR_DOWN_TIMES:
        return getRegularDownTimes();
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
      case SLADslPackage.AVAILABILITY__AVAILABILITY:
        setAvailability((String)newValue);
        return;
      case SLADslPackage.AVAILABILITY__PERCENTILE:
        setPercentile((Percentile)newValue);
        return;
      case SLADslPackage.AVAILABILITY__MTBF:
        setMtbf((String)newValue);
        return;
      case SLADslPackage.AVAILABILITY__MTTR:
        setMttr((String)newValue);
        return;
      case SLADslPackage.AVAILABILITY__MTTR_PERCENTILE:
        setMttrPercentile((Percentile)newValue);
        return;
      case SLADslPackage.AVAILABILITY__REGULAR_DOWN_TIMES:
        setRegularDownTimes((String)newValue);
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
      case SLADslPackage.AVAILABILITY__AVAILABILITY:
        setAvailability(AVAILABILITY_EDEFAULT);
        return;
      case SLADslPackage.AVAILABILITY__PERCENTILE:
        setPercentile((Percentile)null);
        return;
      case SLADslPackage.AVAILABILITY__MTBF:
        setMtbf(MTBF_EDEFAULT);
        return;
      case SLADslPackage.AVAILABILITY__MTTR:
        setMttr(MTTR_EDEFAULT);
        return;
      case SLADslPackage.AVAILABILITY__MTTR_PERCENTILE:
        setMttrPercentile((Percentile)null);
        return;
      case SLADslPackage.AVAILABILITY__REGULAR_DOWN_TIMES:
        setRegularDownTimes(REGULAR_DOWN_TIMES_EDEFAULT);
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
      case SLADslPackage.AVAILABILITY__AVAILABILITY:
        return AVAILABILITY_EDEFAULT == null ? availability != null : !AVAILABILITY_EDEFAULT.equals(availability);
      case SLADslPackage.AVAILABILITY__PERCENTILE:
        return percentile != null;
      case SLADslPackage.AVAILABILITY__MTBF:
        return MTBF_EDEFAULT == null ? mtbf != null : !MTBF_EDEFAULT.equals(mtbf);
      case SLADslPackage.AVAILABILITY__MTTR:
        return MTTR_EDEFAULT == null ? mttr != null : !MTTR_EDEFAULT.equals(mttr);
      case SLADslPackage.AVAILABILITY__MTTR_PERCENTILE:
        return mttrPercentile != null;
      case SLADslPackage.AVAILABILITY__REGULAR_DOWN_TIMES:
        return REGULAR_DOWN_TIMES_EDEFAULT == null ? regularDownTimes != null : !REGULAR_DOWN_TIMES_EDEFAULT.equals(regularDownTimes);
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
    result.append(" (availability: ");
    result.append(availability);
    result.append(", mtbf: ");
    result.append(mtbf);
    result.append(", mttr: ");
    result.append(mttr);
    result.append(", regularDownTimes: ");
    result.append(regularDownTimes);
    result.append(')');
    return result.toString();
  }

} //AvailabilityImpl
