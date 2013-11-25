package org.fornax.soa.xsr.connex.core.subscription;

import java.util.List;

import org.fornax.soa.xsr.connex.core.Asset;


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
