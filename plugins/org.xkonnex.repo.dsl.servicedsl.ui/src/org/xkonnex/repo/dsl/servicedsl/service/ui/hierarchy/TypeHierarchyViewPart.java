package org.xkonnex.repo.dsl.servicedsl.service.ui.hierarchy;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.ui.IContextMenuConstants;
import org.eclipse.jdt.ui.PreferenceConstants;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.IBasicPropertyConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.resource.IEObjectDescription;
//import org.xkonnex.repo.dsl.semanticsdsl.service.ui.hierarchy.IEObjDescrHierarchyLifeCycleListener;
//import org.xkonnex.repo.dsl.semanticsdsl.service.ui.hierarchy.ITypeHierarchyViewPart;
import org.xkonnex.repo.dsl.basedsl.ui.hierarchy.EObjectDescriptionHierarchy;
import org.xkonnex.repo.dsl.basedsl.ui.hierarchy.IEObjDescrHierarchyLifeCycleListener;
import org.xkonnex.repo.dsl.basedsl.ui.hierarchy.IEObjectDescriptionHierarchyLifeCycle;
import org.xkonnex.repo.dsl.basedsl.ui.hierarchy.IEObjectDescriptionHierarchyViewPart;


public class TypeHierarchyViewPart extends ViewPart implements
		IEObjectDescriptionHierarchyViewPart {
	
	private IEObjectDescription inputElement;
	
	private boolean qualifiedTypeNamesEnabled;
	private boolean linkingEnalbled;
	private static final String DIALOGSTORE_HIERARCHYVIEW= "TypeHierarchyViewPart.hierarchyview";	 //$NON-NLS-1$
	private static final String DIALOGSTORE_VIEWLAYOUT= "TypeHierarchyViewPart.orientation";	 //$NON-NLS-1$
	private static final String DIALOGSTORE_QUALIFIED_NAMES= "TypeHierarchyViewPart.qualifiednames";	 //$NON-NLS-1$
	private static final String DIALOGSTORE_LINKEDITORS= "TypeHierarchyViewPart.linkeditors";	 //$NON-NLS-1$

	private static final String TAG_INPUT= "input"; //$NON-NLS-1$
	private static final String TAG_VIEW= "view"; //$NON-NLS-1$
	private static final String TAG_LAYOUT= "orientation"; //$NON-NLS-1$
	private static final String TAG_RATIO= "ratio"; //$NON-NLS-1$
	private static final String TAG_SELECTION= "selection"; //$NON-NLS-1$
	private static final String TAG_VERTICAL_SCROLL= "vertical_scroll"; //$NON-NLS-1$
	private static final String TAG_QUALIFIED_NAMES= "qualified_names"; //$NON-NLS-1$
	private static final String TAG_EDITOR_LINKING= "link_editors"; //$NON-NLS-1$
	/**
	 * Constant used for the vertical view layout.
	 * @since 3.3
	 */
	public static final int VIEW_LAYOUT_VERTICAL= 0;

	/**
	 * Constant used for the horizontal view layout.
	 * @since 3.3
	 */
	public static final int VIEW_LAYOUT_HORIZONTAL= 1;

	/**
	 * Constant used for the single view layout (no members view)
	 * @since 3.3
	 */
	public static final int VIEW_LAYOUT_SINGLE= 2;

	/**
	 * Constant used for the automatic view layout.
	 * @since 3.3
	 */
	public static final int VIEW_LAYOUT_AUTOMATIC= 3;

	/**
	 * Constant used for the 'classic' type hierarchy mode.
	 * @since 3.3
	 */
	public static final int HIERARCHY_MODE_CLASSIC= 2;

	/**
	 * Constant used for the super types hierarchy mode.
	 * @since 3.3
	 */
	public static final int HIERARCHY_MODE_SUPERTYPES= 0;

	/**
	 * Constant used for the sub types hierarchy mode.
	 * @since 3.3
	 */
	public static final int HIERARCHY_MODE_SUBTYPES= 1;

	private static final String GROUP_FOCUS= "group.focus"; //$NON-NLS-1$



	// the selected type in the hierarchy view
	private IEObjectDescription fSelectedType;
	// input elements or null
	private IEObjectDescription[] fInputElements;

	// history of input elements. No duplicates
	private ArrayList<IEObjectDescription[]> fInputHistory;

	private IMemento fMemento;
	private IDialogSettings fDialogSettings;

	private IEObjectDescriptionHierarchyLifeCycle fHierarchyLifeCycle;
//	private ITypeHierarchyLifeCycleListener fTypeHierarchyLifeCycleListener;

	private IPropertyChangeListener fPropertyChangeListener;

//	private SelectionProviderMediator fSelectionProviderMediator;
//	private ISelectionChangedListener fSelectionChangedListener;
	private IPartListener2 fPartListener;

	private int fCurrentLayout;
	private boolean fInComputeLayout;

	private boolean fLinkingEnabled;
	private boolean fShowQualifiedTypeNames;
	private boolean fSelectInEditor;

	private boolean fIsVisible;
	private boolean fNeedRefresh;
	private boolean fIsEnableMemberFilter;
	private boolean fIsRefreshRunnablePosted;

	private int fCurrentViewerIndex;
	private TypeHierarchyViewer[] fAllViewers;

	private SashForm fTypeMethodsSplitter;
	private PageBook fViewerbook;
	private PageBook fPagebook;

	private Label fNoHierarchyShownLabel;
	private Label fEmptyTypesViewer;

	private ViewForm fTypeViewerViewForm;
	private ViewForm fMethodViewerViewForm;

	private CLabel fMethodViewerPaneLabel;
	private Composite fParent;

	private ToggleViewAction[] fViewActions;
//	private ToggleLinkingAction fToggleLinkingAction;
//	private HistoryDropDownAction fHistoryDropDownAction;
//	private ToggleOrientationAction[] fToggleOrientationActions;
//	private EnableMemberFilterAction fEnableMemberFilterAction;
	private ShowQualifiedTypeNamesAction fShowQualifiedTypeNamesAction;
	private FocusOnSelectionAction fFocusOnSelectionAction;
	private CompositeActionGroup fActionGroups;
//	private SelectAllAction fSelectAllAction;

//	private WorkingSetFilterActionGroup fWorkingSetActionGroup;
	private Job fRestoreStateJob;

	private IEObjDescrHierarchyLifeCycleListener fTypeHierarchyLifeCycleListener;

	private ISelectionChangedListener fSelectionChangedListener;
	
	
	public TypeHierarchyViewPart() {
		fSelectedType= null;
		fInputElements= null;
		fIsVisible= false;
		fIsRefreshRunnablePosted= false;
		fSelectInEditor= true;
		fRestoreStateJob= null;

		fHierarchyLifeCycle= new EObjectDescriptionHierarchyLifeCycle(this);
		fTypeHierarchyLifeCycleListener= new IEObjDescrHierarchyLifeCycleListener() {
			public void hierarchyChanged(
					IEObjectDescriptionHierarchyLifeCycle typeHierarchy,
					List<IEObjectDescription> changedTypes) {
				// TODO Auto-generated method stub
				doTypeHierarchyChanged(typeHierarchy, changedTypes);
				
			}
		};
		fHierarchyLifeCycle.addChangedListener(fTypeHierarchyLifeCycleListener);

		fPropertyChangeListener= new IPropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent event) {
				doPropertyChange(event);
			}
		};
		PreferenceConstants.getPreferenceStore().addPropertyChangeListener(fPropertyChangeListener);

		fIsEnableMemberFilter= false;

