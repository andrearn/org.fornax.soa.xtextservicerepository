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

import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.ui.hierarchy.EObjectDescriptionHierarchy;
import org.fornax.soa.basedsl.ui.hierarchy.IEObjectDescriptionHierarchyLifeCycle;

/**
 * A TypeHierarchyViewer that looks like the type hierarchy view of VA/Java:
 * Starting form Object down to the element in focus, then all subclasses from
 * this element.
 * Used by the TypeHierarchyViewPart which has to provide a TypeHierarchyLifeCycle
 * on construction (shared type hierarchy)
 */
public class TraditionalHierarchyViewer extends TypeHierarchyViewer {

	public TraditionalHierarchyViewer(Composite parent, IEObjectDescriptionHierarchyLifeCycle lifeCycle) {
		super(parent, new TraditionalHierarchyContentProvider(lifeCycle), lifeCycle);
	}

	/*
	 * @see TypeHierarchyViewer#updateContent
	 */
	@Override
	public void updateContent(boolean expand) {
		getTree().setRedraw(false);
		refresh();

		if (expand) {
			TraditionalHierarchyContentProvider contentProvider= (TraditionalHierarchyContentProvider) getContentProvider();
			int expandLevel= contentProvider.getExpandLevel();
			if (isMethodFiltering()) {
				expandLevel++;
			}
			expandToLevel(expandLevel);
		}
		getTree().setRedraw(true);
	}

	/**
	 * Content provider for the 'traditional' type hierarchy.
	 */
	public static class TraditionalHierarchyContentProvider extends TypeHierarchyContentProvider {


		public TraditionalHierarchyContentProvider(IEObjectDescriptionHierarchyLifeCycle provider) {
			super(provider);
		}

		public int getExpandLevel() {
			EObjectDescriptionHierarchy hierarchy= getHierarchy();
//			if (hierarchy != null) {
//				//FIXME hierarchy depth expansion
//				IEObjectDescription input= hierarchy.getType();
//				if (input != null) {
//					return getDepth(hierarchy, input) + 2;
//				} else {
//					return 5;
//				}
//			}
			return 2;
		}

		private int getDepth(EObjectDescriptionHierarchy hierarchy, IEObjectDescription input) {
			int count= 0;
			IEObjectDescription superType= hierarchy.getParent(input);
			while (superType != null) {
				count++;
				superType= hierarchy.getParent(superType);
			}
			return count;
		}

		protected final void getRootTypes(List<IEObjectDescription> res) {
			EObjectDescriptionHierarchy hierarchy= getHierarchy();
			if (hierarchy != null) {
				IEObjectDescription root = hierarchy.getRoot();
				res.add(root);
			}
		}

		/*
		 * @see TypeHierarchyContentProvider.getTypesInHierarchy
		 */
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
