package org.xkonnex.repo.server.core.merge;

public enum MergePhase {
	AUTHORIZATION,
	CHECK_COMPLIANCE,
	NOTIFY_SUBSCRIBERS,
	PUSH_UPSTREAM
}
