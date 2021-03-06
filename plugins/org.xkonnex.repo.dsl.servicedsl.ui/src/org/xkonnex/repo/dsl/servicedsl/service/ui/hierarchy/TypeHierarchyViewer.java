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
package org.xkonnex.repo.dsl.servicedsl.service.ui.hierarchy;/*******************************************************************************

 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.basedsl.ui.hierarchy.IEObjectDescriptionHierarchyLifeCycle;
import org.xkonnex.repo.dsl.servicedsl.ui.internal.ServiceDslCustomActivator;
import org.xkonnex.repo.dsl.servicedsl.ui.internal.ServicedslActivator;

import com.google.common.base.Predicate;
import com.google.inject.Injector;

public abstract class TypeHierarchyViewer extends TreeViewer {

	private HierarchyLabelProvider fLabelProvider;


	public TypeHierarchyViewer(Composite parent, IContentProvider contentProvider, IEObjectDescriptionHierarchyLifeCycle lifeCycle) {
		super(new Tree(parent, SWT.SINGLE));

		Injector injector = ServiceDslCustomActivator.getInstance().getInjector(ServicedslActivator.ORG_XKONNEX_REPO_DSL_SERVICEDSL_SERVICEDSL);
		fLabelProvider=injector.getInstance(HierarchyLabelProvider.class);

		setLabelProvider(fLabelProvider);
		setUseHashlookup(true);

		setContentProvider(contentProvider);
		setComparator(new HierarchyViewerSorter(lifeCycle));

	}

	public void setQualifiedTypeName(boolean on) {
		fLabelProvider.setUseQualfiedNames(on);
		refresh();
	}

	/**
	 * Attaches a context menu listener to the tree.
	 *
	 * @param menuListener the menu listener
	 * @param popupId the popup id
	 * @param viewSite the view site
	 */
	public void initContextMenu(IMenuListener menuListener, String popupId, IWorkbenchPartSite viewSite) {
		MenuManager menuMgr= new MenuManager();
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(menuListener);
		Menu menu= menuMgr.createContextMenu(getTree());
		getTree().setMenu(menu);
		viewSite.registerContextMenu(popupId, menuMgr, this);
	}

	/**
	 * Fills up the context menu with items for the hierarchy viewer
	 * Should be called by the creator of the context menu
	 * @param menu the menu manager
	 */
	public void contributeToContextMenu(IMenuManager menu) {
	}

	/**
	 * Set the member filter
	 * @param filter the member filters to set
	 */
	public void setMemberFilter(Predicate<IEObjectDescription> filter) {
		TypeHierarchyContentProvider contentProvider= getHierarchyContentProvider();
		if (contentProvider != null) {
			contentProvider.setMemberFilter(filter);
		}
	}

	/**
	 * Returns if method filtering is enabled.
	 * @return <code>true</code>if method filtering is enabled.
	 */
	public boolean isMethodFiltering() {
		TypeHierarchyContentProvider contentProvider= getHierarchyContentProvider();
		if (contentProvider != null) {
			return contentProvider.getMemberFilter() != null;
		}
		return false;
	}

	public void setWorkingSetFilter(ViewerFilter filter) {
		//FIXME Does the LabelProvider need a filter
//		fLabelProvider.setFilter(filter);
		TypeHierarchyContentProvider contentProvider= getHierarchyContentProvider();
		if (contentProvider != null) {
			contentProvider.setWorkingSetFilter(filter);
		}
	}

	/**
	 * Returns true if the hierarchy contains elements. Returns one of them
	 * With member filtering it is possible that no elements are visible
	 * @return one of the elements contained
	 */
	public Object containsElements() {
		TypeHierarchyContentProvider contentProvider= getHierarchyContentProvider();
		if (contentProvider != null) {
			Object[] elements= contentProvider.getElements(null);
			if (elements.length > 0) {
				return elements[0];
			}
		}
		return null;
	}

	/**
	 * Returns true if the hierarchy contains elements. Returns one of them
	 * With member filtering it is possible that no elements are visible
	 * @return the tree root
	 */
	public IEObjectDescription getTreeRootType() {
		TypeHierarchyContentProvider contentProvider= getHierarchyContentProvider();
		if (contentProvider != null) {
			Object[] elements=  contentProvider.getElements(null);
			if (elements.length > 0 && elements[0] instanceof IEObjectDescription) {
				return (IEObjectDescription) elements[0];
			}
		}
		return null;
	}

	/**
	 * Returns true if the hierarchy contains element the element.
	 * @param element the element
	 * @return <code>true</code> if element is shown
	 */
	public boolean isElementShown(Object element) {
		return findItem(element) != null;
	}

	/**
	 * Updates the content of this viewer: refresh and expanding the tree in the way wanted.
	 * @param doExpand if set, update should expand
	 */
	public abstract void updateContent(boolean doExpand);

	/*
	 * @see StructuredViewer#setContentProvider
	 * Content provider must be of type TypeHierarchyContentProvider
	 */
	@Override
	public void setContentProvider(IContentProvider cp) {
		Assert.isTrue(cp instanceof TypeHierarchyContentProvider);
		super.setContentProvider(cp);
	}

	protected TypeHierarchyContentProvider getHierarchyContentProvider() {
		return (TypeHierarchyContentProvider)getContentProvider();
	}

}
