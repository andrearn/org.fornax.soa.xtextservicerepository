package org.fornax.soa.xsr.connex.core.subscription;

import java.util.List;

import org.fornax.soa.xsr.connex.core.Asset;

public class Subscription {
	
	private Long id;
	private Asset asset;
	private List<EventType> eventTypes;
	private String userId;
	
	public Subscription(Asset asset, List<EventType> eventTypes, String userId) {
		this.asset = asset;
		this.eventTypes = eventTypes;
		this.userId = userId;
	}
	
	public Asset getAsset() {
		return asset;
	}
	
	public List<EventType> getEventTypes() {
		return eventTypes;
	}
	
	public String getUserId() {
		return userId;
	}

	
}
