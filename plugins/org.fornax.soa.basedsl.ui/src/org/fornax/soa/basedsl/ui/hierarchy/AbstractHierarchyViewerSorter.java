package org.fornax.soa.basedsl.ui.hierarchy;
/*******************************************************************************
 * Copyright (c) 2000, 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.search.IEObjectLookup;


/**
  */
public abstract class AbstractHierarchyViewerSorter extends ViewerComparator {


	private IEObjectLookup lookup;

	public AbstractHierarchyViewerSorter() {
	}

	protected abstract EObjectDescriptionHierarchy getHierarchy(IEObjectDescription type);
	public abstract boolean isSortByDefiningType();
	public abstract boolean isSortAlphabetically();


	protected int getTypeFlags(IEObjectDescription type) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ViewerSorter#category(java.lang.Object)
	 */
	@Override
	public int category(Object element) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ViewerSorter#compare(null, null, null)
	 */
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		return 0;
	}



	private int compareInHierarchy(IEObjectDescription def1, IEObjectDescription def2) {
		return getComparator().compare(def1.getName(), def2.getName());
	}


}
