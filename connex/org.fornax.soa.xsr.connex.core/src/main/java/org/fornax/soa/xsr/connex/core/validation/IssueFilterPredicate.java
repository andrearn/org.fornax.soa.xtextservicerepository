package org.fornax.soa.xsr.connex.core.validation;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.Issue;

import com.google.common.base.Predicate;

public class IssueFilterPredicate implements Predicate<Issue> {
	
	private Severity severity;
	
	public IssueFilterPredicate(Severity severity) {
		this.severity = severity;
		if (severity == null)
			this.severity = Severity.ERROR;
	}

	public boolean apply(Issue issue) {
		return severity.equals (issue.getSeverity());
	}
}
