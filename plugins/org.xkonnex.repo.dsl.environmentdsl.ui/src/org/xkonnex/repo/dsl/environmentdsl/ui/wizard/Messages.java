package org.xkonnex.repo.dsl.environmentdsl.ui.wizard;

import org.eclipse.osgi.util.NLS;

public class Messages {
	
	private static final String BUNDLE_NAME = "org.xkonnex.repo.dsl.semanticsdsl.ui.wizard.messages"; //$NON-NLS-1$
	public static String NewEnvDslFileWizard_initialContent;
	public static String NewEnvDslFileWizard_description;
	public static String NewEnvDslFileWizard_title;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}

}
