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

import org.fornax.soa.semanticsDsl.Tag;

import org.fornax.soa.solutionDsl.Feature;
import org.fornax.soa.solutionDsl.Module;
import org.fornax.soa.solutionDsl.ModuleKind;
import org.fornax.soa.solutionDsl.ServiceRef;
import org.fornax.soa.solutionDsl.SolutionDslPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.ModuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.ModuleImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.ModuleImpl#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.ModuleImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.ModuleImpl#getModules <em>Modules</em>}</li>
 *   <li>{@link org.fornax.soa.solutionDsl.impl.ModuleImpl#getTags <em>Tags</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModuleImpl extends MinimalEObjectImpl.Container implements Module
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
   * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected static final ModuleKind KIND_EDEFAULT = ModuleKind.UI;

  /**
   * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected ModuleKind kind = KIND_EDEFAULT;

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
  protected ModuleImpl()
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
    return SolutionDslPackage.Literals.MODULE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, SolutionDslPackage.MODULE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModuleKind getKind()
  {
    return kind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKind(ModuleKind newKind)
  {
    ModuleKind oldKind = kind;
    kind = newKind == null ? KIND_EDEFAULT : newKind;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, SolutionDslPackage.MODULE__KIND, oldKind, kind));
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
      requires = new EObjectContainmentEList<ServiceRef>(ServiceRef.class, this, SolutionDslPackage.MODULE__REQUIRES);
    }
    return requires;
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
      features = new EObjectContainmentEList<Feature>(Feature.class, this, SolutionDslPackage.MODULE__FEATURES);
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
      modules = new EObjectContainmentEList<Module>(Module.class, this, SolutionDslPackage.MODULE__MODULES);
    }
    return modules;
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
      tags = new EObjectResolvingEList<Tag>(Tag.class, this, SolutionDslPackage.MODULE__TAGS);
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
      case SolutionDslPackage.MODULE__REQUIRES:
        return ((InternalEList<?>)getRequires()).basicRemove(otherEnd, msgs);
      case SolutionDslPackage.MODULE__FEATURES:
        return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
      case SolutionDslPackage.MODULE__MODULES:
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
      case SolutionDslPackage.MODULE__NAME:
        return getName();
      case SolutionDslPackage.MODULE__KIND:
        return getKind();
      case SolutionDslPackage.MODULE__REQUIRES:
        return getRequires();
      case SolutionDslPackage.MODULE__FEATURES:
        return getFeatures();
      case SolutionDslPackage.MODULE__MODULES:
        return getModules();
      case SolutionDslPackage.MODULE__TAGS:
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
      case SolutionDslPackage.MODULE__NAME:
        setName((String)newValue);
        return;
      case SolutionDslPackage.MODULE__KIND:
        setKind((ModuleKind)newValue);
        return;
      case SolutionDslPackage.MODULE__REQUIRES:
        getRequires().clear();
        getRequires().addAll((Collection<? extends ServiceRef>)newValue);
        return;
      case SolutionDslPackage.MODULE__FEATURES:
        getFeatures().clear();
        getFeatures().addAll((Collection<? extends Feature>)newValue);
        return;
      case SolutionDslPackage.MODULE__MODULES:
        getModules().clear();
        getModules().addAll((Collection<? extends Module>)newValue);
        return;
      case SolutionDslPackage.MODULE__TAGS:
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
      case SolutionDslPackage.MODULE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case SolutionDslPackage.MODULE__KIND:
        setKind(KIND_EDEFAULT);
        return;
      case SolutionDslPackage.MODULE__REQUIRES:
        getRequires().clear();
        return;
      case SolutionDslPackage.MODULE__FEATURES:
        getFeatures().clear();
        return;
      case SolutionDslPackage.MODULE__MODULES:
        getModules().clear();
        return;
      case SolutionDslPackage.MODULE__TAGS:
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
      case SolutionDslPackage.MODULE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case SolutionDslPackage.MODULE__KIND:
        return kind != KIND_EDEFAULT;
      case SolutionDslPackage.MODULE__REQUIRES:
        return requires != null && !requires.isEmpty();
      case SolutionDslPackage.MODULE__FEATURES:
        return features != null && !features.isEmpty();
      case SolutionDslPackage.MODULE__MODULES:
        return modules != null && !modules.isEmpty();
      case SolutionDslPackage.MODULE__TAGS:
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
    result.append(", kind: ");
    result.append(kind);
    result.append(')');
    return result.toString();
  }

} //ModuleImpl
