package org.xkonnex.repo.dsl.basedsl.model;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

public class DelegatingEObject implements EObject {
	
	protected EObject delegate;
	
	public DelegatingEObject(EObject delegate) {
		this.delegate = delegate;
	}
	
	@Override
	public EList<Adapter> eAdapters() {
		return delegate.eAdapters();
	}

	@Override
	public boolean eDeliver() {
		return delegate.eDeliver();
	}

	@Override
	public void eSetDeliver(boolean deliver) {
		delegate.eSetDeliver(deliver);
	}

	@Override
	public void eNotify(Notification notification) {
		delegate.eNotify(notification);
	}

	@Override
	public EClass eClass() {
		return delegate.eClass();
	}

	@Override
	public Resource eResource() {
		return delegate.eResource();
	}

	@Override
	public EObject eContainer() {
		return delegate.eContainer();
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		return delegate.eContainingFeature();
	}

	@Override
	public EReference eContainmentFeature() {
		return delegate.eContainmentFeature();
	}

	@Override
	public EList<EObject> eContents() {
		return delegate.eContents();
	}

	@Override
	public TreeIterator<EObject> eAllContents() {
		return delegate.eAllContents();
	}

	@Override
	public boolean eIsProxy() {
		return delegate.eIsProxy();
	}

	@Override
	public EList<EObject> eCrossReferences() {
		return delegate.eCrossReferences();
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		return delegate.eGet(feature);
	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		return delegate.eGet(feature, resolve);
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		delegate.eSet(feature, newValue);
	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		return delegate.eIsSet(feature);
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
		delegate.eUnset(feature);
	}

	@Override
	public Object eInvoke(EOperation operation, EList<?> arguments)
			throws InvocationTargetException {
		return delegate.eInvoke(operation, arguments);
	}

}
