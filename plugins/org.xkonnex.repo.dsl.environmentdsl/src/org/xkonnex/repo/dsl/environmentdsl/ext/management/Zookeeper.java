package org.xkonnex.repo.dsl.environmentdsl.ext.management;

import java.util.ArrayList;
import java.util.List;

import org.xkonnex.repo.dsl.environmentdsl.environmentDsl.Host;

public class Zookeeper implements IInfrastructureManager {
	
	private Integer zookeeperPort;
		
	public Integer getZookeeperPort() {
		return zookeeperPort;
	}
	public void setZookeeperPort(Integer zookeeperPort) {
		this.zookeeperPort = zookeeperPort;
	}

}
