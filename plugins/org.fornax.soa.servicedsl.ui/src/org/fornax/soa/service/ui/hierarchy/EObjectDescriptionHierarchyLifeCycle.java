/*******************************************************************************
 * Copyright (c) 2000, 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     André Arnold	   - deliberately  copied from JDT and adapted to 
 *     					 IEObjectDescriptions
 *******************************************************************************/
package org.fornax.soa.service.ui.hierarchy;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.progress.IWorkbenchSiteProgressService;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.resource.IEObjectDescriptionBuilder;
import org.fornax.soa.basedsl.ui.hierarchy.EObjectDescriptionHierarchy;
import org.fornax.soa.basedsl.ui.hierarchy.IEObjDescrHierarchyLifeCycleListener;
import org.fornax.soa.basedsl.ui.hierarchy.IEObjectDescrHierarchyChangedListener;
import org.fornax.soa.basedsl.ui.hierarchy.IEObjectDescriptionHierarchyLifeCycle;
import org.fornax.soa.basedsl.util.TreeNode;
import org.fornax.soa.service.query.type.BusinessObjectQueries;
import org.fornax.soa.service.query.type.BusinessObjectQueryInternal;
import org.fornax.soa.service.ui.hierarchy.TypeHierarchyViewPart;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.ServiceDslPackage;

import com.google.common.collect.Lists;
import com.google.inject.Injector;

/**
 * Manages a type hierarchy, to keep it refreshed, and to allow it to be shared.
 */
public class EObjectDescriptionHierarchyLifeCycle implements IEObjectDescrHierarchyChangedListener, IEObjectDescriptionHierarchyLifeCycle {
	
	private Injector injector;

	private boolean fHierarchyRefreshNeeded;
	private EObjectDescriptionHierarchy fHierarchy;
	private List<IEObjectDescription> fInputElements;
	private boolean fIsSuperTypesOnly;

	private List<IEObjDescrHierarchyLifeCycleListener> fChangeListeners;

	/**
	 * The type hierarchy view part.
	 *
	 * @since 3.6
	 */
	private TypeHierarchyViewPart fTypeHierarchyViewPart;

	/**
	 * The job that runs in the background to refresh the type hierarchy.
	 *
	 * @since 3.6
	 */
	private Job fRefreshHierarchyJob;

	/**
	 * Indicates whether the refresh job was canceled explicitly.
	 * 
	 * @since 3.6
	 */
	private boolean fRefreshJobCanceledExplicitly= true;

	/**
	 * Creates the type hierarchy life cycle.
	 *
	 * @param part the type hierarchy view part
	 * @since 3.6
	 */
	public EObjectDescriptionHierarchyLifeCycle(TypeHierarchyViewPart part) {
		this(false);
		fTypeHierarchyViewPart= part;
		fRefreshHierarchyJob= null;
	}

	public EObjectDescriptionHierarchyLifeCycle(boolean isSuperTypesOnly) {
		fHierarchy= null;
		fInputElements= null;
		fIsSuperTypesOnly= isSuperTypesOnly;
		fChangeListeners= new ArrayList<IEObjDescrHierarchyLifeCycleListener>(2);
	}

	/* (non-Javadoc)
	 * @see org.fornax.soa.service.ui.hierarchy.IEObjectDescriptionHierarchyLifeCycle#getHierarchy()
	 */
	public EObjectDescriptionHierarchy getHierarchy() {
		return fHierarchy;
	}

	/* (non-Javadoc)
	 * @see org.fornax.soa.service.ui.hierarchy.IEObjectDescriptionHierarchyLifeCycle#getInputElements()
	 */
	public List<IEObjectDescription> getInputElements() {
		return fInputElements;
	}


	/* (non-Javadoc)
	 * @see org.fornax.soa.service.ui.hierarchy.IEObjectDescriptionHierarchyLifeCycle#freeHierarchy()
	 */
	public void freeHierarchy() {
		if (fHierarchy != null) {
//			fHierarchy.removeHierarchyChangedListener(this);
//			JavaCore.removeElementChangedListener(this);
			fHierarchy= null;
			fInputElements= null;
		}
//		synchronized (this) {
//			if (fRefreshHierarchyJob != null) {
//				fRefreshHierarchyJob.cancel();
//				fRefreshHierarchyJob= null;
//			}
//		}
	}

	/* (non-Javadoc)
	 * @see org.fornax.soa.service.ui.hierarchy.IEObjectDescriptionHierarchyLifeCycle#removeChangedListener(org.fornax.soa.basedsl.ui.hierarchy.IEObjDescrHierarchyLifeCycleListener)
	 */
	public void removeChangedListener(IEObjDescrHierarchyLifeCycleListener listener) {
		fChangeListeners.remove(listener);
	}

