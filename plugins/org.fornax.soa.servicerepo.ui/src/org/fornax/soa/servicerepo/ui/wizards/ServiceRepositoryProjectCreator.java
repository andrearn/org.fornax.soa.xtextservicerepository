package org.fornax.soa.servicerepo.ui.wizards;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend.type.impl.java.JavaBeansMetaModel;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtext.ui.wizard.AbstractPluginProjectCreator;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class ServiceRepositoryProjectCreator extends AbstractPluginProjectCreator {

	protected static final String BASE_DSL_PROJECT_NAME = "org.fornax.soa.basedsl";
	protected static final String BINDING_DSL_PROJECT_NAME = "org.fornax.soa.bindingdsl";
	protected static final String BUSINESS_DSL_PROJECT_NAME = "org.fornax.soa.businessdsl";
	protected static final String ENVIRONMENT_DSL_PROJECT_NAME = "org.fornax.soa.environmentdsl";
	protected static final String MODULE_DSL_PROJECT_NAME = "org.fornax.soa.moduledsl";
	protected static final String PROFILE_DSL_PROJECT_NAME = "org.fornax.soa.profiledsl";
	protected static final String SLA_DSL_PROJECT_NAME = "org.fornax.soa.sladsl";
	protected static final String SEMANTICS_DSL_PROJECT_NAME = "org.fornax.soa.semanticsdsl";
	protected static final String SERVICE_DSL_PROJECT_NAME = "org.fornax.soa.servicedsl";
	protected static final String SOLUTION_DSL_PROJECT_NAME = "org.fornax.soa.solutiondsl";

	protected static final String BASE_DSL_UI_PROJECT_NAME = "org.fornax.soa.basedsl.ui";
	protected static final String BINDING_DSL_UI_PROJECT_NAME = "org.fornax.soa.bindingdsl.ui";
	protected static final String BUSINESS_DSL_UI_PROJECT_NAME = "org.fornax.soa.businessdsl.ui";
	protected static final String ENVIRONMENT_DSL_UI_PROJECT_NAME = "org.fornax.soa.environmentdsl.ui";
	protected static final String MODULE_DSL_UI_PROJECT_NAME = "org.fornax.soa.moduledsl.ui";
	protected static final String PROFILE_DSL_UI_PROJECT_NAME = "org.fornax.soa.profiledsl.ui";
	protected static final String SLA_DSL_UI_PROJECT_NAME = "org.fornax.soa.sladsl.ui";
	protected static final String SEMANTICS_DSL_UI_PROJECT_NAME = "org.fornax.soa.semanticsdsl.ui";
	protected static final String SERVICE_DSL_UI_PROJECT_NAME = "org.fornax.soa.servicedsl.ui";
	protected static final String SOLUTION_DSL_UI_PROJECT_NAME = "org.fornax.soa.solutiondsl.ui";

	protected static final String SRC_ROOT = "src";
	protected static final String SRC_GEN_ROOT = "src-gen";
	protected final List<String> SRC_FOLDER_LIST = ImmutableList.of(SRC_ROOT, SRC_GEN_ROOT);

	@Override
	protected ServiceRepositoryProjectInfo getProjectInfo() {
		return (ServiceRepositoryProjectInfo) super.getProjectInfo();
	}
	
	protected String getModelFolderName() {
		return SRC_ROOT;
	}
	
	@Override
	protected List<String> getAllFolders() {
        return SRC_FOLDER_LIST;
    }

    @Override
	protected List<String> getRequiredBundles() {
		List<String> result = super.getRequiredBundles();
		result.add(BASE_DSL_PROJECT_NAME);
		result.add(BINDING_DSL_PROJECT_NAME);
		result.add(BUSINESS_DSL_PROJECT_NAME);
		result.add(ENVIRONMENT_DSL_PROJECT_NAME);
		result.add(MODULE_DSL_PROJECT_NAME);
		result.add(PROFILE_DSL_PROJECT_NAME);
		result.add(SEMANTICS_DSL_PROJECT_NAME);
		result.add(SERVICE_DSL_PROJECT_NAME);
		result.add(SLA_DSL_PROJECT_NAME);
		result.add(SOLUTION_DSL_PROJECT_NAME);
		
		result.add(BASE_DSL_UI_PROJECT_NAME);
		result.add(BINDING_DSL_UI_PROJECT_NAME);
		result.add(BUSINESS_DSL_UI_PROJECT_NAME);
		result.add(ENVIRONMENT_DSL_UI_PROJECT_NAME);
		result.add(MODULE_DSL_UI_PROJECT_NAME);
		result.add(PROFILE_DSL_UI_PROJECT_NAME);
		result.add(SEMANTICS_DSL_UI_PROJECT_NAME);
		result.add(SERVICE_DSL_UI_PROJECT_NAME);
		result.add(SLA_DSL_UI_PROJECT_NAME);
		result.add(SOLUTION_DSL_UI_PROJECT_NAME);
		return result;
	}

	protected void enhanceProject(final IProject project, final IProgressMonitor monitor) throws CoreException {
		OutputImpl output = new OutputImpl();
		output.addOutlet(new Outlet(false, getEncoding(), null, true, project.getLocation().makeAbsolute().toOSString()));

		XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(output, null);
		execCtx.getResourceManager().setFileEncoding("UTF-8");
		execCtx.registerMetaModel(new JavaBeansMetaModel());

		XpandFacade facade = XpandFacade.create(execCtx);
		facade.evaluate("org::fornax::soa::servicerepo::ui::wizards::ServiceRepositoryNewProject::main", getProjectInfo());

		project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
	}

}