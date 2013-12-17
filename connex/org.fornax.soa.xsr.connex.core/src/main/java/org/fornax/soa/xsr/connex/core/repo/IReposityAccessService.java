package org.fornax.soa.xsr.connex.core.repo;

public interface IReposityAccessService {
	
	void fetchMaster ();
	void fetchStaging ();
	void revertStaging ();
	void promoteToMaster ();

}