	/* (non-Javadoc)
	 * @see org.fornax.soa.service.ui.hierarchy.IEObjectDescriptionHierarchyLifeCycle#addChangedListener(org.fornax.soa.basedsl.ui.hierarchy.IEObjDescrHierarchyLifeCycleListener)
	 */
	public void addChangedListener(IEObjDescrHierarchyLifeCycleListener listener) {
		if (!fChangeListeners.contains(listener)) {
			fChangeListeners.add(listener);
		}
	}

	private void fireChange(List<IEObjectDescription> changedTypes) {
		for (int i= fChangeListeners.size()-1; i>=0; i--) {
			IEObjDescrHierarchyLifeCycleListener curr= fChangeListeners.get(i);
			curr.hierarchyChanged(this, changedTypes);
		}
	}

	/* (non-Javadoc)
	 * @see org.fornax.soa.service.ui.hierarchy.IEObjectDescriptionHierarchyLifeCycle#ensureRefreshedTypeHierarchy(org.eclipse.xtext.resource.IEObjectDescription, org.eclipse.jface.operation.IRunnableContext)
	 */
	public void ensureRefreshedTypeHierarchy(final IEObjectDescription element, IRunnableContext context) throws InvocationTargetException, InterruptedException {
		ensureRefreshedTypeHierarchy(Lists.newArrayList(element), context);
	}

