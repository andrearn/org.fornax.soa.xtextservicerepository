package org.fornax.soa.servicerepo.ui.wizards;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.ui.wizard.AbstractPluginProjectCreator;
import org.fornax.soa.servicerepo.ui.internal.ServiceRepositoryActivator;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class ServiceRepositoryProjectCreator extends AbstractPluginProjectCreator {

	protected static final String BASE_DSL_PROJECT_NAME = "org.fornax.soa.basedsl";
	protected static final String BINDING_DSL_PROJECT_NAME = "org.fornax.soa.bindingdsl";
	protected static final String BUSINESS_DSL_PROJECT_NAME = "org.fornax.soa.businessdsl";
	protected static final String ENVIRONMENT_DSL_PROJECT_NAME = "org.fornax.soa.environmentdsl";
	protected static final String MODULE_DSL_PROJECT_NAME = "org.fornax.soa.moduledsl";
	protected static final String PROFILE_DSL_PROJECT_NAME = "org.fornax.soa.profiledsl";
	protected static final String SEMANTICS_DSL_PROJECT_NAME = "org.fornax.soa.semanticsdsl";
	protected static final String SERVICE_DSL_PROJECT_NAME = "org.fornax.soa.servicedsl";
	protected static final String SLA_DSL_PROJECT_NAME = "org.fornax.soa.sladsl";
	protected static final String SOLUTION_DSL_PROJECT_NAME = "org.fornax.soa.solutiondsl";

	protected static final String BASE_DSL_UI_PROJECT_NAME = "org.fornax.soa.basedsl.ui";
	protected static final String BINDING_DSL_UI_PROJECT_NAME = "org.fornax.soa.bindingdsl.ui";
	protected static final String BUSINESS_DSL_UI_PROJECT_NAME = "org.fornax.soa.businessdsl.ui";
	protected static final String ENVIRONMENT_DSL_UI_PROJECT_NAME = "org.fornax.soa.environmentdsl.ui";
	protected static final String MODULE_DSL_UI_PROJECT_NAME = "org.fornax.soa.moduledsl.ui";
	protected static final String PROFILE_DSL_UI_PROJECT_NAME = "org.fornax.soa.profiledsl.ui";
	protected static final String SEMANTICS_DSL_UI_PROJECT_NAME = "org.fornax.soa.semanticsdsl.ui";
	protected static final String SERVICE_DSL_UI_PROJECT_NAME = "org.fornax.soa.servicedsl.ui";
	protected static final String SLA_DSL_UI_PROJECT_NAME = "org.fornax.soa.sladsl.ui";
	protected static final String SOLUTION_DSL_UI_PROJECT_NAME = "org.fornax.soa.solutiondsl.ui";

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
				"org.eclipse.xtext.graphview;resolution:=optional",
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