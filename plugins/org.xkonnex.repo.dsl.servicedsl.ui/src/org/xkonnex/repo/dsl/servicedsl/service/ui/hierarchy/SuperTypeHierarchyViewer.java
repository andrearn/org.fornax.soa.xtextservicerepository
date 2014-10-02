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
 * A viewer including the content provider for the supertype hierarchy.
 * Used by the TypeHierarchyViewPart which has to provide a TypeHierarchyLifeCycle
 * on construction (shared type hierarchy)
 */
public class SuperTypeHierarchyViewer extends TypeHierarchyViewer {

	public SuperTypeHierarchyViewer(Composite parent, IEObjectDescriptionHierarchyLifeCycle lifeCycle) {
		super(parent, new SuperTypeHierarchyContentProvider(lifeCycle), lifeCycle);
	}

	/*
	 * @see TypeHierarchyViewer#updateContent
	 */
	@Override
	public void updateContent(boolean expand) {
		getTree().setRedraw(false);
		refresh();
		if (expand) {
			expandAll();
		}
		getTree().setRedraw(true);
	}

	/*
	 * Content provider for the supertype hierarchy
	 */
	public static class SuperTypeHierarchyContentProvider extends TypeHierarchyContentProvider {
		public SuperTypeHierarchyContentProvider(IEObjectDescriptionHierarchyLifeCycle lifeCycle) {
			super(lifeCycle);
		}

		@Override
		protected final void getTypesInHierarchy(IEObjectDescription element, List<IEObjectDescription> res) {
			EObjectDescriptionHierarchy hierarchy= getHierarchy();
			if (hierarchy != null) {
				IEObjectDescription types= hierarchy.getParent(element);
				res.add(types);
			}
		}

		@Override
		protected IEObjectDescription getParentType(IEObjectDescription type) {
			// cant handle
			return null;
		}

	}

}
