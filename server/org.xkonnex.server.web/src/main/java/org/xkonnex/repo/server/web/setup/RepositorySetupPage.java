package org.xkonnex.repo.server.web.setup;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.wicketstuff.annotation.mount.MountPath;
import org.xkonnex.repo.server.core.config.IRepositoryDescriptionManager;
import org.xkonnex.repo.server.core.config.IRepositorySetupService;
import org.xkonnex.repo.server.core.config.RepositoryConfigException;
import org.xkonnex.repo.server.web.HomePage;
import org.xkonnex.repo.server.web.layout.AuthenticatedXKonneXRepoPage;

@MountPath(value = "/", alt = "/reposetup")
public class RepositorySetupPage<T> extends AuthenticatedXKonneXRepoPage<T> {

	private static final long serialVersionUID = 1L;
	
	private IModel<RepositorySetupModel> repositorySetupModel;
	
	@Inject
	private IRepositorySetupService repositorySetupService;
	@Inject
	private IRepositoryDescriptionManager repoDescriptionManager;
	
//	@Inject @Named("repositoryFolder")
//	private String repositoryFolder;

//	public RepositorySetupPage() {
//		super(null);
//	}
	
	public RepositorySetupPage(PageParameters parameters) {
		super (parameters);
		
		repositorySetupModel = new CompoundPropertyModel<RepositorySetupModel>(new RepositorySetupModel());
		Form<RepositorySetupModel> createReposForm =  new Form<RepositorySetupModel>("createReposForm") {
			
			@Override
			protected void onSubmit() {
				// TODO Auto-generated method stub
				super.onSubmit();
				try {
					doCreateRepositories(getModel());
				} catch (RepositoryConfigException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setResponsePage(HomePage.class);
			}

			private void doCreateRepositories(IModel<RepositorySetupModel> model) throws RepositoryConfigException {
				// TODO Auto-generated method stub
				RepositorySetupModel setupModel = model.getObject();
				String masterRepoUrl = setupModel.getMasterRepositoryUrl();
				String stagingRepoUrl = setupModel.getStagingRepositoryUrl();
				String repositoryFolder = repoDescriptionManager.getRepositoryFolder();
				if (masterRepoUrl != null && !(masterRepoUrl.startsWith("/") || masterRepoUrl.startsWith("\\"))) {
					masterRepoUrl = repositoryFolder  + "/" + masterRepoUrl;
				}
				if (stagingRepoUrl != null && !(stagingRepoUrl.startsWith("/") || stagingRepoUrl.startsWith("\\"))) {
					stagingRepoUrl = repositoryFolder + "/" + stagingRepoUrl;
				}
				String createdMasterRepositoryUrl = repositorySetupService.createMasterRepository(masterRepoUrl);
				repositorySetupService.createStagingRepository(stagingRepoUrl, createdMasterRepositoryUrl);
			}
			
		};
		TextField<T> masterRepoUrlField = new TextField<T>("masterRepositoryUrl");
		createReposForm.add (masterRepoUrlField);
		
		TextField<T> stagingRepoUrlField = new TextField<T>("stagingRepositoryUrl");
		createReposForm.add (stagingRepoUrlField);
		createReposForm.setDefaultModel (repositorySetupModel);
		add (createReposForm);
	}
	
	
}
