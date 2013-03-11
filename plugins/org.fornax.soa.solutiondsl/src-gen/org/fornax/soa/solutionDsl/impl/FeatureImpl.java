/**
 * <copyright>
 * </copyright>
 *
 */
package org.fornax.soa.solutionDsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.fornax.soa.basedsl.sOABaseDsl.AdditionalInformation;
import org.fornax.soa.basedsl.sOABaseDsl.User;

import org.fornax.soa.semanticsDsl.Tag;

import org.fornax.soa.solutionDsl.CapabilityRef;
import org.fornax.soa.solutionDsl.EventRef;
import org.fornax.soa.solutionDsl.Feature;
import org.fornax.soa.solutionDsl.ServiceRef;
import org.fornax.soa.solutionDsl.SolutionDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.FeatureImpl#isNonFunctional <em>Non Functional</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.FeatureImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.FeatureImpl#getUseCase <em>Use Case</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.FeatureImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.FeatureImpl#getAdditionalInfo <em>Additional Info</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.FeatureImpl#getUsesCapabilities <em>Uses Capabilities</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.FeatureImpl#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.FeatureImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.FeatureImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.FeatureImpl#getResponsible <em>Responsible</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.FeatureImpl#getBudgeting <em>Budgeting</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.FeatureImpl#getSubscriptions <em>Subscriptions</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.FeatureImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.FeatureImpl#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureImpl extends MinimalEObjectImpl.Container implements Feature
{
  /**
   * The default value of the '{@link #isNonFunctional() <em>Non Functional</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNonFunctional()
   * @generated
   * @ordered
   */
  protected static final boolean NON_FUNCTIONAL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isNonFunctional() <em>Non Functional</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isNonFunctional()
   * @generated
   * @ordered
   */
  protected boolean nonFunctional = NON_FUNCTIONAL_EDEFAULT;

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
   * The cached value of the '{@link #getUseCase() <em>Use Case</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUseCase()
   * @generated
   * @ordered
   */
  protected EList<String> useCase;

  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * The cached value of the '{@link #getAdditionalInfo() <em>Additional Info</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdditionalInfo()
   * @generated
   * @ordered
   */
  protected AdditionalInformation additionalInfo;

  /**
   * The cached value of the '{@link #getUsesCapabilities() <em>Uses Capabilities</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUsesCapabilities()
   * @generated
   * @ordered
   */
  protected EList<CapabilityRef> usesCapabilities;

  /**
   * The cached value of the '{@link #getRequires() <em>Requires</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequires()
   * @generated
   * @ordered
   */
  protected EList<ServiceRef> requires;

  /**
   * The cached value of the '{@link #getEvent() <em>Event</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvent()
   * @generated
   * @ordered
   */
  protected EList<EventRef> event;

  /**
   * The cached value of the '{@link #getOwner() <em>Owner</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwner()
   * @generated
   * @ordered
   */
  protected User owner;

  /**
   * The cached value of the '{@link #getResponsible() <em>Responsible</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResponsible()
   * @generated
   * @ordered
   */
  protected EList<User> responsible;

  /**
   * The cached value of the '{@link #getBudgeting() <em>Budgeting</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBudgeting()
   * @generated
   * @ordered
   */
  protected User budgeting;

  /**
   * The cached value of the '{@link #getSubscriptions() <em>Subscriptions</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubscriptions()
   * @generated
   * @ordered
   */
  protected EList<User> subscriptions;

  /**
   * The cached value of the '{@link #getTags() <em>Tags</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTags()
   * @generated
   * @ordered
   */
  protected EList<Tag> tags;

  /**
   * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatures()
   * @generated
   * @ordered
   */
  protected EList<Feature> features;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FeatureImpl()
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
    return SolutionDslPackage.Literals.FEATURE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isNonFunctional()
  {
    return nonFunctional;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNonFunctional(boolean newNonFunctional)
  {
    boolean oldNonFunctional = nonFunctional;
    nonFunctional = newNonFunctional;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SolutionDslPackage.FEATURE__NON_FUNCTIONAL, oldNonFunctional, nonFunctional));
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
      eNotify(new ENotificationImpl(this, Notification.SET, SolutionDslPackage.FEATURE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getUseCase()
  {
    if (useCase == null)
    {
      useCase = new EDataTypeEList<String>(String.class, this, SolutionDslPackage.FEATURE__USE_CASE);
    }
    return useCase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(String newDescription)
  {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SolutionDslPackage.FEATURE__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdditionalInformation getAdditionalInfo()
  {
    return additionalInfo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAdditionalInfo(AdditionalInformation newAdditionalInfo, NotificationChain msgs)
  {
    AdditionalInformation oldAdditionalInfo = additionalInfo;
    additionalInfo = newAdditionalInfo;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SolutionDslPackage.FEATURE__ADDITIONAL_INFO, oldAdditionalInfo, newAdditionalInfo);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdditionalInfo(AdditionalInformation newAdditionalInfo)
  {
    if (newAdditionalInfo != additionalInfo)
    {
      NotificationChain msgs = null;
      if (additionalInfo != null)
        msgs = ((InternalEObject)additionalInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SolutionDslPackage.FEATURE__ADDITIONAL_INFO, null, msgs);
      if (newAdditionalInfo != null)
        msgs = ((InternalEObject)newAdditionalInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SolutionDslPackage.FEATURE__ADDITIONAL_INFO, null, msgs);
      msgs = basicSetAdditionalInfo(newAdditionalInfo, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SolutionDslPackage.FEATURE__ADDITIONAL_INFO, newAdditionalInfo, newAdditionalInfo));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CapabilityRef> getUsesCapabilities()
  {
    if (usesCapabilities == null)
    {
      usesCapabilities = new EObjectContainmentEList<CapabilityRef>(CapabilityRef.class, this, SolutionDslPackage.FEATURE__USES_CAPABILITIES);
    }
    return usesCapabilities;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ServiceRef> getRequires()
  {
    if (requires == null)
    {
      requires = new EObjectContainmentEList<ServiceRef>(ServiceRef.class, this, SolutionDslPackage.FEATURE__REQUIRES);
    }
    return requires;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EventRef> getEvent()
  {
    if (event == null)
    {
      event = new EObjectContainmentEList<EventRef>(EventRef.class, this, SolutionDslPackage.FEATURE__EVENT);
    }
    return event;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public User getOwner()
  {
    if (owner != null && owner.eIsProxy())
    {
      InternalEObject oldOwner = (InternalEObject)owner;
      owner = (User)eResolveProxy(oldOwner);
      if (owner != oldOwner)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SolutionDslPackage.FEATURE__OWNER, oldOwner, owner));
      }
    }
    return owner;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public User basicGetOwner()
  {
    return owner;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOwner(User newOwner)
  {
    User oldOwner = owner;
    owner = newOwner;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SolutionDslPackage.FEATURE__OWNER, oldOwner, owner));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<User> getResponsible()
  {
    if (responsible == null)
    {
      responsible = new EObjectResolvingEList<User>(User.class, this, SolutionDslPackage.FEATURE__RESPONSIBLE);
    }
    return responsible;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public User getBudgeting()
  {
    if (budgeting != null && budgeting.eIsProxy())
    {
      InternalEObject oldBudgeting = (InternalEObject)budgeting;
      budgeting = (User)eResolveProxy(oldBudgeting);
      if (budgeting != oldBudgeting)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SolutionDslPackage.FEATURE__BUDGETING, oldBudgeting, budgeting));
      }
    }
    return budgeting;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public User basicGetBudgeting()
  {
    return budgeting;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBudgeting(User newBudgeting)
  {
    User oldBudgeting = budgeting;
    budgeting = newBudgeting;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SolutionDslPackage.FEATURE__BUDGETING, oldBudgeting, budgeting));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<User> getSubscriptions()
  {
    if (subscriptions == null)
    {
      subscriptions = new EObjectResolvingEList<User>(User.class, this, SolutionDslPackage.FEATURE__SUBSCRIPTIONS);
    }
    return subscriptions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Tag> getTags()
  {
    if (tags == null)
    {
      tags = new EObjectResolvingEList<Tag>(Tag.class, this, SolutionDslPackage.FEATURE__TAGS);
    }
    return tags;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Feature> getFeatures()
  {
    if (features == null)
    {
      features = new EObjectContainmentEList<Feature>(Feature.class, this, SolutionDslPackage.FEATURE__FEATURES);
    }
    return features;
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
      case SolutionDslPackage.FEATURE__ADDITIONAL_INFO:
        return basicSetAdditionalInfo(null, msgs);
      case SolutionDslPackage.FEATURE__USES_CAPABILITIES:
        return ((InternalEList<?>)getUsesCapabilities()).basicRemove(otherEnd, msgs);
      case SolutionDslPackage.FEATURE__REQUIRES:
        return ((InternalEList<?>)getRequires()).basicRemove(otherEnd, msgs);
      case SolutionDslPackage.FEATURE__EVENT:
        return ((InternalEList<?>)getEvent()).basicRemove(otherEnd, msgs);
      case SolutionDslPackage.FEATURE__FEATURES:
        return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
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
      case SolutionDslPackage.FEATURE__NON_FUNCTIONAL:
        return isNonFunctional();
      case SolutionDslPackage.FEATURE__NAME:
        return getName();
      case SolutionDslPackage.FEATURE__USE_CASE:
        return getUseCase();
      case SolutionDslPackage.FEATURE__DESCRIPTION:
        return getDescription();
      case SolutionDslPackage.FEATURE__ADDITIONAL_INFO:
        return getAdditionalInfo();
      case SolutionDslPackage.FEATURE__USES_CAPABILITIES:
        return getUsesCapabilities();
      case SolutionDslPackage.FEATURE__REQUIRES:
        return getRequires();
      case SolutionDslPackage.FEATURE__EVENT:
        return getEvent();
      case SolutionDslPackage.FEATURE__OWNER:
        if (resolve) return getOwner();
        return basicGetOwner();
      case SolutionDslPackage.FEATURE__RESPONSIBLE:
        return getResponsible();
      case SolutionDslPackage.FEATURE__BUDGETING:
        if (resolve) return getBudgeting();
        return basicGetBudgeting();
      case SolutionDslPackage.FEATURE__SUBSCRIPTIONS:
        return getSubscriptions();
      case SolutionDslPackage.FEATURE__TAGS:
        return getTags();
      case SolutionDslPackage.FEATURE__FEATURES:
        return getFeatures();
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
      case SolutionDslPackage.FEATURE__NON_FUNCTIONAL:
        setNonFunctional((Boolean)newValue);
        return;
      case SolutionDslPackage.FEATURE__NAME:
        setName((String)newValue);
        return;
      case SolutionDslPackage.FEATURE__USE_CASE:
        getUseCase().clear();
        getUseCase().addAll((Collection<? extends String>)newValue);
        return;
      case SolutionDslPackage.FEATURE__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case SolutionDslPackage.FEATURE__ADDITIONAL_INFO:
        setAdditionalInfo((AdditionalInformation)newValue);
        return;
      case SolutionDslPackage.FEATURE__USES_CAPABILITIES:
        getUsesCapabilities().clear();
        getUsesCapabilities().addAll((Collection<? extends CapabilityRef>)newValue);
        return;
      case SolutionDslPackage.FEATURE__REQUIRES:
        getRequires().clear();
        getRequires().addAll((Collection<? extends ServiceRef>)newValue);
        return;
      case SolutionDslPackage.FEATURE__EVENT:
        getEvent().clear();
        getEvent().addAll((Collection<? extends EventRef>)newValue);
        return;
      case SolutionDslPackage.FEATURE__OWNER:
        setOwner((User)newValue);
        return;
      case SolutionDslPackage.FEATURE__RESPONSIBLE:
        getResponsible().clear();
        getResponsible().addAll((Collection<? extends User>)newValue);
        return;
      case SolutionDslPackage.FEATURE__BUDGETING:
        setBudgeting((User)newValue);
        return;
      case SolutionDslPackage.FEATURE__SUBSCRIPTIONS:
        getSubscriptions().clear();
        getSubscriptions().addAll((Collection<? extends User>)newValue);
        return;
      case SolutionDslPackage.FEATURE__TAGS:
        getTags().clear();
        getTags().addAll((Collection<? extends Tag>)newValue);
        return;
      case SolutionDslPackage.FEATURE__FEATURES:
        getFeatures().clear();
        getFeatures().addAll((Collection<? extends Feature>)newValue);
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
      case SolutionDslPackage.FEATURE__NON_FUNCTIONAL:
        setNonFunctional(NON_FUNCTIONAL_EDEFAULT);
        return;
      case SolutionDslPackage.FEATURE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SolutionDslPackage.FEATURE__USE_CASE:
        getUseCase().clear();
        return;
      case SolutionDslPackage.FEATURE__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case SolutionDslPackage.FEATURE__ADDITIONAL_INFO:
        setAdditionalInfo((AdditionalInformation)null);
        return;
      case SolutionDslPackage.FEATURE__USES_CAPABILITIES:
        getUsesCapabilities().clear();
        return;
      case SolutionDslPackage.FEATURE__REQUIRES:
        getRequires().clear();
        return;
      case SolutionDslPackage.FEATURE__EVENT:
        getEvent().clear();
        return;
      case SolutionDslPackage.FEATURE__OWNER:
        setOwner((User)null);
        return;
      case SolutionDslPackage.FEATURE__RESPONSIBLE:
        getResponsible().clear();
        return;
      case SolutionDslPackage.FEATURE__BUDGETING:
        setBudgeting((User)null);
        return;
      case SolutionDslPackage.FEATURE__SUBSCRIPTIONS:
        getSubscriptions().clear();
        return;
      case SolutionDslPackage.FEATURE__TAGS:
        getTags().clear();
        return;
      case SolutionDslPackage.FEATURE__FEATURES:
        getFeatures().clear();
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
      case SolutionDslPackage.FEATURE__NON_FUNCTIONAL:
        return nonFunctional != NON_FUNCTIONAL_EDEFAULT;
      case SolutionDslPackage.FEATURE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SolutionDslPackage.FEATURE__USE_CASE:
        return useCase != null && !useCase.isEmpty();
      case SolutionDslPackage.FEATURE__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case SolutionDslPackage.FEATURE__ADDITIONAL_INFO:
        return additionalInfo != null;
      case SolutionDslPackage.FEATURE__USES_CAPABILITIES:
        return usesCapabilities != null && !usesCapabilities.isEmpty();
      case SolutionDslPackage.FEATURE__REQUIRES:
        return requires != null && !requires.isEmpty();
      case SolutionDslPackage.FEATURE__EVENT:
        return event != null && !event.isEmpty();
      case SolutionDslPackage.FEATURE__OWNER:
        return owner != null;
      case SolutionDslPackage.FEATURE__RESPONSIBLE:
        return responsible != null && !responsible.isEmpty();
      case SolutionDslPackage.FEATURE__BUDGETING:
        return budgeting != null;
      case SolutionDslPackage.FEATURE__SUBSCRIPTIONS:
        return subscriptions != null && !subscriptions.isEmpty();
      case SolutionDslPackage.FEATURE__TAGS:
        return tags != null && !tags.isEmpty();
      case SolutionDslPackage.FEATURE__FEATURES:
        return features != null && !features.isEmpty();
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
    result.append(" (nonFunctional: ");
    result.append(nonFunctional);
    result.append(", name: ");
    result.append(name);
    result.append(", useCase: ");
    result.append(useCase);
    result.append(", description: ");
    result.append(description);
    result.append(')');
    return result.toString();
  }

} //FeatureImpl
