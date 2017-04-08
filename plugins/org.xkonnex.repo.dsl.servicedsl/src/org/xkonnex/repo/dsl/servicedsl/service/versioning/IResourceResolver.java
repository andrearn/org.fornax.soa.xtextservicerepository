package org.xkonnex.repo.dsl.servicedsl.service.versioning;

import java.util.List;

import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ResourceRef;

public interface IResourceResolver {
	
	public Resource findMatchingResourceByMajorVersionAndState (String majorVersion, List<Resource> s, LifecycleState minState);
	
	public Resource findMatchingResource (ResourceRef s);
	
	public Resource findMatchingResourceByState (ResourceRef s, LifecycleState minState);
	
	public boolean isMatchingResource (Resource s, int majorVersion, LifecycleState minState);

}
