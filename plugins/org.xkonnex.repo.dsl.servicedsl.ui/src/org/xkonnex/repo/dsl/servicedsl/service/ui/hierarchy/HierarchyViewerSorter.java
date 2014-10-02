package org.xkonnex.repo.dsl.servicedsl.service.ui.hierarchy;
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

import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.basedsl.ui.hierarchy.AbstractHierarchyViewerSorter;
import org.xkonnex.repo.dsl.basedsl.ui.hierarchy.EObjectDescriptionHierarchy;
import org.xkonnex.repo.dsl.basedsl.ui.hierarchy.IEObjectDescriptionHierarchyLifeCycle;

/**
  */
public class HierarchyViewerSorter extends AbstractHierarchyViewerSorter {

	private final IEObjectDescriptionHierarchyLifeCycle fHierarchy;
	private boolean fSortByDefiningType;

	public HierarchyViewerSorter(IEObjectDescriptionHierarchyLifeCycle cycle) {
		fHierarchy= cycle;
	}

	public void setSortByDefiningType(boolean sortByDefiningType) {
		fSortByDefiningType= sortByDefiningType;
	}

	@Override
	public boolean isSortByDefiningType() {
		return fSortByDefiningType;
	}

	@Override
	public boolean isSortAlphabetically() {
		return true;
	}

	@Override
	protected EObjectDescriptionHierarchy getHierarchy(IEObjectDescription type) {
		return fHierarchy.getHierarchy(); // hierarchy contains all types shown
	}

}
