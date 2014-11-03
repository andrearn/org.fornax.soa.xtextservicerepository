package org.xkonnex.repo.dsl.servicedsl.ui.wizard;

import org.eclipse.osgi.util.NLS;

public class Messages {
	
	private static final String BUNDLE_NAME = "org.xkonnex.repo.dsl.servicedsl.ui.wizard.messages"; //$NON-NLS-1$
	public static String NewSvcDslFileWizard_initialContent;
	public static String NewSvcDslFileWizard_description;
	public static String NewSvcDslFileWizard_title;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}

}
