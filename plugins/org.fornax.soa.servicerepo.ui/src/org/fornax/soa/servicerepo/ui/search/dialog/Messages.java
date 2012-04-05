package org.fornax.soa.servicerepo.ui.search.dialog;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.fornax.soa.servicerepo.ui.search.dialog.messages"; //$NON-NLS-1$
	
	public static String SearchPage_expression_label;
	public static String SearchPage_expression_caseSensitive;
	public static String SearchPage_searchFor_label;
	public static String SearchPage_query_label;
	public static String SearchPage_minState_label;
	public static String SearchPage_maxState_label;
	public static String SearchPage_limitTo_label;
	public static String ServiceRepositoryQuery_monitor;
	public static String ServiceRepositorySearchResultContentProvider_label;
	public static String ServiceRepositorySearchResultLabelProvider_invalid;
	public static String ServiceRepositorySearchViewPage_busyLabel;
	public static String ServiceRepositorySearchViewPageActions_collapseAll;
	public static String ServiceRepositorySearchViewPageActions_collapseAll_tooltip;
	public static String ServiceRepositorySearchViewPageActions_expandAll;
	public static String ServiceRepositorySearchViewPageActions_expandAll_tooltip;
	public static String ServiceRepositorySearchViewPageActions_showNextMatch;
	public static String ServiceRepositorySearchViewPageActions_showNextMatch_tooltip;
	public static String ServiceRepositorySearchViewPageActions_showPreviousMatch;
	public static String ServiceRepositorySearchViewPageActions_showPreviousMatch_tooltip;
	
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}

}
