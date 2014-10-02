package org.xkonnex.repo.server.web.connex.web.git;

import java.util.Collection;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.PostReceiveHook;
import org.eclipse.jgit.transport.PreReceiveHook;
import org.eclipse.jgit.transport.ReceiveCommand;
import org.eclipse.jgit.transport.ReceivePack;
import org.xkonnex.repo.server.web.connex.core.config.RepositoryDescription;
import org.xkonnex.repo.server.web.connex.core.config.RepositoryType;

public class ConnexReceivePack extends ReceivePack implements PreReceiveHook, PostReceiveHook {
	
	private RepositoryDescription repositoryDescription;

	public ConnexReceivePack(Repository into) {
		super(into);
	}

	public ConnexReceivePack(Repository db, RepositoryDescription repositoryDescription) {
		this (db);
		this.repositoryDescription = repositoryDescription;
	}

	@Override
	public void onPostReceive(ReceivePack rp,
			Collection<ReceiveCommand> commands) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPreReceive(ReceivePack rp, Collection<ReceiveCommand> commands) {
		// TODO Auto-generated method stub
		
	}

}
