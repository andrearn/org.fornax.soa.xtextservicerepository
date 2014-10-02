package org.xkonnex.repo.dsl.bindingdsl.ui.wizard;

import org.eclipse.osgi.util.NLS;

public class Messages {
	
	private static final String BUNDLE_NAME = "org.xkonnex.repo.dsl.bindingdsl.ui.wizard.messages"; //$NON-NLS-1$
	public static String NewBindDslFileWizard_initialContent;
	public static String NewBindDslFileWizard_description;
	public static String NewBindDslFileWizard_title;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}

}
