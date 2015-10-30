package org.xkonnex.repo.server.web.git;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.UploadPack;
import org.xkonnex.repo.server.core.config.RepositoryDescription;
import org.xkonnex.repo.server.core.config.RepositoryType;

public class XKonneXRepoUploadPack extends UploadPack {
	
	private RepositoryDescription repositoryDescription;

	public XKonneXRepoUploadPack(Repository copyFrom, RepositoryDescription repositoryDescription) {
		super(copyFrom);
		this.repositoryDescription = repositoryDescription;
	}

}