//		fInputHistory= new ArrayList<IJavaElement[]>();
		fAllViewers= null;

		fViewActions= new ToggleViewAction[] {
			new ToggleViewAction(this, HIERARCHY_MODE_CLASSIC),
			new ToggleViewAction(this, HIERARCHY_MODE_SUPERTYPES),
			new ToggleViewAction(this, HIERARCHY_MODE_SUBTYPES)
		};

//		fDialogSettings= JavaPlugin.getDefault().getDialogSettings();

//		fHistoryDropDownAction= new HistoryDropDownAction(this);
//		fHistoryDropDownAction.setEnabled(false);

//		fToggleOrientationActions= new ToggleOrientationAction[] {
//			new ToggleOrientationAction(this, VIEW_LAYOUT_VERTICAL),
//			new ToggleOrientationAction(this, VIEW_LAYOUT_HORIZONTAL),
//			new ToggleOrientationAction(this, VIEW_LAYOUT_AUTOMATIC),
//			new ToggleOrientationAction(this, VIEW_LAYOUT_SINGLE)
//		};

//		fEnableMemberFilterAction= new EnableMemberFilterAction(this, false);
		fShowQualifiedTypeNamesAction= new ShowQualifiedTypeNamesAction(this, false);

//
//		fToggleLinkingAction= new ToggleLinkingAction(this);
//		fToggleLinkingAction.setActionDefinitionId(IWorkbenchCommandConstants.NAVIGATE_TOGGLE_LINK_WITH_EDITOR);

