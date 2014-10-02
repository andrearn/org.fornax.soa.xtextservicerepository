package org.xkonnex.repo.server.core.notification;

public class NotificationEvent {
	
	protected String subject;

	public NotificationEvent (String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

}
