package org.xkonnex.repo.server.web.setup;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.inject.Inject;

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

@MountPath(value = "/reposetup")
public class RepositorySetupPage extends AuthenticatedXKonneXRepoPage<RepositorySetupModel> {

	private static final long serialVersionUID = 1L;
	
	private IModel<RepositorySetupModel> repositorySetupModel;
	
	@Inject
	private IRepositorySetupService repositorySetupService;
	@Inject
	private IRepositoryDescriptionManager repoDescriptionManager;
	
//	@Inject @Named("repositoryFolder")
//	private String repositoryFolder;

	public RepositorySetupPage() {
		this(null);
	}
	
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
				RepositorySetupModel setupModel = model.getObject();
				String masterRepoUrlStr = setupModel.getMasterRepositoryUrl();
				try {
					URI masterRepoUrl = normalizeURI(masterRepoUrlStr);
					String repositoryFolder = repoDescriptionManager.getRepositoryFolder();
					String stagingRepoUrlStr = setupModel.getStagingRepositoryUrl();
					URI stagingRepoUrl = normalizeURI(stagingRepoUrlStr);
					if (stagingRepoUrlStr != null && !(stagingRepoUrlStr.startsWith("/") || stagingRepoUrlStr.startsWith("\\"))) {
						stagingRepoUrlStr = repositoryFolder + "/" + stagingRepoUrlStr;
					}
					if (masterRepoUrl.getScheme().equals("file")) {
						repositorySetupService.createMasterRepository(masterRepoUrl);
						
					} else {
						repositorySetupService.attachMasterRepository(masterRepoUrl);
					}
					if (stagingRepoUrl.getScheme().equals("file")) {
						repositorySetupService.createStagingRepository(stagingRepoUrl, masterRepoUrl);
						
					} else {
						repositorySetupService.attachStagingRepository(stagingRepoUrl, masterRepoUrl);
					}
				} catch (URISyntaxException e) {
					throw new RepositoryConfigException(e);
				}

			}
			
		};
		TextField masterRepoUrlField = new TextField("masterRepositoryUrl");
		createReposForm.add (masterRepoUrlField);
		
		TextField stagingRepoUrlField = new TextField("stagingRepositoryUrl");
		createReposForm.add (stagingRepoUrlField);
		createReposForm.setDefaultModel (repositorySetupModel);
		add (createReposForm);
	}
	
	private URI normalizeURI (String url) throws URISyntaxException {
		String normalizedUrlStr = url;
		if (!url.contains("://")) {
			File path = new File(normalizedUrlStr);
			if (!path.isAbsolute()) {
				String repositoryFolder = repoDescriptionManager.getRepositoryFolder();
				normalizedUrlStr = repositoryFolder  + "/" + normalizedUrlStr;
				normalizedUrlStr = normalizedUrlStr.replaceAll("\\/\\/", "/");
			}
			normalizedUrlStr = "file://" + normalizedUrlStr;
		}
		URI normalizedUrl = null;
		normalizedUrl = new URI(normalizedUrlStr);
		return normalizedUrl;
	}
	
	
}
