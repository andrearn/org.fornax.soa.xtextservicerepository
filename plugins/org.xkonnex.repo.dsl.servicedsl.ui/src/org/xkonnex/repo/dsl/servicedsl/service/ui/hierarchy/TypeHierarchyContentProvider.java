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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.basedsl.ui.hierarchy.EObjectDescriptionHierarchy;
import org.xkonnex.repo.dsl.basedsl.ui.hierarchy.IEObjDescrHierarchyLifeCycleListener;
import org.xkonnex.repo.dsl.basedsl.ui.hierarchy.IEObjectDescriptionHierarchyLifeCycle;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.BusinessObject;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceDslPackage;

import com.google.common.base.Predicate;
//import org.eclipse.jdt.core.Flags;
//import org.eclipse.jdt.core.IJavaElement;
//import org.eclipse.jdt.core.IMember;
//import org.eclipse.jdt.core.IMethod;
//import org.eclipse.jdt.core.IType;
//import org.eclipse.jdt.core.ITypeHierarchy;
//import org.eclipse.jdt.core.JavaModelException;
//
//import org.eclipse.jdt.internal.corext.util.JavaModelUtil;
//import org.eclipse.jdt.internal.corext.util.MethodOverrideTester;
import org.eclipse.jdt.ui.IWorkingCopyProvider;

/**
 * Base class for content providers for type hierarchy viewers.
 * Implementors must override 'getTypesInHierarchy'.
 * Java delta processing is also performed by the content provider
 */
public abstract class TypeHierarchyContentProvider implements ITreeContentProvider, IWorkingCopyProvider {
	protected static final Object[] NO_ELEMENTS= new Object[0];

	protected IEObjectDescriptionHierarchyLifeCycle fTypeHierarchy;
	protected Predicate<IEObjectDescription> fMemberFilter;

	protected TreeViewer fViewer;

	private ViewerFilter fWorkingSetFilter;
	private IEObjDescrHierarchyLifeCycleListener fTypeHierarchyLifeCycleListener;


	public TypeHierarchyContentProvider(IEObjectDescriptionHierarchyLifeCycle lifecycle) {
		fTypeHierarchy= lifecycle;
		fMemberFilter= null;
		fWorkingSetFilter= null;
		fTypeHierarchyLifeCycleListener= new IEObjDescrHierarchyLifeCycleListener() {
			public void hierarchyChanged(IEObjectDescriptionHierarchyLifeCycle typeHierarchyProvider, List<IEObjectDescription> changedTypes) {
				if (changedTypes == null) {
//					synchronized (this) {

//					}
				}
			}
		};
		lifecycle.addChangedListener(fTypeHierarchyLifeCycleListener);
	}

	/**
	 * Sets members to filter the hierarchy for. Set to <code>null</code> to disable member filtering.
	 * When member filtering is enabled, the hierarchy contains only types that contain
	 * an implementation of one of the filter members and the members themself.
	 * The hierarchy can be empty as well.
	 * @param filter the new member filter
	 */
	public final void setMemberFilter(Predicate<IEObjectDescription> filter) {
		fMemberFilter= filter;
	}



	/**
	 * The members to filter or <code>null</code> if member filtering is disabled.
	 * @return the member filter
	 */
	public Predicate<IEObjectDescription> getMemberFilter() {
		return fMemberFilter;
	}

	/**
	 * Sets a filter representing a working set or <code>null</code> if working sets are disabled.
	 * @param filter the filter
	 */
	public void setWorkingSetFilter(ViewerFilter filter) {
		fWorkingSetFilter= filter;
	}


	protected final EObjectDescriptionHierarchy getHierarchy() {
		return fTypeHierarchy.getHierarchy();
	}


	/* (non-Javadoc)
	 * @see IReconciled#providesWorkingCopies()
	 */
	public boolean providesWorkingCopies() {
		return true;
	}


	/*
	 * Called for the root element
	 * @see IStructuredContentProvider#getElements
	 */
	public Object[] getElements(Object parent) {
		ArrayList<IEObjectDescription> types= new ArrayList<IEObjectDescription>();
		getRootTypes(types);
		for (int i= types.size() - 1; i >= 0; i--) {
			IEObjectDescription curr= types.get(i);
			if (!isInTree(curr)) {
				types.remove(i);
			}
		}
		return types.toArray();
	}

	protected void getRootTypes(List<IEObjectDescription> res) {
		EObjectDescriptionHierarchy hierarchy= getHierarchy();
		if (hierarchy != null) {
			IEObjectDescription input= hierarchy.getRoot();
			if (input != null) {
				res.add(input);
			}
			// opened on a region: dont show
		}
	}

	/**
	 * Hook to overwrite. Filter will be applied on the returned types
	 * @param type the type
	 * @param res all types in the hierarchy of the given type
	 */
	protected abstract void getTypesInHierarchy(IEObjectDescription type, List<IEObjectDescription> res);

