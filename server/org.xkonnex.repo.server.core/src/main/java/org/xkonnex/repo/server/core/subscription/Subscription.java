package org.xkonnex.repo.server.core.subscription;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.xkonnex.repo.server.core.Asset;

@Entity
public class Subscription {
	
	@Id @GeneratedValue
	private Long id;
	@Embedded
	private Asset asset;
	@ElementCollection
	private Set<EventType> eventTypes;
	private String userId;
	
	public Subscription() {
		// TODO Auto-generated constructor stub
	}
	
	public Subscription(Asset asset, Set<EventType> eventTypes, String userId) {
		this.asset = asset;
		this.eventTypes = eventTypes;
		this.userId = userId;
	}
	
	public Asset getAsset() {
		return asset;
	}
	
	public Set<EventType> getEventTypes() {
		return eventTypes;
	}
	
	public String getUserId() {
		return userId;
	}

	
}
