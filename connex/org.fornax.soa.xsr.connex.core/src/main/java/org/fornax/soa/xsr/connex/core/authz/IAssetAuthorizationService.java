package org.fornax.soa.xsr.connex.core.authz;

import java.util.List;

import org.fornax.soa.xsr.connex.core.Asset;


public interface IAssetAuthorizationService {
	
	boolean authorize (Asset asset, String userId);
	void grantAccessToUser (List<Asset> assets, String userId);
	void grantAccessToRole (List<Asset> assets, String roleId);

}
