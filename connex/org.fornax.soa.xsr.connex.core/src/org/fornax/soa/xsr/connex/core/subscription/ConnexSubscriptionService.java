package org.fornax.soa.xsr.connex.core.subscription;

import java.util.List;

import org.fornax.soa.xsr.connex.core.Asset;

import com.google.inject.Inject;

/**
 * A service that provides access to {@link Subscription}s to {@link Asset}s 
 * managed by XSR Connex
 * @author aarnold
 *
 */
public class ConnexSubscriptionService implements ISubscriptionService {

	@Inject
	private ISubscriptionRepository repository;
	
	public void subscribe (List<Subscription> subcriptions) {
		for (Subscription subscription : subcriptions) {
			repository.addSubscription(subscription);
		}
	}

	public void unSubscribe (List<Subscription> subcriptions) {
		for (Subscription subscription : subcriptions) {
			repository.addSubscription(subscription);
		}
	}

	public List<Subscription> getSubscriptions (String userId, EventType eventType) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getSubscriberUserIds (Asset asset, EventType eventType) {
		// TODO Auto-generated method stub
		return null;
	}

}
