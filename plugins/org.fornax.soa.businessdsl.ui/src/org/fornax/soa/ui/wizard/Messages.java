package org.fornax.soa.ui.wizard;

import org.eclipse.osgi.util.NLS;

public class Messages {
	
	private static final String BUNDLE_NAME = "org.fornax.soa.ui.wizard.messages"; //$NON-NLS-1$
	public static String NewBizDslFileWizard_initialContent;
	public static String NewBizDslFileWizard_description;
	public static String NewBizDslFileWizard_title;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}

}