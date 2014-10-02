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
package org.xkonnex.repo.dsl.servicedsl.service.ui.hierarchy;

import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.basedsl.ui.hierarchy.EObjectDescriptionHierarchy;
import org.xkonnex.repo.dsl.basedsl.ui.hierarchy.IEObjectDescriptionHierarchyLifeCycle;

/**
 * A viewer including the content provider for the subtype hierarchy.
 * Used by the TypeHierarchyViewPart which has to provide a EObjectDescriptionHierarchyLifeCycle
 * on construction (shared type hierarchy)
 */
public class SubTypeHierarchyViewer extends TypeHierarchyViewer {

	public SubTypeHierarchyViewer(Composite parent, IEObjectDescriptionHierarchyLifeCycle lifeCycle) {
		super(parent, new SubTypeHierarchyContentProvider(lifeCycle), lifeCycle);
	}

	/*
	 * @see TypeHierarchyViewer#updateContent
	 */
	@Override
	public void updateContent(boolean expand) {
		getTree().setRedraw(false);
		refresh();

		if (expand) {
			int expandLevel= 2;
			if (isMethodFiltering()) {
				expandLevel++;
			}
			expandToLevel(expandLevel);
		}
		getTree().setRedraw(true);
	}

	/**
	 * Content provider for the subtype hierarchy
	 */
	public static class SubTypeHierarchyContentProvider extends TypeHierarchyContentProvider {
		public SubTypeHierarchyContentProvider(IEObjectDescriptionHierarchyLifeCycle lifeCycle) {
			super(lifeCycle);
		}

		@Override
		protected final void getTypesInHierarchy(IEObjectDescription type, List<IEObjectDescription> res) {
			EObjectDescriptionHierarchy hierarchy= getHierarchy();
			if (hierarchy != null) {
				List<IEObjectDescription> children = hierarchy.getChildren(type);
				if (children != null)
					res.addAll(children);
			}
		}

		@Override
		protected IEObjectDescription getParentType(IEObjectDescription type) {
			EObjectDescriptionHierarchy hierarchy= getHierarchy();
			if (hierarchy != null) {
				return hierarchy.getParent(type);
			}
			return null;
		}

	}

}
