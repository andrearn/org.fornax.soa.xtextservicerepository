/*
 * based on Xtext findrefs components
 */
package org.xkonnex.repo.workbench.ui.search.dialog;

import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.util.OpenStrategy;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.search.ui.IContextMenuConstants;
import org.eclipse.search.ui.IQueryListener;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultPage;
import org.eclipse.search.ui.ISearchResultViewPart;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.OpenAndLinkWithEditorHelper;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.xkonnex.repo.workbench.ui.internal.ServiceRepositoryActivator;
import org.xkonnex.repo.workbench.ui.search.EObjectSearchResult;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.ibm.icu.text.MessageFormat;

public class ServiceRepositorySearchViewPage extends Page implements ISearchResultPage {

	private String id;

	private ISearchResult searchResult;

	private PageBook pagebook;

	private Table busyLabel;

	private Composite control;

	private TreeViewer viewer;

	private ISearchResultViewPart part;

	private IAction showNextAction;

	private IAction showPreviousAction;

	private IAction expandAllAction;

	private IAction collapseAllAction;

	@Inject
	private ServiceRepositorySearchResultContentProvider contentProvider;

	@Inject
	private ServiceRepositorySearchResultLabelProvider labelProvider;

	@Inject
	private ServiceRepositorySearchViewSorter sorter;
	
	@Inject
	private IURIEditorOpener uriEditorOpener;

	private boolean isBusyShowing;

	private IQueryListener queryListener;
	
	private static Injector injector;

	private volatile boolean fIsUIUpdateScheduled= false;
	private boolean fBatchedClearAll;

	public ServiceRepositorySearchViewPage() {
		showPreviousAction = new ServiceRepositorySearchViewPageActions.ShowPrevious(this);
		showNextAction = new ServiceRepositorySearchViewPageActions.ShowNext(this);
		expandAllAction = new ServiceRepositorySearchViewPageActions.ExpandAll(this);
		collapseAllAction = new ServiceRepositorySearchViewPageActions.CollapseAll(this);
		injector = ServiceRepositoryActivator.getInstance().getInjector();
		injector.injectMembers (this);
	}

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getLabel() {
		ISearchResult input = getInput();
		if (input != null && input instanceof EObjectSearchResult) {
			EObjectSearchResult result = (EObjectSearchResult) input;
			int matchCount = result.getMatchCount ();
			return MessageFormat.format (ServiceRepositorySearchMessages.ServiceRepositorySearchViewPage_resultLabel,new Object[] {String.valueOf (matchCount)});
		} else {
			return "";
		}
	}

	public Object getUIState() {
		return viewer.getSelection();
	}

	public void restoreState(IMemento memento) {
	}

	public void saveState(IMemento memento) {
	}

	@Override
	public void init(IPageSite pageSite) {
		super.init(pageSite);
	}
	
	public ISearchResult getInput() {
		return searchResult;
	}

	public void setInput(ISearchResult newSearchResult, Object uiState) {
		synchronized (viewer) {
			this.searchResult = newSearchResult;
			if (searchResult != null) {
				viewer.setInput(newSearchResult);
				if (uiState instanceof ISelection) {
					viewer.setSelection((ISelection) uiState);
				}
			}
			part.updateLabel();
		}
	}

	public void setViewPart(ISearchResultViewPart part) {
		this.part = part;
	}
	public ISearchResultViewPart getViewPart() {
		return part;
	}

