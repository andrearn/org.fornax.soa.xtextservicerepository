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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.fornax.soa.basedsl.sOABaseDsl.User;
import org.fornax.soa.basedsl.sOABaseDsl.Version;

import org.fornax.soa.semanticsDsl.Tag;

import org.fornax.soa.sladsl.sLADsl.AssetRef;
import org.fornax.soa.sladsl.sLADsl.Cost;
import org.fornax.soa.sladsl.sLADsl.Escalation;
import org.fornax.soa.sladsl.sLADsl.Party;
import org.fornax.soa.sladsl.sLADsl.PriorityDeclaration;
import org.fornax.soa.sladsl.sLADsl.Report;
import org.fornax.soa.sladsl.sLADsl.SLA;
import org.fornax.soa.sladsl.sLADsl.SLADslPackage;
import org.fornax.soa.sladsl.sLADsl.SecurityRequirement;
import org.fornax.soa.sladsl.sLADsl.ServiceQualityProperty;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SLA</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getEffectiveDate <em>Effective Date</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getEffectiveUntil <em>Effective Until</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getPreample <em>Preample</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getAppliesTo <em>Applies To</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getCosts <em>Costs</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getServiceQualityProperties <em>Service Quality Properties</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getDataSecProtClause <em>Data Sec Prot Clause</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getSecurityRequirements <em>Security Requirements</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getRestrictions <em>Restrictions</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getPriorities <em>Priorities</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getEscalationProcedure <em>Escalation Procedure</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getAdditionalServices <em>Additional Services</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getParties <em>Parties</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getCancellation <em>Cancellation</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getExtraordinaryCancellation <em>Extraordinary Cancellation</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getEffortAccounting <em>Effort Accounting</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getReports <em>Reports</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getResponsible <em>Responsible</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getBudgeting <em>Budgeting</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getSubscriptions <em>Subscriptions</em>}</li>
 *   <li>{@link org.fornax.soa.sladsl.sLADsl.impl.SLAImpl#getTags <em>Tags</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SLAImpl extends MinimalEObjectImpl.Container implements SLA
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
   * The cached value of the '{@link #getVersion() <em>Version</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVersion()
   * @generated
   * @ordered
   */
  protected Version version;

  /**
   * The default value of the '{@link #getEffectiveDate() <em>Effective Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEffectiveDate()
   * @generated
   * @ordered
   */
  protected static final String EFFECTIVE_DATE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEffectiveDate() <em>Effective Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEffectiveDate()
   * @generated
   * @ordered
   */
  protected String effectiveDate = EFFECTIVE_DATE_EDEFAULT;

  /**
   * The default value of the '{@link #getEffectiveUntil() <em>Effective Until</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEffectiveUntil()
   * @generated
   * @ordered
   */
  protected static final String EFFECTIVE_UNTIL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEffectiveUntil() <em>Effective Until</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEffectiveUntil()
   * @generated
   * @ordered
   */
  protected String effectiveUntil = EFFECTIVE_UNTIL_EDEFAULT;

  /**
   * The default value of the '{@link #getPreample() <em>Preample</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPreample()
   * @generated
   * @ordered
   */
  protected static final String PREAMPLE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPreample() <em>Preample</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPreample()
   * @generated
   * @ordered
   */
  protected String preample = PREAMPLE_EDEFAULT;

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
   * The default value of the '{@link #getScope() <em>Scope</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScope()
   * @generated
   * @ordered
   */
  protected static final String SCOPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getScope() <em>Scope</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScope()
   * @generated
   * @ordered
   */
  protected String scope = SCOPE_EDEFAULT;

  /**
   * The cached value of the '{@link #getAppliesTo() <em>Applies To</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAppliesTo()
   * @generated
   * @ordered
   */
  protected EList<AssetRef> appliesTo;

  /**
   * The cached value of the '{@link #getCosts() <em>Costs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCosts()
   * @generated
   * @ordered
   */
  protected Cost costs;

  /**
   * The cached value of the '{@link #getServiceQualityProperties() <em>Service Quality Properties</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getServiceQualityProperties()
   * @generated
   * @ordered
   */
  protected EList<ServiceQualityProperty> serviceQualityProperties;

  /**
   * The default value of the '{@link #getDataSecProtClause() <em>Data Sec Prot Clause</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDataSecProtClause()
   * @generated
   * @ordered
   */
  protected static final String DATA_SEC_PROT_CLAUSE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDataSecProtClause() <em>Data Sec Prot Clause</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDataSecProtClause()
   * @generated
   * @ordered
   */
  protected String dataSecProtClause = DATA_SEC_PROT_CLAUSE_EDEFAULT;

  /**
   * The cached value of the '{@link #getSecurityRequirements() <em>Security Requirements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecurityRequirements()
   * @generated
   * @ordered
   */
  protected EList<SecurityRequirement> securityRequirements;

  /**
   * The default value of the '{@link #getRestrictions() <em>Restrictions</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRestrictions()
   * @generated
   * @ordered
   */
  protected static final String RESTRICTIONS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRestrictions() <em>Restrictions</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRestrictions()
   * @generated
   * @ordered
   */
  protected String restrictions = RESTRICTIONS_EDEFAULT;

  /**
   * The cached value of the '{@link #getPriorities() <em>Priorities</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriorities()
   * @generated
   * @ordered
   */
  protected EList<PriorityDeclaration> priorities;

  /**
   * The cached value of the '{@link #getEscalationProcedure() <em>Escalation Procedure</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEscalationProcedure()
   * @generated
   * @ordered
   */
  protected Escalation escalationProcedure;

  /**
   * The default value of the '{@link #getAdditionalServices() <em>Additional Services</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdditionalServices()
   * @generated
   * @ordered
   */
  protected static final String ADDITIONAL_SERVICES_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getAdditionalServices() <em>Additional Services</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAdditionalServices()
   * @generated
   * @ordered
   */
  protected String additionalServices = ADDITIONAL_SERVICES_EDEFAULT;

  /**
   * The cached value of the '{@link #getParties() <em>Parties</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParties()
   * @generated
   * @ordered
   */
  protected EList<Party> parties;

  /**
   * The default value of the '{@link #getCancellation() <em>Cancellation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCancellation()
   * @generated
   * @ordered
   */
  protected static final String CANCELLATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCancellation() <em>Cancellation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCancellation()
   * @generated
   * @ordered
   */
  protected String cancellation = CANCELLATION_EDEFAULT;

  /**
   * The default value of the '{@link #getExtraordinaryCancellation() <em>Extraordinary Cancellation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtraordinaryCancellation()
   * @generated
   * @ordered
   */
  protected static final String EXTRAORDINARY_CANCELLATION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExtraordinaryCancellation() <em>Extraordinary Cancellation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtraordinaryCancellation()
   * @generated
   * @ordered
   */
  protected String extraordinaryCancellation = EXTRAORDINARY_CANCELLATION_EDEFAULT;

  /**
   * The default value of the '{@link #getEffortAccounting() <em>Effort Accounting</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEffortAccounting()
   * @generated
   * @ordered
   */
  protected static final String EFFORT_ACCOUNTING_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEffortAccounting() <em>Effort Accounting</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEffortAccounting()
   * @generated
   * @ordered
   */
  protected String effortAccounting = EFFORT_ACCOUNTING_EDEFAULT;

  /**
   * The cached value of the '{@link #getReports() <em>Reports</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReports()
   * @generated
   * @ordered
   */
  protected EList<Report> reports;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SLAImpl()
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
    return SLADslPackage.Literals.SLA;
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
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.SLA__NAME, oldName, name));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SLADslPackage.SLA__VERSION, oldVersion, newVersion);
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
        msgs = ((InternalEObject)version).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SLADslPackage.SLA__VERSION, null, msgs);
      if (newVersion != null)
        msgs = ((InternalEObject)newVersion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SLADslPackage.SLA__VERSION, null, msgs);
      msgs = basicSetVersion(newVersion, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.SLA__VERSION, newVersion, newVersion));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEffectiveDate()
  {
    return effectiveDate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEffectiveDate(String newEffectiveDate)
  {
    String oldEffectiveDate = effectiveDate;
    effectiveDate = newEffectiveDate;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.SLA__EFFECTIVE_DATE, oldEffectiveDate, effectiveDate));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEffectiveUntil()
  {
    return effectiveUntil;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEffectiveUntil(String newEffectiveUntil)
  {
    String oldEffectiveUntil = effectiveUntil;
    effectiveUntil = newEffectiveUntil;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.SLA__EFFECTIVE_UNTIL, oldEffectiveUntil, effectiveUntil));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPreample()
  {
    return preample;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPreample(String newPreample)
  {
    String oldPreample = preample;
    preample = newPreample;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.SLA__PREAMPLE, oldPreample, preample));
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
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.SLA__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getScope()
  {
    return scope;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setScope(String newScope)
  {
    String oldScope = scope;
    scope = newScope;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.SLA__SCOPE, oldScope, scope));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AssetRef> getAppliesTo()
  {
    if (appliesTo == null)
    {
      appliesTo = new EObjectContainmentEList<AssetRef>(AssetRef.class, this, SLADslPackage.SLA__APPLIES_TO);
    }
    return appliesTo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Cost getCosts()
  {
    return costs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCosts(Cost newCosts, NotificationChain msgs)
  {
    Cost oldCosts = costs;
    costs = newCosts;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SLADslPackage.SLA__COSTS, oldCosts, newCosts);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCosts(Cost newCosts)
  {
    if (newCosts != costs)
    {
      NotificationChain msgs = null;
      if (costs != null)
        msgs = ((InternalEObject)costs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SLADslPackage.SLA__COSTS, null, msgs);
      if (newCosts != null)
        msgs = ((InternalEObject)newCosts).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SLADslPackage.SLA__COSTS, null, msgs);
      msgs = basicSetCosts(newCosts, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.SLA__COSTS, newCosts, newCosts));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ServiceQualityProperty> getServiceQualityProperties()
  {
    if (serviceQualityProperties == null)
    {
      serviceQualityProperties = new EObjectContainmentEList<ServiceQualityProperty>(ServiceQualityProperty.class, this, SLADslPackage.SLA__SERVICE_QUALITY_PROPERTIES);
    }
    return serviceQualityProperties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDataSecProtClause()
  {
    return dataSecProtClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDataSecProtClause(String newDataSecProtClause)
  {
    String oldDataSecProtClause = dataSecProtClause;
    dataSecProtClause = newDataSecProtClause;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.SLA__DATA_SEC_PROT_CLAUSE, oldDataSecProtClause, dataSecProtClause));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SecurityRequirement> getSecurityRequirements()
  {
    if (securityRequirements == null)
    {
      securityRequirements = new EObjectContainmentEList<SecurityRequirement>(SecurityRequirement.class, this, SLADslPackage.SLA__SECURITY_REQUIREMENTS);
    }
    return securityRequirements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRestrictions()
  {
    return restrictions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRestrictions(String newRestrictions)
  {
    String oldRestrictions = restrictions;
    restrictions = newRestrictions;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.SLA__RESTRICTIONS, oldRestrictions, restrictions));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PriorityDeclaration> getPriorities()
  {
    if (priorities == null)
    {
      priorities = new EObjectContainmentEList<PriorityDeclaration>(PriorityDeclaration.class, this, SLADslPackage.SLA__PRIORITIES);
    }
    return priorities;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Escalation getEscalationProcedure()
  {
    return escalationProcedure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEscalationProcedure(Escalation newEscalationProcedure, NotificationChain msgs)
  {
    Escalation oldEscalationProcedure = escalationProcedure;
    escalationProcedure = newEscalationProcedure;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SLADslPackage.SLA__ESCALATION_PROCEDURE, oldEscalationProcedure, newEscalationProcedure);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEscalationProcedure(Escalation newEscalationProcedure)
  {
    if (newEscalationProcedure != escalationProcedure)
    {
      NotificationChain msgs = null;
      if (escalationProcedure != null)
        msgs = ((InternalEObject)escalationProcedure).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SLADslPackage.SLA__ESCALATION_PROCEDURE, null, msgs);
      if (newEscalationProcedure != null)
        msgs = ((InternalEObject)newEscalationProcedure).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SLADslPackage.SLA__ESCALATION_PROCEDURE, null, msgs);
      msgs = basicSetEscalationProcedure(newEscalationProcedure, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.SLA__ESCALATION_PROCEDURE, newEscalationProcedure, newEscalationProcedure));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getAdditionalServices()
  {
    return additionalServices;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdditionalServices(String newAdditionalServices)
  {
    String oldAdditionalServices = additionalServices;
    additionalServices = newAdditionalServices;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.SLA__ADDITIONAL_SERVICES, oldAdditionalServices, additionalServices));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Party> getParties()
  {
    if (parties == null)
    {
      parties = new EObjectContainmentEList<Party>(Party.class, this, SLADslPackage.SLA__PARTIES);
    }
    return parties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCancellation()
  {
    return cancellation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCancellation(String newCancellation)
  {
    String oldCancellation = cancellation;
    cancellation = newCancellation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.SLA__CANCELLATION, oldCancellation, cancellation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExtraordinaryCancellation()
  {
    return extraordinaryCancellation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtraordinaryCancellation(String newExtraordinaryCancellation)
  {
    String oldExtraordinaryCancellation = extraordinaryCancellation;
    extraordinaryCancellation = newExtraordinaryCancellation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.SLA__EXTRAORDINARY_CANCELLATION, oldExtraordinaryCancellation, extraordinaryCancellation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getEffortAccounting()
  {
    return effortAccounting;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEffortAccounting(String newEffortAccounting)
  {
    String oldEffortAccounting = effortAccounting;
    effortAccounting = newEffortAccounting;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.SLA__EFFORT_ACCOUNTING, oldEffortAccounting, effortAccounting));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Report> getReports()
  {
    if (reports == null)
    {
      reports = new EObjectContainmentEList<Report>(Report.class, this, SLADslPackage.SLA__REPORTS);
    }
    return reports;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SLADslPackage.SLA__OWNER, oldOwner, owner));
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
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.SLA__OWNER, oldOwner, owner));
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
      responsible = new EObjectResolvingEList<User>(User.class, this, SLADslPackage.SLA__RESPONSIBLE);
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, SLADslPackage.SLA__BUDGETING, oldBudgeting, budgeting));
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
      eNotify(new ENotificationImpl(this, Notification.SET, SLADslPackage.SLA__BUDGETING, oldBudgeting, budgeting));
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
      subscriptions = new EObjectResolvingEList<User>(User.class, this, SLADslPackage.SLA__SUBSCRIPTIONS);
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
      tags = new EObjectResolvingEList<Tag>(Tag.class, this, SLADslPackage.SLA__TAGS);
    }
    return tags;
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
      case SLADslPackage.SLA__VERSION:
        return basicSetVersion(null, msgs);
      case SLADslPackage.SLA__APPLIES_TO:
        return ((InternalEList<?>)getAppliesTo()).basicRemove(otherEnd, msgs);
      case SLADslPackage.SLA__COSTS:
        return basicSetCosts(null, msgs);
      case SLADslPackage.SLA__SERVICE_QUALITY_PROPERTIES:
        return ((InternalEList<?>)getServiceQualityProperties()).basicRemove(otherEnd, msgs);
      case SLADslPackage.SLA__SECURITY_REQUIREMENTS:
        return ((InternalEList<?>)getSecurityRequirements()).basicRemove(otherEnd, msgs);
      case SLADslPackage.SLA__PRIORITIES:
        return ((InternalEList<?>)getPriorities()).basicRemove(otherEnd, msgs);
      case SLADslPackage.SLA__ESCALATION_PROCEDURE:
        return basicSetEscalationProcedure(null, msgs);
      case SLADslPackage.SLA__PARTIES:
        return ((InternalEList<?>)getParties()).basicRemove(otherEnd, msgs);
      case SLADslPackage.SLA__REPORTS:
        return ((InternalEList<?>)getReports()).basicRemove(otherEnd, msgs);
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
      case SLADslPackage.SLA__NAME:
        return getName();
      case SLADslPackage.SLA__VERSION:
        return getVersion();
      case SLADslPackage.SLA__EFFECTIVE_DATE:
        return getEffectiveDate();
      case SLADslPackage.SLA__EFFECTIVE_UNTIL:
        return getEffectiveUntil();
      case SLADslPackage.SLA__PREAMPLE:
        return getPreample();
      case SLADslPackage.SLA__DESCRIPTION:
        return getDescription();
      case SLADslPackage.SLA__SCOPE:
        return getScope();
      case SLADslPackage.SLA__APPLIES_TO:
        return getAppliesTo();
      case SLADslPackage.SLA__COSTS:
        return getCosts();
      case SLADslPackage.SLA__SERVICE_QUALITY_PROPERTIES:
        return getServiceQualityProperties();
      case SLADslPackage.SLA__DATA_SEC_PROT_CLAUSE:
        return getDataSecProtClause();
      case SLADslPackage.SLA__SECURITY_REQUIREMENTS:
        return getSecurityRequirements();
      case SLADslPackage.SLA__RESTRICTIONS:
        return getRestrictions();
      case SLADslPackage.SLA__PRIORITIES:
        return getPriorities();
      case SLADslPackage.SLA__ESCALATION_PROCEDURE:
        return getEscalationProcedure();
      case SLADslPackage.SLA__ADDITIONAL_SERVICES:
        return getAdditionalServices();
      case SLADslPackage.SLA__PARTIES:
        return getParties();
      case SLADslPackage.SLA__CANCELLATION:
        return getCancellation();
      case SLADslPackage.SLA__EXTRAORDINARY_CANCELLATION:
        return getExtraordinaryCancellation();
      case SLADslPackage.SLA__EFFORT_ACCOUNTING:
        return getEffortAccounting();
      case SLADslPackage.SLA__REPORTS:
        return getReports();
      case SLADslPackage.SLA__OWNER:
        if (resolve) return getOwner();
        return basicGetOwner();
      case SLADslPackage.SLA__RESPONSIBLE:
        return getResponsible();
      case SLADslPackage.SLA__BUDGETING:
        if (resolve) return getBudgeting();
        return basicGetBudgeting();
      case SLADslPackage.SLA__SUBSCRIPTIONS:
        return getSubscriptions();
      case SLADslPackage.SLA__TAGS:
        return getTags();
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
      case SLADslPackage.SLA__NAME:
        setName((String)newValue);
        return;
      case SLADslPackage.SLA__VERSION:
        setVersion((Version)newValue);
        return;
      case SLADslPackage.SLA__EFFECTIVE_DATE:
        setEffectiveDate((String)newValue);
        return;
      case SLADslPackage.SLA__EFFECTIVE_UNTIL:
        setEffectiveUntil((String)newValue);
        return;
      case SLADslPackage.SLA__PREAMPLE:
        setPreample((String)newValue);
        return;
      case SLADslPackage.SLA__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case SLADslPackage.SLA__SCOPE:
        setScope((String)newValue);
        return;
      case SLADslPackage.SLA__APPLIES_TO:
        getAppliesTo().clear();
        getAppliesTo().addAll((Collection<? extends AssetRef>)newValue);
        return;
      case SLADslPackage.SLA__COSTS:
        setCosts((Cost)newValue);
        return;
      case SLADslPackage.SLA__SERVICE_QUALITY_PROPERTIES:
        getServiceQualityProperties().clear();
        getServiceQualityProperties().addAll((Collection<? extends ServiceQualityProperty>)newValue);
        return;
      case SLADslPackage.SLA__DATA_SEC_PROT_CLAUSE:
        setDataSecProtClause((String)newValue);
        return;
      case SLADslPackage.SLA__SECURITY_REQUIREMENTS:
        getSecurityRequirements().clear();
        getSecurityRequirements().addAll((Collection<? extends SecurityRequirement>)newValue);
        return;
      case SLADslPackage.SLA__RESTRICTIONS:
        setRestrictions((String)newValue);
        return;
      case SLADslPackage.SLA__PRIORITIES:
        getPriorities().clear();
        getPriorities().addAll((Collection<? extends PriorityDeclaration>)newValue);
        return;
      case SLADslPackage.SLA__ESCALATION_PROCEDURE:
        setEscalationProcedure((Escalation)newValue);
        return;
      case SLADslPackage.SLA__ADDITIONAL_SERVICES:
        setAdditionalServices((String)newValue);
        return;
      case SLADslPackage.SLA__PARTIES:
        getParties().clear();
        getParties().addAll((Collection<? extends Party>)newValue);
        return;
      case SLADslPackage.SLA__CANCELLATION:
        setCancellation((String)newValue);
        return;
      case SLADslPackage.SLA__EXTRAORDINARY_CANCELLATION:
        setExtraordinaryCancellation((String)newValue);
        return;
      case SLADslPackage.SLA__EFFORT_ACCOUNTING:
        setEffortAccounting((String)newValue);
        return;
      case SLADslPackage.SLA__REPORTS:
        getReports().clear();
        getReports().addAll((Collection<? extends Report>)newValue);
        return;
      case SLADslPackage.SLA__OWNER:
        setOwner((User)newValue);
        return;
      case SLADslPackage.SLA__RESPONSIBLE:
        getResponsible().clear();
        getResponsible().addAll((Collection<? extends User>)newValue);
        return;
      case SLADslPackage.SLA__BUDGETING:
        setBudgeting((User)newValue);
        return;
      case SLADslPackage.SLA__SUBSCRIPTIONS:
        getSubscriptions().clear();
        getSubscriptions().addAll((Collection<? extends User>)newValue);
        return;
      case SLADslPackage.SLA__TAGS:
        getTags().clear();
        getTags().addAll((Collection<? extends Tag>)newValue);
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
      case SLADslPackage.SLA__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SLADslPackage.SLA__VERSION:
        setVersion((Version)null);
        return;
      case SLADslPackage.SLA__EFFECTIVE_DATE:
        setEffectiveDate(EFFECTIVE_DATE_EDEFAULT);
        return;
      case SLADslPackage.SLA__EFFECTIVE_UNTIL:
        setEffectiveUntil(EFFECTIVE_UNTIL_EDEFAULT);
        return;
      case SLADslPackage.SLA__PREAMPLE:
        setPreample(PREAMPLE_EDEFAULT);
        return;
      case SLADslPackage.SLA__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case SLADslPackage.SLA__SCOPE:
        setScope(SCOPE_EDEFAULT);
        return;
      case SLADslPackage.SLA__APPLIES_TO:
        getAppliesTo().clear();
        return;
      case SLADslPackage.SLA__COSTS:
        setCosts((Cost)null);
        return;
      case SLADslPackage.SLA__SERVICE_QUALITY_PROPERTIES:
        getServiceQualityProperties().clear();
        return;
      case SLADslPackage.SLA__DATA_SEC_PROT_CLAUSE:
        setDataSecProtClause(DATA_SEC_PROT_CLAUSE_EDEFAULT);
        return;
      case SLADslPackage.SLA__SECURITY_REQUIREMENTS:
        getSecurityRequirements().clear();
        return;
      case SLADslPackage.SLA__RESTRICTIONS:
        setRestrictions(RESTRICTIONS_EDEFAULT);
        return;
      case SLADslPackage.SLA__PRIORITIES:
        getPriorities().clear();
        return;
      case SLADslPackage.SLA__ESCALATION_PROCEDURE:
        setEscalationProcedure((Escalation)null);
        return;
      case SLADslPackage.SLA__ADDITIONAL_SERVICES:
        setAdditionalServices(ADDITIONAL_SERVICES_EDEFAULT);
        return;
      case SLADslPackage.SLA__PARTIES:
        getParties().clear();
        return;
      case SLADslPackage.SLA__CANCELLATION:
        setCancellation(CANCELLATION_EDEFAULT);
        return;
      case SLADslPackage.SLA__EXTRAORDINARY_CANCELLATION:
        setExtraordinaryCancellation(EXTRAORDINARY_CANCELLATION_EDEFAULT);
        return;
      case SLADslPackage.SLA__EFFORT_ACCOUNTING:
        setEffortAccounting(EFFORT_ACCOUNTING_EDEFAULT);
        return;
      case SLADslPackage.SLA__REPORTS:
        getReports().clear();
        return;
      case SLADslPackage.SLA__OWNER:
        setOwner((User)null);
        return;
      case SLADslPackage.SLA__RESPONSIBLE:
        getResponsible().clear();
        return;
      case SLADslPackage.SLA__BUDGETING:
        setBudgeting((User)null);
        return;
      case SLADslPackage.SLA__SUBSCRIPTIONS:
        getSubscriptions().clear();
        return;
      case SLADslPackage.SLA__TAGS:
        getTags().clear();
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
      case SLADslPackage.SLA__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SLADslPackage.SLA__VERSION:
        return version != null;
      case SLADslPackage.SLA__EFFECTIVE_DATE:
        return EFFECTIVE_DATE_EDEFAULT == null ? effectiveDate != null : !EFFECTIVE_DATE_EDEFAULT.equals(effectiveDate);
      case SLADslPackage.SLA__EFFECTIVE_UNTIL:
        return EFFECTIVE_UNTIL_EDEFAULT == null ? effectiveUntil != null : !EFFECTIVE_UNTIL_EDEFAULT.equals(effectiveUntil);
      case SLADslPackage.SLA__PREAMPLE:
        return PREAMPLE_EDEFAULT == null ? preample != null : !PREAMPLE_EDEFAULT.equals(preample);
      case SLADslPackage.SLA__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case SLADslPackage.SLA__SCOPE:
        return SCOPE_EDEFAULT == null ? scope != null : !SCOPE_EDEFAULT.equals(scope);
      case SLADslPackage.SLA__APPLIES_TO:
        return appliesTo != null && !appliesTo.isEmpty();
      case SLADslPackage.SLA__COSTS:
        return costs != null;
      case SLADslPackage.SLA__SERVICE_QUALITY_PROPERTIES:
        return serviceQualityProperties != null && !serviceQualityProperties.isEmpty();
      case SLADslPackage.SLA__DATA_SEC_PROT_CLAUSE:
        return DATA_SEC_PROT_CLAUSE_EDEFAULT == null ? dataSecProtClause != null : !DATA_SEC_PROT_CLAUSE_EDEFAULT.equals(dataSecProtClause);
      case SLADslPackage.SLA__SECURITY_REQUIREMENTS:
        return securityRequirements != null && !securityRequirements.isEmpty();
      case SLADslPackage.SLA__RESTRICTIONS:
        return RESTRICTIONS_EDEFAULT == null ? restrictions != null : !RESTRICTIONS_EDEFAULT.equals(restrictions);
      case SLADslPackage.SLA__PRIORITIES:
        return priorities != null && !priorities.isEmpty();
      case SLADslPackage.SLA__ESCALATION_PROCEDURE:
        return escalationProcedure != null;
      case SLADslPackage.SLA__ADDITIONAL_SERVICES:
        return ADDITIONAL_SERVICES_EDEFAULT == null ? additionalServices != null : !ADDITIONAL_SERVICES_EDEFAULT.equals(additionalServices);
      case SLADslPackage.SLA__PARTIES:
        return parties != null && !parties.isEmpty();
      case SLADslPackage.SLA__CANCELLATION:
        return CANCELLATION_EDEFAULT == null ? cancellation != null : !CANCELLATION_EDEFAULT.equals(cancellation);
      case SLADslPackage.SLA__EXTRAORDINARY_CANCELLATION:
        return EXTRAORDINARY_CANCELLATION_EDEFAULT == null ? extraordinaryCancellation != null : !EXTRAORDINARY_CANCELLATION_EDEFAULT.equals(extraordinaryCancellation);
      case SLADslPackage.SLA__EFFORT_ACCOUNTING:
        return EFFORT_ACCOUNTING_EDEFAULT == null ? effortAccounting != null : !EFFORT_ACCOUNTING_EDEFAULT.equals(effortAccounting);
      case SLADslPackage.SLA__REPORTS:
        return reports != null && !reports.isEmpty();
      case SLADslPackage.SLA__OWNER:
        return owner != null;
      case SLADslPackage.SLA__RESPONSIBLE:
        return responsible != null && !responsible.isEmpty();
      case SLADslPackage.SLA__BUDGETING:
        return budgeting != null;
      case SLADslPackage.SLA__SUBSCRIPTIONS:
        return subscriptions != null && !subscriptions.isEmpty();
      case SLADslPackage.SLA__TAGS:
        return tags != null && !tags.isEmpty();
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
    result.append(", effectiveDate: ");
    result.append(effectiveDate);
    result.append(", effectiveUntil: ");
    result.append(effectiveUntil);
    result.append(", preample: ");
    result.append(preample);
    result.append(", description: ");
    result.append(description);
    result.append(", scope: ");
    result.append(scope);
    result.append(", dataSecProtClause: ");
    result.append(dataSecProtClause);
    result.append(", restrictions: ");
    result.append(restrictions);
    result.append(", additionalServices: ");
    result.append(additionalServices);
    result.append(", cancellation: ");
    result.append(cancellation);
    result.append(", extraordinaryCancellation: ");
    result.append(extraordinaryCancellation);
    result.append(", effortAccounting: ");
    result.append(effortAccounting);
    result.append(')');
    return result.toString();
  }

} //SLAImpl
