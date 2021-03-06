package org.xkonnex.repo.workbench.ui.wizards;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.ui.wizard.AbstractPluginProjectCreator;
import org.xkonnex.repo.workbench.ui.internal.ServiceRepositoryActivator;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class ServiceRepositoryProjectCreator extends AbstractPluginProjectCreator {

	protected static final String BASE_DSL_PROJECT_NAME = "org.xkonnex.repo.dsl.basedsl";
	protected static final String BINDING_DSL_PROJECT_NAME = "org.xkonnex.repo.dsl.bindingdsl";
	protected static final String BUSINESS_DSL_PROJECT_NAME = "org.xkonnex.repo.dsl.businessdsl";
	protected static final String ENVIRONMENT_DSL_PROJECT_NAME = "org.xkonnex.repo.dsl.environmentdsl";
	protected static final String MODULE_DSL_PROJECT_NAME = "org.xkonnex.repo.dsl.moduledsl";
	protected static final String PROFILE_DSL_PROJECT_NAME = "org.xkonnex.repo.dsl.profiledsl";
	protected static final String SEMANTICS_DSL_PROJECT_NAME = "org.xkonnex.repo.dsl.semanticsdsl";
	protected static final String SERVICE_DSL_PROJECT_NAME = "org.xkonnex.repo.dsl.servicedsl";
	protected static final String SLA_DSL_PROJECT_NAME = "org.xkonnex.repo.dsl.sladsl";
	protected static final String SOLUTION_DSL_PROJECT_NAME = "org.xkonnex.repo.dsl.solutiondsl";

	protected static final String BASE_DSL_UI_PROJECT_NAME = "org.xkonnex.repo.dsl.basedsl.ui";
	protected static final String BINDING_DSL_UI_PROJECT_NAME = "org.xkonnex.repo.dsl.bindingdsl.ui";
	protected static final String BUSINESS_DSL_UI_PROJECT_NAME = "org.xkonnex.repo.dsl.businessdsl.ui";
	protected static final String ENVIRONMENT_DSL_UI_PROJECT_NAME = "org.xkonnex.repo.dsl.environmentdsl.ui";
	protected static final String MODULE_DSL_UI_PROJECT_NAME = "org.xkonnex.repo.dsl.moduledsl.ui";
	protected static final String PROFILE_DSL_UI_PROJECT_NAME = "org.xkonnex.repo.dsl.profiledsl.ui";
	protected static final String SEMANTICS_DSL_UI_PROJECT_NAME = "org.xkonnex.repo.dsl.semanticsdsl.ui";
	protected static final String SERVICE_DSL_UI_PROJECT_NAME = "org.xkonnex.repo.dsl.servicedsl.ui";
	protected static final String SLA_DSL_UI_PROJECT_NAME = "org.xkonnex.repo.dsl.sladsl.ui";
	protected static final String SOLUTION_DSL_UI_PROJECT_NAME = "org.xkonnex.repo.dsl.solutiondsl.ui";

	protected static final String MODEL_ROOT = "model";
	protected static final String VIEW_SRC_ROOT = "view";
	protected static final String SRC_GEN_ROOT = "src-gen";
	protected final List<String> SRC_FOLDER_LIST = ImmutableList.of(MODEL_ROOT, VIEW_SRC_ROOT);

	@Override
	protected ServiceRepositoryProjectInfo getProjectInfo() {
		return (ServiceRepositoryProjectInfo) super.getProjectInfo();
	}
	
	protected String getModelFolderName() {
		return MODEL_ROOT;
	}
	protected String getViewFolderName() {
		return VIEW_SRC_ROOT;
	}
	
	@Override
	protected List<String> getAllFolders() {
        return SRC_FOLDER_LIST;
    }

    @Override
	protected List<String> getRequiredBundles() {
		List<String> result = Lists.newArrayList(
				"com.ibm.icu",
				"org.eclipse.xtext", 
				"org.eclipse.xtext.generator",
				"de.itemis.xtext.antlr;resolution:=optional",
				"org.eclipse.emf.mwe2.launch;resolution:=optional",
				"org.eclipse.xtext.graphview;bundle-version=\"1.0.4\";resolution:=optional",
				"org.eclipse.xtext.graphview.lib;bundle-version=\"1.0.4\";resolution:=optional",
				BASE_DSL_PROJECT_NAME,
				BINDING_DSL_PROJECT_NAME,
				BUSINESS_DSL_PROJECT_NAME,
				ENVIRONMENT_DSL_PROJECT_NAME,
				MODULE_DSL_PROJECT_NAME,
				PROFILE_DSL_PROJECT_NAME,
				SEMANTICS_DSL_PROJECT_NAME,
				SERVICE_DSL_PROJECT_NAME,
				SLA_DSL_PROJECT_NAME,
				SOLUTION_DSL_PROJECT_NAME,
		
				BASE_DSL_UI_PROJECT_NAME,
				BINDING_DSL_UI_PROJECT_NAME,
				BUSINESS_DSL_UI_PROJECT_NAME,
				ENVIRONMENT_DSL_UI_PROJECT_NAME,
				MODULE_DSL_UI_PROJECT_NAME,
				PROFILE_DSL_UI_PROJECT_NAME,
				SEMANTICS_DSL_UI_PROJECT_NAME,
				SERVICE_DSL_UI_PROJECT_NAME,
				SLA_DSL_UI_PROJECT_NAME,
				SOLUTION_DSL_UI_PROJECT_NAME);
		return result;
	}

	protected void enhanceProject(final IProject project, final IProgressMonitor monitor) throws CoreException {
		ServiceRepositoryNewProjectGenerator gen = new ServiceRepositoryNewProjectGenerator();
		JavaIoFileSystemAccess fsa = ServiceRepositoryActivator.getInstance().getInjector().getInstance(JavaIoFileSystemAccess.class);
		fsa.setOutputPath(project.getLocation().makeAbsolute().toOSString());
		gen.generateProject(fsa);
		
		project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
	}

}