	/* (non-Javadoc)
	 * @see org.fornax.soa.service.ui.hierarchy.IEObjectDescriptionHierarchyLifeCycle#ensureRefreshedTypeHierarchy(java.util.List, org.eclipse.jface.operation.IRunnableContext)
	 */
	public void ensureRefreshedTypeHierarchy(final List<IEObjectDescription> elements, IRunnableContext context) throws InvocationTargetException, InterruptedException {
		synchronized (this) {
			if (fRefreshHierarchyJob != null) {
				fRefreshHierarchyJob.cancel();
				fRefreshJobCanceledExplicitly= false;
				try {
					fRefreshHierarchyJob.join();
				} catch (InterruptedException e) {
					// ignore
				} finally {
					fRefreshHierarchyJob= null;
					fRefreshJobCanceledExplicitly= true;
				}
			}
		}
		if (elements == null || elements.size() == 0) {
			freeHierarchy();
			return;
		}
		for (int i= 0; i < elements.size(); i++) {
			if (elements.get(i) == null) {
				freeHierarchy();
				return;
			}
		}
		boolean hierachyCreationNeeded= true; /*(fHierarchy == null || !Arrays.equals(elements, fInputElements))*/;

		if (hierachyCreationNeeded || fHierarchyRefreshNeeded) {
			if (fTypeHierarchyViewPart == null) {
				IRunnableWithProgress op= new IRunnableWithProgress() {
					public void run(IProgressMonitor pm) throws InvocationTargetException, InterruptedException {
						try {
							doHierarchyRefresh(elements, pm);
						} catch (OperationCanceledException e) {
							throw new InterruptedException();
						}
					}
				};
				fHierarchyRefreshNeeded= true;
				context.run(true, true, op);
				fHierarchyRefreshNeeded= false;
			} else {
				final String label= "";//Messages.format(TypeHierarchyMessages.TypeHierarchyLifeCycle_computeInput, HistoryAction.getElementLabel(elements));
				synchronized (this) {
					fRefreshHierarchyJob= new Job(label) {
						/*
						 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
						 */
						@Override
						public IStatus run(IProgressMonitor pm) {
							pm.beginTask(label, LONG);
							try {
								doHierarchyRefreshBackground(elements, pm);
							} catch (OperationCanceledException e) {
								if (fRefreshJobCanceledExplicitly) {
									fTypeHierarchyViewPart.showEmptyViewer();
								}
								return Status.CANCEL_STATUS;
							} finally {
								fHierarchyRefreshNeeded= true;
								pm.done();
							}
							return Status.OK_STATUS;
						}
					};
					fRefreshHierarchyJob.setUser(true);
					IWorkbenchSiteProgressService progressService= (IWorkbenchSiteProgressService)fTypeHierarchyViewPart.getSite()
														.getAdapter(IWorkbenchSiteProgressService.class);
					progressService.schedule(fRefreshHierarchyJob, 0);
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.fornax.soa.service.ui.hierarchy.IEObjectDescriptionHierarchyLifeCycle#isRefreshJobRunning()
	 */
	public boolean isRefreshJobRunning() {
		return fRefreshHierarchyJob != null;
	}

	/**
	 * Refreshes the hierarchy in the background and updates the hierarchy viewer asynchronously in
	 * the UI thread.
	 * 
	 * @param elements the java elements on which the hierarchy is computed
	 * @param pm the progress monitor
	 * 
	 * @since 3.6
	 */
	protected void doHierarchyRefreshBackground(final List<IEObjectDescription> elements, final IProgressMonitor pm) {
		doHierarchyRefresh(elements, pm);
		if (!pm.isCanceled()) {
			Display.getDefault().asyncExec(new Runnable() {
				/*
				 * @see java.lang.Runnable#run()
				 */
				public void run() {
					synchronized (EObjectDescriptionHierarchyLifeCycle.this) {
						if (fRefreshHierarchyJob == null) {
							return;
						}
						fRefreshHierarchyJob= null;
					}
					if (pm.isCanceled())
						return;
					fTypeHierarchyViewPart.setViewersInput();
					fTypeHierarchyViewPart.updateViewers();
				}
			});
		}
	}

	private EObjectDescriptionHierarchy createHierarchy(List<IEObjectDescription> elements, IProgressMonitor pm) {
		IEObjectDescriptionBuilder descBuilder = injector.getInstance(IEObjectDescriptionBuilder.class);
		if (elements.size() == 1 && ServiceDslPackage.Literals.BUSINESS_OBJECT.equals(elements.get(0).getEClass())) {
			IEObjectDescription type= (IEObjectDescription)elements.get(0);
			BusinessObject queryBO = (BusinessObject)type.getEObjectOrProxy();
			if (fIsSuperTypesOnly) {
				return null; //type.newSupertypeHierarchy(pm);
			} else {
				BusinessObjectQueries boQuery = injector.getInstance(BusinessObjectQueries.class);
				BusinessObject rootBO = boQuery.getRootBusinessObject(queryBO);
				List<TreeNode<IEObjectDescription>> allSubTypes = boQuery.getAllSubTypes(rootBO, rootBO.eResource().getResourceSet());
				TreeNode<IEObjectDescription> rootBODesc = new TreeNode<IEObjectDescription>(descBuilder.buildDescription(rootBO));
				rootBODesc.setChildren(allSubTypes);
				return new EObjectDescriptionHierarchy(rootBODesc, pm);
			}
		} else if (elements.size() == 1 && ServiceDslPackage.Literals.EXCEPTION.equals(elements.get(0).getEClass())) {
			IEObjectDescription type= (IEObjectDescription)elements.get(0);
			if (fIsSuperTypesOnly) {
				return null; //type.newSupertypeHierarchy(pm);
			} else {
				return null; //type.newTypeHierarchy(pm);
			}
		}
			
		return null;
	}


	/* (non-Javadoc)
	 * @see org.fornax.soa.service.ui.hierarchy.IEObjectDescriptionHierarchyLifeCycle#doHierarchyRefresh(java.util.List, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void doHierarchyRefresh(List<IEObjectDescription> elements, IProgressMonitor pm) {
		boolean hierachyCreationNeeded= (fHierarchy == null /* || !Arrays.equals(elements, fInputElements) */);
		// to ensure the order of the two listeners always remove / add listeners on operations
		// on type hierarchies
		if (fHierarchy != null) {
//			fHierarchy.removeHierarchyChangedListener(this);
//			JavaCore.removeElementChangedListener(this);
		}
//		if (hierachyCreationNeeded) {
			fHierarchy= createHierarchy(elements, pm);
			if (pm != null && pm.isCanceled()) {
				throw new OperationCanceledException();
			}
			fInputElements= elements;
//		} else {
//			fHierarchy.refresh(pm);
//			if (pm != null && pm.isCanceled())
//				throw new OperationCanceledException();
//		}
//		fHierarchy.addHierarchyChangedListener(this);
//		JavaCore.addElementChangedListener(this);
		fHierarchyRefreshNeeded= false;
	}

	/*
	 * @see ITypeHierarchyChangedListener#typeHierarchyChanged
	 */
	/* (non-Javadoc)
	 * @see org.fornax.soa.service.ui.hierarchy.IEObjectDescriptionHierarchyLifeCycle#hierarchyChanged(org.fornax.soa.basedsl.ui.hierarchy.EObjectDescriptionHierarchy)
	 */
	public void hierarchyChanged(EObjectDescriptionHierarchy typeHierarchy) {
	 	fHierarchyRefreshNeeded= true;
 		fireChange(null);
	}

	/* (non-Javadoc)
	 * @see org.fornax.soa.service.ui.hierarchy.IEObjectDescriptionHierarchyLifeCycle#getInjector()
	 */
	public Injector getInjector() {
		return injector;
	}

	/* (non-Javadoc)
	 * @see org.fornax.soa.service.ui.hierarchy.IEObjectDescriptionHierarchyLifeCycle#setInjector(com.google.inject.Injector)
	 */
	public void setInjector(Injector injector) {
		this.injector = injector;
	}

}
