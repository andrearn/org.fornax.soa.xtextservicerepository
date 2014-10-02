package org.xkonnex.repo.server.core.repo;

public interface IReposityAccessService {
	
	void fetchMaster ();
	void fetchStaging ();
	void revertStaging ();
	void promoteToMaster ();

}
