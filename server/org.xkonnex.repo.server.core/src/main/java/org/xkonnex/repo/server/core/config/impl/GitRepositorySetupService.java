package org.xkonnex.repo.server.core.config.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.InitCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.errors.RepositoryNotFoundException;
import org.eclipse.jgit.lib.Repository;
import org.xkonnex.repo.server.core.config.IRepositoryDescriptionManager;
import org.xkonnex.repo.server.core.config.IRepositorySetupService;
import org.xkonnex.repo.server.core.config.RepositoryConfigException;
import org.xkonnex.repo.server.core.config.RepositoryDescription;
import org.xkonnex.repo.server.core.config.RepositoryType;

import com.google.inject.Inject;

public class GitRepositorySetupService implements IRepositorySetupService {
	
	@Inject
	private IRepositoryDescriptionManager repoDescriptionManager;
	
	public void attachStagingReposity(String stagingRepositoryUrl, String workspaceLocation) throws RepositoryConfigException {
		// TODO Auto-generated method stub
		
	}

	public void attachMasterRepository(String masterRepositoryUrl) throws RepositoryConfigException {
		// TODO Auto-generated method stub
		
	}

	public String createStagingRepository (String stagingRepositoryUrl, String masterRepositoryUrl) throws RepositoryConfigException {
		if (stagingRepositoryUrl != null && masterRepositoryUrl != null && !stagingRepositoryUrl.equals(masterRepositoryUrl)) {
			CloneCommand cloneCmd = Git.cloneRepository();
			File workspace = new File (stagingRepositoryUrl);
			try {
				workspace.mkdirs();
				cloneCmd.setDirectory (workspace);
				cloneCmd.setURI(masterRepositoryUrl);
				Repository repository = cloneCmd.call().getRepository();
				storeDescription(repository, stagingRepositoryUrl, RepositoryType.STAGING);
				return repository.getDirectory().getPath();
			} catch (GitAPIException e) {
				throw new RepositoryConfigException(e);
			} catch (SecurityException secEx) {
				throw new RepositoryConfigException(secEx);
			}
		} else {
			throw new RepositoryConfigException();
		}
	}

	public String createMasterRepository (String masterRepositoryUrl) throws RepositoryConfigException {
		InitCommand initCmd = Git.init();
		File workspace = new File (masterRepositoryUrl);
		Repository existingRepo = null;
		try {
			existingRepo = Git.open(workspace).getRepository();
		} catch (RepositoryNotFoundException nfex) {
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if (existingRepo == null) {
				workspace.mkdirs();
				initCmd.setDirectory(workspace);
				Repository repository = initCmd.call().getRepository();
				storeDescription(repository, masterRepositoryUrl, RepositoryType.MASTER);
				return "file://" + repository.getDirectory().getAbsolutePath().replace("/.git", "");
			} else  {
				return "file://" + existingRepo.getDirectory().getAbsolutePath().replace("/.git", "");
			}
		} catch (GitAPIException e) {
			throw new RepositoryConfigException(e);
		} catch (SecurityException secEx) {
			throw new RepositoryConfigException(secEx);
		}
	}
	
	private void storeDescription (Repository repository, String path, RepositoryType type) {
		RepositoryDescription description = new RepositoryDescription();
		description.setUrl (path);
		description.setWorkspaceLocation (path);
		description.setType(type);
		repoDescriptionManager.createOrUpdateRepositoryDescription(description);
	}

}
