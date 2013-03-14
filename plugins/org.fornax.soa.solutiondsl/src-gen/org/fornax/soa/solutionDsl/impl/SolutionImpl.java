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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.fornax.soa.basedsl.sOABaseDsl.AdditionalInformation;
import org.fornax.soa.basedsl.sOABaseDsl.User;

import org.fornax.soa.businessDsl.Domain;

import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;

import org.fornax.soa.semanticsDsl.Tag;

import org.fornax.soa.serviceDsl.Channel;

import org.fornax.soa.solutionDsl.Feature;
import org.fornax.soa.solutionDsl.Module;
import org.fornax.soa.solutionDsl.ServiceRef;
import org.fornax.soa.solutionDsl.Solution;
import org.fornax.soa.solutionDsl.SolutionDslPackage;
import org.fornax.soa.solutionDsl.Version;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Solution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.SolutionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.SolutionImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.SolutionImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.SolutionImpl#getState <em>State</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.SolutionImpl#getProductVersion <em>Product Version</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.SolutionImpl#getAdditionalInfo <em>Additional Info</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.SolutionImpl#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.SolutionImpl#getRequiresChannel <em>Requires Channel</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.SolutionImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.SolutionImpl#getModules <em>Modules</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.SolutionImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.SolutionImpl#getResponsible <em>Responsible</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.SolutionImpl#getBudgeting <em>Budgeting</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.SolutionImpl#getTags <em>Tags</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.SolutionImpl#getSubscriptions <em>Subscriptions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SolutionImpl extends MinimalEObjectImpl.Container implements Solution
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
   * The cached value of the '{@link #getDomain() <em>Domain</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDomain()
   * @generated
   * @ordered
   */
  protected Domain domain;

  /**
   * The cached value of the '{@link #getVersion() <em>Version</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVersion()
   * @generated
   * @ordered
   */
  protected Version version;

  /**
   * The cached value of the '{@link #getState() <em>State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getState()
   * @generated
   * @ordered
   */
  protected LifecycleState state;

  /**
   * The cached value of the '{@link #getProductVersion() <em>Product Version</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProductVersion()
   * @generated
   * @ordered
   */
  protected Version productVersion;

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
   * The cached value of the '{@link #getRequires() <em>Requires</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequires()
   * @generated
   * @ordered
   */
  protected EList<ServiceRef> requires;

  /**
   * The cached value of the '{@link #getRequiresChannel() <em>Requires Channel</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequiresChannel()
   * @generated
   * @ordered
   */
  protected EList<Channel> requiresChannel;

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
   * The cached value of the '{@link #getModules() <em>Modules</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModules()
   * @generated
   * @ordered
   */
  protected EList<Module> modules;

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
   * The cached value of the '{@link #getTags() <em>Tags</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTags()
   * @generated
   * @ordered
   */
  protected EList<Tag> tags;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SolutionImpl()
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
    return SolutionDslPackage.Literals.SOLUTION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, SolutionDslPackage.SOLUTION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Domain getDomain()
  {
    if (domain != null && domain.eIsProxy())
    {
      InternalEObject oldDomain = (InternalEObject)domain;
      domain = (Domain)eResolveProxy(oldDomain);
      if (domain != oldDomain)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SolutionDslPackage.SOLUTION__DOMAIN, oldDomain, domain));
      }
    }
    return domain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Domain basicGetDomain()
  {
    return domain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDomain(Domain newDomain)
  {
    Domain oldDomain = domain;
    domain = newDomain;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SolutionDslPackage.SOLUTION__DOMAIN, oldDomain, domain));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Version getVersion()
  {
    return version;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVersion(Version newVersion, NotificationChain msgs)
  {
    Version oldVersion = version;
    version = newVersion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SolutionDslPackage.SOLUTION__VERSION, oldVersion, newVersion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVersion(Version newVersion)
  {
    if (newVersion != version)
    {
      NotificationChain msgs = null;
      if (version != null)
        msgs = ((InternalEObject)version).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SolutionDslPackage.SOLUTION__VERSION, null, msgs);
      if (newVersion != null)
        msgs = ((InternalEObject)newVersion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SolutionDslPackage.SOLUTION__VERSION, null, msgs);
      msgs = basicSetVersion(newVersion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SolutionDslPackage.SOLUTION__VERSION, newVersion, newVersion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LifecycleState getState()
  {
    if (state != null && state.eIsProxy())
    {
      InternalEObject oldState = (InternalEObject)state;
      state = (LifecycleState)eResolveProxy(oldState);
      if (state != oldState)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SolutionDslPackage.SOLUTION__STATE, oldState, state));
      }
    }
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LifecycleState basicGetState()
  {
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setState(LifecycleState newState)
  {
    LifecycleState oldState = state;
    state = newState;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SolutionDslPackage.SOLUTION__STATE, oldState, state));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Version getProductVersion()
  {
    return productVersion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetProductVersion(Version newProductVersion, NotificationChain msgs)
  {
    Version oldProductVersion = productVersion;
    productVersion = newProductVersion;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SolutionDslPackage.SOLUTION__PRODUCT_VERSION, oldProductVersion, newProductVersion);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProductVersion(Version newProductVersion)
  {
    if (newProductVersion != productVersion)
    {
      NotificationChain msgs = null;
      if (productVersion != null)
        msgs = ((InternalEObject)productVersion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SolutionDslPackage.SOLUTION__PRODUCT_VERSION, null, msgs);
      if (newProductVersion != null)
        msgs = ((InternalEObject)newProductVersion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SolutionDslPackage.SOLUTION__PRODUCT_VERSION, null, msgs);
      msgs = basicSetProductVersion(newProductVersion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SolutionDslPackage.SOLUTION__PRODUCT_VERSION, newProductVersion, newProductVersion));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SolutionDslPackage.SOLUTION__ADDITIONAL_INFO, oldAdditionalInfo, newAdditionalInfo);
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
        msgs = ((InternalEObject)additionalInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SolutionDslPackage.SOLUTION__ADDITIONAL_INFO, null, msgs);
      if (newAdditionalInfo != null)
        msgs = ((InternalEObject)newAdditionalInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SolutionDslPackage.SOLUTION__ADDITIONAL_INFO, null, msgs);
      msgs = basicSetAdditionalInfo(newAdditionalInfo, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SolutionDslPackage.SOLUTION__ADDITIONAL_INFO, newAdditionalInfo, newAdditionalInfo));
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
      requires = new EObjectContainmentEList<ServiceRef>(ServiceRef.class, this, SolutionDslPackage.SOLUTION__REQUIRES);
    }
    return requires;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Channel> getRequiresChannel()
  {
    if (requiresChannel == null)
    {
      requiresChannel = new EObjectResolvingEList<Channel>(Channel.class, this, SolutionDslPackage.SOLUTION__REQUIRES_CHANNEL);
    }
    return requiresChannel;
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
      features = new EObjectContainmentEList<Feature>(Feature.class, this, SolutionDslPackage.SOLUTION__FEATURES);
    }
    return features;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Module> getModules()
  {
    if (modules == null)
    {
      modules = new EObjectContainmentEList<Module>(Module.class, this, SolutionDslPackage.SOLUTION__MODULES);
    }
    return modules;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SolutionDslPackage.SOLUTION__OWNER, oldOwner, owner));
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
      eNotify(new ENotificationImpl(this, Notification.SET, SolutionDslPackage.SOLUTION__OWNER, oldOwner, owner));
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
      responsible = new EObjectResolvingEList<User>(User.class, this, SolutionDslPackage.SOLUTION__RESPONSIBLE);
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SolutionDslPackage.SOLUTION__BUDGETING, oldBudgeting, budgeting));
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
      eNotify(new ENotificationImpl(this, Notification.SET, SolutionDslPackage.SOLUTION__BUDGETING, oldBudgeting, budgeting));
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
      tags = new EObjectResolvingEList<Tag>(Tag.class, this, SolutionDslPackage.SOLUTION__TAGS);
    }
    return tags;
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
      subscriptions = new EObjectResolvingEList<User>(User.class, this, SolutionDslPackage.SOLUTION__SUBSCRIPTIONS);
    }
    return subscriptions;
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
      case SolutionDslPackage.SOLUTION__VERSION:
        return basicSetVersion(null, msgs);
      case SolutionDslPackage.SOLUTION__PRODUCT_VERSION:
        return basicSetProductVersion(null, msgs);
      case SolutionDslPackage.SOLUTION__ADDITIONAL_INFO:
        return basicSetAdditionalInfo(null, msgs);
      case SolutionDslPackage.SOLUTION__REQUIRES:
        return ((InternalEList<?>)getRequires()).basicRemove(otherEnd, msgs);
      case SolutionDslPackage.SOLUTION__FEATURES:
        return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
      case SolutionDslPackage.SOLUTION__MODULES:
        return ((InternalEList<?>)getModules()).basicRemove(otherEnd, msgs);
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
      case SolutionDslPackage.SOLUTION__NAME:
        return getName();
      case SolutionDslPackage.SOLUTION__DOMAIN:
        if (resolve) return getDomain();
        return basicGetDomain();
      case SolutionDslPackage.SOLUTION__VERSION:
        return getVersion();
      case SolutionDslPackage.SOLUTION__STATE:
        if (resolve) return getState();
        return basicGetState();
      case SolutionDslPackage.SOLUTION__PRODUCT_VERSION:
        return getProductVersion();
      case SolutionDslPackage.SOLUTION__ADDITIONAL_INFO:
        return getAdditionalInfo();
      case SolutionDslPackage.SOLUTION__REQUIRES:
        return getRequires();
      case SolutionDslPackage.SOLUTION__REQUIRES_CHANNEL:
        return getRequiresChannel();
      case SolutionDslPackage.SOLUTION__FEATURES:
        return getFeatures();
      case SolutionDslPackage.SOLUTION__MODULES:
        return getModules();
      case SolutionDslPackage.SOLUTION__OWNER:
        if (resolve) return getOwner();
        return basicGetOwner();
      case SolutionDslPackage.SOLUTION__RESPONSIBLE:
        return getResponsible();
      case SolutionDslPackage.SOLUTION__BUDGETING:
        if (resolve) return getBudgeting();
        return basicGetBudgeting();
      case SolutionDslPackage.SOLUTION__TAGS:
        return getTags();
      case SolutionDslPackage.SOLUTION__SUBSCRIPTIONS:
        return getSubscriptions();
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
      case SolutionDslPackage.SOLUTION__NAME:
        setName((String)newValue);
        return;
      case SolutionDslPackage.SOLUTION__DOMAIN:
        setDomain((Domain)newValue);
        return;
      case SolutionDslPackage.SOLUTION__VERSION:
        setVersion((Version)newValue);
        return;
      case SolutionDslPackage.SOLUTION__STATE:
        setState((LifecycleState)newValue);
        return;
      case SolutionDslPackage.SOLUTION__PRODUCT_VERSION:
        setProductVersion((Version)newValue);
        return;
      case SolutionDslPackage.SOLUTION__ADDITIONAL_INFO:
        setAdditionalInfo((AdditionalInformation)newValue);
        return;
      case SolutionDslPackage.SOLUTION__REQUIRES:
        getRequires().clear();
        getRequires().addAll((Collection<? extends ServiceRef>)newValue);
        return;
      case SolutionDslPackage.SOLUTION__REQUIRES_CHANNEL:
        getRequiresChannel().clear();
        getRequiresChannel().addAll((Collection<? extends Channel>)newValue);
        return;
      case SolutionDslPackage.SOLUTION__FEATURES:
        getFeatures().clear();
        getFeatures().addAll((Collection<? extends Feature>)newValue);
        return;
      case SolutionDslPackage.SOLUTION__MODULES:
        getModules().clear();
        getModules().addAll((Collection<? extends Module>)newValue);
        return;
      case SolutionDslPackage.SOLUTION__OWNER:
        setOwner((User)newValue);
        return;
      case SolutionDslPackage.SOLUTION__RESPONSIBLE:
        getResponsible().clear();
        getResponsible().addAll((Collection<? extends User>)newValue);
        return;
      case SolutionDslPackage.SOLUTION__BUDGETING:
        setBudgeting((User)newValue);
        return;
      case SolutionDslPackage.SOLUTION__TAGS:
        getTags().clear();
        getTags().addAll((Collection<? extends Tag>)newValue);
        return;
      case SolutionDslPackage.SOLUTION__SUBSCRIPTIONS:
        getSubscriptions().clear();
        getSubscriptions().addAll((Collection<? extends User>)newValue);
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
      case SolutionDslPackage.SOLUTION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SolutionDslPackage.SOLUTION__DOMAIN:
        setDomain((Domain)null);
        return;
      case SolutionDslPackage.SOLUTION__VERSION:
        setVersion((Version)null);
        return;
      case SolutionDslPackage.SOLUTION__STATE:
        setState((LifecycleState)null);
        return;
      case SolutionDslPackage.SOLUTION__PRODUCT_VERSION:
        setProductVersion((Version)null);
        return;
      case SolutionDslPackage.SOLUTION__ADDITIONAL_INFO:
        setAdditionalInfo((AdditionalInformation)null);
        return;
      case SolutionDslPackage.SOLUTION__REQUIRES:
        getRequires().clear();
        return;
      case SolutionDslPackage.SOLUTION__REQUIRES_CHANNEL:
        getRequiresChannel().clear();
        return;
      case SolutionDslPackage.SOLUTION__FEATURES:
        getFeatures().clear();
        return;
      case SolutionDslPackage.SOLUTION__MODULES:
        getModules().clear();
        return;
      case SolutionDslPackage.SOLUTION__OWNER:
        setOwner((User)null);
        return;
      case SolutionDslPackage.SOLUTION__RESPONSIBLE:
        getResponsible().clear();
        return;
      case SolutionDslPackage.SOLUTION__BUDGETING:
        setBudgeting((User)null);
        return;
      case SolutionDslPackage.SOLUTION__TAGS:
        getTags().clear();
        return;
      case SolutionDslPackage.SOLUTION__SUBSCRIPTIONS:
        getSubscriptions().clear();
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
      case SolutionDslPackage.SOLUTION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SolutionDslPackage.SOLUTION__DOMAIN:
        return domain != null;
      case SolutionDslPackage.SOLUTION__VERSION:
        return version != null;
      case SolutionDslPackage.SOLUTION__STATE:
        return state != null;
      case SolutionDslPackage.SOLUTION__PRODUCT_VERSION:
        return productVersion != null;
      case SolutionDslPackage.SOLUTION__ADDITIONAL_INFO:
        return additionalInfo != null;
      case SolutionDslPackage.SOLUTION__REQUIRES:
        return requires != null && !requires.isEmpty();
      case SolutionDslPackage.SOLUTION__REQUIRES_CHANNEL:
        return requiresChannel != null && !requiresChannel.isEmpty();
      case SolutionDslPackage.SOLUTION__FEATURES:
        return features != null && !features.isEmpty();
      case SolutionDslPackage.SOLUTION__MODULES:
        return modules != null && !modules.isEmpty();
      case SolutionDslPackage.SOLUTION__OWNER:
        return owner != null;
      case SolutionDslPackage.SOLUTION__RESPONSIBLE:
        return responsible != null && !responsible.isEmpty();
      case SolutionDslPackage.SOLUTION__BUDGETING:
        return budgeting != null;
      case SolutionDslPackage.SOLUTION__TAGS:
        return tags != null && !tags.isEmpty();
      case SolutionDslPackage.SOLUTION__SUBSCRIPTIONS:
        return subscriptions != null && !subscriptions.isEmpty();
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

} //SolutionImpl
