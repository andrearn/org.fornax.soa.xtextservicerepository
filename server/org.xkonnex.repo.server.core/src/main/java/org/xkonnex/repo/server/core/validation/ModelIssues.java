package org.xkonnex.repo.server.core.validation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;

public class ModelIssues {
	
	private Multimap<URI, Issue> issues = LinkedListMultimap.create();
	private Severity highestSeverity = Severity.IGNORE;
	
	public void addIssue(Issue issue) {
		getIssues().put(issue.getUriToProblem(), issue);
		Severity severity = issue.getSeverity();
		if (severity.ordinal() < getHighestSeverity().ordinal()) {
			setHighestSeverity(severity);
		}
	}
	
	public Multimap<URI, Issue> getIssues() {
		return issues;
	}
	
	public boolean hasErrors () {
		return highestSeverity == Severity.ERROR;
	}
	
	public boolean hasWarnings () {
		return highestSeverity == Severity.WARNING;
	}
	
	public Severity getHighestSeverity() {
		return highestSeverity;
	}

	public void setHighestSeverity(Severity highestSeverity) {
		this.highestSeverity = highestSeverity;
	}
	

}
