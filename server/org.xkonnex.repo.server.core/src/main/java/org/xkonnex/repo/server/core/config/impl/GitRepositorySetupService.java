package org.xkonnex.repo.server.core.config.impl;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.jgit.api.AddCommand;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.CommitCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.InitCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.errors.RepositoryNotFoundException;
import org.eclipse.jgit.lib.Repository;
import org.xkonnex.repo.server.core.config.IProjectGenerator;
import org.xkonnex.repo.server.core.config.IRepositoryDescriptionManager;
import org.xkonnex.repo.server.core.config.IRepositorySetupService;
import org.xkonnex.repo.server.core.config.RepositoryConfigException;
import org.xkonnex.repo.server.core.config.RepositoryDescription;
import org.xkonnex.repo.server.core.config.RepositoryType;

import com.google.inject.Inject;

public class GitRepositorySetupService implements IRepositorySetupService {
	
	@Inject
	private IRepositoryDescriptionManager repoDescriptionManager;
	
	@Inject
	private IProjectGenerator projectGenerator;
	
	public void attachStagingRepository(URI stagingRepositoryUrl, URI workspaceLocation) throws RepositoryConfigException {
		File workspace;
		try {
			workspace = new File (stagingRepositoryUrl);
			Repository repository = null;
			if ("file".equals(stagingRepositoryUrl.getScheme())) {
				Git git = Git.open(workspace);
				repository = git.getRepository();
			} else {
				CloneCommand cloneCommand = Git.cloneRepository();
				String repositoryFolder = repoDescriptionManager.getRepositoryFolder();
				File workspaceFolder = new File(repositoryFolder);
				if (!workspaceFolder.exists())
					workspaceFolder.mkdirs();
				cloneCommand.setDirectory(workspaceFolder);
				cloneCommand.setURI(stagingRepositoryUrl.toString());
				Git git = cloneCommand.call();
				repository = git.getRepository();
			}
			storeDescription(repository, stagingRepositoryUrl.toString(), RepositoryType.STAGING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidRemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void attachMasterRepository(URI masterRepositoryUrl) throws RepositoryConfigException {
		Repository repository = null; 
		if ("file".equals(masterRepositoryUrl.getScheme())) {
			File path = new File(masterRepositoryUrl);
			try {
				repository = Git.open(path).checkout().getRepository();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			repository = Git.lsRemoteRepository().getRepository();
		}
		storeDescription(repository, masterRepositoryUrl.toString(), RepositoryType.STAGING);
	}

	public String createStagingRepository (URI stagingRepositoryUrl, URI masterRepositoryUrl) throws RepositoryConfigException {
		if (stagingRepositoryUrl != null && masterRepositoryUrl != null && !stagingRepositoryUrl.equals(masterRepositoryUrl)) {
			CloneCommand cloneCmd = Git.cloneRepository();
			try {
				File workspace;
				workspace = new File (stagingRepositoryUrl);
				workspace.mkdirs();
				cloneCmd.setDirectory (workspace);
				cloneCmd.setURI(masterRepositoryUrl.toString());
				Repository repository = cloneCmd.call().getRepository();
				storeDescription(repository, stagingRepositoryUrl.toString(), RepositoryType.STAGING);
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

	public String createMasterRepository (URI masterRepositoryUrl) throws RepositoryConfigException {
		InitCommand initCmd = Git.init();
		try {
			File workspace = new File (masterRepositoryUrl);
			Git git = null;
			Repository existingRepo = null;
			try {
				git = Git.open(workspace);
				existingRepo = git.getRepository();
				storeDescription(existingRepo, masterRepositoryUrl.toString(), RepositoryType.MASTER);
			} catch (RepositoryNotFoundException nfex) {
				if ("file".equals(masterRepositoryUrl.getScheme())) {
					workspace.mkdirs();
					initCmd.setDirectory(workspace);
					Repository repository = initCmd.call().getRepository();
					git = Git.open(workspace);
					projectGenerator.generateProject(workspace);
					git.add().addFilepattern("README.txt").call();
					CommitCommand commit = git.commit();
					commit.setAuthor("admin", "admin@example.org");
					commit.setMessage("Initial");
					commit.call();
					storeDescription(repository, masterRepositoryUrl.toString(), RepositoryType.MASTER);
					return "file://" + repository.getDirectory().getAbsolutePath().replace("/.git", "");
				} else  {
					throw new RepositoryConfigException(nfex);
				}
			}
			return "file://" + existingRepo.getDirectory().getAbsolutePath().replace("/.git", "");
		} catch (GitAPIException e) {
			throw new RepositoryConfigException(e);
		} catch (SecurityException secEx) {
			throw new RepositoryConfigException(secEx);
		} catch (IOException e) {
			throw new RepositoryConfigException(e);
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
