package org.xkonnex.repo.server.core.notification;


public interface INotificationPublisher {
	
	void notify (NotificationEvent event);
	
}