//		fPaneLabelProvider= new JavaUILabelProvider();

		fFocusOnSelectionAction= new FocusOnSelectionAction(this);

		fPartListener= new IPartListener2() {
			public void partVisible(IWorkbenchPartReference ref) {
				IWorkbenchPart part= ref.getPart(false);
				if (part == TypeHierarchyViewPart.this) {
					visibilityChanged(true);
				}
			}

			public void partHidden(IWorkbenchPartReference ref) {
				IWorkbenchPart part= ref.getPart(false);
				if (part == TypeHierarchyViewPart.this) {
					visibilityChanged(false);
				}
			}

			public void partActivated(IWorkbenchPartReference ref) {
				IWorkbenchPart part= ref.getPart(false);
				if (part instanceof IEditorPart)
					editorActivated((IEditorPart) part);
			}

		 	public void partInputChanged(IWorkbenchPartReference ref) {
				IWorkbenchPart part= ref.getPart(false);
				if (part instanceof IEditorPart)
					editorActivated((IEditorPart) part);
		 	}

			public void partBroughtToTop(IWorkbenchPartReference ref) {}
			public void partClosed(IWorkbenchPartReference ref) {}
			public void partDeactivated(IWorkbenchPartReference ref) {}
			public void partOpened(IWorkbenchPartReference ref) {}
		};

		fSelectionChangedListener= new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				doSelectionChanged(event);
			}
		};
	}
	private void doPropertyChange(PropertyChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

	private void visibilityChanged(boolean b) {
		// TODO Auto-generated method stub
		
	}

 	private void editorActivated(IEditorPart part) {
		// TODO Auto-generated method stub
		
	}

	protected void doSelectionChanged(SelectionChangedEvent e) {
		typeSelectionChanged(e.getSelection());
	}

	/**
	 * Called from ITypeHierarchyLifeCycleListener.
	 * Can be called from any thread
	 * @param typeHierarchy Hierarchy that has changed
	 * @param changedTypes Types in the hierarchy that have change or <code>null</code> if the full hierarchy has changed
	 */
	protected void doTypeHierarchyChanged(final IEObjectDescriptionHierarchyLifeCycle typeHierarchy, final List<IEObjectDescription> changedTypes) {
		if (!fIsVisible) {
			fNeedRefresh= true;
			return;
		}
		if (fIsRefreshRunnablePosted) {
			return;
		}

		Display display= getDisplay();
		if (display != null) {
			fIsRefreshRunnablePosted= true;
			display.asyncExec(new Runnable() {
				public void run() {
					try {
						if (fPagebook != null && !fPagebook.isDisposed()) {
							doTypeHierarchyChangedOnViewers(changedTypes);
						}
					} finally {
						fIsRefreshRunnablePosted= false;
					}
				}
			});
		}
	}

	protected void doTypeHierarchyChangedOnViewers(List<IEObjectDescription> changedTypes) {
		if (fHierarchyLifeCycle.getHierarchy() == null /*|| !fHierarchyLifeCycle.getHierarchy().exists()*/) {
			clearInput();
		} else {
			if (changedTypes == null) {
				// hierarchy change
				try {
					fHierarchyLifeCycle.ensureRefreshedTypeHierarchy(fInputElements[0], getSite().getWorkbenchWindow());
				} catch (InvocationTargetException e) {
					clearInput();
					return;
				} catch (InterruptedException e) {
					return;
				}
				updateHierarchyViewer(false);
			} else {
				getCurrentViewer().update(changedTypes, new String[] { IBasicPropertyConstants.P_TEXT, IBasicPropertyConstants.P_IMAGE } );
			}
		}
	}

	/*
	 * @see IViewPart#init
	 */
	@Override
	public void init(IViewSite site, IMemento memento) throws PartInitException {
		super.init(site, memento);
		fMemento= memento;
	}

	/*
	 * When the input changed or the hierarchy pane becomes visible,
	 * <code>updateHierarchyViewer<code> brings up the correct view and refreshes
	 * the current tree
	 */
	private void updateHierarchyViewer(final boolean doExpand) {
		if (fInputElements == null) {
			fNoHierarchyShownLabel.setText(EObjectDescrHierarchyMessages.TypeHierarchyViewPart_empty);
			fPagebook.showPage(fNoHierarchyShownLabel);
		} else {
			if (getCurrentViewer().containsElements() != null) {
				Runnable runnable= new Runnable() {
					public void run() {
						getCurrentViewer().updateContent(doExpand); // refresh
					}
				};
				BusyIndicator.showWhile(getDisplay(), runnable);
				if (!isChildVisible(fViewerbook, getCurrentViewer().getControl())) {
					setViewerVisibility(true);
				}
			} else if (true /*!isKeepShowingEmptyViewers()*/) {//Show the empty hierarchy viewer till fresh computation is done.
//				fEmptyTypesViewer.setText(Messages.format(TypeHierarchyMessages.TypeHierarchyViewPart_nodecl, HistoryAction.getElementLabel(fInputElements)));
				setViewerVisibility(false);
			}
		}
	}

	private TypeHierarchyViewer getCurrentViewer() {
		return fAllViewers[fCurrentViewerIndex];
	}
	/*
	 * Toggles between the empty viewer page and the hierarchy
	 */
	private void setViewerVisibility(boolean showHierarchy) {
		if (showHierarchy) {
			fViewerbook.showPage(getCurrentViewer().getControl());
		} else {
			fViewerbook.showPage(fEmptyTypesViewer);
		}
	}

	private Display getDisplay() {
		if (fPagebook != null && !fPagebook.isDisposed()) {
			return fPagebook.getDisplay();
		}
		return null;
	}

	private boolean isChildVisible(Composite pb, Control child) {
		Control[] children= pb.getChildren();
		for (int i= 0; i < children.length; i++) {
			if (children[i] == child && children[i].isVisible())
				return true;
		}
		return false;
	}
	@Override
	public void createPartControl(Composite container) {
		fParent= container;
//    	addResizeListener(container);

		fPagebook= new PageBook(container, SWT.NONE);
//		fWorkingSetActionGroup= new WorkingSetFilterActionGroup(getSite(), fPropertyChangeListener);

		// page 1 of page book (no hierarchy label)

		fNoHierarchyShownLabel= new Label(fPagebook, SWT.TOP + SWT.LEFT + SWT.WRAP);
		fNoHierarchyShownLabel.setText(EObjectDescrHierarchyMessages.TypeHierarchyViewPart_empty);

		// page 2 of page book (viewers)

		fTypeMethodsSplitter= new SashForm(fPagebook, SWT.VERTICAL);
		fTypeMethodsSplitter.setVisible(false);

		fTypeViewerViewForm= new ViewForm(fTypeMethodsSplitter, SWT.NONE);

		Control typeViewerControl= createTypeViewerControl(fTypeViewerViewForm);
		fTypeViewerViewForm.setContent(typeViewerControl);

		ToolBar methodViewerToolBar= new ToolBar(fMethodViewerViewForm, SWT.FLAT | SWT.WRAP);
		fMethodViewerViewForm.setTopCenter(methodViewerToolBar);

//		initDragAndDrop();

		MenuManager menu= new MenuManager();
		fNoHierarchyShownLabel.setMenu(menu.createContextMenu(fNoHierarchyShownLabel));

		fPagebook.showPage(fNoHierarchyShownLabel);

		int layout;
		try {
			layout= fDialogSettings.getInt(DIALOGSTORE_VIEWLAYOUT);
			if (layout < 0 || layout > 3) {
				layout= VIEW_LAYOUT_AUTOMATIC;
			}
		} catch (NumberFormatException e) {
			layout= VIEW_LAYOUT_AUTOMATIC;
		}
		// force the update
		fCurrentLayout= -1;
		// will fill the main tool bar
		setViewLayout(layout);

		showQualifiedTypeNames(fDialogSettings.getBoolean(DIALOGSTORE_QUALIFIED_NAMES));
		setLinkingEnabled(fDialogSettings.getBoolean(DIALOGSTORE_LINKEDITORS));

		// set the filter menu items
		IActionBars actionBars= getViewSite().getActionBars();
		IMenuManager viewMenu= actionBars.getMenuManager();
		for (int i= 0; i < fViewActions.length; i++) {
			ToggleViewAction action= fViewActions[i];
			viewMenu.add(action);
			action.setEnabled(false);
		}
		viewMenu.add(new Separator());

//		fWorkingSetActionGroup.fillViewMenu(viewMenu);

		viewMenu.add(new Separator());

		IMenuManager layoutSubMenu= new MenuManager(EObjectDescrHierarchyMessages.TypeHierarchyViewPart_layout_submenu);
		viewMenu.add(layoutSubMenu);
		viewMenu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		viewMenu.add(fShowQualifiedTypeNamesAction);
//		viewMenu.add(fToggleLinkingAction);


		// fill the method viewer tool bar
		ToolBarManager lowertbmanager= new ToolBarManager(methodViewerToolBar);
		lowertbmanager.update(true);

		// selection provider
		int nHierarchyViewers= fAllViewers.length;
		StructuredViewer[] trackedViewers= new StructuredViewer[nHierarchyViewers + 1];
		for (int i= 0; i < nHierarchyViewers; i++) {
			trackedViewers[i]= fAllViewers[i];
		}
//		trackedViewers[nHierarchyViewers]= fMethodsViewer;
//		fSelectionProviderMediator= new SelectionProviderMediator(trackedViewers, getCurrentViewer());
//		IStatusLineManager slManager= getViewSite().getActionBars().getStatusLineManager();
//		fSelectionProviderMediator.addSelectionChangedListener(new StatusBarUpdater(slManager));

//		getSite().setSelectionProvider(fSelectionProviderMediator);
		getSite().getPage().addPartListener(fPartListener);

//		if (fMemento != null)
//			restoreState(fMemento);
//		else
//			setViewerVisibility(false);
//
//		PlatformUI.getWorkbench().getHelpSystem().setHelp(fPagebook, IJavaHelpContextIds.TYPE_HIERARCHY_VIEW);
//
//
//		fActionGroups= new CompositeActionGroup(new ActionGroup[] {
//				new NewWizardsActionGroup(this.getSite()),
//				new OpenEditorActionGroup(this),
//				new OpenViewActionGroup(this),
//				new CCPActionGroup(this),
//				new GenerateActionGroup(this),
//				new RefactorActionGroup(this),
//				new JavaSearchActionGroup(this)
//		});

//		fActionGroups.fillActionBars(actionBars);
//		fSelectAllAction= new SelectAllAction(fMethodsViewer);
//		fOpenAction= new OpenAction(getSite());
//
//		actionBars.setGlobalActionHandler(ActionFactory.SELECT_ALL.getId(), fSelectAllAction);
//
//		IHandlerService handlerService= (IHandlerService) getViewSite().getService(IHandlerService.class);
//		handlerService.activateHandler(IWorkbenchCommandConstants.NAVIGATE_TOGGLE_LINK_WITH_EDITOR, new ActionHandler(fToggleLinkingAction));
	}

	private void setViewLayout(int layout) {
		// TODO Auto-generated method stub
		
	}

	private Control createTypeViewerControl(ViewForm parent) {
		fViewerbook= new PageBook(parent, SWT.NULL);

		KeyListener keyListener= createKeyListener();

		// Create the viewers
		TypeHierarchyViewer superTypesViewer= new SuperTypeHierarchyViewer(fViewerbook, fHierarchyLifeCycle);
		initializeTypesViewer(superTypesViewer, keyListener, IContextMenuConstants.TARGET_ID_SUPERTYPES_VIEW);

		TypeHierarchyViewer subTypesViewer= new SubTypeHierarchyViewer(fViewerbook, fHierarchyLifeCycle);
		initializeTypesViewer(subTypesViewer, keyListener, IContextMenuConstants.TARGET_ID_SUBTYPES_VIEW);

		TypeHierarchyViewer vajViewer= new TraditionalHierarchyViewer(fViewerbook, fHierarchyLifeCycle);
		initializeTypesViewer(vajViewer, keyListener, IContextMenuConstants.TARGET_ID_HIERARCHY_VIEW);

		fAllViewers= new TypeHierarchyViewer[3];
		fAllViewers[HIERARCHY_MODE_SUPERTYPES]= superTypesViewer;
		fAllViewers[HIERARCHY_MODE_SUBTYPES]= subTypesViewer;
		fAllViewers[HIERARCHY_MODE_CLASSIC]= vajViewer;

		int currViewerIndex;
		try {
			currViewerIndex= fDialogSettings.getInt(DIALOGSTORE_HIERARCHYVIEW);
			if (currViewerIndex < 0 || currViewerIndex > 2) {
				currViewerIndex= HIERARCHY_MODE_CLASSIC;
			}
		} catch (NumberFormatException e) {
			currViewerIndex= HIERARCHY_MODE_CLASSIC;
		}

		fEmptyTypesViewer= new Label(fViewerbook, SWT.TOP | SWT.LEFT | SWT.WRAP);

		for (int i= 0; i < fAllViewers.length; i++) {
			fAllViewers[i].setInput(fAllViewers[i]);
		}

		// force the update
		fCurrentViewerIndex= -1;
		setHierarchyMode(currViewerIndex);

		return fViewerbook;
	}

	private void initializeTypesViewer(final TypeHierarchyViewer typesViewer, KeyListener keyListener, String cotextHelpId) {
		typesViewer.getControl().setVisible(false);
		typesViewer.getControl().addKeyListener(keyListener);
		typesViewer.initContextMenu(new IMenuListener() {
			public void menuAboutToShow(IMenuManager menu) {
				fillTypesViewerContextMenu(typesViewer, menu);
			}

		}, cotextHelpId,	getSite());
		typesViewer.addPostSelectionChangedListener(fSelectionChangedListener);
		typesViewer.setQualifiedTypeName(isQualifiedTypeNamesEnabled());
//		typesViewer.setWorkingSetFilter(fWorkingSetActionGroup.getWorkingSetFilter());
	}
	
	/*
	 * Creates the context menu for the hierarchy viewers
	 */
	private void fillTypesViewerContextMenu(TypeHierarchyViewer viewer, IMenuManager menu) {

		menu.appendToGroup(IContextMenuConstants.GROUP_SHOW, new Separator(GROUP_FOCUS));
		// viewer entries
		viewer.contributeToContextMenu(menu);

		fActionGroups.setContext(new ActionContext(getSite().getSelectionProvider().getSelection()));
		fActionGroups.fillContextMenu(menu);
		fActionGroups.setContext(null);
	}

	private void updateToolbarButtons() {
		boolean isNull= fInputElements == null;
		boolean isType= !isNull && fInputElements.length == 1 && fInputElements[0] instanceof IEObjectDescription;
		for (int i= 0; i < fViewActions.length; i++) {
			ToggleViewAction action= fViewActions[i];
			if (action.getViewerIndex() == HIERARCHY_MODE_CLASSIC) {
				action.setEnabled(!isNull);
			} else {
				action.setEnabled(isType);
			}
		}
	}
	
	public void setHierarchyMode(int viewerIndex) {
		Assert.isNotNull(fAllViewers);
		if (viewerIndex < fAllViewers.length && fCurrentViewerIndex != viewerIndex) {

			fCurrentViewerIndex= viewerIndex;

			updateHierarchyViewer(true);
			if (fInputElements != null) {
				ISelection currSelection= getCurrentViewer().getSelection();
				if (currSelection == null || currSelection.isEmpty()) {
					internalSelectType(getSelectableType(fInputElements), false);
					currSelection= getCurrentViewer().getSelection();
				}
				if (!fIsEnableMemberFilter) {
					typeSelectionChanged(currSelection);
				}
			}
			updateToolTipAndDescription();

			fDialogSettings.put(DIALOGSTORE_HIERARCHYVIEW, viewerIndex);
			getCurrentViewer().getTree().setFocus();

		}
		for (int i= 0; i < fViewActions.length; i++) {
			ToggleViewAction action= fViewActions[i];
			action.setChecked(fCurrentViewerIndex == action.getViewerIndex());
		}
	}

	private void internalSelectType(IEObjectDescription selectableType,
			boolean b) {
		// TODO Auto-generated method stub
		
	}
	private void updateToolTipAndDescription() {
		// TODO Auto-generated method stub
		
	}
	private KeyListener createKeyListener() {
		return new KeyAdapter() {
			@Override
			public void keyReleased(org.eclipse.swt.events.KeyEvent event) {
				if (event.stateMask == 0) {
					if (event.keyCode == SWT.F5) {
						EObjectDescriptionHierarchy hierarchy= fHierarchyLifeCycle.getHierarchy();
						if (hierarchy != null) {
							fHierarchyLifeCycle.hierarchyChanged(hierarchy);
							doTypeHierarchyChangedOnViewers(null);
						}
						updateHierarchyViewer(false);
						return;
					}
 				}
			}

			private void updateHierarchyViewer(boolean b) {
				// TODO Auto-generated method stub
				
			}

			private void doTypeHierarchyChangedOnViewers(Object object) {
				// TODO Auto-generated method stub
				
			}
		};
	}

	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

	public IEObjectDescription getInputElement() {
		return inputElement;
	}

	public void showQualifiedTypeNames(boolean enabled) {
		qualifiedTypeNamesEnabled = enabled;
	}

	public boolean isQualifiedTypeNamesEnabled() {
		return qualifiedTypeNamesEnabled;
	}

	public boolean isLinkingEnabled() {
		return linkingEnalbled;
	}


	/* (non-Javadoc)
	 * @see org.eclipse.jdt.ui.ITypeHierarchyViewPart#setLinkingEnabled(boolean)
	 */
	public void setLinkingEnabled(boolean enabled) {
		fLinkingEnabled= enabled;
//		fToggleLinkingAction.setChecked(enabled);
		fDialogSettings.put(DIALOGSTORE_LINKEDITORS, enabled);

		if (enabled) {
			IWorkbenchPartSite site= getSite();
			if (site != null) {
				IEditorPart editor = site.getPage().getActiveEditor();
				if (editor != null) {
					editorActivated(editor);
				}
			}
		}
	}

	public void showEmptyViewer() {
		// TODO Auto-generated method stub
		
	}

	public void setViewersInput() {
		// TODO Auto-generated method stub
		
	}

	public void updateViewers() {
		if (fInputElements == null)
			return;
		if (!fHierarchyLifeCycle.isRefreshJobRunning()) {
			setViewersInput();
		}
		setViewerVisibility(true);
		// turn off member filtering
		fSelectInEditor= false;
//		setMemberFilter(null);
		internalSelectType(null, false); // clear selection
		fIsEnableMemberFilter= false;
		updateHierarchyViewer(true);
		IEObjectDescription root= getSelectableType(fInputElements);
		internalSelectType(root, true);
		updateToolbarButtons();
//		updateToolTipAndDescription();
		showMembersInHierarchy(false);
		fPagebook.showPage(fTypeMethodsSplitter);		
		fSelectInEditor= true;		
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jdt.ui.ITypeHierarchyViewPart#showMembersInHierarchy(boolean)
	 */
	public void showMembersInHierarchy(boolean on) {
	}


	private IEObjectDescription getSelectableType(IEObjectDescription[] elem) {
		return (IEObjectDescription)elem[0];
	}
	
	private void typeSelectionChanged(ISelection sel) {
		if (sel instanceof IStructuredSelection) {
			List<?> selected= ((IStructuredSelection)sel).toList();
			int nSelected= selected.size();
			if (nSelected != 0) {
				List<Object> types= new ArrayList<Object>(nSelected);
				for (int i= nSelected-1; i >= 0; i--) {
					Object elem= selected.get(i);
					if (elem instanceof IEObjectDescription && !types.contains(elem)) {
						types.add(elem);
					}
				}
				if (types.size() == 1) {
					fSelectedType= (IEObjectDescription) types.get(0);
				} else if (types.size() == 0) {
				}
				if (nSelected == 1 && fSelectInEditor) {
					revealElementInEditor(selected.get(0), getCurrentViewer());
				}
			} else {
				fSelectedType= null;
			}
		}
	}

	private void revealElementInEditor(Object elem, StructuredViewer originViewer) {
		// only allow revealing when the type hierarchy is the active page
		// no revealing after selection events due to model changes

		if (getSite().getPage().getActivePart() != this) {
			return;
		}

//		if (fSelectionProviderMediator.getViewerInFocus() != originViewer) {
//			return;
//		}
//
//		IEditorPart editorPart= EditorUtility.isOpenInEditor(elem);
//		if (editorPart != null && (elem instanceof IJavaElement)) {
//			getSite().getPage().removePartListener(fPartListener);
//			getSite().getPage().bringToTop(editorPart);
//			EditorUtility.revealInEditor(editorPart, (IJavaElement) elem);
//			getSite().getPage().addPartListener(fPartListener);
//		}
	}
	
	public Object getViewPartInput() {
		return fInputElements;
	}

	private void clearInput() {
		fInputElements= null;
		fHierarchyLifeCycle.freeHierarchy();

		updateHierarchyViewer(false);
		updateToolbarButtons();
//		updateToolTipAndDescription();
		getViewSite().getActionBars().getStatusLineManager().setMessage(""); //$NON-NLS-1$		
	}
	/*
	 * @see IWorkbenchPart#dispose
	 */
	@Override
	public void dispose() {
		if (fHierarchyLifeCycle != null) {
			fHierarchyLifeCycle.freeHierarchy();
			fHierarchyLifeCycle.removeChangedListener(fTypeHierarchyLifeCycleListener);
			fHierarchyLifeCycle= null;
		}
//		fPaneLabelProvider.dispose();

		if (fPropertyChangeListener != null) {
//			JavaPlugin.getDefault().getPreferenceStore().removePropertyChangeListener(fPropertyChangeListener);
			fPropertyChangeListener= null;
		}

		getSite().getPage().removePartListener(fPartListener);

//		if (fActionGroups != null)
//			fActionGroups.dispose();
//
//		if (fWorkingSetActionGroup != null)
//			fWorkingSetActionGroup.dispose();

		super.dispose();
	}

}
