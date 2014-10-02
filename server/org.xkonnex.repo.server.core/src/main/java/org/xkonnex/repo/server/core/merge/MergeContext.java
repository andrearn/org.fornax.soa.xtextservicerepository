package org.xkonnex.repo.server.core.merge;

public class MergeContext {
	
	private String committer;
	private String commit;

	public String getCommitter() {
		return committer;
	}

	public void setCommitter(String committer) {
		this.committer = committer;
	}

	public String getCommit() {
		return commit;
	}

	public void setCommit(String commit) {
		this.commit = commit;
	}

}
