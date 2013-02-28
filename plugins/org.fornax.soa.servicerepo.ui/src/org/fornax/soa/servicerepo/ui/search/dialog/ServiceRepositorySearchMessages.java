package org.fornax.soa.servicerepo.ui.search.dialog;

import org.eclipse.osgi.util.NLS;

public class ServiceRepositorySearchMessages extends NLS {

	private static final String BUNDLE_NAME = "org.fornax.soa.servicerepo.ui.search.dialog.messages"; //$NON-NLS-1$
	
	public static String SearchPage_expression_label;
	public static String SearchPage_expression_caseSensitive;
	public static String SearchPage_searchFor_label;
	public static String SearchPage_query_label;
	public static String SearchPage_minState_label;
	public static String SearchPage_maxState_label;
	public static String SearchPage_minVersion_label;
	public static String SearchPage_maxVersion_label;
	public static String SearchPage_canonical_label;
	public static String SearchPage_noncanonical_label;
	public static String SearchPage_limitTo_label;
	public static String ServiceRepositoryQuery_monitor;
	public static String ServiceRepositorySearchResultContentProvider_label;
	public static String ServiceRepositorySearchResultLabelProvider_invalid;
	public static String ServiceRepositorySearchViewPage_busyLabel;
	public static String ServiceRepositorySearchViewPage_resultLabel;
	public static String ServiceRepositorySearchViewPage_resultLabelInitial;
	public static String ServiceRepositorySearchViewPageActions_collapseAll;
	public static String ServiceRepositorySearchViewPageActions_collapseAll_tooltip;
	public static String ServiceRepositorySearchViewPageActions_expandAll;
	public static String ServiceRepositorySearchViewPageActions_expandAll_tooltip;
	public static String ServiceRepositorySearchViewPageActions_showNextMatch;
	public static String ServiceRepositorySearchViewPageActions_showNextMatch_tooltip;
	public static String ServiceRepositorySearchViewPageActions_showPreviousMatch;
	public static String ServiceRepositorySearchViewPageActions_showPreviousMatch_tooltip;
	public static String ServiceRepositorySearchPage_btnCheckButton_text;
	public static String ServiceRepositorySearchPage_btnCheckButton_text_1;
	
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, ServiceRepositorySearchMessages.class);
	}

	private ServiceRepositorySearchMessages() {
	}

}
