package org.fornax.soa.xsr.connex.core.subscription;

import java.util.List;

import org.fornax.soa.xsr.connex.core.Asset;


/**
 * Accesses the Connex datastore to persist and retrive {@link Subscription}s
 * @author aarnold
 *
 */
public interface ISubscriptionRepository {
	
	/**
	 * Adds a new subscription persistently
	 */
	void addSubscription (Subscription subscription);
	/**
	 * Removes a subscription permanently
	 */
	void deleteSubscription (Subscription subscription);
	
	/**
	 * Find all subscriptions to {@link Asset}-changes, a user subscribed to 
	 * @return
	 */
	List<Subscription> findSubscriptionByUser();
	
	/**
	 * 
	 */
	List<String> getSubscribers(Asset asset, EventType eventType);
	
	/**
	 * Checks, whether the subscription already exists
	 * @param subscription
	 * @return
	 */
	boolean subscriptionExists (Subscription subscription);
	

}
