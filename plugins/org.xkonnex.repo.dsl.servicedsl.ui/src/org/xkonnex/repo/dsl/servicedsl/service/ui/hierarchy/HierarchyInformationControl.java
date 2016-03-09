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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.keys.KeySequence;
import org.eclipse.ui.keys.SWTKeySupport;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.basedsl.resource.IEObjectDescriptionBuilder;
import org.xkonnex.repo.dsl.basedsl.ui.hierarchy.EObjectDescriptionHierarchy;
import org.xkonnex.repo.dsl.basedsl.ui.hierarchy.IEObjectDescriptionHierarchyLifeCycle;
import org.xkonnex.repo.dsl.servicedsl.service.ui.hierarchy.SuperTypeHierarchyViewer.SuperTypeHierarchyContentProvider;
import org.xkonnex.repo.dsl.servicedsl.service.ui.hierarchy.TraditionalHierarchyViewer.TraditionalHierarchyContentProvider;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Property;
import org.xkonnex.repo.dsl.servicedsl.ui.internal.Messages;
import org.xkonnex.repo.dsl.servicedsl.ui.internal.ServiceDslCustomActivator;
import org.xkonnex.repo.dsl.servicedsl.ui.internal.ServicedslActivator;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.inject.Injector;

/**
 * Show hierarchy in light-weight control.
 *
 * @since 1.6
 */
public class HierarchyInformationControl extends org.xkonnex.repo.dsl.servicedsl.service.ui.hierarchy.AbstractInformationControl {

	private IWorkbench workbench;
	
	private IQualifiedNameProvider nameProvider;
	
	private IEObjectDescriptionBuilder ieDescBuilder;

	private IEObjectDescriptionHierarchyLifeCycle fLifeCycle;
	private HierarchyLabelProvider fLabelProvider;
	private KeyAdapter fKeyAdapter;

	private Object[] fOtherExpandedElements;
	private TypeHierarchyContentProvider fOtherContentProvider;

	private boolean fDoFilter;


	private Object locked;

	public HierarchyInformationControl(Shell parent, int shellStyle, int treeStyle, Injector injector) {
		super(parent, shellStyle, treeStyle, "org.xkonnex.repo.dsl.semanticsdsl.ServiceDsl.ui.hierarchy.QuickTypeHierarchy"/*IJavaEditorActionDefinitionIds.OPEN_HIERARCHY*/, true);
		fOtherExpandedElements= null;
		fDoFilter= true;
		this.injector = injector;
		workbench = injector.getInstance(IWorkbench.class);
		nameProvider = injector.getInstance(IQualifiedNameProvider.class);
		ieDescBuilder = injector.getInstance(IEObjectDescriptionBuilder.class);
		if (fLifeCycle != null)
			fLifeCycle.setInjector(injector);
	}

