package org.fornax.soa.xsr.connex.web.git;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.UploadPack;
import org.fornax.soa.xsr.connex.core.config.RepositoryDescription;
import org.fornax.soa.xsr.connex.core.config.RepositoryType;

public class ConnexUploadPack extends UploadPack {
	
	private RepositoryDescription repositoryDescription;

	public ConnexUploadPack(Repository copyFrom, RepositoryDescription repositoryDescription) {
		super(copyFrom);
		this.repositoryDescription = repositoryDescription;
	}

}
