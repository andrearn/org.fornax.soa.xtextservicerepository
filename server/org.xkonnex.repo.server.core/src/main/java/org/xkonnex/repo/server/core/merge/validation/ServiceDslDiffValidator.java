package org.xkonnex.repo.server.core.merge.validation;

import java.util.List;

import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.Lists;

public class ServiceDslDiffValidator implements IDiffValidator {

	public List<Issue> validate(Diff diff) {
		List<Issue> issues = Lists.newArrayList();
		if (isResponsible(diff)) {
			List<Issue> versionChangeIssues = checkVersionChange(diff);
			issues.addAll(versionChangeIssues);
		}
		return issues;
	}
	
	public boolean isResponsible (Diff diff) {
		Match match = diff.getMatch();
		EObject left = match.getLeft();
		EObject right = match.getRight();
		return true;
	}
	
	private List<Issue> checkVersionChange (Diff diff) {
		return null;
	}

}
