package org.xkonnex.repo.dsl.sladsl.ui.wizard;

import org.eclipse.osgi.util.NLS;

public class Messages {
	
	private static final String BUNDLE_NAME = "org.xkonnex.repo.dsl.sladsl.ui.wizard.messages"; //$NON-NLS-1$
	public static String NewSLADslFileWizard_initialContent;
	public static String NewSLADslFileWizard_description;
	public static String NewSLADslFileWizard_title;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}

}
