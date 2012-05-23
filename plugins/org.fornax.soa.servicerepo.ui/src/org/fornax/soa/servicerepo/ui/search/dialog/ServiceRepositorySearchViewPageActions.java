/*
 * based on Xtext findrefs components
 */
package org.fornax.soa.servicerepo.ui.search.dialog;

import org.eclipse.jface.action.Action;
import org.fornax.soa.servicerepo.ui.internal.ServiceRepositoryPluginImages;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface ServiceRepositorySearchViewPageActions {

	public static class ShowNext extends Action {

		private ServiceRepositorySearchViewPage page;

		public ShowNext(ServiceRepositorySearchViewPage page) {
			super(ServiceRepositorySearchMessages.ServiceRepositorySearchViewPageActions_showNextMatch);
			setImageDescriptor(ServiceRepositoryPluginImages.DESC_SEARCH_NEXT);
			setToolTipText(ServiceRepositorySearchMessages.ServiceRepositorySearchViewPageActions_showNextMatch_tooltip);
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
			super(ServiceRepositorySearchMessages.ServiceRepositorySearchViewPageActions_showPreviousMatch);
			setImageDescriptor(ServiceRepositoryPluginImages.DESC_SEARCH_PREVIOUS);
			setToolTipText(ServiceRepositorySearchMessages.ServiceRepositorySearchViewPageActions_showPreviousMatch_tooltip);
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
			super(ServiceRepositorySearchMessages.ServiceRepositorySearchViewPageActions_expandAll);
			setImageDescriptor(ServiceRepositoryPluginImages.DESC_EXPAND_ALL);
			setToolTipText(ServiceRepositorySearchMessages.ServiceRepositorySearchViewPageActions_expandAll_tooltip);
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
			super(ServiceRepositorySearchMessages.ServiceRepositorySearchViewPageActions_collapseAll);
			setImageDescriptor(ServiceRepositoryPluginImages.DESC_COLLAPSE_ALL);
			setToolTipText(ServiceRepositorySearchMessages.ServiceRepositorySearchViewPageActions_collapseAll_tooltip);
			this.page = page;
		}

		@Override
		public void run() {
			page.getViewer().collapseAll();
		}
	}
}
