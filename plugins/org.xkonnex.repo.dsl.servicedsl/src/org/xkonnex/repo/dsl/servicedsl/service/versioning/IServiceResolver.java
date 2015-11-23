package org.xkonnex.repo.dsl.servicedsl.service.versioning;

import java.util.List;

import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceRef;

public interface IServiceResolver {
	
	public Service findMatchingServiceByMajorVersionAndState (String majorVersion, List<Service> s, LifecycleState minState);
	
	public Service findMatchingService (ServiceRef s);
	
	public Service findMatchingServiceByState (ServiceRef s, LifecycleState minState);
	
	public boolean isMatchingService (Service s, int majorVersion, LifecycleState minState);
	
}
