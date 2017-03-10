package org.xkonnex.repo.dsl.environmentdsl.ext.cluster;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.InfrastructureManager;

public class Hadoop implements ICluster {
	
	private InfrastructureManager zookeeper;

	public InfrastructureManager getZookeeper() {
		return zookeeper;
	}

	public void setZookeeper(InfrastructureManager zookeeper) {
		this.zookeeper = zookeeper;
	}

}
