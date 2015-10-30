package org.xkonnex.repo.server.core.subscription;

import java.util.List;

import javax.inject.Inject;

import org.xkonnex.repo.server.core.Asset;


/**
 * A service that provides access to {@link Subscription}s to {@link Asset}s 
 * managed by XKonneX Repo
 * @author aarnold
 *
 */
public class XKonneXRepoSubscriptionService implements ISubscriptionService {

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
