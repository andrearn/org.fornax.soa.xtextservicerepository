package org.xkonnex.repo.server.web.git;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.eclipse.jgit.http.server.GitServlet;
import org.eclipse.jgit.transport.resolver.FileResolver;
import org.eclipse.jgit.transport.resolver.RepositoryResolver;
import org.xkonnex.repo.server.core.config.Master;
import org.xkonnex.repo.server.core.config.RepositoryDescription;
import org.xkonnex.repo.server.core.config.Staging;

import com.google.inject.name.Named;



public class XKonneXRepoGitServlet extends GitServlet {
	
	@Inject @Staging 
	private RepositoryDescription stagingRepositoryDescription;
	
	@Inject @Master 
	private RepositoryDescription masterRepositoryDescription;

	@Inject @Named ("repositoryFolder")	
	private String repositoryFolder;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		String repositoryType = config.getInitParameter("repositoryType");
		RepositoryDescription repoDesc = stagingRepositoryDescription;
		if ("MASTER".equalsIgnoreCase(repositoryType)) {
			repoDesc = masterRepositoryDescription;
		}
		try {
			File baseFolder = null;
			if (repoDesc != null) {
				URI repoUri = new URI(repoDesc.getUrl());
				if (repoUri.getScheme().equals("file")) {
					baseFolder = new File(repoUri).getParentFile();
				}
			} else if (repositoryFolder != null){
				baseFolder = new File (repositoryFolder);
			}
			setRepositoryResolver(new FileResolver<HttpServletRequest>(baseFolder, true));
		} catch (URISyntaxException e) {
			throw new ServletException(e);
		}
		

		setUploadPackFactory (new XKonneXRepoUploadPackFactory<HttpServletRequest>(repoDesc));
		setReceivePackFactory (new XKonneXRepoReceivePackFactory<HttpServletRequest>(repoDesc));
		super.init(config);
	}

}
