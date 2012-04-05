/*
 * based on Xtext findrefs components
 */
package org.fornax.soa.servicerepo.ui.search.dialog;

import org.eclipse.jface.action.Action;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface ServiceRepositorySearchViewPageActions {

	public static class ShowNext extends Action {

		private ServiceRepositorySearchViewPage page;

		public ShowNext(ServiceRepositorySearchViewPage page) {
			super(Messages.ServiceRepositorySearchViewPageActions_showNextMatch);
//			setImageDescriptor(XtextPluginImages.DESC_SEARCH_NEXT);
			setToolTipText(Messages.ServiceRepositorySearchViewPageActions_showNextMatch_tooltip);
			this.page = page;
		}

		@Override
		public void run() {
			new TreeViewerNavigator(page).navigateNext(true);
		}
	}

	public static class ShowPrevious extends Action {

		private ServiceRepositorySearchViewPage page;

		public ShowPrevious(ServiceRepositorySearchViewPage page) {
			super(Messages.ServiceRepositorySearchViewPageActions_showPreviousMatch);
//			setImageDescriptor(XtextPluginImages.DESC_SEARCH_PREVIOUS);
			setToolTipText(Messages.ServiceRepositorySearchViewPageActions_showPreviousMatch_tooltip);
			this.page = page;
		}

		@Override
		public void run() {
			new TreeViewerNavigator(page).navigateNext(false);
		}
	}
	
	public static class ExpandAll extends Action {
		private ServiceRepositorySearchViewPage page;

		public ExpandAll(ServiceRepositorySearchViewPage page) {
			super(Messages.ServiceRepositorySearchViewPageActions_expandAll);
//			setImageDescriptor(XtextPluginImages.DESC_EXPAND_ALL);
			setToolTipText(Messages.ServiceRepositorySearchViewPageActions_expandAll_tooltip);
			this.page = page;
		}

		@Override
		public void run() {
			page.getViewer().expandAll();
		}
	}

	public static class CollapseAll extends Action {
		private ServiceRepositorySearchViewPage page;

		public CollapseAll(ServiceRepositorySearchViewPage page) {
			super(Messages.ServiceRepositorySearchViewPageActions_collapseAll);
//			setImageDescriptor(XtextPluginImages.DESC_COLLAPSE_ALL);
			setToolTipText(Messages.ServiceRepositorySearchViewPageActions_collapseAll_tooltip);
			this.page = page;
		}

		@Override
		public void run() {
			page.getViewer().collapseAll();
		}
	}
}
