package org.fornax.soa.xsr.connex.core.subscription;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.fornax.soa.xsr.connex.core.Asset;

@Entity
public class Subscription {
	
	@Id @GeneratedValue
	private Long id;
	private Asset asset;
	private List<EventType> eventTypes;
	private String userId;
	
	public Subscription() {
		// TODO Auto-generated constructor stub
	}
	
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
