package org.xkonnex.repo.server.core.subscription;

import java.util.List;

import org.xkonnex.repo.server.core.Asset;


/**
 * REST-Service
 * @author aarnold
 *
 */
public interface ISubscriptionService {
	
	void subscribe (List<Subscription> subcriptions);
	
	void unSubscribe (List<Subscription> subcriptions);
	
	List<Subscription> getSubscriptions (String userId, EventType eventType);
	
	List<String> getSubscriberUserIds (Asset asset, EventType eventType);

}
