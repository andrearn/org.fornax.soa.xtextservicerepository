package org.xkonnex.repo.server.core.notification;

import org.eclipse.emf.compare.Comparison;
import org.xkonnex.repo.server.core.merge.MergeContext;

public class MergeNotificationEvent extends NotificationEvent {
	
	public MergeNotificationEvent(String subject, Comparison comparison, MergeContext mergeContext) {
		super(subject);
		this.mergeContext = mergeContext;
		this.comparison = comparison;
	}

	private MergeContext mergeContext;
	private Comparison comparison;

	public MergeContext getMergeContext() {
		return mergeContext;
	}

	public void setMergeContext(MergeContext mergeContext) {
		this.mergeContext = mergeContext;
	}

	public Comparison getComparison() {
		return comparison;
	}

	public void setComparison(Comparison comparison) {
		this.comparison = comparison;
	}

}
