package org.xkonnex.repo.dsl.profiledsl.ui.wizard;

import org.eclipse.osgi.util.NLS;

public class Messages {
	
	private static final String BUNDLE_NAME = "org.xkonnex.repo.dsl.profiledsl.ui.wizard.messages"; //$NON-NLS-1$
	public static String NewProfileDslFileWizard_initialContent;
	public static String NewProfileDslFileWizard_description;
	public static String NewProfileDslFileWizard_title;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}

}
