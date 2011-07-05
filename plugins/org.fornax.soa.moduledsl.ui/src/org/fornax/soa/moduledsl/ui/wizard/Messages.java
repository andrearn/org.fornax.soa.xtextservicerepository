package org.fornax.soa.moduledsl.ui.wizard;

import org.eclipse.osgi.util.NLS;

public class Messages {
	
	private static final String BUNDLE_NAME = "org.fornax.soa.moduledsl.ui.wizard.messages"; //$NON-NLS-1$
	public static String NewModuleDslFileWizard_initialContent;
	public static String NewModuleDslFileWizard_description;
	public static String NewModuleDslFileWizard_title;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}

}
