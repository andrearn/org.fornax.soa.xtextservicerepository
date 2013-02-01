package org.fornax.soa.service.versioning;

import java.util.List;

import org.fornax.soa.profiledsl.sOAProfileDsl.LifecycleState;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.ServiceRef;

public interface IServiceResolver {
	
	public Service findMatchingServiceByMajorVersionAndState (String majorVersion, List<Service> s, LifecycleState minState);
	
	public Service findMatchingService (ServiceRef s);
	
	public Service findMatchingServiceByState (ServiceRef s, LifecycleState minState);
	
	public boolean isMatchingService (Service s, int majorVersion, LifecycleState minState);
	
}