	/**
	 * Hook to overwrite. Return null if parent is ambiguous.
	 * @param type the type
	 * @return the parent type
	 */
	protected abstract IEObjectDescription getParentType(IEObjectDescription type);


	private boolean isInHierarchyOfInputElements(IEObjectDescription type) {
		if (fWorkingSetFilter != null && !fWorkingSetFilter.select(null, null, type)) {
			return false;
		}

		List<IEObjectDescription> input= fTypeHierarchy.getInputElements();
		if (input == null)
			return false;
		for (int i= 0; i < input.size(); i++) {
			
			EObject inputType= input.get(i).getEObjectOrProxy();
			if (inputType instanceof BusinessObject) {
				return true;
			}
			if (inputType instanceof org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception) {
				return true;
			}
			return true; //FIXME added this
		}
		return false;
	}

	/*
	 * Called for the tree children.
	 * @see ITreeContentProvider#getChildren
	 */
	public Object[] getChildren(Object element) {
		if (element instanceof IEObjectDescription) {
				IEObjectDescription type= (IEObjectDescription)element;

				List<IEObjectDescription> children= new ArrayList<IEObjectDescription>();
				if (fMemberFilter != null) {
					addFilteredMemberChildren(type, children);
				}

				addTypeChildren(type, children);

				return children.toArray();
		}
		return NO_ELEMENTS;
	}

	/*
	 * @see ITreeContentProvider#hasChildren
	 */
	public boolean hasChildren(Object element) {
		if (element instanceof IEObjectDescription) {
			IEObjectDescription type= (IEObjectDescription) element;
			return hasTypeChildren(type) || (fMemberFilter != null && hasMemberFilterChildren(type));
		}
		return false;
	}

	private void addFilteredMemberChildren(IEObjectDescription parent, List<IEObjectDescription> children) {
		//FIXME implement Predicate-based member filtering
//		for (int i= 0; i < fMemberFilter.length; i++) {
//			IEObjectDescription member= fMemberFilter[i];
//			if (parent.getEObjectOrProxy().equals(member.getEObjectOrProxy().eContainer())) {
//				if (!children.contains(member)) {
//					children.add(member);
//				}
//			}
//		}
	}

	private void addTypeChildren(IEObjectDescription type, List<IEObjectDescription> children) {
		ArrayList<IEObjectDescription> types= new ArrayList<IEObjectDescription>();
		getTypesInHierarchy(type, types);
		int len= types.size();
		for (int i= 0; i < len; i++) {
			IEObjectDescription curr= types.get(i);
			if (isInTree(curr)) {
				children.add(curr);
			}
		}
	}

	protected final boolean isInTree(IEObjectDescription type) {
		if (isInHierarchyOfInputElements(type)) {
			if (fMemberFilter != null) {
				return hasMemberFilterChildren(type) || hasTypeChildren(type);
			} else {
				return true;
			}
		}
		return hasTypeChildren(type);
	}

	private boolean hasMemberFilterChildren(IEObjectDescription type) {
//		for (int i= 0; i < fMemberFilter.length; i++) {
//			IEObjectDescription member= fMemberFilter[i];
//			if (type.getEObjectOrProxy().equals(member.getEObjectOrProxy().eContainer())) {
//				return true;
//			} else if (member instanceof IEObjectDescription) {
//				if (hasCompatibleMethod((IEObjectDescription) member, type)) {
//					return true;
//				}
//			}
//		}
		return true;
	}

	private boolean hasTypeChildren(IEObjectDescription type) {
		ArrayList<IEObjectDescription> types= new ArrayList<IEObjectDescription>();
		getTypesInHierarchy(type, types);
		int len= types.size();
		for (int i= 0; i < len; i++) {
			IEObjectDescription curr= types.get(i);
			if (isInTree(curr)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * @see IContentProvider#inputChanged
	 */
	public void inputChanged(Viewer part, Object oldInput, Object newInput) {
		Assert.isTrue(part instanceof TreeViewer);
		fViewer= (TreeViewer)part;
	}

	/*
	 * @see IContentProvider#dispose
	 */
	public void dispose() {
		fTypeHierarchy.removeChangedListener(fTypeHierarchyLifeCycleListener);

	}

	/*
	 * @see ITreeContentProvider#getParent
	 */
	public Object getParent(Object element) {
		if (element instanceof IEObjectDescription) {
			IEObjectDescription member= (IEObjectDescription) element;
			if (member.getEClass().equals(ServiceDslPackage.Literals.BUSINESS_OBJECT)) {
				return getParentType((IEObjectDescription)member);
			}
			return member.getEObjectOrProxy().eContainer();
		}
		return null;
	}


}
