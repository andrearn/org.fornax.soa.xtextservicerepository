package org.fornax.soa.xsr.connex.core.repo;

import org.fornax.soa.xsr.connex.core.config.Master;
import org.fornax.soa.xsr.connex.core.config.RepositoryDescription;
import org.fornax.soa.xsr.connex.core.config.Staging;

import com.google.inject.Inject;

public class GitRepositoryAccessService implements IReposityAccessService {
	
	@Inject @Staging
	private RepositoryDescription stagingRepository;
	
	@Inject @Master
	private RepositoryDescription masterRepository;

	public void fetchMaster() {
		// TODO Auto-generated method stub
		
	}

	public void fetchStaging() {
		// TODO Auto-generated method stub
		
	}

	public void revertStaging() {
		// TODO Auto-generated method stub
		
	}

	public void promoteToMaster() {
		// TODO Auto-generated method stub
		
	}
	
}