	private KeyAdapter getKeyAdapter() {
		if (fKeyAdapter == null) {
			fKeyAdapter= new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					int accelerator = SWTKeySupport.convertEventToUnmodifiedAccelerator(e);
					KeySequence keySequence = KeySequence.getInstance(SWTKeySupport.convertAcceleratorToKeyStroke(accelerator));
					KeySequence[] sequences= getInvokingCommandKeySequences();
					if (sequences == null)
						return;

					for (int i= 0; i < sequences.length; i++) {
						if (sequences[i].equals(keySequence)) {
							e.doit= false;
							toggleHierarchy();
							return;
						}
					}
				}
			};
		}
		return fKeyAdapter;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean hasHeader() {
		return true;
	}

	@Override
	protected Text createFilterText(Composite parent) {
		// text set later
		Text text= super.createFilterText(parent);
		text.addKeyListener(getKeyAdapter());
		return text;
	}


	@Override
	protected TreeViewer createTreeViewer(Composite parent, int style) {
		Tree tree= new Tree(parent, SWT.SINGLE | (style & ~SWT.MULTI));
		GridData gd= new GridData(GridData.FILL_BOTH);
		gd.heightHint= tree.getItemHeight() * 12;
		tree.setLayoutData(gd);

		TreeViewer treeViewer= new TreeViewer(tree);
		treeViewer.addFilter(new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return element instanceof IEObjectDescription;
			}
		});

		fLifeCycle= new EObjectDescriptionHierarchyLifeCycle(false);

		treeViewer.setComparator(new HierarchyViewerSorter(fLifeCycle));
		treeViewer.setAutoExpandLevel(AbstractTreeViewer.ALL_LEVELS);
		injector = ServiceDslCustomActivator.getInstance().getInjector(ServicedslActivator.ORG_XKONNEX_REPO_DSL_SERVICEDSL_SERVICEDSL);
		fLabelProvider= injector.getInstance (HierarchyLabelProvider.class);

		treeViewer.setLabelProvider(fLabelProvider);

		treeViewer.getTree().addKeyListener(getKeyAdapter());

		return treeViewer;
	}

	private IEObjectDescription findMember(IEObjectDescription filteredMember, IEObjectDescription elementToFindIn) {
		EObject container= filteredMember.getEObjectOrProxy().eContainer();
		IEObjectDescription containerDesc = ieDescBuilder.buildDescription(container); 
		if (containerDesc.equals(elementToFindIn)) {
			return filteredMember;
		}
		
		EObjectDescriptionHierarchy hierarchy= fLifeCycle.getHierarchy();
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * 
	 */
	@Override
	public void setInput(Object information) {
		if (!(information instanceof EObject)) {
			inputChanged(null, null);
			return;
		}
		EObject input= (EObject) information;
		IEObjectDescription inputDesc = ieDescBuilder.buildDescription(input);

		super.setTitleText(getHeaderLabel(inputDesc));
		try {
			fLifeCycle.ensureRefreshedTypeHierarchy(inputDesc, workbench.getActiveWorkbenchWindow());
		} catch (Exception e) {
			dispose();
			return;
		}
		Predicate<IEObjectDescription> memberFilter = Predicates.alwaysTrue();

		TraditionalHierarchyContentProvider contentProvider= new TraditionalHierarchyContentProvider(fLifeCycle);
		contentProvider.setMemberFilter(memberFilter);
		getTreeViewer().setContentProvider(contentProvider);

		fOtherContentProvider= new SuperTypeHierarchyContentProvider(fLifeCycle);
		fOtherContentProvider.setMemberFilter(memberFilter);


		Object[] topLevelObjects= contentProvider.getElements(fLifeCycle);
		if (topLevelObjects.length > 0 && contentProvider.getChildren(topLevelObjects[0]).length > 40) {
			fDoFilter= false;
		} else {
			getTreeViewer().addFilter(new NamePatternFilter());
		}

		Object selection= null;
		if (input instanceof Property) {
			selection=  input;
		} else if (topLevelObjects.length > 0) {
			selection=  topLevelObjects[0];
		}
		inputChanged(fLifeCycle, selection);
	}


	@Override
	protected void stringMatcherUpdated() {
		if (fDoFilter) {
			super.stringMatcherUpdated(); // refresh the view
		} else {
			selectFirstMatch();
		}
	}

	protected void toggleHierarchy() {
		TreeViewer treeViewer= getTreeViewer();

		treeViewer.getTree().setRedraw(false);

		Object[] expandedElements= treeViewer.getExpandedElements();
		TypeHierarchyContentProvider contentProvider= (TypeHierarchyContentProvider) treeViewer.getContentProvider();
		treeViewer.setContentProvider(fOtherContentProvider);

		treeViewer.refresh();
		if (fOtherExpandedElements != null) {
			treeViewer.setExpandedElements(fOtherExpandedElements);
		} else {
			treeViewer.expandAll();
		}

		// reveal selection
		Object selectedElement= getSelectedElement();
		if (selectedElement != null)
			getTreeViewer().reveal(selectedElement);
		else
			selectFirstMatch();

		treeViewer.getTree().setRedraw(true);

		fOtherContentProvider= contentProvider;
		fOtherExpandedElements= expandedElements;

		updateStatusFieldText();
	}


	private String getHeaderLabel(IEObjectDescription input) {
		if (input != null) {
			String arg= input.getName().getLastSegment();
			return Messages.format(EObjectDescrHierarchyMessages.HierarchyInformationControl_hierarchy_label, arg);
		} else {
			return ""; //$NON-NLS-1$
		}
	}

	@Override
	protected String getStatusFieldText() {
		KeySequence[] sequences= getInvokingCommandKeySequences();
		String keyName= ""; //$NON-NLS-1$
		if (sequences != null && sequences.length > 0)
			keyName= sequences[0].format();

		if (fOtherContentProvider instanceof TraditionalHierarchyContentProvider) {
			return Messages.format(EObjectDescrHierarchyMessages.HierarchyInformationControl_toggle_traditionalhierarchy_label, keyName);
		} else {
			return Messages.format(EObjectDescrHierarchyMessages.HierarchyInformationControl_toggle_superhierarchy_label, keyName);
		}
	}

	/*
	 * @see org.eclipse.jdt.internal.ui.text.AbstractInformationControl#getId()
	 */
	@Override
	protected String getId() {
		return "org.xkonnex.repo.dsl.semanticsdsl.service.ui.hierarchy.QuickTypeHierarchy"; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object getSelectedElement() {
		Object selectedElement= super.getSelectedElement();
		return selectedElement;
	}
}
