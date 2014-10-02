package org.xkonnex.repo.dsl.basedsl.ui.hierarchy;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.inject.Injector;

public interface IEObjectDescriptionHierarchyLifeCycle {

	public abstract EObjectDescriptionHierarchy getHierarchy();

	/**
	 * Returns the array of input elements.
	 * 
	 * @return the input elements
	 */
	public abstract List<IEObjectDescription> getInputElements();

	public abstract void freeHierarchy();

	public abstract void removeChangedListener(
			IEObjDescrHierarchyLifeCycleListener listener);

	public abstract void addChangedListener(
			IEObjDescrHierarchyLifeCycleListener listener);

	/**
	 * Refreshes the type hierarchy for the java element if it exists.
	 *
	 * @param element the java element for which the type hierarchy is computed
	 * @param context the runnable context
	 * @throws InterruptedException thrown from the <code>OperationCanceledException</code> when the monitor is canceled
	 * @throws InvocationTargetException thrown from the <code>JavaModelException</code> if the java element does not exist or if an exception occurs while accessing its corresponding resource
	 */
	public abstract void ensureRefreshedTypeHierarchy(
			final IEObjectDescription element, IRunnableContext context)
			throws InvocationTargetException, InterruptedException;

	/**
	 * Refreshes the type hierarchy for the java elements if they exist.
	 * 
	 * @param elements the java elements for which the type hierarchy is computed
	 * @param context the runnable context
	 * @throws InterruptedException thrown from the <code>OperationCanceledException</code> when the monitor is canceled
	 * @throws InvocationTargetException thrown from the <code>JavaModelException</code> if a java element does not exist or if an exception occurs while accessing its corresponding resource
	 * @since 3.7
	 */
	public abstract void ensureRefreshedTypeHierarchy(
			final List<IEObjectDescription> elements, IRunnableContext context)
			throws InvocationTargetException, InterruptedException;

	/**
	 * Returns <code>true</code> if the refresh job is running, <code>false</code> otherwise.
	 * 
	 * @return <code>true</code> if the refresh job is running, <code>false</code> otherwise
	 * 
	 * @since 3.6
	 */
	public abstract boolean isRefreshJobRunning();

	public abstract void doHierarchyRefresh(List<IEObjectDescription> elements,
			IProgressMonitor pm);

	/*
	 * @see ITypeHierarchyChangedListener#typeHierarchyChanged
	 */
	public abstract void hierarchyChanged(
			EObjectDescriptionHierarchy typeHierarchy);

	public abstract Injector getInjector();

	public abstract void setInjector(Injector injector);

}