	@Override
	public void createControl(Composite parent) {
		pagebook = new PageBook(parent, SWT.NULL);
		pagebook.setLayoutData(new GridData(GridData.FILL_BOTH));
		busyLabel = new Table(pagebook, SWT.NONE);
		TableItem item = new TableItem(busyLabel, SWT.NONE);
		item.setText(ServiceRepositorySearchMessages.ServiceRepositorySearchViewPage_busyLabel);
		busyLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		control = new Composite(pagebook, SWT.NULL);
		control.setLayoutData(new GridData(GridData.FILL_BOTH));
		control.setSize(100, 100);
		control.setLayout(new FillLayout());
		viewer = new TreeViewer(control, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(contentProvider);
		viewer.setLabelProvider(labelProvider);
		viewer.setSorter(sorter);
		createOpenAndLinkWithEditorHandler();
		IToolBarManager tbm = getSite().getActionBars().getToolBarManager();
		fillToolbar(tbm);
		tbm.update(true);
		pagebook.showPage(control);
		isBusyShowing = false;
		queryListener = createQueryListener();
		NewSearchUI.addQueryListener(queryListener);
	}

	protected OpenAndLinkWithEditorHelper createOpenAndLinkWithEditorHandler() {
		return new OpenAndLinkWithEditorHelper(viewer) {
			@Override
			protected void activate(ISelection selection) {
				final int currentMode = OpenStrategy.getOpenMethod();
				try {
					OpenStrategy.setOpenMethod(OpenStrategy.DOUBLE_CLICK);
					handleOpen(new OpenEvent(viewer, selection));
				} finally {
					OpenStrategy.setOpenMethod(currentMode);
				}
			}

			@Override
			protected void linkToEditor(ISelection selection) {
				// not supported by this part
			}

			@Override
			protected void open(ISelection selection, boolean activate) {
				handleOpen(new OpenEvent(viewer, selection));
			}
		};
	}

	protected IQueryListener createQueryListener() {
		return new IQueryListener() {

			public void queryStarting(ISearchQuery query) {
				showBusyLabel(true);
			}

			public void queryRemoved(ISearchQuery query) {
				showBusyLabel(false);
			}

			public void queryFinished(ISearchQuery query) {
				showBusyLabel(false);
				scheduleUIUpdate();
			}

			public void queryAdded(ISearchQuery query) {
				showBusyLabel(false);
				scheduleUIUpdate();
			}
		};
	}

	@Override
	public void dispose() {
		NewSearchUI.removeQueryListener(queryListener);
		super.dispose();
	}

	protected void showBusyLabel(final boolean shouldShowBusy) {
		if (shouldShowBusy != isBusyShowing) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					if (shouldShowBusy)
						pagebook.showPage(busyLabel);
					else {
						pagebook.showPage(control);
						scheduleUIUpdate();
					}
				}
			});
			isBusyShowing = shouldShowBusy;
		}
	}

	protected void fillToolbar(IToolBarManager tbm) {
		tbm.appendToGroup(IContextMenuConstants.GROUP_SHOW, showNextAction);
		tbm.appendToGroup(IContextMenuConstants.GROUP_SHOW, showPreviousAction);
		IActionBars actionBars = getSite().getActionBars();
		if (actionBars != null) {
			actionBars.setGlobalActionHandler(ActionFactory.NEXT.getId(), showNextAction);
			actionBars.setGlobalActionHandler(ActionFactory.PREVIOUS.getId(), showPreviousAction);
		}
		tbm.appendToGroup(IContextMenuConstants.GROUP_VIEWER_SETUP, expandAllAction);
		tbm.appendToGroup(IContextMenuConstants.GROUP_VIEWER_SETUP, collapseAllAction);
	}

	protected void handleOpen(OpenEvent openEvent) {
		ISelection selection = openEvent.getSelection();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			for (Iterator<?> i = structuredSelection.iterator(); i.hasNext();) {
				Object selectedObject = i.next();
				if (selectedObject instanceof ServiceRepositorySearchViewTreeNode) {
					ServiceRepositorySearchViewTreeNode treeNode = (ServiceRepositorySearchViewTreeNode) selectedObject;
					Object description = treeNode.getDescription();
					if (description instanceof IEObjectDescription) {
						IEObjectDescription eObjectDescription = (IEObjectDescription) description;
						uriEditorOpener.open(eObjectDescription.getEObjectURI(), true);
					} else if (description instanceof IResourceDescription) {
						uriEditorOpener.open(((IResourceDescription) description).getURI(), true);
					}
				}
			}
		}
	}

	@Override
	public Control getControl() {
		return pagebook;
	}

	@Override
	public void setFocus() {
		Control control = viewer.getControl();
		if (control != null && !control.isDisposed())
			control.setFocus();
	}

	public TreeViewer getViewer() {
		return viewer;
	}
	
	private synchronized void scheduleUIUpdate() {
		if (!fIsUIUpdateScheduled) {
			fIsUIUpdateScheduled= true;
			new UpdateUIJob().schedule();
		}
	}


	private synchronized void runBatchedUpdates() {
	}

	private synchronized void postClear() {
		fBatchedClearAll= true;
		scheduleUIUpdate();
	}

	private synchronized boolean hasMoreUpdates() {
		return fBatchedClearAll;
	}

	private boolean isQueryRunning() {
		ISearchResult result= getInput();
		if (result != null) {
			return NewSearchUI.isQueryRunning(result.getQuery());
		}
		return false;
	}

	private void runBatchedClear() {
		synchronized(this) {
			if (!fBatchedClearAll) {
				return;
			}
			fBatchedClearAll= false;
		}
		getViewPart().updateLabel();
		clear();
	}
	
	protected void clear() {
		if (contentProvider != null)
			contentProvider.clear();
	}

	private class UpdateUIJob extends UIJob {

		public UpdateUIJob() {
			super("Servicerepo search update job");
			setSystem(true);
		}

		public IStatus runInUIThread(IProgressMonitor monitor) {
			Control control= getControl();
			if (control == null || control.isDisposed()) {
				// disposed the control while the UI was posted.
				return Status.OK_STATUS;
			}
			if (hasMoreUpdates() || isQueryRunning()) {
				schedule(500);
			} else {
				fIsUIUpdateScheduled= false;
			}
			getViewPart().updateLabel();
			return Status.OK_STATUS;
		}

		/*
		 * Undocumented for testing only. Used to find UpdateUIJobs.
		 */
		public boolean belongsTo(Object family) {
			return family == ServiceRepositorySearchViewPage.this;
		}

	}

}
